/*
 * Decompiled with CFR 0.152.
 */
package cpw.mods.fml.common.asm.transformers.deobf;

import com.google.common.base.CharMatcher;
import com.google.common.base.Charsets;
import com.google.common.base.Splitter;
import com.google.common.base.Strings;
import com.google.common.collect.BiMap;
import com.google.common.collect.ImmutableBiMap;
import com.google.common.collect.ImmutableCollection;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Iterables;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import com.google.common.io.CharStreams;
import com.google.common.io.InputSupplier;
import cpw.mods.fml.common.FMLLog;
import cpw.mods.fml.common.asm.transformers.deobf.LZMAInputSupplier;
import cpw.mods.fml.common.patcher.ClassPatchManager;
import cpw.mods.fml.relauncher.FMLRelaunchLog;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.minecraft.launchwrapper.LaunchClassLoader;
import org.objectweb.asm.ClassReader;
import org.objectweb.asm.commons.Remapper;
import org.objectweb.asm.tree.ClassNode;
import org.objectweb.asm.tree.FieldNode;

public class FMLDeobfuscatingRemapper
extends Remapper {
    public static final FMLDeobfuscatingRemapper INSTANCE = new FMLDeobfuscatingRemapper();
    private BiMap<String, String> classNameBiMap;
    private BiMap<String, String> mcpNameBiMap;
    private Map<String, Map<String, String>> rawFieldMaps;
    private Map<String, Map<String, String>> rawMethodMaps;
    private Map<String, Map<String, String>> fieldNameMaps;
    private Map<String, Map<String, String>> methodNameMaps;
    private LaunchClassLoader classLoader;
    private static final boolean DEBUG_REMAPPING = Boolean.parseBoolean(System.getProperty("fml.remappingDebug", "false"));
    private static final boolean DUMP_FIELD_MAPS = Boolean.parseBoolean(System.getProperty("fml.remappingDebug.dumpFieldMaps", "false")) && DEBUG_REMAPPING;
    private static final boolean DUMP_METHOD_MAPS = Boolean.parseBoolean(System.getProperty("fml.remappingDebug.dumpMethodMaps", "false")) && DEBUG_REMAPPING;
    private Map<String, Map<String, String>> fieldDescriptions = Maps.newHashMap();
    private Set<String> negativeCacheMethods = Sets.newHashSet();
    private Set<String> negativeCacheFields = Sets.newHashSet();

    private FMLDeobfuscatingRemapper() {
        this.classNameBiMap = ImmutableBiMap.of();
        this.mcpNameBiMap = ImmutableBiMap.of();
    }

    public void setupLoadOnly(String string, boolean bl) {
        try {
            File file = new File(string);
            LZMAInputSupplier lZMAInputSupplier = new LZMAInputSupplier(new FileInputStream(file));
            InputSupplier<InputStreamReader> inputSupplier = CharStreams.newReaderSupplier(lZMAInputSupplier, Charsets.UTF_8);
            List<String> list2 = CharStreams.readLines(inputSupplier);
            this.rawMethodMaps = Maps.newHashMap();
            this.rawFieldMaps = Maps.newHashMap();
            ImmutableBiMap.Builder<String, String> builder = ImmutableBiMap.builder();
            ImmutableBiMap.Builder<String, String> builder2 = ImmutableBiMap.builder();
            Splitter splitter = Splitter.on(CharMatcher.anyOf(": ")).omitEmptyStrings().trimResults();
            for (String string2 : list2) {
                String[] stringArray = Iterables.toArray(splitter.split(string2), String.class);
                String string3 = stringArray[0];
                if ("CL".equals(string3)) {
                    this.parseClass(builder, stringArray);
                    this.parseMCPClass(builder2, stringArray);
                    continue;
                }
                if ("MD".equals(string3) && bl) {
                    this.parseMethod(stringArray);
                    continue;
                }
                if (!"FD".equals(string3) || !bl) continue;
                this.parseField(stringArray);
            }
            this.classNameBiMap = builder.build();
            builder2.put((Object)"BaseMod", (Object)"net/minecraft/src/BaseMod");
            builder2.put((Object)"ModLoader", (Object)"net/minecraft/src/ModLoader");
            builder2.put((Object)"EntityRendererProxy", (Object)"net/minecraft/src/EntityRendererProxy");
            builder2.put((Object)"MLProp", (Object)"net/minecraft/src/MLProp");
            builder2.put((Object)"TradeEntry", (Object)"net/minecraft/src/TradeEntry");
            this.mcpNameBiMap = builder2.build();
        }
        catch (IOException iOException) {
            Logger.getLogger("FML").log(Level.SEVERE, "An error occurred loading the deobfuscation map data", iOException);
        }
        this.methodNameMaps = Maps.newHashMapWithExpectedSize(this.rawMethodMaps.size());
        this.fieldNameMaps = Maps.newHashMapWithExpectedSize(this.rawFieldMaps.size());
    }

    public void setup(File file, LaunchClassLoader launchClassLoader, String string) {
        this.classLoader = launchClassLoader;
        try {
            InputStream inputStream = this.getClass().getResourceAsStream(string);
            LZMAInputSupplier lZMAInputSupplier = new LZMAInputSupplier(inputStream);
            InputSupplier<InputStreamReader> inputSupplier = CharStreams.newReaderSupplier(lZMAInputSupplier, Charsets.UTF_8);
            List<String> list2 = CharStreams.readLines(inputSupplier);
            this.rawMethodMaps = Maps.newHashMap();
            this.rawFieldMaps = Maps.newHashMap();
            ImmutableBiMap.Builder<String, String> builder = ImmutableBiMap.builder();
            ImmutableBiMap.Builder<String, String> builder2 = ImmutableBiMap.builder();
            Splitter splitter = Splitter.on(CharMatcher.anyOf(": ")).omitEmptyStrings().trimResults();
            for (String string2 : list2) {
                String[] stringArray = Iterables.toArray(splitter.split(string2), String.class);
                String string3 = stringArray[0];
                if ("CL".equals(string3)) {
                    this.parseClass(builder, stringArray);
                    this.parseMCPClass(builder2, stringArray);
                    continue;
                }
                if ("MD".equals(string3)) {
                    this.parseMethod(stringArray);
                    continue;
                }
                if (!"FD".equals(string3)) continue;
                this.parseField(stringArray);
            }
            this.classNameBiMap = builder.build();
            builder2.put((Object)"BaseMod", (Object)"net/minecraft/src/BaseMod");
            builder2.put((Object)"ModLoader", (Object)"net/minecraft/src/ModLoader");
            builder2.put((Object)"EntityRendererProxy", (Object)"net/minecraft/src/EntityRendererProxy");
            builder2.put((Object)"MLProp", (Object)"net/minecraft/src/MLProp");
            builder2.put((Object)"TradeEntry", (Object)"net/minecraft/src/TradeEntry");
            this.mcpNameBiMap = builder2.build();
        }
        catch (IOException iOException) {
            FMLRelaunchLog.log(Level.SEVERE, iOException, "An error occurred loading the deobfuscation map data", new Object[0]);
        }
        this.methodNameMaps = Maps.newHashMapWithExpectedSize(this.rawMethodMaps.size());
        this.fieldNameMaps = Maps.newHashMapWithExpectedSize(this.rawFieldMaps.size());
    }

    public boolean isRemappedClass(String string) {
        return this.classNameBiMap.containsKey(string = string.replace('.', '/')) || this.mcpNameBiMap.containsKey(string) || !this.classNameBiMap.isEmpty() && string.indexOf(47) == -1;
    }

    private void parseField(String[] stringArray) {
        String string = stringArray[1];
        int n = string.lastIndexOf(47);
        String string2 = string.substring(0, n);
        String string3 = string.substring(n + 1);
        String string4 = stringArray[2];
        int n2 = string4.lastIndexOf(47);
        String string5 = string4.substring(n2 + 1);
        if (!this.rawFieldMaps.containsKey(string2)) {
            this.rawFieldMaps.put(string2, Maps.newHashMap());
        }
        this.rawFieldMaps.get(string2).put(string3 + ":" + this.getFieldType(string2, string3), string5);
        this.rawFieldMaps.get(string2).put(string3 + ":null", string5);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private String getFieldType(String string, String string2) {
        if (this.fieldDescriptions.containsKey(string)) {
            return this.fieldDescriptions.get(string).get(string2);
        }
        Map<String, Map<String, String>> map = this.fieldDescriptions;
        synchronized (map) {
            try {
                byte[] byArray = ClassPatchManager.INSTANCE.getPatchedResource(string, this.map(string).replace('/', '.'), this.classLoader);
                if (byArray == null) {
                    return null;
                }
                ClassReader classReader = new ClassReader(byArray);
                ClassNode classNode = new ClassNode();
                classReader.accept(classNode, 7);
                HashMap<String, String> hashMap = Maps.newHashMap();
                for (FieldNode fieldNode : classNode.fields) {
                    hashMap.put(fieldNode.name, fieldNode.desc);
                }
                this.fieldDescriptions.put(string, hashMap);
                return (String)hashMap.get(string2);
            }
            catch (IOException iOException) {
                FMLLog.log(Level.SEVERE, iOException, "A critical exception occured reading a class file %s", string);
                return null;
            }
        }
    }

    private void parseClass(ImmutableBiMap.Builder<String, String> builder, String[] stringArray) {
        builder.put((Object)stringArray[1], (Object)stringArray[2]);
    }

    private void parseMCPClass(ImmutableBiMap.Builder<String, String> builder, String[] stringArray) {
        int n = stringArray[2].lastIndexOf(47);
        builder.put((Object)("net/minecraft/src/" + stringArray[2].substring(n + 1)), (Object)stringArray[2]);
    }

    private void parseMethod(String[] stringArray) {
        String string = stringArray[1];
        int n = string.lastIndexOf(47);
        String string2 = string.substring(0, n);
        String string3 = string.substring(n + 1);
        String string4 = stringArray[2];
        String string5 = stringArray[3];
        int n2 = string5.lastIndexOf(47);
        String string6 = string5.substring(n2 + 1);
        if (!this.rawMethodMaps.containsKey(string2)) {
            this.rawMethodMaps.put(string2, Maps.newHashMap());
        }
        this.rawMethodMaps.get(string2).put(string3 + string4, string6);
    }

    @Override
    public String mapFieldName(String string, String string2, String string3) {
        if (this.classNameBiMap == null || this.classNameBiMap.isEmpty()) {
            return string2;
        }
        Map<String, String> map = this.getFieldMap(string);
        return map != null && map.containsKey(string2 + ":" + string3) ? map.get(string2 + ":" + string3) : string2;
    }

    @Override
    public String map(String string) {
        String string2;
        if (this.classNameBiMap == null || this.classNameBiMap.isEmpty()) {
            return string;
        }
        int n = string.indexOf(36);
        String string3 = n > -1 ? string.substring(0, n) : string;
        String string4 = string2 = n > -1 ? string.substring(n + 1) : "";
        String string5 = this.classNameBiMap.containsKey(string3) ? (String)this.classNameBiMap.get(string3) : (this.mcpNameBiMap.containsKey(string3) ? (String)this.mcpNameBiMap.get(string3) : string3);
        string5 = n > -1 ? string5 + "$" + string2 : string5;
        return string5;
    }

    public String unmap(String string) {
        String string2;
        if (this.classNameBiMap == null || this.classNameBiMap.isEmpty()) {
            return string;
        }
        int n = string.indexOf(36);
        String string3 = n > -1 ? string.substring(0, n) : string;
        String string4 = string2 = n > -1 ? string.substring(n + 1) : "";
        String string5 = this.classNameBiMap.containsValue(string3) ? (String)this.classNameBiMap.inverse().get(string3) : (this.mcpNameBiMap.containsValue(string3) ? (String)this.mcpNameBiMap.inverse().get(string3) : string3);
        string5 = n > -1 ? string5 + "$" + string2 : string5;
        return string5;
    }

    @Override
    public String mapMethodName(String string, String string2, String string3) {
        if (this.classNameBiMap == null || this.classNameBiMap.isEmpty()) {
            return string2;
        }
        Map<String, String> map = this.getMethodMap(string);
        String string4 = string2 + string3;
        return map != null && map.containsKey(string4) ? map.get(string4) : string2;
    }

    private Map<String, String> getFieldMap(String string) {
        if (!this.fieldNameMaps.containsKey(string) && !this.negativeCacheFields.contains(string)) {
            this.findAndMergeSuperMaps(string);
            if (!this.fieldNameMaps.containsKey(string)) {
                this.negativeCacheFields.add(string);
            }
            if (DUMP_FIELD_MAPS) {
                FMLRelaunchLog.finest("Field map for %s : %s", string, this.fieldNameMaps.get(string));
            }
        }
        return this.fieldNameMaps.get(string);
    }

    private Map<String, String> getMethodMap(String string) {
        if (!this.methodNameMaps.containsKey(string) && !this.negativeCacheMethods.contains(string)) {
            this.findAndMergeSuperMaps(string);
            if (!this.methodNameMaps.containsKey(string)) {
                this.negativeCacheMethods.add(string);
            }
            if (DUMP_METHOD_MAPS) {
                FMLRelaunchLog.finest("Method map for %s : %s", string, this.methodNameMaps.get(string));
            }
        }
        return this.methodNameMaps.get(string);
    }

    private void findAndMergeSuperMaps(String string) {
        try {
            String string2 = null;
            String[] stringArray = new String[]{};
            byte[] byArray = ClassPatchManager.INSTANCE.getPatchedResource(string, this.map(string), this.classLoader);
            if (byArray != null) {
                ClassReader classReader = new ClassReader(byArray);
                string2 = classReader.getSuperName();
                stringArray = classReader.getInterfaces();
            }
            this.mergeSuperMaps(string, string2, stringArray);
        }
        catch (IOException iOException) {
            iOException.printStackTrace();
        }
    }

    public void mergeSuperMaps(String string, String string2, String[] stringArray) {
        Object object2;
        if (this.classNameBiMap == null || this.classNameBiMap.isEmpty()) {
            return;
        }
        if (Strings.isNullOrEmpty(string2)) {
            return;
        }
        ImmutableCollection immutableCollection = ((ImmutableList.Builder)((ImmutableList.Builder)ImmutableList.builder().add(string2)).addAll(Arrays.asList(stringArray))).build();
        for (Object object2 : immutableCollection) {
            if (this.methodNameMaps.containsKey(object2)) continue;
            this.findAndMergeSuperMaps((String)object2);
        }
        HashMap hashMap = Maps.newHashMap();
        object2 = Maps.newHashMap();
        for (String string3 : immutableCollection) {
            if (this.methodNameMaps.containsKey(string3)) {
                hashMap.putAll(this.methodNameMaps.get(string3));
            }
            if (!this.fieldNameMaps.containsKey(string3)) continue;
            object2.putAll(this.fieldNameMaps.get(string3));
        }
        if (this.rawMethodMaps.containsKey(string)) {
            hashMap.putAll(this.rawMethodMaps.get(string));
        }
        if (this.rawFieldMaps.containsKey(string)) {
            object2.putAll(this.rawFieldMaps.get(string));
        }
        this.methodNameMaps.put(string, ImmutableMap.copyOf(hashMap));
        this.fieldNameMaps.put(string, ImmutableMap.copyOf(object2));
    }

    public Set<String> getObfedClasses() {
        return ImmutableSet.copyOf(this.classNameBiMap.keySet());
    }
}

