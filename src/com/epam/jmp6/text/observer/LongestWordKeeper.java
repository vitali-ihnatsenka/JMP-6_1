package com.epam.jmp6.text.observer;

import com.epam.jmp6.text.TextSubject;

/**
 * Created by Vitali on 22.08.2016.
 */
public class LongestWordKeeper extends TextObserver {
    private String longestWord = "";
    public LongestWordKeeper(TextSubject subject) {
        super(subject);
        subject.attach(this);
    }

    public String getLongestWord() {
        return longestWord;
    }

    @Override
    public void update() {
        String word = subject.getWord();
        if(word != null && word.length() > longestWord.length()){
            longestWord = word;
        }
    }
}
