package Nov8th;

public class Harshad {
    public static boolean harshHelper(int num){
        int sum = harshit(num, 0);
        return num%sum == 0;
    }
    public static int harshit(int num, int sum){ //basically a dumb way to make a while loop

        if(num <= 9){
            sum += num;
            return sum;

        }else{
            int val = num %10;
            sum += val;
            num = num /10;
            return harshit(num, sum);
        }
    }

    public static void main(String[] args) {
        System.out.println(harshHelper(75)); //false
        System.out.println(harshHelper(171)); //true
        System.out.println(harshHelper(481)); //true
        System.out.println(harshHelper(89)); //false
        System.out.println(harshHelper(516)); //true
        System.out.println(harshHelper(200)); //true
    }
}
