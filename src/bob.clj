(ns bob)

(defn is-upper-case? [characters] 
  (if (empty? (re-seq #"[a-zA-Z]" characters)) false
  (every? #(Character/isUpperCase %) (apply str (re-seq #"[a-zA-Z]+" characters)))))

(defn response-for [phrase] 
  (cond 
    (empty? (clojure.string/trim phrase)) "Fine. Be that way!"
    (is-upper-case? phrase) "Whoa, chill out!"
    (= \? (last phrase)) "Sure."
  :else "Whatever."))