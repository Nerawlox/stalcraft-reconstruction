/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.client.gui.replica;

import gloomyfolken.mods.core.client.gui.engine.Dimension;
import gloomyfolken.mods.core.client.gui.engine.GuiHelper;
import gloomyfolken.mods.core.client.gui.engine.Point;
import gloomyfolken.mods.core.client.gui.engine.component.GuiComponent;
import gloomyfolken.mods.core.client.gui.engine.component.McButton;
import java.util.Arrays;
import java.util.function.Consumer;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.nbt.NBTTagCompound;
import noppes.npcs.client.NoppesUtil;
import noppes.npcs.client.gui.replica.GuiReplicas;
import noppes.npcs.client.gui.replica.GuiSoundPresets;
import noppes.npcs.client.gui.util.IGuiData;
import noppes.npcs.constants.EnumPacketType;
import noppes.npcs.controllers.SoundPresetsController;
import noppes.npcs.controllers.replica.ReplicaSystem;

public class GuiPresetReplicas
extends GuiReplicas
implements IGuiData {
    protected int presetId;
    private final Consumer<Integer> presetConsumer;
    private String presetTitle = "";
    private McButton presetBtn;

    public GuiPresetReplicas(GuiScreen guiScreen, ReplicaSystem replicaSystem, int n, Consumer<Integer> consumer) {
        super(guiScreen, replicaSystem);
        this.presetConsumer = consumer;
        this.presetId = n;
        if (n > 0) {
            NoppesUtil.sendData(EnumPacketType.GetPresetTitle, n);
        }
    }

    @Override
    public void initGui() {
        super.initGui();
        Point point = new Point(this.screenWidth / 2 - 375, this.screenHeight / 2 - 300);
        Dimension dimension = new Dimension(150, 30);
        this.presetBtn = GuiHelper.addButton(this, point, dimension, this.presetId > 0 ? this.presetTitle : "\u0412\u044b\u0431\u0440\u0430\u0442\u044c").onClick(guiActionButtonClick -> this.mc._a(new GuiSoundPresets(this, this.onPresetUpdate())));
        if (this.presetId > 0) {
            McButton mcButton = GuiHelper.addButton(this, new Point(this.screenWidth / 2 - 225, this.screenHeight / 2 - 300), new Dimension(30, 30), "X").onClick(guiActionButtonClick -> {
                this.presetId = -1;
                this.setWorldAndResolution(this.mc, this.screenWidth / 2, this.screenHeight / 2);
            });
            for (GuiComponent guiComponent : this.elementsList.getElements()) {
                if (Arrays.asList(this.presetBtn, mcButton, this.saveBtn, this.cancelBtn).contains(guiComponent)) continue;
                guiComponent.setEnabled(false);
            }
        }
    }

    private Consumer<SoundPresetsController.SoundPreset> onPresetUpdate() {
        return soundPreset -> {
            this.presetTitle = soundPreset != null ? soundPreset.title : "";
            this.presetId = soundPreset != null ? soundPreset.id : -1;
        };
    }

    @Override
    protected void saveAndClose() {
        this.presetConsumer.accept(this.presetId);
        super.saveAndClose();
    }

    @Override
    public void setGuiData(NBTTagCompound nBTTagCompound) {
        this.presetBtn.text = this.presetTitle = nBTTagCompound._j("Title");
    }
}

