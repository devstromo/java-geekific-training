package com.devtstromo.behavioral.memento;

public class TextArea {
    private String text;

    public void setText(String text) {
        this.text = text;
    }

    public Memento takeSnapshot() {
        return new Memento(this.text);
    }

    public void restore(Memento memento) {
        this.text = memento.getSavedText();
    }

    public String getText() {
        return text;
    }

    public static class Memento {
        private final String text;

        public Memento(String textToSave) {
            this.text = textToSave;
        }

        public String getSavedText() {
            return text;
        }
    }
}
