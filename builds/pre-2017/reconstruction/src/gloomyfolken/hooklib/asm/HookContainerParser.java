/*
 * Decompiled with CFR 0.152.
 */
package gloomyfolken.hooklib.asm;

import gloomyfolken.hooklib.asm.AsmHook;
import gloomyfolken.hooklib.asm.Hook;
import gloomyfolken.hooklib.asm.HookClassTransformer;
import gloomyfolken.hooklib.asm.HookInjectorFactory;
import gloomyfolken.hooklib.asm.HookPriority;
import gloomyfolken.hooklib.asm.ReturnCondition;
import gloomyfolken.hooklib.asm.ReturnValue;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import org.objectweb.asm.AnnotationVisitor;
import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Type;

public class HookContainerParser {
    private HookClassTransformer transformer;
    private String currentClassName;
    private String currentMethodName;
    private String currentMethodDesc;
    private boolean currentMethodPublicStatic;
    private HashMap<String, Object> annotationValues;
    private HashMap<Integer, Integer> parameterAnnotations = new HashMap();
    private boolean inHookAnnotation;
    private static final String HOOK_DESC = Type.getDescriptor(Hook.class);
    private static final String LOCAL_DESC = Type.getDescriptor(Hook.LocalVariable.class);
    private static final String RETURN_DESC = Type.getDescriptor(Hook.ReturnValue.class);

    public HookContainerParser(HookClassTransformer hookClassTransformer) {
        this.transformer = hookClassTransformer;
    }

    protected void parseHooks(String string) {
        this.transformer.logger.debug("Parsing hooks container " + string);
        try {
            this.transformer.classMetadataReader.acceptVisitor(string, (ClassVisitor)new HookClassVisitor());
        }
        catch (IOException iOException) {
            this.transformer.logger.severe("Can not parse hooks container " + string, iOException);
        }
    }

    protected void parseHooks(byte[] byArray) {
    }

    private void invalidHook(String string) {
        this.transformer.logger.warning("Found invalid hook " + this.currentClassName + "#" + this.currentMethodName);
        this.transformer.logger.warning(string);
    }

    private void createHook() {
        Object object;
        int n;
        AsmHook.Builder builder = AsmHook.newBuilder();
        Type type = Type.getMethodType(this.currentMethodDesc);
        Type[] typeArray = type.getArgumentTypes();
        if (!this.currentMethodPublicStatic) {
            this.invalidHook("Hook method must be public and static.");
            return;
        }
        if (typeArray.length < 1) {
            this.invalidHook("Hook method has no parameters. First parameter of a hook method must belong the type of the target class.");
            return;
        }
        if (typeArray[0].getSort() != 10) {
            this.invalidHook("First parameter of the hook method is not an object. First parameter of a hook method must belong the type of the target class.");
            return;
        }
        builder.setTargetClass(typeArray[0].getClassName());
        if (this.annotationValues.containsKey("targetMethod")) {
            builder.setTargetMethod((String)this.annotationValues.get("targetMethod"));
        } else {
            builder.setTargetMethod(this.currentMethodName);
        }
        builder.setHookClass(this.currentClassName);
        builder.setHookMethod(this.currentMethodName);
        builder.addThisToHookMethodParameters();
        boolean bl = Boolean.TRUE.equals(this.annotationValues.get("injectOnExit"));
        int n2 = 1;
        for (n = 1; n < typeArray.length; ++n) {
            object = typeArray[n];
            if (this.parameterAnnotations.containsKey(n)) {
                int n3 = this.parameterAnnotations.get(n);
                if (n3 == -1) {
                    builder.setTargetMethodReturnType((Type)object);
                    builder.addReturnValueToHookMethodParameters();
                    continue;
                }
                builder.addHookMethodParameter((Type)object, n3);
                continue;
            }
            builder.addTargetMethodParameters(new Type[]{object});
            builder.addHookMethodParameter((Type)object, n2);
            n2 += object == Type.LONG_TYPE || object == Type.DOUBLE_TYPE ? 2 : 1;
        }
        if (bl) {
            builder.setInjectorFactory(AsmHook.ON_EXIT_FACTORY);
        }
        if (this.annotationValues.containsKey("injectOnLine")) {
            n = (Integer)this.annotationValues.get("injectOnLine");
            builder.setInjectorFactory(new HookInjectorFactory.LineNumber(n));
        }
        if (this.annotationValues.containsKey("returnType")) {
            builder.setTargetMethodReturnType((String)this.annotationValues.get("returnType"));
        }
        ReturnCondition returnCondition = ReturnCondition.NEVER;
        if (this.annotationValues.containsKey("returnCondition")) {
            returnCondition = ReturnCondition.valueOf((String)this.annotationValues.get("returnCondition"));
            builder.setReturnCondition(returnCondition);
        }
        if (returnCondition != ReturnCondition.NEVER) {
            object = this.getPrimitiveConstant();
            if (object != null) {
                builder.setReturnValue(ReturnValue.PRIMITIVE_CONSTANT);
                builder.setPrimitiveConstant(object);
            } else if (Boolean.TRUE.equals(this.annotationValues.get("returnNull"))) {
                builder.setReturnValue(ReturnValue.NULL);
            } else if (this.annotationValues.containsKey("returnAnotherMethod")) {
                builder.setReturnValue(ReturnValue.ANOTHER_METHOD_RETURN_VALUE);
                builder.setReturnMethod((String)this.annotationValues.get("returnAnotherMethod"));
            } else if (type.getReturnType() != Type.VOID_TYPE) {
                builder.setReturnValue(ReturnValue.HOOK_RETURN_VALUE);
            }
        }
        builder.setHookMethodReturnType(type.getReturnType());
        if (returnCondition == ReturnCondition.ON_TRUE && type.getReturnType() != Type.BOOLEAN_TYPE) {
            this.invalidHook("Hook method must return boolean if returnCodition is ON_TRUE.");
            return;
        }
        if ((returnCondition == ReturnCondition.ON_NULL || returnCondition == ReturnCondition.ON_NOT_NULL) && type.getReturnType().getSort() != 10 && type.getReturnType().getSort() != 9) {
            this.invalidHook("Hook method must return object if returnCodition is ON_NULL or ON_NOT_NULL.");
            return;
        }
        if (this.annotationValues.containsKey("priority")) {
            builder.setPriority(HookPriority.valueOf((String)this.annotationValues.get("priority")));
        }
        if (this.annotationValues.containsKey("createMethod")) {
            builder.setCreateMethod(Boolean.TRUE.equals(this.annotationValues.get("createMethod")));
        }
        this.transformer.registerHook(builder.build());
    }

