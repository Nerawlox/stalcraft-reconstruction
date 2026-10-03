/*
 * Decompiled with CFR 0.152.
 */
package cpw.mods.fml.common;

import com.google.common.eventbus.EventBus;
import cpw.mods.fml.common.DummyModContainer;
import cpw.mods.fml.common.LoadController;
import cpw.mods.fml.common.ModMetadata;

public class MCPDummyContainer
extends DummyModContainer {
    public MCPDummyContainer(ModMetadata modMetadata) {
        super(modMetadata);
    }

    @Override
    public boolean registerBus(EventBus eventBus, LoadController loadController) {
        return true;
    }
}

