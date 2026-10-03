/*
 * Decompiled with CFR 0.152.
 */
package obf.gloomyfolken.modlist;

import gloomyfolken.hooklib.asm.ClassMetadataReader;
import gloomyfolken.hooklib.asm.HookClassTransformer;
import gloomyfolken.hooklib.asm.SafeClassWriter;
import java.util.ListIterator;
import net.minecraft.launchwrapper.IClassTransformer;
import org.objectweb.asm.ClassReader;
import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.Label;
import org.objectweb.asm.Type;
import org.objectweb.asm.tree.AbstractInsnNode;
import org.objectweb.asm.tree.ClassNode;
import org.objectweb.asm.tree.LdcInsnNode;
import org.objectweb.asm.tree.MethodNode;

public class ModListTransformer
implements IClassTransformer {
    private HookClassTransformer forgeClassTransformer = new HookClassTransformer();

    public ModListTransformer() {
        this.forgeClassTransformer.registerHookContainer("obf.gloomyfolken.modlist.ModListHooks");
    }

    @Override
    public byte[] transform(String string, String string2, byte[] byArray) {
        if (string.equals("cpw.mods.fml.common.discovery.ContainerType")) {
            byArray = this.transformContainerType(byArray);
        } else if (string.equals("cpw.mods.fml.common.ModClassLoader")) {
            byArray = this.transformModClassLoader(byArray);
        }
        byArray = this.forgeClassTransformer.transform(string, byArray);
        return byArray;
    }

    private byte[] transformContainerType(byte[] byArray) {
        ClassNode classNode = new ClassNode();
        ClassReader classReader = new ClassReader(byArray);
        classReader.accept(classNode, 0);
        for (MethodNode methodNode : classNode.methods) {
            if (!methodNode.name.equals("<clinit>")) continue;
            ListIterator<AbstractInsnNode> listIterator = methodNode.instructions.iterator();
            while (listIterator.hasNext()) {
                AbstractInsnNode abstractInsnNode = (AbstractInsnNode)listIterator.next();
                if (abstractInsnNode.getOpcode() != 18) continue;
                LdcInsnNode ldcInsnNode = (LdcInsnNode)abstractInsnNode;
                if (!(ldcInsnNode.cst instanceof Type)) continue;
                Type type = (Type)ldcInsnNode.cst;
                if (type.getInternalName().equals("cpw/mods/fml/common/discovery/JarDiscoverer")) {
                    System.out.println("Jar discoverer replaced");
                    ldcInsnNode.cst = Type.getObjectType("obf/gloomyfolken/modlist/ListJarDiscoverer");
                    continue;
                }
                if (!type.getInternalName().equals("cpw/mods/fml/common/discovery/DirectoryDiscoverer")) continue;
                System.out.println("Dir discoverer replaced");
                ldcInsnNode.cst = Type.getObjectType("obf/gloomyfolken/modlist/ListDirectoryDiscoverer");
            }
        }
        ClassWriter classWriter = new ClassWriter(0);
        classNode.accept(classWriter);
        return classWriter.toByteArray();
    }

    private byte[] transformModClassLoader(byte[] byArray) {
        Object object;
        int n;
        ClassNode classNode = new ClassNode();
        ClassReader classReader = new ClassReader(byArray);
        classReader.accept(classNode, 0);
        for (n = 0; n < classNode.methods.size(); ++n) {
            object = classNode.methods.get(n);
            if (!((MethodNode)object).name.equals("<init>")) continue;
            MethodNode methodNode = new MethodNode(1, "<init>", "(Ljava/lang/ClassLoader;)V", null, null);
            methodNode.visitCode();
            Label label = new Label();
            methodNode.visitLabel(label);
            methodNode.visitVarInsn(25, 0);
            methodNode.visitInsn(3);
            methodNode.visitTypeInsn(189, "java/net/URL");
            methodNode.visitInsn(1);
            methodNode.visitMethodInsn(183, "java/net/URLClassLoader", "<init>", "([Ljava/net/URL;Ljava/lang/ClassLoader;)V", false);
            Label label2 = new Label();
            methodNode.visitLabel(label2);
            methodNode.visitFieldInsn(178, "obf/gloomyfolken/modlist/ModListHooks", "USE_SYSTEM_CLASS_LOADER", "Z");
            Label label3 = new Label();
            methodNode.visitJumpInsn(154, label3);
            Label label4 = new Label();
            methodNode.visitLabel(label4);
            methodNode.visitVarInsn(25, 0);
            methodNode.visitVarInsn(25, 1);
            methodNode.visitTypeInsn(192, "net/minecraft/launchwrapper/LaunchClassLoader");
            methodNode.visitFieldInsn(181, "cpw/mods/fml/common/ModClassLoader", "mainClassLoader", "Lnet/minecraft/launchwrapper/LaunchClassLoader;");
            methodNode.visitLabel(label3);
            methodNode.visitFrame(0, 2, new Object[]{"cpw/mods/fml/common/ModClassLoader", "java/lang/ClassLoader"}, 0, new Object[0]);
            methodNode.visitInsn(177);
            Label label5 = new Label();
            methodNode.visitLabel(label5);
            methodNode.visitLocalVariable("this", "Lcpw/mods/fml/common/ModClassLoader;", null, label, label5, 0);
            methodNode.visitLocalVariable("parent", "Ljava/lang/ClassLoader;", null, label, label5, 1);
            methodNode.visitMaxs(3, 2);
            methodNode.visitEnd();
            classNode.methods.set(n, methodNode);
        }
        n = classNode.version > 50 ? 1 : 0;
        object = new SafeClassWriter(new ClassMetadataReader(), n != 0 ? 2 : 0);
        classNode.accept((ClassVisitor)object);
        return ((ClassWriter)object).toByteArray();
    }
}

