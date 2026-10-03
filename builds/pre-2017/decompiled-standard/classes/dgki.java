/*
 * Decompiled with CFR 0.152.
 */
import java.util.ArrayList;
import java.util.List;
import net.minecraft.client.xpzm;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.ezfc;
import org.lwjgl.opengl.GL11;

public class dgki
extends gqjz {
    private List<cvzo> _a = new ArrayList<cvzo>();
    private int _b;
    private static xsbj _c = new xsbj();
    private static final ResourceLocation _d = new ResourceLocation("stalker", "textures/gui/repair.png");
    private nujd _e;

    public dgki(nujd nujd2) {
        this._e = nujd2;
    }

    @Override
    public void func_73866_w_() {
        for (int i = 0; i < 6; ++i) {
            jiok jiok2 = new jiok(i, this.field_73880_f / 2 - 40, this.field_73881_g / 2 - 83 + i * 24, 106, 20, "");
            jiok2.field_73748_h = true;
            this.field_73887_h.add(jiok2);
        }
        this.field_73887_h.add(new jiok(-1, this.field_73880_f / 2 - 40, this.field_73881_g / 2 + 95, 80, 20, "\u041e\u0442\u043c\u0435\u043d\u0430"));
        this.field_73887_h.add(new jiok(7, this.field_73880_f / 2 - 22, this.field_73881_g / 2 + 61, 20, 20, "<-"));
        this.field_73887_h.add(new jiok(8, this.field_73880_f / 2 + 2, this.field_73881_g / 2 + 61, 20, 20, "->"));
        this.func_73876_c();
    }

    @Override
    public void func_73863_a(int n, int n2, float f) {
        int n3;
        this.func_73873_v_();
        this.func_73732_a(this.field_73886_k, "\u0412\u044b\u0431\u0435\u0440\u0438\u0442\u0435 \u043f\u0440\u0435\u0434\u043c\u0435\u0442 \u0434\u043b\u044f \u043f\u043e\u0447\u0438\u043d\u043a\u0438", this.field_73880_f / 2, this.field_73881_g / 2 - 105, 0xFFFFFF);
        xpzm._E()._h._a(_d);
        this.func_73729_b(this.field_73880_f / 2 - 80, this.field_73881_g / 2 - 90, 0, 0, 160, 180);
        for (int i = 0; i < this.field_73887_h.size(); ++i) {
            jiok jiok2 = (jiok)this.field_73887_h.get(i);
            jiok2.func_73737_a(this.field_73882_e, n, n2);
        }
        cvzo cvzo2 = null;
        for (int i = 0; i < 6 && (n3 = this._b * 6 + i) < this._a.size(); ++i) {
            cvzo cvzo3 = this._a.get(n3);
            int n4 = this.field_73880_f / 2 - 67;
            int n5 = this.field_73881_g / 2 - 82 + i * 24;
            this._b(cvzo3, n4, n5);
            if (n <= n4 || n2 <= n5 || n >= n4 + 18 || n2 >= n5 + 18) continue;
            GL11.glDisable(2896);
            GL11.glDisable(2929);
            this.func_73733_a(n4, n5, n4 + 17, n5 + 16, -2130706433, -2130706433);
            GL11.glEnable(2896);
            GL11.glEnable(2929);
            cvzo2 = cvzo3;
        }
        if (cvzo2 != null) {
            this._a(cvzo2, n, n2);
        }
    }

    protected void _a(cvzo cvzo2, int n, int n2) {
        List list2 = cvzo2._a((EntityPlayer)this.field_73882_e._t, this.field_73882_e._M.field_82882_x);
        for (int i = 0; i < list2.size(); ++i) {
            if (i == 0) {
                list2.set(i, "\u00a7" + Integer.toHexString(cvzo2._w()._e) + (String)list2.get(i));
                continue;
            }
            list2.set(i, (Object)((Object)ezfc._h) + (String)list2.get(i));
        }
        qncw qncw2 = cvzo2._a().getFontRenderer(cvzo2);
        this._a(list2, n, n2, qncw2 == null ? this.field_73886_k : qncw2);
    }

    protected void _a(List list2, int n, int n2, qncw qncw2) {
        if (!list2.isEmpty()) {
            int n3;
            GL11.glDisable(32826);
            qnon._a();
            GL11.glDisable(2896);
            GL11.glDisable(2929);
            int n4 = 0;
            for (String string : list2) {
                n3 = qncw2._b(string);
                if (n3 <= n4) continue;
                n4 = n3;
            }
            int n5 = n + 12;
            n3 = n2 - 12;
            int n6 = 8;
            if (list2.size() > 1) {
                n6 += 2 + (list2.size() - 1) * 10;
            }
            if (n5 + n4 > this.field_73880_f) {
                n5 -= 28 + n4;
            }
            if (n3 + n6 + 6 > this.field_73881_g) {
                n3 = this.field_73881_g - n6 - 6;
            }
            this.field_73735_i = 300.0f;
            dgki._c.field_77023_b = 300.0f;
            int n7 = -267386864;
            this.func_73733_a(n5 - 3, n3 - 4, n5 + n4 + 3, n3 - 3, n7, n7);
            this.func_73733_a(n5 - 3, n3 + n6 + 3, n5 + n4 + 3, n3 + n6 + 4, n7, n7);
            this.func_73733_a(n5 - 3, n3 - 3, n5 + n4 + 3, n3 + n6 + 3, n7, n7);
            this.func_73733_a(n5 - 4, n3 - 3, n5 - 3, n3 + n6 + 3, n7, n7);
            this.func_73733_a(n5 + n4 + 3, n3 - 3, n5 + n4 + 4, n3 + n6 + 3, n7, n7);
            int n8 = 0x505000FF;
            int n9 = (n8 & 0xFEFEFE) >> 1 | n8 & 0xFF000000;
            this.func_73733_a(n5 - 3, n3 - 3 + 1, n5 - 3 + 1, n3 + n6 + 3 - 1, n8, n9);
            this.func_73733_a(n5 + n4 + 2, n3 - 3 + 1, n5 + n4 + 3, n3 + n6 + 3 - 1, n8, n9);
            this.func_73733_a(n5 - 3, n3 - 3, n5 + n4 + 3, n3 - 3 + 1, n8, n8);
            this.func_73733_a(n5 - 3, n3 + n6 + 2, n5 + n4 + 3, n3 + n6 + 3, n9, n9);
            for (int i = 0; i < list2.size(); ++i) {
                String string = (String)list2.get(i);
                qncw2._a(string, n5, n3, -1);
                if (i == 0) {
                    n3 += 2;
                }
                n3 += 10;
            }
            this.field_73735_i = 0.0f;
            dgki._c.field_77023_b = 0.0f;
            GL11.glEnable(2896);
            GL11.glEnable(2929);
            qnon._b();
            GL11.glEnable(32826);
        }
    }

    @Override
    public void func_73876_c() {
        this._a.clear();
        if (this.field_73882_e._t == null) {
            return;
        }
        for (cvzo cvzo2 : this.field_73882_e._t.field_71069_bz.func_75138_a()) {
            if (cvzo2 == null || !cvzo2._h() || !this._e._b(cvzo2)) continue;
            this._a.add(cvzo2);
        }
        int n = Math.max((this._a.size() - 1) / 6, 0);
        this._b = Math.min(this._b, n);
        for (int i = 0; i < 6; ++i) {
            jiok jiok2 = (jiok)this.field_73887_h.get(i);
            int n2 = this._b * 6 + i;
            if (n2 < this._a.size()) {
                jiok2.field_73744_e = this._a.get(n2)._s();
                jiok2.field_73748_h = true;
                continue;
            }
            jiok2.field_73748_h = false;
        }
        ((jiok)this.field_73887_h.get((int)7)).field_73742_g = this._b > 0;
        ((jiok)this.field_73887_h.get((int)8)).field_73742_g = this._b < n;
    }

    @Override
    public void func_73875_a(jiok jiok2) {
        switch (jiok2.field_73741_f) {
            case -1: {
                this.field_73882_e._a((gqjz)null);
                break;
            }
            case 7: {
                --this._b;
                break;
            }
            case 8: {
                ++this._b;
                break;
            }
            default: {
                int n = this._b * 6 + jiok2.field_73741_f;
                if (n < this._a.size()) {
                    cvzo cvzo2 = this._a.get(n);
                    for (int i = 0; i < this.field_73882_e._t.field_71069_bz.func_75138_a().size(); ++i) {
                        if (cvzo2 != this.field_73882_e._t.field_71069_bz.func_75138_a().get(i)) continue;
                        new rpxd(i).sendToServer();
                        break;
                    }
                }
                this.field_73882_e._a((gqjz)null);
            }
        }
    }

    protected void _b(cvzo cvzo2, int n, int n2) {
        this.field_73735_i = 100.0f;
        dgki._c.field_77023_b = 100.0f;
        GL11.glEnable(2929);
        _c.func_82406_b(this.field_73886_k, this.field_73882_e._R(), cvzo2, n, n2);
        _c.func_94148_a(this.field_73886_k, this.field_73882_e._R(), cvzo2, n, n2, null);
        dgki._c.field_77023_b = 0.0f;
        this.field_73735_i = 0.0f;
    }
}

