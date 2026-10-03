/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.launchwrapper.injector;

import java.awt.Frame;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.List;
import java.util.ListIterator;
import javax.imageio.ImageIO;
import net.minecraft.launchwrapper.IClassTransformer;
import net.minecraft.launchwrapper.Launch;
import org.lwjgl.opengl.Display;
import org.objectweb.asm.ClassReader;
import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.Label;
import org.objectweb.asm.Type;
import org.objectweb.asm.tree.AbstractInsnNode;
import org.objectweb.asm.tree.ClassNode;
import org.objectweb.asm.tree.FieldNode;
import org.objectweb.asm.tree.MethodNode;

public class VanillaTweakInjector
implements IClassTransformer {
    @Override
    public byte[] transform(String name, String transformedName, byte[] bytes) {
        MethodNode injectedMethod2;
        if (bytes == null) {
            return null;
        }
        if (!"net.minecraft.client.Minecraft".equals(name)) {
            return bytes;
        }
        ClassNode classNode = new ClassNode();
        ClassReader classReader = new ClassReader(bytes);
        classReader.accept(classNode, 8);
        MethodNode mainMethod = null;
        for (MethodNode injectedMethod2 : classNode.methods) {
            if (!"main".equals(injectedMethod2.name)) continue;
            mainMethod = injectedMethod2;
            break;
        }
        if (mainMethod == null) {
            return bytes;
        }
        FieldNode workDirNode1 = null;
        for (FieldNode label : classNode.fields) {
            String iterator2 = Type.getDescriptor(File.class);
            if (!iterator2.equals(label.desc) || (label.access & 8) != 8) continue;
            workDirNode1 = label;
            break;
        }
        injectedMethod2 = new MethodNode();
        Label label1 = new Label();
        injectedMethod2.visitLabel(label1);
        injectedMethod2.visitLineNumber(9001, label1);
        injectedMethod2.visitMethodInsn(184, "net/minecraft/launchwrapper/injector/VanillaTweakInjector", "inject", "()Ljava/io/File;");
        injectedMethod2.visitFieldInsn(179, "net/minecraft/client/Minecraft", workDirNode1.name, "Ljava/io/File;");
        ListIterator<AbstractInsnNode> iterator1 = mainMethod.instructions.iterator();
        while (iterator1.hasNext()) {
            AbstractInsnNode writer = iterator1.next();
            if (writer.getOpcode() != 177) continue;
            mainMethod.instructions.insertBefore(writer, injectedMethod2.instructions);
        }
        ClassWriter writer1 = new ClassWriter(3);
        classNode.accept(writer1);
        return writer1.toByteArray();
    }

    public static File inject() {
        System.out.println("Turning of ImageIO disk-caching");
        ImageIO.setUseCache(false);
        VanillaTweakInjector.loadIconsOnFrames();
        System.out.println("Setting gameDir to: " + Launch.minecraftHome);
        return Launch.minecraftHome;
    }

    public static void loadIconsOnFrames() {
        try {
            File e = new File(Launch.assetsDir, "icons/icon_16x16.png");
            File bigIcon = new File(Launch.assetsDir, "icons/icon_32x32.png");
            System.out.println("Loading current icons for window from: " + e + " and " + bigIcon);
            Display.setIcon(new ByteBuffer[]{VanillaTweakInjector.loadIcon(e), VanillaTweakInjector.loadIcon(bigIcon)});
            Frame[] frames = Frame.getFrames();
            if (frames != null) {
                List<Image> icons = Arrays.asList(ImageIO.read(e), ImageIO.read(bigIcon));
                Frame[] arr$ = frames;
                int len$ = frames.length;
                for (int i$ = 0; i$ < len$; ++i$) {
                    Frame frame = arr$[i$];
                    try {
                        frame.setIconImages(icons);
                        continue;
                    }
                    catch (Throwable var9) {
                        var9.printStackTrace();
                    }
                }
            }
        }
        catch (IOException var10) {
            var10.printStackTrace();
        }
    }

    private static ByteBuffer loadIcon(File iconFile) throws IOException {
        BufferedImage icon = ImageIO.read(iconFile);
        int[] rgb = icon.getRGB(0, 0, icon.getWidth(), icon.getHeight(), null, 0, icon.getWidth());
        ByteBuffer buffer = ByteBuffer.allocate(4 * rgb.length);
        int[] arr$ = rgb;
        int len$ = rgb.length;
        for (int i$ = 0; i$ < len$; ++i$) {
            int color = arr$[i$];
            buffer.putInt(color << 8 | color >> 24 & 0xFF);
        }
        buffer.flip();
        return buffer;
    }
}

