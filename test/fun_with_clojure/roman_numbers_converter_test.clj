(ns fun-with-clojure.roman-numbers-converter-test
  (:use midje.sweet)
  (:require [fun-with-clojure.roman-numbers-converter :as c]))


(tabular
 (facts "rules of arabic to roman numbers convertion"
       (c/convert ?arabic) => ?roman)

   ?arabic  ?roman
      1      "I"
      2      "II"
      3      "III"
      4      "IV"
      5      "V"
      9      "IX"
       )