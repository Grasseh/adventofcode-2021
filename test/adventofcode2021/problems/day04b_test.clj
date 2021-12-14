(ns adventofcode2021.problems.day04b-test
  (:require [clojure.test :refer :all]
            [adventofcode2021.problems.day04b :refer :all :as day04b]))

(deftest testsolve
  (testing "Test that it solves correctly"
    (is (= (day04b/solve "test/adventofcode2021/input/day04.txt") 1924))))
