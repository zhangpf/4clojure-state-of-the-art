;; The shortest and amazing solutions collection to 4clojure.com
;; Pengfei Zhang
;; Hard level

;; Problem 79. Triangle Minimal Path
;; Write a function which calculates the sum of the minimal path through a triangle. The triangle is represented as a collection of
;; vectors. The path should start at the top of the triangle and move to an adjacent number on the next row until the bottom of the
;; triangle is reached.
(fn f ([g] (f 0 g)) ([i [h & t]] (+ (h i) (if t (min (f i t) (f (+ 1 i) t)) 0))))

;; Problem 92. Read Roman numerals
;; Roman numerals are easy to recognize, but not everyone knows all the rules necessary to work with them. Write a function to parse a
;; Roman-numeral string and return the number it represents. 
;; You can assume that the input will be well-formed, in upper-case, and follow the subtractive principle. You don't need to handle any
;; numbers greater than MMMCMXCIX (3999), the largest number representable with ordinary letters.
#(apply + (reductions (fn [x y] (if (< x y) (- y x x) y))
                      (map {\X 10 \I 1 \V 5 \C 100 \D 500 \L 50 \M 1000} %)))

