/*
 * Decompiled with CFR 0.152.
 */
package mods.pda.client.component.dialog;

import gloomyfolken.mods.core.client.gui.engine.Dimension;
import gloomyfolken.mods.core.client.gui.engine.IAdvancedGui;
import gloomyfolken.mods.core.client.gui.engine.Point;
import gloomyfolken.mods.core.client.gui.engine.component.McButton;
import gloomyfolken.mods.core.client.gui.engine.component.McTextField;
import java.util.function.Consumer;
import mods.pda.client.component.dialog.Dialog;

public class PlayerSearchDialog
extends Dialog {
    private McTextField input;
    private Consumer<String> nameConsumer;

    public PlayerSearchDialog(IAdvancedGui iAdvancedGui, Point point, Dimension dimension) {
        super(iAdvancedGui, point, dimension);
        this.title = "\u041f\u043e\u0438\u0441\u043a \u0438\u0433\u0440\u043e\u043a\u043e\u0432";
    }

    @Override
    protected void setupDialog() {
        this.input = this.add(new McTextField(this.parent, new Point(this.getSize().width / 2 - 155, this.getSize().height / 2 - 15), new Dimension(310, 30)));
        this.input.setStyle(iedw._i);
        this.input.setFocused(true);
        this.input.tipText = "\u041d\u0438\u043a...";
        McButton mcButton = this.add(new McButton(this.parent, new Point(this.getSize().width / 2 - 155, this.getSize().height / 2 + 30), iedw._l, "\u041f\u043e\u0434\u0442\u0432\u0435\u0440\u0434\u0438\u0442\u044c"));
        mcButton.setSize(new Dimension(150, 30));
        mcButton.onClick(guiActionButtonClick -> this.find());
        McButton mcButton2 = this.add(new McButton(this.parent, new Point(this.getSize().width / 2 + 5, this.getSize().height / 2 + 30), iedw._l, "\u041e\u0442\u043c\u0435\u043d\u0430"));
        mcButton2.setSize(new Dimension(150, 30));
        mcButton2.onClick(guiActionButtonClick -> this.close());
    }

    @Override
    public void keyTyped(char c, int n) {
        super.keyTyped(c, n);
        if (n == 28 && this.input.isFocused()) {
            this.find();
        }
    }

    public void find() {
        String string = this.input.getText();
        if (string.trim().isEmpty()) {
            return;
        }
        if (this.getNameConsumer() != null) {
            this.getNameConsumer().accept(string);
        }
        this.close();
    }

    private void close() {
        this.setStatus(false);
        this.parent.getElementsList().removeElement(this);
    }

    public Consumer<String> getNameConsumer() {
        return this.nameConsumer;
    }

    public PlayerSearchDialog setNameConsumer(Consumer<String> consumer) {
        this.nameConsumer = consumer;
        return this;
    }
}

