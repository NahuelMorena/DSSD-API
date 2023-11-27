package com.example.dssdapi.Utils;

import java.util.Random;

public class RandomDecisionUtils {
    public static boolean makeRandomDecision(){
        Random random = new Random();
        double randomValue = random.nextDouble();
        return randomValue < 0.5;
    }
}
