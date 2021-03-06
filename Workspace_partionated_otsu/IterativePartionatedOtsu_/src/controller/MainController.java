package controller;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.MainModel;
import view.MainGui;


public class MainController{

	protected MainGui mainGui;
    protected MainModel mainModel;
    private ImageProcessingPanelController frameList[]; 
    final int TOTAL_PANELS = 2;
   
      
    public MainController(MainGui mainGui) {
    	this.mainGui = mainGui;
        this.mainModel = new MainModel();
        this.setupImageProcessingPanels();
        this.updateImageProcessingPanel();
        this.mainGui.getBtnCancel().addActionListener(new CancelButtonListener(this));
        this.mainGui.getBtnFinish().addActionListener(new CancelButtonListener(this));
    }
    
   private void setupImageProcessingPanels() {
    	this.frameList = new ImageProcessingPanelController[TOTAL_PANELS];
    	this.frameList[0] = new PartionatedOtsuController();   	
    }
    
   protected void updateImageProcessingPanel() {
	   mainGui.setImagePocessingPanel(this.frameList[mainModel.getIdActualFrame()].getPanelView());
   }
   
   protected boolean isFinalPanel() {
	   if (mainModel.getIdActualFrame() == TOTAL_PANELS - 1) {
		   return true;
	   }
	   return false;
   }
}

class CancelButtonListener implements ActionListener{
	private MainController mainController; 
	
	public CancelButtonListener(MainController mainController) {
		this.mainController = mainController;
	}
	
	 @Override
	 public void actionPerformed(ActionEvent e) {
		 this.mainController.mainGui.dispose();
	 }
}
