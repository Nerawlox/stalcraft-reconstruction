/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.client.gui;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import noppes.npcs.client.controllers.CloneController;
import noppes.npcs.client.gui.util.GuiCustomScroll;
import noppes.npcs.client.gui.util.GuiMenuSideButton;
import noppes.npcs.client.gui.util.GuiNpcButton;
import noppes.npcs.client.gui.util.GuiNpcTextField;
import noppes.npcs.client.gui.util.SubGuiInterface;

public class GuiNpcMobSpawnerSelector
extends SubGuiInterface {
    private static String search = "";
    private GuiCustomScroll scroll;
    private HashMap cloneData = new HashMap();
    private ArrayList list;
    private int activeTab = 1;

    public GuiNpcMobSpawnerSelector() {
        this.xSize = 256;
        this.closeOnEsc = true;
        this.setBackground("menubg.png");
    }

    @Override
    public void initGui() {
        super.initGui();
        if (this.scroll == null) {
            this.scroll = new GuiCustomScroll(this, 0);
            this.scroll.setSize(165, 188);
            this.scroll.guiLeft = this.guiLeft + 4;
            this.scroll.guiTop = this.guiTop + 26;
        } else {
            this.scroll.clear();
        }
        this.addScroll(this.scroll, this.mc);
        this.addTextField(new GuiNpcTextField(1, this, this.fontRenderer, this.guiLeft + 4, this.guiTop + 4, 165, 20, search));
        this.addButton(new GuiNpcButton(0, this.guiLeft + 171, this.guiTop + 80, 80, 20, "gui.done"));
        this.addButton(new GuiNpcButton(1, this.guiLeft + 171, this.guiTop + 103, 80, 20, "gui.cancel"));
        this.addSideButton(new GuiMenuSideButton(21, this.guiLeft - 69, this.guiTop + 2, 70, 22, "Tab 1"));
        this.addSideButton(new GuiMenuSideButton(22, this.guiLeft - 69, this.guiTop + 23, 70, 22, "Tab 2"));
        this.addSideButton(new GuiMenuSideButton(23, this.guiLeft - 69, this.guiTop + 44, 70, 22, "Tab 3"));
        this.addSideButton(new GuiMenuSideButton(24, this.guiLeft - 69, this.guiTop + 65, 70, 22, "Tab 4"));
        this.addSideButton(new GuiMenuSideButton(25, this.guiLeft - 69, this.guiTop + 86, 70, 22, "Tab 5"));
        this.addSideButton(new GuiMenuSideButton(26, this.guiLeft - 69, this.guiTop + 107, 70, 22, "Tab 6"));
        this.addSideButton(new GuiMenuSideButton(27, this.guiLeft - 69, this.guiTop + 128, 70, 22, "Tab 7"));
        this.addSideButton(new GuiMenuSideButton(28, this.guiLeft - 69, this.guiTop + 149, 70, 22, "Tab 8"));
        this.addSideButton(new GuiMenuSideButton(29, this.guiLeft - 69, this.guiTop + 170, 70, 22, "Tab 9"));
        this.getSideButton((int)(20 + this.activeTab)).active = true;
        this.showClones();
    }

    private void showClones() {
        this.cloneData.clear();
        ArrayList<String> arrayList = new ArrayList<String>();
        for (NBTTagCompound nBTTagCompound : CloneController.getClones()) {
            String string = nBTTagCompound._j("ClonedName");
            int n = 1;
            while (arrayList.contains(string)) {
                string = String.format("%s%s", nBTTagCompound._j("ClonedName"), ++n);
            }
            n = 1;
            if (nBTTagCompound._c("ClonedTab")) {
                n = nBTTagCompound._f("ClonedTab");
            }
            if (this.activeTab != n) continue;
            arrayList.add(string);
            this.cloneData.put(string, nBTTagCompound);
        }
        this.list = arrayList;
        this.scroll.setList(this.getSearchList());
    }

    @Override
    public void keyTyped(char c, int n) {
        super.keyTyped(c, n);
        if (!search.equals(this.getTextField(1).getText())) {
            search = this.getTextField(1).getText().toLowerCase();
            this.scroll.setList(this.getSearchList());
        }
    }

    private List getSearchList() {
        if (search.isEmpty()) {
            return new ArrayList(this.list);
        }
        ArrayList<String> arrayList = new ArrayList<String>();
        for (String string : this.list) {
            if (!string.toLowerCase().contains(search)) continue;
            arrayList.add(string);
        }
        return arrayList;
    }

    public NBTTagCompound getCompound() {
        String string = this.scroll.getSelected();
        if (string == null) {
            return null;
        }
        NBTTagCompound nBTTagCompound = (NBTTagCompound)this.cloneData.get(string);
        nBTTagCompound._p("StartPos");
        return nBTTagCompound;
    }

    @Override
    protected void actionPerformed(GuiButton guiButton) {
        if (guiButton.id == 0) {
            this.close();
        }
        if (guiButton.id == 1) {
            this.scroll.clear();
            this.close();
        }
        if (guiButton.id > 20) {
            this.activeTab = guiButton.id - 20;
            this.initGui();
        }
    }

    protected NBTTagList newDoubleNBTList(double ... dArray) {
        NBTTagList nBTTagList = new NBTTagList();
        double[] dArray2 = dArray;
        int n = dArray.length;
        for (int i = 0; i < n; ++i) {
            double d = dArray2[i];
            nBTTagList._a(new qoae(null, d));
        }
        return nBTTagList;
    }

    @Override
    public void save() {
    }
}

