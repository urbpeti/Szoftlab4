package Game;

public class Angle {
	private double value;

	public double getAngle() {
		return value;
	}

	public void setAngle(double value) {
		value = value % 360;
		this.value = value;
	}
	
}
