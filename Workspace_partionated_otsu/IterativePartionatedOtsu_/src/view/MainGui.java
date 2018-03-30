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
		setTitle("Local Otsu");
		setBounds(100, 100, 480, 506);
		getContentPane().setLayout(new BorderLayout());
		mainPanel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		getContentPane().add(mainPanel, BorderLayout.CENTER);
		mainPanel.setLayout(null);
		
		JPanel buttonPane = new JPanel();
		buttonPane.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
		getContentPane().add(buttonPane, BorderLayout.SOUTH);
		
		this.btnCancel = new JButton("Cancel");
		buttonPane.add(this.btnCancel);
					
		Component rigidArea = Box.createRigidArea(new Dimension(20, 20));
		buttonPane.add(rigidArea);
					
		this.btnFinish = new JButton("Finish");
		this.btnFinish.setVisible(false);
		buttonPane.add(this.btnFinish);
	}
}