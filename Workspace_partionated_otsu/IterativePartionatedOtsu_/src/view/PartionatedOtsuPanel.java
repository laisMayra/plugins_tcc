package view;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

import ij.IJ;
import view.ImageProcessingPanel;

public class PartionatedOtsuPanel extends ImageProcessingPanel{

	protected JButton btnBinarization, btnReset, btnROISelection;
	protected JLabel width, heigth;
	protected JTextField widthSelected, heigthSelected;
	protected BufferedImage myPicture;
	
	@Override
	public void setupPanel(){
		super.setupPanel();

		//Width
		this.width = new JLabel("Width");
		this.width.setBounds(80, 321, 117, 25);
		this.add(this.width);
		this.widthSelected = new JTextField("00.00");
		this.widthSelected.setEditable(false);
		this.widthSelected.setBounds(130, 321, 50, 25);
		
		//Heigth
		this.heigth = new JLabel("Heigth");
		this.heigth.setBounds(280, 321, 117, 25);
		this.add(this.heigth);
		this.heigthSelected = new JTextField("00.00");
		this.heigthSelected.setEditable(false);
		this.heigthSelected.setBounds(330, 321, 50, 25);
		
		//Binarization Button
		this.lblPanelTitle.setText("Binarization");
		this.txtPanelDescription.setText
		("Use the Rectangle selection tool to select the area that will be used as the parameter to the threshold algorithm." + 
				"\nThe selection should be of the largest sample of the area of interest, with a small portion of the non-interest area."
				+ "\nAn example can be seen below.");
		try  {
			//Insert image on screen
			URL url = new URL("https://github.com/laisMayra/plugins_tcc/blob/master/image.png?raw=true");
			myPicture = ImageIO.read(url);

			JLabel picLabel = new JLabel(new ImageIcon(myPicture));
			picLabel.setBounds(12, 150, 434, 150);
			this.add(picLabel);
		}
		catch (IOException ex) {
			IJ.showMessage("Example image not found!");
		}
		
		
		
		this.btnBinarization = new JButton("Binarization");
		this.btnBinarization.setBounds(270, 371, 120, 25);
		this.add(this.btnBinarization);
		this.getBtnBinarization().setEnabled(false);
		
		//Reset Button
		this.btnReset = new JButton("Reset");
		this.btnReset.setBounds(70, 371, 120, 25);
		this.add(this.btnReset);
		
		this.add(this.widthSelected);
		this.add(this.heigthSelected);
	}
	


	public JButton getBtnBinarization(){ return this.btnBinarization; }
	public JButton getBtnROISelection(){ return this.btnROISelection; }
	public JButton getBtnReset(){ return this.btnReset; }	
	
	public void setWidthSelected(String width){
		this.widthSelected.setText(width);
	}
	public void setHeigthSelected(String heigth){
		this.heigthSelected.setText(heigth);
	}
	
	public void setBtnBinarization(JButton btnBinarization) {
		this.btnBinarization = btnBinarization;
	}

	public void setBtnReset(JButton btnReset) {
		this.btnReset = btnReset;
	}
	
}