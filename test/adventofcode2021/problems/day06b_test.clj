(ns adventofcode2021.problems.day06b-test
  (:require [clojure.test :refer :all]
            [adventofcode2021.problems.day06b :refer :all :as day06b]))

(deftest testsolve
  (testing "Test that it solves correctly"
    (is (= (day06b/solve "test/adventofcode2021/input/day06.txt") 26984457539))))
