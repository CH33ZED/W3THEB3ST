import java.util.ArrayList;

public class Spaceinvader{
    public static int score;
    public static double time;
    public static int type;
    public static String mv;
    public static Ship hero;
    public static int count = 0;
    public static Ship space = new Space();
    public static Ship[] spacer = {space,space,space,space,space,space,space,space,space,space};
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
 
    public static void setCol( int x, Ship[] newCol ){
        for(int b = 0; b < z.length; b++){
            if(newCol[b] instanceof Bullet == true && x == newCol[b].c && x < 9){               set(b,x,space);
                set(b,newCol[b].c+2,newCol[b]);
            }
            if(newCol[b] instanceof Bullet == true && x > newCol[b].c && x < 9){
                newCol[b].setMove("w");
                set(b,newCol[b].c,newCol[b]);
            }
            else{
                set(b,x,newCol[b]);
            }
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
            for(int a = 0; a < 9; a++){
                for(int b = 1; b < 9; b++){
                    if(z[a][b] instanceof Drone && (z[a][b-1].name).equals(hero.name)){
			z[a][b].die();
                        hero.hit = true;
		    }
                    if(z[a][b] instanceof Powerup && (z[a][b-1].name).equals(hero.name)){ 
                        if((z[a][b].toString()).equals("[>=>]")){
                            hero.nuke = true;
                            z[a][b].die();
                        }
                        if((z[a][b].gun.toString()).equals("[)=]-")){
                            hero.setGun(")=");
                        }
                        else{
                            hero.setHP(1);
                        }     
                    }
                    if(z[a][b] instanceof Bullet && b < 9 && (z[a][b+1] instanceof Drone == true)){
			if(z[a][b].nuke == true){
                            for(int x = 2; x < 9; x++){
				setCol(x, spacer);
			    }
                        }
			else{
			    z[a][b+1] = space;
                        }                        
                    }  
                }
            }
	    if(hero.hit == true){
		hero.setHP(-1);
                hero.hit = false;
            }
            System.out.println();
            System.out.println("move!");
            mv = Keyboard.readString();
            set(hero.r,hero.c,space);
            hero.setMove(mv);
            set(hero.r,hero.c,hero);
            int g = hero.fire();
            if(g == 0){
            }
            else{
               Bullet y = new Bullet(hero.r, 2, g);
               set(hero.r, 2, y);
            }
            for(int b = 1; b < 9; b++){
                setCol(b, getCol(b+1));
            }
            hero.special();
            if(count == 0){ 
		count++;
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
            }
	    else{
                count--;
            }
            System.out.println("HEALTH: " + hero.HP + "           SCORE: " + hero.kc + "            TIME: " + (45 - ((int)((System.currentTimeMillis() - time)/1000))));
            System.out.println();
            System.out.println();
            printS();
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
        
