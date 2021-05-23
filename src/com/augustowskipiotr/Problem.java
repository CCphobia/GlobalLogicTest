package com.augustowskipiotr;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Problem {

    private final String keyWord;
    private final List<Character> keyWordChars;

    public Problem(String keyWord) {
        this.keyWord = keyWord;
        this.keyWordChars = keyWord.chars().mapToObj(e -> (char) e).collect(Collectors.toList());
    }

    public Map<SubstringInWordLengthEntry, Integer> solve(String[] words) {

        Map<SubstringInWordLengthEntry, Integer> frequencyMap = new TreeMap<>();
        StringBuilder substringCache = new StringBuilder("");
        Comparator<Character> comparator = new KeyWordCharComparator(keyWordChars);

        for(String word: words) {

            for(char wordChar: word.toCharArray()) {

                if(keyWordChars.contains(wordChar)) {
                    substringCache.append(wordChar);
                } else {

                    if(!substringCache.isEmpty()) {
                        String sortedSubstring = sortString(substringCache.toString(), comparator);

                        SubstringInWordLengthEntry entry =
                                new SubstringInWordLengthEntry(sortedSubstring, word.length());

                        if(frequencyMap.containsKey(entry)) {
                            int oldCounter = frequencyMap.get(entry);
                            frequencyMap.replace(entry, ++oldCounter);
                        } else {
                            frequencyMap.put(entry, 0);
                        }

                        substringCache.setLength(0);
                    }
                }
            }
        }

        return frequencyMap;
    }

    private String sortString(String string, Comparator<Character> comparator) {
        Character[] chars =
                string.chars().mapToObj(c -> (char)c).toArray(Character[]::new);

        Arrays.sort(chars, comparator);

        StringBuilder sb = new StringBuilder("");

        for(Character character : chars) {
            sb.append(character);
        }

        return sb.toString();
    }
}
