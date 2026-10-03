/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.client.gui.player;

import gloomyfolken.mods.core.client.gui.engine.Dimension;
import gloomyfolken.mods.core.client.gui.engine.GuiHelper;
import gloomyfolken.mods.core.client.gui.engine.GuiRendererBuilder;
import gloomyfolken.mods.core.client.gui.engine.GuiScreenAdvanced;
import gloomyfolken.mods.core.client.gui.engine.IAdvancedGui;
import gloomyfolken.mods.core.client.gui.engine.Point;
import gloomyfolken.mods.core.client.gui.engine.component.GuiComponentsList;
import gloomyfolken.mods.core.client.gui.engine.component.McButton;
import gloomyfolken.mods.core.client.gui.engine.component.McDummySlot;
import gloomyfolken.mods.core.client.gui.engine.component.McImage;
import gloomyfolken.mods.core.client.gui.engine.component.McLabel;
import gloomyfolken.mods.core.client.gui.engine.component.McScrollPane;
import gloomyfolken.mods.core.client.gui.engine.component.McToolTip;
import gloomyfolken.mods.core.client.gui.font.ExternalFont;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.item.ItemStack;
import noppes.npcs.NoppesStringUtils;
import noppes.npcs.client.gui.player.IGuiChained;
import noppes.npcs.controllers.Quest;
import znw.mods.stalkerguide.pidb;

public class GuiQuestCompleted
extends GuiScreenAdvanced
implements IGuiChained {
    private Quest quest;
    private List<ItemStack> reward;
    private GuiComponentsList<McToolTip> tooltips = new GuiComponentsList(this);
    private GuiScreen chainedScreen;

    public GuiQuestCompleted(Quest quest, List<ItemStack> list) {
        super(new GuiRendererBuilder().setTextureSize(1024, 1024).setFontRenderer(ExternalFont.tahoma14).create());
        this.quest = quest;
        this.reward = list;
    }

    @Override
    public void initGui() {
        super.initGui();
        int n = 500;
        int n2 = 500;
        String string = String.format("\u0417\u0430\u0434\u0430\u043d\u0438\u0435 \"%s\" \u0437\u0430\u0432\u0435\u0440\u0448\u0435\u043d\u043e.", this.quest.title);
        Point point = new Point(this.screenWidth / 2 - this.renderer.getStringWidth(string) / 2, this.screenHeight / 2 - n2 / 2 - 30);
        this.addElement(new McLabel((IAdvancedGui)this, string, point, -256));
        List<String> list = this.renderer.wrapString(NoppesStringUtils.formatText(this.quest.completeText, this.mc._t.username), n - 20);
        ArrayList<String> arrayList = new ArrayList<String>();
        for (String string2 : list) {
            arrayList.addAll(Arrays.asList(string2.split("\n")));
        }
        int n3 = n / 72;
        int n4 = arrayList.size() * (this.renderer.getFontHeight() + 3) + 20 + this.renderer.getFontHeight() * 2 + (this.reward.size() / n3 + 1) * 72;
        Point point2 = new Point(this.screenWidth / 2 - n / 2, this.screenHeight / 2 - n2 / 2);
        Dimension dimension = new Dimension(n, n2);
        Dimension dimension2 = new Dimension(n, n4);
        McScrollPane mcScrollPane = GuiHelper.createScrollPane((IAdvancedGui)this, point2, dimension, dimension2, true, iedw._j, iedw._k);
        int n5 = 0;
        for (String object2 : arrayList) {
            mcScrollPane.getViewport().addElement(new McLabel((IAdvancedGui)this, object2, new Point(0, n5)));
            n5 += this.renderer.getFontHeight() + 3;
        }
        if (!this.reward.isEmpty()) {
            this.setupReward(mcScrollPane, n5);
        }
        this.addElement(mcScrollPane);
        Point point3 = new Point(this.screenWidth / 2 - 90, this.screenHeight / 2 + n2 / 2 + 20);
        McButton mcButton = GuiHelper.addButton(this, point3, new Dimension(180, 38), GuiHelper.mcButtonStyle, "\u0417\u0430\u0432\u0435\u0440\u0448\u0438\u0442\u044c").onClick(guiActionButtonClick -> this.closeScreen());
        mcButton.setRenderer(GuiHelper.mcWidgetsRenderer);
        this.addElement(this.tooltips);
    }

    private void setupReward(McScrollPane mcScrollPane, int n) {
        int n2 = n + 20;
        String string = this.quest.reward.rewardViaMail ? "\u041d\u0430\u0433\u0440\u0430\u0434\u0430 \u0437\u0430 \u0432\u044b\u043f\u043e\u043b\u043d\u0435\u043d\u0438\u0435 \u0431\u0443\u0434\u0435\u0442 \u043e\u0442\u043f\u0440\u0430\u0432\u043b\u0435\u043d\u0430 \u043f\u043e \u043f\u043e\u0447\u0442\u0435:" : "\u041d\u0430\u0433\u0440\u0430\u0434\u0430 \u0437\u0430 \u0432\u044b\u043f\u043e\u043b\u043d\u0435\u043d\u0438\u0435:";
        mcScrollPane.getViewport().addElement(new McLabel((IAdvancedGui)this, string, new Point(0, n2), -256));
        n2 += 25;
        int n3 = mcScrollPane.getSize().width / 72;
        Dimension dimension = new Dimension(72, 72);
        Point point = new Point(147, 0);
        for (int i = 0; i < this.reward.size(); ++i) {
            int n4 = i % n3 * 72;
            int n5 = n2 + i / n3 * 72;
            Point point2 = new Point(n4, n5);
            McImage mcImage = new McImage((IAdvancedGui)this, point2, point, dimension, GuiHelper.widgets);
            mcImage.setRenderer(GuiHelper.widgetsRenderer);
            mcScrollPane.getViewport().addElement(mcImage);
            McDummySlot mcDummySlot = new McDummySlot(this, this.reward.get(i), n4 + 4, n5 + 4, 2.0f);
            McToolTip mcToolTip = mcDummySlot.createToolTip();
            mcToolTip.setRenderer(GuiHelper.mcWidgetsRenderer);
            this.tooltips.addElement(mcToolTip);
            mcScrollPane.getViewport().addElement(mcDummySlot);
        }
    }

    @Override
    public void drawScreen(int n, int n2, float f) {
        this.drawDefaultBackground();
        super.drawScreen(n, n2, f);
    }

    @Override
    public void closeScreen() {
        pidb._a(this);
        super.closeScreen();
        this.mc._a(this.chainedScreen);
    }

    @Override
    public void setNextGui(GuiScreen guiScreen) {
        this.chainedScreen = guiScreen;
    }

    @Override
    public GuiScreen getNextGui() {
        return this.chainedScreen;
    }
}

