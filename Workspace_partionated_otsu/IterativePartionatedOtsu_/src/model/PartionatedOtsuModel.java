package model;

import java.util.HashMap;

import javax.swing.JButton;

import ij.IJ;
import ij.ImageListener;
import ij.ImagePlus;
import ij.gui.Roi;
import ij.plugin.frame.ThresholdAdjuster;
import ij.process.ImageProcessor;
import view.PartionatedOtsuPanel;

public class PartionatedOtsuModel{
	ImagePlus image, originalImage, newImage,copyImage;
	ImageProcessor imageProcessor;
	Float roiWidth, roiHeigth;
	int numberOfLines, numberOfCollums, collumWidth, lineHeight;
	HashMap<Integer, ImagePlus> mapOriginalImages;
	
	public PartionatedOtsuModel() {
		mapOriginalImages = new HashMap<Integer, ImagePlus>();
		setNewImage();
	}

	public void setNewImage() {
		image = IJ.getImage();
		mapOriginalImages.put(image.getID(), image.duplicate());
	}

	public void setRoiDimentions(PartionatedOtsuPanel panel) {
		image = IJ.getImage();
		Roi roi = image.getRoi();
		roiHeigth = (float) roi.getFloatHeight();
		roiWidth = (float) roi.getFloatWidth();
		
		IJ.setTool(0);
		
		panel.setWidthSelected(String.valueOf(roi.getFloatWidth()));
		panel.setHeigthSelected(String.valueOf(roi.getFloatHeight()));
		
	}
	
	public void disableEnableButtons(PartionatedOtsuPanel panel) {
		if(roiHeigth == 0) {
			panel.getBtnBinarization().setEnabled(false);
		}
		else{
			panel.getBtnBinarization().setEnabled(true);
		}
	}

	
	public void reset(PartionatedOtsuPanel panel){
		image = IJ.getImage();
		int test = image.getID();
		
		image.setImage(mapOriginalImages.get(test));
	}
		
	public void applyBinarization(PartionatedOtsuPanel panel) {
		try{
			Roi roi = image.getRoi();
			numberOfCollums = Math.round(image.getWidth()/roiWidth);
			collumWidth = image.getWidth()/numberOfCollums;
			numberOfLines = Math.round(image.getHeight()/roiHeigth);
			
			//lineHeight -> ROI height after divided by number of lines
			lineHeight = image.getHeight()/numberOfLines;

			IJ.run(image, "8-bit", "");
			copyImage = new ImagePlus();
			
			for( int line=0 ; line<image.getHeight() ; line+=lineHeight ){
				for( int collum=0 ; collum<image.getWidth() ; collum+=collumWidth ){
					
					image.setRoi(collum, line, collumWidth, lineHeight);
					
					//create an IP and apply Otsu to it
					imageProcessor = image.getProcessor();
					imageProcessor = imageProcessor.crop();
					
					imageProcessor.setAutoThreshold("Otsu");
					ThresholdAdjuster.setMode("B&W");
					imageProcessor.autoThreshold();
					
					//Create an image with the threshold applied
					copyImage.setProcessor(imageProcessor);
					copyImage.copy();

					//Paste thresholded image in the empty one
					image.setRoi(collum, line, copyImage.getWidth(), copyImage.getHeight());
					image.paste();
					image.deleteRoi();
				}
			}
			panel.getBtnBinarization().setEnabled(false);
		}
		catch (Exception exceptionType) {
			exceptionType.printStackTrace();
        }
	}
	
	public Roi getRoi(){ return image.getRoi();}
	
	public ImagePlus getImage(){ return image; }

	public void setImage(ImagePlus image){
		this.image = image;
	}
	

	public ImagePlus getOriginalImage() { return originalImage; }

	public void setOriginalImage(ImagePlus originalImage) {
		this.originalImage = originalImage;
	}

}
	