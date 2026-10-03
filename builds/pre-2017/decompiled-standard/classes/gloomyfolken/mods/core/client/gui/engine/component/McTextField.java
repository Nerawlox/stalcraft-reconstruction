/*
 * Decompiled with CFR 0.152.
 */
package gloomyfolken.mods.core.client.gui.engine.component;

import gloomyfolken.mods.core.client.gui.engine.Dimension;
import gloomyfolken.mods.core.client.gui.engine.GuiRenderer;
import gloomyfolken.mods.core.client.gui.engine.IAdvancedGui;
import gloomyfolken.mods.core.client.gui.engine.Point;
import gloomyfolken.mods.core.client.gui.engine.Property;
import gloomyfolken.mods.core.client.gui.engine.action.GuiActionTextFieldChanged;
import gloomyfolken.mods.core.client.gui.engine.action.GuiActionTextFieldUnfocused;
import gloomyfolken.mods.core.client.gui.engine.component.GuiComponent;
import gloomyfolken.mods.core.client.gui.engine.component.IFocusable;
import gloomyfolken.mods.core.client.gui.engine.style.ComponentStyle;
import gloomyfolken.mods.core.client.gui.engine.style.ComponentTextfieldStyle;
import net.minecraft.client.xpzm;
import net.minecraft.util.ezey;
import org.lwjgl.opengl.GL11;

