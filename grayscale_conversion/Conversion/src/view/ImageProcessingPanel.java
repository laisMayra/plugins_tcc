package view;

import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;
import javax.swing.border.EtchedBorder;

public abstract class ImageProcessingPanel extends JPanel {
	protected JLabel lblPanelTitle;
	protected JTextPane txtPanelDescription;
	
	public ImageProcessingPanel() {
		this.setupPanel();
	}
		
	public void setupPanel() {	
		setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
//		statusPanel.setBounds(12, 12, 241, 419);
//		setBounds(12, 12, 418, 419);
		setBounds(12, 12, 225, 160);

		setLayout(null);
		this.lblPanelTitle = new JLabel();
		this.lblPanelTitle.setHorizontalAlignment(SwingConstants.CENTER);
		this.lblPanelTitle.setFont(new Font("Dialog", Font.BOLD, 14));
		this.lblPanelTitle.setBounds(12, 12, 394, 29);
		add(this.lblPanelTitle);
		this.txtPanelDescription = new JTextPane();
		this.txtPanelDescription.setEditable(false);
//		this.txtPanelDescription.setBounds(0, 0, 225, 160);
		add(this.txtPanelDescription);
	}
	
	public String getPanelTitle() {
		return this.lblPanelTitle.getText();
	}
}