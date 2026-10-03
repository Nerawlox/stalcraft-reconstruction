/*
 * Decompiled with CFR 0.152.
 */
package cpw.mods.fml.common.asm.transformers;

import com.google.common.base.Charsets;
import com.google.common.base.Splitter;
import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import com.google.common.collect.Multimap;
import com.google.common.io.LineProcessor;
import com.google.common.io.Resources;
import cpw.mods.fml.common.asm.transformers.deobf.FMLDeobfuscatingRemapper;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;
import net.minecraft.launchwrapper.IClassTransformer;
import org.objectweb.asm.ClassReader;
import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.tree.ClassNode;
import org.objectweb.asm.tree.FieldNode;
import org.objectweb.asm.tree.MethodNode;

public class AccessTransformer
implements IClassTransformer {
    private static final boolean DEBUG = false;
    private Multimap<String, Modifier> modifiers = ArrayListMultimap.create();

    public AccessTransformer() throws IOException {
        this("fml_at.cfg");
    }

    protected AccessTransformer(String string) throws IOException {
        this.readMapFile(string);
    }

    private void readMapFile(String string) throws IOException {
        File file = new File(string);
        URL uRL = file.exists() ? file.toURI().toURL() : Resources.getResource(string);
        Resources.readLines(uRL, Charsets.UTF_8, new LineProcessor<Void>(){

            @Override
            public Void getResult() {
                return null;
            }

            @Override
            public boolean processLine(String string) throws IOException {
                String string2 = Iterables.getFirst(Splitter.on('#').limit(2).split(string), "").trim();
                if (string2.length() == 0) {
                    return true;
                }
                ArrayList<String> arrayList = Lists.newArrayList(Splitter.on(" ").trimResults().split(string2));
                if (arrayList.size() > 2) {
                    throw new RuntimeException("Invalid config file line " + string);
                }
                Modifier modifier = new Modifier();
                modifier.setTargetAccess((String)arrayList.get(0));
                ArrayList<String> arrayList2 = Lists.newArrayList(Splitter.on(".").trimResults().split((CharSequence)arrayList.get(1)));
                if (arrayList2.size() == 1) {
                    modifier.modifyClassVisibility = true;
                } else {
                    String string3 = (String)arrayList2.get(1);
                    int n = string3.indexOf(40);
                    if (n > 0) {
                        modifier.desc = string3.substring(n);
                        modifier.name = string3.substring(0, n);
                    } else {
                        modifier.name = string3;
                    }
                }
                AccessTransformer.this.modifiers.put(((String)arrayList2.get(0)).replace('/', '.'), modifier);
                return true;
            }
        });
        System.out.printf("Loaded %d rules from AccessTransformer config file %s\n", this.modifiers.size(), string);
    }

    @Override
    public byte[] transform(String string, String string2, byte[] byArray) {
        Object object;
        if (byArray == null) {
            return null;
        }
        boolean bl = FMLDeobfuscatingRemapper.INSTANCE.isRemappedClass(string);
        if (!bl && !this.modifiers.containsKey(string)) {
            return byArray;
        }
        ClassNode classNode = new ClassNode();
        ClassReader classReader = new ClassReader(byArray);
        classReader.accept(classNode, 0);
        if (bl) {
            object = new Modifier();
            ((Modifier)object).targetAccess = 1;
            ((Modifier)object).modifyClassVisibility = true;
            this.modifiers.put(string, (Modifier)object);
            object = new Modifier();
            ((Modifier)object).targetAccess = 1;
            ((Modifier)object).name = "*";
            this.modifiers.put(string, (Modifier)object);
            object = new Modifier();
            ((Modifier)object).targetAccess = 1;
            ((Modifier)object).name = "*";
            ((Modifier)object).desc = "<dummy>";
            this.modifiers.put(string, (Modifier)object);
        }
        object = this.modifiers.get(string);
        Object object2 = object.iterator();
        block0: while (object2.hasNext()) {
            Modifier modifier = (Modifier)object2.next();
            if (modifier.modifyClassVisibility) {
                classNode.access = this.getFixedAccess(classNode.access, modifier);
                continue;
            }
            if (modifier.desc.isEmpty()) {
                for (FieldNode fieldNode : classNode.fields) {
                    if (!fieldNode.name.equals(modifier.name) && !modifier.name.equals("*")) continue;
                    fieldNode.access = this.getFixedAccess(fieldNode.access, modifier);
                    if (modifier.name.equals("*")) continue;
                    continue block0;
                }
                continue;
            }
            for (MethodNode methodNode : classNode.methods) {
                if ((!methodNode.name.equals(modifier.name) || !methodNode.desc.equals(modifier.desc)) && !modifier.name.equals("*")) continue;
                methodNode.access = this.getFixedAccess(methodNode.access, modifier);
                if (modifier.name.equals("*")) continue;
                continue block0;
            }
        }
        object2 = new ClassWriter(1);
        classNode.accept((ClassVisitor)object2);
        return ((ClassWriter)object2).toByteArray();
    }

    private String toBinary(int n) {
        return String.format("%16s", Integer.toBinaryString(n)).replace(' ', '0');
    }

    private int getFixedAccess(int n, Modifier modifier) {
        modifier.oldAccess = n;
        int n2 = modifier.targetAccess;
        int n3 = n & 0xFFFFFFF8;
        switch (n & 7) {
            case 2: {
                n3 |= n2;
                break;
            }
            case 0: {
                n3 |= n2 != 2 ? n2 : 0;
                break;
            }
            case 4: {
                n3 |= n2 != 2 && n2 != 0 ? n2 : 4;
                break;
            }
            case 1: {
                n3 |= n2 != 2 && n2 != 0 && n2 != 4 ? n2 : 1;
                break;
            }
            default: {
                throw new RuntimeException("The fuck?");
            }
        }
        if (modifier.changeFinal) {
            n3 = modifier.markFinal ? (n3 |= 0x10) : (n3 &= 0xFFFFFFEF);
        }
        modifier.newAccess = n3;
        return n3;
    }

    public static void main(String[] stringArray) {
        if (stringArray.length < 2) {
            System.out.println("Usage: AccessTransformer <JarPath> <MapFile> [MapFile2]... ");
            System.exit(1);
        }
        boolean bl = false;
        AccessTransformer[] accessTransformerArray = new AccessTransformer[stringArray.length - 1];
        for (int i = 1; i < stringArray.length; ++i) {
            try {
                accessTransformerArray[i - 1] = new AccessTransformer(stringArray[i]);
                bl = true;
                continue;
            }
            catch (IOException iOException) {
                System.out.println("Could not read Transformer Map: " + stringArray[i]);
                iOException.printStackTrace();
            }
        }
        if (!bl) {
            System.out.println("Culd not find a valid transformer to perform");
            System.exit(1);
        }
        File file = new File(stringArray[0]);
        File file2 = new File(stringArray[0] + ".ATBack");
        if (!file.exists() && !file2.exists()) {
            System.out.println("Could not find target jar: " + file);
            System.exit(1);
        }
        if (!file.renameTo(file2)) {
            System.out.println("Could not rename file: " + file + " -> " + file2);
            System.exit(1);
        }
        try {
            AccessTransformer.processJar(file2, file, accessTransformerArray);
        }
        catch (IOException iOException) {
            iOException.printStackTrace();
            System.exit(1);
        }
        if (!file2.delete()) {
            System.out.println("Could not delete temp file: " + file2);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private static void processJar(File file, File file2, AccessTransformer[] accessTransformerArray) throws IOException {
        ZipInputStream zipInputStream = null;
        ZipOutputStream zipOutputStream = null;
        try {
            ZipEntry zipEntry;
            try {
                zipInputStream = new ZipInputStream(new BufferedInputStream(new FileInputStream(file)));
            }
            catch (FileNotFoundException fileNotFoundException) {
                throw new FileNotFoundException("Could not open input file: " + fileNotFoundException.getMessage());
            }
            try {
                zipOutputStream = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(file2)));
            }
            catch (FileNotFoundException fileNotFoundException) {
                throw new FileNotFoundException("Could not open output file: " + fileNotFoundException.getMessage());
            }
            while ((zipEntry = zipInputStream.getNextEntry()) != null) {
                Object object;
                int n;
                if (zipEntry.isDirectory()) {
                    zipOutputStream.putNextEntry(zipEntry);
                    continue;
                }
                byte[] byArray = new byte[4096];
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                do {
                    if ((n = zipInputStream.read(byArray)) <= 0) continue;
                    byteArrayOutputStream.write(byArray, 0, n);
                } while (n != -1);
                byte[] byArray2 = byteArrayOutputStream.toByteArray();
                String string = zipEntry.getName();
                if (string.endsWith(".class") && !string.startsWith(".")) {
                    object = new ClassNode();
                    ClassReader classReader = new ClassReader(byArray2);
                    classReader.accept((ClassVisitor)object, 0);
                    String string2 = ((ClassNode)object).name.replace('/', '.').replace('\\', '.');
                    for (AccessTransformer accessTransformer : accessTransformerArray) {
                        byArray2 = accessTransformer.transform(string2, string2, byArray2);
                    }
                }
                object = new ZipEntry(string);
                zipOutputStream.putNextEntry((ZipEntry)object);
                zipOutputStream.write(byArray2);
            }
        }
        finally {
            if (zipOutputStream != null) {
                try {
                    zipOutputStream.close();
                }
                catch (IOException iOException) {}
            }
            if (zipInputStream != null) {
                try {
                    zipInputStream.close();
                }
                catch (IOException iOException) {}
            }
        }
    }

    public void ensurePublicAccessFor(String string) {
        Modifier modifier = new Modifier();
        modifier.setTargetAccess("public");
        modifier.modifyClassVisibility = true;
        this.modifiers.put(string, modifier);
    }

    private class Modifier {
        public String name = "";
        public String desc = "";
        public int oldAccess = 0;
        public int newAccess = 0;
        public int targetAccess = 0;
        public boolean changeFinal = false;
        public boolean markFinal = false;
        protected boolean modifyClassVisibility;

        private Modifier() {
        }

        private void setTargetAccess(String string) {
            if (string.startsWith("public")) {
                this.targetAccess = 1;
            } else if (string.startsWith("private")) {
                this.targetAccess = 2;
            } else if (string.startsWith("protected")) {
                this.targetAccess = 4;
            }
            if (string.endsWith("-f")) {
                this.changeFinal = true;
                this.markFinal = false;
            } else if (string.endsWith("+f")) {
                this.changeFinal = true;
                this.markFinal = true;
            }
        }
    }
}

