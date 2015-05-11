package Game;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ResultsView extends JPanel {
  /**
   * 
   */
  private static final long serialVersionUID = -2289008529287554157L;
  private Main parent;
  private Image map;

  public ResultsView(Main m) {
    parent = m;
    setBackground(Color.white);
    setLayout(null);
    /*addMouseListener(new MouseAdapter() {
      @Override
      public void mousePressed(MouseEvent e) {
        super.mousePressed(e);
        setVisible(false);
        parent.nullGame();
        parent.ShowMenu();
      }
    });*/
  }

  public void present(ArrayList<Robot> l) {
    /*l.sort(new Comparator<Robot>() {

      public int compare(Robot o1, Robot o2) {
        return (int) (o2.distance - o1.distance);
      }

    });*/

    // Names

    Font font = new Font("Verdana", Font.ITALIC, 20);
    for (int i = 0; i < l.size(); i++) {
      JLabel j = new JLabel(l.get(i).getName());
      j.setFont(font);
      add(j);
      j.setBounds(350, 100 * (i + 1) + 150, 180, 50);
      JLabel k = new JLabel(Integer.toString((int) l.get(i).distance));
      add(k);
      k.setFont(font);
      k.setForeground(Color.GRAY);
      k.setBounds(530, 100 * (i + 1) + 150, 200, 50);

      try {
        if (l.get(i).getColor().equals(Color.green))
          draw_green(i);
        else if (l.get(i).getColor().equals(Color.red))
          draw_red(i);
        else
          draw_cyan(i);
      } catch (IOException e1) {
        parent.FailureinGui("Playericon image load failure");
        e1.printStackTrace();
      }
    }
    
    //Button
    JButton back = new JButton("BACK");
    back.setForeground(new Color(121, 107, 255));
    back.addActionListener(new ActionListener() {
      
      public void actionPerformed(ActionEvent e) {
        setVisible(false);
        parent.nullGame();
        parent.ShowMenu();
      }
    });
    back.setBorderPainted(false); 
        back.setContentAreaFilled(false); 
        back.setFocusPainted(false); 
        back.setOpaque(false);
    back.setBounds(300, 550, 200, 50);
    back.setFont(new Font("Verdana", Font.PLAIN, 30));
    add(back);

    // Map image
    try {
      map = ImageIO.read(new File("Images/map.png"));
      map = map.getScaledInstance(800, 800, 1);
      JLabel Maplabel = new JLabel(new ImageIcon(map));
      add(Maplabel);
      Maplabel.setBounds(0, 0, 800, 800);
      setComponentZOrder(Maplabel, 3);
    } catch (IOException e1) {
      parent.FailureinGui("Map image load failure");
      e1.printStackTrace();
    }

    setVisible(true);
  }

  private void draw_green(int position) throws IOException {
    map = ImageIO.read(new File("Images/player_green.png"));
    map = map.getScaledInstance(70, 70, 1);
    JLabel playericonlabel_green = new JLabel(new ImageIcon(map));
    add(playericonlabel_green);
    playericonlabel_green.setBounds(230, 230 + position * 100, 90, 90);
  }

  private void draw_red(int position) throws IOException {
    map = ImageIO.read(new File("Images/player_red.png"));
    map = map.getScaledInstance(70, 70, 1);
    JLabel playericonlabel_red = new JLabel(new ImageIcon(map));
    add(playericonlabel_red);
    playericonlabel_red.setBounds(230, 230 + position * 100, 90, 90);
  }

  private void draw_cyan(int position) throws IOException {
    map = ImageIO.read(new File("Images/player_cyan.png"));
    map = map.getScaledInstance(70, 70, 1);
    JLabel playericonlabel_cyan = new JLabel(new ImageIcon(map));
    add(playericonlabel_cyan);
    playericonlabel_cyan.setBounds(230, 230 + position * 100, 90, 90);
  }

}
