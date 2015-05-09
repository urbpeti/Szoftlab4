package Game;

import java.awt.image.BufferedImage;

public class GraphicCreature implements Drawable {
  private Creature creature;
  private BufferedImage image;

  public GraphicCreature(Creature c) {
    creature = c;
  }

  @Override
  public void draw() {
    // TODO Auto-generated method stub

  }

  public boolean isitme(Object o) {
    if (o.equals(creature))
      return true;
    return false;
  }

}
