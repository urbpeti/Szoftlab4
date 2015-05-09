package Game;

import java.awt.Color;

import javax.swing.JFrame;

public class Main extends JFrame {
  /**
   * 
   */
  private static final long serialVersionUID = 1L;
  private MenuView menu;
  private ResultsView results;
  private GameView game;
  public Field field;

  public static void main(String[] args) {
    new Main();
  }

  public Main() {
    menu = new MenuView(this);
    results = new ResultsView(this);
    game = new GameView(this);
    field = new Field(game);
    setTitle("MarsONE");
    setResizable(false);
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    setSize(800, 800);
    add(menu);
    menu.setVisible(true);
    setVisible(true);
    ShowMenu();
  }

  public void ShowMenu() {
    menu.present();
  }

  public void ShowGame() {
    game.present(field.getRobots());
  }

  public void ShowResults() {
    results.present(field.getRobots());
  }

  public void AddPlayer(String name, Color cl) {
    field.newRobot(name, cl);
    System.out.println(field.getRobots().get(0).velocity);
  }

  public void FailureinGui(String s) {

  }
}
