import java.util.Scanner;


class tamagotchi{
	//static Scanner scanner = null;
	//static String line = null;
	//private volatile boolean stopped = false;

	public static void main(String[] args) {
		gameEngine engine = new gameEngine();
		engine.startGame();
	}
/*
	private void game() {

		//System.out.println("Hello, world!");
		gameEngine engine = new gameEngine();
		engine.setKuuntelija(this);
		engine.startGame();
		while(!stopped) {
			System.out.println("Feed tama");

			line = scanner.nextLine();
			if (line.equals("0")) {
				engine.feedTama(0);
			 
			} if (line.equals("1")) {
				engine.feedTama(1);
			 
			} if (line.equals("2")) {
				engine.feedTama(2);
			 
			} if (line.equals("3")) {
				engine.feedTama(3);
			 
			} if (line.equals("4")) {
				engine.feedTama(4);
			 
			} 	
		}
	}

	public void stopThis() {
		stopped = true;
	  }

	@Override
	public void gameOverMessage(String status) {
		if (status.contains("end")) {
			stopThis();
			System.out.println("Game Over!!");
		}

	}

	
	  
*/	  
	  
}
