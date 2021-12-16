(ns adventofcode2021.problems.day07a)
  (require '[clojure.string :as str])
  (use 'clojure.java.io)

(defn get-lines [fname]
  (with-open [r (reader fname)]
    (doall (line-seq r))))

(defn intThis [string]
  (Integer/parseInt string))

(defn total-fuel-distance [position crabs]
  (reduce #(+ %1 (Math/abs (- position %2))) 0 crabs))

(defn binary-search [crabs start-index end-index start-value end-value]
  (let [middle-index (+ (quot (- end-index start-index) 2) start-index)]
  (let [middle-value (total-fuel-distance middle-index crabs)]
    (if (= end-value start-value)
      middle-value
      (if
        (< start-value end-value)
        (binary-search crabs start-index middle-index start-value middle-value)
        (binary-search crabs middle-index end-index middle-value end-value)
      )
    ))))

(defn do-stuff [filename]
  (let [file-data (get-lines filename)]
  (let [crabs (map intThis (str/split (first file-data) #","))]
  (let [start-index 1]
  (let [start-value (total-fuel-distance start-index crabs)]
  (let [end-index (apply max crabs)]
  (let [end-value (total-fuel-distance end-index crabs)]
  (binary-search crabs start-index end-index start-value end-value))))))))

(defn solve
  "Return depth multiplied by position"
  [filename]
  (let [solution (do-stuff filename)]
    (println (str "Your solution is " solution))
    solution))
