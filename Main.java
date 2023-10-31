import java.util.Scanner;
public class Main {
    public static Scanner sc = new Scanner(System.in);
    public static void main(String[] args){
        //Holidays
        String s1 = "Eid";
        String s2 = "Christmas";
        String s3 = "Thanksgiving";
        String s4 = "Hina Matsuri";
        String s5 = "Qixi";

        String holiday="";
        switch((int) ((Math.random() * 5) + 1)){
            case 1 -> holiday = s1;
            case 2 -> holiday = s2;
            case 3 -> holiday = s3;
            case 4 -> holiday = s4;
            case 5 -> holiday = s5;
            default -> {
            }
        }







    }
    public static String generateDashes(String words){
        String dashes = "";
        int wordLength = words.length();
        int randomIndex1=(int) (Math.random() * wordLength);
        int randomIndex2=(int) (Math.random() * wordLength);

        if(wordLength<4){
            randomIndex2 = -1;

        } else if(wordLength>4){
            while(randomIndex2==randomIndex1){
                randomIndex2 = (int) (Math.random() * wordLength);
            }
        }
        for(int i=0;i<wordLength;i++) {
            if(i==randomIndex2 || i==randomIndex1 || words.charAt(i)==' '){
                dashes += words.charAt(i);
            } else{
                dashes += "_";
            }
        }
        return dashes;
    }
}
