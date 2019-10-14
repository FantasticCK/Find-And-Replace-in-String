package com.CK;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
//        String S = "abcd";
//        int[] indexes = {0, 2};
//        String[] sources = {"a", "cd"}, targets = {"eee", "ffff"};
//        String S = "vmokgggqzp";
//        int[] indexes = {3,5,1};
//        String[] sources = {"kg","ggq","mo"}, targets = {"s","so","bfr"};
        String S = "jjievdtjfb";
        int[] indexes = {4, 6, 1};
        String[] sources = {"md", "tjgb", "jf"}, targets = {"foe", "oov", "e"};

        new Solution().findReplaceString(S, indexes, sources, targets);
    }
}

class Solution {
    public String findReplaceString(String S, int[] indexes, String[] sources, String[] targets) {
        if (indexes.length == 0 || sources.length == 0 || targets.length == 0) {
            return S;
        }
        Map<Integer, String> sMap = new HashMap<>(), tMap = new HashMap<>();
        for (int i = 0; i < indexes.length; i++) {
            sMap.put(indexes[i], sources[i]);
            tMap.put(indexes[i], targets[i]);
        }

        Arrays.sort(indexes);
        int i = 0, s = 0;
        StringBuilder sb = new StringBuilder();
        while (i < indexes.length) {
            int index = indexes[i];
            String source = sMap.get(index);
            String target = tMap.get(index);
            if (s < index) {
                sb.append(S.substring(s, index));
                s = index;
                continue;
            }

            if (!S.substring(s, s + source.length()).equals(source)) {
                sb.append(S, s, s + source.length());
                i++;
                s += source.length();
                continue;
            }

            sb.append(target);
            i++;
            s += source.length();
        }

        if (s <= S.length() - 1) {
            sb.append(S.substring(s));
        }
        return sb.toString();
    }
}