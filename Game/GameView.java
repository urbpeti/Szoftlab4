package Game;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

public class GameView extends JPanel implements Control {
	private Main parent;
	private Timer timer;
	private InputHandler inputHandler;
	private List<Drawable> drawables;
	private GameTimer gameTimer;
	private Field field;
	private JLabel timecounter;
	private JLabel Maplabel;
	private int seconds;
	
	public GameView(Main m, Field f){
		field = f;
		seconds = 0;
		parent=m;
		drawables = new ArrayList<Drawable>();
		gameTimer = new GameTimer();
		gameTimer.register(field);
		setBackground(Color.white);
		setLayout(null);
		initializeComponents();
		timer = new Timer(1000,new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				removeAll();
				initializeComponents();
				gameTimer.tick();
				seconds++;
				if (field.isAllDead() || gameTimer.ended()) endGame();
				//repaint();
				else drawAll();
			}
		});
	}
	
	public void initializeComponents(){
		//Map image
		try {
			Image map = ImageIO.read(new File("Images\\map.png"));
			map = map.getScaledInstance(800, 800, 1);
			Maplabel = new JLabel(new ImageIcon(map));
			add(Maplabel);
			Maplabel.setBounds(0, 0, 800, 800);
			setComponentZOrder(Maplabel, 0);
		} catch (IOException e1) {
			parent.FailureinGui("Map image load failure");
				e1.printStackTrace();
		}
	//Timerlabel
		timecounter = new JLabel(getTimeString());
		timecounter.setBounds(280 ,350, 400, 100);
		timecounter.setFont(new Font("Verdana",Font.PLAIN, 100));
		timecounter.setText(getTimeString());
		add(timecounter);
	}
	
	public void present(){
		setVisible(true);
		timer.start();
		seconds = 1;
		drawAll();
		inputHandler = new InputHandler(field.getRobots());
		addKeyListener(inputHandler);
		setFocusable(true);
		requestFocus();
		
	}
	
	public void endGame(){
		timer.stop();
		setVisible(false);
		parent.ShowResults();
	}
	
	public void drawAll(){
		for (Drawable drawable : drawables) {
			drawable.draw(this);
		}
	}

	public void itemAdded(Item i) {
		GraphicItem gi = new GraphicItem(i);
		drawables.add(gi);
	}

	public void itemRemoved(Item i) {
		for (int j=0; j<drawables.size(); j++){
			if(drawables.get(j).isitme(i)){
				drawables.remove(j);
				break;
			}
		}
		
	}

	public void creatureAdded(Creature c) {
		GraphicCreature gc = new GraphicCreature(c);
		drawables.add(gc);
		
	}

	public void creatureRemoved(Creature c) {
		for (int j=0; j<drawables.size(); j++){
			if(drawables.get(j).isitme(c)){
				drawables.remove(j);
				break;
			}
		}
		
	}
	
	private String getTimeString(){
		int minutes = seconds/60;
		return new String(Integer.toString(minutes) + " : " + Integer.toString(seconds-minutes*60));
	}
	
}
