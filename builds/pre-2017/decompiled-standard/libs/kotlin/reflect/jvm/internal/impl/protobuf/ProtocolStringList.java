/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.protobuf;

import java.util.List;
import kotlin.reflect.jvm.internal.impl.protobuf.ByteString;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 */
public interface ProtocolStringList
extends List<String> {
    public List<ByteString> asByteStringList();
}

