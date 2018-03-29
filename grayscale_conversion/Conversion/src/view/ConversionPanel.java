package view;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JRadioButton;

import controller.ConversionController;
import ij.ImagePlus;
import model.ConversionModel;

public class ConversionPanel extends ImageProcessingPanel {

	protected JButton btnBinarization;
	protected JButton btnROISelection;
	protected JLabel width, heigth;
	private JRadioButton desaturation, media, luminance;
//	private RadioButtonHandler handler;
	private ButtonGroup conveersionTypes;
	
	@Override
	public void setupPanel() {
		super.setupPanel();

		desaturation = new JRadioButton("Desaturation");
		desaturation.setBounds(12, 24, 137, 25);
		media = new JRadioButton("Avarage");
		media.setBounds(12, 61, 117, 25);
		luminance = new JRadioButton("Luminance");
		luminance.setBounds(12, 98, 117, 25);
		
		this.add(this.desaturation);
		this.add(this.media);
		this.add(this.luminance);
		
		conveersionTypes = new ButtonGroup();
		conveersionTypes.add(desaturation);
		conveersionTypes.add(media);
		conveersionTypes.add(luminance);
		
//		handler = new RadioButtonHandler();
//		colorToGray.addItemListener(handler);
//		desaturation.addItemListener(handler);
//		media.addItemListener(handler);
//		luminance.addItemListener(handler);
		
//		//Selection Button
//		this.btnROISelection = new JButton("Select");
//		this.btnROISelection.setBounds(312, 321, 117, 25);
//		this.add(this.btnROISelection);
//		
//		//Binarization Button
//		this.lblPanelTitle.setText("Binarization");
//		this.txtPanelDescription.setText("Use the tool **** to select the area that represents...");
//		this.btnBinarization = new JButton("Binarization");
//		this.btnBinarization.setBounds(175, 371, 117, 25);
//		this.add(this.btnBinarization);		
		
	}
	
	public JButton getBtnBinarization() {
		return this.btnBinarization; 
	}
	public JButton getBtnROISelection() {
		return this.btnROISelection; 
	}
	
	public void radiobuttonHandler( ) {
		if(desaturation.isSelected())
			System.out.println("desaturation");
		else if(media.isSelected())
			System.out.println("media");
		else if(luminance.isSelected())
			System.out.println("luminance");
		
	}

	public JRadioButton getDesaturation() { return desaturation; }

	public void setDesaturation(JRadioButton desaturation) {
		this.desaturation = desaturation;
	}

	public JRadioButton getMedia() { return media;	}

	public void setMedia(JRadioButton media) {
		this.media = media;
	}

	public JRadioButton getLuminance() { return luminance;	}

	public void setLuminance(JRadioButton luminance) {
		this.luminance = luminance;
	}	
	

}
	
//	public class RadioButtonHandler implements ItemListener{
//	
//		@Override
//		public void itemStateChanged(ItemEvent e) {
//			if(luminance.isSelected())
//				System.out.println("luminance");
//		}	
//	}
	
	
		
	
	
