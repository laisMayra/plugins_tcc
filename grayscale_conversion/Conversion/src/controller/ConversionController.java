package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import model.ConversionModel;
import view.ConversionPanel;
import view.ImageProcessingPanel;

public class ConversionController extends ImageProcessingPanelController{
    protected ConversionPanel conversionPanel;
    protected ConversionModel conversionModel;
    
    @Override
    public void panelController() {
    	this.conversionPanel = new ConversionPanel();
        this.conversionModel = new ConversionModel();
//        this.conversionModel.converion();
//        this.conversionPanel.getBtnBinarization().addActionListener(new PartionatedOtsuButtonBinarizationListener(this.partionatedOtsuModel));
//        this.partionatedOtsuPanel.getBtnROISelection().addActionListener(new PartionatedOtsuButtonROISelectionListener(this.partionatedOtsuModel, this.partionatedOtsuPanel));
        this.conversionPanel.getLuminance().addActionListener(new RadioButtonListener(this.conversionModel, 0));
        this.conversionPanel.getMedia().addActionListener(new RadioButtonListener(this.conversionModel, 1));
        this.conversionPanel.getDesaturation().addActionListener(new RadioButtonListener(this.conversionModel, 2));

    }
    
    public ConversionPanel getConversionPanel() { return conversionPanel; }
	public ConversionModel getConversionModel() { return conversionModel; }
	
	public ImageProcessingPanel getPanelView() { return this.conversionPanel; }
}

//ActionListener actionListener = new ActionListener() {
//    @Override
//    public void actionPerformed(ActionEvent e) {
//        if(e.getSource() instanceof JRadioButton){
//            JRadioButton radioButton = (JRadioButton) e.getSource();
//            if(radioButton.isSelected()){
//                jtfAnswer.setText(radioButton.getText());
//            }
//        }
//    }
//}

//class RadioButtonListener implements ActionListener{
//	protected ConversionPanel conversionPanel;
//	
//	public RadioButtonListener(ConversionPanel conversionPanel){
//		this.conversionPanel = conversionPanel;
//	}
//	
//	@Override
//	public void actionPerformed(ActionEvent e) {
//		this.conversionPanel.radiobuttonHandler();
////		System.out.println("hahahaha");
//	}
//}

class RadioButtonListener implements ActionListener{
	protected ConversionModel conversionModel;
	protected int method; 
	
	public RadioButtonListener(ConversionModel conversionModel, int method){
		this.conversionModel = conversionModel;
		this.method = method;
	}
	
	@Override
	public void actionPerformed(ActionEvent e){
		switch (method){
			case 0:
				conversionModel.luminanceConversion();
				break;
			case 1:
				conversionModel.mediaConversion();
				break;
			case 2:
				conversionModel.desaturationConversion();
				break;
			default:
				System.out.println("Error: Unknown method!");		
		}
	}
}


//class PartionatedOtsuButtonROISelectionListener implements ActionListener{
//	protected PartionatedOtsuModel partionatedOtsuModel;
//	protected PartionatedOtsuPanel partionatedOtsuPanel;
//	
//	public PartionatedOtsuButtonROISelectionListener(PartionatedOtsuModel partionatedOtsuModel, PartionatedOtsuPanel partionatedOtsuPanel){
//		this.partionatedOtsuModel = partionatedOtsuModel;
//		this.partionatedOtsuPanel = partionatedOtsuPanel;
//	}
//	
//	 @Override
//	 public void actionPerformed(ActionEvent e) {
//  		this.partionatedOtsuModel.getSelectedROI(partionatedOtsuPanel);
//	 } 
//}