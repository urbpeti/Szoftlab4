import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class RobotTest {
	private static final double UNIT = GameSetUp.UNIT;
	private final double DEVIATION = 0.001;
	Robot robot;

	@Before
	public void setUp() throws Exception {
		robot = new Robot();
	}

	@Test
	public void getVelocityTest() {
		assertEquals(0.0, robot.getVelocity(), DEVIATION);
		robot.accelerate();
		robot.accelerate();
		assertEquals(2 * UNIT, robot.getVelocity(), DEVIATION);
		robot.decelerate();
		assertEquals(UNIT, robot.getVelocity(), DEVIATION);
	}

	@Test
	public void accelerateTest() throws Exception {
		double vtemp = robot.getVelocity();
		robot.accelerate();
		assertEquals(vtemp + UNIT, robot.getVelocity(), DEVIATION);
	}

	@Test
	public void decelerate() throws Exception {
		double vtemp = robot.getVelocity();
		robot.decelerate();
		assertEquals(vtemp - UNIT, robot.getVelocity(), DEVIATION);
	}

	@Test
	public void getpositionTest() throws Exception {
		assertEquals(0, robot.getposition(), DEVIATION);
	}

	@Test
	public void jump() throws Exception {
		robot.accelerate();
		robot.jump();
		assertEquals(UNIT, robot.getposition(), DEVIATION);
		robot.jump();
		assertEquals(2 * UNIT, robot.getposition(), DEVIATION);
		for (int i = 2; i < 36; i++) {
			robot.jump();
		}
		assertEquals(0, robot.getposition(), DEVIATION);

	}

	@Test
	public void getDistanceTest() throws Exception {
		assertEquals(0, robot.getDistance(), DEVIATION);
		robot.accelerate();
		robot.jump();
		assertEquals(10, robot.getDistance(), DEVIATION);
		robot.decelerate();
		robot.jump();
		robot.decelerate();
		robot.jump();
		assertEquals(20, robot.getDistance(), DEVIATION);
	}

	@Test
	public void halfspeed() throws Exception {
		robot.accelerate();
		robot.halfspeed();
		assertEquals(0.5 * UNIT, robot.getVelocity(), DEVIATION);
	}
}
