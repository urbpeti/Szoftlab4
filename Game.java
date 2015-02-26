import java.util.ArrayList;


public class Game {
	ArrayList<Robot> robots;
	
	public Game(){
		robots = new ArrayList<Robot>();
	}
	
	public void addRobot(Robot robot) {
		robots.add(robot);
	}

	public void step() {
		for (Robot robot : robots) {
			robot.jump();
		}
	}
	
	public double robotPosition(int robotnum){
		return robots.get(robotnum).getPosition();
		
	}

	
}
