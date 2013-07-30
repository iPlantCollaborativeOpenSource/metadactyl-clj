(ns metadactyl.translations.app-metadata.internal-to-external
  (:use [metadactyl.translations.app-metadata.util]
        [slingshot.slingshot :only [throw+]])
  (:require [clojure-commons.error-codes :as ce]))

(defn validators-from-rules
  "Converts a list of rules from the internal JSON format to a list of validators for the
   external JSON format."
  [rules]
  (mapcat (partial map (fn [[k v]] {:type (name k) :params v}))
          (remove :MustContain rules)))

(defn- uuid
  []
  (.toUpperCase (str (java.util.UUID/randomUUID))))

(defn- add-default-field-value
  "Adds a field to a map with a default value if that field is not already present in the map."
  [field value-fn m]
  (if-not (contains? m field)
    (assoc m field (value-fn))
    m))

(defn get-property-arguments
  "Gets the property arguments from a list of validation rules."
  [rules]
  (mapv (comp (partial add-default-field-value :id #(uuid))
              (partial add-default-field-value :isDefault (constantly false)))
        (:MustContain (first (filter :MustContain rules)) [])))

(defn find-default-arg
  "Finds the default argument in a property's argument list."
  [args]
  (first (filter #(Boolean/parseBoolean (str (:isDefault %))) args)))

(defn get-default-value
  "Gets the default value for a property and a set of list of selectable arguments."
  [property args]
  (let [default-value (:value property)]
    (or (cond
         (not (seq args))        default-value
         (map? default-value)    default-value
         (vector? default-value) default-value
         :else                   (find-default-arg args)))))

(defn translate-property
  "Translates a property from its internal format to its external format."
  [property]
  (let [rules     (get-in property [:validator :rules] [])
        args      (get-property-arguments rules)
        data-obj  (:data_object property)
        type      (:type property)
        mult      (:multiplicity data-obj)
        info-type (:file_info_type data-obj)]
    (if (nil? data-obj)
      (assoc (dissoc property :validator :value)
        :arguments    args
        :required     (get-in property [:validator :required] false)
        :validators   (validators-from-rules rules)
        :defaultValue (get-default-value property args))
      (assoc (dissoc property :validator :value)
        :arguments    args
        :validators   (validators-from-rules rules)
        :defaultValue (get-default-value property args)
        :data_object  (dissoc data-obj
                              :cmdSwitch :name :description :id :label :order :required
                              :file_info_type_id :format_id :multiplicity)
        :name         (:cmdSwitch data-obj (:name property))
        :description  (:description data-obj (:description property))
        :id           (:id data-obj (:id property))
        :label        (:name data-obj (:label property))
        :order        (:order data-obj (:order property))
        :required     (:required data-obj (:required property false))
        :type         (property-type-for type mult info-type)))))

(defn translate-property-group
  "Translates a property group from its internal format to its external format."
  [property-group]
  (assoc property-group
    :properties (map translate-property (:properties property-group))))

(defn translate-template
  "Translates a template from its internal format to its external format."
  [template]
  (assoc template
    :groups (map translate-property-group (get-property-groups template))))
