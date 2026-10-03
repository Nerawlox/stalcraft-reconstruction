/*
 * Decompiled with CFR 0.152.
 */
package codechicken.nei;

import codechicken.core.gui.GuiDraw;
import codechicken.lib.config.ConfigFile;
import codechicken.nei.DropDownWidget;
import codechicken.nei.ItemVisibilityHash;
import codechicken.nei.LayoutManager;
import codechicken.nei.NEIClientConfig;
import codechicken.nei.NEIClientUtils;
import codechicken.nei.SubSetRangeTag;
import java.io.File;
import java.util.ArrayList;
import java.util.LinkedList;
import net.minecraft.client.xpzm;
import org.lwjgl.opengl.GL11;

public class DropDownFile
extends ConfigFile {
    public ArrayList<SubSetRangeTag> sortedtags = new ArrayList();
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
    public boolean hidden;
    public static final int slotheight = 18;
    public static DropDownFile dropDownInstance = new DropDownFile(new File(xpzm._E()._P, "config/NEISubset.cfg"));

    public DropDownFile(File file) {
        super(file);
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

    @Override
    public void saveConfig() {
        super.saveConfig();
    }

    public boolean thisContains(int n, int n2) {
        return n >= this.x && n < this.x + this.width && n2 >= this.y && n2 <= this.y + this.height;
    }

    public boolean contains(int n, int n2) {
        if (this.thisContains(n, n2)) {
            return true;
        }
        for (SubSetRangeTag subSetRangeTag : this.sortedtags) {
            if (!subSetRangeTag.contains(n, n2)) continue;
            return true;
        }
        return false;
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
        int n = this.childTagMap().size();
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
        this.processScrollMouse(n, n2);
        String string2 = "";
        int n3 = this.y;
        int n4 = this.x + (this.hasscroll ? this.getScrollBarWidth() : 0);
        int n5 = 0;
        for (SubSetRangeTag subSetRangeTag : this.sortedtags) {
            String string3;
            if (++n5 <= this.getScrolledSlots()) continue;
            if (n4 <= n && this.x + this.width > n && n3 <= n2 && n3 + 18 > n2) {
                string2 = subSetRangeTag.qualifiedname;
            }
            if (!(string3 = subSetRangeTag.updateMouseOver(n, n2, string)).equals("")) {
                string2 = string3;
            }
            n3 += 18;
        }
        return string2;
    }

    public boolean click(int n, int n2, int n3) {
        boolean bl = this.thisContains(n, n2);
        if (!bl) {
            for (SubSetRangeTag subSetRangeTag : this.sortedtags) {
                subSetRangeTag.click(n, n2, n3);
            }
        }
        int n4 = this.height - this.getScrollBarHeight();
        int n5 = this.y + (int)((double)((float)n4 * this.percentscrolled) + 0.5);
        int n6 = this.x + this.getScrollBarWidth();
        if (this.hasscroll && n3 == 0 && this.getScrollBarHeight() < this.height && n >= this.x && n <= this.x + this.getScrollBarWidth() && n2 >= this.y && n2 <= this.y + this.height) {
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
        this.scrollpercent += (float)n / (float)this.contentheight * 10.0f;
        if (this.scrollpercent > 1.0f) {
            this.scrollpercent = 1.0f;
        } else if (this.scrollpercent < 0.0f) {
            this.scrollpercent = 0.0f;
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
    }

    public void hideAllItems() {
        for (SubSetRangeTag subSetRangeTag : this.sortedtags) {
            subSetRangeTag.hideAllItems();
        }
    }

    public void showAllItems() {
        for (SubSetRangeTag subSetRangeTag : this.sortedtags) {
            subSetRangeTag.showAllItems();
        }
    }

    public void mouseUp(int n, int n2, int n3) {
        if (this.scrollclicky >= 0 && n3 == 0) {
            this.scrollclicky = -1;
        }
        for (SubSetRangeTag subSetRangeTag : this.sortedtags) {
            subSetRangeTag.mouseUp(n, n2, n3);
        }
    }

    public void draw(int n, int n2) {
        this.drawScrollBar();
        int n3 = this.y;
        int n4 = this.x + (this.hasscroll ? this.getScrollBarWidth() : 0);
        int n5 = 0;
        for (SubSetRangeTag subSetRangeTag : this.sortedtags) {
            if (++n5 <= this.getScrolledSlots()) continue;
            if (!this.hidden) {
                int n6;
                if (!DropDownWidget.texturedButtons) {
                    n6 = n >= n4 && n < n4 + this.slotwidth && n2 >= n3 && n2 < n3 + 18 ? 1 : 0;
                    GuiDraw.drawRect(n4, n3, this.slotwidth, 18, n6 != 0 ? -12578808 : -16777216);
                    GuiDraw.drawStringC(subSetRangeTag.name, n4, n3, this.slotwidth, 18, subSetRangeTag.getColourFromState(), subSetRangeTag.state == 0);
                } else {
                    GuiDraw.changeTexture("textures/gui/widgets.png");
                    if (subSetRangeTag.state == 1) {
                        GL11.glColor4f(0.65f, 0.65f, 0.65f, 1.0f);
                    } else {
                        GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
                    }
                    n6 = subSetRangeTag.state == 0 ? 0 : 1;
                    LayoutManager.drawButtonBackground(n4, n3, this.slotwidth, 18, false, n6);
                    int n7 = subSetRangeTag.state == 2 ? -2039584 : -6250336;
                    GuiDraw.drawStringC(subSetRangeTag.name, n4, n3, this.slotwidth, 18, n7);
                }
            }
            subSetRangeTag.draw(n, n2);
            if ((n3 += 18) < this.y + this.height) continue;
            break;
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
        int n2 = NEIClientUtils.getGuiContainer().field_73881_g - this.y;
        this.contentheight = this.childTagMap().size() * 18;
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
            int n3 = qncw2._b(subSetRangeTag.name);
            if (n3 <= this.slotwidth) continue;
            this.slotwidth = n3;
        }
        this.slotwidth += 2;
        this.width = this.slotwidth;
        if (this.hasscroll) {
            this.width += 5;
        }
        this.hidden = (n = this.x + this.width - LayoutManager.dropDown.x) <= 0;
    }

    public void resetHashes() {
        this.sortedtags = this.getSortedTagList();
        for (SubSetRangeTag subSetRangeTag : this.sortedtags) {
            subSetRangeTag.resetHashes();
        }
    }

    public void updateState() {
        ItemVisibilityHash itemVisibilityHash = NEIClientConfig.vishash;
        for (SubSetRangeTag subSetRangeTag : this.sortedtags) {
            subSetRangeTag.updateState(itemVisibilityHash);
        }
    }

    public void addItemIfInRange(int n, int n2, qoac qoac2) {
        for (SubSetRangeTag subSetRangeTag : this.sortedtags) {
            subSetRangeTag.addItemIfInRange(n, n2, qoac2);
        }
    }

    public int getWidthAtLevel(int n) {
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

    public Iterable<SubSetRangeTag> allTags() {
        LinkedList<SubSetRangeTag> linkedList = new LinkedList<SubSetRangeTag>();
        for (SubSetRangeTag subSetRangeTag : this.sortedtags) {
            subSetRangeTag.addChildTags(linkedList);
        }
        return linkedList;
    }

    static {
        dropDownInstance.setComment("You can put your own custom SubSet Ranges in here\nFollow the following format (replace {something} with what you want.\n{Parent}.{Name}=[{item1}],[{item2}],[{item3}-{item4}],[{item5}:{damage}],[{item6}:{damage1}-{damage2}]\nEg. Blocks.Nether = [87-89],[112-115]\nEg2. Birch = [17:2],[6:2]");
    }
}

