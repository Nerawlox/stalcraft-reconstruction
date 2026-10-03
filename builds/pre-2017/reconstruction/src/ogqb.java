/*
 * Decompiled with CFR 0.152.
 */
import gloomyfolken.bundle.common.core.eidj;
import gloomyfolken.bundle.common.core.ezey;
import gloomyfolken.hooklib.asm.Hook;
import gloomyfolken.hooklib.asm.ReturnCondition;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.EntityRenderer;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.network.packet.Packet9Respawn;
import net.minecraft.util.sajh;
import net.minecraftforge.common.MinecraftForge;
import org.lwjgl.opengl.GL11;

public class ogqb {
    @Hook(injectOnExit=true)
    @ezey(_a={eidj.CLIENT})
    public static void _a(bscn bscn2, Packet9Respawn packet9Respawn) {
        MinecraftForge.EVENT_BUS.post(new zxrk(packet9Respawn._a, packet9Respawn._b, packet9Respawn._c, packet9Respawn._d, packet9Respawn._e));
    }

    @ezey(_a={eidj.CLIENT})
    @Hook(returnCondition=ReturnCondition.ALWAYS)
    public static void _a(EntityRenderer entityRenderer, float f) {
        float f2;
        EntityLivingBase entityLivingBase = entityRenderer.mc._u;
        float f3 = (float)entityLivingBase.hurtTime - f;
        if (entityLivingBase.getHealth() <= 0.0f) {
            f2 = entityLivingBase.deathTime;
            GL11.glRotatef(40.0f - 8000.0f / (f2 + 200.0f), 0.0f, 0.0f, 1.0f);
        }
        if (f3 >= 0.0f) {
            f3 /= (float)entityLivingBase.maxHurtTime;
            f3 = sajh._a(f3 * f3 * f3 * f3 * (float)Math.PI);
            f2 = entityLivingBase.attackedAtYaw;
            GL11.glRotatef(-f2, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(-f3 * 14.0f, 0.0f, 0.0f, 1.0f);
            GL11.glRotatef(f2, 0.0f, 1.0f, 0.0f);
        }
    }

    @ezey(_a={eidj.CLIENT})
    @Hook(returnCondition=ReturnCondition.ALWAYS)
    public static float _a(EntityRenderer entityRenderer, float f, boolean bl) {
        int n;
        if (entityRenderer.debugViewDirection > 0) {
            return 90.0f;
        }
        EntityLivingBase entityLivingBase = entityRenderer.mc._u;
        float f2 = 70.0f;
        if (bl) {
            f2 += entityRenderer.mc._M.fovSetting * 40.0f;
            f2 *= entityRenderer.fovModifierHandPrev + (entityRenderer.fovModifierHand - entityRenderer.fovModifierHandPrev) * f;
        }
        if (entityLivingBase.getHealth() <= 0.0f) {
            float f3 = entityLivingBase.deathTime;
            f2 /= (1.0f - 500.0f / (f3 + 500.0f)) * 2.0f + 1.0f;
        }
        if ((n = tfss._a(entityRenderer.mc._r, entityLivingBase, f)) != 0 && Block.blocksList[n].blockMaterial == Material._h) {
            f2 = f2 * 60.0f / 70.0f;
        }
        return f2 + entityRenderer.prevDebugCamFOV + (entityRenderer.debugCamFOV - entityRenderer.prevDebugCamFOV) * f;
    }
}

