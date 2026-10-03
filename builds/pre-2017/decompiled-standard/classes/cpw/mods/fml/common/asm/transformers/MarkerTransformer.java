/*
 * Decompiled with CFR 0.152.
 */
package cpw.mods.fml.common.asm.transformers;

import com.google.common.base.Charsets;
import com.google.common.base.Splitter;
import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Iterables;
import com.google.common.collect.ListMultimap;
import com.google.common.collect.Lists;
import com.google.common.io.LineProcessor;
import com.google.common.io.Resources;
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

public class MarkerTransformer
implements IClassTransformer {
    private ListMultimap<String, String> markers = ArrayListMultimap.create();

    public MarkerTransformer() throws IOException {
        this("fml_marker.cfg");
    }

    protected MarkerTransformer(String string) throws IOException {
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
                if (arrayList.size() != 2) {
                    throw new RuntimeException("Invalid config file line " + string);
                }
                ArrayList<String> arrayList2 = Lists.newArrayList(Splitter.on(",").trimResults().split((CharSequence)arrayList.get(1)));
                for (String string3 : arrayList2) {
                    MarkerTransformer.this.markers.put(arrayList.get(0), string3);
                }
                return true;
            }
        });
    }

    @Override
    public byte[] transform(String string, String string2, byte[] byArray) {
        if (byArray == null) {
            return null;
        }
        if (!this.markers.containsKey(string)) {
            return byArray;
        }
        ClassNode classNode = new ClassNode();
        ClassReader classReader = new ClassReader(byArray);
        classReader.accept(classNode, 0);
        for (String string3 : this.markers.get(string)) {
            classNode.interfaces.add(string3);
        }
        ClassWriter classWriter = new ClassWriter(1);
        classNode.accept(classWriter);
        return classWriter.toByteArray();
    }

    public static void main(String[] stringArray) {
        if (stringArray.length < 2) {
            System.out.println("Usage: MarkerTransformer <JarPath> <MapFile> [MapFile2]... ");
            return;
        }
        boolean bl = false;
        MarkerTransformer[] markerTransformerArray = new MarkerTransformer[stringArray.length - 1];
        for (int i = 1; i < stringArray.length; ++i) {
            try {
                markerTransformerArray[i - 1] = new MarkerTransformer(stringArray[i]);
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
            return;
        }
        File file = new File(stringArray[0]);
        File file2 = new File(stringArray[0] + ".ATBack");
        if (!file.exists() && !file2.exists()) {
            System.out.println("Could not find target jar: " + file);
            return;
        }
        if (!file.renameTo(file2)) {
            System.out.println("Could not rename file: " + file + " -> " + file2);
            return;
        }
        try {
            MarkerTransformer.processJar(file2, file, markerTransformerArray);
        }
        catch (IOException iOException) {
            iOException.printStackTrace();
        }
        if (!file2.delete()) {
            System.out.println("Could not delete temp file: " + file2);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private static void processJar(File file, File file2, MarkerTransformer[] markerTransformerArray) throws IOException {
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
                    for (MarkerTransformer markerTransformer : markerTransformerArray) {
                        byArray2 = markerTransformer.transform(string2, string2, byArray2);
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
}

