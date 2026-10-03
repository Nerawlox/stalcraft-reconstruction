/*
 * Decompiled with CFR 0.152.
 */
package mods.pda.client.tab;

import gloomyfolken.bundle.common.core.stats.Stat;
import gloomyfolken.bundle.common.core.tupg;
import gloomyfolken.mods.core.client.gui.engine.Dimension;
import gloomyfolken.mods.core.client.gui.engine.GuiHelper;
import gloomyfolken.mods.core.client.gui.engine.GuiRendererBuilder;
import gloomyfolken.mods.core.client.gui.engine.IAdvancedGui;
import gloomyfolken.mods.core.client.gui.engine.Point;
import gloomyfolken.mods.core.client.gui.engine.action.GuiActionButtonClick;
import gloomyfolken.mods.core.client.gui.engine.component.McButton;
import gloomyfolken.mods.core.client.gui.engine.component.McLabel;
import gloomyfolken.mods.core.client.gui.engine.component.McTextArea;
import gloomyfolken.mods.core.client.gui.engine.component.McToolTip;
import gloomyfolken.mods.core.client.gui.engine.style.ComponentButtonStyle;
import gloomyfolken.mods.core.client.gui.font.ExternalFont;
import gloomyfolken.mods.core.main.GloomyCore;
import gloomyfolken.mods.party.zwat;
import gloomyfolken.mods.stalker.clans.ClansMod;
import gloomyfolken.mods.stalker.misc.StalkerMiscMod;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import mods.chat.ChatMod;
import mods.pda.client.component.McPlayerIcon;
import mods.pda.client.component.dialog.PdaConfirmDialog;
import mods.pda.client.component.dialog.PlayerSearchDialog;
import mods.pda.client.screens.GuiPda;
import mods.pda.client.screens.tab.AbstractPdaTab;
import mods.pda.client.tab.PdaAchievements;
import mods.pda.client.tab.PdaStats;
import mods.pda.packet.PacketIgnoreAction;
import mods.pda.packet.PacketIgnoredList;
import net.minecraft.client.Minecraft;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumChatFormatting;
import noppes.npcs.client.pda.PdaFactions;
import org.apache.commons.lang3.tuple.Pair;
import org.lwjgl.opengl.GL11;

