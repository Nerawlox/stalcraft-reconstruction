/*
 * Decompiled with CFR 0.152.
 */
package codechicken.nei;

import codechicken.nei.GuiEnchantmentModifier;
import codechicken.nei.NEICPH;
import codechicken.nei.NEIServerUtils;
import java.util.ArrayList;
import net.minecraft.client.xpzm;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.eidj;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

public class ContainerEnchantmentModifier
extends mson {
    public ArrayList<EnchantmentHash> slotEnchantment = new ArrayList();
    int level = 5;
    public int scrollclicky = -1;
    public float scrollpercent;
    public int scrollmousey;
    public float percentscrolled;
    public int relx = 60;
    public int rely = 14;
    public int height = 57;
    public int cwidth = 101;
    public int slotheight = 19;
    public GuiEnchantmentModifier parentscreen;

    public ContainerEnchantmentModifier(eidj eidj2, ozlu ozlu2, int n, int n2, int n3) {
        super(eidj2, ozlu2, n, n2, n3);
    }

    public int getNumSlots() {
        return this.slotEnchantment.size();
    }

    public int getScrollBarHeight() {
        int n = (int)((float)this.height / (float)this.getContentHeight() * (float)this.height);
        if (n > this.height) {
            return this.height;
        }
        if (n < this.height / 15) {
            return this.height / 15;
        }
        return n;
    }

    public int getScrollBarWidth() {
        return 7;
    }

    public int getContentHeight() {
        return this.slotheight * this.getNumSlots();
    }

    public int getScrolledSlots() {
        int n = this.getNumSlots();
        int n2 = this.height / this.slotheight;
        return (int)(this.percentscrolled * (float)(n - n2) + 0.5f);
    }

    private int getClickedSlot(int n) {
        return (n - this.rely) / this.slotheight + this.getScrolledSlots();
    }

    public void calculatePercentScrolled() {
        int n;
        int n2 = this.height - this.getScrollBarHeight();
        if (this.scrollclicky >= 0) {
            n = this.scrollmousey - this.scrollclicky;
            this.percentscrolled = (float)n / (float)n2 + this.scrollpercent;
        }
        if (this.percentscrolled < 0.0f) {
            this.percentscrolled = 0.0f;
        }
        if (this.percentscrolled > 1.0f) {
            this.percentscrolled = 1.0f;
        }
        n = this.rely + (int)((double)((float)n2 * this.percentscrolled) + 0.5);
        this.percentscrolled = (float)(n - this.rely) / (float)n2;
    }

    public boolean clickScrollBar(int n, int n2, int n3) {
        int n4 = this.height - this.getScrollBarHeight();
        int n5 = this.rely + (int)((double)((float)n4 * this.percentscrolled) + 0.5);
        if (n3 == 0 && this.getScrollBarHeight() < this.height && (n -= this.parentscreen.field_74198_m) >= this.relx + this.cwidth && n < this.relx + this.cwidth + this.getScrollBarWidth() && (n2 -= this.parentscreen.field_74197_n) >= this.rely && n2 < this.rely + this.height) {
            if (n2 < n5) {
                this.percentscrolled = (float)(n2 - this.rely) / (float)n4;
                this.calculatePercentScrolled();
            } else if (n2 > n5 + this.getScrollBarHeight()) {
                this.percentscrolled = (float)(n2 - this.rely - this.getScrollBarHeight() + 1) / (float)n4;
                this.calculatePercentScrolled();
            } else {
                this.scrollclicky = n2;
                this.scrollpercent = this.percentscrolled;
                this.scrollmousey = n2;
            }
            return true;
        }
        return false;
    }

    public void mouseUp(int n, int n2, int n3) {
        if (this.scrollclicky >= 0 && n3 == 0) {
            this.scrollclicky = -1;
        }
    }

    public boolean clickButton(int n, int n2, int n3) {
        if ((n -= this.parentscreen.field_74198_m) >= this.relx && n < this.relx + this.cwidth && (n2 -= this.parentscreen.field_74197_n) >= this.rely && n2 <= this.rely + this.height) {
            int n4 = this.getClickedSlot(n2);
            if (n4 >= this.getNumSlots()) {
                return false;
            }
            this.toggleSlotEnchantment(n4);
            return true;
        }
        return false;
    }

    private void toggleSlotEnchantment(int n) {
        EnchantmentHash enchantmentHash = this.slotEnchantment.get(n);
        if (enchantmentHash.state == 2) {
            NEICPH.sendModifyEnchantment(enchantmentHash.enchantment._y, 0, false);
            enchantmentHash.state = 0;
        } else {
            if (enchantmentHash.state == 1) {
                return;
            }
            NEICPH.sendModifyEnchantment(enchantmentHash.enchantment._y, this.level, true);
            enchantmentHash.state = 2;
        }
        this.updateEnchantmentOptions(GuiEnchantmentModifier.validateEnchantments());
    }

    public boolean addEnchantment(int n, int n2) {
        if (n < zhqo._a.length && zhqo._a[n] != null) {
            ((yeso)this.field_75151_b.get(0)).func_75211_c()._a(zhqo._a[n], n2);
            return true;
        }
        return false;
    }

    public void removeEnchantment(int n) {
        cvzo cvzo2 = ((yeso)this.field_75151_b.get(0)).func_75211_c();
        bsyv bsyv2 = cvzo2._r();
        if (bsyv2 != null) {
            for (int i = 0; i < bsyv2._d(); ++i) {
                short s = ((qoac)bsyv2._b(i))._e("id");
                if (s != n) continue;
                bsyv2._a(i);
                if (bsyv2._d() == 0) {
                    cvzo2._q()._p("ench");
                }
                if (cvzo2._q()._e()) {
                    cvzo2._d(null);
                }
                return;
            }
        }
    }

    @Override
    public boolean func_75145_c(EntityPlayer entityPlayer) {
        return true;
    }

    @Override
    public void func_75130_a(mssh mssh2) {
        if (this.parentscreen != null) {
            this.updateEnchantmentOptions(GuiEnchantmentModifier.validateEnchantments());
        }
    }

    public void updateEnchantmentOptions(boolean bl) {
        int n = this.slotEnchantment.size();
        this.slotEnchantment.clear();
        cvzo cvzo2 = this.func_75139_a(0).func_75211_c();
        if (cvzo2 == null) {
            this.percentscrolled = 0.0f;
            return;
        }
        tgdv tgdv2 = cvzo2._a();
        int n2 = tgdv2.func_77619_b();
        if (n2 == 0 && bl) {
            this.percentscrolled = 0.0f;
            return;
        }
        for (zhqo zhqo2 : zhqo._a) {
            if (zhqo2 == null || zhqo2._A == null || !zhqo2._A._a(tgdv2) && bl) continue;
            int n3 = 0;
            int n4 = -1;
            if (NEIServerUtils.stackHasEnchantment(cvzo2, zhqo2._y)) {
                n3 = 2;
                n4 = NEIServerUtils.getEnchantmentLevel(cvzo2, zhqo2._y);
            } else if (NEIServerUtils.doesEnchantmentConflict(NEIServerUtils.getEnchantments(cvzo2), zhqo2) && bl) {
                n3 = 1;
            }
            this.slotEnchantment.add(new EnchantmentHash(zhqo2, n3, n4));
        }
        if (n != this.slotEnchantment.size()) {
            this.percentscrolled = 0.0f;
        }
    }

    public void drawSlots(GuiEnchantmentModifier guiEnchantmentModifier) {
        for (int i = 0; i < 3; ++i) {
            int n = 0;
            String string = "";
            int n2 = i + this.getScrolledSlots();
            if (n2 + 1 > this.slotEnchantment.size()) {
                n = 1;
            } else {
                EnchantmentHash enchantmentHash = this.slotEnchantment.get(n2);
                n = enchantmentHash.state;
                string = enchantmentHash.enchantment._c(enchantmentHash.level == -1 ? this.level : enchantmentHash.level);
                if (guiEnchantmentModifier.field_73882_e._z._b(string) > 95 && string.contains("Projectile")) {
                    string = string.replace("Projectile", "Proj");
                }
                if (guiEnchantmentModifier.field_73882_e._z._b(string) > 95 && string.contains("Protection")) {
                    string = string.replace("Protection", "Protect");
                }
                if (guiEnchantmentModifier.field_73882_e._z._b(string) > 95 && string.contains("Bane of")) {
                    string = string.replace("Bane of ", "");
                }
            }
            xpzm._E()._h._a(new ResourceLocation("textures/gui/container/enchanting_table.png"));
            GL11.glColor3f(1.0f, 1.0f, 1.0f);
            if (this.hasScrollBar()) {
                guiEnchantmentModifier.func_73729_b(this.relx, this.rely + i * this.slotheight, 0, guiEnchantmentModifier.field_74195_c + this.slotheight * n, this.cwidth - 30, this.slotheight);
                guiEnchantmentModifier.func_73729_b(this.relx + this.cwidth - 30, this.rely + i * this.slotheight, this.cwidth - 23, guiEnchantmentModifier.field_74195_c + this.slotheight * n, 30, this.slotheight);
            } else {
                guiEnchantmentModifier.func_73729_b(this.relx, this.rely + i * this.slotheight, 0, guiEnchantmentModifier.field_74195_c + this.slotheight * n, this.cwidth + 7, this.slotheight);
            }
            guiEnchantmentModifier.field_73886_k._b(string, this.relx + 4, this.rely + i * this.slotheight + 5, this.textColourFromState(n));
        }
    }

    private boolean hasScrollBar() {
        return this.getNumSlots() > 3;
    }

    public void drawScrollBar(GuiEnchantmentModifier guiEnchantmentModifier) {
        if (!this.hasScrollBar()) {
            return;
        }
        int n = this.rely + (int)((double)((float)(this.height - this.getScrollBarHeight()) * this.percentscrolled) + 0.5);
        int n2 = this.relx + this.cwidth;
        bawa.func_73734_a(n2, this.rely, n2 + this.getScrollBarWidth(), this.rely + this.height, -14671840);
        bawa.func_73734_a(n2, n, n2 + this.getScrollBarWidth(), n + this.getScrollBarHeight(), -7631989);
        bawa.func_73734_a(n2, n, n2 + this.getScrollBarWidth() - 1, n + this.getScrollBarHeight() - 1, -986896);
        bawa.func_73734_a(n2 + 1, n + 1, n2 + this.getScrollBarWidth() - 1, n + this.getScrollBarHeight() - 1, -11184811);
        bawa.func_73734_a(n2 + 1, n + 1, n2 + this.getScrollBarWidth() - 2, n + this.getScrollBarHeight() - 2, -3750202);
    }

    private int textColourFromState(int n) {
        if (n == 0) {
            return 6839882;
        }
        if (n == 1) {
            return 4226832;
        }
        return 0xFFFF80;
    }

    public void onUpdate(int n, int n2) {
        this.processScrollMouse(n, n2);
    }

    public void processScrollMouse(int n, int n2) {
        n -= this.parentscreen.field_74198_m;
        n2 -= this.parentscreen.field_74197_n;
        if (this.scrollclicky >= 0) {
            int n3 = n2 - this.scrollclicky;
            int n4 = (int)((double)((float)(this.height - this.getScrollBarHeight()) * this.scrollpercent) + 0.5);
            int n5 = this.height - this.getScrollBarHeight() - n4;
            this.scrollmousey = -n3 > n4 ? this.scrollclicky - n4 : (n3 > n5 ? this.scrollclicky + n5 : n2);
            this.calculatePercentScrolled();
        }
    }

    public static class EnchantmentHash {
        zhqo enchantment;
        int state;
        int level;

        public EnchantmentHash(zhqo zhqo2, int n, int n2) {
            this.enchantment = zhqo2;
            this.state = n;
            this.level = n2;
        }
    }
}

