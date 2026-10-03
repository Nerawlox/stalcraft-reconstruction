/*
 * Decompiled with CFR 0.152.
 */
package codechicken.nei;

import codechicken.nei.GuiEnchantmentModifier;
import codechicken.nei.NEICPH;
import codechicken.nei.NEIServerUtils;
import java.util.ArrayList;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.ContainerEnchantment;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import org.lwjgl.opengl.GL11;

public class ContainerEnchantmentModifier
extends ContainerEnchantment {
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

    public ContainerEnchantmentModifier(InventoryPlayer inventoryPlayer, World world, int n, int n2, int n3) {
        super(inventoryPlayer, world, n, n2, n3);
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
        if (n3 == 0 && this.getScrollBarHeight() < this.height && (n -= this.parentscreen.guiLeft) >= this.relx + this.cwidth && n < this.relx + this.cwidth + this.getScrollBarWidth() && (n2 -= this.parentscreen.guiTop) >= this.rely && n2 < this.rely + this.height) {
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
        if ((n -= this.parentscreen.guiLeft) >= this.relx && n < this.relx + this.cwidth && (n2 -= this.parentscreen.guiTop) >= this.rely && n2 <= this.rely + this.height) {
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
        if (n < Enchantment._a.length && Enchantment._a[n] != null) {
            ((Slot)this.inventorySlots.get(0)).getStack()._a(Enchantment._a[n], n2);
            return true;
        }
        return false;
    }

    public void removeEnchantment(int n) {
        ItemStack itemStack = ((Slot)this.inventorySlots.get(0)).getStack();
        NBTTagList nBTTagList = itemStack._r();
        if (nBTTagList != null) {
            for (int i = 0; i < nBTTagList._d(); ++i) {
                short s = ((NBTTagCompound)nBTTagList._b(i))._e("id");
                if (s != n) continue;
                nBTTagList._a(i);
                if (nBTTagList._d() == 0) {
                    itemStack._q()._p("ench");
                }
                if (itemStack._q()._e()) {
                    itemStack._d(null);
                }
                return;
            }
        }
    }

    @Override
    public boolean canInteractWith(EntityPlayer entityPlayer) {
        return true;
    }

    @Override
    public void onCraftMatrixChanged(IInventory iInventory) {
        if (this.parentscreen != null) {
            this.updateEnchantmentOptions(GuiEnchantmentModifier.validateEnchantments());
        }
    }

    public void updateEnchantmentOptions(boolean bl) {
        int n = this.slotEnchantment.size();
        this.slotEnchantment.clear();
        ItemStack itemStack = this.getSlot(0).getStack();
        if (itemStack == null) {
            this.percentscrolled = 0.0f;
            return;
        }
        Item item = itemStack._a();
        int n2 = item.getItemEnchantability();
        if (n2 == 0 && bl) {
            this.percentscrolled = 0.0f;
            return;
        }
        for (Enchantment enchantment : Enchantment._a) {
            if (enchantment == null || enchantment._A == null || !enchantment._A._a(item) && bl) continue;
            int n3 = 0;
            int n4 = -1;
            if (NEIServerUtils.stackHasEnchantment(itemStack, enchantment._y)) {
                n3 = 2;
                n4 = NEIServerUtils.getEnchantmentLevel(itemStack, enchantment._y);
            } else if (NEIServerUtils.doesEnchantmentConflict(NEIServerUtils.getEnchantments(itemStack), enchantment) && bl) {
                n3 = 1;
            }
            this.slotEnchantment.add(new EnchantmentHash(enchantment, n3, n4));
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
                if (guiEnchantmentModifier.mc._z._b(string) > 95 && string.contains("Projectile")) {
                    string = string.replace("Projectile", "Proj");
                }
                if (guiEnchantmentModifier.mc._z._b(string) > 95 && string.contains("Protection")) {
                    string = string.replace("Protection", "Protect");
                }
                if (guiEnchantmentModifier.mc._z._b(string) > 95 && string.contains("Bane of")) {
                    string = string.replace("Bane of ", "");
                }
            }
            Minecraft._E()._h._a(new ResourceLocation("textures/gui/container/enchanting_table.png"));
            GL11.glColor3f(1.0f, 1.0f, 1.0f);
            if (this.hasScrollBar()) {
                guiEnchantmentModifier.drawTexturedModalRect(this.relx, this.rely + i * this.slotheight, 0, guiEnchantmentModifier.ySize + this.slotheight * n, this.cwidth - 30, this.slotheight);
                guiEnchantmentModifier.drawTexturedModalRect(this.relx + this.cwidth - 30, this.rely + i * this.slotheight, this.cwidth - 23, guiEnchantmentModifier.ySize + this.slotheight * n, 30, this.slotheight);
            } else {
                guiEnchantmentModifier.drawTexturedModalRect(this.relx, this.rely + i * this.slotheight, 0, guiEnchantmentModifier.ySize + this.slotheight * n, this.cwidth + 7, this.slotheight);
            }
            guiEnchantmentModifier.fontRenderer._b(string, this.relx + 4, this.rely + i * this.slotheight + 5, this.textColourFromState(n));
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
        Gui.drawRect(n2, this.rely, n2 + this.getScrollBarWidth(), this.rely + this.height, -14671840);
        Gui.drawRect(n2, n, n2 + this.getScrollBarWidth(), n + this.getScrollBarHeight(), -7631989);
        Gui.drawRect(n2, n, n2 + this.getScrollBarWidth() - 1, n + this.getScrollBarHeight() - 1, -986896);
        Gui.drawRect(n2 + 1, n + 1, n2 + this.getScrollBarWidth() - 1, n + this.getScrollBarHeight() - 1, -11184811);
        Gui.drawRect(n2 + 1, n + 1, n2 + this.getScrollBarWidth() - 2, n + this.getScrollBarHeight() - 2, -3750202);
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
        n -= this.parentscreen.guiLeft;
        n2 -= this.parentscreen.guiTop;
        if (this.scrollclicky >= 0) {
            int n3 = n2 - this.scrollclicky;
            int n4 = (int)((double)((float)(this.height - this.getScrollBarHeight()) * this.scrollpercent) + 0.5);
            int n5 = this.height - this.getScrollBarHeight() - n4;
            this.scrollmousey = -n3 > n4 ? this.scrollclicky - n4 : (n3 > n5 ? this.scrollclicky + n5 : n2);
            this.calculatePercentScrolled();
        }
    }

    public static class EnchantmentHash {
        Enchantment enchantment;
        int state;
        int level;

        public EnchantmentHash(Enchantment enchantment, int n, int n2) {
            this.enchantment = enchantment;
            this.state = n;
            this.level = n2;
        }
    }
}

