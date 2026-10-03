/*
 * Decompiled with CFR 0.152.
 */
package codechicken.nei.config;

import codechicken.core.gui.GuiDraw;
import codechicken.lib.vec.Rectangle4i;
import codechicken.nei.TextField;
import codechicken.nei.config.GuiOptionList;
import codechicken.nei.config.Option;
import java.util.List;

public class OptionTextField
extends Option {
    private boolean focused = false;
    private TextField textField = new TextField(""){

        @Override
        public void onTextChange(String string) {
            if (!this.text().equals(OptionTextField.this.renderTag().getValue())) {
                OptionTextField.this.getTag().setValue(this.text());
            }
        }

        @Override
        public boolean focused() {
            return OptionTextField.this.focused;
        }

        @Override
        public void setFocus(boolean bl) {
            if (bl && OptionTextField.this.renderDefault()) {
                return;
            }
            OptionTextField.this.focused = bl;
        }
    };

    public OptionTextField(String string) {
        super(string);
        this.textField.height = 20;
        this.textField.y = 2;
    }

    @Override
    public void onAdded(GuiOptionList.OptionScrollSlot optionScrollSlot) {
        super.onAdded(optionScrollSlot);
    }

    @Override
    public void update() {
        this.textField.setText(this.renderText());
    }

    public String getPrefix() {
        return this.translateN(this.name, new Object[0]);
    }

    @Override
    public void draw(int n, int n2, float f) {
        GuiDraw.drawString(this.getPrefix(), 10, 8, -1);
        this.textField.setText(this.renderText());
        this.textField.width = this.slot.contentWidth() - GuiDraw.getStringWidth(this.getPrefix()) - 16;
        this.textField.x = this.slot.contentWidth() - this.textField.width;
        this.textField.draw(n, n2);
    }

    public String renderText() {
        return this.renderTag().getValue();
    }

    @Override
    public void keyTyped(char c, int n) {
        this.textField.handleKeyPress(n, c);
    }

    @Override
    public void mouseClicked(int n, int n2, int n3) {
        if (this.textField.contains(n, n2)) {
            this.textField.handleClick(n, n2, n3);
        }
    }

    @Override
    public void onMouseClicked(int n, int n2, int n3) {
        this.textField.onGuiClick(n, n2);
    }

    @Override
    public List<String> handleTooltip(int n, int n2, List<String> list2) {
        String string;
        if (new Rectangle4i(10, 2, this.textField.x - 10, 20).contains(n, n2) && !(string = this.translateN(this.name + ".tip", new Object[0])).equals(this.name + ".tip")) {
            list2.add(string);
        }
        return list2;
    }
}

