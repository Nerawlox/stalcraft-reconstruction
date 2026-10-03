/*
 * Decompiled with CFR 0.152.
 */
package gloomyfolken.mods.stalker.mobs.entity.mutants;

import gloomyfolken.bundle.common.core.InvokeSideOnly;
import gloomyfolken.mods.effects.client.main.pidb;
import gloomyfolken.mods.ktcore.McExtensionsKt;
import gloomyfolken.mods.ktcore.VecExtensionsKt;
import gloomyfolken.mods.stalker.mobs.client.render.particlesystems.DogeDeathEffect;
import gloomyfolken.mods.stalker.mobs.entity.EntityMutant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.util.jxtc;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={1, 1, 7}, bv={1, 0, 2}, k=1, d1={"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0006H\u0016J\u0012\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016\u00a8\u0006\u000b"}, d2={"Lgloomyfolken/mods/stalker/mobs/entity/mutants/EntityDoge;", "Lgloomyfolken/mods/stalker/mobs/entity/EntityMutant;", "par1World", "Lnet/minecraft/world/World;", "(Lnet/minecraft/world/World;)V", "getEntityName", "", "onDeath", "", "par1DamageSource", "Lnet/minecraft/util/DamageSource;", "minecraft"})
public final class EntityDoge
extends EntityMutant {
    @Override
    @NotNull
    public String func_70023_ak() {
        return "\u0418\u0433\u043e\u0440\u044c \u043f\u0451\u0441";
    }

    @Override
    public void func_70645_a(@Nullable jxtc jxtc2) {
        super.func_70645_a(jxtc2);
        InvokeSideOnly.client(this.field_70170_p.field_72995_K, new InvokeSideOnly.InvokeClientOnly(this){
            final /* synthetic */ EntityDoge this$0;

            public final void run() {
                ozlu ozlu2 = this.this$0.field_70170_p;
                Intrinsics.checkExpressionValueIsNotNull(ozlu2, "worldObj");
                pidb._a(new DogeDeathEffect(ozlu2, VecExtensionsKt.add(McExtensionsKt.getPos(this.this$0), 0.0, 3.25, 0.0)));
            }
            {
                this.this$0 = entityDoge;
            }
        });
    }

    public EntityDoge(@NotNull ozlu ozlu2) {
        Intrinsics.checkParameterIsNotNull(ozlu2, "par1World");
        super(ozlu2);
    }
}

