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

;; Problem 31. Pack a Sequence
;; Write a function which packs consecutive duplicates into sub-lists.
partition-by str

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

;; Problem 40. Interpose a Seq
;; Write a function which separates the items of a sequence by an arbitrary value.
;; Special Restrictions: interpose
;; dacquiri's solution
#(rest (for [i %2, x [% i]] x))

;; Problem 41. Drop Every Nth Item
;; Write a function which drops every Nth item from a sequence.
#(flatten (partition-all (dec %2) %2 %1))

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

;; Problem 49. Split a sequence
;; Write a function which will split a sequence into two parts.
;; Special Restrictions: split-at
;; thegeez's solution
(juxt take drop)

;; Problem 51. Advanced Destructuring
;; Here is an example of some more sophisticated destructuring.
;; (= [1 2 [3 4 5] [1 2 3 4 5]] (let [[a b & c :as d] __] [a b c d]))
[1 2 3 4 5]

;; Problem 52. Intro to Destructuring
;; Let bindings and function parameter lists support destructuring.
[c e]

;; Problem 61. Map Construction
;; Write a function which takes a vector of keys and a vector of values and constructs a map from them.
;; chouser's solution
#(into {} (map vector % %2))

;; Problem 62. Re-implement Iterate
;; Given a side-effect free function f and an initial value x write a function which returns an infinite lazy sequence of x, (f x), (f
;; (f x)), (f (f (f x))), etc.
;; dacquiri's solution
#(tree-seq % (juxt %) %2)

;; Problem 66. Greatest Common Divisor
;; Given two integers, write a function which returns the greatest common divisor.
;; megaterik's solution
#(if (= 0 %2) % (recur %2 (mod % %2)))

;; Problem 81. Set Intersection
;; Write a function which returns the intersection of two sets. The intersection is the sub-set of items that each set has in common.
;; aceeca1's solution
(comp set filter)

;; Problem 83. A Half-Truth
;; Write a function which takes a variable number of booleans. Your function should return true if some of the parameters are true, but
;; not all of the parameters are true. Otherwise your function should return false.
;; awebb's solution
not=

;; Problem 88. Symmetric Difference
;; Write a function which returns the symmetric difference of two sets. The symmetric difference is the set of items belonging to one
;; but not both of the two sets.
;; kohyama's solution
#(set (concat (remove % %2) (remove %2 %)))

;; Problem 90. Cartesian Product
;; Write a function which calculates the Cartesian product of two sets.
#(set (for [x %1 y %2] [x y]))

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

;; Problem 99. Product Digits
;; Write a function which multiplies two numbers and returns the result as a sequence of its digits.
;; aimhere's solutiont 
#(for [d (str (* % %2))] (- (int d) 48))

;; Problem 107. Simple closures
;; Given a positive integer n, return a function (f x) which computes xn. Observe that the effect of this is to preserve the value of n
;; for use outside the scope in which it is defined.
;; 0x89's solution (for some reason, the float has some precision error, so I modified it.)
(fn [n] #(int (Math/pow % n)))

;; Problem 118. Re-implement Map
;; Map is one of the core elements of a functional programming language. Given a function f and an input sequence s, return a lazy
;; sequence of (f x) for each element x in s.
;; Special Restrictions: map, map-indexed, mapcat, for
;; zawutuckatez's solution
(fn [f l] (rest (reductions #(f %2) 0 l)))

;; Problem 120. Sum of square of digits
;; Write a function which takes a collection of integers as an argument. Return the count of how many elements are smaller
;; than the sum of their squared component digits. For example: 10 is larger than 1 squared plus 0 squared; whereas 15 is smaller than
;; 1 squared plus 5 squared.
;; cgrand's solution
reduce #(if (< %2 (reduce + (map (zipmap "0123456789" (map * (range) (range))) (str %2)))) (inc %) %) 0

;; Problem 122. Read a binary number
;; Convert a binary number, provided in the form of a string, to its numerical value.
;; adereth's solution
#(Integer/parseInt % 2)

;; Problem 126. Through the Looking Class
;; Enter a value which satisfies the following:
;; (let [x __]
;;   (and (= (class x) x) x))
Class

;; Problem 128. Recognize Playing Cards
;; Write a function which converts (for example) the string "SJ" into a map of {:suit :spade, :rank 9}. A ten will always be
;; represented with the single character "T", rather than the two characters "10".
;; austintaylor's solution
(fn [[s r]]
    { :suit ({\D :diamond \H :heart \C :club \S :spade} s)
         :rank (.indexOf (seq "23456789TJQKA") r)})

;; Problem 135. Infix Calculator
;; Your friend Joe is always whining about Lisps using the prefix notation for math. Show him how you could easily write a function
;; that does math using the infix notation. Is your favorite language that flexible, Joe? Write a function that accepts a variable
;; length mathematical expression consisting of numbers and the operations +, -, *, and /. Assume a simple calculator that does not do
;; precedence and instead just calculates left to right.
;; sheldon's solution
(fn i ([r] r) ([l o r & m] (apply i (o l r) m)))

;; Problem 143. dot product
;; Create a function that computes the dot product of two sequences. You may assume that the vectors will have the same length. 
#(apply + (map * % %2))

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

;; Problem 166. Comparisons
;; For any orderable data type it's possible to derive all of the basic comparison operations (<, ≤, =, ≠, ≥, and >) from a single
;; operation (any operator but = or ≠ will work). Write a function that takes three arguments, a less than operator for the data and
;; two items to compare. The function should return a keyword describing the relationship between the two items. The keywords for the
;; relationship between x and y are as follows:
;; x = y → :eq
;; x > y → :gt
;; x < y → :lt
#(if (% %2 %3) :lt (if (% %3 %2) :gt :eq))

;; Problem 173. Intro to Destructuring 2
;; Sequential destructuring allows you to bind symbols to parts of sequential things (vectors, lists, seqs, etc.): (let [bindings* ]
;; exprs*) Complete the bindings so all let-parts evaluate to 3.
x y

