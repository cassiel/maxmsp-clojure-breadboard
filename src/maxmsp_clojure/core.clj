(ns maxmsp-clojure.core
  (:gen-class
   :name net.loadbang.Clojure
   :prefix max-
   :extends com.cycling74.max.MaxObject
   :state state
   :init init)
  (:import (com.cycling74.max Atom)))

(defn max-init []
  [[] nil])
