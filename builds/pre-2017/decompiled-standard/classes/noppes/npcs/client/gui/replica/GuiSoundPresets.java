/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.client.gui.replica;

import gloomyfolken.mods.core.client.gui.engine.Dimension;
import gloomyfolken.mods.core.client.gui.engine.GuiHelper;
import gloomyfolken.mods.core.client.gui.engine.GuiScreenAdvanced;
import gloomyfolken.mods.core.client.gui.engine.Point;
import gloomyfolken.mods.core.client.gui.engine.component.McScrollList;
import gloomyfolken.mods.core.misc.vjsq;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import net.minecraft.client.xpzm;
import noppes.npcs.client.NoppesUtil;
import noppes.npcs.client.gui.replica.GuiEditPreset;
import noppes.npcs.client.gui.util.IGuiData;
import noppes.npcs.constants.EnumPacketType;
import noppes.npcs.controllers.SoundPresetsController;

public class GuiSoundPresets
extends GuiScreenAdvanced
implements IGuiData {
    private List<SoundPresetEntry> entries = new ArrayList<SoundPresetEntry>();
    private McScrollList<SoundPresetEntry> list;
    private Consumer<SoundPresetsController.SoundPreset> presetConsumer = null;

    public GuiSoundPresets(gqjz gqjz2) {
        this(gqjz2, null);
    }

    public GuiSoundPresets(gqjz gqjz2, Consumer<SoundPresetsController.SoundPreset> consumer) {
        super(GuiHelper.widgetsRenderer, 400, 550, gqjz2);
        this.presetConsumer = consumer;
        NoppesUtil.sendData(EnumPacketType.GetSoundPresets, new Object[0]);
    }

    @Override
    public void func_73866_w_() {
        super.func_73866_w_();
        GuiHelper.addBackground(this, this.guiLeft, this.guiTop, this.guiWidth, this.guiHeight, true);
        this.list = GuiHelper.addScrollList(this, this.entries, new Point(this.screenWidth / 2 - 150, this.screenHeight / 2 - 225), new Dimension(300, 400));
        GuiHelper.addButton(this, new Point(this.screenWidth / 2 - 150, this.screenHeight / 2 + 195), new Dimension(125, 30), "\u0420\u0435\u0434\u0430\u043a\u0442\u0438\u0440\u043e\u0432\u0430\u0442\u044c").onClick(guiActionButtonClick -> this.editSelected());
        GuiHelper.addButton(this, new Point(this.screenWidth / 2 + 25, this.screenHeight / 2 + 195), new Dimension(125, 30), "\u0423\u0434\u0430\u043b\u0438\u0442\u044c").onClick(guiActionButtonClick -> this.deleteSelected());
        GuiHelper.addButton(this, new Point(this.screenWidth / 2 - 75, this.screenHeight / 2 + 230), new Dimension(150, 30), "\u0413\u043e\u0442\u043e\u0432\u043e").onClick(guiActionButtonClick -> this.supplyPresetAndClose());
    }

    private void supplyPresetAndClose() {
        SoundPresetEntry soundPresetEntry = this.list.getSelectedLine();
        if (soundPresetEntry != null && this.presetConsumer != null) {
            this.presetConsumer.accept(soundPresetEntry.preset);
        }
        this.closeScreen();
    }

    private void editSelected() {
        SoundPresetEntry soundPresetEntry = this.list.getSelectedLine();
        if (soundPresetEntry != null) {
            xpzm._E()._a(new GuiEditPreset(this, soundPresetEntry.preset));
        }
    }

    private void deleteSelected() {
        SoundPresetEntry soundPresetEntry = this.list.getSelectedLine();
        if (soundPresetEntry != null) {
            if (this.list.getSelectedLineId() >= this.list.getLines().size() - 1) {
                this.list.setSelectedLineId(-1);
            }
            this.list.getLines().remove(soundPresetEntry);
            NoppesUtil.sendData(EnumPacketType.DeleteSoundPreset, soundPresetEntry.preset.id);
        }
    }

    @Override
    public void setGuiData(qoac qoac2) {
        bsyv bsyv2 = qoac2._n("Replicas");
        for (int i = 0; i < bsyv2._d(); ++i) {
            qoac qoac3 = (qoac)bsyv2._b(i);
            SoundPresetsController.SoundPreset soundPreset = new SoundPresetsController.SoundPreset();
            soundPreset.readFromNbt(qoac3);
            this.entries.add(new SoundPresetEntry(soundPreset));
        }
    }

    private class SoundPresetEntry
    implements vjsq {
        public SoundPresetsController.SoundPreset preset;

        public SoundPresetEntry(SoundPresetsController.SoundPreset soundPreset) {
            this.preset = soundPreset;
        }

        @Override
        public String getString() {
            return this.preset.title;
        }

        @Override
        public int getColor() {
            return -1;
        }
    }
}

