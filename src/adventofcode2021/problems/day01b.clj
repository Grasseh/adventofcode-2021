(ns adventofcode2021.problems.day01b)
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

(defn indexCollection [collection]
  (map-indexed vector collection))

(defn sumCollection [indexed, indexes]
  (apply +
    (map last
      (map (partial nth indexed) indexes))))

(defn regroup [indexed, value]
  (let [index (first value)]
    (sumCollection indexed (range index (+ index 3)))))

(defn threeSum [collection]
  (map (partial regroup collection) (drop-last 2 collection)))

(defn doStuff [filename]
  (let [data (get-lines filename)]
    (let [slidingList (threeSum (indexCollection (turnIntoIntList data)))]
      (amountHigherThanPrevious slidingList Integer/MAX_VALUE))))

(defn solve
  "Return the amount of increased records"
  [filename]
  (let [solution (doStuff filename)]
    (println (str "Your solution is " solution))
    solution))
