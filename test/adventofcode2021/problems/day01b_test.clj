(ns adventofcode2021.problems.day01b-test
  (:require [clojure.test :refer :all]
            [adventofcode2021.problems.day01b :refer :all :as day01b]))

(deftest testsolve
  (testing "Test that it solves correctly"
    (is (= (day01b/solve "test/adventofcode2021/input/day01.txt") 5))))
