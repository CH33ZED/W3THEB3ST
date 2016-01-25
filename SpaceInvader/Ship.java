public abstract class Ship{                                          //Super class of every object in this game
    public String name;                                              //used for identification purposes          
    public String gun;                                               //used to spawn the corresponding type of bullets during fire()                      
    public int r;                                                    //row index                               
    public int c;                                                    //column index                   
    public int HP;                                                   //health                     
    public boolean nuke;                                             //nuke equipped for fire()>                        
    public boolean hit;                                              //if the ship is hit
    public int kc;                                                   //number of kills the ship has                     
    public int ammo;                                                 //weapon reload progress        
    public boolean dead;                                             //is the unit dead? (not used)                           
    public abstract void setMove(String a);                          //set new position to move to         
    public abstract int fire();                                      //return an int indicating bullet type                     
    public abstract void upgrade(int a);                             //upgrades ship(not used)      
    public abstract void setGun(String a);                           //set gun as String a               
    public abstract void setHP(int a);                               //add int a to HP          
    public abstract void special();                                  //ship's special ability                 
    public abstract void die();                                      //die
}
