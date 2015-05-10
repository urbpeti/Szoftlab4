package Game;

import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;


public class InputHandler implements KeyListener {
	private List<Robot> robots;
	
	public InputHandler(ArrayList<Robot> l){
		robots = l;
		System.out.println("sajt");
	}
	
	public void keyPressed(KeyEvent e){
		
		//Elsõ játékos
		switch (e.getKeyChar()) {
		case 'a':
			if (!robots.get(0).getIsDead())
			robots.get(0).accelerate();
			break;
			
		case 'd':
			if (!robots.get(0).getIsDead())
			robots.get(0).decelerate();
			break;
			
		case 'q':
			if (!robots.get(0).getIsDead())
			robots.get(0).setItemCache(new Tacky(new Angle(robots.get(0).getPosition().getAngle())));
			break;
			
		case 'e':
			if (!robots.get(0).getIsDead())
			robots.get(0).setItemCache(new Oil(new Angle(robots.get(0).getPosition().getAngle())));
			break;
			
		default:
			break;
		}
		
		//Második játékos
		if (robots.size()>1){
			switch (e.getKeyChar()) {
			case 'j':
				if (!robots.get(1).getIsDead())
				robots.get(1).accelerate();
				break;
				
			case 'l':
				if (!robots.get(1).getIsDead())
				robots.get(1).decelerate();
				break;
				
			case 'u':
				if (!robots.get(1).getIsDead())
				robots.get(1).setItemCache(new Tacky(new Angle(robots.get(1).getPosition().getAngle())));
				break;
				
			case 'o':
				if (!robots.get(1).getIsDead())
				robots.get(1).setItemCache(new Oil(new Angle(robots.get(1).getPosition().getAngle())));
				break;
				
			default:
				break;
			}
		}
		
		//Harmadik játékos
		if (robots.size()>2){
			switch (e.getKeyChar()) {
			case '4':
				if (!robots.get(2).getIsDead())
				robots.get(2).accelerate();
				break;
				
			case '6':
				if (!robots.get(2).getIsDead())
				robots.get(2).decelerate();
				break;
				
			case '7':
				if (!robots.get(2).getIsDead())
				robots.get(2).setItemCache(new Tacky(new Angle(robots.get(2).getPosition().getAngle())));
				break;
				
			case '9':
				if (!robots.get(2).getIsDead())
				robots.get(2).setItemCache(new Oil(new Angle(robots.get(2).getPosition().getAngle())));
				break;
				
			default:
				break;
			}
		}
		
		
		System.out.println("Hit");
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	
}
