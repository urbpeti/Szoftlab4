package Game;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

/*
 * A forgatás nem megy még !!!!!!!!
 * A kihelyezés jó, csak nem állítottam vissza!
 * 
 * 
 * 
 * 
 */


public class GraphicItem implements Drawable {
	private Item item;
	private BufferedImage image;
	private JLabel itemlabel;
	private String imagesource;
	
	public GraphicItem(Item i){
		item = i;
		if (item instanceof Hole) imagesource = "Images\\hole.png";
		else if (item instanceof Oil) imagesource="Images\\oil.png";
		else imagesource="Images\\tacky.png";		
	}
	
	public void draw(JPanel p) {
		if(item.exists()){
			initializePicture();
	        /*Graphics2D g = (Graphics2D)image.getGraphics();
	        
	        AffineTransform identity = new AffineTransform();
	        Graphics2D g2d = (Graphics2D)g;
	        AffineTransform trans = new AffineTransform();
	        trans.setTransform(identity);
	        trans.rotate( Math.toRadians(item.position.getAngle()) );*/
	        
			
			AffineTransform tx = new AffineTransform();
			BufferedImage image2 = (BufferedImage)image;
			// last, width = height and height = width :)
			tx.translate(image2.getHeight() / 2,image2.getWidth() / 2);
			tx.rotate(Math.toRadians(item.position.getAngle()));
			// first - center image at the origin so rotate works OK
			tx.translate(-image2.getWidth() / 2,-image2.getHeight() / 2);

			AffineTransformOp op = new AffineTransformOp(tx, AffineTransformOp.TYPE_BILINEAR);

			// new destination image where height = width and width = height.
			BufferedImage newImage =new BufferedImage(image2.getHeight(), image2.getWidth(), image2.getType());
			op.filter(image2, newImage);
			
			
			
			
			itemlabel = new JLabel(new ImageIcon(newImage));
			//itemlabel.setRotation(2);
	        p.add(itemlabel);
	        p.setComponentZOrder(itemlabel, 0);
	        //itemlabel.setRotation(Math.toRadians(item.position.getAngle()));
	        //itemlabel.setRotation(1);
	        itemlabel.setBounds((int)(380+280*Math.cos(Math.toRadians(item.position.getAngle()))), (int)(380+280*Math.sin(Math.toRadians(item.position.getAngle()))), 40, 40);
		}
	}

	public boolean isitme(Object o) {
		if (o == item) return true;
		else return false;
		
	}
	
	private void initializePicture(){
		try {
			image = ImageIO.read(new File(imagesource));
			//image = (BufferedImage) image.getScaledInstance(38, 45, 1);
			//itemlabel = new JLabel(new ImageIcon(image));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	private class RotateLabel extends JLabel{
		
		private double rotation = 0;
		
		public RotateLabel(ImageIcon imageIcon) {
			super(imageIcon);
		}

		public void setRotation(double r){
			rotation = r;
		}
		
		@Override
		public void paintComponent(Graphics g){
			Graphics2D gx = (Graphics2D)g;
			gx.rotate(rotation, getX() + getWidth()/2, getY() + getHeight()/2);
			super.paintComponent(g);
		}
	}

}
