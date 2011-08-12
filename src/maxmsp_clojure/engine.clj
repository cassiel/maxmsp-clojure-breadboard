(ns maxmsp-clojure.engine
  (:require [maxmsp-clojure.eval :as ev]
            [maxmsp-clojure.data :as d])
  (:import (com.cycling74.max Atom)))

(defn evaluate [this ns-sym tok atomArray]
  "Evaluate an incoming message. If tok starts with '(', assume Clojure code, else
   treat as a function name followed by primitives as arguments.
   The result might be a single value of a type which can be atomised,
   or an array of two or more Atoms, or nil."
  (d/wrap-result (if (.startsWith tok "(")
                   (ev/evaluate ns-sym (str tok " " (Atom/toOneString atomArray)))
                   (apply ev/evaluate-list ns-sym tok (d/unpack-atoms (seq atomArray))))))
