/*
 * Decompiled with CFR 0.152.
 */
package net.smart.moving;

public interface ISmartMovingClient {
    public float getMaximumExhaustion();

    public float getMaximumUpJumpCharge();

    public float getMaximumHeadJumpCharge();

    public void setMaximumExhaustionValue(String var1, float var2);

    public float getMaximumExhaustionValue(String var1);

    public boolean removeMaximumExhaustionValue(String var1);

    public void setNativeUserInterfaceDrawing(boolean var1);

    public boolean getNativeUserInterfaceDrawing();
}

