package com.example.rest_service.controllers;

import com.example.rest_service.models.Author;
import com.example.rest_service.models.Quote;
import com.example.rest_service.services.GradientService;
import com.example.rest_service.services.GreetingService;
import com.example.rest_service.services.QuotesService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.Clock;
import java.time.ZoneId;

@Controller
public class WebController {

    private final QuotesService quotesService;
    private final GreetingService greetingService;
    private final GradientService gradientService;
    private static final ZoneId CPH = ZoneId.of("Europe/Copenhagen");

    public WebController() {
        greetingService = new GreetingService(Clock.system(CPH),CPH);
        quotesService   = new QuotesService();
        gradientService = new GradientService();

        quotesService.addQuote(
                new Quote(quotesService.nextUnusedId(),
                         new Author(0L,"Edgar Allan Poe"),
                         "I was never really insane except upon occasions when my heart was touched."
                )
        );

        quotesService.addQuote(
                new Quote(quotesService.nextUnusedId(),
                        new Author(1L,"Vincent Van Gogh"),
                        "It is good to love many things, for therein lies the true strength, and whosoever loves much performs much, and can accomplish much, and what is done in love is well done."
                )
        );

        quotesService.addQuote(
                new Quote(quotesService.nextUnusedId(),
                        new Author(2L,"George S. Patton"),
                        "If everybody is thinking alike, then somebody isn't thinking."
                )
        );

        quotesService.addQuote(
                new Quote(quotesService.nextUnusedId(),
                        new Author(3L,"Fyodor Dostoevsky"),
                        "I say let the world go to hell, but I should always have my tea."
                )
        );

        quotesService.addQuote(
                new Quote(quotesService.nextUnusedId(),
                        new Author(4L,"Franklin D. Roosevelt"),
                        "The only limit to our realization of tomorrow is our doubts of today."
                )
        );
    }

    @GetMapping("/web-greeting")
    public String greetingPage(Model model) {
        Quote quote = quotesService.getRandomQuote();
        String[] gradients = gradientService.getRandomGradient();
        model.addAttribute("gradientStart", gradients[0]);
        model.addAttribute("gradientEnd", gradients[1]);
        model.addAttribute("quote", quote.getQuoteText());
        model.addAttribute("author", quote.getAuthor().getName());
        model.addAttribute("greeting", greetingService.getGreeting());
        model.addAttribute("symbol", greetingService.getSymbol()); // or "moon"
        model.addAttribute("bobaRecommendation", "Classic Milk Tea"); // optional
        return "greeting"; // corresponds to greeting.html
    }
}
