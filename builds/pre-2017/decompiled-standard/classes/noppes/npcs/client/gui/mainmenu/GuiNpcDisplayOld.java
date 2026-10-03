/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.client.gui.mainmenu;

import net.minecraft.entity.Entity;
import noppes.npcs.DataDisplay;
import noppes.npcs.EntityNPCInterface;
import noppes.npcs.client.NoppesUtil;
import noppes.npcs.client.gui.GuiNPCTextures;
import noppes.npcs.client.gui.GuiNpcModelSelection;
import noppes.npcs.client.gui.GuiNpcTextureCloaks;
import noppes.npcs.client.gui.GuiNpcTextureOverlays;
import noppes.npcs.client.gui.util.GuiNPCInterface2;
import noppes.npcs.client.gui.util.GuiNpcButton;
import noppes.npcs.client.gui.util.GuiNpcLabel;
import noppes.npcs.client.gui.util.GuiNpcTextField;
import noppes.npcs.client.gui.util.IGuiData;
import noppes.npcs.client.gui.util.ITextfieldListener;
import noppes.npcs.constants.EnumPacketType;

public class GuiNpcDisplayOld
extends GuiNPCInterface2
implements IGuiData,
ITextfieldListener {
    private DataDisplay display;

    public GuiNpcDisplayOld(EntityNPCInterface entityNPCInterface) {
        super(entityNPCInterface, 1);
        this.display = entityNPCInterface.display;
        NoppesUtil.sendData(EnumPacketType.MainmenuDisplayGet, new Object[0]);
    }

    @Override
    public void func_73866_w_() {
        super.func_73866_w_();
        this.addLabel(new GuiNpcLabel(0, "gui.name", this.guiLeft + 5, this.guiTop + 15, 0x404040));
        this.addTextField(new GuiNpcTextField(0, this, this.field_73886_k, this.guiLeft + 50, this.guiTop + 10, 200, 20, this.display.name));
        this.addButton(new GuiNpcButton(0, this.guiLeft + 253, this.guiTop + 10, 110, 20, new String[]{"display.show", "display.hide", "display.showAttacking"}, this.display.showName));
        this.addLabel(new GuiNpcLabel(1, "display.model", this.guiLeft + 5, this.guiTop + 38, 0x404040));
        this.addButton(new GuiNpcButton(1, this.guiLeft + 50, this.guiTop + 33, 110, 20, this.display.modelType.name));
        this.addLabel(new GuiNpcLabel(2, "display.size", this.guiLeft + 175, this.guiTop + 38, 0x404040));
        this.addTextField(new GuiNpcTextField(2, this, this.field_73886_k, this.guiLeft + 203, this.guiTop + 33, 40, 20, this.display.modelSize + ""));
        this.getTextField((int)2).numbersOnly = true;
        this.getTextField(2).setMinMaxDefault(1, 30, 5);
        this.addLabel(new GuiNpcLabel(3, "(1-30)", this.guiLeft + 246, this.guiTop + 38, 0x404040));
        this.addLabel(new GuiNpcLabel(4, "display.texture", this.guiLeft + 5, this.guiTop + 61, 0x404040));
        this.addTextField(new GuiNpcTextField(3, this, this.field_73886_k, this.guiLeft + 80, this.guiTop + 56, 200, 20, this.display.usingSkinUrl ? this.display.skinUsername : this.display.texture));
        this.addButton(new GuiNpcButton(3, this.guiLeft + 325, this.guiTop + 56, 38, 20, "mco.template.button.select"));
        this.addButton(new GuiNpcButton(2, this.guiLeft + 283, this.guiTop + 56, 40, 20, new String[]{"display.texture", "display.player"}, this.display.usingSkinUrl ? 1 : 0));
        this.getButton((int)3).field_73742_g = !this.display.usingSkinUrl;
        this.addLabel(new GuiNpcLabel(8, "display.textureCape", this.guiLeft + 5, this.guiTop + 84, 0x404040));
        this.addTextField(new GuiNpcTextField(8, this, this.field_73886_k, this.guiLeft + 80, this.guiTop + 79, 200, 20, this.display.cloakTexture));
        this.addButton(new GuiNpcButton(8, this.guiLeft + 283, this.guiTop + 79, 80, 20, "display.selectTexture"));
        this.addLabel(new GuiNpcLabel(9, "display.textureOverlay", this.guiLeft + 5, this.guiTop + 108, 0x404040));
        this.addTextField(new GuiNpcTextField(9, this, this.field_73886_k, this.guiLeft + 80, this.guiTop + 103, 200, 20, this.display.glowTexture));
        this.addButton(new GuiNpcButton(9, this.guiLeft + 283, this.guiTop + 103, 80, 20, "display.selectTexture"));
        this.addLabel(new GuiNpcLabel(5, "display.livingAnimation", this.guiLeft + 5, this.guiTop + 132, 0x404040));
        this.addButton(new GuiNpcButton(5, this.guiLeft + 120, this.guiTop + 127, 50, 20, new String[]{"gui.yes", "gui.no"}, this.display.NoLivingAnimation ? 1 : 0));
        this.addLabel(new GuiNpcLabel(6, "display.tint", this.guiLeft + 5, this.guiTop + 156, 0x404040));
        String string = Integer.toHexString(this.display.skinColor);
        while (string.length() < 6) {
            string = "0" + string;
        }
        this.addTextField(new GuiNpcTextField(6, this, this.field_73886_k, this.guiLeft + 120, this.guiTop + 151, 40, 20, string));
        this.getTextField(6).func_73794_g(this.display.skinColor);
        this.addLabel(new GuiNpcLabel(7, "display.visible", this.guiLeft + 5, this.guiTop + 180, 0x404040));
        this.addButton(new GuiNpcButton(7, this.guiLeft + 120, this.guiTop + 175, 50, 20, new String[]{"gui.yes", "gui.no", "gui.partly"}, this.display.visible));
    }

    @Override
    public void unFocused(GuiNpcTextField guiNpcTextField) {
        if (guiNpcTextField.id == 0) {
            if (!guiNpcTextField.isEmpty()) {
                this.display.name = guiNpcTextField.func_73781_b();
            } else {
                guiNpcTextField.func_73782_a(this.display.name);
            }
        } else if (guiNpcTextField.id == 2) {
            this.display.modelSize = guiNpcTextField.getInteger();
        } else if (guiNpcTextField.id == 3) {
            if (this.display.usingSkinUrl) {
                this.display.skinUsername = guiNpcTextField.func_73781_b();
            } else {
                this.display.texture = guiNpcTextField.func_73781_b();
            }
        } else if (guiNpcTextField.id == 6) {
            int n;
            boolean bl = false;
            try {
                n = Integer.parseInt(guiNpcTextField.func_73781_b(), 16);
            }
            catch (NumberFormatException numberFormatException) {
                n = 0xFFFFFF;
            }
            this.display.skinColor = n;
            guiNpcTextField.func_73794_g(this.display.skinColor);
        } else if (guiNpcTextField.id == 8) {
            this.display.cloakTexture = guiNpcTextField.func_73781_b();
        } else if (guiNpcTextField.id == 9) {
            this.display.glowTexture = guiNpcTextField.func_73781_b();
        }
    }

    @Override
    protected void func_73875_a(jiok jiok2) {
        GuiNpcButton guiNpcButton = (GuiNpcButton)jiok2;
        if (guiNpcButton.field_73741_f == 0) {
            this.display.showName = guiNpcButton.getValue();
        }
        if (guiNpcButton.field_73741_f == 1) {
            NoppesUtil.openGUI(this.player, new GuiNpcModelSelection(this.npc, this));
        }
        if (guiNpcButton.field_73741_f == 2) {
            this.display.usingSkinUrl = guiNpcButton.getValue() == 1;
            boolean bl = this.getButton((int)3).field_73742_g = !this.display.usingSkinUrl;
            if (this.display.usingSkinUrl) {
                this.getTextField(3).func_73782_a(this.display.skinUsername);
            } else {
                this.getTextField(3).func_73782_a(this.npc.display.texture);
            }
        } else if (guiNpcButton.field_73741_f == 3) {
            NoppesUtil.openGUI(this.player, new GuiNPCTextures(this.npc, this));
        } else if (guiNpcButton.field_73741_f == 5) {
            this.display.NoLivingAnimation = guiNpcButton.getValue() == 1;
        } else if (guiNpcButton.field_73741_f == 7) {
            this.display.visible = guiNpcButton.getValue();
        } else if (guiNpcButton.field_73741_f == 8) {
            NoppesUtil.openGUI(this.player, new GuiNpcTextureCloaks(this.npc, this));
        } else if (guiNpcButton.field_73741_f == 9) {
            NoppesUtil.openGUI(this.player, new GuiNpcTextureOverlays(this.npc, this));
        }
    }

    @Override
    public void save() {
        this.field_73882_e._s._c(this.npc);
        this.field_73882_e._s._b((Entity)this.npc);
        NoppesUtil.sendData(EnumPacketType.MainmenuDisplaySave, this.display.writeToNBT(new qoac()));
    }

    @Override
    public void setGuiData(qoac qoac2) {
        this.display.readToNBT(qoac2);
        this.func_73866_w_();
    }
}

