/*
 * Decompiled with CFR 0.152.
 */
package cpw.mods.fml.common.asm;

import cpw.mods.fml.common.registry.BlockProxy;
import net.minecraft.launchwrapper.IClassTransformer;
import org.objectweb.asm.ClassReader;
import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.Type;
import org.objectweb.asm.tree.ClassNode;

public class ASMTransformer
implements IClassTransformer {
    @Override
    public byte[] transform(String string, String string2, byte[] byArray) {
        if ("net.minecraft.src.Block".equals(string)) {
            ClassReader classReader = new ClassReader(byArray);
            ClassNode classNode = new ClassNode(262144);
            classReader.accept(classNode, 8);
            classNode.interfaces.add(Type.getInternalName(BlockProxy.class));
            ClassWriter classWriter = new ClassWriter(3);
            classNode.accept(classWriter);
            return classWriter.toByteArray();
        }
        return byArray;
    }
}

