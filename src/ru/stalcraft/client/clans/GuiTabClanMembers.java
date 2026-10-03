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

public class GuiTabClanMembers
extends GuiClanTab
implements IScrollable {
    private GuiElementSlider slider;
    private GuiElementScrollButton topButton;
    private GuiElementScrollButton bottomButton;
    private GuiElementScrollableContent list;
    private static final String[] rankNames = new String[]{"\u0420\u044f\u0434\u043e\u0432\u043e\u0439", "\u041e\u0444\u0438\u0446\u0435\u0440", "\u041b\u0438\u0434\u0435\u0440"};
    private aut kickButton;
    private aut leaveButton;
    private aut rankUpButton;
    private aut rankDownButton;
    private aut leaderButton;
    private aut dissolutionButton;

    public GuiTabClanMembers(GuiClans parent) {
        super(parent);
        GuiClanTab.texture = new bjo("stalker", "textures/clans/members.png");
        this.kickButton = new aut(0, parent.g / 2 + 52, parent.h / 2 + 60, 120, 20, "\u0418\u0441\u043a\u043b\u044e\u0447\u0438\u0442\u044c");
        this.leaveButton = new aut(1, parent.g / 2 + 52, parent.h / 2 + 60, 120, 20, "\u041f\u043e\u043a\u0438\u043d\u0443\u0442\u044c \u0433\u0440\u0443\u043f\u043f\u0438\u0440\u043e\u0432\u043a\u0443");
        this.rankUpButton = new aut(2, parent.g / 2 + 52, parent.h / 2 + 84, 120, 20, "\u041f\u043e\u0432\u044b\u0441\u0438\u0442\u044c \u0440\u0430\u043d\u0433");
        this.rankDownButton = new aut(3, parent.g / 2 + 52, parent.h / 2 + 84, 120, 20, "\u041f\u043e\u043d\u0438\u0437\u0438\u0442\u044c \u0440\u0430\u043d\u0433");
        this.leaderButton = new aut(4, parent.g / 2 + 52, parent.h / 2 + 108, 120, 20, "\u0421\u0434\u0435\u043b\u0430\u0442\u044c \u043b\u0438\u0434\u0435\u0440\u043e\u043c");
        this.dissolutionButton = new aut(5, parent.g / 2 + 52, parent.h / 2 + 108, 120, 20, "\u0420\u0430\u0441\u043f\u0443\u0441\u0442\u0438\u0442\u044c \u0433\u0440\u0443\u043f\u043f\u0438\u0440\u043e\u0432\u043a\u0443");
    }

    @Override
    void drawTabForeground(int x2, int y2) {
        this.slider.draw(x2, y2);
        this.topButton.draw(x2, y2);
        this.bottomButton.draw(x2, y2);
        this.list.draw(x2, y2);
        this.parent.getButtonsList().clear();
        if (this.list.getSelectedLine() >= 0 && this.list.getSelectedLine() < ClientProxy.clanData.members.size()) {
            ClientClanData.ClientClanMember member = (ClientClanData.ClientClanMember)ClientProxy.clanData.members.get(this.list.getSelectedLine());
            this.drawString("\u041d\u0438\u043a: " + member.username, this.parent.g / 2 + 50, this.parent.h / 2 - 75, 0xFFFFFF);
            this.drawString("\u0420\u0430\u043d\u0433: " + rankNames[member.rank], this.parent.g / 2 + 50, this.parent.h / 2 - 65, 0xFFFFFF);
            if (member.online) {
                this.drawString("\u0418\u0433\u0440\u043e\u043a \u0432 \u0441\u0435\u0442\u0438", this.parent.g / 2 + 50, this.parent.h / 2 - 55, 0x11AA11);
            } else {
                this.drawString("\u0418\u0433\u0440\u043e\u043a \u043d\u0435 \u0432 \u0441\u0435\u0442\u0438", this.parent.g / 2 + 50, this.parent.h / 2 - 55, 0xAA1111);
            }
            if (ClientProxy.clanData.thePlayerRank != 2 && member.username.equals(atv.w().h.bu)) {
                this.parent.getButtonsList().add(this.leaveButton);
                this.leaveButton.e = this.parent.h / 2 + 108;
            } else if (ClientProxy.clanData.thePlayerRank == 1 && member.rank != 2) {
                this.parent.getButtonsList().add(this.kickButton);
                this.parent.getButtonsList().add(member.rank == 0 ? this.rankUpButton : this.rankDownButton);
                this.kickButton.e = this.parent.h / 2 + 84;
                this.rankUpButton.e = this.parent.h / 2 + 108;
                this.rankDownButton.e = this.parent.h / 2 + 108;
            } else if (ClientProxy.clanData.thePlayerRank == 2 && !member.username.equals(atv.w().h.bu)) {
                this.parent.getButtonsList().add(this.kickButton);
                this.parent.getButtonsList().add(member.rank == 0 ? this.rankUpButton : this.rankDownButton);
                this.parent.getButtonsList().add(this.leaderButton);
                this.kickButton.e = this.parent.h / 2 + 60;
                this.rankUpButton.e = this.parent.h / 2 + 84;
                this.rankDownButton.e = this.parent.h / 2 + 84;
                this.leaderButton.e = this.parent.h / 2 + 108;
            } else if (ClientProxy.clanData.thePlayerRank == 2) {
                this.parent.getButtonsList().add(this.dissolutionButton);
                this.dissolutionButton.e = this.parent.h / 2 + 108;
            }
        }
    }

    @Override
    void switchToTab() {
        ClientPacketSender.sendClanMembersRequest();
        this.slider = new GuiElementSlider(this.parent, this, this.parent.g + 37, this.parent.h - 156, this.parent.h + 220, 18, 30);
        this.topButton = new GuiElementScrollButton(this.parent, this.slider, GuiElementScrollButton.ScrollButtonDirection.TOP, this.parent.g + 37, this.parent.h - 176, 18, 18);
        this.bottomButton = new GuiElementScrollButton(this.parent, this.slider, GuiElementScrollButton.ScrollButtonDirection.BOTTOM, this.parent.g + 37, this.parent.h + 252, 18, 18);
        this.list = new GuiElementScrollableContent(this.parent, this.slider, ClientProxy.clanData.members, atv.w().d / 2 - 400 + 26, atv.w().e / 2 - 150, 400, 430);
    }

    @Override
    TabType getTabType() {
        return TabType.MEMBERS;
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
        ClientClanData.ClientClanMember member;
        int line = this.list.getSelectedLine();
        ClientClanData.ClientClanMember clientClanMember = member = line < 0 ? null : (ClientClanData.ClientClanMember)ClientProxy.clanData.members.get(line);
        if (btn == this.kickButton) {
            ClientPacketSender.sendClanKickRequest(member.username);
        } else if (btn == this.leaveButton) {
            ClientPacketSender.sendClanLeaveRequest();
        } else if (btn == this.rankUpButton) {
            ClientPacketSender.sendRankUpRequest(member.username);
        } else if (btn == this.rankDownButton) {
            ClientPacketSender.sendRankDownRequest(member.username);
        } else if (btn == this.leaderButton) {
            ClientPacketSender.sendSetLeaderRequest(member.username);
        } else if (btn == this.dissolutionButton) {
            ClientPacketSender.sendClanDeleteRequest();
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

