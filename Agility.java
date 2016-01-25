public class Agility extends Ship{
    public Agility(){
           r = 4;
           c = 0;
           HP = 2;
           gun = "==";
           name = "Agility";
           nuke = false;
           hit = false;
           kc = 0;
           dead = false;
           ammo = 3;
    }
    public String toString(){
        return "---=}";
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
	   if (gun.equals(")=") && ammo == 3){
	         ammo = 0;
                 return 2;
	   }
	   else{ 
               if(ammo == 3){
		   ammo = 0;
                   return 1;
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
    public void special(){
        if(((int)(Math.random()*2))== 0){
               hit = false;
        }
    }
    public void die(){
         name = "&&&&&";
         dead = true;
    }                         
}
