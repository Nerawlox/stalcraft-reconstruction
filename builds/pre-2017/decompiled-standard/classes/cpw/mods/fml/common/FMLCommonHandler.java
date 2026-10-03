/*
 * Decompiled with CFR 0.152.
 */
package cpw.mods.fml.common;

import com.google.common.base.Joiner;
import com.google.common.base.Objects;
import com.google.common.base.Strings;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import com.google.common.collect.MapDifference;
import com.google.common.collect.MapMaker;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import cpw.mods.fml.common.FMLLog;
import cpw.mods.fml.common.ICrashCallable;
import cpw.mods.fml.common.IFMLSidedHandler;
import cpw.mods.fml.common.IScheduledTickHandler;
import cpw.mods.fml.common.InjectedModContainer;
import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.ModContainer;
import cpw.mods.fml.common.ObfuscationReflectionHelper;
import cpw.mods.fml.common.TickType;
import cpw.mods.fml.common.WorldAccessContainer;
import cpw.mods.fml.common.network.EntitySpawnAdjustmentPacket;
import cpw.mods.fml.common.network.EntitySpawnPacket;
import cpw.mods.fml.common.registry.EntityRegistry;
import cpw.mods.fml.common.registry.ItemData;
import cpw.mods.fml.common.registry.TickRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.server.FMLServerHandler;
import gloomyfolken.mods.asm.GloomyHooks;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.minecraft.crash.CrashReport;
import net.minecraft.crash.jxsn;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;

public class FMLCommonHandler {
    private static final FMLCommonHandler INSTANCE = new FMLCommonHandler();
    private IFMLSidedHandler sidedDelegate;
    private List<IScheduledTickHandler> scheduledClientTicks = Lists.newArrayList();
    private List<IScheduledTickHandler> scheduledServerTicks = Lists.newArrayList();
    private Class<?> forge;
    private boolean noForge;
    private List<String> brandings;
    private List<ICrashCallable> crashCallables = Lists.newArrayList(Loader.instance().getCallableCrashInformation());
    private Set<plxv> handlerSet = Sets.newSetFromMap(new MapMaker().weakKeys().makeMap());

    public void beginLoading(IFMLSidedHandler iFMLSidedHandler) {
        this.sidedDelegate = iFMLSidedHandler;
        FMLLog.log("MinecraftForge", Level.INFO, "Attempting early MinecraftForge initialization", new Object[0]);
        this.callForgeMethod("initialize");
        this.callForgeMethod("registerCrashCallable");
        FMLLog.log("MinecraftForge", Level.INFO, "Completed early MinecraftForge initialization", new Object[0]);
    }

    public void rescheduleTicks(Side side) {
        TickRegistry.updateTickQueue(side.isClient() ? this.scheduledClientTicks : this.scheduledServerTicks, side);
    }

    public void tickStart(EnumSet<TickType> enumSet, Side side, Object ... objectArray) {
        List<IScheduledTickHandler> list;
        List<IScheduledTickHandler> list2 = list = side.isClient() ? this.scheduledClientTicks : this.scheduledServerTicks;
        if (list.size() == 0) {
            return;
        }
        for (IScheduledTickHandler iScheduledTickHandler : list) {
            EnumSet<TickType> enumSet2 = EnumSet.copyOf(Objects.firstNonNull(iScheduledTickHandler.ticks(), EnumSet.noneOf(TickType.class)));
            enumSet2.retainAll(enumSet);
            if (enumSet2.isEmpty()) continue;
            iScheduledTickHandler.tickStart(enumSet2, objectArray);
        }
    }

    public void tickEnd(EnumSet<TickType> enumSet, Side side, Object ... objectArray) {
        List<IScheduledTickHandler> list;
        List<IScheduledTickHandler> list2 = list = side.isClient() ? this.scheduledClientTicks : this.scheduledServerTicks;
        if (list.size() == 0) {
            return;
        }
        for (IScheduledTickHandler iScheduledTickHandler : list) {
            EnumSet<TickType> enumSet2 = EnumSet.copyOf(Objects.firstNonNull(iScheduledTickHandler.ticks(), EnumSet.noneOf(TickType.class)));
            enumSet2.retainAll(enumSet);
            if (enumSet2.isEmpty()) continue;
            iScheduledTickHandler.tickEnd(enumSet2, objectArray);
        }
    }

    public static FMLCommonHandler instance() {
        return INSTANCE;
    }

    public ModContainer findContainerFor(Object object) {
        return (ModContainer)Loader.instance().getReversedModObjectList().get(object);
    }

    public Logger getFMLLogger() {
        return FMLLog.getLogger();
    }

    public Side getSide() {
        return this.sidedDelegate.getSide();
    }

