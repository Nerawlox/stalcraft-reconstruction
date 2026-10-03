/*
 * Decompiled with CFR 0.152.
 */
package codechicken.nei.forge;

public interface IContainerObjectHandler {
    public void guiTick(zybc var1);

    public void refresh(zybc var1);

    public void load(zybc var1);

    public cvzo getStackUnderMouse(zybc var1, int var2, int var3);

    public boolean objectUnderMouse(zybc var1, int var2, int var3);

    public boolean shouldShowTooltip(zybc var1);
}

