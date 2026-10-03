/*
 * Decompiled with CFR 0.152.
 */
package gloomyfolken.mods.stalker.mobs.entity.config;

import gloomyfolken.mods.asm.FileWriteBlocker;
import gloomyfolken.mods.asm.Logger;
import gloomyfolken.mods.stalker.mobs.StalkerMobsMod;
import gloomyfolken.mods.stalker.mobs.entity.config.ConfigJsonHelper;
import gloomyfolken.mods.stalker.mobs.entity.config.MutantConfiguration;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.io.FilesKt;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.apache.commons.io.FileUtils;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={1, 1, 7}, bv={1, 0, 2}, k=1, d1={"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0010$\n\u0002\b\u0006\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001bB\u0005\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\nJ\u0016\u0010\u000b\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\nJ\u0010\u0010\u000f\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\nH\u0007J\u0018\u0010\u000f\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\nH\u0007J\u0006\u0010\u0010\u001a\u00020\fJ\u0006\u0010\u0011\u001a\u00020\fJ\u000e\u0010\u0012\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\tJ\u0010\u0010\u0013\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\tH\u0007J\u000e\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\tJ\u0012\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\u0016J\u0012\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\u0016J\u0010\u0010\u0018\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000e\u001a\u00020\tJ\u0006\u0010\u0019\u001a\u00020\fJ\b\u0010\u001a\u001a\u00020\fH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001c"}, d2={"Lgloomyfolken/mods/stalker/mobs/entity/config/MutantConfigHelper;", "", "()V", "configsDir", "Ljava/io/File;", "isDirty", "", "mobConfigurations", "Ljava/util/HashMap;", "", "Lgloomyfolken/mods/stalker/mobs/entity/config/MutantConfiguration;", "addMobConfig", "", "config", "name", "addMobConfigRemote", "clearAndDumpAllConfigs", "clearMobConfigs", "deleteMobConfig", "deleteMobConfigRemote", "dumpConfig", "getEditableMobConfigs", "", "getMobConfigs", "getMobConfiguration", "resetAndReadAllMobConfigs", "sendMobConfigsToPlayers", "Companion", "minecraft"})
public final class MutantConfigHelper {
    private final HashMap<String, MutantConfiguration> mobConfigurations = new HashMap();
    private final File configsDir = new File(StalkerMobsMod.getWorldSaveDirectory(), "configs");
    private boolean isDirty;
    @JvmField
    @NotNull
    public static final MutantConfigHelper CLIENT;
    @JvmField
    @NotNull
    public static final MutantConfigHelper SERVER;
    public static final Companion Companion;

    public final void clearMobConfigs() {
        this.mobConfigurations.clear();
    }

    public final void addMobConfig(@NotNull MutantConfiguration mutantConfiguration) {
        Intrinsics.checkParameterIsNotNull(mutantConfiguration, "config");
        this.addMobConfig(mutantConfiguration.getCommon().getName(), mutantConfiguration);
    }

    public final void addMobConfig(@NotNull String string, @NotNull MutantConfiguration mutantConfiguration) {
        Intrinsics.checkParameterIsNotNull(string, "name");
        Intrinsics.checkParameterIsNotNull(mutantConfiguration, "config");
        mutantConfiguration.getCommon().setName(string);
        this.mobConfigurations.put(string, mutantConfiguration);
        this.isDirty = true;
    }

    public final void deleteMobConfig(@NotNull String string) {
        Intrinsics.checkParameterIsNotNull(string, "name");
        this.mobConfigurations.remove(string);
    }

    @NotNull
    public final Map<String, MutantConfiguration> getMobConfigs() {
        return this.mobConfigurations;
    }

    @NotNull
    public final Map<String, MutantConfiguration> getEditableMobConfigs() {
        Map map;
        Map map2 = map = (Map)this.mobConfigurations;
        Map map3 = new LinkedHashMap();
        Map map4 = map2;
        for (Map.Entry entry : map4.entrySet()) {
            Map.Entry entry2 = entry;
            if (!(StringsKt.contains$default((CharSequence)entry2.getKey(), "#@", false, 2, null) ^ true)) continue;
            map3.put(entry.getKey(), entry.getValue());
        }
        return map3;
    }

