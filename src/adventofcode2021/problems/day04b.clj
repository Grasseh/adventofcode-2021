(ns adventofcode2021.problems.day04b)
  (require '[clojure.string :as str])
  (use 'clojure.java.io)

(defrecord BingoSheet [vectors])

(defn get-lines [fname]
  (with-open [r (reader fname)]
    (doall (line-seq r))))

(defn intThis [string]
  (Integer/parseInt string))

(defn draw-numbers [file-data]
  (map intThis (str/split (first file-data) #",")))

(defn get-sheet-numbers [sheet-lines index]
  (map intThis (str/split (str/trim (nth sheet-lines index)) #"\s+"))
  )

(defn cell [numbers col row]
  (nth (nth numbers row) col))

(defn row [numbers index]
  (into [] (nth numbers index)))

(defn col [numbers index]
  (into [] (map (partial cell numbers index) (range 0 5))))

; (cell numbers 0 (- 4 (* 4 dia-index)))
; (cell numbers 1 (- 3 (* 2 dia-index)))
; (cell numbers 2 (- 2 (* 0 dia-index)))
; (cell numbers 3 (- 1 (* -2 dia-index)))
; (cell numbers 4 (- 0 (* -4 dia-index)))
(defn dia [numbers diagonal-index]
  (into [] (map (fn [loop-index]
    (cell
      numbers
      loop-index
      (- (- 4 loop-index) (* (- 4 (* 2 loop-index)) diagonal-index))
    ))
    (range 0 5)
  )))

(defn create-vectors [sheet-numbers]
  [
    (row sheet-numbers 0)
    (row sheet-numbers 1)
    (row sheet-numbers 2)
    (row sheet-numbers 3)
    (row sheet-numbers 4)
    (col sheet-numbers 0)
    (col sheet-numbers 1)
    (col sheet-numbers 2)
    (col sheet-numbers 3)
    (col sheet-numbers 4)
    ; (dia sheet-numbers 0)
    ; (dia sheet-numbers 1)
  ])

(defn create-sheet [sheet-lines index]
  (let [start (+ (* index 6) 2)]
  (let [end (+ (* index 6) 7)]
  (let [sheet-numbers (
    map (partial get-sheet-numbers sheet-lines) (range start end)
  )]
  (BingoSheet. (create-vectors sheet-numbers))
  ))))

(defn create-sheets [file-data]
  (map (partial create-sheet file-data) (range 0 (quot (count file-data) 6))
  ))

(defn sum-vectors [vectors]
  (reduce + (map (partial reduce +) vectors)))

(defn calculate-score [bingo-sheet]
  (sum-vectors (take 5 (:vectors bingo-sheet))))

(defn update-vector [number old-vector]
  (remove #(= number %) old-vector))

(defn update-sheet [number-drawn sheet]
  (let [old-vectors (:vectors sheet)]
  (let [new-vectors (map (partial update-vector number-drawn) old-vectors)]
  (BingoSheet. new-vectors)
  )))

(defn is-winner [sheet]
  (some #(= 0 (count %)) (:vectors sheet)))

(defn exclude-winners [bingo-sheets]
  (remove is-winner bingo-sheets))

(defn calculate-loser [remaining-numbers losing-sheet]
  (let [current-number (first remaining-numbers)]
  (let [rest-of-numbers (rest remaining-numbers)]
  (let [updated-sheet (update-sheet current-number losing-sheet)]
  (if (is-winner updated-sheet)
    (* current-number (calculate-score updated-sheet))
    (calculate-loser (rest-of-numbers updated-sheet))
  )))))

(defn find-loser [numbers-drawn bingo-sheets]
  (let [current-number (first numbers-drawn)]
  (let [rest-of-numbers (rest numbers-drawn)]
  (let [updated-sheets (
    map
    (partial update-sheet current-number)
    bingo-sheets
  )]
  (let [leftover-sheets (exclude-winners updated-sheets)]
  (if
    (> (count leftover-sheets) 1)
    (find-loser rest-of-numbers leftover-sheets)
    (calculate-loser rest-of-numbers (first leftover-sheets))
  ))))))

(defn do-stuff [filename]
  (let [file-data (get-lines filename)]
  (let [numbers-drawn (draw-numbers file-data)]
  (let [bingo-sheets (create-sheets file-data)]
  (find-loser numbers-drawn bingo-sheets)
  ))))

(defn solve
  "Return depth multiplied by position"
  [filename]
  (let [solution (do-stuff filename)]
    (println (str "Your solution is " solution))
    solution))
