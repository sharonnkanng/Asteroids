package animation;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;

/**
 * This class creates and fires the bullet object.
 * 
 * @author Sky
 * @author Sharon
 */


public class ProjectileObject implements AnimatedObject {

	// The size of the shot
	private static final int SHOT_SIZE = 10;

	// The number of pixels to move on each frame of the animation.
	double moveAmount;

	// The animation that this object is part of.
	AbstractAnimation animation;

	// The asteroid shape
	private Ellipse2D ellipse;

	// X coordinate where the bullet starts
	public double x;

	// Y coordinate where the bullet starts
	public double y;

	private double rotation;

	// Constructor
	public ProjectileObject(AbstractAnimation animation, double x, double y, double moveAmount, double rotation) {

		this.x = x;
		this.y = y;
		this.moveAmount = moveAmount;
		this.animation = animation;
		this.rotation = rotation;
		// Create an ellipse object with x and y coordinate and size of the bullet
		ellipse = new Ellipse2D.Double(x, y, SHOT_SIZE, SHOT_SIZE);
	}

	/**
	 * Updates x and y to cause the shot to move in the direction it is pointing
	 */
	public void calculateXY() {

		double xOffset = moveAmount * Math.sin(rotation);
		double yOffset = -moveAmount * Math.cos(rotation);

		x = x + xOffset;
		y = y + yOffset;

	};

	/**
	 * Moves the shot a small amount.
	 */
	@Override
	public void nextFrame() {
		// call calculateXY to make shots go forward from the center of the ship
		calculateXY();
		ellipse.setFrame(x, y, SHOT_SIZE, SHOT_SIZE);
	}

	/**
	 * The ship’s bullet goes at the ship’s speed + 5 pixels /frame.
	 */
	public void fire() {
		calculateXY();
		moveAmount += 5;
		System.out.println("Fire");
	};

	/**
	 * Draws the bullet
	 * 
	 * @param g the graphics context to draw on
	 */
	@Override
	public void paint(Graphics2D g) {

		g.setColor(Color.PINK);
		g.fill(getShape());
	}

	// returns the shape of the bullet
	public Ellipse2D getShape() {

		return ellipse;
	}

    // For TESTING only
    double getX() {
        return x;
    }
    
    // For TESTING only
    double getY() {
        return y;
    }
    
    // For TESTING only
    double getMoveAmount() {
        return moveAmount;
    }
    
    // For TESTING only
    int getSize() {
        return SHOT_SIZE;
    }
    
    // For TESTING only
    double getRotation() {
    	return rotation;
    }

}
