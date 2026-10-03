/*
 * Decompiled with CFR 0.152.
 */
package codechicken.nei;

import codechicken.core.gui.GuiDraw;
import codechicken.nei.Button;
import codechicken.nei.DropDownFile;
import codechicken.nei.ItemList;
import codechicken.nei.ItemVisibilityHash;
import codechicken.nei.LayoutManager;
import codechicken.nei.NEIClientConfig;
import codechicken.nei.NEIClientUtils;
import codechicken.nei.SaveLoadButton;
import codechicken.nei.Widget;
import java.awt.Dimension;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.GL11;

public class DropDownWidget
extends Widget {
    public DropDownFile file = DropDownFile.dropDownInstance;
    private int dropDowna;
    private long lastclicktime;
    private ArrayList<String> mouseovernamestack = new ArrayList();
    private boolean mouseoverTickRecorded;
    public boolean canChangeMouseOver = true;
    public cvzo hoverItem;
    public SaveLoadButton[] stateButtons = new SaveLoadButton[7];
    public Button[] deleteButtons = new Button[7];
    public int maxheight;
    public int droppedwidth;
    private int relx;
    private int hiddenlevel;
    private LinkedList<Integer> hiddenstack = new LinkedList();
    public static boolean texturedButtons;
    private static final int stacklatency = 4;

    public DropDownWidget() {
        for (int i = 0; i < 7; ++i) {
            final int n = i;
            this.stateButtons[i] = new SaveLoadButton("VIS"){

                @Override
                public void onTextChange() {
                    qoac qoac2 = NEIClientConfig.global.nbt._m("vis");
                    NEIClientConfig.global.nbt._a("vis", (huhy)qoac2);
                    qoac qoac3 = qoac2._m("statename");
                    qoac2._a("statename", (huhy)qoac3);
                    qoac3._a("" + n, this.label);
                    NEIClientConfig.global.saveNBT();
                }

                @Override
                public boolean onButtonPress(boolean bl) {
                    if (bl) {
                        return false;
                    }
                    if (ItemVisibilityHash.isStateSaved(n)) {
                        NEIClientConfig.vishash.loadState(n);
                    } else {
                        NEIClientConfig.vishash.saveState(n);
                    }
                    return true;
                }
            };
            this.deleteButtons[i] = new Button("x"){

                @Override
                public boolean onButtonPress(boolean bl) {
                    if (!bl) {
                        NEIClientConfig.vishash.clearState(n);
                        return true;
                    }
                    return false;
                }
            };
            this.stateButtons[i].height = 20;
            this.deleteButtons[i].width = 16;
            this.deleteButtons[i].height = 16;
        }
    }

    @Override
    public void draw(int n, int n2) {
        this.hoverItem = null;
        boolean bl = super.contains(n, n2);
        texturedButtons = LayoutManager.getLayoutStyle().texturedButtons();
        if (!texturedButtons) {
            GuiDraw.drawRect(this.x, this.y, this.width, this.height, bl ? -297791480 : -301989888);
            GuiDraw.drawStringC(NEIClientUtils.translate("inventory.item_subsets", new Object[0]), this.x, this.y, this.width, this.height, -1);
        } else {
            GL11.glDisable(2896);
            GuiDraw.changeTexture("textures/gui/widgets.png");
            GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
            int n3 = bl ? 2 : 1;
            LayoutManager.drawButtonBackground(this.x - 1, this.y, this.width + 2, this.height, true, n3);
            GuiDraw.drawStringC(NEIClientUtils.translate("inventory.item_subsets", new Object[0]), this.x + this.width / 2, this.y + (this.height - 8) / 2, bl ? 0xFFFFA0 : 0xE0E0E0);
        }
        if (this.getDropDown() == 1) {
            if (this.mouseovernamestack.size() == 0) {
                this.setDropDown(0);
                return;
            }
            this.updateMouseOver(n, n2);
            this.updatePosition(n, n2);
            this.file.draw(n, n2);
        } else if (this.getDropDown() == 2) {
            this.updateStatePosition();
            this.drawStateButtons(n, n2);
        }
    }

    private void drawStateButtons(int n, int n2) {
        for (int i = 0; i < 7; ++i) {
            this.stateButtons[i].draw(n, n2);
            this.deleteButtons[i].draw(n, n2);
        }
    }

    private void updateStatePosition() {
        int n;
        int n2 = 0;
        for (n = 0; n < 7; ++n) {
            this.deleteButtons[n].x = -1000;
            this.stateButtons[n].y = this.height + 2 + 22 * n;
            qoac qoac2 = NEIClientConfig.global.nbt._m("vis");
            NEIClientConfig.global.nbt._a("vis", (huhy)qoac2);
            qoac qoac3 = qoac2._m("statename");
            qoac2._a("statename", (huhy)qoac3);
            String string = qoac3._j("" + n);
            if (qoac3._b("" + n) == null) {
                string = "" + (n + 1);
                qoac3._a("" + n, string);
            }
            this.stateButtons[n].label = string;
            this.stateButtons[n].saved = ItemVisibilityHash.isStateSaved(n);
            int n3 = GuiDraw.getStringWidth(this.stateButtons[n].getRenderLabel()) + 26;
            if (n3 + 22 > this.width) {
                n3 = this.width - 22;
            }
            if (n3 <= n2) continue;
            n2 = n3;
        }
        n = this.x + (this.width - (n2 + 20)) / 2;
        for (int i = 0; i < 7; ++i) {
            this.stateButtons[i].width = n2;
            this.stateButtons[i].x = n;
            if (!this.stateButtons[i].saved) continue;
            this.deleteButtons[i].x = this.stateButtons[i].x + n2 + 2;
            this.deleteButtons[i].y = this.stateButtons[i].y + 2;
        }
    }

    private void updateMouseOver(int n, int n2) {
        String string = this.file.updateMouseOver(n, n2, this.mouseovernamestack.get(0));
        if (!this.mouseoverTickRecorded) {
            if (this.canChangeMouseOver) {
                String string2 = this.mouseovernamestack.get(this.mouseovernamestack.size() - 1);
                String string3 = this.mouseovernamestack.get(0);
                if (!string.equals(string2)) {
                    for (int i = 0; i < this.mouseovernamestack.size(); ++i) {
                        this.mouseovernamestack.set(i, string3);
                    }
                }
                this.mouseovernamestack.add(string);
            } else {
                this.mouseovernamestack.add(this.mouseovernamestack.get(this.mouseovernamestack.size() - 1));
            }
            this.mouseoverTickRecorded = true;
        }
        if (this.mouseovernamestack.get(0).equals("") && !LayoutManager.dropDown.contains(n, n2)) {
            this.setDropDown(0);
        }
    }

    private void updatePosition(int n, int n2) {
        this.rehashMaxHeight();
        while (true) {
            int n3;
            this.droppedwidth = 0;
            this.file.position(this.x + this.relx, this.y + this.height);
            if (this.droppedwidth > this.width) {
                n3 = this.file.getWidthAtLevel(this.hiddenlevel);
                if (n - n3 < this.x) {
                    n3 = this.droppedwidth - this.width;
                }
                DropDownWidget.moveMouse(-n3, 0);
                n -= n3;
                this.relx -= n3;
                this.hiddenstack.addLast(n3);
                ++this.hiddenlevel;
                continue;
            }
            if (this.relx >= 0 || this.width - this.droppedwidth <= this.hiddenstack.getLast()) break;
            n3 = this.hiddenstack.getLast();
            if (!this.mouseovernamestack.get(0).equals("")) {
                DropDownWidget.moveMouse(n3, 0);
                n += n3;
            }
            this.relx += n3;
            this.hiddenstack.removeLast();
            --this.hiddenlevel;
        }
    }

    public static void moveMouse(int n, int n2) {
        Dimension dimension = GuiDraw.displayRes();
        Dimension dimension2 = GuiDraw.displaySize();
        Mouse.setCursorPosition(Mouse.getX() + n * dimension2.width / dimension.width, Mouse.getY() + n2 * dimension2.height / dimension.height);
    }

    private void rehashMaxHeight() {
        this.maxheight = GuiDraw.displaySize().height - this.height - this.y - 25;
        this.maxheight = this.maxheight / 18 * 18;
    }

    @Override
    public boolean handleClick(int n, int n2, int n3) {
        if (super.contains(n, n2)) {
            if (n3 == 0) {
                if (System.currentTimeMillis() - this.lastclicktime < 300L) {
                    this.file.showAllItems();
                    this.file.updateState();
                    ItemList.updateSearch();
                    NEIClientConfig.vishash.save();
                }
                this.setDropDown(1);
                this.lastclicktime = System.currentTimeMillis();
            } else if (n3 == 1) {
                if (this.getDropDown() == 2) {
                    this.setDropDown(0);
                } else {
                    this.setDropDown(2);
                }
            }
            return true;
        }
        if (this.getDropDown() == 1) {
            return this.file.click(n, n2, n3);
        }
        if (this.getDropDown() == 2) {
            return this.processStateClick(n, n2, n3);
        }
        return false;
    }

    private boolean processStateClick(int n, int n2, int n3) {
        for (int i = 0; i < 7; ++i) {
            if ((!this.stateButtons[i].contains(n, n2) || !this.stateButtons[i].handleClick(n, n2, n3)) && (!this.deleteButtons[i].contains(n, n2) || !this.deleteButtons[i].handleClick(n, n2, n3))) continue;
            return true;
        }
        this.setDropDown(0);
        return false;
    }

    @Override
    public boolean handleKeyPress(int n, char c) {
        for (int i = 0; i < 7; ++i) {
            if (!this.stateButtons[i].handleKeyPress(n, c)) continue;
            return true;
        }
        return false;
    }

    @Override
    public void onGuiClick(int n, int n2) {
        if (this.getDropDown() == 2) {
            for (int i = 0; i < 7; ++i) {
                this.stateButtons[i].onGuiClick(n, n2);
            }
            if (!this.contains(n, n2)) {
                this.setDropDown(0);
            }
        }
    }

    @Override
    public void mouseUp(int n, int n2, int n3) {
        if (this.getDropDown() == 1) {
            this.file.mouseUp(n, n2, n3);
        }
    }

    @Override
    public boolean contains(int n, int n2) {
        return super.contains(n, n2) || this.getDropDown() == 1 && this.file.contains(n, n2) || this.getDropDown() == 2 && this.statesContain(n, n2);
    }

    private boolean statesContain(int n, int n2) {
        for (int i = 0; i < 7; ++i) {
            if (!this.stateButtons[i].contains(n, n2) && !this.deleteButtons[i].contains(n, n2)) continue;
            return true;
        }
        return false;
    }

    @Override
    public boolean onMouseWheel(int n, int n2, int n3) {
        if (this.getDropDown() == 1) {
            this.file.onMouseWheel(-n);
            return true;
        }
        return false;
    }

    public void setHoverItem(cvzo cvzo2) {
        this.hoverItem = cvzo2;
    }

    @Override
    public void update() {
        if (this.getDropDown() == 1) {
            if (this.mouseovernamestack.size() == 0) {
                this.setDropDown(0);
                return;
            }
            this.mouseovernamestack.remove(0);
            if (!this.mouseoverTickRecorded) {
                this.mouseovernamestack.add(this.mouseovernamestack.get(this.mouseovernamestack.size() - 1));
            }
            this.mouseoverTickRecorded = false;
        } else if (this.getDropDown() == 2) {
            for (int i = 0; i < 7; ++i) {
                this.stateButtons[i].update();
            }
        }
    }

    public void setDropDown(int n) {
        if (n == 1) {
            this.mouseoverTickRecorded = false;
            this.mouseovernamestack.clear();
            for (int i = 0; i < 4; ++i) {
                this.mouseovernamestack.add("");
            }
        }
        this.dropDowna = n;
    }

    public int getDropDown() {
        return this.dropDowna;
    }

    @Override
    public cvzo getStackMouseOver(int n, int n2) {
        return this.hoverItem;
    }

    @Override
    public List<String> handleTooltip(int n, int n2, List<String> list) {
        return list;
    }
}

