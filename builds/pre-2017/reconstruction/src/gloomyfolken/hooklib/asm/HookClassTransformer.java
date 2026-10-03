/*
 * Decompiled with CFR 0.152.
 */
package gloomyfolken.hooklib.asm;

import gloomyfolken.hooklib.asm.AsmHook;
import gloomyfolken.hooklib.asm.ClassMetadataReader;
import gloomyfolken.hooklib.asm.HookContainerParser;
import gloomyfolken.hooklib.asm.HookInjectorClassVisitor;
import gloomyfolken.hooklib.asm.HookLogger;
import gloomyfolken.hooklib.asm.SafeClassWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import org.objectweb.asm.ClassReader;
import org.objectweb.asm.ClassWriter;

public class HookClassTransformer {
    public HookLogger logger = new HookLogger.SystemOutLogger();
    protected HashMap<String, List<AsmHook>> hooksMap = new HashMap();
    private HookContainerParser containerParser = new HookContainerParser(this);
    protected ClassMetadataReader classMetadataReader = new ClassMetadataReader();

    public void registerHook(AsmHook asmHook) {
        if (this.hooksMap.containsKey(asmHook.getTargetClassName())) {
            this.hooksMap.get(asmHook.getTargetClassName()).add(asmHook);
        } else {
            ArrayList<AsmHook> arrayList = new ArrayList<AsmHook>(2);
            arrayList.add(asmHook);
            this.hooksMap.put(asmHook.getTargetClassName(), arrayList);
        }
    }

    public void registerHookContainer(String string) {
        this.containerParser.parseHooks(string);
    }

    public void registerHookContainer(byte[] byArray) {
        this.containerParser.parseHooks(byArray);
    }

    public byte[] transform(String string, byte[] byArray) {
        List<AsmHook> list2 = this.hooksMap.get(string);
        if (list2 != null) {
            try {
                Collections.sort(list2);
                this.logger.debug("Injecting hooks into class " + string);
                int n = list2.size();
                int n2 = (byArray[6] & 0xFF) << 8 | byArray[7] & 0xFF;
                boolean bl = n2 > 50;
                ClassReader classReader = new ClassReader(byArray);
                ClassWriter classWriter = this.createClassWriter(bl ? 2 : 1);
                HookInjectorClassVisitor hookInjectorClassVisitor = this.createInjectorClassVisitor(classWriter, list2);
                classReader.accept(hookInjectorClassVisitor, bl ? 4 : 8);
                int n3 = n - hookInjectorClassVisitor.hooks.size();
                this.logger.debug("Successfully injected " + n3 + " hook" + (n3 == 1 ? "" : "s") + " to " + string);
                for (AsmHook asmHook : hookInjectorClassVisitor.hooks) {
                    this.logger.warning("Can not found target method of hook " + asmHook);
                }
                return classWriter.toByteArray();
            }
            catch (Exception exception) {
                this.logger.severe("A problem has occured during transformation of class " + string + ".");
                this.logger.severe("Attached hooks:");
                for (AsmHook asmHook : list2) {
                    this.logger.severe(asmHook.toString());
                }
                this.logger.severe("Stack trace:", exception);
            }
        }
        return byArray;
    }

    protected HookInjectorClassVisitor createInjectorClassVisitor(ClassWriter classWriter, List<AsmHook> list2) {
        return new HookInjectorClassVisitor(this, classWriter, list2);
    }

    protected ClassWriter createClassWriter(int n) {
        return new SafeClassWriter(this.classMetadataReader, n);
    }
}

