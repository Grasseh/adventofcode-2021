(ns adventofcode2021.problems.day03b-test
  (:require [clojure.test :refer :all]
            [adventofcode2021.problems.day03b :refer :all :as day03b]))

(deftest testsolve
  (testing "Test that it solves correctly"
    (is (= (day03b/solve "test/adventofcode2021/input/day03.txt") 230))))
