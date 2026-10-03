/*
 * Decompiled with CFR 0.152.
 */
import cpw.mods.fml.common.registry.VillagerRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.model.ModelVillager;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

@SideOnly(value=Side.CLIENT)
public class wpbs
extends RenderLiving {
    public static final ResourceLocation _a = new ResourceLocation("textures/entity/villager/villager.png");
    public static final ResourceLocation _b = new ResourceLocation("textures/entity/villager/farmer.png");
    public static final ResourceLocation _c = new ResourceLocation("textures/entity/villager/librarian.png");
    public static final ResourceLocation _d = new ResourceLocation("textures/entity/villager/priest.png");
    public static final ResourceLocation _e = new ResourceLocation("textures/entity/villager/smith.png");
    public static final ResourceLocation _f = new ResourceLocation("textures/entity/villager/butcher.png");
    public ModelVillager _g;

    public wpbs() {
        super(new ModelVillager(0.0f), 0.5f);
        this._g = (ModelVillager)this.mainModel;
    }

    public int _a(EntityVillager entityVillager, int n, float f) {
        return -1;
    }

    public void _a(EntityVillager entityVillager, double d, double d2, double d3, float f, float f2) {
        super.doRenderLiving(entityVillager, d, d2, d3, f, f2);
    }

    public ResourceLocation _a(EntityVillager entityVillager) {
        switch (entityVillager.getProfession()) {
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
        return VillagerRegistry.getVillagerSkin(entityVillager.getProfession(), _a);
    }

    public void _a(EntityVillager entityVillager, float f) {
        super.renderEquippedItems(entityVillager, f);
    }

    public void _b(EntityVillager entityVillager, float f) {
        float f2 = 0.9375f;
        if (entityVillager.getGrowingAge() < 0) {
            f2 = (float)((double)f2 * 0.5);
            this.shadowSize = 0.25f;
        } else {
            this.shadowSize = 0.5f;
        }
        GL11.glScalef(f2, f2, f2);
    }

    @Override
    public void doRenderLiving(EntityLiving entityLiving, double d, double d2, double d3, float f, float f2) {
        this._a((EntityVillager)entityLiving, d, d2, d3, f, f2);
    }

    @Override
    public void preRenderCallback(EntityLivingBase entityLivingBase, float f) {
        this._b((EntityVillager)entityLivingBase, f);
    }

    @Override
    public int shouldRenderPass(EntityLivingBase entityLivingBase, int n, float f) {
        return this._a((EntityVillager)entityLivingBase, n, f);
    }

    @Override
    public void renderEquippedItems(EntityLivingBase entityLivingBase, float f) {
        this._a((EntityVillager)entityLivingBase, f);
    }

    @Override
    public void renderPlayer(EntityLivingBase entityLivingBase, double d, double d2, double d3, float f, float f2) {
        this._a((EntityVillager)entityLivingBase, d, d2, d3, f, f2);
    }

    @Override
    public ResourceLocation getEntityTexture(Entity entity) {
        return this._a((EntityVillager)entity);
    }

    @Override
    public void doRender(Entity entity, double d, double d2, double d3, float f, float f2) {
        this._a((EntityVillager)entity, d, d2, d3, f, f2);
    }
}

