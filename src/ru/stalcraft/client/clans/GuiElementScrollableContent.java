/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.lwjgl.opengl.GL11
 */
package ru.stalcraft.client.clans;

import java.util.List;
import org.lwjgl.opengl.GL11;
import ru.stalcraft.client.clans.ClientClanData;
import ru.stalcraft.client.clans.GuiClans;
import ru.stalcraft.client.clans.GuiElement;
import ru.stalcraft.client.clans.GuiElementSlider;

public class GuiElementScrollableContent
extends GuiElement {
    private static final int LINE_HEIGHT = 26;
    private final GuiClans parent;
    private final GuiElementSlider slider;
    private final List lines;
    private final int x;
    private final int y;
    private final int xSize;
    private final int ySize;
    private int selectedLineId = -1;

    public GuiElementScrollableContent(GuiClans parent, GuiElementSlider slider, List lines, int x2, int y2, int xSize, int ySize) {
        this.parent = parent;
        this.slider = slider;
        this.lines = lines;
        this.x = x2;
        this.y = y2;
        this.xSize = xSize;
        this.ySize = ySize;
    }

    void draw(int mouseX, int mouseY) {
        GL11.glEnable((int)3089);
        GL11.glScissor((int)this.x, (int)(atv.w().e - this.y - this.ySize), (int)this.xSize, (int)this.ySize);
        for (int i2 = 0; i2 < this.lines.size(); ++i2) {
            int y2 = this.y - Math.round((float)(this.getTotalHeight() - this.getHeightPerPage()) * this.slider.pos) + i2 * 26;
            if (y2 + 26 <= this.y || y2 >= this.y + this.ySize) continue;
            this.drawLine(i2, y2, mouseX, mouseY);
        }
        GL11.glDisable((int)3089);
    }

    private void drawLine(int id, int y2, int mouseX, int mouseY) {
        boolean isMouseOver;
        GL11.glColor4f((float)1.0f, (float)1.0f, (float)1.0f, (float)1.0f);
        atv.w().N.a(GuiClans.buttonsTexture);
        String str = ((ClientClanData.IListable)this.lines.get(id)).getString();
        boolean bl2 = isMouseOver = mouseX >= this.x && mouseX < this.x + this.xSize && mouseY >= y2 && mouseY < y2 + 26;
        if (this.selectedLineId == id) {
            this.parent.drawTexturedModalRect(this.x, y2, 0, 360, this.xSize, 26, 512);
        } else if (isMouseOver) {
            this.parent.drawTexturedModalRect(this.x, y2, 0, 334, this.xSize, 26, 512);
        } else {
            this.parent.drawTexturedModalRect(this.x, y2, 0, 308, this.xSize, 26, 512);
        }
        String idStr = id + 1 + ".";
        this.drawString(idStr, this.parent.g / 2 - 300 + 128 - this.getWidth(idStr), y2 / 2 + 5, 0xFFFFFF);
        this.drawString(((ClientClanData.IListable)this.lines.get(id)).getString(), this.parent.g / 2 - 300 + 135, y2 / 2 + 5, ((ClientClanData.IListable)this.lines.get(id)).getColor());
    }

    void onClick(int x2, int y2, int button) {
        int id;
        if (button == 0 && x2 >= this.x && x2 < this.x + this.xSize && y2 >= this.y && y2 < this.y + this.ySize && (id = (y2 - this.y + Math.round((float)(this.getTotalHeight() - this.getHeightPerPage()) * this.slider.pos)) / 26) < this.lines.size()) {
            this.selectedLineId = id;
        }
    }

    public int getTotalHeight() {
        return this.lines.size() * 26;
    }

    public int getHeightPerPage() {
        return this.ySize;
    }

    public int getMinScroll() {
        return 26;
    }

    void keyTyped(char par1, int par2) {
        if (par2 == 200) {
            this.selectedLineId = Math.max(0, this.selectedLineId - 1);
        } else if (par2 == 208) {
            this.selectedLineId = Math.min(this.lines.size() - 1, this.selectedLineId + 1);
        }
        int y2 = this.y - Math.round((float)(this.getTotalHeight() - this.getHeightPerPage()) * this.slider.pos) + this.selectedLineId * 26;
        if (y2 < this.y) {
            this.slider.pos = (float)this.selectedLineId * 26.0f / (float)(this.getTotalHeight() - this.getHeightPerPage());
        } else if (y2 + 26 > this.y + this.ySize) {
            this.slider.pos = (float)((this.selectedLineId + 1) * 26 - this.getHeightPerPage()) / (float)(this.getTotalHeight() - this.getHeightPerPage());
        }
    }

    public int getSelectedLine() {
        return this.selectedLineId;
    }

    private int getWidth(String str) {
        return atv.w().l.a(str);
    }

    private void drawString(String str, int x2, int y2, int color) {
        atv.w().l.b(str, x2, y2, color);
    }

    void updateScreen() {
        if (this.selectedLineId < -1 || this.selectedLineId >= this.lines.size()) {
            this.selectedLineId = 0;
        }
    }
}

