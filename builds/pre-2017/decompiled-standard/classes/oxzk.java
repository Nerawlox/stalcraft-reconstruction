/*
 * Decompiled with CFR 0.152.
 */
import net.minecraft.entity.player.EntityPlayer;

public class oxzk
extends iwgt {
    public oxzk(int n) {
        super(n, tflj._d);
        this.func_71849_a(tgbl.field_78028_d);
    }

    @Override
    public void func_71863_a(ozlu ozlu2, int n, int n2, int n3, int n4) {
        boolean bl = ozlu2.func_72864_z(n, n2, n3);
        tgvf tgvf2 = (tgvf)ozlu2.func_72796_p(n, n2, n3);
        if (tgvf2 != null && tgvf2._b != bl) {
            if (bl) {
                tgvf2._a(ozlu2, n, n2, n3);
            }
            tgvf2._b = bl;
        }
    }

    @Override
    public boolean func_71903_a(ozlu ozlu2, int n, int n2, int n3, EntityPlayer entityPlayer, int n4, float f, float f2, float f3) {
        if (ozlu2.field_72995_K) {
            return true;
        }
        tgvf tgvf2 = (tgvf)ozlu2.func_72796_p(n, n2, n3);
        if (tgvf2 != null) {
            tgvf2._a();
            tgvf2._a(ozlu2, n, n2, n3);
        }
        return true;
    }

    @Override
    public void func_71921_a(ozlu ozlu2, int n, int n2, int n3, EntityPlayer entityPlayer) {
        if (ozlu2.field_72995_K) {
            return;
        }
        tgvf tgvf2 = (tgvf)ozlu2.func_72796_p(n, n2, n3);
        if (tgvf2 != null) {
            tgvf2._a(ozlu2, n, n2, n3);
        }
    }

    @Override
    public hurg func_72274_a(ozlu ozlu2) {
        return new tgvf();
    }

    @Override
    public boolean func_71883_b(ozlu ozlu2, int n, int n2, int n3, int n4, int n5) {
        float f = (float)Math.pow(2.0, (double)(n5 - 12) / 12.0);
        String string = "harp";
        if (n4 == 1) {
            string = "bd";
        }
        if (n4 == 2) {
            string = "snare";
        }
        if (n4 == 3) {
            string = "hat";
        }
        if (n4 == 4) {
            string = "bassattack";
        }
        ozlu2.func_72908_a((double)n + 0.5, (double)n2 + 0.5, (double)n3 + 0.5, "note." + string, 3.0f, f);
        ozlu2.func_72869_a("note", (double)n + 0.5, (double)n2 + 1.2, (double)n3 + 0.5, (double)n5 / 24.0, 0.0, 0.0);
        return true;
    }
}

