(defproject game-of-clojure "1.0.0-SNAPSHOT"
  :description "Game of Life implementation in Clojure"
  :dependencies [[org.clojure/clojure "1.4.0"] [org.clojure/clojure-contrib "1.2.0"]]
  :aot [game-of-clojure.core game-of-clojure.test.core]
  :main game-of-clojure.core)
