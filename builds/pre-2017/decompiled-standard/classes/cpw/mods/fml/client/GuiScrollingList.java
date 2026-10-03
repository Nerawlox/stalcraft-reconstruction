/*
 * Decompiled with CFR 0.152.
 */
package cpw.mods.fml.client;

import java.util.List;
import net.minecraft.client.xpzm;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.GL11;

public abstract class GuiScrollingList {
    private final xpzm client;
    protected final int listWidth;
    protected final int listHeight;
    protected final int top;
    protected final int bottom;
    private final int right;
    protected final int left;
    protected final int slotHeight;
    private int scrollUpActionId;
    private int scrollDownActionId;
    protected int mouseX;
    protected int mouseY;
    private float initialMouseClickY = -2.0f;
    private float scrollFactor;
    private float scrollDistance;
    private int selectedIndex = -1;
    private long lastClickTime = 0L;
    private boolean field_25123_p = true;
    private boolean field_27262_q;
    private int field_27261_r;

    public GuiScrollingList(xpzm xpzm2, int n, int n2, int n3, int n4, int n5, int n6) {
        this.client = xpzm2;
        this.listWidth = n;
        this.listHeight = n2;
        this.top = n3;
        this.bottom = n4;
        this.slotHeight = n6;
        this.left = n5;
        this.right = n + this.left;
    }

    public void func_27258_a(boolean bl) {
        this.field_25123_p = bl;
    }

    protected void func_27259_a(boolean bl, int n) {
        this.field_27262_q = bl;
        this.field_27261_r = n;
        if (!bl) {
            this.field_27261_r = 0;
        }
    }

    protected abstract int getSize();

    protected abstract void elementClicked(int var1, boolean var2);

    protected abstract boolean isSelected(int var1);

    protected int getContentHeight() {
        return this.getSize() * this.slotHeight + this.field_27261_r;
    }

    protected abstract void drawBackground();

    protected abstract void drawSlot(int var1, int var2, int var3, int var4, htvf var5);

    protected void func_27260_a(int n, int n2, htvf htvf2) {
    }

    protected void func_27255_a(int n, int n2) {
    }

    protected void func_27257_b(int n, int n2) {
    }

    public int func_27256_c(int n, int n2) {
        int n3 = this.left + 1;
        int n4 = this.left + this.listWidth - 7;
        int n5 = n2 - this.top - this.field_27261_r + (int)this.scrollDistance - 4;
        int n6 = n5 / this.slotHeight;
        return n >= n3 && n <= n4 && n6 >= 0 && n5 >= 0 && n6 < this.getSize() ? n6 : -1;
    }

    public void registerScrollButtons(List list, int n, int n2) {
        this.scrollUpActionId = n;
        this.scrollDownActionId = n2;
    }

    private void applyScrollLimits() {
        int n = this.getContentHeight() - (this.bottom - this.top - 4);
        if (n < 0) {
            n /= 2;
        }
        if (this.scrollDistance < 0.0f) {
            this.scrollDistance = 0.0f;
        }
        if (this.scrollDistance > (float)n) {
            this.scrollDistance = n;
        }
    }

    public void actionPerformed(jiok jiok2) {
        if (jiok2.field_73742_g) {
            if (jiok2.field_73741_f == this.scrollUpActionId) {
                this.scrollDistance -= (float)(this.slotHeight * 2 / 3);
                this.initialMouseClickY = -2.0f;
                this.applyScrollLimits();
            } else if (jiok2.field_73741_f == this.scrollDownActionId) {
                this.scrollDistance += (float)(this.slotHeight * 2 / 3);
                this.initialMouseClickY = -2.0f;
                this.applyScrollLimits();
            }
        }
    }

