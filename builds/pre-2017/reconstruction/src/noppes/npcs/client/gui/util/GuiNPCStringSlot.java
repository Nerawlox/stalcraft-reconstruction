/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.client.gui.util;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiSlot;
import net.minecraft.client.renderer.Tessellator;
import noppes.npcs.EntityNPCInterface;
import noppes.npcs.client.gui.util.GuiNPCInterface;

public class GuiNPCStringSlot
extends GuiSlot {
    public String selected;
    public HashSet selectedList = new HashSet();
    public int size;
    private List list;
    private boolean multiSelect;
    private GuiNPCInterface parent;
    private long prevTime = 0L;

    public GuiNPCStringSlot(List list2, GuiNPCInterface guiNPCInterface, EntityNPCInterface entityNPCInterface, boolean bl, int n) {
        super(Minecraft._E(), guiNPCInterface.width, guiNPCInterface.height, 32, guiNPCInterface.height - 64, n);
        this.parent = guiNPCInterface;
        Collections.sort(list2, String.CASE_INSENSITIVE_ORDER);
        this.list = list2;
        this.multiSelect = bl;
        this.size = n;
    }

    public void setList(List list2) {
        Collections.sort(list2, String.CASE_INSENSITIVE_ORDER);
        this.list = list2;
        this.selected = "";
    }

    @Override
    protected int getSize() {
        return this.list.size();
    }

    @Override
    protected void elementClicked(int n, boolean bl) {
        long l = System.currentTimeMillis();
        if (this.selected != null && this.selected.equals(this.list.get(n)) && l - this.prevTime < 400L) {
            this.parent.doubleClicked();
        }
        this.selected = (String)this.list.get(n);
        if (this.selectedList.contains(this.selected)) {
            this.selectedList.remove(this.selected);
        } else {
            this.selectedList.add(this.selected);
        }
        this.parent.elementClicked();
        this.prevTime = l;
    }

    @Override
    protected boolean isSelected(int n) {
        return !this.multiSelect ? (this.selected == null ? false : this.selected.equals(this.list.get(n))) : this.selectedList.contains(this.list.get(n));
    }

    @Override
    protected int getContentHeight() {
        return this.list.size() * this.size;
    }

    @Override
    protected void drawBackground() {
        this.parent.drawDefaultBackground();
    }

    @Override
    protected void drawSlot(int n, int n2, int n3, int n4, Tessellator tessellator) {
        String string = (String)this.list.get(n);
        if (!this.parent.drawSlot(n, n2, n3, n4, tessellator, string)) {
            this.parent.drawString(this.parent.getFontRenderer(), string, n2 + 50, n3 + 3, 0xFFFFFF);
        }
    }

    public void clear() {
        this.list.clear();
    }
}

