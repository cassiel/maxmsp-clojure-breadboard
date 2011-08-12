(ns maxmsp-clojure.test.engine
  (:require [maxmsp-clojure.engine :as engine])
  (:use [clojure.test])
  (:import (com.cycling74.max Atom)
           (java.util Arrays)))

(deftest engine-eval-lisp-1-result
  (is (= 15 (engine/evaluate :unused 'user "(+" (into-array Atom (map #(Atom/newAtom %) [4 5 6 ")"])))))
  (is (= 10 (engine/evaluate :unused 'user "(+ 5" (into-array Atom (map #(Atom/newAtom %) [5 ")"])))))
  (is (= 15 (engine/evaluate :unused 'user "(+ 5" (into-array Atom (map #(Atom/newAtom %) [5 "5)"])))))
  (is (= 15 (engine/evaluate :unused 'user "(+ 4 5 6)" (into-array Atom []))))
  (is (= "ABC" (engine/evaluate :unused 'user "(str \"A\" \"B\" \"C\")" (into-array Atom []))))
  (is (= "ABC" (engine/evaluate :unused 'user "(str \"A\"" (into-array Atom (map #(Atom/newAtom %) ["\"B\"" "\"C\")"]))))))

(defn atom-vals [& vals] (into-array Atom (map #(Atom/newAtom %) vals)))

(deftest engine-eval-lisp-n-results
  (is (Arrays/equals (atom-vals "A" "B" "C")
                     (engine/evaluate :unused 'user "(reverse" (atom-vals "[" "\"C\"" "\"B\"" "\"A\"" "])") ))))

(deftest engine-eval-atomised-1-result
  (is (= 15 (engine/evaluate :unused 'user "+" (into-array Atom (map #(Atom/newAtom %) [9 6]))))))
