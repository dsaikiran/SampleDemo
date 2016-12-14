### A sample spring boot application 

### Overview
provides solution for knapsack problem with dynamic programming approach.

### Maven build 
```
cd /SampleDemo
mvn clean install
```
### Start application
```
cd /SampleDemo
java -jar target/demo-0.0.1-SNAPSHOT.jar
```
### Problem
 Gordon Ramsey, a very smart guy, like seating food. Now, Gordon is at a restaurant and he has many different types of food to choose from. Gordon gets x amount of satisfaction and requires y amount of time to eat an item from the menu. Given t minutes, write a java program that reads the text file and ﬁnds out the maximum satisfaction that Gordon can get from eating at the restaurant. You will be given a text file with the following format:
 [t][Number of items on menu]
[amount of satisfaction from eating dish 1][time taken for dish 1]
[amount of satisfaction from dish 2][time taken for dish 2]

### Solution
* Get the total number of items.
* Create a matrix. Items are in rows and weight at in columns +1 on each side
* If the knapsack's capacity is 0 - Set all columns at row 0 to be 0
* Fill the first row with 0
* Let's fill the values row by row
* Check the current items weight less than or equal to running weight
* Given a weight, check if the value of the current item + value of the item that we could afford with the remaining weight
  is greater than the value without the current item itself
* If the current item's weight is more than the running weight, just carry forward the value without the current item

### Reference link
Knapsack Problem Dynamic Programming: https://www.youtube.com/watch?v=8LusJS5-AGo
