(ns adventofcode2021.problems.day06a-test
  (:require [clojure.test :refer :all]
            [adventofcode2021.problems.day06a :refer :all :as day06a]))

(deftest testsolve
  (testing "Test that it solves correctly"
    (is (= (day06a/solve "test/adventofcode2021/input/day06.txt") 5934))))
