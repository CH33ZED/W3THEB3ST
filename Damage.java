public class Damage extends Ship{
    public Damage(){
	   r = 4;
           c = 0;
           HP = 3;
           gun = "(C";
           name = "Damage";
           nuke = false;
           hit = false;
           ammo = 0;
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
    public void fire(){
	/*
        if (gun.equals(")="){
	      bullet a = bullet(4);
	}
	else{
	    if(ammo % 2 == 0){
	      bullet a = bullet(2);
            }
        }
	ammo++;
        */     	  
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
    public void special(){
        if(kc >= 10){
               nuke = true;
               kc -= 10;
        }
    }
    public void die(){
         name = "&&&";
         dead = true;
    }                         
}
