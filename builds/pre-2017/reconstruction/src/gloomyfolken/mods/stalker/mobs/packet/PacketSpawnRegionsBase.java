/*
 * Decompiled with CFR 0.152.
 */
package gloomyfolken.mods.stalker.mobs.packet;

import gloomyfolken.mods.stalker.mobs.packet.PacketConfig;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.util.ArrayList;

public class PacketSpawnRegionsBase
extends PacketConfig {
    private static final ArrayList allowedUsernames = new ArrayList();

    static {
        allowedUsernames.add("znw");
        allowedUsernames.add("folken");
        allowedUsernames.add("marxont");
        allowedUsernames.add("helper");
    }

    @Override
    public void read(DataInput dataInput) throws IOException {
        super.read(dataInput);
    }

    @Override
    public void write(DataOutput dataOutput) throws IOException {
        super.write(dataOutput);
    }
}

