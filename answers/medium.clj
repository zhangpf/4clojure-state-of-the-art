;; The shortest and amazing solutions collection to 4clojure.com
;; Pengfei Zhang
;; Medium level

;; Problem 46. Flipping out
;; Write a higher-order function which flips the order of the arguments of an input function.
#(fn [a b] (% b a))

;; Problem 50. Split by Type
;; Write a function which takes a sequence consisting of items with different types and splits them up into a set of homogeneous
;; sub-sequences. The internal order of each sub-sequence should be maintained, but the sub-sequences themselves can be returned in any
;; order (this is why 'set' is used in the test cases).
;; _pcl's solution
#(vals (group-by type %))

;; Problem 55. Count Occurrences
;; Write a function which returns a map containing the number of occurences of each distinct item in a sequence.
;; Special Restrictions: frequencies
;; jriddy's solution
reduce #(assoc % %2 (+ 1 (% %2 0))) {}

;; Problem 56. Find Distinct Items
;; Write a function which removes the duplicates from a sequence. Order of the items must be maintained.
;; Special Restrictions: distinct
#(vec (java.util.LinkedHashSet. %))
;; baex's solution
reduce #(if ((set %) %2) % (conj % %2)) []

;; Problem 67. Prime Numbers
;; Write a function which returns the first x number of prime numbers. 
#(take %2 (remove (set (for [i % j (range (+ i i) 999 i)] j)) %))
(range 2 999)

;; Problem 70. Word Sorting
;; Write a function that splits a sentence up into a sorted list of words. Capitalization should not affect sort order and punctuation
;; should be ignored.
#(sort-by (fn [s] (.toLowerCase s)) (re-seq #"\w+" %))

