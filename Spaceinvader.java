public class Spaceinvader{
    public static int score = 0;            //player's score
    public static double time;              //starting time
    public static int bar;                  //difficulty level    
    public static int type;                 //hero type            
    public static String mv;                //player's movement input      
    public static Ship hero;                //player controllable ship            
    public static Bullet y;                 //player's bullet
    public static int count = 0;            //enemy spawn frequency
    public static Ship space = new Space("-----");  //space background
    public static Ship explode = new Space("XXXXX"); //explosion background
    public static Ship[] spacer = {space,space,space,space,space,space,space,space,space,space};
    public static Ship[] exploder = {explode,explode,explode,explode,explode,explode,explode,explode,explode,explode,};
    public static Ship[][] z = {{space,space,space,space,space,space,space,space,space,space},{space,space,space,space,space,space,space,space,space,space},{space,space,space,space,space,space,space,space,space,space},{space,space,space,space,space,space,space,space,space,space},{space,space,space,space,space,space,space,space,space,space},{space,space,space,space,space,space,space,space,space,space},{space,space,space,space,space,space,space,space,space,space},{space,space,space,space,space,space,space,space,space,space},{space,space,space,space,space,space,space,space,space,space},{space,space,space,space,space,space,space,space,space,space}}; //game display
    public static void printS(){    //prints out modified string of every ship in the 2D array
        for (Ship[] n: z){
	    System.out.println();
            for (Ship b: n){
                System.out.print(b.toString());
            }
	}
    }
    public static void set(int a, int b, Ship c){    //sets ship c at row a column b of the 2D array
        z[a][b] = c;
    }
    public static Ship[] getCol( int c ){     //get column c
        Ship[] a = new Ship[10];
        for (int b = 0; b < z.length; b++){
            a[b] = z[b][c];
        }
        return a;
    }
 
    public static void setCol( int x, Ship[] newCol ){   //set column x using ships from newCol
        for(int b = 0; b < z.length; b++){
            if(newCol[b] instanceof Bullet == true){               
                set(b,x,space);
            }
            else{
                set(b,x,newCol[b]);
            }
        }
    }
    public static void main(String [] args){
        System.out.println("Choose a class!");
        System.out.println("");
        System.out.println("1.Tank         2.Damage        3.Agility");      //player choooses class
        type = Keyboard.readInt();
        System.out.println();
        System.out.println("Choose difficulty");
        System.out.println("");
        System.out.println("1.Easy         2.Hard          3.Insane!");     //player chooses difficulty
        bar = Keyboard.readInt();
        System.out.println("Good Choice! Get Ready for battle");
        if (type == 1){                                 //set player's hero type
            hero = new Tank();
        }
        else if (type == 2){
            hero = new Damage();
        }
        else{
            hero = new Agility();
        }
        set(hero.r,hero.c, hero);
        printS();                                        //print starting board
        time = System.currentTimeMillis();               //save start time
        while(System.currentTimeMillis() - time < 45000){       //starts countdown
            score++;                                       //increas score by 1 every move the player makes
	    if(hero.hit == true){                          //check if the player is hit, if hit, decreases health        
		hero.setHP(-1);
                hero.hit = false;
            }
            System.out.println();
            System.out.println("move!");
            mv = Keyboard.readString();                    //prompts the player to input movement command      
            set(hero.r,hero.c,space);                      //set hero's old position as space  
            hero.setMove(mv);                              //set hero's new position             
            set(hero.r,hero.c,hero);                       //set the hero to its new position           
            for(int b = 1; b < 9; b++){                    //move enemies toward hero by one column        
                setCol(b, getCol(b+1));
            }
            int g = hero.fire();                          //hero fires     
            if(g == 0){
            }
            else{
               y = new Bullet(hero.r, 0, g);             //spawns new bullet
            }
            y.setMove("w");                              //set new bullet position                        
            set(y.r,y.c,y);                              //set bullet to its new position                    
            for(int a = 0; a < 10; a++){
                for(int b = 1; b < 10; b++){
                    if(z[a][b] instanceof Drone && (z[a][b-1].name).equals(hero.name)){        //checks if a drone hit the hero
			z[a][b].die();
                        hero.hit = true;
		    }
                    if(z[a][b] instanceof Powerup && (z[a][b-1].name).equals(hero.name)){      //checks if a powerup hit the hero
                        if((z[a][b].toString()).equals("[>=>]")){                              //set appropriate powerup to hero if hit         
                            hero.nuke = true;
                        }
                        if((z[a][b].gun.toString()).equals("[)=]-")){                     
                            hero.setGun(")=");
                        }
                        else{
                            hero.setHP(1);
                        }
                    }
                    if(z[a][b] instanceof Bullet && b == 9){                              //erase bullets that reaches the max range  
			z[a][b] = space;
		    }
                    if(z[a][b] instanceof Bullet && b < 8 && ((z[a][b+2] instanceof Drone == true)||(z[a][b+1] instanceof Drone == true))){     //check if a bullet hit a drone
			if(z[a][b].nuke == true){                                       //bullet explodes
                            for(int x = 2; x < 9; x++){
				setCol(x, exploder);
                                score += 50;
			    }
                            setCol(9, spacer);
                        }
			else{
			    z[a][b+1] = space;
                            z[a][b] = space;
                            score += 10;
                            hero.kc += 1;
                        }                        
                    }  
                }
            }
            hero.special();                                 //hero uses its special ability
            if(count == 0){                                  //enemy spawn timer check
		count++;
                for(int a = 0; a < 6; a++){                         //spawn 6 enemies or powerups in random row in column 9
	          if(((int)(Math.random()*20)) <= 18){              //19/20 chance to spawn enemy drone
		     Drone bob = new Drone();
                     bob.setMove(mv);     
                     set(bob.r,bob.c, bob);
                  }
                  else{
		     Powerup bob = new Powerup();                   //1/20 chance to spawn poweru[]       
                     bob.setMove(mv);     
                     set(bob.r,bob.c, bob); 
                  } 
                }  
            }
	    else{
                count--;
            }
            System.out.println("HEALTH: " + hero.HP + "           SCORE: " + score + "            TIME: " + (45 - ((int)((System.currentTimeMillis() - time)/1000))));       //shows player;s health, score, and time left
            System.out.println();
            System.out.println();
            printS();
            if(hero.HP <= 0){                                   //check hero's HP, ends the game if lower than or equal to 0
		System.out.println();
                System.out.println();
                System.out.println("TERMINATED!");
                break;
            }
	}
        System.out.println();
        System.out.println();
        if(score > (100 + (300)*bar)){                         //determines if the player met the score requirement and inform the player whether he or she won        
	    System.out.println("YOU WON!");
        }
        else{
            System.out.println("YOU LOST");
        }
    }
}
        
