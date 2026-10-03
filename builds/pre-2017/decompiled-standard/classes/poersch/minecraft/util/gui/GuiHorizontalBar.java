/*
 * Decompiled with CFR 0.152.
 */
package poersch.minecraft.util.gui;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.xpzm;
import org.lwjgl.opengl.GL11;
import poersch.minecraft.util.gui.GuiButton;

@SideOnly(value=Side.CLIENT)
public class GuiHorizontalBar
extends GuiButton {
    public GuiHorizontalBar(int n, int n2, int n3, int n4, int n5) {
        super(n, n2, n3, n4, n5, "");
    }

    @Override
    protected void func_73733_a(int n, int n2, int n3, int n4, int n5, int n6) {
        float f = (float)(n5 >> 24 & 0xFF) / 255.0f;
        float f2 = (float)(n5 >> 16 & 0xFF) / 255.0f;
        float f3 = (float)(n5 >> 8 & 0xFF) / 255.0f;
        float f4 = (float)(n5 & 0xFF) / 255.0f;
        float f5 = (float)(n6 >> 24 & 0xFF) / 255.0f;
        float f6 = (float)(n6 >> 16 & 0xFF) / 255.0f;
        float f7 = (float)(n6 >> 8 & 0xFF) / 255.0f;
        float f8 = (float)(n6 & 0xFF) / 255.0f;
        GL11.glDisable(3553);
        GL11.glEnable(3042);
        GL11.glDisable(3008);
        GL11.glBlendFunc(770, 771);
        GL11.glShadeModel(7425);
        htvf htvf2 = htvf.field_78398_a;
        htvf2.func_78382_b();
        htvf2.func_78369_a(f2, f3, f4, f);
        htvf2.func_78377_a(n, n2, this.field_73735_i);
        htvf2.func_78377_a(n, n4, this.field_73735_i);
        htvf2.func_78369_a(f6, f7, f8, f5);
        htvf2.func_78377_a(n3, n4, this.field_73735_i);
        htvf2.func_78377_a(n3, n2, this.field_73735_i);
        htvf2.func_78381_a();
        GL11.glShadeModel(7424);
        GL11.glDisable(3042);
        GL11.glEnable(3008);
        GL11.glEnable(3553);
    }

    @Override
    public void func_73737_a(xpzm xpzm2, int n, int n2) {
        if (this.field_73748_h) {
            this.func_73733_a(this.field_73746_c, this.field_73743_d, this.field_73746_c + this.field_73747_a / 2, this.field_73743_d + this.field_73745_b, 0x666666, -10066330);
            this.func_73733_a(this.field_73746_c + this.field_73747_a / 2, this.field_73743_d, this.field_73746_c + this.field_73747_a, this.field_73743_d + this.field_73745_b, -10066330, 0x666666);
        }
    }
}

