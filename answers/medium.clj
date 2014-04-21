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

;; Problem 65. Black Box Testing
;; Write a function which takes a collection and returns one of :map, :set, :list, or :vector - describing the type of collection it
;; was given.
;; You won't be allowed to inspect their class or use the built-in predicates like list? - the point is to poke at them and understand
;; their behavior.
#({\[ :vector \# :set \{ :map} (nth (str %) 0) :list)

;; Problem 67. Prime Numbers
;; Write a function which returns the first x number of prime numbers. 
#(take %2 (remove (set (for [i % j (range (+ i i) 999 i)] j)) %))
(range 2 999)

;; Problem 70. Word Sorting
;; Write a function that splits a sentence up into a sorted list of words. Capitalization should not affect sort order and punctuation
;; should be ignored.
#(sort-by (fn [s] (.toLowerCase s)) (re-seq #"\w+" %))

;; Problem 74. Filter Perfect Squares
;; Given a string of comma separated integers, write a function which returns a new comma separated string that only contains the
;; numbers which are perfect squares.
;; awebb's solution
(fn [s] 
  (clojure.string/join 
    "," 
    (filter 
      #(= 0.0 (mod (Math/sqrt %) 1)) 
      (read-string 
        (str "[" s "]")
        ) 
      )
    ) 
  )

;; Problem 77. Anagram Finder
;; Write a function which finds all the anagrams in a vector of words. A word x is an anagram of word y if all the letters in x can be
;; rearranged in a different order to form y. Your function should return a set of sets, where each sub-set is a group of words which
;; are anagrams of each other. Each sub-set should have at least two words. Words without any anagrams should not be included in the
;; result.
;; pawellozinski's solution
#(set (map set (filter next (vals (group-by set %)))))

;; Problem 80. Perfect Numbers
;; A number is "perfect" if the sum of its divisors equal the number itself. 6 is a perfect number because 1+2+3=6. Write a function
;; which returns true for perfect numbers and false otherwise.
(fn [x] (= x (apply + (filter #(= 0 (rem x %)) (range 1 x)))))

;; Problem 102. intoCamelCase
;; When working with java, you often need to create an object with fieldsLikeThis, but you'd rather work with a hashmap that has
;; :keys-like-this until it's time to convert. Write a function which takes lower-case hyphen-separated strings and converts them to
;; camel-case strings.
;; chouser's solution
#(clojure.string/replace % #"-." (fn [[_ x]] (format "%S" x)))

;; Problem 137. Digits and bases
;; Write a function which returns a sequence of digits of a non-negative number (first argument) in numerical system with an arbitrary
;; base (second argument). Digits should be represented with their integer values, e.g. 15 would be [1 5] in base 10, [1 1 1 1] in base
;; 2 and [15] in base 16. 
;; mehmet's solution
(fn f [n b] (if (< n b) [n] (conj (f (quot n b) b)(mod n b) )))

