public class Tank extends Ship{
    public Tank(){
           r = 4;
           c = 0;
           HP = 6;
           gun = ">";
           name = "Tank";
           nuke = false;
           hit = false;
           kc = 0;
           dead = false;
    }
    public String toString(){
        return "[}" + HP + "}]" + gun;
    }
    public void setMove(String a){
        if(a = "w"){
            if(r > 0){
                r--;
            }
	else{
            if(r < 9){
                r++;
            }
        }
    }
    public void fire(){
        if (gun.equals(")="){
	      bullet a = bullet(r,c+1,2);
	}
	else{
	    if(ammo % 3 == 0){
	      bullet a = bullet(r,c+1,2);
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
        HP = a;
    }  
    public void special(){
        if(kc >= 10){
               this.setHP(kc/10);
               kc %= 10;
        }
    }
    public void die(){
         name = "&&&";
         dead = true;
    }                         
}
