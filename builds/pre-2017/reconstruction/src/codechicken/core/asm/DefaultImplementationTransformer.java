/*
 * Decompiled with CFR 0.152.
 */
package codechicken.core.asm;

import codechicken.lib.asm.ASMHelper;
import codechicken.lib.asm.ObfMapping;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import net.minecraft.launchwrapper.IClassTransformer;
import net.minecraft.launchwrapper.Launch;
import net.minecraft.launchwrapper.LaunchClassLoader;
import org.objectweb.asm.tree.ClassNode;
import org.objectweb.asm.tree.MethodNode;

public class DefaultImplementationTransformer
implements IClassTransformer {
    private static LaunchClassLoader cl = Launch.classLoader;
    private static HashMap<String, InterfaceImpl> impls = new HashMap();

    private static ClassNode getClassNode(String string) {
        try {
            byte[] byArray = cl.getClassBytes(string.replace('/', '.'));
            return byArray == null ? null : ASMHelper.createClassNode(byArray);
        }
        catch (IOException iOException) {
            throw new RuntimeException(iOException);
        }
    }

    public static void registerDefaultImpl(String string, String string2) {
        impls.put(string.replace('.', '/'), new InterfaceImpl(string, string2));
    }

    @Override
    public byte[] transform(String string, String string2, byte[] byArray) {
        if (string2.startsWith("net.minecraft") || impls.isEmpty()) {
            return byArray;
        }
        ClassNode classNode = ASMHelper.createClassNode(byArray);
        boolean bl = false;
        for (String string3 : classNode.interfaces) {
            InterfaceImpl interfaceImpl = impls.get(string3);
            if (interfaceImpl == null) continue;
            bl |= interfaceImpl.patch(classNode);
        }
        return bl ? ASMHelper.createBytes(classNode, 0) : byArray;
    }

    static class InterfaceImpl {
        public final String iname;
        public ArrayList<MethodNode> impls = new ArrayList();

        public InterfaceImpl(String string, String string2) {
            this.iname = string;
            HashSet<String> hashSet = new HashSet<String>();
            ClassNode classNode = DefaultImplementationTransformer.getClassNode(string);
            if (classNode == null) {
                return;
            }
            for (MethodNode object : classNode.methods) {
                hashSet.add(object.name + object.desc);
            }
            ClassNode classNode2 = DefaultImplementationTransformer.getClassNode(string2);
            if (classNode2 == null) {
                return;
            }
            for (MethodNode methodNode : classNode2.methods) {
                if (!hashSet.contains(methodNode.name + methodNode.desc)) continue;
                this.impls.add(methodNode);
                methodNode.desc = new ObfMapping((String)classNode2.name, (String)methodNode.name, (String)methodNode.desc).toRuntime().s_desc;
            }
        }

        public boolean patch(ClassNode classNode) {
            LinkedList<String> linkedList = new LinkedList<String>();
            for (MethodNode object : classNode.methods) {
                ObfMapping obfMapping = new ObfMapping(classNode.name, object.name, object.desc).toRuntime();
                linkedList.add(obfMapping.s_name + obfMapping.s_desc);
            }
            boolean bl = false;
            for (MethodNode methodNode : this.impls) {
                if (linkedList.contains(methodNode.name + methodNode.desc)) continue;
                MethodNode methodNode2 = new MethodNode(methodNode.access, methodNode.name, methodNode.desc, methodNode.signature, methodNode.exceptions == null ? null : methodNode.exceptions.toArray(new String[0]));
                ASMHelper.copy(methodNode, methodNode2);
                classNode.methods.add(methodNode);
                bl = true;
            }
            return bl;
        }
    }
}

