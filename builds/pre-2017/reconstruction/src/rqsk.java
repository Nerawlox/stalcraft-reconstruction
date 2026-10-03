/*
 * Decompiled with CFR 0.152.
 */
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.model.ModelZombie;
import net.minecraft.client.model.ModelZombieVillager;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.monster.EntityPigZombie;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.util.ResourceLocation;

public class rqsk
extends ifvk {
    public static final ResourceLocation _g = new ResourceLocation("textures/entity/zombie_pigman.png");
    public static final ResourceLocation _h = new ResourceLocation("textures/entity/zombie/zombie.png");
    public static final ResourceLocation _i = new ResourceLocation("textures/entity/zombie/zombie_villager.png");
    public ModelBiped _j = this._a;
    public ModelZombieVillager _k = new ModelZombieVillager();
    public ModelBiped _l;
    public ModelBiped _m;
    public ModelBiped _n;
    public ModelBiped _o;
    public int _p = 1;

    public rqsk() {
        super(new ModelZombie(), 0.5f, 1.0f);
    }

    @Override
    public void _a() {
        this._c = new ModelZombie(1.0f, true);
        this._d = new ModelZombie(0.5f, true);
        this._l = this._c;
        this._m = this._d;
        this._n = new ModelZombieVillager(1.0f, 0.0f, true);
        this._o = new ModelZombieVillager(0.5f, 0.0f, true);
    }

    public int _a(EntityZombie entityZombie, int n, float f) {
        this._b(entityZombie);
        return super._a(entityZombie, n, f);
    }

    public void _a(EntityZombie entityZombie, double d, double d2, double d3, float f, float f2) {
        this._b(entityZombie);
        super.doRenderLiving(entityZombie, d, d2, d3, f, f2);
    }

    public ResourceLocation _a(EntityZombie entityZombie) {
        if (entityZombie instanceof EntityPigZombie) {
            return _g;
        }
        if (entityZombie.isVillager()) {
            return _i;
        }
        return _h;
    }

    public void _a(EntityZombie entityZombie, float f) {
        this._b(entityZombie);
        super._a((EntityLiving)entityZombie, f);
    }

    public void _b(EntityZombie entityZombie) {
        if (entityZombie.isVillager()) {
            if (this._p != this._k.func_82897_a()) {
                this._k = new ModelZombieVillager();
                this._p = this._k.func_82897_a();
                this._n = new ModelZombieVillager(1.0f, 0.0f, true);
                this._o = new ModelZombieVillager(0.5f, 0.0f, true);
            }
            this.mainModel = this._k;
            this._c = this._n;
            this._d = this._o;
        } else {
            this.mainModel = this._j;
            this._c = this._l;
            this._d = this._m;
        }
        this._a = (ModelBiped)this.mainModel;
    }

    public void _a(EntityZombie entityZombie, float f, float f2, float f3) {
        if (entityZombie.isConverting()) {
            f2 += (float)(Math.cos((double)entityZombie.ticksExisted * 3.25) * Math.PI * 0.25);
        }
        super.rotateCorpse(entityZombie, f, f2, f3);
    }

    @Override
    public /* synthetic */ void doRenderLiving(EntityLiving entityLiving, double d, double d2, double d3, float f, float f2) {
        this._a((EntityZombie)entityLiving, d, d2, d3, f, f2);
    }

    @Override
    public /* synthetic */ int shouldRenderPass(EntityLivingBase entityLivingBase, int n, float f) {
        return this._a((EntityZombie)entityLivingBase, n, f);
    }

    @Override
    public /* synthetic */ void renderEquippedItems(EntityLivingBase entityLivingBase, float f) {
        this._a((EntityZombie)entityLivingBase, f);
    }

    @Override
    public /* synthetic */ void rotateCorpse(EntityLivingBase entityLivingBase, float f, float f2, float f3) {
        this._a((EntityZombie)entityLivingBase, f, f2, f3);
    }

    @Override
    public /* synthetic */ void renderPlayer(EntityLivingBase entityLivingBase, double d, double d2, double d3, float f, float f2) {
        this._a((EntityZombie)entityLivingBase, d, d2, d3, f, f2);
    }

    @Override
    public /* synthetic */ ResourceLocation getEntityTexture(Entity entity) {
        return this._a((EntityZombie)entity);
    }

    @Override
    public /* synthetic */ void doRender(Entity entity, double d, double d2, double d3, float f, float f2) {
        this._a((EntityZombie)entity, d, d2, d3, f, f2);
    }
}

