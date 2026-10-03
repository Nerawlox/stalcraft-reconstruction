/*
 * Decompiled with CFR 0.152.
 */
package api.player.forge;

import com.google.common.eventbus.EventBus;
import cpw.mods.fml.common.DummyModContainer;
import cpw.mods.fml.common.LoadController;
import cpw.mods.fml.common.ModMetadata;
import java.util.Arrays;

public class PlayerAPIContainer
extends DummyModContainer {
    public PlayerAPIContainer() {
        super(PlayerAPIContainer.createMetadata());
    }

    @Override
    public boolean registerBus(EventBus eventBus, LoadController loadController) {
        return true;
    }

    private static ModMetadata createMetadata() {
        ModMetadata modMetadata = new ModMetadata();
        modMetadata.modId = "PlayerAPI";
        modMetadata.name = "Player API";
        modMetadata.version = "1.0";
        modMetadata.description = "Player API for Minecraft Forge";
        modMetadata.url = "http://www.minecraftforum.net/topic/738498-";
        modMetadata.authorList = Arrays.asList("Divisor");
        return modMetadata;
    }
}

