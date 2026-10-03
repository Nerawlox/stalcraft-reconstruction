/*
 * Decompiled with CFR 0.152.
 */
import carpentersblocks.tileentity.TECarpentersBlock;
import gloomyfolken.mods.asm.Logger;

public class dfsc {
    private boolean _a;

    public dfsc() {
        try {
            Class.forName("carpentersblocks.CarpentersBlocks");
            Logger.finest("CarpenterBlocks found!", new Object[0]);
            this._a = true;
        }
        catch (Exception exception) {
            Logger.finest("CarpenterBlocks not found!", new Object[0]);
        }
    }

    public short _a(sdrg sdrg2, int n, int n2, int n3) {
        if (this._a) {
            return this._b(sdrg2, n, n2, n3);
        }
        return 0;
    }

    private short _b(sdrg sdrg2, int n, int n2, int n3) {
        hurg hurg2 = sdrg2.func_72796_p(n, n2, n3);
        if (hurg2 instanceof TECarpentersBlock) {
            return ((TECarpentersBlock)hurg2).cover[6];
        }
        return 0;
    }

    public int _a(short s) {
        return s & 0xFFF;
    }

    public int _b(short s) {
        return (s & 0xF000) >>> 12;
    }
}

