package Game;

import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;

public class InputHandler extends KeyAdapter {
  private List<Robot> robots;

  public InputHandler(ArrayList<Robot> robots) {
    this.robots = robots;
  }

  public void keyPressed(KeyEvent e) {

    // Elsõ játékos
    if (!robots.get(0).getIsDead()) {
      switch (e.getKeyChar()) {
      case 'a':
        robots.get(0).accelerate();
        break;

      case 'd':
        robots.get(0).decelerate();
        break;

      case 'q':
        robots.get(0).setItemCache(
            new Tacky(new Angle(robots.get(0).getPosition().getAngle())));
        break;

      case 'e':
        robots.get(0).setItemCache(
            new Oil(new Angle(robots.get(0).getPosition().getAngle())));
        break;

      default:
        break;
      }
    }

    // Második játékos

    if ((robots.size() > 1) && !robots.get(1).getIsDead()) {
      switch (e.getKeyChar()) {
      case 'j':
        robots.get(1).accelerate();
        break;

      case 'l':
        robots.get(1).decelerate();
        break;

      case 'u':
        robots.get(1).setItemCache(
            new Tacky(new Angle(robots.get(1).getPosition().getAngle())));
        break;

      case 'o':
        robots.get(1).setItemCache(
            new Oil(new Angle(robots.get(1).getPosition().getAngle())));
        break;

      default:
        break;
      }
    }

    // Harmadik játékos
    if ((robots.size() > 2) && !robots.get(2).getIsDead()) {
      switch (e.getKeyChar()) {
      case '4':
        robots.get(2).accelerate();
        break;

      case '6':
        robots.get(2).decelerate();
        break;

      case '7':
        robots.get(2).setItemCache(
            new Tacky(new Angle(robots.get(2).getPosition().getAngle())));
        break;

      case '9':
        robots.get(2).setItemCache(
            new Oil(new Angle(robots.get(2).getPosition().getAngle())));
        break;

      default:
        break;
      }
    }

  }

}
