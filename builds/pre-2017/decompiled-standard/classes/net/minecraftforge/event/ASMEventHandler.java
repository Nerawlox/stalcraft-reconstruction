/*
 * Decompiled with CFR 0.152.
 */
package net.minecraftforge.event;

import com.google.common.collect.Maps;
import java.lang.reflect.Method;
import java.util.HashMap;
import net.minecraftforge.event.Event;
import net.minecraftforge.event.EventPriority;
import net.minecraftforge.event.ForgeSubscribe;
import net.minecraftforge.event.IEventListener;
import obf.gloomyfolken.modlist.ModListHooks;
import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Type;

public class ASMEventHandler
implements IEventListener {
    private static int IDs = 0;
    private static final String HANDLER_DESC = Type.getInternalName(IEventListener.class);
    private static final String HANDLER_FUNC_DESC = Type.getMethodDescriptor(IEventListener.class.getDeclaredMethods()[0]);
    private static final ASMClassLoader LOADER = new ASMClassLoader();
    private static final HashMap<Method, Class<?>> cache = Maps.newHashMap();
    private final IEventListener handler;
    private final ForgeSubscribe subInfo;

    public ASMEventHandler(Object object, Method method) throws Exception {
        this.handler = (IEventListener)this.createWrapper(method).getConstructor(Object.class).newInstance(object);
        this.subInfo = method.getAnnotation(ForgeSubscribe.class);
    }

    @Override
    public void invoke(Event event) {
        if (!(this.handler == null || event.isCancelable() && event.isCanceled() && !this.subInfo.receiveCanceled())) {
            this.handler.invoke(event);
        }
    }

    public EventPriority getPriority() {
        return this.subInfo.priority();
    }

    public Class<?> createWrapper(Method method) {
        Class<?> clazz = ModListHooks.createWrapper(this, method);
        if (clazz != null) {
            return clazz;
        }
        if (cache.containsKey(method)) {
            ModListHooks.createWrapperPost(this, method);
            return cache.get(method);
        }
        clazz = new ClassWriter(0);
        String string = this.getUniqueName(method);
        String string2 = string.replace('.', '/');
        String string3 = Type.getInternalName(method.getDeclaringClass());
        String string4 = Type.getInternalName(method.getParameterTypes()[0]);
        ((ClassWriter)((Object)clazz)).visit(50, 33, string2, null, "java/lang/Object", new String[]{HANDLER_DESC});
        ((ClassWriter)((Object)clazz)).visitSource(".dynamic", null);
        ((ClassWriter)((Object)clazz)).visitField(1, "instance", "Ljava/lang/Object;", null, null).visitEnd();
        MethodVisitor methodVisitor = ((ClassWriter)((Object)clazz)).visitMethod(1, "<init>", "(Ljava/lang/Object;)V", null, null);
        methodVisitor.visitCode();
        methodVisitor.visitVarInsn(25, 0);
        methodVisitor.visitMethodInsn(183, "java/lang/Object", "<init>", "()V");
        methodVisitor.visitVarInsn(25, 0);
        methodVisitor.visitVarInsn(25, 1);
        methodVisitor.visitFieldInsn(181, string2, "instance", "Ljava/lang/Object;");
        methodVisitor.visitInsn(177);
        methodVisitor.visitMaxs(2, 2);
        methodVisitor.visitEnd();
        methodVisitor = ((ClassWriter)((Object)clazz)).visitMethod(1, "invoke", HANDLER_FUNC_DESC, null, null);
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
        ((ClassWriter)((Object)clazz)).visitEnd();
        Class<?> clazz2 = LOADER.define(string, ((ClassWriter)((Object)clazz)).toByteArray());
        cache.put(method, clazz2);
        ModListHooks.createWrapperPost(this, method);
        return clazz2;
    }

    private String getUniqueName(Method method) {
        String string = ModListHooks.getUniqueName(this, method);
        return string;
    }

    private static class ASMClassLoader
    extends ClassLoader {
        private ASMClassLoader() {
            super(ASMClassLoader.class.getClassLoader());
        }

        public Class<?> define(String string, byte[] byArray) {
            return this.defineClass(string, byArray, 0, byArray.length);
        }
    }
}

