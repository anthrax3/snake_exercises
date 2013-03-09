---
layout: exercises
title: Exercise 1
---

## Exercise 1 - Output

**Goal**: Practice simple drawing on a canvas.

**Description**: In this exercise, we will draw a green square and a red apple.

### Instructions

1. Open `GameExercises.java` file
2. Modify the method `redrawCanvas` to draw some a green square and a red apple
3. Experiment with drawing other shapes.
4. What do the four numbers passed in when we draw affect?
  
### Hints

  To draw a red circle (experiment with changing the numbers and see what it does):
    
    canvas.setColor(Color.RED);
    canvas.fillOval(10, 10, 50, 50);

  To draw a green rectangle:
    
    canvas.setColor(Color.GREEN);
    canvas.fillRect(30, 30, 50, 50);
    
  To draw a label:
  	
    Font f = new Font("Helvetica Nueue", Font.BOLD, 24);
    canvas.setFont(f);
    canvas.drawString("Exercise 1", 50, 50);