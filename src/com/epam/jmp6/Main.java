package com.epam.jmp6;

import com.epam.jmp6.text.TextSubject;
import com.epam.jmp6.text.observer.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Iterator;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("d:\\book.txt");
        try(TextSubject subject = new TextSubject(file)){
            LongestWordKeeper longestWordKeeper = new LongestWordKeeper(subject);
            ReverseWord reverseWord = new ReverseWord(subject);
            NumberCounter numberCounter = new NumberCounter(subject);
            WordCounter wordCounter = new WordCounter(subject);

            Iterator<String> iterator = subject.getIterator();
            while(iterator.hasNext()){
                iterator.next();
            }
            System.out.println("Longest word " + longestWordKeeper.getLongestWord());
            System.out.println("Last reverse word " + reverseWord.getReverseWord());
            System.out.println("Number counter " + numberCounter.getCount());
            System.out.println("Word counter " + wordCounter.getCount());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
