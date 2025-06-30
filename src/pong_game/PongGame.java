package pong_game;

public class PongGame {

	int pontuacaoJogador1 = 0;
	int pontuacaoJogador2 = 0;
	
	public PongGame() {
		//tioivo
	}
	
    public void start() {
        // Game starting logic goes here
        System.out.println("Pong Game Started!");
    }

	public void updateScore(int player) {
		if (player == 1) {
			pontuacaoJogador1++;
		} else if (player == 2) {
			pontuacaoJogador2++;
		}
		System.out.println("Player 1 Score: " + pontuacaoJogador1);
		System.out.println("Player 2 Score: " + pontuacaoJogador2);
	}

	public int getPontuacaoJogador1() {
		return pontuacaoJogador1;
	}

	public int getPontuacaoJogador2() {
		return pontuacaoJogador2;
	}

	public void resetScores() {
		pontuacaoJogador1 = 0;
		pontuacaoJogador2 = 0;
		System.out.println("Scores have been reset.");
	} 

}
