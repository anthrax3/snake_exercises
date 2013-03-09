---
layout: exercises
title: Exercise 8
---

## Exercise 8 - Collections

**Goal**: Refactor the game to replace all arrays with ArrayList

**Description**: In this exercise, we will refactor the Snake Game and replace all fixed basic arrays with ArrayLists.

### Instructions

1. Locate the instances of an array in your application (i.e xSnakePos)
2. Replace the basic array with an ArrayList 
3. Fix usage of the array to conform to ArrayList methods (use `.get`, `.add`)

### Hint:

You can instantiate an ArrayList with predefined values with:

    ArrayList<Integer> xPos = new ArrayList<Integer>(Arrays.asList(1,2,3,4,5));
    // creates an ArrayList with values: [1, 2, 3, 4, 5]
