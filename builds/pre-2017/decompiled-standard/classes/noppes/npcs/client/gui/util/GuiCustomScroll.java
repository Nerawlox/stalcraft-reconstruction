/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.client.gui.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.function.Function;
import net.minecraft.util.ResourceLocation;
import noppes.npcs.client.gui.util.GuiCustomScrollActionListener;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.GL11;

public class GuiCustomScroll
extends gqjz {
    private final ResourceLocation resource;
    public int id;
    public int guiLeft = 0;
    public int guiTop = 0;
    public int selected;
    private List list;
    private int xSize;
    private int ySize;
    private HashSet selectedList;
    private int hover;
    private int listHeight;
    private int scrollY;
    private int maxScrollY;
    private int scrollHeight;
    private boolean isScrolling;
    private boolean multipleSelection = false;
    private GuiCustomScrollActionListener listener;
    private boolean isSorted = true;
    public IColorChecker colorChecker = WHITE;
    public Function<String, String> lineDecorator = Function.identity();
    private static IColorChecker WHITE = string -> 0xFFFFFF;

    public GuiCustomScroll(gqjz gqjz2, int n) {
        this.resource = new ResourceLocation("customnpcs", "textures/gui/misc.png");
        this.field_73880_f = 176;
        this.field_73881_g = 166;
        this.xSize = 176;
        this.ySize = 159;
        this.selected = -1;
        this.hover = -1;
        this.selectedList = new HashSet();
        this.listHeight = 0;
        this.scrollY = 0;
        this.scrollHeight = 0;
        this.isScrolling = false;
        if (gqjz2 instanceof GuiCustomScrollActionListener) {
            this.listener = (GuiCustomScrollActionListener)((Object)gqjz2);
        }
        this.list = new ArrayList();
        this.id = n;
    }

    public GuiCustomScroll(gqjz gqjz2, int n, boolean bl) {
        this(gqjz2, n);
        this.multipleSelection = bl;
    }

    public void setSize(int n, int n2) {
        this.ySize = n2;
        this.xSize = n;
        this.listHeight = 14 * this.list.size();
        this.scrollHeight = (int)((double)(this.ySize - 8) / (double)this.listHeight * (double)(this.ySize - 8));
        this.maxScrollY = this.listHeight - (this.ySize - 8) - 1;
    }

    @Override
    public void func_73863_a(int n, int n2, float f) {
        this.func_73733_a(this.guiLeft, this.guiTop, this.xSize + this.guiLeft, this.ySize + this.guiTop, -1072689136, -804253680);
        GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
        this.field_73882_e._h._a(this.resource);
        if (this.scrollHeight < this.ySize - 8) {
            this.drawScrollBar();
        }
        GL11.glPushMatrix();
        GL11.glRotatef(180.0f, 1.0f, 0.0f, 0.0f);
        GL11.glPopMatrix();
        GL11.glPushMatrix();
        GL11.glTranslatef(this.guiLeft, this.guiTop, 0.0f);
        GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
        this.hover = this.getMouseOver(n, n2);
        this.drawItems();
        GL11.glPopMatrix();
        if (this.scrollHeight < this.ySize - 8) {
            int n3;
            n -= this.guiLeft;
            n2 -= this.guiTop;
            if (Mouse.isButtonDown(0)) {
                if (n >= this.xSize - 11 && n < this.xSize - 6 && n2 >= 4 && n2 < this.ySize) {
                    this.isScrolling = true;
                }
            } else {
                this.isScrolling = false;
            }
            if (this.isScrolling) {
                this.scrollY = (n2 - 8) * this.listHeight / (this.ySize - 8) - this.scrollHeight;
                if (this.scrollY < 0) {
                    this.scrollY = 0;
                }
                if (this.scrollY > this.maxScrollY) {
                    this.scrollY = this.maxScrollY;
                }
            }
            if ((n3 = Mouse.getDWheel()) < 0) {
                this.scrollY += 14;
                if (this.scrollY > this.maxScrollY) {
                    this.scrollY = this.maxScrollY;
                }
            } else if (n3 > 0) {
                this.scrollY -= 14;
                if (this.scrollY < 0) {
                    this.scrollY = 0;
                }
            }
        }
    }

    public boolean mouseInOption(int n, int n2, int n3) {
        int n4 = 4;
        int n5 = 14 * n3 + 4 - this.scrollY;
        return n >= n4 - 1 && n < n4 + this.xSize - 11 && n2 >= n5 - 1 && n2 < n5 + 8;
    }

    protected void drawItems() {
        for (int i = 0; i < this.list.size(); ++i) {
            int n = 4;
            int n2 = 14 * i + 4 - this.scrollY;
            if (n2 < 4 || n2 + 12 >= this.ySize) continue;
            String string = (String)this.list.get(i);
            String string2 = this.lineDecorator.apply(string);
            if (!(this.multipleSelection && this.selectedList.contains(string) || !this.multipleSelection && this.selected == i)) {
                if (i == this.hover) {
                    this.field_73886_k._b(string2, n, n2, 0xFFFF00);
                    continue;
                }
                this.field_73886_k._b(string2, n, n2, this.colorChecker.getColor(string));
                continue;
            }
            this.func_73728_b(n - 2, n2 - 4, n2 + 10, -1);
            this.func_73728_b(n + this.xSize - 20, n2 - 4, n2 + 10, -1);
            this.func_73730_a(n - 2, n + this.xSize - 20, n2 - 3, -1);
            this.func_73730_a(n - 2, n + this.xSize - 20, n2 + 10, -1);
            this.field_73886_k._b(string2, n, n2, this.colorChecker.getColor(string));
        }
    }

    public String getSelected() {
        return this.selected != -1 && this.selected < this.list.size() ? (String)this.list.get(this.selected) : null;
    }

    public void setSelected(String string) {
        this.selected = this.list.indexOf(string);
    }

    private int getMouseOver(int n, int n2) {
        if ((n -= this.guiLeft) >= 4 && n < this.xSize - 4 && (n2 -= this.guiTop) >= 4 && n2 < this.ySize) {
            for (int i = 0; i < this.list.size(); ++i) {
                if (!this.mouseInOption(n, n2, i)) continue;
                return i;
            }
        }
        return -1;
    }

    @Override
    public void func_73864_a(int n, int n2, int n3) {
        if (n3 == 0 && this.hover >= 0) {
            if (this.multipleSelection) {
                if (this.selectedList.contains(this.list.get(this.hover))) {
                    this.selectedList.remove(this.list.get(this.hover));
                } else {
                    this.selectedList.add(this.list.get(this.hover));
                }
            } else {
                if (this.hover >= 0) {
                    this.selected = this.hover;
                }
                this.hover = -1;
            }
            if (this.listener != null) {
                this.listener.customScrollClicked(n, n2, n3, this);
            }
        }
    }

    private void drawScrollBar() {
        int n;
        int n2 = this.guiLeft + this.xSize - 10;
        int n3 = this.guiTop + (int)((double)this.scrollY / (double)this.listHeight * (double)(this.ySize - 8)) + 4;
        this.func_73729_b(n2, n3, this.xSize, 9, 5, 1);
        for (n = n3 + 1; n < n3 + this.scrollHeight - 1; ++n) {
            this.func_73729_b(n2, n, this.xSize, 10, 5, 1);
        }
        this.func_73729_b(n2, n, this.xSize, 11, 5, 1);
    }

    public boolean hasSelected() {
        return this.selected >= 0;
    }

    public void setUnsortedList(List list2) {
        this.isSorted = false;
        this.list = list2;
        this.setSize(this.xSize, this.ySize);
    }

    public void replace(String string, String string2) {
        String string3 = this.getSelected();
        this.list.remove(string);
        this.list.add(string2);
        if (this.isSorted) {
            Collections.sort(this.list, String.CASE_INSENSITIVE_ORDER);
        }
        if (string.equals(string3)) {
            string3 = string2;
        }
        this.selected = this.list.indexOf(string3);
        this.setSize(this.xSize, this.ySize);
    }

    public void clear() {
        this.list = new ArrayList();
        this.selected = -1;
        this.scrollY = 0;
        this.setSize(this.xSize, this.ySize);
    }

    public List getList() {
        return this.list;
    }

    public void setList(List list2) {
        this.isSorted = true;
        Collections.sort(list2, String.CASE_INSENSITIVE_ORDER);
        this.list = list2;
        this.setSize(this.xSize, this.ySize);
    }

    public HashSet getSelectedList() {
        return this.selectedList;
    }

    public void setSelectedList(HashSet hashSet) {
        this.selectedList = hashSet;
    }

    public static interface IColorChecker {
        public int getColor(String var1);
    }
}

