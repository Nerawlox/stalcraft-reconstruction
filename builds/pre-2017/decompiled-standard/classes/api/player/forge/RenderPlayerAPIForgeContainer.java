/*
 * Decompiled with CFR 0.152.
 */
package api.player.forge;

import com.google.common.eventbus.EventBus;
import cpw.mods.fml.common.DummyModContainer;
import cpw.mods.fml.common.LoadController;
import cpw.mods.fml.common.ModMetadata;
import java.util.Arrays;

public class RenderPlayerAPIForgeContainer
extends DummyModContainer {
    public RenderPlayerAPIForgeContainer() {
        super(RenderPlayerAPIForgeContainer.createMetadata());
    }

    @Override
    public boolean registerBus(EventBus eventBus, LoadController loadController) {
        return true;
    }

    private static ModMetadata createMetadata() {
        ModMetadata modMetadata = new ModMetadata();
        modMetadata.modId = "RenderPlayerAPI";
        modMetadata.name = "Render Player API";
        modMetadata.version = "1.0";
        modMetadata.description = "Render Player API for Minecraft Forge";
        modMetadata.url = "http://www.minecraftforum.net/topic/1261354-";
        modMetadata.authorList = Arrays.asList("Divisor");
        return modMetadata;
    }
}

