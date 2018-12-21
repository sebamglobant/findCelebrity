# Find the celebrity
This project is a solution with Stack to solve the code problem **Find the celebrity**.

## Problem
**Description:**
* In a team of *n* people, a celebrity is known by everyone but he/she doesn't know anybody.

## Solution
Suppose there is a matrix that holds the information of who knows who in the team.

      A B C D
    A 0,0,1,0
    B 0,0,1,0
    C 0,0,0,0
    D 0,0,1,0  

We know that A knows C, because [A][C] == 1, and  A doesn't know B because [A][B] == 0.

To solve this problem we are going to make the following observations:

1. If A knows B, we can discard A because A knows al least one members in the team, and B may be is the celebrity.
2. If A doesn't Knows B, we can discard B as celebrity because someone doesn't know B and A may be is the celebrity.

Based on these observations we can add de members IDs into a Stack

```
0 <- top
1
2
3 
```

And start to take 2 of the members and validates if they know each other, and discard one of them.
```
knows(0,1)
  |-> False => 1 is discarded and 0 may be is the celebrity.
  |-> True => 0 is discarded and 1 may be is the celebrity.
```   
So we can add the possible "celebrity" back to the Stack
```
0 <- top
2
3
```
    
We must to repeat this validations untils only remains one id in the Stack.
After those validations and we have only one ID, we have to validate this ID in the matrix and verify if is the celebrity.
    
## How to make it work
This project is a JAVA solution and is build with gradle. So if you want to run it, you can execute the following command at the root project's folder.

    ./gradlew run
    
## testCases.txt file
If you want to add some extra cases, you can add it in the testCases.txt file following this convention of the file:

````
3 /* Number of test cases in this file*/
3 /* Number of members in the team*/
0,0,0 //
0,1,0 // Matrix that represents the information of the team
1,0,0 //
2
0,0
1,0
4
0,0,1,0
0,0,1,0
0,0,0,0
0,0,1,0
```
