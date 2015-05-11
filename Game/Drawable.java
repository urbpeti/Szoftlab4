package Game;

import javax.swing.JPanel;

public interface Drawable {
	public void draw(JPanel p);
	public boolean isItsMe(Object o);
}
