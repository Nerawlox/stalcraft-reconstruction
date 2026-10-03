/*
 * Decompiled with CFR 0.152.
 */
package mods.pda.client.tab;

import gloomyfolken.mods.core.client.gui.engine.Dimension;
import gloomyfolken.mods.core.client.gui.engine.GuiHelper;
import gloomyfolken.mods.core.client.gui.engine.IAdvancedGui;
import gloomyfolken.mods.core.client.gui.engine.Point;
import gloomyfolken.mods.core.client.gui.engine.component.GuiComponent;
import gloomyfolken.mods.core.client.gui.engine.component.GuiComponentsList;
import gloomyfolken.mods.core.client.gui.engine.component.McLabel;
import gloomyfolken.mods.core.client.gui.engine.component.McScrollBar;
import gloomyfolken.mods.core.client.gui.engine.component.McScrollButton;
import gloomyfolken.mods.core.client.gui.engine.component.McScrollList;
import gloomyfolken.mods.core.client.gui.engine.component.McToolTip;
import gloomyfolken.mods.core.client.gui.engine.style.ComponentButtonStyle;
import gloomyfolken.mods.party.zwat;
import java.time.Instant;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;
import mods.chat.ChatMod;
import mods.pda.client.component.dialog.PlayerSearchDialog;
import mods.pda.client.screens.GuiPda;
import mods.pda.client.screens.tab.AbstractPdaTab;
import mods.pda.client.tab.PdaProfile;

