Name: Shreeman Gautam

Chocolate Bar Problem:

Representative Test Cases From Brute Force Method[I was not able to make a DP
solution for this one]:

Input = The csv file provided in the question

Input Matrix:
1101
0001
0001
0001
0011
0011

Output[Generated in the OutputChocolateBF.txt file, order changed.]

4
(1,0,5,2)
(0,0,1,2)
(4,2,2,1)
(0,2,4,1)
(0,3,6,1)

The csv file is read and the chocolate is put into a matrix. In the method 
'matrixWork' a linkedlist called solutionBar is made and since it is call by
reference, it is free to be manipulated in the bars method and at the end of
the bars method, it adds the required pieces into the linkedlist. The method
bars also returns the number of breaks required to break the given chocolate.
At the end of the matrixWork method, solutionBar and number of breaks are sent
to be written into the file.

Now with this out of the way, we proceed in breaking the chocolate matrix by row 
and column in the method bars, as stated in the question. Any chocolate bar is 
broken by row and column in every way possible and the pieces that were broken 
off are broken further and further until we find pieces only compromising of 1s 
or 0s, which is a correct matrix. However, there are a lot of 'correct matrices' 
and the if statement in both the for loops of the bars method ensure that we
get the desired breaks possible, that is, the R,C,H,W asked by the question. In
the end, we get all the desired tuples and we will print it out.

Time Complexity: SInce there are O(m^2 * n^2) subproblems and each subropblem has
O(m * n) possibilites, I think that the running time may be O(m^3 * n^3). Since
an array can be broken down to 1 piece in the worst case, I'll say that the time
complexity os O(m * n).




Parentheses Problem:

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
