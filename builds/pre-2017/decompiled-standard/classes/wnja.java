/*
 * Decompiled with CFR 0.152.
 */
import net.minecraft.entity.player.EntityPlayer;

public class wnja {
    public static boolean _a;
    private static int _b;
    private static int _c;
    private static int _d;

    private static void _a(float f, float f2) {
        _c = Float.floatToIntBits(f) ^ 0x9381AC12;
        _d = Float.floatToIntBits(f2) ^ 0x9381AC12;
    }

    private static float _b() {
        return Float.intBitsToFloat(_c ^ 0x9381AC12);
    }

    private static float _c() {
        return Float.intBitsToFloat(_d ^ 0x9381AC12);
    }

    public static void _a(EntityPlayer entityPlayer) {
        if (entityPlayer == null) {
            return;
        }
        if ((entityPlayer.field_70177_z != wnja._b() || entityPlayer.field_70125_A != wnja._c()) && _b == System.identityHashCode(entityPlayer) && entityPlayer.field_70173_aa > 1) {
            _a = true;
        }
    }

    public static void _b(EntityPlayer entityPlayer) {
        if (entityPlayer == null) {
            return;
        }
        wnja._a(entityPlayer.field_70177_z, entityPlayer.field_70125_A);
        _b = System.identityHashCode(entityPlayer);
    }

    public static boolean _a() {
        boolean bl = _a;
        _a = false;
        return bl;
    }
}

