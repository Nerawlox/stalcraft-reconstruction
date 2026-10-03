/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.client.gui.replica;

import gloomyfolken.mods.core.client.gui.engine.Dimension;
import gloomyfolken.mods.core.client.gui.engine.GuiHelper;
import gloomyfolken.mods.core.client.gui.engine.GuiScreenAdvanced;
import gloomyfolken.mods.core.client.gui.engine.Point;
import gloomyfolken.mods.core.client.gui.engine.component.McTextField;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.nbt.NBTTagCompound;
import noppes.npcs.client.NoppesUtil;
import noppes.npcs.constants.EnumPacketType;
import noppes.npcs.controllers.replica.ReplicaSystem;

public class GuiCreatePreset
extends GuiScreenAdvanced {
    private ReplicaSystem replicas;
    public McTextField titleField;

    public GuiCreatePreset(GuiScreen guiScreen, ReplicaSystem replicaSystem) {
        super(GuiHelper.widgetsRenderer, 200, 130, guiScreen);
        this.replicas = replicaSystem;
        this.replicas = new ReplicaSystem();
        this.replicas.readFromNbt(replicaSystem.writeToNbt(new NBTTagCompound()));
    }

    @Override
    public void initGui() {
        super.initGui();
        GuiHelper.addBackground(this, this.guiLeft, this.guiTop, this.guiWidth, this.guiHeight, true);
        this.titleField = new McTextField(this, new Point(this.screenWidth / 2 - 75, this.screenHeight / 2 - 50), new Dimension(150, 30));
        this.addElement(this.titleField);
        GuiHelper.addButton(this, this.screenWidth / 2 - 75, this.screenHeight / 2, 150, 30, "\u0421\u043e\u0437\u0434\u0430\u0442\u044c").onClick(guiActionButtonClick -> this.createPreset());
    }

    private void createPreset() {
        if (!this.titleField.getText().isEmpty()) {
            NoppesUtil.sendData(EnumPacketType.CreateSoundPreset, this.titleField.getText(), this.replicas.writeToNbt(new NBTTagCompound()));
            this.closeScreen();
        }
    }
}

