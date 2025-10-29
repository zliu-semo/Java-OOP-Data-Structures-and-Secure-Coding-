package res;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class isNumberTests {
    
    PostfixProcessor in = new PostfixProcessor();

    @Test
    void testPositiveInteger() {
        assertTrue(in.isNumber("100"));
    }
    
    @Test
    void testNegativeInteger() {
        assertTrue(in.isNumber("-100"));
    }
    
    @Test
    void testPositiveFloat() {
        assertTrue(in.isNumber("+100.1"));
    }
    
    @Test
    void testNegativeFloat() {
        assertTrue(in.isNumber("-100.1"));
    }
    
    @Test
    void testPositiveDecimalEnd() {
        assertTrue(in.isNumber("+100."));
    }
    
    @Test
    void testPositiveDecimalStart() {
        assertTrue(in.isNumber(".25"));
    }
    
    @Test
    void testNegativeDecimalEnd() {
        assertTrue(in.isNumber("-60."));
    }
    
    @Test
    void testNegativeDecimalStart() {
        assertTrue(in.isNumber("-.60"));
    }
    
    @Test
    void testTwoDecimalPoints() {
        assertFalse(in.isNumber("60.0.0"));
    }
    
    @Test
    void testNegativeSignInMiddle() {
        assertFalse(in.isNumber("60-1"));
    }
    
    @Test
    void testTwoSigns() {
        assertFalse(in.isNumber("+-60"));
    }
    
    @Test
    void testNonDigits() {
        assertFalse(in.isNumber("80a"));
    }
    
    @Test
    void testEmptyString() {
        assertFalse(in.isNumber(""));
    }
}
