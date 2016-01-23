public class Powerup extends Ship{
    public Powerup(){
	   r = (int)(math.random() * 10);
           c = 9;
           HP = 1;
           gun = "";
           name = "Powerup";
           nuke = false;
           hit = false;
           ammo = 0;
           kc = 0;
           dead = false;
    }
    public String toString(){
        return "[" + gun + "]";
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
        gun = a;
    }
    public void setHP(int a){
    }  
    public void special(){
        if((int)(math.random()*2)==0){
	    gun = "+";
        }
        else{
            gun = ")=";
        }
    }
    public void die(){
         name = "!";
         dead = true;
    }                         
}
