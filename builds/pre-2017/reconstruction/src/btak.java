/*
 * Decompiled with CFR 0.152.
 */
import net.minecraft.potion.Potion;

public class btak
extends Potion {
    public btak(int n, boolean bl, int n2) {
        super(n, bl, n2);
    }

    @Override
    public boolean _b() {
        return true;
    }

    @Override
    public boolean _b(int n, int n2) {
        return n >= 1;
    }
}

