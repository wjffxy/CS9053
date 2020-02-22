package edu.nyu.cs9053.homework8;
import java.util.*;
import java.util.regex.*;

public class TextingDictionary {

    private final List<String> list = new ArrayList<String>();

    public void insert(String word) {
        if (!Pattern.matches("[a-zA-Z]+", word)) {
            throw new IllegalArgumentException();
        }
        for (String words : list) {
            if (words.equalsIgnoreCase(word)) {
                return;
            }
        }
        list.add(word);
    }
    
    public List<String> search(List<ValidTextKeyPress> prefixes) {

        List<String> resultList = new ArrayList<String>();
        List<String> helpList = searchCombinationsOfKey(prefixes);
        for (String word : helpList) {
            for (String words : list) {
                if (words.toLowerCase().startsWith(word)) {
                    resultList.add(words);
                }
            }
        }
        return resultList;
    }

    private List<String> searchCombinationsOfKey(List<ValidTextKeyPress> prefixes) {

        LinkedList<String> combinationList = new LinkedList<>();
        combinationList.add("");
        for (int i = 0; i < prefixes.size(); i++) {
            char[] charArray = prefixes.get(i).getDescription().toCharArray();
            while (combinationList.peek().length() == i) { //adding every letter combination of two ValidTextKeyPresses into the linkedList.
                String word = combinationList.remove();
                for (int j = 0; j < charArray.length; j++) {
                    combinationList.add(word + charArray[j]);
                }
            }
        }
        return combinationList;
    } 
}