/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.protobuf;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.reflect.jvm.internal.impl.protobuf.ByteString;
import kotlin.reflect.jvm.internal.impl.protobuf.CodedInputStream;
import kotlin.reflect.jvm.internal.impl.protobuf.CodedOutputStream;
import kotlin.reflect.jvm.internal.impl.protobuf.Internal;
import kotlin.reflect.jvm.internal.impl.protobuf.LazyField;
import kotlin.reflect.jvm.internal.impl.protobuf.MessageLite;
import kotlin.reflect.jvm.internal.impl.protobuf.SmallSortedMap;
import kotlin.reflect.jvm.internal.impl.protobuf.WireFormat;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 */
final class FieldSet<FieldDescriptorType extends FieldDescriptorLite<FieldDescriptorType>> {
    private final SmallSortedMap<FieldDescriptorType, Object> fields;
    private boolean isImmutable;
    private boolean hasLazyField = false;
    private static final FieldSet DEFAULT_INSTANCE = new FieldSet(true);

    private FieldSet() {
        this.fields = SmallSortedMap.newFieldMap(16);
    }

    private FieldSet(boolean dummy) {
        this.fields = SmallSortedMap.newFieldMap(0);
        this.makeImmutable();
    }

    public static <T extends FieldDescriptorLite<T>> FieldSet<T> newFieldSet() {
        return new FieldSet();
    }

    public static <T extends FieldDescriptorLite<T>> FieldSet<T> emptySet() {
        return DEFAULT_INSTANCE;
    }

    public void makeImmutable() {
        if (this.isImmutable) {
            return;
        }
        this.fields.makeImmutable();
        this.isImmutable = true;
    }

    public boolean isImmutable() {
        return this.isImmutable;
    }

    public FieldSet<FieldDescriptorType> clone() {
        FieldDescriptorLite descriptor2;
        FieldSet clone = FieldSet.newFieldSet();
        for (int i = 0; i < this.fields.getNumArrayEntries(); ++i) {
            Map.Entry<FieldDescriptorType, Object> entry = this.fields.getArrayEntryAt(i);
            descriptor2 = (FieldDescriptorLite)entry.getKey();
            clone.setField(descriptor2, entry.getValue());
        }
        for (Map.Entry<FieldDescriptorType, Object> entry : this.fields.getOverflowEntries()) {
            descriptor2 = (FieldDescriptorLite)entry.getKey();
            clone.setField(descriptor2, entry.getValue());
        }
        clone.hasLazyField = this.hasLazyField;
        return clone;
    }

    public void clear() {
        this.fields.clear();
        this.hasLazyField = false;
    }

    public Map<FieldDescriptorType, Object> getAllFields() {
        if (this.hasLazyField) {
            SmallSortedMap result2 = SmallSortedMap.newFieldMap(16);
            for (int i = 0; i < this.fields.getNumArrayEntries(); ++i) {
                this.cloneFieldEntry(result2, this.fields.getArrayEntryAt(i));
            }
            for (Map.Entry<FieldDescriptorType, Object> entry : this.fields.getOverflowEntries()) {
                this.cloneFieldEntry(result2, entry);
            }
            if (this.fields.isImmutable()) {
                result2.makeImmutable();
            }
            return result2;
        }
        return this.fields.isImmutable() ? this.fields : Collections.unmodifiableMap(this.fields);
    }

    private void cloneFieldEntry(Map<FieldDescriptorType, Object> map2, Map.Entry<FieldDescriptorType, Object> entry) {
        FieldDescriptorLite key = (FieldDescriptorLite)entry.getKey();
        Object value = entry.getValue();
        if (value instanceof LazyField) {
            map2.put(key, ((LazyField)value).getValue());
        } else {
            map2.put(key, value);
        }
    }

    public Iterator<Map.Entry<FieldDescriptorType, Object>> iterator() {
        if (this.hasLazyField) {
            return new LazyField.LazyIterator(this.fields.entrySet().iterator());
        }
        return this.fields.entrySet().iterator();
    }

