//all subclass method descritpions are in superclass ship
//hero-use-able ship type

public class Tank extends Ship{
    public Tank(){
           r = 4;
           c = 0;
           HP = 6;
           gun = ">[";
           name = "Tank";
           nuke = false;
           hit = false;
           kc = 0;
           dead = false;
           ammo = 4;
    }
    public String toString(){
        return "}]---";
    }
    public void setMove(String a){
        if(a.equals("w")){
            if(r > 0){
                r--;
            }
        }
        if(a.equals("s")){
            if(r < 9){
                r++;
            }
	}
	else{
        }
    }
    public int fire(){
	if(nuke == true){
            nuke = false;
            ammo = 0;
            return 10;
        }
        else{
            if (gun.equals(")=") && ammo == 4){
                 return 2;
	    }
 	    else{
	         if(ammo == 4){;
                     ammo = 0;
                     return 2;
                 }
                 else{
                     ammo++;;
                     return 0;
                 }
            }
        }
    }
    public void upgrade(int a){
        setHP(HP + a);
    }
    public void setGun(String a){
        gun = a;
    }
    public void setHP(int a){
        HP += a;
        if (HP >= 10){
            HP = 9;
        }
    }  
    public void special(){                         //regains 1 health for every 10 kills
        if(kc >= 10){
               this.setHP(kc/10);
               kc %= 10;
        }
    }
    public void die(){
         name = "&&&&&";
         dead = true;
    }                         
}
