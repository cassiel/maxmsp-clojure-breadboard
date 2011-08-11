(ns maxmsp-clojure.test.eval
  (:require [maxmsp-clojure.eval :as e])
  (:use [clojure.test]))

(deftest simple-eval
  "Simple evaluation test."
  (is (= 42 (e/evaluate 'test-ns "(+ 40 2)"))))

(deftest simple-def
  "Simple definition test."
  (is (= 42 (do (e/evaluate 'test-ns "(def x 42)")
                (e/evaluate 'user "test-ns/x"))))
  (is (= 67 (do (e/evaluate 'test-ns "(def x 67)")
                (e/evaluate 'user "test-ns/x"))))
  (is (= 42 (do (e/evaluate 'user "(def x 42)")
                (e/evaluate 'user "x"))))
  (is (= 67 (do (e/evaluate 'user "(def x 67)")
                (e/evaluate 'user "x")))))

(deftest find-var-test
  "Looking up variables."
  (is (= #'clojure.core/+ (e/find-var-from-name 'user "+")))
  (is (= #'clojure.core/+ (e/find-var-from-name 'user "clojure.core/+")))
  (is (= #'maxmsp-clojure.eval/evaluate (e/find-var-from-name 'user "maxmsp-clojure.eval/evaluate")))
  (is (= #'maxmsp-clojure.eval/evaluate (e/find-var-from-name 'maxmsp-clojure.eval "evaluate"))))

(deftest resolver
  "Resolving strings as functions."
  (is (= 56 (e/resolve-item 'user 56)))
  (is (fn? (e/resolve-item 'clojure.core "drop-last"))))

(deftest eval-list-primitives
  "Evaluate from list of arguments."
  (is (= 56 (e/evaluate-list 'test-ns 56)))
  (is (= 42 (e/evaluate-list 'clojure.core "+" 30 10 2))))