    public Side getEffectiveSide() {
        Thread thread = Thread.currentThread();
        if (thread instanceof vmwi || thread instanceof zibx) {
            return Side.SERVER;
        }
        return Side.CLIENT;
    }

    public void raiseException(Throwable throwable, String string, boolean bl) {
        FMLLog.log(Level.SEVERE, throwable, "Something raised an exception. The message was '%s'. 'stopGame' is %b", string, bl);
        if (bl) {
            this.getSidedDelegate().haltGame(string, throwable);
        }
    }

    private Class<?> findMinecraftForge() {
        if (this.forge == null && !this.noForge) {
            try {
                this.forge = Class.forName("net.minecraftforge.common.MinecraftForge");
            }
            catch (Exception exception) {
                this.noForge = true;
            }
        }
        return this.forge;
    }

    private Object callForgeMethod(String string) {
        if (this.noForge) {
            return null;
        }
        try {
            return this.findMinecraftForge().getMethod(string, new Class[0]).invoke(null, new Object[0]);
        }
        catch (Exception exception) {
            return null;
        }
    }

    public void computeBranding() {
        if (this.brandings == null) {
            ImmutableList.Builder builder = ImmutableList.builder();
            builder.add(Loader.instance().getMCVersionString());
            builder.add(Loader.instance().getMCPVersionString());
            builder.add("FML v" + Loader.instance().getFMLVersionString());
            String string = (String)this.callForgeMethod("getBrandingVersion");
            if (!Strings.isNullOrEmpty(string)) {
                builder.add(string);
            }
            if (this.sidedDelegate != null) {
                builder.addAll(this.sidedDelegate.getAdditionalBrandingInformation());
            }
            if (Loader.instance().getFMLBrandingProperties().containsKey("fmlbranding")) {
                builder.add(Loader.instance().getFMLBrandingProperties().get("fmlbranding"));
            }
            int n = Loader.instance().getModList().size();
            int n2 = Loader.instance().getActiveModList().size();
            builder.add(String.format("%d mod%s loaded, %d mod%s active", n, n != 1 ? "s" : "", n2, n2 != 1 ? "s" : ""));
            this.brandings = builder.build();
        }
    }

    public List<String> getBrandings() {
        if (this.brandings == null) {
            this.computeBranding();
        }
        return ImmutableList.copyOf(this.brandings);
    }

    public IFMLSidedHandler getSidedDelegate() {
        return this.sidedDelegate;
    }

    public void onPostServerTick() {
        this.tickEnd(EnumSet.of(TickType.SERVER), Side.SERVER, new Object[0]);
    }

    public void onPostWorldTick(Object object) {
        this.tickEnd(EnumSet.of(TickType.WORLD), Side.SERVER, object);
    }

    public void onPreServerTick() {
        this.tickStart(EnumSet.of(TickType.SERVER), Side.SERVER, new Object[0]);
    }

    public void onPreWorldTick(Object object) {
        this.tickStart(EnumSet.of(TickType.WORLD), Side.SERVER, object);
    }

    public void onWorldLoadTick(ozlu[] ozluArray) {
        this.rescheduleTicks(Side.SERVER);
        for (ozlu ozlu2 : ozluArray) {
            this.tickStart(EnumSet.of(TickType.WORLDLOAD), Side.SERVER, ozlu2);
        }
    }

    public boolean handleServerAboutToStart(dzfd dzfd2) {
        return Loader.instance().serverAboutToStart(dzfd2);
    }

    public boolean handleServerStarting(dzfd dzfd2) {
        return Loader.instance().serverStarting(dzfd2);
    }

    public void handleServerStarted() {
        Loader.instance().serverStarted();
    }

    public void handleServerStopping() {
        Loader.instance().serverStopping();
    }

    public dzfd getMinecraftServerInstance() {
        return this.sidedDelegate.getServer();
    }

    public void showGuiScreen(Object object) {
        this.sidedDelegate.showGuiScreen(object);
    }

    public Entity spawnEntityIntoClientWorld(EntityRegistry.EntityRegistration entityRegistration, EntitySpawnPacket entitySpawnPacket) {
        return this.sidedDelegate.spawnEntityIntoClientWorld(entityRegistration, entitySpawnPacket);
    }

    public void adjustEntityLocationOnClient(EntitySpawnAdjustmentPacket entitySpawnAdjustmentPacket) {
        this.sidedDelegate.adjustEntityLocationOnClient(entitySpawnAdjustmentPacket);
    }

    public void onServerStart(ujth ujth2) {
        FMLServerHandler.instance();
        this.sidedDelegate.beginServerLoading(ujth2);
    }

    public void onServerStarted() {
        this.sidedDelegate.finishServerLoading();
    }

