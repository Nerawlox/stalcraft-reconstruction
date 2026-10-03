/*
 * Decompiled with CFR 0.152.
 */
import gloomyfolken.mods.faction.pidb;
import gloomyfolken.mods.stalker.misc.tupg;
import java.util.List;
import net.minecraft.client.xpzm;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.ezfc;
import org.lwjgl.opengl.GL11;

public class nuis
extends cebg {
    public jzak _a;
    public static final int _b = 227;
    public static final int _c = 181;
    public static final ResourceLocation _d = new ResourceLocation("stalker", "textures/gui/inventory.png");
    protected EntityPlayer _e;

    public nuis(EntityPlayer entityPlayer) {
        super(entityPlayer);
        this._e = entityPlayer;
        this._a = (jzak)entityPlayer.field_71069_bz;
    }

    public yeso _a(int n, int n2) {
        for (int i = 0; i < this._a.field_75151_b.size(); ++i) {
            yeso yeso2 = (yeso)this._a.field_75151_b.get(i);
            if (!this.func_74186_a(yeso2, n, n2) || !yeso2.func_111238_b()) continue;
            return yeso2;
        }
        return null;
    }

    @Override
    protected boolean func_74186_a(yeso yeso2, int n, int n2) {
        return this.func_74188_c(yeso2.field_75223_e, yeso2.field_75221_f, 16, 16, n, n2);
    }

    public void _a(cvzo cvzo2, int n, int n2) {
        List list2 = cvzo2._a((EntityPlayer)this.field_73882_e._t, this.field_73882_e._M.field_82882_x);
        for (int i = 0; i < list2.size(); ++i) {
            if (i == 0) {
                list2.set(i, "\u00a7" + Integer.toHexString(cvzo2._w()._e) + (String)list2.get(i));
                continue;
            }
            list2.set(i, (Object)((Object)ezfc._h) + (String)list2.get(i));
        }
        qncw qncw2 = cvzo2._a().getFontRenderer(cvzo2);
        this.drawHoveringText(list2, n, n2, qncw2 == null ? this.field_73886_k : qncw2);
    }

    @Override
    public void func_73866_w_() {
        this.field_73887_h.clear();
        this.field_74194_b = 227;
        this.field_74195_c = 181;
        this.field_74198_m = this.field_73880_f / 2 - this.field_74194_b / 2;
        this.field_74197_n = this.field_73881_g / 2 - this.field_74195_c / 2;
    }

    @Override
    protected void func_74185_a(float f, int n, int n2) {
        int n3;
        GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
        GL11.glDisable(2896);
        xpzm._E()._h._a(_d);
        this.func_73729_b(this.field_73880_f / 2 - 113, this.field_73881_g / 2 - 90, 0, 0, 227, 181);
        for (int i = n3 = this._a.getArtefaktSlots(); i < 5; ++i) {
            this.func_73729_b(this.field_73880_f / 2 - 113 + 7 + i * 18, this.field_73881_g / 2 - 90 + 107, 228, 154, 18, 18);
        }
    }

    @Override
    public void func_73876_c() {
        super.func_73876_c();
    }

    @Override
    protected void func_74189_g(int n, int n2) {
        GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
        GL11.glDisable(2896);
        tupg tupg2 = tupg._a(this._e);
        String string = pidb._a((EntityPlayer)this._e)._a()._e;
        this.func_73731_b(this.field_73882_e._z, "\u0412\u0435\u0441: " + (int)tupg2._i() + "/" + (int)tupg2._j() + " \u043a\u0433", 126, 159, 0xFFFFFF);
        this.func_73732_a(this.field_73882_e._z, string + " " + this.field_73882_e._t.getDisplayName(), 113, -28, 0xFFFFFF);
    }
}

