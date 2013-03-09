---
layout: exercises
title: Exercise 2
---

## Exercise 2 - Variables

**Goal**: Practice defining and using variables and simple array.

**Description**: In this exercise, we will draw a snake that is 4 squares long.

### Instructions 

1. Open `GameExercises.java` file
2. Modify the method `redrawCanvas` to draw a green snake
   - To draw the snake, draw 4 green squares next to each other
   - Position the squares vertically such that the snake is pointed up.
3. Change the snake width
   - Instead of modifying the width everywhere, create a variable called `snakeWidth`.
   - Set the `snakeWidth` variable to different values and choose a good width for the snake (i.e 25).
4. Change the snake color
  - Instead of setting the color manually each time, create a variable called `snakeColor`.
  - Replace every instance of `Color.GREEN` with `snakeColor` in your drawing code
5. Store the snake in an array
  - Create two integer arrays `int[] x, int[] y` to store the coordinates of the squares that form the snake.
  - Refactor the snake drawing code so that it uses the array to get the snake coordinates.   
