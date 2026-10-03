/*
 * Decompiled with CFR 0.152.
 */
package ru.stalcraft;

import java.util.Random;

public class AnomalyDrop {
    private int[] drops;
    private float[] weights;
    private int weightsSum = 0;

    public AnomalyDrop(String config) {
        if (config.isEmpty()) {
            this.drops = new int[0];
            this.weights = new float[0];
        } else {
            String[] splitted = config.split(",");
            this.drops = new int[splitted.length];
            this.weights = new float[splitted.length];
            int number = 0;
            String[] arr$ = splitted;
            int len$ = splitted.length;
            for (int i$ = 0; i$ < len$; ++i$) {
                String[] splitted2 = arr$[i$].split("-");
                this.drops[number] = Integer.parseInt(splitted2[0]);
                this.weights[number] = Float.parseFloat(splitted2[1]);
                this.weightsSum = (int)((float)this.weightsSum + this.weights[number]);
                ++number;
            }
        }
    }

    public int getDrop(Random random) {
        float calculatedWeight;
        if (this.weightsSum <= 0) {
            return 0;
        }
        float rand = random.nextFloat() * (float)this.weightsSum;
        int dropElement = 0;
        for (calculatedWeight = 0.0f; dropElement < this.drops.length && calculatedWeight < rand; calculatedWeight += this.weights[dropElement], ++dropElement) {
        }
        return dropElement == this.drops.length && calculatedWeight < rand ? 0 : this.drops[dropElement - 1];
    }
}

