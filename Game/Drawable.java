package Game;

import javax.swing.JPanel;

public interface Drawable {
  public void draw(JPanel p);

  public boolean isItMe(Object o);

  public boolean kindOf(Object o);
}
