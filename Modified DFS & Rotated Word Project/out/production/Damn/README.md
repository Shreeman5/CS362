Description of 'isRotated': 

I think this problem is important because the first time you see it, it is
not going to click that the rotated word, if combined with itself, will 
yield a word that contains the original word. However, I did not use a 
brute force solution for this method because after seeing the problem for
10 minutes, it clicked to me that what I have mentioned above works. I have 
provided several test cases in the code file and additionally added a 
toLowercase method which converts uppercase letters to lowercase letters.
Running time is O(n) because that is what functions 'toLowerCase' and 'contains'
take to complete. Space complexity is O(1) since strings are only used.

Description of ConnectedComponent: 

I start by specifying the number of nodes that the graph will have and make
a neighbor list(using linked list) for all nodes. DFS is then modified 
by starting at node 0 and exploring all the nodes connected to 0. After 
all the connections of 0 and it's neighbors have been exhausted, do DFS at
a node that has not been explored yet, which will be component 2. DO DFS in
component 2 and run the code until all the nodes in the graph have been explored.
Time Complexity is O(m + n) where m is vertices and n is edges in BFS.
Space complexity os O(n^n) because of the formation of adjacency list.
Idea for using adjacency list: 
https://www.geeksforgeeks.org/graph-and-its-representations/
