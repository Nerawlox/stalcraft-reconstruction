/*
 * Decompiled with CFR 0.152.
 */
package gloomyfolken.hooklib.asm;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import org.apache.commons.io.IOUtils;
import org.objectweb.asm.ClassReader;
import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Type;

public class ClassMetadataReader {
    private static Method m;

    public byte[] getClassData(String string) throws IOException {
        String string2 = '/' + string.replace('.', '/') + ".class";
        return IOUtils.toByteArray(ClassMetadataReader.class.getResourceAsStream(string2));
    }

    public void acceptVisitor(byte[] byArray, ClassVisitor classVisitor) {
        new ClassReader(byArray).accept(classVisitor, 0);
    }

    public void acceptVisitor(String string, ClassVisitor classVisitor) throws IOException {
        this.acceptVisitor(this.getClassData(string), classVisitor);
    }

    public MethodReference findVirtualMethod(String string, String string2, String string3) {
        ArrayList<String> arrayList = this.getSuperClasses(string);
        for (int i = arrayList.size() - 1; i > 0; --i) {
            String string4 = arrayList.get(i);
            MethodReference methodReference = this.getMethodReference(string4, string2, string3);
            if (methodReference == null) continue;
            System.out.println("found virtual method: " + methodReference);
            return methodReference;
        }
        return null;
    }

    private MethodReference getMethodReference(String string, String string2, String string3) {
        try {
            return this.getMethodReferenceASM(string, string2, string3);
        }
        catch (Exception exception) {
            return this.getMethodReferenceReflect(string, string2, string3);
        }
    }

    protected MethodReference getMethodReferenceASM(String string, String string2, String string3) throws IOException {
        FindMethodClassVisitor findMethodClassVisitor = new FindMethodClassVisitor(string2, string3);
        this.acceptVisitor(string, (ClassVisitor)findMethodClassVisitor);
        if (findMethodClassVisitor.found) {
            return new MethodReference(string, findMethodClassVisitor.targetName, findMethodClassVisitor.targetDesc);
        }
        return null;
    }

    protected MethodReference getMethodReferenceReflect(String string, String string2, String string3) {
        Class clazz = this.getLoadedClass(string);
        if (clazz != null) {
            for (Method method : clazz.getDeclaredMethods()) {
                if (!this.checkSameMethod(string2, string3, method.getName(), Type.getMethodDescriptor(method))) continue;
                return new MethodReference(string, method.getName(), Type.getMethodDescriptor(method));
            }
        }
        return null;
    }

    protected boolean checkSameMethod(String string, String string2, String string3, String string4) {
        return string.equals(string3) && string2.equals(string4);
    }

    public ArrayList<String> getSuperClasses(String string) {
        ArrayList<String> arrayList = new ArrayList<String>(1);
        arrayList.add(string);
        while ((string = this.getSuperClass(string)) != null) {
            arrayList.add(string);
        }
        Collections.reverse(arrayList);
        return arrayList;
    }

    private Class getLoadedClass(String string) {
        if (m != null) {
            try {
                ClassLoader classLoader = ClassMetadataReader.class.getClassLoader();
                return (Class)m.invoke(classLoader, string.replace('/', '.'));
            }
            catch (Exception exception) {
                exception.printStackTrace();
            }
        }
        return null;
    }

    public String getSuperClass(String string) {
        try {
            return this.getSuperClassASM(string);
        }
        catch (Exception exception) {
            return this.getSuperClassReflect(string);
        }
    }

    protected String getSuperClassASM(String string) throws IOException {
        CheckSuperClassVisitor checkSuperClassVisitor = new CheckSuperClassVisitor();
        this.acceptVisitor(string, (ClassVisitor)checkSuperClassVisitor);
        return checkSuperClassVisitor.superClassName;
    }

    protected String getSuperClassReflect(String string) {
        Class clazz = this.getLoadedClass(string);
        if (clazz != null) {
            if (clazz.getSuperclass() == null) {
                return null;
            }
            return clazz.getSuperclass().getName().replace('.', '/');
        }
        return "java/lang/Object";
    }

    static {
        try {
            m = ClassLoader.class.getDeclaredMethod("findLoadedClass", String.class);
            m.setAccessible(true);
        }
        catch (NoSuchMethodException noSuchMethodException) {
            noSuchMethodException.printStackTrace();
        }
    }

    public static class MethodReference {
        public final String owner;
        public final String name;
        public final String desc;

        public MethodReference(String string, String string2, String string3) {
            this.owner = string;
            this.name = string2;
            this.desc = string3;
        }

        public Type getType() {
            return Type.getMethodType(this.desc);
        }

        public String toString() {
            return "MethodReference{owner='" + this.owner + '\'' + ", name='" + this.name + '\'' + ", desc='" + this.desc + '\'' + '}';
        }
    }

    protected class FindMethodClassVisitor
    extends ClassVisitor {
        public String targetName;
        public String targetDesc;
        public boolean found;

        public FindMethodClassVisitor(String string, String string2) {
            super(327680);
            this.targetName = string;
            this.targetDesc = string2;
        }

        @Override
        public MethodVisitor visitMethod(int n, String string, String string2, String string3, String[] stringArray) {
            System.out.println("visiting " + string + "#" + string2);
            if ((n & 2) == 0 && ClassMetadataReader.this.checkSameMethod(string, string2, this.targetName, this.targetDesc)) {
                this.found = true;
                this.targetName = string;
                this.targetDesc = string2;
            }
            return null;
        }
    }

    private class CheckSuperClassVisitor
    extends ClassVisitor {
        String superClassName;

        public CheckSuperClassVisitor() {
            super(327680);
        }

        @Override
        public void visit(int n, int n2, String string, String string2, String string3, String[] stringArray) {
            this.superClassName = string3;
        }
    }
}

