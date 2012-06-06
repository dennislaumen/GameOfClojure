(ns game-of-clojure.test.core
  (:use [game-of-clojure.core])
  (:use [clojure.test]))

(deftest underpopulation 
  "If a cell has 1 or 0 neighbours he dies!"
  (is (= [[:dead :dead :dead][:dead :dead :dead][:dead :dead :dead]] 
      (evolve [[:dead :live :dead][:dead :live :dead][:dead :dead :dead]]))
      "Cells did not die of underpopulation."))

;(deftest overpopulation
;  "If a cell has more than 2 neighbours, he dies!"
;  (is (= [[:dead :live :dead] [:dead :dead :dead] [:dead :dead :dead]]
;      (evolve [[:dead :live :live][:dead :live :dead][:dead :dead :dead]]))
;      "Cells did not die of overpopulation."))

; (deftest growth
;  "If a cell has 2 neighbours, he lives!")

(deftest neighbours-test
  (is (= [:dead :live :dead :dead :dead :dead :dead :dead]
      (neighbours [[:dead :live :dead][:dead :live :dead][:dead :dead :dead]] [1 1]))))
