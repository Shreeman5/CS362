Name: Shreeman Gautam
File: Parentheses Problem

Representative Test Cases From Brute Force and Dynamic Programming Method:

N = 5
Output[Generated in both the OutputParenthesesBF & OutputParenthesesDP file.
       This is specifically for the OutputParenthesesBF code. The DP code 
       generates the same set of values, order changed.]:

()()()()()
()()()(())
()()(())()
()()(()())
()()((()))
()(())()()
()(())(())
()(()())()
()(()()())
()(()(()))
()((()))()
()((())())
()((()()))
()(((())))
(())()()()
(())()(())
(())(())()
(())(()())
(())((()))
(()())()()
(()())(())
(()()())()
(()()()())
(()()(()))
(()(()))()
(()(())())
(()(()()))
(()((())))
((()))()()
((()))(())
((())())()
((())()())
((())(()))
((()()))()
((()())())
((()()()))
((()(())))
(((())))()
(((()))())
(((())()))
(((()())))
((((()))))

Brute Force Method: As you can see from the brute force code, it employs a bunch
of recursion trees to find strings for n. Let's say for n = 2, the first string 
is printed as ()() but after the first tree of recursion ends, the stacks go back
to the first ')' and from there, the second string is printed as (()). With
bigger n values, the trees keep going back and employ even more branches of
recursion. For n = 3, there are 5 branches of recursion and for n = 4, there are
14 branches of recursion. Obviously, this is not a very efficient method because
for bigger n values, branches will increase at an exponential rate. However, 
behind this recursive tree mess, there is a slimmer of logic behind the if 
statements in the 'parenthesesSets' method.
 
The first if statement in the else statement checks for number of closeBrackets 
vs openBrackets. At the start of the method, this if statement does not work 
since closeBracket = openBracket and as a result, the second if statement 
proceeds, giving us the first '('. Then we will go through the method and find 
that ()()() is printed(assume n = 3). Notice that after the stack returns back 
to the first if statement at any point in time, a new tree will be made from 
the second if statement. This is how we get various strings. The arching logic 
here being that if openBracket beats the number of closeBracket, a closing 
bracket is put and the remaining brackets are recursivley called. If openBracket 
is less than n, an opening bracket is placed and the remaining brackets are 
called recursively. 

Dynamic Programming Method: This one is way easier to explain and won't be like
the recursive mess it was before because dynamic programming is used. In the
method parentheses sets, in the first for loop, variable oneString corresponds 
to a recursive call of parenthesesSets(n - 1) which clues us to the fact of why
a n == 1 is used as a base case. n = 2 builds from the things returned by
n = 1 and n = 3 builds from the things returned by n = 2. This way avoids all
the recursive tree loops that the brute force method used and easily crafts 
strings for a specific n number. The meoization part in this dynamic solution
comes from the use of the Set of Strings, which is the variable memoizationSet
in the method. This variable serves two purposes: store all the string combinations
for a n value and if any string is duplicated in the second for loop, add it 
anyway but not show it in the solution because a set is defined by unique objects
in it. 

Time and space complexity of Brute Force Parentheses Problem:
For 2 ^(2n) sequences that is generated in the code, we need to print each valid 
sequence which takes O(n) time, giving a run time of O(n * (2 ^(2n))). Now, we
also know that the stack goes as deep as (2 ^ (2n)), giving us a space complexity
of (2 ^ (2n)).

Time and space complexity of Dynamic Programming Parentheses Problem:
For 2 ^(2n) sequences that is generated in the code, we are using previous n values
to generate the n value that we are given. My dynamic programming code is faster
so I would guess that 2 ^ (2n) = 4^n is divided by an n value[which I am not too sure about]
Maybe 4^n/n is my guess but I could be wrong. I would say the same for the space
time as well: 4^n/n.
