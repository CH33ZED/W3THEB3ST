import cs1.Keyboard;
import java.util.ArrayList;

public class Spaceinvader{
    public static int score;
    public static int time;
    public static int type;
    public static String mv;
    public static Ship hero;
    public static String[][] z = {{"-----","-----","-----","-----","-----","-----","-----","-----","-----","-----","-----","-----","-----","-----","-----","-----","-----","-----","-----","-----"},{"-----","-----","-----","-----","-----","-----","-----","-----","-----","-----","-----","-----","-----","-----","-----","-----","-----","-----","-----","-----"},{"-----","-----","-----","-----","-----","-----","-----","-----","-----","-----","-----","-----","-----","-----","-----","-----","-----","-----","-----","-----"},{"-----","-----","-----","-----","-----","-----","-----","-----","-----","-----","-----","-----","-----","-----","-----","-----","-----","-----","-----","-----"},{"-----","-----","-----","-----","-----","-----","-----","-----","-----","-----","-----","-----","-----","-----","-----","-----","-----","-----","-----","-----"},{"-----","-----","-----","-----","-----","-----","-----","-----","-----","-----","-----","-----","-----","-----","-----","-----","-----","-----","-----","-----"},{"-----","-----","-----","-----","-----","-----","-----","-----","-----","-----","-----","-----","-----","-----","-----","-----","-----","-----","-----","-----"},{"-----","-----","-----","-----","-----","-----","-----","-----","-----","-----","-----","-----","-----","-----","-----","-----","-----","-----","-----","-----"},{"-----","-----","-----","-----","-----","-----","-----","-----","-----","-----","-----","-----","-----","-----","-----","-----","-----","-----","-----","-----"},{"-----","-----","-----","-----","-----","-----","-----","-----","-----","-----","-----","-----","-----","-----","-----","-----","-----","-----","-----","-----"}};
    public static void printS(){
        for (String[] n: z){
	    System.out.println();
            for (String b: n){
                System.out.print(b);
            }
	}
    }
    public static void main(String [] args){
        System.out.println("Choose a class!");
        System.out.println("");
        System.out.println("1.Tank         2.Damage        3.Agility");      
        type = Keyboard.readInt();
        System.out.println("Good Choice! Get Ready for battle");
        hero = new Damage();
        z[4][0] = hero.toString();
        printS();
    }
}
        
