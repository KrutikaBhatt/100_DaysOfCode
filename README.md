# 100 Days of Code

### Day 1 :<br>
<i><b>This problem was recently asked by Google.</i></b><br>
Given a list of numbers and a number k, return whether any two numbers from the list add up to k.
For example, given [10, 15, 3, 7] and k of 17, return true since 10 + 7 is 17.<br>
There are two solutions provided- the Method 1 was naive method and Method 2 was more efficient method<br>
<a href = "https://github.com/KrutikaBhatt/100_DaysOfCode/blob/master/Day1/Day1_method2.java">Solution</a>

### Day 2 :<br>
 The <i><b>Sieve of Eratosthenes </b></i>is an algorithm used to generate all prime numbers smaller than N.
   The method is to take increasingly larger prime numbers, and mark their multiples as composite.
   For example, to find all primes less than 100, we would first mark [4, 6, 8, ...] (multiples of two),
   then [6, 9, 12, ...] (multiples of three), and so on. Once we have done this for all primes less than N,
   the unmarked numbers that remain will be prime.
   Implement this algorithm.<br>
   <a href = "https://github.com/KrutikaBhatt/100_DaysOfCode/blob/master/Day2/Day2.java">Solution</a>
   
### Day 3:<br>
<b><i>This problem was asked by Spotify.</b></i><br>
There are N couples sitting in a row of length 2 * N. They are currently ordered randomly,
   but would like to rearrange themselves so that each couple's partners can sit side by side.
   What is the minimum number of swaps necessary for this to happen?
   <br>
   <a href = "https://github.com/KrutikaBhatt/100_DaysOfCode/blob/master/Day3.java">Solution</a>
   
### Day 4 :<br>
<b><i>This problem was asked by Uber.</i></b><br>
Given an array of integers, return a new array such that each element at index i of the new array is the product of all the numbers in the original array except the one at i.<br>
For example, if our input was [1, 2, 3, 4, 5], the expected output would be [120, 60, 40, 30, 24]. If our input was [3, 2, 1], the expected output would be [2, 3, 6].
Follow-up: what if you can't use division?<br>
 <a href = "https://github.com/KrutikaBhatt/100_DaysOfCode/blob/master/Day4.java">Solution</a>
 
### Day 5 :<br>
<b><i>This problem was asked by Google.</b></i><br>
Given the root to a binary tree, implement serialize(root), which serializes the tree into a string, 
and deserialize(s), which deserializes the string back into the tree.
<br>
<a href ="https://github.com/KrutikaBhatt/100_DaysOfCode/blob/master/Day5.py">Solution</a>

#### Day 6 :<br>
<b><i>This problem was asked by Stripe.</b></i><br>
Given an array of integers, find the first missing positive integer in linear time and constant space. In other words, find the lowest positive integer that does not exist in the array.
The array can contain duplicates and negative numbers as well.
For example, the input [3, 4, -1, 1] should give 2. The input [1, 2, 0] should give 3.
You can modify the input array in-place.
<br>
<a href="https://github.com/KrutikaBhatt/100_DaysOfCode/blob/master/Day6.java">Solution</a><br>
#### Day 7:<br>
Given a string with repeated characters, rearrange the string so that no two adjacent characters are the same.
If this is not possible, return None.For example, given "aaabbc", you could return "ababac". Given "aaab", return None.
<a href="https://github.com/KrutikaBhatt/100_DaysOfCode/blob/master/Day7.java">Solution</a>
#### Day 8:<br>
<b><i>This problem was asked by Google.</b></i><br>
An XOR linked list is a more memory efficient doubly linked list. 
Instead of each node holding next and prev fields, it holds a field named both, which is an XOR of the next node and the previous node. 
Implement an XOR linked list; it has an add(element) which adds the element to the end, and a get(index) which returns the node at index.<br>
If using a language that has no pointers (such as Python), you can assume you have access to get_pointer and dereference_pointer functions that converts between nodes and memory addresses. <br>
![#f03c15](https://via.placeholder.com/15/f03c15/000000?text=+) `Do read the glimpse file which explains certain important concepts related to it`
<br>
Solution :<br><a href="https://github.com/KrutikaBhatt/100_DaysOfCode/blob/master/Day8/Day8_Python.py"> In Python</a> and <a href="https://github.com/KrutikaBhatt/100_DaysOfCode/blob/master/Day8/Day8.cpp"> In C++</a>

#### Day 9 :<br>
<b><i>This problem was asked by Facebook.</b></i>
 
Suppose you are given two lists of n points, one list p1, p2, ...,
pn on the line y = 0 and the other list q1, q2, ..., qn on the line y = 1.
Imagine a set of n line segments connecting each point pi to qi.
Write an algorithm to determine how many pairs of the line segments intersect.
<br><a href ="https://github.com/KrutikaBhatt/100_DaysOfCode/blob/master/Day9/Day9.java">Solution</a>
#### Day 10 :<br>
<b><i>This problem was asked by Facebook.</b></i>

Given the mapping a = 1, b = 2, ... z = 26, and an encoded message, count the number of ways it can be decoded.
For example, the message '111' would give 3, since it could be decoded as 'aaa', 'ka', and 'ak'.
You can assume that the messages are decodable. For example, '001' is not allowed.
<br><a href ="https://github.com/KrutikaBhatt/100_DaysOfCode/blob/master/Day10/Day10.java">Solution </a>

#### Day 11 :<br>
 Write an algorithm that computes the reversal of a directed graph.
For example, if a graph consists of A -> B -> C, it should become <br>A <- B <- C.<br>
<a href = "https://github.com/KrutikaBhatt/100_DaysOfCode/blob/master/Day11/Graph_Reversal.java">Solution</a>

#### Day 12 :<br>
<b><i>This problem was asked by Google.</b></i><br>

A unival tree (which stands for "universal value") is a tree where all nodes under it have the same value.
Given the root to a binary tree, count the number of unival subtrees.<br>
<a href ="https://github.com/KrutikaBhatt/100_DaysOfCode/blob/master/Day12.java">Solution</a>
#### Day 13:<br>
Given an array of elements, return the length of the longest subarray where all its elements are distinct.
For example, given the array [5, 1, 3, 5, 2, 3, 4, 1], return 5 as the longest subarray of distinct elements is [5, 2, 3, 4, 1].<br>
[Solution](Day13.java)

#### Day 14 :<br>
This problem was asked by Uber.
Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
Find the minimum element in O(log N) time. You may assume the array does not contain duplicates.
or example, given [5, 7, 10, 3, 4], return 3.<br>
[Solution](Day14.java)

#### Day 15 :<br>
This problem was asked by Amazon.

There exists a staircase with N steps, and you can climb up either 1 or 2 steps at a time. Given N, write a function that returns the number of unique ways you can climb the staircase.
The order of the steps matters.<br>
[Solution](Day15.java)
#### Day 16 :<br>
This problem was asked by Google.
 Given the head of a singly linked list, swap every two nodes and return its head.
 For example, given 1 -> 2 -> 3 -> 4, return 2 -> 1 -> 4 -> 3
 <br>[Solution](Day16.java)
