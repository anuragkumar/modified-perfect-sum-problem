# modified-perfect-sum-problem
Code to find the subset of an array whose has the sum equal to a given non-negative integer or closest to but greater than our non-negative integer

# Problem Statement
Consider you have a process which you need to run on certain set of systems. You have a list of systems and the processor cores' count each system has. You know before hand that you will be needing x number of processor cores to run your process. You need to find minimum number of systems which can satisfy the processor cores requirements of your process.

Examples:
# Example 1
Let arr = [1, 2, 3, 4, 5] is an array of systems where index represnt system number and value at index represent number of processor cores that system has.
Let sum = 5 which is the number of processor cores I need to run my process
Possible solutions are:
1. [2, 3]
2. [1, 4]
3. [5]
The best solution is [5] as in this case system with 5 cores can easily run my process which is the minimum system I need.

# Example 2
Let arr = [1,2,3,4]
Let sum = 5
Possible Solutions are:
1. [2, 3]
2. [1, 4]
The best solution can be either of these two.

Let us take an example where we don't have any subset which can satisfy the processor cores requirements. In this case, we will find the next best possible value:
# Example 3
Let arr = [2, 3, 5, 7]
Let sum = 6
Possible solutions are:
1. [5, 2]
2. [5, 3]
3. [7]
.... (more combinations where sum is greater than 6 but close to 6.)
The best solution is [7] as it satisfy the cores requirement as well as it is minimum number of systems I need to run my process.

# Solution
We will use the general perfectSum problem where we find all possible subests of an array where sum of each subset is equal to our target value. 
Link: https://www.geeksforgeeks.org/perfect-sum-problem-print-subsets-given-sum/
We will modify this a little where we can search for perfect sum or closest to the sum but greater.

So normally, we create a 2D array where rows define the index of the array and columns define the sum.
1. In the code provided in link above, we take columns till sum+1. But in our case, we will take columns to the max sum of the array.
2. Then, instead of checking if bottom right value of our 2D array is true/false to determine if a subset exists, we will check from the location dp[n-1][sum] till dp[n-1][max+1] value if we have any true value. If we find any true value in this range, then we have either the perfect sum or closest to it. So, we will search for first true value we can find and start backtracking. If we can't find any true value, that means we don't have any systems which can satisfy our process's needs.
3. While backtracking, we will maintain a check which will hold our subset which has the minimum length. That's our best solution.

Code for backtracking is exactly the same as in the link above except one check where I am calling the funciton to store it in some place if it is best or not.

Try it out for practice.
