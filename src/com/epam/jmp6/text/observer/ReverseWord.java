package com.epam.jmp6.text.observer;

import com.epam.jmp6.text.TextSubject;

/**
 * Created by Vitali on 22.08.2016.
 */
public class ReverseWord extends TextObserver {
    private String reverseWord;

    public ReverseWord(TextSubject subject) {
        super(subject);
        subject.attach(this);
    }

    public String getReverseWord() {
        return reverseWord;
    }

    @Override
    public void update() {
        String word = subject.getWord();
        if(word != null && word.length() > 3){
            reverseWord = new StringBuilder(word).reverse().toString();
        }
    }
}
