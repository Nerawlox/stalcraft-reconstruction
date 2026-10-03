/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.client.gui.global;

import gloomyfolken.mods.core.client.gui.engine.Dimension;
import gloomyfolken.mods.core.client.gui.engine.GuiHelper;
import gloomyfolken.mods.core.client.gui.engine.GuiScreenAdvanced;
import gloomyfolken.mods.core.client.gui.engine.Point;
import noppes.npcs.EntityNPCInterface;
import noppes.npcs.RandomEquipSettings;
import noppes.npcs.client.NoppesUtil;
import noppes.npcs.client.gui.global.GuiNpcRandomSkins;
import noppes.npcs.constants.EnumGuiType;

public class GuiNpcRandomEquip
extends GuiScreenAdvanced {
    private RandomEquipSettings settings;
    private final EntityNPCInterface npc;

    public GuiNpcRandomEquip(EntityNPCInterface entityNPCInterface) {
        super(GuiHelper.widgetsRenderer, 200, 150);
        this.settings = entityNPCInterface.inventory.randomEquipSettings;
        this.npc = entityNPCInterface;
    }

    @Override
    public void initGui() {
        super.initGui();
        GuiHelper.addBackground(this, this.guiLeft, this.guiTop, this.guiWidth, this.guiHeight, true);
        GuiHelper.addButton(this, new Point(this.screenWidth / 2 - 50, this.screenHeight / 2 - 38), new Dimension(100, 38), "\u0421\u043a\u0438\u043d\u044b").onClick(guiActionButtonClick -> this.mc._a(new GuiNpcRandomSkins(this, this.npc)));
        GuiHelper.addButton(this, new Point(this.screenWidth / 2 - 50, this.screenHeight / 2 + 15), new Dimension(100, 38), "\u0421\u043d\u0430\u0440\u044f\u0436\u0435\u043d\u0438\u0435").onClick(guiActionButtonClick -> NoppesUtil.requestOpenGUI(EnumGuiType.RandomEquip));
    }

    @Override
    public void drawScreen(int n, int n2, float f) {
        this.drawDefaultBackground();
        super.drawScreen(n, n2, f);
    }

    @Override
    public void closeScreen() {
        super.closeScreen();
        NoppesUtil.requestOpenGUI(EnumGuiType.MainMenuInv);
    }
}

