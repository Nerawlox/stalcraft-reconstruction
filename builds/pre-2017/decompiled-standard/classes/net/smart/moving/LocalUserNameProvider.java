/*
 * Decompiled with CFR 0.152.
 */
package net.smart.moving;

import net.minecraft.client.xpzm;
import net.smart.moving.ILocalUserNameProvider;
import net.smart.moving.SmartMovingContext;

public class LocalUserNameProvider
extends SmartMovingContext
implements ILocalUserNameProvider {
    @Override
    public String getLocalConfigUserName() {
        return (Boolean)SmartMovingContext.Options._localUserHasChangeConfigRight.value != false ? xpzm._E()._t.func_70023_ak() : null;
    }

    @Override
    public String getLocalSpeedUserName() {
        return (Boolean)SmartMovingContext.Options._localUserHasChangeSpeedRight.value != false ? xpzm._E()._t.func_70023_ak() : null;
    }
}

