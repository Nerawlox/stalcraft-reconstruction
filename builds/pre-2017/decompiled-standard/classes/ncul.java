/*
 * Decompiled with CFR 0.152.
 */
import cpw.mods.fml.common.network.PacketDispatcher;
import gloomyfolken.bundle.common.core.eidj;
import gloomyfolken.bundle.common.core.ezey;
import gloomyfolken.mods.bundle.zwat;

@ezey(_a={eidj.CLIENT})
public class ncul {
    public static void _a(gloomyfolken.bundle.common.core.zwat zwat2) {
        PacketDispatcher.sendPacketToServer(new fmco(zwat2));
    }

    public static void _b(gloomyfolken.bundle.common.core.zwat zwat2) {
        kjui._b(zwat2);
    }

    private static class kjui {
        private kjui() {
        }

        private static void _b(gloomyfolken.bundle.common.core.zwat zwat2) {
            PacketDispatcher.sendPacketToServer(new fmco(new zwat(zwat2)));
        }
    }
}

