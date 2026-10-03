/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.serialization.builtins;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectStreamException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite;
import kotlin.reflect.jvm.internal.impl.protobuf.AbstractParser;
import kotlin.reflect.jvm.internal.impl.protobuf.ByteString;
import kotlin.reflect.jvm.internal.impl.protobuf.CodedInputStream;
import kotlin.reflect.jvm.internal.impl.protobuf.CodedOutputStream;
import kotlin.reflect.jvm.internal.impl.protobuf.ExtensionRegistryLite;
import kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite;
import kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException;
import kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder;
import kotlin.reflect.jvm.internal.impl.protobuf.Parser;
import kotlin.reflect.jvm.internal.impl.protobuf.WireFormat;
import kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf;

public final class BuiltInsProtoBuf {
    public static final int PACKAGE_FQ_NAME_FIELD_NUMBER = 151;
    public static final GeneratedMessageLite.GeneratedExtension<ProtoBuf.Package, Integer> packageFqName = GeneratedMessageLite.newSingularGeneratedExtension(ProtoBuf.Package.getDefaultInstance(), 0, null, null, 151, WireFormat.FieldType.INT32, Integer.class);
    public static final int CLASS_ANNOTATION_FIELD_NUMBER = 150;
    public static final GeneratedMessageLite.GeneratedExtension<ProtoBuf.Class, List<ProtoBuf.Annotation>> classAnnotation = GeneratedMessageLite.newRepeatedGeneratedExtension(ProtoBuf.Class.getDefaultInstance(), ProtoBuf.Annotation.getDefaultInstance(), null, 150, WireFormat.FieldType.MESSAGE, false, ProtoBuf.Annotation.class);
    public static final int CONSTRUCTOR_ANNOTATION_FIELD_NUMBER = 150;
    public static final GeneratedMessageLite.GeneratedExtension<ProtoBuf.Constructor, List<ProtoBuf.Annotation>> constructorAnnotation = GeneratedMessageLite.newRepeatedGeneratedExtension(ProtoBuf.Constructor.getDefaultInstance(), ProtoBuf.Annotation.getDefaultInstance(), null, 150, WireFormat.FieldType.MESSAGE, false, ProtoBuf.Annotation.class);
    public static final int FUNCTION_ANNOTATION_FIELD_NUMBER = 150;
    public static final GeneratedMessageLite.GeneratedExtension<ProtoBuf.Function, List<ProtoBuf.Annotation>> functionAnnotation = GeneratedMessageLite.newRepeatedGeneratedExtension(ProtoBuf.Function.getDefaultInstance(), ProtoBuf.Annotation.getDefaultInstance(), null, 150, WireFormat.FieldType.MESSAGE, false, ProtoBuf.Annotation.class);
    public static final int PROPERTY_ANNOTATION_FIELD_NUMBER = 150;
    public static final GeneratedMessageLite.GeneratedExtension<ProtoBuf.Property, List<ProtoBuf.Annotation>> propertyAnnotation = GeneratedMessageLite.newRepeatedGeneratedExtension(ProtoBuf.Property.getDefaultInstance(), ProtoBuf.Annotation.getDefaultInstance(), null, 150, WireFormat.FieldType.MESSAGE, false, ProtoBuf.Annotation.class);
    public static final int COMPILE_TIME_VALUE_FIELD_NUMBER = 151;
    public static final GeneratedMessageLite.GeneratedExtension<ProtoBuf.Property, ProtoBuf.Annotation.Argument.Value> compileTimeValue = GeneratedMessageLite.newSingularGeneratedExtension(ProtoBuf.Property.getDefaultInstance(), ProtoBuf.Annotation.Argument.Value.getDefaultInstance(), ProtoBuf.Annotation.Argument.Value.getDefaultInstance(), null, 151, WireFormat.FieldType.MESSAGE, ProtoBuf.Annotation.Argument.Value.class);
    public static final int ENUM_ENTRY_ANNOTATION_FIELD_NUMBER = 150;
    public static final GeneratedMessageLite.GeneratedExtension<ProtoBuf.EnumEntry, List<ProtoBuf.Annotation>> enumEntryAnnotation = GeneratedMessageLite.newRepeatedGeneratedExtension(ProtoBuf.EnumEntry.getDefaultInstance(), ProtoBuf.Annotation.getDefaultInstance(), null, 150, WireFormat.FieldType.MESSAGE, false, ProtoBuf.Annotation.class);
    public static final int PARAMETER_ANNOTATION_FIELD_NUMBER = 150;
    public static final GeneratedMessageLite.GeneratedExtension<ProtoBuf.ValueParameter, List<ProtoBuf.Annotation>> parameterAnnotation = GeneratedMessageLite.newRepeatedGeneratedExtension(ProtoBuf.ValueParameter.getDefaultInstance(), ProtoBuf.Annotation.getDefaultInstance(), null, 150, WireFormat.FieldType.MESSAGE, false, ProtoBuf.Annotation.class);
    public static final int TYPE_ANNOTATION_FIELD_NUMBER = 150;
    public static final GeneratedMessageLite.GeneratedExtension<ProtoBuf.Type, List<ProtoBuf.Annotation>> typeAnnotation = GeneratedMessageLite.newRepeatedGeneratedExtension(ProtoBuf.Type.getDefaultInstance(), ProtoBuf.Annotation.getDefaultInstance(), null, 150, WireFormat.FieldType.MESSAGE, false, ProtoBuf.Annotation.class);
    public static final int TYPE_PARAMETER_ANNOTATION_FIELD_NUMBER = 150;
    public static final GeneratedMessageLite.GeneratedExtension<ProtoBuf.TypeParameter, List<ProtoBuf.Annotation>> typeParameterAnnotation = GeneratedMessageLite.newRepeatedGeneratedExtension(ProtoBuf.TypeParameter.getDefaultInstance(), ProtoBuf.Annotation.getDefaultInstance(), null, 150, WireFormat.FieldType.MESSAGE, false, ProtoBuf.Annotation.class);

