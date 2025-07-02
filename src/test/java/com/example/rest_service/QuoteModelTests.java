package com.example.rest_service;

import com.example.rest_service.models.Author;
import com.example.rest_service.models.Quote;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class QuoteModelTests {

    @Test
    void contextLoads() {
    }

    @Test
    void testQuoteFields(){
        Quote test_quote = new Quote();
        test_quote.setId(32L);
        Author test_author = new Author(32L, "Test McTestperson");
        test_quote.setAuthor(test_author);
        test_quote.setQuoteText("Testing leads to failure, and failure leads to understanding.");

        assertEquals(32, test_quote.getId());
        assertEquals(test_author, test_quote.getAuthor());
        assertEquals("Testing leads to failure, and failure leads to understanding.", test_quote.getQuoteText());
    }
    @Test
    void testQuoteConstructor(){
        Author test_author = new Author(32L, "Test McTestperson");
        Quote test_quote = new Quote(32L, test_author, "Testing leads to failure, and failure leads to understanding.");

        assertEquals(32, test_quote.getId());
        assertEquals(test_author, test_quote.getAuthor());
        assertEquals("Testing leads to failure, and failure leads to understanding.", test_quote.getQuoteText());
    }

    @Test
    void testQuoteEquality(){
        Author test_author = new Author(32L, "Test McTestperson");
        Quote test_quote = new Quote(32L, test_author, "Testing leads to failure, and failure leads to understanding.");
        Quote test_quote2 = new Quote(32L, test_author, "Testing leads to failure, and failure leads to understanding.");

        assertEquals(test_quote, test_quote2);
    }
}
