/*
 * Decompiled with CFR 0.152.
 */
package codechicken.nei;

import codechicken.core.gui.GuiDraw;
import codechicken.lib.config.ConfigTag;
import codechicken.lib.inventory.ItemKey;
import codechicken.nei.DropDownFile;
import codechicken.nei.DropDownWidget;
import codechicken.nei.ItemList;
import codechicken.nei.ItemRange;
import codechicken.nei.ItemVisibilityHash;
import codechicken.nei.LayoutManager;
import codechicken.nei.MultiItemRange;
import codechicken.nei.NEIClientConfig;
import codechicken.nei.NEIClientUtils;
import codechicken.nei.forge.GuiContainerManager;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import org.lwjgl.opengl.GL11;

public class SubSetRangeTag
extends ConfigTag {
    public ArrayList<SubSetRangeTag> sortedtags = new ArrayList();
    public boolean saveTag = true;
    public MultiItemRange validranges;
    public byte state;
    public int slotwidth = 0;
    public boolean hasscroll;
    protected int scrollclicky = -1;
    protected float scrollpercent;
    protected int scrollmousey;
    protected float percentscrolled;
    protected int lastslotclicked = -1;
    protected long lastslotclicktime;
    int x;
    int y;
    int height;
    int width;
    int contentheight;
    public boolean expanded;
    public boolean hidden;
    private static final int slotheight = 18;

    public SubSetRangeTag(DropDownFile dropDownFile, String string) {
        super(dropDownFile, string);
    }

    public SubSetRangeTag(SubSetRangeTag subSetRangeTag, String string) {
        super(subSetRangeTag, string);
        this.saveTag = subSetRangeTag.saveTag;
    }

    @Override
    public ConfigTag onLoaded() {
        this.saveTag = true;
        return this;
    }

    @Override
    public SubSetRangeTag getTag(String string) {
        return (SubSetRangeTag)super.getTag(string);
    }

    @Override
    public SubSetRangeTag getTag(String string, boolean bl) {
        return (SubSetRangeTag)super.getTag(string, bl);
    }

    @Override
    public SubSetRangeTag getNewTag(String string) {
        return new SubSetRangeTag(this, string);
    }

    public void setDefaultValue(MultiItemRange multiItemRange) {
        if (this.value == null) {
            this.setRange(multiItemRange);
        }
    }

    @Override
    public void setValue(String string) {
        this.value = string;
        if (this.saveTag) {
            this.saveConfig();
        }
        if (this.validranges == null) {
            this.validranges = new MultiItemRange(string);
        }
    }

    public void setRange(MultiItemRange multiItemRange) {
        this.validranges = multiItemRange;
        this.setValue(this.validranges.toString());
    }

    public MultiItemRange getRange() {
        return this.validranges;
    }

    public boolean thisContains(int n, int n2) {
        return n >= this.x && n < this.x + this.width && n2 >= this.y && n2 < this.y + this.height;
    }

    public boolean contains(int n, int n2) {
        if (!this.expanded) {
            return false;
        }
        if (this.thisContains(n, n2)) {
            return true;
        }
        for (SubSetRangeTag subSetRangeTag : this.sortedtags) {
            if (!subSetRangeTag.contains(n, n2)) continue;
            return true;
        }
        return false;
    }

    public int getNumSlots() {
        return this.childTagMap().size() + (this.validranges == null ? 0 : this.validranges.getNumSlots());
    }

    public int getScrollBarWidth() {
        return 5;
    }

    public int getScrollBarHeight() {
        int n = (int)((float)this.height / (float)this.contentheight * (float)this.height);
        if (n > this.height) {
            return this.height;
        }
        if (n < this.height / 15) {
            return this.height / 15;
        }
        return n;
    }

    public int getScrolledSlots() {
        int n = this.getNumSlots();
        int n2 = this.height / 18;
        return (int)(this.percentscrolled * (float)(n - n2) + 0.5f);
    }

    private int getClickedSlot(int n) {
        return (n - this.y) / 18 + this.getScrolledSlots();
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
        n = this.y + (int)((double)((float)n2 * this.percentscrolled) + 0.5);
        this.percentscrolled = (float)(n - this.y) / (float)n2;
    }

    public void processScrollMouse(int n, int n2) {
        if (this.scrollclicky >= 0) {
            int n3 = n2 - this.scrollclicky;
            int n4 = (int)((double)((float)(this.height - this.getScrollBarHeight()) * this.scrollpercent) + 0.5);
            int n5 = this.height - this.getScrollBarHeight() - n4;
            this.scrollmousey = -n3 > n4 ? this.scrollclicky - n4 : (n3 > n5 ? this.scrollclicky + n5 : n2);
            this.calculatePercentScrolled();
        }
    }

    public String updateMouseOver(int n, int n2, String string) {
        boolean bl = this.expanded = string.equals(this.qualifiedname) || string.length() > this.qualifiedname.length() && string.startsWith(this.qualifiedname) && string.charAt(this.qualifiedname.length()) == '.';
        if (!this.expanded) {
            this.scrollclicky = -1;
            return "";
        }
        this.processScrollMouse(n, n2);
        String object = "";
        if (this.contains(n, n2)) {
            object = this.qualifiedname + ".-";
        }
        int n3 = this.y;
        int n4 = this.x + (this.hasscroll ? this.getScrollBarWidth() : 0);
        int n5 = 0;
        for (SubSetRangeTag object2 : this.sortedtags) {
            String string2;
            if (++n5 <= this.getScrolledSlots()) continue;
            if (n4 <= n && this.x + this.width > n && n3 <= n2 && n3 + 18 > n2) {
                object = object2.qualifiedname;
            }
            if (!(string2 = object2.updateMouseOver(n, n2, string)).equals("")) {
                object = string2;
            }
            n3 += 18;
        }
        int n6 = n5;
        if (this.validranges != null) {
            for (ItemRange itemRange : this.validranges.ranges) {
                if (n5 + itemRange.encompasseditems.size() <= this.getScrolledSlots()) {
                    n5 += itemRange.encompasseditems.size();
                    continue;
                }
                for (int i = 0; i < itemRange.encompasseditems.size(); ++i) {
                    if (++n5 <= this.getScrolledSlots()) continue;
                    if (n4 <= n && this.x + this.width > n && n3 <= n2 && n3 + 18 > n2) {
                        object = this.qualifiedname + "." + (n5 - n6);
                        break;
                    }
                    if ((n3 += 18) >= this.y + this.height) break;
                }
                if (n3 < this.y + this.height) continue;
                break;
            }
        }
        return object;
    }

    public boolean click(int n, int n2, int n3) {
        if (!this.expanded) {
            return false;
        }
        boolean bl = this.thisContains(n, n2);
        if (!bl) {
            for (SubSetRangeTag subSetRangeTag : this.sortedtags) {
                subSetRangeTag.click(n, n2, n3);
            }
        }
        int n4 = this.height - this.getScrollBarHeight();
        int n5 = this.y + (int)((double)((float)n4 * this.percentscrolled) + 0.5);
        int n6 = this.x + this.getScrollBarWidth();
        if (this.hasscroll && n3 == 0 && this.getScrollBarHeight() < this.height && n >= this.x && n < this.x + this.getScrollBarWidth() && n2 >= this.y && n2 < this.y + this.height) {
            if (n2 < n5) {
                this.percentscrolled = (float)(n2 - this.y) / (float)n4;
                this.calculatePercentScrolled();
            } else if (n2 > n5 + this.getScrollBarHeight()) {
                this.percentscrolled = (float)(n2 - this.y - this.getScrollBarHeight() + 1) / (float)n4;
                this.calculatePercentScrolled();
            } else {
                this.scrollclicky = n2;
                this.scrollpercent = this.percentscrolled;
                this.scrollmousey = n2;
                LayoutManager.dropDown.canChangeMouseOver = false;
            }
        } else if (n >= n6 && n < this.x + this.width && n2 >= this.y && n2 <= this.y + this.height) {
            int n7 = this.getClickedSlot(n2);
            if (n7 == this.lastslotclicked && System.currentTimeMillis() - this.lastslotclicktime < 500L && n3 == 0) {
                this.slotClicked(n7, n3, true);
            } else {
                this.slotClicked(n7, n3, false);
            }
            if (n3 == 0) {
                this.lastslotclicked = n7;
                this.lastslotclicktime = System.currentTimeMillis();
            }
        }
        return true;
    }

    public void onMouseWheel(int n) {
        if (this.scrollclicky != -1) {
            return;
        }
        for (SubSetRangeTag subSetRangeTag : this.sortedtags) {
            if (!subSetRangeTag.expanded) continue;
            subSetRangeTag.onMouseWheel(n);
            return;
        }
        this.percentscrolled += (float)n / (float)this.contentheight * 100.0f;
        if (this.percentscrolled > 1.0f) {
            this.percentscrolled = 1.0f;
        } else if (this.percentscrolled < 0.0f) {
            this.percentscrolled = 0.0f;
        }
    }

    private void slotClicked(int n, int n2, boolean bl) {
        int n3 = 0;
        for (SubSetRangeTag subSetRangeTag : this.sortedtags) {
            if (n == n3) {
                subSetRangeTag.onClick(n2, bl);
                return;
            }
            ++n3;
        }
        if (this.validranges != null) {
            this.validranges.slotClicked(n - n3, n2, bl);
        }
    }

    public void onClick(int n, boolean bl) {
        if (n == 0 && !bl) {
            if (NEIClientUtils.shiftKey()) {
                LayoutManager.searchField.setText("@" + this.qualifiedname);
                return;
            }
            this.showAllItems();
        } else if (n == 0 && bl) {
            DropDownFile.dropDownInstance.hideAllItems();
            this.showAllItems();
        } else if (n == 1) {
            this.hideAllItems();
        }
        DropDownFile.dropDownInstance.updateState();
        ItemList.updateSearch();
        NEIClientConfig.vishash.save();
    }

    public void hideAllItems() {
        if (this.validranges != null) {
            this.validranges.hideAllItems();
        }
        for (SubSetRangeTag subSetRangeTag : this.sortedtags) {
            subSetRangeTag.hideAllItems();
        }
    }

    public void showAllItems() {
        if (this.validranges != null) {
            this.validranges.showAllItems();
        }
        for (SubSetRangeTag subSetRangeTag : this.sortedtags) {
            subSetRangeTag.showAllItems();
        }
    }

    public void mouseUp(int n, int n2, int n3) {
        if (this.scrollclicky >= 0 && n3 == 0) {
            this.scrollclicky = -1;
            LayoutManager.dropDown.canChangeMouseOver = true;
        }
        for (SubSetRangeTag subSetRangeTag : this.sortedtags) {
            subSetRangeTag.mouseUp(n, n2, n3);
        }
    }

    public void draw(int n, int n2) {
        int n3;
        if (!this.expanded) {
            return;
        }
        this.drawScrollBar();
        int n4 = this.y;
        int n5 = this.x + (this.hasscroll ? this.getScrollBarWidth() : 0);
        int n6 = 0;
        for (SubSetRangeTag object : this.sortedtags) {
            if (++n6 <= this.getScrolledSlots()) continue;
            if (!this.hidden) {
                if (!DropDownWidget.texturedButtons) {
                    n3 = n >= n5 && n < n5 + this.slotwidth && n2 >= n4 && n2 < n4 + 18 ? 1 : 0;
                    GuiDraw.drawRect(n5, n4, this.slotwidth, 18, n3 != 0 ? -12578808 : -16777216);
                    GuiDraw.drawStringC(object.name, n5, n4, this.slotwidth, 18, object.getColourFromState(), object.state == 0);
                } else {
                    GuiDraw.changeTexture("textures/gui/widgets.png");
                    if (object.state == 1) {
                        GL11.glColor4f(0.65f, 0.65f, 0.65f, 1.0f);
                    } else {
                        GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
                    }
                    n3 = object.state == 0 ? 0 : 1;
                    LayoutManager.drawButtonBackground(n5, n4, this.slotwidth, 18, false, n3);
                    int n7 = object.state == 2 ? -2039584 : -6250336;
                    GuiDraw.drawStringC(object.name, n5, n4, this.slotwidth, 18, n7);
                }
            }
            object.draw(n, n2);
            if ((n4 += 18) < this.y + this.height) continue;
            break;
        }
        if (this.validranges != null && n4 < this.y + this.height) {
            for (ItemRange itemRange : this.validranges.ranges) {
                if (n6 + itemRange.encompasseditems.size() <= this.getScrolledSlots()) {
                    n6 += itemRange.encompasseditems.size();
                    continue;
                }
                for (n3 = 0; n3 < itemRange.encompasseditems.size(); ++n3) {
                    boolean bl;
                    if (++n6 <= this.getScrolledSlots()) continue;
                    ItemKey itemKey = itemRange.encompasseditems.get(n3);
                    int n8 = n5 + this.slotwidth / 2 - 8;
                    int n9 = n4 + 1;
                    boolean bl2 = bl = !NEIClientConfig.vishash.isItemHidden(itemKey);
                    if (!DropDownWidget.texturedButtons) {
                        GuiDraw.drawRect(n5, n4, this.slotwidth, 18, bl ? -16764928 : -13631488);
                    } else {
                        int n10 = bl ? 1 : 0;
                        GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
                        LayoutManager.drawButtonBackground(n5, n4, this.slotwidth, 18, false, n10);
                    }
                    cvzo cvzo2 = itemKey.item;
                    GuiContainerManager.drawItem(n8, n9, cvzo2);
                    if (n8 <= n && n8 + 16 > n && n9 + 1 <= n2 && n9 + 16 > n2) {
                        LayoutManager.dropDown.setHoverItem(itemKey.item);
                    }
                    if ((n4 += 18) >= this.y + this.height) break;
                }
                if (n4 < this.y + this.height) continue;
                break;
            }
        }
    }

    private void drawScrollBar() {
        if (this.hasscroll && !this.hidden) {
            int n = this.y + (int)((double)((float)(this.height - this.getScrollBarHeight()) * this.percentscrolled) + 0.5);
            GuiDraw.drawRect(this.x, this.y, 5, this.height, -14671840);
            if (DropDownWidget.texturedButtons) {
                GuiDraw.drawRect(this.x, n, 5, this.getScrollBarHeight(), -7631989);
                GuiDraw.drawRect(this.x, n, 4, this.getScrollBarHeight() - 1, -986896);
                GuiDraw.drawRect(this.x + 1, n + 1, 4, this.getScrollBarHeight() - 1, -11184811);
                GuiDraw.drawRect(this.x + 1, n + 1, 3, this.getScrollBarHeight() - 2, -3750202);
            } else {
                GuiDraw.drawRect(this.x, n, 5, this.getScrollBarHeight(), -2039584);
            }
        }
    }

    public void position(int n, int n2) {
        this.x = n;
        this.y = n2;
        this.recalcSize();
        if (!this.expanded) {
            return;
        }
        int n3 = this.y;
        int n4 = this.x + this.width;
        int n5 = 0;
        for (SubSetRangeTag subSetRangeTag : this.sortedtags) {
            if (++n5 <= this.getScrolledSlots()) continue;
            subSetRangeTag.position(n4, n3);
            if ((n3 += 18) < this.y + this.height) continue;
            break;
        }
    }

    public void recalcSize() {
        int n;
        int n2 = LayoutManager.dropDown.y + LayoutManager.dropDown.maxheight + LayoutManager.dropDown.height - this.y;
        int n3 = this.y - LayoutManager.dropDown.height;
        this.contentheight = this.getNumSlots() * 18;
        if (this.contentheight > n2) {
            if (this.contentheight <= n2 + n3) {
                this.y -= this.contentheight - n2;
                n2 = this.contentheight;
            } else {
                this.y -= n3;
                n2 += n3;
            }
        }
        if (this.contentheight > n2) {
            this.height = n2 / 18 * 18;
            this.hasscroll = true;
        } else {
            this.hasscroll = false;
            this.height = this.contentheight;
        }
        this.slotwidth = 0;
        qncw qncw2 = NEIClientUtils.mc()._z;
        for (SubSetRangeTag subSetRangeTag : this.sortedtags) {
            int n4 = qncw2._b(subSetRangeTag.name);
            if (n4 <= this.slotwidth) continue;
            this.slotwidth = n4;
        }
        if (this.validranges != null && (n = this.validranges.getWidth()) > this.slotwidth) {
            this.slotwidth = n;
        }
        this.slotwidth += 2;
        this.width = this.slotwidth;
        if (this.hasscroll) {
            this.width += this.getScrollBarWidth();
        }
        int n5 = this.x + this.width - LayoutManager.dropDown.x;
        if (this.expanded && n5 > LayoutManager.dropDown.droppedwidth) {
            LayoutManager.dropDown.droppedwidth = n5;
        }
        this.hidden = n5 <= 0;
    }

    public int getWidthAtLevel(int n) {
        if (!this.expanded) {
            return 0;
        }
        if (n == 0) {
            return this.width;
        }
        for (SubSetRangeTag subSetRangeTag : this.sortedtags) {
            int n2 = subSetRangeTag.getWidthAtLevel(n - 1);
            if (n2 == 0) continue;
            return n2;
        }
        return 0;
    }

    public void resetHashes() {
        if (this.validranges != null) {
            this.validranges.resetHashes();
        }
        this.sortedtags = this.getSortedTagList();
        for (SubSetRangeTag subSetRangeTag : this.sortedtags) {
            subSetRangeTag.resetHashes();
        }
    }

    public void updateState(ItemVisibilityHash itemVisibilityHash) {
        boolean bl = false;
        boolean bl2 = false;
        for (SubSetRangeTag subSetRangeTag : this.sortedtags) {
            subSetRangeTag.updateState(itemVisibilityHash);
        }
        for (SubSetRangeTag subSetRangeTag : this.sortedtags) {
            if (subSetRangeTag.state == 1) {
                this.state = 1;
                return;
            }
            if (subSetRangeTag.state == 0) {
                if (bl) {
                    this.state = 1;
                    return;
                }
                bl2 = true;
                continue;
            }
            if (bl2) {
                this.state = 1;
                return;
            }
            bl = true;
        }
        if (this.validranges != null) {
            this.validranges.updateState(itemVisibilityHash);
            byte by = this.validranges.state;
            if (by == 1) {
                this.state = 1;
                return;
            }
            if (by == 0) {
                if (bl) {
                    this.state = 1;
                    return;
                }
                bl2 = true;
            } else {
                if (bl2) {
                    this.state = 1;
                    return;
                }
                bl = true;
            }
        }
        this.state = bl ? (byte)2 : (byte)0;
    }

    public void addItemIfInRange(int n, int n2, qoac qoac2) {
        if (this.validranges != null) {
            this.validranges.addItemIfInRange(n, n2, qoac2);
        }
        for (SubSetRangeTag subSetRangeTag : this.sortedtags) {
            subSetRangeTag.addItemIfInRange(n, n2, qoac2);
        }
    }

    public boolean isItemInRange(int n, int n2) {
        if (this.validranges != null && this.validranges.isItemInRange(n, n2)) {
            return true;
        }
        for (SubSetRangeTag subSetRangeTag : this.sortedtags) {
            if (!subSetRangeTag.isItemInRange(n, n2)) continue;
            return true;
        }
        return false;
    }

    public int getColourFromState() {
        if (this.state == 0) {
            return -10481648;
        }
        if (this.state == 1) {
            return -8359824;
        }
        return -1;
    }

    public void setSave(boolean bl) {
        this.saveTag = bl;
        this.saveConfig();
    }

    @Override
    public void save(PrintWriter printWriter, int n, String string, boolean bl) {
        if (this.saveTag) {
            super.save(printWriter, n, string, bl);
        } else {
            this.saveTagTree(printWriter, n, string);
        }
    }

    @Override
    public SubSetRangeTag useBraces() {
        return (SubSetRangeTag)super.useBraces();
    }

    @Override
    public SubSetRangeTag setComment(String string) {
        return (SubSetRangeTag)super.setComment(string);
    }

    @Override
    public SubSetRangeTag setPosition(int n) {
        this.position = n;
        if (this.saveTag) {
            this.saveConfig();
        }
        return this;
    }

    public String toString() {
        return this.qualifiedname;
    }

    public void addChildTags(List<SubSetRangeTag> list) {
        list.add(this);
        for (SubSetRangeTag subSetRangeTag : this.sortedtags) {
            subSetRangeTag.addChildTags(list);
        }
    }
}

