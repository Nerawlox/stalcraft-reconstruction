/*
 * Decompiled with CFR 0.152.
 */
package mods.pda.client.screens;

import gloomyfolken.mods.core.client.gui.engine.Dimension;
import gloomyfolken.mods.core.client.gui.engine.GuiHelper;
import gloomyfolken.mods.core.client.gui.engine.GuiRenderer;
import gloomyfolken.mods.core.client.gui.engine.GuiRendererBuilder;
import gloomyfolken.mods.core.client.gui.engine.GuiScreenAdvanced;
import gloomyfolken.mods.core.client.gui.engine.IAdvancedGui;
import gloomyfolken.mods.core.client.gui.engine.Point;
import gloomyfolken.mods.core.client.gui.engine.component.GuiComponent;
import gloomyfolken.mods.core.client.gui.engine.component.GuiComponentsList;
import gloomyfolken.mods.core.client.gui.engine.component.IFocusable;
import gloomyfolken.mods.core.client.gui.engine.component.McLabel;
import gloomyfolken.mods.core.client.gui.engine.component.McScrollPane;
import gloomyfolken.mods.core.client.gui.font.ExternalFont;
import gloomyfolken.mods.core.client.gui.font.IFontRenderer;
import gloomyfolken.mods.effects.client.main.jxtc;
import gloomyfolken.mods.effects.client.main.zwaw;
import gloomyfolken.mods.money.zwat;
import java.util.Collection;
import java.util.Comparator;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import kotlin.Unit;
import mods.pda.PdaMod;
import mods.pda.client.PdaTabMeta;
import mods.pda.client.component.PdaTabButton;
import mods.pda.client.component.dialog.NotificationDialog;
import mods.pda.client.component.dialog.PdaConfirmDialog;
import mods.pda.client.screens.tab.AbstractPdaTab;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.settings.KeyBinding;
import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL20;

