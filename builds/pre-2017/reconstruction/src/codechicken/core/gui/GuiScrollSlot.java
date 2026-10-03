/*
 * Decompiled with CFR 0.152.
 */
package codechicken.core.gui;

import codechicken.core.gui.GuiWidget;
import codechicken.lib.math.MathHelper;
import net.minecraft.client.gui.GuiButton;

public abstract class GuiScrollSlot
extends GuiWidget {
    protected GuiButton scrollupbutton;
    protected GuiButton scrolldownbutton;
    protected String actionCommand;
    protected int scrollclicky = -1;
    protected float scrollpercent;
    protected int scrollmousey;
    protected float percentscrolled;
    protected int lastslotclicked = -1;
    protected int lastbuttonclicked = -1;
    protected long lastslotclicktime;
    public boolean focused;
    public int contentx;
    public int contenty;
    public int contentheight;
    public boolean smoothScroll = true;

    public GuiScrollSlot(int n, int n2, int n3, int n4) {
        super(n, n2, n3, n4);
        this.setContentSize(n + 3, n2 + 2, n4 - 2);
    }

    public GuiScrollSlot setActionCommand(String string) {
        this.actionCommand = string;
        return this;
    }

    public void setSmoothScroll(boolean bl) {
        this.smoothScroll = bl;
    }

    @Override
    public void setSize(int n, int n2, int n3, int n4) {
        int n5 = this.contentx - this.x;
        int n6 = this.contenty - this.y;
        int n7 = n4 - this.contentheight;
        super.setSize(n, n2, n3, n4);
        this.setContentSize(n + n5, n2 + n6, n4 - n7);
    }

    public void setContentSize(int n, int n2, int n3) {
        this.contentx = n;
        this.contenty = n2;
        this.contentheight = n3;
    }

    public void registerButtons(GuiButton guiButton, GuiButton guiButton2, String string) {
        this.scrollupbutton = guiButton;
        this.scrolldownbutton = guiButton2;
        this.actionCommand = string;
    }

    public abstract int getSlotHeight();

    protected abstract int getNumSlots();

    public abstract void selectNext();

    public abstract void selectPrev();

    protected abstract void slotClicked(int var1, int var2, int var3, int var4, boolean var5);

    protected abstract boolean isSlotSelected(int var1);

    protected abstract void drawSlot(int var1, int var2, int var3, int var4, int var5, boolean var6, float var7);

    protected void unfocus() {
    }

    public void setFocused(boolean bl) {
        this.focused = bl;
        if (!this.focused) {
            this.unfocus();
        }
    }

    public void scrollUp() {
        this.scroll(-5);
    }

    public void scrollDown() {
        this.scroll(5);
    }

    public void scroll(int n) {
        this.percentscrolled += (float)n / (float)this.contentheight * 100.0f;
        this.calculatePercentScrolled();
    }

    public int totalContentHeight() {
        return this.getNumSlots() * this.getSlotHeight();
    }

    public int getSlotY(int n) {
        int n2 = (int)((double)((float)(this.totalContentHeight() - this.contentheight) * this.percentscrolled) + 0.5);
        if (!this.smoothScroll) {
            n2 = (int)((double)n2 / (double)this.getSlotHeight() + 0.5) * this.getSlotHeight();
        }
        return this.contenty - n2 + n * this.getSlotHeight();
    }

    public int getClickedSlot(int n) {
        if (n < this.contenty || n >= this.contenty + this.contentheight) {
            return -1;
        }
        for (int i = 0; i < this.getNumSlots(); ++i) {
            int n2 = this.getSlotY(i);
            if (n < n2 || n >= n2 + this.getSlotHeight()) continue;
            return i;
        }
        return -1;
    }

    public int getScrollBarWidth() {
        return 5;
    }

    public int getScrollBarHeight() {
        int n = (int)((float)this.contentheight / (float)this.totalContentHeight() * (float)this.height);
        if (n > this.height) {
            return this.height;
        }
        if (n < this.height / 15) {
            return this.height / 15;
        }
        return n;
    }

    public void calculatePercentScrolled() {
        int n = this.height - this.getScrollBarHeight();
        if (this.scrollclicky >= 0) {
            int n2 = this.scrollmousey - this.scrollclicky;
            this.percentscrolled = (float)n2 / (float)n + this.scrollpercent;
        }
        this.percentscrolled = (float)MathHelper.clip(this.percentscrolled, 0.0, 1.0);
    }

    public void showSlot(int n) {
        int n2 = this.getSlotY(n);
        if (n2 + this.getSlotHeight() > this.contenty + this.contentheight) {
            int n3 = n2 - (this.contenty + this.contentheight - this.getSlotHeight());
            this.percentscrolled = (float)((double)this.percentscrolled + (double)n3 / (double)(this.totalContentHeight() - this.contentheight));
            this.calculatePercentScrolled();
        } else if (n2 < this.contenty) {
            int n4 = this.contenty - n2;
            this.percentscrolled = (float)((double)this.percentscrolled - (double)n4 / (double)(this.totalContentHeight() - this.contentheight));
            this.calculatePercentScrolled();
        }
    }

    public void processMouse(int n, int n2) {
        if (this.scrollclicky >= 0) {
            int n3 = n2 - this.scrollclicky;
            int n4 = (int)((double)((float)(this.height - this.getScrollBarHeight()) * this.scrollpercent) + 0.5);
            int n5 = this.height - this.getScrollBarHeight() - n4;
            this.scrollmousey = -n3 > n4 ? this.scrollclicky - n4 : (n3 > n5 ? this.scrollclicky + n5 : n2);
            this.calculatePercentScrolled();
        }
    }

    public void actionPerformed(GuiButton guiButton) {
        if (!guiButton.enabled) {
            return;
        }
        if (this.scrollupbutton != null && guiButton.id == this.scrollupbutton.id) {
            this.scrollUp();
        } else if (this.scrolldownbutton != null && guiButton.id == this.scrolldownbutton.id) {
            this.scrollDown();
        }
    }

    @Override
    public void mouseClicked(int n, int n2, int n3) {
        boolean bl;
        boolean bl2 = bl = n >= this.x && n < this.x + this.width && n2 >= this.y && n2 <= this.y + this.height;
        if (bl != this.focused) {
            this.setFocused(bl);
        }
        int n4 = this.height - this.getScrollBarHeight();
        int n5 = this.x + this.width - this.getScrollBarWidth();
        int n6 = this.y + (int)((double)((float)n4 * this.percentscrolled) + 0.5);
        if (n3 == 0 && this.getScrollBarHeight() < this.height && n >= n5 && n <= this.x + this.width && n2 >= this.y && n2 <= this.y + this.height) {
            if (n2 < n6) {
                this.percentscrolled = (float)(n2 - this.y) / (float)n4;
                this.calculatePercentScrolled();
            } else if (n2 > n6 + this.getScrollBarHeight()) {
                this.percentscrolled = (float)(n2 - this.y - this.getScrollBarHeight() + 1) / (float)n4;
                this.calculatePercentScrolled();
            } else {
                this.scrollclicky = n2;
                this.scrollpercent = this.percentscrolled;
                this.scrollmousey = n2;
            }
        } else if (n >= this.contentx && n < n5 && n2 >= this.contenty && n2 <= this.contenty + this.contentheight) {
            int n7 = this.getClickedSlot(n2);
            if (n7 >= 0) {
                this.slotClicked(n7, n3, n - this.contentx, n2 - this.getSlotY(n7), n7 == this.lastslotclicked && n3 == this.lastbuttonclicked && System.currentTimeMillis() - this.lastslotclicktime < 500L);
            }
            this.lastslotclicked = n7;
            this.lastbuttonclicked = n3;
            this.lastslotclicktime = System.currentTimeMillis();
        }
    }

    @Override
    public void mouseMovedOrUp(int n, int n2, int n3) {
        if (this.scrollclicky >= 0 && n3 == 0) {
            this.scrollclicky = -1;
        }
    }

    @Override
    public void keyTyped(char c, int n) {
        if (!this.focused) {
            return;
        }
        if (n == 200) {
            this.selectPrev();
        }
        if (n == 208) {
            this.selectNext();
        }
        if (n == 28 && this.actionCommand != null) {
            this.sendAction(this.actionCommand, new Object[0]);
        }
    }

    public void drawSlotBox(float f) {
        GuiScrollSlot.drawRect(this.x, this.y, this.x + this.width, this.y + this.height, -16777216);
    }

    public void drawBackground(float f) {
    }

    public void drawOverlay(float f) {
        GuiScrollSlot.drawRect(this.x, this.y - 1, this.x + this.width, this.y, -6250336);
        GuiScrollSlot.drawRect(this.x, this.y + this.height, this.x + this.width, this.y + this.height + 1, -6250336);
        GuiScrollSlot.drawRect(this.x - 1, this.y - 1, this.x, this.y + this.height + 1, -6250336);
        GuiScrollSlot.drawRect(this.x + this.width, this.y - 1, this.x + this.width + 1, this.y + this.height + 1, -6250336);
    }

    public void drawScrollBar(float f) {
        int n = this.getScrollBarWidth();
        int n2 = this.getScrollBarHeight();
        int n3 = this.x + this.width - n;
        int n4 = this.y + (int)((double)((float)(this.height - n2) * this.percentscrolled) + 0.4999);
        GuiScrollSlot.drawRect(n3, n4, n3 + n, n4 + n2, -7631989);
        GuiScrollSlot.drawRect(n3, n4, n3 + n - 1, n4 + n2 - 1, -986896);
        GuiScrollSlot.drawRect(n3 + 1, n4 + 1, n3 + n, n4 + n2, -11184811);
        GuiScrollSlot.drawRect(n3 + 1, n4 + 1, n3 + n - 1, n4 + n2 - 1, -3750202);
        if (this.drawLineGuide()) {
            GuiScrollSlot.drawRect(n3 - 1, this.y, n3, this.y + this.height, -8355712);
        }
    }

    public boolean drawLineGuide() {
        return true;
    }

    public void drawSlots(int n, int n2, float f) {
        for (int i = 0; i < this.getNumSlots(); ++i) {
            int n3 = this.getSlotY(i);
            if (n3 <= this.contenty - this.getSlotHeight() || n3 >= this.contenty + this.contentheight) continue;
            this.drawSlot(i, this.contentx, n3, n - this.contentx, n2 - n3, this.isSlotSelected(i), f);
        }
    }

    @Override
    public void mouseDragged(int n, int n2, int n3, long l) {
        this.processMouse(n, n2);
    }

    @Override
    public void draw(int n, int n2, float f) {
        this.drawBackground(f);
        this.drawSlotBox(f);
        this.drawSlots(n, n2, f);
        this.drawOverlay(f);
        this.drawScrollBar(f);
    }
}

