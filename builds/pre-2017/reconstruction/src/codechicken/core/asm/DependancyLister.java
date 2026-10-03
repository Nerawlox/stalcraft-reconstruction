/*
 * Decompiled with CFR 0.152.
 */
package codechicken.core.asm;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.FieldVisitor;
import org.objectweb.asm.Label;
import org.objectweb.asm.MethodVisitor;

public class DependancyLister
extends ClassVisitor {
    private static Pattern classdesc = Pattern.compile("L(.+?);");
    private HashSet<String> dependancies = new HashSet();

    public DependancyLister(int n) {
        super(n);
    }

    @Override
    public FieldVisitor visitField(int n, String string, String string2, String string3, Object object) {
        this.dependDesc(string2);
        return null;
    }

    private void dependDesc(String string) {
        Matcher matcher = classdesc.matcher(string);
        while (matcher.find()) {
            String string2 = matcher.group();
            this.depend(string2.substring(1, string2.length() - 1));
        }
    }

    private void depend(String string) {
        this.dependancies.add(string);
    }

    @Override
    public MethodVisitor visitMethod(int n, String string, String string2, String string3, String[] stringArray) {
        this.dependDesc(string2);
        return new DependancyMethodLister(262144);
    }

    @Override
    public void visit(int n, int n2, String string, String string2, String string3, String[] stringArray) {
        this.depend(string3);
        if (stringArray != null) {
            for (String string4 : stringArray) {
                this.depend(string4);
            }
        }
    }

    public List<String> getDependancies() {
        return new ArrayList<String>(this.dependancies);
    }

    private class DependancyMethodLister
    extends MethodVisitor {
        public DependancyMethodLister(int n) {
            super(n);
        }

        @Override
        public void visitFieldInsn(int n, String string, String string2, String string3) {
            DependancyLister.this.dependDesc(string3);
        }

        @Override
        public void visitLocalVariable(String string, String string2, String string3, Label label, Label label2, int n) {
            DependancyLister.this.dependDesc(string2);
        }

        @Override
        public void visitMethodInsn(int n, String string, String string2, String string3) {
            DependancyLister.this.depend(string);
            DependancyLister.this.dependDesc(string3);
        }
    }
}

