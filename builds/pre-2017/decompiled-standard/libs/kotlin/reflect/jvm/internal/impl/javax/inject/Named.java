/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.javax.inject;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import kotlin.reflect.jvm.internal.impl.javax.inject.Qualifier;

@Qualifier
@Documented
@Retention(value=RetentionPolicy.RUNTIME)
public @interface Named {
    public String value() default "";
}

