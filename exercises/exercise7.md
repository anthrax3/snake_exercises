---
layout: exercises
title: Exercise 7
---

## Exercise 7 - Inheritance

**Goal**: Refactor the snake and apple objects to use a shared base class

**Description**: In this exercise, we will refactor the Snake Game so that the `Snake` and `Apple`
classes share a common base class `Actor`

### Instructions

1. Refactor the snake and apple using inheritance
2. Snake and Apple should both extend from `Actor`
3. Move any common fields or methods into the base class.

### Review:

Your base class might start like:

    public class Actor {
      private int drawSize;
    }
    
and the snake class starts with:

    public class Snake extends Actor {
      int[] xPos;
      // ... snake specific fields
    }