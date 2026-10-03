/*
 * Decompiled with CFR 0.152.
 */
package gloomyfolken.mods.stalker.mobs.client;

import cpw.mods.fml.client.registry.ClientRegistry;
import gloomyfolken.bundle.common.core.eidj;
import gloomyfolken.bundle.common.core.ezey;
import gloomyfolken.mods.asm.GloomyLoadingPlugin;
import gloomyfolken.mods.core.main.ClientProxy;
import gloomyfolken.mods.effects.client.main.pidb;
import gloomyfolken.mods.effects.client.main.zwaw;
import gloomyfolken.mods.effects.client.mcsa.jxsn;
import gloomyfolken.mods.effects.client.mcsa.ugqi;
import gloomyfolken.mods.stalker.hud.kjui;
import gloomyfolken.mods.stalker.mobs.StalkerMobsHooks;
import gloomyfolken.mods.stalker.mobs.StalkerMobsMod;
import gloomyfolken.mods.stalker.mobs.client.render.DebugDrawInfo;
import gloomyfolken.mods.stalker.mobs.client.render.MutantsIconList;
import gloomyfolken.mods.stalker.mobs.client.tuning.gui.CaseEditor;
import gloomyfolken.mods.stalker.mobs.client.tuning.gui.MutantConfigEdit;
import gloomyfolken.mods.stalker.mobs.client.tuning.gui.RegionEdit;
import gloomyfolken.mods.stalker.mobs.client.tuning.gui.TextTransfer;
import gloomyfolken.mods.stalker.mobs.entity.EntityMutant;
import gloomyfolken.mods.stalker.mobs.entity.MutantRegistry;
import gloomyfolken.mods.stalker.mobs.entity.config.ConfigEditPermissions;
import gloomyfolken.mods.stalker.mobs.entity.config.ConfigJsonHelper;
import gloomyfolken.mods.stalker.mobs.entity.mutants.EntityKrovosos;
import gloomyfolken.mods.stalker.mobs.spawn.region.SpawnRegionEntry;
import gloomyfolken.mods.stalker.mobs.spawn.region.SpawnRegionReader;
import gloomyfolken.mods.stalker.mobs.tile.TileEntityMutantSpawner;
import gloomyfolken.mods.stalker.mobs.tile.TileEntityMutantSpawnerSpecial;
import java.io.File;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.EntityRenderer;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.ForgeSubscribe;
import org.apache.commons.io.FileUtils;
import org.jetbrains.annotations.NotNull;
import org.lwjgl.input.Keyboard;

@Metadata(mv={1, 1, 7}, bv={1, 0, 2}, k=1, d1={"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001aB\u0005\u00a2\u0006\u0002\u0010\u0002J\u0006\u0010\u000e\u001a\u00020\u000fJ\u0010\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u0012H\u0007J\b\u0010\u0013\u001a\u00020\u000fH\u0002J\u0010\u0010\u0014\u001a\u00020\u000f2\u0006\u0010\u0015\u001a\u00020\u0016H\u0007J\u0010\u0010\u0017\u001a\u00020\u000f2\u0006\u0010\u0015\u001a\u00020\u0018H\u0007J\u0006\u0010\u0019\u001a\u00020\u000fR\u0011\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R-\u0010\u0007\u001a\u001e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\bj\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n`\u000b\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r\u00a8\u0006\u001b"}, d2={"Lgloomyfolken/mods/stalker/mobs/client/StalkerMobsClient;", "", "()V", "debugInfo", "Lgloomyfolken/mods/stalker/mobs/client/render/DebugDrawInfo;", "getDebugInfo", "()Lgloomyfolken/mods/stalker/mobs/client/render/DebugDrawInfo;", "localRegionsData", "Ljava/util/HashMap;", "", "Lgloomyfolken/mods/stalker/mobs/spawn/region/SpawnRegionEntry;", "Lkotlin/collections/HashMap;", "getLocalRegionsData", "()Ljava/util/HashMap;", "init", "", "onGetCrosshairColor", "event", "Lgloomyfolken/mods/stalker/hud/GetCrosshairColorEvent;", "registerRenderers", "reloadBaseConfigs", "evt", "Lgloomyfolken/mods/effects/client/event/ReloadResourcesEvent;", "tick", "Lgloomyfolken/mods/core/event/TickEvent$ClientTickEvent;", "updateLocalRegionsData", "Companion", "minecraft"})
public final class StalkerMobsClient {
    @NotNull
    private final DebugDrawInfo debugInfo = new DebugDrawInfo();
    @NotNull
    private final HashMap<String, SpawnRegionEntry> localRegionsData;
    public static final Companion Companion = new Companion(null);

    @NotNull
    public final DebugDrawInfo getDebugInfo() {
        return this.debugInfo;
    }

    @NotNull
    public final HashMap<String, SpawnRegionEntry> getLocalRegionsData() {
        return this.localRegionsData;
    }

    @ForgeSubscribe
    public final void reloadBaseConfigs(@NotNull sbhn sbhn2) {
        Intrinsics.checkParameterIsNotNull(sbhn2, "evt");
        if (GloomyLoadingPlugin._a) {
            MutantRegistry.INSTANCE.reloadAllConfigs();
        }
    }

