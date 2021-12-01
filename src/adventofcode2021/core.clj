(ns adventofcode2021.core
  (:gen-class)
  (:require [adventofcode2021.problems.day0a :as day0a])
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


