import java.util.Scanner;
public class Main {
    public static Scanner sc = new Scanner(System.in);
    public static void main(String[] args){
        //Holidays
        String s1 = "eid";
        String s2 = "christmas";
        String s3 = "thanksgiving";
        String s4 = "hina matsuri";
        String s5 = "qixi";
        String playAgain = "1";
        while(playAgain.equals("1")){
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
            String dashes = generateDashes(holiday);
            //Print the start of a game
            System.out.println("<<<Hang Man Game>>>");
            System.out.println(dashes);

            int tries = 3;
            while(tries>=0){
                System.out.println("Enter a letter:");
                String guess = sc.next();
                while((guess.length() != 1) || guess.equals(" ")) {
                    System.out.println("Hey that wasn't 1 letter. Try again:");
                    guess = sc.next();
                }
                if(holiday.contains(guess)){
                    dashes = updateDashes(guess, dashes, holiday);
                    System.out.println(dashes);
                    if(dashes.equals(holiday)){
                        System.out.println("You win!");
                        break;
                    }
                } else{
                    System.out.println(dashes);
                    tries--;
                    System.out.println("You have "+ tries + " left");
                }

            }
            if(!(dashes.equals(holiday))) System.out.println("Too bad, you ran out of tries. The correct answer is: "+ holiday);
            System.out.println("press 1 to play again, press any other key to quit:");
            playAgain = sc.next();
            System.out.println();
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
    public static String updateDashes(String guess, String dashes, String word){
        while(word.contains(guess)){
            dashes = dashes.substring(0,word.indexOf(guess))+ guess +dashes.substring(word.indexOf(guess)+1);
            word = word.substring(0,word.indexOf(guess))+ " " +word.substring(word.indexOf(guess)+1);
        }
        return dashes;
    }
}
