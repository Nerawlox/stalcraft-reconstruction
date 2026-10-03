/*
 * Decompiled with CFR 0.152.
 */
package codechicken.nei.config;

import codechicken.lib.inventory.InventoryUtils;
import codechicken.nei.ItemPanel;
import codechicken.nei.ItemPanelStack;
import codechicken.nei.config.DataDumper;
import codechicken.nei.forge.GuiContainerManager;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.LinkedList;

public class ItemPanelDumper
extends DataDumper {
    public ItemPanelDumper(String string) {
        super(string);
    }

    @Override
    public String[] header() {
        return new String[]{"Item ID", "Item meta", "Has NBT", "Display Name"};
    }

    @Override
    public Iterable<String[]> dump(int n) {
        LinkedList<String[]> linkedList = new LinkedList<String[]>();
        for (ItemPanel.ItemPanelObject itemPanelObject : ItemPanel.visibleitems) {
            if (!(itemPanelObject instanceof ItemPanelStack)) continue;
            cvzo cvzo2 = ((ItemPanelStack)itemPanelObject).item;
            linkedList.add(new String[]{Integer.toString(cvzo2._d), Integer.toString(InventoryUtils.actualDamage(cvzo2)), cvzo2._e == null ? "false" : "true", GuiContainerManager.itemDisplayNameShort(cvzo2).replaceAll("\u00a7.", "")});
        }
        return linkedList;
    }

    @Override
    public String renderName() {
        return this.translateN(this.name, new Object[0]);
    }

    @Override
    public String getFileName(String string) {
        return string + (this.getMode() == 0 ? ".csv" : ".nbt");
    }

    @Override
    public String dumpMessage(File file) {
        return this.translateN(this.name + ".dumped", "dumps/" + file.getName());
    }

    @Override
    public String modeButtonText() {
        return this.translateN(this.name + ".mode." + this.getMode(), new Object[0]);
    }

    @Override
    public void dumpTo(File file) throws IOException {
        if (this.getMode() == 0) {
            super.dumpTo(file);
        } else {
            this.dumpNBT(file);
        }
    }

    public void dumpNBT(File file) throws IOException {
        bsyv bsyv2 = new bsyv();
        for (ItemPanel.ItemPanelObject itemPanelObject : ItemPanel.visibleitems) {
            if (!(itemPanelObject instanceof ItemPanelStack)) continue;
            bsyv2._a(((ItemPanelStack)itemPanelObject).item._b(new qoac()));
        }
        qoac qoac2 = new qoac();
        qoac2._a("list", bsyv2);
        bsvf._a(qoac2, new FileOutputStream(file));
    }

    @Override
    public int modeCount() {
        return 2;
    }
}

