/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.client.gui.player;

import java.util.ArrayList;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiYesNo;
import net.minecraft.nbt.NBTTagCompound;
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
    public void initGui() {
        super.initGui();
        if (this.scroll == null) {
            this.scroll = new GuiCustomScroll(this, 0);
            this.scroll.setSize(165, 186);
            this.scroll.guiLeft = this.guiLeft + 4;
            this.scroll.guiTop = this.guiTop + 4;
        }
        this.addScroll(this.scroll, this.mc);
        String string = tdpx._a("mailbox.name");
        int n = (this.xSize - this.fontRenderer._b(string)) / 2;
        this.addLabel(new GuiNpcLabel(0, string, this.guiLeft + n, this.guiTop - 8, 0xFFFFFF));
        if (this.selected != null) {
            this.addLabel(new GuiNpcLabel(3, tdpx._a("mailbox.sender") + ":", this.guiLeft + 170, this.guiTop + 6, 0x404040));
            this.addLabel(new GuiNpcLabel(1, this.selected.sender, this.guiLeft + 174, this.guiTop + 18, 0x404040));
            this.addLabel(new GuiNpcLabel(2, tdpx._a("mailbox.timesend", this.getTimePast()), this.guiLeft + 174, this.guiTop + 30, 0x404040));
        }
        this.addButton(new GuiNpcButton(0, this.guiLeft + 4, this.guiTop + 192, 82, 20, "mailbox.read"));
        this.addButton(new GuiNpcButton(1, this.guiLeft + 88, this.guiTop + 192, 82, 20, "selectWorld.deleteButton"));
        this.getButton((int)1).enabled = this.selected != null;
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
    public void confirmClicked(boolean bl, int n) {
        if (bl && this.selected != null) {
            NoppesUtilPlayer.sendData(EnumPlayerPacket.MailDelete, this.selected.time, this.selected.sender);
            this.selected = null;
        }
        NoppesUtil.openGUI(this.player, this);
    }

    @Override
    protected void actionPerformed(GuiButton guiButton) {
        if (this.scroll.selected >= 0) {
            if (guiButton.id == 0) {
                this.mc._a(new GuiMailmanWrite(this, this.selected.message, false));
            }
            if (guiButton.id == 1) {
                GuiYesNo guiYesNo = new GuiYesNo(this, "Confirm", tdpx._a("gui.delete"), 0);
                this.mc._a(guiYesNo);
            }
        }
    }

    @Override
    public void mouseClicked(int n, int n2, int n3) {
        super.mouseClicked(n, n2, n3);
        this.scroll.mouseClicked(n, n2, n3);
    }

    @Override
    public void keyTyped(char c, int n) {
        if (n == 1 || n == this.mc._M.keyBindInventory._d) {
            this.close();
        }
    }

    @Override
    public void save() {
    }

    @Override
    public void setGuiData(NBTTagCompound nBTTagCompound) {
        PlayerMailData playerMailData = new PlayerMailData();
        playerMailData.readNBT(nBTTagCompound);
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
        this.initGui();
        if (this.selected != null && !this.selected.beenRead) {
            this.selected.beenRead = true;
            NoppesUtilPlayer.sendData(EnumPlayerPacket.MailRead, this.selected.time, this.selected.sender);
        }
    }
}

