package com.devtstromo.behavioral.memento;


import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class EditorTest {


    @Test
    public void testMemento(){
        Editor editor = new Editor();

        editor.write("Like and");
        editor.write("Like and Subscribe");
        editor.write("Like and Subscribe to Geekific!");

        editor.undo();

        assertEquals("Like and", editor.getTextArea().getText());
    }

}