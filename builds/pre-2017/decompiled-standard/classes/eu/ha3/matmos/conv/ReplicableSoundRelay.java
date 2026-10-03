/*
 * Decompiled with CFR 0.152.
 */
package eu.ha3.matmos.conv;

import eu.ha3.matmos.engine.interfaces.SoundRelay;

public interface ReplicableSoundRelay
extends SoundRelay {
    public SoundRelay createChild();
}

