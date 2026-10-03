/*
 * Decompiled with CFR 0.152.
 */
package gloomyfolken.mods.physics.ragdolls.client;

import cpw.mods.fml.client.registry.RenderingRegistry;
import gloomyfolken.mods.core.misc.samo;
import gloomyfolken.mods.physics.ragdolls.RagdollsMod;
import gloomyfolken.mods.physics.ragdolls.client.ragdoll.CollisionModel;
import gloomyfolken.mods.physics.ragdolls.client.render.RenderCorpseAnimal;
import gloomyfolken.mods.physics.ragdolls.client.render.RenderCorpseBiped;
import gloomyfolken.mods.physics.ragdolls.client.render.RenderCorpseLeftovers;
import gloomyfolken.mods.physics.ragdolls.entity.EntityCorpseAnimal;
import gloomyfolken.mods.physics.ragdolls.entity.EntityCorpseBag;
import gloomyfolken.mods.physics.ragdolls.entity.EntityCorpsePlayer;
import gloomyfolken.mods.stalker.mobs.entity.MutantRegistry;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.src.ModLoader;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.MinecraftForge;
import noppes.npcs.entity.EntityNPCHumanMale;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={1, 1, 7}, bv={1, 0, 2}, k=1, d1={"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0006\u0010\t\u001a\u00020\nJ\b\u0010\u000b\u001a\u00020\nH\u0002J \u0010\f\u001a\u00020\n2\u000e\u0010\r\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00050\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002J\b\u0010\u0011\u001a\u00020\nH\u0002R\u001d\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b\u00a8\u0006\u0013"}, d2={"Lgloomyfolken/mods/physics/ragdolls/client/RagdollsClient;", "", "()V", "cache", "Lgloomyfolken/mods/core/misc/NearestInstanceAbstractFactory;", "Lnet/minecraft/entity/Entity;", "Lgloomyfolken/mods/physics/ragdolls/client/ragdoll/CollisionModel;", "getCache", "()Lgloomyfolken/mods/core/misc/NearestInstanceAbstractFactory;", "init", "", "registerNpcCorpse", "registerRagdoll", "clz", "Ljava/lang/Class;", "modelId", "", "registerRagdollAssets", "Companion", "minecraft"})
public final class RagdollsClient {
    @NotNull
    private final samo<Entity, CollisionModel> cache = new samo(Entity.class);
    public static final Companion Companion = new Companion(null);

    @NotNull
    public final samo<Entity, CollisionModel> getCache() {
        return this.cache;
    }

    public final void init() {
        RenderingRegistry.registerEntityRenderingHandler(EntityCorpseAnimal.class, new RenderCorpseAnimal());
        RenderingRegistry.registerEntityRenderingHandler(EntityCorpsePlayer.class, new RenderCorpseBiped());
        RenderingRegistry.registerEntityRenderingHandler(EntityCorpseBag.class, new RenderCorpseLeftovers());
        this.registerRagdollAssets();
    }

    private final void registerRagdollAssets() {
        Map map;
        Map map2 = map = (Map)MutantRegistry.INSTANCE.getRegisteredMobsInv();
        Iterator iterator2 = map2.entrySet().iterator();
        while (iterator2.hasNext()) {
            Map.Entry entry;
            Map.Entry entry2 = entry = iterator2.next();
            this.registerRagdoll((Class)entry2.getKey(), (String)entry2.getValue());
        }
        this.registerRagdoll(EntityPlayer.class, "steve");
        if (ModLoader.isModLoaded("customnpcs")) {
            this.registerNpcCorpse();
        }
    }

    private final void registerNpcCorpse() {
        this.registerRagdoll(EntityNPCHumanMale.class, "steve");
    }

    private final void registerRagdoll(Class<? extends Entity> clazz, String string) {
        CollisionModel collisionModel = new CollisionModel(new ResourceLocation("ragdolls:models/" + string + "/ragdoll.mcsa"));
        collisionModel.load(false);
        collisionModel.init();
        this.cache._a(clazz, collisionModel);
    }

    public RagdollsClient() {
        MinecraftForge.EVENT_BUS.register(this);
    }

    @NotNull
    public static final RagdollsClient getInstance() {
        return Companion.getInstance();
    }

    @Metadata(mv={1, 1, 7}, bv={1, 0, 2}, k=1, d1={"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u00048FX\u0087\u0004\u00a2\u0006\f\u0012\u0004\b\u0005\u0010\u0002\u001a\u0004\b\u0006\u0010\u0007\u00a8\u0006\b"}, d2={"Lgloomyfolken/mods/physics/ragdolls/client/RagdollsClient$Companion;", "", "()V", "instance", "Lgloomyfolken/mods/physics/ragdolls/client/RagdollsClient;", "instance$annotations", "getInstance", "()Lgloomyfolken/mods/physics/ragdolls/client/RagdollsClient;", "minecraft"})
    public static final class Companion {
        @JvmStatic
        public static /* synthetic */ void instance$annotations() {
        }

        @NotNull
        public final RagdollsClient getInstance() {
            RagdollsClient ragdollsClient = RagdollsMod.instance.ragdollsClient;
            Intrinsics.checkExpressionValueIsNotNull(ragdollsClient, "RagdollsMod.instance.ragdollsClient");
            return ragdollsClient;
        }

        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }
}

