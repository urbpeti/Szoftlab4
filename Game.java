import java.util.ArrayList;

public class Game {
	ArrayList<Robot> robots;
	ArrayList<Item> items;

	public Game() {
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

	public double robotPosition(int robotnum) {
		return robots.get(robotnum).getPosition();

	}

	public int winnerIs() {
		Robot winner = robots.get(0);
		for (Robot robot : robots) {
			if(winner.getDistance() < robot.getDistance())
				winner = robot;
		}
		return robots.indexOf(winner);
	}

}
