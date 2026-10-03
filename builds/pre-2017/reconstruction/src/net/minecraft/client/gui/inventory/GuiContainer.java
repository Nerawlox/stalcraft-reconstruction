/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.client.gui.inventory;

import codechicken.nei.forge.GuiContainerManager;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import gloomyfolken.mods.asm.GloomyHooks;
import gloomyfolken.mods.stalker.mobs.StalkerMobsHooks;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.renderer.entity.RenderItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.Icon;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.sajh;
import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.GL11;
import znw.mods.stalkerguide.pidb;

@SideOnly(value=Side.CLIENT)
public abstract class GuiContainer
extends GuiScreen {
    protected static final ResourceLocation field_110408_a = new ResourceLocation("textures/gui/container/inventory.png");
    public static RenderItem itemRenderer = new RenderItem();
    public int xSize = 176;
    public int ySize = 166;
    public Container inventorySlots;
    public int guiLeft;
    public int guiTop;
    private Slot theSlot;
    private Slot clickedSlot;
    private boolean isRightMouseClick;
    private ItemStack draggedStack;
    private int field_85049_r;
    private int field_85048_s;
    private Slot returningStackDestSlot;
    private long returningStackTime;
    private ItemStack returningStack;
    private Slot field_92033_y;
    private long field_92032_z;
    protected final Set field_94077_p = new HashSet();
    protected boolean field_94076_q;
    private int field_94071_C;
    private int field_94067_D;
    private boolean field_94068_E;
    private int field_94069_F;
    private long field_94070_G;
    private Slot field_94072_H;
    private int field_94073_I;
    private boolean field_94074_J;
    private ItemStack field_94075_K;
    public GuiContainerManager manager;

    public GuiContainer(Container container) {
        this.inventorySlots = container;
        this.field_94068_E = true;
    }

    @Override
    public void setWorldAndResolution(Minecraft minecraft, int n, int n2) {
        super.setWorldAndResolution(minecraft, n, n2);
        if (minecraft._B == this) {
            this.manager = new GuiContainerManager(this);
            this.manager.load();
        }
    }

    @Override
    public void initGui() {
        super.initGui();
        this.mc._t.openContainer = this.inventorySlots;
        this.guiLeft = (this.width - this.xSize) / 2;
        this.guiTop = (this.height - this.ySize) / 2;
    }

    @Override
    public void drawScreen(int n, int n2, float f) {
        int n3;
        int n4;
        Object object;
        this.manager.preDraw();
        this.drawDefaultBackground();
        int n5 = this.guiLeft;
        int n6 = this.guiTop;
        this.drawGuiContainerBackgroundLayer(f, n, n2);
        GL11.glDisable(32826);
        qnon._a();
        GL11.glDisable(2896);
        GL11.glDisable(2929);
        super.drawScreen(n, n2, f);
        qnon._c();
        GL11.glPushMatrix();
        GL11.glTranslatef(n5, n6, 0.0f);
        GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
        GL11.glEnable(32826);
        this.theSlot = null;
        int n7 = 240;
        int n8 = 240;
        iwya._a(iwya._b, (float)n7 / 1.0f, (float)n8 / 1.0f);
        GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
        boolean bl = this.manager.objectUnderMouse(n, n2);
        for (int i = 0; i < this.inventorySlots.inventorySlots.size(); ++i) {
            object = (Slot)this.inventorySlots.inventorySlots.get(i);
            this.drawSlotInventory((Slot)object);
            if (!this.isMouseOverSlot((Slot)object, n, n2) || !((Slot)object).func_111238_b() || bl) continue;
            this.theSlot = object;
            GL11.glDisable(2896);
            GL11.glDisable(2929);
            n4 = ((Slot)object).xDisplayPosition;
            n3 = ((Slot)object).yDisplayPosition;
            this.drawGradientRect(n4, n3, n4 + 16, n3 + 16, -2130706433, -2130706433);
            GL11.glEnable(2896);
            GL11.glEnable(2929);
        }
        GL11.glDisable(2896);
        this.drawGuiContainerForegroundLayer(n, n2);
        GL11.glEnable(2896);
        GL11.glTranslatef(-n5, -n6, 200.0f);
        this.manager.renderObjects(n, n2);
        GL11.glTranslatef(n5, n6, -200.0f);
        InventoryPlayer inventoryPlayer = this.mc._t.inventory;
        Object object2 = object = this.draggedStack == null ? inventoryPlayer._g() : this.draggedStack;
        if (object != null) {
            n4 = 8;
            n3 = this.draggedStack == null ? 8 : 16;
            String string = null;
            if (this.draggedStack != null && this.isRightMouseClick) {
                object = ((ItemStack)object)._l();
                ((ItemStack)object)._b = sajh._f((float)((ItemStack)object)._b / 2.0f);
            } else if (this.field_94076_q && this.field_94077_p.size() > 1) {
                object = ((ItemStack)object)._l();
                ((ItemStack)object)._b = this.field_94069_F;
                if (((ItemStack)object)._b == 0) {
                    string = "" + (Object)((Object)EnumChatFormatting._o) + "0";
                }
            }
            this.drawItemStack((ItemStack)object, n - n5 - n4, n2 - n6 - n3, string);
        }
        if (this.returningStack != null) {
            float f2 = (float)(Minecraft._M() - this.returningStackTime) / 100.0f;
            if (f2 >= 1.0f) {
                f2 = 1.0f;
                this.returningStack = null;
            }
            n3 = this.returningStackDestSlot.xDisplayPosition - this.field_85049_r;
            int n9 = this.returningStackDestSlot.yDisplayPosition - this.field_85048_s;
            int n10 = this.field_85049_r + (int)((float)n3 * f2);
            int n11 = this.field_85048_s + (int)((float)n9 * f2);
            this.drawItemStack(this.returningStack, n10, n11, null);
        }
        GL11.glPopMatrix();
        this.manager.renderToolTips(n, n2);
        GL11.glEnable(2896);
        GL11.glEnable(2929);
        qnon._b();
        pidb._a(this, n, n2, f);
        StalkerMobsHooks.drawScreen(this, n, n2, f);
    }

    private void drawItemStack(ItemStack itemStack, int n, int n2, String string) {
        GL11.glTranslatef(0.0f, 0.0f, 32.0f);
        this.zLevel = 500.0f;
        GuiContainer.itemRenderer.zLevel = 500.0f;
        FontRenderer fontRenderer = null;
        if (itemStack != null) {
            fontRenderer = itemStack._a().getFontRenderer(itemStack);
        }
        if (fontRenderer == null) {
            fontRenderer = this.fontRenderer;
        }
        itemRenderer.renderItemAndEffectIntoGUI(fontRenderer, this.mc._R(), itemStack, n, n2);
        itemRenderer.renderItemOverlayIntoGUI(fontRenderer, this.mc._R(), itemStack, n, n2 - (this.draggedStack == null ? 0 : 8), string);
        this.zLevel = 0.0f;
        GuiContainer.itemRenderer.zLevel = 0.0f;
    }

    public List<String> handleTooltip(int n, int n2, List<String> list2) {
        return list2;
    }

    public List<String> handleItemTooltip(ItemStack itemStack, int n, int n2, List<String> list2) {
        return list2;
    }

    @Deprecated
    protected void drawItemStackTooltip(ItemStack itemStack, int n, int n2) {
        List list2 = itemStack._a((EntityPlayer)this.mc._t, this.mc._M.advancedItemTooltips);
        for (int i = 0; i < list2.size(); ++i) {
            if (i == 0) {
                list2.set(i, "\u00a7" + Integer.toHexString(itemStack._w()._e) + (String)list2.get(i));
                continue;
            }
            list2.set(i, (Object)((Object)EnumChatFormatting._h) + (String)list2.get(i));
        }
        FontRenderer fontRenderer = itemStack._a().getFontRenderer(itemStack);
        this.drawHoveringText(list2, n, n2, fontRenderer == null ? this.fontRenderer : fontRenderer);
    }

    @Deprecated
    protected void drawCreativeTabHoveringText(String string, int n, int n2) {
        this.func_102021_a(Arrays.asList(string), n, n2);
    }

    @Deprecated
    protected void func_102021_a(List list2, int n, int n2) {
        this.drawHoveringText(list2, n, n2, this.fontRenderer);
    }

    @Deprecated
    protected void drawHoveringText(List list2, int n, int n2, FontRenderer fontRenderer) {
        if (!list2.isEmpty()) {
            int n3;
            GL11.glDisable(32826);
            qnon._a();
            GL11.glDisable(2896);
            GL11.glDisable(2929);
            int n4 = 0;
            for (String string : list2) {
                n3 = fontRenderer._b(string);
                if (n3 <= n4) continue;
                n4 = n3;
            }
            int n5 = n + 12;
            n3 = n2 - 12;
            int n6 = 8;
            if (list2.size() > 1) {
                n6 += 2 + (list2.size() - 1) * 10;
            }
            if (n5 + n4 > this.width) {
                n5 -= 28 + n4;
            }
            if (n3 + n6 + 6 > this.height) {
                n3 = this.height - n6 - 6;
            }
            this.zLevel = 300.0f;
            GuiContainer.itemRenderer.zLevel = 300.0f;
            int n7 = -267386864;
            this.drawGradientRect(n5 - 3, n3 - 4, n5 + n4 + 3, n3 - 3, n7, n7);
            this.drawGradientRect(n5 - 3, n3 + n6 + 3, n5 + n4 + 3, n3 + n6 + 4, n7, n7);
            this.drawGradientRect(n5 - 3, n3 - 3, n5 + n4 + 3, n3 + n6 + 3, n7, n7);
            this.drawGradientRect(n5 - 4, n3 - 3, n5 - 3, n3 + n6 + 3, n7, n7);
            this.drawGradientRect(n5 + n4 + 3, n3 - 3, n5 + n4 + 4, n3 + n6 + 3, n7, n7);
            int n8 = 0x505000FF;
            int n9 = (n8 & 0xFEFEFE) >> 1 | n8 & 0xFF000000;
            this.drawGradientRect(n5 - 3, n3 - 3 + 1, n5 - 3 + 1, n3 + n6 + 3 - 1, n8, n9);
            this.drawGradientRect(n5 + n4 + 2, n3 - 3 + 1, n5 + n4 + 3, n3 + n6 + 3 - 1, n8, n9);
            this.drawGradientRect(n5 - 3, n3 - 3, n5 + n4 + 3, n3 - 3 + 1, n8, n8);
            this.drawGradientRect(n5 - 3, n3 + n6 + 2, n5 + n4 + 3, n3 + n6 + 3, n9, n9);
            for (int i = 0; i < list2.size(); ++i) {
                String string = (String)list2.get(i);
                fontRenderer._a(string, n5, n3, -1);
                if (i == 0) {
                    n3 += 2;
                }
                n3 += 10;
            }
            this.zLevel = 0.0f;
            GuiContainer.itemRenderer.zLevel = 0.0f;
            GL11.glEnable(2896);
            GL11.glEnable(2929);
            qnon._b();
            GL11.glEnable(32826);
        }
    }

    protected void drawGuiContainerForegroundLayer(int n, int n2) {
    }

    protected abstract void drawGuiContainerBackgroundLayer(float var1, int var2, int var3);

    protected void drawSlotInventory(Slot slot) {
        Icon icon;
        if (GloomyHooks.shouldNotRenderSlot(this, slot)) {
            return;
        }
        int n = slot.xDisplayPosition;
        int n2 = slot.yDisplayPosition;
        ItemStack itemStack = slot.getStack();
        boolean bl = false;
        boolean bl2 = slot == this.clickedSlot && this.draggedStack != null && !this.isRightMouseClick;
        ItemStack itemStack2 = this.mc._t.inventory._g();
        String string = null;
        if (slot == this.clickedSlot && this.draggedStack != null && this.isRightMouseClick && itemStack != null) {
            itemStack = itemStack._l();
            itemStack._b /= 2;
        } else if (this.field_94076_q && this.field_94077_p.contains(slot) && itemStack2 != null) {
            if (this.field_94077_p.size() == 1) {
                return;
            }
            if (Container.func_94527_a(slot, itemStack2, true) && this.inventorySlots.canDragIntoSlot(slot)) {
                itemStack = itemStack2._l();
                bl = true;
                Container.func_94525_a(this.field_94077_p, this.field_94071_C, itemStack, slot.getStack() == null ? 0 : slot.getStack()._b);
                if (itemStack._b > itemStack._d()) {
                    string = (Object)((Object)EnumChatFormatting._o) + "" + itemStack._d();
                    itemStack._b = itemStack._d();
                }
                if (itemStack._b > slot.getSlotStackLimit()) {
                    string = (Object)((Object)EnumChatFormatting._o) + "" + slot.getSlotStackLimit();
                    itemStack._b = slot.getSlotStackLimit();
                }
            } else {
                this.field_94077_p.remove(slot);
                this.func_94066_g();
            }
        }
        this.zLevel = 100.0f;
        GuiContainer.itemRenderer.zLevel = 100.0f;
        if (itemStack == null && (icon = slot.getBackgroundIconIndex()) != null) {
            GL11.glDisable(2896);
            this.mc._R()._a(sctd._e);
            this.drawTexturedModelRectFromIcon(n, n2, icon, 16, 16);
            GL11.glEnable(2896);
            bl2 = true;
        }
        if (!bl2) {
            if (bl) {
                GuiContainer.drawRect(n, n2, n + 16, n2 + 16, -2130706433);
            }
            this.manager.renderSlotUnderlay(slot);
            GL11.glEnable(2929);
            this.drawSlotItem(slot, itemStack, n, n2, string);
            this.manager.renderSlotOverlay(slot);
        }
        GuiContainer.itemRenderer.zLevel = 0.0f;
        this.zLevel = 0.0f;
    }

    public void drawSlotItem(Slot slot, ItemStack itemStack, int n, int n2, String string) {
        itemRenderer.renderItemAndEffectIntoGUI(this.fontRenderer, this.mc._R(), itemStack, n, n2);
        itemRenderer.renderItemOverlayIntoGUI(this.fontRenderer, this.mc._R(), itemStack, n, n2, string);
    }

    private void func_94066_g() {
        ItemStack itemStack = this.mc._t.inventory._g();
        if (itemStack != null && this.field_94076_q) {
            this.field_94069_F = itemStack._b;
            for (Slot slot : this.field_94077_p) {
                ItemStack itemStack2 = itemStack._l();
                int n = slot.getStack() == null ? 0 : slot.getStack()._b;
                Container.func_94525_a(this.field_94077_p, this.field_94071_C, itemStack2, n);
                if (itemStack2._b > itemStack2._d()) {
                    itemStack2._b = itemStack2._d();
                }
                if (itemStack2._b > slot.getSlotStackLimit()) {
                    itemStack2._b = slot.getSlotStackLimit();
                }
                this.field_94069_F -= itemStack2._b - n;
            }
        }
    }

    public Slot getSlotAtPosition(int n, int n2) {
        for (int i = 0; i < this.inventorySlots.inventorySlots.size(); ++i) {
            Slot slot = (Slot)this.inventorySlots.inventorySlots.get(i);
            if (!this.isMouseOverSlot(slot, n, n2)) continue;
            return slot;
        }
        return null;
    }

    @Override
    protected void mouseClicked(int n, int n2, int n3) {
        super.mouseClicked(n, n2, n3);
        this.field_94068_E = true;
        if (this.manager.mouseClicked(n, n2, n3)) {
            return;
        }
        boolean bl = n3 == this.mc._M.keyBindPickBlock._d + 100;
        Slot slot = this.getSlotAtPosition(n, n2);
        long l = Minecraft._M();
        this.field_94074_J = this.field_94072_H == slot && l - this.field_94070_G < 250L && this.field_94073_I == n3;
        this.field_94068_E = false;
        if (n3 == 0 || n3 == 1 || bl) {
            int n4 = this.guiLeft;
            int n5 = this.guiTop;
            boolean bl2 = (n < n4 || n2 < n5 || n >= n4 + this.xSize || n2 >= n5 + this.ySize) && slot == null;
            int n6 = -1;
            if (slot != null) {
                n6 = slot.slotNumber;
            }
            if (bl2) {
                n6 = -999;
            }
            if (this.mc._M.touchscreen && bl2 && this.mc._t.inventory._g() == null) {
                this.mc._a((GuiScreen)null);
                return;
            }
            if (n6 != -1) {
                if (this.mc._M.touchscreen) {
                    if (slot != null && slot.getHasStack()) {
                        this.clickedSlot = slot;
                        this.draggedStack = null;
                        this.isRightMouseClick = n3 == 1;
                    } else {
                        this.clickedSlot = null;
                    }
                } else if (!this.field_94076_q) {
                    if (this.mc._t.inventory._g() == null) {
                        if (n3 == this.mc._M.keyBindPickBlock._d + 100) {
                            this.manager.handleMouseClick(slot, n6, n3, 3);
                        } else {
                            boolean bl3 = n6 != -999 && (Keyboard.isKeyDown(42) || Keyboard.isKeyDown(54));
                            int n7 = 0;
                            if (bl3) {
                                this.field_94075_K = slot != null && slot.getHasStack() ? slot.getStack() : null;
                                n7 = 1;
                            } else if (n6 == -999) {
                                n7 = 4;
                            }
                            this.manager.handleMouseClick(slot, n6, n3, n7);
                        }
                        this.field_94068_E = true;
                    } else {
                        this.field_94076_q = true;
                        this.field_94067_D = n3;
                        this.field_94077_p.clear();
                        if (n3 == 0) {
                            this.field_94071_C = 0;
                        } else if (n3 == 1) {
                            this.field_94071_C = 1;
                        }
                    }
                }
            }
        }
        this.field_94072_H = slot;
        this.field_94070_G = l;
        this.field_94073_I = n3;
    }

    @Override
    protected void mouseClickMove(int n, int n2, int n3, long l) {
        Slot slot = this.getSlotAtPosition(n, n2);
        ItemStack itemStack = this.mc._t.inventory._g();
        this.manager.mouseDragged(n, n2, n3, l);
        if (this.clickedSlot != null && this.mc._M.touchscreen) {
            if (n3 == 0 || n3 == 1) {
                if (this.draggedStack == null) {
                    if (slot != this.clickedSlot) {
                        this.draggedStack = this.clickedSlot.getStack()._l();
                    }
                } else if (this.draggedStack._b > 1 && slot != null && Container.func_94527_a(slot, this.draggedStack, false)) {
                    long l2 = Minecraft._M();
                    if (this.field_92033_y == slot) {
                        if (l2 - this.field_92032_z > 500L) {
                            this.handleMouseClick(this.clickedSlot, this.clickedSlot.slotNumber, 0, 0);
                            this.handleMouseClick(slot, slot.slotNumber, 1, 0);
                            this.handleMouseClick(this.clickedSlot, this.clickedSlot.slotNumber, 0, 0);
                            this.field_92032_z = l2 + 750L;
                            --this.draggedStack._b;
                        }
                    } else {
                        this.field_92033_y = slot;
                        this.field_92032_z = l2;
                    }
                }
            }
        } else if (this.field_94076_q && slot != null && itemStack != null && itemStack._b > this.field_94077_p.size() && Container.func_94527_a(slot, itemStack, true) && slot.isItemValid(itemStack) && this.inventorySlots.canDragIntoSlot(slot)) {
            this.field_94077_p.add(slot);
            this.func_94066_g();
        }
    }

    @Override
    protected void mouseMovedOrUp(int n, int n2, int n3) {
        Slot slot = this.getSlotAtPosition(n, n2);
        int n4 = this.guiLeft;
        int n5 = this.guiTop;
        boolean bl = n < n4 || n2 < n5 || n >= n4 + this.xSize || n2 >= n5 + this.ySize;
        int n6 = -1;
        if (slot != null) {
            n6 = slot.slotNumber;
        }
        if (bl) {
            n6 = -999;
        }
        if (this.field_94074_J && slot != null && n3 == 0 && this.inventorySlots.func_94530_a(null, slot)) {
            if (GuiContainer.isShiftKeyDown()) {
                if (slot != null && slot.inventory != null && this.field_94075_K != null) {
                    for (Slot slot2 : this.inventorySlots.inventorySlots) {
                        if (slot2 == null || !slot2.canTakeStack(this.mc._t) || !slot2.getHasStack() || slot2.inventory != slot.inventory || !Container.func_94527_a(slot2, this.field_94075_K, true)) continue;
                        this.handleMouseClick(slot2, slot2.slotNumber, n3, 1);
                    }
                }
            } else {
                this.handleMouseClick(slot, n6, n3, 6);
            }
            this.field_94074_J = false;
            this.field_94070_G = 0L;
        } else {
            if (this.field_94076_q && this.field_94067_D != n3) {
                this.field_94076_q = false;
                this.field_94077_p.clear();
                this.field_94068_E = true;
                return;
            }
            if (this.field_94068_E) {
                this.manager.mouseUp(n, n2, n3);
                this.field_94068_E = false;
                return;
            }
            if (this.clickedSlot != null && this.mc._M.touchscreen) {
                if (n3 == 0 || n3 == 1) {
                    if (this.draggedStack == null && slot != this.clickedSlot) {
                        this.draggedStack = this.clickedSlot.getStack();
                    }
                    boolean bl2 = Container.func_94527_a(slot, this.draggedStack, false);
                    if (n6 != -1 && this.draggedStack != null && bl2) {
                        this.handleMouseClick(this.clickedSlot, this.clickedSlot.slotNumber, n3, 0);
                        this.handleMouseClick(slot, n6, 0, 0);
                        if (this.mc._t.inventory._g() != null) {
                            this.handleMouseClick(this.clickedSlot, this.clickedSlot.slotNumber, n3, 0);
                            this.field_85049_r = n - n4;
                            this.field_85048_s = n2 - n5;
                            this.returningStackDestSlot = this.clickedSlot;
                            this.returningStack = this.draggedStack;
                            this.returningStackTime = Minecraft._M();
                        } else {
                            this.returningStack = null;
                        }
                    } else if (this.draggedStack != null) {
                        this.field_85049_r = n - n4;
                        this.field_85048_s = n2 - n5;
                        this.returningStackDestSlot = this.clickedSlot;
                        this.returningStack = this.draggedStack;
                        this.returningStackTime = Minecraft._M();
                    }
                    this.draggedStack = null;
                    this.clickedSlot = null;
                }
            } else if (this.field_94076_q && !this.field_94077_p.isEmpty()) {
                this.handleMouseClick(null, -999, Container.func_94534_d(0, this.field_94071_C), 5);
                for (Slot slot3 : this.field_94077_p) {
                    this.handleMouseClick(slot3, slot3.slotNumber, Container.func_94534_d(1, this.field_94071_C), 5);
                }
                this.handleMouseClick(null, -999, Container.func_94534_d(2, this.field_94071_C), 5);
            } else if (this.mc._t.inventory._g() != null) {
                if (n3 == this.mc._M.keyBindPickBlock._d + 100) {
                    this.handleMouseClick(slot, n6, n3, 3);
                } else {
                    boolean bl3;
                    boolean bl4 = bl3 = n6 != -999 && (Keyboard.isKeyDown(42) || Keyboard.isKeyDown(54));
                    if (bl3) {
                        this.field_94075_K = slot != null && slot.getHasStack() ? slot.getStack() : null;
                    }
                    this.handleMouseClick(slot, n6, n3, bl3 ? 1 : 0);
                }
            } else if (n3 >= 0) {
                this.manager.mouseUp(n, n2, n3);
            }
        }
        if (this.mc._t.inventory._g() == null) {
            this.field_94070_G = 0L;
        }
        this.field_94076_q = false;
    }

    protected boolean isMouseOverSlot(Slot slot, int n, int n2) {
        return this.isPointInRegion(slot.xDisplayPosition, slot.yDisplayPosition, 16, 16, n, n2);
    }

    public boolean isPointInRegion(int n, int n2, int n3, int n4, int n5, int n6) {
        int n7 = this.guiLeft;
        int n8 = this.guiTop;
        return (n5 -= n7) >= n - 1 && n5 < n + n3 + 1 && (n6 -= n8) >= n2 - 1 && n6 < n2 + n4 + 1;
    }

    protected void handleMouseClick(Slot slot, int n, int n2, int n3) {
        if (slot != null) {
            n = slot.slotNumber;
        }
        if (n == -1) {
            return;
        }
        if (this.isClientOnly()) {
            this.mc._t.openContainer.slotClick(n, n2, n3, this.mc._t);
        } else {
            this.mc._j._a(this.inventorySlots.windowId, n, n2, n3, this.mc._t);
        }
    }

    public void sendMouseClick(Slot slot, int n, int n2, int n3) {
        this.handleMouseClick(slot, n, n2, n3);
    }

    public boolean isClientOnly() {
        return false;
    }

    @Override
    protected void keyTyped(char c, int n) {
        if (n == 1) {
            this.mc._t.closeScreen();
            return;
        }
        if (this.manager.lastKeyTyped(n, c)) {
            return;
        }
        this.checkHotbarKeys(n);
        if (this.theSlot != null && this.theSlot.getHasStack()) {
            if (n == this.mc._M.keyBindPickBlock._d) {
                this.handleMouseClick(this.theSlot, this.theSlot.slotNumber, 0, 3);
            } else if (n == this.mc._M.keyBindDrop._d) {
                this.handleMouseClick(this.theSlot, this.theSlot.slotNumber, GuiContainer.isCtrlKeyDown() ? 1 : 0, 4);
            }
        }
        if (n == this.mc._M.keyBindInventory._d) {
            this.mc._t.closeScreen();
            return;
        }
    }

    protected boolean checkHotbarKeys(int n) {
        if (this.mc._t.inventory._g() == null && this.theSlot != null) {
            for (int i = 0; i < 9; ++i) {
                if (n != 2 + i) continue;
                this.handleMouseClick(this.theSlot, this.theSlot.slotNumber, i, 2);
                return true;
            }
        }
        return false;
    }

    @Override
    public void onGuiClosed() {
        if (this.mc._t != null) {
            this.inventorySlots.onContainerClosed(this.mc._t);
        }
    }

    @Override
    public boolean doesGuiPauseGame() {
        return false;
    }

    @Override
    public void updateScreen() {
        super.updateScreen();
        this.manager.guiTick();
        if (!this.mc._t.isEntityAlive() || this.mc._t.isDead) {
            this.mc._t.closeScreen();
        }
    }

    public void keyPress(int n, char c) {
        if (n == 87) {
            this.mc._r();
            return;
        }
        if (this.manager.firstKeyTyped(n, c)) {
            return;
        }
        this.keyTyped(c, n);
    }

    @Override
    public void handleKeyboardInput() {
        this.manager.fixhandleKeyboardInput();
    }

    @Override
    public void handleMouseInput() {
        super.handleMouseInput();
        int n = Mouse.getEventDWheel();
        if (n != 0) {
            int n2 = n = n > 0 ? 1 : -1;
            if (!this.manager.mouseScrolled(n)) {
                // empty if block
            }
            this.mouseScrolled(n);
        }
    }

    public void mouseScrolled(int n) {
    }

    public void refresh() {
        this.manager.refresh();
    }
}

