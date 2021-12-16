(ns adventofcode2021.problems.day07a-test
  (:require [clojure.test :refer :all]
            [adventofcode2021.problems.day07a :refer :all :as day07a]))

(deftest testsolve
  (testing "Test that it solves correctly"
    (is (= (day07a/solve "test/adventofcode2021/input/day07.txt") 37))))
