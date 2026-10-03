/*
 * Decompiled with CFR 0.152.
 */
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import gloomyfolken.mods.asm.GloomyHooks;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.dwan;

public class yeso {
    public final int field_75225_a;
    public final mssh field_75224_c;
    public int field_75222_d;
    public int field_75223_e;
    public int field_75221_f;
    public dwan backgroundIcon = null;
    @SideOnly(value=Side.CLIENT)
    public ResourceLocation texture;

    public yeso(mssh mssh2, int n, int n2, int n3) {
        this.field_75224_c = mssh2;
        this.field_75225_a = n;
        this.field_75223_e = n2;
        this.field_75221_f = n3;
    }

    public void func_75220_a(cvzo cvzo2, cvzo cvzo3) {
        int n;
        if (cvzo2 != null && cvzo3 != null && cvzo2._d == cvzo3._d && (n = cvzo3._b - cvzo2._b) > 0) {
            this.func_75210_a(cvzo2, n);
        }
    }

    public void func_75210_a(cvzo cvzo2, int n) {
    }

    public void func_75208_c(cvzo cvzo2) {
    }

    public void func_82870_a(EntityPlayer entityPlayer, cvzo cvzo2) {
        this.func_75218_e();
    }

    public boolean func_75214_a(cvzo cvzo2) {
        return true;
    }

    public cvzo func_75211_c() {
        return this.field_75224_c.func_70301_a(this.field_75225_a);
    }

    public boolean func_75216_d() {
        return this.func_75211_c() != null;
    }

    public void func_75215_d(cvzo cvzo2) {
        this.field_75224_c.func_70299_a(this.field_75225_a, cvzo2);
        this.func_75218_e();
    }

    public void func_75218_e() {
        GloomyHooks.onSlotChanged(this);
        this.field_75224_c.func_70296_d();
    }

    public int func_75219_a() {
        return this.field_75224_c.func_70297_j_();
    }

    public cvzo func_75209_a(int n) {
        return this.field_75224_c.func_70298_a(this.field_75225_a, n);
    }

    public boolean func_75217_a(mssh mssh2, int n) {
        return mssh2 == this.field_75224_c && n == this.field_75225_a;
    }

    public boolean func_82869_a(EntityPlayer entityPlayer) {
        return true;
    }

    @SideOnly(value=Side.CLIENT)
    public dwan func_75212_b() {
        return this.backgroundIcon;
    }

    @SideOnly(value=Side.CLIENT)
    public boolean func_111238_b() {
        return true;
    }

    @SideOnly(value=Side.CLIENT)
    public ResourceLocation getBackgroundIconTexture() {
        return this.texture == null ? sctd._e : this.texture;
    }

    public void setBackgroundIcon(dwan dwan2) {
        this.backgroundIcon = dwan2;
    }

    @SideOnly(value=Side.CLIENT)
    public void setBackgroundIconTexture(ResourceLocation resourceLocation) {
        this.texture = resourceLocation;
    }

    public int getSlotIndex() {
        return this.field_75225_a;
    }
}

