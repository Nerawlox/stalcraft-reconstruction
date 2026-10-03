/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.serialization.jvm;

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
import kotlin.reflect.jvm.internal.impl.protobuf.Internal;
import kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException;
import kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder;
import kotlin.reflect.jvm.internal.impl.protobuf.Parser;
import kotlin.reflect.jvm.internal.impl.protobuf.WireFormat;
import kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf;

public final class JvmProtoBuf {
    public static final int CONSTRUCTOR_SIGNATURE_FIELD_NUMBER = 100;
    public static final GeneratedMessageLite.GeneratedExtension<ProtoBuf.Constructor, JvmMethodSignature> constructorSignature = GeneratedMessageLite.newSingularGeneratedExtension(ProtoBuf.Constructor.getDefaultInstance(), JvmMethodSignature.getDefaultInstance(), JvmMethodSignature.getDefaultInstance(), null, 100, WireFormat.FieldType.MESSAGE, JvmMethodSignature.class);
    public static final int METHOD_SIGNATURE_FIELD_NUMBER = 100;
    public static final GeneratedMessageLite.GeneratedExtension<ProtoBuf.Function, JvmMethodSignature> methodSignature = GeneratedMessageLite.newSingularGeneratedExtension(ProtoBuf.Function.getDefaultInstance(), JvmMethodSignature.getDefaultInstance(), JvmMethodSignature.getDefaultInstance(), null, 100, WireFormat.FieldType.MESSAGE, JvmMethodSignature.class);
    public static final int PROPERTY_SIGNATURE_FIELD_NUMBER = 100;
    public static final GeneratedMessageLite.GeneratedExtension<ProtoBuf.Property, JvmPropertySignature> propertySignature = GeneratedMessageLite.newSingularGeneratedExtension(ProtoBuf.Property.getDefaultInstance(), JvmPropertySignature.getDefaultInstance(), JvmPropertySignature.getDefaultInstance(), null, 100, WireFormat.FieldType.MESSAGE, JvmPropertySignature.class);
    public static final int TYPE_ANNOTATION_FIELD_NUMBER = 100;
    public static final GeneratedMessageLite.GeneratedExtension<ProtoBuf.Type, List<ProtoBuf.Annotation>> typeAnnotation = GeneratedMessageLite.newRepeatedGeneratedExtension(ProtoBuf.Type.getDefaultInstance(), ProtoBuf.Annotation.getDefaultInstance(), null, 100, WireFormat.FieldType.MESSAGE, false, ProtoBuf.Annotation.class);
    public static final int IS_RAW_FIELD_NUMBER = 101;
    public static final GeneratedMessageLite.GeneratedExtension<ProtoBuf.Type, Boolean> isRaw = GeneratedMessageLite.newSingularGeneratedExtension(ProtoBuf.Type.getDefaultInstance(), false, null, null, 101, WireFormat.FieldType.BOOL, Boolean.class);
    public static final int TYPE_PARAMETER_ANNOTATION_FIELD_NUMBER = 100;
    public static final GeneratedMessageLite.GeneratedExtension<ProtoBuf.TypeParameter, List<ProtoBuf.Annotation>> typeParameterAnnotation = GeneratedMessageLite.newRepeatedGeneratedExtension(ProtoBuf.TypeParameter.getDefaultInstance(), ProtoBuf.Annotation.getDefaultInstance(), null, 100, WireFormat.FieldType.MESSAGE, false, ProtoBuf.Annotation.class);
    public static final int CLASS_MODULE_NAME_FIELD_NUMBER = 101;
    public static final GeneratedMessageLite.GeneratedExtension<ProtoBuf.Class, Integer> classModuleName = GeneratedMessageLite.newSingularGeneratedExtension(ProtoBuf.Class.getDefaultInstance(), 0, null, null, 101, WireFormat.FieldType.INT32, Integer.class);
    public static final int PACKAGE_MODULE_NAME_FIELD_NUMBER = 101;
    public static final GeneratedMessageLite.GeneratedExtension<ProtoBuf.Package, Integer> packageModuleName = GeneratedMessageLite.newSingularGeneratedExtension(ProtoBuf.Package.getDefaultInstance(), 0, null, null, 101, WireFormat.FieldType.INT32, Integer.class);

