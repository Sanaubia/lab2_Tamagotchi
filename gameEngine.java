import java.util.Scanner;
import java.util.ArrayList;

import java.io.IOException;

class gameEngine implements tamagotchObject.TamagotchState {
 
    private volatile boolean stopped = false;
    Scanner scanner = new Scanner(System.in);
    
    tamagotchObject tama = new tamagotchObject("tamagotchi 0", 15);
    tamagotchObject tama1 = new tamagotchObject("tamagotchi 1", 15);
    tamagotchObject tama2 = new tamagotchObject("tamagotchi 2", 15);
    tamagotchObject tama3 = new tamagotchObject("tamagotchi 3", 15);
    tamagotchObject tama4 = new tamagotchObject("tamagotchi 4", 15);


    ArrayList<Object> Objects = new ArrayList<Object>();
    int dead = 0;
    boolean gameOver = false;
 

    private GameOver kuuntelija;

    public interface GameOver{
        public void gameOverMessage(String status);

    }

    public void setKuuntelija(GameOver uusiKuuntelija) {
        this.kuuntelija = uusiKuuntelija;
      }


    public void clear() {
        try {
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();

        } catch (InterruptedException | IOException e) {
            e.printStackTrace();
        }
    }

    public void print() {
        System.out.println("Tamagotchi farm!!");
        System.out.println();
        for (int i = 0; i < Objects.size(); i++) {
            System.out.println(Objects.get(i));
        }
        System.out.println();
        System.out.println("Enter number to feed tamagotchi");
        


    }

    public void TamagotchData(String status) {
        // clear();
        // if ()
        if (dead < 5) {

            if (status.contains("tamagotchi 0")) {
                // clear();
                Objects.set(0, status);
                if (status.contains("dead")) {
                    dead += 1;
                }
                // print();

            } else if (status.contains("tamagotchi 1")) {
                // clear();
                Objects.set(1, status);
                if (status.contains("dead")) {
                    dead += 1;
                }
                // print();

            } else if (status.contains("tamagotchi 2")) {
                // clear();
                Objects.set(2, status);
                if (status.contains("dead")) {
                    dead += 1;
                }
                // print();

            } else if (status.contains("tamagotchi 3")) {
                // clear();
                Objects.set(3, status);
                if (status.contains("dead")) {
                    dead += 1;
                }
                // print();

            } else if (status.contains("tamagotchi 4")) {
                // clear();
                Objects.set(4, status);
                if (status.contains("dead")) {
                    dead += 1;
                }
                // print();

            }

        }
    }
   


    public int feedTama(int id) {
        if (id == 0) {
            tama.feed(10);
            System.out.println(tama.name + " fed");
        } else if (id == 1) {
            tama1.feed(10);
            System.out.println(tama1.name + " fed");
        } else if (id == 2) {
            tama2.feed(10);
            System.out.println(tama2.name + " fed");
        } else if (id == 3) {
            tama3.feed(10);
            System.out.println(tama3.name + " fed");
        } else if (id == 4) {
            tama4.feed(10);
            System.out.println(tama4.name + " fed");
        }

        return 0;
    }

    public void startGame() {

        tama.setKuuntelija(this);
        Objects.add("tamagotchi 0");
        tama.start();
        sleep(100);
        tama1.setKuuntelija(this);
        Objects.add("tamagotchi 1");
        tama1.start();
        sleep(100);
        tama2.setKuuntelija(this);
        Objects.add("tamagotchi 2");
        tama2.start();
        sleep(100);
        tama3.setKuuntelija(this);
        Objects.add("tamagotchi 3");
        tama3.start();
        sleep(100);
        tama4.setKuuntelija(this);
        Objects.add("tamagotchi 4");
        tama4.start();
        Game game = new Game();
        game.start();
        Tulostus t = new Tulostus();
        t.start();
    }

    private void sleep(int time) {
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {

            e.printStackTrace();
        }
    }



    class Tulostus extends Thread {

        public void run() {
            while (gameOver == false) {

                    if (dead == 5){
                        stopThis();
                        kuuntelija.gameOverMessage("end");
                    }
                    clear();
                    print();
                        try {
                            sleep(500);
                        } catch (InterruptedException e) {
                            // TODO Auto-generated catch block
                            e.printStackTrace();
                        }
                }
            }

        }

    class Game extends Thread{


        public void run(){
           
            String line = null;
            //System.out.println("Hello, world!");
            
            //engine.setKuuntelija(this);
            //engine.startGame();
            while(gameOver == false) {
                
                line = scanner.nextLine();
                if (line.equals("0")) {
                    feedTama(0);
                 
                } if (line.equals("1")) {
                    feedTama(1);
                 
                } if (line.equals("2")) {
                    feedTama(2);
                 
                } if (line.equals("3")) {
                    feedTama(3);
                 
                } if (line.equals("4")) {
                    feedTama(4);
                 
                } 	
                System.out.println("Feed tama");
    
    
            }
        }
           
        }
    
        public void stopThis() {
            gameOver = true;
            scanner.close();
            
          }
    }



