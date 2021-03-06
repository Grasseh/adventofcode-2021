(ns adventofcode2021.problems.day01a)
  (use 'clojure.java.io)

(defn get-lines [fname]
  (with-open [r (reader fname)]
    (doall (line-seq r))))

(defn amountHigherThanPrevious [collection previous]
  (if (empty? collection)
    0
    (if (> (first collection) previous)
      (+ 1 (amountHigherThanPrevious (rest collection) (first collection)))
      (+ 0 (amountHigherThanPrevious (rest collection) (first collection))))))

(defn intThis [string]
  (Integer/parseInt string))

(defn turnIntoIntList [strings]
  (map intThis strings))

(defn doStuff [filename]
  (let [data (get-lines filename)]
    (amountHigherThanPrevious (turnIntoIntList data) Integer/MAX_VALUE)))

(defn solve
  "Return the amount of increased records"
  [filename]
  (let [solution (doStuff filename)]
    (println (str "Your solution is " solution))
    solution))
