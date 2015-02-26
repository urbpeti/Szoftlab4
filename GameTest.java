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

}
