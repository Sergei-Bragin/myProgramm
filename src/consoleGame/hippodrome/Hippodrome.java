package consoleGame.hippodrome;


import java.util.ArrayList;

public class Hippodrome {
    public static ArrayList<Horse> horses = new ArrayList<Horse>();
    public static   Hippodrome game;

    public ArrayList<Horse> getHorses()
    {
        return horses;
    }

    public Horse getWinner(){
        double temp =0;
        Horse win = null;
        for(Horse horse: getHorses()){
            if(horse.getDistance() > temp){
                temp = horse.getDistance();
                win = horse;
            }
        }
        return win;
    }
    public void printWinner(){
        System.out.println("Winner is "+ getWinner().getName()+"!");
    }

    public void move(){
        for(Horse horse: getHorses()){
            horse.move();
        }
    }
    public void print(){
        for(Horse horse: getHorses()){
            horse.print();
            System.out.println();
        }
        System.out.println();
        System.out.println();

    }
    public void run(){
        for(int i = 1; i<=100; i++){
            move();
            print();
        }
        try
        {
            Thread.sleep(500);
        }
        catch (InterruptedException e){
            e.printStackTrace();
        }


    }

    public static void main(String[] args)
    {
        game = new Hippodrome();
        Horse h1 = new Horse("Spirit",3,0);
        Horse h2 = new Horse("Torym",3,0);
        Horse h3 = new Horse("Floki",3,0);
        horses.add(h1);
        horses.add(h2);
        horses.add(h3);
        game.run();
        game.printWinner();
    }
}
