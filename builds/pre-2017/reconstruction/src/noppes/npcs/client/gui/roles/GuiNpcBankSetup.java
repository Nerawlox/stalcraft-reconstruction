/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.client.gui.roles;

import java.util.HashMap;
import java.util.Vector;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.nbt.NBTTagCompound;
import noppes.npcs.EntityNPCInterface;
import noppes.npcs.client.NoppesUtil;
import noppes.npcs.client.gui.util.GuiCustomScroll;
import noppes.npcs.client.gui.util.GuiCustomScrollActionListener;
import noppes.npcs.client.gui.util.GuiNPCInterface2;
import noppes.npcs.client.gui.util.IScrollData;
import noppes.npcs.constants.EnumPacketType;
import noppes.npcs.controllers.Bank;
import noppes.npcs.roles.RoleBank;

public class GuiNpcBankSetup
extends GuiNPCInterface2
implements GuiCustomScrollActionListener,
IScrollData {
    private GuiCustomScroll scroll;
    private HashMap data = new HashMap();
    private RoleBank role;

    public GuiNpcBankSetup(EntityNPCInterface entityNPCInterface) {
        super(entityNPCInterface);
        NoppesUtil.sendData(EnumPacketType.BanksGet, new Object[0]);
        this.role = (RoleBank)entityNPCInterface.roleInterface;
    }

    @Override
    public void initGui() {
        super.initGui();
        this.scroll = new GuiCustomScroll(this, 0);
        this.scroll.setWorldAndResolution(this.mc, 350, 250);
        this.scroll.setSize(200, 152);
        this.scroll.guiLeft = this.guiLeft + 85;
        this.scroll.guiTop = this.guiTop + 20;
    }

    @Override
    public void drawScreen(int n, int n2, float f) {
        super.drawScreen(n, n2, f);
        this.scroll.drawScreen(n, n2, f);
    }

    @Override
    protected void actionPerformed(GuiButton guiButton) {
    }

    @Override
    public void setData(Vector vector, HashMap hashMap) {
        String string = null;
        Bank bank = this.role.getBank();
        if (bank != null) {
            string = bank.name;
        }
        this.data = hashMap;
        this.scroll.setList(vector);
        if (string != null) {
            this.setSelected(string);
        }
    }

    @Override
    public void mouseClicked(int n, int n2, int n3) {
        super.mouseClicked(n, n2, n3);
        if (n3 == 0 && this.scroll != null) {
            this.scroll.mouseClicked(n, n2, n3);
        }
    }

    @Override
    public void setSelected(String string) {
        this.scroll.setSelected(string);
    }

    @Override
    public void customScrollClicked(int n, int n2, int n3, GuiCustomScroll guiCustomScroll) {
        if (guiCustomScroll.id == 0) {
            this.role.bankId = (Integer)this.data.get(this.scroll.getSelected());
            this.save();
        }
    }

    @Override
    public void save() {
        NoppesUtil.sendData(EnumPacketType.MainmenuAdvancedSave, this.npc.advanced.writeToNBT(new NBTTagCompound()));
    }
}

