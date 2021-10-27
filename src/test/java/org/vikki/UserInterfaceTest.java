package org.vikki;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class UserInterfaceTest {

   public String message = "Invalid command number entered.Please Enter a valid number";
   WrongInputException wrongInputException = new WrongInputException(message);

    @Test
    public void testMessage() {
        assertEquals(message, wrongInputException.getMessage());
    }

}