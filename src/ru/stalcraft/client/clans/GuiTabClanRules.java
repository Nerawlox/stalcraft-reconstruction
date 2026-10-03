/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  aut
 *  bjo
 */
package ru.stalcraft.client.clans;

import ru.stalcraft.client.ClientProxy;
import ru.stalcraft.client.clans.GuiClanTab;
import ru.stalcraft.client.clans.GuiClans;
import ru.stalcraft.client.clans.GuiElementScrollButton;
import ru.stalcraft.client.clans.GuiElementSlider;
import ru.stalcraft.client.clans.GuiElementTextBox;
import ru.stalcraft.client.clans.IScrollable;
import ru.stalcraft.client.clans.TabType;
import ru.stalcraft.client.network.ClientPacketSender;

public class GuiTabClanRules
extends GuiClanTab
implements IScrollable {
    private GuiElementTextBox text;
    private GuiElementSlider slider;
    private GuiElementScrollButton topButton;
    private GuiElementScrollButton bottomButton;
    private aut editButton;
    private aut saveButton;

    public GuiTabClanRules(GuiClans parent) {
        super(parent);
        GuiClanTab.texture = new bjo("stalker", "textures/clans/rules.png");
    }

    @Override
    void drawTabForeground(int x2, int y2) {
        this.text.draw();
        this.slider.draw(x2, y2);
        this.topButton.draw(x2, y2);
        this.bottomButton.draw(x2, y2);
    }

    @Override
    void switchToTab() {
        ClientPacketSender.sendClanRulesRequest();
        atv mc = atv.w();
        this.slider = new GuiElementSlider(this.parent, this, mc.d / 2 + 363, mc.e / 2 - 156, mc.e / 2 + 220, 18, 30);
        this.topButton = new GuiElementScrollButton(this.parent, this.slider, GuiElementScrollButton.ScrollButtonDirection.TOP, mc.d / 2 + 363, mc.e / 2 - 176, 18, 18);
        this.bottomButton = new GuiElementScrollButton(this.parent, this.slider, GuiElementScrollButton.ScrollButtonDirection.BOTTOM, mc.d / 2 + 363, mc.e / 2 + 252, 18, 18);
        this.text = new GuiElementTextBox(this.parent, this.slider, mc.d / 2 - 360, mc.e / 2 - 170, 700, 404);
        this.editButton = new aut(0, this.parent.g / 2 - 180, this.parent.h / 2 + 120, 100, 20, "\u0420\u0435\u0434\u0430\u043a\u0442\u0438\u0440\u043e\u0432\u0430\u0442\u044c");
        this.saveButton = new aut(1, this.parent.g / 2 - 76, this.parent.h / 2 + 120, 100, 20, "\u0421\u043e\u0445\u0440\u0430\u043d\u0438\u0442\u044c");
        this.saveButton.i = ClientProxy.clanData.thePlayerRank > 0;
        this.editButton.i = this.saveButton.i;
        this.parent.getButtonsList().add(this.editButton);
        this.parent.getButtonsList().add(this.saveButton);
    }

    @Override
    TabType getTabType() {
        return TabType.RULES;
    }

    @Override
    void updateScreen() {
        this.slider.updateScreen();
        this.topButton.updateScreen();
        this.bottomButton.updateScreen();
        this.text.updateScreen();
        if (!this.text.isEditable) {
            this.text.setText(ClientProxy.clanData.rules);
        }
        this.editButton.f = this.text.isEditable ? "\u041e\u0442\u043c\u0435\u043d\u0430" : "\u0420\u0435\u0434\u0430\u043a\u0442\u0438\u0440\u043e\u0432\u0430\u0442\u044c";
        this.saveButton.h = this.text.isEditable;
    }

    @Override
    void keyTyped(char par1, int par2) {
        this.slider.keyTyped(par1, par2);
        this.text.keyTyped(par1, par2);
    }

    @Override
    void mouseClicked(int x2, int y2, int button) {
        this.slider.mouseClicked(x2, y2, button);
        this.topButton.mouseClicked(x2, y2, button);
        this.bottomButton.mouseClicked(x2, y2, button);
        this.text.mouseClicked(x2, y2, button);
    }

    @Override
    void handleWheel(int amountScrolled) {
        if (amountScrolled > 0) {
            this.slider.scrollDown(amountScrolled * 3);
        } else {
            this.slider.scrollUp(-amountScrolled * 3);
        }
    }

    @Override
    void mouseUp(int x2, int y2) {
        this.slider.mouseUp(x2, y2);
        this.topButton.mouseUp(x2, y2);
        this.bottomButton.mouseUp(x2, y2);
    }

    @Override
    void actionPerformed(aut btn) {
        if (btn.g == 0) {
            this.text.isEditable = !this.text.isEditable;
        } else if (btn.g == 1) {
            ClientProxy.clanData.rules = this.text.getText();
            ClientPacketSender.sendClanSetRulesRequest(this.text.getText());
            this.text.isEditable = false;
        }
    }

    @Override
    public int getHeightPerPage() {
        return this.text.getHeightPerPage();
    }

    @Override
    public int getTotalHeight() {
        return this.text.getTotalHeight();
    }

    @Override
    public int getMinScroll() {
        return this.text.getMinScroll();
    }
}

