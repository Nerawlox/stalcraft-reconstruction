/*
 * Decompiled with CFR 0.152.
 */
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiTextField;
import net.minecraft.client.gui.inventory.SlotCreativeInventory;
import net.minecraft.client.renderer.InventoryEffectRenderer;
import net.minecraft.client.settings.GameSettings;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.InventoryBasic;
import net.minecraft.inventory.Slot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.AchievementList;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.GL11;

@SideOnly(value=Side.CLIENT)
public class qngy
extends InventoryEffectRenderer {
    public static final ResourceLocation _a = new ResourceLocation("textures/gui/container/creative_inventory/tabs.png");
    public static InventoryBasic _b = new InventoryBasic("tmp", true, 45);
    public static int _c = CreativeTabs.tabBlock.getTabIndex();
    public float _d;
    public boolean _e;
    public boolean _f;
    public GuiTextField _g;
    public List _h;
    public Slot _i;
    public boolean _j;
    public jzuc _k;
    public static int _l = 0;
    public int _m = 0;

    public qngy(EntityPlayer entityPlayer) {
        super(new dyct(entityPlayer));
        entityPlayer.openContainer = this.inventorySlots;
        this.allowUserInput = true;
        entityPlayer.addStat(AchievementList._f, 1);
        this.ySize = 136;
        this.xSize = 195;
    }

    @Override
    public void updateScreen() {
        super.updateScreen();
        if (!this.mc._j._i()) {
            this.mc._a(new cebg(this.mc._t));
        }
    }

    @Override
    public void handleMouseClick(Slot slot, int n, int n2, int n3) {
        this._j = true;
        boolean bl = n3 == 1;
        int n4 = n3 = n == -999 && n3 == 0 ? 4 : n3;
        if (slot == null && _c != CreativeTabs.tabInventory.getTabIndex() && n3 != 5) {
            InventoryPlayer inventoryPlayer = this.mc._t.inventory;
            if (inventoryPlayer._g() != null) {
                if (n2 == 0) {
                    this.mc._t.dropPlayerItem(inventoryPlayer._g());
                    this.mc._j._a(inventoryPlayer._g());
                    inventoryPlayer._d(null);
                }
                if (n2 == 1) {
                    ItemStack itemStack = inventoryPlayer._g()._a(1);
                    this.mc._t.dropPlayerItem(itemStack);
                    this.mc._j._a(itemStack);
                    if (inventoryPlayer._g()._b == 0) {
                        inventoryPlayer._d(null);
                    }
                }
            }
        } else if (slot == this._i && bl) {
            for (int i = 0; i < this.mc._t.inventoryContainer.getInventory().size(); ++i) {
                this.mc._j._a((ItemStack)null, i);
            }
        } else if (_c == CreativeTabs.tabInventory.getTabIndex()) {
            if (slot == this._i) {
                this.mc._t.inventory._d(null);
            } else if (n3 == 4 && slot != null && slot.getHasStack()) {
                ItemStack itemStack = slot.decrStackSize(n2 == 0 ? 1 : slot.getStack()._d());
                this.mc._t.dropPlayerItem(itemStack);
                this.mc._j._a(itemStack);
            } else if (n3 == 4 && this.mc._t.inventory._g() != null) {
                this.mc._t.dropPlayerItem(this.mc._t.inventory._g());
                this.mc._j._a(this.mc._t.inventory._g());
                this.mc._t.inventory._d(null);
            } else {
                this.mc._t.inventoryContainer.slotClick(slot == null ? n : SlotCreativeInventory._a((SlotCreativeInventory)((SlotCreativeInventory)slot)).slotNumber, n2, n3, this.mc._t);
                this.mc._t.inventoryContainer.detectAndSendChanges();
            }
        } else if (n3 != 5 && slot.inventory == _b) {
            InventoryPlayer inventoryPlayer = this.mc._t.inventory;
            ItemStack itemStack = inventoryPlayer._g();
            ItemStack itemStack2 = slot.getStack();
            if (n3 == 2) {
                if (itemStack2 != null && n2 >= 0 && n2 < 9) {
                    ItemStack itemStack3 = itemStack2._l();
                    itemStack3._b = itemStack3._d();
                    this.mc._t.inventory.setInventorySlotContents(n2, itemStack3);
                    this.mc._t.inventoryContainer.detectAndSendChanges();
                }
                return;
            }
            if (n3 == 3) {
                if (inventoryPlayer._g() == null && slot.getHasStack()) {
                    ItemStack itemStack4 = slot.getStack()._l();
                    itemStack4._b = itemStack4._d();
                    inventoryPlayer._d(itemStack4);
                }
                return;
            }
            if (n3 == 4) {
                if (itemStack2 != null) {
                    ItemStack itemStack5 = itemStack2._l();
                    itemStack5._b = n2 == 0 ? 1 : itemStack5._d();
                    this.mc._t.dropPlayerItem(itemStack5);
                    this.mc._j._a(itemStack5);
                }
                return;
            }
            if (itemStack != null && itemStack2 != null && itemStack._b(itemStack2) && ItemStack._a(itemStack, itemStack2)) {
                if (n2 == 0) {
                    if (bl) {
                        itemStack._b = itemStack._d();
                    } else if (itemStack._b < itemStack._d()) {
                        ++itemStack._b;
                    }
                } else if (itemStack._b <= 1) {
                    inventoryPlayer._d(null);
                } else {
                    --itemStack._b;
                }
            } else if (itemStack2 != null && itemStack == null) {
                inventoryPlayer._d(ItemStack._c(itemStack2));
                itemStack = inventoryPlayer._g();
                if (bl) {
                    itemStack._b = itemStack._d();
                }
            } else {
                inventoryPlayer._d(null);
            }
        } else {
            this.inventorySlots.slotClick(slot == null ? n : slot.slotNumber, n2, n3, this.mc._t);
            if (Container.func_94532_c(n2) == 2) {
                for (int i = 0; i < 9; ++i) {
                    this.mc._j._a(this.inventorySlots.getSlot(45 + i).getStack(), 36 + i);
                }
            } else if (slot != null) {
                ItemStack itemStack = this.inventorySlots.getSlot(slot.slotNumber).getStack();
                this.mc._j._a(itemStack, slot.slotNumber - this.inventorySlots.inventorySlots.size() + 9 + 36);
            }
        }
    }

    @Override
    public void initGui() {
        if (this.mc._j._i()) {
            super.initGui();
            this.buttonList.clear();
            Keyboard.enableRepeatEvents(true);
            this._g = new GuiTextField(this.fontRenderer, this.guiLeft + 82, this.guiTop + 6, 89, this.fontRenderer._c);
            this._g.setMaxStringLength(15);
            this._g.setEnableBackgroundDrawing(false);
            this._g.setVisible(false);
            this._g.setTextColor(0xFFFFFF);
            int n = _c;
            _c = -1;
            this._a(CreativeTabs.creativeTabArray[n]);
            this._k = new jzuc(this.mc);
            this.mc._t.inventoryContainer.func_75132_a(this._k);
            int n2 = CreativeTabs.creativeTabArray.length;
            if (n2 > 12) {
                this.buttonList.add(new GuiButton(101, this.guiLeft, this.guiTop - 50, 20, 20, "<"));
                this.buttonList.add(new GuiButton(102, this.guiLeft + this.xSize - 20, this.guiTop - 50, 20, 20, ">"));
                this._m = (n2 - 12) / 10 + 1;
            }
        } else {
            this.mc._a(new cebg(this.mc._t));
        }
    }

    @Override
    public void onGuiClosed() {
        super.onGuiClosed();
        if (this.mc._t != null && this.mc._t.inventory != null) {
            this.mc._t.inventoryContainer.removeCraftingFromCrafters(this._k);
        }
        Keyboard.enableRepeatEvents(false);
    }

    @Override
    public void keyTyped(char c, int n) {
        if (!CreativeTabs.creativeTabArray[_c].hasSearchBar()) {
            if (GameSettings.isKeyDown(this.mc._M.keyBindChat)) {
                this._a(CreativeTabs.tabAllSearch);
            } else {
                super.keyTyped(c, n);
            }
        } else {
            if (this._j) {
                this._j = false;
                this._g.setText("");
            }
            if (!this.checkHotbarKeys(n)) {
                if (this._g.textboxKeyTyped(c, n)) {
                    this._a();
                } else {
                    super.keyTyped(c, n);
                }
            }
        }
    }

    public void _a() {
        dyct dyct2 = (dyct)this.inventorySlots;
        dyct2._a.clear();
        CreativeTabs creativeTabs = CreativeTabs.creativeTabArray[_c];
        if (creativeTabs.hasSearchBar() && creativeTabs != CreativeTabs.tabAllSearch) {
            creativeTabs.displayAllReleventItems(dyct2._a);
            this._a(dyct2);
            return;
        }
        for (Item item : Item.itemsList) {
            if (item == null || item.getCreativeTab() == null) continue;
            item.getSubItems(item.itemID, null, dyct2._a);
        }
        for (Enchantment enchantment : Enchantment._a) {
            if (enchantment == null || enchantment._A == null) continue;
            Item.enchantedBook._a(enchantment, dyct2._a);
        }
        this._a(dyct2);
    }

    public void _a(dyct dyct2) {
        Iterator iterator = dyct2._a.iterator();
        String string = this._g.getText().toLowerCase();
        while (iterator.hasNext()) {
            ItemStack itemStack = (ItemStack)iterator.next();
            boolean bl = false;
            for (String string2 : itemStack._a((EntityPlayer)this.mc._t, this.mc._M.advancedItemTooltips)) {
                if (!string2.toLowerCase().contains(string)) continue;
                bl = true;
                break;
            }
            if (bl) continue;
            iterator.remove();
        }
        this._d = 0.0f;
        dyct2._a(0.0f);
    }

    @Override
    public void drawGuiContainerForegroundLayer(int n, int n2) {
        CreativeTabs creativeTabs = CreativeTabs.creativeTabArray[_c];
        if (creativeTabs != null && creativeTabs.drawInForegroundOfTab()) {
            this.fontRenderer._b(wpcz._a(creativeTabs.getTranslatedTabLabel()), 8, 6, 0x404040);
        }
    }

    @Override
    public void mouseClicked(int n, int n2, int n3) {
        if (n3 == 0) {
            int n4 = n - this.guiLeft;
            int n5 = n2 - this.guiTop;
            for (CreativeTabs creativeTabs : CreativeTabs.creativeTabArray) {
                if (!this._a(creativeTabs, n4, n5)) continue;
                return;
            }
        }
        super.mouseClicked(n, n2, n3);
    }

    @Override
    public void mouseMovedOrUp(int n, int n2, int n3) {
        if (n3 == 0) {
            int n4 = n - this.guiLeft;
            int n5 = n2 - this.guiTop;
            for (CreativeTabs creativeTabs : CreativeTabs.creativeTabArray) {
                if (creativeTabs == null || !this._a(creativeTabs, n4, n5)) continue;
                this._a(creativeTabs);
                return;
            }
        }
        super.mouseMovedOrUp(n, n2, n3);
    }

    public boolean _b() {
        if (CreativeTabs.creativeTabArray[_c] == null) {
            return false;
        }
        return _c != CreativeTabs.tabInventory.getTabIndex() && CreativeTabs.creativeTabArray[_c].shouldHidePlayerInventory() && ((dyct)this.inventorySlots)._a();
    }

    public void _a(CreativeTabs creativeTabs) {
        if (creativeTabs == null) {
            return;
        }
        int n = _c;
        _c = creativeTabs.getTabIndex();
        dyct dyct2 = (dyct)this.inventorySlots;
        this.field_94077_p.clear();
        dyct2._a.clear();
        creativeTabs.displayAllReleventItems(dyct2._a);
        if (creativeTabs == CreativeTabs.tabInventory) {
            Container container = this.mc._t.inventoryContainer;
            if (this._h == null) {
                this._h = dyct2.inventorySlots;
            }
            dyct2.inventorySlots = new ArrayList();
            for (int i = 0; i < container.inventorySlots.size(); ++i) {
                int n2;
                int n3;
                int n4;
                SlotCreativeInventory slotCreativeInventory = new SlotCreativeInventory(this, (Slot)container.inventorySlots.get(i), i);
                dyct2.inventorySlots.add(slotCreativeInventory);
                if (i >= 5 && i < 9) {
                    n4 = i - 5;
                    n3 = n4 / 2;
                    n2 = n4 % 2;
                    slotCreativeInventory.xDisplayPosition = 9 + n3 * 54;
                    slotCreativeInventory.yDisplayPosition = 6 + n2 * 27;
                    continue;
                }
                if (i >= 0 && i < 5) {
                    slotCreativeInventory.yDisplayPosition = -2000;
                    slotCreativeInventory.xDisplayPosition = -2000;
                    continue;
                }
                if (i >= container.inventorySlots.size()) continue;
                n4 = i - 9;
                n3 = n4 % 9;
                n2 = n4 / 9;
                slotCreativeInventory.xDisplayPosition = 9 + n3 * 18;
                slotCreativeInventory.yDisplayPosition = i >= 36 ? 112 : 54 + n2 * 18;
            }
            this._i = new Slot(_b, 0, 173, 112);
            dyct2.inventorySlots.add(this._i);
        } else if (n == CreativeTabs.tabInventory.getTabIndex()) {
            dyct2.inventorySlots = this._h;
            this._h = null;
        }
        if (this._g != null) {
            if (creativeTabs.hasSearchBar()) {
                this._g.setVisible(true);
                this._g.setCanLoseFocus(false);
                this._g.setFocused(true);
                this._g.setText("");
                this._a();
            } else {
                this._g.setVisible(false);
                this._g.setCanLoseFocus(true);
                this._g.setFocused(false);
            }
        }
        this._d = 0.0f;
        dyct2._a(0.0f);
    }

    @Override
    public void handleMouseInput() {
        super.handleMouseInput();
        int n = Mouse.getEventDWheel();
        if (n != 0 && this._b()) {
            int n2 = ((dyct)this.inventorySlots)._a.size() / 9 - 5 + 1;
            if (n > 0) {
                n = 1;
            }
            if (n < 0) {
                n = -1;
            }
            this._d = (float)((double)this._d - (double)n / (double)n2);
            if (this._d < 0.0f) {
                this._d = 0.0f;
            }
            if (this._d > 1.0f) {
                this._d = 1.0f;
            }
            ((dyct)this.inventorySlots)._a(this._d);
        }
    }

    @Override
    public void drawScreen(int n, int n2, float f) {
        boolean bl = Mouse.isButtonDown(0);
        int n3 = this.guiLeft;
        int n4 = this.guiTop;
        int n5 = n3 + 175;
        int n6 = n4 + 18;
        int n7 = n5 + 14;
        int n8 = n6 + 112;
        if (!this._f && bl && n >= n5 && n2 >= n6 && n < n7 && n2 < n8) {
            this._e = this._b();
        }
        if (!bl) {
            this._e = false;
        }
        this._f = bl;
        if (this._e) {
            this._d = ((float)(n2 - n6) - 7.5f) / ((float)(n8 - n6) - 15.0f);
            if (this._d < 0.0f) {
                this._d = 0.0f;
            }
            if (this._d > 1.0f) {
                this._d = 1.0f;
            }
            ((dyct)this.inventorySlots)._a(this._d);
        }
        super.drawScreen(n, n2, f);
        CreativeTabs[] creativeTabsArray = CreativeTabs.creativeTabArray;
        int n9 = _l * 10;
        int n10 = Math.min(creativeTabsArray.length, (_l + 1) * 10 + 2);
        if (_l != 0) {
            n9 += 2;
        }
        boolean bl2 = false;
        for (int i = n9; i < n10; ++i) {
            CreativeTabs creativeTabs = creativeTabsArray[i];
            if (creativeTabs == null || !this._b(creativeTabs, n, n2)) continue;
            bl2 = true;
            break;
        }
        if (!bl2 && !this._b(CreativeTabs.tabAllSearch, n, n2)) {
            this._b(CreativeTabs.tabInventory, n, n2);
        }
        if (this._i != null && _c == CreativeTabs.tabInventory.getTabIndex() && this.isPointInRegion(this._i.xDisplayPosition, this._i.yDisplayPosition, 16, 16, n, n2)) {
            this.drawCreativeTabHoveringText(wpcz._a("inventory.binSlot"), n, n2);
        }
        if (this._m != 0) {
            String string = String.format("%d / %d", _l + 1, this._m + 1);
            int n11 = this.fontRenderer._b(string);
            GL11.glDisable(2896);
            this.zLevel = 300.0f;
            qngy.itemRenderer.zLevel = 300.0f;
            this.fontRenderer._b(string, this.guiLeft + this.xSize / 2 - n11 / 2, this.guiTop - 44, -1);
            this.zLevel = 0.0f;
            qngy.itemRenderer.zLevel = 0.0f;
        }
        GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
        GL11.glDisable(2896);
    }

    @Override
    public void drawItemStackTooltip(ItemStack itemStack, int n, int n2) {
        if (_c == CreativeTabs.tabAllSearch.getTabIndex()) {
            Map map;
            List list = itemStack._a((EntityPlayer)this.mc._t, this.mc._M.advancedItemTooltips);
            CreativeTabs creativeTabs = itemStack._a().getCreativeTab();
            if (creativeTabs == null && itemStack._d == Item.enchantedBook.itemID && (map = zhty._a(itemStack)).size() == 1) {
                Enchantment enchantment = Enchantment._a[(Integer)map.keySet().iterator().next()];
                for (CreativeTabs creativeTabs2 : CreativeTabs.creativeTabArray) {
                    if (!creativeTabs2.func_111226_a(enchantment._A)) continue;
                    creativeTabs = creativeTabs2;
                    break;
                }
            }
            if (creativeTabs != null) {
                list.add(1, "" + (Object)((Object)EnumChatFormatting._r) + (Object)((Object)EnumChatFormatting._j) + wpcz._a(creativeTabs.getTranslatedTabLabel()));
            }
            for (int i = 0; i < list.size(); ++i) {
                if (i == 0) {
                    list.set(i, "\u00a7" + Integer.toHexString(itemStack._w()._e) + (String)list.get(i));
                    continue;
                }
                list.set(i, (Object)((Object)EnumChatFormatting._h) + (String)list.get(i));
            }
            this.func_102021_a(list, n, n2);
        } else {
            super.drawItemStackTooltip(itemStack, n, n2);
        }
    }

    @Override
    public void drawGuiContainerBackgroundLayer(float f, int n, int n2) {
        int n3;
        GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
        qnon._c();
        CreativeTabs creativeTabs = CreativeTabs.creativeTabArray[_c];
        CreativeTabs[] creativeTabsArray = CreativeTabs.creativeTabArray;
        int n4 = creativeTabsArray.length;
        int n5 = _l * 10;
        n4 = Math.min(creativeTabsArray.length, (_l + 1) * 10 + 2);
        if (_l != 0) {
            n5 += 2;
        }
        for (n3 = n5; n3 < n4; ++n3) {
            CreativeTabs creativeTabs2 = creativeTabsArray[n3];
            this.mc._R()._a(_a);
            if (creativeTabs2 == null || creativeTabs2.getTabIndex() == _c) continue;
            this._b(creativeTabs2);
        }
        if (_l != 0) {
            if (creativeTabs != CreativeTabs.tabAllSearch) {
                this.mc._R()._a(_a);
                this._b(CreativeTabs.tabAllSearch);
            }
            if (creativeTabs != CreativeTabs.tabInventory) {
                this.mc._R()._a(_a);
                this._b(CreativeTabs.tabInventory);
            }
        }
        this.mc._R()._a(new ResourceLocation("textures/gui/container/creative_inventory/tab_" + creativeTabs.getBackgroundImageName()));
        this.drawTexturedModalRect(this.guiLeft, this.guiTop, 0, 0, this.xSize, this.ySize);
        this._g.drawTextBox();
        GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
        int n6 = this.guiLeft + 175;
        n4 = this.guiTop + 18;
        n3 = n4 + 112;
        this.mc._R()._a(_a);
        if (creativeTabs.shouldHidePlayerInventory()) {
            this.drawTexturedModalRect(n6, n4 + (int)((float)(n3 - n4 - 17) * this._d), 232 + (this._b() ? 0 : 12), 0, 12, 15);
        }
        if ((creativeTabs == null || creativeTabs.getTabPage() != _l) && creativeTabs != CreativeTabs.tabAllSearch && creativeTabs != CreativeTabs.tabInventory) {
            return;
        }
        this._b(creativeTabs);
        if (creativeTabs == CreativeTabs.tabInventory) {
            cebg._a(this.guiLeft + 43, this.guiTop + 45, 20, this.guiLeft + 43 - n, this.guiTop + 45 - 30 - n2, this.mc._t);
        }
    }

    public boolean _a(CreativeTabs creativeTabs, int n, int n2) {
        if (creativeTabs.getTabPage() != _l && creativeTabs != CreativeTabs.tabAllSearch && creativeTabs != CreativeTabs.tabInventory) {
            return false;
        }
        int n3 = creativeTabs.getTabColumn();
        int n4 = 28 * n3;
        int n5 = 0;
        if (n3 == 5) {
            n4 = this.xSize - 28 + 2;
        } else if (n3 > 0) {
            n4 += n3;
        }
        int n6 = creativeTabs.isTabInFirstRow() ? n5 - 32 : n5 + this.ySize;
        return n >= n4 && n <= n4 + 28 && n2 >= n6 && n2 <= n6 + 32;
    }

    public boolean _b(CreativeTabs creativeTabs, int n, int n2) {
        int n3 = creativeTabs.getTabColumn();
        int n4 = 28 * n3;
        int n5 = 0;
        if (n3 == 5) {
            n4 = this.xSize - 28 + 2;
        } else if (n3 > 0) {
            n4 += n3;
        }
        int n6 = creativeTabs.isTabInFirstRow() ? n5 - 32 : n5 + this.ySize;
        if (this.isPointInRegion(n4 + 3, n6 + 3, 23, 27, n, n2)) {
            this.drawCreativeTabHoveringText(wpcz._a(creativeTabs.getTranslatedTabLabel()), n, n2);
            return true;
        }
        return false;
    }

    public void _b(CreativeTabs creativeTabs) {
        boolean bl = creativeTabs.getTabIndex() == _c;
        boolean bl2 = creativeTabs.isTabInFirstRow();
        int n = creativeTabs.getTabColumn();
        int n2 = n * 28;
        int n3 = 0;
        int n4 = this.guiLeft + 28 * n;
        int n5 = this.guiTop;
        int n6 = 32;
        if (bl) {
            n3 += 32;
        }
        if (n == 5) {
            n4 = this.guiLeft + this.xSize - 28;
        } else if (n > 0) {
            n4 += n;
        }
        if (bl2) {
            n5 -= 28;
        } else {
            n3 += 64;
            n5 += this.ySize - 4;
        }
        GL11.glDisable(2896);
        GL11.glColor3f(1.0f, 1.0f, 1.0f);
        this.drawTexturedModalRect(n4, n5, n2, n3, 28, n6);
        this.zLevel = 100.0f;
        qngy.itemRenderer.zLevel = 100.0f;
        int n7 = bl2 ? 1 : -1;
        GL11.glEnable(2896);
        GL11.glEnable(32826);
        ItemStack itemStack = creativeTabs.getIconItemStack();
        itemRenderer.renderItemAndEffectIntoGUI(this.fontRenderer, this.mc._R(), itemStack, n4 += 6, n5 += 8 + n7);
        itemRenderer.renderItemOverlayIntoGUI(this.fontRenderer, this.mc._R(), itemStack, n4, n5);
        GL11.glDisable(2896);
        qngy.itemRenderer.zLevel = 0.0f;
        this.zLevel = 0.0f;
    }

    @Override
    public void actionPerformed(GuiButton guiButton) {
        if (guiButton.id == 0) {
            this.mc._a(new ohbq(this.mc._X));
        }
        if (guiButton.id == 1) {
            this.mc._a(new uzta(this, this.mc._X));
        }
        if (guiButton.id == 101) {
            _l = Math.max(_l - 1, 0);
        } else if (guiButton.id == 102) {
            _l = Math.min(_l + 1, this._m);
        }
    }

    public int _c() {
        return _c;
    }

    public static InventoryBasic _d() {
        return _b;
    }
}

