package Game;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

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
  private static final long serialVersionUID = 4041578561937564998L;
  private Main parent;
	private ArrayList<JTextField> nameFields;
	private JButton start;
	private int colornumber;
	private Image map;
	
	public MenuView(Main m) {
		parent = m;
		setBackground(Color.white);
		setLayout(null);
		
		//Playericons
		try {
		  int w = 90;
			map = ImageIO.read(new File("Images/player_green.png"));
			map = map.getScaledInstance(w - 20, w - 20, 1);
			JLabel playericonlabel_green = new JLabel(new ImageIcon(map));
			add(playericonlabel_green);
			playericonlabel_green.setBounds(230, 230, w, w);
			
			map = ImageIO.read(new File("Images/player_red.png"));
			map = map.getScaledInstance(w - 20, w - 20, 1);
			JLabel playericonlabel_red = new JLabel(new ImageIcon(map));
			add(playericonlabel_red);
			playericonlabel_red.setBounds(230, 330, w, w);
			
			map = ImageIO.read(new File("Images/player_cyan.png"));
			map = map.getScaledInstance(w - 20, w - 20, 1);
			JLabel playericonlabel_cyan = new JLabel(new ImageIcon(map));
			add(playericonlabel_cyan);
			playericonlabel_cyan.setBounds(230, 430, w, w);
			
		} catch (IOException e1) {
			parent.FailureinGui("Playericon image load failure");
			e1.printStackTrace();
		}
		
		//Textfields
		colornumber = 0;
		final Color[] colors = {Color.green, Color.red, Color.cyan};
		Font font = new Font("Verdana",Font.ITALIC, 20);
		nameFields = new ArrayList<JTextField>();
		for (int i=0; i<3; i++){
		  PlaceholderTextField j = new PlaceholderTextField("");
			j.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, new Color(213, 213, 213)));
			j.setColumns(20);
	    j.setPlaceholder("Enter name");
			j.setFont(font);

			nameFields.add(j);
			add(j);
			j.setBounds(350, 100 * (i+1) +150 ,200,50);
			
		}
		
		//Button
		start = new JButton("START");
		start.setForeground(new Color(121, 107, 255));
		start.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
			  if (nameFields.get(0).getText().equals("")) return;
			  
				for (JTextField jTextField : nameFields) {
					if (!jTextField.getText().equals("")){
						parent.AddPlayer(jTextField.getText(), colors[colornumber++]);
					}
					setVisible(false);
				}				
				parent.ShowGame();
			}
		});
		start.setBorderPainted(false); 
        start.setContentAreaFilled(false); 
        start.setFocusPainted(false); 
        start.setOpaque(false);
		start.setBounds(300, 550, 200, 50);
		start.setFont(new Font("Verdana", Font.PLAIN, 30));
		add(start);
				
		//Map image
		try {
			map = ImageIO.read(new File("Images/map.png"));
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
	
	public void handleStart(){
		
	}
	
	public void present(){
		setVisible(true);
	}

}
