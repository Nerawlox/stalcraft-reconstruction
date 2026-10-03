/*
 * Decompiled with CFR 0.152.
 */
package codechicken.core.asm;

import codechicken.core.asm.CodeChickenCoreModContainer;
import codechicken.core.launch.CodeChickenCorePlugin;
import codechicken.lib.asm.ASMHelper;
import codechicken.lib.asm.CC_ClassWriter;
import codechicken.lib.asm.ObfMapping;
import codechicken.lib.config.ConfigFile;
import codechicken.lib.config.ConfigTag;
import codechicken.obfuscator.IHeirachyEvaluator;
import codechicken.obfuscator.ObfuscationMap;
import codechicken.obfuscator.ObfuscationRun;
import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;
import cpw.mods.fml.common.asm.transformers.AccessTransformer;
import cpw.mods.fml.common.asm.transformers.DeobfuscationTransformer;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import javax.swing.JFileChooser;
import net.minecraft.launchwrapper.IClassTransformer;
import net.minecraft.launchwrapper.LaunchClassLoader;
import org.objectweb.asm.Opcodes;
import org.objectweb.asm.tree.ClassNode;
import org.objectweb.asm.tree.MethodInsnNode;
import org.objectweb.asm.tree.MethodNode;

public class MCPDeobfuscationTransformer
implements IHeirachyEvaluator,
IClassTransformer,
Opcodes {
    private static ObfuscationRun run;
    private static List<String> excludedPackages;
    private static MCPDeobfuscationTransformer instance;
    private static boolean activated;
    private static Field f_transformers;
    private static Field f_modifiers;
    private static Field f_Modifier_name;
    private static Field f_Modifier_desc;

    private static Object get(Field field, Object object) {
        try {
            return field.get(object);
        }
        catch (Exception exception) {
            throw new RuntimeException(exception);
        }
    }

    private static void set(Field field, Object object, Object object2) {
        try {
            field.set(object, object2);
        }
        catch (Exception exception) {
            throw new RuntimeException(exception);
        }
    }

    private static List<IClassTransformer> getTransformers() {
        return (List)MCPDeobfuscationTransformer.get(f_transformers, CodeChickenCorePlugin.cl);
    }

    public static void load() {
        ConfigFile configFile = CodeChickenCoreModContainer.config;
        File file = CodeChickenCorePlugin.minecraftDir;
        if (configFile.getTag("dev.deobfuscate").setComment("set to true to completely deobfuscate mcp names").getBooleanValue(!ObfMapping.obfuscated)) {
            System.out.println("Loading MCPDeobfuscationTransformer");
            run = new ObfuscationRun(false, MCPDeobfuscationTransformer.getConfFiles(file, configFile), ObfuscationRun.fillDefaults(new HashMap<String, String>()));
            MCPDeobfuscationTransformer.run.obf.setHeirachyEvaluator(instance);
            run.setQuiet().parseMappings();
            for (String string : MCPDeobfuscationTransformer.run.config.get("excludedPackages").split(";")) {
                excludedPackages.add(string);
            }
            ObfMapping.runtimeMapper = MCPDeobfuscationTransformer.run.obfMapper;
            if (ObfMapping.obfuscated) {
                run.setSeargeConstants();
                MCPDeobfuscationTransformer.getTransformers().add(instance);
            } else {
                ObfMapping.mcpMapper = MCPDeobfuscationTransformer.run.obfMapper;
                MCPDeobfuscationTransformer.getTransformers().add(0, instance);
            }
        }
    }

    private static File confDirectoryGuess(int n, File file, ConfigTag configTag) {
        switch (n) {
            case 0: {
                return configTag.value != null ? new File(configTag.getValue()) : null;
            }
            case 1: {
                return new File(file, "../conf");
            }
            case 2: {
                return new File(file, "../build/unpacked");
            }
        }
        JFileChooser jFileChooser = new JFileChooser(file);
        jFileChooser.setFileSelectionMode(1);
        jFileChooser.setDialogTitle("Select an mcp conf dir for the deobfuscator.");
        int n2 = jFileChooser.showDialog(null, "Select");
        return n2 == 0 ? jFileChooser.getSelectedFile() : null;
    }

    private static File[] getConfFiles(File file, ConfigFile configFile) {
        ConfigTag configTag = configFile.getTag("dev.mappingDir");
        for (int i = 0; i < 6; ++i) {
            File[] fileArray;
            File file2 = MCPDeobfuscationTransformer.confDirectoryGuess(i, file, configTag);
            if (file2 == null || file2.isFile()) continue;
            try {
                fileArray = ObfuscationRun.parseConfDir(file2);
            }
            catch (Exception exception) {
                if (i < 3) continue;
                exception.printStackTrace();
                continue;
            }
            configTag.setValue(file2.getPath());
            return fileArray;
        }
        throw new RuntimeException("Failed to select mappings directory, set it manually in the config");
    }

    @Override
    public byte[] transform(String string, String string2, byte[] byArray) {
        if (string.equals("cpw.mods.fml.common.Loader")) {
            byArray = this.injectCallback(byArray);
            activated = true;
        }
        if (!activated || byArray == null) {
            return byArray;
        }
        ClassNode classNode = ASMHelper.createClassNode(byArray, 8);
        CC_ClassWriter cC_ClassWriter = new CC_ClassWriter(0, true);
        run.remap(classNode, cC_ClassWriter);
        return cC_ClassWriter.toByteArray();
    }

    private byte[] injectCallback(byte[] byArray) {
        ClassNode classNode = ASMHelper.createClassNode(byArray);
        MethodNode methodNode = ASMHelper.findMethod(new ObfMapping(classNode.name, "<clinit>", "()V"), classNode);
        methodNode.instructions.insert(new MethodInsnNode(184, "codechicken/core/asm/MCPDeobfuscationTransformer", "loadCallback", "()V"));
        return ASMHelper.createBytes(classNode, 0);
    }

    public static void loadCallback() {
        if (ObfMapping.obfuscated) {
            List<IClassTransformer> list = MCPDeobfuscationTransformer.getTransformers();
            Iterator<IClassTransformer> iterator2 = list.iterator();
            while (iterator2.hasNext()) {
                IClassTransformer iClassTransformer = iterator2.next();
                if (iClassTransformer != instance && !(iClassTransformer instanceof DeobfuscationTransformer)) continue;
                iterator2.remove();
            }
            list.add(instance);
        } else {
            for (IClassTransformer iClassTransformer : MCPDeobfuscationTransformer.getTransformers()) {
                if (!(iClassTransformer instanceof AccessTransformer)) continue;
                MCPDeobfuscationTransformer.remapAccessTransformer(iClassTransformer);
            }
        }
    }

    private static void remapAccessTransformer(IClassTransformer iClassTransformer) {
        Multimap multimap = (Multimap)MCPDeobfuscationTransformer.get(f_modifiers, iClassTransformer);
        HashMultimap hashMultimap = HashMultimap.create();
        for (Map.Entry entry : multimap.entries()) {
            ObfMapping obfMapping;
            Object v = entry.getValue();
            String string = ((String)entry.getKey()).replace('.', '/');
            String string2 = (String)MCPDeobfuscationTransformer.get(f_Modifier_name, v);
            String string3 = (String)MCPDeobfuscationTransformer.get(f_Modifier_desc, v);
            if (string2.equals("*")) {
                obfMapping = new ObfMapping(string);
                obfMapping.s_name = string2;
                obfMapping.s_desc = string3;
            } else {
                obfMapping = new ObfMapping(string, string2, string3);
            }
            MCPDeobfuscationTransformer.set(f_Modifier_name, v, obfMapping.s_name);
            MCPDeobfuscationTransformer.set(f_Modifier_desc, v, obfMapping.s_desc);
            hashMultimap.put(obfMapping.javaClass(), v);
        }
        MCPDeobfuscationTransformer.set(f_modifiers, iClassTransformer, hashMultimap);
    }

    @Override
    public List<String> getParents(ObfuscationMap.ObfuscationEntry obfuscationEntry) {
        try {
            String string = ObfMapping.obfuscated ? obfuscationEntry.obf.s_owner : obfuscationEntry.mcp.s_owner;
            string = string.replace('/', '.');
            byte[] byArray = CodeChickenCorePlugin.cl.getClassBytes(string);
            if (byArray != null) {
                return ObfuscationRun.getParents(ASMHelper.createClassNode(byArray));
            }
        }
        catch (IOException iOException) {
            // empty catch block
        }
        return null;
    }

    @Override
    public boolean isLibClass(ObfuscationMap.ObfuscationEntry obfuscationEntry) {
        String string = obfuscationEntry.srg.s_owner;
        for (String string2 : excludedPackages) {
            if (!string.startsWith(string2)) continue;
            return true;
        }
        return false;
    }

    public static String unmap(String string) {
        if (run == null) {
            return null;
        }
        ObfuscationMap.ObfuscationEntry obfuscationEntry = MCPDeobfuscationTransformer.run.obf.lookupMcpClass(string);
        if (obfuscationEntry == null) {
            return null;
        }
        return obfuscationEntry.obf.s_owner;
    }

    public static MCPDeobfuscationTransformer instance() {
        return instance;
    }

    static {
        excludedPackages = new LinkedList<String>();
        instance = new MCPDeobfuscationTransformer();
        try {
            f_transformers = LaunchClassLoader.class.getDeclaredField("transformers");
            f_modifiers = AccessTransformer.class.getDeclaredField("modifiers");
            Class<?> clazz = Class.forName(AccessTransformer.class.getName() + "$Modifier", false, CodeChickenCorePlugin.cl);
            f_Modifier_name = clazz.getDeclaredField("name");
            f_Modifier_desc = clazz.getDeclaredField("desc");
            f_transformers.setAccessible(true);
            f_modifiers.setAccessible(true);
            f_Modifier_name.setAccessible(true);
            f_Modifier_desc.setAccessible(true);
        }
        catch (Exception exception) {
            throw new RuntimeException(exception);
        }
    }
}

