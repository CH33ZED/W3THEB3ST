import java.util.ArrayList;

public class Spaceinvader{
    public static int score;
    public static double time;
    public static int type;
    public static String mv;
    public static Ship hero;
    public static Ship space = new Space();
    public static Ship[][] z = {{space,space,space,space,space,space,space,space,space,space},{space,space,space,space,space,space,space,space,space,space},{space,space,space,space,space,space,space,space,space,space},{space,space,space,space,space,space,space,space,space,space},{space,space,space,space,space,space,space,space,space,space},{space,space,space,space,space,space,space,space,space,space},{space,space,space,space,space,space,space,space,space,space},{space,space,space,space,space,space,space,space,space,space},{space,space,space,space,space,space,space,space,space,space},{space,space,space,space,space,space,space,space,space,space}};
    public static void printS(){
        for (Ship[] n: z){
	    System.out.println();
            for (Ship b: n){
                System.out.print(b.toString());
            }
	}
    }
    public static void set(int a, int b, Ship c){
        z[a][b] = c;
    }
    public static Ship[] getCol( int c ){
        Ship[] a = new Ship[10];
        for (int b = 0; b < z.length; b++){
            a[b] = z[b][c];
        }
        return a;
    }
 
    public static void setCol( int c, Ship[] newCol ){
        for(int b = 0; b < z.length; b++){
            z[b][c] = newCol[b];
        }
    }
    public static void main(String [] args){
        System.out.println("Choose a class!");
        System.out.println("");
        System.out.println("1.Tank         2.Damage        3.Agility");      
        type = Keyboard.readInt();
        System.out.println("Good Choice! Get Ready for battle");
        if (type == 1){
            hero = new Tank();
        }
        else if (type == 2){
            hero = new Damage();
        }
        else{
            hero = new Agility();
        }
        set(hero.r,hero.c, hero);
        printS();
        time = System.currentTimeMillis();
        while(System.currentTimeMillis() - time < 45000){
            System.out.println();
            System.out.println("move!");
            mv = Keyboard.readString();
            set(hero.r,hero.c,space);
            hero.setMove(mv);
            set(hero.r,hero.c,hero);
            for(int b = 1; b < 9; b++){
                setCol(b, getCol(b+1));
            }
            for(int a = 0; a < 6; a++){
	        if(((int)(Math.random()*20)) <= 18){
		     Drone bob = new Drone();
                     bob.setMove(mv);     
                     set(bob.r,bob.c, bob);
                }
                else{
		     Powerup bob = new Powerup();
                     bob.setMove(mv);     
                     set(bob.r,bob.c, bob);  
                }  
            }
            for(int a = 0; a < 9; a++){
                for(int b = 2; b < 9; b++){
                    if(z[a][b] instanceof Drone && (z[a][b-2].name).equals(hero.name)){
			z[a][b-1].die();
                        hero.setHP(-1);
		    }
                    if(z[a][b] instanceof Powerup && (z[a][b-2].name).equals(hero.name)){ 
                        if((z[a][b].gun).equals("[>=>]")){
                            hero.nuke = true;
                        }
                        if((z[a][b].gun).equals("[)=]-")){
                            hero.setGun(")=");
                        }
                        else{
                            hero.setHP(1);
                        }     
                    }                        
                }  
            }
            System.out.println();
            System.out.println();
            System.out.println("HEALTH: " + hero.HP + "           SCORE: " + hero.kc + "            TIME: " + (45 - ((int)((System.currentTimeMillis() - time)/1000))));
	    printS();;
            if(hero.HP <= 0){
		System.out.println();
                System.out.println();
                System.out.println("TERMINATED!");
                break;
            }
	}
        System.out.println();
        System.out.println();
        System.out.println("YOU LOST");
    }
}
        
