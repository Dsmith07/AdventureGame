package game;

import globals.WT;

public class WordAndType {

    private String word;
    private WT wordtype;

    public WordAndType(String wd, WT wt) {
        word = wd;
        wordtype = wt;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public WT getWordtype() {
        return wordtype;
    }

    public void setWordtype(WT wordtype) {
        this.wordtype = wordtype;
    }

}
