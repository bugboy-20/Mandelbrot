package mandelbrot;

import javax.swing.JFrame;


public class Main {
	public static void main(String[] args) throws InterruptedException {

        JFrame f = new JFrame();
        Pannello  p = new Pannello(1000, new ComplexNumber(0,0), 2, 2000);
        f.add(p);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setBounds(0, 0, 1000, 1000);
        f.setResizable(false);
        f.setVisible(true);
        Thread.sleep(25);
        /*
        for (int i = 0; i < 100; i++) {
        	Thread.sleep(200);
			p.redrawMandelbrot(-0.7473198, 0.1084649,(double) 1/i);
		}*///try these
        //p.redrawMandelbrot(-0.7473198, 0.1084649,0.00003);
        //p.redrawMandelbrot(-0.74731515, 0.1084652,0.00000000001); 
        //p.redrawMandelbrot(-0.74731515, 0.1084652,0.0000000000001); max

        
        
    }
}
