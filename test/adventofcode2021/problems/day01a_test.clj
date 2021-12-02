(ns adventofcode2021.problems.day01a-test
  (:require [clojure.test :refer :all]
            [adventofcode2021.problems.day01a :refer :all :as day01a]))

(deftest testsolve
  (testing "Test that it solves correctly"
    (is (= (day01a/solve "test/adventofcode2021/input/day01.txt") 7))))
