/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.client.gui;

import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import noppes.npcs.EntityNPCInterface;
import noppes.npcs.client.NoppesUtil;
import noppes.npcs.client.gui.util.GuiNPCInterface;
import noppes.npcs.client.gui.util.GuiNpcButton;
import noppes.npcs.client.gui.util.GuiNpcLabel;
import noppes.npcs.client.gui.util.GuiNpcTextField;
import noppes.npcs.constants.EnumPacketType;

public class GuiNPCTransportCategoryEdit
extends GuiNPCInterface {
    private GuiScreen parent;
    private String name;
    private int id;

    public GuiNPCTransportCategoryEdit(EntityNPCInterface entityNPCInterface, GuiScreen guiScreen, String string, int n) {
        super(entityNPCInterface);
        this.parent = guiScreen;
        this.name = string;
        this.id = n;
        this.title = "Npc Transport Category";
    }

    @Override
    public void initGui() {
        super.initGui();
        this.addTextField(1, new GuiNpcTextField(1, this, this.fontRenderer, this.width / 2 - 40, 100, 140, 20, this.name));
        this.addLabel(new GuiNpcLabel(1, "Title:", this.width / 2 - 100 + 4, 105, 0xFFFFFF));
        this.addButton(2, new GuiNpcButton(2, this.width / 2 - 100, 210, 98, 20, "gui.back"));
        this.addButton(3, new GuiNpcButton(3, this.width / 2 + 2, 210, 98, 20, "Save"));
    }

    @Override
    public void drawScreen(int n, int n2, float f) {
        super.drawScreen(n, n2, f);
    }

    @Override
    protected void actionPerformed(GuiButton guiButton) {
        if (guiButton.id == 2) {
            NoppesUtil.openGUI(this.player, this.parent);
            NoppesUtil.sendData(EnumPacketType.TransportCategoriesGet, new Object[0]);
        }
        if (guiButton.id == 3) {
            this.save();
            NoppesUtil.openGUI(this.player, this.parent);
            NoppesUtil.sendData(EnumPacketType.TransportCategoriesGet, new Object[0]);
        }
    }

    @Override
    public void save() {
        String string = this.getTextField(1).getText();
        if (!string.trim().isEmpty()) {
            NoppesUtil.sendData(EnumPacketType.TransportCategorySave, string, this.id);
        }
    }

    @Override
    public void drawDefaultBackground() {
        this.drawBackground(0);
    }
}

