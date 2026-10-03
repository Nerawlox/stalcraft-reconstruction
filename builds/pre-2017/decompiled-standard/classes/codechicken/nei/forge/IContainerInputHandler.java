/*
 * Decompiled with CFR 0.152.
 */
package codechicken.nei.forge;

public interface IContainerInputHandler {
    public boolean keyTyped(zybc var1, char var2, int var3);

    public void onKeyTyped(zybc var1, char var2, int var3);

    public boolean lastKeyTyped(zybc var1, char var2, int var3);

    public boolean mouseClicked(zybc var1, int var2, int var3, int var4);

    public void onMouseClicked(zybc var1, int var2, int var3, int var4);

    public void onMouseUp(zybc var1, int var2, int var3, int var4);

    public boolean mouseScrolled(zybc var1, int var2, int var3, int var4);

    public void onMouseScrolled(zybc var1, int var2, int var3, int var4);

    public void onMouseDragged(zybc var1, int var2, int var3, int var4, long var5);
}

