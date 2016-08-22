package com.epam.jmp6.text.observer;

import com.epam.jmp6.text.TextSubject;

/**
 * Created by Vitali on 22.08.2016.
 */
public abstract class TextObserver {
    protected TextSubject subject;

    public TextObserver() {
    }

    public TextObserver(TextSubject subject) {
        this.subject = subject;
        subject.attach(this);
    }

    public abstract void update();
}
