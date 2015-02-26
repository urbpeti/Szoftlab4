import javax.swing.JFrame;


public class Main {
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(600, 600);
		frame.add(new Panel());
		frame.setResizable(false);
		frame.setVisible(true);
	}
}
