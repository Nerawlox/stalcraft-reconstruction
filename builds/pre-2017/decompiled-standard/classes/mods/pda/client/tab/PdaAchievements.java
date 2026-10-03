/*
 * Decompiled with CFR 0.152.
 */
package mods.pda.client.tab;

import gloomyfolken.mods.core.client.gui.engine.Dimension;
import gloomyfolken.mods.core.client.gui.engine.GuiHelper;
import gloomyfolken.mods.core.client.gui.engine.GuiRenderer;
import gloomyfolken.mods.core.client.gui.engine.GuiRendererBuilder;
import gloomyfolken.mods.core.client.gui.engine.IAdvancedGui;
import gloomyfolken.mods.core.client.gui.engine.Point;
import gloomyfolken.mods.core.client.gui.engine.component.IScrollable;
import gloomyfolken.mods.core.client.gui.engine.component.McButton;
import gloomyfolken.mods.core.client.gui.engine.component.McImage;
import gloomyfolken.mods.core.client.gui.engine.component.McScrollBar;
import gloomyfolken.mods.core.client.gui.engine.component.McScrollButton;
import gloomyfolken.mods.core.client.gui.engine.component.McScrollList;
import gloomyfolken.mods.core.client.gui.engine.style.ComponentButtonStyle;
import gloomyfolken.mods.core.client.gui.font.ExternalFont;
import gloomyfolken.mods.core.misc.vjsq;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import mods.pda.client.screens.GuiPda;
import mods.pda.client.screens.tab.AbstractPdaTab;
import net.minecraft.client.xpzm;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

