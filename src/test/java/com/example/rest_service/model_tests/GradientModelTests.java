package com.example.rest_service.model_tests;

import com.example.rest_service.models.Gradient;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class GradientModelTests {

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
    @Test
    void testGradientConstructor(){
        Gradient test_gradient = new Gradient(1,2,3);

        assertEquals(1, test_gradient.getR());
        assertEquals(2, test_gradient.getG());
        assertEquals(3, test_gradient.getB());
    }

    @Test
    void testGradientEquality(){
        Gradient test_gradient = new Gradient(1,2,3);
        Gradient test_gradient2 = new Gradient(1,2,3);

        assertEquals(test_gradient, test_gradient2);
    }

    @Test
    void testRandomGradient(){
        Gradient test_gradient = new Gradient(-1,100,-1);

        assertTrue(test_gradient.getR()>=0);
        assertEquals(100, test_gradient.getG());
        assertTrue(test_gradient.getB()>=0);
    }
}