    public void onPreClientTick() {
        GloomyHooks.onPreClientTick(this);
        this.tickStart(EnumSet.of(TickType.CLIENT), Side.CLIENT, new Object[0]);
    }

    public void onPostClientTick() {
        this.tickEnd(EnumSet.of(TickType.CLIENT), Side.CLIENT, new Object[0]);
    }

    public void onRenderTickStart(float f) {
        this.tickStart(EnumSet.of(TickType.RENDER), Side.CLIENT, Float.valueOf(f));
    }

    public void onRenderTickEnd(float f) {
        this.tickEnd(EnumSet.of(TickType.RENDER), Side.CLIENT, Float.valueOf(f));
    }

    public void onPlayerPreTick(EntityPlayer entityPlayer) {
        Side side = entityPlayer instanceof EntityPlayerMP ? Side.SERVER : Side.CLIENT;
        this.tickStart(EnumSet.of(TickType.PLAYER), side, entityPlayer);
    }

    public void onPlayerPostTick(EntityPlayer entityPlayer) {
        Side side = entityPlayer instanceof EntityPlayerMP ? Side.SERVER : Side.CLIENT;
        this.tickEnd(EnumSet.of(TickType.PLAYER), side, entityPlayer);
    }

    public void registerCrashCallable(ICrashCallable iCrashCallable) {
        this.crashCallables.add(iCrashCallable);
    }

    public void enhanceCrashReport(CrashReport crashReport, jxsn jxsn2) {
        for (ICrashCallable iCrashCallable : this.crashCallables) {
            jxsn2._a(iCrashCallable.getLabel(), iCrashCallable);
        }
    }

    public void handleTinyPacket(elai elai2, yexp yexp2) {
        this.sidedDelegate.handleTinyPacket(elai2, yexp2);
    }

    public void handleWorldDataSave(plxv plxv2, iyev iyev2, qoac qoac2) {
        for (ModContainer modContainer : Loader.instance().getModList()) {
            WorldAccessContainer worldAccessContainer;
            if (!(modContainer instanceof InjectedModContainer) || (worldAccessContainer = ((InjectedModContainer)modContainer).getWrappedWorldAccessContainer()) == null) continue;
            qoac qoac3 = worldAccessContainer.getDataForWriting(plxv2, iyev2);
            qoac2._a(modContainer.getModId(), qoac3);
        }
    }

    public void handleWorldDataLoad(plxv plxv2, iyev iyev2, qoac qoac2) {
        if (this.getEffectiveSide() != Side.SERVER) {
            return;
        }
        if (this.handlerSet.contains(plxv2)) {
            return;
        }
        this.handlerSet.add(plxv2);
        HashMap<String, huhy> hashMap = Maps.newHashMap();
        iyev2._a(hashMap);
        for (ModContainer modContainer : Loader.instance().getModList()) {
            WorldAccessContainer worldAccessContainer;
            if (!(modContainer instanceof InjectedModContainer) || (worldAccessContainer = ((InjectedModContainer)modContainer).getWrappedWorldAccessContainer()) == null) continue;
            worldAccessContainer.readData(plxv2, iyev2, hashMap, qoac2._m(modContainer.getModId()));
        }
    }

    public boolean shouldServerBeKilledQuietly() {
        if (this.sidedDelegate == null) {
            return false;
        }
        return this.sidedDelegate.shouldServerShouldBeKilledQuietly();
    }

    public void disconnectIDMismatch(MapDifference<Integer, ItemData> mapDifference, elai elai2, jjpj jjpj2) {
        this.sidedDelegate.disconnectIDMismatch(mapDifference, elai2, jjpj2);
    }

    public void handleServerStopped() {
        this.sidedDelegate.serverStopped();
        dzfd dzfd2 = this.getMinecraftServerInstance();
        Loader.instance().serverStopped();
        if (dzfd2 != null) {
            ObfuscationReflectionHelper.setPrivateValue(dzfd.class, dzfd2, Boolean.valueOf(false), "_m", "u", "serverStopped");
        }
    }

    public String getModName() {
        ArrayList<String> arrayList = Lists.newArrayListWithExpectedSize(3);
        arrayList.add("fml");
        if (!this.noForge) {
            arrayList.add("forge");
        }
        if (Loader.instance().getFMLBrandingProperties().containsKey("snooperbranding")) {
            arrayList.add(Loader.instance().getFMLBrandingProperties().get("snooperbranding"));
        }
        return Joiner.on(',').join(arrayList);
    }

    public void addModToResourcePack(ModContainer modContainer) {
        this.sidedDelegate.addModAsResource(modContainer);
    }

    public void updateResourcePackList() {
        this.sidedDelegate.updateResourcePackList();
    }

    public String getCurrentLanguage() {
        return this.sidedDelegate.getCurrentLanguage();
    }
}

