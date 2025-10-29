package res;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class hasHigherPrecedenceTests {
    PostfixProcessor in = new PostfixProcessor();
    
    @Test
    void testOpenParentheses() {
        assertFalse(in.hasHigherPrecedence("(", "("));
        assertFalse(in.hasHigherPrecedence("(", "^"));
        assertFalse(in.hasHigherPrecedence("(", "*"));
        assertFalse(in.hasHigherPrecedence("(", "/"));
        assertFalse(in.hasHigherPrecedence("(", "+"));
        assertFalse(in.hasHigherPrecedence("(", "-"));
    }
    
    @Test
    void testExponentiation() {
        assertTrue(in.hasHigherPrecedence("^", "("));
        assertFalse(in.hasHigherPrecedence("^", "^"));
        assertTrue(in.hasHigherPrecedence("^", "*"));
        assertTrue(in.hasHigherPrecedence("^", "/"));
        assertTrue(in.hasHigherPrecedence("^", "/"));
        assertTrue(in.hasHigherPrecedence("^", "-"));
    }
    
    @Test
    void testMultiplication() {
        assertTrue(in.hasHigherPrecedence("*", "("));
        assertFalse(in.hasHigherPrecedence("*", "^"));
        assertFalse(in.hasHigherPrecedence("*", "*"));
        assertFalse(in.hasHigherPrecedence("*", "/"));
        assertTrue(in.hasHigherPrecedence("*", "+"));
        assertTrue(in.hasHigherPrecedence("*", "-"));
    }
    
    @Test
    void testDivision() {
        assertTrue(in.hasHigherPrecedence("/", "("));
        assertFalse(in.hasHigherPrecedence("/", "^"));
        assertFalse(in.hasHigherPrecedence("/", "*"));
        assertFalse(in.hasHigherPrecedence("/", "/"));
        assertTrue(in.hasHigherPrecedence("/", "+"));
        assertTrue(in.hasHigherPrecedence("/", "-"));
    }
    
    @Test
    void testAddition() {
        assertTrue(in.hasHigherPrecedence("+", "("));
        assertFalse(in.hasHigherPrecedence("+", "^"));
        assertFalse(in.hasHigherPrecedence("+", "*"));
        assertFalse(in.hasHigherPrecedence("+", "/"));
        assertFalse(in.hasHigherPrecedence("+", "+"));
        assertFalse(in.hasHigherPrecedence("+", "-"));
    }
    
    @Test
    void testSubtraction() {
        assertTrue(in.hasHigherPrecedence("-", "("));
        assertFalse(in.hasHigherPrecedence("-", "^"));
        assertFalse(in.hasHigherPrecedence("-", "*"));
        assertFalse(in.hasHigherPrecedence("-", "/"));
        assertFalse(in.hasHigherPrecedence("-", "+"));
        assertFalse(in.hasHigherPrecedence("-", "-"));
    }
}