    public boolean hasField(FieldDescriptorType descriptor2) {
        if (descriptor2.isRepeated()) {
            throw new IllegalArgumentException("hasField() can only be called on non-repeated fields.");
        }
        return this.fields.get(descriptor2) != null;
    }

    public Object getField(FieldDescriptorType descriptor2) {
        Object o = this.fields.get(descriptor2);
        if (o instanceof LazyField) {
            return ((LazyField)o).getValue();
        }
        return o;
    }

    public void setField(FieldDescriptorType descriptor2, Object value) {
        if (descriptor2.isRepeated()) {
            if (!(value instanceof List)) {
                throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
            }
            ArrayList newList = new ArrayList();
            newList.addAll(value);
            for (Object element : newList) {
                FieldSet.verifyType(descriptor2.getLiteType(), element);
            }
            value = newList;
        } else {
            FieldSet.verifyType(descriptor2.getLiteType(), value);
        }
        if (value instanceof LazyField) {
            this.hasLazyField = true;
        }
        this.fields.put(descriptor2, (Object)value);
    }

    public void clearField(FieldDescriptorType descriptor2) {
        this.fields.remove(descriptor2);
        if (this.fields.isEmpty()) {
            this.hasLazyField = false;
        }
    }

    public int getRepeatedFieldCount(FieldDescriptorType descriptor2) {
        if (!descriptor2.isRepeated()) {
            throw new IllegalArgumentException("getRepeatedField() can only be called on repeated fields.");
        }
        Object value = this.getField(descriptor2);
        if (value == null) {
            return 0;
        }
        return ((List)value).size();
    }

    public Object getRepeatedField(FieldDescriptorType descriptor2, int index) {
        if (!descriptor2.isRepeated()) {
            throw new IllegalArgumentException("getRepeatedField() can only be called on repeated fields.");
        }
        Object value = this.getField(descriptor2);
        if (value == null) {
            throw new IndexOutOfBoundsException();
        }
        return ((List)value).get(index);
    }

    public void setRepeatedField(FieldDescriptorType descriptor2, int index, Object value) {
        if (!descriptor2.isRepeated()) {
            throw new IllegalArgumentException("getRepeatedField() can only be called on repeated fields.");
        }
        Object list = this.getField(descriptor2);
        if (list == null) {
            throw new IndexOutOfBoundsException();
        }
        FieldSet.verifyType(descriptor2.getLiteType(), value);
        ((List)list).set(index, value);
    }

    public void addRepeatedField(FieldDescriptorType descriptor2, Object value) {
        ArrayList<Object> list;
        if (!descriptor2.isRepeated()) {
            throw new IllegalArgumentException("addRepeatedField() can only be called on repeated fields.");
        }
        FieldSet.verifyType(descriptor2.getLiteType(), value);
        Object existingValue = this.getField(descriptor2);
        if (existingValue == null) {
            list = new ArrayList<Object>();
            this.fields.put(descriptor2, (Object)list);
        } else {
            list = (ArrayList<Object>)existingValue;
        }
        list.add(value);
    }

    private static void verifyType(WireFormat.FieldType type2, Object value) {
        if (value == null) {
            throw new NullPointerException();
        }
        boolean isValid = false;
        switch (type2.getJavaType()) {
            case INT: {
                isValid = value instanceof Integer;
                break;
            }
            case LONG: {
                isValid = value instanceof Long;
                break;
            }
            case FLOAT: {
                isValid = value instanceof Float;
                break;
            }
            case DOUBLE: {
                isValid = value instanceof Double;
                break;
            }
            case BOOLEAN: {
                isValid = value instanceof Boolean;
                break;
            }
            case STRING: {
                isValid = value instanceof String;
                break;
            }
            case BYTE_STRING: {
                isValid = value instanceof ByteString || value instanceof byte[];
                break;
            }
            case ENUM: {
                isValid = value instanceof Integer || value instanceof Internal.EnumLite;
                break;
            }
            case MESSAGE: {
                boolean bl = isValid = value instanceof MessageLite || value instanceof LazyField;
            }
        }
        if (!isValid) {
            throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
        }
    }

