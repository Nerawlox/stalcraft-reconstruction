/*
 * Decompiled with CFR 0.152.
 */
import java.util.ArrayList;
import java.util.List;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.eidj;

public class dyct
extends jjgc {
    public List _a = new ArrayList();

    public dyct(EntityPlayer entityPlayer) {
        int n;
        eidj eidj2 = entityPlayer.field_71071_by;
        for (n = 0; n < 5; ++n) {
            for (int i = 0; i < 9; ++i) {
                this.func_75146_a(new yeso(qngy._d(), n * 9 + i, 9 + i * 18, 18 + n * 18));
            }
        }
        for (n = 0; n < 9; ++n) {
            this.func_75146_a(new yeso(eidj2, n, 9 + n * 18, 112));
        }
        this._a(0.0f);
    }

    @Override
    public boolean func_75145_c(EntityPlayer entityPlayer) {
        return true;
    }

    public void _a(float f) {
        int n = this._a.size() / 9 - 5 + 1;
        int n2 = (int)((double)(f * (float)n) + 0.5);
        if (n2 < 0) {
            n2 = 0;
        }
        for (int i = 0; i < 5; ++i) {
            for (int j = 0; j < 9; ++j) {
                int n3 = j + (i + n2) * 9;
                if (n3 >= 0 && n3 < this._a.size()) {
                    qngy._d().func_70299_a(j + i * 9, (cvzo)this._a.get(n3));
                    continue;
                }
                qngy._d().func_70299_a(j + i * 9, null);
            }
        }
    }

    public boolean _a() {
        return this._a.size() > 45;
    }

    @Override
    public void func_75133_b(int n, int n2, boolean bl, EntityPlayer entityPlayer) {
    }

    @Override
    public cvzo func_82846_b(EntityPlayer entityPlayer, int n) {
        yeso yeso2;
        if (n >= this.field_75151_b.size() - 9 && n < this.field_75151_b.size() && (yeso2 = (yeso)this.field_75151_b.get(n)) != null && yeso2.func_75216_d()) {
            yeso2.func_75215_d(null);
        }
        return null;
    }

    @Override
    public boolean func_94530_a(cvzo cvzo2, yeso yeso2) {
        return yeso2.field_75221_f > 90;
    }

    @Override
    public boolean func_94531_b(yeso yeso2) {
        return yeso2.field_75224_c instanceof eidj || yeso2.field_75221_f > 90 && yeso2.field_75223_e <= 162;
    }
}

