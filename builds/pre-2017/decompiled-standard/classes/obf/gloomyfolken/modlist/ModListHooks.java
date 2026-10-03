/*
 * Decompiled with CFR 0.152.
 */
package obf.gloomyfolken.modlist;

import cpw.mods.fml.common.ModClassLoader;
import cpw.mods.fml.common.ModContainer;
import cpw.mods.fml.common.asm.FMLSanityChecker;
import cpw.mods.fml.common.discovery.asm.ASMModParser;
import cpw.mods.fml.common.discovery.asm.ModAnnotation;
import cpw.mods.fml.common.modloader.BaseModProxy;
import gloomyfolken.hooklib.asm.Hook;
import gloomyfolken.hooklib.asm.ReturnCondition;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import net.minecraftforge.event.ASMEventHandler;
import net.minecraftforge.event.IEventListener;
import org.apache.commons.io.FileUtils;
import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Type;

public class ModListHooks {
    public static final boolean DISABLE_MOD_PARSING = System.getProperty("disable_mod_parsing", "false").equals("true");
    public static final boolean USE_SYSTEM_CLASS_LOADER = System.getProperty("use_system_class_loader", "false").equals("true");
    public static HashSet<String> modClasses = new HashSet();
    public static final boolean DUMP_EVENT_CLASSES = System.getProperty("dump_event_classes", "false").equals("true");
    public static final boolean LOAD_DUMPED_EVENT_CLASSES = System.getProperty("load_dumped_event_classes", "false").equals("true");
    private static final File dumpedEventsDir = new File("mods/events");
    private static final String HANDLER_DESC;
    private static final String HANDLER_FUNC_DESC;
    private static ClassLoader classLoader;
    private static final File modParserDumpDir;

    public static void onModBuild(ASMModParser aSMModParser, ModContainer modContainer) {
        if (modContainer != null) {
            modClasses.add(aSMModParser.getASMType().getInternalName() + ".class");
        }
    }

    public static void afterModsLoaded() {
        File file = new File("modlist.txt");
        try {
            FileUtils.writeLines(file, "UTF-8", modClasses, "\n", false);
        }
        catch (IOException iOException) {
            iOException.printStackTrace();
        }
    }

    @Hook(returnCondition=ReturnCondition.ALWAYS)
    public static String getUniqueName(ASMEventHandler aSMEventHandler, Method method) {
        return String.format("%s_%s_%s_%s", aSMEventHandler.getClass().getName(), method.getDeclaringClass().getName().replace('.', '_'), method.getName(), method.getParameterTypes()[0].getName().replace('.', '_'));
    }

    @Hook(injectOnExit=true, targetMethod="createWrapper")
    public static void createWrapperPost(ASMEventHandler aSMEventHandler, Method method) {
        if (DUMP_EVENT_CLASSES) {
            byte[] byArray = ModListHooks.createWrapperBytecode(aSMEventHandler, method);
            String string = ModListHooks.getUniqueName(aSMEventHandler, method);
            String string2 = string.substring(0, string.lastIndexOf(46));
            String string3 = string.substring(string.lastIndexOf(46) + 1);
            String string4 = string2.replace('.', '/');
            File file = new File(dumpedEventsDir, string4 + "/" + string3 + ".class");
            try {
                FileUtils.writeByteArrayToFile(file, byArray);
            }
            catch (IOException iOException) {
                iOException.printStackTrace();
            }
        }
    }

    private static byte[] createWrapperBytecode(ASMEventHandler aSMEventHandler, Method method) {
        ClassWriter classWriter = new ClassWriter(0);
        String string = ModListHooks.getUniqueName(aSMEventHandler, method);
        String string2 = string.replace('.', '/');
        String string3 = Type.getInternalName(method.getDeclaringClass());
        String string4 = Type.getInternalName(method.getParameterTypes()[0]);
        classWriter.visit(50, 33, string2, null, "java/lang/Object", new String[]{HANDLER_DESC});
        classWriter.visitSource(".dynamic", null);
        classWriter.visitField(1, "instance", "Ljava/lang/Object;", null, null).visitEnd();
        MethodVisitor methodVisitor = classWriter.visitMethod(1, "<init>", "(Ljava/lang/Object;)V", null, null);
        methodVisitor.visitCode();
        methodVisitor.visitVarInsn(25, 0);
        methodVisitor.visitMethodInsn(183, "java/lang/Object", "<init>", "()V");
        methodVisitor.visitVarInsn(25, 0);
        methodVisitor.visitVarInsn(25, 1);
        methodVisitor.visitFieldInsn(181, string2, "instance", "Ljava/lang/Object;");
        methodVisitor.visitInsn(177);
        methodVisitor.visitMaxs(2, 2);
        methodVisitor.visitEnd();
        methodVisitor = classWriter.visitMethod(1, "invoke", HANDLER_FUNC_DESC, null, null);
        methodVisitor.visitCode();
        methodVisitor.visitVarInsn(25, 0);
        methodVisitor.visitFieldInsn(180, string2, "instance", "Ljava/lang/Object;");
        methodVisitor.visitTypeInsn(192, string3);
        methodVisitor.visitVarInsn(25, 1);
        methodVisitor.visitTypeInsn(192, string4);
        methodVisitor.visitMethodInsn(182, string3, method.getName(), Type.getMethodDescriptor(method));
        methodVisitor.visitInsn(177);
        methodVisitor.visitMaxs(2, 2);
        methodVisitor.visitEnd();
        classWriter.visitEnd();
        return classWriter.toByteArray();
    }

