import java.util.ArrayList;

public class Spaceinvader{
    public static int score;
    public static int time;
    public static int type;
    public static String mv;
    public static Ship hero;
    public static String[][] z = {{"-----","-----","-----","-----","-----","-----","-----","-----","-----","-----"},{"-----","-----","-----","-----","-----","-----","-----","-----","-----","-----"},{"-----","-----","-----","-----","-----","-----","-----","-----","-----","-----"},{"-----","-----","-----","-----","-----","-----","-----","-----","-----","-----"},{"-----","-----","-----","-----","-----","-----","-----","-----","-----","-----"},{"-----","-----","-----","-----","-----","-----","-----","-----","-----","-----"},{"-----","-----","-----","-----","-----","-----","-----","-----","-----","-----"},{"-----","-----","-----","-----","-----","-----","-----","-----","-----","-----"},{"-----","-----","-----","-----","-----","-----","-----","-----","-----","-----"},{"-----","-----","-----","-----","-----","-----","-----","-----","-----","-----"},};
    public static void printS(){
        for (String[] n: z){
	    System.out.println();
            for (String b: n){
                System.out.print(b);
            }
	}
    }
    public static void set(int a, int b, String c){
        z[a][b] = c;
    }
    public static void main(String [] args){
        System.out.println("Choose a class!");
        System.out.println("");
        System.out.println("1.Tank         2.Damage        3.Agility");      
        type = Keyboard.readInt();
        System.out.println("Good Choice! Get Ready for battle");
        hero = new Damage();
        z[hero.r][hero.c] = hero.toString();
        printS();
        time = 30;
        while(time > 0){
            System.out.println();
            System.out.println("move!");
            mv = Keyboard.readString();
            set(hero.r,hero.c,"-----");
            hero.setMove(mv);
            set(hero.r,hero.c,hero.toString());
	    printS();
            time--;
	}
    }
}
        
