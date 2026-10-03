/*
 * Decompiled with CFR 0.152.
 */
package codechicken.nei;

import codechicken.nei.ContainerEnchantmentModifier;
import codechicken.nei.GuiNEIButton;
import codechicken.nei.NEIClientConfig;
import codechicken.nei.NEIClientUtils;
import net.minecraft.entity.player.eidj;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

public class GuiEnchantmentModifier
extends zybc {
    ContainerEnchantmentModifier container;

    public GuiEnchantmentModifier(eidj eidj2, ozlu ozlu2, int n, int n2, int n3) {
        super(new ContainerEnchantmentModifier(eidj2, ozlu2, n, n2, n3));
        this.container = (ContainerEnchantmentModifier)this.field_74193_d;
        this.container.parentscreen = this;
    }

    @Override
    protected void func_74189_g(int n, int n2) {
        this.field_73886_k._b(NEIClientUtils.translate("enchant", new Object[0]), 12, 6, 0x404040);
        this.field_73886_k._b(NEIClientUtils.translate("enchant.level", new Object[0]), 19, 20, 0x404040);
    }

    @Override
    protected void func_74185_a(float f, int n, int n2) {
        GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
        this.field_73882_e._h._a(new ResourceLocation("textures/gui/container/enchanting_table.png"));
        GL11.glTranslatef(this.field_74198_m, this.field_74197_n, 0.0f);
        this.func_73729_b(0, 0, 0, 0, this.field_74194_b, this.field_74195_c);
        this.container.onUpdate(n, n2);
        this.container.drawSlots(this);
        this.container.drawScrollBar(this);
        String string = "" + this.container.level;
        this.field_73886_k._b(string, 33 - this.field_73886_k._b(string) / 2, 34, -10461088);
        GL11.glTranslatef(-this.field_74198_m, -this.field_74197_n, 0.0f);
    }

    @Override
    public void func_73866_w_() {
        super.func_73866_w_();
        this.field_73887_h.add(new GuiNEIButton(0, this.field_73880_f / 2 - 78, this.field_73881_g / 2 - 52, 12, 12, "<"));
        this.field_73887_h.add(new GuiNEIButton(1, this.field_73880_f / 2 - 44, this.field_73881_g / 2 - 52, 12, 12, ">"));
        this.field_73887_h.add(new GuiNEIButton(2, this.field_73880_f / 2 - 80, this.field_73881_g / 2 - 15, 50, 12, this.lockDisplayString()));
    }

    private String lockDisplayString() {
        return GuiEnchantmentModifier.validateEnchantments() ? NEIClientUtils.translate("enchant.locked", new Object[0]) : NEIClientUtils.translate("enchant.unlocked", new Object[0]);
    }

    public static boolean validateEnchantments() {
        return NEIClientConfig.world.nbt._o("validateenchantments");
    }

    public static void toggleEnchantmentValidation() {
        NEIClientConfig.world.nbt._a("validateenchantments", !GuiEnchantmentModifier.validateEnchantments());
        NEIClientConfig.world.saveNBT();
    }

    @Override
    protected void func_73875_a(jiok jiok2) {
        if (jiok2.field_73741_f == 0) {
            this.changeLevel(-1);
        } else if (jiok2.field_73741_f == 1) {
            this.changeLevel(1);
        } else if (jiok2.field_73741_f == 2) {
            GuiEnchantmentModifier.toggleEnchantmentValidation();
            this.container.updateEnchantmentOptions(GuiEnchantmentModifier.validateEnchantments());
            jiok2.field_73744_e = this.lockDisplayString();
        }
    }

    private void changeLevel(int n) {
        this.container.level += n;
        ((jiok)this.field_73887_h.get((int)0)).field_73742_g = this.container.level != 1;
        ((jiok)this.field_73887_h.get((int)1)).field_73742_g = this.container.level != 10;
    }

    @Override
    protected void func_73864_a(int n, int n2, int n3) {
        if (this.container.clickButton(n, n2, n3)) {
            return;
        }
        if (this.container.clickScrollBar(n, n2, n3)) {
            return;
        }
        super.func_73864_a(n, n2, n3);
    }

    @Override
    protected void func_73879_b(int n, int n2, int n3) {
        this.container.mouseUp(n, n2, n3);
        super.func_73879_b(n, n2, n3);
    }
}

