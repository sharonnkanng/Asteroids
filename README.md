# Asteroids Atari Game with Java - MHC CS 225 Fall'22

## Features: 


**Game Setup and Display** The game sets up a window using the JFrame class, with a size of 600x600 pixels, a black background, and the title "Asteroid Game."

_**(This part is what I worked) Ship Object:** The ShipObject class represents the user-controlled ship in the game. It can move up, rotate left, and rotate right using the up arrow, left arrow, and right arrow keys, respectively. The ship's movement speed is limited to 20 pixels per frame._

_**(This part is what I worked) Asteroid Object:** The AsteroidObject class represents the asteroids that move around the screen. The game initially creates a specific number of asteroids (5 by default) and gives them random starting positions and directions. The asteroids move continuously across the screen and reappear on the opposite side when they move beyond the window borders._ 

---

**Bullet Object:** The ProjectileObject class represents the bullets fired by the ship. When the player presses the space bar, the ship fires a bullet in the direction it is currently facing. The bullet moves in a straight line from the ship's position.

**Collision Detection:** The game includes collision detection between the ship and the asteroids and between the asteroids and the bullets. When an asteroid collides with the ship, the game ends, and the "GAME OVER" message with the final score is displayed. If a bullet hits an asteroid, both the bullet and the asteroid are removed from the game, and the player earns points.

**Score and Level System:** The game keeps track of the player's score, which is incremented when the player destroys an asteroid. It also features a level system, where the level increases when all asteroids on the screen are destroyed. As the level increases, the number of asteroids and their speed also increase.

**User Input:** The game allows user input through key presses. The ship responds to key presses for movement and firing bullets.

**Animation Loop:** The game uses an animation loop to update the positions of the ship, asteroids, and bullets on each frame and redraws the screen accordingly.

**Hyperspace Functionality:** The ShipObject class includes a "hyperspace" function that teleports the ship to a random position on the screen.

**Graphics and Display:** The game uses Graphics2D to draw the ship, asteroids, bullets, score, level, and "GAME OVER" message on the screen. Different colors are used for the ship, bullets, and asteroids.

## Demo
https://github.com/sharonnkanng/Asteroids/assets/94573832/edba5d77-2379-4a94-bfe7-6b6ddaa1260c