    private Object getPrimitiveConstant() {
        for (Map.Entry<String, Object> entry : this.annotationValues.entrySet()) {
            if (!entry.getKey().endsWith("Constant")) continue;
            return entry.getValue();
        }
        return null;
    }

    private class HookAnnotationVisitor
    extends AnnotationVisitor {
        public HookAnnotationVisitor() {
            super(327680);
        }

        @Override
        public void visit(String string, Object object) {
            if (HookContainerParser.this.inHookAnnotation) {
                HookContainerParser.this.annotationValues.put(string, object);
            }
        }

        @Override
        public void visitEnum(String string, String string2, String string3) {
            this.visit(string, string3);
        }

        @Override
        public void visitEnd() {
            HookContainerParser.this.inHookAnnotation = false;
        }
    }

    private class HookMethodVisitor
    extends MethodVisitor {
        public HookMethodVisitor() {
            super(327680);
        }

        @Override
        public AnnotationVisitor visitAnnotation(String string, boolean bl) {
            if (HOOK_DESC.equals(string)) {
                HookContainerParser.this.annotationValues = new HashMap();
                HookContainerParser.this.inHookAnnotation = true;
            }
            return new HookAnnotationVisitor();
        }

        @Override
        public AnnotationVisitor visitParameterAnnotation(final int n, String string, boolean bl) {
            if (RETURN_DESC.equals(string)) {
                HookContainerParser.this.parameterAnnotations.put(n, -1);
            }
            if (LOCAL_DESC.equals(string)) {
                return new AnnotationVisitor(327680){

                    @Override
                    public void visit(String string, Object object) {
                        HookContainerParser.this.parameterAnnotations.put(n, (Integer)object);
                    }
                };
            }
            return null;
        }

        @Override
        public void visitEnd() {
            if (HookContainerParser.this.annotationValues != null) {
                HookContainerParser.this.createHook();
            }
            HookContainerParser.this.parameterAnnotations.clear();
            HookContainerParser.this.currentMethodName = (HookContainerParser.this.currentMethodDesc = null);
            HookContainerParser.this.currentMethodPublicStatic = false;
            HookContainerParser.this.annotationValues = null;
        }
    }

    private class HookClassVisitor
    extends ClassVisitor {
        public HookClassVisitor() {
            super(327680);
        }

        @Override
        public void visit(int n, int n2, String string, String string2, String string3, String[] stringArray) {
            HookContainerParser.this.currentClassName = string.replace('/', '.');
        }

        @Override
        public MethodVisitor visitMethod(int n, String string, String string2, String string3, String[] stringArray) {
            HookContainerParser.this.currentMethodName = string;
            HookContainerParser.this.currentMethodDesc = string2;
            HookContainerParser.this.currentMethodPublicStatic = (n & 1) != 0 && (n & 8) != 0;
            return new HookMethodVisitor();
        }
    }
}

