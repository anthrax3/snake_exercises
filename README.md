# SnakeGame

- Output
  - Simple graphics (draw a green square, red apple)
    canvas.setColor(Color.RED);
    canvas.fillOval(10, 10, 1, 1);
    canvas.setColor(Color.GREEN);
    canvas.fillRect(15, 15, 5, 5);
- Variables
  - Simple graphic (draw the snake without loops)
  - First, draw manually, repeating colors and width
  - Then, try to change the color and width of the snake
  - Refactor code so that changing the color and width is easier
  - Add an array for snake positions	
- Methods
  - Refactor variable exercise
  - Method they create and call for each el in the array
  - drawSnake(x, y) - Paints square on canvas
  - moveUp(snake)
  - moveDown(snake)
  - moveLeft(snake)
  - moveRight(snake)
- Loops
  - Draw variable length snakes
  - Refactor move using loops
- Conditionals
  - Introduce proper move logic based on current direction
  - Add bounds collision logic of snake and apple.
  - Handle apple eating
- Classes
  - Introduce a snake and apple class with getters, setters, constructors
  - Have them fill in the snake and apple classes
- Inheritance
  - Refactor the snake and apple using inheritance?
  - Add a hole tile.
  - Item represents apple or hole
- ArrayList
  - Make original array require copy to new array to grow snake
  - Refactor all arrays into ArrayLists
  - Refactor x and y arrays to use an ArrayList<Point>