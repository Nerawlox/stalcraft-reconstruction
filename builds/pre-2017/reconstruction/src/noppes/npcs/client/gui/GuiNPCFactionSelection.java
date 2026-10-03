/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.client.gui;

import java.util.HashMap;
import java.util.Vector;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import noppes.npcs.EntityNPCInterface;
import noppes.npcs.client.NoppesUtil;
import noppes.npcs.client.gui.util.GuiNPCInterface;
import noppes.npcs.client.gui.util.GuiNPCStringSlot;
import noppes.npcs.client.gui.util.GuiNpcButton;
import noppes.npcs.client.gui.util.GuiSelectionListener;
import noppes.npcs.client.gui.util.IScrollData;
import noppes.npcs.constants.EnumPacketType;

public class GuiNPCFactionSelection
extends GuiNPCInterface
implements IScrollData {
    public GuiSelectionListener listener;
    private GuiNPCStringSlot slot;
    private GuiScreen parent;
    private HashMap data = new HashMap();
    private int dialog;

    public GuiNPCFactionSelection(EntityNPCInterface entityNPCInterface, GuiScreen guiScreen, int n) {
        super(entityNPCInterface);
        this.drawDefaultBackground = false;
        this.title = "Select Dialog Category";
        this.parent = guiScreen;
        this.dialog = n;
        NoppesUtil.sendData(EnumPacketType.FactionsGet, new Object[0]);
        if (guiScreen instanceof GuiSelectionListener) {
            this.listener = (GuiSelectionListener)((Object)guiScreen);
        }
    }

    @Override
    public void initGui() {
        super.initGui();
        Vector vector = new Vector();
        this.slot = new GuiNPCStringSlot(vector, this, this.npc, false, 18);
        this.slot.registerScrollButtons(4, 5);
        this.addButton(2, new GuiNpcButton(2, this.width / 2 - 100, this.height - 41, 98, 20, "gui.back"));
        this.addButton(4, new GuiNpcButton(4, this.width / 2 + 2, this.height - 41, 98, 20, "mco.template.button.select"));
    }

    @Override
    public void drawScreen(int n, int n2, float f) {
        this.slot.drawScreen(n, n2, f);
        super.drawScreen(n, n2, f);
    }

    @Override
    protected void actionPerformed(GuiButton guiButton) {
        if (guiButton.id == 2) {
            this.close();
            NoppesUtil.openGUI(this.player, this.parent);
        }
        if (guiButton.id == 4) {
            this.doubleClicked();
        }
    }

    @Override
    public void doubleClicked() {
        if (this.slot.selected != null && !this.slot.selected.isEmpty()) {
            this.dialog = (Integer)this.data.get(this.slot.selected);
            this.close();
            NoppesUtil.openGUI(this.player, this.parent);
        }
    }

    @Override
    public void save() {
        if (this.dialog >= 0 && this.listener != null) {
            this.listener.selected(this.dialog);
        }
    }

    @Override
    public void setData(Vector vector, HashMap hashMap) {
        this.data = hashMap;
        this.slot.setList(vector);
        if (this.dialog >= 0) {
            for (String string : hashMap.keySet()) {
                if ((Integer)hashMap.get(string) != this.dialog) continue;
                this.slot.selected = string;
            }
        }
    }

    @Override
    public void setSelected(String string) {
    }
}

