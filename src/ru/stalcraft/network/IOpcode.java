/*
 * Decompiled with CFR 0.152.
 */
package ru.stalcraft.network;

import ru.stalcraft.network.DebugGroup;
import ru.stalcraft.network.DebugPriority;

public interface IOpcode {
    public DebugGroup getGroup();

    public DebugPriority getPriority();

    public int getOrdinal();

    public String getName();
}

