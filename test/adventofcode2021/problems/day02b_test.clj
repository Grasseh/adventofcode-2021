(ns adventofcode2021.problems.day02b-test
  (:require [clojure.test :refer :all]
            [adventofcode2021.problems.day02b :refer :all :as day02b]))

(deftest testsolve
  (testing "Test that it solves correctly"
    (is (= (day02b/solve "test/adventofcode2021/input/day02.txt") 900))))
