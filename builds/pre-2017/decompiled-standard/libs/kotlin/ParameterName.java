/*
 * Decompiled with CFR 0.152.
 */
package kotlin;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.annotation.AnnotationTarget;
import kotlin.annotation.MustBeDocumented;
import kotlin.annotation.Target;

@Target(allowedTargets={AnnotationTarget.TYPE})
@MustBeDocumented
@Documented
@Retention(value=RetentionPolicy.RUNTIME)
@java.lang.annotation.Target(value={})
@Metadata(mv={1, 1, 5}, bv={1, 0, 1}, k=1, d1={"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\u0002\u0018\u00002\u00020\u0001B\b\u0012\u0006\u0010\u0002\u001a\u00020\u0003R\t\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0000\u00a8\u0006\u0004"}, d2={"Lkotlin/ParameterName;", "", "name", "", "kotlin-runtime"})
@SinceKotlin(version="1.1")
public @interface ParameterName {
    public String name();
}

