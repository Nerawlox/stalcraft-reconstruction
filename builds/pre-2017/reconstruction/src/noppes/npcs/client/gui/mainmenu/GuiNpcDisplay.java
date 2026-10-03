/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.client.gui.mainmenu;

import gloomyfolken.mods.core.client.gui.engine.Dimension;
import gloomyfolken.mods.core.client.gui.engine.GuiHelper;
import gloomyfolken.mods.core.client.gui.engine.Point;
import java.util.ArrayList;
import mods.pda.client.PdaClient;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.entity.Entity;
import net.minecraft.nbt.NBTTagCompound;
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

public class GuiNpcDisplay
extends GuiNPCInterface2
implements IGuiData,
ITextfieldListener {
    private DataDisplay display;

    public GuiNpcDisplay(EntityNPCInterface entityNPCInterface) {
        super(entityNPCInterface, 1);
        this.display = entityNPCInterface.display;
        NoppesUtil.sendData(EnumPacketType.MainmenuDisplayGet, new Object[0]);
        NoppesUtil.sendData(EnumPacketType.NpcAccess, new Object[0]);
    }

    @Override
    public void initGui() {
        super.initGui();
        this.addLabel(new GuiNpcLabel(0, "gui.name", this.guiLeft + 8, this.guiTop + 15, 0x404040));
        this.addTextField(new GuiNpcTextField(0, this, this.fontRenderer, this.guiLeft + 50, this.guiTop + 10, 200, 20, this.display.name));
        this.addButton(new GuiNpcButton(0, this.guiLeft + 253, this.guiTop + 10, 110, 20, new String[]{"display.show", "display.hide", "display.showAttacking"}, this.display.showName));
        this.addLabel(new GuiNpcLabel(1, "display.model", this.guiLeft + 8, this.guiTop + 38, 0x404040));
        this.addButton(new GuiNpcButton(1, this.guiLeft + 50, this.guiTop + 33, 110, 20, this.display.modelType.name));
        this.addLabel(new GuiNpcLabel(2, "display.size", this.guiLeft + 175, this.guiTop + 38, 0x404040));
        this.addTextField(new GuiNpcTextField(2, this, this.fontRenderer, this.guiLeft + 203, this.guiTop + 33, 40, 20, this.display.modelSize + ""));
        this.getTextField((int)2).numbersOnly = true;
        this.getTextField(2).setMinMaxDefault(1, 30, 5);
        this.addLabel(new GuiNpcLabel(3, "(1-30)", this.guiLeft + 246, this.guiTop + 38, 0x404040));
        this.addLabel(new GuiNpcLabel(4, "display.texture", this.guiLeft + 8, this.guiTop + 61, 0x404040));
        this.addTextField(new GuiNpcTextField(3, this, this.fontRenderer, this.guiLeft + 80, this.guiTop + 56, 200, 20, this.display.usingSkinUrl ? this.display.skinUsername : this.display.texture));
        this.addButton(new GuiNpcButton(3, this.guiLeft + 325, this.guiTop + 56, 38, 20, "mco.template.button.select"));
        this.addButton(new GuiNpcButton(2, this.guiLeft + 283, this.guiTop + 56, 40, 20, new String[]{"display.texture", "display.player"}, this.display.usingSkinUrl ? 1 : 0));
        this.getButton((int)3).enabled = !this.display.usingSkinUrl;
        this.addLabel(new GuiNpcLabel(8, "display.textureCape", this.guiLeft + 8, this.guiTop + 84, 0x404040));
        this.addTextField(new GuiNpcTextField(8, this, this.fontRenderer, this.guiLeft + 80, this.guiTop + 79, 200, 20, this.display.cloakTexture));
        this.addButton(new GuiNpcButton(8, this.guiLeft + 283, this.guiTop + 79, 80, 20, "display.selectTexture"));
        this.addLabel(new GuiNpcLabel(9, "display.textureOverlay", this.guiLeft + 8, this.guiTop + 108, 0x404040));
        this.addTextField(new GuiNpcTextField(9, this, this.fontRenderer, this.guiLeft + 80, this.guiTop + 103, 200, 20, this.display.glowTexture));
        this.addButton(new GuiNpcButton(9, this.guiLeft + 283, this.guiTop + 103, 80, 20, "display.selectTexture"));
        this.addLabel(new GuiNpcLabel(5, "display.livingAnimation", this.guiLeft + 8, this.guiTop + 132, 0x404040));
        this.addButton(new GuiNpcButton(5, this.guiLeft + 120, this.guiTop + 127, 50, 20, new String[]{"gui.yes", "gui.no"}, this.display.NoLivingAnimation ? 1 : 0));
        this.addLabel(new GuiNpcLabel(6, "display.tint", this.guiLeft + 8, this.guiTop + 156, 0x404040));
        String string = Integer.toHexString(this.display.skinColor);
        while (string.length() < 6) {
            string = "0" + string;
        }
        this.addTextField(new GuiNpcTextField(6, this, this.fontRenderer, this.guiLeft + 120, this.guiTop + 149, 40, 20, string));
        this.getTextField(6).setTextColor(this.display.skinColor);
        this.addLabel(new GuiNpcLabel(7, "display.visible", this.guiLeft + 8, this.guiTop + 178, 0x404040));
        this.addButton(new GuiNpcButton(7, this.guiLeft + 120, this.guiTop + 170, 50, 20, new String[]{"gui.yes", "gui.no", "gui.partly"}, this.display.visible));
        this.addLabel(new GuiNpcLabel(100, "\u041f\u043e\u0434\u0441\u043a\u0430\u0437\u043a\u0430 \u043e \u0432\u0437\u0430\u0438\u043c\u043e\u0434\u0435\u0439\u0441\u0442\u0432\u0438\u0438", this.guiLeft + 8, this.guiTop + 200, 0x404040));
        this.addButton(new GuiNpcButton(100, this.guiLeft + 120, this.guiTop + 191, 50, 20, new String[]{"gui.yes", "gui.no"}, this.display.showTip ? 0 : 1));
        this.addLabel(new GuiNpcLabel(101, "\u041a\u0440\u043e\u0432\u044c \u043f\u0440\u0438 \u0430\u0442\u0430\u043a\u0435", this.guiLeft + 190, this.guiTop + 132, 0x404040));
        this.addButton(new GuiNpcButton(101, this.guiLeft + 260, this.guiTop + 127, 50, 20, new String[]{"gui.yes", "gui.no"}, this.display.bloodStains ? 0 : 1));
        this.addLabel(new GuiNpcLabel(102, "\u0418\u043a\u043e\u043d\u043a\u0430 \u043d\u0430 \u043a\u0430\u0440\u0442\u0435", this.guiLeft + 190, this.guiTop + 156, 0x404040));
        this.addTextField(new GuiNpcTextField(10, this, this.fontRenderer, this.guiLeft + 260, this.guiTop + 149, 80, 20, this.display.iconName));
        this.addLabel(new GuiNpcLabel(103, "[?]", this.guiLeft + 345, this.guiTop + 156, 0x404040));
        if (!this.npcAccess) {
            this.disableAll(null);
        }
    }

    @Override
    public void drawScreen(int n, int n2, float f) {
        super.drawScreen(n, n2, f);
        int n3 = this.guiLeft + 345;
        int n4 = this.guiTop + 156;
        if (n >= n3 && n2 >= n4 && n2 < n3 + 10 && n2 < n4 + 10) {
            ArrayList<String> arrayList = new ArrayList<String>(PdaClient.NPC_ICONS_POS.keySet());
            arrayList.add("'-' to forcebly disable icon for npcs with role");
            GuiHelper.widgetsRenderer.drawHoveringText(arrayList, new Point(n3 * 2, n4 * 2), new Dimension(this.width, this.height));
        }
    }

    @Override
    public void unFocused(GuiNpcTextField guiNpcTextField) {
        if (guiNpcTextField.id == 0) {
            if (!guiNpcTextField.isEmpty()) {
                this.display.name = guiNpcTextField.getText();
            } else {
                guiNpcTextField.setText(this.display.name);
            }
        } else if (guiNpcTextField.id == 2) {
            this.display.modelSize = guiNpcTextField.getInteger();
        } else if (guiNpcTextField.id == 3) {
            if (this.display.usingSkinUrl) {
                this.display.skinUsername = guiNpcTextField.getText();
            } else {
                this.display.texture = guiNpcTextField.getText();
            }
        } else if (guiNpcTextField.id == 6) {
            int n;
            boolean bl = false;
            try {
                n = Integer.parseInt(guiNpcTextField.getText(), 16);
            }
            catch (NumberFormatException numberFormatException) {
                n = 0xFFFFFF;
            }
            this.display.skinColor = n;
            guiNpcTextField.setTextColor(this.display.skinColor);
        } else if (guiNpcTextField.id == 8) {
            this.display.cloakTexture = guiNpcTextField.getText();
        } else if (guiNpcTextField.id == 9) {
            this.display.glowTexture = guiNpcTextField.getText();
        } else if (guiNpcTextField.id == 10) {
            this.display.iconName = guiNpcTextField.getText();
        }
    }

    @Override
    protected void actionPerformed(GuiButton guiButton) {
        GuiNpcButton guiNpcButton = (GuiNpcButton)guiButton;
        if (guiNpcButton.id == 0) {
            this.display.showName = guiNpcButton.getValue();
        }
        if (guiNpcButton.id == 1) {
            NoppesUtil.openGUI(this.player, new GuiNpcModelSelection(this.npc, this));
        }
        if (guiNpcButton.id == 2) {
            this.display.usingSkinUrl = guiNpcButton.getValue() == 1;
            boolean bl = this.getButton((int)3).enabled = !this.display.usingSkinUrl;
            if (this.display.usingSkinUrl) {
                this.getTextField(3).setText(this.display.skinUsername);
            } else {
                this.getTextField(3).setText(this.npc.display.texture);
            }
        } else if (guiNpcButton.id == 3) {
            NoppesUtil.openGUI(this.player, new GuiNPCTextures(this.npc, this));
        } else if (guiNpcButton.id == 5) {
            this.display.NoLivingAnimation = guiNpcButton.getValue() == 1;
        } else if (guiNpcButton.id == 7) {
            this.display.visible = guiNpcButton.getValue();
        } else if (guiNpcButton.id == 8) {
            NoppesUtil.openGUI(this.player, new GuiNpcTextureCloaks(this.npc, this));
        } else if (guiNpcButton.id == 9) {
            NoppesUtil.openGUI(this.player, new GuiNpcTextureOverlays(this.npc, this));
        } else if (guiNpcButton.id == 100) {
            this.display.showTip = guiNpcButton.getValue() == 0;
        } else if (guiNpcButton.id == 101) {
            this.display.bloodStains = guiNpcButton.getValue() == 0;
        }
    }

    @Override
    public void save() {
        this.mc._s._c(this.npc);
        this.mc._s._b((Entity)this.npc);
        NoppesUtil.sendData(EnumPacketType.MainmenuDisplaySave, this.display.writeToNBT(new NBTTagCompound()));
    }

    @Override
    public void setGuiData(NBTTagCompound nBTTagCompound) {
        if (nBTTagCompound._c("NpcAccess")) {
            this.npcAccess = nBTTagCompound._o("NpcAccess");
        } else {
            this.display.readToNBT(nBTTagCompound);
        }
        this.initGui();
    }
}

