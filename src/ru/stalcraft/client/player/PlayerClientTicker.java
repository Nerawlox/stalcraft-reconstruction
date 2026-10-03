/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cpw.mods.fml.common.ITickHandler
 *  cpw.mods.fml.common.TickType
 */
package ru.stalcraft.client.player;

import cpw.mods.fml.common.ITickHandler;
import cpw.mods.fml.common.TickType;
import java.util.EnumSet;
import ru.stalcraft.asm.MethodsHelper;

public class PlayerClientTicker
implements ITickHandler {
    public void tickStart(EnumSet type, Object ... tickData) {
        MethodsHelper.isTickingThePlayer = true;
    }

    public void tickEnd(EnumSet type, Object ... tickData) {
        MethodsHelper.isTickingThePlayer = false;
    }

    public EnumSet ticks() {
        return EnumSet.of(TickType.PLAYER);
    }

    public String getLabel() {
        return "StalkerPlayerTicker";
    }
}

