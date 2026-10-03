/*
 * Decompiled with CFR 0.152.
 */
package mods.pda.client.component.dialog;

import gloomyfolken.mods.core.client.gui.engine.Dimension;
import gloomyfolken.mods.core.client.gui.engine.IAdvancedGui;
import gloomyfolken.mods.core.client.gui.engine.Point;
import gloomyfolken.mods.core.client.gui.engine.component.McButton;
import java.util.List;
import mods.pda.client.component.dialog.Dialog;

public class NotificationDialog
extends Dialog {
    private zfhb.kjui type;
    private String text;
    private List<String> lines;

    public NotificationDialog(IAdvancedGui iAdvancedGui, Point point, Dimension dimension, zfhb.kjui kjui2, String string) {
        super(iAdvancedGui, point, dimension);
        this.type = kjui2;
        this.text = string;
        this.title = kjui2 == zfhb.kjui._a ? "\u041e\u0448\u0438\u0431\u043a\u0430" : "\u0423\u0432\u0435\u0434\u043e\u043c\u043b\u0435\u043d\u0438\u0435";
        this.lines = this.renderer.getFontRenderer().wrapString(string, dimension.width / 3);
        this.setSize(new Dimension(this.getSize().width, this.lines.size() * this.renderer.getFontHeight() + 130));
    }

    @Override
    protected void setupDialog() {
        McButton mcButton = this.add(new McButton(this.parent, new Point(this.getSize().width / 2 - this.getSize().width / 4, this.getSize().height - 40), iedw._l, "\u041f\u043e\u0434\u0442\u0432\u0435\u0440\u0434\u0438\u0442\u044c"));
        mcButton.setSize(new Dimension(this.getSize().width / 2, 30));
        mcButton.onClick(guiActionButtonClick -> {
            this.setStatus(false);
            this.parent.getElementsList().removeElement(this);
        });
    }

    @Override
    public void drawComponent(Point point, float f) {
        super.drawComponent(point, f);
        int n = this.type == zfhb.kjui._a ? 0xFF0000 : iedw._e.getRGB();
        Point point2 = this.getLocation().add(this.getSize().width / 2, 70);
        for (int i = 0; i < this.lines.size(); ++i) {
            this.renderer.drawCenteredString(this.lines.get(i), point2.add(0, i * (this.renderer.getFontHeight() + 3)), n);
        }
    }
}

