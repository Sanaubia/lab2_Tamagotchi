class tamagotchObject extends Thread{

    String name;
    int food;
    int id;
    private volatile boolean stopped = false;
    private TamagotchState kuuntelija;

    public interface TamagotchState{
        void TamagotchData(String status);

    }

    public void setKuuntelija(TamagotchState uusiKuuntelija) {
        this.kuuntelija = uusiKuuntelija;
      }

    public tamagotchObject(String name, int food){
        this.food = food;
        this.name = name;
      
    }

    public int feed(int foodAdded){
        food = food + foodAdded;
        return food;
    }
    public String getTamagotchName(){
        return name;
    }

    public int getTamagotchId(){
        return id;
    }


    public int getTamagotchFood(){
        return food;
    }



    
    
    public void stopThis() {
        stopped = true;
      }

    @Override
    public void run(){
        try{
            while(!stopped){
                
                if(food >= 0 && food < 20){
                        if(kuuntelija != null){
                            
                            kuuntelija.TamagotchData("Tamagotchi name: " + name + " Food left: " + food);
                        }
                } else if (food < 0){
                    if(kuuntelija != null){
                    kuuntelija.TamagotchData("Tamagotchi " + name + " is dead");
                    //kuuntelija.TamagotchData(name + " " + food  + " Your Tamagotchi is dead!");
                    }
                    stopThis();
                }  else if (food > 20){
                    if(kuuntelija != null){
                    kuuntelija.TamagotchData("Tamagotchi " + name + " is dead from overfeeding");
                    //kuuntelija.TamagotchData(name + " " + food  + " Your Tamagotchi is dead!");
                }
                    stopThis();
                
                }
                food = food - 1;
                sleep(1000);
            }

        } catch (Exception e){
            e.printStackTrace();
        }

    }



}