package model;

import java.awt.image.BufferedImage;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import ij.IJ;
import ij.ImagePlus;
import ij.gui.Roi;

import java.lang.Math;

public class ConversionModel {
	protected ImagePlus imp, imp2, luminanceImp, mediaImp, desaturationImp;
	protected int luminanceId;
	
	public ConversionModel(){
		imp = IJ.getImage();
	}
	
//	public void converion() {
//		try {
//			imp = IJ.getImage();
//			
//			luminanceImp = imp.duplicate();	
//			imp.duplicate();
//			luminanceConversion(imp);
//			
//			mediaImp = imp.duplicate();
//			imp.duplicate();
//			mediaConversion(imp);
//			
//			desaturationImp = imp.duplicate();
//			imp.duplicate();
//			desaturationConversion(imp);
//			
//		}
//		catch (Exception exceptionType) {
//			exceptionType.printStackTrace();
//        }
//	}
//	
	public void luminanceConversion() {
		imp2 = IJ.getImage();
		imp2.hide();
		
		BufferedImage img = imp.getBufferedImage();
	    int width = img.getWidth();
	    int height = img.getHeight();

	    for(int y = 0; y < height; y++){
		      for(int x = 0; x < width; x++){
		        int p = img.getRGB(x,y);

		        int a = (p>>24)&0xff;
		        int r = (p>>16)&0xff;
		        int g = (p>>8)&0xff;
		        int b = p&0xff;

		        int value = (int)((r*0.3) + (g*0.59) + (b*0.11));

		        p = (a<<24) | (value<<16) | (value<<8) | value;

		        img.setRGB(x, y, p);
		      }
		    }

	    try {						
			ImagePlus ip = new ImagePlus("luminance",img);
			ip.setTitle("Luminance");
			ip.show();
			IJ.run("Conversions...", "scale weighted");
			IJ.run(ip, "8-bit", "");
		}
		catch (Exception exceptionType) {
			exceptionType.printStackTrace();
        }				
	}
	
	public void mediaConversion() {
		imp2 = IJ.getImage();
		imp2.hide();
		
		BufferedImage img = imp.getBufferedImage();
	    int width = img.getWidth();
	    int height = img.getHeight();

	    for(int y = 0; y < height; y++){
	      for(int x = 0; x < width; x++){
	        int p = img.getRGB(x,y);

	        int a = (p>>24)&0xff;
	        int r = (p>>16)&0xff;
	        int g = (p>>8)&0xff;
	        int b = p&0xff;

	        int avg = (r+g+b)/3;

	        p = (a<<24) | (avg<<16) | (avg<<8) | avg;

	        img.setRGB(x, y, p);
	      }
	    }

	    try {						
			ImagePlus ip = new ImagePlus("average",img);
			ip.setTitle("Average");
			ip.show();
			IJ.run("Conversions...", "scale weighted");
			IJ.run(ip, "8-bit", "");
		}
		catch (Exception exceptionType) {
			exceptionType.printStackTrace();
        }	
	    
	}
	
	
	public void desaturationConversion() {
		imp2 = IJ.getImage();
		imp2.hide();
		
		BufferedImage img = imp.getBufferedImage();
	    int width = img.getWidth();
	    int height = img.getHeight();
	    

	    for(int y = 0; y < height; y++){
	        for(int x = 0; x < width; x++){
	          int p = img.getRGB(x,y);

	          int a = (p>>24)&0xff;
	          int r = (p>>16)&0xff;
	          int g = (p>>8)&0xff;
	          int b = p&0xff;
	          
	          
	          
	          int max = Math.min(Math.min(r, g), b);
	          int min = Math.min(Math.min(r, g), b);
	          
//	          System.out.println("R: "+r+" G: "+g+" B: "+b+" Max: "+max+" Min: "+min);
	          
	          int result = (max + min) / 2 ;

	          p = (a<<24) | (result<<16) | (result<<8) | result;

	          img.setRGB(x, y, p);
	        }
	    }

	    try {						
			ImagePlus ip = new ImagePlus("desaturation",img);
			ip.setTitle("Desaturation");
			ip.show();
			IJ.run("Conversions...", "scale weighted");
			IJ.run(ip, "8-bit", "");
		}
		catch (Exception exceptionType) {
			exceptionType.printStackTrace();
        }	
	    
	}
	
	public void resetImage() {
		imp2 = IJ.getImage();
		imp2.hide();
		
		imp.show();		
	}
	
			
	public ImagePlus getImp() {	return imp;	}

}