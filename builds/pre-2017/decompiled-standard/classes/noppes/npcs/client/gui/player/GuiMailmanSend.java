/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.client.gui.player;

import net.minecraft.util.tdpx;
import noppes.npcs.NoppesUtilPlayer;
import noppes.npcs.client.gui.player.GuiMailmanWrite;
import noppes.npcs.client.gui.util.GuiNPCInterface;
import noppes.npcs.client.gui.util.GuiNpcButton;
import noppes.npcs.client.gui.util.GuiNpcLabel;
import noppes.npcs.client.gui.util.GuiNpcTextField;
import noppes.npcs.client.gui.util.IGuiClose;
import noppes.npcs.client.gui.util.IGuiError;
import noppes.npcs.client.gui.util.ITextfieldListener;
import noppes.npcs.constants.EnumPlayerPacket;
import noppes.npcs.controllers.PlayerMail;

public class GuiMailmanSend
extends GuiNPCInterface
implements IGuiClose,
IGuiError,
ITextfieldListener {
    private GuiNpcLabel error;
    private PlayerMail mail;
    private String username = "";
    private qoac compound = new qoac();

    public GuiMailmanSend() {
        this.xSize = 256;
        this.setBackground("menubg.png");
        this.mail = new PlayerMail();
    }

    @Override
    public void func_73866_w_() {
        super.func_73866_w_();
        this.addLabel(new GuiNpcLabel(0, "mailbox.username", this.guiLeft + 4, this.guiTop + 19, 0x404040));
        this.addTextField(new GuiNpcTextField(0, this, this.field_73886_k, this.guiLeft + 60, this.guiTop + 14, 180, 20, this.username));
        this.addLabel(new GuiNpcLabel(1, "mailbox.subject", this.guiLeft + 4, this.guiTop + 49, 0x404040));
        this.addTextField(new GuiNpcTextField(1, this, this.field_73886_k, this.guiLeft + 60, this.guiTop + 44, 180, 20, this.mail.subject));
        this.addButton(new GuiNpcButton(2, this.guiLeft + 29, this.guiTop + 100, "mailbox.write"));
        this.error = new GuiNpcLabel(2, "", this.guiLeft + 4, this.guiTop + 160, 0xFF0000);
        this.addLabel(this.error);
        this.addButton(new GuiNpcButton(0, this.guiLeft + 26, this.guiTop + 190, 100, 20, "mailbox.send"));
        this.addButton(new GuiNpcButton(1, this.guiLeft + 130, this.guiTop + 190, 100, 20, "gui.cancel"));
    }

    @Override
    public void buttonEvent(jiok jiok2) {
        if (jiok2.field_73741_f == 0) {
            this.mail.sender = this.player.field_71092_bJ;
            this.mail.message = this.compound;
            NoppesUtilPlayer.sendData(EnumPlayerPacket.MailSend, this.username, this.mail.writeNBT());
        }
        if (jiok2.field_73741_f == 1) {
            this.field_73882_e._a((gqjz)null);
        }
        if (jiok2.field_73741_f == 2) {
            this.field_73882_e._a(new GuiMailmanWrite(this, this.compound, true));
        }
    }

    @Override
    public void save() {
    }

    @Override
    public void unFocused(GuiNpcTextField guiNpcTextField) {
        if (guiNpcTextField.id == 0) {
            this.username = guiNpcTextField.func_73781_b();
        }
        if (guiNpcTextField.id == 1) {
            this.mail.subject = guiNpcTextField.func_73781_b();
        }
    }

    @Override
    public void setError(int n, qoac qoac2) {
        if (n == 0) {
            this.error.label = tdpx._a("mailbox.errorUsername");
        }
        if (n == 1) {
            this.error.label = tdpx._a("mailbox.errorSubject");
        }
    }

    @Override
    public void setClose(int n, qoac qoac2) {
        this.player.func_71035_c(tdpx._a("mailbox.succes", qoac2._j("username")));
    }
}

