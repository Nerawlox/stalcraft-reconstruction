/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.client.gui.roles;

import java.util.HashMap;
import java.util.Vector;
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
    public void func_73866_w_() {
        super.func_73866_w_();
        this.scroll = new GuiCustomScroll(this, 0);
        this.scroll.func_73872_a(this.field_73882_e, 350, 250);
        this.scroll.setSize(200, 152);
        this.scroll.guiLeft = this.guiLeft + 85;
        this.scroll.guiTop = this.guiTop + 20;
    }

    @Override
    public void func_73863_a(int n, int n2, float f) {
        super.func_73863_a(n, n2, f);
        this.scroll.func_73863_a(n, n2, f);
    }

    @Override
    protected void func_73875_a(jiok jiok2) {
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
    public void func_73864_a(int n, int n2, int n3) {
        super.func_73864_a(n, n2, n3);
        if (n3 == 0 && this.scroll != null) {
            this.scroll.func_73864_a(n, n2, n3);
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
        NoppesUtil.sendData(EnumPacketType.MainmenuAdvancedSave, this.npc.advanced.writeToNBT(new qoac()));
    }
}

