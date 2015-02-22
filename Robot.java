
public class Robot {
	private double velocity;
	private double position;
	private double distance;

	public Robot() {
		velocity = 0;
		distance = 0;
		position = 0;
	}

	public double getVelocity() {
		return velocity;
	}

	public void accelerate() {
		velocity += GameSetUp.UNIT;
	}

	public void decelerate() {
		velocity -= GameSetUp.UNIT;
	}

	public double getposition() {
		return position;
	}

	public void jump() {
		position += velocity;
		position = position % 360;
		distance += Math.abs(velocity);
	}

	public double getDistance() {
		return distance;
	}

	public void halfspeed() {
		velocity = velocity / 2;
	}

}