    @Hook(returnCondition=ReturnCondition.ON_NOT_NULL)
    public static Class<?> createWrapper(ASMEventHandler aSMEventHandler, Method method) {
        if (LOAD_DUMPED_EVENT_CLASSES) {
            try {
                return Class.forName(ModListHooks.getUniqueName(aSMEventHandler, method));
            }
            catch (Exception exception) {
                System.out.println("Can not load dumped event class " + method);
                exception.printStackTrace();
            }
        }
        return null;
    }

    @Hook(returnCondition=ReturnCondition.ON_TRUE, returnNull=true)
    public static boolean call(FMLSanityChecker fMLSanityChecker) {
        return USE_SYSTEM_CLASS_LOADER;
    }

    @Hook(returnCondition=ReturnCondition.ON_TRUE)
    public static boolean injectData(FMLSanityChecker fMLSanityChecker, Map<String, Object> map) {
        if (USE_SYSTEM_CLASS_LOADER) {
            System.out.println("Sanity check disabled.");
            FMLSanityChecker.fmlLocation = (File)map.get("coremodLocation");
            return true;
        }
        return false;
    }

    @Hook(returnCondition=ReturnCondition.ON_TRUE)
    public static boolean addFile(ModClassLoader modClassLoader, File file) {
        return USE_SYSTEM_CLASS_LOADER;
    }

    @Hook(returnCondition=ReturnCondition.ON_TRUE, returnAnotherMethod="loadClassDefault")
    public static boolean loadClass(ModClassLoader modClassLoader, String string) {
        return USE_SYSTEM_CLASS_LOADER;
    }

    public static Class<?> loadClassDefault(ModClassLoader modClassLoader, String string) throws ClassNotFoundException {
        return classLoader.loadClass(string);
    }

    @Hook(returnCondition=ReturnCondition.ON_TRUE, returnAnotherMethod="getEmptyFileArray")
    public static boolean getParentSources(ModClassLoader modClassLoader) {
        return USE_SYSTEM_CLASS_LOADER;
    }

    public static File[] getEmptyFileArray(ModClassLoader modClassLoader) {
        return new File[0];
    }

    @Hook(returnCondition=ReturnCondition.ON_TRUE, returnAnotherMethod="doLoadBaseModClass")
    public static boolean loadBaseModClass(ModClassLoader modClassLoader, String string) {
        return USE_SYSTEM_CLASS_LOADER;
    }

    public static Class<? extends BaseModProxy> doLoadBaseModClass(ModClassLoader modClassLoader, String string) throws Exception {
        return Class.forName(string, true, classLoader);
    }

    @Hook(returnCondition=ReturnCondition.ON_TRUE)
    public static boolean clearNegativeCacheFor(ModClassLoader modClassLoader, Set<String> set) {
        return USE_SYSTEM_CLASS_LOADER;
    }

    @Hook(returnCondition=ReturnCondition.ON_TRUE, targetMethod="<init>")
    public static boolean init(ASMModParser aSMModParser, InputStream inputStream) throws ReflectiveOperationException {
        if (inputStream == null) {
            Field field = ASMModParser.class.getDeclaredField("annotations");
            field.setAccessible(true);
            field.set(aSMModParser, new LinkedList());
        }
        return inputStream == null;
    }

    @Hook(injectOnExit=true, targetMethod="<init>")
    public static void postInit(ASMModParser aSMModParser, InputStream inputStream) {
        if (!DISABLE_MOD_PARSING) {
            ModListHooks.dumpDataToFile(aSMModParser);
        }
    }

    @Hook(returnCondition=ReturnCondition.ON_TRUE, booleanReturnConstant=false)
    public static boolean isBaseMod(ASMModParser aSMModParser, List<String> list) {
        return aSMModParser.getASMSuperType() == null;
    }

