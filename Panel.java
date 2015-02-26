import java.awt.Graphics;

import javax.swing.JPanel;


public class Panel extends JPanel{
	private static final long serialVersionUID = 1L;
	private Game game;
	private Player player;
	
	public Panel(){
		Robot robot = new Robot();
		
		game = new Game();
		game.addRobot(robot);
		
		player = new Player(robot);
		
		setFocusable(true);
		addKeyListener(player);
	}
	
	public void paint(Graphics g){
		g.clearRect(0, 0, 600, 600);
		g.drawOval(100, 100,GameSetUp.WIDTH, GameSetUp.HEIGHT);
		g.drawOval((int)(300+Math.cos(game.robotPosition(0)/180*Math.PI)*200-15), (int)(300+Math.sin(game.robotPosition(0)/180*Math.PI)*200-15), 30, 30);
		game.step();
		repaint();
	}
}
