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

(defn sanitise [val]
  (if (or (integer? val) (float? val) (string? val))
    val
    (str val)))

(defn pack-atom [val]
  (Atom/newAtom (sanitise val)))

(defn pack-atoms [& vals]
  (into-array Atom (map pack-atom vals)))

(defn wrap-result [result]
  "Turn the result of an evaluation into a scalar value, an array of Atoms, or nil."
  (cond (nil? result) nil
        (sequential? result) (apply pack-atoms result)
        :else (sanitise result)))
