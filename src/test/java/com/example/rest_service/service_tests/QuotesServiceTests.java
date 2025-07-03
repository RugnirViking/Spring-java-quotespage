package com.example.rest_service.service_tests;

import com.example.rest_service.models.Author;
import com.example.rest_service.models.Quote;
import com.example.rest_service.services.GreetingService;
import com.example.rest_service.services.QuotesService;
import org.junit.jupiter.api.Test;

import java.time.*;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;

public class QuotesServiceTests {


    @Test
    void contextLoads() {
    }

    @Test
    void addQuoteTest() {
        Author test_author = new Author(11,"Test McTestperson");
        Quote test_quote = new Quote(32L,
                test_author,
                "Testing leads to failure, and failure leads to understanding.");

        QuotesService test_quotesService = new QuotesService();
        test_quotesService.addQuote(test_quote);

        assertEquals(test_quote, test_quotesService.getQuoteById(32L));
        assertEquals(1, test_quotesService.getQuoteCount());
    }

    @Test
    void emptyQuoteServiceSuggestsZeroId() {

        QuotesService test_quotesService = new QuotesService();
        assertEquals(0, test_quotesService.nextUnusedId());

    }

    @Test
    void singleQuoteServiceSuggestsOneId() {
        Author test_author = new Author(11,"Test McTestperson");
        Quote test_quote = new Quote(0L,
                test_author,
                "Testing leads to failure, and failure leads to understanding.");
        QuotesService test_quotesService = new QuotesService();
        test_quotesService.addQuote(test_quote); // there is a single quote with ID 0, next will be 1

        assertEquals(1L, test_quotesService.nextUnusedId());
    }


    @Test
    void quoteServiceGetQuoteByIdReturnsNullInvalidId() {
        QuotesService test_quotesService = new QuotesService();

        assertNull(test_quotesService.getQuoteById(1L));
    }

    @Test
    void randomQuoteGives() {
        Author test_author = new Author(11,"Test McTestperson");
        Quote test_quote = new Quote(32L,
                test_author,
                "Testing leads to failure, and failure leads to understanding.");
        QuotesService test_quotesService = new QuotesService();
        test_quotesService.addQuote(test_quote);

        assertEquals(test_quote, test_quotesService.getRandomQuote());
    }
}
