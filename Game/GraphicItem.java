package Game;

import java.awt.image.BufferedImage;

public class GraphicItem implements Drawable {
  private Item item;
  private BufferedImage image;

  public GraphicItem(Item i) {

  }

  @Override
  public void draw() {
    // TODO Auto-generated method stub

  }

  public boolean isitme(Object o) {
    if (o.equals(item))
      return true;
    else
      return false;

  }

}
