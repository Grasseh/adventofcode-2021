(ns adventofcode2021.problems.day02a)
  (require '[clojure.string :as str])
  (use 'clojure.java.io)

(defn get-lines [fname]
  (with-open [r (reader fname)]
    (doall (line-seq r))))

(defn forward [amount]
  { :depth 0 :position amount })

(defn down [amount]
  { :depth amount :position 0 })

(defn up [amount]
  { :depth (- 0 amount) :position 0 })

(defn call [function & args]
  (let [namespaced-fn (str "adventofcode2021.problems.day02a/" function)]
  (apply (resolve (symbol namespaced-fn)) args)))

(defn int-this [string]
  (Integer/parseInt string))

(defn convert-to-movement [line]
  (let [data (str/split line #" ")]
    (call (first data) (int-this (second data)))
  ))

(defn move [incoming accumulator]
  {
    :depth (+ (:depth incoming) (:depth accumulator))
    :position (+ (:position incoming) (:position accumulator))
  })

(defn do-stuff [filename]
  (let [data (get-lines filename)]
  (let [mapped-data (map convert-to-movement data)]
  (let [result (reduce move { :depth 0 :position 0 } mapped-data)]
    (* (:depth result) (:position result))))))

(defn solve
  "Return depth multiplied by position"
  [filename]
  (let [solution (do-stuff filename)]
    (println (str "Your solution is " solution))
    solution))
