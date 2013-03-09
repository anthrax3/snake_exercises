---
layout: exercises
title: Exercise 3
---

## Exercise 3 - Methods

**Goal**: Define methods to break up the code into smaller, more readable parts,
use global variables, and animate the snake.

**Description**: In this exercise, we will refactor the drawing code into methods
and create a method to move the snake.

### Instructions

1. Open `GameExercises.java` file
2. Create methods called `drawSnake`, `drawApple`, and `drawLabel`.
3. Move the drawing code from `redrawCanvas` into the different
   drawing methods and call the methods from `redrawCanvas`.
4. Create global variables (defined at the class level) for the snake's position called
   `int[] xSnakePos` and `int[] ySnakePos`.
5. Update drawSnake to use the global position variables.
6. Create a method called `moveUp()` that changes
   the coordinates in the position arrays to move the snake up.  
   Hint: the y axis goes up and down.
7. Call `moveUp()` from onTimer to move the snake up one square per second.
