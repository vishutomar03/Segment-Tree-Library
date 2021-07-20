# Segment Tree Library

Segment Tree is a data structures that let you easily find the minimum, maximum, or sum over a given subrange of a larger range.

This repository contains a Java class which implements a general-purpose Segment Tree library that can be used for almost any type of range queries like range sum queries, range minimum queries or any other user defined queries.


To construct a segment tree you need to specify the following:
      
    a) The datatype of array for which the tree is being constructed.

    b) An array for which the tree is to be constructed.

    c) A value that can be used to fill the extra nodes of the tree.

    d) A function combine that specifies how the result of left and right child of a node should be used to generate the value of current node.
