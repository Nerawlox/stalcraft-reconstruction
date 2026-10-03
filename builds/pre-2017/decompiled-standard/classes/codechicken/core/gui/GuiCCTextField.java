/*
 * Decompiled with CFR 0.152.
 */
package codechicken.core.gui;

import codechicken.core.gui.GuiWidget;
import net.minecraft.util.ezey;

public class GuiCCTextField
extends GuiWidget {
    private String text;
    private boolean isFocused = false;
    private boolean isEnabled = true;
    public int maxStringLength;
    public int cursorCounter;
    public String actionCommand;
    private String allowedcharacters;

    public GuiCCTextField(int n, int n2, int n3, int n4, String string) {
        super(n, n2, n3, n4);
        this.text = string;
        this.allowedcharacters = ezey._a;
    }

    public GuiCCTextField setActionCommand(String string) {
        this.actionCommand = string;
        return this;
    }

    public void setText(String string) {
        if (string.equals(this.text)) {
            return;
        }
        String string2 = this.text;
        this.text = string;
        this.onTextChanged(string2);
    }

    public void onTextChanged(String string) {
    }

    public final String getText() {
        return this.text;
    }

    public final boolean isEnabled() {
        return this.isEnabled;
    }

    public void setEnabled(boolean bl) {
        this.isEnabled = bl;
        if (!this.isEnabled && this.isFocused) {
            this.setFocused(false);
        }
    }

    public final boolean isFocused() {
        return this.isFocused;
    }

    @Override
    public void update() {
        ++this.cursorCounter;
    }

    @Override
    public void keyTyped(char c, int n) {
        if (!this.isEnabled || !this.isFocused) {
            return;
        }
        if (c == '\u0016') {
            String string = gqjz.func_73870_l();
            if (string == null || string.equals("")) {
                return;
            }
            for (int i = 0; i < string.length(); ++i) {
                if (this.text.length() == this.maxStringLength) {
                    return;
                }
                char c2 = string.charAt(i);
                if (!this.canAddChar(c2)) continue;
                this.setText(this.text + c2);
            }
        }
        if (n == 28) {
            this.setFocused(false);
            this.sendAction(this.actionCommand, this.getText());
        }
        if (n == 14 && this.text.length() > 0) {
            this.setText(this.text.substring(0, this.text.length() - 1));
        }
        if ((this.text.length() < this.maxStringLength || this.maxStringLength == 0) && this.canAddChar(c)) {
            this.setText(this.text + c);
        }
    }

    public boolean canAddChar(char c) {
        return this.allowedcharacters.indexOf(c) >= 0;
    }

    @Override
    public void mouseClicked(int n, int n2, int n3) {
        if (this.isEnabled && this.pointInside(n, n2)) {
            this.setFocused(true);
            if (n3 == 1) {
                this.setText("");
            }
        } else {
            this.setFocused(false);
        }
    }

    public void setFocused(boolean bl) {
        if (bl == this.isFocused) {
            return;
        }
        this.isFocused = bl;
        this.onFocusChanged();
    }

    public void onFocusChanged() {
        if (this.isFocused) {
            this.cursorCounter = 0;
        }
    }

    @Override
    public void draw(int n, int n2, float f) {
        this.drawBackground();
        this.drawText();
    }

    public void drawBackground() {
        GuiCCTextField.func_73734_a(this.x - 1, this.y - 1, this.x + this.width + 1, this.y + this.height + 1, -6250336);
        GuiCCTextField.func_73734_a(this.x, this.y, this.x + this.width, this.y + this.height, -16777216);
    }

    public String getDrawText() {
        String string = this.getText();
        if (this.isEnabled && this.isFocused && this.cursorCounter / 6 % 2 == 0) {
            string = string + "_";
        }
        return string;
    }

    public void drawText() {
        this.func_73731_b(this.fontRenderer, this.getDrawText(), this.x + 4, this.y + this.height / 2 - 4, this.getTextColour());
    }

    public int getTextColour() {
        return this.isEnabled ? 0xE0E0E0 : 0x707070;
    }

    public GuiCCTextField setMaxStringLength(int n) {
        this.maxStringLength = n;
        return this;
    }

    public GuiCCTextField setAllowedCharacters(String string) {
        if (string == null) {
            string = ezey._a;
        } else {
            this.allowedcharacters = string;
        }
        return this;
    }
}

