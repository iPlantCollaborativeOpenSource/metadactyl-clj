(ns metadactyl.translations.app-metadata.external-to-preview
  (:use metadactyl.translations.app-metadata.util))

(defn- translate-property
  [prop]
  {:name  (:name prop)
   :value (:value prop)
   :order (:order prop)})

(defn- translate-property-group
  [group]
  (map translate-property (:properties group [])))

(defn translate-template
  [template]
  {:params (mapcat translate-property-group (get-property-groups template))})