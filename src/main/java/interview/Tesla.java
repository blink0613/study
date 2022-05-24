package interview;

public class Tesla {

    /**
     * 2022.05.24 特斯拉笔试
     * 二进制转十进制，除2于1 则 -1， 除2于0 则除2，到0为止，返回共需要多少次除法
     * @param
     * @return
     */

    public static void main(String[] args) {
        String s = "011100";
        solution(s);
    }

    public static int solution(String S) {
        // write your code in Java SE 8
        //二进制转十进制
        int i = S.length() - 1;
        long number = 0;
        while(i >=0){
            if(S.charAt(i) == '1'){
                System.out.println(i);
                number += Math.pow(2,S.length() - i - 1);
            }
            i--;
        }
        System.out.println(number);
        int result = 0;
        while(number != 0){
            if(number % 2 == 0){
                number = number/2;
            }else{
                number--;
            }
            result++;
        }
        return result;
    }
}