    public void drawScreen(int n, int n2, float f) {
        int n3;
        int n4;
        int n5;
        int n6;
        int n7;
        int n8;
        int n9;
        this.mouseX = n;
        this.mouseY = n2;
        this.drawBackground();
        int n10 = this.getSize();
        int n11 = this.left + this.listWidth - 6;
        int n12 = n11 + 6;
        int n13 = this.left;
        int n14 = n11 - 1;
        if (Mouse.isButtonDown(0)) {
            if (this.initialMouseClickY == -1.0f) {
                n9 = 1;
                if (n2 >= this.top && n2 <= this.bottom) {
                    n8 = n2 - this.top - this.field_27261_r + (int)this.scrollDistance - 4;
                    n7 = n8 / this.slotHeight;
                    if (n >= n13 && n <= n14 && n7 >= 0 && n8 >= 0 && n7 < n10) {
                        boolean bl = n7 == this.selectedIndex && System.currentTimeMillis() - this.lastClickTime < 250L;
                        this.elementClicked(n7, bl);
                        this.selectedIndex = n7;
                        this.lastClickTime = System.currentTimeMillis();
                    } else if (n >= n13 && n <= n14 && n8 < 0) {
                        this.func_27255_a(n - n13, n2 - this.top + (int)this.scrollDistance - 4);
                        n9 = 0;
                    }
                    if (n >= n11 && n <= n12) {
                        this.scrollFactor = -1.0f;
                        n6 = this.getContentHeight() - (this.bottom - this.top - 4);
                        if (n6 < 1) {
                            n6 = 1;
                        }
                        if ((n5 = (int)((float)((this.bottom - this.top) * (this.bottom - this.top)) / (float)this.getContentHeight())) < 32) {
                            n5 = 32;
                        }
                        if (n5 > this.bottom - this.top - 8) {
                            n5 = this.bottom - this.top - 8;
                        }
                        this.scrollFactor /= (float)(this.bottom - this.top - n5) / (float)n6;
                    } else {
                        this.scrollFactor = 1.0f;
                    }
                    this.initialMouseClickY = n9 != 0 ? (float)n2 : -2.0f;
                } else {
                    this.initialMouseClickY = -2.0f;
                }
            } else if (this.initialMouseClickY >= 0.0f) {
                this.scrollDistance -= ((float)n2 - this.initialMouseClickY) * this.scrollFactor;
                this.initialMouseClickY = n2;
            }
        } else {
            while (Mouse.next()) {
                n9 = Mouse.getEventDWheel();
                if (n9 == 0) continue;
                if (n9 > 0) {
                    n9 = -1;
                } else if (n9 < 0) {
                    n9 = 1;
                }
                this.scrollDistance += (float)(n9 * this.slotHeight / 2);
            }
            this.initialMouseClickY = -1.0f;
        }
        this.applyScrollLimits();
        GL11.glDisable(2896);
        GL11.glDisable(2912);
        htvf htvf2 = htvf.field_78398_a;
        this.client._h._a(bawa.field_110325_k);
        GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
        float f2 = 32.0f;
        htvf2.func_78382_b();
        htvf2.func_78378_d(0x202020);
        htvf2.func_78374_a(this.left, this.bottom, 0.0, (float)this.left / f2, (float)(this.bottom + (int)this.scrollDistance) / f2);
        htvf2.func_78374_a(this.right, this.bottom, 0.0, (float)this.right / f2, (float)(this.bottom + (int)this.scrollDistance) / f2);
        htvf2.func_78374_a(this.right, this.top, 0.0, (float)this.right / f2, (float)(this.top + (int)this.scrollDistance) / f2);
        htvf2.func_78374_a(this.left, this.top, 0.0, (float)this.left / f2, (float)(this.top + (int)this.scrollDistance) / f2);
        htvf2.func_78381_a();
        n8 = this.top + 4 - (int)this.scrollDistance;
        if (this.field_27262_q) {
            this.func_27260_a(n14, n8, htvf2);
        }
        for (n7 = 0; n7 < n10; ++n7) {
            n6 = n8 + n7 * this.slotHeight + this.field_27261_r;
            n5 = this.slotHeight - 4;
            if (n6 > this.bottom || n6 + n5 < this.top) continue;
            if (this.field_25123_p && this.isSelected(n7)) {
                n4 = n13;
                n3 = n14;
                GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
                GL11.glDisable(3553);
                htvf2.func_78382_b();
                htvf2.func_78378_d(0x808080);
                htvf2.func_78374_a(n4, n6 + n5 + 2, 0.0, 0.0, 1.0);
                htvf2.func_78374_a(n3, n6 + n5 + 2, 0.0, 1.0, 1.0);
                htvf2.func_78374_a(n3, n6 - 2, 0.0, 1.0, 0.0);
                htvf2.func_78374_a(n4, n6 - 2, 0.0, 0.0, 0.0);
                htvf2.func_78378_d(0);
                htvf2.func_78374_a(n4 + 1, n6 + n5 + 1, 0.0, 0.0, 1.0);
                htvf2.func_78374_a(n3 - 1, n6 + n5 + 1, 0.0, 1.0, 1.0);
                htvf2.func_78374_a(n3 - 1, n6 - 1, 0.0, 1.0, 0.0);
                htvf2.func_78374_a(n4 + 1, n6 - 1, 0.0, 0.0, 0.0);
                htvf2.func_78381_a();
                GL11.glEnable(3553);
            }
            this.drawSlot(n7, n14, n6, n5, htvf2);
        }
        GL11.glDisable(2929);
        n3 = 4;
        this.overlayBackground(0, this.top, 255, 255);
        this.overlayBackground(this.bottom, this.listHeight, 255, 255);
        GL11.glEnable(3042);
        GL11.glBlendFunc(770, 771);
        GL11.glDisable(3008);
        GL11.glShadeModel(7425);
        GL11.glDisable(3553);
        htvf2.func_78382_b();
        htvf2.func_78384_a(0, 0);
        htvf2.func_78374_a(this.left, this.top + n3, 0.0, 0.0, 1.0);
        htvf2.func_78374_a(this.right, this.top + n3, 0.0, 1.0, 1.0);
        htvf2.func_78384_a(0, 255);
        htvf2.func_78374_a(this.right, this.top, 0.0, 1.0, 0.0);
        htvf2.func_78374_a(this.left, this.top, 0.0, 0.0, 0.0);
        htvf2.func_78381_a();
        htvf2.func_78382_b();
        htvf2.func_78384_a(0, 255);
        htvf2.func_78374_a(this.left, this.bottom, 0.0, 0.0, 1.0);
        htvf2.func_78374_a(this.right, this.bottom, 0.0, 1.0, 1.0);
        htvf2.func_78384_a(0, 0);
        htvf2.func_78374_a(this.right, this.bottom - n3, 0.0, 1.0, 0.0);
        htvf2.func_78374_a(this.left, this.bottom - n3, 0.0, 0.0, 0.0);
        htvf2.func_78381_a();
        n6 = this.getContentHeight() - (this.bottom - this.top - 4);
        if (n6 > 0) {
            n5 = (this.bottom - this.top) * (this.bottom - this.top) / this.getContentHeight();
            if (n5 < 32) {
                n5 = 32;
            }
            if (n5 > this.bottom - this.top - 8) {
                n5 = this.bottom - this.top - 8;
            }
            if ((n4 = (int)this.scrollDistance * (this.bottom - this.top - n5) / n6 + this.top) < this.top) {
                n4 = this.top;
            }
            htvf2.func_78382_b();
            htvf2.func_78384_a(0, 255);
            htvf2.func_78374_a(n11, this.bottom, 0.0, 0.0, 1.0);
            htvf2.func_78374_a(n12, this.bottom, 0.0, 1.0, 1.0);
            htvf2.func_78374_a(n12, this.top, 0.0, 1.0, 0.0);
            htvf2.func_78374_a(n11, this.top, 0.0, 0.0, 0.0);
            htvf2.func_78381_a();
            htvf2.func_78382_b();
            htvf2.func_78384_a(0x808080, 255);
            htvf2.func_78374_a(n11, n4 + n5, 0.0, 0.0, 1.0);
            htvf2.func_78374_a(n12, n4 + n5, 0.0, 1.0, 1.0);
            htvf2.func_78374_a(n12, n4, 0.0, 1.0, 0.0);
            htvf2.func_78374_a(n11, n4, 0.0, 0.0, 0.0);
            htvf2.func_78381_a();
            htvf2.func_78382_b();
            htvf2.func_78384_a(0xC0C0C0, 255);
            htvf2.func_78374_a(n11, n4 + n5 - 1, 0.0, 0.0, 1.0);
            htvf2.func_78374_a(n12 - 1, n4 + n5 - 1, 0.0, 1.0, 1.0);
            htvf2.func_78374_a(n12 - 1, n4, 0.0, 1.0, 0.0);
            htvf2.func_78374_a(n11, n4, 0.0, 0.0, 0.0);
            htvf2.func_78381_a();
        }
        this.func_27257_b(n, n2);
        GL11.glEnable(3553);
        GL11.glShadeModel(7424);
        GL11.glEnable(3008);
        GL11.glDisable(3042);
    }

    private void overlayBackground(int n, int n2, int n3, int n4) {
        htvf htvf2 = htvf.field_78398_a;
        this.client._h._a(bawa.field_110325_k);
        GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
        float f = 32.0f;
        htvf2.func_78382_b();
        htvf2.func_78384_a(0x404040, n4);
        htvf2.func_78374_a(0.0, n2, 0.0, 0.0, (float)n2 / f);
        htvf2.func_78374_a((double)this.listWidth + 30.0, n2, 0.0, (float)(this.listWidth + 30) / f, (float)n2 / f);
        htvf2.func_78384_a(0x404040, n3);
        htvf2.func_78374_a((double)this.listWidth + 30.0, n, 0.0, (float)(this.listWidth + 30) / f, (float)n / f);
        htvf2.func_78374_a(0.0, n, 0.0, 0.0, (float)n / f);
        htvf2.func_78381_a();
    }
}

