/*
 * Decompiled with CFR 0.152.
 */
package cpw.mods.fml.common.asm.transformers;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.ListMultimap;
import com.google.common.collect.Sets;
import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.ModAPIManager;
import cpw.mods.fml.common.discovery.ASMDataTable;
import cpw.mods.fml.relauncher.FMLRelaunchLog;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Set;
import net.minecraft.launchwrapper.IClassTransformer;
import org.objectweb.asm.ClassReader;
import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.tree.ClassNode;
import org.objectweb.asm.tree.MethodNode;

public class ModAPITransformer
implements IClassTransformer {
    private static final boolean logDebugInfo = Boolean.valueOf(System.getProperty("fml.debugAPITransformer", "true"));
    private ListMultimap<String, ASMDataTable.ASMData> optionals;

    @Override
    public byte[] transform(String string, String string2, byte[] byArray) {
        if (this.optionals == null || !this.optionals.containsKey(string)) {
            return byArray;
        }
        ClassNode classNode = new ClassNode();
        ClassReader classReader = new ClassReader(byArray);
        classReader.accept(classNode, 0);
        if (logDebugInfo) {
            FMLRelaunchLog.finest("Optional removal - found optionals for class %s - processing", string);
        }
        for (ASMDataTable.ASMData aSMData : this.optionals.get(string)) {
            String string3 = (String)aSMData.getAnnotationInfo().get("modid");
            if (Loader.isModLoaded(string3) || ModAPIManager.INSTANCE.hasAPI(string3)) {
                if (!logDebugInfo) continue;
                FMLRelaunchLog.finest("Optional removal skipped - mod present %s", string3);
                continue;
            }
            if (logDebugInfo) {
                FMLRelaunchLog.finest("Optional on %s triggered - mod missing %s", string, string3);
            }
            if (aSMData.getAnnotationInfo().containsKey("iface")) {
                Boolean bl = (Boolean)aSMData.getAnnotationInfo().get("striprefs");
                if (bl == null) {
                    bl = Boolean.FALSE;
                }
                this.stripInterface(classNode, (String)aSMData.getAnnotationInfo().get("iface"), bl);
                continue;
            }
            this.stripMethod(classNode, aSMData.getObjectName());
        }
        if (logDebugInfo) {
            FMLRelaunchLog.finest("Optional removal - class %s processed", string);
        }
        ClassWriter classWriter = new ClassWriter(1);
        classNode.accept(classWriter);
        return classWriter.toByteArray();
    }

    private void stripMethod(ClassNode classNode, String string) {
        ListIterator<MethodNode> listIterator = classNode.methods.listIterator();
        while (listIterator.hasNext()) {
            MethodNode methodNode = listIterator.next();
            if (!string.equals(methodNode.name + methodNode.desc)) continue;
            listIterator.remove();
            if (logDebugInfo) {
                FMLRelaunchLog.finest("Optional removal - method %s removed", string);
            }
            return;
        }
        if (logDebugInfo) {
            FMLRelaunchLog.finest("Optional removal - method %s NOT removed - not found", string);
        }
    }

    private void stripInterface(ClassNode classNode, String string, boolean bl) {
        String string2 = string.replace('.', '/');
        boolean bl2 = classNode.interfaces.remove(string2);
        if (bl2 && logDebugInfo) {
            FMLRelaunchLog.finest("Optional removal - interface %s removed", string);
        }
        if (!bl2 && logDebugInfo) {
            FMLRelaunchLog.finest("Optional removal - interface %s NOT removed - not found", string);
        }
        if (bl2 && bl) {
            if (logDebugInfo) {
                FMLRelaunchLog.finest("Optional removal - interface %s - stripping method signature references", string);
            }
            Iterator<MethodNode> iterator2 = classNode.methods.iterator();
            while (iterator2.hasNext()) {
                MethodNode methodNode = iterator2.next();
                if (!methodNode.desc.contains(string2)) continue;
                if (logDebugInfo) {
                    FMLRelaunchLog.finest("Optional removal - interface %s - stripping method containing reference %s", string, methodNode.name);
                }
                iterator2.remove();
            }
            if (logDebugInfo) {
                FMLRelaunchLog.finest("Optional removal - interface %s - all method signature references stripped", string);
            }
        } else if (bl2 && logDebugInfo) {
            FMLRelaunchLog.finest("Optional removal - interface %s - NOT stripping method signature references", string);
        }
    }

    public void initTable(ASMDataTable aSMDataTable) {
        this.optionals = ArrayListMultimap.create();
        Set<ASMDataTable.ASMData> set = aSMDataTable.getAll("cpw.mods.fml.common.Optional$InterfaceList");
        this.addData(this.unpackInterfaces(set));
        Set<ASMDataTable.ASMData> set2 = aSMDataTable.getAll("cpw.mods.fml.common.Optional$Interface");
        this.addData(set2);
        Set<ASMDataTable.ASMData> set3 = aSMDataTable.getAll("cpw.mods.fml.common.Optional$Method");
        this.addData(set3);
    }

    private Set<ASMDataTable.ASMData> unpackInterfaces(Set<ASMDataTable.ASMData> set) {
        HashSet<ASMDataTable.ASMData> hashSet = Sets.newHashSet();
        for (ASMDataTable.ASMData aSMData : set) {
            List list = (List)aSMData.getAnnotationInfo().get("value");
            for (Map map : list) {
                ASMDataTable.ASMData aSMData2 = aSMData.copy(map);
                hashSet.add(aSMData2);
            }
        }
        return hashSet;
    }

    private void addData(Set<ASMDataTable.ASMData> set) {
        for (ASMDataTable.ASMData aSMData : set) {
            this.optionals.put(aSMData.getClassName(), aSMData);
        }
    }
}

