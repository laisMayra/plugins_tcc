package controller;

import view.ImageProcessingPanel;




public abstract class ImageProcessingPanelController{
    
    public ImageProcessingPanelController() {
    	panelController();
    }
    
    public abstract void panelController();
    
    public abstract ImageProcessingPanel getPanelView();
}