public class Tank extends Ship{
    public Tank(){
           r = 4;
           c = o;
           HP = 6;
           gun = ">";
           name = "Tank";
           nuke = false;
           hit = false;
    }
    public String toString(){
        return "~" + HP + "}" + gun;
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
    public upgrade(int a){
        setHP(HP + a);
    }
    public setGun(String a){
        gun = a;
    }
    public setHP(int a){
        HP = a;
    }  
    public special(){
        if(kc >= 10){
               this.setHP(kc/10);
               kc %= 10;
        }
    }
    public die(){
         name = "&&&";
    }                         
}
