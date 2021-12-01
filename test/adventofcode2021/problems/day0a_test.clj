(ns adventofcode2021.problems.day0a-test
  (:require [clojure.test :refer :all]
            [adventofcode2021.problems.day0a :refer :all :as day0a]))

(deftest testsolve
  (testing "Test that it solves correctly"
    (is (= (day0a/solve "test/adventofcode2021/input/day0.txt") "3"))))
