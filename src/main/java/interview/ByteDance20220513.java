package interview;

import java.util.Stack;

public class ByteDance20220513 {
    /**
     * LeetCode 503. 下一个更大元素 II
     * 给定一个循环数组 nums （ nums[nums.length - 1] 的下一个元素是 nums[0] ），返回 nums 中每个元素的 下一个更大元素 。
     *
     * 数字 x 的 下一个更大的元素 是按数组遍历顺序，这个数字之后的第一个比它更大的数，这意味着你应该循环地搜索它的下一个更大的数。如果不存在，则输出 -1 。
     */

    public static int[] findMax(int[] array){
        if(array == null || array.length == 0){return array;}

        int[] result = new int[array.length];
        Stack<Integer> stack = new Stack<>();
        int i = 0;
        while(i < array.length){
            if(stack.isEmpty() || array[i] <= array[stack.peek()]){
                stack.push(i);
                i++;
            }else{
                result[stack.pop()] = array[i];
            }
        }
        while(!stack.isEmpty()){result[stack.pop()] = -1;}
        return result;
    }
}
