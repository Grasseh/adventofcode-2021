(ns adventofcode2021.problems.day03a)
  (require '[clojure.string :as str])
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

(defn rate [data operator]
  (let [length (count (first data))]
  (reduce
    (fn [acc index]
      (str
        acc
        (if
          (operator (count-at data index 0) (count-at data index 1))
          0
          1
          )
        )
      )
    ""
    (range 0 length)
  )))

(defn gamma-rate [data]
  (rate data >)
  )

; This could be 0(M + M*N) instead of O(2 M*N) since N is bigger if this
; function inverted the binary of gamma instead of recalculating its own value
; but hey this code isn't performance-driven THAT much
(defn epsilon-rate [data]
  (rate data <)
  )

(defn do-stuff [filename]
  (let [data (get-lines filename)]
  (let [γ (bin-to-decimal (gamma-rate data))]
  (let [ε (bin-to-decimal (epsilon-rate data))]
  (* γ ε)))))

(defn solve
  "Return depth multiplied by position"
  [filename]
  (let [solution (do-stuff filename)]
    (println (str "Your solution is " solution))
    solution))
