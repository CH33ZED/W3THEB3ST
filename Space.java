public class Space extends Ship{
    public Space(){
	   r = 0;
           c = 0;
           HP = 0;
           gun = "-----";
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
    public void fire(){
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
