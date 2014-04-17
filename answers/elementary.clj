;; The shortest and amazing solutions collection to 4clojure.com
;; Pengfei Zhang
;; Elementary level

;; Problem 1
;; This is a clojure form. Enter a value which will make the form evaluate to true. Don't over think it!
true

;; Problem 2
;; Enter only enough to fill in the blank (in this case, a single number) - do not retype the whole problem
4

;; Problem 3
;; Clojure strings are Java strings. This means that you can use any of the Java string methods on Clojure strings.
"HELLO WORLD"

;; Problem 4
;; Lists can be constructed with either a function or a quoted form.
:a :b :c

;; Problem 5
;; When operating on a list, the conj function will return a new list with one or more items "added" to the front.
[1 2 3 4]

;; Problem 6
;; Vectors can be constructed several ways. You can compare them with lists.
:a :b :c

;; Problem 7
;; When operating on a Vector, the conj function will return a new vector with one or more items "added" to the end.
[1 2 3 4]

;; Problem 8
;; Sets are collections of unique values.
#{:a :b :c :d}

;; Problem 9
;; When operating on a set, the conj function returns a new set with one or more keys "added".
2

;; Problem 10
;; Maps store key-value pairs. Both maps and keywords can be used as lookup functions. Commas can be used to make maps more readable,
;; but they are not required.
20

;; Problem 11
;; When operating on a map, the conj function returns a new map with one or more key-value pairs "added".
[:b 2]

;; Problem 12
;; All Clojure collections support sequencing. You can operate on sequences with functions like first, second, and last.
3

;; Problem 13
;; The rest function will return all the items of a sequence except the first.
[20 30 40]

;; Problem 14
;; Clojure has many different ways to create functions.
8

;; Problem 15
;; Write a function which doubles a number.
* 2

;; Problem 16
;; Write a function which returns a personalized greeting.
format "Hello, %s!"

;; Problem 17
;; The map function takes two arguments: a function (f) and a sequence (s). Map returns a new sequence consisting of the result of
;; applying f to each item of s. Do not confuse the map function with the map data structure.
[6 7 8]

;; Problem 35
;; Clojure lets you give local names to values using the special let-form.
7

;; Problem 36
;; Can you bind x, y, and z so that these are all true?
[x 7 z 1 y 3]

;; Problem 37
;; Regex patterns are supported with a special reader macro.
"ABC"

;; Problem 57
;; A recursive function is a function which calls itself. This is one of the fundamental techniques used in functional programming.
(range 5 0 -1)

;; Problem 64
;; Reduce takes a 2 argument function and an optional starting value. It then applies the function to the first 2 items in the sequence
;; (or the starting value and the first element of the sequence). In the next iteration the function will be called on the previous
;; return value and the next item from the sequence, thus reducing the entire collection to one value. Don't worry, it's not as
;; complicated as it sounds.
+

;; Problem 68
;; Clojure only has one non-stack-consuming looping construct: recur. Either a function or a loop can be used as the recursion point.
;; Either way, recur rebinds the bindings of the recursion point to the values it is passed. Recur must be called from the
;; tail-position, and calling it elsewhere will result in an error.
[7 6 5 4 3]

;; Problem 71
;; The -> macro threads an expression x through a variable number of forms. First, x is inserted as the second item in the first form,
;; making a list of it if it is not a list already. Then the first form is inserted as the second item in the second form, making a
;; list of that form if necessary. This process continues for all the forms. Using -> can sometimes make your code more readable.
last

;; Problem 72
;; The ->> macro threads an expression x through a variable number of forms. First, x is inserted as the last item in the first form,
;; making a list of it if it is not a list already. Then the first form is inserted as the last item in the second form, making a list
;; of that form if necessary. This process continues for all the forms. Using ->> can sometimes make your code more readable.
apply +

;; Problem 134
;; Write a function which, given a key and map, returns true iff the map contains an entry with that key and its value is nil.
#(not (%2 % 1))

;; Problem 145
;; Clojure's for macro is a tremendously versatile mechanism for producing a sequence based on some other sequence(s). It can take some
;; time to understand how to use it properly, but that investment will be paid back with clear, concise sequence-wrangling later. With
;; that in mind, read over these for expressions and try to see how each of them produces the same result.
(range 1 40 4)

;; Problem 156
;; Write a function which takes a default value and a sequence of keys and constructs a map.
#(zipmap %2 (repeat %))

;; Problem 161
;; Set A is a subset of set B, or equivalently B is a superset of A, if A is "contained" inside B. A and B may coincide.
#{1 2}

;; Problem 162
;; In Clojure, only nil and false represent the values of logical falsity in conditional tests - anything else is logical truth.
1

