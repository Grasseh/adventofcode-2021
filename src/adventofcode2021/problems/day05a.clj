(ns adventofcode2021.problems.day05a)
  (require '[clojure.string :as str])
  (use 'clojure.java.io)

(defn get-lines [fname]
  (with-open [r (reader fname)]
    (doall (line-seq r))))

(defrecord Vent [x1 y1 x2 y2])

(def input-matcher #"(\d+),(\d+) -> (\d+),(\d+)")

(defn intThis [string]
  (Integer/parseInt string))

(defn parse-coordinates [file-data]
  (map #(drop 1 (re-find (re-matcher input-matcher %))) file-data))

(defn coordinates-to-vent [coordinates]
  (let [[x1 y1 x2 y2] (map intThis coordinates)]
  (Vent. x1 y1 x2 y2)))

(defn generate-hash-key [x y]
  (str x "-" y))

(defn increment-map [incoming-map x y]
  (let [hash-key (keyword (generate-hash-key x y))]
  (if (incoming-map hash-key)
    (update incoming-map hash-key inc)
    (merge incoming-map {hash-key 1}))))

(defn count-x [count-map vent]
  (reduce
    #(increment-map %1 (:x1 vent) %2)
    count-map
    (range (min (:y1 vent) (:y2 vent)) (+ (max (:y1 vent) (:y2 vent)) 1))
  ))

(defn count-y [count-map vent]
  (reduce
    #(increment-map %1 %2 (:y1 vent))
    count-map
    (range (min (:x1 vent) (:x2 vent)) (+ (max (:x1 vent) (:x2 vent)) 1))
  ))

(defn count-vent [count-map vent]
  (cond
    (= (:x1 vent) (:x2 vent)) (count-x count-map vent)
    (= (:y1 vent) (:y2 vent)) (count-y count-map vent)
    :else count-map
  ))

(defn generate-map-count [vents]
  (reduce count-vent {} vents))

(defn count-twos [map-counts]
  (reduce
    #(+ %1 (if (> (last %2) 1) 1 0))
    0
    (seq map-counts)
  ))

(defn do-stuff [filename]
  (let [file-data (get-lines filename)]
  (let [coordinates (parse-coordinates file-data)]
  (let [vents (map coordinates-to-vent coordinates)]
  (let [map-counts (generate-map-count vents)]
  (count-twos map-counts)
  )))))

(defn solve
  "Return depth multiplied by position"
  [filename]
  (let [solution (do-stuff filename)]
    (println (str "Your solution is " solution))
    solution))
