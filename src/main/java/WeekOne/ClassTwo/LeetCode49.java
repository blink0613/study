package WeekOne.ClassTwo;

import java.util.*;

public class LeetCode49 {
    /**
     * 49. 字母异位词分组
     * 给你一个字符串数组，请你将 字母异位词 组合在一起。可以按任意顺序返回结果列表。
     *
     * 字母异位词 是由重新排列源单词的字母得到的一个新单词，所有源单词中的字母通常恰好只用一次。
     *
     *
     *
     * 示例 1:
     *
     * 输入: strs = ["eat", "tea", "tan", "ate", "nat", "bat"]
     * 输出: [["bat"],["nat","tan"],["ate","eat","tea"]]
     */
    public static void main(String[] args) {

    }

    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> map = new HashMap<>();
        for(String str : strs){
            char[] strArray = str.toCharArray();
            Arrays.sort(strArray);
            List<String> anagrams = map.getOrDefault(Arrays.toString(strArray),new ArrayList<>());
            anagrams.add(str);
            map.put(Arrays.toString(strArray),anagrams);
        }
        return new ArrayList<>(map.values());
    }
}
