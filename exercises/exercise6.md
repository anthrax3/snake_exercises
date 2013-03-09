---
layout: exercises
title: Exercise 6
---

## Exercise 6 - Classes

**Goal**: Refactor the snakes game using classes.

**Description**: In this exercise, we will reorganize the implementation
into classes, so that it is object oriented.

### Instructions

1. Open `GameRunner.java`. 
   
   Find the line 
   
     `gameFrame.add(new GameExercises());`
   
   and change it to:
    
     `gameFrame.add(new GameObjectExercises());`
     
2. Try running the project. It should run successfully, and
   you should see a blank canvas again.
   
3. Open `GameObjectExercises.java`. 
     - Instantiate a snake and an apple in the constructor.
     - What do you think the initial positions would be?
     
4. Modify the `redrawCanvas` method so that it draws the snake and the apple. 
     - Refer to your previous implementation to implement logic details. 
     - You will also need to add code to the `Snake` and `Apple` class.
   
5. Modify the `onKeyPress` so that you can control the snake.

6. Add back the collision and apple detection from previous exercises but with
   the logic properly contained in either `Snake`, `Apple` or `GameObjectExercises`.