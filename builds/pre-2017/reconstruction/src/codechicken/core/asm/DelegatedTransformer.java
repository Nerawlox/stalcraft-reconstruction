/*
 * Decompiled with CFR 0.152.
 */
package codechicken.core.asm;

import codechicken.core.asm.DependancyLister;
import codechicken.core.launch.CodeChickenCorePlugin;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Map;
import java.util.Stack;
import java.util.jar.JarFile;
import java.util.zip.ZipEntry;
import net.minecraft.launchwrapper.IClassTransformer;
import net.minecraft.launchwrapper.LaunchClassLoader;
import org.objectweb.asm.ClassReader;

public class DelegatedTransformer
implements IClassTransformer {
    private static ArrayList<IClassTransformer> delegatedTransformers;
    private static Method m_defineClass;
    private static Field f_cachedClasses;

    public DelegatedTransformer() {
        delegatedTransformers = new ArrayList();
        try {
            m_defineClass = ClassLoader.class.getDeclaredMethod("defineClass", String.class, byte[].class, Integer.TYPE, Integer.TYPE);
            m_defineClass.setAccessible(true);
            f_cachedClasses = LaunchClassLoader.class.getDeclaredField("cachedClasses");
            f_cachedClasses.setAccessible(true);
        }
        catch (Exception exception) {
            throw new RuntimeException(exception);
        }
    }

    @Override
    public byte[] transform(String string, String string2, byte[] byArray) {
        if (byArray == null) {
            return null;
        }
        for (IClassTransformer iClassTransformer : delegatedTransformers) {
            byArray = iClassTransformer.transform(string, string2, byArray);
        }
        return byArray;
    }

    public static void addTransformer(String string, JarFile jarFile, File file) {
        try {
            Object object;
            Object object2;
            byte[] byArray = null;
            byArray = CodeChickenCorePlugin.cl.getClassBytes(string);
            if (byArray == null) {
                object2 = string.replace('.', '/') + ".class";
                object = jarFile.getEntry((String)object2);
                if (object == null) {
                    throw new Exception("Failed to add transformer: " + string + ". Entry not found in jar file " + file.getName());
                }
                byArray = DelegatedTransformer.readFully(jarFile.getInputStream((ZipEntry)object));
            }
            DelegatedTransformer.defineDependancies(byArray, jarFile, file);
            object2 = DelegatedTransformer.defineClass(string, byArray);
            if (!IClassTransformer.class.isAssignableFrom((Class<?>)object2)) {
                throw new Exception("Failed to add transformer: " + string + " is not an instance of IClassTransformer");
            }
            try {
                object = (IClassTransformer)((Class)object2).getDeclaredConstructor(File.class).newInstance(file);
            }
            catch (NoSuchMethodException noSuchMethodException) {
                object = (IClassTransformer)((Class)object2).newInstance();
            }
            delegatedTransformers.add((IClassTransformer)object);
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    private static void defineDependancies(byte[] byArray, JarFile jarFile, File file) throws Exception {
        DelegatedTransformer.defineDependancies(byArray, jarFile, file, new Stack<String>());
    }

    private static void defineDependancies(byte[] byArray, JarFile jarFile, File file, Stack<String> stack) throws Exception {
        ClassReader classReader = new ClassReader(byArray);
        DependancyLister dependancyLister = new DependancyLister(262144);
        classReader.accept(dependancyLister, 0);
        stack.push(classReader.getClassName());
        for (String string : dependancyLister.getDependancies()) {
            if (stack.contains(string)) continue;
            try {
                CodeChickenCorePlugin.cl.loadClass(string.replace('/', '.'));
            }
            catch (ClassNotFoundException classNotFoundException) {
                ZipEntry zipEntry = jarFile.getEntry(string + ".class");
                if (zipEntry == null) {
                    throw new Exception("Dependancy " + string + " not found in jar file " + file.getName());
                }
                byte[] byArray2 = DelegatedTransformer.readFully(jarFile.getInputStream(zipEntry));
                DelegatedTransformer.defineDependancies(byArray2, jarFile, file, stack);
                System.out.println("Defining dependancy: " + string);
                DelegatedTransformer.defineClass(string.replace('/', '.'), byArray2);
            }
        }
        stack.pop();
    }

    private static Class<?> defineClass(String string, byte[] byArray) throws Exception {
        Class clazz = (Class)m_defineClass.invoke(CodeChickenCorePlugin.cl, string, byArray, 0, byArray.length);
        ((Map)f_cachedClasses.get(CodeChickenCorePlugin.cl)).put(string, clazz);
        return clazz;
    }

    public static byte[] readFully(InputStream inputStream) throws IOException {
        int n;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(inputStream.available());
        while ((n = inputStream.read()) != -1) {
            byteArrayOutputStream.write(n);
        }
        return byteArrayOutputStream.toByteArray();
    }
}

