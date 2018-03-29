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
    final int TOTAL_PANELS = 1;
   
      
    public MainController(MainGui mainGui) {
    	this.mainGui = mainGui;
        this.mainModel = new MainModel();
        this.setupImageProcessingPanels();
        this.updateImageProcessingPanel();
//        this.updateLabelsTexts();
        this.mainGui.getBtnCancel().addActionListener(new CancelButtonListener(this, (ConversionController) frameList[0]));
//        this.mainGui.getBtnFinish().addActionListener(new CancelButtonListener(this, (ConversionController) frameList[0]));
//        this.mainGui.getBtnBack().addActionListener(new BackButtonListener(this));
//        this.mainGui.getBtnNext().addActionListener(new NextButtonListener(this));
    }
    
   private void setupImageProcessingPanels() {
    	this.frameList = new ImageProcessingPanelController[TOTAL_PANELS];
//    	this.frameList[0] = new WelcomeController();
    	this.frameList[0] = new ConversionController();
//    	this.frameList[2] = new GrayscaleController();
//    	this.frameList[3] = new SmoothFilterController();
//    	this.frameList[1] = new PartionatedOtsuController();
//    	//this.frameList[5] = new EraseNoiseController();
//    	//this.frameList[6] = new FillHolesController();
//    	this.frameList[5] = new WatershedController();
//    	//this.frameList[8] = new MaxCirclesController();
//    	this.frameList[6] = new AnalyzeParticlesController();
    	
    	
    }
    
//   protected void updateLabelsTexts() {
//	   int idImageProcessingPanel;
//	   for (idImageProcessingPanel = 0; idImageProcessingPanel < TOTAL_PANELS; idImageProcessingPanel++) {
//		   mainGui.getLabelList()[idImageProcessingPanel].setText(this.frameList[idImageProcessingPanel].getPanelView().getPanelTitle());
//		   if (idImageProcessingPanel == mainModel.getIdActualFrame()) {
//			   mainGui.getLabelList()[idImageProcessingPanel].setForeground(Color.red);
//		   }
//		   else {
//			   mainGui.getLabelList()[idImageProcessingPanel].setForeground(Color.black);
//		   }
//	   }
//   }
//    
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
	private ConversionController conversionController;
	
	public CancelButtonListener(MainController mainController, ConversionController conversionController) {
		this.mainController = mainController;
		this.conversionController = conversionController;
		
	}
	
	 @Override
	 public void actionPerformed(ActionEvent e) {
		 this.mainController.mainGui.dispose();
		 this.conversionController.getConversionModel().resetImage();
	 }
}

class BackButtonListener implements ActionListener{
	private MainController mainController; 
	
	public BackButtonListener(MainController mainController) {
		this.mainController = mainController;
	}
	
	 @Override
	 public void actionPerformed(ActionEvent e) {
  		this.mainController.mainModel.gotoBackFrame();
 		this.mainController.updateImageProcessingPanel();
// 		this.mainController.updateLabelsTexts();
		if (!this.mainController.isFinalPanel()) {
			this.mainController.mainGui.getBtnNext().setVisible(true);
			this.mainController.mainGui.getBtnFinish().setVisible(false);
			this.mainController.mainGui.repaint();
		}
	 }
}

class NextButtonListener implements ActionListener{
	private MainController mainController;
	
	public NextButtonListener(MainController mainController) {
		this.mainController = mainController;
	}
	
	 @Override
	 public void actionPerformed(ActionEvent e) {
		this.mainController.mainModel.gotoNextFrame(mainController.TOTAL_PANELS);
 		this.mainController.updateImageProcessingPanel();
// 		this.mainController.updateLabelsTexts();
		if (this.mainController.isFinalPanel()) {
			this.mainController.mainGui.getBtnNext().setVisible(false);
			this.mainController.mainGui.getBtnFinish().setVisible(true);
			this.mainController.mainGui.repaint();
		}
	 }
}