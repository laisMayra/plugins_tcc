package view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Component;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EtchedBorder;

import javax.swing.Box;

public class MainGui extends JDialog {

	private final JPanel mainPanel = new JPanel();
	
	private JButton btnCancel;
	private JButton btnBack;
	private JButton btnNext;
	private JButton btnFinish;
	
	private JPanel imageProcessingPanel;
	
	private JLabel labelList[];

	public JButton getBtnCancel() {
        return this.btnCancel;
    }
	
	public JButton getBtnBackl() {
        return this.btnBack;
    }
	
	public JButton getBtnNext() {
		return this.btnNext;
	}
	
	public JButton getBtnBack() {
		return this.btnBack;
	}
	
	public JButton getBtnFinish() {
		return this.btnFinish;
	}
	
	public JPanel getMainPanel() {
		return this.mainPanel; 
	}
	
	public JLabel[] getLabelList() {
		return this.labelList;
	}
	
	public void setImagePocessingPanel(JPanel newPanel) {
		if (this.imageProcessingPanel != null) {
			this.mainPanel.remove(this.imageProcessingPanel);
		}
		this.imageProcessingPanel = newPanel;
		this.imageProcessingPanel.isVisible();
		this.mainPanel.add(this.imageProcessingPanel);
		this.mainPanel.repaint();
	}
	
	public MainGui() {
		setTitle("Greyscale Conversion");
		setBounds(100, 100, 250, 250);
		getContentPane().setLayout(new BorderLayout());
		mainPanel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		getContentPane().add(mainPanel, BorderLayout.CENTER);
		mainPanel.setLayout(null);
		
//		JPanel statusPanel = new JPanel();
//		statusPanel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
//		statusPanel.setBounds(12, 12, 241, 419);
//		mainPanel.add(statusPanel);
//		statusPanel.setLayout(null);

//		this.labelList = new JLabel[7];
//		
//		JLabel lblFrame0 = new JLabel("Frame 0");
//		lblFrame0.setHorizontalAlignment(SwingConstants.CENTER);
//		lblFrame0.setBounds(12, 142, 217, 15);
//		statusPanel.add(lblFrame0);
//		this.labelList[0] = lblFrame0;
//		JLabel lblFrame1 = new JLabel("Frame 1");
//		lblFrame1.setHorizontalAlignment(SwingConstants.CENTER);
//		lblFrame1.setBounds(12, 169, 217, 15);
//		statusPanel.add(lblFrame1);
//		this.labelList[1] = lblFrame1;
////		JLabel lblFrame2 = new JLabel("Frame 2");
//		lblFrame2.setHorizontalAlignment(SwingConstants.CENTER);
//		lblFrame2.setBounds(12, 196, 217, 15);
//		statusPanel.add(lblFrame2);
//		this.labelList[2] = lblFrame2;
//		JLabel lblFrame3 = new JLabel("Frame 3");
//		lblFrame3.setHorizontalAlignment(SwingConstants.CENTER);
//		lblFrame3.setBounds(12, 223, 217, 15);
//		statusPanel.add(lblFrame3);
//		this.labelList[3] = lblFrame3;
//		JLabel lblFrame4 = new JLabel("Frame 4");
//		lblFrame4.setHorizontalAlignment(SwingConstants.CENTER);
//		lblFrame4.setBounds(12, 250, 217, 15);
//		statusPanel.add(lblFrame4);
//		this.labelList[4] = lblFrame4;
//		JLabel lblFrame5 = new JLabel("Frame 5");
//		lblFrame5.setHorizontalAlignment(SwingConstants.CENTER);
//		lblFrame5.setBounds(12, 277, 217, 15);
//		statusPanel.add(lblFrame5);
//		this.labelList[5] = lblFrame5;
//		JLabel lblFrame6 = new JLabel("Frame 6");
//		lblFrame6.setHorizontalAlignment(SwingConstants.CENTER);
//		lblFrame6.setBounds(12, 304, 217, 15);
//		statusPanel.add(lblFrame6);
//		this.labelList[6] = lblFrame6;
		
		JPanel buttonPane = new JPanel();
		buttonPane.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
		getContentPane().add(buttonPane, BorderLayout.SOUTH);
		
		this.btnCancel = new JButton("Cancel");
		buttonPane.add(this.btnCancel);
					
		Component rigidArea = Box.createRigidArea(new Dimension(20, 20));
		buttonPane.add(rigidArea);
//		
//		this.btnBack = new JButton("Back");
//		buttonPane.add(this.btnBack);
//		
//		this.btnNext = new JButton("Next");
//		buttonPane.add(this.btnNext);
//					
//		this.btnFinish = new JButton("Finish");
//		this.btnFinish.setVisible(false);
//		buttonPane.add(this.btnFinish);
	}
}