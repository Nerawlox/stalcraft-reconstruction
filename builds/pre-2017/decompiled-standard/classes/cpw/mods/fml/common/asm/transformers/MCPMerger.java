/*
 * Decompiled with CFR 0.152.
 */
package cpw.mods.fml.common.asm.transformers;

import com.google.common.base.Objects;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipOutputStream;
import org.objectweb.asm.ClassReader;
import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.Type;
import org.objectweb.asm.tree.AnnotationNode;
import org.objectweb.asm.tree.ClassNode;
import org.objectweb.asm.tree.FieldNode;
import org.objectweb.asm.tree.MethodNode;

public class MCPMerger {
    private static Hashtable<String, ClassInfo> clients = new Hashtable();
    private static Hashtable<String, ClassInfo> shared = new Hashtable();
    private static Hashtable<String, ClassInfo> servers = new Hashtable();
    private static HashSet<String> copyToServer = new HashSet();
    private static HashSet<String> copyToClient = new HashSet();
    private static HashSet<String> dontAnnotate = new HashSet();
    private static HashSet<String> dontProcess = new HashSet();
    private static final boolean DEBUG = false;

    public static void main(String[] stringArray) {
        if (stringArray.length != 3) {
            System.out.println("Usage: MCPMerger <MapFile> <minecraft.jar> <minecraft_server.jar>");
            System.exit(1);
        }
        File file = new File(stringArray[0]);
        File file2 = new File(stringArray[1]);
        File file3 = new File(stringArray[2]);
        File file4 = new File(stringArray[1] + ".backup_merge");
        File file5 = new File(stringArray[2] + ".backup_merge");
        if (file4.exists() && !file4.delete()) {
            System.out.println("Could not delete temp file: " + file4);
        }
        if (file5.exists() && !file5.delete()) {
            System.out.println("Could not delete temp file: " + file5);
        }
        if (!file2.exists()) {
            System.out.println("Could not find minecraft.jar: " + file2);
            System.exit(1);
        }
        if (!file3.exists()) {
            System.out.println("Could not find minecraft_server.jar: " + file3);
            System.exit(1);
        }
        if (!file2.renameTo(file4)) {
            System.out.println("Could not rename file: " + file2 + " -> " + file4);
            System.exit(1);
        }
        if (!file3.renameTo(file5)) {
            System.out.println("Could not rename file: " + file3 + " -> " + file5);
            System.exit(1);
        }
        if (!MCPMerger.readMapFile(file)) {
            System.out.println("Could not read map file: " + file);
            System.exit(1);
        }
        try {
            MCPMerger.processJar(file4, file5, file2, file3);
        }
        catch (IOException iOException) {
            iOException.printStackTrace();
            System.exit(1);
        }
        if (!file4.delete()) {
            System.out.println("Could not delete temp file: " + file4);
        }
        if (!file5.delete()) {
            System.out.println("Could not delete temp file: " + file5);
        }
    }

