(ns bob
  (:require [clojure.string :as s]))

(defn upper-case? [characters] 
  (if (empty? (re-seq #"[a-zA-Z]" characters)) 
    false
  	(every? #(Character/isUpperCase %) 
		  (apply str (re-seq #"[a-zA-Z]+" characters)))))

(defn response-for [phrase] 
  (cond 
    (s/blank? phrase) "Fine. Be that way!"
    (upper-case? phrase) "Whoa, chill out!"
    (s/ends-with? phrase "?") "Sure."
    :else "Whatever."))