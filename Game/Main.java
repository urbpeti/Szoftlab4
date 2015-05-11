package Game;

import java.awt.Color;

import javax.swing.JFrame;

public class Main extends JFrame {
  /**
   * 
   */
  private static final long serialVersionUID = -169271550253961193L;
  private MenuView menu;
  private ResultsView results;
  private GameView game;
  public Field field;

  public static void main(String[] args) {
    new Main();
  }

  public Main() {
    ShowMenu();

  }

  public void ShowMenu() {
    GraphicCreature.setColorCount(0);
    menu = new MenuView(this);
    results = new ResultsView(this);
    field = new Field();
    game = new GameView(this, field);
    field.setControl(game);
    setTitle("MarsONE");
    setResizable(false);
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    setSize(800, 800);
    add(menu);
    menu.setVisible(true);
    setVisible(true);
    menu.present();
  }

  public void ShowGame() {
    add(game);
    game.present();
  }

  public void ShowResults() {
    add(results);
    results.present(field.getRobots());
  }

  public void AddPlayer(String name, Color cl) {
    field.newRobot(name, cl);
  }

  public void FailureinGui(String s) {

  }
}