public class GuiPda
extends GuiScreenAdvanced
implements ejiw,
owwh {
    private final Dimension bgSize = new Dimension(1024, 700);
    private int initialScale;
    private Point pdaScreenStart;
    private Dimension pdaScreen;
    private McLabel timeLabel;
    public PdaTabMeta selectedComponent;
    public AbstractPdaTab currentTab;
    public PdaConfirmDialog dialog;
    private int tick = 0;

    public GuiPda() {
        this.initialScale = Minecraft._E()._M.guiScale;
        Minecraft._E()._M.guiScale = 2;
    }

    public GuiPda(AbstractPdaTab abstractPdaTab) {
        this();
        this.currentTab.requestInformation();
        this.currentTab = abstractPdaTab;
    }

    @Override
    public void initGui() {
        super.initGui();
        Minecraft._E()._M.guiScale = 2;
        if (this.selectedComponent == null && PdaMod.getClientPda().lastChoosenTab != null) {
            this.selectedComponent = PdaMod.getClientPda().getLastPdaTab();
        }
        this.renderer = new GuiRendererBuilder().setFontRenderer(ExternalFont.tahoma12).setTextureSize(1024, 1024).create();
        Map<String, PdaTabMeta> map = PdaMod.getClientPda().getPdaTabs();
        if (map.isEmpty()) {
            return;
        }
        if (this.selectedComponent == null) {
            this.selectedComponent = map.entrySet().iterator().next().getValue();
        }
        if (this.currentTab == null) {
            this.openTab(this.selectedComponent.createPdaTab(this));
        } else {
            this.openTab(this.currentTab);
        }
    }

    public void openTab(AbstractPdaTab abstractPdaTab) {
        this.openTab(abstractPdaTab, true);
    }

    public void openTab(AbstractPdaTab abstractPdaTab, boolean bl) {
        if (this.currentTab != abstractPdaTab) {
            abstractPdaTab.requestInformation();
            if (bl) {
                abstractPdaTab.parentTab = this.currentTab;
            }
            if (this.currentTab != null) {
                this.currentTab.onScreenClose();
            }
        }
        this.currentTab = abstractPdaTab;
        this.buttonList.clear();
        this.elementsList.clearElements();
        this.createTabs(PdaMod.getClientPda().getPdaTabs().values().stream().sorted(Comparator.comparing(PdaTabMeta::getPriority)).collect(Collectors.toList()));
        this.createMoneyLabel();
        this.pdaScreenStart = new Point((int)((double)(this.screenWidth / 2) - (double)this.bgSize.width / 3.5), (int)((double)(this.screenHeight / 2) - (double)this.bgSize.height / 2.8 - 1.0));
        abstractPdaTab.setPdaScreenStart(this.pdaScreenStart);
        this.pdaScreen = new Dimension(741, 504);
        abstractPdaTab.setPdaScreen(this.pdaScreen);
        this.addElement(abstractPdaTab);
        abstractPdaTab.init(this);
        this.dialog = new PdaConfirmDialog(this, this.pdaScreenStart.add(this.pdaScreen.width / 2 - 250, this.pdaScreen.height / 2 - 100), new Dimension(500, 200));
        this.dialog.init().setStatus(false);
        this.addElement(this.dialog);
        this.timeLabel = GuiHelper.addLabel(this, "00:00", new Point(this.screenWidth / 2 - 410, this.screenHeight / 2 + 264));
        this.timeLabel.setRenderer(this.rendererWithFont(ExternalFont.tahoma14));
        this.timeLabel.setStyle(iedw._h);
    }

    public void showNotification(zfhb.kjui kjui2, String string) {
        NotificationDialog notificationDialog = new NotificationDialog(this, this.pdaScreenStart.add(this.pdaScreen.width / 2 - 250, this.pdaScreen.height / 2 - 100), new Dimension(500, 200), kjui2, string);
        this.addElement(notificationDialog);
        notificationDialog.init();
    }

    @Override
    public void drawScreen(int n, int n2, float f) {
        this.drawDefaultBackground();
        this.renderPdaBackground();
        super.drawScreen(n, n2, f);
        this.renderTimeIcon();
        this.renderLEDs();
        if (PdaMod.isInterfering()) {
            GuiPda.drawInterferenceOverlay(this.renderer.scale, this.screenWidth / 2 - 448, this.screenHeight / 2 - 252, 896.0f, 544.0f, 1.0f, false);
        }
    }

    @Override
    protected void keyTyped(char c, int n) {
        super.keyTyped(c, n);
        if (n == PdaMod.instance.pdaKey._d && !this.isAnyFocused(this.getElementsList())) {
            this.closeScreen();
        }
    }

    @Override
    public void handleKeyboardInput() {
        int n = Keyboard.getEventKey();
        char c = Keyboard.getEventCharacter();
        if (!this.isAnyFocused(this.getElementsList())) {
            this._a();
        } else {
            KeyBinding._a();
        }
        if (Keyboard.getEventKeyState()) {
            this.keyTyped(c, n);
        }
    }

    private boolean isAnyFocused(GuiComponentsList<GuiComponent> guiComponentsList) {
        boolean bl = false;
        for (GuiComponent guiComponent : guiComponentsList.getElements()) {
            if (guiComponent instanceof IFocusable) {
                bl = ((IFocusable)((Object)guiComponent)).isFocused();
            } else if (guiComponent instanceof GuiComponentsList) {
                bl = this.isAnyFocused((GuiComponentsList)guiComponent);
            }
            if (!bl) continue;
            break;
        }
        return bl;
    }

    @Override
    protected void mouseClicked(int n, int n2, int n3) {
        super.mouseClicked(n, n2, n3);
    }

    @Override
    public void updateScreen() {
        ++this.tick;
        super.updateScreen();
        this.timeLabel.setText(bqgh._b(Minecraft._E()._r.getWorldTime()));
    }

    private void createTabs(Collection<PdaTabMeta> collection) {
        McScrollPane mcScrollPane = this.setupScrollingPane(collection.size() * 20);
        Dimension dimension = new Dimension(139, 27);
        int n = 0;
        GuiRenderer guiRenderer = this.rendererWithFont(ExternalFont.tahoma13);
        for (PdaTabMeta pdaTabMeta : collection) {
            PdaTabButton pdaTabButton = pdaTabMeta.createTabButton(this, new Point(0, n++ * 28), dimension);
            pdaTabButton.setRenderer(guiRenderer);
            pdaTabButton.selected = pdaTabMeta == this.selectedComponent;
            pdaTabButton.onClick(guiActionButtonClick -> {
                this.selectedComponent = pdaTabMeta;
                PdaMod.getClientPda().lastChoosenTab = this.selectedComponent.getId();
                this.openTab(this.selectedComponent.createPdaTab(this), false);
            });
            mcScrollPane.getViewport().addElement(pdaTabButton);
        }
        this.addElement(mcScrollPane);
    }

    private McScrollPane setupScrollingPane(int n) {
        int n2 = this.screenWidth / 2 - 448;
        int n3 = this.screenHeight / 2 - 252;
        return GuiPda.createScrollPane(this, new Point(n2, n3), new Dimension(152, 513), new Dimension(150, n));
    }

    private void createMoneyLabel() {
        if (this.mc._t == null) {
            return;
        }
        String string = "\u0421\u0447\u0435\u0442: " + zwat._a(this.mc._t)._b();
        int n = this.screenWidth / 2 + 420 - this.renderer.getStringWidth(string) - 15;
        int n2 = this.screenHeight / 2 + 264;
        McLabel mcLabel = new McLabel((IAdvancedGui)this, string, n, n2);
        mcLabel.setStyle(iedw._h);
        mcLabel.setRenderer(this.rendererWithFont(ExternalFont.tahoma14));
        this.addElement(mcLabel);
    }

    private void renderLEDs() {
        boolean bl = PdaMod.isInterfering();
        if (!bl && Math.sin(this.tick) * 15.0 % 1.0 < 0.7) {
            this.drawLED(this.pdaScreenStart.add(597, -37), 0.0f, 1.0f, 0.0f, 1.0f);
        }
        if (bl && Math.sin(this.tick / 3) > 0.0) {
            this.drawLED(this.pdaScreenStart.add(615, -37), 1.0f, 1.0f - PdaMod.getInterference() * 10.0f, 0.0f, 1.0f);
        }
        this.drawLED(this.pdaScreenStart.add(652, -37), 0.0f, 1.0f, 0.0f, 1.0f);
    }

    private void drawLED(Point point, float f, float f2, float f3, float f4) {
        Point point2 = new Point(340, 878);
        Dimension dimension = new Dimension(22, 22);
        GL11.glEnable(3042);
        GL11.glColor4f(f, f2, f3, f4);
        this.renderer.bindTexture(iedw._a);
        this.renderer.drawTexturedModalRect(point, point2, dimension);
    }

    private void renderPdaBackground() {
        GL11.glEnable(3042);
        Minecraft._E()._R()._a(iedw._a);
        this.renderer.drawTexturedModalRect(this.screenWidth / 2 - this.bgSize.width / 2, this.screenHeight / 2 - this.bgSize.height / 2, 0, 0, 1024, 714);
        this.renderer.drawTiledRect(new Point(this.screenWidth / 2 - 448 + 140, this.screenHeight / 2 - 252), new Point(24, 832), new Dimension(15, 504), new Dimension(15, 64), 2);
        GL11.glDisable(3042);
    }

    private void renderTimeIcon() {
        Point point = bqgh._d(Minecraft._E()._r.getWorldTime()) ? new Point(88, 832) : new Point(64, 832);
        Minecraft._E()._R()._a(iedw._a);
        GL11.glEnable(3042);
        this.renderer.drawTexturedModalRect(this.timeLabel.getLocation().add(-30, -2), point, new Dimension(24, 24));
        GL11.glDisable(3042);
    }

    public static McScrollPane createScrollPane(IAdvancedGui iAdvancedGui, Point point, Dimension dimension, Dimension dimension2) {
        McScrollPane mcScrollPane = GuiHelper.createScrollPane(iAdvancedGui, point, dimension, dimension2, false);
        mcScrollPane.setScrollButtonStyle(iedw._k);
        mcScrollPane.setScrollBarStyle(iedw._j);
        mcScrollPane.initControls();
        mcScrollPane.getVerticalScrollBar().setSliderLength(16);
        mcScrollPane.getHorizontalScrollBar().setVisible(false);
        mcScrollPane.getLeftButton().setVisible(false);
        mcScrollPane.getRightButton().setVisible(false);
        mcScrollPane.setElementsRenderer(mcScrollPane.getRenderer());
        return mcScrollPane;
    }

    public GuiRenderer rendererWithFont(IFontRenderer iFontRenderer) {
        return new GuiRendererBuilder(this.getRenderer()).setFontRenderer(iFontRenderer).create();
    }

    @Override
    public void apply(srli srli2) {
        if (this.currentTab instanceof ejiw) {
            ((ejiw)((Object)this.currentTab)).apply(srli2);
        }
    }

    @Override
    public void onGuiClosed() {
        if (this.currentTab != null) {
            this.currentTab.onScreenClose();
        }
        super.onGuiClosed();
        Minecraft._E()._M.guiScale = this.initialScale;
    }

    public static void openPda(String string, Function<GuiPda, AbstractPdaTab> function) {
        PdaMod.getClientPda().setLastPdaTab(string);
        GuiPda guiPda = new GuiPda();
        Minecraft._E()._a(guiPda);
        guiPda.openTab(function.apply(guiPda));
    }

    public static AbstractPdaTab openPda(String string) {
        PdaMod.getClientPda().setLastPdaTab(string);
        GuiPda guiPda = new GuiPda();
        Minecraft._E()._a(guiPda);
        return guiPda.currentTab;
    }

    public static void drawInterferenceOverlay(float f, float f2, float f3, float f4, float f5, float f6, boolean bl) {
        Minecraft minecraft = Minecraft._E();
        zwaw._b(() -> {
            GL11.glDisable(2929);
            GL11.glBlendFunc(770, 771);
            GL11.glDisable(3008);
            GL11.glEnable(3553);
            ejef._b();
            GL11.glDisable(3042);
            GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
            GuiPda.drawScaledQuad(0.0f, 0.0f, minecraft._n, minecraft._o, f);
            if (bl) {
                ejef._a();
            }
            GL11.glEnable(3042);
            jxtc jxtc2 = PdaMod.pdaDistortionShader;
            jxtc2._e();
            jxtc2._a("frame", 0);
            jxtc2._a("resolution", (float)minecraft._n, (float)minecraft._o);
            jxtc2._a("time", (float)(System.currentTimeMillis() % 1000000L) * 0.004f);
            jxtc2._a("amplitude", (PdaMod.getInterference() * 6.0f + 0.1f) * f6);
            GuiPda.drawScaledQuad(f2, f3, f4, f5, f);
            GL11.glEnable(2929);
            GL11.glEnable(3008);
            if (bl) {
                ejef._b();
            }
            GL20.glUseProgram(0);
            return Unit.INSTANCE;
        });
    }

    private static void drawScaledQuad(float f, float f2, float f3, float f4, float f5) {
        Tessellator tessellator = Tessellator.instance;
        tessellator.startDrawingQuads();
        tessellator.addVertexWithUV(f * f5, (f2 + f4) * f5, -90.0, 0.0, 0.0);
        tessellator.addVertexWithUV((f + f3) * f5, (f2 + f4) * f5, -90.0, 1.0, 0.0);
        tessellator.addVertexWithUV((f + f3) * f5, f2 * f5, -90.0, 1.0, 1.0);
        tessellator.addVertexWithUV(f * f5, f2 * f5, -90.0, 0.0, 1.0);
        tessellator.draw();
    }

    public static AbstractPdaTab getCurrentTab() {
        GuiScreen guiScreen = Minecraft._E()._B;
        return guiScreen instanceof GuiPda ? ((GuiPda)guiScreen).currentTab : null;
    }
}

