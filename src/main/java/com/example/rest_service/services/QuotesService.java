package com.example.rest_service.services;

import com.example.rest_service.models.Quote;

import java.util.*;

public class QuotesService {
    private List<Quote> _quotesList;

    public QuotesService(){
        _quotesList = new Vector<Quote>();
    }

    public void addQuote(Quote testQuote) {
        _quotesList.add(testQuote);
    }

    public Quote getQuoteById(long l) {
        Quote quote = _quotesList.stream()
                .filter(q -> q.getId() == l)
                .findFirst()
                .orElse(null);

        return quote;
    }

    public Quote getRandomQuote() {
        if (_quotesList.isEmpty()) return null;
        Random rand = new Random();

        int index = rand.nextInt(_quotesList.size());
        return _quotesList.get(index);
    }

    public Long nextUnusedId() {
        // had thought about whether I should just find the max
        // ID but wanted to be thorough and allow for gaps in the IDs

        List<Long> usedIds = new Vector<>();
        for (Quote q : _quotesList) {
            usedIds.add(q.getId());
        }

        Long nextId = 0L;
        while (usedIds.contains(nextId)) {
            nextId++;
        }
        return nextId;
    }

    public int getQuoteCount() {
        return _quotesList.size();
    }
}
