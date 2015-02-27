import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.JPanel;
import javax.swing.Timer;

public class Panel extends JPanel {
	private static final long serialVersionUID = 1L;
	private Game game;
	private Player player;
	private TimerHandler timer;

	public Panel() {
		Robot robot = new Robot();
		timer = new TimerHandler();
		timer.start();

		game = new Game();
		game.addRobot(robot);

		player = new Player(robot);
		player.setAccelerationKey(KeyEvent.VK_D);
		player.setDecelerateKey(KeyEvent.VK_A);
		robot = new Robot();
		robot.accelerate();
		robot.jump();
		game.addRobot(robot);

		setFocusable(true);
		addKeyListener(player);
		addKeyListener(new Player(robot));
	}

	public void paint(Graphics g) {
		g.clearRect(0, 0, 600, 600);
		g.drawOval(100, 100, GameSetUp.WIDTH, GameSetUp.HEIGHT);
		g.drawOval(
				(int) (300 + Math.cos(game.robotPosition(0) / 180 * Math.PI) * 200 - 4),
				(int) (300 + Math.sin(game.robotPosition(0) / 180 * Math.PI) * 200 - 4),
				8, 8);
		g.drawOval(
				(int) (300 + Math.cos(game.robotPosition(1) / 180 * Math.PI) * 200 - 4),
				(int) (300 + Math.sin(game.robotPosition(1) / 180 * Math.PI) * 200 - 4),
				8, 8);
	}

	class TimerHandler implements ActionListener {
		Timer timer = new Timer(1000, this);

		@Override
		public void actionPerformed(ActionEvent e) {
			game.step();
			repaint();
		}

		public void start() {
			timer.start();
		}

		public void stop() {
			timer.stop();
		}

	}

}
