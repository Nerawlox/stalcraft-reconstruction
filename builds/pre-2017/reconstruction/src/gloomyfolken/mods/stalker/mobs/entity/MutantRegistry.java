/*
 * Decompiled with CFR 0.152.
 */
package gloomyfolken.mods.stalker.mobs.entity;

import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.registry.EntityRegistry;
import cpw.mods.fml.relauncher.Side;
import gloomyfolken.bundle.common.core.InvokeSideOnly;
import gloomyfolken.bundle.common.core.eidj;
import gloomyfolken.bundle.common.core.ezey;
import gloomyfolken.mods.asm.Logger;
import gloomyfolken.mods.core.misc.tdpx;
import gloomyfolken.mods.core.misc.uxqz;
import gloomyfolken.mods.effects.client.mcsa.kjui;
import gloomyfolken.mods.stalker.mobs.StalkerMobsMod;
import gloomyfolken.mods.stalker.mobs.client.render.RenderKrovosos;
import gloomyfolken.mods.stalker.mobs.client.render.RenderMutant;
import gloomyfolken.mods.stalker.mobs.entity.EntityMutant;
import gloomyfolken.mods.stalker.mobs.entity.config.MutantBaseConfig;
import gloomyfolken.mods.stalker.mobs.entity.mutants.EntityBoar;
import gloomyfolken.mods.stalker.mobs.entity.mutants.EntityCat;
import gloomyfolken.mods.stalker.mobs.entity.mutants.EntityChimera;
import gloomyfolken.mods.stalker.mobs.entity.mutants.EntityDog;
import gloomyfolken.mods.stalker.mobs.entity.mutants.EntityDoge;
import gloomyfolken.mods.stalker.mobs.entity.mutants.EntityFlesh;
import gloomyfolken.mods.stalker.mobs.entity.mutants.EntityKrovosos;
import gloomyfolken.mods.stalker.mobs.entity.mutants.EntityPseudodog;
import gloomyfolken.mods.stalker.mobs.entity.mutants.EntityPseudogigant;
import gloomyfolken.mods.stalker.mobs.entity.mutants.EntityPsidog;
import gloomyfolken.mods.stalker.mobs.entity.mutants.EntityPsidogClone;
import gloomyfolken.mods.stalker.mobs.entity.mutants.EntitySnork;
import gloomyfolken.mods.stalker.mobs.entity.mutants.EntityTushkan;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.util.ResourceLocation;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={1, 1, 7}, bv={1, 0, 2}, k=1, d1={"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013J(\u0010\u0014\u001a\u00020\u00112\u000e\u0010\u0015\u001a\n\u0012\u0006\b\u0001\u0012\u00020\t0\b2\u0006\u0010\u0016\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u0013H\u0002J \u0010\u0017\u001a\u00020\u00112\u000e\u0010\u0018\u001a\n\u0012\u0006\b\u0001\u0012\u00020\t0\b2\u0006\u0010\u0016\u001a\u00020\u0007H\u0007J\u0006\u0010\u0019\u001a\u00020\u0011J \u0010\u001a\u001a\u00020\u00112\u000e\u0010\u0018\u001a\n\u0012\u0006\b\u0001\u0012\u00020\t0\b2\u0006\u0010\u0016\u001a\u00020\u0007H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082D\u00a2\u0006\u0002\n\u0000R=\u0010\u0005\u001a.\u0012\u0004\u0012\u00020\u0007\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\t0\b0\u0006j\u0016\u0012\u0004\u0012\u00020\u0007\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\t0\b`\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR=\u0010\r\u001a.\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\t0\b\u0012\u0004\u0012\u00020\u00070\u0006j\u0016\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\t0\b\u0012\u0004\u0012\u00020\u0007`\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\fR\u000e\u0010\u000f\u001a\u00020\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001b"}, d2={"Lgloomyfolken/mods/stalker/mobs/entity/MutantRegistry;", "", "()V", "TRACKING_RANGE", "", "registeredMobs", "Ljava/util/HashMap;", "", "Ljava/lang/Class;", "Lgloomyfolken/mods/stalker/mobs/entity/EntityMutant;", "Lkotlin/collections/HashMap;", "getRegisteredMobs", "()Ljava/util/HashMap;", "registeredMobsInv", "getRegisteredMobsInv", "typeEntityId", "initRegistry", "", "side", "Lcpw/mods/fml/relauncher/Side;", "registerMob", "clazz", "name", "registerMobRenderer", "clz", "reloadAllConfigs", "storeMobConfigFromFile", "minecraft"})
public final class MutantRegistry {
    private static final int TRACKING_RANGE = 64;
    @NotNull
    private static final HashMap<String, Class<? extends EntityMutant>> registeredMobs;
    @NotNull
    private static final HashMap<Class<? extends EntityMutant>, String> registeredMobsInv;
    private static int typeEntityId;
    public static final MutantRegistry INSTANCE;

    @NotNull
    public final HashMap<String, Class<? extends EntityMutant>> getRegisteredMobs() {
        return registeredMobs;
    }

    @NotNull
    public final HashMap<Class<? extends EntityMutant>, String> getRegisteredMobsInv() {
        return registeredMobsInv;
    }

