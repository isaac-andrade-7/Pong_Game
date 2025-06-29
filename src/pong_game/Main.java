package pong_game;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;

public class Main extends Canvas implements Runnable, KeyListener {

	private static final long serialVersionUID = 1L;
	private static int WIDTH = 480;
	private static int HEIGTH = 480;
	
	private int ballX = 220;
	private int ballY = 220;
	private int ballSpeed = 5;
	
	private boolean upPressed = false;
	private boolean downPressed = false;
	private boolean leftPressed = false;
	private boolean rightPressed = false;
    
    public Main() {
        this.setPreferredSize(new Dimension(WIDTH, HEIGTH));
        this.addKeyListener(this);
        this.setFocusable(true);
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
        g.fillRect(0, 0, WIDTH, HEIGTH); // fundo preto

        g.setColor(Color.WHITE);
        g.fillOval(ballX, ballY, 20, 20); // bolinha controlável
	}
	
	private void update() {
	    // Move a bolinha com base nas teclas pressionadas
	    if (upPressed && ballY > 0) {
	        ballY -= ballSpeed;
	    }
	    if (downPressed && ballY < HEIGTH - 20) {
	        ballY += ballSpeed;
	    }
	    if (leftPressed && ballX > 0) {
	        ballX -= ballSpeed;
	    }
	    if (rightPressed && ballX < WIDTH - 20) {
	        ballX += ballSpeed;
	    }
	}

	@Override
	public void run() {
	    while (true) {
	        update(); // atualiza a posição da bolinha
	        repaint(); // redesenha a tela
	        try {
	            Thread.sleep(16); //60 FPS
	        } catch (InterruptedException e) {
	            e.printStackTrace();
	        }
	    }
	}

	@Override
	public void keyPressed(KeyEvent e) {
	    int key = e.getKeyCode();
	    
	    if (key == KeyEvent.VK_UP) {
	        upPressed = true;
	    }
	    if (key == KeyEvent.VK_DOWN) {
	        downPressed = true;
	    }
	    if (key == KeyEvent.VK_LEFT) {
	        leftPressed = true;
	    }
	    if (key == KeyEvent.VK_RIGHT) {
	        rightPressed = true;
	    }
	}

	@Override
	public void keyReleased(KeyEvent e) {
	    int key = e.getKeyCode();
	    
	    if (key == KeyEvent.VK_UP) {
	        upPressed = false;
	    }
	    if (key == KeyEvent.VK_DOWN) {
	        downPressed = false;
	    }
	    if (key == KeyEvent.VK_LEFT) {
	        leftPressed = false;
	    }
	    if (key == KeyEvent.VK_RIGHT) {
	        rightPressed = false;
	    }
	}

	@Override
	public void keyTyped(KeyEvent e) {
	    // Não usado, mas necessário para implementar a interface
	}

}
