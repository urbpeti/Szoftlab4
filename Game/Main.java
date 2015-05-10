package Game;
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.List;

import javax.swing.JFrame;

public class Main extends JFrame {
	private MenuView menu;
	private ResultsView results;
	private GameView game;
	public Field field;
	
	public static void main(String[] args) {
		Main m = new Main();
		System.out.println("asdf");
	}	
	
	public Main(){
		menu = new MenuView(this);
		results = new ResultsView(this);
		field = new Field();
		game = new GameView(this, field);
		field.setcontrol(game);
		field.placeHoles();
		setTitle("MarsONE");
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(800,800);
		add(menu);
		menu.setVisible(true);
		setVisible(true);
		ShowMenu();

	}
	
	public void ShowMenu(){
		menu.present();
	}
	
	public void ShowGame(){
		add(game);
		game.present();
	}
	
	public void ShowResults(){
		add(results);
		results.present(field.getRobots());
	}
	
	public void AddPlayer(String name, Color cl){
		field.newRobot(name, cl);
		System.out.println(field.getRobots().get(0).velocity);
	}
	
	public void FailureinGui(String s){
		
	}
}
