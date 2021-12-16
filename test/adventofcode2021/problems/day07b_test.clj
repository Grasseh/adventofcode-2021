(ns adventofcode2021.problems.day07b-test
  (:require [clojure.test :refer :all]
            [adventofcode2021.problems.day07b :refer :all :as day07b]))

(deftest testsolve
  (testing "Test that it solves correctly"
    (is (= (day07b/solve "test/adventofcode2021/input/day07.txt") 168))))
