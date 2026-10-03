/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  aut
 *  bjo
 */
package ru.stalcraft.client.shop.gui;

import java.net.URI;
import ru.stalcraft.client.shop.gui.GuiTabWeapon;

public class GuiTabArmor
extends awe {
    private final bjo ShopBackGround = new bjo("stalker", "textures/shop/tab_shop.png");
    private final bjo ShopWidgets = new bjo("stalker", "textures/shop/shop_widgets.png");
    private int id_ZARYA = 101;
    private int id_SEVA = 102;
    private int tab = 1;

    @Override
    public void A_() {
        this.i.add(new aut(1, this.g / 2 - 213, this.h / 6 + 18 - 6, 50, 20, "\u041e\u0440\u0443\u0436\u0438\u0435"));
        this.i.add(new aut(2, this.g / 2 - 160, this.h / 6 + 18 - 6, 50, 20, "\u0411\u0440\u043e\u043d\u044f"));
        this.i.add(new aut(this.id_ZARYA, this.g / 2 - 5, this.h / 6 + 98 - 6, 100, 20, "\u041a\u0443\u043f\u0438\u0442\u044c"));
        this.i.add(new aut(this.id_SEVA, this.g / 2 + 150, this.h / 6 + 98 - 6, 100, 20, "\u041a\u0443\u043f\u0438\u0442\u044c"));
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
    }

    public void addItem() {
        this.f.N.a(new bjo("stalker:textures/items/zarya_gas.png"));
        this.drawTexturedModalRect(this.g / 2 - 48, this.h / 2 - 92, 0, 0, 68, 68, 68, 0.5);
        this.a(this.o, "\u041a\u043e\u043c\u0431\u0435\u0437 \u0417\u0430\u0440\u044f 200 \u0420\u0443\u0431.", this.g / 2 + 36, 163, 0xFFFFFF);
        this.f.N.a(new bjo("stalker:textures/items/seva.png"));
        this.drawTexturedModalRect(this.g / 2 + 105, this.h / 2 - 94, 0, 0, 68, 68, 68, 0.55);
        this.a(this.o, "\u041f\u043e\u0442\u0440\u0451\u043f\u0430\u043d\u043d\u044b\u0439 \u043a\u043e\u043c\u0431\u0435\u0437 390 \u0420\u0443\u0431.", this.g / 2 + 201, 163, 0xFFFFFF);
    }

    @Override
    public void a(int par1, int par2, int par3) {
        super.a(par1, par2, par3);
    }

    @Override
    public void a(aut b2) {
        Object object;
        Class<?> throwable;
        if (b2.g == 1) {
            this.f.a(new GuiTabWeapon());
        }
        if (b2.g == this.id_ZARYA) {
            try {
                throwable = Class.forName("java.awt.Desktop");
                object = throwable.getMethod("getDesktop", new Class[0]).invoke(null, new Object[0]);
                throwable.getMethod("browse", URI.class).invoke(object, new URI("https://vk.com/market-169616941?w=product-169616941_1693388%2Fquery"));
            }
            catch (Throwable var4) {
                var4.printStackTrace();
            }
        }
        if (b2.g == this.id_SEVA) {
            try {
                throwable = Class.forName("java.awt.Desktop");
                object = throwable.getMethod("getDesktop", new Class[0]).invoke(null, new Object[0]);
                throwable.getMethod("browse", URI.class).invoke(object, new URI("https://vk.com/market-169616941?w=product-169616941_1693591%2Fquery"));
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

