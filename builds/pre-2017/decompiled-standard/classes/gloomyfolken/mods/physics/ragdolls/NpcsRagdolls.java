/*
 * Decompiled with CFR 0.152.
 */
package gloomyfolken.mods.physics.ragdolls;

import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.registry.EntityRegistry;
import gloomyfolken.bundle.common.core.InvokeSideOnly;
import gloomyfolken.mods.core.misc.hank;
import gloomyfolken.mods.physics.core.PhysicsMod;
import gloomyfolken.mods.physics.ragdolls.NpcsRagdolls;
import gloomyfolken.mods.physics.ragdolls.RagdollsMod;
import gloomyfolken.mods.physics.ragdolls.entity.EntityCorpseNpc;
import gloomyfolken.mods.physics.ragdolls.entity.EntityRagdollCorpse;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.entity.Entity;
import noppes.npcs.CustomNpcs;
import noppes.npcs.entity.EntityNPCHumanMale;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={1, 1, 7}, bv={1, 0, 2}, k=1, d1={"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J*\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00042\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\t\u00a8\u0006\f"}, d2={"Lgloomyfolken/mods/physics/ragdolls/NpcsRagdolls;", "", "()V", "registerCustomNpcStuff", "", "event", "Lcpw/mods/fml/common/event/FMLInitializationEvent;", "typeEntityId", "corpseFactory", "Lgloomyfolken/mods/core/misc/NearestInstanceFunction;", "Lnet/minecraft/entity/Entity;", "Lgloomyfolken/mods/physics/ragdolls/entity/EntityRagdollCorpse;", "minecraft"})
public final class NpcsRagdolls {
    public static final NpcsRagdolls INSTANCE;

    public final int registerCustomNpcStuff(@NotNull FMLInitializationEvent fMLInitializationEvent, int n, @NotNull hank<Entity, EntityRagdollCorpse> hank2) {
        Intrinsics.checkParameterIsNotNull(fMLInitializationEvent, "event");
        Intrinsics.checkParameterIsNotNull(hank2, "corpseFactory");
        int n2 = n;
        CustomNpcs.spawnHumanCorpses = !RagdollsMod.getNoCorpses();
        EntityRegistry.registerModEntity(EntityCorpseNpc.class, "EntityCorpseNpc", n2++, RagdollsMod.instance, 64, 50, false);
        PhysicsMod.instance.registerStateFactory(EntityCorpseNpc.class, registerCustomNpcStuff.1.INSTANCE);
        hank2._a(EntityNPCHumanMale.class, registerCustomNpcStuff.2.INSTANCE);
        InvokeSideOnly.client(fMLInitializationEvent.getSide().isClient(), registerCustomNpcStuff.3.INSTANCE);
        return n2;
    }

    private NpcsRagdolls() {
        INSTANCE = this;
    }

    static {
        new NpcsRagdolls();
    }
}

