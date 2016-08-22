package com.epam.jmp6.text;

import com.epam.jmp6.text.observer.TextObserver;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

/**
 * Created by Vitali on 22.08.2016.
 */
public class TextSubject implements AutoCloseable{
    private Scanner scanner;
    private Set<TextObserver> observers = new HashSet<TextObserver>();
    private WordIterator iterator = new WordIterator();
    private String word;

    public TextSubject() {
    }

    public TextSubject(File file) throws FileNotFoundException {
        this.scanner = new Scanner(file).useDelimiter("\\s");
    }

    public void attach(TextObserver observer){
        observers.add(observer);
    }

    public Iterator<String> getIterator(){
        return iterator;
    }

    public String getWord(){
        return word;
    }

    @Override
    public void close() throws Exception {
        scanner.close();
    }

    private void notifyAllObservers(){
        observers.forEach(observer -> observer.update());
    }

    private class WordIterator implements Iterator<String>{
        @Override
        public boolean hasNext() {
            return scanner.hasNext();
        }

        @Override
        public String next() {
            word = scanner.next();
            notifyAllObservers();
            return word;
        }
    }
}
