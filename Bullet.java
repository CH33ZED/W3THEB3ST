public class Bullet extends Ship{
    public Bullet(int x, int y, int num){
           r = x;
           c = y;
           HP = num;
           gun = ":";
           name = "Bullet";
           if(num == 10){
              nuke = true;
           }
           else{
	      nuke = false; 
           }
           hit = false;
           kc = 0;
           dead = false;
    }
    public String toString(){
        if(nuke == true){
           return "-~>=>";
        }
        else{ 
	   if(HP < 2){
               return "----O";
           }
	   else{
               return "~=:>)";
           }
	}     
    }
    public void setMove(String a){
            if(c < 9){
                c++;
            }
    }
    public int fire(){
	   return 0;
    }
    public void upgrade(int a){
    }
    public void setGun(String a){
    }
    public void setHP(int a){
    }  
    public void special(){
    }
    public void die(){
         name = ")>=<(";
         dead = true;
    }                         
}
