package WeekOne.ClassTwo;



import java.util.*;

public class LeetCode30 {
    /**
     * 30. 串联所有单词的子串
     * 给定一个字符串 s 和一些 长度相同 的单词 words 。找出 s 中恰好可以由 words 中所有单词串联形成的子串的起始位置。
     *
     * 注意子串要与 words 中的单词完全匹配，中间不能有其他字符 ，但不需要考虑 words 中单词串联的顺序。
     *
     *
     *
     * 示例 1：
     *
     * 输入：s = "barfoothefoobarman", words = ["foo","bar"]
     * 输出：[0,9]
     * 解释：
     * 从索引 0 和 9 开始的子串分别是 "barfoo" 和 "foobar" 。
     * 输出的顺序不重要, [9,0] 也是有效答案。
     */
    public static void main(String[] args) {
        String s = "barfoothefoobarman";
        String[] words = {"foo","bar"};
        System.out.println( findSubstring(s,words));
    }
    public static List<Integer> findSubstring(String s, String[] words) {
        List<Integer> result = new ArrayList<>();
        if (s == null || s.length() == 0 || words == null || words.length == 0) return result;
        Map<String,Integer> map = new HashMap();
        for(String word : words){
            map.put(word,map.getOrDefault(word,0)+1);
        }
        int wordsLength = words.length * words[0].length();
        for(int i = 0 ; i <= s.length() - wordsLength;i++){
            Map<String,Integer> listMap = new HashMap<>();
            String sub = s.substring(i,i+wordsLength);
            for(int j = 0;j < sub.length();j+=words[0].length()){
                String subString = sub.substring(j,j+words[0].length());
                listMap.put(subString,listMap.getOrDefault(subString,0)+1);
            }
            if(listMap.equals(map)) result.add(i);
        }
        return result;
    }
}
