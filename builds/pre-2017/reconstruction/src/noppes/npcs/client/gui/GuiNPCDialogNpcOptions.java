/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.client.gui;

import java.util.HashMap;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.nbt.NBTTagCompound;
import noppes.npcs.EntityNPCInterface;
import noppes.npcs.client.NoppesUtil;
import noppes.npcs.client.gui.GuiNPCDialogSelection;
import noppes.npcs.client.gui.util.GuiNPCInterface2;
import noppes.npcs.client.gui.util.GuiNpcButton;
import noppes.npcs.client.gui.util.GuiNpcLabel;
import noppes.npcs.client.gui.util.GuiSelectionListener;
import noppes.npcs.client.gui.util.IGuiData;
import noppes.npcs.constants.EnumPacketType;
import noppes.npcs.controllers.DialogOption;

public class GuiNPCDialogNpcOptions
extends GuiNPCInterface2
implements GuiSelectionListener,
IGuiData {
    private GuiScreen parent;
    private HashMap data = new HashMap();
    private int selectedSlot;

    public GuiNPCDialogNpcOptions(EntityNPCInterface entityNPCInterface, GuiScreen guiScreen) {
        super(entityNPCInterface);
        this.parent = guiScreen;
        this.drawDefaultBackground = true;
        NoppesUtil.sendData(EnumPacketType.DialogNpcGet, new Object[0]);
    }

    @Override
    public void initGui() {
        super.initGui();
        for (int i = 0; i < 12; ++i) {
            int n = i >= 6 ? 200 : 0;
            this.addButton(new GuiNpcButton(i + 20, this.guiLeft + 20 + n, this.guiTop + 13 + i % 6 * 22, 20, 20, "X"));
            this.addLabel(new GuiNpcLabel(i, "" + i, this.guiLeft + 6 + n, this.guiTop + 18 + i % 6 * 22, 0));
            String string = "dialog.selectoption";
            if (this.data.containsKey(i)) {
                string = ((DialogOption)this.data.get((Object)Integer.valueOf((int)i))).title;
            }
            this.addButton(new GuiNpcButton(i, this.guiLeft + 44 + n, this.guiTop + 13 + i % 6 * 22, 140, 20, string));
        }
    }

    @Override
    public void drawScreen(int n, int n2, float f) {
        super.drawScreen(n, n2, f);
    }

    @Override
    protected void actionPerformed(GuiButton guiButton) {
        int n;
        if (guiButton.id == 1) {
            NoppesUtil.openGUI(this.player, this.parent);
        }
        if (guiButton.id >= 0 && guiButton.id < 20) {
            this.close();
            this.selectedSlot = guiButton.id;
            n = -1;
            if (this.data.containsKey(guiButton.id)) {
                n = ((DialogOption)this.data.get((Object)Integer.valueOf((int)guiButton.id))).dialogId;
            }
            NoppesUtil.openGUI(this.player, new GuiNPCDialogSelection(this.npc, this, n));
        }
        if (guiButton.id >= 20 && guiButton.id < 40) {
            n = guiButton.id - 20;
            this.data.remove(n);
            NoppesUtil.sendData(EnumPacketType.DialogNpcRemove, n);
            this.initGui();
        }
    }

    @Override
    public void save() {
    }

    @Override
    public void selected(int n) {
        NoppesUtil.sendData(EnumPacketType.DialogNpcSet, this.selectedSlot, n);
    }

    @Override
    public void setGuiData(NBTTagCompound nBTTagCompound) {
        int n = nBTTagCompound._f("Position");
        DialogOption dialogOption = new DialogOption();
        dialogOption.readNBT(nBTTagCompound);
        this.data.put(n, dialogOption);
        this.initGui();
    }
}