    private BuiltInsProtoBuf() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
        registry.add(packageFqName);
        registry.add(classAnnotation);
        registry.add(constructorAnnotation);
        registry.add(functionAnnotation);
        registry.add(propertyAnnotation);
        registry.add(compileTimeValue);
        registry.add(enumEntryAnnotation);
        registry.add(parameterAnnotation);
        registry.add(typeAnnotation);
        registry.add(typeParameterAnnotation);
    }

    public static final class BuiltIns
    extends GeneratedMessageLite
    implements BuiltInsOrBuilder {
        private static final BuiltIns defaultInstance;
        private final ByteString unknownFields;
        public static Parser<BuiltIns> PARSER;
        private int bitField0_;
        public static final int STRINGS_FIELD_NUMBER = 1;
        private ProtoBuf.StringTable strings_;
        public static final int QUALIFIED_NAMES_FIELD_NUMBER = 2;
        private ProtoBuf.QualifiedNameTable qualifiedNames_;
        public static final int PACKAGE_FIELD_NUMBER = 3;
        private ProtoBuf.Package package_;
        public static final int CLASS_FIELD_NUMBER = 4;
        private List<ProtoBuf.Class> class__;
        private byte memoizedIsInitialized = (byte)-1;
        private int memoizedSerializedSize = -1;
        private static final long serialVersionUID = 0L;

        private BuiltIns(GeneratedMessageLite.Builder builder) {
            super(builder);
            this.unknownFields = builder.getUnknownFields();
        }

        private BuiltIns(boolean noInit) {
            this.unknownFields = ByteString.EMPTY;
        }

        public static BuiltIns getDefaultInstance() {
            return defaultInstance;
        }

        @Override
        public BuiltIns getDefaultInstanceForType() {
            return defaultInstance;
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        private BuiltIns(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            this.initFields();
            int mutable_bitField0_ = 0;
            ByteString.Output unknownFieldsOutput = ByteString.newOutput();
            CodedOutputStream unknownFieldsCodedOutput = CodedOutputStream.newInstance(unknownFieldsOutput);
            try {
                boolean done = false;
                block22: while (!done) {
                    int tag = input.readTag();
                    switch (tag) {
                        case 0: {
                            done = true;
                            continue block22;
                        }
                        default: {
                            if (this.parseUnknownField(input, unknownFieldsCodedOutput, extensionRegistry, tag)) continue block22;
                            done = true;
                            continue block22;
                        }
                        case 10: {
                            GeneratedMessageLite.Builder subBuilder = null;
                            if ((this.bitField0_ & 1) == 1) {
                                subBuilder = this.strings_.toBuilder();
                            }
                            this.strings_ = input.readMessage(ProtoBuf.StringTable.PARSER, extensionRegistry);
                            if (subBuilder != null) {
                                ((ProtoBuf.StringTable.Builder)subBuilder).mergeFrom(this.strings_);
                                this.strings_ = ((ProtoBuf.StringTable.Builder)subBuilder).buildPartial();
                            }
                            this.bitField0_ |= 1;
                            continue block22;
                        }
                        case 18: {
                            GeneratedMessageLite.Builder subBuilder = null;
                            if ((this.bitField0_ & 2) == 2) {
                                subBuilder = this.qualifiedNames_.toBuilder();
                            }
                            this.qualifiedNames_ = input.readMessage(ProtoBuf.QualifiedNameTable.PARSER, extensionRegistry);
                            if (subBuilder != null) {
                                ((ProtoBuf.QualifiedNameTable.Builder)subBuilder).mergeFrom(this.qualifiedNames_);
                                this.qualifiedNames_ = ((ProtoBuf.QualifiedNameTable.Builder)subBuilder).buildPartial();
                            }
                            this.bitField0_ |= 2;
                            continue block22;
                        }
                        case 26: {
                            GeneratedMessageLite.Builder subBuilder = null;
                            if ((this.bitField0_ & 4) == 4) {
                                subBuilder = this.package_.toBuilder();
                            }
                            this.package_ = input.readMessage(ProtoBuf.Package.PARSER, extensionRegistry);
                            if (subBuilder != null) {
                                ((ProtoBuf.Package.Builder)subBuilder).mergeFrom(this.package_);
                                this.package_ = ((ProtoBuf.Package.Builder)subBuilder).buildPartial();
                            }
                            this.bitField0_ |= 4;
                            continue block22;
                        }
                        case 34: 
                    }
                    if ((mutable_bitField0_ & 8) != 8) {
                        this.class__ = new ArrayList<ProtoBuf.Class>();
                        mutable_bitField0_ |= 8;
                    }
                    this.class__.add(input.readMessage(ProtoBuf.Class.PARSER, extensionRegistry));
                }
            }
            catch (InvalidProtocolBufferException e) {
                throw e.setUnfinishedMessage(this);
            }
            catch (IOException e) {
                throw new InvalidProtocolBufferException(e.getMessage()).setUnfinishedMessage(this);
            }
            finally {
                if ((mutable_bitField0_ & 8) == 8) {
                    this.class__ = Collections.unmodifiableList(this.class__);
                }
                try {
                    unknownFieldsCodedOutput.flush();
                }
                catch (IOException e) {
                }
                finally {
                    this.unknownFields = unknownFieldsOutput.toByteString();
                }
                this.makeExtensionsImmutable();
            }
        }

        public Parser<BuiltIns> getParserForType() {
            return PARSER;
        }

        @Override
        public boolean hasStrings() {
            return (this.bitField0_ & 1) == 1;
        }

        @Override
        public ProtoBuf.StringTable getStrings() {
            return this.strings_;
        }

        @Override
        public boolean hasQualifiedNames() {
            return (this.bitField0_ & 2) == 2;
        }

        @Override
        public ProtoBuf.QualifiedNameTable getQualifiedNames() {
            return this.qualifiedNames_;
        }

        @Override
        public boolean hasPackage() {
            return (this.bitField0_ & 4) == 4;
        }

        @Override
        public ProtoBuf.Package getPackage() {
            return this.package_;
        }

        @Override
        public List<ProtoBuf.Class> getClass_List() {
            return this.class__;
        }

        public List<? extends ProtoBuf.ClassOrBuilder> getClass_OrBuilderList() {
            return this.class__;
        }

        @Override
        public int getClass_Count() {
            return this.class__.size();
        }

        @Override
        public ProtoBuf.Class getClass_(int index) {
            return this.class__.get(index);
        }

        public ProtoBuf.ClassOrBuilder getClass_OrBuilder(int index) {
            return this.class__.get(index);
        }

        private void initFields() {
            this.strings_ = ProtoBuf.StringTable.getDefaultInstance();
            this.qualifiedNames_ = ProtoBuf.QualifiedNameTable.getDefaultInstance();
            this.package_ = ProtoBuf.Package.getDefaultInstance();
            this.class__ = Collections.emptyList();
        }

        @Override
        public final boolean isInitialized() {
            byte isInitialized = this.memoizedIsInitialized;
            if (isInitialized == 1) {
                return true;
            }
            if (isInitialized == 0) {
                return false;
            }
            if (this.hasQualifiedNames() && !this.getQualifiedNames().isInitialized()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            if (this.hasPackage() && !this.getPackage().isInitialized()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            for (int i = 0; i < this.getClass_Count(); ++i) {
                if (this.getClass_(i).isInitialized()) continue;
                this.memoizedIsInitialized = 0;
                return false;
            }
            this.memoizedIsInitialized = 1;
            return true;
        }

        @Override
        public void writeTo(CodedOutputStream output) throws IOException {
            this.getSerializedSize();
            if ((this.bitField0_ & 1) == 1) {
                output.writeMessage(1, this.strings_);
            }
            if ((this.bitField0_ & 2) == 2) {
                output.writeMessage(2, this.qualifiedNames_);
            }
            if ((this.bitField0_ & 4) == 4) {
                output.writeMessage(3, this.package_);
            }
            for (int i = 0; i < this.class__.size(); ++i) {
                output.writeMessage(4, this.class__.get(i));
            }
            output.writeRawBytes(this.unknownFields);
        }

        @Override
        public int getSerializedSize() {
            int size = this.memoizedSerializedSize;
            if (size != -1) {
                return size;
            }
            size = 0;
            if ((this.bitField0_ & 1) == 1) {
                size += CodedOutputStream.computeMessageSize(1, this.strings_);
            }
            if ((this.bitField0_ & 2) == 2) {
                size += CodedOutputStream.computeMessageSize(2, this.qualifiedNames_);
            }
            if ((this.bitField0_ & 4) == 4) {
                size += CodedOutputStream.computeMessageSize(3, this.package_);
            }
            for (int i = 0; i < this.class__.size(); ++i) {
                size += CodedOutputStream.computeMessageSize(4, this.class__.get(i));
            }
            this.memoizedSerializedSize = size += this.unknownFields.size();
            return size;
        }

        @Override
        protected Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }

        public static BuiltIns parseFrom(ByteString data2) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data2);
        }

        public static BuiltIns parseFrom(ByteString data2, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data2, extensionRegistry);
        }

        public static BuiltIns parseFrom(byte[] data2) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data2);
        }

        public static BuiltIns parseFrom(byte[] data2, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data2, extensionRegistry);
        }

        public static BuiltIns parseFrom(InputStream input) throws IOException {
            return PARSER.parseFrom(input);
        }

        public static BuiltIns parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return PARSER.parseFrom(input, extensionRegistry);
        }

        public static BuiltIns parseDelimitedFrom(InputStream input) throws IOException {
            return PARSER.parseDelimitedFrom(input);
        }

        public static BuiltIns parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return PARSER.parseDelimitedFrom(input, extensionRegistry);
        }

        public static BuiltIns parseFrom(CodedInputStream input) throws IOException {
            return PARSER.parseFrom(input);
        }

        public static BuiltIns parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return PARSER.parseFrom(input, extensionRegistry);
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        @Override
        public Builder newBuilderForType() {
            return BuiltIns.newBuilder();
        }

        public static Builder newBuilder(BuiltIns prototype) {
            return BuiltIns.newBuilder().mergeFrom(prototype);
        }

        @Override
        public Builder toBuilder() {
            return BuiltIns.newBuilder(this);
        }

        static {
            PARSER = new AbstractParser<BuiltIns>(){

                @Override
                public BuiltIns parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                    return new BuiltIns(input, extensionRegistry);
                }
            };
            defaultInstance = new BuiltIns(true);
            defaultInstance.initFields();
        }

        public static final class Builder
        extends GeneratedMessageLite.Builder<BuiltIns, Builder>
        implements BuiltInsOrBuilder {
            private int bitField0_;
            private ProtoBuf.StringTable strings_ = ProtoBuf.StringTable.getDefaultInstance();
            private ProtoBuf.QualifiedNameTable qualifiedNames_ = ProtoBuf.QualifiedNameTable.getDefaultInstance();
            private ProtoBuf.Package package_ = ProtoBuf.Package.getDefaultInstance();
            private List<ProtoBuf.Class> class__ = Collections.emptyList();

            private Builder() {
                this.maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
            }

            private static Builder create() {
                return new Builder();
            }

            @Override
            public Builder clear() {
                super.clear();
                this.strings_ = ProtoBuf.StringTable.getDefaultInstance();
                this.bitField0_ &= 0xFFFFFFFE;
                this.qualifiedNames_ = ProtoBuf.QualifiedNameTable.getDefaultInstance();
                this.bitField0_ &= 0xFFFFFFFD;
                this.package_ = ProtoBuf.Package.getDefaultInstance();
                this.bitField0_ &= 0xFFFFFFFB;
                this.class__ = Collections.emptyList();
                this.bitField0_ &= 0xFFFFFFF7;
                return this;
            }

            @Override
            public Builder clone() {
                return Builder.create().mergeFrom(this.buildPartial());
            }

            @Override
            public BuiltIns getDefaultInstanceForType() {
                return BuiltIns.getDefaultInstance();
            }

            @Override
            public BuiltIns build() {
                BuiltIns result2 = this.buildPartial();
                if (!result2.isInitialized()) {
                    throw Builder.newUninitializedMessageException(result2);
                }
                return result2;
            }

            @Override
            public BuiltIns buildPartial() {
                BuiltIns result2 = new BuiltIns(this);
                int from_bitField0_ = this.bitField0_;
                int to_bitField0_ = 0;
                if ((from_bitField0_ & 1) == 1) {
                    to_bitField0_ |= 1;
                }
                result2.strings_ = this.strings_;
                if ((from_bitField0_ & 2) == 2) {
                    to_bitField0_ |= 2;
                }
                result2.qualifiedNames_ = this.qualifiedNames_;
                if ((from_bitField0_ & 4) == 4) {
                    to_bitField0_ |= 4;
                }
                result2.package_ = this.package_;
                if ((this.bitField0_ & 8) == 8) {
                    this.class__ = Collections.unmodifiableList(this.class__);
                    this.bitField0_ &= 0xFFFFFFF7;
                }
                result2.class__ = this.class__;
                result2.bitField0_ = to_bitField0_;
                return result2;
            }

            @Override
            public Builder mergeFrom(BuiltIns other) {
                if (other == BuiltIns.getDefaultInstance()) {
                    return this;
                }
                if (other.hasStrings()) {
                    this.mergeStrings(other.getStrings());
                }
                if (other.hasQualifiedNames()) {
                    this.mergeQualifiedNames(other.getQualifiedNames());
                }
                if (other.hasPackage()) {
                    this.mergePackage(other.getPackage());
                }
                if (!other.class__.isEmpty()) {
                    if (this.class__.isEmpty()) {
                        this.class__ = other.class__;
                        this.bitField0_ &= 0xFFFFFFF7;
                    } else {
                        this.ensureClass_IsMutable();
                        this.class__.addAll(other.class__);
                    }
                }
                this.setUnknownFields(this.getUnknownFields().concat(other.unknownFields));
                return this;
            }

            @Override
            public final boolean isInitialized() {
                if (this.hasQualifiedNames() && !this.getQualifiedNames().isInitialized()) {
                    return false;
                }
                if (this.hasPackage() && !this.getPackage().isInitialized()) {
                    return false;
                }
                for (int i = 0; i < this.getClass_Count(); ++i) {
                    if (this.getClass_(i).isInitialized()) continue;
                    return false;
                }
                return true;
            }

            @Override
            public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                BuiltIns parsedMessage = null;
                try {
                    parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
                }
                catch (InvalidProtocolBufferException e) {
                    parsedMessage = (BuiltIns)e.getUnfinishedMessage();
                    throw e;
                }
                finally {
                    if (parsedMessage != null) {
                        this.mergeFrom(parsedMessage);
                    }
                }
                return this;
            }

            @Override
            public boolean hasStrings() {
                return (this.bitField0_ & 1) == 1;
            }

            @Override
            public ProtoBuf.StringTable getStrings() {
                return this.strings_;
            }

            public Builder setStrings(ProtoBuf.StringTable value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.strings_ = value;
                this.bitField0_ |= 1;
                return this;
            }

            public Builder setStrings(ProtoBuf.StringTable.Builder builderForValue) {
                this.strings_ = builderForValue.build();
                this.bitField0_ |= 1;
                return this;
            }

            public Builder mergeStrings(ProtoBuf.StringTable value) {
                this.strings_ = (this.bitField0_ & 1) == 1 && this.strings_ != ProtoBuf.StringTable.getDefaultInstance() ? ProtoBuf.StringTable.newBuilder(this.strings_).mergeFrom(value).buildPartial() : value;
                this.bitField0_ |= 1;
                return this;
            }

            public Builder clearStrings() {
                this.strings_ = ProtoBuf.StringTable.getDefaultInstance();
                this.bitField0_ &= 0xFFFFFFFE;
                return this;
            }

            @Override
            public boolean hasQualifiedNames() {
                return (this.bitField0_ & 2) == 2;
            }

            @Override
            public ProtoBuf.QualifiedNameTable getQualifiedNames() {
                return this.qualifiedNames_;
            }

            public Builder setQualifiedNames(ProtoBuf.QualifiedNameTable value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.qualifiedNames_ = value;
                this.bitField0_ |= 2;
                return this;
            }

            public Builder setQualifiedNames(ProtoBuf.QualifiedNameTable.Builder builderForValue) {
                this.qualifiedNames_ = builderForValue.build();
                this.bitField0_ |= 2;
                return this;
            }

            public Builder mergeQualifiedNames(ProtoBuf.QualifiedNameTable value) {
                this.qualifiedNames_ = (this.bitField0_ & 2) == 2 && this.qualifiedNames_ != ProtoBuf.QualifiedNameTable.getDefaultInstance() ? ProtoBuf.QualifiedNameTable.newBuilder(this.qualifiedNames_).mergeFrom(value).buildPartial() : value;
                this.bitField0_ |= 2;
                return this;
            }

            public Builder clearQualifiedNames() {
                this.qualifiedNames_ = ProtoBuf.QualifiedNameTable.getDefaultInstance();
                this.bitField0_ &= 0xFFFFFFFD;
                return this;
            }

            @Override
            public boolean hasPackage() {
                return (this.bitField0_ & 4) == 4;
            }

            @Override
            public ProtoBuf.Package getPackage() {
                return this.package_;
            }

            public Builder setPackage(ProtoBuf.Package value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.package_ = value;
                this.bitField0_ |= 4;
                return this;
            }

            public Builder setPackage(ProtoBuf.Package.Builder builderForValue) {
                this.package_ = builderForValue.build();
                this.bitField0_ |= 4;
                return this;
            }

            public Builder mergePackage(ProtoBuf.Package value) {
                this.package_ = (this.bitField0_ & 4) == 4 && this.package_ != ProtoBuf.Package.getDefaultInstance() ? ProtoBuf.Package.newBuilder(this.package_).mergeFrom(value).buildPartial() : value;
                this.bitField0_ |= 4;
                return this;
            }

            public Builder clearPackage() {
                this.package_ = ProtoBuf.Package.getDefaultInstance();
                this.bitField0_ &= 0xFFFFFFFB;
                return this;
            }

            private void ensureClass_IsMutable() {
                if ((this.bitField0_ & 8) != 8) {
                    this.class__ = new ArrayList<ProtoBuf.Class>(this.class__);
                    this.bitField0_ |= 8;
                }
            }

            @Override
            public List<ProtoBuf.Class> getClass_List() {
                return Collections.unmodifiableList(this.class__);
            }

            @Override
            public int getClass_Count() {
                return this.class__.size();
            }

            @Override
            public ProtoBuf.Class getClass_(int index) {
                return this.class__.get(index);
            }

            public Builder setClass_(int index, ProtoBuf.Class value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.ensureClass_IsMutable();
                this.class__.set(index, value);
                return this;
            }

            public Builder setClass_(int index, ProtoBuf.Class.Builder builderForValue) {
                this.ensureClass_IsMutable();
                this.class__.set(index, builderForValue.build());
                return this;
            }

            public Builder addClass_(ProtoBuf.Class value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.ensureClass_IsMutable();
                this.class__.add(value);
                return this;
            }

            public Builder addClass_(int index, ProtoBuf.Class value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.ensureClass_IsMutable();
                this.class__.add(index, value);
                return this;
            }

            public Builder addClass_(ProtoBuf.Class.Builder builderForValue) {
                this.ensureClass_IsMutable();
                this.class__.add(builderForValue.build());
                return this;
            }

            public Builder addClass_(int index, ProtoBuf.Class.Builder builderForValue) {
                this.ensureClass_IsMutable();
                this.class__.add(index, builderForValue.build());
                return this;
            }

            public Builder addAllClass_(Iterable<? extends ProtoBuf.Class> values2) {
                this.ensureClass_IsMutable();
                AbstractMessageLite.Builder.addAll(values2, this.class__);
                return this;
            }

            public Builder clearClass_() {
                this.class__ = Collections.emptyList();
                this.bitField0_ &= 0xFFFFFFF7;
                return this;
            }

            public Builder removeClass_(int index) {
                this.ensureClass_IsMutable();
                this.class__.remove(index);
                return this;
            }
        }
    }

    public static interface BuiltInsOrBuilder
    extends MessageLiteOrBuilder {
        public boolean hasStrings();

        public ProtoBuf.StringTable getStrings();

        public boolean hasQualifiedNames();

        public ProtoBuf.QualifiedNameTable getQualifiedNames();

        public boolean hasPackage();

        public ProtoBuf.Package getPackage();

        public List<ProtoBuf.Class> getClass_List();

        public ProtoBuf.Class getClass_(int var1);

        public int getClass_Count();
    }
}

