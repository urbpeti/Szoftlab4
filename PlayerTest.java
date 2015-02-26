import org.junit.Test;


public class PlayerTest {
	Player player;
	Robot robot;
	
	@Test
	public void createTest() throws Exception {
		robot = new Robot();
		player = new Player(robot);
	}

}
