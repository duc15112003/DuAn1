package GUI;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;



public class ProgressBarGUI {
	
	JFrame frame;
	JProgressBar br;
	boolean ret = true;
	private JProgressBar progressBar;
	public ProgressBarGUI() {
		init();
		
	}
	private void init() {
		frame = new JFrame();
		frame.setSize(641, 339);
        frame.setUndecorated(true);
		frame.setLocationRelativeTo(null);
		frame.setBackground(Color.white);
		frame.getContentPane().setLayout(null);
		
		
		
		JLabel lblPanelAnh = new JLabel("");
		lblPanelAnh.setIcon(new ImageIcon(getClass().getResource("/panelhome.png")));
		lblPanelAnh.setBounds(0, 0, 655, 300);
		frame.getContentPane().add(lblPanelAnh);
		progressBar = new JProgressBar();
		progressBar.setBounds(0, 299, 639, 39);
		frame.getContentPane().add(progressBar);

		
		frame.setVisible(true);
		set();
	}
	
	public void set() {
		int i = 0;
        try {
            while (i <= 100) {
            	
                progressBar.setValue(i + 10);
                Thread.sleep(5);
                i += 1;
            }
    		if(progressBar.getValue()==100) {
    			new LoginGUI();
    			frame.setVisible(false);
    		}
        } catch (Exception e) {
        }
	}
	
	public static void main(String[] args) {
		new ProgressBarGUI();
	}
}
