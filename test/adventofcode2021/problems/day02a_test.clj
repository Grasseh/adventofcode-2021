(ns adventofcode2021.problems.day02a-test
  (:require [clojure.test :refer :all]
            [adventofcode2021.problems.day02a :refer :all :as day02a]))

(deftest testsolve
  (testing "Test that it solves correctly"
    (is (= (day02a/solve "test/adventofcode2021/input/day02.txt") 150))))
