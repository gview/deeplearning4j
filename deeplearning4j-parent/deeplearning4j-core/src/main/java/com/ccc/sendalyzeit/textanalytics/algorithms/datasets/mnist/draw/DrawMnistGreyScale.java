package com.ccc.sendalyzeit.textanalytics.algorithms.datasets.mnist.draw;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;
import java.awt.image.WritableRaster;

import javax.swing.*;

import org.jblas.DoubleMatrix;

public class DrawMnistGreyScale {

	public  JFrame frame;
	BufferedImage img;
	private int width = 28;
	private int height = 28;
	public String title = "TEST";
	private int heightOffset = 0;
	private int widthOffset = 0;

	
	public DrawMnistGreyScale(DoubleMatrix data,int heightOffset,int widthOffset) {
		img = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		this.heightOffset = heightOffset;
		this.widthOffset = widthOffset;
		WritableRaster r = img.getRaster();
		int[] equiv = new int[data.length];
		for(int i = 0; i < equiv.length; i++)
			equiv[i] = (int) Math.round(data.get(i));
		
		r.setDataElements(0, 0, width, height, equiv);


	}
	
	public DrawMnistGreyScale(DoubleMatrix data) {
		img = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		WritableRaster r = img.getRaster();
		int[] equiv = new int[data.length];
		for(int i = 0; i < equiv.length; i++)
			equiv[i] = (int) Math.round(data.get(i));
		
		r.setDataElements(0, 0, width, height, equiv);


	}

	
	public void draw() {
		frame = new JFrame(title);
		frame.setVisible(true);
		start();
		frame.add(new JLabel(new ImageIcon(getImage())));

		frame.pack();
		// Better to DISPOSE than EXIT
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}

	public Image getImage() {
		return img;
	}

	public void start(){


		int[] pixels = ((DataBufferInt)img.getRaster().getDataBuffer()).getData();
		boolean running = true;
		while(running){
			BufferStrategy bs = frame.getBufferStrategy();
			if(bs==null){
				frame.createBufferStrategy(4);
				return;
			}
			for (int i = 0; i < width * height; i++)
				pixels[i] = 0;

			Graphics g= bs.getDrawGraphics();
			g.drawImage(img, heightOffset, widthOffset, width, height, null);
			g.dispose();
			bs.show();

		}
	}
}
