/*
 * Decompiled with CFR 0.152.
 */
package gloomyfolken.mods.core.client.gui.screens;

import gloomyfolken.bundle.common.core.eidj;
import gloomyfolken.bundle.common.core.ezey;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.tdpx;
import org.lwjgl.opengl.GL11;

@ezey(_a={eidj.CLIENT})
public class GuiOtherInventory
extends lpaq {
    private float xSize_lo;
    private float ySize_lo;
    private EntityLivingBase entity;

    public GuiOtherInventory(zwyn zwyn2) {
        super(zwyn2);
        this.entity = zwyn2.owner;
        this.field_73885_j = true;
    }

    @Override
    public void func_73866_w_() {
        this.field_73887_h.clear();
        super.func_73866_w_();
    }

    @Override
    protected void func_74189_g(int n, int n2) {
        this.field_73886_k._b(tdpx._a("container.crafting"), 86, 16, 0x404040);
    }

    @Override
    public void func_73863_a(int n, int n2, float f) {
        super.func_73863_a(n, n2, f);
        this.xSize_lo = n;
        this.ySize_lo = n2;
    }

    @Override
    protected void func_74185_a(float f, int n, int n2) {
        GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
        this.field_73882_e._R()._a(zybc.field_110408_a);
        int n3 = this.field_74198_m;
        int n4 = this.field_74197_n;
        this.func_73729_b(n3, n4, 0, 0, this.field_74194_b, this.field_74195_c);
        cebg._a(n3 + 51, n4 + 75, 30, (float)(n3 + 51) - this.xSize_lo, (float)(n4 + 75 - 50) - this.ySize_lo, this.entity);
    }
}

