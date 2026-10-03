/*
 * Decompiled with CFR 0.152.
 */
package codechicken.core.asm;

import codechicken.core.launch.CodeChickenCorePlugin;
import codechicken.lib.asm.ObfMapping;
import java.io.File;
import java.io.PrintWriter;
import org.objectweb.asm.ClassReader;
import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.util.Printer;
import org.objectweb.asm.util.TraceMethodVisitor;

public class MethodASMifier
extends ClassVisitor {
    PrintWriter printWriter;
    ObfMapping method;
    Printer asmifier;

    public MethodASMifier(ObfMapping obfMapping, Printer printer, PrintWriter printWriter) {
        super(262144);
        this.method = obfMapping;
        this.printWriter = printWriter;
        this.asmifier = printer;
    }

    @Override
    public MethodVisitor visitMethod(int n, String string, String string2, String string3, String[] stringArray) {
        if (this.method.matches(string, string2)) {
            Printer printer = this.asmifier.visitMethod(n, string, string2, string3, stringArray);
            return new TraceMethodVisitor(null, printer);
        }
        return null;
    }

    @Override
    public void visitEnd() {
        this.asmifier.visitClassEnd();
        this.asmifier.print(this.printWriter);
        super.visitEnd();
    }

    public static void printMethod(ObfMapping obfMapping, Printer printer, File file) {
        try {
            MethodASMifier.printMethod(obfMapping, CodeChickenCorePlugin.cl.getClassBytes(obfMapping.javaClass()), printer, file);
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    public static void printMethod(ObfMapping obfMapping, byte[] byArray, Printer printer, File file) {
        try {
            if (!file.getParentFile().exists()) {
                file.getParentFile().mkdirs();
            }
            if (!file.exists()) {
                file.createNewFile();
            }
            PrintWriter printWriter = new PrintWriter(file);
            MethodASMifier methodASMifier = new MethodASMifier(obfMapping, printer, printWriter);
            ClassReader classReader = new ClassReader(byArray);
            classReader.accept(methodASMifier, 0);
            printWriter.close();
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
    }
}

