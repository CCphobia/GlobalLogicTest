package com.augustowskipiotr;

import java.util.*;
import java.util.stream.Collectors;

public class Problem {

    private final String keyWord;
    private final List<Character> keyWordChars;
    private int keyCharsCounter;
    private int wordsCharsCounter;

    public Problem(String keyWord) {
        this.keyWord = keyWord.toLowerCase();
        this.keyWordChars = this.keyWord.chars().mapToObj(e -> (char) e).collect(Collectors.toList());
        this.keyCharsCounter = 0;
        this.wordsCharsCounter = 0;
    }

    public Map<CharsWordLengthEntry, Integer> solve(String text) {
        String cleanedText = cleanString(text);
        String[] words = cleanedText.split(" ");

        return solve(words);
    }

    private Map<CharsWordLengthEntry, Integer> solve(String[] words) {

        Comparator<Character> comparator = new StringCharOrderComparator(this.keyWord);
        Map<CharsWordLengthEntry, Integer> frequencyMap = new HashMap<>();

        for(String word: words) {
            int wordLength = word.length();

            CharsWordLengthEntry cacheEntry = new CharsWordLengthEntry(comparator);
            cacheEntry.setWordLength(wordLength);
            this.wordsCharsCounter += wordLength;
            int localKeyCharCounter = 0;

            for(char wordChar: word.toCharArray()) {
                if(keyWordChars.contains(wordChar)) {
                    cacheEntry.getChars().add(wordChar);
                    keyCharsCounter++;
                    localKeyCharCounter++;
                }
            }
            if(cacheEntry.getChars().size() > 0) {
                if(frequencyMap.containsKey(cacheEntry)) {
                    int oldCounter = frequencyMap.get(cacheEntry);
                    int newCounter = oldCounter + localKeyCharCounter;
                    frequencyMap.replace(cacheEntry, newCounter);
                } else {
                    frequencyMap.put(cacheEntry, localKeyCharCounter);
                }
            }
        }
        return frequencyMap;
    }

    public String solutionToString(Map<CharsWordLengthEntry, Integer> solution) {

        List<Map.Entry<CharsWordLengthEntry, Integer>> entryList
                = new ArrayList<>(solution.entrySet());
        entryList.sort(Map.Entry.comparingByValue());

        StringBuilder stringBuilder = new StringBuilder("");

        for(Map.Entry<CharsWordLengthEntry, Integer> entry: entryList) {
            stringBuilder.append("{(");

            Iterator entryCharsSetIterator = entry.getKey().getChars().iterator();
            while(entryCharsSetIterator.hasNext()){
                stringBuilder.append(entryCharsSetIterator.next());

                if(entryCharsSetIterator.hasNext()) {
                    stringBuilder.append(", ");
                }
            }

            stringBuilder.append("), ")
                .append(entry.getKey().getWordLength())
                .append("} = ");

            double localFrequency = (double) entry.getValue() / (double) keyCharsCounter;
            double roundedLocalFrequency = (double) Math.round(localFrequency * 100) / 100;

            stringBuilder.append(roundedLocalFrequency)
                    .append(" (")
                    .append(entry.getValue())
                    .append("/")
                    .append(this.keyCharsCounter)
                    .append(")")
                    .append("\n");
        }

        double totalFrequency = (double) keyCharsCounter / (double) wordsCharsCounter;
        double roundedTotalFrequency = (double) Math.round(totalFrequency * 100) / 100;

        stringBuilder.append("TOTAL Frequency: ")
                .append(roundedTotalFrequency)
                .append(" (")
                .append(keyCharsCounter)
                .append("/")
                .append(wordsCharsCounter)
                .append(")");

        return stringBuilder.toString();
    }

    public void printSolution(Map<CharsWordLengthEntry, Integer> solution) {
        System.out.println(solutionToString(solution));
    }

    private String cleanString(String text) {
        String cleanedText = text.replaceAll("[^a-zA-Z0-9\s]", "");
        cleanedText = cleanedText.replaceAll(" +", " ");

        return cleanedText.toLowerCase();
    }
}
