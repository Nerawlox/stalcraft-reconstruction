/*
 * Decompiled with CFR 0.152.
 */
import gloomyfolken.hooklib.asm.Hook;
import gloomyfolken.hooklib.asm.ReturnCondition;
import gloomyfolken.mods.effects.client.main.eidj;
import gloomyfolken.mods.effects.client.main.zwaw;
import gloomyfolken.mods.effects.client.mcsa.ezfa;
import gloomyfolken.mods.stalker.misc.tupg;
import java.nio.FloatBuffer;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.EntityRenderer;
import net.minecraft.client.renderer.texture.TextureManager;
import net.minecraft.client.renderer.tileentity.TileEntityRenderer;
import net.minecraft.network.packet.Packet9Respawn;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.Vec3;
import net.minecraftforge.client.MinecraftForgeClient;
import net.minecraftforge.common.MinecraftForge;
import org.lwjgl.BufferUtils;
import org.lwjgl.opengl.GL11;
import org.lwjgl.util.vector.Matrix4f;

public class fmej {
    public static boolean _a;
    public static boolean _b;
    public static FloatBuffer _c;
    public static Matrix4f _d;
    public static Matrix4f _e;

    @Hook(returnCondition=ReturnCondition.ON_TRUE)
    public static boolean _a(EntityRenderer entityRenderer, int n, float f) {
        tupg tupg2 = tupg._a(Minecraft._E()._t);
        return false;
    }

    @Hook(targetMethod="renderHand")
    public static void _a(EntityRenderer entityRenderer, float f, int n) {
        fmej._a(2983, _d);
        fmej._a(2982, _e);
    }

    private static void _a(int n, Matrix4f matrix4f) {
        _c.clear();
        GL11.glGetFloat(n, _c);
        matrix4f.load(_c);
    }

    @Hook(injectOnExit=true)
    public static void _b(EntityRenderer entityRenderer, float f, int n) {
        jylm.kjui kjui2 = new jylm.kjui(entityRenderer, f, n, 16384);
        MinecraftForge.EVENT_BUS.post(kjui2);
        if (!kjui2.isCanceled()) {
            zwaw._a(kjui2._d, true);
        }
        jylm.pidb pidb2 = new jylm.pidb(entityRenderer, f, n);
        MinecraftForge.EVENT_BUS.post(pidb2);
    }

    @Hook
    public static void _a(bscn bscn2, Packet9Respawn packet9Respawn) {
        _b = true;
    }

    private static void _a() {
        jysc jysc2 = jysc._H();
        if (zwaw._n() && jysc2 != null) {
            GL11.glColor4d(1.0, 1.0, 1.0, 1.0);
            GL11.glDisable(2929);
            GL11.glDisable(3008);
            GL11.glDisable(2896);
            GL11.glEnable(3553);
            anya._h();
            MinecraftForge.EVENT_BUS.post(new tvms.kjui(jysc2));
            GL11.glEnable(2929);
            GL11.glEnable(3008);
            GL11.glEnable(2896);
        }
    }

    @Hook(injectOnExit=true)
    public static void _a(EntityRenderer entityRenderer, float f, long l) {
        fmej._a();
        fmej._b();
        Minecraft._E().__ah._a("postprocessing");
        hsmn hsmn2 = eidj._a._c;
        if (hsmn2 != null) {
            eidj._a._c._a(f);
        }
        Minecraft._E().__ah._b();
    }

    private static void _b() {
        fmej._b(5889, _d);
        fmej._b(5888, _e);
        ezfa ezfa2 = ezfa._a;
        ezfa2._a(ezfa2._b);
        ezfa2._b(ezfa2._b);
    }

    private static void _b(int n, Matrix4f matrix4f) {
        _c.clear();
        GL11.glMatrixMode(n);
        matrix4f.store(_c);
        _c.flip();
        GL11.glLoadMatrix(_c);
    }

    @Hook(injectOnExit=true)
    public static void _a(cvgz cvgz2, Vec3 vec3, lpai lpai2, float f) {
        Minecraft._E().__ah._a("delayed rendering");
        int n = MinecraftForgeClient.getRenderPass();
        if (n > 0) {
            GL11.glEnable(2884);
        }
        ezfa._a._a();
        if (n > 0) {
            GL11.glDisable(2884);
        }
        Minecraft._E().__ah._b();
        eidj._C._i = cvgz2._e.size();
    }

    @Hook
    public static void _a(TileEntityRenderer tileEntityRenderer, TileEntity tileEntity, double d, double d2, double d3, float f) {
        ++eidj._C._h;
    }

    @Hook(returnCondition=ReturnCondition.ON_TRUE)
    public static boolean _a(EntityRenderer entityRenderer, float f) {
        return !_a;
    }

    public static boolean _a(int n) {
        return ytzy._a != -1 && ytzy._a != n;
    }

    @Hook(injectOnExit=true)
    public static void _c(EntityRenderer entityRenderer, float f, int n) {
        eidj._a._c();
    }

    @Hook(returnCondition=ReturnCondition.ALWAYS)
    public static void _a(TextureManager textureManager, ResourceLocation resourceLocation) {
        sctg sctg2 = (sctg)textureManager._a.get(resourceLocation);
        int n = 3553;
        if (sctg2 == null) {
            sctg2 = fmib._a.get(resourceLocation);
            if (sctg2 == null) {
                try {
                    sctg2 = fmib._f(resourceLocation);
                }
                catch (Exception exception) {
                    exception.printStackTrace();
                    sctg2 = bsfn._b;
                }
            }
            textureManager._a(resourceLocation, sctg2);
        }
        if (sctg2 instanceof ejfb) {
            n = ((ejfb)sctg2)._e();
        }
        GL11.glBindTexture(n, sctg2.getGlTextureId());
    }

    static {
        _b = true;
        _c = BufferUtils.createFloatBuffer(16);
        _d = new Matrix4f();
        _e = new Matrix4f();
    }
}

