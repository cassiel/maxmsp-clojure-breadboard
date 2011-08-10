(ns maxmsp-clojure.eval)

(defn evaluate [ns-sym expr]
  "Evaluate an expression in a namespace."
  (do
    (in-ns ns-sym)
    (refer 'clojure.core)
    (load-string expr)))

(defn find-var-from-name [ns-sym name]
  (let [toks (.split name "/")]
    (if (= (alength toks) 1)
      (let [v (find-var (symbol (str ns-sym) name))]
        (if (nil? v)
          (find-var (symbol "clojure.core" name))
          v))
      (find-var (symbol name)))))

(defn resolve-item [ns-sym item]
  (if (instance? String item)
    (var-get (find-var-from-name ns-sym item))
    item))

(defn evaluate-args [ns-sym item & args]
  "Evaluate a list of items. The first, if a string, is taken as a function
   or variable name. Any of the rest, if strings, are taken as literal strings."
  (let [item (resolve-item ns-sym item)]
    (if (seq args)
      (apply item args)
      item)))