    public static void fillModParser(ASMModParser aSMModParser, byte[] byArray) throws IOException, ReflectiveOperationException {
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(byArray);
        ObjectInputStream objectInputStream = new ObjectInputStream(byteArrayInputStream);
        aSMModParser.beginNewTypeName(objectInputStream.readUTF(), objectInputStream.readInt(), objectInputStream.readUTF());
        if (objectInputStream.readBoolean()) {
            aSMModParser.setBaseModProperties(objectInputStream.readUTF());
        }
        int n = objectInputStream.readInt();
        Class<?> clazz = Class.forName("cpw.mods.fml.common.discovery.asm.ASMModParser$AnnotationType");
        Method method = clazz.getDeclaredMethod("values", new Class[0]);
        method.setAccessible(true);
        Enum[] enumArray = (Enum[])method.invoke(null, new Object[0]);
        Constructor constructor = ModAnnotation.class.getConstructor(clazz, Type.class, String.class);
        constructor.setAccessible(true);
        for (int i = 0; i < n; ++i) {
            Enum enum_ = enumArray[objectInputStream.readInt()];
            Type type = Type.getObjectType(objectInputStream.readUTF());
            String string = objectInputStream.readUTF();
            ModAnnotation modAnnotation = (ModAnnotation)constructor.newInstance(enum_, type, string);
            int n2 = objectInputStream.readInt();
            for (int j = 0; j < n2; ++j) {
                String string2 = objectInputStream.readBoolean() ? objectInputStream.readUTF() : null;
                Object object = objectInputStream.readObject();
                modAnnotation.addProperty(string2, object);
            }
            aSMModParser.getAnnotations().add(modAnnotation);
        }
        objectInputStream.close();
    }

    public static void dumpDataToFile(ASMModParser aSMModParser) {
        ArrayList<ModAnnotation> arrayList = new ArrayList<ModAnnotation>(2);
        for (ModAnnotation object : aSMModParser.getAnnotations()) {
            if (!object.getASMType().getClassName().startsWith("cpw.mods.fml.common")) continue;
            arrayList.add(object);
        }
        if (arrayList.size() > 0 || aSMModParser.getASMSuperType() != null && aSMModParser.isBaseMod(Collections.emptyList())) {
            Object object2 = ModListHooks.dumpData(aSMModParser, arrayList);
            File file = new File(modParserDumpDir, aSMModParser.getASMType().getClassName() + ".dump");
            try {
                FileUtils.writeByteArrayToFile(file, (byte[])object2);
            }
            catch (IOException iOException) {
                iOException.printStackTrace();
            }
        }
    }

    public static byte[] dumpData(ASMModParser aSMModParser, List<ModAnnotation> list) {
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
            objectOutputStream.writeUTF(aSMModParser.getASMType().getInternalName());
            objectOutputStream.writeInt(aSMModParser.getClassVersion());
            objectOutputStream.writeUTF(aSMModParser.getASMSuperType().getInternalName());
            objectOutputStream.writeBoolean(aSMModParser.getBaseModProperties() != null);
            if (aSMModParser.getBaseModProperties() != null) {
                objectOutputStream.writeUTF(aSMModParser.getBaseModProperties());
            }
            objectOutputStream.writeInt(list.size());
            for (ModAnnotation modAnnotation : list) {
                ASMModParser.AnnotationType annotationType = modAnnotation.getType();
                objectOutputStream.writeInt(annotationType.ordinal());
                objectOutputStream.writeUTF(modAnnotation.getASMType().getInternalName());
                objectOutputStream.writeUTF(modAnnotation.getMember() == null ? "" : modAnnotation.getMember());
                HashMap<String, Object> hashMap = new HashMap<String, Object>(modAnnotation.getValues());
                hashMap.values().removeIf(object -> !(object instanceof Serializable));
                objectOutputStream.writeInt(hashMap.size());
                for (Map.Entry entry : hashMap.entrySet()) {
                    objectOutputStream.writeBoolean(entry.getKey() != null);
                    if (entry.getKey() != null) {
                        objectOutputStream.writeUTF((String)entry.getKey());
                    }
                    objectOutputStream.writeObject(entry.getValue());
                }
            }
            objectOutputStream.close();
            return byteArrayOutputStream.toByteArray();
        }
        catch (IOException iOException) {
            throw new RuntimeException(iOException);
        }
    }

    static {
        if (DUMP_EVENT_CLASSES) {
            try {
                dumpedEventsDir.mkdirs();
                FileUtils.cleanDirectory(dumpedEventsDir);
            }
            catch (IOException iOException) {
                iOException.printStackTrace();
            }
        }
        HANDLER_DESC = Type.getInternalName(IEventListener.class);
        HANDLER_FUNC_DESC = Type.getMethodDescriptor(IEventListener.class.getDeclaredMethods()[0]);
        classLoader = ModListHooks.class.getClassLoader();
        modParserDumpDir = new File("mods/asmdata");
        if (!DISABLE_MOD_PARSING) {
            try {
                modParserDumpDir.mkdirs();
                FileUtils.cleanDirectory(modParserDumpDir);
            }
            catch (IOException iOException) {
                iOException.printStackTrace();
            }
        }
    }
}