    private JvmProtoBuf() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
        registry.add(constructorSignature);
        registry.add(methodSignature);
        registry.add(propertySignature);
        registry.add(typeAnnotation);
        registry.add(isRaw);
        registry.add(typeParameterAnnotation);
        registry.add(classModuleName);
        registry.add(packageModuleName);
    }

    public static final class JvmPropertySignature
    extends GeneratedMessageLite
    implements JvmPropertySignatureOrBuilder {
        private static final JvmPropertySignature defaultInstance;
        private final ByteString unknownFields;
        public static Parser<JvmPropertySignature> PARSER;
        private int bitField0_;
        public static final int FIELD_FIELD_NUMBER = 1;
        private JvmFieldSignature field_;
        public static final int SYNTHETIC_METHOD_FIELD_NUMBER = 2;
        private JvmMethodSignature syntheticMethod_;
        public static final int GETTER_FIELD_NUMBER = 3;
        private JvmMethodSignature getter_;
        public static final int SETTER_FIELD_NUMBER = 4;
        private JvmMethodSignature setter_;
        private byte memoizedIsInitialized = (byte)-1;
        private int memoizedSerializedSize = -1;
        private static final long serialVersionUID = 0L;

        private JvmPropertySignature(GeneratedMessageLite.Builder builder) {
            super(builder);
            this.unknownFields = builder.getUnknownFields();
        }

        private JvmPropertySignature(boolean noInit) {
            this.unknownFields = ByteString.EMPTY;
        }

        public static JvmPropertySignature getDefaultInstance() {
            return defaultInstance;
        }

        @Override
        public JvmPropertySignature getDefaultInstanceForType() {
            return defaultInstance;
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        private JvmPropertySignature(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            this.initFields();
            boolean mutable_bitField0_ = false;
            ByteString.Output unknownFieldsOutput = ByteString.newOutput();
            CodedOutputStream unknownFieldsCodedOutput = CodedOutputStream.newInstance(unknownFieldsOutput);
            try {
                boolean done = false;
                block22: while (!done) {
                    GeneratedMessageLite.Builder subBuilder;
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
                            subBuilder = null;
                            if ((this.bitField0_ & 1) == 1) {
                                subBuilder = this.field_.toBuilder();
                            }
                            this.field_ = input.readMessage(JvmFieldSignature.PARSER, extensionRegistry);
                            if (subBuilder != null) {
                                ((JvmFieldSignature.Builder)subBuilder).mergeFrom(this.field_);
                                this.field_ = ((JvmFieldSignature.Builder)subBuilder).buildPartial();
                            }
                            this.bitField0_ |= 1;
                            continue block22;
                        }
                        case 18: {
                            subBuilder = null;
                            if ((this.bitField0_ & 2) == 2) {
                                subBuilder = this.syntheticMethod_.toBuilder();
                            }
                            this.syntheticMethod_ = input.readMessage(JvmMethodSignature.PARSER, extensionRegistry);
                            if (subBuilder != null) {
                                ((JvmMethodSignature.Builder)subBuilder).mergeFrom(this.syntheticMethod_);
                                this.syntheticMethod_ = ((JvmMethodSignature.Builder)subBuilder).buildPartial();
                            }
                            this.bitField0_ |= 2;
                            continue block22;
                        }
                        case 26: {
                            subBuilder = null;
                            if ((this.bitField0_ & 4) == 4) {
                                subBuilder = this.getter_.toBuilder();
                            }
                            this.getter_ = input.readMessage(JvmMethodSignature.PARSER, extensionRegistry);
                            if (subBuilder != null) {
                                ((JvmMethodSignature.Builder)subBuilder).mergeFrom(this.getter_);
                                this.getter_ = ((JvmMethodSignature.Builder)subBuilder).buildPartial();
                            }
                            this.bitField0_ |= 4;
                            continue block22;
                        }
                        case 34: 
                    }
                    subBuilder = null;
                    if ((this.bitField0_ & 8) == 8) {
                        subBuilder = this.setter_.toBuilder();
                    }
                    this.setter_ = input.readMessage(JvmMethodSignature.PARSER, extensionRegistry);
                    if (subBuilder != null) {
                        ((JvmMethodSignature.Builder)subBuilder).mergeFrom(this.setter_);
                        this.setter_ = ((JvmMethodSignature.Builder)subBuilder).buildPartial();
                    }
                    this.bitField0_ |= 8;
                }
            }
            catch (InvalidProtocolBufferException e) {
                throw e.setUnfinishedMessage(this);
            }
            catch (IOException e) {
                throw new InvalidProtocolBufferException(e.getMessage()).setUnfinishedMessage(this);
            }
            finally {
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

        public Parser<JvmPropertySignature> getParserForType() {
            return PARSER;
        }

        @Override
        public boolean hasField() {
            return (this.bitField0_ & 1) == 1;
        }

        @Override
        public JvmFieldSignature getField() {
            return this.field_;
        }

        @Override
        public boolean hasSyntheticMethod() {
            return (this.bitField0_ & 2) == 2;
        }

        @Override
        public JvmMethodSignature getSyntheticMethod() {
            return this.syntheticMethod_;
        }

        @Override
        public boolean hasGetter() {
            return (this.bitField0_ & 4) == 4;
        }

        @Override
        public JvmMethodSignature getGetter() {
            return this.getter_;
        }

        @Override
        public boolean hasSetter() {
            return (this.bitField0_ & 8) == 8;
        }

        @Override
        public JvmMethodSignature getSetter() {
            return this.setter_;
        }

        private void initFields() {
            this.field_ = JvmFieldSignature.getDefaultInstance();
            this.syntheticMethod_ = JvmMethodSignature.getDefaultInstance();
            this.getter_ = JvmMethodSignature.getDefaultInstance();
            this.setter_ = JvmMethodSignature.getDefaultInstance();
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
            this.memoizedIsInitialized = 1;
            return true;
        }

        @Override
        public void writeTo(CodedOutputStream output) throws IOException {
            this.getSerializedSize();
            if ((this.bitField0_ & 1) == 1) {
                output.writeMessage(1, this.field_);
            }
            if ((this.bitField0_ & 2) == 2) {
                output.writeMessage(2, this.syntheticMethod_);
            }
            if ((this.bitField0_ & 4) == 4) {
                output.writeMessage(3, this.getter_);
            }
            if ((this.bitField0_ & 8) == 8) {
                output.writeMessage(4, this.setter_);
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
                size += CodedOutputStream.computeMessageSize(1, this.field_);
            }
            if ((this.bitField0_ & 2) == 2) {
                size += CodedOutputStream.computeMessageSize(2, this.syntheticMethod_);
            }
            if ((this.bitField0_ & 4) == 4) {
                size += CodedOutputStream.computeMessageSize(3, this.getter_);
            }
            if ((this.bitField0_ & 8) == 8) {
                size += CodedOutputStream.computeMessageSize(4, this.setter_);
            }
            this.memoizedSerializedSize = size += this.unknownFields.size();
            return size;
        }

        @Override
        protected Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }

        public static JvmPropertySignature parseFrom(ByteString data2) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data2);
        }

        public static JvmPropertySignature parseFrom(ByteString data2, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data2, extensionRegistry);
        }

        public static JvmPropertySignature parseFrom(byte[] data2) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data2);
        }

        public static JvmPropertySignature parseFrom(byte[] data2, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data2, extensionRegistry);
        }

        public static JvmPropertySignature parseFrom(InputStream input) throws IOException {
            return PARSER.parseFrom(input);
        }

        public static JvmPropertySignature parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return PARSER.parseFrom(input, extensionRegistry);
        }

        public static JvmPropertySignature parseDelimitedFrom(InputStream input) throws IOException {
            return PARSER.parseDelimitedFrom(input);
        }

        public static JvmPropertySignature parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return PARSER.parseDelimitedFrom(input, extensionRegistry);
        }

        public static JvmPropertySignature parseFrom(CodedInputStream input) throws IOException {
            return PARSER.parseFrom(input);
        }

        public static JvmPropertySignature parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return PARSER.parseFrom(input, extensionRegistry);
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        @Override
        public Builder newBuilderForType() {
            return JvmPropertySignature.newBuilder();
        }

        public static Builder newBuilder(JvmPropertySignature prototype) {
            return JvmPropertySignature.newBuilder().mergeFrom(prototype);
        }

        @Override
        public Builder toBuilder() {
            return JvmPropertySignature.newBuilder(this);
        }

        static {
            PARSER = new AbstractParser<JvmPropertySignature>(){

                @Override
                public JvmPropertySignature parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                    return new JvmPropertySignature(input, extensionRegistry);
                }
            };
            defaultInstance = new JvmPropertySignature(true);
            defaultInstance.initFields();
        }

        public static final class Builder
        extends GeneratedMessageLite.Builder<JvmPropertySignature, Builder>
        implements JvmPropertySignatureOrBuilder {
            private int bitField0_;
            private JvmFieldSignature field_ = JvmFieldSignature.getDefaultInstance();
            private JvmMethodSignature syntheticMethod_ = JvmMethodSignature.getDefaultInstance();
            private JvmMethodSignature getter_ = JvmMethodSignature.getDefaultInstance();
            private JvmMethodSignature setter_ = JvmMethodSignature.getDefaultInstance();

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
                this.field_ = JvmFieldSignature.getDefaultInstance();
                this.bitField0_ &= 0xFFFFFFFE;
                this.syntheticMethod_ = JvmMethodSignature.getDefaultInstance();
                this.bitField0_ &= 0xFFFFFFFD;
                this.getter_ = JvmMethodSignature.getDefaultInstance();
                this.bitField0_ &= 0xFFFFFFFB;
                this.setter_ = JvmMethodSignature.getDefaultInstance();
                this.bitField0_ &= 0xFFFFFFF7;
                return this;
            }

            @Override
            public Builder clone() {
                return Builder.create().mergeFrom(this.buildPartial());
            }

            @Override
            public JvmPropertySignature getDefaultInstanceForType() {
                return JvmPropertySignature.getDefaultInstance();
            }

            @Override
            public JvmPropertySignature build() {
                JvmPropertySignature result2 = this.buildPartial();
                if (!result2.isInitialized()) {
                    throw Builder.newUninitializedMessageException(result2);
                }
                return result2;
            }

            @Override
            public JvmPropertySignature buildPartial() {
                JvmPropertySignature result2 = new JvmPropertySignature(this);
                int from_bitField0_ = this.bitField0_;
                int to_bitField0_ = 0;
                if ((from_bitField0_ & 1) == 1) {
                    to_bitField0_ |= 1;
                }
                result2.field_ = this.field_;
                if ((from_bitField0_ & 2) == 2) {
                    to_bitField0_ |= 2;
                }
                result2.syntheticMethod_ = this.syntheticMethod_;
                if ((from_bitField0_ & 4) == 4) {
                    to_bitField0_ |= 4;
                }
                result2.getter_ = this.getter_;
                if ((from_bitField0_ & 8) == 8) {
                    to_bitField0_ |= 8;
                }
                result2.setter_ = this.setter_;
                result2.bitField0_ = to_bitField0_;
                return result2;
            }

            @Override
            public Builder mergeFrom(JvmPropertySignature other) {
                if (other == JvmPropertySignature.getDefaultInstance()) {
                    return this;
                }
                if (other.hasField()) {
                    this.mergeField(other.getField());
                }
                if (other.hasSyntheticMethod()) {
                    this.mergeSyntheticMethod(other.getSyntheticMethod());
                }
                if (other.hasGetter()) {
                    this.mergeGetter(other.getGetter());
                }
                if (other.hasSetter()) {
                    this.mergeSetter(other.getSetter());
                }
                this.setUnknownFields(this.getUnknownFields().concat(other.unknownFields));
                return this;
            }

            @Override
            public final boolean isInitialized() {
                return true;
            }

            @Override
            public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                JvmPropertySignature parsedMessage = null;
                try {
                    parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
                }
                catch (InvalidProtocolBufferException e) {
                    parsedMessage = (JvmPropertySignature)e.getUnfinishedMessage();
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
            public boolean hasField() {
                return (this.bitField0_ & 1) == 1;
            }

            @Override
            public JvmFieldSignature getField() {
                return this.field_;
            }

            public Builder setField(JvmFieldSignature value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.field_ = value;
                this.bitField0_ |= 1;
                return this;
            }

            public Builder setField(JvmFieldSignature.Builder builderForValue) {
                this.field_ = builderForValue.build();
                this.bitField0_ |= 1;
                return this;
            }

            public Builder mergeField(JvmFieldSignature value) {
                this.field_ = (this.bitField0_ & 1) == 1 && this.field_ != JvmFieldSignature.getDefaultInstance() ? JvmFieldSignature.newBuilder(this.field_).mergeFrom(value).buildPartial() : value;
                this.bitField0_ |= 1;
                return this;
            }

            public Builder clearField() {
                this.field_ = JvmFieldSignature.getDefaultInstance();
                this.bitField0_ &= 0xFFFFFFFE;
                return this;
            }

            @Override
            public boolean hasSyntheticMethod() {
                return (this.bitField0_ & 2) == 2;
            }

            @Override
            public JvmMethodSignature getSyntheticMethod() {
                return this.syntheticMethod_;
            }

            public Builder setSyntheticMethod(JvmMethodSignature value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.syntheticMethod_ = value;
                this.bitField0_ |= 2;
                return this;
            }

            public Builder setSyntheticMethod(JvmMethodSignature.Builder builderForValue) {
                this.syntheticMethod_ = builderForValue.build();
                this.bitField0_ |= 2;
                return this;
            }

            public Builder mergeSyntheticMethod(JvmMethodSignature value) {
                this.syntheticMethod_ = (this.bitField0_ & 2) == 2 && this.syntheticMethod_ != JvmMethodSignature.getDefaultInstance() ? JvmMethodSignature.newBuilder(this.syntheticMethod_).mergeFrom(value).buildPartial() : value;
                this.bitField0_ |= 2;
                return this;
            }

            public Builder clearSyntheticMethod() {
                this.syntheticMethod_ = JvmMethodSignature.getDefaultInstance();
                this.bitField0_ &= 0xFFFFFFFD;
                return this;
            }

            @Override
            public boolean hasGetter() {
                return (this.bitField0_ & 4) == 4;
            }

            @Override
            public JvmMethodSignature getGetter() {
                return this.getter_;
            }

            public Builder setGetter(JvmMethodSignature value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.getter_ = value;
                this.bitField0_ |= 4;
                return this;
            }

            public Builder setGetter(JvmMethodSignature.Builder builderForValue) {
                this.getter_ = builderForValue.build();
                this.bitField0_ |= 4;
                return this;
            }

            public Builder mergeGetter(JvmMethodSignature value) {
                this.getter_ = (this.bitField0_ & 4) == 4 && this.getter_ != JvmMethodSignature.getDefaultInstance() ? JvmMethodSignature.newBuilder(this.getter_).mergeFrom(value).buildPartial() : value;
                this.bitField0_ |= 4;
                return this;
            }

            public Builder clearGetter() {
                this.getter_ = JvmMethodSignature.getDefaultInstance();
                this.bitField0_ &= 0xFFFFFFFB;
                return this;
            }

            @Override
            public boolean hasSetter() {
                return (this.bitField0_ & 8) == 8;
            }

            @Override
            public JvmMethodSignature getSetter() {
                return this.setter_;
            }

            public Builder setSetter(JvmMethodSignature value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.setter_ = value;
                this.bitField0_ |= 8;
                return this;
            }

            public Builder setSetter(JvmMethodSignature.Builder builderForValue) {
                this.setter_ = builderForValue.build();
                this.bitField0_ |= 8;
                return this;
            }

            public Builder mergeSetter(JvmMethodSignature value) {
                this.setter_ = (this.bitField0_ & 8) == 8 && this.setter_ != JvmMethodSignature.getDefaultInstance() ? JvmMethodSignature.newBuilder(this.setter_).mergeFrom(value).buildPartial() : value;
                this.bitField0_ |= 8;
                return this;
            }

            public Builder clearSetter() {
                this.setter_ = JvmMethodSignature.getDefaultInstance();
                this.bitField0_ &= 0xFFFFFFF7;
                return this;
            }
        }
    }

    public static interface JvmPropertySignatureOrBuilder
    extends MessageLiteOrBuilder {
        public boolean hasField();

        public JvmFieldSignature getField();

        public boolean hasSyntheticMethod();

        public JvmMethodSignature getSyntheticMethod();

        public boolean hasGetter();

        public JvmMethodSignature getGetter();

        public boolean hasSetter();

        public JvmMethodSignature getSetter();
    }

    public static final class JvmFieldSignature
    extends GeneratedMessageLite
    implements JvmFieldSignatureOrBuilder {
        private static final JvmFieldSignature defaultInstance;
        private final ByteString unknownFields;
        public static Parser<JvmFieldSignature> PARSER;
        private int bitField0_;
        public static final int NAME_FIELD_NUMBER = 1;
        private int name_;
        public static final int DESC_FIELD_NUMBER = 2;
        private int desc_;
        private byte memoizedIsInitialized = (byte)-1;
        private int memoizedSerializedSize = -1;
        private static final long serialVersionUID = 0L;

        private JvmFieldSignature(GeneratedMessageLite.Builder builder) {
            super(builder);
            this.unknownFields = builder.getUnknownFields();
        }

        private JvmFieldSignature(boolean noInit) {
            this.unknownFields = ByteString.EMPTY;
        }

        public static JvmFieldSignature getDefaultInstance() {
            return defaultInstance;
        }

        @Override
        public JvmFieldSignature getDefaultInstanceForType() {
            return defaultInstance;
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        private JvmFieldSignature(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            this.initFields();
            boolean mutable_bitField0_ = false;
            ByteString.Output unknownFieldsOutput = ByteString.newOutput();
            CodedOutputStream unknownFieldsCodedOutput = CodedOutputStream.newInstance(unknownFieldsOutput);
            try {
                boolean done = false;
                block20: while (!done) {
                    int tag = input.readTag();
                    switch (tag) {
                        case 0: {
                            done = true;
                            continue block20;
                        }
                        default: {
                            if (this.parseUnknownField(input, unknownFieldsCodedOutput, extensionRegistry, tag)) continue block20;
                            done = true;
                            continue block20;
                        }
                        case 8: {
                            this.bitField0_ |= 1;
                            this.name_ = input.readInt32();
                            continue block20;
                        }
                        case 16: 
                    }
                    this.bitField0_ |= 2;
                    this.desc_ = input.readInt32();
                }
            }
            catch (InvalidProtocolBufferException e) {
                throw e.setUnfinishedMessage(this);
            }
            catch (IOException e) {
                throw new InvalidProtocolBufferException(e.getMessage()).setUnfinishedMessage(this);
            }
            finally {
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

        public Parser<JvmFieldSignature> getParserForType() {
            return PARSER;
        }

        @Override
        public boolean hasName() {
            return (this.bitField0_ & 1) == 1;
        }

        @Override
        public int getName() {
            return this.name_;
        }

        @Override
        public boolean hasDesc() {
            return (this.bitField0_ & 2) == 2;
        }

        @Override
        public int getDesc() {
            return this.desc_;
        }

        private void initFields() {
            this.name_ = 0;
            this.desc_ = 0;
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
            this.memoizedIsInitialized = 1;
            return true;
        }

        @Override
        public void writeTo(CodedOutputStream output) throws IOException {
            this.getSerializedSize();
            if ((this.bitField0_ & 1) == 1) {
                output.writeInt32(1, this.name_);
            }
            if ((this.bitField0_ & 2) == 2) {
                output.writeInt32(2, this.desc_);
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
                size += CodedOutputStream.computeInt32Size(1, this.name_);
            }
            if ((this.bitField0_ & 2) == 2) {
                size += CodedOutputStream.computeInt32Size(2, this.desc_);
            }
            this.memoizedSerializedSize = size += this.unknownFields.size();
            return size;
        }

        @Override
        protected Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }

        public static JvmFieldSignature parseFrom(ByteString data2) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data2);
        }

        public static JvmFieldSignature parseFrom(ByteString data2, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data2, extensionRegistry);
        }

        public static JvmFieldSignature parseFrom(byte[] data2) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data2);
        }

        public static JvmFieldSignature parseFrom(byte[] data2, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data2, extensionRegistry);
        }

        public static JvmFieldSignature parseFrom(InputStream input) throws IOException {
            return PARSER.parseFrom(input);
        }

        public static JvmFieldSignature parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return PARSER.parseFrom(input, extensionRegistry);
        }

        public static JvmFieldSignature parseDelimitedFrom(InputStream input) throws IOException {
            return PARSER.parseDelimitedFrom(input);
        }

        public static JvmFieldSignature parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return PARSER.parseDelimitedFrom(input, extensionRegistry);
        }

        public static JvmFieldSignature parseFrom(CodedInputStream input) throws IOException {
            return PARSER.parseFrom(input);
        }

        public static JvmFieldSignature parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return PARSER.parseFrom(input, extensionRegistry);
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        @Override
        public Builder newBuilderForType() {
            return JvmFieldSignature.newBuilder();
        }

        public static Builder newBuilder(JvmFieldSignature prototype) {
            return JvmFieldSignature.newBuilder().mergeFrom(prototype);
        }

        @Override
        public Builder toBuilder() {
            return JvmFieldSignature.newBuilder(this);
        }

        static {
            PARSER = new AbstractParser<JvmFieldSignature>(){

                @Override
                public JvmFieldSignature parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                    return new JvmFieldSignature(input, extensionRegistry);
                }
            };
            defaultInstance = new JvmFieldSignature(true);
            defaultInstance.initFields();
        }

        public static final class Builder
        extends GeneratedMessageLite.Builder<JvmFieldSignature, Builder>
        implements JvmFieldSignatureOrBuilder {
            private int bitField0_;
            private int name_;
            private int desc_;

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
                this.name_ = 0;
                this.bitField0_ &= 0xFFFFFFFE;
                this.desc_ = 0;
                this.bitField0_ &= 0xFFFFFFFD;
                return this;
            }

            @Override
            public Builder clone() {
                return Builder.create().mergeFrom(this.buildPartial());
            }

            @Override
            public JvmFieldSignature getDefaultInstanceForType() {
                return JvmFieldSignature.getDefaultInstance();
            }

            @Override
            public JvmFieldSignature build() {
                JvmFieldSignature result2 = this.buildPartial();
                if (!result2.isInitialized()) {
                    throw Builder.newUninitializedMessageException(result2);
                }
                return result2;
            }

            @Override
            public JvmFieldSignature buildPartial() {
                JvmFieldSignature result2 = new JvmFieldSignature(this);
                int from_bitField0_ = this.bitField0_;
                int to_bitField0_ = 0;
                if ((from_bitField0_ & 1) == 1) {
                    to_bitField0_ |= 1;
                }
                result2.name_ = this.name_;
                if ((from_bitField0_ & 2) == 2) {
                    to_bitField0_ |= 2;
                }
                result2.desc_ = this.desc_;
                result2.bitField0_ = to_bitField0_;
                return result2;
            }

            @Override
            public Builder mergeFrom(JvmFieldSignature other) {
                if (other == JvmFieldSignature.getDefaultInstance()) {
                    return this;
                }
                if (other.hasName()) {
                    this.setName(other.getName());
                }
                if (other.hasDesc()) {
                    this.setDesc(other.getDesc());
                }
                this.setUnknownFields(this.getUnknownFields().concat(other.unknownFields));
                return this;
            }

            @Override
            public final boolean isInitialized() {
                return true;
            }

            @Override
            public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                JvmFieldSignature parsedMessage = null;
                try {
                    parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
                }
                catch (InvalidProtocolBufferException e) {
                    parsedMessage = (JvmFieldSignature)e.getUnfinishedMessage();
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
            public boolean hasName() {
                return (this.bitField0_ & 1) == 1;
            }

            @Override
            public int getName() {
                return this.name_;
            }

            public Builder setName(int value) {
                this.bitField0_ |= 1;
                this.name_ = value;
                return this;
            }

            public Builder clearName() {
                this.bitField0_ &= 0xFFFFFFFE;
                this.name_ = 0;
                return this;
            }

            @Override
            public boolean hasDesc() {
                return (this.bitField0_ & 2) == 2;
            }

            @Override
            public int getDesc() {
                return this.desc_;
            }

            public Builder setDesc(int value) {
                this.bitField0_ |= 2;
                this.desc_ = value;
                return this;
            }

            public Builder clearDesc() {
                this.bitField0_ &= 0xFFFFFFFD;
                this.desc_ = 0;
                return this;
            }
        }
    }

    public static interface JvmFieldSignatureOrBuilder
    extends MessageLiteOrBuilder {
        public boolean hasName();

        public int getName();

        public boolean hasDesc();

        public int getDesc();
    }

    public static final class JvmMethodSignature
    extends GeneratedMessageLite
    implements JvmMethodSignatureOrBuilder {
        private static final JvmMethodSignature defaultInstance;
        private final ByteString unknownFields;
        public static Parser<JvmMethodSignature> PARSER;
        private int bitField0_;
        public static final int NAME_FIELD_NUMBER = 1;
        private int name_;
        public static final int DESC_FIELD_NUMBER = 2;
        private int desc_;
        private byte memoizedIsInitialized = (byte)-1;
        private int memoizedSerializedSize = -1;
        private static final long serialVersionUID = 0L;

        private JvmMethodSignature(GeneratedMessageLite.Builder builder) {
            super(builder);
            this.unknownFields = builder.getUnknownFields();
        }

        private JvmMethodSignature(boolean noInit) {
            this.unknownFields = ByteString.EMPTY;
        }

        public static JvmMethodSignature getDefaultInstance() {
            return defaultInstance;
        }

        @Override
        public JvmMethodSignature getDefaultInstanceForType() {
            return defaultInstance;
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        private JvmMethodSignature(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            this.initFields();
            boolean mutable_bitField0_ = false;
            ByteString.Output unknownFieldsOutput = ByteString.newOutput();
            CodedOutputStream unknownFieldsCodedOutput = CodedOutputStream.newInstance(unknownFieldsOutput);
            try {
                boolean done = false;
                block20: while (!done) {
                    int tag = input.readTag();
                    switch (tag) {
                        case 0: {
                            done = true;
                            continue block20;
                        }
                        default: {
                            if (this.parseUnknownField(input, unknownFieldsCodedOutput, extensionRegistry, tag)) continue block20;
                            done = true;
                            continue block20;
                        }
                        case 8: {
                            this.bitField0_ |= 1;
                            this.name_ = input.readInt32();
                            continue block20;
                        }
                        case 16: 
                    }
                    this.bitField0_ |= 2;
                    this.desc_ = input.readInt32();
                }
            }
            catch (InvalidProtocolBufferException e) {
                throw e.setUnfinishedMessage(this);
            }
            catch (IOException e) {
                throw new InvalidProtocolBufferException(e.getMessage()).setUnfinishedMessage(this);
            }
            finally {
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

        public Parser<JvmMethodSignature> getParserForType() {
            return PARSER;
        }

        @Override
        public boolean hasName() {
            return (this.bitField0_ & 1) == 1;
        }

        @Override
        public int getName() {
            return this.name_;
        }

        @Override
        public boolean hasDesc() {
            return (this.bitField0_ & 2) == 2;
        }

        @Override
        public int getDesc() {
            return this.desc_;
        }

        private void initFields() {
            this.name_ = 0;
            this.desc_ = 0;
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
            this.memoizedIsInitialized = 1;
            return true;
        }

        @Override
        public void writeTo(CodedOutputStream output) throws IOException {
            this.getSerializedSize();
            if ((this.bitField0_ & 1) == 1) {
                output.writeInt32(1, this.name_);
            }
            if ((this.bitField0_ & 2) == 2) {
                output.writeInt32(2, this.desc_);
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
                size += CodedOutputStream.computeInt32Size(1, this.name_);
            }
            if ((this.bitField0_ & 2) == 2) {
                size += CodedOutputStream.computeInt32Size(2, this.desc_);
            }
            this.memoizedSerializedSize = size += this.unknownFields.size();
            return size;
        }

        @Override
        protected Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }

        public static JvmMethodSignature parseFrom(ByteString data2) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data2);
        }

        public static JvmMethodSignature parseFrom(ByteString data2, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data2, extensionRegistry);
        }

        public static JvmMethodSignature parseFrom(byte[] data2) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data2);
        }

        public static JvmMethodSignature parseFrom(byte[] data2, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data2, extensionRegistry);
        }

        public static JvmMethodSignature parseFrom(InputStream input) throws IOException {
            return PARSER.parseFrom(input);
        }

        public static JvmMethodSignature parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return PARSER.parseFrom(input, extensionRegistry);
        }

        public static JvmMethodSignature parseDelimitedFrom(InputStream input) throws IOException {
            return PARSER.parseDelimitedFrom(input);
        }

        public static JvmMethodSignature parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return PARSER.parseDelimitedFrom(input, extensionRegistry);
        }

        public static JvmMethodSignature parseFrom(CodedInputStream input) throws IOException {
            return PARSER.parseFrom(input);
        }

        public static JvmMethodSignature parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return PARSER.parseFrom(input, extensionRegistry);
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        @Override
        public Builder newBuilderForType() {
            return JvmMethodSignature.newBuilder();
        }

        public static Builder newBuilder(JvmMethodSignature prototype) {
            return JvmMethodSignature.newBuilder().mergeFrom(prototype);
        }

        @Override
        public Builder toBuilder() {
            return JvmMethodSignature.newBuilder(this);
        }

        static {
            PARSER = new AbstractParser<JvmMethodSignature>(){

                @Override
                public JvmMethodSignature parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                    return new JvmMethodSignature(input, extensionRegistry);
                }
            };
            defaultInstance = new JvmMethodSignature(true);
            defaultInstance.initFields();
        }

        public static final class Builder
        extends GeneratedMessageLite.Builder<JvmMethodSignature, Builder>
        implements JvmMethodSignatureOrBuilder {
            private int bitField0_;
            private int name_;
            private int desc_;

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
                this.name_ = 0;
                this.bitField0_ &= 0xFFFFFFFE;
                this.desc_ = 0;
                this.bitField0_ &= 0xFFFFFFFD;
                return this;
            }

            @Override
            public Builder clone() {
                return Builder.create().mergeFrom(this.buildPartial());
            }

            @Override
            public JvmMethodSignature getDefaultInstanceForType() {
                return JvmMethodSignature.getDefaultInstance();
            }

            @Override
            public JvmMethodSignature build() {
                JvmMethodSignature result2 = this.buildPartial();
                if (!result2.isInitialized()) {
                    throw Builder.newUninitializedMessageException(result2);
                }
                return result2;
            }

            @Override
            public JvmMethodSignature buildPartial() {
                JvmMethodSignature result2 = new JvmMethodSignature(this);
                int from_bitField0_ = this.bitField0_;
                int to_bitField0_ = 0;
                if ((from_bitField0_ & 1) == 1) {
                    to_bitField0_ |= 1;
                }
                result2.name_ = this.name_;
                if ((from_bitField0_ & 2) == 2) {
                    to_bitField0_ |= 2;
                }
                result2.desc_ = this.desc_;
                result2.bitField0_ = to_bitField0_;
                return result2;
            }

            @Override
            public Builder mergeFrom(JvmMethodSignature other) {
                if (other == JvmMethodSignature.getDefaultInstance()) {
                    return this;
                }
                if (other.hasName()) {
                    this.setName(other.getName());
                }
                if (other.hasDesc()) {
                    this.setDesc(other.getDesc());
                }
                this.setUnknownFields(this.getUnknownFields().concat(other.unknownFields));
                return this;
            }

            @Override
            public final boolean isInitialized() {
                return true;
            }

            @Override
            public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                JvmMethodSignature parsedMessage = null;
                try {
                    parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
                }
                catch (InvalidProtocolBufferException e) {
                    parsedMessage = (JvmMethodSignature)e.getUnfinishedMessage();
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
            public boolean hasName() {
                return (this.bitField0_ & 1) == 1;
            }

            @Override
            public int getName() {
                return this.name_;
            }

            public Builder setName(int value) {
                this.bitField0_ |= 1;
                this.name_ = value;
                return this;
            }

            public Builder clearName() {
                this.bitField0_ &= 0xFFFFFFFE;
                this.name_ = 0;
                return this;
            }

            @Override
            public boolean hasDesc() {
                return (this.bitField0_ & 2) == 2;
            }

            @Override
            public int getDesc() {
                return this.desc_;
            }

            public Builder setDesc(int value) {
                this.bitField0_ |= 2;
                this.desc_ = value;
                return this;
            }

            public Builder clearDesc() {
                this.bitField0_ &= 0xFFFFFFFD;
                this.desc_ = 0;
                return this;
            }
        }
    }

    public static interface JvmMethodSignatureOrBuilder
    extends MessageLiteOrBuilder {
        public boolean hasName();

        public int getName();

        public boolean hasDesc();

        public int getDesc();
    }

    public static final class StringTableTypes
    extends GeneratedMessageLite
    implements StringTableTypesOrBuilder {
        private static final StringTableTypes defaultInstance;
        private final ByteString unknownFields;
        public static Parser<StringTableTypes> PARSER;
        public static final int RECORD_FIELD_NUMBER = 1;
        private List<Record> record_;
        public static final int LOCAL_NAME_FIELD_NUMBER = 5;
        private List<Integer> localName_;
        private int localNameMemoizedSerializedSize = -1;
        private byte memoizedIsInitialized = (byte)-1;
        private int memoizedSerializedSize = -1;
        private static final long serialVersionUID = 0L;

        private StringTableTypes(GeneratedMessageLite.Builder builder) {
            super(builder);
            this.unknownFields = builder.getUnknownFields();
        }

        private StringTableTypes(boolean noInit) {
            this.unknownFields = ByteString.EMPTY;
        }

        public static StringTableTypes getDefaultInstance() {
            return defaultInstance;
        }

        @Override
        public StringTableTypes getDefaultInstanceForType() {
            return defaultInstance;
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        private StringTableTypes(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            this.initFields();
            int mutable_bitField0_ = 0;
            ByteString.Output unknownFieldsOutput = ByteString.newOutput();
            CodedOutputStream unknownFieldsCodedOutput = CodedOutputStream.newInstance(unknownFieldsOutput);
            try {
                boolean done = false;
                block21: while (!done) {
                    int tag = input.readTag();
                    switch (tag) {
                        case 0: {
                            done = true;
                            continue block21;
                        }
                        default: {
                            if (this.parseUnknownField(input, unknownFieldsCodedOutput, extensionRegistry, tag)) continue block21;
                            done = true;
                            continue block21;
                        }
                        case 10: {
                            if ((mutable_bitField0_ & 1) != 1) {
                                this.record_ = new ArrayList<Record>();
                                mutable_bitField0_ |= 1;
                            }
                            this.record_.add(input.readMessage(Record.PARSER, extensionRegistry));
                            continue block21;
                        }
                        case 40: {
                            if ((mutable_bitField0_ & 2) != 2) {
                                this.localName_ = new ArrayList<Integer>();
                                mutable_bitField0_ |= 2;
                            }
                            this.localName_.add(input.readInt32());
                            continue block21;
                        }
                        case 42: 
                    }
                    int length = input.readRawVarint32();
                    int limit = input.pushLimit(length);
                    if ((mutable_bitField0_ & 2) != 2 && input.getBytesUntilLimit() > 0) {
                        this.localName_ = new ArrayList<Integer>();
                        mutable_bitField0_ |= 2;
                    }
                    while (input.getBytesUntilLimit() > 0) {
                        this.localName_.add(input.readInt32());
                    }
                    input.popLimit(limit);
                }
            }
            catch (InvalidProtocolBufferException e) {
                throw e.setUnfinishedMessage(this);
            }
            catch (IOException e) {
                throw new InvalidProtocolBufferException(e.getMessage()).setUnfinishedMessage(this);
            }
            finally {
                if (mutable_bitField0_ & true) {
                    this.record_ = Collections.unmodifiableList(this.record_);
                }
                if ((mutable_bitField0_ & 2) == 2) {
                    this.localName_ = Collections.unmodifiableList(this.localName_);
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

        public Parser<StringTableTypes> getParserForType() {
            return PARSER;
        }

        @Override
        public List<Record> getRecordList() {
            return this.record_;
        }

        public List<? extends RecordOrBuilder> getRecordOrBuilderList() {
            return this.record_;
        }

        @Override
        public int getRecordCount() {
            return this.record_.size();
        }

        @Override
        public Record getRecord(int index) {
            return this.record_.get(index);
        }

        public RecordOrBuilder getRecordOrBuilder(int index) {
            return this.record_.get(index);
        }

        @Override
        public List<Integer> getLocalNameList() {
            return this.localName_;
        }

        @Override
        public int getLocalNameCount() {
            return this.localName_.size();
        }

        @Override
        public int getLocalName(int index) {
            return this.localName_.get(index);
        }

        private void initFields() {
            this.record_ = Collections.emptyList();
            this.localName_ = Collections.emptyList();
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
            this.memoizedIsInitialized = 1;
            return true;
        }

        @Override
        public void writeTo(CodedOutputStream output) throws IOException {
            int i;
            this.getSerializedSize();
            for (i = 0; i < this.record_.size(); ++i) {
                output.writeMessage(1, this.record_.get(i));
            }
            if (this.getLocalNameList().size() > 0) {
                output.writeRawVarint32(42);
                output.writeRawVarint32(this.localNameMemoizedSerializedSize);
            }
            for (i = 0; i < this.localName_.size(); ++i) {
                output.writeInt32NoTag(this.localName_.get(i));
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
            for (int i = 0; i < this.record_.size(); ++i) {
                size += CodedOutputStream.computeMessageSize(1, this.record_.get(i));
            }
            int dataSize = 0;
            for (int i = 0; i < this.localName_.size(); ++i) {
                dataSize += CodedOutputStream.computeInt32SizeNoTag(this.localName_.get(i));
            }
            size += dataSize;
            if (!this.getLocalNameList().isEmpty()) {
                ++size;
                size += CodedOutputStream.computeInt32SizeNoTag(dataSize);
            }
            this.localNameMemoizedSerializedSize = dataSize;
            this.memoizedSerializedSize = size += this.unknownFields.size();
            return size;
        }

        @Override
        protected Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }

        public static StringTableTypes parseFrom(ByteString data2) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data2);
        }

        public static StringTableTypes parseFrom(ByteString data2, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data2, extensionRegistry);
        }

        public static StringTableTypes parseFrom(byte[] data2) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data2);
        }

        public static StringTableTypes parseFrom(byte[] data2, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data2, extensionRegistry);
        }

        public static StringTableTypes parseFrom(InputStream input) throws IOException {
            return PARSER.parseFrom(input);
        }

        public static StringTableTypes parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return PARSER.parseFrom(input, extensionRegistry);
        }

        public static StringTableTypes parseDelimitedFrom(InputStream input) throws IOException {
            return PARSER.parseDelimitedFrom(input);
        }

        public static StringTableTypes parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return PARSER.parseDelimitedFrom(input, extensionRegistry);
        }

        public static StringTableTypes parseFrom(CodedInputStream input) throws IOException {
            return PARSER.parseFrom(input);
        }

        public static StringTableTypes parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return PARSER.parseFrom(input, extensionRegistry);
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        @Override
        public Builder newBuilderForType() {
            return StringTableTypes.newBuilder();
        }

        public static Builder newBuilder(StringTableTypes prototype) {
            return StringTableTypes.newBuilder().mergeFrom(prototype);
        }

        @Override
        public Builder toBuilder() {
            return StringTableTypes.newBuilder(this);
        }

        static {
            PARSER = new AbstractParser<StringTableTypes>(){

                @Override
                public StringTableTypes parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                    return new StringTableTypes(input, extensionRegistry);
                }
            };
            defaultInstance = new StringTableTypes(true);
            defaultInstance.initFields();
        }

        public static final class Builder
        extends GeneratedMessageLite.Builder<StringTableTypes, Builder>
        implements StringTableTypesOrBuilder {
            private int bitField0_;
            private List<Record> record_ = Collections.emptyList();
            private List<Integer> localName_ = Collections.emptyList();

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
                this.record_ = Collections.emptyList();
                this.bitField0_ &= 0xFFFFFFFE;
                this.localName_ = Collections.emptyList();
                this.bitField0_ &= 0xFFFFFFFD;
                return this;
            }

            @Override
            public Builder clone() {
                return Builder.create().mergeFrom(this.buildPartial());
            }

            @Override
            public StringTableTypes getDefaultInstanceForType() {
                return StringTableTypes.getDefaultInstance();
            }

            @Override
            public StringTableTypes build() {
                StringTableTypes result2 = this.buildPartial();
                if (!result2.isInitialized()) {
                    throw Builder.newUninitializedMessageException(result2);
                }
                return result2;
            }

            @Override
            public StringTableTypes buildPartial() {
                StringTableTypes result2 = new StringTableTypes(this);
                int from_bitField0_ = this.bitField0_;
                if ((this.bitField0_ & 1) == 1) {
                    this.record_ = Collections.unmodifiableList(this.record_);
                    this.bitField0_ &= 0xFFFFFFFE;
                }
                result2.record_ = this.record_;
                if ((this.bitField0_ & 2) == 2) {
                    this.localName_ = Collections.unmodifiableList(this.localName_);
                    this.bitField0_ &= 0xFFFFFFFD;
                }
                result2.localName_ = this.localName_;
                return result2;
            }

            @Override
            public Builder mergeFrom(StringTableTypes other) {
                if (other == StringTableTypes.getDefaultInstance()) {
                    return this;
                }
                if (!other.record_.isEmpty()) {
                    if (this.record_.isEmpty()) {
                        this.record_ = other.record_;
                        this.bitField0_ &= 0xFFFFFFFE;
                    } else {
                        this.ensureRecordIsMutable();
                        this.record_.addAll(other.record_);
                    }
                }
                if (!other.localName_.isEmpty()) {
                    if (this.localName_.isEmpty()) {
                        this.localName_ = other.localName_;
                        this.bitField0_ &= 0xFFFFFFFD;
                    } else {
                        this.ensureLocalNameIsMutable();
                        this.localName_.addAll(other.localName_);
                    }
                }
                this.setUnknownFields(this.getUnknownFields().concat(other.unknownFields));
                return this;
            }

            @Override
            public final boolean isInitialized() {
                return true;
            }

            @Override
            public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                StringTableTypes parsedMessage = null;
                try {
                    parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
                }
                catch (InvalidProtocolBufferException e) {
                    parsedMessage = (StringTableTypes)e.getUnfinishedMessage();
                    throw e;
                }
                finally {
                    if (parsedMessage != null) {
                        this.mergeFrom(parsedMessage);
                    }
                }
                return this;
            }

            private void ensureRecordIsMutable() {
                if ((this.bitField0_ & 1) != 1) {
                    this.record_ = new ArrayList<Record>(this.record_);
                    this.bitField0_ |= 1;
                }
            }

            @Override
            public List<Record> getRecordList() {
                return Collections.unmodifiableList(this.record_);
            }

            @Override
            public int getRecordCount() {
                return this.record_.size();
            }

            @Override
            public Record getRecord(int index) {
                return this.record_.get(index);
            }

            public Builder setRecord(int index, Record value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.ensureRecordIsMutable();
                this.record_.set(index, value);
                return this;
            }

            public Builder setRecord(int index, Record.Builder builderForValue) {
                this.ensureRecordIsMutable();
                this.record_.set(index, builderForValue.build());
                return this;
            }

            public Builder addRecord(Record value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.ensureRecordIsMutable();
                this.record_.add(value);
                return this;
            }

            public Builder addRecord(int index, Record value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.ensureRecordIsMutable();
                this.record_.add(index, value);
                return this;
            }

            public Builder addRecord(Record.Builder builderForValue) {
                this.ensureRecordIsMutable();
                this.record_.add(builderForValue.build());
                return this;
            }

            public Builder addRecord(int index, Record.Builder builderForValue) {
                this.ensureRecordIsMutable();
                this.record_.add(index, builderForValue.build());
                return this;
            }

            public Builder addAllRecord(Iterable<? extends Record> values2) {
                this.ensureRecordIsMutable();
                AbstractMessageLite.Builder.addAll(values2, this.record_);
                return this;
            }

            public Builder clearRecord() {
                this.record_ = Collections.emptyList();
                this.bitField0_ &= 0xFFFFFFFE;
                return this;
            }

            public Builder removeRecord(int index) {
                this.ensureRecordIsMutable();
                this.record_.remove(index);
                return this;
            }

            private void ensureLocalNameIsMutable() {
                if ((this.bitField0_ & 2) != 2) {
                    this.localName_ = new ArrayList<Integer>(this.localName_);
                    this.bitField0_ |= 2;
                }
            }

            @Override
            public List<Integer> getLocalNameList() {
                return Collections.unmodifiableList(this.localName_);
            }

            @Override
            public int getLocalNameCount() {
                return this.localName_.size();
            }

            @Override
            public int getLocalName(int index) {
                return this.localName_.get(index);
            }

            public Builder setLocalName(int index, int value) {
                this.ensureLocalNameIsMutable();
                this.localName_.set(index, value);
                return this;
            }

            public Builder addLocalName(int value) {
                this.ensureLocalNameIsMutable();
                this.localName_.add(value);
                return this;
            }

            public Builder addAllLocalName(Iterable<? extends Integer> values2) {
                this.ensureLocalNameIsMutable();
                AbstractMessageLite.Builder.addAll(values2, this.localName_);
                return this;
            }

            public Builder clearLocalName() {
                this.localName_ = Collections.emptyList();
                this.bitField0_ &= 0xFFFFFFFD;
                return this;
            }
        }

        public static final class Record
        extends GeneratedMessageLite
        implements RecordOrBuilder {
            private static final Record defaultInstance;
            private final ByteString unknownFields;
            public static Parser<Record> PARSER;
            private int bitField0_;
            public static final int RANGE_FIELD_NUMBER = 1;
            private int range_;
            public static final int PREDEFINED_INDEX_FIELD_NUMBER = 2;
            private int predefinedIndex_;
            public static final int STRING_FIELD_NUMBER = 6;
            private Object string_;
            public static final int OPERATION_FIELD_NUMBER = 3;
            private Operation operation_;
            public static final int SUBSTRING_INDEX_FIELD_NUMBER = 4;
            private List<Integer> substringIndex_;
            private int substringIndexMemoizedSerializedSize = -1;
            public static final int REPLACE_CHAR_FIELD_NUMBER = 5;
            private List<Integer> replaceChar_;
            private int replaceCharMemoizedSerializedSize = -1;
            private byte memoizedIsInitialized = (byte)-1;
            private int memoizedSerializedSize = -1;
            private static final long serialVersionUID = 0L;

            private Record(GeneratedMessageLite.Builder builder) {
                super(builder);
                this.unknownFields = builder.getUnknownFields();
            }

            private Record(boolean noInit) {
                this.unknownFields = ByteString.EMPTY;
            }

            public static Record getDefaultInstance() {
                return defaultInstance;
            }

            @Override
            public Record getDefaultInstanceForType() {
                return defaultInstance;
            }

            /*
             * WARNING - Removed try catching itself - possible behaviour change.
             */
            private Record(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                this.initFields();
                int mutable_bitField0_ = 0;
                ByteString.Output unknownFieldsOutput = ByteString.newOutput();
                CodedOutputStream unknownFieldsCodedOutput = CodedOutputStream.newInstance(unknownFieldsOutput);
                try {
                    boolean done = false;
                    block26: while (!done) {
                        int tag = input.readTag();
                        switch (tag) {
                            case 0: {
                                done = true;
                                continue block26;
                            }
                            default: {
                                if (this.parseUnknownField(input, unknownFieldsCodedOutput, extensionRegistry, tag)) continue block26;
                                done = true;
                                continue block26;
                            }
                            case 8: {
                                this.bitField0_ |= 1;
                                this.range_ = input.readInt32();
                                continue block26;
                            }
                            case 16: {
                                this.bitField0_ |= 2;
                                this.predefinedIndex_ = input.readInt32();
                                continue block26;
                            }
                            case 24: {
                                int rawValue = input.readEnum();
                                Operation value = Operation.valueOf(rawValue);
                                if (value == null) {
                                    unknownFieldsCodedOutput.writeRawVarint32(tag);
                                    unknownFieldsCodedOutput.writeRawVarint32(rawValue);
                                    continue block26;
                                }
                                this.bitField0_ |= 8;
                                this.operation_ = value;
                                continue block26;
                            }
                            case 32: {
                                if ((mutable_bitField0_ & 0x10) != 16) {
                                    this.substringIndex_ = new ArrayList<Integer>();
                                    mutable_bitField0_ |= 0x10;
                                }
                                this.substringIndex_.add(input.readInt32());
                                continue block26;
                            }
                            case 34: {
                                int length = input.readRawVarint32();
                                int limit = input.pushLimit(length);
                                if ((mutable_bitField0_ & 0x10) != 16 && input.getBytesUntilLimit() > 0) {
                                    this.substringIndex_ = new ArrayList<Integer>();
                                    mutable_bitField0_ |= 0x10;
                                }
                                while (input.getBytesUntilLimit() > 0) {
                                    this.substringIndex_.add(input.readInt32());
                                }
                                input.popLimit(limit);
                                continue block26;
                            }
                            case 40: {
                                if ((mutable_bitField0_ & 0x20) != 32) {
                                    this.replaceChar_ = new ArrayList<Integer>();
                                    mutable_bitField0_ |= 0x20;
                                }
                                this.replaceChar_.add(input.readInt32());
                                continue block26;
                            }
                            case 42: {
                                int length = input.readRawVarint32();
                                int limit = input.pushLimit(length);
                                if ((mutable_bitField0_ & 0x20) != 32 && input.getBytesUntilLimit() > 0) {
                                    this.replaceChar_ = new ArrayList<Integer>();
                                    mutable_bitField0_ |= 0x20;
                                }
                                while (input.getBytesUntilLimit() > 0) {
                                    this.replaceChar_.add(input.readInt32());
                                }
                                input.popLimit(limit);
                                continue block26;
                            }
                            case 50: 
                        }
                        ByteString bs = input.readBytes();
                        this.bitField0_ |= 4;
                        this.string_ = bs;
                    }
                }
                catch (InvalidProtocolBufferException e) {
                    throw e.setUnfinishedMessage(this);
                }
                catch (IOException e) {
                    throw new InvalidProtocolBufferException(e.getMessage()).setUnfinishedMessage(this);
                }
                finally {
                    if ((mutable_bitField0_ & 0x10) == 16) {
                        this.substringIndex_ = Collections.unmodifiableList(this.substringIndex_);
                    }
                    if ((mutable_bitField0_ & 0x20) == 32) {
                        this.replaceChar_ = Collections.unmodifiableList(this.replaceChar_);
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

            public Parser<Record> getParserForType() {
                return PARSER;
            }

            @Override
            public boolean hasRange() {
                return (this.bitField0_ & 1) == 1;
            }

            @Override
            public int getRange() {
                return this.range_;
            }

            @Override
            public boolean hasPredefinedIndex() {
                return (this.bitField0_ & 2) == 2;
            }

            @Override
            public int getPredefinedIndex() {
                return this.predefinedIndex_;
            }

            @Override
            public boolean hasString() {
                return (this.bitField0_ & 4) == 4;
            }

            @Override
            public String getString() {
                Object ref = this.string_;
                if (ref instanceof String) {
                    return (String)ref;
                }
                ByteString bs = (ByteString)ref;
                String s = bs.toStringUtf8();
                if (bs.isValidUtf8()) {
                    this.string_ = s;
                }
                return s;
            }

            @Override
            public ByteString getStringBytes() {
                Object ref = this.string_;
                if (ref instanceof String) {
                    ByteString b = ByteString.copyFromUtf8((String)ref);
                    this.string_ = b;
                    return b;
                }
                return (ByteString)ref;
            }

            @Override
            public boolean hasOperation() {
                return (this.bitField0_ & 8) == 8;
            }

            @Override
            public Operation getOperation() {
                return this.operation_;
            }

            @Override
            public List<Integer> getSubstringIndexList() {
                return this.substringIndex_;
            }

            @Override
            public int getSubstringIndexCount() {
                return this.substringIndex_.size();
            }

            @Override
            public int getSubstringIndex(int index) {
                return this.substringIndex_.get(index);
            }

            @Override
            public List<Integer> getReplaceCharList() {
                return this.replaceChar_;
            }

            @Override
            public int getReplaceCharCount() {
                return this.replaceChar_.size();
            }

            @Override
            public int getReplaceChar(int index) {
                return this.replaceChar_.get(index);
            }

            private void initFields() {
                this.range_ = 1;
                this.predefinedIndex_ = 0;
                this.string_ = "";
                this.operation_ = Operation.NONE;
                this.substringIndex_ = Collections.emptyList();
                this.replaceChar_ = Collections.emptyList();
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
                this.memoizedIsInitialized = 1;
                return true;
            }

            @Override
            public void writeTo(CodedOutputStream output) throws IOException {
                int i;
                this.getSerializedSize();
                if ((this.bitField0_ & 1) == 1) {
                    output.writeInt32(1, this.range_);
                }
                if ((this.bitField0_ & 2) == 2) {
                    output.writeInt32(2, this.predefinedIndex_);
                }
                if ((this.bitField0_ & 8) == 8) {
                    output.writeEnum(3, this.operation_.getNumber());
                }
                if (this.getSubstringIndexList().size() > 0) {
                    output.writeRawVarint32(34);
                    output.writeRawVarint32(this.substringIndexMemoizedSerializedSize);
                }
                for (i = 0; i < this.substringIndex_.size(); ++i) {
                    output.writeInt32NoTag(this.substringIndex_.get(i));
                }
                if (this.getReplaceCharList().size() > 0) {
                    output.writeRawVarint32(42);
                    output.writeRawVarint32(this.replaceCharMemoizedSerializedSize);
                }
                for (i = 0; i < this.replaceChar_.size(); ++i) {
                    output.writeInt32NoTag(this.replaceChar_.get(i));
                }
                if ((this.bitField0_ & 4) == 4) {
                    output.writeBytes(6, this.getStringBytes());
                }
                output.writeRawBytes(this.unknownFields);
            }

            @Override
            public int getSerializedSize() {
                int i;
                int size = this.memoizedSerializedSize;
                if (size != -1) {
                    return size;
                }
                size = 0;
                if ((this.bitField0_ & 1) == 1) {
                    size += CodedOutputStream.computeInt32Size(1, this.range_);
                }
                if ((this.bitField0_ & 2) == 2) {
                    size += CodedOutputStream.computeInt32Size(2, this.predefinedIndex_);
                }
                if ((this.bitField0_ & 8) == 8) {
                    size += CodedOutputStream.computeEnumSize(3, this.operation_.getNumber());
                }
                int dataSize = 0;
                for (i = 0; i < this.substringIndex_.size(); ++i) {
                    dataSize += CodedOutputStream.computeInt32SizeNoTag(this.substringIndex_.get(i));
                }
                size += dataSize;
                if (!this.getSubstringIndexList().isEmpty()) {
                    ++size;
                    size += CodedOutputStream.computeInt32SizeNoTag(dataSize);
                }
                this.substringIndexMemoizedSerializedSize = dataSize;
                dataSize = 0;
                for (i = 0; i < this.replaceChar_.size(); ++i) {
                    dataSize += CodedOutputStream.computeInt32SizeNoTag(this.replaceChar_.get(i));
                }
                size += dataSize;
                if (!this.getReplaceCharList().isEmpty()) {
                    ++size;
                    size += CodedOutputStream.computeInt32SizeNoTag(dataSize);
                }
                this.replaceCharMemoizedSerializedSize = dataSize;
                if ((this.bitField0_ & 4) == 4) {
                    size += CodedOutputStream.computeBytesSize(6, this.getStringBytes());
                }
                this.memoizedSerializedSize = size += this.unknownFields.size();
                return size;
            }

            @Override
            protected Object writeReplace() throws ObjectStreamException {
                return super.writeReplace();
            }

            public static Record parseFrom(ByteString data2) throws InvalidProtocolBufferException {
                return PARSER.parseFrom(data2);
            }

            public static Record parseFrom(ByteString data2, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return PARSER.parseFrom(data2, extensionRegistry);
            }

            public static Record parseFrom(byte[] data2) throws InvalidProtocolBufferException {
                return PARSER.parseFrom(data2);
            }

            public static Record parseFrom(byte[] data2, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return PARSER.parseFrom(data2, extensionRegistry);
            }

            public static Record parseFrom(InputStream input) throws IOException {
                return PARSER.parseFrom(input);
            }

            public static Record parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                return PARSER.parseFrom(input, extensionRegistry);
            }

            public static Record parseDelimitedFrom(InputStream input) throws IOException {
                return PARSER.parseDelimitedFrom(input);
            }

            public static Record parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                return PARSER.parseDelimitedFrom(input, extensionRegistry);
            }

            public static Record parseFrom(CodedInputStream input) throws IOException {
                return PARSER.parseFrom(input);
            }

            public static Record parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                return PARSER.parseFrom(input, extensionRegistry);
            }

            public static Builder newBuilder() {
                return Builder.create();
            }

            @Override
            public Builder newBuilderForType() {
                return Record.newBuilder();
            }

            public static Builder newBuilder(Record prototype) {
                return Record.newBuilder().mergeFrom(prototype);
            }

            @Override
            public Builder toBuilder() {
                return Record.newBuilder(this);
            }

            static {
                PARSER = new AbstractParser<Record>(){

                    @Override
                    public Record parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                        return new Record(input, extensionRegistry);
                    }
                };
                defaultInstance = new Record(true);
                defaultInstance.initFields();
            }

            public static final class Builder
            extends GeneratedMessageLite.Builder<Record, Builder>
            implements RecordOrBuilder {
                private int bitField0_;
                private int range_ = 1;
                private int predefinedIndex_;
                private Object string_ = "";
                private Operation operation_ = Operation.NONE;
                private List<Integer> substringIndex_ = Collections.emptyList();
                private List<Integer> replaceChar_ = Collections.emptyList();

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
                    this.range_ = 1;
                    this.bitField0_ &= 0xFFFFFFFE;
                    this.predefinedIndex_ = 0;
                    this.bitField0_ &= 0xFFFFFFFD;
                    this.string_ = "";
                    this.bitField0_ &= 0xFFFFFFFB;
                    this.operation_ = Operation.NONE;
                    this.bitField0_ &= 0xFFFFFFF7;
                    this.substringIndex_ = Collections.emptyList();
                    this.bitField0_ &= 0xFFFFFFEF;
                    this.replaceChar_ = Collections.emptyList();
                    this.bitField0_ &= 0xFFFFFFDF;
                    return this;
                }

                @Override
                public Builder clone() {
                    return Builder.create().mergeFrom(this.buildPartial());
                }

                @Override
                public Record getDefaultInstanceForType() {
                    return Record.getDefaultInstance();
                }

                @Override
                public Record build() {
                    Record result2 = this.buildPartial();
                    if (!result2.isInitialized()) {
                        throw Builder.newUninitializedMessageException(result2);
                    }
                    return result2;
                }

                @Override
                public Record buildPartial() {
                    Record result2 = new Record(this);
                    int from_bitField0_ = this.bitField0_;
                    int to_bitField0_ = 0;
                    if ((from_bitField0_ & 1) == 1) {
                        to_bitField0_ |= 1;
                    }
                    result2.range_ = this.range_;
                    if ((from_bitField0_ & 2) == 2) {
                        to_bitField0_ |= 2;
                    }
                    result2.predefinedIndex_ = this.predefinedIndex_;
                    if ((from_bitField0_ & 4) == 4) {
                        to_bitField0_ |= 4;
                    }
                    result2.string_ = this.string_;
                    if ((from_bitField0_ & 8) == 8) {
                        to_bitField0_ |= 8;
                    }
                    result2.operation_ = this.operation_;
                    if ((this.bitField0_ & 0x10) == 16) {
                        this.substringIndex_ = Collections.unmodifiableList(this.substringIndex_);
                        this.bitField0_ &= 0xFFFFFFEF;
                    }
                    result2.substringIndex_ = this.substringIndex_;
                    if ((this.bitField0_ & 0x20) == 32) {
                        this.replaceChar_ = Collections.unmodifiableList(this.replaceChar_);
                        this.bitField0_ &= 0xFFFFFFDF;
                    }
                    result2.replaceChar_ = this.replaceChar_;
                    result2.bitField0_ = to_bitField0_;
                    return result2;
                }

                @Override
                public Builder mergeFrom(Record other) {
                    if (other == Record.getDefaultInstance()) {
                        return this;
                    }
                    if (other.hasRange()) {
                        this.setRange(other.getRange());
                    }
                    if (other.hasPredefinedIndex()) {
                        this.setPredefinedIndex(other.getPredefinedIndex());
                    }
                    if (other.hasString()) {
                        this.bitField0_ |= 4;
                        this.string_ = other.string_;
                    }
                    if (other.hasOperation()) {
                        this.setOperation(other.getOperation());
                    }
                    if (!other.substringIndex_.isEmpty()) {
                        if (this.substringIndex_.isEmpty()) {
                            this.substringIndex_ = other.substringIndex_;
                            this.bitField0_ &= 0xFFFFFFEF;
                        } else {
                            this.ensureSubstringIndexIsMutable();
                            this.substringIndex_.addAll(other.substringIndex_);
                        }
                    }
                    if (!other.replaceChar_.isEmpty()) {
                        if (this.replaceChar_.isEmpty()) {
                            this.replaceChar_ = other.replaceChar_;
                            this.bitField0_ &= 0xFFFFFFDF;
                        } else {
                            this.ensureReplaceCharIsMutable();
                            this.replaceChar_.addAll(other.replaceChar_);
                        }
                    }
                    this.setUnknownFields(this.getUnknownFields().concat(other.unknownFields));
                    return this;
                }

                @Override
                public final boolean isInitialized() {
                    return true;
                }

                @Override
                public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                    Record parsedMessage = null;
                    try {
                        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
                    }
                    catch (InvalidProtocolBufferException e) {
                        parsedMessage = (Record)e.getUnfinishedMessage();
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
                public boolean hasRange() {
                    return (this.bitField0_ & 1) == 1;
                }

                @Override
                public int getRange() {
                    return this.range_;
                }

                public Builder setRange(int value) {
                    this.bitField0_ |= 1;
                    this.range_ = value;
                    return this;
                }

                public Builder clearRange() {
                    this.bitField0_ &= 0xFFFFFFFE;
                    this.range_ = 1;
                    return this;
                }

                @Override
                public boolean hasPredefinedIndex() {
                    return (this.bitField0_ & 2) == 2;
                }

                @Override
                public int getPredefinedIndex() {
                    return this.predefinedIndex_;
                }

                public Builder setPredefinedIndex(int value) {
                    this.bitField0_ |= 2;
                    this.predefinedIndex_ = value;
                    return this;
                }

                public Builder clearPredefinedIndex() {
                    this.bitField0_ &= 0xFFFFFFFD;
                    this.predefinedIndex_ = 0;
                    return this;
                }

                @Override
                public boolean hasString() {
                    return (this.bitField0_ & 4) == 4;
                }

                @Override
                public String getString() {
                    Object ref = this.string_;
                    if (!(ref instanceof String)) {
                        ByteString bs = (ByteString)ref;
                        String s = bs.toStringUtf8();
                        if (bs.isValidUtf8()) {
                            this.string_ = s;
                        }
                        return s;
                    }
                    return (String)ref;
                }

                @Override
                public ByteString getStringBytes() {
                    Object ref = this.string_;
                    if (ref instanceof String) {
                        ByteString b = ByteString.copyFromUtf8((String)ref);
                        this.string_ = b;
                        return b;
                    }
                    return (ByteString)ref;
                }

                public Builder setString(String value) {
                    if (value == null) {
                        throw new NullPointerException();
                    }
                    this.bitField0_ |= 4;
                    this.string_ = value;
                    return this;
                }

                public Builder clearString() {
                    this.bitField0_ &= 0xFFFFFFFB;
                    this.string_ = Record.getDefaultInstance().getString();
                    return this;
                }

                public Builder setStringBytes(ByteString value) {
                    if (value == null) {
                        throw new NullPointerException();
                    }
                    this.bitField0_ |= 4;
                    this.string_ = value;
                    return this;
                }

                @Override
                public boolean hasOperation() {
                    return (this.bitField0_ & 8) == 8;
                }

                @Override
                public Operation getOperation() {
                    return this.operation_;
                }

                public Builder setOperation(Operation value) {
                    if (value == null) {
                        throw new NullPointerException();
                    }
                    this.bitField0_ |= 8;
                    this.operation_ = value;
                    return this;
                }

                public Builder clearOperation() {
                    this.bitField0_ &= 0xFFFFFFF7;
                    this.operation_ = Operation.NONE;
                    return this;
                }

                private void ensureSubstringIndexIsMutable() {
                    if ((this.bitField0_ & 0x10) != 16) {
                        this.substringIndex_ = new ArrayList<Integer>(this.substringIndex_);
                        this.bitField0_ |= 0x10;
                    }
                }

                @Override
                public List<Integer> getSubstringIndexList() {
                    return Collections.unmodifiableList(this.substringIndex_);
                }

                @Override
                public int getSubstringIndexCount() {
                    return this.substringIndex_.size();
                }

                @Override
                public int getSubstringIndex(int index) {
                    return this.substringIndex_.get(index);
                }

                public Builder setSubstringIndex(int index, int value) {
                    this.ensureSubstringIndexIsMutable();
                    this.substringIndex_.set(index, value);
                    return this;
                }

                public Builder addSubstringIndex(int value) {
                    this.ensureSubstringIndexIsMutable();
                    this.substringIndex_.add(value);
                    return this;
                }

                public Builder addAllSubstringIndex(Iterable<? extends Integer> values2) {
                    this.ensureSubstringIndexIsMutable();
                    AbstractMessageLite.Builder.addAll(values2, this.substringIndex_);
                    return this;
                }

                public Builder clearSubstringIndex() {
                    this.substringIndex_ = Collections.emptyList();
                    this.bitField0_ &= 0xFFFFFFEF;
                    return this;
                }

                private void ensureReplaceCharIsMutable() {
                    if ((this.bitField0_ & 0x20) != 32) {
                        this.replaceChar_ = new ArrayList<Integer>(this.replaceChar_);
                        this.bitField0_ |= 0x20;
                    }
                }

                @Override
                public List<Integer> getReplaceCharList() {
                    return Collections.unmodifiableList(this.replaceChar_);
                }

                @Override
                public int getReplaceCharCount() {
                    return this.replaceChar_.size();
                }

                @Override
                public int getReplaceChar(int index) {
                    return this.replaceChar_.get(index);
                }

                public Builder setReplaceChar(int index, int value) {
                    this.ensureReplaceCharIsMutable();
                    this.replaceChar_.set(index, value);
                    return this;
                }

                public Builder addReplaceChar(int value) {
                    this.ensureReplaceCharIsMutable();
                    this.replaceChar_.add(value);
                    return this;
                }

                public Builder addAllReplaceChar(Iterable<? extends Integer> values2) {
                    this.ensureReplaceCharIsMutable();
                    AbstractMessageLite.Builder.addAll(values2, this.replaceChar_);
                    return this;
                }

                public Builder clearReplaceChar() {
                    this.replaceChar_ = Collections.emptyList();
                    this.bitField0_ &= 0xFFFFFFDF;
                    return this;
                }
            }

            public static enum Operation implements Internal.EnumLite
            {
                NONE(0, 0),
                INTERNAL_TO_CLASS_ID(1, 1),
                DESC_TO_CLASS_ID(2, 2);

                public static final int NONE_VALUE = 0;
                public static final int INTERNAL_TO_CLASS_ID_VALUE = 1;
                public static final int DESC_TO_CLASS_ID_VALUE = 2;
                private static Internal.EnumLiteMap<Operation> internalValueMap;
                private final int value;

                @Override
                public final int getNumber() {
                    return this.value;
                }

                public static Operation valueOf(int value) {
                    switch (value) {
                        case 0: {
                            return NONE;
                        }
                        case 1: {
                            return INTERNAL_TO_CLASS_ID;
                        }
                        case 2: {
                            return DESC_TO_CLASS_ID;
                        }
                    }
                    return null;
                }

                public static Internal.EnumLiteMap<Operation> internalGetValueMap() {
                    return internalValueMap;
                }

                private Operation(int index, int value) {
                    this.value = value;
                }

                static {
                    internalValueMap = new Internal.EnumLiteMap<Operation>(){

                        @Override
                        public Operation findValueByNumber(int number) {
                            return Operation.valueOf(number);
                        }
                    };
                }
            }
        }

        public static interface RecordOrBuilder
        extends MessageLiteOrBuilder {
            public boolean hasRange();

            public int getRange();

            public boolean hasPredefinedIndex();

            public int getPredefinedIndex();

            public boolean hasString();

            public String getString();

            public ByteString getStringBytes();

            public boolean hasOperation();

            public Record.Operation getOperation();

            public List<Integer> getSubstringIndexList();

            public int getSubstringIndexCount();

            public int getSubstringIndex(int var1);

            public List<Integer> getReplaceCharList();

            public int getReplaceCharCount();

            public int getReplaceChar(int var1);
        }
    }

    public static interface StringTableTypesOrBuilder
    extends MessageLiteOrBuilder {
        public List<StringTableTypes.Record> getRecordList();

        public StringTableTypes.Record getRecord(int var1);

        public int getRecordCount();

        public List<Integer> getLocalNameList();

        public int getLocalNameCount();

        public int getLocalName(int var1);
    }
}

