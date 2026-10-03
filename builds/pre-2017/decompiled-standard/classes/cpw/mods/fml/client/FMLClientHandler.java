/*
 * Decompiled with CFR 0.152.
 */
package cpw.mods.fml.client;

import com.google.common.base.Throwables;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.MapDifference;
import com.google.common.collect.Maps;
import cpw.mods.fml.client.CustomModLoadingErrorDisplayException;
import cpw.mods.fml.client.GuiCustomModLoadingErrorScreen;
import cpw.mods.fml.client.GuiDupesFound;
import cpw.mods.fml.client.GuiIdMismatchScreen;
import cpw.mods.fml.client.GuiModsMissing;
import cpw.mods.fml.client.GuiModsMissingForServer;
import cpw.mods.fml.client.GuiSortingProblem;
import cpw.mods.fml.client.GuiWrongMinecraft;
import cpw.mods.fml.client.modloader.ModLoaderClientHelper;
import cpw.mods.fml.client.registry.KeyBindingRegistry;
import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.DummyModContainer;
import cpw.mods.fml.common.DuplicateModsFoundException;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.FMLLog;
import cpw.mods.fml.common.IFMLSidedHandler;
import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.LoaderException;
import cpw.mods.fml.common.MetadataCollection;
import cpw.mods.fml.common.MissingModsException;
import cpw.mods.fml.common.ModContainer;
import cpw.mods.fml.common.ModMetadata;
import cpw.mods.fml.common.ObfuscationReflectionHelper;
import cpw.mods.fml.common.WrongMinecraftVersionException;
import cpw.mods.fml.common.network.EntitySpawnAdjustmentPacket;
import cpw.mods.fml.common.network.EntitySpawnPacket;
import cpw.mods.fml.common.network.ModMissingPacket;
import cpw.mods.fml.common.registry.EntityRegistry;
import cpw.mods.fml.common.registry.GameData;
import cpw.mods.fml.common.registry.IEntityAdditionalSpawnData;
import cpw.mods.fml.common.registry.IThrowableEntity;
import cpw.mods.fml.common.registry.ItemData;
import cpw.mods.fml.common.toposort.ModSortingException;
import cpw.mods.fml.relauncher.Side;
import gloomyfolken.mods.asm.GloomyHooks;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.minecraft.client.xpzm;
import net.minecraft.crash.CrashReport;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.launchwrapper.Launch;

