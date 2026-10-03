/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  aut
 *  bjo
 */
package ru.stalcraft.client.clans;

import ru.stalcraft.client.ClientProxy;
import ru.stalcraft.client.clans.ClientClanData;
import ru.stalcraft.client.clans.GuiClanTab;
import ru.stalcraft.client.clans.GuiClans;
import ru.stalcraft.client.clans.GuiElementScrollButton;
import ru.stalcraft.client.clans.GuiElementScrollableContent;
import ru.stalcraft.client.clans.GuiElementSlider;
import ru.stalcraft.client.clans.IScrollable;
import ru.stalcraft.client.clans.TabType;
import ru.stalcraft.client.network.ClientPacketSender;

public class GuiTabClansList
extends GuiClanTab
implements IScrollable {
    private GuiElementSlider slider;
    private GuiElementScrollButton topButton;
    private GuiElementScrollButton bottomButton;
    private GuiElementScrollableContent list;
    private aut peaceOfferButton;
    private aut cancelPeaceOfferButton;
    private aut peaceButton;
    private aut warButton;

    public GuiTabClansList(GuiClans parent) {
        super(parent);
        GuiClanTab.texture = new bjo("stalker", "textures/clans/clans.png");
        this.peaceOfferButton = new aut(0, parent.g / 2 + 52, parent.h / 2 + 108, 120, 20, "\u041f\u0440\u0435\u0434\u043b\u043e\u0436\u0438\u0442\u044c \u043c\u0438\u0440");
        this.cancelPeaceOfferButton = new aut(1, parent.g / 2 + 52, parent.h / 2 + 108, 120, 20, "\u041f\u0440\u043e\u0434\u043e\u043b\u0436\u0438\u0442\u044c \u0432\u043e\u0439\u043d\u0443");
        this.peaceButton = new aut(2, parent.g / 2 + 52, parent.h / 2 + 108, 120, 20, "\u0417\u0430\u043a\u043b\u044e\u0447\u0438\u0442\u044c \u043c\u0438\u0440");
        this.warButton = new aut(3, parent.g / 2 + 52, parent.h / 2 + 108, 120, 20, "\u041e\u0431\u044a\u044f\u0432\u0438\u0442\u044c \u0432\u043e\u0439\u043d\u0443");
    }

    @Override
    void drawTabForeground(int x2, int y2) {
        this.slider.draw(x2, y2);
        this.topButton.draw(x2, y2);
        this.bottomButton.draw(x2, y2);
        this.list.draw(x2, y2);
        this.parent.getButtonsList().clear();
        if (this.list.getSelectedLine() >= 0) {
            ClientClanData.ClientOtherClan clan = (ClientClanData.ClientOtherClan)ClientProxy.clanData.clans.get(this.list.getSelectedLine());
            this.drawString("\u041d\u0430\u0437\u0432\u0430\u043d\u0438\u0435: " + clan.name, this.parent.g / 2 + 50, this.parent.h / 2 - 75, 0xFFFFFF);
            this.drawString("\u041b\u0438\u0434\u0435\u0440: " + clan.leader, this.parent.g / 2 + 50, this.parent.h / 2 - 65, 0xFFFFFF);
            this.drawString("\u041a\u043e\u043b\u0438\u0447\u0435\u0441\u0442\u0432\u043e \u0443\u0447\u0430\u0441\u0442\u043d\u0438\u043a\u043e\u0432: " + clan.membersCount, this.parent.g / 2 + 50, this.parent.h / 2 - 55, 0xFFFFFF);
            this.drawString("\u041a\u043e\u043b\u0438\u0447\u0435\u0441\u0442\u0432\u043e \u0431\u0430\u0437: " + clan.landsCount, this.parent.g / 2 + 50, this.parent.h / 2 - 45, 0xFFFFFF);
            if (clan.warState == -1) {
                this.drawString("\u041e\u0442\u043d\u043e\u0448\u0435\u043d\u0438\u044f: \u041c\u0438\u0440", this.parent.g / 2 + 50, this.parent.h / 2 - 35, 0x11AA11);
                this.parent.getButtonsList().add(this.warButton);
                this.warButton.h = ClientProxy.clanData.landsCount > 0 && clan.landsCount > 0;
            } else {
                this.drawString("\u041e\u0442\u043d\u043e\u0448\u0435\u043d\u0438\u044f: \u0412\u043e\u0439\u043d\u0430", this.parent.g / 2 + 50, this.parent.h / 2 - 35, 0xAA1111);
                if (clan.warState == 0) {
                    this.parent.getButtonsList().add(this.peaceOfferButton);
                } else if (clan.warState == 1) {
                    this.parent.getButtonsList().add(this.cancelPeaceOfferButton);
                } else if (clan.warState == 2) {
                    this.parent.getButtonsList().add(this.peaceButton);
                }
            }
        }
    }

    @Override
    void switchToTab() {
        ClientPacketSender.sendClanListRequest();
        this.slider = new GuiElementSlider(this.parent, this, this.parent.g + 37, this.parent.h - 156, this.parent.h + 220, 18, 30);
        this.topButton = new GuiElementScrollButton(this.parent, this.slider, GuiElementScrollButton.ScrollButtonDirection.TOP, this.parent.g + 37, this.parent.h - 176, 18, 18);
        this.bottomButton = new GuiElementScrollButton(this.parent, this.slider, GuiElementScrollButton.ScrollButtonDirection.BOTTOM, this.parent.g + 37, this.parent.h + 252, 18, 18);
        this.list = new GuiElementScrollableContent(this.parent, this.slider, ClientProxy.clanData.clans, atv.w().d / 2 - 400 + 26, atv.w().e / 2 - 150, 400, 430);
    }

    @Override
    TabType getTabType() {
        return TabType.CLANS;
    }

    @Override
    void updateScreen() {
        this.slider.updateScreen();
        this.topButton.updateScreen();
        this.bottomButton.updateScreen();
        this.list.updateScreen();
    }

    @Override
    void keyTyped(char par1, int par2) {
        this.slider.keyTyped(par1, par2);
        this.list.keyTyped(par1, par2);
    }

    @Override
    void mouseClicked(int x2, int y2, int button) {
        this.slider.mouseClicked(x2, y2, button);
        this.topButton.mouseClicked(x2, y2, button);
        this.bottomButton.mouseClicked(x2, y2, button);
        this.list.onClick(x2, y2, button);
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
        ClientClanData.ClientOtherClan clan;
        int line = this.list.getSelectedLine();
        ClientClanData.ClientOtherClan clientOtherClan = clan = line < 0 ? null : (ClientClanData.ClientOtherClan)ClientProxy.clanData.clans.get(line);
        if (btn != this.peaceOfferButton && btn != this.peaceButton) {
            if (btn == this.cancelPeaceOfferButton) {
                ClientPacketSender.sendClanPeaceOfferCancelRequest(clan.name);
            } else if (btn == this.warButton) {
                ClientPacketSender.sendClanWarRequest(clan.name);
            }
        } else {
            ClientPacketSender.sendClanPeaceRequest(clan.name);
        }
    }

    @Override
    public int getHeightPerPage() {
        return this.list.getHeightPerPage();
    }

    @Override
    public int getTotalHeight() {
        return this.list.getTotalHeight();
    }

    @Override
    public int getMinScroll() {
        return this.list.getMinScroll();
    }
}

