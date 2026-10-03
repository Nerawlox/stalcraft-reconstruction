/*
 * Decompiled with CFR 0.152.
 */
import gloomyfolken.mods.stalker.clans.pidb;
import net.minecraft.client.Minecraft;

public class pjhv
implements ofux {
    @Override
    public void onKeyDown() {
        Minecraft minecraft = Minecraft._E();
        pidb pidb2 = yuch._c;
        if (pidb2 != null && minecraft._B == null) {
            minecraft._a(new baco(pidb2));
        }
    }

    @Override
    public void onKeyUp() {
        Minecraft minecraft = Minecraft._E();
        if (minecraft._B instanceof baco) {
            minecraft._o();
        }
    }

    @Override
    public boolean processOnGui() {
        return true;
    }
}

