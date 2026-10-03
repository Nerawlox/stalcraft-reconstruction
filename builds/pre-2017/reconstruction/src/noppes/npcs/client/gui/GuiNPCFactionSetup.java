/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.client.gui;

import java.util.HashMap;
import java.util.Vector;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.nbt.NBTTagCompound;
import noppes.npcs.EntityNPCInterface;
import noppes.npcs.client.NoppesUtil;
import noppes.npcs.client.gui.GuiAdvancedFactionOptions;
import noppes.npcs.client.gui.util.GuiCustomScroll;
import noppes.npcs.client.gui.util.GuiCustomScrollActionListener;
import noppes.npcs.client.gui.util.GuiNPCInterface2;
import noppes.npcs.client.gui.util.GuiNpcButton;
import noppes.npcs.client.gui.util.GuiNpcLabel;
import noppes.npcs.client.gui.util.GuiNpcTextField;
import noppes.npcs.client.gui.util.IScrollData;
import noppes.npcs.client.gui.util.ITextfieldListener;
import noppes.npcs.constants.EnumPacketType;

public class GuiNPCFactionSetup
extends GuiNPCInterface2
implements GuiCustomScrollActionListener,
IScrollData,
ITextfieldListener {
    private GuiCustomScroll scrollFactions;
    private HashMap data = new HashMap();

    public GuiNPCFactionSetup(EntityNPCInterface entityNPCInterface) {
        super(entityNPCInterface);
        NoppesUtil.sendData(EnumPacketType.FactionsGet, new Object[0]);
    }

    @Override
    public void initGui() {
        super.initGui();
        this.addLabel(new GuiNpcLabel(0, "faction.attackHostile", this.guiLeft + 4, this.guiTop + 25, 0x404040));
        this.addButton(new GuiNpcButton(0, this.guiLeft + 144, this.guiTop + 20, 40, 20, new String[]{"gui.no", "gui.yes"}, this.npc.advanced.attackOtherFactions ? 1 : 0));
        this.addLabel(new GuiNpcLabel(1, "faction.defend", this.guiLeft + 4, this.guiTop + 47, 0x404040));
        this.addButton(new GuiNpcButton(1, this.guiLeft + 144, this.guiTop + 42, 40, 20, new String[]{"gui.no", "gui.yes"}, this.npc.advanced.defendFaction ? 1 : 0));
        this.addLabel(new GuiNpcLabel(12, "faction.ondeath", this.guiLeft + 4, this.guiTop + 69, 0x404040));
        this.addButton(new GuiNpcButton(12, this.guiLeft + 90, this.guiTop + 64, 80, 20, "faction.points"));
        this.scrollFactions = new GuiCustomScroll(this, 0);
        this.scrollFactions.setWorldAndResolution(this.mc, 350, 250);
        this.scrollFactions.setSize(180, 200);
        this.scrollFactions.guiLeft = this.guiLeft + 200;
        this.scrollFactions.guiTop = this.guiTop + 4;
        this.addLabel(new GuiNpcLabel(13, "\u0420\u0435\u043f\u0443\u0442\u0430\u0446\u0438\u044f \u0437\u0430 \u0443\u0431\u0438\u0439\u0441\u0442\u0432\u043e", this.guiLeft + 4, this.guiTop + 91, 0x404040));
        this.addButton(new GuiNpcButton(13, this.guiLeft + 90, this.guiTop + 86, 80, 20, new String[]{"\u041e\u0442 \u0444\u0440\u0430\u043a\u0446\u0438\u0438", "\u041f\u0435\u0440\u0441\u043e\u043d\u0430\u043b\u044c\u043d\u0430\u044f"}, this.npc.advanced.customReputation ? 1 : 0));
        if (this.npc.advanced.customReputation) {
            this.addTextField(new GuiNpcTextField(7, this, this.fontRenderer, this.guiLeft + 90, this.guiTop + 108, 80, 20, this.npc.advanced.reputationForKill + ""));
            this.getTextField((int)7).numbersOnly = true;
            this.getTextField((int)7).min = Integer.MIN_VALUE;
        }
    }

    @Override
    public void drawScreen(int n, int n2, float f) {
        super.drawScreen(n, n2, f);
        this.scrollFactions.drawScreen(n, n2, f);
    }

    @Override
    public void buttonEvent(GuiButton guiButton) {
        GuiNpcButton guiNpcButton = (GuiNpcButton)guiButton;
        if (guiButton.id == 0) {
            boolean bl = this.npc.advanced.attackOtherFactions = guiNpcButton.getValue() == 1;
        }
        if (guiButton.id == 1) {
            boolean bl = this.npc.advanced.defendFaction = guiNpcButton.getValue() == 1;
        }
        if (guiNpcButton.id == 12) {
            Minecraft._E()._a(new GuiAdvancedFactionOptions(this, this.npc, this.npc.advanced.factions));
        }
        if (guiNpcButton.id == 13) {
            this.npc.advanced.customReputation = !this.npc.advanced.customReputation;
            this.initGui();
        }
    }

    @Override
    public void unFocused(GuiNpcTextField guiNpcTextField) {
        if (guiNpcTextField.id == 7) {
            this.npc.advanced.reputationForKill = guiNpcTextField.getInteger();
        }
    }

    @Override
    public void setData(Vector vector, HashMap hashMap) {
        String string = this.npc.getFaction().name;
        this.data = hashMap;
        this.scrollFactions.setList(vector);
        if (string != null) {
            this.setSelected(string);
        }
    }

    @Override
    public void mouseClicked(int n, int n2, int n3) {
        super.mouseClicked(n, n2, n3);
        if (n3 == 0 && this.scrollFactions != null) {
            this.scrollFactions.mouseClicked(n, n2, n3);
        }
    }

    @Override
    public void setSelected(String string) {
        this.scrollFactions.setSelected(string);
    }

    @Override
    public void customScrollClicked(int n, int n2, int n3, GuiCustomScroll guiCustomScroll) {
        if (guiCustomScroll.id == 0) {
            NoppesUtil.sendData(EnumPacketType.FactionSet, this.data.get(this.scrollFactions.getSelected()));
        }
    }

    @Override
    public void save() {
        NoppesUtil.sendData(EnumPacketType.MainmenuAdvancedSave, this.npc.advanced.writeToNBT(new NBTTagCompound()));
    }
}

