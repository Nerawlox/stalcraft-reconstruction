/*
 * Decompiled with CFR 0.152.
 */
import cpw.mods.fml.common.registry.LanguageRegistry;
import gloomyfolken.bundle.common.core.InvokeSideOnly;
import gloomyfolken.bundle.common.core.eidj;
import gloomyfolken.bundle.common.core.ezey;
import gloomyfolken.mods.core.entity.EntityAdvancedThrowable;
import gloomyfolken.mods.core.entity.jxtc;
import gloomyfolken.mods.core.misc.pibk;
import gloomyfolken.mods.core.misc.ybzs;
import gloomyfolken.mods.weapon.entity.EntityGrenade;
import java.util.List;
import mods.sound.client.environment.EnvironmentProcessor;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class yurw
extends ybzs {
    public final String _b;
    public final float _c;
    public final int _d;
    public final scai _e;
    public final boolean _f;
    private final boolean _n;
    private final String _o;
    public int _g;
    public int _h;
    public int _i;
    public int _j;
    public String _k;
    public String _l;
    public boolean _m = true;

    public yurw(int n, String string, pibk pibk2, String string2, List<String> list, float f, boolean bl, int n2, boolean bl2, String string3, scai scai2) {
        super(n, string, "weapons:" + string2, list, pibk2, string3, 300);
        this.setUnlocalizedName("grenade" + this.itemID);
        LanguageRegistry.addName(this, string);
        this._b = string3;
        this._o = string2;
        this._c = f;
        this._n = bl;
        this._d = n2;
        this._f = bl2;
        this._e = scai2;
    }

    @Override
    @ezey(_a={eidj.CLIENT})
    public boolean isFull3D() {
        return true;
    }

    @Override
    @ezey(_a={eidj.CLIENT})
    public void registerIcons(IconRegister iconRegister) {
        this.itemIcon = iconRegister._b("weapons:" + this._o);
    }

    @Override
    public float _a(@NotNull jxtc jxtc2, float f) {
        if (jxtc2 == null) {
            yurw._c(0);
        }
        if (!this._n) {
            return 0.0f;
        }
        float f2 = Math.max(0, this._b(jxtc2, false) - 1 - this._g);
        float f3 = Math.max(0, this._b(jxtc2, false) - this._g);
        return Math.max(0.0f, owkq._c(f, f2, f3) / (float)this._h);
    }

    @Override
    public void _a(@NotNull jxtc jxtc2) {
        if (jxtc2 == null) {
            yurw._c(1);
        }
        super._a(jxtc2);
        InvokeSideOnly.client(() -> {
            if (jxtc2 == null) {
                yurw._c(6);
            }
            EntityLivingBase entityLivingBase = jxtc2._u();
            EnvironmentProcessor.instance.playSoundRelatively("weapons:" + this._l, (float)entityLivingBase.posX, (float)entityLivingBase.posY, (float)entityLivingBase.posZ, 1.0f, 1.0f, true, false);
        });
    }

    @Override
    @Nullable
    public boolean _b(@NotNull ItemStack itemStack, @NotNull jxtc jxtc2, int n) {
        if (itemStack == null) {
            yurw._c(2);
        }
        if (jxtc2 == null) {
            yurw._c(3);
        }
        if (this._a(jxtc2, 0.0f) > 1.0f) {
            EntityLivingBase entityLivingBase = jxtc2._u();
            if (!entityLivingBase.worldObj.isRemote) {
                EntityGrenade entityGrenade = this._a(entityLivingBase, 0.0f);
                entityLivingBase.worldObj.spawnEntityInWorld(entityGrenade);
                entityGrenade.visible = false;
                entityGrenade.setDead();
            }
            if (entityLivingBase instanceof EntityPlayer) {
                this._a((EntityPlayer)entityLivingBase, itemStack);
            }
            return true;
        }
        return false;
    }

    @Override
    @Nullable
    public EntityAdvancedThrowable _a(@NotNull ItemStack itemStack, @NotNull jxtc jxtc2, int n) {
        if (itemStack == null) {
            yurw._c(4);
        }
        if (jxtc2 == null) {
            yurw._c(5);
        }
        EntityLivingBase entityLivingBase = jxtc2._u();
        World world = entityLivingBase.worldObj;
        EntityGrenade entityGrenade = this._a(entityLivingBase, this._c(n));
        entityGrenade.lifetime = (int)((float)entityGrenade.lifetime * (1.0f - Math.min(1.0f, this._a(jxtc2, 0.0f))));
        if (world.isRemote) {
            entityGrenade.setAsFakeEntity();
        }
        world.spawnEntityInWorld(entityGrenade);
        if (entityLivingBase instanceof EntityPlayer) {
            EntityPlayer entityPlayer = (EntityPlayer)entityLivingBase;
            this._a(entityPlayer, itemStack);
            if (!world.isRemote) {
                InvokeSideOnly.frontend(() -> {});
            }
        }
        return entityGrenade;
    }

    private EntityGrenade _a(EntityLivingBase entityLivingBase, float f) {
        EntityGrenade entityGrenade = new EntityGrenade(entityLivingBase.worldObj, entityLivingBase, f * this._i(), this, false);
        entityGrenade.modelName = this._o();
        return entityGrenade;
    }

    private static /* synthetic */ void _c(int n) {
        Object[] objectArray;
        Object[] objectArray2;
        Object[] objectArray3 = new Object[3];
        switch (n) {
            default: {
                objectArray2 = objectArray3;
                objectArray3[0] = "user";
                break;
            }
            case 2: 
            case 4: {
                objectArray2 = objectArray3;
                objectArray3[0] = "itemStack";
                break;
            }
        }
        objectArray2[1] = "gloomyfolken/mods/weapon/item/ItemGrenade";
        switch (n) {
            default: {
                objectArray = objectArray2;
                objectArray2[2] = "getIgnitionProgress";
                break;
            }
            case 1: {
                objectArray = objectArray2;
                objectArray2[2] = "onStartedCharging";
                break;
            }
            case 2: 
            case 3: {
                objectArray = objectArray2;
                objectArray2[2] = "onChargeTick";
                break;
            }
            case 4: 
            case 5: {
                objectArray = objectArray2;
                objectArray2[2] = "spawnThrownEntity";
                break;
            }
            case 6: {
                objectArray = objectArray2;
                objectArray2[2] = "lambda$onStartedCharging$0";
                break;
            }
        }
        throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objectArray));
    }
}

