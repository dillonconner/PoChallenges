package Nov1st;

public class AtBashCipher {

    public static StringBuilder encrypt(String in){

        StringBuilder out = new StringBuilder();
        char [] chars = in.toCharArray();
        for(int i = 0; i < chars.length; i++){

            if(chars[i] >= 'A' && chars[i] <= 'Z' ){
                int diff = chars[i] - 'A';
                out.append((char) ('Z' - diff));
            }
            else if(chars[i] >= 'a' && chars[i] <= 'z' ){
                int diff = chars[i] - 'a';
                out.append((char) ('z' - diff));
            }
            else{ //non-letters stay the same
                out.append(chars[i]);
            }
        }

        return out;
    }

    public static void main(String[] args) {

        String test1 = "apple";
        String test2 = "Hello World!";
        String test3 = "Christmas is the 25th of December";

        System.out.println(AtBashCipher.encrypt(test1).toString());
        System.out.println(AtBashCipher.encrypt(test2).toString());
        System.out.println(AtBashCipher.encrypt(test3).toString());
    }
}
