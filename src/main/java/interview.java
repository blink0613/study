public class interview {
    public static void main(String[] args) {
        System.out.println(waysOfStairs(4));
    }
    /**
     * 爬楼梯，有n节楼梯，你每次只能走1，2，3节，有多少种办法保证爬上楼梯？
     */
    public static int waysOfStairs(int n){
        if(n <=3){return n;}
        int[] arr = new int[n];
        arr[0] = 1;
        arr[1] = 2;
        arr[2] = 3;
        for(int i = 3; i < n;i++){
            arr[i] = arr[i-2] + arr[i-1] + arr[i-3];
        }

        return arr[n-1];

    }

}
