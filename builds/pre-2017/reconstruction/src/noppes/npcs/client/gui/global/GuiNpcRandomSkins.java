/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.client.gui.global;

import gloomyfolken.mods.core.client.gui.engine.Dimension;
import gloomyfolken.mods.core.client.gui.engine.GuiHelper;
import gloomyfolken.mods.core.client.gui.engine.GuiScreenAdvanced;
import gloomyfolken.mods.core.client.gui.engine.IAdvancedGui;
import gloomyfolken.mods.core.client.gui.engine.Point;
import gloomyfolken.mods.core.client.gui.engine.action.GuiActionTextFieldChanged;
import gloomyfolken.mods.core.client.gui.engine.component.McLabel;
import gloomyfolken.mods.core.client.gui.engine.component.McNumberField;
import gloomyfolken.mods.core.client.gui.engine.component.McTextField;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.nbt.NBTTagCompound;
import noppes.npcs.EntityNPCInterface;
import noppes.npcs.RandomEquipSettings;
import noppes.npcs.client.NoppesUtil;
import noppes.npcs.client.gui.GuiNPCTextures;
import noppes.npcs.constants.EnumPacketType;

public class GuiNpcRandomSkins
extends GuiScreenAdvanced {
    private final RandomEquipSettings settings;
    private final EntityNPCInterface npc;

    public GuiNpcRandomSkins(GuiScreen guiScreen, EntityNPCInterface entityNPCInterface) {
        super(GuiHelper.widgetsRenderer, 600, 500, guiScreen);
        this.settings = entityNPCInterface.inventory.randomEquipSettings;
        this.npc = entityNPCInterface;
    }

    @Override
    public void initGui() {
        super.initGui();
        GuiHelper.addBackground(this, this.guiLeft, this.guiTop, this.guiWidth, this.guiHeight, true);
        for (int i = 0; i < 12; ++i) {
            int n2 = i;
            Point point = new Point(this.screenWidth / 2 - 250, this.screenHeight / 2 - 170 + i * 30);
            this.addElement(new McLabel((IAdvancedGui)this, i + 1 + ".", point.add(-20, 6)));
            RandomEquipSettings.Skin skin = this.settings.skins.computeIfAbsent(n2, n -> new RandomEquipSettings.Skin("", 1.0f));
            McTextField mcTextField = new McTextField(this, point, new Dimension(450, 25));
            mcTextField.setMaxStringLength(100000);
            mcTextField.setText(skin.texture);
            McNumberField mcNumberField = GuiHelper.createNumberField(this, point.add(460, 0), (long)skin.weight);
            mcNumberField.setSize(new Dimension(60, 25));
            this.actionManager.registerActionHandler(mcNumberField, GuiActionTextFieldChanged.class, guiActionTextFieldChanged -> {
                this.settings.skins.get((Object)Integer.valueOf((int)n)).weight = ((McNumberField)guiActionTextFieldChanged.component).getValue();
            });
            this.actionManager.registerActionHandler(mcTextField, GuiActionTextFieldChanged.class, guiActionTextFieldChanged -> {
                this.settings.skins.get((Object)Integer.valueOf((int)n)).texture = ((McTextField)guiActionTextFieldChanged.component).getText();
            });
            GuiHelper.addButton(this, point.add(530, 0), new Dimension(100, 30), "\u0412\u044b\u0431\u0440\u0430\u0442\u044c").onClick(guiActionButtonClick -> {
                String string2 = skin.texture.isEmpty() ? "customnpcs:textures/entity/humanmale/_" : skin.texture;
                Minecraft._E()._a(new GuiNPCTextures(this.npc, this, string2, string -> {
                    this.settings.skins.get((Object)Integer.valueOf((int)n)).texture = string;
                }));
            });
            this.addElement(mcTextField);
            this.addElement(mcNumberField);
        }
        GuiHelper.addButton(this, new Point(this.screenWidth / 2 - 75, this.screenHeight / 2 + 210), new Dimension(150, 30), "\u0413\u043e\u0442\u043e\u0432\u043e").onClick(guiActionButtonClick -> this.closeScreen());
    }

    @Override
    public void closeScreen() {
        super.closeScreen();
        this.save();
    }

    private void save() {
        NoppesUtil.sendData(EnumPacketType.MainmenuInvSave, this.npc.inventory.writeEntityToNBT(new NBTTagCompound()));
    }
}

