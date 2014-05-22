(ns fun-with-clojure.string-calculator
  (:require [clojure.string :as str]))

(defn- split-and-add [expr delimiter]
  (let [numbers (map #(Integer/valueOf %) (str/split expr delimiter))
        negatives (filter #(< % 0) numbers)]

    (when-not (empty? negatives)
      (throw (Exception. (str "Negatives not allowed: " (str/join ", " negatives)))))

    (apply + numbers)))

(defn add [expr]
  (cond
    (empty? expr) 0
    (.startsWith expr "//") (let [[delimiter extracted-expr] (rest (re-find #"//(.*)\n(.*)" expr))]
                                 (split-and-add extracted-expr (re-pattern delimiter)))
    :else (split-and-add expr #",|\n")
    ))