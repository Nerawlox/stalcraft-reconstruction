/*
 * Decompiled with CFR 0.152.
 */
package gloomyfolken.mods.core.client.gui.engine.component;

import gloomyfolken.mods.core.client.gui.engine.Dimension;
import gloomyfolken.mods.core.client.gui.engine.IAdvancedGui;
import gloomyfolken.mods.core.client.gui.engine.Point;
import gloomyfolken.mods.core.client.gui.engine.Property;
import gloomyfolken.mods.core.client.gui.engine.ScissorHelper;
import gloomyfolken.mods.core.client.gui.engine.action.GuiActionTextAreaChanged;
import gloomyfolken.mods.core.client.gui.engine.component.GuiComponent;
import gloomyfolken.mods.core.client.gui.engine.component.IFocusable;
import gloomyfolken.mods.core.client.gui.engine.component.IScrollable;
import gloomyfolken.mods.core.client.gui.engine.component.McScrollBar;
import gloomyfolken.mods.core.client.gui.engine.style.ComponentStyle;
import gloomyfolken.mods.core.client.gui.engine.style.ComponentTextfieldStyle;
import java.util.ArrayList;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.util.ChatAllowedCharacters;

public class McTextArea
extends GuiComponent
implements IFocusable,
IScrollable {
    private static final int LINE_HEIGHT = 20;
    @Property
    private String text = "";
    private McScrollBar slider;
    private ArrayList<String> lines = new ArrayList();
    private ArrayList<Integer> lineBreaks = new ArrayList();
    private boolean isFocused = false;
    @Property
    public boolean isEditable = false;
    @Property
    public boolean drawBackground = true;
    @Property
    public boolean isCentered;
    private int cursorCounter = 0;
    private int cursor = 0;
    @Property
    public int maxLength = -1;
    @Property
    public int color = 0xFFFFFF;
    private float sliderPos;

    public McTextArea(IAdvancedGui iAdvancedGui, int n, int n2, int n3, int n4) {
        this(iAdvancedGui, new Point(n, n2), new Dimension(n3, n4));
    }

    public McTextArea(IAdvancedGui iAdvancedGui, Point point, Dimension dimension) {
        super(iAdvancedGui, point, dimension);
    }

    public void setSlider(McScrollBar mcScrollBar) {
        this.slider = mcScrollBar;
    }

    @Override
    public void drawComponent(Point point, float f) {
        if (this.drawBackground) {
            if (this.getStyle() != null) {
                Minecraft._E()._R()._a(this.getStyle().getResourceLocation());
                this.renderer.drawTiledRect(this.getLocation(), this.getStyle().getDefaultUv(), this.getSize(), this.getStyle().getSize(), this.getStyle().getBorderThickness());
            } else {
                this.renderer.drawRect(this.getLocation().add(-1, -1), this.getSize().add(2, 2), -6250336);
                this.renderer.drawRect(this.getLocation(), this.getSize(), -16777216);
            }
        }
        if (this.cursor > this.text.length()) {
            this.cursor = this.text.length();
        }
        this.renderer.scaledScissor(this.getAbsoluteLocation().add(0, 2), this.getSize().add(0, -2));
        this.splitText();
        for (int i = 0; i < this.lines.size(); ++i) {
            String string = this.lines.get(i);
            int n = this.getLocation().y - Math.round((float)(this.getTotalHeight() - this.getHeightPerPage()) * this.getSliderPos()) + i * 20 + 3;
            if (n + 20 <= this.getLocation().y || n >= this.getLocation().y + this.getSize().height) continue;
            int n2 = this.getLocation().x + 10;
            if (this.isCentered && !this.isEditable) {
                n2 += this.getSize().width / 2 - 10 - this.renderer.getStringWidth(string) / 2;
            }
            this.renderer.drawString(string, n2, n, this.color);
            int n3 = this.getCursorLine();
            if (this.cursorCounter % 20 >= 10 || i != n3 || !this.canWrite()) continue;
            int n4 = this.getCursorColumn();
            int n5 = this.getLocation().x + 9 + this.renderer.getStringWidth(string.substring(0, n4));
            this.renderer.drawRect(n5 - 1, n + 1, 1.0, this.renderer.getFontHeight() - 2, -1);
        }
        ScissorHelper.popScissor();
    }

    public void setText(String string) {
        this.text = this.maxLength >= 0 ? string.substring(0, Math.min(string.length(), this.maxLength)) : string;
        this.parent.getActionManager().processAction(new GuiActionTextAreaChanged(this));
        this.cursor = 0;
    }

    public String getText() {
        return this.text;
    }

    @Override
    public void keyTyped(char c, int n) {
        switch (n) {
            case 205: {
                this.moveCursorTo(this.cursor + 1);
                break;
            }
            case 203: {
                this.moveCursorTo(this.cursor - 1);
                break;
            }
            case 208: {
                int n2 = this.getCursorLine();
                if (n2 + 1 >= this.lines.size()) break;
                int n3 = this.getCursorColumn();
                int n4 = this.renderer.getStringWidth(this.lines.get(n2).substring(0, n3));
                this.moveCursorToLineAndX(++n2, n4);
                break;
            }
            case 200: {
                int n5 = this.getCursorLine();
                if (n5 <= 0) break;
                int n6 = this.getCursorColumn();
                int n7 = this.renderer.getStringWidth(this.lines.get(n5).substring(0, n6));
                this.moveCursorToLineAndX(--n5, n7);
                break;
            }
            case 211: {
                if (this.canWrite() && this.cursor < this.text.length()) {
                    this.text = this.text.substring(0, this.cursor) + this.text.substring(this.cursor + 1);
                    this.parent.getActionManager().processAction(new GuiActionTextAreaChanged(this));
                }
                this.cursorCounter = 0;
                break;
            }
            case 14: {
                if (!this.canWrite() || this.cursor <= 0) break;
                this.text = this.text.substring(0, this.cursor - 1) + this.text.substring(this.cursor);
                this.moveCursorTo(this.cursor - 1);
                this.parent.getActionManager().processAction(new GuiActionTextAreaChanged(this));
                break;
            }
            case 199: {
                int n8 = this.getCursorLine();
                this.moveCursorTo(this.getGlobalCursorPos(n8, 0));
                break;
            }
            case 207: {
                int n9 = this.getCursorLine();
                if (n9 >= this.lines.size()) break;
                this.moveCursorTo(this.getGlobalCursorPos(n9, this.lines.get(n9).length()));
                if (!this.lineBreaks.contains(n9)) break;
                this.moveCursorTo(this.cursor - 1);
                break;
            }
            case 28: {
                this.writeText("\n");
                break;
            }
            case 47: {
                if (GuiScreen.isCtrlKeyDown()) {
                    this.writeText(GuiScreen.getClipboardString().replaceAll("\r", ""));
                    break;
                }
            }
            default: {
                if (!ChatAllowedCharacters._a(c)) break;
                this.writeText(String.valueOf(c));
            }
        }
    }

    private void splitText() {
        String[] stringArray;
        int n = this.getSize().width - 12;
        this.lines.clear();
        this.lineBreaks.clear();
        for (String string : stringArray = this.text.split("[\r\n]")) {
            String[] stringArray2 = string.split("(?<!( )) ");
            for (int i = 1; i < stringArray2.length; ++i) {
                while (stringArray2[i].startsWith(" ")) {
                    int n2 = i - 1;
                    stringArray2[n2] = stringArray2[n2] + " ";
                    stringArray2[i] = stringArray2[i].substring(1);
                }
            }
            String string2 = "";
            for (int i = 0; i < stringArray2.length; ++i) {
                String string3 = stringArray2[i];
                if (this.renderer.getStringWidth(string2 + (i == 0 ? string3 : " " + string3)) <= n) {
                    string2 = string2 + (i == 0 ? string3 : " " + string3);
                    continue;
                }
                if (string2.length() > 0 && this.renderer.getStringWidth(string3) <= n) {
                    this.lines.add(string2);
                    string2 = string3;
                    continue;
                }
                if (string2.length() > 0) {
                    this.lines.add(string2);
                    string2 = "";
                }
                for (int j = 0; j < string3.length(); ++j) {
                    if (this.renderer.getStringWidth(string2 + string3.charAt(j)) > n) {
                        this.lineBreaks.add(this.lines.size());
                        this.lines.add(string2);
                        string2 = "";
                    }
                    string2 = string2 + string3.charAt(j);
                }
            }
            if (string.endsWith(" ")) {
                string2 = string2 + " ";
            }
            this.lines.add(string2);
        }
        if (this.text.endsWith("\n")) {
            this.lines.add("");
        }
    }

    private void writeText(String string) {
        if (this.canWrite()) {
            this.text = this.text.substring(0, this.cursor) + string + this.text.substring(this.cursor);
            this.moveCursorTo(this.cursor + string.length());
            if (this.maxLength >= 0) {
                this.text = this.text.substring(0, Math.min(this.text.length(), this.maxLength));
            }
            this.parent.getActionManager().processAction(new GuiActionTextAreaChanged(this));
        }
    }

    private boolean canWrite() {
        return this.isEditable && this.isFocused;
    }

    private void moveCursorToLineAndX(int n, int n2) {
        if (n >= this.lines.size()) {
            this.moveCursorTo(this.text.length());
            return;
        }
        if (n < 0) {
            this.moveCursorTo(0);
            return;
        }
        String string = this.lines.get(n);
        for (int i = 0; i < string.length(); ++i) {
            int n3 = this.renderer.getStringWidth(string.substring(0, i));
            if (n3 < n2) continue;
            if (i == 0) {
                this.moveCursorTo(this.getGlobalCursorPos(n, 0));
                return;
            }
            int n4 = n3 - n2;
            int n5 = n2 - this.renderer.getStringWidth(string.substring(0, i - 1));
            if (n4 < n5) {
                this.moveCursorTo(this.getGlobalCursorPos(n, i));
            } else {
                this.moveCursorTo(this.getGlobalCursorPos(n, i - 1));
            }
            return;
        }
        this.moveCursorTo(this.getGlobalCursorPos(n, string.length()));
    }

    private int getCursorLine() {
        int n = 0;
        for (int i = 0; i < this.lines.size(); ++i) {
            n += this.lines.get(i).length();
            if (!this.lineBreaks.contains(i)) {
                ++n;
            }
            if (n <= this.cursor) continue;
            return i;
        }
        return Math.max(0, this.lines.size() - 1);
    }

    private int getCursorColumn() {
        int n = 0;
        for (int i = 0; i < this.lines.size(); ++i) {
            if (n + this.lines.get(i).length() + (this.lineBreaks.contains(i) ? 0 : 1) > this.cursor) {
                return Math.max(0, this.cursor - n);
            }
            n += this.lines.get(i).length();
            if (this.lineBreaks.contains(i)) continue;
            ++n;
        }
        return 0;
    }

    private int getGlobalCursorPos(int n, int n2) {
        int n3 = 0;
        if (n >= this.lines.size()) {
            return this.text.length();
        }
        for (int i = 0; i < n; ++i) {
            n3 += this.lines.get(i).length();
            if (this.lineBreaks.contains(i)) continue;
            ++n3;
        }
        if (n2 > this.lines.get(n).length()) {
            return n3 + this.lines.get(n).length();
        }
        return n3 + n2;
    }

    private void moveCursorTo(int n) {
        this.cursor = n;
        if (this.cursor < 0) {
            this.cursor = 0;
        } else if (this.cursor > this.text.length()) {
            this.cursor = this.text.length();
        }
        int n2 = this.getCursorLine();
        this.cursorCounter = 0;
        int n3 = this.getLocation().y - Math.round((float)(this.getTotalHeight() - this.getHeightPerPage()) * this.getSliderPos()) + n2 * 20;
        if (n3 < this.getLocation().y) {
            this.setSliderPos((float)n2 * 20.0f / (float)(this.getTotalHeight() - this.getHeightPerPage()));
        } else if (n3 + 20 > this.getLocation().y + this.getSize().height) {
            this.setSliderPos((float)((n2 + 1) * 20 - this.getHeightPerPage()) / (float)(this.getTotalHeight() - this.getHeightPerPage()));
        }
    }

    @Override
    public void tick() {
        ++this.cursorCounter;
    }

    @Override
    public void mouseClicked(Point point, int n) {
        if (n == 0 && this.isMouseOver()) {
            this.isFocused = true;
            int n2 = (point.y - this.getLocation().y + Math.round((float)(this.getTotalHeight() - this.getHeightPerPage()) * this.getSliderPos())) / 20;
            this.moveCursorToLineAndX(n2, point.x - this.getLocation().x - 7);
        } else if (n == 0) {
            this.isFocused = false;
        }
    }

    @Override
    public int getMinScroll() {
        return 20;
    }

    @Override
    public int getTotalWidth() {
        return this.getSize().width;
    }

    @Override
    public int getWidthPerPage() {
        return this.getSize().width;
    }

    @Override
    public int getTotalHeight() {
        return Math.max(this.lines.size() * 20, this.getHeightPerPage());
    }

    @Override
    public int getHeightPerPage() {
        return this.getSize().height - 6;
    }

    private void setSliderPos(float f) {
        if (this.slider != null) {
            this.slider.pos = f;
        }
        this.sliderPos = f;
    }

    private float getSliderPos() {
        if (this.slider != null) {
            this.sliderPos = this.slider.pos;
        }
        return this.sliderPos;
    }

    @Override
    public boolean isFocused() {
        return this.isFocused;
    }

    @Override
    public void setFocused(boolean bl) {
        this.isFocused = bl;
    }

    public McScrollBar getSlider() {
        return this.slider;
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
        this.color = this.getStyle().getEnabledTextColor().getRGB();
    }
}

