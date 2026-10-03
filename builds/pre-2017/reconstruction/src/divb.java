/*
 * Decompiled with CFR 0.152.
 */
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.Icon;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.sajh;
import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.GL11;

public abstract class divb
extends GuiContainer {
    protected static final ResourceLocation __ac = new ResourceLocation("textures/gui/container/inventory.png");
    protected int __ad = 176;
    protected int __ae = 166;
    public Container __af;
    protected int __ag;
    protected int __ah;
    protected Slot __ai;
    protected Slot __aj;
    protected boolean __ak;
    protected ItemStack __al;
    protected Slot __am;
    protected long __an;
    protected int __ao;
    protected int __ap;
    protected final Set<Slot> __aq = new HashSet<Slot>();
    protected ItemStack __ar;
    protected ItemStack __as;
    protected Slot __at;
    protected Slot __au;
    protected boolean __av;
    protected boolean __aw;
    protected boolean __ax;
    protected long __ay;
    protected long __az;
    protected int __aA;
    protected int __aB;
    protected int __aC;
    protected int __aD;
    protected ArrayList<Rectangle> __aE;
    protected boolean __aF = true;
    protected boolean __aG = true;
    protected boolean[] __aH;

    public divb(Container container) {
        super(container);
        this.__af = container;
        this.__aw = true;
        this.__aE = new ArrayList();
        this.mc = Minecraft._E();
        this.__aH = new boolean[100];
    }

    @Override
    public void initGui() {
        this.mc._t.openContainer = this.__af;
        this.__ag = (this.width - this.__ad) / 2;
        this.__ah = (this.height - this.__ae) / 2;
    }

    @Override
    public void drawScreen(int n, int n2, float f) {
        int n3;
        ItemStack itemStack;
        this.drawDefaultBackground();
        int n4 = this.__ag;
        int n5 = this.__ah;
        this.drawGuiContainerBackgroundLayer(f, n, n2);
        GL11.glDisable(32826);
        qnon._a();
        GL11.glDisable(2896);
        GL11.glDisable(2929);
        qnon._c();
        GL11.glPushMatrix();
        GL11.glTranslatef(n4, n5, 0.0f);
        GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
        GL11.glEnable(32826);
        this.__ai = null;
        int n6 = 240;
        int n7 = 240;
        iwya._a(iwya._b, (float)n6 / 1.0f, (float)n7 / 1.0f);
        GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
        GL11.glDisable(2896);
        this.drawGuiContainerForegroundLayer(n, n2);
        GL11.glEnable(2896);
        InventoryPlayer inventoryPlayer = this.mc._t.inventory;
        ItemStack itemStack2 = itemStack = this.__al == null ? inventoryPlayer._g() : this.__al;
        if (itemStack != null) {
            n3 = this.__al == null ? 8 : 16;
            String string = null;
            if (this.__al != null && this.__ak) {
                itemStack = itemStack._l();
                itemStack._b = sajh._f((float)itemStack._b / 2.0f);
            } else if (this.__av && this.__aq.size() > 1) {
                itemStack = itemStack._l();
                itemStack._b = this.__aC;
                if (itemStack._b == 0) {
                    string = "" + (Object)((Object)EnumChatFormatting._o) + "0";
                }
            }
            this._a(itemStack, n - n4 - 8, n2 - n5 - n3, string);
        }
        if (this.__ar != null) {
            float f2 = (float)(Minecraft._M() - this.__an) / 100.0f;
            if (f2 >= 1.0f) {
                f2 = 1.0f;
                this.__ar = null;
            }
            n3 = this.__am.xDisplayPosition - this.__ao;
            int n8 = this.__am.yDisplayPosition - this.__ap;
            int n9 = this.__ao + (int)((float)n3 * f2);
            int n10 = this.__ap + (int)((float)n8 * f2);
            this._a(this.__ar, n9, n10, null);
        }
        GL11.glPopMatrix();
        if (inventoryPlayer._g() == null && this.__ai != null && this.__ai.getHasStack()) {
            ItemStack itemStack3 = this.__ai.getStack();
            this.drawItemStackTooltip(itemStack3, n, n2);
        }
        GL11.glEnable(2896);
        GL11.glEnable(2929);
        qnon._b();
    }

    @Override
    public void drawItemStackTooltip(ItemStack itemStack, int n, int n2) {
        super.drawItemStackTooltip(itemStack, n, n2);
    }

    @Override
    public void drawGradientRect(int n, int n2, int n3, int n4, int n5, int n6) {
        super.drawGradientRect(n, n2, n3, n4, n5, n6);
    }

    protected void _a(ItemStack itemStack, int n, int n2, String string) {
        GL11.glTranslatef(0.0f, 0.0f, 32.0f);
        this.zLevel = 200.0f;
        GuiContainer.itemRenderer.zLevel = 200.0f;
        FontRenderer fontRenderer = null;
        if (itemStack != null) {
            fontRenderer = itemStack._a().getFontRenderer(itemStack);
        }
        if (fontRenderer == null) {
            fontRenderer = this.fontRenderer;
        }
        GuiContainer.itemRenderer.renderItemAndEffectIntoGUI(fontRenderer, this.mc._R(), itemStack, n, n2);
        GuiContainer.itemRenderer.renderItemOverlayIntoGUI(fontRenderer, this.mc._R(), itemStack, n, n2 - (this.__al == null ? 0 : 8), string);
        this.zLevel = 0.0f;
        GuiContainer.itemRenderer.zLevel = 0.0f;
    }

    @Override
    protected void drawGuiContainerForegroundLayer(int n, int n2) {
    }

    @Override
    protected abstract void drawGuiContainerBackgroundLayer(float var1, int var2, int var3);

    protected void _a(Slot slot) {
        Icon icon;
        int n = slot.xDisplayPosition;
        int n2 = slot.yDisplayPosition;
        ItemStack itemStack = slot.getStack();
        boolean bl = false;
        boolean bl2 = slot == this.__aj && this.__al != null && !this.__ak;
        ItemStack itemStack2 = this.mc._t.inventory._g();
        String string = null;
        if (slot == this.__aj && this.__al != null && this.__ak && itemStack != null) {
            itemStack = itemStack._l();
            itemStack._b /= 2;
        } else if (this.__av && this.__aq.contains(slot) && itemStack2 != null) {
            if (this.__aq.size() == 1) {
                return;
            }
            if (Container.func_94527_a(slot, itemStack2, true) && this.__af.canDragIntoSlot(slot)) {
                itemStack = itemStack2._l();
                bl = true;
                Container.func_94525_a(this.__aq, this.__aA, itemStack, slot.getStack() == null ? 0 : slot.getStack()._b);
                if (itemStack._b > itemStack._d()) {
                    string = (Object)((Object)EnumChatFormatting._o) + "" + itemStack._d();
                    itemStack._b = itemStack._d();
                }
                if (itemStack._b > slot.getSlotStackLimit()) {
                    string = (Object)((Object)EnumChatFormatting._o) + "" + slot.getSlotStackLimit();
                    itemStack._b = slot.getSlotStackLimit();
                }
            } else {
                this.__aq.remove(slot);
                this._h();
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
                divb.drawRect(n, n2, n + 16, n2 + 16, -2130706433);
            }
            GL11.glEnable(2929);
            GuiContainer.itemRenderer.renderItemAndEffectIntoGUI(this.fontRenderer, this.mc._R(), itemStack, n, n2);
            GuiContainer.itemRenderer.renderItemOverlayIntoGUI(this.fontRenderer, this.mc._R(), itemStack, n, n2, string);
        }
        GuiContainer.itemRenderer.zLevel = 0.0f;
        this.zLevel = 0.0f;
    }

    protected void _h() {
        ItemStack itemStack = this.mc._t.inventory._g();
        if (itemStack != null && this.__av) {
            this.__aC = itemStack._b;
            for (Slot slot : this.__aq) {
                ItemStack itemStack2 = itemStack._l();
                int n = slot.getStack() == null ? 0 : slot.getStack()._b;
                Container.func_94525_a(this.__aq, this.__aA, itemStack2, n);
                if (itemStack2._b > itemStack2._d()) {
                    itemStack2._b = itemStack2._d();
                }
                if (itemStack2._b > slot.getSlotStackLimit()) {
                    itemStack2._b = slot.getSlotStackLimit();
                }
                this.__aC -= itemStack2._b - n;
            }
        }
    }

    @Override
    public Slot getSlotAtPosition(int n, int n2) {
        for (int i = 0; i < this.__af.inventorySlots.size(); ++i) {
            Slot slot = (Slot)this.__af.inventorySlots.get(i);
            if (!this.isMouseOverSlot(slot, n, n2) || !this.__aG || this.__aH[i]) continue;
            return slot;
        }
        return null;
    }

    public void _a(Slot slot, int n, int n2, int n3) {
    }

    public boolean _a(int n, int n2, int n3) {
        boolean bl = n3 == this.mc._M.keyBindPickBlock._d + 100;
        Slot slot = this.getSlotAtPosition(n, n2);
        long l = Minecraft._M();
        this.__ax = this.__au == slot && l - this.__az < 250L && this.__aD == n3;
        this.__aw = false;
        if (slot != null) {
            this._a(slot, n, n2, n3);
        }
        if (slot instanceof ukeo) {
            return true;
        }
        if (n3 == 0 || n3 == 1 || bl) {
            int n4 = this.__ag;
            int n5 = this.__ah;
            boolean bl2 = n < n4 || n2 < n5 || n >= n4 + this.__ad || n2 >= n5 + this.__ae;
            for (Rectangle rectangle : this.__aE) {
                bl2 &= !rectangle.contains(n, n2);
            }
            int n6 = -1;
            if (slot != null) {
                n6 = slot.slotNumber;
            }
            if (bl2 && slot == null) {
                n6 = -999;
            }
            if (this.mc._M.touchscreen && bl2 && this.mc._t.inventory._g() == null) {
                this.mc._a((GuiScreen)null);
                return false;
            }
            if (n6 != -1) {
                if (this.mc._M.touchscreen) {
                    if (slot != null && slot.getHasStack()) {
                        this.__aj = slot;
                        this.__al = null;
                        this.__ak = n3 == 1;
                    } else {
                        this.__aj = null;
                    }
                } else if (!this.__av) {
                    if (this.mc._t.inventory._g() == null) {
                        if (n3 == this.mc._M.keyBindPickBlock._d + 100) {
                            this.handleMouseClick(slot, n6, n3, 3);
                        } else {
                            boolean bl3 = n6 != -999 && (Keyboard.isKeyDown(42) || Keyboard.isKeyDown(54));
                            int n7 = 0;
                            if (bl3) {
                                this.__as = slot != null && slot.getHasStack() ? slot.getStack() : null;
                                n7 = 1;
                            } else if (n6 == -999) {
                                n7 = 4;
                            }
                            this.handleMouseClick(slot, n6, n3, n7);
                        }
                        this.__aw = true;
                    } else {
                        this.__av = true;
                        this.__aB = n3;
                        this.__aq.clear();
                        if (n3 == 0) {
                            this.__aA = 0;
                        } else if (n3 == 1) {
                            this.__aA = 1;
                        }
                    }
                }
            }
        }
        this.__au = slot;
        this.__az = l;
        this.__aD = n3;
        return slot != null;
    }

    @Override
    protected void mouseClickMove(int n, int n2, int n3, long l) {
        Slot slot = this.getSlotAtPosition(n, n2);
        ItemStack itemStack = this.mc._t.inventory._g();
        if (this.__aj != null && this.mc._M.touchscreen) {
            if (n3 == 0 || n3 == 1) {
                if (this.__al == null) {
                    if (slot != this.__aj) {
                        this.__al = this.__aj.getStack()._l();
                    }
                } else if (this.__al._b > 1 && slot != null && Container.func_94527_a(slot, this.__al, false)) {
                    long l2 = Minecraft._M();
                    if (this.__at == slot) {
                        if (l2 - this.__ay > 500L) {
                            this.handleMouseClick(this.__aj, this.__aj.slotNumber, 0, 0);
                            this.handleMouseClick(slot, slot.slotNumber, 1, 0);
                            this.handleMouseClick(this.__aj, this.__aj.slotNumber, 0, 0);
                            this.__ay = l2 + 750L;
                            --this.__al._b;
                        }
                    } else {
                        this.__at = slot;
                        this.__ay = l2;
                    }
                }
            }
        } else if (this.__av && slot != null && itemStack != null && itemStack._b > this.__aq.size() && Container.func_94527_a(slot, itemStack, true) && slot.isItemValid(itemStack) && this.__af.canDragIntoSlot(slot)) {
            this.__aq.add(slot);
            this._h();
        }
    }

    @Override
    protected void mouseMovedOrUp(int n, int n2, int n3) {
        Slot slot = this.getSlotAtPosition(n, n2);
        int n4 = this.__ag;
        int n5 = this.__ah;
        boolean bl = n < n4 || n2 < n5 || n >= n4 + this.__ad || n2 >= n5 + this.__ae;
        for (Rectangle object : this.__aE) {
            bl &= !object.contains(n, n2);
        }
        int n6 = -1;
        if (slot != null) {
            n6 = slot.slotNumber;
        }
        if (bl) {
            n6 = -999;
        }
        if (this.__ax && slot != null && n3 == 0 && this.__af.func_94530_a(null, slot)) {
            if (divb.isShiftKeyDown()) {
                if (slot != null && slot.inventory != null && this.__as != null) {
                    for (Slot slot2 : this.__af.inventorySlots) {
                        if (slot2 == null || !slot2.canTakeStack(this.mc._t) || !slot2.getHasStack() || slot2.inventory != slot.inventory || !Container.func_94527_a(slot2, this.__as, true)) continue;
                        this.handleMouseClick(slot2, slot2.slotNumber, n3, 1);
                    }
                }
            } else {
                this.handleMouseClick(slot, n6, n3, 6);
            }
            this.__ax = false;
            this.__az = 0L;
        } else {
            if (this.__av && this.__aB != n3) {
                this.__av = false;
                this.__aq.clear();
                this.__aw = true;
                return;
            }
            if (this.__aw) {
                this.__aw = false;
                return;
            }
            if (this.__aj != null && this.mc._M.touchscreen) {
                if (n3 == 0 || n3 == 1) {
                    if (this.__al == null && slot != this.__aj) {
                        this.__al = this.__aj.getStack();
                    }
                    boolean bl2 = Container.func_94527_a(slot, this.__al, false);
                    if (n6 != -1 && this.__al != null && bl2) {
                        this.handleMouseClick(this.__aj, this.__aj.slotNumber, n3, 0);
                        this.handleMouseClick(slot, n6, 0, 0);
                        if (this.mc._t.inventory._g() != null) {
                            this.handleMouseClick(this.__aj, this.__aj.slotNumber, n3, 0);
                            this.__ao = n - n4;
                            this.__ap = n2 - n5;
                            this.__am = this.__aj;
                            this.__ar = this.__al;
                            this.__an = Minecraft._M();
                        } else {
                            this.__ar = null;
                        }
                    } else if (this.__al != null) {
                        this.__ao = n - n4;
                        this.__ap = n2 - n5;
                        this.__am = this.__aj;
                        this.__ar = this.__al;
                        this.__an = Minecraft._M();
                    }
                    this.__al = null;
                    this.__aj = null;
                }
            } else if (this.__av && !this.__aq.isEmpty()) {
                this.handleMouseClick(null, -999, Container.func_94534_d(0, this.__aA), 5);
                for (Slot slot3 : this.__aq) {
                    this.handleMouseClick(slot3, slot3.slotNumber, Container.func_94534_d(1, this.__aA), 5);
                }
                this.handleMouseClick(null, -999, Container.func_94534_d(2, this.__aA), 5);
            } else if (this.mc._t.inventory._g() != null) {
                if (n3 == this.mc._M.keyBindPickBlock._d + 100) {
                    this.handleMouseClick(slot, n6, n3, 3);
                } else {
                    boolean bl3;
                    boolean bl4 = bl3 = n6 != -999 && (Keyboard.isKeyDown(42) || Keyboard.isKeyDown(54));
                    if (bl3) {
                        this.__as = slot != null && slot.getHasStack() ? slot.getStack() : null;
                    }
                    this.handleMouseClick(slot, n6, n3, bl3 ? 1 : 0);
                }
            }
        }
        if (this.mc._t.inventory._g() == null) {
            this.__az = 0L;
        }
        this.__av = false;
    }

    @Override
    protected boolean isMouseOverSlot(Slot slot, int n, int n2) {
        return this.isPointInRegion(slot.xDisplayPosition, slot.yDisplayPosition, 16, 16, n, n2);
    }

    @Override
    public boolean isPointInRegion(int n, int n2, int n3, int n4, int n5, int n6) {
        int n7 = this.__ag;
        int n8 = this.__ah;
        return (n5 -= n7) >= n - 1 && n5 < n + n3 + 1 && (n6 -= n8) >= n2 - 1 && n6 < n2 + n4 + 1;
    }

    @Override
    protected void handleMouseClick(Slot slot, int n, int n2, int n3) {
        if (slot != null) {
            n = slot.slotNumber;
        }
        this.mc._j._a(this.__af.windowId, n, n2, n3, this.mc._t);
    }

    @Override
    protected void keyTyped(char c, int n) {
        this.checkHotbarKeys(n);
        if (this.__ai != null && this.__ai.getHasStack()) {
            if (n == this.mc._M.keyBindPickBlock._d) {
                this.handleMouseClick(this.__ai, this.__ai.slotNumber, 0, 3);
            } else if (n == this.mc._M.keyBindDrop._d) {
                this.handleMouseClick(this.__ai, this.__ai.slotNumber, divb.isCtrlKeyDown() ? 1 : 0, 4);
            }
        }
    }

    @Override
    protected boolean checkHotbarKeys(int n) {
        if (this.mc._t.inventory._g() == null && this.__ai != null) {
            for (int i = 0; i < 9; ++i) {
                if (n != 2 + i) continue;
                this.handleMouseClick(this.__ai, this.__ai.slotNumber, i, 2);
                return true;
            }
        }
        return false;
    }

    @Override
    public void onGuiClosed() {
        if (this.mc._t != null) {
            this.__af.onContainerClosed(this.mc._t);
        }
    }

    @Override
    public boolean doesGuiPauseGame() {
        return false;
    }

    @Override
    public void updateScreen() {
        super.updateScreen();
        if (!this.mc._t.isEntityAlive() || this.mc._t.isDead) {
            this.mc._t.closeScreen();
        }
    }

    public void _a(int n, int n2, int[] nArray) {
        ywrk ywrk2 = ywrk._a();
        ywrk2._a(n, n2, nArray);
    }

    public void _a(int n, int n2, int n3, int n4, int[] nArray) {
        ywrk ywrk2 = ywrk._a();
        ywrk2._a(n, n2, n3, n4, nArray);
    }

    @Override
    public void drawTexturedModalRect(int n, int n2, int n3, int n4, int n5, int n6) {
        ywrk ywrk2 = ywrk._a();
        ywrk2._a(n, n2, n3, n4, n5, n6);
    }

    public void _a(int n, int n2, int n3, int n4, int n5, int n6, int n7, int n8) {
        ywrk ywrk2 = ywrk._a();
        ywrk2._a(n, n2, n3, n4, n5, n6, n7, n8);
    }

    public void _a(int n, int n2, int n3, int n4, int n5, int n6, int n7, int n8, int n9, int n10) {
        ywrk ywrk2 = ywrk._a();
        ywrk2._a(n, n2, n3, n4, n5, n6, n7, n8, n9, n10);
    }
}

