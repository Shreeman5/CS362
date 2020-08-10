Name: Shreeman Gautam
File: Chocolate Bar Problem

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