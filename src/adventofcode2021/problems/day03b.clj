(ns adventofcode2021.problems.day03b)
  (use 'clojure.java.io)

(defn get-lines [fname]
  (with-open [r (reader fname)]
    (doall (line-seq r))))

(defn bin-to-decimal [binary-string]
  (Integer/parseInt binary-string 2))

(defn count-at [array index character]
  (count
    (filter
      (fn [row] (= (str (nth row index)) (str character)))
      array
      )))

(defn rate [data operator tie-breaker index]
  (let [length (count (first data))]
  (let [zeros (count-at data index 0)]
  (let [ones (count-at data index 1)]
  (let [bit-criteria (if (= zeros ones) tie-breaker (if (operator zeros ones) 0 1))]
  (let [filtered-data
        (filter (fn [row] (= (str (nth row index)) (str bit-criteria))) data)]
  (if (<= (count filtered-data) 1)
    (first filtered-data)
    (rate filtered-data operator tie-breaker (+ index 1)
  ))))))))

(defn oxygen-generator [data]
  (rate data > 1 0)
  )

(defn carbon-scrubber [data]
  (rate data < 0 0)
  )

(defn do-stuff [filename]
  (let [data (get-lines filename)]
  (let [oxygen (bin-to-decimal (oxygen-generator data))]
  (let [carbon (bin-to-decimal (carbon-scrubber data))]
  (* oxygen carbon)))))

(defn solve
  "Return depth multiplied by position"
  [filename]
  (let [solution (do-stuff filename)]
    (println (str "Your solution is " solution))
    solution))
