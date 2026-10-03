/*
 * Decompiled with CFR 0.152.
 */
package cpw.mods.fml.client;

import cpw.mods.fml.client.GuiModList;
import cpw.mods.fml.client.GuiScrollingList;
import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.LoaderState;
import cpw.mods.fml.common.ModContainer;
import java.util.ArrayList;

public class GuiSlotModList
extends GuiScrollingList {
    private GuiModList parent;
    private ArrayList<ModContainer> mods;

    public GuiSlotModList(GuiModList guiModList, ArrayList<ModContainer> arrayList, int n) {
        super(guiModList.getMinecraftInstance(), n, guiModList.field_73881_g, 32, guiModList.field_73881_g - 65 + 4, 10, 35);
        this.parent = guiModList;
        this.mods = arrayList;
    }

    @Override
    protected int getSize() {
        return this.mods.size();
    }

    @Override
    protected void elementClicked(int n, boolean bl) {
        this.parent.selectModIndex(n);
    }

    @Override
    protected boolean isSelected(int n) {
        return this.parent.modIndexSelected(n);
    }

    @Override
    protected void drawBackground() {
        this.parent.func_73873_v_();
    }

    @Override
    protected int getContentHeight() {
        return this.getSize() * 35 + 1;
    }

    @Override
    protected void drawSlot(int n, int n2, int n3, int n4, htvf htvf2) {
        ModContainer modContainer = this.mods.get(n);
        if (Loader.instance().getModState(modContainer) == LoaderState.ModState.DISABLED) {
            this.parent.getFontRenderer()._b(this.parent.getFontRenderer()._a(modContainer.getName(), this.listWidth - 10), this.left + 3, n3 + 2, 0xFF2222);
            this.parent.getFontRenderer()._b(this.parent.getFontRenderer()._a(modContainer.getDisplayVersion(), this.listWidth - 10), this.left + 3, n3 + 12, 0xFF2222);
            this.parent.getFontRenderer()._b(this.parent.getFontRenderer()._a("DISABLED", this.listWidth - 10), this.left + 3, n3 + 22, 0xFF2222);
        } else {
            this.parent.getFontRenderer()._b(this.parent.getFontRenderer()._a(modContainer.getName(), this.listWidth - 10), this.left + 3, n3 + 2, 0xFFFFFF);
            this.parent.getFontRenderer()._b(this.parent.getFontRenderer()._a(modContainer.getDisplayVersion(), this.listWidth - 10), this.left + 3, n3 + 12, 0xCCCCCC);
            this.parent.getFontRenderer()._b(this.parent.getFontRenderer()._a(modContainer.getMetadata() != null ? modContainer.getMetadata().getChildModCountString() : "Metadata not found", this.listWidth - 10), this.left + 3, n3 + 22, 0xCCCCCC);
        }
    }
}

