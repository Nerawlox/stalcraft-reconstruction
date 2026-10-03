/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.lwjgl.opengl.GL11
 */
package ru.stalcraft.client.clans;

import java.util.ArrayList;
import org.lwjgl.opengl.GL11;
import ru.stalcraft.client.clans.GuiClans;
import ru.stalcraft.client.clans.GuiElement;
import ru.stalcraft.client.clans.GuiElementSlider;

public class GuiElementTextBox
extends GuiElement {
    private static avi fr = atv.w().l;
    private static final int LINE_HEIGHT = 20;
    private String text = "";
    private GuiClans parent;
    private GuiElementSlider slider;
    private ArrayList lines = new ArrayList();
    private ArrayList lineBreaks = new ArrayList();
    private int xPos;
    private int yPos;
    private int width;
    private int height;
    public boolean isEditable = false;
    private boolean isFocused = false;
    private int cursorCounter = 0;
    private int cursor = 0;

    public GuiElementTextBox(GuiClans parent, GuiElementSlider slider, int x2, int y2, int xSize, int ySize) {
        this.parent = parent;
        this.xPos = x2;
        this.yPos = y2;
        this.width = xSize;
        this.height = ySize;
        this.slider = slider;
    }

    public void draw() {
        GuiElementTextBox.drawRectHD(this.xPos - 1, this.yPos - 1, this.xPos + this.width + 1, this.yPos + this.height + 1, -6250336);
        GuiElementTextBox.drawRectHD(this.xPos, this.yPos, this.xPos + this.width, this.yPos + this.height, -16777216);
        if (this.cursor > this.text.length()) {
            this.cursor = this.text.length();
        }
        GL11.glEnable((int)3089);
        GL11.glScissor((int)this.xPos, (int)(atv.w().e - this.yPos - this.height), (int)this.width, (int)(this.height - 6));
        this.splitText();
        for (int i2 = 0; i2 < this.lines.size(); ++i2) {
            String str = (String)this.lines.get(i2);
            int y2 = this.yPos - Math.round((float)(this.getTotalHeight() - this.getHeightPerPage()) * this.slider.pos) + i2 * 20 + 3;
            if (y2 + 20 <= this.yPos || y2 >= this.yPos + this.height) continue;
            fr.b(str, this.xPos / 2 + 5, y2 / 2, 0xFFFFFF);
            int cursorLine = this.getCursorLine();
            if (this.cursorCounter % 20 >= 10 || i2 != cursorLine || !this.canWrite()) continue;
            int cursorColumn = this.getCursorColumn();
            int x2 = this.xPos + 9 + fr.a(str.substring(0, cursorColumn)) * 2;
            GuiElementTextBox.drawRectHD(x2 - 1, y2 + 1, x2, y2 + GuiElementTextBox.fr.a * 2 - 1, -1);
        }
        GL11.glDisable((int)3089);
    }

    public void setText(String newText) {
        this.text = newText;
        this.cursor = 0;
    }

    public String getText() {
        return this.text;
    }

    private void splitText() {
        String[] textLines;
        int maxWidth = this.width / 2 - 6;
        this.lines.clear();
        this.lineBreaks.clear();
        String[] arr$ = textLines = this.text.split("\n");
        int len$ = textLines.length;
        for (int i$ = 0; i$ < len$; ++i$) {
            String line = arr$[i$];
            String[] words = line.split("(?<!( )) ");
            for (int s2 = 1; s2 < words.length; ++s2) {
                while (words[s2].startsWith(" ")) {
                    words[s2 - 1] = words[s2 - 1] + " ";
                    words[s2] = words[s2].substring(1);
                }
            }
            String var12 = "";
            for (int i2 = 0; i2 < words.length; ++i2) {
                String word = words[i2];
                if (fr.a(var12 + (i2 == 0 ? word : " " + word)) <= maxWidth) {
                    var12 = var12 + (i2 == 0 ? word : " " + word);
                    continue;
                }
                if (var12.length() > 0 && fr.a(word) <= maxWidth) {
                    this.lines.add(var12);
                    var12 = word;
                    continue;
                }
                if (var12.length() > 0) {
                    this.lines.add(var12);
                    var12 = "";
                }
                for (int j2 = 0; j2 < word.length(); ++j2) {
                    if (fr.a(var12 + word.charAt(j2)) > maxWidth) {
                        this.lineBreaks.add(this.lines.size());
                        this.lines.add(var12);
                        var12 = "";
                    }
                    var12 = var12 + word.charAt(j2);
                }
            }
            if (line.endsWith(" ")) {
                var12 = var12 + " ";
            }
            this.lines.add(var12);
        }
        if (this.text.endsWith("\n")) {
            this.lines.add("");
        }
    }

    void keyTyped(char par1, int par2) {
        if (par2 == 205) {
            this.moveCursorTo(this.cursor + 1);
        } else if (par2 == 203) {
            this.moveCursorTo(this.cursor - 1);
        } else if (par2 == 208) {
            int cursorLine = this.getCursorLine();
            if (cursorLine + 1 < this.lines.size()) {
                int currentCursorPos = this.getCursorColumn();
                int cursorColumn = GuiElementTextBox.getStringWidthHD(((String)this.lines.get(cursorLine)).substring(0, currentCursorPos));
                this.moveCursorToLineAndX(++cursorLine, cursorColumn);
            }
        } else if (par2 == 200) {
            int cursorLine = this.getCursorLine();
            if (cursorLine > 0) {
                boolean var6 = false;
                int cursorColumn = this.getCursorColumn();
                int currentCursorPos = GuiElementTextBox.getStringWidthHD(((String)this.lines.get(cursorLine)).substring(0, cursorColumn));
                this.moveCursorToLineAndX(--cursorLine, currentCursorPos);
            }
        } else if (par2 == 211) {
            if (this.cursor < this.text.length()) {
                this.text = this.text.substring(0, this.cursor) + this.text.substring(this.cursor + 1);
            }
            this.cursorCounter = 0;
        } else if (par2 == 14) {
            if (this.cursor > 0) {
                this.text = this.text.substring(0, this.cursor - 1) + this.text.substring(this.cursor);
                this.moveCursorTo(this.cursor - 1);
            }
        } else if (par2 == 199) {
            int cursorLine = this.getCursorLine();
            this.moveCursorTo(this.getGlobalCursorPos(cursorLine, 0));
        } else if (par2 == 207) {
            int cursorLine = this.getCursorLine();
            if (cursorLine < this.lines.size()) {
                this.moveCursorTo(this.getGlobalCursorPos(cursorLine, ((String)this.lines.get(cursorLine)).length()));
                if (this.lineBreaks.contains(cursorLine)) {
                    this.moveCursorTo(this.cursor - 1);
                }
            }
        } else if (par2 == 47 && awe.o()) {
            this.writeText(awe.l().replaceAll("\r", ""));
        } else if (par2 == 28) {
            this.writeText("\n");
        } else if (v.a(par1)) {
            this.writeText(String.valueOf(par1));
        }
    }

    private void writeText(String text) {
        if (this.canWrite()) {
            this.text = this.text.substring(0, this.cursor) + text + this.text.substring(this.cursor);
            this.moveCursorTo(this.cursor + text.length());
        }
    }

    private boolean canWrite() {
        return this.isEditable && this.isFocused;
    }

    private void moveCursorToLineAndX(int cursorLine, int x2) {
        if (cursorLine >= this.lines.size()) {
            this.moveCursorTo(this.text.length());
        } else {
            String str = (String)this.lines.get(cursorLine);
            for (int i2 = 0; i2 < str.length(); ++i2) {
                int currentWidth = GuiElementTextBox.getStringWidthHD(str.substring(0, i2));
                if (currentWidth < x2) continue;
                if (i2 == 0) {
                    this.moveCursorTo(this.getGlobalCursorPos(cursorLine, 0));
                    return;
                }
                int currentDifference = currentWidth - x2;
                int prevDifference = x2 - GuiElementTextBox.getStringWidthHD(str.substring(0, i2 - 1));
                if (currentDifference < prevDifference) {
                    this.moveCursorTo(this.getGlobalCursorPos(cursorLine, i2));
                } else {
                    this.moveCursorTo(this.getGlobalCursorPos(cursorLine, i2 - 1));
                }
                return;
            }
            this.moveCursorTo(this.getGlobalCursorPos(cursorLine, str.length()));
        }
    }

    private int getCursorLine() {
        int length = 0;
        for (int i2 = 0; i2 < this.lines.size(); ++i2) {
            length += ((String)this.lines.get(i2)).length();
            if (!this.lineBreaks.contains(i2)) {
                ++length;
            }
            if (length <= this.cursor) continue;
            return i2;
        }
        return Math.max(0, this.lines.size() - 1);
    }

    private int getCursorColumn() {
        int length = 0;
        boolean line = false;
        for (int i2 = 0; i2 < this.lines.size(); ++i2) {
            if (length + ((String)this.lines.get(i2)).length() + (this.lineBreaks.contains(i2) ? 0 : 1) > this.cursor) {
                return Math.max(0, this.cursor - length);
            }
            length += ((String)this.lines.get(i2)).length();
            if (this.lineBreaks.contains(i2)) continue;
            ++length;
        }
        return 0;
    }

    private int getGlobalCursorPos(int cursorLine, int cursorColumn) {
        int pos = 0;
        if (cursorLine >= this.lines.size()) {
            return this.text.length();
        }
        for (int i2 = 0; i2 < cursorLine; ++i2) {
            pos += ((String)this.lines.get(i2)).length();
            if (this.lineBreaks.contains(i2)) continue;
            ++pos;
        }
        if (cursorColumn > ((String)this.lines.get(cursorLine)).length()) {
            return pos + ((String)this.lines.get(cursorLine)).length();
        }
        return pos + cursorColumn;
    }

    private void moveCursorTo(int newCursor) {
        this.cursor = newCursor;
        if (this.cursor < 0) {
            this.cursor = 0;
        } else if (this.cursor > this.text.length()) {
            this.cursor = this.text.length();
        }
        int cursorLine = this.getCursorLine();
        int y2 = this.yPos - Math.round((float)(this.getTotalHeight() - this.getHeightPerPage()) * this.slider.pos) + cursorLine * 20;
        if (y2 < this.yPos) {
            this.slider.pos = (float)cursorLine * 20.0f / (float)(this.getTotalHeight() - this.getHeightPerPage());
        } else if (y2 + 20 > this.yPos + this.height) {
            this.slider.pos = (float)((cursorLine + 1) * 20 - this.getHeightPerPage()) / (float)(this.getTotalHeight() - this.getHeightPerPage());
        }
        this.cursorCounter = 0;
    }

    void updateScreen() {
        ++this.cursorCounter;
    }

    void mouseClicked(int x2, int y2, int button) {
        if (button == 0 && x2 >= this.xPos && x2 < this.xPos + this.width && y2 >= this.yPos && y2 < this.yPos + this.height) {
            this.isFocused = true;
            int line = (y2 - this.yPos + Math.round((float)(this.getTotalHeight() - this.getHeightPerPage()) * this.slider.pos)) / 20;
            this.moveCursorToLineAndX(line, x2 - this.xPos - 7);
        } else if (button == 0) {
            this.isFocused = false;
        }
    }

    public int getMinScroll() {
        return 20;
    }

    public int getTotalHeight() {
        return this.lines.size() * 20;
    }

    public int getHeightPerPage() {
        return this.height - 6;
    }
}