public class PdaProfile
extends AbstractPdaTab
implements iuxb.kjui,
PacketIgnoredList.IgnoreListConsumer,
qlmx.kjui {
    private static final int MAIN_COLUMN = 443;
    private static final int SIDE_COLUMN = 298;
    private static final String MONOLIT = "\u041c\u043e\u043d\u043e\u043b\u0438\u0442";
    private static final String MILITARY = "\u0412\u043e\u0435\u043d\u043d\u044b\u0435";
    private static final Point[][] backgrounds = new Point[][]{{new Point(0, 0), new Point(0, 128)}, {new Point(128, 0), new Point(128, 128)}, {new Point(256, 0), new Point(256, 128), new Point(256, 256)}, {new Point(384, 0), new Point(384, 128), new Point(384, 256)}};
    private static final DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd").withZone(ZoneId.systemDefault());
    private String targetName;
    private dwmf profileData;
    private List<Pair<String, String>> sideInfo = new ArrayList<Pair<String, String>>();
    private List<iuxb.pidb> friendList = new ArrayList<iuxb.pidb>();
    private McTextArea statusArea;
    private boolean self;
    private boolean waitingSearchResult = false;
    private McButton addFriendButton;
    private McButton ignoreButton;
    private List<PdaAchievements.AchievementEntry> achievementEntries = new ArrayList<PdaAchievements.AchievementEntry>();
    private List<String> ignoredPlayers = new ArrayList<String>();

    public PdaProfile(IAdvancedGui iAdvancedGui, String string) {
        super(iAdvancedGui);
        this.targetName = string;
    }

    public PdaProfile(IAdvancedGui iAdvancedGui, dwmf dwmf2) {
        super(iAdvancedGui);
        this.targetName = dwmf2._d();
        this.profileData = dwmf2;
    }

    @Override
    public void init(GuiPda guiPda) {
        super.init(guiPda);
        this.sideInfo.clear();
        if (this.profileData != null) {
            Object object;
            int n;
            int n2;
            this.achievementEntries = this.profileData._g().stream().filter(string -> wmvj._a(string) != null).map(string -> new PdaAchievements.AchievementEntry(wmvj._a(string), null, false)).collect(Collectors.toList());
            this.self = this.profileData._d().equals(Minecraft._E()._t.username);
            this.setupSideLines();
            this.addPictureButton(this.pdaScreenStart.add(20, 7), new Point(250, 841), new Dimension(23, 23), "\u041f\u043e\u0438\u0441\u043a \u0438\u0433\u0440\u043e\u043a\u043e\u0432", false, guiActionButtonClick -> this.showPlayerSearchDialog());
            McPlayerIcon mcPlayerIcon = new McPlayerIcon((IAdvancedGui)this.pda, this.pdaScreenStart.add(20, 45), new Dimension(128, 128), this.getBackgroundUv());
            for (n2 = 0; n2 < this.profileData._l().length; ++n2) {
                n = this.profileData._l()[n2];
                object = null;
                if (n > 0) {
                    object = new ItemStack(n, 1, 0);
                }
                mcPlayerIcon.setPreviewItem(n2 + 36, (ItemStack)object);
            }
            this.pda.addElement(mcPlayerIcon);
            mcPlayerIcon.setRenderer(new GuiRendererBuilder(this.renderer).setTextureSize(512, 512).create());
            n2 = this.profileData._g().size();
            if (this.self) {
                for (n = 0; n < this.achievementEntries.size(); ++n) {
                    object = this.achievementEntries.get(n);
                    McButton mcButton = GuiHelper.addButton(this.pda, this.pdaScreenStart.add(384, 180 + 57 * n + 5), new Dimension(20, 20), iedw._f, "x").onClick(arg_0 -> this.lambda$init$3((PdaAchievements.AchievementEntry)object, arg_0));
                    mcButton.textColor = 0;
                    this.pda.addElement(new McToolTip((IAdvancedGui)this.pda, Collections.singletonList("\u0423\u0431\u0440\u0430\u0442\u044c \u0438\u0437 \u0438\u0437\u0431\u0440\u0430\u043d\u043d\u044b\u0445"), mcButton));
                }
            }
            this.statusArea = new McTextArea(this.pda, this.pdaScreenStart.add(15, 210 + n2 * 57), new Dimension(398, 240 - n2 * 57));
            this.statusArea.setStyle(iedw._i);
            this.statusArea.setText(this.profileData._f());
            this.statusArea.isEditable = false;
            this.pda.addElement(new McLabel((IAdvancedGui)this.pda, "\u041e \u0441\u0435\u0431\u0435:", this.statusArea.getLocation().add(5, -28), 0x939393));
            if (this.self) {
                this.setupStatusControls();
            }
            this.setupMainInfo();
            this.setupSideButtons();
            this.pda.addElement(this.statusArea);
        }
    }

    @Override
    public void drawComponent(Point point, float f) {
        this.drawScreenBackground(this.pdaScreenStart, new Dimension(443, this.pdaScreen.height), true);
        this.drawScreenBackground(this.pdaScreenStart.add(443, 0), new Dimension(298, this.pdaScreen.height), true);
        if (this.profileData != null) {
            Point point2 = this.pdaScreenStart.add(18, 180);
            for (int i = 0; i < this.achievementEntries.size(); ++i) {
                PdaAchievements.AchievementEntry achievementEntry = this.achievementEntries.get(i);
                this.drawAchievement(achievementEntry, point2.add(0, 57 * i));
            }
        }
        super.drawComponent(point, f);
        this.drawSideInfo();
    }

    private void drawAchievement(PdaAchievements.AchievementEntry achievementEntry, Point point) {
        int n = achievementEntry.ach._e();
        int n2 = n <= 0 ? 0 : (achievementEntry.ach._e() - 10) / 5 + 1;
        Point point2 = new Point(point.x + 80, point.y + 15);
        this.renderer.bindTexture(PdaAchievements.ACHIEVEMENTS);
        float f = 0.55f;
        Dimension dimension = new Dimension((int)((float)PdaAchievements.BG_SIZE.width * f), (int)((float)PdaAchievements.BG_SIZE.height * f));
        Point point3 = PdaAchievements.BACKGROUNDS[n2].multiply(f).add(0, 515);
        this.renderer.drawTexturedRect(point, point3, point3.add((int)((float)PdaAchievements.BG_SIZE.width * f), (int)((float)PdaAchievements.BG_SIZE.height * f)), dimension);
        Point point4 = PdaAchievements.COUNTERS[n2];
        this.renderer.drawTexturedRect(point.add(10, 2), point4, point4.add(PdaAchievements.COUNTER_SIZE.width, PdaAchievements.COUNTER_SIZE.height), new Dimension((int)((float)PdaAchievements.COUNTER_SIZE.width * f), (int)((float)PdaAchievements.COUNTER_SIZE.height * f)));
        ExternalFont.tahoma16.renderString(this.renderer.trimToWidth(achievementEntry.ach._c(), 221, true), point2.x / 2, point2.y / 2, -1, true);
        GL11.glDisable(3042);
    }

    private void drawSideInfo() {
        for (int i = 0; i < this.sideInfo.size(); ++i) {
            String string = this.sideInfo.get(i).getKey();
            String string2 = this.sideInfo.get(i).getValue();
            int n = this.pdaScreenStart.y + 45 + (this.renderer.getFontHeight() + 3) * i;
            this.renderer.drawString(string, this.pdaScreenStart.x + 443 + 15, n, 0x939393);
            this.renderer.drawString(string2, this.pdaScreenStart.x + 443 + 298 - 30 - this.renderer.getStringWidth(string2), n, 0x939393);
        }
    }

    @Override
    public void requestInformation() {
        if (this.profileData == null) {
            new jxzm(this.targetName).sendToServer();
        }
        if (!Minecraft._E()._t.username.equals(this.targetName)) {
            new srtr().sendClientToBackend();
            new PacketIgnoredList().sendToServer();
        }
    }

    @Override
    public void updatePlayerProfile(dwmf dwmf2) {
        if (this.waitingSearchResult) {
            this.pda.openTab(new PdaProfile((IAdvancedGui)this.pda, dwmf2));
        } else {
            this.profileData = dwmf2;
            this.pda.openTab(this);
        }
    }

    @Override
    public void updateFriends(List<iuxb.pidb> list) {
        this.friendList = list;
        if (this.addFriendButton != null) {
            this.addFriendButton.text = this.isFriend() ? "\u0423\u0434\u0430\u043b\u0438\u0442\u044c \u0438\u0437 \u0434\u0440\u0443\u0437\u0435\u0439" : "\u0414\u043e\u0431\u0430\u0432\u0438\u0442\u044c \u0432 \u0434\u0440\u0443\u0437\u044c\u044f";
            this.addFriendButton.setEnabled(true);
        }
    }

    private void showPlayerSearchDialog() {
        PlayerSearchDialog playerSearchDialog = new PlayerSearchDialog(this.pda, this.pdaScreenStart.add(this.pdaScreen.width / 2 - 200, this.pdaScreen.height / 2 - 80), new Dimension(400, 160)).setNameConsumer(this::findPlayerProfile);
        this.pda.addElement(playerSearchDialog);
        playerSearchDialog.init();
    }

    private Point getBackgroundUv() {
        int n = this.profileData._i().equals(MONOLIT) ? 0 : (this.profileData._i().equals(MILITARY) ? 1 : (this.profileData._h() == tupg._c ? 2 : 3));
        Point[] pointArray = backgrounds[n];
        int n2 = Math.abs(this.profileData._d().hashCode()) % pointArray.length;
        return pointArray[n2];
    }

    private void setupMainInfo() {
        boolean bl;
        int n = 0x939393;
        String string = this.profileData._h()._e + " " + this.profileData._d();
        Point point = this.pdaScreenStart.add(160, 60);
        GuiHelper.addLabel((IAdvancedGui)this.pda, string, point, n);
        boolean bl2 = bl = !this.profileData._i().equals("");
        if (bl) {
            GuiHelper.addLabel((IAdvancedGui)this.pda, "\u0413\u0440\u0443\u043f\u043f\u0438\u0440\u043e\u0432\u043a\u0430: " + this.profileData._i(), point.add(0, 20), n);
            GuiHelper.addLabel((IAdvancedGui)this.pda, "\u0420\u0430\u043d\u0433: " + this.profileData._j()._e, point.add(0, 40), n);
        }
        boolean bl3 = this.profileData._k();
        String string2 = "\u0421\u0442\u0430\u0442\u0443\u0441: " + (bl3 ? (Object)((Object)EnumChatFormatting._k) + "\u0412 \u0441\u0435\u0442\u0438" : (Object)((Object)EnumChatFormatting._m) + "\u041d\u0435 \u0432 \u0441\u0435\u0442\u0438");
        GuiHelper.addLabel((IAdvancedGui)this.pda, string2, point.add(0, bl ? 60 : 20), n);
        if (!bl3) {
            boolean bl4 = System.currentTimeMillis() - this.profileData._c() > TimeUnit.HOURS.toMillis(1L);
            String string3 = bl4 ? this.profileData._a() : this.profileData._b();
            String string4 = bl4 ? this.profileData._b() : this.profileData._a();
            McLabel mcLabel = GuiHelper.addLabel((IAdvancedGui)this.pda, "\u0417\u0430\u0445\u043e\u0434\u0438\u043b: " + string3, point.add(0, bl ? 80 : 40), n);
            mcLabel.noMouseInteraction = false;
            this.pda.addElement(new McToolTip((IAdvancedGui)this.pda, Collections.singletonList(string4), mcLabel));
        }
    }

    private void setupStatusControls() {
        Point point = this.statusArea.getLocation().add(0, this.statusArea.getSize().height + 7);
        McButton mcButton = GuiHelper.addButton(this.pda, point, new Dimension(150, 27), iedw._l, "\u0421\u043e\u0445\u0440\u0430\u043d\u0438\u0442\u044c");
        McButton mcButton2 = GuiHelper.addButton(this.pda, point, new Dimension(150, 27), iedw._l, "\u0420\u0435\u0434\u0430\u043a\u0442\u0438\u0440\u043e\u0432\u0430\u0442\u044c");
        mcButton.setEnabled(false);
        mcButton.setVisible(false);
        mcButton2.onClick(guiActionButtonClick -> {
            this.statusArea.setEnabled(true);
            this.statusArea.setFocused(true);
            this.statusArea.isEditable = true;
            mcButton.setEnabled(true);
            mcButton.setVisible(true);
            ((McButton)guiActionButtonClick.component).setEnabled(false);
            ((McButton)guiActionButtonClick.component).setVisible(false);
        });
        mcButton.onClick(guiActionButtonClick -> {
            this.statusArea.setEnabled(false);
            this.statusArea.setFocused(false);
            this.statusArea.isEditable = false;
            mcButton2.setEnabled(true);
            mcButton2.setVisible(true);
            ((McButton)guiActionButtonClick.component).setEnabled(false);
            ((McButton)guiActionButtonClick.component).setVisible(false);
            this.updateStatus();
        });
    }

    private void setupSideLines() {
        Object object;
        Object object2 = this.profileData._e().get(ClansMod._h);
        if (object2 != null && !"".equals(this.profileData._i())) {
            this.sideInfo.add(Pair.of("\u0412 \u0433\u0440\u0443\u043f\u043f\u0438\u0440\u043e\u0432\u043a\u0435 \u0441:", dateFormatter.format((TemporalAccessor)object2)));
        }
        if ((object = this.profileData._e().get(GloomyCore.REGISTRATION_TIME)) != null) {
            this.sideInfo.add(Pair.of("\u0412 \u0417\u043e\u043d\u0435 \u0441:", dateFormatter.format((TemporalAccessor)object)));
        }
        double d = this.profileData._e().getInt(GloomyCore.KILLS);
        double d2 = this.profileData._e().getInt(GloomyCore.DEATHS);
        double d3 = d / Math.max(d2, 1.0);
        this.sideInfo.addAll(Arrays.asList(Pair.of("\u0421\u043e\u043e\u0442\u043d\u043e\u0448\u0435\u043d\u0438\u0435 \u0423/C:", String.format("%.2f", d3)), Pair.of("\u041e\u0447\u043a\u0438 \u0434\u043e\u0441\u0442\u0438\u0436\u0435\u043d\u0438\u0439:", String.valueOf(this.profileData._e().getInt(GloomyCore.ACHIEVEMENT_POINTS))), Pair.of("\u041f\u043e\u0441\u044b\u043b\u043e\u043a \u0434\u043e\u0441\u0442\u0430\u0432\u043b\u0435\u043d\u043e:", String.valueOf(this.profileData._e().getInt(StalkerMiscMod._i)))));
    }

    private void setupSideButtons() {
        int n = 0;
        Point point = this.pdaScreenStart.add(458, this.pdaScreen.height - 40);
        Dimension dimension = new Dimension(255, 27);
        ComponentButtonStyle componentButtonStyle = iedw._l;
        if (!this.self) {
            GuiHelper.addButton(this.pda, point.add(0, -33 * n++), dimension, componentButtonStyle, "\u041d\u0430\u043f\u0438\u0441\u0430\u0442\u044c \u0441\u043e\u043e\u0431\u0449\u0435\u043d\u0438\u0435").onClick(guiActionButtonClick -> this.sendMessage()).setEnabled(this.profileData._k());
            this.addFriendButton = GuiHelper.addButton(this.pda, point.add(0, -33 * n++), dimension, componentButtonStyle, "\u0414\u043e\u0431\u0430\u0432\u0438\u0442\u044c \u0432 \u0434\u0440\u0443\u0437\u044c\u044f").onClick(guiActionButtonClick -> this.inviteToFriends());
            if (this.friendList.stream().anyMatch(pidb2 -> pidb2._a().equals(this.targetName))) {
                this.addFriendButton.setEnabled(false);
            }
            GuiHelper.addButton(this.pda, point.add(0, -33 * n++), dimension, componentButtonStyle, "\u041f\u0440\u0438\u0433\u043b\u0430\u0441\u0438\u0442\u044c \u0432 \u043e\u0442\u0440\u044f\u0434").onClick(this::inviteToParty).setEnabled(this.profileData._k() && "".equals(this.profileData._i()) && zwat._a._a(this.profileData._d()));
            GuiHelper.addButton(this.pda, point.add(0, -33 * n++), dimension, componentButtonStyle, "\u041f\u0440\u0438\u0433\u043b\u0430\u0441\u0438\u0442\u044c \u0432 \u0433\u0440\u0443\u043f\u043f\u0438\u0440\u043e\u0432\u043a\u0443").onClick(this::inviteToGuild).setEnabled(this.profileData._k() && yuch._a._b(this.profileData._d()));
            this.ignoreButton = GuiHelper.addButton(this.pda, point.add(0, -33 * n++), dimension, componentButtonStyle, this.isIgnored() ? "\u0420\u0430\u0437\u0431\u043b\u043e\u043a\u0438\u0440\u043e\u0432\u0430\u0442\u044c" : "\u0417\u0430\u0431\u043b\u043e\u043a\u0438\u0440\u043e\u0432\u0430\u0442\u044c").onClick(this::handleIgnoreAction);
        }
        if (this.self) {
            GuiHelper.addButton(this.pda, point.add(0, -33 * n++), dimension, componentButtonStyle, "\u041c\u043e\u0438 \u0444\u0440\u0430\u043a\u0446\u0438\u0438").onClick(guiActionButtonClick -> this.pda.openTab(new PdaFactions(this.pda)));
        }
        GuiHelper.addButton(this.pda, point.add(0, -33 * n++), dimension, componentButtonStyle, this.self ? "\u041c\u043e\u0438 \u0434\u043e\u0441\u0442\u0438\u0436\u0435\u043d\u0438\u044f" : "\u0414\u043e\u0441\u0442\u0438\u0436\u0435\u043d\u0438\u044f \u0438\u0433\u0440\u043e\u043a\u0430").onClick(guiActionButtonClick -> this.openAchievements());
        GuiHelper.addButton(this.pda, point.add(0, -33 * n++), dimension, componentButtonStyle, this.self ? "\u041c\u043e\u044f \u0441\u0442\u0430\u0442\u0438\u0441\u0442\u0438\u043a\u0430" : "\u0421\u0442\u0430\u0442\u0438\u0441\u0442\u0438\u043a\u0430 \u0438\u0433\u0440\u043e\u043a\u0430").onClick(guiActionButtonClick -> this.openStats());
    }

    private void handleIgnoreAction(GuiActionButtonClick guiActionButtonClick) {
        if (this.isIgnored()) {
            new PacketIgnoreAction(this.profileData._d(), false).sendToServer();
        } else {
            PdaConfirmDialog pdaConfirmDialog = new PdaConfirmDialog(this.pda, this.pdaScreenStart.add(this.pdaScreen.width / 2 - 250, this.pdaScreen.height / 2 - 100), new Dimension(500, 200));
            this.pda.addElement(pdaConfirmDialog);
            pdaConfirmDialog.init();
            pdaConfirmDialog.setOnConfirm(() -> new PacketIgnoreAction(this.profileData._d(), true).sendToServer()).setOnDecline(() -> this.pda.removeElement(pdaConfirmDialog)).setText("\u0415\u0441\u043b\u0438 \u0432\u044b \u0434\u043e\u0431\u0430\u0432\u0438\u0442\u0435 \u0438\u0433\u0440\u043e\u043a\u0430 " + this.profileData._d() + " \u0432 \u0438\u0433\u043d\u043e\u0440-\u043b\u0438\u0441\u0442, \u0442\u043e \u043d\u0435 \u0431\u0443\u0434\u0435\u0442\u0435 \u0432\u0438\u0434\u0435\u0442\u044c \u0441\u043e\u043e\u0431\u0449\u0435\u043d\u0438\u044f, \u043f\u0438\u0441\u044c\u043c\u0430 \u0438 \u0443\u0432\u0435\u0434\u043e\u043c\u043b\u0435\u043d\u0438\u044f \u043e\u0442 \u043d\u0435\u0433\u043e.").setStatus(true);
        }
        ((McButton)guiActionButtonClick.component).setEnabled(false);
    }

    private boolean isIgnored() {
        return this.ignoredPlayers.contains(this.profileData._d());
    }

    private void findPlayerProfile(String string) {
        new jxzm(string).sendToServer();
        this.waitingSearchResult = true;
    }

    private void updateStatus() {
        new ezmu(this.statusArea.getText()).sendToServer();
    }

    private void openStats() {
        if (this.profileData != null) {
            this.pda.openTab(new PdaStats(this.pda, this.targetName, this.profileData._e(), Stat.StatsCategory.SURVIVAL));
        }
    }

    public void openAchievements() {
        this.pda.openTab(new PdaAchievements(this.pda, this.targetName));
    }

    public void inviteToFriends() {
        if (this.isFriend()) {
            new mqcx(this.targetName).sendClientToBackend();
        } else {
            new uxzh(this.targetName).sendClientToBackend();
        }
        this.addFriendButton.setEnabled(false);
    }

    public boolean isFriend() {
        return this.friendList.stream().anyMatch(pidb2 -> pidb2._a().equals(this.targetName));
    }

    public void inviteToGuild(GuiActionButtonClick guiActionButtonClick) {
        new ncdg(this.profileData._d()).sendClientToBackend();
        ((McButton)guiActionButtonClick.component).setEnabled(false);
    }

    private void inviteToParty(GuiActionButtonClick guiActionButtonClick) {
        new cthk(this.profileData._d()).sendClientToBackend();
        ((McButton)guiActionButtonClick.component).setEnabled(false);
    }

    private void sendMessage() {
        ChatMod.openChatWith(this.profileData._d());
    }

    @Override
    public void updateIgnored(List<String> list) {
        this.ignoredPlayers = list;
        this.ignoreButton.setEnabled(true);
        this.ignoreButton.text = this.isIgnored() ? "\u0420\u0430\u0437\u0431\u043b\u043e\u043a\u0438\u0440\u043e\u0432\u0430\u0442\u044c" : "\u0417\u0430\u0431\u043b\u043e\u043a\u0438\u0440\u043e\u0432\u0430\u0442\u044c";
    }

    private /* synthetic */ void lambda$init$3(PdaAchievements.AchievementEntry achievementEntry, GuiActionButtonClick guiActionButtonClick) {
        new ncdr(achievementEntry.ach._a(), false).sendToServer();
        this.profileData._g().remove(achievementEntry.ach._a());
        this.pda.openTab(this);
    }
}

