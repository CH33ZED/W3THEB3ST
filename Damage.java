//all subclass method descritpions are in superclass ship
//hero-use-able ship type, focus on damage

public class Damage extends Ship{
    public Damage(){
	   r = 4;
           c = 0;
           HP = 3;
           gun = "(C";
           name = "Damage";
           nuke = false;
           hit = false;
           ammo = 4;
           kc = 0;
           dead = false;
    }
    public String toString(){
        return ">C---";
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
            ammo = 0;
            nuke = false;
            return 10;
        }
        else{
            if (gun.equals(")=") && ammo == 4){
                    return 4;
	    }
	    else{
	        if(ammo == 4){
                    ammo = 0;
                    return 2;
                }
                else{
		    ammo++;
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
    public void special(){     //get a free nuke for every 10 kills
        if(kc >= 10){
               nuke = true;
               kc -= 10;
        }
    }
    public void die(){
         name = "&&&&&";
         dead = true;
    }                         
}
