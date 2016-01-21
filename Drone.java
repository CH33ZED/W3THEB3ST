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
        return "<}";
    }
    public void setMove(String a){
        if(c > 0){
	   c--;
        }
        else{
	   this.die();
	}
    }
    public void fire(){
    }
    
    public void upgrade(int a){
    }
    public void setGun(String a){
    }
    public void setHP(int a){
    }  
    public void special(){
    }
    public void die(){
         name = "X";
         dead = true;
    }                         
}
