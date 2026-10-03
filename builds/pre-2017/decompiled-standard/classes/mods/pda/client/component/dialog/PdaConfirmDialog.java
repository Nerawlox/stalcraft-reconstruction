/*
 * Decompiled with CFR 0.152.
 */
package mods.pda.client.component.dialog;

import gloomyfolken.mods.core.client.gui.engine.Dimension;
import gloomyfolken.mods.core.client.gui.engine.IAdvancedGui;
import gloomyfolken.mods.core.client.gui.engine.Point;
import gloomyfolken.mods.core.client.gui.engine.action.GuiActionButtonClick;
import gloomyfolken.mods.core.client.gui.engine.component.McButton;
import gloomyfolken.mods.core.client.gui.engine.style.ComponentButtonStyle;
import java.util.ArrayList;
import java.util.List;
import mods.pda.client.component.dialog.Dialog;

public class PdaConfirmDialog
extends Dialog {
    protected ComponentButtonStyle buttonStyle = iedw._l;
    protected Runnable onConfirm;
    protected Runnable onDecline;
    protected List<String> lines = new ArrayList<String>();

    public PdaConfirmDialog(IAdvancedGui iAdvancedGui, Point point, Dimension dimension) {
        super(iAdvancedGui, point, dimension);
        this.setTitle("\u041f\u043e\u0434\u0442\u0432\u0435\u0440\u0436\u0434\u0435\u043d\u0438\u0435");
    }

    @Override
    protected void setupDialog() {
        McButton mcButton = this.add(new McButton(this.parent, new Point(this.getSize().width / 2 - 205, this.getSize().height * 7 / 10), this.buttonStyle, "\u041f\u043e\u0434\u0442\u0432\u0435\u0440\u0434\u0438\u0442\u044c"));
        this.parent.getActionManager().registerActionHandler(mcButton, GuiActionButtonClick.class, guiActionButtonClick -> {
            if (this.getOnConfirm() != null) {
                this.getOnConfirm().run();
            }
            this.setStatus(false);
        });
        mcButton.setSize(new Dimension(200, 30));
        McButton mcButton2 = this.add(new McButton(this.parent, new Point(this.getSize().width / 2 + 5, this.getSize().height * 7 / 10), this.buttonStyle, "\u041e\u0442\u043c\u0435\u043d\u0438\u0442\u044c"));
        this.parent.getActionManager().registerActionHandler(mcButton2, GuiActionButtonClick.class, guiActionButtonClick -> {
            if (this.getOnDecline() != null) {
                this.getOnDecline().run();
            }
            this.setStatus(false);
        });
        mcButton2.setSize(new Dimension(200, 30));
    }

    @Override
    public void drawComponent(Point point, float f) {
        super.drawComponent(point, f);
        for (int i = 0; i < this.lines.size(); ++i) {
            this.renderer.drawCenteredString(this.lines.get(i), this.getLocation().add(this.getSize().width / 2, this.getSize().height * 2 / 5 + i * 15), iedw._e.getRGB());
        }
    }

    public Runnable getOnConfirm() {
        return this.onConfirm;
    }

    public PdaConfirmDialog setOnConfirm(Runnable runnable) {
        this.onConfirm = runnable;
        return this;
    }

    public Runnable getOnDecline() {
        return this.onDecline;
    }

    public PdaConfirmDialog setOnDecline(Runnable runnable) {
        this.onDecline = runnable;
        return this;
    }

    public PdaConfirmDialog setText(String string) {
        this.lines.clear();
        this.lines.addAll(this.renderer.getFontRenderer().wrapString(string, this.getSize().width / 3));
        return this;
    }
}

