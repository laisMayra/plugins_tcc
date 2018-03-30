package model;

import ij.IJ;
import ij.ImagePlus;

public class MainModel{
	private int idActualFrame;
	private ImagePlus actualImage;
	protected ImagePlus imageList[];
	
	public MainModel(){
		this.idActualFrame = 0;
		this.actualImage = IJ.getImage();
		this.imageList = new ImagePlus[7];	
	}
		
	public int getIdActualFrame() {
		return this.idActualFrame;
	}
}
	