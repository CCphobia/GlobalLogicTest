package com.augustowskipiotr;

import java.util.Comparator;
import java.util.List;

public class KeyWordCharComparator implements Comparator<Character> {

    private List<Character> keyWordChars;

    public KeyWordCharComparator(List<Character> keyWordChars) {
        if(keyWordChars.size() == 0) {
            throw new IllegalArgumentException();
        }
        this.keyWordChars = keyWordChars;
    }

    @Override
    public int compare(Character o1, Character o2) {

        if(keyWordChars.size() == 1) {
            return 0;
        }

        int o1Index = keyWordChars.indexOf(o1);
        int o2Index = keyWordChars.indexOf(o2);

        if(o1Index > o2Index) {
            return 1;
        } else if(o1Index < o2Index) {
            return -1;
        } else {
            return 0;
        }
    }


}
