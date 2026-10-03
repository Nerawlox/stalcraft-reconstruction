/*
 * Decompiled with CFR 0.152.
 */
package net.smart.moving;

import net.minecraft.client.Minecraft;
import net.smart.moving.ILocalUserNameProvider;
import net.smart.moving.SmartMovingContext;

public class LocalUserNameProvider
extends SmartMovingContext
implements ILocalUserNameProvider {
    @Override
    public String getLocalConfigUserName() {
        return (Boolean)SmartMovingContext.Options._localUserHasChangeConfigRight.value != false ? Minecraft._E()._t.getEntityName() : null;
    }

    @Override
    public String getLocalSpeedUserName() {
        return (Boolean)SmartMovingContext.Options._localUserHasChangeSpeedRight.value != false ? Minecraft._E()._t.getEntityName() : null;
    }
}

