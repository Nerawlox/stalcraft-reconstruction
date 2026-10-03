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
import ru.stalcraft.client.clans.TabType;
import ru.stalcraft.client.network.ClientPacketSender;

public class GuiTabClanInfo
extends GuiClanTab {
    private avf input;
    private aut salaryButton;

    public GuiTabClanInfo(GuiClans parent) {
        super(parent);
        GuiClanTab.texture = new bjo("stalker", "textures/clans/info.png");
    }

    @Override
    void drawTabForeground(int x2, int y2) {
        this.drawString("\u041d\u0430\u0437\u0432\u0430\u043d\u0438\u0435:", this.parent.g / 2 - 182, this.parent.h / 2 - 65, 0xFFFFFF);
        this.drawString("\u041b\u0438\u0434\u0435\u0440:", this.parent.g / 2 - 182, this.parent.h / 2 - 52, 0xFFFFFF);
        this.drawString("\u041a\u043e\u043b\u0438\u0447\u0435\u0441\u0442\u0432\u043e \u0431\u0430\u0437:", this.parent.g / 2 - 182, this.parent.h / 2 - 39, 0xFFFFFF);
        this.drawString("\u0421\u0443\u043c\u043c\u0430\u0440\u043d\u0430\u044f \u0440\u0435\u043f\u0443\u0442\u0430\u0446\u0438\u044f:", this.parent.g / 2 - 182, this.parent.h / 2 - 26, 0xFFFFFF);
        this.drawString("\u0421\u0443\u043c\u043c\u0430\u0440\u043d\u044b\u0435 \u043e\u0447\u043a\u0438 \u0441\u043c\u0435\u0440\u0442\u0438:", this.parent.g / 2 - 182, this.parent.h / 2 - 13, 0xFFFFFF);
        this.drawString("\u041a\u043e\u043b\u0438\u0447\u0435\u0441\u0442\u0432\u043e \u0443\u0447\u0430\u0441\u0442\u043d\u0438\u043a\u043e\u0432:", this.parent.g / 2 - 182, this.parent.h / 2, 0xFFFFFF);
        this.drawString("\u0423\u0447\u0430\u0441\u0442\u043d\u0438\u043a\u043e\u0432 \u043e\u043d\u043b\u0430\u0439\u043d:", this.parent.g / 2 - 182, this.parent.h / 2 + 13, 0xFFFFFF);
        this.drawString("\u0421\u0447\u0435\u0442:", this.parent.g / 2 - 182, this.parent.h / 2 + 26, 0xFFFFFF);
        String name = ClientProxy.clanData.thePlayerClan;
        String leader = ClientProxy.clanData.leader;
        String lands = String.valueOf(ClientProxy.clanData.landsCount);
        String rep = String.valueOf(ClientProxy.clanData.reputatuion);
        String death = String.valueOf(ClientProxy.clanData.deathCount);
        String members = String.valueOf(ClientProxy.clanData.membersCount);
        String online = String.valueOf(ClientProxy.clanData.onlineMembersCount);
        String money = ClientProxy.clanData.money + " \u0440\u0443\u0431.";
        this.drawString(name, this.parent.g / 2 - 3 - this.getWidth(name), this.parent.h / 2 - 65, 0xFFFFFF);
        this.drawString(leader, this.parent.g / 2 - 3 - this.getWidth(leader), this.parent.h / 2 - 52, 0xFFFFFF);
        this.drawString(lands, this.parent.g / 2 - 3 - this.getWidth(lands), this.parent.h / 2 - 39, 0xFFFFFF);
        this.drawString(rep, this.parent.g / 2 - 3 - this.getWidth(rep), this.parent.h / 2 - 26, 0xFFFFFF);
        this.drawString(death, this.parent.g / 2 - 3 - this.getWidth(death), this.parent.h / 2 - 13, 0xFFFFFF);
        this.drawString(members, this.parent.g / 2 - 3 - this.getWidth(members), this.parent.h / 2, 0xFFFFFF);
        this.drawString(online, this.parent.g / 2 - 3 - this.getWidth(online), this.parent.h / 2 + 13, 0xFFFFFF);
        this.drawString(money, this.parent.g / 2 - 3 - this.getWidth(money), this.parent.h / 2 + 26, 0xFFFFFF);
        int warningsY = 39;
        if (ClientProxy.clanData.removeTime >= 0) {
            int minLeft = (72000 - ClientProxy.clanData.removeTime) / 1200;
            if (minLeft > 0) {
                this.drawString("\u0414\u043e \u0440\u043e\u0441\u043f\u0443\u0441\u043a\u0430 \u043e\u0441\u0442\u0430\u043b\u043e\u0441\u044c " + minLeft + " \u043c\u0438\u043d.", this.parent.g / 2 - 182, this.parent.h / 2 + warningsY, 0xAA1111);
            } else {
                this.drawString("\u0414\u043e \u0440\u043e\u0441\u043f\u0443\u0441\u043a\u0430 \u043e\u0441\u0442\u0430\u043b\u043e\u0441\u044c \u043c\u0435\u043d\u0435\u0435 \u043e\u0434\u043d\u043e\u0439 \u043c\u0438\u043d\u0443\u0442\u044b!", this.parent.g / 2 - 182, this.parent.h / 2 + warningsY, 0xAA1111);
            }
            warningsY += 13;
        }
        if (ClientProxy.clanData.landsCount == 0) {
            this.drawString("\u0413\u0440\u0443\u043f\u043f\u0438\u0440\u043e\u0432\u043a\u0430, \u043d\u0435 \u0438\u043c\u0435\u044e\u0449\u0430\u044f \u043d\u0438 \u043e\u0434\u043d\u043e\u0439 \u0431\u0430\u0437\u044b, \u043d\u0435 \u043c\u043e\u0436\u0435\u0442 \u043e\u0431\u044a\u044f\u0432\u043b\u044f\u0442\u044c \u0432\u043e\u0439\u043d\u044b.", this.parent.g / 2 - 182, this.parent.h / 2 + warningsY, 0xAA1111);
            warningsY += 13;
        }
        this.input.f();
    }

    @Override
    void switchToTab() {
        avf var10001;
        ClientPacketSender.sendClanInfoRequest();
        int var10004 = this.parent.g / 2 - 182;
        this.input = var10001 = new avf(atv.w().l, var10004, this.parent.h / 2 + 117, 89, 16);
        this.input.f(32);
        this.salaryButton = new aut(1, this.parent.g / 2 - 89, this.parent.h / 2 + 91, 89, 20, "");
        this.parent.getButtonsList().add(this.salaryButton);
        this.updateSalaryButton();
        if (ClientProxy.clanData.thePlayerRank > 0) {
            this.parent.getButtonsList().add(new aut(0, this.parent.g / 2 - 89, this.parent.h / 2 + 115, 89, 20, "\u041f\u0440\u0438\u0433\u043b\u0430\u0441\u0438\u0442\u044c"));
            this.parent.getButtonsList().add(new aut(2, this.parent.g / 2 - 182, this.parent.h / 2 + 91, 89, 20, "\u041e\u0431\u043d\u043e\u0432\u0438\u0442\u044c \u0440\u0435\u043f\u0443\u0442\u0430\u0446\u0438\u044e"));
        } else {
            this.input.e(false);
        }
    }

    private void updateSalaryButton() {
        this.salaryButton.i = true;
        if (ClientProxy.clanData.salaryState > 0) {
            this.salaryButton.h = ClientProxy.clanData.salaryState == 2;
            this.salaryButton.f = "\u041f\u043e\u043b\u0443\u0447\u0438\u0442\u044c \u0437\u0430\u0440\u043f\u043b\u0430\u0442\u0443";
        } else if (ClientProxy.clanData.thePlayerRank == 2) {
            this.salaryButton.h = ClientProxy.clanData.money > 0;
            this.salaryButton.f = "\u0421\u043d\u044f\u0442\u044c \u0434\u0435\u043d\u044c\u0433\u0438";
        } else {
            this.salaryButton.i = false;
        }
        if (ClientProxy.clanData.thePlayerRank > 0) {
            this.salaryButton.d = this.parent.g / 2 - 89;
            this.salaryButton.e = this.parent.h / 2 + 91;
        } else {
            this.salaryButton.d = this.parent.g / 2 - 182;
            this.salaryButton.e = this.parent.h / 2 + 117;
        }
    }

    @Override
    void keyTyped(char par1, int par2) {
        super.keyTyped(par1, par2);
        if (par2 == 28 && this.input.l() && this.input.b().length() > 0) {
            ClientPacketSender.sendClanInviteRequest(this.input.b());
        }
        this.input.a(par1, par2);
    }

    @Override
    public void updateScreen() {
        this.input.a();
        this.updateSalaryButton();
    }

    @Override
    void mouseClicked(int x2, int y2, int button) {
        this.input.a(x2 / 2, y2 / 2, button);
    }

    @Override
    TabType getTabType() {
        return TabType.INFO;
    }

    @Override
    void actionPerformed(aut btn) {
        if (btn.g == 0 && this.input != null && this.input.b().length() > 0) {
            ClientPacketSender.sendClanInviteRequest(this.input.b());
        }
        if (btn.g == 1) {
            ClientPacketSender.sendWithdrawRequest();
            if (ClientProxy.clanData.thePlayerRank == 2) {
                ClientProxy.clanData.money = 0;
            }
        }
        if (btn.g == 2) {
            ClientPacketSender.sendSyncReputationRequest();
        }
    }

    private int getWidth(String str) {
        return atv.w().l.a(str);
    }
}

