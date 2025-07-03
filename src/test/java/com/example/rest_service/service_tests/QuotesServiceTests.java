package com.example.rest_service.service_tests;

import com.example.rest_service.models.Gradient;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
public class QuotesServiceTests {

    @Test
    void contextLoads() {
    }

    @Test
    void testGradientFields(){
        Gradient test_gradient = new Gradient(0,0,0);
        test_gradient.setR(256);
        test_gradient.setG(128);
        test_gradient.setB(64);

        assertEquals(256, test_gradient.getR());
        assertEquals(128, test_gradient.getG());
        assertEquals(64 , test_gradient.getB());
    }
}
