/*
 * Decompiled with CFR 0.152.
 */
package mods.regions.client;

import gloomyfolken.mods.core.client.gui.engine.Dimension;
import gloomyfolken.mods.core.client.gui.engine.GuiHelper;
import gloomyfolken.mods.core.client.gui.engine.GuiScreenAdvanced;
import gloomyfolken.mods.core.client.gui.engine.Point;
import gloomyfolken.mods.core.client.gui.engine.action.GuiActionTextFieldChanged;
import gloomyfolken.mods.core.client.gui.engine.component.McTextField;
import mods.regions.packet.PacketPresetBlock;

public class GuiPresetBlock
extends GuiScreenAdvanced {
    public final int x;
    public final int y;
    public final int z;
    public String presetName;
    public String regionName;

    public GuiPresetBlock(int n, int n2, int n3, String string, String string2) {
        this.x = n;
        this.y = n2;
        this.z = n3;
        this.presetName = string;
        this.regionName = string2;
    }

    @Override
    public void func_73866_w_() {
        super.func_73866_w_();
        GuiHelper.addBackground(this, this.screenWidth / 2 - 140, this.screenHeight / 2 - 75, 280, 230, true);
        GuiHelper.addLabel(this, "\u041d\u0430\u0437\u0432\u0430\u043d\u0438\u0435 \u0441\u0446\u0435\u043d\u0430\u0440\u043d\u043e\u0433\u043e \u0431\u043b\u043e\u043a\u0430: ", Point.zeroPoint).setCentered(this.screenWidth / 2, this.screenHeight / 2 - 45);
        McTextField mcTextField = new McTextField(this, new Point(this.screenWidth / 2 - 45, this.screenHeight / 2 - 30), new Dimension(90, 27), this.presetName);
        mcTextField.setMaxStringLength(100);
        this.actionManager.registerActionHandler(mcTextField, GuiActionTextFieldChanged.class, guiActionTextFieldChanged -> {
            this.presetName = ((McTextField)guiActionTextFieldChanged.component).getText();
        });
        this.addElement(mcTextField);
        GuiHelper.addLabel(this, "\u041d\u0430\u0437\u0432\u0430\u043d\u0438\u0435 \u0440\u0435\u0433\u0438\u043e\u043d\u0430 \u0434\u043b\u044f \u0432\u0441\u0442\u0430\u0432\u043a\u0438: ", Point.zeroPoint).setCentered(this.screenWidth / 2, this.screenHeight / 2 + 30);
        McTextField mcTextField2 = new McTextField(this, new Point(this.screenWidth / 2 - 45, this.screenHeight / 2 + 50), new Dimension(90, 27), this.regionName);
        mcTextField.setMaxStringLength(100);
        this.actionManager.registerActionHandler(mcTextField2, GuiActionTextFieldChanged.class, guiActionTextFieldChanged -> {
            this.regionName = ((McTextField)guiActionTextFieldChanged.component).getText();
        });
        this.addElement(mcTextField2);
        Dimension dimension = new Dimension(100, 38);
        GuiHelper.addButton(this, new Point(this.screenWidth / 2 - 105, this.screenHeight / 2 + 90), dimension, "\u041e\u0442\u043c\u0435\u043d\u0438\u0442\u044c").onClick(guiActionButtonClick -> this.closeScreen());
        GuiHelper.addButton(this, new Point(this.screenWidth / 2 + 5, this.screenHeight / 2 + 90), dimension, "\u0421\u043e\u0445\u0440\u0430\u043d\u0438\u0442\u044c").onClick(guiActionButtonClick -> {
            this.save();
            this.closeScreen();
        });
    }

    public void save() {
        new PacketPresetBlock(this.x, this.y, this.z, this.presetName, this.regionName).sendToServer();
    }
}

