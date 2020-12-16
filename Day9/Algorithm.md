### Problem Statment :<br>
<b><i>This problem was asked by Facebook.</b></i>
 
Suppose you are given two lists of n points, one list p1, p2, ...,
pn on the line y = 0 and the other list q1, q2, ..., qn on the line y = 1.
Imagine a set of n line segments connecting each point pi to qi.
Write an algorithm to determine how many pairs of the line segments intersect.

#### Algorithm :
1. Method count_pairs() takes two arrays as input that represent cordinates of x at y=0 
   and y=1 . It returns Intersecting pairs .
2. First loop traverses coordinates of x (y0,y1) at y=0 and y=1
3. Second loop traverses both y0 and y1 again to compare every element in y0[] and y1[]
4. When point (y0[i],0) of line 1 is before point (y0[j],0) of line 2 and 
point (y1[i],1) of line 1 is after point (y1[j],1) of line 2 or vice-versa ,they will intersect.

Example- point (3,0) of line 1 is before point (4,0) of line 2 and
point (5,1) of line 1 is after point (2,1) of line 2,
they will surely intersect.
<br><br>
[![Day9.png](https://i.postimg.cc/jS3fbB6D/Day9.png)](https://postimg.cc/XrFqKHzW)
