(ns maxmsp-clojure.test.data
  (:require [maxmsp-clojure.data :as d])
  (:use [clojure.test])
  (:import (com.cycling74.max Atom)
           (java.util Arrays)))

(deftest unpacking-single
  (is (= 45 (d/unpack-atom (Atom/newAtom 45))))
  (is (= 1.0 (d/unpack-atom (Atom/newAtom 1.0))))
  (is (= "A" (d/unpack-atom (Atom/newAtom "A")))))

(deftest unpacking
  (is (= [45] (d/unpack-atoms (into-array Atom [(Atom/newAtom 45)]))))
  (is (= [45 5.0 "A"] (d/unpack-atoms (into-array Atom (map #(Atom/newAtom %) [45 5.0 "A"]))))))

(deftest packing-single
  (is (= (Atom/newAtom 45) (d/pack-atom 45))))

(deftest packing
  (is (Arrays/equals (Atom/newAtom (into-array Integer/TYPE [3])) (d/pack-atoms 3)))
  (is (Arrays/equals (Atom/newAtom (into-array Integer/TYPE [4 5])) (d/pack-atoms 4 5)))
  (is (Arrays/equals (into-array Atom (map #(Atom/newAtom %) [3 4.0 "A"]))
                     (d/pack-atoms 3 4.0 "A"))))
