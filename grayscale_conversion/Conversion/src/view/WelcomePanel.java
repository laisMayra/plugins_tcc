package view;


import javax.swing.JLabel;


import view.ImageProcessingPanel;

public class WelcomePanel extends ImageProcessingPanel {

	@Override
	public void setupPanel() {
		super.setupPanel();
		this.lblPanelTitle.setText("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
		this.txtPanelDescription.setText("The next steps will help you to identify and analyze nodular graphite that exist in cast iron.\n\nClick the Next button to continue.");
	}
}