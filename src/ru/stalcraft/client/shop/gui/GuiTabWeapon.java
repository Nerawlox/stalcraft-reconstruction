/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  aut
 *  bjo
 */
package ru.stalcraft.client.shop.gui;

import java.net.URI;
import ru.stalcraft.client.shop.gui.GuiTabArmor;

public class GuiTabWeapon
extends awe {
    private final bjo ShopBackGround = new bjo("stalker", "textures/shop/tab_shop.png");
    private final bjo ShopWidgets = new bjo("stalker", "textures/shop/shop_widgets.png");
    private int id_AK74 = 101;
    private int id_SCARL = 102;
    private int id_XM8 = 103;
    private int id_GROZA = 104;
    private int tab = 1;

    @Override
    public void A_() {
        this.i.add(new aut(1, this.g / 2 - 213, this.h / 6 + 18 - 6, 50, 20, "\u041e\u0440\u0443\u0436\u0438\u0435"));
        this.i.add(new aut(2, this.g / 2 - 160, this.h / 6 + 18 - 6, 50, 20, "\u0411\u0440\u043e\u043d\u044f"));
        this.i.add(new aut(this.id_AK74, this.g / 2 - 5, this.h / 6 + 98 - 6, 100, 20, "\u041a\u0443\u043f\u0438\u0442\u044c"));
        this.i.add(new aut(this.id_SCARL, this.g / 2 + 150, this.h / 6 + 98 - 6, 100, 20, "\u041a\u0443\u043f\u0438\u0442\u044c"));
        this.i.add(new aut(this.id_XM8, this.g / 2 - 5, this.h / 6 + 153 - 6, 100, 20, "\u041a\u0443\u043f\u0438\u0442\u044c"));
        this.i.add(new aut(this.id_GROZA, this.g / 2 + 150, this.h / 6 + 153 - 6, 100, 20, "\u041a\u0443\u043f\u0438\u0442\u044c"));
        super.A_();
    }

    @Override
    public void a(int par1, int par2, float par3) {
        this.f.N.a(this.ShopBackGround);
        this.drawTexturedModalRect(this.g / 2 - 250, this.h / 2 - 185, 0, 0, 1000, 600, 1024, 0.6);
        this.addTextureContainer();
        this.addItem();
        super.a(par1, par2, par3);
    }

    public void addTextureContainer() {
        this.f.N.a(this.ShopWidgets);
        this.drawTexturedModalRect(this.g / 2 - 60, this.h / 2 - 160, 0, 0, 250, 150, 240, 0.7);
        this.f.N.a(this.ShopWidgets);
        this.drawTexturedModalRect(this.g / 2 + 95, this.h / 2 - 160, 0, 0, 250, 150, 240, 0.7);
        this.f.N.a(this.ShopWidgets);
        this.drawTexturedModalRect(this.g / 2 - 60, this.h / 2 - 105, 0, 0, 250, 150, 240, 0.7);
        this.f.N.a(this.ShopWidgets);
        this.drawTexturedModalRect(this.g / 2 + 95, this.h / 2 - 105, 0, 0, 250, 150, 240, 0.7);
    }

    public void addItem() {
        this.f.N.a(new bjo("stalker:textures/items/aks_icon.png"));
        this.drawTexturedModalRect(this.g / 2 - 48, this.h / 2 - 92, 0, 0, 68, 68, 68, 0.5);
        this.a(this.o, "AKC-74 380 \u0420\u0443\u0431.", this.g / 2 + 30, 163, 0xFFFFFF);
        this.f.N.a(new bjo("stalker:textures/items/scarl.png"));
        this.drawTexturedModalRect(this.g / 2 + 105, this.h / 2 - 94, 0, 0, 68, 68, 68, 0.55);
        this.a(this.o, "FN SCAR-L 400 \u0420\u0443\u0431.", this.g / 2 + 190, 163, 0xFFFFFF);
        this.f.N.a(new bjo("stalker:textures/items/xm8_icon.png"));
        this.drawTexturedModalRect(this.g / 2 - 48, this.h / 2 - 36, 0, 0, 68, 68, 68, 0.5);
        this.a(this.o, "XM-8 650 \u0420\u0443\u0431.", this.g / 2 + 30, 220, 0xFFFFFF);
        this.f.N.a(new bjo("stalker:textures/items/groza_icon.png"));
        this.drawTexturedModalRect(this.g / 2 + 105, this.h / 2 - 36, 0, 0, 68, 68, 68, 0.5);
        this.a(this.o, "\u041e\u0426-14 \u0413\u0440\u043e\u0437\u0430 500 \u0420\u0443\u0431.", this.g / 2 + 190, 220, 0xFFFFFF);
    }

    @Override
    public void a(int par1, int par2, int par3) {
        super.a(par1, par2, par3);
    }

    @Override
    public void a(aut b2) {
        Object object;
        Class<?> throwable;
        if (b2.g == 2) {
            this.f.a(new GuiTabArmor());
        }
        if (b2.g == this.id_AK74) {
            try {
                throwable = Class.forName("java.awt.Desktop");
                object = throwable.getMethod("getDesktop", new Class[0]).invoke(null, new Object[0]);
                throwable.getMethod("browse", URI.class).invoke(object, new URI("https://vk.com/market-169616941?w=product-169616941_1693593%2Fquery"));
            }
            catch (Throwable var4) {
                var4.printStackTrace();
            }
        }
        if (b2.g == this.id_SCARL) {
            try {
                throwable = Class.forName("java.awt.Desktop");
                object = throwable.getMethod("getDesktop", new Class[0]).invoke(null, new Object[0]);
                throwable.getMethod("browse", URI.class).invoke(object, new URI("https://vk.com/market-169616941?w=product-169616941_1693628%2Fquery"));
            }
            catch (Throwable var4) {
                var4.printStackTrace();
            }
        }
        if (b2.g == this.id_XM8) {
            try {
                throwable = Class.forName("java.awt.Desktop");
                object = throwable.getMethod("getDesktop", new Class[0]).invoke(null, new Object[0]);
                throwable.getMethod("browse", URI.class).invoke(object, new URI("https://vk.com/market-169616941?w=product-169616941_1693634%2Fquery"));
            }
            catch (Throwable var4) {
                var4.printStackTrace();
            }
        }
        if (b2.g == this.id_GROZA) {
            try {
                throwable = Class.forName("java.awt.Desktop");
                object = throwable.getMethod("getDesktop", new Class[0]).invoke(null, new Object[0]);
                throwable.getMethod("browse", URI.class).invoke(object, new URI("https://vk.com/market-169616941?w=product-169616941_1693620%2Fquery"));
            }
            catch (Throwable var4) {
                var4.printStackTrace();
            }
        }
    }

    @Override
    public boolean f() {
        return false;
    }

    public void drawTexturedModalRect(int posWidth, int posHeight, int minU, int minv, int maxU, int maxV, int textureSize, double scale) {
        double d2 = 1.0 / (double)textureSize;
        double sizeWidth = scale;
        double sizeHeight = scale;
        bfq tessellator = bfq.a;
        tessellator.b();
        tessellator.a(posWidth + 0, (double)posHeight + (double)maxV * sizeHeight, this.n, (double)(minU + 0) * d2, (double)(minv + maxV) * d2);
        tessellator.a((double)posWidth + (double)maxU * sizeWidth, (double)posHeight + (double)maxV * sizeHeight, this.n, (double)(minU + maxU) * d2, (double)(minv + maxV) * d2);
        tessellator.a((double)posWidth + (double)maxU * sizeWidth, posHeight + 0, this.n, (double)(minU + maxU) * d2, (double)(minv + 0) * d2);
        tessellator.a(posWidth + 0, posHeight + 0, this.n, (double)(minU + 0) * d2, (double)(minv + 0) * d2);
        tessellator.a();
    }
}

