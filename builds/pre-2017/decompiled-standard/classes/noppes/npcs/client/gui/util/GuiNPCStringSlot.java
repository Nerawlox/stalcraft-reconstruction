/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.client.gui.util;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import net.minecraft.client.xpzm;
import noppes.npcs.EntityNPCInterface;
import noppes.npcs.client.gui.util.GuiNPCInterface;

public class GuiNPCStringSlot
extends wovy {
    public String selected;
    public HashSet selectedList = new HashSet();
    public int size;
    private List list;
    private boolean multiSelect;
    private GuiNPCInterface parent;
    private long prevTime = 0L;

    public GuiNPCStringSlot(List list2, GuiNPCInterface guiNPCInterface, EntityNPCInterface entityNPCInterface, boolean bl, int n) {
        super(xpzm._E(), guiNPCInterface.field_73880_f, guiNPCInterface.field_73881_g, 32, guiNPCInterface.field_73881_g - 64, n);
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
    protected int func_77217_a() {
        return this.list.size();
    }

    @Override
    protected void func_77213_a(int n, boolean bl) {
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
    protected boolean func_77218_a(int n) {
        return !this.multiSelect ? (this.selected == null ? false : this.selected.equals(this.list.get(n))) : this.selectedList.contains(this.list.get(n));
    }

    @Override
    protected int func_77212_b() {
        return this.list.size() * this.size;
    }

    @Override
    protected void func_77221_c() {
        this.parent.func_73873_v_();
    }

    @Override
    protected void func_77214_a(int n, int n2, int n3, int n4, htvf htvf2) {
        String string = (String)this.list.get(n);
        if (!this.parent.drawSlot(n, n2, n3, n4, htvf2, string)) {
            this.parent.func_73731_b(this.parent.getFontRenderer(), string, n2 + 50, n3 + 3, 0xFFFFFF);
        }
    }

    public void clear() {
        this.list.clear();
    }
}