    public final void initRegistry(@NotNull Side side) {
        Map map;
        Object object;
        Object object2;
        Object object3;
        Map.Entry entry;
        Intrinsics.checkParameterIsNotNull((Object)side, "side");
        this.registerMob(EntityDog.class, "dog", side);
        this.registerMob(EntityCat.class, "cat", side);
        this.registerMob(EntityBoar.class, "boar", side);
        this.registerMob(EntityDoge.class, "doge", side);
        this.registerMob(EntityFlesh.class, "flesh", side);
        this.registerMob(EntityPsidog.class, "psidog", side);
        this.registerMob(EntityPseudodog.class, "pseudodog", side);
        this.registerMob(EntityPsidogClone.class, "psidog_clone", side);
        this.registerMob(EntityChimera.class, "chimera", side);
        this.registerMob(EntitySnork.class, "snork", side);
        this.registerMob(EntityKrovosos.class, "krovosos", side);
        this.registerMob(EntityPseudogigant.class, "pseudogigant", side);
        this.registerMob(EntityTushkan.class, "tushkan", side);
        Map map2 = registeredMobs;
        HashMap<Class<? extends EntityMutant>, String> hashMap = registeredMobsInv;
        Map map3 = map2;
        Map map4 = new LinkedHashMap(MapsKt.mapCapacity(map2.size()));
        Iterable iterable = map3.entrySet();
        for (Object t : iterable) {
            entry = (Map.Entry)t;
            Map map5 = map4;
            object3 = entry.getKey();
            object2 = (Map.Entry)t;
            object = object3;
            map = map5;
            String string = (String)object2.getKey();
            map.put(object, string);
        }
        map3 = map2 = (map = map4);
        map4 = new LinkedHashMap(MapsKt.mapCapacity(map2.size()));
        iterable = map3.entrySet();
        for (Object t : iterable) {
            entry = (Map.Entry)t;
            map = map4;
            if (registeredMobs.get(entry.getValue()) == null) {
                Intrinsics.throwNpe();
            }
            object3 = (Map.Entry)t;
            object2 = object;
            Map map6 = map;
            Object v = object3.getValue();
            map6.put(object2, v);
        }
        map = map4;
        hashMap.putAll(map);
    }

    private final void registerMob(Class<? extends EntityMutant> clazz, String string, Side side) {
        try {
            this.storeMobConfigFromFile(clazz, string);
            EntityRegistry.registerModEntity(clazz, string, typeEntityId, StalkerMobsMod.instance, TRACKING_RANGE, 1, true);
            if (Intrinsics.areEqual((Object)side, (Object)Side.CLIENT)) {
                InvokeSideOnly.client(new InvokeSideOnly.InvokeClientOnly(clazz, string){
                    final /* synthetic */ Class $clazz;
                    final /* synthetic */ String $name;

                    public final void run() {
                        MutantRegistry.INSTANCE.registerMobRenderer(this.$clazz, this.$name);
                    }
                    {
                        this.$clazz = clazz;
                        this.$name = string;
                    }
                });
            }
            registeredMobs.putIfAbsent(string, clazz);
            Logger.info(string + " registered with id %d", typeEntityId);
            int n = typeEntityId;
            typeEntityId = n + 1;
        }
        catch (IOException iOException) {
            iOException.printStackTrace();
        }
    }

    public final void reloadAllConfigs() {
        Map map;
        Map map2 = map = (Map)registeredMobs;
        Iterator iterator2 = map2.entrySet().iterator();
        while (iterator2.hasNext()) {
            Map.Entry entry;
            Map.Entry entry2 = entry = iterator2.next();
            INSTANCE.storeMobConfigFromFile((Class)entry2.getValue(), (String)entry2.getKey());
        }
    }

    private final void storeMobConfigFromFile(Class<? extends EntityMutant> clazz, String string) {
        String string2 = tdpx._b(new ResourceLocation("stalkermobs", "configs/base_" + string + ".smm"));
        MutantBaseConfig mutantBaseConfig = uxqz._a(string2, MutantBaseConfig.class);
        mutantBaseConfig.create();
        MutantBaseConfig.Companion.getMobConfigurations().put(clazz, mutantBaseConfig);
    }

    @ezey(_a={eidj.CLIENT})
    public final void registerMobRenderer(@NotNull Class<? extends EntityMutant> clazz, @NotNull String string) {
        Intrinsics.checkParameterIsNotNull(clazz, "clz");
        Intrinsics.checkParameterIsNotNull(string, "name");
        if (Intrinsics.areEqual(clazz, EntityKrovosos.class)) {
            RenderingRegistry.registerEntityRenderingHandler(clazz, new RenderKrovosos());
        } else {
            RenderingRegistry.registerEntityRenderingHandler(clazz, new RenderMutant());
        }
        kjui kjui2 = new kjui("/assets/stalkermobs/models/" + string + '/' + string + ".mcsa");
        RenderMutant.Companion.getMobToRendererMap().put(clazz, kjui2);
    }

    private MutantRegistry() {
        INSTANCE = this;
        TRACKING_RANGE = 64;
        registeredMobs = new HashMap();
        registeredMobsInv = new HashMap();
    }

    static {
        new MutantRegistry();
    }
}