public class McTextField
extends GuiComponent
implements IFocusable {
    @Property
    private String text = "";
    @Property
    private int maxStringLength = 32;
    private int cursorCounter;
    @Property
    private boolean enableBackgroundDrawing = true;
    @Property
    private boolean canLoseFocus = true;
    private boolean isFocused;
    private int lineScrollOffset;
    private int cursorPosition;
    private int selectionEnd;
    private int enabledColor = 0xE0E0E0;
    private int disabledColor = 0x707070;
    public String tipText;
    public int tipTextColor = 0x808080;
    private ComponentStyle backgroundStyle;

    public McTextField(IAdvancedGui iAdvancedGui, int n, int n2, int n3, int n4) {
        this(iAdvancedGui, new Point(n, n2), new Dimension(n3, n4));
    }

    public McTextField(IAdvancedGui iAdvancedGui, Point point, Dimension dimension) {
        super(iAdvancedGui, point, dimension);
    }

    public McTextField(IAdvancedGui iAdvancedGui, Point point, Dimension dimension, String string) {
        super(iAdvancedGui, point, dimension);
        this.setText(string);
    }

    @Override
    public GuiComponent setRenderer(GuiRenderer guiRenderer) {
        super.setRenderer(guiRenderer);
        return this;
    }

    @Override
    public void tick() {
        ++this.cursorCounter;
    }

    public void setText(String string) {
        this.text = string.length() > this.maxStringLength ? string.substring(0, this.maxStringLength) : string;
        this.parent.getActionManager().processAction(new GuiActionTextFieldChanged(this));
        this.setCursorPositionEnd();
    }

    public String getText() {
        return this.text;
    }

    public String getSelectedtext() {
        int n = this.cursorPosition < this.selectionEnd ? this.cursorPosition : this.selectionEnd;
        int n2 = this.cursorPosition < this.selectionEnd ? this.selectionEnd : this.cursorPosition;
        return this.text.substring(n, n2);
    }

    public void writeText(String string) {
        int n;
        String string2 = "";
        String string3 = ezey._a(string);
        int n2 = this.cursorPosition < this.selectionEnd ? this.cursorPosition : this.selectionEnd;
        int n3 = this.cursorPosition < this.selectionEnd ? this.selectionEnd : this.cursorPosition;
        int n4 = this.maxStringLength - this.text.length() - (n2 - this.selectionEnd);
        boolean bl = false;
        if (this.text.length() > 0) {
            string2 = string2 + this.text.substring(0, n2);
        }
        if (n4 < string3.length()) {
            string2 = string2 + string3.substring(0, n4);
            n = n4;
        } else {
            string2 = string2 + string3;
            n = string3.length();
        }
        if (this.text.length() > 0 && n3 < this.text.length()) {
            string2 = string2 + this.text.substring(n3);
        }
        this.text = string2;
        this.parent.getActionManager().processAction(new GuiActionTextFieldChanged(this));
        this.moveCursorBy(n2 - this.selectionEnd + n);
    }

    public void deleteWords(int n) {
        if (this.text.length() != 0) {
            if (this.selectionEnd != this.cursorPosition) {
                this.writeText("");
            } else {
                this.deleteFromCursor(this.getNthWordFromCursor(n) - this.cursorPosition);
            }
        }
    }

    public void deleteFromCursor(int n) {
        if (this.text.length() != 0) {
            if (this.selectionEnd != this.cursorPosition) {
                this.writeText("");
            } else {
                boolean bl = n < 0;
                int n2 = bl ? this.cursorPosition + n : this.cursorPosition;
                int n3 = bl ? this.cursorPosition : this.cursorPosition + n;
                String string = "";
                if (n2 >= 0) {
                    string = this.text.substring(0, n2);
                }
                if (n3 < this.text.length()) {
                    string = string + this.text.substring(n3);
                }
                this.text = string;
                this.parent.getActionManager().processAction(new GuiActionTextFieldChanged(this));
                if (bl) {
                    this.moveCursorBy(n);
                }
            }
        }
    }

    public int getNthWordFromCursor(int n) {
        return this.getNthWordFromPos(n, this.getCursorPosition());
    }

    public int getNthWordFromPos(int n, int n2) {
        return this.func_73798_a(n, this.getCursorPosition(), true);
    }

    public int func_73798_a(int n, int n2, boolean bl) {
        int n3 = n2;
        boolean bl2 = n < 0;
        int n4 = Math.abs(n);
        for (int i = 0; i < n4; ++i) {
            if (bl2) {
                while (bl && n3 > 0 && this.text.charAt(n3 - 1) == ' ') {
                    --n3;
                }
                while (n3 > 0 && this.text.charAt(n3 - 1) != ' ') {
                    --n3;
                }
                continue;
            }
            int n5 = this.text.length();
            if ((n3 = this.text.indexOf(32, n3)) == -1) {
                n3 = n5;
                continue;
            }
            while (bl && n3 < n5 && this.text.charAt(n3) == ' ') {
                ++n3;
            }
        }
        return n3;
    }

    public void moveCursorBy(int n) {
        this.setCursorPosition(this.selectionEnd + n);
    }

    public void setCursorPosition(int n) {
        this.cursorPosition = n;
        int n2 = this.text.length();
        if (this.cursorPosition < 0) {
            this.cursorPosition = 0;
        }
        if (this.cursorPosition > n2) {
            this.cursorPosition = n2;
        }
        this.setSelectionPos(this.cursorPosition);
    }

    public void setCursorPositionZero() {
        this.setCursorPosition(0);
    }

    public void setCursorPositionEnd() {
        this.setCursorPosition(this.text.length());
    }

    @Override
    public void keyTyped(char c, int n) {
        if (this.getEnabled() && this.isFocused) {
            switch (c) {
                case '\u0001': {
                    this.setCursorPositionEnd();
                    this.setSelectionPos(0);
                    return;
                }
                case '\u0003': {
                    gqjz.func_73865_d(this.getSelectedtext());
                    return;
                }
                case '\u0016': {
                    this.writeText(gqjz.func_73870_l());
                    return;
                }
                case '\u0018': {
                    gqjz.func_73865_d(this.getSelectedtext());
                    this.writeText("");
                    return;
                }
            }
            switch (n) {
                case 14: {
                    if (gqjz.func_73861_o()) {
                        this.deleteWords(-1);
                    } else {
                        this.deleteFromCursor(-1);
                    }
                    return;
                }
                case 199: {
                    if (gqjz.func_73877_p()) {
                        this.setSelectionPos(0);
                    } else {
                        this.setCursorPositionZero();
                    }
                    return;
                }
                case 203: {
                    if (gqjz.func_73877_p()) {
                        if (gqjz.func_73861_o()) {
                            this.setSelectionPos(this.getNthWordFromPos(-1, this.getSelectionEnd()));
                        } else {
                            this.setSelectionPos(this.getSelectionEnd() - 1);
                        }
                    } else if (gqjz.func_73861_o()) {
                        this.setCursorPosition(this.getNthWordFromCursor(-1));
                    } else {
                        this.moveCursorBy(-1);
                    }
                    return;
                }
                case 205: {
                    if (gqjz.func_73877_p()) {
                        if (gqjz.func_73861_o()) {
                            this.setSelectionPos(this.getNthWordFromPos(1, this.getSelectionEnd()));
                        } else {
                            this.setSelectionPos(this.getSelectionEnd() + 1);
                        }
                    } else if (gqjz.func_73861_o()) {
                        this.setCursorPosition(this.getNthWordFromCursor(1));
                    } else {
                        this.moveCursorBy(1);
                    }
                    return;
                }
                case 207: {
                    if (gqjz.func_73877_p()) {
                        this.setSelectionPos(this.text.length());
                    } else {
                        this.setCursorPositionEnd();
                    }
                    return;
                }
                case 211: {
                    if (gqjz.func_73861_o()) {
                        this.deleteWords(1);
                    } else {
                        this.deleteFromCursor(1);
                    }
                    return;
                }
            }
            if (ezey._a(c)) {
                this.writeText(Character.toString(c));
            }
            return;
        }
    }

    @Override
    public void mouseClicked(Point point, int n) {
        if (this.canLoseFocus) {
            this.setFocused(this.getEnabled() && this.isMouseOver());
        }
        if (this.isFocused && n == 0 && this.isMouseOver()) {
            int n2 = point.x - this.getLocation().x;
            if (this.enableBackgroundDrawing) {
                n2 -= 8;
            }
            String string = this.renderer.trimToWidth(this.text.substring(this.lineScrollOffset), this.getWidth(), false);
            this.setCursorPosition(this.renderer.trimToWidth(string, n2, false).length() + this.lineScrollOffset);
        }
    }

    @Override
    public void drawComponent(Point point, float f) {
        if (this.getEnableBackgroundDrawing()) {
            if (this.getStyle() != null) {
                xpzm._E()._R()._a(this.getStyle().getResourceLocation());
                this.renderer.drawTiledRect(this.getLocation(), this.getStyle().getDefaultUv(), this.getSize(), this.getStyle().getSize(), this.getStyle().getBorderThickness());
            } else {
                this.renderer.drawRect(this.getLocation().add(-2, -2), this.getSize().add(4, 4), -6250336);
                this.renderer.drawRect(this.getLocation(), this.getSize(), -16777216);
            }
        }
        int n = this.getEnabled() ? this.enabledColor : this.disabledColor;
        int n2 = this.cursorPosition - this.lineScrollOffset;
        int n3 = this.selectionEnd - this.lineScrollOffset;
        String string = this.renderer.trimToWidth(this.getText().substring(this.lineScrollOffset), this.getWidth(), false);
        boolean bl = n2 >= 0 && n2 <= string.length();
        boolean bl2 = this.isFocused && this.cursorCounter / 6 % 2 == 0 && bl;
        int n4 = this.enableBackgroundDrawing ? this.getLocation().x + 8 : this.getLocation().x;
        int n5 = this.enableBackgroundDrawing ? this.getLocation().y + (this.getSize().height - 16) / 2 : this.getLocation().y;
        int n6 = n4;
        if (n3 > string.length()) {
            n3 = string.length();
        }
        if (string.length() > 0) {
            String string2 = bl ? string.substring(0, n2) : string;
            n6 = this.renderer.drawString(string2, n6, n5, n);
        }
        boolean bl3 = this.cursorPosition < this.text.length() || this.text.length() >= this.getMaxStringLength();
        int n7 = n6;
        if (!bl) {
            n7 = n2 > 0 ? n4 + this.getSize().width : n4;
        } else if (bl3) {
            n7 = n6 - 1;
            --n6;
        }
        if (string.length() > 0 && bl && n2 < string.length()) {
            this.renderer.drawString(string.substring(n2), n6, n5, n);
        }
        if (bl2) {
            if (bl3) {
                this.renderer.drawRect(n7 - 2, n5 - 2, 2.0, 4 + this.renderer.getFontHeight(), -3092272);
            } else {
                this.renderer.drawString("_", n7, n5, n);
            }
        }
        if (n3 != n2) {
            int n8 = n4 + this.renderer.getStringWidth(string.substring(0, n3));
            this.drawCursorVertical(n7, n5 - 2, n8 - 2, n5 + 2 + this.renderer.getFontHeight());
        }
        if (this.text.length() == 0 && !this.isFocused && this.tipText != null) {
            this.renderer.drawString(this.tipText, n4, n5, this.tipTextColor);
        }
    }

    private void drawCursorVertical(int n, int n2, int n3, int n4) {
        int n5;
        if (n < n3) {
            n5 = n;
            n = n3;
            n3 = n5;
        }
        if (n2 < n4) {
            n5 = n2;
            n2 = n4;
            n4 = n5;
        }
        htvf htvf2 = htvf.field_78398_a;
        GL11.glColor4f(0.0f, 0.0f, 255.0f, 255.0f);
        GL11.glDisable(3553);
        GL11.glEnable(3058);
        GL11.glLogicOp(5387);
        this.renderer.drawRect(n, n2, n3 - n, n4 - n2, -16776961);
        GL11.glDisable(3058);
        GL11.glEnable(3553);
    }

    public void setMaxStringLength(int n) {
        this.maxStringLength = n;
        if (this.text.length() > n) {
            this.text = this.text.substring(0, n);
            this.parent.getActionManager().processAction(new GuiActionTextFieldChanged(this));
        }
    }

    public int getMaxStringLength() {
        return this.maxStringLength;
    }

    public int getCursorPosition() {
        return this.cursorPosition;
    }

    public boolean getEnableBackgroundDrawing() {
        return this.enableBackgroundDrawing;
    }

    public void setEnableBackgroundDrawing(boolean bl) {
        this.enableBackgroundDrawing = bl;
    }

    public void setTextColor(int n) {
        this.enabledColor = n;
    }

    public void setDisabledTextColour(int n) {
        this.disabledColor = n;
    }

    @Override
    public void setFocused(boolean bl) {
        if (bl && !this.isFocused) {
            this.cursorCounter = 0;
        }
        if (this.isFocused && !bl) {
            this.parent.getActionManager().processAction(new GuiActionTextFieldUnfocused(this));
        }
        this.isFocused = bl;
    }

    @Override
    public boolean isFocused() {
        return this.isFocused;
    }

    @Override
    public void setEnabled(boolean bl) {
        super.setEnabled(bl);
    }

    public int getSelectionEnd() {
        return this.selectionEnd;
    }

    public int getWidth() {
        return this.getEnableBackgroundDrawing() ? this.getSize().width - 16 : this.getSize().width;
    }

    public void setSelectionPos(int n) {
        int n2 = this.text.length();
        if (n > n2) {
            n = n2;
        }
        if (n < 0) {
            n = 0;
        }
        this.selectionEnd = n;
        if (this.renderer != null) {
            if (this.lineScrollOffset > n2) {
                this.lineScrollOffset = n2;
            }
            int n3 = this.getWidth();
            String string = this.renderer.trimToWidth(this.text.substring(this.lineScrollOffset), n3, false);
            int n4 = string.length() + this.lineScrollOffset;
            if (n == this.lineScrollOffset) {
                this.lineScrollOffset -= this.renderer.trimToWidth(this.text, n3, true).length();
            }
            if (n > n4) {
                this.lineScrollOffset += n - n4;
            } else if (n <= this.lineScrollOffset) {
                this.lineScrollOffset -= this.lineScrollOffset - n;
            }
            if (this.lineScrollOffset < 0) {
                this.lineScrollOffset = 0;
            }
            if (this.lineScrollOffset > n2) {
                this.lineScrollOffset = n2;
            }
        }
    }

    @Override
    public ComponentTextfieldStyle getStyle() {
        return (ComponentTextfieldStyle)super.getStyle();
    }

    @Override
    public void setStyle(ComponentStyle componentStyle) {
        if (componentStyle instanceof ComponentTextfieldStyle) {
            super.setStyle(componentStyle);
        }
        this.enabledColor = this.getStyle().getEnabledTextColor().getRGB();
        this.disabledColor = this.getStyle().getDisabledTextColor().getRGB();
    }

    public void setCanLoseFocus(boolean bl) {
        this.canLoseFocus = bl;
    }

    public ComponentStyle getBackgroundStyle() {
        return this.backgroundStyle;
    }
}

