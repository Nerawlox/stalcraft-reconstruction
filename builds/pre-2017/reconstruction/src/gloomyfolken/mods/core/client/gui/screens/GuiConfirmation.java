/*
 * Decompiled with CFR 0.152.
 */
package gloomyfolken.mods.core.client.gui.screens;

import gloomyfolken.mods.core.client.gui.engine.Dimension;
import gloomyfolken.mods.core.client.gui.engine.GuiHelper;
import gloomyfolken.mods.core.client.gui.engine.GuiRendererBuilder;
import gloomyfolken.mods.core.client.gui.engine.GuiScreenAdvanced;
import gloomyfolken.mods.core.client.gui.engine.IAdvancedGui;
import gloomyfolken.mods.core.client.gui.engine.Point;
import gloomyfolken.mods.core.client.gui.engine.component.McLabel;
import gloomyfolken.mods.core.client.gui.font.ExternalFont;
import java.util.List;
import mods.pda.client.component.PdaBackground;
import net.minecraft.client.gui.GuiScreen;

public class GuiConfirmation
extends GuiScreenAdvanced {
    private Runnable onConfirm;
    private Runnable onDecline;
    private String description;

    public GuiConfirmation(GuiScreen guiScreen, String string) {
        super(new GuiRendererBuilder().setTextureSize(1024, 1024).setFontRenderer(ExternalFont.tahoma12).create());
        this.parentScreen = guiScreen;
        this.description = string;
    }

    @Override
    public void initGui() {
        super.initGui();
        GuiHelper.addBackground(this, 0, 0, 0, 0, true);
        Point point = new Point(this.screenWidth / 2, this.screenHeight / 2);
        int n = this.renderer.getStringWidth(this.description);
        int n2 = (int)(300.0f + (float)n * 0.1f);
        List<String> list2 = this.renderer.wrapString(this.description, n2 - 30);
        int n3 = list2.size() * 20 + 120;
        this.addElement(new PdaBackground(this, point.add(-n2 / 2, -n3 / 2), new Dimension(n2, n3), true, true).setRenderer(new GuiRendererBuilder(this.renderer).setTextureSize(1024, 1024).create()));
        this.addElement(new McLabel((IAdvancedGui)this, "\u041f\u043e\u0434\u0442\u0432\u0435\u0440\u0436\u0434\u0435\u043d\u0438\u0435", point.add(-n2 / 2 + 20, -n3 / 2 + 8), 0x939393).setFontRenderer(ExternalFont.tahoma14));
        for (int i = 0; i < list2.size(); ++i) {
            String string = list2.get(i);
            this.addElement(new McLabel((IAdvancedGui)this, string, point.add(-this.renderer.getStringWidth(string) / 2 - 7, -n3 / 2 + 60 + 20 * i), 0x939393));
        }
        this.addElement(GuiHelper.addButton(this, point.add(-135, n3 / 4), new Dimension(130, 27), iedw._l, "\u041f\u043e\u0434\u0442\u0432\u0435\u0440\u0434\u0438\u0442\u044c").onClick(guiActionButtonClick -> this.runConfirmation()));
        this.addElement(GuiHelper.addButton(this, point.add(5, n3 / 4), new Dimension(130, 27), iedw._l, "\u041e\u0442\u043c\u0435\u043d\u0438\u0442\u044c").onClick(guiActionButtonClick -> this.runDeclination()));
    }

    @Override
    public void closeScreen() {
        this.runAndClearCallbacks(this.onDecline);
        super.closeScreen();
    }

    private void runConfirmation() {
        this.runAndClearCallbacks(this.onConfirm);
        this.closeScreen();
    }

    private void runAndClearCallbacks(Runnable runnable) {
        if (runnable != null) {
            runnable.run();
        }
        this.onDecline = null;
        this.onConfirm = null;
    }

    private void runDeclination() {
        this.closeScreen();
    }

    public Runnable getOnConfirm() {
        return this.onConfirm;
    }

    public GuiConfirmation setOnConfirm(Runnable runnable) {
        this.onConfirm = runnable;
        return this;
    }

    public Runnable getOnDecline() {
        return this.onDecline;
    }

    public GuiConfirmation setOnDecline(Runnable runnable) {
        this.onDecline = runnable;
        return this;
    }
}

