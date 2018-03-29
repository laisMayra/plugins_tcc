package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.ImageProcessingPanel;
import view.WelcomePanel;
import controller.ImageProcessingPanelController;

public class WelcomeController extends ImageProcessingPanelController{
    protected WelcomePanel welcomePanel;
    
    @Override
    public void panelController() {
    	this.welcomePanel = new WelcomePanel();
    }
    
    public ImageProcessingPanel getPanelView() {
		return this.welcomePanel;
	}
}