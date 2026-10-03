/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.client.renderer;

import gloomyfolken.mods.asm.GloomyHooks;
import java.util.Collection;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.inventory.Container;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import org.lwjgl.opengl.GL11;

public abstract class InventoryEffectRenderer
extends GuiContainer {
    public boolean field_74222_o;

    public InventoryEffectRenderer(Container container) {
        super(container);
    }

    @Override
    public void initGui() {
        super.initGui();
        if (!this.mc._t.getActivePotionEffects().isEmpty()) {
            this.guiLeft = 160 + (this.width - this.xSize - 200) / 2;
            this.field_74222_o = true;
        }
    }

    @Override
    public void drawScreen(int n, int n2, float f) {
        super.drawScreen(n, n2, f);
        if (this.field_74222_o) {
            this.displayDebuffEffects();
        }
    }

    public void displayDebuffEffects() {
        if (GloomyHooks.getTrue()) {
            return;
        }
        int n = this.guiLeft - 124;
        int n2 = this.guiTop;
        int n3 = 166;
        Collection collection = this.mc._t.getActivePotionEffects();
        if (collection.isEmpty()) {
            return;
        }
        GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
        GL11.glDisable(2896);
        int n4 = 33;
        if (collection.size() > 5) {
            n4 = 132 / (collection.size() - 1);
        }
        for (PotionEffect potionEffect : this.mc._t.getActivePotionEffects()) {
            Potion potion = Potion._a[potionEffect._a()];
            GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
            this.mc._R()._a(field_110408_a);
            this.drawTexturedModalRect(n, n2, 0, 166, 140, 32);
            if (potion._d()) {
                int n5 = potion._e();
                this.drawTexturedModalRect(n + 6, n2 + 7, 0 + n5 % 8 * 18, 198 + n5 / 8 * 18, 18, 18);
            }
            String string = wpcz._a(potion._c());
            if (potionEffect._c() == 1) {
                string = string + " II";
            } else if (potionEffect._c() == 2) {
                string = string + " III";
            } else if (potionEffect._c() == 3) {
                string = string + " IV";
            }
            this.fontRenderer._a(string, n + 10 + 18, n2 + 6, 0xFFFFFF);
            String string2 = Potion._a(potionEffect);
            this.fontRenderer._a(string2, n + 10 + 18, n2 + 6 + 10, 0x7F7F7F);
            n2 += n4;
        }
    }
}

