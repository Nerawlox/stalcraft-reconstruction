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

public class GuiTabClanLands
extends GuiClanTab
implements IScrollable {
    private GuiElementSlider slider;
    private GuiElementScrollButton topButton;
    private GuiElementScrollButton bottomButton;
    private GuiElementScrollableContent list;
    private aut renameButton;
    private avf renameField;

    public GuiTabClanLands(GuiClans parent) {
        super(parent);
        GuiClanTab.texture = new bjo("stalker", "textures/clans/lands.png");
    }

    @Override
    void drawTabForeground(int x2, int y2) {
        this.slider.draw(x2, y2);
        this.topButton.draw(x2, y2);
        this.bottomButton.draw(x2, y2);
        this.list.draw(x2, y2);
        this.renameField.f();
        if (this.list.getSelectedLine() < ClientProxy.clanData.lands.size() && this.list.getSelectedLine() >= 0) {
            ClientClanData.ClientClanLand land = (ClientClanData.ClientClanLand)ClientProxy.clanData.lands.get(this.list.getSelectedLine());
            this.drawString("\u041d\u0430\u0437\u0432\u0430\u043d\u0438\u0435: " + land.name, this.parent.g / 2 + 50, this.parent.h / 2 - 75, 0xFFFFFF);
            this.drawString("\u041a\u043e\u043e\u0440\u0434\u0438\u043d\u0430\u0442\u044b: " + land.x + ", " + land.z, this.parent.g / 2 + 50, this.parent.h / 2 - 65, 0xFFFFFF);
            this.drawString("\u0427\u0438\u0441\u043b\u043e \u0443\u0447\u0430\u0441\u0442\u043d\u0438\u043a\u043e\u0432: " + land.membersCount, this.parent.g / 2 + 50, this.parent.h / 2 - 55, 0xFFFFFF);
            if (land.isThePlayerMember) {
                this.drawString("\u0412\u044b \u043e\u0441\u0442\u0430\u043d\u043e\u0432\u0438\u043b\u0438\u0441\u044c \u043d\u0430 \u044d\u0442\u043e\u0439 \u0431\u0430\u0437\u0435.", this.parent.g / 2 + 50, this.parent.h / 2 - 45, 0xFFFFFF);
            }
        }
    }

    @Override
    void switchToTab() {
        avf var10001;
        ClientPacketSender.sendClanLandsRequest();
        int var10004 = this.parent.g / 2 + 53;
        this.renameField = var10001 = new avf(atv.w().l, var10004, this.parent.h / 2 + 84, 118, 16);
        this.renameField.f(16);
        this.renameButton = new aut(0, this.parent.g / 2 + 52, this.parent.h / 2 + 108, 120, 20, "\u041f\u0435\u0440\u0435\u0438\u043c\u0435\u043d\u043e\u0432\u0430\u0442\u044c");
        this.slider = new GuiElementSlider(this.parent, this, this.parent.g + 37, this.parent.h - 156, this.parent.h + 220, 18, 30);
        this.topButton = new GuiElementScrollButton(this.parent, this.slider, GuiElementScrollButton.ScrollButtonDirection.TOP, this.parent.g + 37, this.parent.h - 176, 18, 18);
        this.bottomButton = new GuiElementScrollButton(this.parent, this.slider, GuiElementScrollButton.ScrollButtonDirection.BOTTOM, this.parent.g + 37, this.parent.h + 252, 18, 18);
        this.list = new GuiElementScrollableContent(this.parent, this.slider, ClientProxy.clanData.lands, atv.w().d / 2 - 400 + 26, atv.w().e / 2 - 150, 400, 430);
        this.parent.getButtonsList().clear();
        this.parent.getButtonsList().add(this.renameButton);
    }

    @Override
    TabType getTabType() {
        return TabType.LANDS;
    }

    @Override
    void actionPerformed(aut btn) {
        if (btn.g == 0 && this.list.getSelectedLine() < ClientProxy.clanData.lands.size() && this.list.getSelectedLine() >= 0) {
            ClientClanData.ClientClanLand land = (ClientClanData.ClientClanLand)ClientProxy.clanData.lands.get(this.list.getSelectedLine());
            land.name = this.renameField.b();
            ClientPacketSender.sendLandRenameRequest(land.id, this.renameField.b());
        }
    }

    @Override
    void updateScreen() {
        this.slider.updateScreen();
        this.topButton.updateScreen();
        this.bottomButton.updateScreen();
        this.list.updateScreen();
        this.renameField.a();
        boolean isLandSelected = this.list.getSelectedLine() < ClientProxy.clanData.lands.size() && this.list.getSelectedLine() >= 0;
        this.renameButton.i = ClientProxy.clanData.thePlayerRank != 0 && isLandSelected;
        this.renameButton.h = this.renameField.b().length() > 0;
        this.renameField.e(ClientProxy.clanData.thePlayerRank != 0 && isLandSelected);
    }

    @Override
    void keyTyped(char par1, int par2) {
        this.slider.keyTyped(par1, par2);
        this.list.keyTyped(par1, par2);
        this.renameField.a(par1, par2);
    }

    @Override
    void mouseClicked(int x2, int y2, int button) {
        this.slider.mouseClicked(x2, y2, button);
        this.topButton.mouseClicked(x2, y2, button);
        this.bottomButton.mouseClicked(x2, y2, button);
        this.list.onClick(x2, y2, button);
        this.renameField.a(x2 / 2, y2 / 2, button);
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

