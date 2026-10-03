/*
 * Decompiled with CFR 0.152.
 */
package gloomyfolken.mods.core.client.gui.screens;

import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

public class GuiInventoryDynamic
extends zybc {
    private static final ResourceLocation field_110421_t = new ResourceLocation("textures/gui/container/generic_54.png");
    private mssh playerInventory;
    private xqsf dynInventory;
    private int inventoryRows;
    private int numPages = 1;

    public GuiInventoryDynamic(tego tego2, int n) {
        super(tego2);
        this.playerInventory = tego2._b;
        this.dynInventory = tego2._a;
        this.numPages = n;
        this.field_73885_j = false;
        int n2 = 222;
        int n3 = n2 - 108;
        this.inventoryRows = 3;
        this.field_74195_c = n3 + this.inventoryRows * 18;
    }

    @Override
    public void func_73866_w_() {
        super.func_73866_w_();
        this.field_73887_h.add(new jiok(1, this.field_74198_m + 5, this.field_74197_n - 20 - 5, 40, 20, wpcz._a("<")));
        this.field_73887_h.add(new jiok(2, this.field_74198_m + this.field_74194_b - 40 - 5, this.field_74197_n - 20 - 5, 40, 20, wpcz._a(">")));
        this.field_73887_h.add(new jiok(3, this.field_74198_m + this.field_74194_b / 2 - 40, this.field_74197_n - 20 - 5, 80, 20, wpcz._a("\u0421\u043e\u0440\u0442\u0438\u0440\u043e\u0432\u0430\u0442\u044c \u043f\u043e ID")));
        this.checkButtons();
    }

    @Override
    protected void func_74189_g(int n, int n2) {
        this.field_73886_k._b(this.dynInventory.func_94042_c() ? this.dynInventory.func_70303_b() : wpcz._a(this.dynInventory.func_70303_b()), 8, 6, 0x404040);
        this.field_73886_k._b(this.playerInventory.func_94042_c() ? this.playerInventory.func_70303_b() : wpcz._a(this.playerInventory.func_70303_b()), 8, this.field_74195_c - 96 + 2, 0x404040);
        String string = "\u0421\u0442\u0440\u0430\u043d\u0438\u0446\u0430: " + this.getPage();
        this.field_73886_k._b(string, this.field_74194_b - this.field_73886_k._b(string) - 8, 6, 0x404040);
    }

    @Override
    protected void func_74185_a(float f, int n, int n2) {
        GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
        this.field_73882_e._R()._a(field_110421_t);
        int n3 = (this.field_73880_f - this.field_74194_b) / 2;
        int n4 = (this.field_73881_g - this.field_74195_c) / 2;
        this.func_73729_b(n3, n4, 0, 0, this.field_74194_b, this.inventoryRows * 18 + 17);
        this.func_73729_b(n3, n4 + this.inventoryRows * 18 + 17, 0, 126, this.field_74194_b, 96);
    }

    @Override
    protected void func_73875_a(jiok jiok2) {
        if (jiok2.field_73741_f == 1) {
            this.changeButton(0);
        } else if (jiok2.field_73741_f == 2) {
            this.changeButton(1);
        } else if (jiok2.field_73741_f == 3) {
            this.changeButton(2);
        }
    }

    private int getPage() {
        return this.getDynInv()._c();
    }

    private void setPage(int n) {
        this.getDynInv()._a(n);
    }

    private void removePageItems(int n) {
        int n2 = (n - 1) * this.dynInventory.func_70302_i_();
        for (int i = 0; i < this.dynInventory.func_70302_i_(); ++i) {
            if (!this.dynInventory._a().containsKey(n2 + i)) continue;
            this.dynInventory._a().remove(n2 + i);
        }
    }

    private void changeButton(int n) {
        if (n == 1) {
            if (this.getPage() < this.numPages) {
                this.setPage(this.getPage() + 1);
                this.removePageItems(this.getPage());
                new ncxz(n).sendToServer();
            }
        } else if (this.getPage() > 0 && n == 0) {
            this.setPage(this.getPage() - 1);
            this.removePageItems(this.getPage());
            new ncxz(n).sendToServer();
        } else if (n == 2) {
            this.getDynInv()._a();
            this.getDynInv()._b();
            new ncxz(n).sendToServer();
        }
        this.checkButtons();
    }

    private void checkButtons() {
        ((jiok)this.field_73887_h.get((int)0)).field_73742_g = this.getPage() != 1;
        ((jiok)this.field_73887_h.get((int)1)).field_73742_g = this.getPage() < this.numPages;
    }

    private tego getDynInv() {
        return (tego)this.field_74193_d;
    }
}

