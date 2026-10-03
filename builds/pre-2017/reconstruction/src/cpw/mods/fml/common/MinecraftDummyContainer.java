/*
 * Decompiled with CFR 0.152.
 */
package cpw.mods.fml.common;

import cpw.mods.fml.common.DummyModContainer;
import cpw.mods.fml.common.ModMetadata;
import cpw.mods.fml.common.versioning.VersionParser;
import cpw.mods.fml.common.versioning.VersionRange;

public class MinecraftDummyContainer
extends DummyModContainer {
    private VersionRange staticRange;

    public MinecraftDummyContainer(String string) {
        super(new ModMetadata());
        this.getMetadata().modId = "Minecraft";
        this.getMetadata().name = "Minecraft";
        this.getMetadata().version = string;
        this.staticRange = VersionParser.parseRange("[" + string + "]");
    }

    public VersionRange getStaticVersionRange() {
        return this.staticRange;
    }
}

