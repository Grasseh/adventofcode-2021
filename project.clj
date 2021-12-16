(defproject adventofcode-2021 "0.0.1"
  :description "Advent of Code solutions"
  :url "http://www.github.com/grasseh/adventofcode-2021"
  :license {:name "MIT"
            :url "https://opensource.org/licenses/MIT"}
  :dependencies [
                 [org.clojure/clojure "1.10.3"],
                 [org.clojure/math.numeric-tower "0.0.5"]
                 ]
  :main ^:skip-aot adventofcode2021.core
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all}})
