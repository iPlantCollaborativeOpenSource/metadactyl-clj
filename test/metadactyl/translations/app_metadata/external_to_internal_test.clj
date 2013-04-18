(ns metadactyl.translations.app-metadata.external-to-internal-test
  (:use [clojure.test]
        [metadactyl.translations.app-metadata.external-to-internal]))

(defn- external-selection-args
  []
  (mapv (fn [n] {:name n :value n :display n}) ["foo" "bar" "baz"]))

(defn- internal-selection-args
  ([]
     (internal-selection-args nil))
  ([default]
     (map #(assoc % :isDefault (= default (:name %)))
          (external-selection-args))))

(deftest build-validator-for-property-test
  (is (= {:required true :rules []}
         (build-validator-for-property {:required true}))))

(deftest build-validator-for-property-with-rules-test
  (is (= {:required false :rules [{:IntAbove [0]}]}
         (build-validator-for-property {:validators [{:type "IntAbove" :params [0]}]}))))

(deftest build-validator-for-property-with-args-test
  (is (= {:required true :rules [{:MustContain (internal-selection-args)}]}
         (build-validator-for-property {:required true :arguments (external-selection-args)}))))

(deftest build-validator-for-property-with-args-and-rules-test
  (is (= {:required false
          :rules    [{:IntAbove    [0]}
                     {:MustContain (internal-selection-args)}]}
         (build-validator-for-property {:validators [{:type "IntAbove" :params [0]}]
                                        :arguments  (external-selection-args)}))))

(deftest build-validator-for-optional-property-with-args-test
  (is (= {:required     false
          :rules        [{:MustContain (internal-selection-args "foo")}]}
         (build-validator-for-property
          {:arguments    (external-selection-args)
           :defaultValue {:name "foo" :value "foo" :display "foo"}}))))

(deftest translate-property-test
  (is (= {:value "foo" :validator nil :data_object nil}
         (translate-property {:defaultValue "foo"}))))

(deftest translate-empty-property-test
  (is (= {:value nil :validator nil :data_object nil}
         (translate-property {}))))

(deftest translate-required-property-test
  (is (= {:value       nil
          :validator   {:required true
                        :rules    []}
          :data_object nil}
         (translate-property
          {:required true}))))

(deftest translate-property-with-rules-test
  (is (= {:value       nil
          :validator   {:required false
                        :rules    [{:IntAbove [42]}]}
          :data_object nil}
         (translate-property
          {:validators [{:type   "IntAbove"
                         :params [42]}]}))))

(deftest translate-property-with-args-test
  (is (= {:value       nil
          :validator   {:required false
                        :rules    [{:MustContain (internal-selection-args)}]}
          :data_object nil}
         (translate-property
          {:arguments (external-selection-args)}))))

(deftest translate-property-with-data-object-test
  (is (= {:data_object   {:cmdSwitch      "da-name"
                          :data_source    "da-data-source"
                          :description    "da-description"
                          :file_info_type "da-info-type"
                          :format         "da-format"
                          :id             "da-id"
                          :is_implicit    false
                          :multiplicity   "single"
                          :name           "da-label"
                          :order          42
                          :required       false
                          :retain         true}
          :description   "da-description"
          :id            "da-id"
          :isVisible     true
          :label         "da-label"
          :name          "da-name"
          :omit_if_blank false
          :order         42
          :required      false
          :type          "Input"
          :value         nil
          :validator     nil})
      (translate-property
       {:data_object   {:data_source    "da-data-source"
                        :file_info_type "da-info-type"
                        :format         "da-format"
                        :is_implicit    false
                        :multiplicity   "single"
                        :retain         true}
        :description   "da-description"
        :id            "da-id"
        :isVisible     true
        :label         "da-label"
        :name          "na-name"
        :omit_if_blank false
        :order         42
        :required      false})))
