;; gorilla-repl.fileformat = 1

;; **
;;; # Clojure Presentation Track
;;; 
;;; ## Intro
;;; 
;;; Hello Everybody,
;;; 
;;; my name is Simone Mosciatti, I am Italian and I am going to introduce Clojure and functional programming.
;;; 
;;; I do have a weird accent, so if you cannot understand what I am saying please just raise your hand.
;;; 
;;; Let me ask you first:
;;; 
;;; **Who know clojure ?** _few hands expected_
;;; 
;;; **Who know functional programming ?** _slightly more hands_
;;; 
;;; Thank you.
;;; 
;;; ## Clojure intro
;;; 
;;; Clojure is a Lisp dialect that run on the JVM, it is been invented by Rich Hickey.
;;; 
;;; `Lisp => LISt Processor`
;;; 
;;; Is definitely more than fast enough for most application, with clojure is extremely simple to write parallel application, it is used to write data intensive application.
;;; 
;;; Actually it is used at Netflix, Amazon, TwoSigma (financial), CircleCI (Continuos Integration aaS), Factual (Big Data, they have also an office in Shanghai), Citi, Deutsche Bank, Climate Corporation, MixRadio (the music in your windows phone), pretty much everywhere.  
;;; 
;;; Clojure is a very productive language, you need to write few line of code to express the same logic behind an application. (Usually is a good thing, but dense code can bring a lot of disadvantages.)
;;; 
;;; Actually is a good fit for most task, I won't write a micro controller in clojure though.
;;; 
;;; 
;;; ## What clojure looks like ?
;;; 
;;; 
;; **

;; @@
(def one-to-ten (range 1 (inc 10))) ;; a variable
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-var'>#&#x27;user/one-to-ten</span>","value":"#'user/one-to-ten"}
;; <=

;; @@
(defn multiply-by-two [num] ;; a function
  (* num 2))

;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-var'>#&#x27;user/multiply-by-two</span>","value":"#'user/multiply-by-two"}
;; <=

;; @@
(map multiply-by-two (range 1 (inc 10))) ;; an expression
;; (2 4 6 8 10 12 14 16 18 20) this is a comment

;; @@
;; =>
;;; {"type":"list-like","open":"<span class='clj-lazy-seq'>(</span>","close":"<span class='clj-lazy-seq'>)</span>","separator":" ","items":[{"type":"html","content":"<span class='clj-long'>2</span>","value":"2"},{"type":"html","content":"<span class='clj-long'>4</span>","value":"4"},{"type":"html","content":"<span class='clj-long'>6</span>","value":"6"},{"type":"html","content":"<span class='clj-long'>8</span>","value":"8"},{"type":"html","content":"<span class='clj-long'>10</span>","value":"10"},{"type":"html","content":"<span class='clj-long'>12</span>","value":"12"},{"type":"html","content":"<span class='clj-long'>14</span>","value":"14"},{"type":"html","content":"<span class='clj-long'>16</span>","value":"16"},{"type":"html","content":"<span class='clj-long'>18</span>","value":"18"},{"type":"html","content":"<span class='clj-long'>20</span>","value":"20"}],"value":"(2 4 6 8 10 12 14 16 18 20)"}
;; <=

;; **
;;; Ok, it is different from what you usually see but it is an extremely simple concept.
;;; 
;;; The first thing after the bracket is a function, all the other things are arguments for such function, of course, argument to a function can be other function call.
;;; 
;;; That it's.
;;; 
;;; ## Some simple example
;;; 
;; **

;; **
;;; 
;;; ### Simple Math
;;; 
;;; Let's try to make some math...
;;; 
;; **

;; @@
(+ 41 1) ;; 41 + 1
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-long'>42</span>","value":"42"}
;; <=

;; @@
(* 21 2) ;; 21 * 2
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-long'>42</span>","value":"42"}
;; <=

;; @@
(/ 4 2)
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-long'>2</span>","value":"2"}
;; <=

;; @@
(/ 4 3)
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-ratio'>4/3</span>","value":"4/3"}
;; <=

