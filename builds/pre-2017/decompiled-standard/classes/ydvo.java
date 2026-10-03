/*
 * Decompiled with CFR 0.152.
 */
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.dwan;

public class ydvo
extends twgu {
    public dwan _a;
    public dwan _b;

    public ydvo(int n) {
        super(n, tflj._d);
        this.func_71849_a(tgbl.field_78031_c);
    }

    @Override
    public dwan func_71858_a(int n, int n2) {
        if (n == 1) {
            return this._a;
        }
        if (n == 0) {
            return twgu.field_71988_x.func_71851_a(n);
        }
        if (n == 2 || n == 4) {
            return this._b;
        }
        return this.field_94336_cN;
    }

    @Override
    public void func_94332_a(nege nege2) {
        this.field_94336_cN = nege2._b(this.func_111023_E() + "_side");
        this._a = nege2._b(this.func_111023_E() + "_top");
        this._b = nege2._b(this.func_111023_E() + "_front");
    }

    @Override
    public boolean func_71903_a(ozlu ozlu2, int n, int n2, int n3, EntityPlayer entityPlayer, int n4, float f, float f2, float f3) {
        if (ozlu2.field_72995_K) {
            return true;
        }
        entityPlayer.func_71058_b(n, n2, n3);
        return true;
    }
}

