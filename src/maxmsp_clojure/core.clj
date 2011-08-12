(ns maxmsp-clojure.core
  (:gen-class
   :name net.loadbang.Clojure
   :prefix max-
   :extends com.cycling74.max.MaxObject
   :state state
   :init init)
  (:require [maxmsp-clojure.engine :as e])
  (:import (com.cycling74.max Atom)))

(defn max-init []
  [[] nil])

(defn max-anything [this tok atoms]
  (e/evaluate this 'user tok atoms))
