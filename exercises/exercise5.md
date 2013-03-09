---
layout: exercises
title: Exercise 5
---

## Exercise 5 - Conditionals

**Goal**: Use conditionals to complete the snakes game!

**Description**: In this exercise, we will complete the game logic to
detect snake collisions, grow the snake, place the apple.

### Instructions

1. Open `GameExercises.java` file
2. Modify `onTimer` to call the following methods:
  a) `checkApple`
    - If the snake is on the apple tile, then increase the snake length and move the apple.
  b) `checkBoundsCollision`
    - Check for collision w/ walls or the snake with itself
  c) `moveSnake`
    - Advance the snake in the direction it's currently moving
3. `onKeyPress`
  - Change the direction of the snake.  Note that if the snake is already 
    traveling up, it cannot immediately turn down, it can only go left or right.

### Hints

At the end of this exercise, we should have a basic functioning snake game. Here are
several more in depth hints on how to achieve that:

#### Ensure snake head and apple are on a grid.

The snake head and the apple need to be placed onto a grid. This means the snake and apple
should both have the same width and height. Also, when the snake moves, we need to
make sure it moves along the grid so that it will hit the apple.

- Create an instance variable called `gridInterval` and initialize it to 25.
- When drawing the snake and apple in the methods `drawSnake` and `drawApple`, use `gridInterval` for the size.
- When moving the snake, it should move by increments of `gridInterval`.
  
#### Bounds collision detection

Bounds collision is how we determine if the snake hit the wall or itself. We need a way
to halt the game (game over) if the snake hits these conditions.

- Create a method called `checkBoundsCollision` and call the method from `onTimer`.
- Create an instance variable called `isRunning` inside `checkBoundsCollision`.
- In `checkBoundsCollision`, check for collisions with the wall by seeing if the position of the head 
  of the snake is less than 0 or greater than 500.If the snake has collided with the wall, set isRunning to false.
- In `checkBoundsCollision`, check for collisions with the snake body by comparing the position of the 
  head of the snake with each of the segments of the snake body using a for loop. If the snake has collided 
  with itself, set `isRunning` to false.
- In `onTimer`, if `isRunnin`g is false, then don't run any of the other game methods.

#### Apple collisions

Checking for collisions with the apple requires the apple to be positioned correctly
onto the grid so that the snake head will hit the apple directly.

- If the snake head position is the same as the apple position, do the following:
  - We can determine the canvas width using the `getWidth()` method
  - Regenerate the apple on a grid interval. Generate a random number between 0 to the canvas width. 
    In order to ensure that the apple is on a grid interval, do something like: `(newPosition / gridInterval) * gridInterval`. 
    Because integer division will truncate the result, this ensures that the apple will be on a grid interval.
  - Increase the snake length using `Arrays.copyOf` to create new X and Y position arrays based on the existing arrays
    i.e `xSnakePos = Arrays.copyOf(xSnakePos, xSnakePos.length + 1)`

#### Changing snake direction

We need to allow the player to change the direction of the snake using the arrow keys. 
We need to fill in logic to the `onKeyPress` method for handling different key presses.

- Create an instance variable for `direction` (string)
- In `onKeyPress`, set the new direction based on the pressed key to the new direction.
    - e.g., `if (keyCode == KeyEvent.VK_LEFT)`
    - Note: if the snake is traveling left or right, it may only turn up or down.  
      If the snake is traveling up or down, it may only turn left or right.
- Rename `moveUp` to `moveSnake`.  In this method, change the way the snake's position is modified as follows:
  - In the snake positions arrays, shift all the elements to the right, so that the old snake head is 
    now the second element of the position array. Use a for loop.
  - Based on the direction of the snake, set the coordinates for the new head. 
    Use an if / else if statement to check the four possible directions and set new head position accordingly.