;; @@
(* (/ 4 3) (/ 5 3))
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-ratio'>20/9</span>","value":"20/9"}
;; <=

;; @@
(float 4/3)
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-unkown'>1.3333334</span>","value":"1.3333334"}
;; <=

;; @@
(Math/sqrt 16)
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-double'>4.0</span>","value":"4.0"}
;; <=

;; **
;;; Ok the math works.
;;; 
;;; If you have paid attention you are wondering about the square root...
;;; 
;;; `Math/sqrt` actually is java call, clojure is completely interopatible with the host platform, that usually is Java.
;;; 
;;; This means that you can use any Java library and actually is pretty common. (Usually it is a good idea to write a thin layer to wrap the Java library but it is not required.)
;;; 
;;; ### Datatype
;;; 
;;; We have pretty much any datatype you would expect.
;;; 
;;; #### Fundamental
;;; 
;; **

;; @@
(def string "normal string")
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-var'>#&#x27;user/string</span>","value":"#'user/string"}
;; <=

;; @@
(def number 42) ;; and float and rations
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-var'>#&#x27;user/number</span>","value":"#'user/number"}
;; <=

;; @@
(def single-key :key) ;; please ask, it is just a type of string
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-var'>#&#x27;user/single-key</span>","value":"#'user/single-key"}
;; <=

;; **
;;; 
;;; #### Sequential
;;; 
;;; Sequential stuff such list and vector.
;; **

;; @@
(def primes-vector [1 2 3 5 7 11]) ;; extremely fast
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-var'>#&#x27;user/primes-vector</span>","value":"#'user/primes-vector"}
;; <=

;; @@
primes-vector
;; @@
;; =>
;;; {"type":"list-like","open":"<span class='clj-vector'>[</span>","close":"<span class='clj-vector'>]</span>","separator":" ","items":[{"type":"html","content":"<span class='clj-long'>1</span>","value":"1"},{"type":"html","content":"<span class='clj-long'>2</span>","value":"2"},{"type":"html","content":"<span class='clj-long'>3</span>","value":"3"},{"type":"html","content":"<span class='clj-long'>5</span>","value":"5"},{"type":"html","content":"<span class='clj-long'>7</span>","value":"7"},{"type":"html","content":"<span class='clj-long'>11</span>","value":"11"}],"value":"[1 2 3 5 7 11]"}
;; <=

;; **
;;; Vector are extremelly fast, especially if you have a lot of elements in it, for extremelly fast I mean that the lookup will run in `LOG32(N)`
;; **

