(ns fun-with-clojure.roman-numbers-converter)

(def arabic-numbers [  9    5   4    1 ])
(def roman-numbers  [ "IX" "V" "IV" "I"])

(defn convert
  ([arabic] (convert arabic "" arabic-numbers roman-numbers))
  ([arabic roman an rn]

     (cond

      (>= arabic (first an))
        (recur (- arabic (first an)) (str roman (first rn)) an rn)

      (number? (second an))
        (recur arabic roman (rest an) (rest rn))

      :else roman

       )))