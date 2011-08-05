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



f


(f 4 6)