/*
 * Decompiled with CFR 0.152.
 */
package codechicken.nei.forge;

public interface IContainerDrawHandler {
    public void onPreDraw(zybc var1);

    public void renderObjects(zybc var1, int var2, int var3);

    public void postRenderObjects(zybc var1, int var2, int var3);

    public void renderSlotUnderlay(zybc var1, yeso var2);

    public void renderSlotOverlay(zybc var1, yeso var2);
}

