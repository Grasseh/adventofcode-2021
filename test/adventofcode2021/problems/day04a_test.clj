(ns adventofcode2021.problems.day04a-test
  (:require [clojure.test :refer :all]
            [adventofcode2021.problems.day04a :refer :all :as day04a]))

(deftest testsolve
  (testing "Test that it solves correctly"
    (is (= (day04a/solve "test/adventofcode2021/input/day04.txt") 4512))))
