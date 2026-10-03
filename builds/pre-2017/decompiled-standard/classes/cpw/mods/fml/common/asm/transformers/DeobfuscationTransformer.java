/*
 * Decompiled with CFR 0.152.
 */
package cpw.mods.fml.common.asm.transformers;

import cpw.mods.fml.common.asm.transformers.deobf.FMLDeobfuscatingRemapper;
import cpw.mods.fml.common.asm.transformers.deobf.FMLRemappingAdapter;
import net.minecraft.launchwrapper.IClassNameTransformer;
import net.minecraft.launchwrapper.IClassTransformer;
import org.objectweb.asm.ClassReader;
import org.objectweb.asm.ClassWriter;

public class DeobfuscationTransformer
implements IClassNameTransformer,
IClassTransformer {
    @Override
    public byte[] transform(String string, String string2, byte[] byArray) {
        if (byArray == null) {
            return null;
        }
        ClassReader classReader = new ClassReader(byArray);
        ClassWriter classWriter = new ClassWriter(1);
        FMLRemappingAdapter fMLRemappingAdapter = new FMLRemappingAdapter(classWriter);
        classReader.accept(fMLRemappingAdapter, 8);
        return classWriter.toByteArray();
    }

    @Override
    public String remapClassName(String string) {
        return FMLDeobfuscatingRemapper.INSTANCE.map(string.replace('.', '/')).replace('/', '.');
    }

    @Override
    public String unmapClassName(String string) {
        return FMLDeobfuscatingRemapper.INSTANCE.unmap(string.replace('.', '/')).replace('/', '.');
    }
}