public class FMLClientHandler
implements IFMLSidedHandler {
    private static final FMLClientHandler INSTANCE = new FMLClientHandler();
    private xpzm client;
    private DummyModContainer optifineContainer;
    private boolean guiLoaded;
    private boolean serverIsRunning;
    private MissingModsException modsMissing;
    private ModSortingException modSorting;
    private boolean loading = true;
    private WrongMinecraftVersionException wrongMC;
    private CustomModLoadingErrorDisplayException customError;
    private DuplicateModsFoundException dupesFound;
    private boolean serverShouldBeKilledQuietly;
    private List<fnrl> resourcePackList;
    private ifzx resourceManager;
    private Map<String, fnrl> resourcePackMap;

    public void beginMinecraftLoading(xpzm xpzm2, List list2, ifzx ifzx2) {
        Map<String, String> map;
        HashMap<String, Object> hashMap;
        GloomyHooks.beginMinecraftLoading(this, xpzm2, list2, ifzx2);
        this.client = xpzm2;
        this.resourcePackList = list2;
        this.resourceManager = ifzx2;
        this.resourcePackMap = Maps.newHashMap();
        if (xpzm2._y()) {
            FMLLog.severe("DEMO MODE DETECTED, FML will not work. Finishing now.", new Object[0]);
            this.haltGame("FML will not run in demo mode", new RuntimeException());
            return;
        }
        FMLCommonHandler.instance().beginLoading(this);
        new ModLoaderClientHelper(this.client);
        try {
            hashMap = Class.forName("Config", false, Loader.instance().getModClassLoader());
            String string = (String)((Class)((Object)hashMap)).getField("VERSION").get(null);
            ImmutableMap<String, Object> object = ImmutableMap.builder().put("name", "Optifine").put("version", string).build();
            map = MetadataCollection.from(this.getClass().getResourceAsStream("optifinemod.info"), "optifine").getMetadataForId("optifine", object);
            this.optifineContainer = new DummyModContainer((ModMetadata)((Object)map));
            FMLLog.info("Forge Mod Loader has detected optifine %s, enabling compatibility features", this.optifineContainer.getVersion());
        }
        catch (Exception exception) {
            this.optifineContainer = null;
        }
        try {
            Loader.instance().loadMods();
        }
        catch (WrongMinecraftVersionException wrongMinecraftVersionException) {
            this.wrongMC = wrongMinecraftVersionException;
        }
        catch (DuplicateModsFoundException duplicateModsFoundException) {
            this.dupesFound = duplicateModsFoundException;
        }
        catch (MissingModsException missingModsException) {
            this.modsMissing = missingModsException;
        }
        catch (ModSortingException modSortingException) {
            this.modSorting = modSortingException;
        }
        catch (CustomModLoadingErrorDisplayException customModLoadingErrorDisplayException) {
            FMLLog.log(Level.SEVERE, customModLoadingErrorDisplayException, "A custom exception was thrown by a mod, the game will now halt", new Object[0]);
            this.customError = customModLoadingErrorDisplayException;
        }
        catch (LoaderException loaderException) {
            this.haltGame("There was a severe problem during mod loading that has caused the game to fail", loaderException);
            return;
        }
        hashMap = (Map)Launch.blackboard.get("modList");
        if (hashMap == null) {
            hashMap = Maps.newHashMap();
            Launch.blackboard.put("modList", hashMap);
        }
        for (ModContainer modContainer : Loader.instance().getActiveModList()) {
            map = modContainer.getSharedModDescriptor();
            if (map == null) continue;
            String string = "fml:" + modContainer.getModId();
            hashMap.put(string, map);
        }
    }

    @Override
    public void haltGame(String string, Throwable throwable) {
        this.client._b(new CrashReport(string, throwable));
        throw Throwables.propagate(throwable);
    }

    public void finishMinecraftLoading() {
        if (this.modsMissing != null || this.wrongMC != null || this.customError != null || this.dupesFound != null || this.modSorting != null) {
            return;
        }
        try {
            Loader.instance().initializeMods();
        }
        catch (CustomModLoadingErrorDisplayException customModLoadingErrorDisplayException) {
            FMLLog.log(Level.SEVERE, customModLoadingErrorDisplayException, "A custom exception was thrown by a mod, the game will now halt", new Object[0]);
            this.customError = customModLoadingErrorDisplayException;
            return;
        }
        catch (LoaderException loaderException) {
            this.haltGame("There was a severe problem during mod loading that has caused the game to fail", loaderException);
            return;
        }
        this.client._N._a = true;
        this.client._c();
        RenderingRegistry.instance().loadEntityRenderers(gqqu._b._a);
        this.loading = false;
        KeyBindingRegistry.instance().uploadKeyBindingsToGame(this.client._M);
    }

    public void extendModList() {
        Map map = (Map)Launch.blackboard.get("modList");
        if (map != null) {
            for (Map.Entry entry : map.entrySet()) {
                String string = (String)entry.getKey();
                String string2 = string.split(":")[0];
                if ("fml".equals(string2)) continue;
                Map map2 = (Map)entry.getValue();
                String string3 = (String)map2.get("modsystem");
                String string4 = (String)map2.get("id");
                String string5 = (String)map2.get("version");
                String string6 = (String)map2.get("name");
                String string7 = (String)map2.get("url");
                String string8 = (String)map2.get("authors");
                String string9 = (String)map2.get("description");
            }
        }
    }

    public void onInitializationComplete() {
        if (this.wrongMC != null) {
            this.client._a(new GuiWrongMinecraft(this.wrongMC));
        } else if (this.modsMissing != null) {
            this.client._a(new GuiModsMissing(this.modsMissing));
        } else if (this.dupesFound != null) {
            this.client._a(new GuiDupesFound(this.dupesFound));
        } else if (this.modSorting != null) {
            this.client._a(new GuiSortingProblem(this.modSorting));
        } else if (this.customError != null) {
            this.client._a(new GuiCustomModLoadingErrorScreen(this.customError));
        }
        sbnz._a();
        GloomyHooks.onInitializationComplete(this);
        sbnz._a(this);
        GloomyHooks.dumpClasses(this);
    }

    public xpzm getClient() {
        return this.client;
    }

    public Logger getMinecraftLogger() {
        return null;
    }

    public static FMLClientHandler instance() {
        return INSTANCE;
    }

    public void displayGuiScreen(EntityPlayer entityPlayer, gqjz gqjz2) {
        if (this.client._t == entityPlayer && gqjz2 != null) {
            this.client._a(gqjz2);
        }
    }

    public void addSpecialModEntries(ArrayList<ModContainer> arrayList) {
        if (this.optifineContainer != null) {
            arrayList.add(this.optifineContainer);
        }
    }

    @Override
    public List<String> getAdditionalBrandingInformation() {
        if (this.optifineContainer != null) {
            return Arrays.asList(String.format("Optifine %s", this.optifineContainer.getVersion()));
        }
        return ImmutableList.of();
    }

    @Override
    public Side getSide() {
        return Side.CLIENT;
    }

    public boolean hasOptifine() {
        return this.optifineContainer != null;
    }

    @Override
    public void showGuiScreen(Object object) {
        gqjz gqjz2 = (gqjz)object;
        this.client._a(gqjz2);
    }

    @Override
    public Entity spawnEntityIntoClientWorld(EntityRegistry.EntityRegistration entityRegistration, EntitySpawnPacket entitySpawnPacket) {
        pkix pkix2 = this.client._r;
        Class<? extends Entity> clazz = entityRegistration.getEntityClass();
        try {
            Entity entity;
            if (entityRegistration.hasCustomSpawning()) {
                entity = entityRegistration.doCustomSpawning(entitySpawnPacket);
            } else {
                Entity[] entityArray;
                entity = clazz.getConstructor(ozlu.class).newInstance(pkix2);
                int n = entitySpawnPacket.entityId - entity.field_70157_k;
                entity.field_70157_k = entitySpawnPacket.entityId;
                entity.func_70012_b(entitySpawnPacket.scaledX, entitySpawnPacket.scaledY, entitySpawnPacket.scaledZ, entitySpawnPacket.scaledYaw, entitySpawnPacket.scaledPitch);
                if (entity instanceof EntityLiving) {
                    ((EntityLiving)entity).field_70759_as = entitySpawnPacket.scaledHeadYaw;
                }
                if ((entityArray = entity.func_70021_al()) != null) {
                    for (int i = 0; i < entityArray.length; ++i) {
                        entityArray[i].field_70157_k += n;
                    }
                }
            }
            entity.field_70118_ct = entitySpawnPacket.rawX;
            entity.field_70117_cu = entitySpawnPacket.rawY;
            entity.field_70116_cv = entitySpawnPacket.rawZ;
            if (entity instanceof IThrowableEntity) {
                Entity entity2 = this.client._t.field_70157_k == entitySpawnPacket.throwerId ? this.client._t : pkix2.func_73045_a(entitySpawnPacket.throwerId);
                ((IThrowableEntity)((Object)entity)).setThrower(entity2);
            }
            if (entitySpawnPacket.metadata != null) {
                entity.func_70096_w()._a(entitySpawnPacket.metadata);
            }
            if (entitySpawnPacket.throwerId > 0) {
                entity.func_70016_h(entitySpawnPacket.speedScaledX, entitySpawnPacket.speedScaledY, entitySpawnPacket.speedScaledZ);
            }
            if (entity instanceof IEntityAdditionalSpawnData) {
                ((IEntityAdditionalSpawnData)((Object)entity)).readSpawnData(entitySpawnPacket.dataStream);
            }
            pkix2._a(entitySpawnPacket.entityId, entity);
            return entity;
        }
        catch (Exception exception) {
            FMLLog.log(Level.SEVERE, exception, "A severe problem occurred during the spawning of an entity", new Object[0]);
            throw Throwables.propagate(exception);
        }
    }

    @Override
    public void adjustEntityLocationOnClient(EntitySpawnAdjustmentPacket entitySpawnAdjustmentPacket) {
        Entity entity = this.client._r.func_73045_a(entitySpawnAdjustmentPacket.entityId);
        if (entity != null) {
            entity.field_70118_ct = entitySpawnAdjustmentPacket.serverX;
            entity.field_70117_cu = entitySpawnAdjustmentPacket.serverY;
            entity.field_70116_cv = entitySpawnAdjustmentPacket.serverZ;
        } else {
            FMLLog.fine("Attempted to adjust the position of entity %d which is not present on the client", entitySpawnAdjustmentPacket.entityId);
        }
    }

    @Override
    public void beginServerLoading(dzfd dzfd2) {
        this.serverShouldBeKilledQuietly = false;
    }

    @Override
    public void finishServerLoading() {
    }

    @Override
    public dzfd getServer() {
        return this.client._J();
    }

    @Override
    public void sendPacket(cezg cezg2) {
        if (this.client._t != null) {
            this.client._t.field_71174_a._b(cezg2);
        }
    }

    @Override
    public void displayMissingMods(ModMissingPacket modMissingPacket) {
        this.client._a(new GuiModsMissingForServer(modMissingPacket));
    }

    public boolean isLoading() {
        return this.loading;
    }

    @Override
    public void handleTinyPacket(elai elai2, yexp yexp2) {
        ((bscn)elai2)._a(yexp2);
    }

    @Override
    public void setClientCompatibilityLevel(byte by) {
        bscn._a(by);
    }

    @Override
    public byte getClientCompatibilityLevel() {
        return bscn._e();
    }

    public void warnIDMismatch(MapDifference<Integer, ItemData> mapDifference, boolean bl) {
        GuiIdMismatchScreen guiIdMismatchScreen = new GuiIdMismatchScreen(mapDifference, bl);
        this.client._a(guiIdMismatchScreen);
    }

    public void callbackIdDifferenceResponse(boolean bl) {
        if (bl) {
            this.serverShouldBeKilledQuietly = false;
            GameData.releaseGate(true);
            this.client._t();
        } else {
            this.serverShouldBeKilledQuietly = true;
            GameData.releaseGate(false);
            this.client._a((pkix)null);
            this.client._a((gqjz)null);
        }
    }

    @Override
    public boolean shouldServerShouldBeKilledQuietly() {
        return this.serverShouldBeKilledQuietly;
    }

    @Override
    public void disconnectIDMismatch(MapDifference<Integer, ItemData> mapDifference, elai elai2, jjpj jjpj2) {
        boolean bl = !mapDifference.entriesOnlyOnLeft().isEmpty();
        for (Map.Entry<Integer, MapDifference.ValueDifference<ItemData>> entry : mapDifference.entriesDiffering().entrySet()) {
            MapDifference.ValueDifference<ItemData> valueDifference = entry.getValue();
            if (valueDifference.leftValue().mayDifferByOrdinal(valueDifference.rightValue())) continue;
            bl = true;
        }
        if (!bl) {
            return;
        }
        ((bscn)elai2)._c();
        fnnc._i((fnnc)this.client._B);
        jjpj2._b();
        this.client._a((pkix)null);
        this.warnIDMismatch(mapDifference, false);
    }

    public boolean isGUIOpen(Class<? extends gqjz> clazz) {
        return this.client._B != null && this.client._B.getClass().equals(clazz);
    }

    @Override
    public void addModAsResource(ModContainer modContainer) {
        Class<?> clazz = modContainer.getCustomResourcePackClass();
        if (clazz != null) {
            try {
                fnrl fnrl2 = (fnrl)clazz.getConstructor(ModContainer.class).newInstance(modContainer);
                this.resourcePackList.add(fnrl2);
                this.resourcePackMap.put(modContainer.getModId(), fnrl2);
            }
            catch (NoSuchMethodException noSuchMethodException) {
                FMLLog.log(Level.SEVERE, "The container %s (type %s) returned an invalid class for it's resource pack.", modContainer.getName(), modContainer.getClass().getName());
                return;
            }
            catch (Exception exception) {
                FMLLog.log(Level.SEVERE, exception, "An unexpected exception occurred constructing the custom resource pack for %s", modContainer.getName());
                throw Throwables.propagate(exception);
            }
        }
    }

    @Override
    public void updateResourcePackList() {
        this.client._c();
    }

    public fnrl getResourcePackFor(String string) {
        return this.resourcePackMap.get(string);
    }

    @Override
    public String getCurrentLanguage() {
        return this.client._U()._c()._a();
    }

    @Override
    public void serverStopped() {
        dzfd dzfd2 = this.getServer();
        if (dzfd2 != null && !dzfd2.__ai()) {
            ObfuscationReflectionHelper.setPrivateValue(dzfd.class, dzfd2, Boolean.valueOf(true), "_R", "serverIsRunning");
        }
    }
}

