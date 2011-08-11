(ns maxmsp-clojure.data
  (:require [maxmsp-clojure.eval :as e])
  (:import (com.cycling74.max Atom)))

(defn unpack-atom [atom]
  (cond (.isInt atom) (.getInt atom)
        (.isFloat atom) (.getFloat atom)
        (.isString atom) (.getString atom)
        :else nil))

(defn unpack-atoms [atoms]
  (map unpack-atom (seq atoms)))

(defn pack-atom [val]
  (Atom/newAtom val))

(defn pack-atoms [& vals]
  (into-array Atom (map #(Atom/newAtom %) vals)))
