package org.vikki;

import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;

import java.util.HashMap;

import static org.junit.Assert.*;

public class FileReaderTest {
    private HashMap map = new HashMap();

    @BeforeEach
    public void setUp() throws Exception {
        FileReader fileReader = new FileReader(map);
    }

    @Test
    @DisplayName("Remove Square brackets from string")
    public void removeSquareBracketsAroundWord() {
        FileReader fileReader = new FileReader(map);
        String expected = "word";
        String actual = fileReader.removeSquareBracketsAroundWord("[word]");
        assertEquals(expected, actual);
    }

}