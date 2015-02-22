import java.util.ArrayList;


public class Game {
	ArrayList<Robot> robots;
	
	public Game(){
		robots = new ArrayList<Robot>();
	}
	
	public void addRobot(Robot robot) {
		robots.add(robot);
	}
	
}
