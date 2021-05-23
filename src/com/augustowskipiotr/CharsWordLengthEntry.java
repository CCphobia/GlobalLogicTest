package com.augustowskipiotr;

import java.util.*;

public class CharsWordLengthEntry implements Comparable<CharsWordLengthEntry> {

    private Set<Character> chars;
    private int wordLength;

    public CharsWordLengthEntry(Comparator<Character> comparator) {
        this.chars = new TreeSet<>(comparator);
        this.wordLength = 0;
    }

    public CharsWordLengthEntry(Set<Character> chars, int wordLength) {
        this.chars = chars;
        this.wordLength = wordLength;
    }

    @Override
    public int compareTo(CharsWordLengthEntry o) {
        if(this.getChars().equals(o.chars)) {
            if(this.wordLength > o.wordLength) return 1;
            if(this.wordLength < o.wordLength) return -1;
            return 0;
        } else {
            return -1;
        }
    }

    public void clear() {
        this.chars.clear();
        this.wordLength = 0;
    }

    public Set<Character> getChars() {
        return chars;
    }

    public int getWordLength() {
        return wordLength;
    }

    public void setWordLength(int wordLength) {
        this.wordLength = wordLength;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CharsWordLengthEntry entry = (CharsWordLengthEntry) o;

        if (wordLength != entry.wordLength) return false;
        return chars.equals(entry.chars);
    }

    @Override
    public int hashCode() {
        int result = chars.hashCode();
        result = 31 * result + wordLength;
        return result;
    }
}
