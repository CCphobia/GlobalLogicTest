package com.augustowskipiotr;

public class SubstringInWordLengthEntry implements Comparable<SubstringInWordLengthEntry> {

    private String substring;
    private int wordLength;

    public SubstringInWordLengthEntry(String substring, int wordLength) {
        this.substring = substring;
        this.wordLength = wordLength;
    }

    public String getSubstring() {
        return substring;
    }

    public void setSubstring(String substring) {
        this.substring = substring;
    }

    public int getWordLength() {
        return wordLength;
    }

    public void setWordLength(int wordLength) {
        this.wordLength = wordLength;
    }

    @Override
    public int compareTo(SubstringInWordLengthEntry o) {
        if(this.getSubstring().equals(o.getSubstring())) {
            if(this.getWordLength() > o.getWordLength()) {
                return 1;
            } else if(this.getWordLength() < o.getWordLength()) {
                return -1;
            } else return 0;
        }

        return this.getSubstring().compareTo(o.getSubstring());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SubstringInWordLengthEntry that = (SubstringInWordLengthEntry) o;

        if (wordLength != that.wordLength) return false;
        return substring != null ? substring.equals(that.substring) : that.substring == null;
    }

    @Override
    public int hashCode() {
        int result = substring != null ? substring.hashCode() : 0;
        result = 31 * result + wordLength;
        return result;
    }
}
