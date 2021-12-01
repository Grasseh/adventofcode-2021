(ns adventofcode2021.problems.day0a)
  (use 'clojure.java.io)

(defn get-lines [fname]
    (with-open [r (reader fname)]
          (doall (line-seq r))))

(defn doStuff [filename]
  (let [data (get-lines filename)]
  (nth data 2)))

(defn solve
  "Return the third input in the provided file"
  [filename]
  (let [solution (doStuff filename)]
    (println (str "Your solution is " solution))
    solution))
