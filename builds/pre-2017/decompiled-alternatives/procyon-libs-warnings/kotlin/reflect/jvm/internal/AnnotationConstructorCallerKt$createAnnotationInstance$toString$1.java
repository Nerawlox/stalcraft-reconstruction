// 
// Decompiled by Procyon v0.6.0
// 

package kotlin.reflect.jvm.internal;

import kotlin.reflect.KProperty0;
import kotlin.Metadata;
import kotlin.jvm.internal.LocalVariableReference;

@Metadata(mv = { 1, 1, 5 }, bv = { 1, 0, 1 }, k = 3)
final class AnnotationConstructorCallerKt$createAnnotationInstance$toString$1 extends LocalVariableReference
{
    public static final KProperty0 INSTANCE;
    
    static {
        INSTANCE = (KProperty0)new AnnotationConstructorCallerKt$createAnnotationInstance$toString$1();
    }
    
    public String getName() {
        return "toString";
    }
    
    public String getSignature() {
        return "<get-toString>()Ljava/lang/String;";
    }
}
