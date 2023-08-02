package animation;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.awt.Shape;
import java.awt.geom.AffineTransform;
import java.awt.geom.Ellipse2D;
import java.util.ArrayList;

/**
 * This class creates and moves the Ship object.
 * @author Sky
 * @author Sharon
 *
 */

public class ShipObject implements AnimatedObject {

	// The animation that this object is part of.
	private AbstractAnimation animation;

	// The p that is drawn
	private Polygon p;

	// The x coordinate of the ship
	private double x;

	// The y coordinate of the ship
	private double y;

	// Default rotation value
	private double rotation = Math.PI / 4;

	// The number of pixels to move on each frame of the animation.
	public double moveAmount = 0;

	// Width of the ship
	private final double SHIP_WIDTH = 10;

	// Height of the ship
	private final double SHIP_HEIGHT = 17;

	// Count the frame of the animation so that the increased speed would decrease
	// after 3 frames
	private int frameCount = 0;

	// ArrayList that would store all bullets
	public ArrayList<ProjectileObject> bullets = new ArrayList<ProjectileObject>();

	// Boolean value that keeps track of whether the ship is dead or not
	protected boolean alive = true;

	/**
	 * Constructs a ship
	 * 
	 * @param animation
	 */
	public ShipObject(AbstractAnimation animation) {
		this.animation = animation;
		p = new Polygon();
		p.addPoint((int)-(SHIP_WIDTH/2), (int)(SHIP_HEIGHT/2));
		p.addPoint(0, (int)-(SHIP_HEIGHT/2));
		p.addPoint((int)(SHIP_WIDTH/2), (int)(SHIP_HEIGHT/2));
		// Default coordinate set in a middle of the screen
		x = 300;
		y = 300;
	}; 


	/**
	 * Returns the shape after applying the current translation and rotation
	 * 
	 * @return the shape located as we want it to appear
	 */
	public Shape getShape() {

		// AffineTransform captures the movement and rotation we
		// want the shape to have
		AffineTransform at1 = new AffineTransform();

		// x, y are where the origin of the shape will be.
		// In this case, this is the center of the triangle.
		at1.translate(x, y);

		// Rotate the shape 45 degrees to the left
		at1.rotate(rotation);

		AffineTransform at = at1;

		// Create a shape that looks like our triangle, but centered
		// and rotated as specified by the AffineTransform object.
		return at.createTransformedShape(p);
	}

	/**
	 * Updates x and y to cause the ship to move in the direction it is pointing
	 */
	public void calculateXY() {

		double xOffset = moveAmount * Math.sin(rotation);
		double yOffset = -moveAmount * Math.cos(rotation);

		// Update the x and y coordinates with offsets
		x = x + xOffset;
		y = y + yOffset;
	};

	/**
	 * Draws the triangle
	 * 
	 * @param g the graphics context to draw on
	 */

	public void paint(Graphics2D g) {
		g.setColor(Color.WHITE);
		g.draw(getShape());
		g.fill(getShape());
	}

	/**
	 * Ship goes forward to the direction where the tip is pointing
	 */
	public void up() {

		moveAmount += 3;
		// Ship's speed should not exceed 20
		if (moveAmount >20){
			moveAmount = 20;
		}
	};

	/**
	 * Ship rotates to the right
	 */
	public void rotateRight() {
		rotation += Math.PI / 4;
	}

	/**
	 * Ship rotates to the left
	 */
	public void rotateLeft() {
		rotation -= Math.PI / 4;
	}

	/**
	 * Ship fires the bullet
	 * 
	 * @return ArrayList that stores the all bullets
	 */
	public ArrayList<ProjectileObject> fire() {

		// Construct the bullet with the ship's coordinate, speed, and rotation
		ProjectileObject shot = new ProjectileObject(animation, x, y - 8.5, moveAmount, rotation);
		shot.fire();
		bullets.add(shot);
		return bullets;
	};

	/**
	 * Ship goes to the hyper space and comes back with the random coordinate
	 */
	public void hyperspace() {

		// The size of the screen is 600 * 600
		int max_width = 600;
		int max_height = 600;
		x = (int) (Math.random() * max_width);
		y = (int) (Math.random() * max_height);
	};

	/**
	 * Moves the ship a small amount. If it reaches the left or right edge, it
	 * teleports it to the same place on the opposite edge.
	 */
	public void nextFrame() {

		frameCount += 1;

		// Decrement the speed in every 3 frames until it stops
		if (frameCount % 3 == 0 && moveAmount >= 0) {
			moveAmount -= (moveAmount * 0.1);
		}

		calculateXY();

		// Check if the right edge of the ball is beyond the right edge of the window.
		// If it is, move it to the left on its next move.

		if (x - SHIP_WIDTH >= 600) {
			x = 0;
		}

		// Check if the left edge of the ball is beyond the left edge of the window.
		// If it is, move it to the right on its next move.

		else if (x + (SHIP_WIDTH / 2) < 0) {
			// The size of the screen is 600 * 600
			x = 600;

		}

		// Check if the lower edge of the ball is beyond the lower edge of the window.
		// If it is, move it to the upper edge on its next move

		if (y - SHIP_HEIGHT >= 600) {
			y = 0;
		}

		// Check if the upper edge of the ball is beyond the upper edge of the window.
		// If it is, move it to the lower edge on its next move

		else if (y + (SHIP_HEIGHT / 2) < 0) {
			// The size of the screen is 600 * 600
			y = 600;
		}

	};

	/**
	 * Sets alive
	 * 
	 * @param set boolean true if ship is alive
	 */
	protected void setAlive(boolean set) {
		alive = set;
	}

	/**
	 * Get if the ship is alive
	 * 
	 * @return boolean true if alive
	 */
	protected boolean isAlive() {
		return alive;
	}
  
  
    // For TESTING only
    double getX() {
        return x;
    }
    
    // For TESTING only
    void setX(double x) {
        this.x = x;
    }
    
    // For TESTING only
    double getY() {
        return y;
    }
    
    // For TESTING only
    void setY(double y) {
        this.y = y;
    }
    
    // For TESTING only
    double getMoveAmount() {
        return moveAmount;
    }
    
    // For TESTING only
    void setMoveAmount(double amount) {
        moveAmount = amount;
    }
    
    // For TESTING only
    double getWidth() {
        return SHIP_WIDTH;
    }
    
    // For TESTING only
    double getHeight() {
        return SHIP_HEIGHT;
    }
    
    void setRotation(double rotation) {
    	rotation = this.rotation;
    }
    
    double getRotation() {
//    	System.out.println("boo");
//    	System.out.println(rotation);
    	return rotation;
    }

}