    public boolean isInitialized() {
        for (int i = 0; i < this.fields.getNumArrayEntries(); ++i) {
            if (this.isInitialized(this.fields.getArrayEntryAt(i))) continue;
            return false;
        }
        for (Map.Entry<FieldDescriptorType, Object> entry : this.fields.getOverflowEntries()) {
            if (this.isInitialized(entry)) continue;
            return false;
        }
        return true;
    }

    private boolean isInitialized(Map.Entry<FieldDescriptorType, Object> entry) {
        FieldDescriptorLite descriptor2 = (FieldDescriptorLite)entry.getKey();
        if (descriptor2.getLiteJavaType() == WireFormat.JavaType.MESSAGE) {
            if (descriptor2.isRepeated()) {
                for (MessageLite element : (List)entry.getValue()) {
                    if (element.isInitialized()) continue;
                    return false;
                }
            } else {
                Object value = entry.getValue();
                if (value instanceof MessageLite) {
                    if (!((MessageLite)value).isInitialized()) {
                        return false;
                    }
                } else {
                    if (value instanceof LazyField) {
                        return true;
                    }
                    throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
                }
            }
        }
        return true;
    }

    static int getWireFormatForFieldType(WireFormat.FieldType type2, boolean isPacked) {
        if (isPacked) {
            return 2;
        }
        return type2.getWireType();
    }

    public void mergeFrom(FieldSet<FieldDescriptorType> other) {
        for (int i = 0; i < other.fields.getNumArrayEntries(); ++i) {
            this.mergeFromField(other.fields.getArrayEntryAt(i));
        }
        for (Map.Entry<FieldDescriptorType, Object> entry : other.fields.getOverflowEntries()) {
            this.mergeFromField(entry);
        }
    }

    private Object cloneIfMutable(Object value) {
        if (value instanceof byte[]) {
            byte[] bytes = (byte[])value;
            byte[] copy = new byte[bytes.length];
            System.arraycopy(bytes, 0, copy, 0, bytes.length);
            return copy;
        }
        return value;
    }

    private void mergeFromField(Map.Entry<FieldDescriptorType, Object> entry) {
        FieldDescriptorLite descriptor2 = (FieldDescriptorLite)entry.getKey();
        Object otherValue = entry.getValue();
        if (otherValue instanceof LazyField) {
            otherValue = ((LazyField)otherValue).getValue();
        }
        if (descriptor2.isRepeated()) {
            ArrayList value = this.getField(descriptor2);
            if (value == null) {
                value = new ArrayList();
            }
            for (Object element : (List)otherValue) {
                ((List)value).add(this.cloneIfMutable(element));
            }
            this.fields.put((FieldDescriptorType)descriptor2, (Object)value);
        } else if (descriptor2.getLiteJavaType() == WireFormat.JavaType.MESSAGE) {
            Object value = this.getField(descriptor2);
            if (value == null) {
                this.fields.put((FieldDescriptorType)descriptor2, this.cloneIfMutable(otherValue));
            } else {
                value = descriptor2.internalMergeFrom(((MessageLite)value).toBuilder(), (MessageLite)otherValue).build();
                this.fields.put((FieldDescriptorType)descriptor2, value);
            }
        } else {
            this.fields.put((FieldDescriptorType)descriptor2, this.cloneIfMutable(otherValue));
        }
    }

