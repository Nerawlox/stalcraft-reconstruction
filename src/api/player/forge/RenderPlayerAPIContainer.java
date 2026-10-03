/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.common.eventbus.EventBus
 *  cpw.mods.fml.common.DummyModContainer
 *  cpw.mods.fml.common.LoadController
 *  cpw.mods.fml.common.ModMetadata
 */
package api.player.forge;

import com.google.common.eventbus.EventBus;
import cpw.mods.fml.common.DummyModContainer;
import cpw.mods.fml.common.LoadController;
import cpw.mods.fml.common.ModMetadata;
import java.util.Arrays;

public class RenderPlayerAPIContainer
extends DummyModContainer {
    public RenderPlayerAPIContainer() {
        super(RenderPlayerAPIContainer.createMetadata());
    }

    public boolean registerBus(EventBus var1, LoadController var2) {
        return true;
    }

    private static ModMetadata createMetadata() {
        ModMetadata var0 = new ModMetadata();
        var0.modId = "RenderPlayerAPI";
        var0.name = "Render Player API";
        var0.version = "1.1";
        var0.description = "Render Player API for Minecraft Forge";
        var0.url = "http://www.minecraftforum.net/topic/1261354-";
        var0.authorList = Arrays.asList("Divisor");
        return var0;
    }
}

