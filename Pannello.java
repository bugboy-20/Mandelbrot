package mandelbrot;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;
import javax.swing.JPanel;



public class Pannello extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	BufferedImage bi;
	ImageIcon graf;
	int iterations;
	ComplexNumber center;
	//int x,y;
	int size;
	public Pannello(int size, ComplexNumber center, double radius, int iterations) {
		this.iterations = iterations;
		bi = new BufferedImage(size, size, BufferedImage.TYPE_INT_RGB);
		graf = new ImageIcon(bi);
		
		this.size=size;
		this.center=center;
		drawMandelbrot(range(size, radius));
	}
	
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		graf.paintIcon(this, g, 0, 0);
		
	}
	
	void drawMandelbrot(double range) {
		for (int y = 0; y < size; y ++)
		{
			for (int x = 0; x < size; x++)
			{
				/*if(isInTheSet(x,y,range))
					bi.setRGB(x, y, Color.BLACK.getRGB());
				else
					bi.setRGB(x, y, Color.WHITE.getRGB());*/
				bi.setRGB(x, y, chooseColor(x, y, range).getRGB());
			}
		}
	}
	/*
	boolean isInTheSet(int x, int y, double range)	
	{
		ComplexNumber c = pixelToComplex(x, y, range);
		ComplexNumber z = new ComplexNumber();
		for (int i = 0; i < iterations; i++) {
			z = ComplexNumber.pow(z, 2);
			z = ComplexNumber.add(z, c);
			
			if(z.getRe()>=2 || z.getIm()>=2)
				return false;
		}
		return true;
	}
	*/
	
	Color chooseColor(int x, int y, double range) {
		ComplexNumber c = pixelToComplex(x, y, range);
		ComplexNumber z = new ComplexNumber();
		ComplexNumber ex_z;
		for (int i = 0; i < iterations; i++) {
			ex_z=z;
			z = ComplexNumber.pow(z, 2);
			z = ComplexNumber.add(z, c);
			if(z.equals(ex_z))
			{
				return Color.BLACK;
			}
			if(z.getRe()>=2 || z.getIm()>=2)
			{
				//System.out.println((double) i/iterations);
				return Color.getHSBColor((float) 10*i/iterations, 1, 1);
			}
		}
		return Color.BLACK;
	}
	
	double range(int size, double radius) //range in number line from pixel to pixel
	{
		double range=2*radius;
		if(range<0)
			range*=-1;
		range/=size;
		return range;
	}
	
	ComplexNumber pixelToComplex(int x, int y, double range)
	{
		ComplexNumber z = new ComplexNumber((x-size/2)*range+center.getRe(), (y-size/2)*range+center.getIm());
		return z;
	}
	
	public void redrawMandelbrot(double re, double im, double r) {
		center = new ComplexNumber(re, im);
		drawMandelbrot(range(size, r));
		repaint();
	}
}