    public static Object readPrimitiveField(CodedInputStream input, WireFormat.FieldType type2, boolean checkUtf8) throws IOException {
        switch (type2) {
            case DOUBLE: {
                return input.readDouble();
            }
            case FLOAT: {
                return Float.valueOf(input.readFloat());
            }
            case INT64: {
                return input.readInt64();
            }
            case UINT64: {
                return input.readUInt64();
            }
            case INT32: {
                return input.readInt32();
            }
            case FIXED64: {
                return input.readFixed64();
            }
            case FIXED32: {
                return input.readFixed32();
            }
            case BOOL: {
                return input.readBool();
            }
            case STRING: {
                if (checkUtf8) {
                    return input.readStringRequireUtf8();
                }
                return input.readString();
            }
            case BYTES: {
                return input.readBytes();
            }
            case UINT32: {
                return input.readUInt32();
            }
            case SFIXED32: {
                return input.readSFixed32();
            }
            case SFIXED64: {
                return input.readSFixed64();
            }
            case SINT32: {
                return input.readSInt32();
            }
            case SINT64: {
                return input.readSInt64();
            }
            case GROUP: {
                throw new IllegalArgumentException("readPrimitiveField() cannot handle nested groups.");
            }
            case MESSAGE: {
                throw new IllegalArgumentException("readPrimitiveField() cannot handle embedded messages.");
            }
            case ENUM: {
                throw new IllegalArgumentException("readPrimitiveField() cannot handle enums.");
            }
        }
        throw new RuntimeException("There is no way to get here, but the compiler thinks otherwise.");
    }

    public void writeTo(CodedOutputStream output) throws IOException {
        for (int i = 0; i < this.fields.getNumArrayEntries(); ++i) {
            Map.Entry<FieldDescriptorType, Object> entry = this.fields.getArrayEntryAt(i);
            FieldSet.writeField((FieldDescriptorLite)entry.getKey(), entry.getValue(), output);
        }
        for (Map.Entry<FieldDescriptorType, Object> entry : this.fields.getOverflowEntries()) {
            FieldSet.writeField((FieldDescriptorLite)entry.getKey(), entry.getValue(), output);
        }
    }

    public void writeMessageSetTo(CodedOutputStream output) throws IOException {
        for (int i = 0; i < this.fields.getNumArrayEntries(); ++i) {
            this.writeMessageSetTo(this.fields.getArrayEntryAt(i), output);
        }
        for (Map.Entry<FieldDescriptorType, Object> entry : this.fields.getOverflowEntries()) {
            this.writeMessageSetTo(entry, output);
        }
    }

    private void writeMessageSetTo(Map.Entry<FieldDescriptorType, Object> entry, CodedOutputStream output) throws IOException {
        FieldDescriptorLite descriptor2 = (FieldDescriptorLite)entry.getKey();
        if (descriptor2.getLiteJavaType() == WireFormat.JavaType.MESSAGE && !descriptor2.isRepeated() && !descriptor2.isPacked()) {
            Object value = entry.getValue();
            if (value instanceof LazyField) {
                value = ((LazyField)value).getValue();
            }
            output.writeMessageSetExtension(((FieldDescriptorLite)entry.getKey()).getNumber(), (MessageLite)value);
        } else {
            FieldSet.writeField(descriptor2, entry.getValue(), output);
        }
    }

    private static void writeElement(CodedOutputStream output, WireFormat.FieldType type2, int number, Object value) throws IOException {
        if (type2 == WireFormat.FieldType.GROUP) {
            output.writeGroup(number, (MessageLite)value);
        } else {
            output.writeTag(number, FieldSet.getWireFormatForFieldType(type2, false));
            FieldSet.writeElementNoTag(output, type2, value);
        }
    }

    private static void writeElementNoTag(CodedOutputStream output, WireFormat.FieldType type2, Object value) throws IOException {
        switch (type2) {
            case DOUBLE: {
                output.writeDoubleNoTag((Double)value);
                break;
            }
            case FLOAT: {
                output.writeFloatNoTag(((Float)value).floatValue());
                break;
            }
            case INT64: {
                output.writeInt64NoTag((Long)value);
                break;
            }
            case UINT64: {
                output.writeUInt64NoTag((Long)value);
                break;
            }
            case INT32: {
                output.writeInt32NoTag((Integer)value);
                break;
            }
            case FIXED64: {
                output.writeFixed64NoTag((Long)value);
                break;
            }
            case FIXED32: {
                output.writeFixed32NoTag((Integer)value);
                break;
            }
            case BOOL: {
                output.writeBoolNoTag((Boolean)value);
                break;
            }
            case STRING: {
                output.writeStringNoTag((String)value);
                break;
            }
            case GROUP: {
                output.writeGroupNoTag((MessageLite)value);
                break;
            }
            case MESSAGE: {
                output.writeMessageNoTag((MessageLite)value);
                break;
            }
            case BYTES: {
                if (value instanceof ByteString) {
                    output.writeBytesNoTag((ByteString)value);
                    break;
                }
                output.writeByteArrayNoTag((byte[])value);
                break;
            }
            case UINT32: {
                output.writeUInt32NoTag((Integer)value);
                break;
            }
            case SFIXED32: {
                output.writeSFixed32NoTag((Integer)value);
                break;
            }
            case SFIXED64: {
                output.writeSFixed64NoTag((Long)value);
                break;
            }
            case SINT32: {
                output.writeSInt32NoTag((Integer)value);
                break;
            }
            case SINT64: {
                output.writeSInt64NoTag((Long)value);
                break;
            }
            case ENUM: {
                if (value instanceof Internal.EnumLite) {
                    output.writeEnumNoTag(((Internal.EnumLite)value).getNumber());
                    break;
                }
                output.writeEnumNoTag((Integer)value);
            }
        }
    }

