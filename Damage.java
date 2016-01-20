public class Damage extends Ship{
    public Damage(){
           r = 4;
           c = o;
           HP = 3;
           gun = "(C";
           name = "Damage";
           nuke = false;
           hit = false;
           ammo = 0;
           kc = 0;
    }
    public String toString(){
        return "]}" + HP + "=" + gun;
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
	      bullet a = bullet(r,c+1,4);
	}
	else{
	    if(ammo % 2 == 0){
	      bullet a = bullet(r,c+1,2);
            }
        }
	ammo++;     	  
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
               nuke = true;
               kc -= 10;
        }
    }
    public die(){
         name = "&&&";
    }                         
}
