package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import ij.IJ;
import ij.ImageListener;
import ij.ImagePlus;
import ij.gui.RoiListener;
import model.PartionatedOtsuModel;
import view.ImageProcessingPanel;
import view.PartionatedOtsuPanel;

public class PartionatedOtsuController extends ImageProcessingPanelController{
    protected PartionatedOtsuPanel partionatedOtsuPanel;
    protected PartionatedOtsuModel partionatedOtsuModel;
    
    @Override
    public void panelController() {
    	this.partionatedOtsuPanel = new PartionatedOtsuPanel();
        this.partionatedOtsuModel = new PartionatedOtsuModel();
        
        this.partionatedOtsuPanel.getBtnBinarization().addActionListener(new PartionatedOtsuButtonBinarizationListener(this.partionatedOtsuModel, this.partionatedOtsuPanel));
        this.partionatedOtsuPanel.getBtnReset().addActionListener(new PartionatedOtsuButtonResetListener(this.partionatedOtsuModel, this.partionatedOtsuPanel));
        this.partionatedOtsuModel.getRoi().addRoiListener(new PartionatedOtsuRoiListener(this.partionatedOtsuModel, this.partionatedOtsuPanel));
        this.partionatedOtsuModel.getImage().addImageListener(new ImageListener2(this.partionatedOtsuModel, this.partionatedOtsuPanel));
    }
    
    public ImageProcessingPanel getPanelView() {
		return this.partionatedOtsuPanel;
	}
}

//Image listener
class ImageListener2 implements ImageListener {
	boolean active = true;
	protected PartionatedOtsuModel partionatedOtsuModel;
	protected PartionatedOtsuPanel partionatedOtsuPanel;
	
	
	public ImageListener2(PartionatedOtsuModel partionatedOtsuModel, PartionatedOtsuPanel partionatedOtsuPanel){
		this.partionatedOtsuModel = partionatedOtsuModel;
		this.partionatedOtsuPanel = partionatedOtsuPanel;
	}

	@Override
	public void imageOpened(ImagePlus imp) {		
		partionatedOtsuModel.setNewImage();
		System.out.println("open");		
	}

	@Override
	public void imageClosed(ImagePlus imp) {
			System.out.println("close");
	}

	@Override
	public void imageUpdated(ImagePlus imp) {
		// TODO Auto-generated method stub
	}
}


//Roi listener
class PartionatedOtsuRoiListener implements RoiListener	{
	protected PartionatedOtsuModel partionatedOtsuModel;
	protected PartionatedOtsuPanel partionatedOtsuPanel;
	
	
	public PartionatedOtsuRoiListener(PartionatedOtsuModel partionatedOtsuModel, PartionatedOtsuPanel partionatedOtsuPanel){
		this.partionatedOtsuModel = partionatedOtsuModel;
		this.partionatedOtsuPanel = partionatedOtsuPanel;
	}
	
	@Override
	public void roiModified(ImagePlus img, int id) {
		this.partionatedOtsuModel.setRoiDimentions(partionatedOtsuPanel);
		this.partionatedOtsuModel.disableEnableButtons(partionatedOtsuPanel);
	}
}

//Binarization Button
class PartionatedOtsuButtonBinarizationListener implements ActionListener{
	protected PartionatedOtsuModel partionatedOtsuModel;
	protected PartionatedOtsuPanel partionatedOtsuPanel;
	
	public PartionatedOtsuButtonBinarizationListener(PartionatedOtsuModel partionatedOtsuModel, PartionatedOtsuPanel partionatedOtsuPanel){
		this.partionatedOtsuModel = partionatedOtsuModel;
		this.partionatedOtsuPanel = partionatedOtsuPanel;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		this.partionatedOtsuModel.applyBinarization(this.partionatedOtsuPanel);
	}
}

//Reset Button
class PartionatedOtsuButtonResetListener implements ActionListener{
	protected PartionatedOtsuModel partionatedOtsuModel;
	protected PartionatedOtsuPanel partionatedOtsuPanel;
	
	public PartionatedOtsuButtonResetListener(PartionatedOtsuModel partionatedOtsuModel, PartionatedOtsuPanel partionatedOtsuPanel){
		this.partionatedOtsuModel = partionatedOtsuModel;
		this.partionatedOtsuPanel = partionatedOtsuPanel;
	}
	
	 @Override
	 public void actionPerformed(ActionEvent e) {
  		this.partionatedOtsuModel.reset(partionatedOtsuPanel);
	 } 
}