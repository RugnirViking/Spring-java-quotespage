package com.example.rest_service.models;

import java.util.Objects;
import java.util.Random;
import java.util.random.RandomGenerator;

public class Gradient {
    private int _r;
    public void setR(int value) { _r = value; }
    public int getR() { return _r; }

    private int _g;
    public void setG(int value) { _g = value; }
    public int getG() { return _g; }

    private int _b;
    public void setB(int value) { _b = value; }
    public int getB() { return _b; }

    ///
    /// Gradient class, takes an int between 0 and 255. A negative passed value will be randomized between 0 and 255
    ///
    public Gradient(int r, int g, int b) {
        // should probably have injected the random here instead so we can fix it for testing
        Random rand = new Random();
        r = r <0 ? rand.nextInt(0,255) : r;
        g = g <0 ? rand.nextInt(0,255) : g;
        b = b <0 ? rand.nextInt(0,255) : b;

        setR(r);
        setG(g);
        setB(b);
        // TODO: this is bad bad bad we need to do hsv randomization then fit it somehow so we can get good colors
        // as it stands it can make a gradient between black, and black. Which would be impossible to read anything
        // new idea: we make random hue, have two set saturations and hues to go between.
        // Tbh we should have had color (with hsv) as a model and the gradientService handle gradients but there we go
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Gradient)) return false;
        Gradient comparedGradient = (Gradient) o;
        // I ought to find if there's a better way to compare all the properties automatically rather than manually compare each one.
        return Objects.equals(_r, comparedGradient.getR())
                && Objects.equals(_g, comparedGradient.getG())
                && Objects.equals(_b, comparedGradient.getB());
    }

}
