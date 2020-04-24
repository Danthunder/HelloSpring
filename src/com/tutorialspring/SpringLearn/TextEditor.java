package com.tutorialspring.SpringLearn;

/**
 * @author wangdanning
 * @version V1.0
 * @Package com.tutorialspring.SpringLearn
 * @date 2019/12/9 22:46
 */
public class TextEditor {
    private SpellChecker spellChecker;

    public SpellChecker getSpellChecker() {
        return spellChecker;
    }

    public void setSpellChecker(SpellChecker spellChecker) {
        System.out.println("Inside setSpellChecker." );
        this.spellChecker = spellChecker;
    }

    public void spellCheck() {
        spellChecker.checkSpelling();
    }
}
