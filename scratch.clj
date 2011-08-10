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