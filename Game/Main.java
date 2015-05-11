package Game;

import java.awt.Color;
import java.util.ArrayList;

import javax.swing.JFrame;

public class Main extends JFrame {
  /**
   * 
   */
  private static final long serialVersionUID = -169271550253961193L;
  private MenuView menu;
  private ResultsView results;
  private GameView game;

  public static void main(String[] args) {
    new Main();
  }

  public Main() {
	game = new GameView(this);
    ShowMenu();

  }

  public void ShowMenu() {
    GraphicCreature.setColorCount(0);
    menu = new MenuView(this);
    results = new ResultsView(this);
    
    setTitle("MarsONE");
    setResizable(false);
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    setSize(800, 800);
    add(menu);
    menu.setVisible(true);
    setVisible(true);
    menu.present();
  }
  
  public void nullGame(){
	  game = new GameView(this);
  }

  public void ShowGame() {
    add(game);
    game.present();
  }

  public void ShowResults(ArrayList<Robot> l) {
    add(results);
    results.present(l);
  }

  public void AddPlayer(String name, Color cl) {
    game.addPlayer(name, cl);
  }

  public void FailureinGui(String s) {

  }
}
