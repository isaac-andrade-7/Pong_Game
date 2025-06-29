package pong_game;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JFrame;

public class Main extends Canvas implements Runnable{

	//public static int WIDTH = 480, HEIGTH = 480;
	public static int WIDTH = 480;
	public static int HEIGTH = 480;
	
	public Main() {
		this.setPreferredSize(new Dimension(WIDTH, HEIGHT));
	}
	
	public static void main(String[] args) {
		Main main = new Main();
		new Thread(main).start();
		
		JFrame janela = new JFrame("Pong_Game");
        janela.add(main);
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        janela.setResizable(false);
        janela.pack();
        janela.setLocationRelativeTo(null);
        janela.setVisible(true);
	}
	
	@Override
	public void paint(Graphics g) {
	    g.setColor(Color.BLACK);
	    g.fillRect(0, 0, WIDTH, HEIGHT); // fundo preto

	    g.setColor(Color.WHITE);
	    g.fillOval(220, 220, 20, 20); // uma bolinha no centro
	}
	
	@Override
	public void run() {
	    while (true) {
	        repaint(); // redesenha a tela
	        try {
	            Thread.sleep(16); // ~60 FPS
	        } catch (InterruptedException e) {
	            e.printStackTrace();
	        }
	    }
	}

}
