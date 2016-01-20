public class Agility extends Ship{
    public Agility(){
           r = 4;
           c = 0;
           HP = 2;
           gun = "-";
           name = "Agility";
           nuke = false;
           hit = false;
           kc = 0;
           dead = false;
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
	      bullet a = bullet(r,c+1, 1);
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
        if(((int)(Math.random()*2))== 0){
               hit = false;
        }
    }
    public void die(){
         name = "&&&";
         dead = true;
    }                         
}
