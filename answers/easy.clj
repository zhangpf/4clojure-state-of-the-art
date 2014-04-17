;; The shortest and amazing solutions collection to 4clojure.com
;; Pengfei Zhang
;; Easy level

;; Problem 18
;; The filter function takes two arguments: a predicate function (f) and a sequence (s). Filter returns a new sequence consisting of
;; all the items of s for which (f item) returns true.
[6 7]

;; Problem 19
;; Write a function which returns the last element in a sequence.
;; daowen's solution
reduce #(-> %2)
;; grdvnl's solution
#(peek (vec %))

;; Problem 20
;; Write a function which returns the second to last element from a sequence.
;; 0x89's solution
(comp peek pop vec)

;; Problem 21
;; Write a function which returns the Nth element from a sequence.
;; gtss's solution
.get

;; Problem 22
;; Write a function which returns the total number of elements in a sequence.
#(-> % seq .size)

;; Problem 23
;; Write a function which reverses a sequence.
;; leetwinski's solution
into ()

;; Problem 24
;; Write a function which returns the sum of a sequence of numbers.
apply +

;; Problem 25
;; Write a function which returns only the odd numbers from a sequence.
filter odd?

;; Problem 26
;; Write a function which returns the first X fibonacci numbers.
;; megaterik's solution
#(take % ((fn f [a b] (lazy-cat [a] (f (+ a b) a))) 1 0))

;; Problem 27
;; Write a function which returns true if the given sequence is a palindrome.
#(= (reverse %) (seq %))

