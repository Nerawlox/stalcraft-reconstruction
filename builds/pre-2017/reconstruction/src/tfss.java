/*
 * Decompiled with CFR 0.152.
 */
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import net.minecraft.block.Block;
import net.minecraft.block.BlockFluid;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.Vec3;
import net.minecraft.util.sajh;
import net.minecraft.world.World;
import org.lwjgl.opengl.GL11;
import org.lwjgl.util.glu.GLU;

public class tfss {
    public static float _a;
    public static float _b;
    public static float _c;
    public static IntBuffer _d;
    public static FloatBuffer _e;
    public static FloatBuffer _f;
    public static FloatBuffer _g;
    public static float _h;
    public static float _i;
    public static float _j;
    public static float _k;
    public static float _l;

    public static void _a(EntityPlayer entityPlayer, boolean bl) {
        GL11.glGetFloat(2982, _e);
        GL11.glGetFloat(2983, _f);
        GL11.glGetInteger(2978, _d);
        float f = (_d.get(0) + _d.get(2)) / 2;
        float f2 = (_d.get(1) + _d.get(3)) / 2;
        GLU.gluUnProject(f, f2, 0.0f, _e, _f, _d, _g);
        _a = _g.get(0);
        _b = _g.get(1);
        _c = _g.get(2);
        int n = bl ? 1 : 0;
        float f3 = entityPlayer.rotationPitch;
        float f4 = entityPlayer.rotationYaw;
        _h = sajh._b(f4 * (float)Math.PI / 180.0f) * (float)(1 - n * 2);
        _j = sajh._a(f4 * (float)Math.PI / 180.0f) * (float)(1 - n * 2);
        _k = -_j * sajh._a(f3 * (float)Math.PI / 180.0f) * (float)(1 - n * 2);
        _l = _h * sajh._a(f3 * (float)Math.PI / 180.0f) * (float)(1 - n * 2);
        _i = sajh._b(f3 * (float)Math.PI / 180.0f);
    }

    public static Vec3 _a(EntityLivingBase entityLivingBase, double d) {
        double d2 = entityLivingBase.prevPosX + (entityLivingBase.posX - entityLivingBase.prevPosX) * d;
        double d3 = entityLivingBase.prevPosY + (entityLivingBase.posY - entityLivingBase.prevPosY) * d + (double)entityLivingBase.getEyeHeight();
        double d4 = entityLivingBase.prevPosZ + (entityLivingBase.posZ - entityLivingBase.prevPosZ) * d;
        double d5 = d2 + (double)(_a * 1.0f);
        double d6 = d3 + (double)(_b * 1.0f);
        double d7 = d4 + (double)(_c * 1.0f);
        return entityLivingBase.worldObj.getWorldVec3Pool()._a(d5, d6, d7);
    }

    public static int _a(World world, EntityLivingBase entityLivingBase, float f) {
        float f2;
        float f3;
        Vec3 vec3 = tfss._a(entityLivingBase, f);
        xtcd xtcd2 = new xtcd(vec3);
        int n = world.getBlockId(xtcd2._d, xtcd2._e, xtcd2._f);
        if (n != 0 && Block.blocksList[n].blockMaterial._d() && vec3._d >= (double)(f3 = (float)(xtcd2._e + 1) - (f2 = BlockFluid._a(world.getBlockMetadata(xtcd2._d, xtcd2._e, xtcd2._f)) - 0.11111111f))) {
            n = world.getBlockId(xtcd2._d, xtcd2._e + 1, xtcd2._f);
        }
        return n;
    }

    static {
        _d = pklh._d(16);
        _e = pklh._e(16);
        _f = pklh._e(16);
        _g = pklh._e(3);
    }
}

