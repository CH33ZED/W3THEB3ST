//all subclass method descritpions are in superclass ship
//enemy ship type

public class Drone extends Ship{
    public Drone(){
	   r = (int)(Math.random()*10);
           c = 9;
           HP = 1;
           gun = "-";
           name = "Drone";
           nuke = false;
           hit = false;
           kc = 0;
           dead = false;
    }
    public String toString(){
        return "<----";
    }
    public void setMove(String a){
        if(c > 1){
	   c--;
           r = (int)(Math.random()*10);
        }
        else{
	   this.die();
	}
    }
    public int fire(){
          return 0;
    }
    
    public void upgrade(int a){
    }
    public void setGun(String a){
    }
    public void setHP(int a){
	 HP += a;
    }  
    public void special(){
    }
    public void die(){
         name = "X----";
         dead = true;
    }                         
}
