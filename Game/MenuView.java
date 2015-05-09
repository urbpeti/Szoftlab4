package Game;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class MenuView extends JPanel {
  /**
   * 
   */
  private static final long serialVersionUID = 1L;
  private Main parent;
  private ArrayList<JTextField> nameFields;
  private List<BufferedImage> roboticons;
  private JButton start;
  private int colornumber;
  private Image map;

  public MenuView(Main m) {
    parent = m;
    setBackground(Color.white);
    setLayout(null);

    // Playericons
    try {
      map = ImageIO.read(new File("Images\\player_green.png"));
      map = map.getScaledInstance(80, 80, 1);
      JLabel playericonlabel_green = new JLabel(new ImageIcon(map));
      add(playericonlabel_green);
      playericonlabel_green.setBounds(220, 225, 100, 100);

      map = ImageIO.read(new File("Images\\player_red.png"));
      map = map.getScaledInstance(80, 80, 1);
      JLabel playericonlabel_red = new JLabel(new ImageIcon(map));
      add(playericonlabel_red);
      playericonlabel_red.setBounds(220, 325, 100, 100);

      map = ImageIO.read(new File("Images\\player_cyan.png"));
      map = map.getScaledInstance(80, 80, 1);
      JLabel playericonlabel_cyan = new JLabel(new ImageIcon(map));
      add(playericonlabel_cyan);
      playericonlabel_cyan.setBounds(220, 425, 100, 100);

    } catch (IOException e1) {
      parent.FailureinGui("Playericon image load failure");
      e1.printStackTrace();
    }

    // Textfields
    colornumber = 0;
    final Color[] colors = { Color.green, Color.red, Color.cyan };
    Font font = new Font("Verdana", Font.ITALIC, 20);
    nameFields = new ArrayList<JTextField>();
    for (int i = 0; i < 3; i++) {
      JTextField j = new JTextField("");
      if (i == 0)
        j.setText("Player name");
      j.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.BLACK));
      j.setFont(font);
      nameFields.add(j);
      add(j);
      j.setBounds(350, 100 * (i + 1) + 150, 200, 50);

    }

    // Button
    start = new JButton("START");
    start.addActionListener(new ActionListener() {

      public void actionPerformed(ActionEvent e) {
        for (JTextField jTextField : nameFields) {
          if (!jTextField.getText().equals("")) {
            parent.AddPlayer(jTextField.getText(), colors[colornumber++]);
          }
        }

      }
    });
    start.setBorderPainted(false);
    start.setContentAreaFilled(false);
    start.setFocusPainted(false);
    start.setOpaque(false);
    start.setBounds(300, 550, 200, 50);
    start.setFont(new Font("Arial", Font.PLAIN, 30));
    add(start);

    // Map image
    try {
      map = ImageIO.read(new File("Images\\map.png"));
      map = map.getScaledInstance(800, 800, 1);
      JLabel Maplabel = new JLabel(new ImageIcon(map));
      add(Maplabel);
      Maplabel.setBounds(0, 0, 800, 800);
      setComponentZOrder(Maplabel, 4);
    } catch (IOException e1) {
      parent.FailureinGui("Map image load failure");
      e1.printStackTrace();
    }

  }

  public void handleStart() {

  }

  public void present() {
    setVisible(true);
  }

}
