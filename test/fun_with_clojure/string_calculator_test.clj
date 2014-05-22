(ns fun-with-clojure.string-calculator-test
  (:use midje.sweet)
  (:require [fun-with-clojure.string-calculator :as calc]))

(facts "about string calculator"

    (fact "empty string gives zero"
          (calc/add "") => 0)

    (fact "number represented as string is converted to ing"
          (calc/add "1") => 1
          (calc/add "2") => 2)

    (fact "comma is a valid delimiter"
          (calc/add "1,2") => 3
          (calc/add "1,2,3") => 6)

    (fact "new lines is a valid delimiter"
          (calc/add "1\n2,3") => 6
          (calc/add "1,2\n3") => 6)

    (fact "it's possible to specify custom delimiter"
          (calc/add "//;\n1;2") => 3
          (calc/add "//w\n1w3") => 4)

    (fact "add with negative numbers will throw an exception"
          (calc/add "-1,2") => (throws Exception "Negatives not allowed: -1")
          (calc/add "-1,2,-3") => (throws Exception "Negatives not allowed: -1, -3")))