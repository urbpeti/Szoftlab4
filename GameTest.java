import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;


public class GameTest {
	Game game;
	ArrayList<Robot> robots;
	
	@Before
	public void setUp() throws Exception {
		game = new Game();
		robots = new ArrayList<Robot>();
		final Robot robot1 = new Robot();
		final Robot robot2 = new Robot();
		robots.add(robot1);
		robots.add(robot2);		
		game.addRobot(robot1);
		game.addRobot(robot2);
	}

	@Test
	public void stepTest(){
		game.step();
		assertEquals(robots, game.robots);
	}
	
	@Test
	public void winnerIsTest() throws Exception {
		assertEquals(0, game.winnerIs());
		Robot robot0 = robots.get(0);
		Robot robot1 = robots.get(1);
		robot1.accelerate();
		game.step();
		assertEquals(1,game.winnerIs());
		robot0.decelerate();
		game.step();
		robot0.decelerate();
		game.step();
		game.step();
		assertEquals(0, game.winnerIs());
	}
	
	

}
