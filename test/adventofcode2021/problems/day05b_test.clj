(ns adventofcode2021.problems.day05b-test
  (:require [clojure.test :refer :all]
            [adventofcode2021.problems.day05b :refer :all :as day05b]))

(deftest testsolve
  (testing "Test that it solves correctly"
    (is (= (day05b/solve "test/adventofcode2021/input/day05.txt") 12))))
