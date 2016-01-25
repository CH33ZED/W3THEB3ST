//all subclass method descritpions are in superclass ship
//space taker basic ship type

public class Space extends Ship{
    public Space(String a){
	   r = 0;
           c = 0;
           HP = 0;
           gun = a;
           name = "Space";
           nuke = false;
           hit = false;
           ammo = 0;
           kc = 0;
           dead = false;
    }
    public String toString(){
        return gun;
    }
    public void setMove(String a){
    }
    public int fire(){
	   return 0;
    }
    public void upgrade(int a){
    }
    public void setGun(String a){
	   gun = a;
    }
    public void setHP(int a){
    }  
    public void special(){
    }
    public void die(){
    }                         
}
