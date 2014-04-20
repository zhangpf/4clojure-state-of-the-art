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

;; Problem 30. Compress a Sequence
;; Write a function which removes consecutive duplicates from a sequence.
;; mllr's solution
#(map last (partition-by str %))

;; Problem 32. Duplicate a Sequence
;; Write a function which duplicates each element of a sequence.
;; austintaylor's solution
#(interleave % %)
;; aceeca1's solution
mapcat #(list % %)

;; Problem 33. Replicate a Sequence
;; Write a function which replicates each element of a sequence a variable number of times.
;; dacquiri's solution
#(for [x %, i (range %2)] x)

;; Problem 34. Implement range
;; Write a function which creates a list of all integers in a given range.
;; Special Restrictions: range
#(take (- %2 %) (iterate inc %))

;; Problem 38. Maximum value
;; Write a function which takes a variable number of parameters and returns the maximum value.
;; ramo's solution
#(last (sort %&))

;; Problem 39. Interleave Two Seqs
;; Write a function which takes two sequences and returns the first item from each, then the second item from each, then the third,
;; etc.
mapcat vector

;; Problem 42. Factorial Fun
;; Write a function which calculates factorials.
#(apply * (range % 1 -1))

;; Problem 45. Intro to Iterate
;; The iterate function can be used to produce an infinite lazy sequence.
(range 1 15 3)

;; Problem 47. Contain Yourself
;; The contains? function checks if a KEY is present in a given collection. This often leads beginner clojurians to use it incorrectly
;; with numerically indexed collections like vectors and lists.
4

;; Problem 48. Intro to some
;; The some function takes a predicate function and a collection. It returns the first logical true value of (predicate x) where x is
;; an item in the collection.
6

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

;; Problem 95. To Tree, or not to Tree
;; Write a predicate which checks whether or not a given sequence represents a binary tree. Each node in the tree must have a value, a
;; left child, and a right child.
;; redraiment's solution
(fn f [x] (or (nil? x) (and (coll? x) (= 3 (count x)) (every? f (rest x)))))

;; Problem 96. Beauty is Symmetry
;; Write a predicate to determine whether or not a given binary tree is symmetric. (see To Tree, or not to Tree for a reminder on the
;; tree representation we're using).
;; baex's solution
#(= % ((fn f [[a b c]] (if a [a (f c) (f b)])) %))

;; Problem 97. Pascal's Triangle
;; Write a function which returns the nth row of Pascal's Triangle. 
;; baex's solution
#(nth (iterate (fn [x] (map + `(0 ~@x) `(~@x 0))) [1]) (- % 1))

;; Problem 107. Simple closures
;; Given a positive integer n, return a function (f x) which computes xn. Observe that the effect of this is to preserve the value of n
;; for use outside the scope in which it is defined.
;; 0x89's solution (for some reason, the float has some precision error, so I modified it.)
(fn [n] #(int (Math/pow % n)))

;; Problem 122. Read a binary number
;; Convert a binary number, provided in the form of a string, to its numerical value.
;; adereth's solution
#(Integer/parseInt % 2)

;; Problem 118. Re-implement Map
;; Map is one of the core elements of a functional programming language. Given a function f and an input sequence s, return a lazy
;; sequence of (f x) for each element x in s.
;; Special Restrictions: map, map-indexed, mapcat, for
;; zawutuckatez's solution
(fn [f l] (rest (reductions #(f %2) 0 l)))

;; Problem 126. Through the Looking Class
;; Enter a value which satisfies the following:
;; (let [x __]
;;   (and (= (class x) x) x))
Class

;; Problme 128. Recognize Playing Cards
;; Write a function which converts (for example) the string "SJ" into a map of {:suit :spade, :rank 9}. A ten will always be
;; represented with the single character "T", rather than the two characters "10".
;; austintaylor's solution
(fn [[s r]]
    { :suit ({\D :diamond \H :heart \C :club \S :spade} s)
         :rank (.indexOf (seq "23456789TJQKA") r)})

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

;; Problem 153. Pairwise Disjoint Sets
;; Given a set of sets, create a function which returns true if no two of those sets have any elements in common and false otherwise.
;; Some of the test cases are a bit tricky, so pay a little more attention to them.
;; dacquiri's solution
not-any? #(some #{'+ 0 [] :a} %)

;; Problem 157. Indexing Sequences
;; Transform a sequence into a sequence of pairs containing the original elements along with their index.
;; austintaylor's solution
#(map list % (range))

;; Problem 173. Intro to Destructuring 2
;; Sequential destructuring allows you to bind symbols to parts of sequential things (vectors, lists, seqs, etc.): (let [bindings* ]
;; exprs*) Complete the bindings so all let-parts evaluate to 3.
x y

