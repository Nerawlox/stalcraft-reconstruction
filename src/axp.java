/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  bkb
 *  cpw.mods.fml.relauncher.Side
 *  cpw.mods.fml.relauncher.SideOnly
 *  ni
 *  org.lwjgl.opengl.GL11
 */
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.Collection;
import org.lwjgl.opengl.GL11;

@SideOnly(value=Side.CLIENT)
public abstract class axp
extends awy {
    private boolean t;

    public axp(uy par1Container) {
        super(par1Container);
    }

    @Override
    public void A_() {
        super.A_();
        if (!this.f.h.aL().isEmpty()) {
            this.p = 160 + (this.g - this.c - 200) / 2;
            this.t = true;
        }
    }

    @Override
    public void a(int par1, int par2, float par3) {
        super.a(par1, par2, par3);
        if (this.t) {
            this.g();
        }
    }

    private void g() {
        int i = this.p - 124;
        int j2 = this.q;
        boolean flag = true;
        Collection collection = this.f.h.aL();
        if (!collection.isEmpty()) {
            GL11.glColor4f((float)1.0f, (float)1.0f, (float)1.0f, (float)1.0f);
            GL11.glDisable((int)2896);
            int k = 33;
            if (collection.size() > 5) {
                k = 132 / (collection.size() - 1);
            }
            for (nj potioneffect : this.f.h.aL()) {
                ni potion = ni.a[potioneffect.a()];
                GL11.glColor4f((float)1.0f, (float)1.0f, (float)1.0f, (float)1.0f);
                this.f.J().a(a);
                this.b(i, j2, 0, 166, 140, 32);
                if (potion.d()) {
                    int l = potion.e();
                    this.b(i + 6, j2 + 7, 0 + l % 8 * 18, 198 + l / 8 * 18, 18, 18);
                }
                String s2 = bkb.a((String)potion.a());
                if (potioneffect.c() == 1) {
                    s2 = s2 + " II";
                } else if (potioneffect.c() == 2) {
                    s2 = s2 + " III";
                } else if (potioneffect.c() == 3) {
                    s2 = s2 + " IV";
                }
                this.o.a(s2, i + 10 + 18, j2 + 6, 0xFFFFFF);
                String s1 = ni.a((nj)potioneffect);
                this.o.a(s1, i + 10 + 18, j2 + 6 + 10, 0x7F7F7F);
                j2 += k;
            }
        }
    }
}