public class PdaAchievements
extends AbstractPdaTab
implements eiku.kjui {
    public static final Point[] BACKGROUNDS = new Point[]{new Point(1, 1), new Point(1, 104), new Point(1, 207), new Point(1, 310)};
    public static final Point BRICK = new Point(1, 413);
    public static final Dimension BG_SIZE = new Dimension(708, 102);
    public static final Point[] COUNTERS = new Point[]{new Point(714, 433), new Point(714, 1), new Point(714, 109), new Point(714, 217)};
    public static final Dimension COUNTER_SIZE = new Dimension(96, 96);
    public static final Point COUNTER_BLOCKED = new Point(714, 325);
    public static final ResourceLocation ACHIEVEMENTS = new ResourceLocation("pda", "textures/gui/achievements.png");
    private String username;
    private List<String> categories = wmvj._a().stream().map(turb::_b).distinct().collect(Collectors.toList());
    private String category = !this.categories.isEmpty() ? this.categories.get(0) : "";
    private uxqz storage = new uxqz();
    private List<String> displayedAchievements = new ArrayList<String>();
    private List<AchievementEntry> achievements = new ArrayList<AchievementEntry>();
    private boolean self = false;

    public PdaAchievements(IAdvancedGui iAdvancedGui, String string) {
        super(iAdvancedGui);
        this.username = string;
        this.allowParentJump = true;
    }

    @Override
    public void init(GuiPda guiPda) {
        super.init(guiPda);
        this.createNavigation(this.categories);
        this.initList();
        this.updateAchievementsContent();
    }

    @Override
    public void drawComponent(Point point, float f) {
        this.drawScreenBackground(this.pdaScreenStart, this.pdaScreen, true);
        super.drawComponent(point, f);
    }

    @Override
    public void requestInformation() {
        new roqd(this.username).sendToServer();
    }

    @Override
    public void updateAchivements(uxqz uxqz2, List<String> list2) {
        this.storage = uxqz2;
        this.displayedAchievements = list2;
        this.self = uxqz2._b().equals(xpzm._E()._t.field_71092_bJ);
        this.updateAchievementsContent();
    }

    private void updateAchievementsContent() {
        this.achievements.clear();
        wmvj._a().stream().filter(turb2 -> this.category.equals("") || this.category.equals(turb2._b())).map(turb2 -> new AchievementEntry((turb)turb2, this.storage._a((turb)turb2), false)).filter(achievementEntry -> achievementEntry.ach._e() != 0 || achievementEntry.state._a()).sorted(Comparator.comparing(achievementEntry -> achievementEntry.state._a()).thenComparing(achievementEntry -> achievementEntry.state instanceof kjwj && ((kjwj)achievementEntry.state)._f() > 0).thenComparingInt(achievementEntry -> achievementEntry.state._a() ? -achievementEntry.ach._e() : 0).reversed()).forEach(this.achievements::add);
        this.updateDisplayedState();
    }

    private void updateDisplayedState() {
        this.achievements.forEach(achievementEntry -> {
            achievementEntry.displayed = this.self && this.displayedAchievements.contains(achievementEntry.ach._a());
        });
    }

    private void createNavigation(List<String> list2) {
        int n = 0;
        GuiRenderer guiRenderer = this.pda.rendererWithFont(ExternalFont.tahoma11);
        for (int i = 0; i < list2.size(); ++i) {
            String string = list2.get(i);
            int n2 = guiRenderer.getStringWidth(string);
            McButton mcButton = GuiHelper.addButton(this.parent, this.pdaScreenStart.add(10 + n, 15), new Dimension(n2, 15), iedw._f, string);
            n += n2 + 10;
            mcButton.setRenderer(guiRenderer);
            mcButton.onClick(guiActionButtonClick -> {
                this.category = string;
                this.pda.openTab(this);
            });
            this.pda.addElement(mcButton);
            if (!this.category.equals(string)) {
                mcButton.mouseOverTextColor = 0xFFFFFF;
                mcButton.textColor = iedw._e.getRGB();
            } else {
                mcButton.textColor = 0x109101;
                this.pda.addElement(mcButton);
            }
            if (i == list2.size() - 1) continue;
            this.pda.addElement(new McImage((IAdvancedGui)this.pda, mcButton.getLocation().add(n2, 0), new Point(84, 880), new Dimension(11, 13), iedw._a));
        }
    }

    protected void initList() {
        Point point = this.pdaScreenStart.add(5, 23);
        Dimension dimension = new Dimension(this.pdaScreen.width - 23, this.pdaScreen.height - 35);
        AchievementsList achievementsList = new AchievementsList(this.parent, iedw._g, this.achievements, point.add(5, 28), dimension.add(-13, -35));
        achievementsList.setRenderer(new GuiRendererBuilder(this.renderer).setFontRenderer(ExternalFont.tahoma14).create());
        McScrollBar mcScrollBar = new McScrollBar(this.parent, (IScrollable)achievementsList, McScrollBar.ScrollBarType.VERTICAL, point.add(dimension.width, 14), dimension.height - 28, iedw._j.getVerticalBarStyle());
        mcScrollBar.setSliderLength(16);
        achievementsList.setSlider(mcScrollBar);
        achievementsList.setDrawLineSeparators(true);
        this.pda.addElement(achievementsList);
        this.pda.addElement(mcScrollBar);
        this.pda.addElement(new McScrollButton(this.parent, mcScrollBar, McScrollButton.ScrollButtonDirection.TOP, new Point(point.x + dimension.width, point.y), iedw._k.getTopArrowStyle()));
        this.pda.addElement(new McScrollButton(this.parent, mcScrollBar, McScrollButton.ScrollButtonDirection.BOTTOM, new Point(point.x + dimension.width, point.y + dimension.height - 14), iedw._k.getBottomArrowStyle()));
    }

    private void onAchievementClick(AchievementEntry achievementEntry) {
        if (!this.self) {
            return;
        }
        if (achievementEntry.state._a()) {
            boolean bl = !achievementEntry.displayed;
            String string = achievementEntry.ach._a();
            new ncdr(string, !achievementEntry.displayed).sendToServer();
            boolean bl2 = achievementEntry.displayed = !achievementEntry.displayed;
            if (bl) {
                if (!this.displayedAchievements.contains(string)) {
                    this.displayedAchievements.add(string);
                    if (this.displayedAchievements.size() > 3) {
                        this.displayedAchievements = new ArrayList<String>(this.displayedAchievements.subList(1, 4));
                    }
                }
            } else {
                this.displayedAchievements.remove(string);
            }
            this.updateDisplayedState();
        }
    }

    public class AchievementsList
    extends McScrollList<AchievementEntry> {
        public AchievementsList(IAdvancedGui iAdvancedGui, ComponentButtonStyle componentButtonStyle, List<AchievementEntry> list2, Point point, Dimension dimension) {
            super(iAdvancedGui, componentButtonStyle, list2, point, dimension, 102);
        }

        @Override
        protected void drawLine(int n, int n2, Point point) {
            Point point2;
            GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
            AchievementEntry achievementEntry = (AchievementEntry)this.lines.get(n);
            boolean bl = achievementEntry.ach instanceof srok;
            boolean bl2 = achievementEntry.state._a();
            int n3 = achievementEntry.ach._e();
            int n4 = n3 <= 0 ? 0 : (achievementEntry.ach._e() - 10) / 5 + 1;
            Point point3 = new Point(this.getLocation().x + 140, n2 + 20);
            GL11.glEnable(3042);
            this.renderer.bindTexture(ACHIEVEMENTS);
            if (bl) {
                this.renderer.drawTexturedModalRect(this.getLocation().x, n2, PdaAchievements.BRICK.x, PdaAchievements.BRICK.y, PdaAchievements.BG_SIZE.width, PdaAchievements.BG_SIZE.height);
                point2 = BACKGROUNDS[n4];
                float f = ((kjwj)achievementEntry.state)._f();
                float f2 = ((srok)achievementEntry.ach)._e;
                int n5 = (int)((float)PdaAchievements.BG_SIZE.width * (f / f2));
                this.renderer.drawTexturedModalRect(this.getLocation().x, n2, point2.x, point2.y, n5, PdaAchievements.BG_SIZE.height);
                if (PdaAchievements.BG_SIZE.width - n5 > 30 && f > 0.0f) {
                    this.renderer.drawTexturedModalRect(this.getLocation().x + n5, n2 + 2, 834, 1, 18, 93);
                }
            } else {
                point2 = bl2 ? BACKGROUNDS[n4] : BRICK;
                this.renderer.drawTexturedModalRect(this.getLocation().x, n2, point2.x, point2.y, PdaAchievements.BG_SIZE.width, PdaAchievements.BG_SIZE.height);
            }
            point2 = bl2 ? COUNTERS[n4] : COUNTER_BLOCKED;
            this.renderer.drawTexturedModalRect(this.getLocation().x + 10, n2 + 2, point2.x, point2.y, PdaAchievements.COUNTER_SIZE.width, PdaAchievements.COUNTER_SIZE.height);
            if (PdaAchievements.this.self && achievementEntry.state._a()) {
                this.renderer.bindTexture(iedw._a);
                GL11.glEnable(3042);
                if (achievementEntry.displayed) {
                    GL11.glColor4f(1.0f, 1.0f, 0.0f, 1.0f);
                }
                this.renderer.drawTexturedModalRect(this.getLocation().x + this.getSize().width - 40, n2 + 5, 363, 837, 26, 25);
            }
            ExternalFont.tahoma18.renderString(achievementEntry.ach._c(), point3.x / 2, point3.y / 2, -1, true);
            this.renderer.renderStringAbsolutePos(achievementEntry.ach._d(), point3.x + 1, point3.y + 30, -1, true);
            if (bl) {
                int n6 = ((kjwj)achievementEntry.state)._f();
                int n7 = ((srok)achievementEntry.ach)._e;
                String string = String.format("%d / %d", n6, n7);
                this.renderer.renderStringAbsolutePos(string, point3.x + 530 - this.renderer.getStringWidth(string), point3.y + 10, -1, true);
            }
            GL11.glDisable(3042);
        }

        @Override
        public void setSelectedLineId(int n) {
            super.setSelectedLineId(n);
            AchievementEntry achievementEntry = (AchievementEntry)this.getSelectedLine();
            if (achievementEntry != null) {
                PdaAchievements.this.onAchievementClick(achievementEntry);
            }
        }
    }

    public static class AchievementEntry
    implements vjsq {
        public final turb ach;
        public final pzde state;
        public boolean displayed = false;

        public AchievementEntry(turb turb2, pzde pzde2, boolean bl) {
            this.ach = turb2;
            this.state = pzde2 == null ? turb2._f() : pzde2;
            this.displayed = bl;
        }

        @Override
        public String getString() {
            return this.ach._c();
        }

        @Override
        public int getColor() {
            return 0x9393939;
        }
    }
}

