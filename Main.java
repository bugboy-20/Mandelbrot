package mandelbrot;

import javax.swing.JFrame;


public class Main {
	public static void main(String[] args) throws InterruptedException {

        JFrame f = new JFrame();
        Pannello  p = new Pannello(1000, new ComplexNumber(0,0), 2, 500);
        f.add(p);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setBounds(0, 0, 1000, 1000);
        f.setResizable(false);
        f.setVisible(true);
        
    }
}
