/*
 * Decompiled with CFR 0.152.
 */
package codechicken.obfuscator;

import codechicken.obfuscator.ConstantObfuscator;
import codechicken.obfuscator.DummyOutputStream;
import codechicken.obfuscator.ILogStreams;
import codechicken.obfuscator.ObfDirection;
import codechicken.obfuscator.ObfRemapper;
import codechicken.obfuscator.ObfuscationMap;
import com.google.common.base.Function;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.PrintStream;
import java.text.DecimalFormat;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.commons.RemappingClassAdapter;
import org.objectweb.asm.tree.ClassNode;

public class ObfuscationRun
implements ILogStreams {
    public final ObfDirection obfDir;
    public final ObfuscationMap obf;
    public final ObfRemapper obfMapper;
    public final ConstantObfuscator cstMappper;
    public File[] mappings;
    public Map<String, String> config;
    private PrintStream out = System.out;
    private PrintStream err = System.err;
    private PrintStream quietStream = new PrintStream(DummyOutputStream.instance);
    private boolean verbose;
    private boolean quiet;
    public boolean clean;
    private long startTime;
    private boolean finished;

    public ObfuscationRun(boolean bl, File[] fileArray, Map<String, String> map) {
        this.obfDir = new ObfDirection().setObfuscate(bl);
        this.mappings = fileArray;
        this.config = map;
        this.obf = new ObfuscationMap().setLog(this);
        this.obfMapper = new ObfRemapper(this.obf, this.obfDir);
        this.cstMappper = new ConstantObfuscator(this.obfMapper, map.get("classConstantCalls").split(","), map.get("descConstantCalls").split(","));
    }

    public ObfuscationRun setClean() {
        this.clean = true;
        return this;
    }

    public ObfuscationRun setVerbose() {
        this.verbose = true;
        return this;
    }

    public ObfuscationRun setQuiet() {
        this.quiet = true;
        return this;
    }

    public ObfuscationRun setOut(PrintStream printStream) {
        this.out = printStream;
        return this;
    }

    @Override
    public PrintStream out() {
        return this.quiet ? this.quietStream : this.out;
    }

    public PrintStream fine() {
        return this.verbose ? this.out : this.quietStream;
    }

    public ObfuscationRun setErr(PrintStream printStream) {
        this.err = printStream;
        return this;
    }

    @Override
    public PrintStream err() {
        return this.quiet ? this.quietStream : this.err;
    }

    public ObfuscationRun setSearge() {
        this.obfDir.setSearge(true);
        return this;
    }

    public ObfuscationRun setSeargeConstants() {
        this.obfDir.setSeargeConstants(true);
        return this;
    }

    public void start() {
        this.startTime = System.currentTimeMillis();
    }

    public static Map<String, String> fillDefaults(Map<String, String> map) {
        if (!map.containsKey("excludedPackages")) {
            map.put("excludedPackages", "java/;sun/;javax/;scala/;argo/;org/lwjgl/;org/objectweb/;org/bouncycastle/;com/google/");
        }
        if (!map.containsKey("ignore")) {
            map.put("ignore", ".");
        }
        if (!map.containsKey("classConstantCalls")) {
            map.put("classConstantCalls", "codechicken/lib/asm/ObfMapping.<init>(Ljava/lang/String;)V,codechicken/lib/asm/ObfMapping.subclass(Ljava/lang/String;)Lcodechicken/lib/asm/ObfMapping;,codechicken/lib/asm/ObfMapping.<init>(Lcodechicken/lib/asm/ObfMapping;Ljava/lang/String;)V");
        }
        if (!map.containsKey("descConstantCalls")) {
            map.put("descConstantCalls", "codechicken/lib/asm/ObfMapping.<init>(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V,org/objectweb/asm/MethodVisitor.visitFieldInsn(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V,org/objectweb/asm/tree/MethodNode.visitFieldInsn(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V,org/objectweb/asm/MethodVisitor.visitMethodInsn(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V,org/objectweb/asm/tree/MethodNode.visitMethodInsn(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V,org/objectweb/asm/tree/MethodInsnNode.<init>(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V,org/objectweb/asm/tree/FieldInsnNode.<init>(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V");
        }
        return map;
    }

    public static void processLines(File file, Function<String, Void> function) {
        try {
            String string;
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            while ((string = bufferedReader.readLine()) != null) {
                function.apply(string);
            }
            bufferedReader.close();
        }
        catch (Exception exception) {
            throw new RuntimeException(exception);
        }
    }

    public static void processFiles(File file, Function<File, Void> function, boolean bl) {
        for (File file2 : file.listFiles()) {
            if (file2.isDirectory() && bl) {
                ObfuscationRun.processFiles(file2, function, bl);
                continue;
            }
            function.apply(file2);
        }
    }

    public static void deleteDir(File file, boolean bl) {
        if (!file.exists()) {
            if (!bl) {
                file.mkdirs();
            }
            return;
        }
        for (File file2 : file.listFiles()) {
            if (file2.isDirectory()) {
                ObfuscationRun.deleteDir(file2, true);
                continue;
            }
            if (file2.delete()) continue;
            throw new RuntimeException("Delete Failed: " + file2);
        }
        if (bl && !file.delete()) {
            throw new RuntimeException("Delete Failed: " + file);
        }
    }

    public static File[] parseConfDir(File file) {
        File file2;
        File file3;
        File file4 = new File(file, "conf");
        if (!file4.exists()) {
            file4 = file;
        }
        if (!(file3 = new File(file4, "packaged.srg")).exists()) {
            file3 = new File(file4, "joined.srg");
        }
        if (!file3.exists()) {
            throw new RuntimeException("Could not find packaged.srg or joined.srg");
        }
        File file5 = new File(file, "mappings");
        if (!file5.exists()) {
            file5 = file;
        }
        if (!(file2 = new File(file5, "methods.csv")).exists()) {
            throw new RuntimeException("Could not find methods.csv");
        }
        File file6 = new File(file5, "fields.csv");
        if (!file6.exists()) {
            throw new RuntimeException("Could not find fields.csv");
        }
        return new File[]{file3, file2, file6};
    }

    public long startTime() {
        return this.startTime;
    }

    public void remap(ClassNode classNode, ClassVisitor classVisitor) {
        this.cstMappper.transform(classNode);
        classNode.accept(new RemappingClassAdapter(classVisitor, this.obfMapper));
    }

    public static List<String> getParents(ClassNode classNode) {
        LinkedList<String> linkedList = new LinkedList<String>();
        if (classNode.superName != null) {
            linkedList.add(classNode.superName);
        }
        for (String string : classNode.interfaces) {
            linkedList.add(string);
        }
        return linkedList;
    }

    public void finish(boolean bl) {
        long l = System.currentTimeMillis() - this.startTime;
        this.out().println((bl ? "Errored after" : "Done in ") + new DecimalFormat("0.00").format((double)l / 1000.0) + "s");
        this.finished = true;
    }

    public boolean finished() {
        return this.finished;
    }

    public void parseMappings() {
        this.obf.parseMappings(this.mappings);
    }
}

