/*
 * Decompiled with CFR 0.152.
 */
package mcoptifine;

public class AnimatedTextures {
    private static int nextAnimationSlot = 0;

    public static int getNextAnimationSlot() {
        return nextAnimationSlot++;
    }

    public static void reset() {
        nextAnimationSlot = 0;
    }
}

