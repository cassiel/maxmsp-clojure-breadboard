(ns maxmsp-clojure.eval1
  (:import (clojure.lang RT)))

(defn invokeFn [name args]
  (let [m (RT/map RT/CURRENT_NS (.deref RT/CURRENT_NS))
       _ (Var/pushThreadBindings m)
       ns "user"
       var (RT/var ns name)]
  (do (.applyto var (seq args))
      (Var/popThreadBindings))))
