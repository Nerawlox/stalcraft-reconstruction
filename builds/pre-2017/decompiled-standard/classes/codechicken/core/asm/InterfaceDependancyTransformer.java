/*
 * Decompiled with CFR 0.152.
 */
package codechicken.core.asm;

import codechicken.core.asm.InterfaceDependancies;
import codechicken.core.launch.CodeChickenCorePlugin;
import codechicken.lib.asm.ASMHelper;
import codechicken.lib.asm.ObfMapping;
import java.util.Iterator;
import net.minecraft.launchwrapper.IClassTransformer;
import org.objectweb.asm.Type;
import org.objectweb.asm.tree.AnnotationNode;
import org.objectweb.asm.tree.ClassNode;

public class InterfaceDependancyTransformer
implements IClassTransformer {
    @Override
    public byte[] transform(String string, String string2, byte[] byArray) {
        if (byArray == null) {
            return null;
        }
        ClassNode classNode = ASMHelper.createClassNode(byArray);
        boolean bl = false;
        if (classNode.visibleAnnotations != null) {
            for (AnnotationNode annotationNode : classNode.visibleAnnotations) {
                if (!annotationNode.desc.equals(Type.getDescriptor(InterfaceDependancies.class))) continue;
                bl = true;
                break;
            }
        }
        if (!bl) {
            return byArray;
        }
        bl = false;
        Iterator<Object> iterator2 = classNode.interfaces.iterator();
        while (iterator2.hasNext()) {
            try {
                CodeChickenCorePlugin.cl.findClass(new ObfMapping((String)iterator2.next()).toRuntime().javaClass());
            }
            catch (ClassNotFoundException classNotFoundException) {
                iterator2.remove();
                bl = true;
            }
        }
        if (!bl) {
            return byArray;
        }
        return ASMHelper.createBytes(classNode, 0);
    }
}

