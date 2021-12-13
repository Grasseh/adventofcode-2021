(ns adventofcode2021.problems.day03a-test
  (:require [clojure.test :refer :all]
            [adventofcode2021.problems.day03a :refer :all :as day03a]))

; (deftest testsolve-2
;   (testing "Test that it solves correctly"
;     (is (= (day03a/count-at ["0101" "0101" "0101"] 0 "0") 3))))

(deftest testsolve
  (testing "Test that it solves correctly"
    (is (= (day03a/solve "test/adventofcode2021/input/day03.txt") 198))))
