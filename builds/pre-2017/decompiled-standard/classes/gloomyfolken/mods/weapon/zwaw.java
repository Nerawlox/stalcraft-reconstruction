/*
 * Decompiled with CFR 0.152.
 */
package gloomyfolken.mods.weapon;

public class zwaw
extends RuntimeException {
    protected wolf _a;
    protected wolf _b;

    public zwaw(wolf wolf2, cvzo cvzo2) {
        super("Gun excepted = " + wolf2 + ", stack received = " + cvzo2 + "!");
    }
}

