public abstract class Ship{
    public String name;
    public String gun; 
    public int r;
    public int c;
    public int HP;
    public boolean nuke;
    public boolean hit;
    public int kc;
    public abstract void move(String a);
    public abstract void fire();
    public abstract void upgrade(int a);  
    public abstract void setGun(String a);
    public abstract void setHP(int a);
    public abstract void special();
    public abstract void die(); 
}
