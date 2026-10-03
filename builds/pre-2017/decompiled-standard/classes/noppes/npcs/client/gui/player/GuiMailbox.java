/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.client.gui.player;

import java.util.ArrayList;
import net.minecraft.util.tdpx;
import noppes.npcs.NoppesUtilPlayer;
import noppes.npcs.client.NoppesUtil;
import noppes.npcs.client.gui.player.GuiMailmanWrite;
import noppes.npcs.client.gui.util.GuiCustomScroll;
import noppes.npcs.client.gui.util.GuiCustomScrollActionListener;
import noppes.npcs.client.gui.util.GuiNPCInterface;
import noppes.npcs.client.gui.util.GuiNpcButton;
import noppes.npcs.client.gui.util.GuiNpcLabel;
import noppes.npcs.client.gui.util.IGuiData;
import noppes.npcs.constants.EnumPlayerPacket;
import noppes.npcs.controllers.PlayerMail;
import noppes.npcs.controllers.PlayerMailData;

public class GuiMailbox
extends GuiNPCInterface
implements GuiCustomScrollActionListener,
IGuiData {
    private GuiCustomScroll scroll;
    private PlayerMailData data;
    private PlayerMail selected;

    public GuiMailbox() {
        this.xSize = 256;
        this.setBackground("menubg.png");
        NoppesUtilPlayer.sendData(EnumPlayerPacket.MailGet, new Object[0]);
    }

    @Override
    public void func_73866_w_() {
        super.func_73866_w_();
        if (this.scroll == null) {
            this.scroll = new GuiCustomScroll(this, 0);
            this.scroll.setSize(165, 186);
            this.scroll.guiLeft = this.guiLeft + 4;
            this.scroll.guiTop = this.guiTop + 4;
        }
        this.addScroll(this.scroll, this.field_73882_e);
        String string = tdpx._a("mailbox.name");
        int n = (this.xSize - this.field_73886_k._b(string)) / 2;
        this.addLabel(new GuiNpcLabel(0, string, this.guiLeft + n, this.guiTop - 8, 0xFFFFFF));
        if (this.selected != null) {
            this.addLabel(new GuiNpcLabel(3, tdpx._a("mailbox.sender") + ":", this.guiLeft + 170, this.guiTop + 6, 0x404040));
            this.addLabel(new GuiNpcLabel(1, this.selected.sender, this.guiLeft + 174, this.guiTop + 18, 0x404040));
            this.addLabel(new GuiNpcLabel(2, tdpx._a("mailbox.timesend", this.getTimePast()), this.guiLeft + 174, this.guiTop + 30, 0x404040));
        }
        this.addButton(new GuiNpcButton(0, this.guiLeft + 4, this.guiTop + 192, 82, 20, "mailbox.read"));
        this.addButton(new GuiNpcButton(1, this.guiLeft + 88, this.guiTop + 192, 82, 20, "selectWorld.deleteButton"));
        this.getButton((int)1).field_73742_g = this.selected != null;
    }

    private String getTimePast() {
        if (this.selected.timePast > 86400000L) {
            int n = (int)(this.selected.timePast / 86400000L);
            return n == 1 ? n + " " + tdpx._a("mailbox.day") : n + " " + tdpx._a("mailbox.days");
        }
        if (this.selected.timePast > 3600000L) {
            int n = (int)(this.selected.timePast / 3600000L);
            return n == 1 ? n + " " + tdpx._a("mailbox.hour") : n + " " + tdpx._a("mailbox.hours");
        }
        int n = (int)(this.selected.timePast / 60000L);
        return n == 1 ? n + " " + tdpx._a("mailbox.minutes") : n + " " + tdpx._a("mailbox.minutes");
    }

    @Override
    public void func_73878_a(boolean bl, int n) {
        if (bl && this.selected != null) {
            NoppesUtilPlayer.sendData(EnumPlayerPacket.MailDelete, this.selected.time, this.selected.sender);
            this.selected = null;
        }
        NoppesUtil.openGUI(this.player, this);
    }

    @Override
    protected void func_73875_a(jiok jiok2) {
        if (this.scroll.selected >= 0) {
            if (jiok2.field_73741_f == 0) {
                this.field_73882_e._a(new GuiMailmanWrite(this, this.selected.message, false));
            }
            if (jiok2.field_73741_f == 1) {
                lowa lowa2 = new lowa(this, "Confirm", tdpx._a("gui.delete"), 0);
                this.field_73882_e._a(lowa2);
            }
        }
    }

    @Override
    public void func_73864_a(int n, int n2, int n3) {
        super.func_73864_a(n, n2, n3);
        this.scroll.func_73864_a(n, n2, n3);
    }

    @Override
    public void func_73869_a(char c, int n) {
        if (n == 1 || n == this.field_73882_e._M.field_74315_B._d) {
            this.close();
        }
    }

    @Override
    public void save() {
    }

    @Override
    public void setGuiData(qoac qoac2) {
        PlayerMailData playerMailData = new PlayerMailData();
        playerMailData.readNBT(qoac2);
        ArrayList<String> arrayList = new ArrayList<String>();
        for (PlayerMail playerMail : playerMailData.playermail) {
            arrayList.add(playerMail.subject);
        }
        this.data = playerMailData;
        this.scroll.clear();
        this.selected = null;
        this.scroll.setUnsortedList(arrayList);
    }

    @Override
    public void customScrollClicked(int n, int n2, int n3, GuiCustomScroll guiCustomScroll) {
        this.selected = (PlayerMail)this.data.playermail.get(guiCustomScroll.selected);
        this.func_73866_w_();
        if (this.selected != null && !this.selected.beenRead) {
            this.selected.beenRead = true;
            NoppesUtilPlayer.sendData(EnumPlayerPacket.MailRead, this.selected.time, this.selected.sender);
        }
    }
}