;; @@
(def string-list '("a" "b" 2)) ;; why the hypes ???
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-var'>#&#x27;user/string-list</span>","value":"#'user/string-list"}
;; <=

;; **
;;; Faster than vector if you have few elements
;; **

;; @@
string-list
;; @@
;; =>
;;; {"type":"list-like","open":"<span class='clj-list'>(</span>","close":"<span class='clj-list'>)</span>","separator":" ","items":[{"type":"html","content":"<span class='clj-string'>&quot;a&quot;</span>","value":"\"a\""},{"type":"html","content":"<span class='clj-string'>&quot;b&quot;</span>","value":"\"b\""},{"type":"html","content":"<span class='clj-long'>2</span>","value":"2"}],"value":"(\"a\" \"b\" 2)"}
;; <=

;; **
;;; 
;;; Those sequential element can contains anything.
;;; 
;;; #### Tables and Sets
;;; 
;;; This is an hash table, called `maps` in clojure, are extremely fast, extremelly easy to manipulate and are a good fit for a lot of problems.
;;; 	
;; **

;; @@
(def my-self
    {:name "Simone Mosciatti"
     :age 20
     :work "Freelance Developer"
     :girlfriend "Extremely far from HERE :-("})

;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-var'>#&#x27;user/my-self</span>","value":"#'user/my-self"}
;; <=

;; **
;;; We also have simple mathematical sets, again extremely fast.
;;; 
;; **

;; @@
(clojure.set/union #{1 2 3} #{3 4 5}) ;; ??? namespace

;; @@
;; =>
;;; {"type":"list-like","open":"<span class='clj-set'>#{</span>","close":"<span class='clj-set'>}</span>","separator":" ","items":[{"type":"html","content":"<span class='clj-long'>1</span>","value":"1"},{"type":"html","content":"<span class='clj-long'>4</span>","value":"4"},{"type":"html","content":"<span class='clj-long'>3</span>","value":"3"},{"type":"html","content":"<span class='clj-long'>2</span>","value":"2"},{"type":"html","content":"<span class='clj-long'>5</span>","value":"5"}],"value":"#{1 4 3 2 5}"}
;; <=

;; **
;;; ### Control flow
;;; 
;;; There are a lot of way to control the logical flow in clojure, let me show the simplest.
;;; 
;; **

;; @@
(if (= (+ 41 1) (* 21 2))
	:ok
	:ahhh-the-world-is-ending)
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-keyword'>:ok</span>","value":":ok"}
;; <=

;; **
;;; `if` takes three expression, if the first expression is true the second expresion is evaluate, otherwise the third expresion get evaluate.
;; **

;; @@
(case (second "abc")
	\b "This is a b"
	\a "We got an a"
	"Something else")
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-string'>&quot;This is a b&quot;</span>","value":"\"This is a b\""}
;; <=

;; **
;;; 
;;; ## Function
;;; 
;;; ### Simple function
;;; 
;; **

;; @@
(defn name-of-the-function
	"The documentation string for the function"
	[the-argument other-argument]
	(+ the-argument other-argument))
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-var'>#&#x27;user/name-of-the-function</span>","value":"#'user/name-of-the-function"}
;; <=

;; @@
(name-of-the-function 3 4)
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-long'>7</span>","value":"7"}
;; <=

;; **
;;; 
;;; Of course the same function will be written as
;;; 
;; **

;; @@
(defn sum-two-number [a b]
	    (+ a b))
(sum-two-number 3 4)
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-long'>7</span>","value":"7"}
;; <=

;; **
;;; Function in idiomatic clojure should be pure and small.
;;; 
;;; A pure function is a function that given the same input, return always the same output, it does not depend on the environment of the system and do not modify the environment.
;; **

;; **
;;; 
;;; ### Anonymous function
;;; 
;; **

;; @@
( (fn [a] (+ 1 a)) 3)
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-long'>4</span>","value":"4"}
;; <=

;; @@
( #(+ 1 % ) 3) ;; shortcut
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-long'>4</span>","value":"4"}
;; <=

;; **
;;; Ananonymous function are extremelly useful, you can pass those to other function or, if save them in a map.
;; **

;; **
;;; 
;;; Function are first order citizen, so they can be passed around like number, and can be returned by other function...
;;; 
;; **

;; @@
(defn add-n [n]
	(fn [a] (+ a n)))

(def add-two (add-n 2))

(add-two 3)

(defn add-five [a]
	(let [add-four (add-n 4)]
	    (add-four (+ a 1))))

(add-five 5)

(defn transform-number [function n]
	(function n))

(transform-number add-five 4)

(transform-number (add-n 6) 4)

(transform-number add-n 4)

( (transform-number add-n 4) 4)
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-long'>8</span>","value":"8"}
;; <=

;; **
;;; ## Immutability and variable
;;; 
;;; So, we have played around with clojure but I have never modified a variable, this because I cannot. (It is not exactly true but lets keep stuff simple...)
;;; 
;;; ### How can we make any useful thing without modify variable ?
;;; 
;;; In clojure, similarly to other functional languages, you usually create a funnel/chain of transformations, you plug your input in, and you get your output out.
;;; 
;;; This "funnel/chain of transformations" is the composition of several functions.
;;; 
;;; This is extremely powerful:
;;; 
;; **

;; @@
(def my-self
    {:name "Simone Mosciatti"
     :age 20
     :work "Freelance Developer"
     :girlfriend "Extremely far from HERE :-("})

(defn split-name [{:keys [name] :as person}]
	(let [[name surname] (clojure.string/split name #" ")]
	  (assoc person :firstname name :lastname surname)))

(defn birthday [{:keys [age] :as person}]
	(update-in person [:age] inc)
;;	(assoc person :age (inc age))
)

(defn find-job [person]
	(assoc person :work "Amazing company"))

(defn meet-girlfriend [person]
	(assoc person :girlfriend "Just next to me :-)"))

(defn perfect [user]
	(birthday (find-job (meet-girlfriend (split-name user)))))

(defn more-idiomatic-perfect [person]
	(-> person split-name birthday find-job meet-girlfriend))

(def perfect-perfect (comp split-name birthday find-job meet-girlfriend))

(perfect-perfect my-self)
;; @@
;; =>
;;; {"type":"list-like","open":"<span class='clj-map'>{</span>","close":"<span class='clj-map'>}</span>","separator":", ","items":[{"type":"list-like","open":"","close":"","separator":" ","items":[{"type":"html","content":"<span class='clj-keyword'>:age</span>","value":":age"},{"type":"html","content":"<span class='clj-long'>21</span>","value":"21"}],"value":"[:age 21]"},{"type":"list-like","open":"","close":"","separator":" ","items":[{"type":"html","content":"<span class='clj-keyword'>:lastname</span>","value":":lastname"},{"type":"html","content":"<span class='clj-string'>&quot;Mosciatti&quot;</span>","value":"\"Mosciatti\""}],"value":"[:lastname \"Mosciatti\"]"},{"type":"list-like","open":"","close":"","separator":" ","items":[{"type":"html","content":"<span class='clj-keyword'>:work</span>","value":":work"},{"type":"html","content":"<span class='clj-string'>&quot;Amazing company&quot;</span>","value":"\"Amazing company\""}],"value":"[:work \"Amazing company\"]"},{"type":"list-like","open":"","close":"","separator":" ","items":[{"type":"html","content":"<span class='clj-keyword'>:name</span>","value":":name"},{"type":"html","content":"<span class='clj-string'>&quot;Simone Mosciatti&quot;</span>","value":"\"Simone Mosciatti\""}],"value":"[:name \"Simone Mosciatti\"]"},{"type":"list-like","open":"","close":"","separator":" ","items":[{"type":"html","content":"<span class='clj-keyword'>:girlfriend</span>","value":":girlfriend"},{"type":"html","content":"<span class='clj-string'>&quot;Just next to me :-)&quot;</span>","value":"\"Just next to me :-)\""}],"value":"[:girlfriend \"Just next to me :-)\"]"},{"type":"list-like","open":"","close":"","separator":" ","items":[{"type":"html","content":"<span class='clj-keyword'>:firstname</span>","value":":firstname"},{"type":"html","content":"<span class='clj-string'>&quot;Simone&quot;</span>","value":"\"Simone\""}],"value":"[:firstname \"Simone\"]"}],"value":"{:age 21, :lastname \"Mosciatti\", :work \"Amazing company\", :name \"Simone Mosciatti\", :girlfriend \"Just next to me :-)\", :firstname \"Simone\"}"}
;; <=

;; **
;;; 
;;; How it this approach useful ?
;;; 
;;; Any function can be tested in isolation, test is extremely simple, and atomic.
;;; 
;;; This approach scale, even with thousand of LOC we are still using pure function that are trivial to test.
;;; 
;;; Small recap: Clojure do not modify variable, it modify, and combine function in such a way to create a funnel/chain, where you plug in your input value and where you get out your output value.
;;; 
;;; Function in idiomatic clojure are simple, small, and pure, are extremely easy to test (maybe even too easy) and to reason about.
;;; 
;;; ## End
;;; 
;;; We have barely scratch the surface, but hopefully I got you interested in Clojuer.
;;; 
;;; Thanks for listening, and if you have any question just let know :)
;;; 
;; **

;; @@

;; @@
