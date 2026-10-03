/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.client.gui.replica;

import gloomyfolken.mods.core.client.gui.engine.GuiHelper;
import gloomyfolken.mods.core.client.gui.engine.Point;
import gloomyfolken.mods.core.client.gui.engine.action.GuiActionCheckboxToggle;
import gloomyfolken.mods.core.client.gui.engine.component.McCheckBox;
import net.minecraft.client.gui.GuiScreen;
import noppes.npcs.client.gui.replica.GuiPresetReplicas;
import noppes.npcs.controllers.replica.ReplicaController;

public class GuiNpcReplicas
extends GuiPresetReplicas {
    private boolean useFactionSettings;
    private final ReplicaController replicas;

    public GuiNpcReplicas(GuiScreen guiScreen, ReplicaController replicaController) {
        super(guiScreen, replicaController.npcReplicas, replicaController.presetId, (Integer n) -> {
            replicaController.presetId = n;
        });
        this.useFactionSettings = replicaController.includeFactionReplicas;
        this.replicas = replicaController;
    }

    @Override
    public void initGui() {
        super.initGui();
        McCheckBox mcCheckBox = GuiHelper.createCheckBox(this, new Point(this.screenWidth / 2 + 100, this.screenHeight / 2 - 300), "\u0418\u0441\u043f\u043e\u043b\u044c\u0437\u043e\u0432\u0430\u0442\u044c \u0440\u0435\u043f\u043b\u0438\u043a\u0438 \u0444\u0440\u0430\u043a\u0446\u0438\u0438");
        mcCheckBox.setActive(this.useFactionSettings);
        this.switchFactionSettings(mcCheckBox.getActive());
        this.actionManager.registerActionHandler(mcCheckBox, GuiActionCheckboxToggle.class, guiActionCheckboxToggle -> {
            this.useFactionSettings = ((McCheckBox)guiActionCheckboxToggle.component).getActive();
            this.switchFactionSettings(this.useFactionSettings);
        });
        this.addElement(mcCheckBox);
    }

    private void switchFactionSettings(boolean bl) {
        this.delayTime.setEnabled(this.presetId <= 0 && !bl);
        this.randomDelay.setEnabled(this.presetId <= 0 && !bl);
    }

    @Override
    protected void saveAndClose() {
        this.replicas.includeFactionReplicas = this.useFactionSettings;
        super.saveAndClose();
    }
}

