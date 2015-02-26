import static org.junit.Assert.*;

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
		robot.jump();
		robot.accelerate();
		robot.jump();
		assertEquals(2 * UNIT, robot.getVelocity(), DEVIATION);
		robot.decelerate();
		robot.jump();
		assertEquals(UNIT, robot.getVelocity(), DEVIATION);
	}

	@Test
	public void accelerateTest() throws Exception {
		double vtemp = robot.getVelocity();
		robot.accelerate();
		robot.accelerate();
		assertEquals(vtemp, robot.getVelocity(), DEVIATION);
		robot.jump();
		assertEquals(vtemp + UNIT, robot.getVelocity(), DEVIATION);
	}

	@Test
	public void decelerate() throws Exception {
		double vtemp = robot.getVelocity();
		robot.decelerate();
		robot.decelerate();
		assertEquals(vtemp, robot.getVelocity(), DEVIATION);
		robot.jump();
		assertEquals(vtemp - UNIT, robot.getVelocity(), DEVIATION);
	}
	
	@Test
	public void ZeroAcceleration() throws Exception {
		robot.accelerate();
		robot.decelerate();
		robot.jump();
		assertEquals(0, robot.getVelocity(),DEVIATION);
	}

	@Test
	public void getpositionTest() throws Exception {
		assertEquals(0, robot.getPosition(), DEVIATION);
	}

	@Test
	public void jump() throws Exception {
		robot.accelerate();
		robot.jump();
		assertEquals(UNIT, robot.getPosition(), DEVIATION);
		robot.jump();
		assertEquals(2 * UNIT, robot.getPosition(), DEVIATION);
		for (int i = 2; i < 36; i++) {
			robot.jump();
		}
		assertEquals(UNIT*36%360, robot.getPosition(), DEVIATION);

	}

	@Test
	public void getDistanceTest() throws Exception {
		assertEquals(0, robot.getDistance(), DEVIATION);
		robot.accelerate();
		robot.jump();
		assertEquals(UNIT, robot.getDistance(), DEVIATION);
		robot.decelerate();
		robot.jump();
		robot.decelerate();
		robot.jump();
		assertEquals(2*UNIT, robot.getDistance(), DEVIATION);
	}

	@Test
	public void halfspeed() throws Exception {
		robot.accelerate();
		robot.jump();
		robot.halfSpeed();
		assertEquals(0.5 * UNIT, robot.getVelocity(), DEVIATION);
	}
}
