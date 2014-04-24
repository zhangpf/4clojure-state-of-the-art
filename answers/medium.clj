;; The shortest and amazing solutions collection to 4clojure.com
;; Pengfei Zhang
;; Medium level

;; Problem 43. Reverse Interleave
;; Write a function which reverses the interleave process into x number of subsequences.
#(apply map list (partition %2 %))

;; Problem 44. Rotate Sequence
;; Write a function which can rotate a sequence in either direction.
#(let [x (count %2)] (take x (drop (mod % x) (cycle %2))))

;; Problem 46. Flipping out
;; Write a higher-order function which flips the order of the arguments of an input function.
#(fn [a b] (% b a))

;; Problem 50. Split by Type
;; Write a function which takes a sequence consisting of items with different types and splits them up into a set of homogeneous
;; sub-sequences. The internal order of each sub-sequence should be maintained, but the sub-sequences themselves can be returned in any
;; order (this is why 'set' is used in the test cases).
#(vals (group-by type %))

;; Problem 54. Partition a Sequence
;; Write a function which returns a sequence of lists of x items each. Lists of less than x items should not be returned.
;; Special Restrictions: partition, partition-all
(fn [x s]
    (map #(take x (drop % s)) (range 0 (- (count s) x -1) x)))

;; Problem 55. Count Occurrences
;; Write a function which returns a map containing the number of occurences of each distinct item in a sequence.
;; Special Restrictions: frequencies
reduce #(assoc % %2 (+ 1 (% %2 0))) {}

;; Problem 56. Find Distinct Items
;; Write a function which removes the duplicates from a sequence. Order of the items must be maintained.
;; Special Restrictions: distinct
#(vec (java.util.LinkedHashSet. %))
;; alternative solution
reduce #(if ((set %) %2) % (conj % %2)) []

;; Problem 58. Function Composition
;; Write a function which allows you to create function compositions. The parameter list should take a variable number of functions,
;; and create a function applies them from right-to-left.
;; Special Restrictions: comp
(fn c [a f & g] (if g #(f (a (a c a g) %&)) f))
apply

;; Problem 59. Juxtaposition
;; Take a set of functions and return a new function that takes a variable number of arguments and returns a sequence containing the
;; result of applying each function left-to-right to the argument list.
;; Special Restrictions: juxt
#(fn [& x] (for [y %&] (apply y x)))

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

;; Problem 76. Intro to Trampoline
;; The trampoline function takes a function f and a variable number of parameters. Trampoline calls f with any parameters that were
;; supplied. If f returns a function, trampoline calls that function with no arguments. This is repeated, until the return value is not
;; a function, and then trampoline returns that non-function value. This is useful for implementing mutually recursive algorithms in a
;; way that won't consume the stack.
[1 3 5 7 9 11]

;; Problem 75. Euler's Totient Function
;; Two numbers are coprime if their greatest common divisor equals 1. Euler's totient function f(x) is defined as the number of
;; positive integers less than x which are coprime to x. The special case f(1) equals 1. Write a function which calculates Euler's
;; totient function.
(fn [z] (count (filter #(= 1 ((fn f [x y] (if (= 0 x) y (f (mod y x) x))) % z)) (range z 0 -1))))

;; Problem 77. Anagram Finder
;; Write a function which finds all the anagrams in a vector of words. A word x is an anagram of word y if all the letters in x can be
;; rearranged in a different order to form y. Your function should return a set of sets, where each sub-set is a group of words which
;; are anagrams of each other. Each sub-set should have at least two words. Words without any anagrams should not be included in the
;; result.
#(set (map set (filter next (vals (group-by set %)))))

;; Problem 78. Reimplement Trampoline
;; Reimplement the function described in "Intro to Trampoline".
;; Special Restrictions: trampoline
#(if (fn? %) (recur (apply % %&) ()) %)

;; Problem 80. Perfect Numbers
;; A number is "perfect" if the sum of its divisors equal the number itself. 6 is a perfect number because 1+2+3=6. Write a function
;; which returns true for perfect numbers and false otherwise.
(fn [x] (= x (apply + (filter #(= 0 (rem x %)) (range 1 x)))))

;; Problem 85. Power Set
;; Write a function which generates the power set of a given set. The power set of a set x is the set of all subsets of x, including
;; the empty set and x itself.
reduce (fn [y z] (into y (map #(conj % z) y))) #{#{}}

;; Problem 86. Happy numbers
;; Happy numbers are positive integers that follow a particular formula: take each individual digit, square it, and then sum the
;; squares to get a new number. Repeat with the new number and eventually, you might get to a number whose squared sum is 1. This is a
;; happy number. An unhappy number (or sad number) is one that loops endlessly. Write a function that determines if a number is happy
;; or not.
(fn [x] (= 1 (nth (iterate #(reduce (fn [y z] (+ y (let [t (- (int z) 48)] (* t t)))) 0 (str %)) x) 10)))

;; Problem 98. Equivalence Classes
;; A function f defined on a domain D induces an equivalence relation on D, as follows: a is equivalent to b with respect to f if and
;; only if (f a) is equal to (f b). Write a function with arguments f and D that computes the equivalence classes of D with respect to
;; f.
#(set (map set (vals (group-by % %2))))

;; Problem 102. intoCamelCase
;; When working with java, you often need to create an object with fieldsLikeThis, but you'd rather work with a hashmap that has
;; :keys-like-this until it's time to convert. Write a function which takes lower-case hyphen-separated strings and converts them to
;; camel-case strings.
#(clojure.string/replace % #"-." (fn [[_ x]] (format "%S" x)))

;; Problem 103. Generating k-combinations
;; Given a sequence S consisting of n elements generate all k-combinations of S, i. e. generate all possible sets consisting of k
;; distinct elements taken from S. The number of k-combinations for a sequence is equal to the binomial coefficient.
(fn [n s] 
    (set (nth (iterate #(for [y % x y] 
                          (disj y x)) [s]) 
              (Math/abs (- (count s) n)))))

;; Problem 108. Lazy Searching
;; Given any number of sequences, each sorted from smallest to largest, find the smallest single number which appears in all of the
;; sequences. The sequences may be infinite, so be careful to search lazily.
(fn [f & r]
    (some (fn [e]
            (if (every?
                  (fn [c] (= e (some #(if (>= % e) %) c)))
                  r)
              e)
            )
          f))

;; Problem 114. Global take-while
;; Write a function which accepts an integer n, a predicate p, and a sequence. It should return a lazy sequence of items in the list up
;; to, but not including, the nth item that satisfies the predicate.
(fn [n p s] 
    (take (.indexOf s (nth (filter p s) (- n 1))) s))

;; Problem 115. The Balance of N
;; A balanced number is one whose component digits have the same sum on the left and right halves of the number. Write a function which
;; accepts an integer n, and returns true iff n is balanced.
#(let [y (map int (str %)) z (/ (count y) 2)] (= (apply + (drop z y)) (apply + (drop-last z y))))

;; Problem 116. Prime Sandwich
;; A balanced prime is a prime number which is also the mean of the primes directly before and after it in the sequence of ;; valid primes. Create a function which takes an integer n, and returns true iff it is a balanced prime.
(fn [x] (letfn [(c [y] (reduce #(and % %2) (< 1 y) (map #(not= 0 (mod y %)) (range 2 y))))]
          (and (c x) 
               (loop [u (- x 1) v (+ 1 x)]
                 (if (and (c u) (c v))
                   true
                   (if (c v)
                     (c u)
                     (recur (dec u) (inc v))
                     )
                   )
                 )
               )
          )
  )
  
;; Problem 132. Insert between two items
;; Write a function that takes a two-argument predicate, a value, and a collection; and returns a new collection where the value is inserted between every two items that satisfy the predicate.
#(apply concat
        (take 1 %3)
        (for [[a b] (partition 2 1 %3)]
          (if (% a b)
            [%2 b]
            [b])))

;; Problem 137. Digits and bases
;; Write a function which returns a sequence of digits of a non-negative number (first argument) in numerical system with an arbitrary
;; base (second argument). Digits should be represented with their integer values, e.g. 15 would be [1 5] in base 10, [1 1 1 1] in base
;; 2 and [15] in base 16. 
(fn f [n b] (if (< n b) [n] (conj (f (quot n b) b)(mod n b) )))

;; Problem 148. The Big Divide
;; Write a function which calculates the sum of all natural numbers under n (first argument) which are evenly divisible by at least one
;; of a and b (second and third argument). Numbers a and b are guaranteed to be coprimes.
;; Note: Some test cases have a very large n, so the most obvious solution will exceed the time limit.
#(- (+ (% %2 %3) (% %2 %4)) (% %2 (* %3 %4)))
#(* %2 1/2 (quot (- % 1) %2) (+ (quot (- % 1) %2) 1))
