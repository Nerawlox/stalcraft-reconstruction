/*
 * Decompiled with CFR 0.152.
 */
package gloomyfolken.mods.faction;

import gloomyfolken.mods.faction.pidb;
import net.minecraftforge.event.ForgeSubscribe;

public class kjui {
    @ForgeSubscribe
    public void _a(mquk mquk2) {
        mquk2._a("faction_handler", new pidb(mquk2._a));
    }
}

