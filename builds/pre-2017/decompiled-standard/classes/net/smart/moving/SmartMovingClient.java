/*
 * Decompiled with CFR 0.152.
 */
package net.smart.moving;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import net.smart.moving.ISmartMovingClient;
import net.smart.moving.SmartMovingContext;

public class SmartMovingClient
extends SmartMovingContext
implements ISmartMovingClient {
    private final Map maximumExhaustionValues = new HashMap();
    private boolean nativeUserInterfaceDrawing = true;

    @Override
    public float getMaximumExhaustion() {
        float f = SmartMovingContext.Config.getMaxExhaustion();
        if (this.maximumExhaustionValues.size() > 0) {
            Iterator iterator2 = this.maximumExhaustionValues.values().iterator();
            while (iterator2.hasNext()) {
                f = Math.max(((Float)iterator2.next()).floatValue(), f);
            }
        }
        return f;
    }

    @Override
    public float getMaximumUpJumpCharge() {
        return ((Float)SmartMovingContext.Config._jumpChargeMaximum.value).floatValue();
    }

    @Override
    public float getMaximumHeadJumpCharge() {
        return ((Float)SmartMovingContext.Config._headJumpChargeMaximum.value).floatValue();
    }

    @Override
    public void setMaximumExhaustionValue(String string, float f) {
        this.maximumExhaustionValues.put(string, Float.valueOf(f));
    }

    @Override
    public float getMaximumExhaustionValue(String string) {
        return ((Float)this.maximumExhaustionValues.get(string)).floatValue();
    }

    @Override
    public boolean removeMaximumExhaustionValue(String string) {
        return this.maximumExhaustionValues.remove(string) != null;
    }

    @Override
    public void setNativeUserInterfaceDrawing(boolean bl) {
        this.nativeUserInterfaceDrawing = bl;
    }

    @Override
    public boolean getNativeUserInterfaceDrawing() {
        return this.nativeUserInterfaceDrawing;
    }
}

