package Game;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.geom.AffineTransform;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class GraphicItem extends JPanel implements Drawable {
  /**
   * 
   */
  private static final long serialVersionUID = -1809070250854807982L;
  private Item item;
  private Image image;

  public GraphicItem(Item i) {
    super();

    item = i;
    String imagesource;
    if (item instanceof Hole)
      imagesource = "Images\\hole.png";
    else if (item instanceof Oil)
      imagesource = "Images\\oil.png";
    else
      imagesource = "Images\\tacky.png";

    try {
      image = ImageIO.read(new File(imagesource));
    } catch (IOException e) {
      e.printStackTrace();
    }
    image = image.getScaledInstance(47, 47, 1);

    setOpaque(false);
  }

  public void draw(JPanel p) {
      p.add(this);
      double d = Math.toRadians(item.position.getAngle());

      this.setBounds((int) (370 + 280 * Math.cos(d)),
          (int) (370 + 280 * Math.sin(d)), 60, 60);
  }

  public boolean isItsMe(Object o) {
    if (item.equals(o))
      return true;
    return false;
  }

  @Override
  public void paintComponent(Graphics g) {
    super.paintComponent(g);
    Graphics2D g2d = (Graphics2D) g;
    g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
        RenderingHints.VALUE_ANTIALIAS_ON);
    g2d.setRenderingHint(RenderingHints.KEY_RENDERING,
        RenderingHints.VALUE_RENDER_QUALITY);

    AffineTransform at = new AffineTransform();
    at.translate(getWidth() / 2, getHeight() / 2);
    at.rotate(Math.toRadians(item.position.getAngle() + 90));
    at.translate(-image.getWidth(null) / 2, -image.getHeight(null) / 2);

    g2d.drawImage(image, at, null);
  }
}
