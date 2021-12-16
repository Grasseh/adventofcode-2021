(ns adventofcode2021.problems.day06b)
  (require '[clojure.string :as str])
  (use 'clojure.java.io)

(defn get-lines [fname]
  (with-open [r (reader fname)]
    (doall (line-seq r))))

(defn intThis [string]
  (Integer/parseInt string))

(defn generate-initial-fish-colony [line]
  (let [fishies (str/split line #",")]
  (let [fish-colony-map (zipmap (map symbol (map str (range 0 9))) (repeat 0))]
  (reduce #(update %1 %2 inc) fish-colony-map (map symbol fishies))
  )))

(defn symbol-minus-one [old-symbol]
  (symbol (str (+ -1 (Integer/parseInt (name (symbol old-symbol)))))))

(defn update-fishies-map [new-map old-fishies-keyval]
  (case (str (key old-fishies-keyval))
    ("0") (update
      (update new-map (symbol "6") (partial + (val old-fishies-keyval)))
      (symbol "8") (partial + (val old-fishies-keyval)))
    (update
      new-map
      (symbol-minus-one (key old-fishies-keyval))
      (partial + (val old-fishies-keyval)))))

(defn spend-colony-day [fishies-map i]
  (reduce
    update-fishies-map
    (zipmap (map symbol (map str (range 0 9))) (repeat 0))
    (seq fishies-map)
  ))


(defn do-stuff [filename]
  (let [file-data (get-lines filename)]
  (let [fish-colony (generate-initial-fish-colony (first file-data))]
  (let [day-one (spend-colony-day fish-colony 1)]
  (let [day-two-fiddy-six
    (reduce #(spend-colony-day %1 %2) fish-colony (range 0 256))
  ]
  (reduce #(+ %1 (val %2)) 0 (seq day-two-fiddy-six))
  )))))

(defn solve
  "Return depth multiplied by position"
  [filename]
  (let [solution (do-stuff filename)]
    (println (str "Your solution is " solution))
    solution))
