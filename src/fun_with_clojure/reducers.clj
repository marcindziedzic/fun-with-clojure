(ns fun-with-clojure.reducers
  (:require [clojure.core.reducers :as r]
            [clojure.java.io :as io]
            [clojure.string :as str]
            ))

(def ^:private fname "C:/Dev/workspace/fun-with-clojure/resources/bible.txt")

(def ^:private coll
  (with-open [r (io/reader fname)]
    (vec (line-seq r))))

(defn- wc [line]
  (reduce
    #(merge-with + %1 {%2 1})
    {}
    (str/split line #" ")))

(defn- combinef
  ([] {})
  ([p1 p2] (merge-with + p1 p2)))

(defn- reducef
  ([result line]
    (if-not (empty? line)
      (merge-with + result (wc line))
      result)))

(def ^:private words-in-poetry (r/fold combinef reducef coll))

(println words-in-poetry)