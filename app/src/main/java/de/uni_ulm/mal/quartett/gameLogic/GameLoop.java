package de.uni_ulm.mal.quartett.gameLogic;

public class GameLoop {
	public static void main(String[] args){
		Player player1 = getP1();
		Player player2 = getP2();
		GameMode gameMode = getGameMode();
		setUpMatch(player1, player2, gameMode);
		
	}
	public static void setUpMatch(Player p1, Player p2, GameMode gameMode){
		MatchUp game = new  MatchUp(p1,p2,gameMode,setUpTimer(),setUpTimer(),0, 0, 18, 18, 0);
		setUpCards(gameMode);
		gameLoop(game);
	}
	public static void gameLoop(MatchUp game){
		
		//GameLoop for QUICKPLAY
		if(game.gameMode.equals(GameMode.QUICKPLAY)){
			while(game.round > 9){
				if(game.round % 2 == 0){
					while(setUpTimer() <= game.timeLastAction + 60){
						//if(player1 winns)
						{
							game.scoreP1++;
							game.round++;
							game.timeLastAction = setUpTimer();
						}
						//else if (player2 winns)
						{
							game.scoreP2++;
							game.round++;
							game.timeLastAction = setUpTimer();
						}
						//else
						{
							game.round++;
							game.timeLastAction = setUpTimer();
						}
						 
					}
					//player1 loses Round if time is up
					game.scoreP2++;
					game.round++;
					game.timeLastAction = setUpTimer();
					
				}else if(game.player2.ai == true){
					//TODO CalculateTurn.calculateAI();
					//if(player2 winns)
					{
						game.scoreP2++;
						game.round++;
						game.timeLastAction = setUpTimer();
					}
					//else if (player1 winns)
					{
						game.scoreP1++;
						game.round++;
						game.timeLastAction = setUpTimer();
					}
					//else
					{
						game.round++;
						game.timeLastAction = setUpTimer();
					}
					 
				}				
			}
			if(game.scoreP1 > game.scoreP2){
				//show winning screen
			}
			if(game.scoreP1 < game.scoreP2){
				//show losing screen
			}
			if(game.scoreP1 == game.scoreP2){
				//show draw  screen
			}
		}
		
		//GameLoop for NORMAL
		if(game.gameMode.equals(GameMode.NORMAL)){
			while(game.round > 19){
				if(game.round % 2 == 0){
					while(setUpTimer() <= game.timeLastAction + 86400){
						//if(player1 wins)
						{
							game.scoreP1++;
							game.round++;
							game.timeLastAction = setUpTimer();
						}
						//else if (player2 wins)
						{
							game.scoreP2++;
							game.round++;
							game.timeLastAction = setUpTimer();
						}
						//else
						{
							game.round++;
							game.timeLastAction = setUpTimer();
						}
						 
					}
					//player1 loses Round if time is up
					game.scoreP2++;
					game.round++;
					game.timeLastAction = setUpTimer();
					
				}else if(game.player2.ai == true){
					//TODO CalculateTurn.calculateAI();
					//if(player2 wins)
					{
						game.scoreP2++;
						game.round++;
						game.timeLastAction = setUpTimer();
					}
					//else if (player1 wins)
					{
						game.scoreP1++;
						game.round++;
						game.timeLastAction = setUpTimer();
					}
					//else
					{
						game.round++;
						game.timeLastAction = setUpTimer();
					}
					 
				}
			}
			if(game.scoreP1 > game.scoreP2){
				//show winning screen
			}
			if(game.scoreP1 < game.scoreP2){
				//show losing screen
			}
			if(game.scoreP1 == game.scoreP2){
				//show draw  screen
			}
		}
		
		//GameLoop for DUELL
		if(game.gameMode.equals(GameMode.DUELL)){
			while(game.cardsP1 != 0 && game.cardsP2 != 0){

				while(setUpTimer() <= game.timeLastAction + 86400){
					//if(player1 wins)
					{
						game.cardsP1++;
						game.cardsP2--;
						game.round++;
						//player1s turn
					}
					//else if (player2 wins)
					{
						game.cardsP2++;
						game.cardsP1--;
						game.round++;
						game.timeLastAction = setUpTimer();
						//player2s turn
					}
					//else
					{
						game.round++;
						game.timeLastAction = setUpTimer();
						//other players turn
					}
				}
			}
			if(game.cardsP2 == 0){
				//show winning screen
			}else{
				//show losing screen
			}
		}
		
		if(game.gameMode.equals(GameMode.LIMITED)){
			while(game.round > 17){
				//absolutly no clue
			}
		}
	}
	//TODO get actual Player from DB
	private static Player getP1(){
		Player p1 = new Player(0, "p1", false);
		return p1;
	}
	//TODO get actual KI Player from DB
	private static Player getP2(){
		Player p2 = new Player(1, "p2", true);
		return p2;
	}
	//TODO get chosen GameMode
	private static GameMode getGameMode(){
		return GameMode.NORMAL;
	}
	
	private static void setUpCards(GameMode gameMode){
		//TODO
	}
	private static long setUpTimer(){
		//get Unix time
		return (System.currentTimeMillis() / 1000L);
	}
}
