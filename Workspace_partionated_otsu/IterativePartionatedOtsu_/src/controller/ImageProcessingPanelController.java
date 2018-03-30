package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.ImageProcessingPanel;

public abstract class ImageProcessingPanelController{
    
    public ImageProcessingPanelController() {
    	panelController();
    }
    
    public abstract void panelController();
    
    public abstract ImageProcessingPanel getPanelView();
}