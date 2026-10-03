/*
 * Decompiled with CFR 0.152.
 */
package gloomyfolken.mods.asm;

import cpw.mods.fml.common.network.FMLNetworkHandler;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.network.Player;
import gloomyfolken.bundle.common.core.eidj;
import gloomyfolken.bundle.common.core.ezey;
import gloomyfolken.hooklib.asm.Hook;
import gloomyfolken.hooklib.asm.ReturnCondition;
import gloomyfolken.mods.core.main.GloomyCore;
import java.lang.reflect.Field;
import java.nio.ByteBuffer;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import net.minecraft.client.Minecraft;
import net.minecraft.network.packet.Packet250CustomPayload;
import net.minecraft.network.packet.Packet252SharedKey;

public class NetworkHooks {
    private static Set<yezc> _a = new HashSet<yezc>();
    private static Set<yezc> _b = new HashSet<yezc>();
    private static Map<yezc, Integer> _c;
    private static boolean _d;

    @Hook(returnCondition=ReturnCondition.ALWAYS)
    public static void activateChannel(NetworkRegistry networkRegistry, Player player, String string) {
    }

    @Hook
    @ezey(_a={eidj.CLIENT})
    public static void handleServerAuthData(bscn bscn2, ujpx ujpx2) {
        if (!"-".equals(ujpx2._a().trim()) && _d) {
            ujpx2._a = "-";
        }
    }

    @Hook(returnCondition=ReturnCondition.ON_TRUE)
    @ezey(_a={eidj.CLIENT})
    public static boolean handleSharedKey(bscn bscn2, Packet252SharedKey packet252SharedKey) {
        if (_d) {
            NetworkHooks.sendAssetsHash(bscn2, packet252SharedKey);
            bscn2._b(FMLNetworkHandler.getFMLFakeLoginPacket());
            bscn2._b(new wnsq(Minecraft._E()._P()._b()));
            return true;
        }
        return false;
    }

    @Hook(targetMethod="handleSharedKey", injectOnExit=true)
    @ezey(_a={eidj.CLIENT})
    public static void sendAssetsHash(bscn bscn2, Packet252SharedKey packet252SharedKey) {
        byte[] byArray = ByteBuffer.allocate(4).putInt(GloomyCore.instance.itemsLoader._f()).array();
        bscn2._b(new Packet250CustomPayload("GloomyLogin", byArray));
    }

    static {
        try {
            FMLNetworkHandler fMLNetworkHandler = FMLNetworkHandler.instance();
            Field field = FMLNetworkHandler.class.getDeclaredField("loginStates");
            field.setAccessible(true);
            _c = (Map)field.get(fMLNetworkHandler);
        }
        catch (IllegalAccessException | NoSuchFieldException reflectiveOperationException) {
            throw new RuntimeException(reflectiveOperationException);
        }
        _d = System.getProperty("test_session", "false").equals("true");
    }
}

