package com.example.rest_service.services;

import com.example.rest_service.models.Quote;

import java.util.List;
import java.util.Random;
import java.util.Vector;

public class GradientService {
    public final int SATURATION = 175;
    public final int VALUE = 175;

    public static int[] hsvToRgb(int h, int s, int v) {
        float hue   = (h & 0xFF) * 360f / 255f;
        float sat   = (s & 0xFF) / 255f;
        float value = (v & 0xFF) / 255f;

        if (sat == 0f) {
            int gray = Math.round(value * 255f);
            return new int[] { gray, gray, gray };
        }

        float hf   = hue / 60f;                // sector
        int   i    = (int) Math.floor(hf);     // integer part
        float f    = hf - i;                   // fractional part

        float p = value * (1f - sat);
        float q = value * (1f - sat * f);
        float t = value * (1f - sat * (1f - f));

        float rf, gf, bf;
        switch (i) {
            case 0:  rf = value; gf = t;     bf = p;     break;
            case 1:  rf = q;     gf = value; bf = p;     break;
            case 2:  rf = p;     gf = value; bf = t;     break;
            case 3:  rf = p;     gf = q;     bf = value; break;
            case 4:  rf = t;     gf = p;     bf = value; break;
            default: rf = value; gf = p;     bf = q;     break;
        }

        return new int[] {
                Math.round(rf * 255f),
                Math.round(gf * 255f),
                Math.round(bf * 255f)
        };
    }

    public String[] getRandomGradient() {
        Random rand = new Random();

        int hue = rand.nextInt(0,255);
        int hue2 = (hue+25) % 255; // if its over 255 we loop back to 0

        int saturation = SATURATION;
        int saturation2 = SATURATION + 25; // we could do the same modulo but given they're const we don't have to

        int value = VALUE;
        int value2 = VALUE + 25;

        int[] rgb = hsvToRgb(hue, saturation, value);
        int[] rgb2 = hsvToRgb(hue2, saturation2, value2);

        String hex1 = String.format("#%02X%02X%02X", rgb[0], rgb[1], rgb[2]);
        String hex2 = String.format("#%02X%02X%02X", rgb2[0], rgb2[1], rgb2[2]);

        return new String[] { hex1, hex2 };
    }
}
