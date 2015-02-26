import static java.awt.event.KeyEvent.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


public class Player implements KeyListener {
	private Robot robot;
	
	public Player(Robot robot) {
		this.robot = robot;
	}

	@Override
	public void keyPressed(KeyEvent e) {
		switch (e.getKeyCode()) {
		case(VK_LEFT):
			robot.decelerate();
			break;
		case(VK_RIGHT):
			robot.accelerate();
		default:
			break;
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
	}

	@Override
	public void keyTyped(KeyEvent e) {
	}

}
