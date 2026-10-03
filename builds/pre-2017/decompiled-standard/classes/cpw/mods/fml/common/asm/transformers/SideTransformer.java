/*
 * Decompiled with CFR 0.152.
 */
package cpw.mods.fml.common.asm.transformers;

import cpw.mods.fml.relauncher.FMLLaunchHandler;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.Iterator;
import java.util.List;
import net.minecraft.launchwrapper.IClassTransformer;
import org.objectweb.asm.ClassReader;
import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.Type;
import org.objectweb.asm.tree.AnnotationNode;
import org.objectweb.asm.tree.ClassNode;
import org.objectweb.asm.tree.FieldNode;
import org.objectweb.asm.tree.MethodNode;

public class SideTransformer
implements IClassTransformer {
    private static String SIDE = FMLLaunchHandler.side().name();
    private static final boolean DEBUG = false;

    @Override
    public byte[] transform(String string, String string2, byte[] byArray) {
        Object object;
        Object object2;
        if (byArray == null) {
            return null;
        }
        ClassNode classNode = new ClassNode();
        ClassReader classReader = new ClassReader(byArray);
        classReader.accept(classNode, 0);
        if (this.remove(classNode.visibleAnnotations, SIDE)) {
            throw new RuntimeException(String.format("Attempted to load class %s for invalid side %s", classNode.name, SIDE));
        }
        Iterator<FieldNode> iterator2 = classNode.fields.iterator();
        while (iterator2.hasNext()) {
            object2 = iterator2.next();
            if (!this.remove(((FieldNode)object2).visibleAnnotations, SIDE)) continue;
            iterator2.remove();
        }
        object2 = classNode.methods.iterator();
        while (object2.hasNext()) {
            object = (MethodNode)object2.next();
            if (!this.remove(((MethodNode)object).visibleAnnotations, SIDE)) continue;
            object2.remove();
        }
        object = new ClassWriter(1);
        classNode.accept((ClassVisitor)object);
        return ((ClassWriter)object).toByteArray();
    }

    private boolean remove(List<AnnotationNode> list, String string) {
        if (list == null) {
            return false;
        }
        for (AnnotationNode annotationNode : list) {
            if (!annotationNode.desc.equals(Type.getDescriptor(SideOnly.class)) || annotationNode.values == null) continue;
            for (int i = 0; i < annotationNode.values.size() - 1; i += 2) {
                Object object = annotationNode.values.get(i);
                Object object2 = annotationNode.values.get(i + 1);
                if (!(object instanceof String) || !object.equals("value") || !(object2 instanceof String[]) || ((String[])object2)[1].equals(string)) continue;
                return true;
            }
        }
        return false;
    }
}

