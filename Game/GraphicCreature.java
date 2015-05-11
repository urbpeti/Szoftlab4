package Game;

import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class GraphicCreature implements Drawable {
  private Creature creature;
  private Image image;
  private static int colorcount = 0;
  private JLabel robotlabel;
  private static final String[] imagesources = { "Images\\ingame_green.png",
      "Images\\ingame_red.png", "Images\\ingame_cyan.png" };

  public GraphicCreature(Creature c) {
    creature = c;
    if (c instanceof Robot) {
      try {
        image = ImageIO.read(new File(imagesources[colorcount++]));
        image = image.getScaledInstance(40, 40, 1);
        robotlabel = new JLabel(new ImageIcon(image));
      } catch (IOException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }
    } else {
      try {
        image = ImageIO.read(new File("Images\\worker.png"));
        image = image.getScaledInstance(30, 30, 1);
        robotlabel = new JLabel(new ImageIcon(image));
      } catch (IOException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }
    }
  }

  @Override
  public void draw(JPanel p) {
    if (!(creature.getIsDead())) {
      p.add(robotlabel);
      robotlabel.setBounds((int) (380 + 280 * Math.cos(Math.toRadians(creature
          .getPosition().getAngle()))), (int) (380 + 280 * Math.sin(Math
          .toRadians(creature.getPosition().getAngle()))), 40, 40);
    }
  }

  public boolean isItsMe(Object o) {
    if (o.equals(creature))
      return true;
    return false;
  }

  public static void setColorCount(int i) {
    colorcount = i;
  }

}
