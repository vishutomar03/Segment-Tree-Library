<h1>Segment Tree</h1>

Segment Tree is a data structures that let you easily find the minimum, maximum, or sum over a given subrange of a larger range.

<h1> About </h1>
This repository contains a Java class which implements a general-purpose Segment Tree library that can be used for almost any type of range queries like range sum queries, range minimum queries or any other user defined queries.

<h1> Requirements</h1>

To use this Segment Tree Library you need to specify the following:

- The datatype of array for which the Segment Tree is being constructed
- An array for which the tree is to be constructed
- A neutral value that can be used to fill the extra nodes of the tree
- A function 'combine' that specifies how the result of left and right child of a node should be used to generate the value of parent node
