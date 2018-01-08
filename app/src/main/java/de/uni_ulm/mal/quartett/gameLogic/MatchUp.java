package de.uni_ulm.mal.quartett.gameLogic;

public class MatchUp {
	Player player1;
	Player player2;
	GameMode gameMode;
	long timeStarted;
	long timeLastAction;
	int scoreP1;
	int scoreP2;
	int cardsP1;
	int cardsP2;
	int round;
	
	public MatchUp(Player player1, Player player2, GameMode gameMode, long timeStarted, long timeLastAction, int scoreP1, int scoreP2, int cardsP1, int cardsP2, int round){
		this.player1 = player1;
		this.player2 = player2;
		this.gameMode = gameMode;
		this.timeStarted = timeStarted;
		this.timeLastAction = timeLastAction;
		this.scoreP1 = scoreP1;
		this.scoreP2 = scoreP2;
		this.cardsP1 = cardsP1;
		this.cardsP2 = cardsP2;
		this.round = round;
		
	}
}
