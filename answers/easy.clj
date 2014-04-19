;; The shortest and amazing solutions collection to 4clojure.com
;; Pengfei Zhang
;; Easy level

;; Problem 19. Last Element
;; Write a function which returns the last element in a sequence.
;; daowen's solution
reduce #(-> %2)
;; grdvnl's solution
#(peek (vec %))

;; Problem 20. Penultimate Element
;; Write a function which returns the second to last element from a sequence.
;; 0x89's solution
(comp peek pop vec)

;; Problem 21. Nth Element
;; Write a function which returns the Nth element from a sequence.
;; gtss's solution
.get

;; Problem 22. Count a Sequence
;; Write a function which returns the total number of elements in a sequence.
#(-> % seq .size)

;; Problem 23. Reverse a Sequence
;; Write a function which reverses a sequence.
;; leetwinski's solution
into ()

;; Problem 24. Sum It All Up
;; Write a function which returns the sum of a sequence of numbers.
apply +

;; Problem 25. Find the odd numbers
;; Write a function which returns only the odd numbers from a sequence.
filter odd?

;; Problem 26. Fibonacci Sequence
;; Write a function which returns the first X fibonacci numbers.
;; megaterik's solution
#(take % ((fn f [a b] (lazy-cat [a] (f (+ a b) a))) 1 0))

;; Problem 27. Palindrome Detector
;; Write a function which returns true if the given sequence is a palindrome.
#(= (reverse %) (seq %))

;; Problem 28. Flatten a Sequence
;; Write a function which flattens a sequence.
;; Special Restrictions: flatten
;; megaterik's solution
(fn f [x] (if (coll? x) (mapcat f x) [x]))

;; Problem 29. Get the Caps
;; Write a function which takes a string and returns a new string containing only the capital letters.
;; megaterik's solution
#(.replaceAll % "[^A-Z]" "")

;; Problem 32. Duplicate a Sequence
;; Write a function which duplicates each element of a sequence.
;; austintaylor's solution
#(interleave % %)
;; aceeca1's solution
mapcat #(list % %)

;; Problem 38. Maximum value
;; Write a function which takes a variable number of parameters and returns the maximum value.
;; ramo's solution
#(last (sort %&))

;; Problem 61. Map Construction
;; Write a function which takes a vector of keys and a vector of values and constructs a map from them.
;; chouser's solution
#(into {} (map vector % %2))

;; Problem 62. Re-implement Iterate
;; Given a side-effect free function f and an initial value x write a function which returns an infinite lazy sequence of x, (f x), (f
;; (f x)), (f (f (f x))), etc.
;; dacquiri's solution
#(tree-seq % (juxt %) %2)

;; Problem 81. Set Intersection
;; Write a function which returns the intersection of two sets. The intersection is the sub-set of items that each set has in common.
;; aceeca1's solution
(comp set filter)

;; Problem 97. Pascal's Triangle
;; Write a function which returns the nth row of Pascal's Triangle. 
;; baex's solution
#(nth (iterate (fn [x] (map + `(0 ~@x) `(~@x 0))) [1]) (- % 1))

;; Problem 122. Read a binary number
;; Convert a binary number, provided in the form of a string, to its numerical value.
;; adereth's solution
#(Integer/parseInt % 2)

;; Problem 134. Infix Calculator
;; Your friend Joe is always whining about Lisps using the prefix notation for math. Show him how you could easily write a function
;; that does math using the infix notation. Is your favorite language that flexible, Joe? Write a function that accepts a variable
;; length mathematical expression consisting of numbers and the operations +, -, *, and /. Assume a simple calculator that does not do
;; precedence and instead just calculates left to right.
;; sheldon's solution
(fn i ([r] r) ([l o r & m] (apply i (o l r) m)))

;; Problem 147. Pascal's Trapezoid
;; Write a function that, for any given input vector of numbers, returns an infinite lazy sequence of vectors, where each next one is
;; constructed from the previous following the rules used in Pascal's Triangle. For example, for [3 1 2], the next row is [3 4 3 2].
;; awebb's solution
iterate #(map +' `(0 ~@%) `(~@% 0))

;; Problem 157. Indexing Sequences
;; Transform a sequence into a sequence of pairs containing the original elements along with their index.
;; austintaylor's solution
#(map list % (range))

