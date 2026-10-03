/*
 * Decompiled with CFR 0.152.
 */
package mods.sound.client;

import gloomyfolken.mods.core.client.gui.engine.Dimension;
import gloomyfolken.mods.core.client.gui.engine.GuiHelper;
import gloomyfolken.mods.core.client.gui.engine.GuiScreenAdvanced;
import gloomyfolken.mods.core.client.gui.engine.IAdvancedGui;
import gloomyfolken.mods.core.client.gui.engine.Point;
import gloomyfolken.mods.core.client.gui.engine.action.GuiActionTextFieldChanged;
import gloomyfolken.mods.core.client.gui.engine.component.McLabel;
import gloomyfolken.mods.core.client.gui.engine.component.McNumberField;
import gloomyfolken.mods.core.client.gui.engine.component.McScrollList;
import gloomyfolken.mods.core.misc.vjsq;
import java.util.ArrayList;
import mods.sound.SoundMod;
import mods.sound.config.SoundGroup;
import mods.sound.config.SoundSource;
import mods.sound.packet.PacketEditSound;

public class GuiEditSource
extends GuiScreenAdvanced {
    private final SoundSource source;
    private McScrollList<GroupEntry> groupList;

    public GuiEditSource(SoundSource soundSource) {
        this.source = soundSource;
    }

    @Override
    public void initGui() {
        GuiHelper.addBackground(this, this.screenWidth / 2 - 125, this.screenHeight / 2 - 60, 250, 300, true);
        ArrayList<GroupEntry> arrayList = new ArrayList<GroupEntry>();
        int n = 0;
        int n2 = 0;
        for (SoundGroup object2 : SoundMod.instance.soundController.soundGroups.values()) {
            if (object2.getName().equals(this.source.getGroup())) {
                n = n2;
            }
            arrayList.add(new GroupEntry(object2));
            ++n2;
        }
        Point point = new Point(this.screenWidth / 2, this.screenHeight / 2);
        this.addElement(new McLabel((IAdvancedGui)this, "\u0413\u0440\u0443\u043f\u043f\u0430 \u0437\u0432\u0443\u043a\u043e\u0432:", point.add(-100, -50)));
        this.groupList = GuiHelper.addScrollList(this, arrayList, point.add(-100, -35), new Dimension(200, 100));
        this.groupList.setSelectedLineId(n);
        Dimension dimension = new Dimension(200, 30);
        this.addElement(new McLabel((IAdvancedGui)this, "\u0421\u043b\u044b\u0448\u0438\u043c\u043e\u0441\u0442\u044c (0-256):", point.add(-100, 70)));
        McNumberField mcNumberField = GuiHelper.createNumberField(this, point.add(-100, 90), dimension, (long)this.source.getRolloff(), 256L, 0L);
        this.getActionManager().registerActionHandler(mcNumberField, GuiActionTextFieldChanged.class, guiActionTextFieldChanged -> this.source.setRolloff(((McNumberField)guiActionTextFieldChanged.component).getValue()));
        this.addElement(mcNumberField);
        this.addElement(new McLabel((IAdvancedGui)this, "\u0413\u0440\u043e\u043c\u043a\u043e\u0441\u0442\u044c (0-100):", point.add(-100, 125)));
        McNumberField mcNumberField2 = GuiHelper.createNumberField(this, point.add(-100, 145), dimension, (long)(this.source.getGain() * 100.0f), 100L, 0L);
        this.getActionManager().registerActionHandler(mcNumberField2, GuiActionTextFieldChanged.class, guiActionTextFieldChanged -> this.source.setGain((float)((double)((McNumberField)guiActionTextFieldChanged.component).getValue() / 100.0)));
        this.addElement(mcNumberField2);
        GuiHelper.addButton(this, point.add(-100, 185), new Dimension(200, 38), "\u0421\u043e\u0445\u0440\u0430\u043d\u0438\u0442\u044c").onClick(guiActionButtonClick -> this.save());
    }

    private void save() {
        this.closeScreen();
        new PacketEditSound(this.source).sendToServer();
    }

    @Override
    public void updateScreen() {
        super.updateScreen();
        GroupEntry groupEntry = this.groupList.getSelectedLine();
        if (groupEntry != null) {
            this.source.setGroup(groupEntry.group.getName());
        }
    }

    private class GroupEntry
    implements vjsq {
        private SoundGroup group;

        public GroupEntry(SoundGroup soundGroup) {
            this.group = soundGroup;
        }

        @Override
        public String getString() {
            return this.group.getName();
        }

        @Override
        public int getColor() {
            return -1;
        }
    }
}