    public static void writeField(FieldDescriptorLite<?> descriptor2, Object value, CodedOutputStream output) throws IOException {
        WireFormat.FieldType type2 = descriptor2.getLiteType();
        int number = descriptor2.getNumber();
        if (descriptor2.isRepeated()) {
            List valueList = (List)value;
            if (descriptor2.isPacked()) {
                output.writeTag(number, 2);
                int dataSize = 0;
                for (Object element : valueList) {
                    dataSize += FieldSet.computeElementSizeNoTag(type2, element);
                }
                output.writeRawVarint32(dataSize);
                for (Object element : valueList) {
                    FieldSet.writeElementNoTag(output, type2, element);
                }
            } else {
                for (Object element : valueList) {
                    FieldSet.writeElement(output, type2, number, element);
                }
            }
        } else if (value instanceof LazyField) {
            FieldSet.writeElement(output, type2, number, ((LazyField)value).getValue());
        } else {
            FieldSet.writeElement(output, type2, number, value);
        }
    }

    public int getSerializedSize() {
        int size = 0;
        for (int i = 0; i < this.fields.getNumArrayEntries(); ++i) {
            Map.Entry<FieldDescriptorType, Object> entry = this.fields.getArrayEntryAt(i);
            size += FieldSet.computeFieldSize((FieldDescriptorLite)entry.getKey(), entry.getValue());
        }
        for (Map.Entry<FieldDescriptorType, Object> entry : this.fields.getOverflowEntries()) {
            size += FieldSet.computeFieldSize((FieldDescriptorLite)entry.getKey(), entry.getValue());
        }
        return size;
    }

    public int getMessageSetSerializedSize() {
        int size = 0;
        for (int i = 0; i < this.fields.getNumArrayEntries(); ++i) {
            size += this.getMessageSetSerializedSize(this.fields.getArrayEntryAt(i));
        }
        for (Map.Entry<FieldDescriptorType, Object> entry : this.fields.getOverflowEntries()) {
            size += this.getMessageSetSerializedSize(entry);
        }
        return size;
    }

    private int getMessageSetSerializedSize(Map.Entry<FieldDescriptorType, Object> entry) {
        FieldDescriptorLite descriptor2 = (FieldDescriptorLite)entry.getKey();
        Object value = entry.getValue();
        if (descriptor2.getLiteJavaType() == WireFormat.JavaType.MESSAGE && !descriptor2.isRepeated() && !descriptor2.isPacked()) {
            if (value instanceof LazyField) {
                return CodedOutputStream.computeLazyFieldMessageSetExtensionSize(((FieldDescriptorLite)entry.getKey()).getNumber(), (LazyField)value);
            }
            return CodedOutputStream.computeMessageSetExtensionSize(((FieldDescriptorLite)entry.getKey()).getNumber(), (MessageLite)value);
        }
        return FieldSet.computeFieldSize(descriptor2, value);
    }

    private static int computeElementSize(WireFormat.FieldType type2, int number, Object value) {
        int tagSize = CodedOutputStream.computeTagSize(number);
        if (type2 == WireFormat.FieldType.GROUP) {
            tagSize *= 2;
        }
        return tagSize + FieldSet.computeElementSizeNoTag(type2, value);
    }

