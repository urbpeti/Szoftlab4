public class Robot {
	private double acceleration;
	private double velocity;
	private double position;
	private double distance;

	public Robot() {
		acceleration = 0;
		velocity = 0;
		distance = 0;
		position = 0;
	}

	public double getVelocity() {
		return velocity;
	}

	public void accelerate() {
		if (acceleration < GameSetUp.UNIT)
			acceleration += GameSetUp.UNIT;
	}

	public void decelerate() {
		if (acceleration > -GameSetUp.UNIT)
			acceleration -= GameSetUp.UNIT;
	}

	public double getPosition() {
		return position;
	}

	public void jump() {
		velocity += acceleration;
		position += velocity;
		position = position % 360;
		distance += Math.abs(velocity);
		acceleration = 0;
	}

	public double getDistance() {
		return distance;
	}

	public void halfSpeed() {
		velocity = velocity / 2;
	}

}