    @ForgeSubscribe
    public final void tick(@NotNull lnrm.kjui kjui2) {
        ItemStack itemStack;
        Intrinsics.checkParameterIsNotNull(kjui2, "evt");
        Minecraft minecraft = Minecraft._E();
        if (Intrinsics.areEqual((Object)kjui2._c, (Object)lnrm.pidb._b) && !minecraft._y && minecraft._t != null && minecraft._t.capabilities._d) {
            if (Keyboard.isKeyDown(25) && Keyboard.isKeyDown(29)) {
                MutantConfigEdit.openEditor(ConfigEditPermissions.ALL);
            }
            if (Keyboard.isKeyDown(24) && Keyboard.isKeyDown(29)) {
                RegionEdit.openEditor();
            }
            if (Keyboard.isKeyDown(53) && Keyboard.isKeyDown(29)) {
                CaseEditor.openEditor();
            }
            if (Keyboard.isKeyDown(48) && Keyboard.isKeyDown(29)) {
                zwaw._a(!zwaw._n());
            }
            if (Keyboard.isKeyDown(49) && Keyboard.isKeyDown(29)) {
                zwaw._c(!zwaw._r());
            }
            if (Keyboard.isKeyDown(50) && Keyboard.isKeyDown(29)) {
                boolean bl = EntityRenderer.useShader = !EntityRenderer.useShader;
            }
        }
        if (Intrinsics.areEqual((Object)kjui2._c, (Object)lnrm.pidb._b) && Minecraft._E()._B instanceof nuis && Keyboard.isKeyDown(46) && Keyboard.isKeyDown(29) && (itemStack = StalkerMobsHooks.getLastHoveredStack()) != null) {
            pzne pzne2 = new pzne(itemStack._d, itemStack._b, itemStack._f, itemStack._q(), 0, 1.0f);
            TextTransfer.getInstance().setClipboardContents(ConfigJsonHelper.Companion.write(pzne2));
        }
    }

    @ezey(_a={eidj.CLIENT})
    @ForgeSubscribe
    public final void onGetCrosshairColor(@NotNull kjui kjui2) {
        boolean bl;
        Intrinsics.checkParameterIsNotNull(kjui2, "event");
        if (kjui2._a != -1) {
            return;
        }
        Entity entity = ClientProxy.ticker._c;
        if (!(entity instanceof EntityMutant)) {
            entity = null;
        }
        EntityMutant entityMutant = (EntityMutant)entity;
        if (entityMutant == null) {
            return;
        }
        EntityMutant entityMutant2 = entityMutant;
        Minecraft minecraft = Minecraft._E();
        boolean bl2 = bl = entityMutant2 != RenderManager._b._j && !entityMutant2.isInvisibleToPlayer(minecraft._t) && entityMutant2.riddenByEntity == null;
        if (!bl) {
            return;
        }
        if (!(entityMutant2 instanceof EntityKrovosos) || ((EntityKrovosos)entityMutant2).getChameleon() <= 0.0) {
            kjui2._a = (int)0xFFFF0000L;
        }
    }

    public final void init() {
        this.registerRenderers();
        ugqi.register("krovosos", new ugqi(){

            protected void loadLocations(@NotNull jxsn jxsn2) {
                Intrinsics.checkParameterIsNotNull(jxsn2, "shader");
                jxsn2._c("chameleon");
            }

            protected String getFragmentUniformHook() {
                return srxe._b("/assets/stalkermobs/shaders/krovosos_invis_uniforms.fsh");
            }

            protected String getFragmentExitHook() {
                return srxe._b("/assets/stalkermobs/shaders/krovosos_invis.fsh");
            }
        });
        this.updateLocalRegionsData();
    }

    public final void updateLocalRegionsData() {
        this.localRegionsData.clear();
        try {
            File file = new File(StalkerMobsMod.instance.config.get("client", "regionsFileName", "").getString());
            String string = FileUtils.readFileToString(file);
            Intrinsics.checkExpressionValueIsNotNull(string, "FileUtils.readFileToString(file)");
            this.localRegionsData.putAll(SpawnRegionReader.readRegions$default(SpawnRegionReader.INSTANCE, string, null, 2, null));
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    private final void registerRenderers() {
        ClientRegistry.bindTileEntitySpecialRenderer(TileEntityMutantSpawner.class, new zfvd());
        ClientRegistry.bindTileEntitySpecialRenderer(TileEntityMutantSpawnerSpecial.class, new zfvd());
        pidb._a(new MutantsIconList());
    }

    public StalkerMobsClient() {
        StalkerMobsClient stalkerMobsClient = this;
        HashMap hashMap = new HashMap();
        stalkerMobsClient.localRegionsData = hashMap;
        MinecraftForge.EVENT_BUS.register(this);
    }

    @NotNull
    public static final StalkerMobsClient getInstance() {
        return Companion.getInstance();
    }

    @Metadata(mv={1, 1, 7}, bv={1, 0, 2}, k=1, d1={"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u00048FX\u0087\u0004\u00a2\u0006\f\u0012\u0004\b\u0005\u0010\u0002\u001a\u0004\b\u0006\u0010\u0007\u00a8\u0006\b"}, d2={"Lgloomyfolken/mods/stalker/mobs/client/StalkerMobsClient$Companion;", "", "()V", "instance", "Lgloomyfolken/mods/stalker/mobs/client/StalkerMobsClient;", "instance$annotations", "getInstance", "()Lgloomyfolken/mods/stalker/mobs/client/StalkerMobsClient;", "minecraft"})
    public static final class Companion {
        @JvmStatic
        public static /* synthetic */ void instance$annotations() {
        }

        @NotNull
        public final StalkerMobsClient getInstance() {
            StalkerMobsClient stalkerMobsClient = StalkerMobsMod.instance.stalkerMobsClient;
            Intrinsics.checkExpressionValueIsNotNull(stalkerMobsClient, "StalkerMobsMod.instance.stalkerMobsClient");
            return stalkerMobsClient;
        }

        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }
}

