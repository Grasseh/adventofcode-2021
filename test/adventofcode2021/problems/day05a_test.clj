(ns adventofcode2021.problems.day05a-test
  (:require [clojure.test :refer :all]
            [adventofcode2021.problems.day05a :refer :all :as day05a]))

(deftest testsolve
  (testing "Test that it solves correctly"
    (is (= (day05a/solve "test/adventofcode2021/input/day05.txt") 5))))
