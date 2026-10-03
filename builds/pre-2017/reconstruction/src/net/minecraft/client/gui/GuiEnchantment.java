/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.client.gui;

import java.util.Random;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.model.ModelBook;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.ContainerEnchantment;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnchantmentNameParts;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.sajh;
import net.minecraft.world.World;
import org.lwjgl.opengl.GL11;
import org.lwjgl.util.glu.Project;

public class GuiEnchantment
extends GuiContainer {
    public static final ResourceLocation _a = new ResourceLocation("textures/gui/container/enchanting_table.png");
    public static final ResourceLocation _b = new ResourceLocation("textures/entity/enchanting_table_book.png");
    public static final ModelBook _c = new ModelBook();
    public Random _d = new Random();
    public ContainerEnchantment _e = (ContainerEnchantment)this.inventorySlots;
    public int _f;
    public float _g;
    public float _h;
    public float _i;
    public float _j;
    public float _k;
    public float _l;
    public ItemStack _m;
    public String _n;

    public GuiEnchantment(InventoryPlayer inventoryPlayer, World world, int n, int n2, int n3, String string) {
        super(new ContainerEnchantment(inventoryPlayer, world, n, n2, n3));
        this._n = string;
    }

    @Override
    public void drawGuiContainerForegroundLayer(int n, int n2) {
        this.fontRenderer._b(this._n == null ? wpcz._a("container.enchant") : this._n, 12, 5, 0x404040);
        this.fontRenderer._b(wpcz._a("container.inventory"), 8, this.ySize - 96 + 2, 0x404040);
    }

    @Override
    public void updateScreen() {
        super.updateScreen();
        this._a();
    }

    @Override
    public void mouseClicked(int n, int n2, int n3) {
        super.mouseClicked(n, n2, n3);
        int n4 = (this.width - this.xSize) / 2;
        int n5 = (this.height - this.ySize) / 2;
        for (int i = 0; i < 3; ++i) {
            int n6 = n - (n4 + 60);
            int n7 = n2 - (n5 + 14 + 19 * i);
            if (n6 < 0 || n7 < 0 || n6 >= 108 || n7 >= 19 || !this._e.enchantItem(this.mc._t, i)) continue;
            this.mc._j._a(this._e.windowId, i);
        }
    }

    @Override
    public void drawGuiContainerBackgroundLayer(float f, int n, int n2) {
        GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
        this.mc._R()._a(_a);
        int n3 = (this.width - this.xSize) / 2;
        int n4 = (this.height - this.ySize) / 2;
        this.drawTexturedModalRect(n3, n4, 0, 0, this.xSize, this.ySize);
        GL11.glPushMatrix();
        GL11.glMatrixMode(5889);
        GL11.glPushMatrix();
        GL11.glLoadIdentity();
        htou htou2 = new htou(this.mc._M, this.mc._n, this.mc._o);
        GL11.glViewport((htou2._a() - 320) / 2 * htou2._e(), (htou2._b() - 240) / 2 * htou2._e(), 320 * htou2._e(), 240 * htou2._e());
        GL11.glTranslatef(-0.34f, 0.23f, 0.0f);
        Project.gluPerspective(90.0f, 1.3333334f, 9.0f, 80.0f);
        float f2 = 1.0f;
        GL11.glMatrixMode(5888);
        GL11.glLoadIdentity();
        qnon._b();
        GL11.glTranslatef(0.0f, 3.3f, -16.0f);
        GL11.glScalef(f2, f2, f2);
        float f3 = 5.0f;
        GL11.glScalef(f3, f3, f3);
        GL11.glRotatef(180.0f, 0.0f, 0.0f, 1.0f);
        this.mc._R()._a(_b);
        GL11.glRotatef(20.0f, 1.0f, 0.0f, 0.0f);
        float f4 = this._l + (this._k - this._l) * f;
        GL11.glTranslatef((1.0f - f4) * 0.2f, (1.0f - f4) * 0.1f, (1.0f - f4) * 0.25f);
        GL11.glRotatef(-(1.0f - f4) * 90.0f - 90.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(180.0f, 1.0f, 0.0f, 0.0f);
        float f5 = this._h + (this._g - this._h) * f + 0.25f;
        float f6 = this._h + (this._g - this._h) * f + 0.75f;
        f5 = (f5 - (float)sajh._b((double)f5)) * 1.6f - 0.3f;
        f6 = (f6 - (float)sajh._b((double)f6)) * 1.6f - 0.3f;
        if (f5 < 0.0f) {
            f5 = 0.0f;
        }
        if (f6 < 0.0f) {
            f6 = 0.0f;
        }
        if (f5 > 1.0f) {
            f5 = 1.0f;
        }
        if (f6 > 1.0f) {
            f6 = 1.0f;
        }
        GL11.glEnable(32826);
        _c.render(null, 0.0f, f5, f6, f4, 0.0f, 0.0625f);
        GL11.glDisable(32826);
        qnon._a();
        GL11.glMatrixMode(5889);
        GL11.glViewport(0, 0, this.mc._n, this.mc._o);
        GL11.glPopMatrix();
        GL11.glMatrixMode(5888);
        GL11.glPopMatrix();
        qnon._a();
        GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
        EnchantmentNameParts._a._a(this._e.nameSeed);
        for (int i = 0; i < 3; ++i) {
            String string = EnchantmentNameParts._a._a();
            this.zLevel = 0.0f;
            this.mc._R()._a(_a);
            int n5 = this._e.enchantLevels[i];
            GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
            if (n5 == 0) {
                this.drawTexturedModalRect(n3 + 60, n4 + 14 + 19 * i, 0, 185, 108, 19);
                continue;
            }
            String string2 = "" + n5;
            FontRenderer fontRenderer = this.mc._A;
            int n6 = 6839882;
            if (this.mc._t.experienceLevel < n5 && !this.mc._t.capabilities._d) {
                this.drawTexturedModalRect(n3 + 60, n4 + 14 + 19 * i, 0, 185, 108, 19);
                fontRenderer._a(string, n3 + 62, n4 + 16 + 19 * i, 104, (n6 & 0xFEFEFE) >> 1);
                fontRenderer = this.mc._z;
                n6 = 4226832;
                fontRenderer._a(string2, n3 + 62 + 104 - fontRenderer._b(string2), n4 + 16 + 19 * i + 7, n6);
                continue;
            }
            int n7 = n - (n3 + 60);
            int n8 = n2 - (n4 + 14 + 19 * i);
            if (n7 >= 0 && n8 >= 0 && n7 < 108 && n8 < 19) {
                this.drawTexturedModalRect(n3 + 60, n4 + 14 + 19 * i, 0, 204, 108, 19);
                n6 = 0xFFFF80;
            } else {
                this.drawTexturedModalRect(n3 + 60, n4 + 14 + 19 * i, 0, 166, 108, 19);
            }
            fontRenderer._a(string, n3 + 62, n4 + 16 + 19 * i, 104, n6);
            fontRenderer = this.mc._z;
            n6 = 8453920;
            fontRenderer._a(string2, n3 + 62 + 104 - fontRenderer._b(string2), n4 + 16 + 19 * i + 7, n6);
        }
    }

    public void _a() {
        float f;
        float f2;
        ItemStack itemStack = this.inventorySlots.getSlot(0).getStack();
        if (!ItemStack._b(itemStack, this._m)) {
            this._m = itemStack;
            do {
                this._i += (float)(this._d.nextInt(4) - this._d.nextInt(4));
            } while (this._g <= this._i + 1.0f && this._g >= this._i - 1.0f);
        }
        ++this._f;
        this._h = this._g;
        this._l = this._k;
        boolean bl = false;
        for (int i = 0; i < 3; ++i) {
            if (this._e.enchantLevels[i] == 0) continue;
            bl = true;
        }
        this._k = bl ? (this._k += 0.2f) : (this._k -= 0.2f);
        if (this._k < 0.0f) {
            this._k = 0.0f;
        }
        if (this._k > 1.0f) {
            this._k = 1.0f;
        }
        if ((f2 = (this._i - this._g) * 0.4f) < -(f = 0.2f)) {
            f2 = -f;
        }
        if (f2 > f) {
            f2 = f;
        }
        this._j += (f2 - this._j) * 0.9f;
        this._g += this._j;
    }
}

