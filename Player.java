import static java.awt.event.KeyEvent.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Player implements KeyListener {
	private Robot robot;
	private int acceleration = VK_RIGHT;

	private int decelerate = VK_LEFT;

	public Player(Robot robot) {
		this.robot = robot;
	}

	public void setAccelerationKey(int KeyCode) {
		this.acceleration = KeyCode;
	}
	
	public void setDecelerateKey(int KeyCode) {
		this.decelerate = KeyCode;
	}
	
	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode() == decelerate){
			robot.decelerate();			
		}
		if(e.getKeyCode() == acceleration)
			robot.accelerate();
	}

	@Override
	public void keyReleased(KeyEvent e) {
	}

	@Override
	public void keyTyped(KeyEvent e) {
	}

}
