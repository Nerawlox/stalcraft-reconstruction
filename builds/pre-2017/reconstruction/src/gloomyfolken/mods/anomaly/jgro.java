/*
 * Decompiled with CFR 0.152.
 */
package gloomyfolken.mods.anomaly;

import com.google.common.collect.Lists;
import cpw.mods.fml.common.registry.LanguageRegistry;
import gloomyfolken.bundle.common.core.InvokeSideOnly;
import gloomyfolken.bundle.common.core.eidj;
import gloomyfolken.bundle.common.core.ezey;
import gloomyfolken.mods.anomaly.entity.EntityBolt;
import gloomyfolken.mods.core.entity.EntityAdvancedThrowable;
import gloomyfolken.mods.core.entity.jxtc;
import gloomyfolken.mods.core.main.GloomyCore;
import gloomyfolken.mods.core.misc.pibk;
import gloomyfolken.mods.core.misc.ybzs;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraftforge.client.MinecraftForgeClient;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class jgro
extends ybzs {
    public jgro(int n) {
        super(n, "bolt", "anomalies:bolt", Lists.newArrayList(""), new pibk("anomalies/models/bolt.mcsa", "/assets/anomalies/anims/bolt.anm"), "anomalies/models/bolt_thrown.mcsa", 1);
        this.setUnlocalizedName("bolt");
        this._b(5);
        LanguageRegistry.addName(this, "\u0411\u043e\u043b\u0442");
        if (GloomyCore.side.isClient()) {
            InvokeSideOnly.client(() -> {
                ejwe ejwe2 = new ejwe(this, zfvg::_i, "");
                MinecraftForgeClient.registerItemRenderer(this.itemID, ejwe2);
                anoq._i._a(this.itemID, ejwe2);
            });
        }
    }

    @Override
    @ezey(_a={eidj.CLIENT})
    public void registerIcons(IconRegister iconRegister) {
        this.itemIcon = iconRegister._b("anomalies:bolt");
    }

    @Override
    @Nullable
    public EntityAdvancedThrowable _a(@NotNull ItemStack itemStack, @NotNull jxtc jxtc2, int n) {
        if (itemStack == null) {
            jgro._c(0);
        }
        if (jxtc2 == null) {
            jgro._c(1);
        }
        EntityLivingBase entityLivingBase = jxtc2._u();
        float f = 0.25f + 0.75f * ((float)n / (float)this._n());
        EntityBolt entityBolt = new EntityBolt(entityLivingBase.worldObj, entityLivingBase, f, this._l());
        if (entityLivingBase.worldObj.isRemote) {
            entityBolt.setAsFakeEntity();
        } else if (entityLivingBase instanceof EntityPlayer) {
            EntityPlayer entityPlayer = (EntityPlayer)entityLivingBase;
            InvokeSideOnly.frontend(() -> {});
        }
        entityLivingBase.worldObj.spawnEntityInWorld(entityBolt);
        return entityBolt;
    }

    private static /* synthetic */ void _c(int n) {
        Object[] objectArray;
        Object[] objectArray2 = new Object[3];
        switch (n) {
            default: {
                objectArray = objectArray2;
                objectArray2[0] = "itemStack";
                break;
            }
            case 1: {
                objectArray = objectArray2;
                objectArray2[0] = "user";
                break;
            }
        }
        objectArray[1] = "gloomyfolken/mods/anomaly/ItemBolt";
        objectArray[2] = "spawnThrownEntity";
        throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objectArray));
    }
}

