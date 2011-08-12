(defn f [a b] (+ a b))

(def hello "Hello World")

((var-get (find-var (symbol "user" "f"))) 4 5)

(def args (quote (4 5)))

(apply (var-get (find-var (symbol "user" "f"))) args)

(var-get (find-var (symbol "user" "hello")))

(var-get (find-var (symbol "user" "hello2")))

(find-var (symbol "user" "hello2"))

(defn g [] (println "G"))

(g)

((var-get (find-var (symbol "user" "g"))))

(symbol (symbol "a") "b")

(find-var-from-name 'user "+")

#'+

f

(in-ns 'maxmsp-clojure.eval)
(resolve-item (symbol "test-ns") 56)

(def a (seq (.split "A B C" " ")))

(nth a 0)

(maxmsp-clojure.eval/find-var-from-name 'user "+")


(f 4 6)

(run-all-tests)

(clojure.test/run-all-tests)

(maxmsp-clojure.eval/evaluate "user" "(def fooble 13)")

(fn? 35)

(+ 40 2)
(maxmsp-clojure.eval/evaluate (symbol "test-ns") "(+ 40 2)")

(instance? String 34)

(into-array Integer/TYPE [3])

(java.util.Arrays/equals (com.cycling74.max.Atom/newAtom (into-array Integer/TYPE [3])) (com.cycling74.max.Atom/newAtom (into-array Integer/TYPE [3])))

(= [45 5.0 "A"] (maxmsp-clojure.data/unpack-atoms (into-array com.cycling74.max.Atom (map #(com.cycling74.max.Atom/newAtom %) [45 5.0 "A"]))))

(= [4 5.6 6] '(4 5.6 6))

(java.util.Arrays/equals (into-array Integer/TYPE [2]) (into-array Integer/TYPE [2]))

(into-array [2 3 4])

(maxmsp-clojure.data/pack-atoms 1 2 3)

(apply maxmsp-clojure.data/pack-atoms [1 2 3])

(maxmsp-clojure.data/wrap-result [1 2 3])

(maxmsp-clojure.eval/evaluate 'user "(+ 1 2)")

(maxmsp-clojure.engine/evaluate 'user "(+" (maxmsp-clojure.data/pack-atoms 1 "2)"))

(maxmsp-clojure.core/max-anything nil "(+" (maxmsp-clojure.data/pack-atoms 1 "2)"))

(com.cycling74.max.Atom/newAtom 3)

(format "%s" 'a)

(load-string "(println a)")

(str 'a)

(reverse ["A" "B"])

(maxmsp-clojure.test.engine/atom-vals 1 2 3)

(sequential? [1 2 3])

(sequential? 1)

(seq [1 2 3])

(nil? nil)

(str reverse)

;; Testing thread-local bindings of namespaces?

(def a 1)
a

(in-ns 'ns1)
(def a 1)
(in-ns 'user)

(.start (Thread. #(do (in-ns 'ns2) (println *ns*)))) ; no.

(in-ns 'ns2)

(.start (Thread. #(do (refer 'clojure.core) (println *ns*))))

(.start (Thread. #(load-string "(in-ns 'ns2) (refer 'clojure.core) (println *ns*)")))

(.start (Thread. #(+ 1 2)))

(def ag (agent nil))

(send ag (fn [_] (load-string in-ns 'ns2)))

(send ag (fn [_] (println *ns*)))

