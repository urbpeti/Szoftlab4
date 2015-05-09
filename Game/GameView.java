package Game;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.Timer;

public class GameView implements Control {
  private Main parent;
  private Timer timer;
  private InputHandler inputHandler;
  private List<Drawable> drawables;
  private GameTimer gameTimer;
  private Field field;

  public GameView(Main m) {
    parent = m;
    drawables = new ArrayList<Drawable>();
    gameTimer = new GameTimer();
  }

  public void present(List l) {
    gameTimer.register(field);
    timer = new Timer(1000, new ActionListener() {

      public void actionPerformed(ActionEvent e) {
        gameTimer.tick();
        if (field.isAllDead() || gameTimer.ended())
          endGame();
      }
    });
    timer.start();
  }

  public void endGame() {
    timer.stop();

  }

  public void drawAll() {

  }

  public void itemAdded(Item i) {
    GraphicItem gi = new GraphicItem(i);
    drawables.add(gi);
  }

  public void itemRemoved(Item i) {
    for (int j = 0; j < drawables.size(); j++) {
      if (drawables.get(j).isitme(i)) {
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
    for (int j = 0; j < drawables.size(); j++) {
      if (drawables.get(j).isitme(c)) {
        drawables.remove(j);
        break;
      }
    }

  }
}
