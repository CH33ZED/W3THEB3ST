//all subclass method descritpions are in superclass ship
//hero-use-able powerups

public class Powerup extends Ship{
    public Powerup(){
	   r = (int)(Math.random() * 10);
           c = 9;
           HP = 1;
           if(r == 0){
	       gun = "[>=>]";          // 1/9 chance to get a nuke
           }
           else if(r > 0 && r < 5) {
	       gun = "[+]--";          // 4/9 chance to get a medkit
	   }
	   else{
               gun = "[)=]-";          // 4/9 chance to get a twin cannon
           } 
           name = "Powerup";
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
        if(c > 1){
            c--;
        }
        else{
            this.die();
        }
    }
    public int fire(){;
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
         name = "--!--";
         dead = true;
    }                         
}
