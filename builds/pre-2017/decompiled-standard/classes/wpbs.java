/*
 * Decompiled with CFR 0.152.
 */
import cpw.mods.fml.common.registry.VillagerRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.model.ModelVillager;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

@SideOnly(value=Side.CLIENT)
public class wpbs
extends ceev {
    public static final ResourceLocation _a = new ResourceLocation("textures/entity/villager/villager.png");
    public static final ResourceLocation _b = new ResourceLocation("textures/entity/villager/farmer.png");
    public static final ResourceLocation _c = new ResourceLocation("textures/entity/villager/librarian.png");
    public static final ResourceLocation _d = new ResourceLocation("textures/entity/villager/priest.png");
    public static final ResourceLocation _e = new ResourceLocation("textures/entity/villager/smith.png");
    public static final ResourceLocation _f = new ResourceLocation("textures/entity/villager/butcher.png");
    public ModelVillager _g;

    public wpbs() {
        super(new ModelVillager(0.0f), 0.5f);
        this._g = (ModelVillager)this.field_77045_g;
    }

    public int _a(EntityVillager entityVillager, int n, float f) {
        return -1;
    }

    public void _a(EntityVillager entityVillager, double d, double d2, double d3, float f, float f2) {
        super.func_77031_a(entityVillager, d, d2, d3, f, f2);
    }

    public ResourceLocation _a(EntityVillager entityVillager) {
        switch (entityVillager.func_70946_n()) {
            case 0: {
                return _b;
            }
            case 1: {
                return _c;
            }
            case 2: {
                return _d;
            }
            case 3: {
                return _e;
            }
            case 4: {
                return _f;
            }
        }
        return VillagerRegistry.getVillagerSkin(entityVillager.func_70946_n(), _a);
    }

    public void _a(EntityVillager entityVillager, float f) {
        super.func_77029_c(entityVillager, f);
    }

    public void _b(EntityVillager entityVillager, float f) {
        float f2 = 0.9375f;
        if (entityVillager.func_70874_b() < 0) {
            f2 = (float)((double)f2 * 0.5);
            this.field_76989_e = 0.25f;
        } else {
            this.field_76989_e = 0.5f;
        }
        GL11.glScalef(f2, f2, f2);
    }

    @Override
    public void func_77031_a(EntityLiving entityLiving, double d, double d2, double d3, float f, float f2) {
        this._a((EntityVillager)entityLiving, d, d2, d3, f, f2);
    }

    @Override
    public void func_77041_b(EntityLivingBase entityLivingBase, float f) {
        this._b((EntityVillager)entityLivingBase, f);
    }

    @Override
    public int func_77032_a(EntityLivingBase entityLivingBase, int n, float f) {
        return this._a((EntityVillager)entityLivingBase, n, f);
    }

    @Override
    public void func_77029_c(EntityLivingBase entityLivingBase, float f) {
        this._a((EntityVillager)entityLivingBase, f);
    }

    @Override
    public void func_77101_a(EntityLivingBase entityLivingBase, double d, double d2, double d3, float f, float f2) {
        this._a((EntityVillager)entityLivingBase, d, d2, d3, f, f2);
    }

    @Override
    public ResourceLocation func_110775_a(Entity entity) {
        return this._a((EntityVillager)entity);
    }

    @Override
    public void func_76986_a(Entity entity, double d, double d2, double d3, float f, float f2) {
        this._a((EntityVillager)entity, d, d2, d3, f, f2);
    }
}

