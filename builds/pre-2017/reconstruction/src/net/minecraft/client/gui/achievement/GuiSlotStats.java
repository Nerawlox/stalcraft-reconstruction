/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.client.gui.achievement;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import net.minecraft.client.gui.GuiSlot;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.item.Item;
import org.lwjgl.input.Mouse;

public abstract class GuiSlotStats
extends GuiSlot {
    public int _a;
    public List _b;
    public Comparator _c;
    public int _d;
    public int _e;
    public final /* synthetic */ uzta _f;

    public GuiSlotStats(uzta uzta2) {
        this._f = uzta2;
        super(uzta._f(uzta2), uzta2.width, uzta2.height, 32, uzta2.height - 64, 20);
        this._a = -1;
        this._d = -1;
        this.setShowSelectionBox(false);
        this.func_77223_a(true, 20);
    }

    @Override
    public void elementClicked(int n, boolean bl) {
    }

    @Override
    public boolean isSelected(int n) {
        return false;
    }

    @Override
    public void drawBackground() {
        this._f.drawDefaultBackground();
    }

    @Override
    public void func_77222_a(int n, int n2, Tessellator tessellator) {
        if (!Mouse.isButtonDown(0)) {
            this._a = -1;
        }
        if (this._a == 0) {
            uzta._a(this._f, n + 115 - 18, n2 + 1, 0, 0);
        } else {
            uzta._a(this._f, n + 115 - 18, n2 + 1, 0, 18);
        }
        if (this._a == 1) {
            uzta._a(this._f, n + 165 - 18, n2 + 1, 0, 0);
        } else {
            uzta._a(this._f, n + 165 - 18, n2 + 1, 0, 18);
        }
        if (this._a == 2) {
            uzta._a(this._f, n + 215 - 18, n2 + 1, 0, 0);
        } else {
            uzta._a(this._f, n + 215 - 18, n2 + 1, 0, 18);
        }
        if (this._d != -1) {
            int n3 = 79;
            int n4 = 18;
            if (this._d == 1) {
                n3 = 129;
            } else if (this._d == 2) {
                n3 = 179;
            }
            if (this._e == 1) {
                n4 = 36;
            }
            uzta._a(this._f, n + n3, n2 + 1, n4, 0);
        }
    }

    @Override
    public void func_77224_a(int n, int n2) {
        this._a = -1;
        if (n >= 79 && n < 115) {
            this._a = 0;
        } else if (n >= 129 && n < 165) {
            this._a = 1;
        } else if (n >= 179 && n < 215) {
            this._a = 2;
        }
        if (this._a >= 0) {
            this._c(this._a);
            uzta._g((uzta)this._f)._N._a("random.click", 1.0f, 1.0f);
        }
    }

    @Override
    public final int getSize() {
        return this._b.size();
    }

    public final huss _a(int n) {
        return (huss)this._b.get(n);
    }

    public abstract String _b(int var1);

    public void _a(huss huss2, int n, int n2, boolean bl) {
        if (huss2 != null) {
            String string = huss2.func_75968_a(uzta._c(this._f)._a(huss2));
            this._f.drawString(uzta._h(this._f), string, n - uzta._i(this._f)._b(string), n2 + 5, bl ? 0xFFFFFF : 0x909090);
        } else {
            String string = "-";
            this._f.drawString(uzta._j(this._f), string, n - uzta._k(this._f)._b(string), n2 + 5, bl ? 0xFFFFFF : 0x909090);
        }
    }

    @Override
    public void func_77215_b(int n, int n2) {
        if (n2 < this.top || n2 > this.bottom) {
            return;
        }
        int n3 = this.func_77210_c(n, n2);
        int n4 = this._f.width / 2 - 92 - 16;
        if (n3 >= 0) {
            if (n < n4 + 40 || n > n4 + 40 + 20) {
                return;
            }
            huss huss2 = this._a(n3);
            this._a(huss2, n, n2);
        } else {
            String string = "";
            if (n >= n4 + 115 - 18 && n <= n4 + 115) {
                string = this._b(0);
            } else if (n >= n4 + 165 - 18 && n <= n4 + 165) {
                string = this._b(1);
            } else if (n >= n4 + 215 - 18 && n <= n4 + 215) {
                string = this._b(2);
            } else {
                return;
            }
            string = ("" + wpcz._a(string)).trim();
            if (string.length() > 0) {
                int n5 = n + 12;
                int n6 = n2 - 12;
                int n7 = uzta._l(this._f)._b(string);
                uzta._a(this._f, n5 - 3, n6 - 3, n5 + n7 + 3, n6 + 8 + 3, -1073741824, -1073741824);
                uzta._m(this._f)._a(string, n5, n6, -1);
            }
        }
    }

    public void _a(huss huss2, int n, int n2) {
        if (huss2 == null) {
            return;
        }
        Item item = Item.itemsList[huss2._a()];
        String string = ("" + wpcz._a(item.getUnlocalizedName() + ".name")).trim();
        if (string.length() > 0) {
            int n3 = n + 12;
            int n4 = n2 - 12;
            int n5 = uzta._n(this._f)._b(string);
            uzta._b(this._f, n3 - 3, n4 - 3, n3 + n5 + 3, n4 + 8 + 3, -1073741824, -1073741824);
            uzta._o(this._f)._a(string, n3, n4, -1);
        }
    }

    public void _c(int n) {
        if (n != this._d) {
            this._d = n;
            this._e = -1;
        } else if (this._e == -1) {
            this._e = 1;
        } else {
            this._d = -1;
            this._e = 0;
        }
        Collections.sort(this._b, this._c);
    }
}

