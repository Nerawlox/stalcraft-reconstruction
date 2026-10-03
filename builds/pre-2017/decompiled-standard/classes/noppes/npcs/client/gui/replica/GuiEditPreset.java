/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.client.gui.replica;

import gloomyfolken.mods.core.client.gui.engine.Dimension;
import gloomyfolken.mods.core.client.gui.engine.GuiHelper;
import gloomyfolken.mods.core.client.gui.engine.GuiScreenAdvanced;
import gloomyfolken.mods.core.client.gui.engine.Point;
import gloomyfolken.mods.core.client.gui.engine.action.GuiActionTextFieldChanged;
import gloomyfolken.mods.core.client.gui.engine.component.McTextField;
import net.minecraft.client.xpzm;
import noppes.npcs.client.NoppesUtil;
import noppes.npcs.client.gui.replica.GuiReplicas;
import noppes.npcs.constants.EnumPacketType;
import noppes.npcs.controllers.SoundPresetsController;

public class GuiEditPreset
extends GuiScreenAdvanced {
    private final SoundPresetsController.SoundPreset preset;

    public GuiEditPreset(gqjz gqjz2, SoundPresetsController.SoundPreset soundPreset) {
        super(GuiHelper.widgetsRenderer, 200, 130, gqjz2);
        this.preset = soundPreset;
    }

    @Override
    public void func_73866_w_() {
        super.func_73866_w_();
        GuiHelper.addBackground(this, this.guiLeft, this.guiTop, this.guiWidth, this.guiHeight, true);
        McTextField mcTextField = new McTextField(this, new Point(this.screenWidth / 2 - 75, this.screenHeight / 2 - 50), new Dimension(150, 30));
        mcTextField.setText(this.preset.title);
        this.getActionManager().registerActionHandler(mcTextField, GuiActionTextFieldChanged.class, guiActionTextFieldChanged -> {
            this.preset.title = ((McTextField)guiActionTextFieldChanged.component).getText();
        });
        this.addElement(mcTextField);
        GuiHelper.addButton(this, new Point(this.screenWidth / 2 - 75, this.screenHeight / 2), new Dimension(150, 30), "\u0420\u0435\u043f\u043b\u0438\u043a\u0438").onClick(guiActionButtonClick -> xpzm._E()._a(new GuiReplicas(this, this.preset.replicas)));
    }

    @Override
    public void closeScreen() {
        super.closeScreen();
        NoppesUtil.sendData(EnumPacketType.SaveSoundPreset, this.preset.id, this.preset.writeToNbt(new qoac()));
    }
}

