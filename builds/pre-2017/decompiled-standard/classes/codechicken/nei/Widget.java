/*
 * Decompiled with CFR 0.152.
 */
package codechicken.nei;

import java.util.List;

public abstract class Widget {
    public int x;
    public int y;
    public int z;
    public int width;
    public int height;

    public abstract void draw(int var1, int var2);

    public void postDraw(int n, int n2) {
    }

    public boolean handleClick(int n, int n2, int n3) {
        return true;
    }

    public void onGuiClick(int n, int n2) {
    }

    public void mouseUp(int n, int n2, int n3) {
    }

    public boolean handleKeyPress(int n, char c) {
        return false;
    }

    public void lastKeyTyped(int n, char c) {
    }

    public boolean handleClickExt(int n, int n2, int n3) {
        return false;
    }

    public boolean onMouseWheel(int n, int n2, int n3) {
        return false;
    }

    public void update() {
    }

    public boolean contains(int n, int n2) {
        return n >= this.x && n < this.x + this.width && n2 >= this.y && n2 < this.y + this.height;
    }

    public void resize() {
    }

    public cvzo getStackMouseOver(int n, int n2) {
        return null;
    }

    public void mouseDragged(int n, int n2, int n3, long l) {
    }

    public List<String> handleTooltip(int n, int n2, List<String> list2) {
        return list2;
    }

    public void loseFocus() {
    }

    public void gainFocus() {
    }
}

