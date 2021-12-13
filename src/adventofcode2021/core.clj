(ns adventofcode2021.core
  (:gen-class)
  (:require [adventofcode2021.problems.day0a :as day0a])
  (:require [adventofcode2021.problems.day01a :as day01a])
  (:require [adventofcode2021.problems.day01b :as day01b])
  (:require [adventofcode2021.problems.day02a :as day02a])
  (:require [adventofcode2021.problems.day02b :as day02b])
  (:require [adventofcode2021.problems.day03a :as day03a])
  (:require [adventofcode2021.problems.day03b :as day03b])
  )

(defn call [nspace nm & args]
  (if-let [func (resolve (symbol nspace nm))]
    (apply func args)
    (println "No problem found.")))

(defn -main
  "I currently just show stuff"
  [& args]
  (println "Select a level")
  (let [level (read-line)]
    (println "You selected problem #" level)
    (call (str "adventofcode2021.problems.day" level) "solve" (str "input/day" level ".txt"))))


