/*
 * Decompiled with CFR 0.152.
 */
package gloomyfolken.mods.party;

import gloomyfolken.bundle.common.core.eidj;
import gloomyfolken.bundle.common.core.ezey;
import gloomyfolken.mods.party.kjui;
import net.minecraft.client.Minecraft;

@ezey(_a={eidj.CLIENT})
public class zwat
implements nttf {
    public static kjui _a;

    public static boolean _a(qlqj qlqj2) {
        String string = Minecraft._E()._t.username;
        return qlqj2._d().equals(string) || zwat._a._a.values().iterator().next()._a.equals(string);
    }

    @Override
    public void onGameJoined() {
        _a = new kjui();
    }

    @Override
    public void onTickInGame() {
    }
}