    private static boolean readMapFile(File file) {
        try {
            String string;
            FileInputStream fileInputStream = new FileInputStream(file);
            DataInputStream dataInputStream = new DataInputStream(fileInputStream);
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(dataInputStream));
            while ((string = bufferedReader.readLine()) != null) {
                string = string.split("#")[0];
                char c = string.charAt(0);
                string = string.substring(1).trim();
                switch (c) {
                    case '!': {
                        dontAnnotate.add(string);
                        break;
                    }
                    case '<': {
                        copyToClient.add(string);
                        break;
                    }
                    case '>': {
                        copyToServer.add(string);
                        break;
                    }
                    case '^': {
                        dontProcess.add(string);
                    }
                }
            }
            dataInputStream.close();
            return true;
        }
        catch (Exception exception) {
            System.err.println("Error: " + exception.getMessage());
            return false;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static void processJar(File file, File file2, File file3, File file4) throws IOException {
        ZipFile zipFile = null;
        ZipFile zipFile2 = null;
        ZipOutputStream zipOutputStream = null;
        ZipOutputStream zipOutputStream2 = null;
        try {
            Object object;
            Object object2;
            Object object3;
            try {
                zipFile = new ZipFile(file);
                zipFile2 = new ZipFile(file2);
            }
            catch (FileNotFoundException fileNotFoundException) {
                throw new FileNotFoundException("Could not open input file: " + fileNotFoundException.getMessage());
            }
            try {
                zipOutputStream = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(file3)));
                zipOutputStream2 = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(file4)));
            }
            catch (FileNotFoundException fileNotFoundException) {
                throw new FileNotFoundException("Could not open output file: " + fileNotFoundException.getMessage());
            }
            Hashtable<String, ZipEntry> hashtable = MCPMerger.getClassEntries(zipFile, zipOutputStream);
            Hashtable<String, ZipEntry> hashtable2 = MCPMerger.getClassEntries(zipFile2, zipOutputStream2);
            HashSet<String> hashSet = new HashSet<String>();
            HashSet<String> hashSet2 = new HashSet<String>();
            for (Map.Entry<String, ZipEntry> entry : hashtable.entrySet()) {
                String string = entry.getKey();
                ZipEntry object4 = entry.getValue();
                object3 = hashtable2.get(string);
                if (object3 == null) {
                    if (!copyToServer.contains(string)) {
                        MCPMerger.copyClass(zipFile, object4, zipOutputStream, null, true);
                        hashSet.add(string);
                        continue;
                    }
                    MCPMerger.copyClass(zipFile, object4, zipOutputStream, zipOutputStream2, true);
                    hashSet.add(string);
                    hashSet2.add(string);
                    continue;
                }
                hashtable2.remove(string);
                object2 = new ClassInfo(string);
                shared.put(string, (ClassInfo)object2);
                object = MCPMerger.readEntry(zipFile, entry.getValue());
                byte[] byArray = MCPMerger.readEntry(zipFile2, (ZipEntry)object3);
                byte[] byArray2 = MCPMerger.processClass(object, byArray, (ClassInfo)object2);
                ZipEntry zipEntry = new ZipEntry(object4.getName());
                zipOutputStream.putNextEntry(zipEntry);
                zipOutputStream.write(byArray2);
                zipOutputStream2.putNextEntry(zipEntry);
                zipOutputStream2.write(byArray2);
                hashSet.add(string);
                hashSet2.add(string);
            }
            for (Map.Entry<String, ZipEntry> entry : hashtable2.entrySet()) {
                MCPMerger.copyClass(zipFile2, entry.getValue(), zipOutputStream, zipOutputStream2, false);
            }
            for (String string : new String[]{SideOnly.class.getName(), Side.class.getName()}) {
                object3 = string.replace(".", "/");
                object2 = MCPMerger.getClassBytes(string);
                object = new ZipEntry(string.replace(".", "/").concat(".class"));
                if (!hashSet.contains(object3)) {
                    zipOutputStream.putNextEntry((ZipEntry)object);
                    zipOutputStream.write((byte[])object2);
                }
                if (hashSet2.contains(object3)) continue;
                zipOutputStream2.putNextEntry((ZipEntry)object);
                zipOutputStream2.write((byte[])object2);
            }
        }
        finally {
            if (zipFile != null) {
                try {
                    zipFile.close();
                }
                catch (IOException iOException) {}
            }
            if (zipFile2 != null) {
                try {
                    zipFile2.close();
                }
                catch (IOException iOException) {}
            }
            if (zipOutputStream != null) {
                try {
                    zipOutputStream.close();
                }
                catch (IOException iOException) {}
            }
            if (zipOutputStream2 != null) {
                try {
                    zipOutputStream2.close();
                }
                catch (IOException iOException) {}
            }
        }
    }

    private static void copyClass(ZipFile zipFile, ZipEntry zipEntry, ZipOutputStream zipOutputStream, ZipOutputStream zipOutputStream2, boolean bl) throws IOException {
        ClassReader classReader = new ClassReader(MCPMerger.readEntry(zipFile, zipEntry));
        ClassNode classNode = new ClassNode();
        classReader.accept(classNode, 0);
        if (!dontAnnotate.contains(classNode.name)) {
            if (classNode.visibleAnnotations == null) {
                classNode.visibleAnnotations = new ArrayList<AnnotationNode>();
            }
            classNode.visibleAnnotations.add(MCPMerger.getSideAnn(bl));
        }
        ClassWriter classWriter = new ClassWriter(1);
        classNode.accept(classWriter);
        byte[] byArray = classWriter.toByteArray();
        ZipEntry zipEntry2 = new ZipEntry(zipEntry.getName());
        if (zipOutputStream != null) {
            zipOutputStream.putNextEntry(zipEntry2);
            zipOutputStream.write(byArray);
        }
        if (zipOutputStream2 != null) {
            zipOutputStream2.putNextEntry(zipEntry2);
            zipOutputStream2.write(byArray);
        }
    }

    private static AnnotationNode getSideAnn(boolean bl) {
        AnnotationNode annotationNode = new AnnotationNode(Type.getDescriptor(SideOnly.class));
        annotationNode.values = new ArrayList<Object>();
        annotationNode.values.add("value");
        annotationNode.values.add(new String[]{Type.getDescriptor(Side.class), bl ? "CLIENT" : "SERVER"});
        return annotationNode;
    }

    private static Hashtable<String, ZipEntry> getClassEntries(ZipFile zipFile, ZipOutputStream zipOutputStream) throws IOException {
        Hashtable<String, ZipEntry> hashtable = new Hashtable<String, ZipEntry>();
        for (ZipEntry zipEntry : Collections.list(zipFile.entries())) {
            if (zipEntry.isDirectory()) {
                zipOutputStream.putNextEntry(zipEntry);
                continue;
            }
            String string = zipEntry.getName();
            boolean bl = false;
            for (String string2 : dontProcess) {
                if (!string.startsWith(string2)) continue;
                bl = true;
                break;
            }
            if (bl || !string.endsWith(".class") || string.startsWith(".")) {
                ZipEntry zipEntry2 = new ZipEntry(zipEntry.getName());
                zipOutputStream.putNextEntry(zipEntry2);
                zipOutputStream.write(MCPMerger.readEntry(zipFile, zipEntry));
                continue;
            }
            hashtable.put(string.replace(".class", ""), zipEntry);
        }
        return hashtable;
    }

    private static byte[] readEntry(ZipFile zipFile, ZipEntry zipEntry) throws IOException {
        return MCPMerger.readFully(zipFile.getInputStream(zipEntry));
    }

    private static byte[] readFully(InputStream inputStream) throws IOException {
        int n;
        byte[] byArray = new byte[4096];
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        do {
            if ((n = inputStream.read(byArray)) <= 0) continue;
            byteArrayOutputStream.write(byArray, 0, n);
        } while (n != -1);
        return byteArrayOutputStream.toByteArray();
    }

    public static byte[] processClass(byte[] byArray, byte[] byArray2, ClassInfo classInfo) {
        ClassNode classNode = MCPMerger.getClassNode(byArray);
        ClassNode classNode2 = MCPMerger.getClassNode(byArray2);
        MCPMerger.processFields(classNode, classNode2, classInfo);
        MCPMerger.processMethods(classNode, classNode2, classInfo);
        ClassWriter classWriter = new ClassWriter(1);
        classNode.accept(classWriter);
        return classWriter.toByteArray();
    }

    private static ClassNode getClassNode(byte[] byArray) {
        ClassReader classReader = new ClassReader(byArray);
        ClassNode classNode = new ClassNode();
        classReader.accept(classNode, 0);
        return classNode;
    }

    private static void processFields(ClassNode classNode, ClassNode classNode2, ClassInfo classInfo) {
        FieldNode fieldNode;
        int n;
        List<FieldNode> list = classNode.fields;
        List<FieldNode> list2 = classNode2.fields;
        int n2 = 0;
        for (n = 0; n < list.size(); ++n) {
            fieldNode = list.get(n);
            if (n2 < list2.size()) {
                if (!fieldNode.name.equals(list2.get((int)n2).name)) {
                    int n3;
                    boolean bl = false;
                    for (n3 = n2 + 1; n3 < list2.size(); ++n3) {
                        if (!fieldNode.name.equals(list2.get((int)n3).name)) continue;
                        bl = true;
                        break;
                    }
                    if (bl) {
                        n3 = 0;
                        FieldNode fieldNode2 = list2.get(n2);
                        for (int i = n + 1; i < list.size(); ++i) {
                            if (!fieldNode2.name.equals(list.get((int)i).name)) continue;
                            n3 = 1;
                            break;
                        }
                        if (n3 == 0) {
                            if (fieldNode2.visibleAnnotations == null) {
                                fieldNode2.visibleAnnotations = new ArrayList<AnnotationNode>();
                            }
                            fieldNode2.visibleAnnotations.add(MCPMerger.getSideAnn(false));
                            list.add(n++, fieldNode2);
                            classInfo.sField.add(fieldNode2);
                        }
                    } else {
                        if (fieldNode.visibleAnnotations == null) {
                            fieldNode.visibleAnnotations = new ArrayList<AnnotationNode>();
                        }
                        fieldNode.visibleAnnotations.add(MCPMerger.getSideAnn(true));
                        list2.add(n2, fieldNode);
                        classInfo.cField.add(fieldNode);
                    }
                }
            } else {
                if (fieldNode.visibleAnnotations == null) {
                    fieldNode.visibleAnnotations = new ArrayList<AnnotationNode>();
                }
                fieldNode.visibleAnnotations.add(MCPMerger.getSideAnn(true));
                list2.add(n2, fieldNode);
                classInfo.cField.add(fieldNode);
            }
            ++n2;
        }
        if (list2.size() != list.size()) {
            for (n = list.size(); n < list2.size(); ++n) {
                fieldNode = list2.get(n);
                if (fieldNode.visibleAnnotations == null) {
                    fieldNode.visibleAnnotations = new ArrayList<AnnotationNode>();
                }
                fieldNode.visibleAnnotations.add(MCPMerger.getSideAnn(true));
                list.add(n++, fieldNode);
                classInfo.sField.add(fieldNode);
            }
        }
    }

    private static void processMethods(ClassNode classNode, ClassNode classNode2, ClassInfo classInfo) {
        String string;
        List<MethodNode> list = classNode.methods;
        List<MethodNode> list2 = classNode2.methods;
        LinkedHashSet<MethodWrapper> linkedHashSet = Sets.newLinkedHashSet();
        int n = 0;
        int n2 = 0;
        int n3 = list.size();
        int n4 = list2.size();
        String string2 = string = "";
        String string3 = "";
        block0: while (n < n3 || n2 < n4) {
            MethodWrapper methodWrapper;
            Object object;
            while (n2 < n4) {
                object = list2.get(n2);
                string3 = ((MethodNode)object).name;
                if (!string3.equals(string2) && n != n3) break;
                methodWrapper = new MethodWrapper((MethodNode)object);
                methodWrapper.server = true;
                linkedHashSet.add(methodWrapper);
                if (++n2 < n4) continue;
            }
            while (n < n3) {
                object = list.get(n);
                string = ((MethodNode)object).name;
                string2 = string;
                if (!string.equals(string2) && n2 != n4) continue block0;
                methodWrapper = new MethodWrapper((MethodNode)object);
                methodWrapper.client = true;
                linkedHashSet.add(methodWrapper);
                if (++n < n3) continue;
                continue block0;
            }
        }
        list.clear();
        list2.clear();
        for (MethodWrapper methodWrapper : linkedHashSet) {
            list.add(methodWrapper.node);
            list2.add(methodWrapper.node);
            if (methodWrapper.server && methodWrapper.client) continue;
            if (((MethodWrapper)methodWrapper).node.visibleAnnotations == null) {
                ((MethodWrapper)methodWrapper).node.visibleAnnotations = Lists.newArrayListWithExpectedSize(1);
            }
            ((MethodWrapper)methodWrapper).node.visibleAnnotations.add(MCPMerger.getSideAnn(methodWrapper.client));
            if (methodWrapper.client) {
                classInfo.sMethods.add(methodWrapper.node);
                continue;
            }
            classInfo.cMethods.add(methodWrapper.node);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static byte[] getClassBytes(String string) throws IOException {
        InputStream inputStream = null;
        try {
            inputStream = MCPMerger.class.getResourceAsStream("/" + string.replace('.', '/').concat(".class"));
            byte[] byArray = MCPMerger.readFully(inputStream);
            return byArray;
        }
        finally {
            if (inputStream != null) {
                try {
                    inputStream.close();
                }
                catch (IOException iOException) {}
            }
        }
    }

    private static class MethodWrapper {
        private MethodNode node;
        public boolean client;
        public boolean server;

        public MethodWrapper(MethodNode methodNode) {
            this.node = methodNode;
        }

        public boolean equals(Object object) {
            boolean bl;
            if (object == null || !(object instanceof MethodWrapper)) {
                return false;
            }
            MethodWrapper methodWrapper = (MethodWrapper)object;
            boolean bl2 = bl = Objects.equal(this.node.name, methodWrapper.node.name) && Objects.equal(this.node.desc, methodWrapper.node.desc);
            if (bl) {
                methodWrapper.client = this.client | methodWrapper.client;
                methodWrapper.server = this.server | methodWrapper.server;
                this.client |= methodWrapper.client;
                this.server |= methodWrapper.server;
            }
            return bl;
        }

        public int hashCode() {
            return Objects.hashCode(this.node.name, this.node.desc);
        }

        public String toString() {
            return Objects.toStringHelper(this).add("name", this.node.name).add("desc", this.node.desc).add("server", this.server).add("client", this.client).toString();
        }
    }

    private static class ClassInfo {
        public String name;
        public ArrayList<FieldNode> cField = new ArrayList();
        public ArrayList<FieldNode> sField = new ArrayList();
        public ArrayList<MethodNode> cMethods = new ArrayList();
        public ArrayList<MethodNode> sMethods = new ArrayList();

        public ClassInfo(String string) {
            this.name = string;
        }

        public boolean isSame() {
            return this.cField.size() == 0 && this.sField.size() == 0 && this.cMethods.size() == 0 && this.sMethods.size() == 0;
        }
    }
}

