(ns game-of-clojure.core)

(defn neighbour-coords
  ([yx]
    (neighbour-coords 3 yx))
  ([size yx] 
    (neighbour-coords [[-1 -1][-1 0][-1 1][0 -1][0 1][1 -1][1 0][1 1]] size yx))
  ([deltas size yx] 
    (filter (fn [new-yx] (every? #(< -1 % size) new-yx)) ; Tests whether the coordinates are a valid coordinate
            (map #(map + yx %) deltas)))) ; Maps the coordinates onto each set of deltas, resulting in the actual coordinates!!!

(defn neighbours
  [universe yx]
    (map #(get-in universe %) (neighbour-coords 3 yx)))

(defn live?
  [cell]
    (= :live cell))

(defn number-of-live-neighbours
  [universe yx]
    (count (filter live? (neighbours universe yx))))

(defn underpopulated?
  [universe yx]
    (<= 1 (number-of-live-neighbours universe yx)))

(defn kill
  [universe yx]
    (assoc-in universe yx :dead))

(defn evolve 
  [universe]
    (let [width (count (first universe)) height (count universe)]
      (for [y (range 0 height) x (range 0 width)]
        (when (underpopulated? universe [y x])
          ; return value of kill is a new universe, handle this!
          (kill universe [y x])))
      universe))
          
(defn -main
  []
    (evolve [[:dead :live :dead][:live :dead :dead][:dead :live :dead]]))