    @Nullable
    public final MutantConfiguration getMobConfiguration(@NotNull String string) {
        Intrinsics.checkParameterIsNotNull(string, "name");
        return this.mobConfigurations.get(string);
    }

    public final boolean dumpConfig(@NotNull String string) {
        Intrinsics.checkParameterIsNotNull(string, "name");
        if (FileWriteBlocker._a) {
            return false;
        }
        MutantConfiguration mutantConfiguration = this.mobConfigurations.get(string);
        if (mutantConfiguration == null) {
            return false;
        }
        MutantConfiguration mutantConfiguration2 = mutantConfiguration;
        File file = new File(this.configsDir, "" + string + ".json");
        MutantConfiguration mutantConfiguration3 = mutantConfiguration2;
        Intrinsics.checkExpressionValueIsNotNull(mutantConfiguration3, "config");
        FileUtils.writeStringToFile(file, ConfigJsonHelper.Companion.write(mutantConfiguration3));
        return true;
    }

    public final void clearAndDumpAllConfigs() {
        Object object;
        Object object2;
        if (FileWriteBlocker._a) {
            return;
        }
        Object object3 = this.configsDir.listFiles();
        Object[] objectArray = object3;
        if (object3 == null) {
            objectArray = new File[]{};
        }
        object3 = objectArray;
        for (int i = 0; i < ((Object[])object3).length; ++i) {
            object2 = object3[i];
            object = (File)object2;
            if (!Intrinsics.areEqual(FilesKt.getExtension((File)object), "json")) continue;
            ((File)object).delete();
        }
        Object object4 = object3 = (Iterable)this.mobConfigurations.keySet();
        object2 = new ArrayList();
        object = object4.iterator();
        while (object.hasNext()) {
            Object e = object.next();
            String string = (String)e;
            if (!(!StringsKt.contains$default((CharSequence)string, "#@", false, 2, null))) continue;
            object2.add(e);
        }
        object3 = (List)object2;
        object4 = object3.iterator();
        while (object4.hasNext()) {
            object2 = object4.next();
            Object object5 = object = (String)object2;
            Intrinsics.checkExpressionValueIsNotNull(object5, "name");
            this.dumpConfig((String)object5);
        }
    }

    public final void resetAndReadAllMobConfigs() {
        Object[] objectArray;
        this.clearMobConfigs();
        Object[] objectArray2 = objectArray = (Object[])this.configsDir.listFiles();
        if (objectArray == null) {
            objectArray2 = new File[]{};
        }
        objectArray = objectArray2;
        for (int i = 0; i < objectArray.length; ++i) {
            Object object = objectArray[i];
            File file = (File)object;
            if (!Intrinsics.areEqual(FilesKt.getExtension(file), "json")) continue;
            String string = FilesKt.getNameWithoutExtension(file);
            try {
                String string2 = FileUtils.readFileToString(file);
                Intrinsics.checkExpressionValueIsNotNull(string2, "FileUtils.readFileToString(file)");
                this.addMobConfig(string, ConfigJsonHelper.Companion.read(string2, MutantConfiguration.class));
                continue;
            }
            catch (Exception exception) {
                Logger.severe("Error during reading mob configuration at '" + string + "', aborting operation.", new Object[0]);
                exception.printStackTrace();
            }
        }
    }

    public MutantConfigHelper() {
        if (!FileWriteBlocker._a) {
            this.configsDir.mkdirs();
        }
    }

    static {
        Companion = new Companion(null);
        CLIENT = new MutantConfigHelper();
        SERVER = new MutantConfigHelper();
    }

    @Metadata(mv={1, 1, 7}, bv={1, 0, 2}, k=1, d1={"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u0010\u0010\u0003\u001a\u00020\u00048\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u00020\u00048\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0006"}, d2={"Lgloomyfolken/mods/stalker/mobs/entity/config/MutantConfigHelper$Companion;", "", "()V", "CLIENT", "Lgloomyfolken/mods/stalker/mobs/entity/config/MutantConfigHelper;", "SERVER", "minecraft"})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }
}

