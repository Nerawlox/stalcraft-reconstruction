/*
 * Decompiled with CFR 0.152.
 */
package gloomyfolken.hooklib.asm;

import gloomyfolken.hooklib.asm.ClassMetadataReader;
import gloomyfolken.hooklib.asm.HookInjectorClassVisitor;
import gloomyfolken.hooklib.asm.HookInjectorFactory;
import gloomyfolken.hooklib.asm.HookInjectorMethodVisitor;
import gloomyfolken.hooklib.asm.HookPriority;
import gloomyfolken.hooklib.asm.ReturnCondition;
import gloomyfolken.hooklib.asm.ReturnValue;
import gloomyfolken.hooklib.asm.TypeHelper;
import java.util.ArrayList;
import java.util.List;
import org.objectweb.asm.Label;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Type;

public class AsmHook
implements Cloneable,
Comparable<AsmHook> {
    private String targetClassName;
    private String targetMethodName;
    private List<Type> targetMethodParameters = new ArrayList<Type>(2);
    private Type targetMethodReturnType;
    private String hooksClassName;
    private String hookMethodName;
    private List<Integer> transmittableVariableIds = new ArrayList<Integer>(2);
    private List<Type> hookMethodParameters = new ArrayList<Type>(2);
    private Type hookMethodReturnType = Type.VOID_TYPE;
    private boolean hasReturnValueParameter;
    private ReturnCondition returnCondition = ReturnCondition.NEVER;
    private ReturnValue returnValue = ReturnValue.VOID;
    private Object primitiveConstant;
    private HookInjectorFactory injectorFactory = ON_ENTER_FACTORY;
    private HookPriority priority = HookPriority.NORMAL;
    public static final HookInjectorFactory ON_ENTER_FACTORY = HookInjectorFactory.MethodEnter.INSTANCE;
    public static final HookInjectorFactory ON_EXIT_FACTORY = HookInjectorFactory.MethodExit.INSTANCE;
    private String targetMethodDescription;
    private String hookMethodDescription;
    private String returnMethodName;
    private String returnMethodDescription;
    private boolean createMethod;

    protected String getTargetClassName() {
        return this.targetClassName;
    }

    private String getTargetClassInternalName() {
        return this.targetClassName.replace('.', '/');
    }

    private String getHookClassInternalName() {
        return this.hooksClassName.replace('.', '/');
    }

    protected boolean isTargetMethod(String string, String string2) {
        return (this.targetMethodReturnType == null && string2.startsWith(this.targetMethodDescription) || string2.equals(this.targetMethodDescription)) && string.equals(this.targetMethodName);
    }

    protected boolean getCreateMethod() {
        return this.createMethod;
    }

    protected HookInjectorFactory getInjectorFactory() {
        return this.injectorFactory;
    }

    private boolean hasHookMethod() {
        return this.hookMethodName != null && this.hooksClassName != null;
    }

    protected void createMethod(HookInjectorClassVisitor hookInjectorClassVisitor) {
        HookInjectorMethodVisitor hookInjectorMethodVisitor;
        ClassMetadataReader.MethodReference methodReference = hookInjectorClassVisitor.findVirtualMethod(this.getTargetClassInternalName(), this.targetMethodName, this.targetMethodDescription);
        MethodVisitor methodVisitor = hookInjectorClassVisitor.visitMethod(1, methodReference == null ? this.targetMethodName : methodReference.name, this.targetMethodDescription, null, null);
        if (methodVisitor instanceof HookInjectorMethodVisitor) {
            hookInjectorMethodVisitor = (HookInjectorMethodVisitor)methodVisitor;
            hookInjectorMethodVisitor.visitCode();
            hookInjectorMethodVisitor.visitLabel(new Label());
            if (methodReference == null) {
                this.injectDefaultValue(hookInjectorMethodVisitor, this.targetMethodReturnType);
            } else {
                this.injectSuperCall(hookInjectorMethodVisitor, methodReference);
            }
        } else {
            throw new IllegalArgumentException("Hook injector not created");
        }
        this.injectReturn(hookInjectorMethodVisitor, this.targetMethodReturnType);
        hookInjectorMethodVisitor.visitLabel(new Label());
        hookInjectorMethodVisitor.visitMaxs(0, 0);
        hookInjectorMethodVisitor.visitEnd();
    }

    protected void inject(HookInjectorMethodVisitor hookInjectorMethodVisitor) {
        Type type = hookInjectorMethodVisitor.methodType.getReturnType();
        int n = -1;
        if (this.hasReturnValueParameter) {
            n = hookInjectorMethodVisitor.newLocal(type);
            hookInjectorMethodVisitor.visitVarInsn(type.getOpcode(54), n);
        }
        int n2 = -1;
        if (this.hasHookMethod()) {
            this.injectInvokeStatic(hookInjectorMethodVisitor, n, this.hookMethodName, this.hookMethodDescription);
            if (this.returnValue == ReturnValue.HOOK_RETURN_VALUE || this.returnCondition.requiresCondition) {
                n2 = hookInjectorMethodVisitor.newLocal(this.hookMethodReturnType);
                hookInjectorMethodVisitor.visitVarInsn(this.hookMethodReturnType.getOpcode(54), n2);
            }
        }
        if (this.returnCondition != ReturnCondition.NEVER) {
            Label label = hookInjectorMethodVisitor.newLabel();
            if (this.returnCondition != ReturnCondition.ALWAYS) {
                hookInjectorMethodVisitor.visitVarInsn(this.hookMethodReturnType.getOpcode(21), n2);
                if (this.returnCondition == ReturnCondition.ON_TRUE) {
                    hookInjectorMethodVisitor.visitJumpInsn(153, label);
                } else if (this.returnCondition == ReturnCondition.ON_NULL) {
                    hookInjectorMethodVisitor.visitJumpInsn(199, label);
                } else if (this.returnCondition == ReturnCondition.ON_NOT_NULL) {
                    hookInjectorMethodVisitor.visitJumpInsn(198, label);
                }
            }
            if (this.returnValue == ReturnValue.NULL) {
                hookInjectorMethodVisitor.visitInsn(1);
            } else if (this.returnValue == ReturnValue.PRIMITIVE_CONSTANT) {
                hookInjectorMethodVisitor.visitLdcInsn(this.primitiveConstant);
            } else if (this.returnValue == ReturnValue.HOOK_RETURN_VALUE) {
                hookInjectorMethodVisitor.visitVarInsn(this.hookMethodReturnType.getOpcode(21), n2);
            } else if (this.returnValue == ReturnValue.ANOTHER_METHOD_RETURN_VALUE) {
                String string = this.returnMethodDescription;
                if (string.endsWith(")")) {
                    string = string + type.getDescriptor();
                }
                this.injectInvokeStatic(hookInjectorMethodVisitor, n, this.returnMethodName, string);
            }
            this.injectReturn(hookInjectorMethodVisitor, type);
            hookInjectorMethodVisitor.visitLabel(label);
        }
        if (this.hasReturnValueParameter) {
            this.injectLoad(hookInjectorMethodVisitor, type, n);
        }
    }

    private void injectLoad(HookInjectorMethodVisitor hookInjectorMethodVisitor, Type type, int n) {
        int n2 = type == Type.INT_TYPE || type == Type.BYTE_TYPE || type == Type.CHAR_TYPE || type == Type.BOOLEAN_TYPE || type == Type.SHORT_TYPE ? 21 : (type == Type.LONG_TYPE ? 22 : (type == Type.FLOAT_TYPE ? 23 : (type == Type.DOUBLE_TYPE ? 24 : 25)));
        hookInjectorMethodVisitor.visitVarInsn(n2, n);
    }

    private void injectSuperCall(HookInjectorMethodVisitor hookInjectorMethodVisitor, ClassMetadataReader.MethodReference methodReference) {
        int n = 0;
        for (int i = 0; i <= this.targetMethodParameters.size(); ++i) {
            Type type = i == 0 ? TypeHelper.getType(this.targetClassName) : this.targetMethodParameters.get(i - 1);
            this.injectLoad(hookInjectorMethodVisitor, type, n);
            if (type.getSort() == 8 || type.getSort() == 7) {
                n += 2;
                continue;
            }
            ++n;
        }
        hookInjectorMethodVisitor.visitMethodInsn(183, methodReference.owner, methodReference.name, methodReference.desc, false);
    }

    private void injectDefaultValue(HookInjectorMethodVisitor hookInjectorMethodVisitor, Type type) {
        switch (type.getSort()) {
            case 0: {
                break;
            }
            case 1: 
            case 2: 
            case 3: 
            case 4: 
            case 5: {
                hookInjectorMethodVisitor.visitInsn(3);
                break;
            }
            case 6: {
                hookInjectorMethodVisitor.visitInsn(11);
                break;
            }
            case 7: {
                hookInjectorMethodVisitor.visitInsn(9);
                break;
            }
            case 8: {
                hookInjectorMethodVisitor.visitInsn(14);
                break;
            }
            default: {
                hookInjectorMethodVisitor.visitInsn(1);
            }
        }
    }

    private void injectReturn(HookInjectorMethodVisitor hookInjectorMethodVisitor, Type type) {
        if (type == Type.INT_TYPE || type == Type.SHORT_TYPE || type == Type.BOOLEAN_TYPE || type == Type.BYTE_TYPE || type == Type.CHAR_TYPE) {
            hookInjectorMethodVisitor.visitInsn(172);
        } else if (type == Type.LONG_TYPE) {
            hookInjectorMethodVisitor.visitInsn(173);
        } else if (type == Type.FLOAT_TYPE) {
            hookInjectorMethodVisitor.visitInsn(174);
        } else if (type == Type.DOUBLE_TYPE) {
            hookInjectorMethodVisitor.visitInsn(175);
        } else if (type == Type.VOID_TYPE) {
            hookInjectorMethodVisitor.visitInsn(177);
        } else {
            hookInjectorMethodVisitor.visitInsn(176);
        }
    }

    private void injectInvokeStatic(HookInjectorMethodVisitor hookInjectorMethodVisitor, int n, String string, String string2) {
        for (int i = 0; i < this.hookMethodParameters.size(); ++i) {
            Type type = this.hookMethodParameters.get(i);
            int n2 = this.transmittableVariableIds.get(i);
            if (hookInjectorMethodVisitor.isStatic) {
                if (n2 == 0) {
                    hookInjectorMethodVisitor.visitInsn(1);
                    continue;
                }
                if (n2 > 0) {
                    --n2;
                }
            }
            if (n2 == -1) {
                n2 = n;
            }
            this.injectLoad(hookInjectorMethodVisitor, type, n2);
        }
        hookInjectorMethodVisitor.visitMethodInsn(184, this.getHookClassInternalName(), string, string2, false);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("AsmHook: ");
        stringBuilder.append(this.targetClassName).append('#').append(this.targetMethodName);
        stringBuilder.append(this.targetMethodDescription);
        stringBuilder.append(" -> ");
        stringBuilder.append(this.hooksClassName).append('#').append(this.hookMethodName);
        stringBuilder.append(this.hookMethodDescription);
        stringBuilder.append(", ReturnCondition=" + (Object)((Object)this.returnCondition));
        stringBuilder.append(", ReturnValue=" + (Object)((Object)this.returnValue));
        if (this.returnValue == ReturnValue.PRIMITIVE_CONSTANT) {
            stringBuilder.append(", Constant=" + this.primitiveConstant);
        }
        stringBuilder.append(", InjectorFactory: " + this.injectorFactory.getClass().getName());
        return stringBuilder.toString();
    }

    @Override
    public int compareTo(AsmHook asmHook) {
        if (this.injectorFactory.isPriorityInverted && asmHook.injectorFactory.isPriorityInverted) {
            return this.priority.ordinal() > asmHook.priority.ordinal() ? -1 : 1;
        }
        if (!this.injectorFactory.isPriorityInverted && !asmHook.injectorFactory.isPriorityInverted) {
            return this.priority.ordinal() > asmHook.priority.ordinal() ? 1 : -1;
        }
        return this.injectorFactory.isPriorityInverted ? 1 : -1;
    }

    public static Builder newBuilder() {
        AsmHook asmHook = new AsmHook();
        asmHook.getClass();
        return asmHook.new Builder();
    }

    public class Builder
    extends AsmHook {
        private Builder() {
        }

        public Builder setTargetClass(String string) {
            AsmHook.this.targetClassName = string;
            return this;
        }

        public Builder setTargetMethod(String string) {
            AsmHook.this.targetMethodName = string;
            return this;
        }

        public Builder addTargetMethodParameters(Type ... typeArray) {
            for (Type type : typeArray) {
                AsmHook.this.targetMethodParameters.add(type);
            }
            return this;
        }

        public Builder addTargetMethodParameters(String ... stringArray) {
            Type[] typeArray = new Type[stringArray.length];
            for (int i = 0; i < stringArray.length; ++i) {
                typeArray[i] = TypeHelper.getType(stringArray[i]);
            }
            return this.addTargetMethodParameters(typeArray);
        }

        public Builder setTargetMethodReturnType(Type type) {
            AsmHook.this.targetMethodReturnType = type;
            return this;
        }

        public Builder setTargetMethodReturnType(String string) {
            return this.setTargetMethodReturnType(TypeHelper.getType(string));
        }

        public Builder setHookClass(String string) {
            AsmHook.this.hooksClassName = string;
            return this;
        }

        public Builder setHookMethod(String string) {
            AsmHook.this.hookMethodName = string;
            return this;
        }

        public Builder addHookMethodParameter(Type type, int n) {
            if (!AsmHook.this.hasHookMethod()) {
                throw new IllegalStateException("Hook method is not specified, so can not append parameter to its parameters list.");
            }
            AsmHook.this.hookMethodParameters.add(type);
            AsmHook.this.transmittableVariableIds.add(n);
            return this;
        }

        public Builder addHookMethodParameter(String string, int n) {
            return this.addHookMethodParameter(TypeHelper.getType(string), n);
        }

        public Builder addThisToHookMethodParameters() {
            if (!AsmHook.this.hasHookMethod()) {
                throw new IllegalStateException("Hook method is not specified, so can not append parameter to its parameters list.");
            }
            AsmHook.this.hookMethodParameters.add(TypeHelper.getType(AsmHook.this.targetClassName));
            AsmHook.this.transmittableVariableIds.add(0);
            return this;
        }

        public Builder addReturnValueToHookMethodParameters() {
            if (!AsmHook.this.hasHookMethod()) {
                throw new IllegalStateException("Hook method is not specified, so can not append parameter to its parameters list.");
            }
            if (AsmHook.this.targetMethodReturnType == Type.VOID_TYPE) {
                throw new IllegalStateException("Target method's return type is void, it does not make sense to transmit its return value to hook method.");
            }
            AsmHook.this.hookMethodParameters.add(AsmHook.this.targetMethodReturnType);
            AsmHook.this.transmittableVariableIds.add(-1);
            AsmHook.this.hasReturnValueParameter = true;
            return this;
        }

        public Builder setReturnCondition(ReturnCondition returnCondition) {
            Type type;
            if (returnCondition.requiresCondition && AsmHook.this.hookMethodName == null) {
                throw new IllegalArgumentException("Hook method is not specified, so can not use return condition that depends on hook method.");
            }
            AsmHook.this.returnCondition = returnCondition;
            switch (returnCondition) {
                case NEVER: 
                case ALWAYS: {
                    type = Type.VOID_TYPE;
                    break;
                }
                case ON_TRUE: {
                    type = Type.BOOLEAN_TYPE;
                    break;
                }
                default: {
                    type = Type.getType(Object.class);
                }
            }
            AsmHook.this.hookMethodReturnType = type;
            return this;
        }

        public Builder setReturnValue(ReturnValue returnValue) {
            if (AsmHook.this.returnCondition == ReturnCondition.NEVER) {
                throw new IllegalStateException("Current return condition is ReturnCondition.NEVER, so it does not make sense to specify the return value.");
            }
            Type type = AsmHook.this.targetMethodReturnType;
            if (returnValue != ReturnValue.VOID && type == Type.VOID_TYPE) {
                throw new IllegalArgumentException("Target method return value is void, so it does not make sense to return anything else.");
            }
            if (returnValue == ReturnValue.VOID && type != Type.VOID_TYPE) {
                throw new IllegalArgumentException("Target method return value is not void, so it is impossible to return VOID.");
            }
            if (returnValue == ReturnValue.PRIMITIVE_CONSTANT && type != null && !this.isPrimitive(type)) {
                throw new IllegalArgumentException("Target method return value is not a primitive, so it is impossible to return PRIVITIVE_CONSTANT.");
            }
            if (returnValue == ReturnValue.NULL && type != null && this.isPrimitive(type)) {
                throw new IllegalArgumentException("Target method return value is a primitive, so it is impossible to return NULL.");
            }
            if (returnValue == ReturnValue.HOOK_RETURN_VALUE && !AsmHook.this.hasHookMethod()) {
                throw new IllegalArgumentException("Hook method is not specified, so can not use return value that depends on hook method.");
            }
            AsmHook.this.returnValue = returnValue;
            if (returnValue == ReturnValue.HOOK_RETURN_VALUE) {
                AsmHook.this.hookMethodReturnType = AsmHook.this.targetMethodReturnType;
            }
            return this;
        }

        public Type getHookMethodReturnType() {
            return AsmHook.this.hookMethodReturnType;
        }

        protected void setHookMethodReturnType(Type type) {
            AsmHook.this.hookMethodReturnType = type;
        }

        private boolean isPrimitive(Type type) {
            return type.getSort() > 0 && type.getSort() < 9;
        }

        public Builder setPrimitiveConstant(Object object) {
            if (AsmHook.this.returnValue != ReturnValue.PRIMITIVE_CONSTANT) {
                throw new IllegalStateException("Return value is not PRIMITIVE_CONSTANT, so it does not make senceto specify that constant.");
            }
            Type type = AsmHook.this.targetMethodReturnType;
            if (type == Type.BOOLEAN_TYPE && !(object instanceof Boolean) || type == Type.CHAR_TYPE && !(object instanceof Character) || type == Type.BYTE_TYPE && !(object instanceof Byte) || type == Type.SHORT_TYPE && !(object instanceof Short) || type == Type.INT_TYPE && !(object instanceof Integer) || type == Type.LONG_TYPE && !(object instanceof Long) || type == Type.FLOAT_TYPE && !(object instanceof Float) || type == Type.DOUBLE_TYPE && !(object instanceof Double)) {
                throw new IllegalArgumentException("Given object class does not math target method return type.");
            }
            AsmHook.this.primitiveConstant = object;
            return this;
        }

        public Builder setReturnMethod(String string) {
            if (AsmHook.this.returnValue != ReturnValue.ANOTHER_METHOD_RETURN_VALUE) {
                throw new IllegalStateException("Return value is not ANOTHER_METHOD_RETURN_VALUE, so it does not make sence to specify that method.");
            }
            AsmHook.this.returnMethodName = string;
            return this;
        }

        public Builder setInjectorFactory(HookInjectorFactory hookInjectorFactory) {
            AsmHook.this.injectorFactory = hookInjectorFactory;
            return this;
        }

        public Builder setPriority(HookPriority hookPriority) {
            AsmHook.this.priority = hookPriority;
            return this;
        }

        public Builder setCreateMethod(boolean bl) {
            AsmHook.this.createMethod = bl;
            return this;
        }

        private String getMethodDesc(Type type, List<Type> list) {
            Type[] typeArray = list.toArray(new Type[0]);
            if (type == null) {
                String string = Type.getMethodDescriptor(Type.VOID_TYPE, typeArray);
                return string.substring(0, string.length() - 1);
            }
            return Type.getMethodDescriptor(type, typeArray);
        }

        public AsmHook build() {
            AsmHook asmHook = AsmHook.this;
            if (asmHook.createMethod && asmHook.targetMethodReturnType == null) {
                asmHook.targetMethodReturnType = asmHook.hookMethodReturnType;
            }
            asmHook.targetMethodDescription = this.getMethodDesc(asmHook.targetMethodReturnType, asmHook.targetMethodParameters);
            if (asmHook.hasHookMethod()) {
                asmHook.hookMethodDescription = Type.getMethodDescriptor(asmHook.hookMethodReturnType, asmHook.hookMethodParameters.toArray(new Type[0]));
            }
            if (asmHook.returnValue == ReturnValue.ANOTHER_METHOD_RETURN_VALUE) {
                asmHook.returnMethodDescription = this.getMethodDesc(asmHook.targetMethodReturnType, asmHook.hookMethodParameters);
            }
            try {
                asmHook = (AsmHook)AsmHook.this.clone();
            }
            catch (CloneNotSupportedException cloneNotSupportedException) {
                // empty catch block
            }
            if (asmHook.targetClassName == null) {
                throw new IllegalStateException("Target class name is not specified. Call setTargetClassName() before build().");
            }
            if (asmHook.targetMethodName == null) {
                throw new IllegalStateException("Target method name is not specified. Call setTargetMethodName() before build().");
            }
            if (asmHook.returnValue == ReturnValue.PRIMITIVE_CONSTANT && asmHook.primitiveConstant == null) {
                throw new IllegalStateException("Return value is PRIMITIVE_CONSTANT, but the constant is not specified. Call setReturnValue() before build().");
            }
            if (asmHook.returnValue == ReturnValue.ANOTHER_METHOD_RETURN_VALUE && asmHook.returnMethodName == null) {
                throw new IllegalStateException("Return value is ANOTHER_METHOD_RETURN_VALUE, but the method is not specified. Call setReturnMethod() before build().");
            }
            if (!(asmHook.injectorFactory instanceof HookInjectorFactory.MethodExit) && asmHook.hasReturnValueParameter) {
                throw new IllegalStateException("Can not pass return value to hook method because hook location is not return insn.");
            }
            return asmHook;
        }
    }
}

