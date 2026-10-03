/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.load.java.descriptors;

import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.synthetic.SyntheticMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.descriptors.JavaCallableMemberDescriptor;

public interface SamAdapterDescriptor<D extends FunctionDescriptor>
extends FunctionDescriptor,
JavaCallableMemberDescriptor,
SyntheticMemberDescriptor<D> {
}

