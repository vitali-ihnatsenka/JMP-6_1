package com.epam.jmp6.text.observer;

import com.epam.jmp6.text.TextSubject;

/**
 * Created by Vitali on 22.08.2016.
 */
public class WordCounter extends TextObserver {
    private int count;

    public WordCounter(TextSubject subject) {
        super(subject);
        subject.attach(this);
    }

    public int getCount() {
        return count;
    }

    @Override
    public void update() {
        if(subject.getWord() != null){
            count++;
        }
    }
}
