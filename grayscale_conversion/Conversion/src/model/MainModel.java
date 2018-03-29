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
	
	public void gotoNextFrame(int totalFrames) {
		if (this.idActualFrame < totalFrames - 1) {
			this.imageList[this.idActualFrame] = this.actualImage.duplicate();
			this.idActualFrame++;	
		}
	}
	
	public void gotoBackFrame() {
		if (this.idActualFrame > 0) {
			this.idActualFrame--;
			this.actualImage.setImage(this.imageList[this.idActualFrame]);
			this.actualImage.updateImage();
		}
		
	}
	
	public int getIdActualFrame() {
		return this.idActualFrame;
	}
}
	