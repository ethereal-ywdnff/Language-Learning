package com11;

import java.util.HashSet;
import java.util.Set;

public class _1_3_The_longest_substring_without_repeating_characters {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        int maxLength = 0;
        int left = 0;  // 滑动窗口的左边界

        for (int right = 0; right < s.length(); right++) {
            while (set.contains(s.charAt(right))) {
                // 如果遇到重复字符，移动左边界直到没有重复
                set.remove(s.charAt(left));
                left++;
            }
            set.add(s.charAt(right));
            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }

    public static void main(String[] args) {
        _1_3_The_longest_substring_without_repeating_characters solution = new _1_3_The_longest_substring_without_repeating_characters();
        System.out.println(solution.lengthOfLongestSubstring("abcabcbb"));
        System.out.println(solution.lengthOfLongestSubstring("bbbbb"));
        System.out.println(solution.lengthOfLongestSubstring("pwwkew"));
    }

}