public class PdaFriends
extends AbstractPdaTab
implements iuxb.kjui {
    protected McScrollList<iuxb.pidb> list;
    private List<iuxb.pidb> playerList = new ArrayList<iuxb.pidb>();
    private String selected = "";
    private GuiComponentsList<GuiComponent> friendPanel;
    private McLabel onlineLabel;

    public PdaFriends(IAdvancedGui iAdvancedGui) {
        super(iAdvancedGui);
    }

    @Override
    public void requestInformation() {
        super.requestInformation();
        new srtr().sendClientToBackend();
    }

    @Override
    public void init(GuiPda guiPda) {
        super.init(guiPda);
        this.initList();
        this.onlineLabel = GuiHelper.addLabel(this.parent, "", this.list.getLocation().add(10, -23), iedw._h);
        this.addPictureButton(this.pdaScreenStart.add(23, 9), new Point(302, 840), new Dimension(19, 19), "\u0414\u043e\u0431\u0430\u0432\u0438\u0442\u044c \u0432 \u0434\u0440\u0443\u0437\u044c\u044f", false, guiActionButtonClick -> this.displayFindFriendDialog()).setGlColorEnabled(-7105645).setGlColorDisabled(-7105645);
        this.friendPanel = new GuiComponentsList(this.pda);
        this.pda.addElement(this.friendPanel);
        this.selected = "";
    }

    @Override
    public void tick() {
        super.tick();
        iuxb.pidb pidb2 = this.list.getSelectedLine();
        if (pidb2 != null && !pidb2._a().equals(this.selected)) {
            this.selected = pidb2._a();
            this.displayFriend(pidb2);
        } else if (pidb2 == null && !"".equals(this.selected)) {
            this.displayFriend(null);
            this.selected = "";
        }
    }

    @Override
    public void updateFriends(List<iuxb.pidb> list2) {
        iuxb.pidb pidb4;
        int n;
        String string;
        String string2 = string = this.list.getSelectedLineId() >= 0 ? this.list.getSelectedLine()._a() : null;
        if (list2.size() - 1 < this.list.getSelectedLineId()) {
            this.list.setSelectedLineId(-1);
        }
        this.playerList.clear();
        this.playerList.addAll(list2);
        this.playerList.sort((pidb2, pidb3) -> {
            if (pidb3._d() == pidb2._d()) {
                if (pidb3._b() == pidb2._b()) {
                    return pidb3._a().compareTo(pidb2._a());
                }
                return Boolean.compare(pidb3._b(), pidb2._b());
            }
            return pidb3._d().compareTo(pidb2._d());
        });
        if (string != null && (n = this.playerList.indexOf(pidb4 = (iuxb.pidb)this.playerList.stream().filter(pidb2 -> pidb2._a().equals(string)).findFirst().orElse(null))) >= 0) {
            this.list.setSelectedLineId(n);
            this.displayFriend(pidb4);
        }
        int n2 = (int)list2.stream().filter(iuxb.pidb::_b).count();
        n = (int)list2.stream().filter(pidb2 -> pidb2._d() == iuxb.eidj._c).count();
        this.onlineLabel.setText(String.format("\u0414\u0440\u0443\u0437\u0435\u0439 \u0432 \u0441\u0435\u0442\u0438: %d/%d (\u043c\u0430\u043a\u0441. %d)", n2, n, 100));
    }

    @Override
    public void drawComponent(Point point, float f) {
        this.drawScreenBackground(this.pdaScreenStart, new Dimension(443, this.pdaScreen.height), true);
        this.drawScreenBackground(this.pdaScreenStart.add(443, 0), new Dimension(298, this.pdaScreen.height), true);
        super.drawComponent(point, f);
        this.renderer.drawRect(this.list.getLocation().add(0, -2), new Dimension(this.list.getSize().width, 1), 0x64646464);
    }

    private void displayFriend(iuxb.pidb pidb2) {
        this.friendPanel.clearElements();
        if (pidb2 == null) {
            return;
        }
        int n = 0;
        this.friendPanel.addElement(new McLabel((IAdvancedGui)this.pda, "\u0418\u0433\u0440\u043e\u043a: " + pidb2._a(), this.pdaScreenStart.add(458, 40), 0x939393));
        this.friendPanel.addElement(new McLabel((IAdvancedGui)this.pda, "\u0421\u0442\u0430\u0442\u0443\u0441: " + pidb2._e(), this.pdaScreenStart.add(458, 60), 0x939393));
        long l = pidb2._c();
        if (l > 0L) {
            this.setupLastLoginLabel(this.pdaScreenStart.add(458, 80), pidb2);
        }
        Point point = this.pdaScreenStart.add(463, this.pdaScreen.height - 50);
        Dimension dimension = new Dimension(250, 30);
        if (pidb2._d() == iuxb.eidj._c) {
            GuiHelper.addButton(this.friendPanel, point.add(0, -35 * n++), dimension, iedw._l, "\u0423\u0431\u0440\u0430\u0442\u044c \u0438\u0437 \u0434\u0440\u0443\u0437\u0435\u0439").onClick(guiActionButtonClick -> new mqcx(pidb2._a()).sendClientToBackend());
        } else if (pidb2._d() == iuxb.eidj._a) {
            GuiHelper.addButton(this.friendPanel, point.add(0, -35 * n++), dimension, iedw._l, "\u041e\u0442\u043a\u043b\u043e\u043d\u0438\u0442\u044c \u0437\u0430\u044f\u0432\u043a\u0443").onClick(guiActionButtonClick -> new eikj(pidb2._a(), false).sendClientToBackend());
            GuiHelper.addButton(this.friendPanel, point.add(0, -35 * n++), dimension, iedw._l, "\u041f\u0440\u0438\u043d\u044f\u0442\u044c \u0437\u0430\u044f\u0432\u043a\u0443").onClick(guiActionButtonClick -> new eikj(pidb2._a(), true).sendClientToBackend());
        } else if (pidb2._d() == iuxb.eidj._b) {
            GuiHelper.addButton(this.friendPanel, point.add(0, -35 * n++), dimension, iedw._l, "\u041e\u0442\u043c\u0435\u043d\u0438\u0442\u044c \u0437\u0430\u044f\u0432\u043a\u0443").onClick(guiActionButtonClick -> new mqcx(pidb2._a()).sendClientToBackend());
        }
        GuiHelper.addButton(this.friendPanel, point.add(0, -35 * n++), dimension, iedw._l, "\u041d\u0430\u043f\u0438\u0441\u0430\u0442\u044c \u0441\u043e\u043e\u0431\u0449\u0435\u043d\u0438\u0435").onClick(guiActionButtonClick -> ChatMod.openChatWith(pidb2._a()));
        GuiHelper.addButton(this.friendPanel, point.add(0, -35 * n++), dimension, iedw._l, "\u041f\u0440\u0438\u0433\u043b\u0430\u0441\u0438\u0442\u044c \u0432 \u0433\u0440\u0443\u043f\u043f\u0438\u0440\u043e\u0432\u043a\u0443").onClick(guiActionButtonClick -> new ncdg(pidb2._a()).sendClientToBackend()).setEnabled(yuch._a._b(pidb2._a()));
        GuiHelper.addButton(this.friendPanel, point.add(0, -35 * n++), dimension, iedw._l, "\u041f\u0440\u0438\u0433\u043b\u0430\u0441\u0438\u0442\u044c \u0432 \u043e\u0442\u0440\u044f\u0434").onClick(guiActionButtonClick -> new cthk(pidb2._a()).sendClientToBackend()).setEnabled(zwat._a._a(pidb2._a()));
        GuiHelper.addButton(this.friendPanel, point.add(0, -35 * n++), dimension, iedw._l, "\u041e\u0442\u043a\u0440\u044b\u0442\u044c \u043f\u0440\u043e\u0444\u0438\u043b\u044c").onClick(guiActionButtonClick -> this.pda.openTab(new PdaProfile((IAdvancedGui)this.pda, pidb2._a())));
    }

    private void setupLastLoginLabel(Point point, iuxb.pidb pidb2) {
        long l = pidb2._c();
        long l2 = System.currentTimeMillis();
        long l3 = l2 - l;
        boolean bl = l3 > TimeUnit.HOURS.toMillis(1L);
        String string = bqgh._b.format(ZonedDateTime.ofInstant(Instant.ofEpochMilli(l), ZoneOffset.UTC));
        String string2 = bqgh._e(l3);
        String string3 = bl ? string : string2;
        String string4 = bl ? string2 : string;
        McLabel mcLabel = new McLabel((IAdvancedGui)this.pda, "\u0417\u0430\u0445\u043e\u0434\u0438\u043b: " + string3, point, 0x939393);
        mcLabel.noMouseInteraction = false;
        this.friendPanel.addElement(mcLabel);
        this.friendPanel.addElement(new McToolTip((IAdvancedGui)this.pda, Collections.singletonList(string4), mcLabel));
    }

    private void displayFindFriendDialog() {
        PlayerSearchDialog playerSearchDialog = new PlayerSearchDialog(this.pda, this.pdaScreenStart.add(this.pdaScreen.width / 2 - 200, this.pdaScreen.height / 2 - 80), new Dimension(400, 160)).setNameConsumer(this::sendFriendRequest);
        playerSearchDialog.setTitle("\u0414\u043e\u0431\u0430\u0432\u0438\u0442\u044c \u0432 \u0434\u0440\u0443\u0437\u044c\u044f");
        this.pda.addElement(playerSearchDialog);
        playerSearchDialog.init();
    }

    private void sendFriendRequest(String string) {
        new uxzh(string).sendClientToBackend();
    }

    protected void initList() {
        Point point = this.pdaScreenStart.add(5, 23);
        Dimension dimension = new Dimension((int)((double)this.pdaScreen.width * 0.6) - 23, this.pdaScreen.height - 35);
        this.list = new FriendScrollList(this.parent, iedw._g, this.playerList, point.add(5, 38), dimension.add(-13, -35));
        McScrollBar mcScrollBar = new McScrollBar(this.parent, this.list, McScrollBar.ScrollBarType.VERTICAL, point.add(dimension.width, 14), dimension.height - 28, iedw._j.getVerticalBarStyle());
        mcScrollBar.setSliderLength(16);
        this.list.setSlider(mcScrollBar);
        this.list.setDrawLineSeparators(true);
        this.pda.addElement(this.list);
        this.pda.addElement(mcScrollBar);
        this.pda.addElement(new McScrollButton(this.parent, mcScrollBar, McScrollButton.ScrollButtonDirection.TOP, new Point(point.x + dimension.width, point.y), iedw._k.getTopArrowStyle()));
        this.pda.addElement(new McScrollButton(this.parent, mcScrollBar, McScrollButton.ScrollButtonDirection.BOTTOM, new Point(point.x + dimension.width, point.y + dimension.height - 14), iedw._k.getBottomArrowStyle()));
    }

    private class FriendScrollList
    extends McScrollList<iuxb.pidb> {
        public FriendScrollList(IAdvancedGui iAdvancedGui, ComponentButtonStyle componentButtonStyle, List<iuxb.pidb> list2, Point point, Dimension dimension) {
            super(iAdvancedGui, componentButtonStyle, list2, point, dimension);
        }

        @Override
        protected void drawLine(int n, int n2, Point point) {
            super.drawLine(n, n2, point);
            iuxb.pidb pidb2 = (iuxb.pidb)this.lines.get(n);
            int n3 = pidb2._b() ? 0x109101 : 0x939393;
            String string = pidb2._e();
            int n4 = n2 + Math.abs(26 - this.renderer.getFontHeight()) / 2;
            this.renderer.drawString(string, this.getLocation().x + this.getSize().width - this.renderer.getStringWidth(string) - 5, n4, n3);
        }
    }
}

