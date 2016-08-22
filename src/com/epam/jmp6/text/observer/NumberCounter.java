package com.epam.jmp6.text.observer;

import com.epam.jmp6.text.TextSubject;

/**
 * Created by Vitali on 22.08.2016.
 */
public class NumberCounter extends TextObserver {
    private int count;

    public NumberCounter(TextSubject subject) {
        super(subject);
        subject.attach(this);
    }

    public int getCount() {
        return count;
    }

    @Override
    public void update() {
        String word = subject.getWord();
        if(word != null){
            try{
                int digit = Integer.parseInt(word);
                count++;
            }catch(NumberFormatException e){
            }
        }
    }
}
