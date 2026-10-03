/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.src;

@Deprecated
public class TradeEntry {
    @Deprecated
    public final int id;
    @Deprecated
    public float chance;
    @Deprecated
    public boolean buying;
    @Deprecated
    public int min = 0;
    @Deprecated
    public int max = 0;

    @Deprecated
    public TradeEntry(int n, float f, boolean bl, int n2, int n3) {
        this.id = n;
        this.chance = f;
        this.buying = bl;
        this.min = n2;
        this.max = n3;
    }

    @Deprecated
    public TradeEntry(int n, float f, boolean bl) {
        this(n, f, bl, 0, 0);
    }
}