    private static int computeElementSizeNoTag(WireFormat.FieldType type2, Object value) {
        switch (type2) {
            case DOUBLE: {
                return CodedOutputStream.computeDoubleSizeNoTag((Double)value);
            }
            case FLOAT: {
                return CodedOutputStream.computeFloatSizeNoTag(((Float)value).floatValue());
            }
            case INT64: {
                return CodedOutputStream.computeInt64SizeNoTag((Long)value);
            }
            case UINT64: {
                return CodedOutputStream.computeUInt64SizeNoTag((Long)value);
            }
            case INT32: {
                return CodedOutputStream.computeInt32SizeNoTag((Integer)value);
            }
            case FIXED64: {
                return CodedOutputStream.computeFixed64SizeNoTag((Long)value);
            }
            case FIXED32: {
                return CodedOutputStream.computeFixed32SizeNoTag((Integer)value);
            }
            case BOOL: {
                return CodedOutputStream.computeBoolSizeNoTag((Boolean)value);
            }
            case STRING: {
                return CodedOutputStream.computeStringSizeNoTag((String)value);
            }
            case GROUP: {
                return CodedOutputStream.computeGroupSizeNoTag((MessageLite)value);
            }
            case BYTES: {
                if (value instanceof ByteString) {
                    return CodedOutputStream.computeBytesSizeNoTag((ByteString)value);
                }
                return CodedOutputStream.computeByteArraySizeNoTag((byte[])value);
            }
            case UINT32: {
                return CodedOutputStream.computeUInt32SizeNoTag((Integer)value);
            }
            case SFIXED32: {
                return CodedOutputStream.computeSFixed32SizeNoTag((Integer)value);
            }
            case SFIXED64: {
                return CodedOutputStream.computeSFixed64SizeNoTag((Long)value);
            }
            case SINT32: {
                return CodedOutputStream.computeSInt32SizeNoTag((Integer)value);
            }
            case SINT64: {
                return CodedOutputStream.computeSInt64SizeNoTag((Long)value);
            }
            case MESSAGE: {
                if (value instanceof LazyField) {
                    return CodedOutputStream.computeLazyFieldSizeNoTag((LazyField)value);
                }
                return CodedOutputStream.computeMessageSizeNoTag((MessageLite)value);
            }
            case ENUM: {
                if (value instanceof Internal.EnumLite) {
                    return CodedOutputStream.computeEnumSizeNoTag(((Internal.EnumLite)value).getNumber());
                }
                return CodedOutputStream.computeEnumSizeNoTag((Integer)value);
            }
        }
        throw new RuntimeException("There is no way to get here, but the compiler thinks otherwise.");
    }

    public static int computeFieldSize(FieldDescriptorLite<?> descriptor2, Object value) {
        WireFormat.FieldType type2 = descriptor2.getLiteType();
        int number = descriptor2.getNumber();
        if (descriptor2.isRepeated()) {
            if (descriptor2.isPacked()) {
                int dataSize = 0;
                for (Object element : (List)value) {
                    dataSize += FieldSet.computeElementSizeNoTag(type2, element);
                }
                return dataSize + CodedOutputStream.computeTagSize(number) + CodedOutputStream.computeRawVarint32Size(dataSize);
            }
            int size = 0;
            for (Object element : (List)value) {
                size += FieldSet.computeElementSize(type2, number, element);
            }
            return size;
        }
        return FieldSet.computeElementSize(type2, number, value);
    }

    /*
     * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
     */
    public static interface FieldDescriptorLite<T extends FieldDescriptorLite<T>>
    extends Comparable<T> {
        public int getNumber();

        public WireFormat.FieldType getLiteType();

        public WireFormat.JavaType getLiteJavaType();

        public boolean isRepeated();

        public boolean isPacked();

        public Internal.EnumLiteMap<?> getEnumType();

        public MessageLite.Builder internalMergeFrom(MessageLite.Builder var1, MessageLite var2);
    }
}

