(ns adventofcode2021.problems.day02b)
  (require '[clojure.string :as str])
  (use 'clojure.java.io)

(defn get-lines [fname]
  (with-open [r (reader fname)]
    (doall (line-seq r))))

(defn forward [amount current_directions]
  {
    :depth (+ (:depth current_directions) (* amount (:aim current_directions)))
    :aim (:aim current_directions)
    :position (+ (:position current_directions) amount)
  })

(defn down [amount current_directions]
  {
    :depth (:depth current_directions)
    :aim (+ amount (:aim current_directions))
    :position (:position current_directions)
  })

(defn up [amount current_directions]
  {
    :depth (:depth current_directions)
    :aim (- (:aim current_directions) amount)
    :position (:position current_directions)
  })

(defn call [function & args]
  (let [namespaced-fn (str "adventofcode2021.problems.day02b/" function)]
  (apply (resolve (symbol namespaced-fn)) args)))

(defn int-this [string]
  (Integer/parseInt string))

(defn move [accumulator incoming]
  (let [data (str/split incoming #" ")]
    (call (first data) (int-this (second data)) accumulator)
  ))

(defn do-stuff [filename]
  (let [data (get-lines filename)]
  (let [result (reduce move { :aim 0 :depth 0 :position 0 } data)]
    (* (:depth result) (:position result)))))

(defn solve
  "Return depth multiplied by position"
  [filename]
  (let [solution (do-stuff filename)]
    (println (str "Your solution is " solution))
    solution))
