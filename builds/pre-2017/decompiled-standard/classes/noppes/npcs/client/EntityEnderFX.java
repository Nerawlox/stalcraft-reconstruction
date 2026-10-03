/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.client;

import net.minecraft.client.particle.EntityFX;
import net.minecraft.client.particle.EntityPortalFX;
import net.minecraft.client.xpzm;
import net.minecraft.util.ResourceLocation;
import noppes.npcs.EntityNPCInterface;
import noppes.npcs.client.ClientProxy;
import noppes.npcs.client.renderer.RenderNPCInterface;
import org.lwjgl.opengl.GL11;

public class EntityEnderFX
extends EntityPortalFX {
    private static final ResourceLocation field_110737_b = new ResourceLocation("textures/particle/particles.png");
    private float field_70571_a;
    private int particleNumber;
    private RenderNPCInterface npcRenderer;
    private EntityNPCInterface npc;

    public EntityEnderFX(EntityNPCInterface entityNPCInterface, double d, double d2, double d3, double d4, double d5, double d6) {
        super(entityNPCInterface.field_70170_p, d, d2, d3, d4, d5, d6);
        this.npcRenderer = (RenderNPCInterface)gqqu._b._a(entityNPCInterface);
        this.npc = entityNPCInterface;
        this.particleNumber = entityNPCInterface.field_70170_p.field_73012_v.nextInt(2);
        this.field_70571_a = this.field_70544_f = this.field_70146_Z.nextFloat() * 0.2f + 0.5f;
        this.field_70551_j = 1.0f;
        this.field_70553_i = 1.0f;
        this.field_70552_h = 1.0f;
    }

    @Override
    public void func_70539_a(htvf htvf2, float f, float f2, float f3, float f4, float f5, float f6) {
        htvf htvf3 = htvf.field_78398_a;
        htvf3.func_78381_a();
        float f7 = ((float)this.field_70546_d + f) / (float)this.field_70547_e;
        f7 = 1.0f - f7;
        f7 *= f7;
        f7 = 1.0f - f7;
        this.field_70544_f = this.field_70571_a * f7;
        xpzm xpzm2 = xpzm._E();
        ClientProxy.bindTexture(this.npcRenderer.func_110775_a(this.npc));
        float f8 = 0.875f;
        float f9 = f8 + 0.125f;
        float f10 = 0.75f - (float)this.particleNumber * 0.25f;
        float f11 = f10 + 0.25f;
        float f12 = 0.1f * this.field_70544_f;
        float f13 = (float)(this.field_70169_q + (this.field_70165_t - this.field_70169_q) * (double)f - EntityFX.field_70556_an);
        float f14 = (float)(this.field_70167_r + (this.field_70163_u - this.field_70167_r) * (double)f - EntityFX.field_70554_ao);
        float f15 = (float)(this.field_70166_s + (this.field_70161_v - this.field_70166_s) * (double)f - EntityFX.field_70555_ap);
        GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
        htvf3.func_78382_b();
        htvf3.func_78380_c(this.func_70070_b(f));
        htvf2.func_78386_a(1.0f, 1.0f, 1.0f);
        htvf2.func_78374_a(f13 - f2 * f12 - f5 * f12, f14 - f3 * f12, f15 - f4 * f12 - f6 * f12, f9, f11);
        htvf2.func_78374_a(f13 - f2 * f12 + f5 * f12, f14 + f3 * f12, f15 - f4 * f12 + f6 * f12, f9, f10);
        htvf2.func_78374_a(f13 + f2 * f12 + f5 * f12, f14 + f3 * f12, f15 + f4 * f12 + f6 * f12, f8, f10);
        htvf2.func_78374_a(f13 + f2 * f12 - f5 * f12, f14 - f3 * f12, f15 + f4 * f12 - f6 * f12, f8, f11);
        htvf3.func_78381_a();
        ClientProxy.bindTexture(field_110737_b);
        htvf3.func_78382_b();
    }

    @Override
    public int func_70537_b() {
        return 0;
    }
}

