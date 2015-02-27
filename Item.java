
public abstract class Item {
	protected double position;
	
	public void setPosition(double position){
		if(position > 0 && position < 360)
			this.position = position;
	}
	
	public abstract void interaction(Robot robot);
	
}
