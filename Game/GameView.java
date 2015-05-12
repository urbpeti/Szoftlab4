package Game;

import static Setup.GameSetUp.TICKTIME;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

public class GameView extends JPanel implements Control {
  /**
   * 
   */
  private static final long serialVersionUID = 63362967967279836L;
  private Main parent;
  private Timer timer;
  private InputHandler inputHandler;
  private ArrayList<Drawable> drawables;
  private GameTimer gameTimer;
  private Field field;
  private JLabel timecounter;
  private JLabel Maplabel;
  private int seconds;
  private Image map;

  public GameView(Main m) {
    drawables = new ArrayList<Drawable>();
    field = new Field();
    seconds = 0;
    parent = m;

    gameTimer = new GameTimer();
    gameTimer.register(field);
    setBackground(Color.white);
    setLayout(null);
    timer = new Timer(TICKTIME, new ActionListener() {

      public void actionPerformed(ActionEvent e) {
        removeAll();
        timecounter.setText(getTimeString());
        gameTimer.tick();
        seconds++;
        if (field.isAllDead() || gameTimer.ended())
          endGame();
        else {
          drawAll();
          add(timecounter);
          add(Maplabel);
          repaint();
        }
      }
    });
    init();
    field.setControl(this);
  }

  private void init() {
    try {
      map = ImageIO.read(new File("Images/map.png"));
      map = map.getScaledInstance(800, 800, 1);
      Maplabel = new JLabel(new ImageIcon(map));
      Maplabel.setBounds(0, 0, 800, 800);
    } catch (IOException e1) {
      parent.FailureinGui("Map image load failure");
      e1.printStackTrace();
    }

    timecounter = new JLabel(getTimeString());
    timecounter.setBounds(280, 350, 400, 100);
    timecounter.setFont(new Font("Verdana", Font.PLAIN, 100));
    timecounter.setForeground(new Color(177, 177, 177));
  }

  public void present() {
    setVisible(true);
    timer.start();
    seconds = 1;
    inputHandler = new InputHandler(field.getRobots());
    addKeyListener(inputHandler);
    setFocusable(true);
    requestFocus();

    field.placeHoles();
    removeAll();
    drawAll();
    add(timecounter);
    add(Maplabel);
    repaint();
  }

  public void endGame() {
    timer.stop();
    setVisible(false);
    parent.ShowResults(field.getRobots());
  }

  public void drawAll() {
    // Robots
    Robot r = new Robot("", null, null, 0);
    for (Drawable d : drawables)
      if (d.kindOf(r))
        d.draw(this);

    // Workers
    Worker w = new Worker(null, null);
    for (Drawable d : drawables)
      if (d.kindOf(w))
        d.draw(this);

    // Items
    Oil o = new Oil(null);
    Tacky t = new Tacky(null);
    Hole h = new Hole(null);
    for (Drawable d : drawables)
      if (d.kindOf(o) || d.kindOf(t) || d.kindOf(h))
        d.draw(this);
  }

  public void itemAdded(Item i) {
    GraphicItem gi = new GraphicItem(i);
    drawables.add(gi);
  }

  public void itemRemoved(Item i) {
    for (int j = 0; j < drawables.size(); j++) {
      if (drawables.get(j).isItMe(i)) {
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
      if (drawables.get(j).isItMe(c)) {
        drawables.remove(j);
        break;
      }
    }
  }

  private String getTimeString() {
    int minutes = seconds / 60;
    return new String(Integer.toString(minutes) + " : "
        + Integer.toString(seconds - minutes * 60));
  }

  public void addPlayer(String name, Color cl) {
    field.newRobot(name, cl);
  }
}
