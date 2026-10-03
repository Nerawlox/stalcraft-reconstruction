/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.serialization;

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
import kotlin.reflect.jvm.internal.impl.protobuf.LazyStringArrayList;
import kotlin.reflect.jvm.internal.impl.protobuf.LazyStringList;
import kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder;
import kotlin.reflect.jvm.internal.impl.protobuf.Parser;
import kotlin.reflect.jvm.internal.impl.protobuf.ProtocolStringList;

public final class ProtoBuf {
    private ProtoBuf() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static final class SinceKotlinInfoTable
    extends GeneratedMessageLite
    implements SinceKotlinInfoTableOrBuilder {
        private static final SinceKotlinInfoTable defaultInstance;
        private final ByteString unknownFields;
        public static Parser<SinceKotlinInfoTable> PARSER;
        public static final int INFO_FIELD_NUMBER = 1;
        private List<SinceKotlinInfo> info_;
        private byte memoizedIsInitialized = (byte)-1;
        private int memoizedSerializedSize = -1;
        private static final long serialVersionUID = 0L;

        private SinceKotlinInfoTable(GeneratedMessageLite.Builder builder) {
            super(builder);
            this.unknownFields = builder.getUnknownFields();
        }

        private SinceKotlinInfoTable(boolean noInit) {
            this.unknownFields = ByteString.EMPTY;
        }

        public static SinceKotlinInfoTable getDefaultInstance() {
            return defaultInstance;
        }

        @Override
        public SinceKotlinInfoTable getDefaultInstanceForType() {
            return defaultInstance;
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        private SinceKotlinInfoTable(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            this.initFields();
            boolean mutable_bitField0_ = false;
            ByteString.Output unknownFieldsOutput = ByteString.newOutput();
            CodedOutputStream unknownFieldsCodedOutput = CodedOutputStream.newInstance(unknownFieldsOutput);
            try {
                boolean done = false;
                block19: while (!done) {
                    int tag = input.readTag();
                    switch (tag) {
                        case 0: {
                            done = true;
                            continue block19;
                        }
                        default: {
                            if (this.parseUnknownField(input, unknownFieldsCodedOutput, extensionRegistry, tag)) continue block19;
                            done = true;
                            continue block19;
                        }
                        case 10: 
                    }
                    if (!(mutable_bitField0_ & true)) {
                        this.info_ = new ArrayList<SinceKotlinInfo>();
                        mutable_bitField0_ |= true;
                    }
                    this.info_.add(input.readMessage(SinceKotlinInfo.PARSER, extensionRegistry));
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
                    this.info_ = Collections.unmodifiableList(this.info_);
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

        public Parser<SinceKotlinInfoTable> getParserForType() {
            return PARSER;
        }

        @Override
        public List<SinceKotlinInfo> getInfoList() {
            return this.info_;
        }

        public List<? extends SinceKotlinInfoOrBuilder> getInfoOrBuilderList() {
            return this.info_;
        }

        @Override
        public int getInfoCount() {
            return this.info_.size();
        }

        @Override
        public SinceKotlinInfo getInfo(int index) {
            return this.info_.get(index);
        }

        public SinceKotlinInfoOrBuilder getInfoOrBuilder(int index) {
            return this.info_.get(index);
        }

        private void initFields() {
            this.info_ = Collections.emptyList();
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
            for (int i = 0; i < this.info_.size(); ++i) {
                output.writeMessage(1, this.info_.get(i));
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
            for (int i = 0; i < this.info_.size(); ++i) {
                size += CodedOutputStream.computeMessageSize(1, this.info_.get(i));
            }
            this.memoizedSerializedSize = size += this.unknownFields.size();
            return size;
        }

        @Override
        protected Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }

        public static SinceKotlinInfoTable parseFrom(ByteString data2) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data2);
        }

        public static SinceKotlinInfoTable parseFrom(ByteString data2, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data2, extensionRegistry);
        }

        public static SinceKotlinInfoTable parseFrom(byte[] data2) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data2);
        }

        public static SinceKotlinInfoTable parseFrom(byte[] data2, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data2, extensionRegistry);
        }

        public static SinceKotlinInfoTable parseFrom(InputStream input) throws IOException {
            return PARSER.parseFrom(input);
        }

        public static SinceKotlinInfoTable parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return PARSER.parseFrom(input, extensionRegistry);
        }

        public static SinceKotlinInfoTable parseDelimitedFrom(InputStream input) throws IOException {
            return PARSER.parseDelimitedFrom(input);
        }

        public static SinceKotlinInfoTable parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return PARSER.parseDelimitedFrom(input, extensionRegistry);
        }

        public static SinceKotlinInfoTable parseFrom(CodedInputStream input) throws IOException {
            return PARSER.parseFrom(input);
        }

        public static SinceKotlinInfoTable parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return PARSER.parseFrom(input, extensionRegistry);
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        @Override
        public Builder newBuilderForType() {
            return SinceKotlinInfoTable.newBuilder();
        }

        public static Builder newBuilder(SinceKotlinInfoTable prototype) {
            return SinceKotlinInfoTable.newBuilder().mergeFrom(prototype);
        }

        @Override
        public Builder toBuilder() {
            return SinceKotlinInfoTable.newBuilder(this);
        }

        static {
            PARSER = new AbstractParser<SinceKotlinInfoTable>(){

                @Override
                public SinceKotlinInfoTable parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                    return new SinceKotlinInfoTable(input, extensionRegistry);
                }
            };
            defaultInstance = new SinceKotlinInfoTable(true);
            defaultInstance.initFields();
        }

        public static final class Builder
        extends GeneratedMessageLite.Builder<SinceKotlinInfoTable, Builder>
        implements SinceKotlinInfoTableOrBuilder {
            private int bitField0_;
            private List<SinceKotlinInfo> info_ = Collections.emptyList();

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
                this.info_ = Collections.emptyList();
                this.bitField0_ &= 0xFFFFFFFE;
                return this;
            }

            @Override
            public Builder clone() {
                return Builder.create().mergeFrom(this.buildPartial());
            }

            @Override
            public SinceKotlinInfoTable getDefaultInstanceForType() {
                return SinceKotlinInfoTable.getDefaultInstance();
            }

            @Override
            public SinceKotlinInfoTable build() {
                SinceKotlinInfoTable result2 = this.buildPartial();
                if (!result2.isInitialized()) {
                    throw Builder.newUninitializedMessageException(result2);
                }
                return result2;
            }

            @Override
            public SinceKotlinInfoTable buildPartial() {
                SinceKotlinInfoTable result2 = new SinceKotlinInfoTable(this);
                int from_bitField0_ = this.bitField0_;
                if ((this.bitField0_ & 1) == 1) {
                    this.info_ = Collections.unmodifiableList(this.info_);
                    this.bitField0_ &= 0xFFFFFFFE;
                }
                result2.info_ = this.info_;
                return result2;
            }

            @Override
            public Builder mergeFrom(SinceKotlinInfoTable other) {
                if (other == SinceKotlinInfoTable.getDefaultInstance()) {
                    return this;
                }
                if (!other.info_.isEmpty()) {
                    if (this.info_.isEmpty()) {
                        this.info_ = other.info_;
                        this.bitField0_ &= 0xFFFFFFFE;
                    } else {
                        this.ensureInfoIsMutable();
                        this.info_.addAll(other.info_);
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
                SinceKotlinInfoTable parsedMessage = null;
                try {
                    parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
                }
                catch (InvalidProtocolBufferException e) {
                    parsedMessage = (SinceKotlinInfoTable)e.getUnfinishedMessage();
                    throw e;
                }
                finally {
                    if (parsedMessage != null) {
                        this.mergeFrom(parsedMessage);
                    }
                }
                return this;
            }

            private void ensureInfoIsMutable() {
                if ((this.bitField0_ & 1) != 1) {
                    this.info_ = new ArrayList<SinceKotlinInfo>(this.info_);
                    this.bitField0_ |= 1;
                }
            }

            @Override
            public List<SinceKotlinInfo> getInfoList() {
                return Collections.unmodifiableList(this.info_);
            }

            @Override
            public int getInfoCount() {
                return this.info_.size();
            }

            @Override
            public SinceKotlinInfo getInfo(int index) {
                return this.info_.get(index);
            }

            public Builder setInfo(int index, SinceKotlinInfo value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.ensureInfoIsMutable();
                this.info_.set(index, value);
                return this;
            }

            public Builder setInfo(int index, SinceKotlinInfo.Builder builderForValue) {
                this.ensureInfoIsMutable();
                this.info_.set(index, builderForValue.build());
                return this;
            }

            public Builder addInfo(SinceKotlinInfo value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.ensureInfoIsMutable();
                this.info_.add(value);
                return this;
            }

            public Builder addInfo(int index, SinceKotlinInfo value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.ensureInfoIsMutable();
                this.info_.add(index, value);
                return this;
            }

            public Builder addInfo(SinceKotlinInfo.Builder builderForValue) {
                this.ensureInfoIsMutable();
                this.info_.add(builderForValue.build());
                return this;
            }

            public Builder addInfo(int index, SinceKotlinInfo.Builder builderForValue) {
                this.ensureInfoIsMutable();
                this.info_.add(index, builderForValue.build());
                return this;
            }

            public Builder addAllInfo(Iterable<? extends SinceKotlinInfo> values2) {
                this.ensureInfoIsMutable();
                AbstractMessageLite.Builder.addAll(values2, this.info_);
                return this;
            }

            public Builder clearInfo() {
                this.info_ = Collections.emptyList();
                this.bitField0_ &= 0xFFFFFFFE;
                return this;
            }

            public Builder removeInfo(int index) {
                this.ensureInfoIsMutable();
                this.info_.remove(index);
                return this;
            }
        }
    }

    public static interface SinceKotlinInfoTableOrBuilder
    extends MessageLiteOrBuilder {
        public List<SinceKotlinInfo> getInfoList();

        public SinceKotlinInfo getInfo(int var1);

        public int getInfoCount();
    }

    public static final class SinceKotlinInfo
    extends GeneratedMessageLite
    implements SinceKotlinInfoOrBuilder {
        private static final SinceKotlinInfo defaultInstance;
        private final ByteString unknownFields;
        public static Parser<SinceKotlinInfo> PARSER;
        private int bitField0_;
        public static final int VERSION_FIELD_NUMBER = 1;
        private int version_;
        public static final int VERSION_FULL_FIELD_NUMBER = 2;
        private int versionFull_;
        public static final int LEVEL_FIELD_NUMBER = 3;
        private Level level_;
        public static final int ERROR_CODE_FIELD_NUMBER = 4;
        private int errorCode_;
        public static final int MESSAGE_FIELD_NUMBER = 5;
        private int message_;
        private byte memoizedIsInitialized = (byte)-1;
        private int memoizedSerializedSize = -1;
        private static final long serialVersionUID = 0L;

        private SinceKotlinInfo(GeneratedMessageLite.Builder builder) {
            super(builder);
            this.unknownFields = builder.getUnknownFields();
        }

        private SinceKotlinInfo(boolean noInit) {
            this.unknownFields = ByteString.EMPTY;
        }

        public static SinceKotlinInfo getDefaultInstance() {
            return defaultInstance;
        }

        @Override
        public SinceKotlinInfo getDefaultInstanceForType() {
            return defaultInstance;
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        private SinceKotlinInfo(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            this.initFields();
            boolean mutable_bitField0_ = false;
            ByteString.Output unknownFieldsOutput = ByteString.newOutput();
            CodedOutputStream unknownFieldsCodedOutput = CodedOutputStream.newInstance(unknownFieldsOutput);
            try {
                boolean done = false;
                block23: while (!done) {
                    int tag = input.readTag();
                    switch (tag) {
                        case 0: {
                            done = true;
                            continue block23;
                        }
                        default: {
                            if (this.parseUnknownField(input, unknownFieldsCodedOutput, extensionRegistry, tag)) continue block23;
                            done = true;
                            continue block23;
                        }
                        case 8: {
                            this.bitField0_ |= 1;
                            this.version_ = input.readInt32();
                            continue block23;
                        }
                        case 16: {
                            this.bitField0_ |= 2;
                            this.versionFull_ = input.readInt32();
                            continue block23;
                        }
                        case 24: {
                            int rawValue = input.readEnum();
                            Level value = Level.valueOf(rawValue);
                            if (value == null) {
                                unknownFieldsCodedOutput.writeRawVarint32(tag);
                                unknownFieldsCodedOutput.writeRawVarint32(rawValue);
                                continue block23;
                            }
                            this.bitField0_ |= 4;
                            this.level_ = value;
                            continue block23;
                        }
                        case 32: {
                            this.bitField0_ |= 8;
                            this.errorCode_ = input.readInt32();
                            continue block23;
                        }
                        case 40: 
                    }
                    this.bitField0_ |= 0x10;
                    this.message_ = input.readInt32();
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

        public Parser<SinceKotlinInfo> getParserForType() {
            return PARSER;
        }

        @Override
        public boolean hasVersion() {
            return (this.bitField0_ & 1) == 1;
        }

        @Override
        public int getVersion() {
            return this.version_;
        }

        @Override
        public boolean hasVersionFull() {
            return (this.bitField0_ & 2) == 2;
        }

        @Override
        public int getVersionFull() {
            return this.versionFull_;
        }

        @Override
        public boolean hasLevel() {
            return (this.bitField0_ & 4) == 4;
        }

        @Override
        public Level getLevel() {
            return this.level_;
        }

        @Override
        public boolean hasErrorCode() {
            return (this.bitField0_ & 8) == 8;
        }

        @Override
        public int getErrorCode() {
            return this.errorCode_;
        }

        @Override
        public boolean hasMessage() {
            return (this.bitField0_ & 0x10) == 16;
        }

        @Override
        public int getMessage() {
            return this.message_;
        }

        private void initFields() {
            this.version_ = 0;
            this.versionFull_ = 0;
            this.level_ = Level.ERROR;
            this.errorCode_ = 0;
            this.message_ = 0;
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
                output.writeInt32(1, this.version_);
            }
            if ((this.bitField0_ & 2) == 2) {
                output.writeInt32(2, this.versionFull_);
            }
            if ((this.bitField0_ & 4) == 4) {
                output.writeEnum(3, this.level_.getNumber());
            }
            if ((this.bitField0_ & 8) == 8) {
                output.writeInt32(4, this.errorCode_);
            }
            if ((this.bitField0_ & 0x10) == 16) {
                output.writeInt32(5, this.message_);
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
                size += CodedOutputStream.computeInt32Size(1, this.version_);
            }
            if ((this.bitField0_ & 2) == 2) {
                size += CodedOutputStream.computeInt32Size(2, this.versionFull_);
            }
            if ((this.bitField0_ & 4) == 4) {
                size += CodedOutputStream.computeEnumSize(3, this.level_.getNumber());
            }
            if ((this.bitField0_ & 8) == 8) {
                size += CodedOutputStream.computeInt32Size(4, this.errorCode_);
            }
            if ((this.bitField0_ & 0x10) == 16) {
                size += CodedOutputStream.computeInt32Size(5, this.message_);
            }
            this.memoizedSerializedSize = size += this.unknownFields.size();
            return size;
        }

        @Override
        protected Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }

        public static SinceKotlinInfo parseFrom(ByteString data2) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data2);
        }

        public static SinceKotlinInfo parseFrom(ByteString data2, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data2, extensionRegistry);
        }

        public static SinceKotlinInfo parseFrom(byte[] data2) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data2);
        }

        public static SinceKotlinInfo parseFrom(byte[] data2, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data2, extensionRegistry);
        }

        public static SinceKotlinInfo parseFrom(InputStream input) throws IOException {
            return PARSER.parseFrom(input);
        }

        public static SinceKotlinInfo parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return PARSER.parseFrom(input, extensionRegistry);
        }

        public static SinceKotlinInfo parseDelimitedFrom(InputStream input) throws IOException {
            return PARSER.parseDelimitedFrom(input);
        }

        public static SinceKotlinInfo parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return PARSER.parseDelimitedFrom(input, extensionRegistry);
        }

        public static SinceKotlinInfo parseFrom(CodedInputStream input) throws IOException {
            return PARSER.parseFrom(input);
        }

        public static SinceKotlinInfo parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return PARSER.parseFrom(input, extensionRegistry);
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        @Override
        public Builder newBuilderForType() {
            return SinceKotlinInfo.newBuilder();
        }

        public static Builder newBuilder(SinceKotlinInfo prototype) {
            return SinceKotlinInfo.newBuilder().mergeFrom(prototype);
        }

        @Override
        public Builder toBuilder() {
            return SinceKotlinInfo.newBuilder(this);
        }

        static {
            PARSER = new AbstractParser<SinceKotlinInfo>(){

                @Override
                public SinceKotlinInfo parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                    return new SinceKotlinInfo(input, extensionRegistry);
                }
            };
            defaultInstance = new SinceKotlinInfo(true);
            defaultInstance.initFields();
        }

        public static final class Builder
        extends GeneratedMessageLite.Builder<SinceKotlinInfo, Builder>
        implements SinceKotlinInfoOrBuilder {
            private int bitField0_;
            private int version_;
            private int versionFull_;
            private Level level_ = Level.ERROR;
            private int errorCode_;
            private int message_;

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
                this.version_ = 0;
                this.bitField0_ &= 0xFFFFFFFE;
                this.versionFull_ = 0;
                this.bitField0_ &= 0xFFFFFFFD;
                this.level_ = Level.ERROR;
                this.bitField0_ &= 0xFFFFFFFB;
                this.errorCode_ = 0;
                this.bitField0_ &= 0xFFFFFFF7;
                this.message_ = 0;
                this.bitField0_ &= 0xFFFFFFEF;
                return this;
            }

            @Override
            public Builder clone() {
                return Builder.create().mergeFrom(this.buildPartial());
            }

            @Override
            public SinceKotlinInfo getDefaultInstanceForType() {
                return SinceKotlinInfo.getDefaultInstance();
            }

            @Override
            public SinceKotlinInfo build() {
                SinceKotlinInfo result2 = this.buildPartial();
                if (!result2.isInitialized()) {
                    throw Builder.newUninitializedMessageException(result2);
                }
                return result2;
            }

            @Override
            public SinceKotlinInfo buildPartial() {
                SinceKotlinInfo result2 = new SinceKotlinInfo(this);
                int from_bitField0_ = this.bitField0_;
                int to_bitField0_ = 0;
                if ((from_bitField0_ & 1) == 1) {
                    to_bitField0_ |= 1;
                }
                result2.version_ = this.version_;
                if ((from_bitField0_ & 2) == 2) {
                    to_bitField0_ |= 2;
                }
                result2.versionFull_ = this.versionFull_;
                if ((from_bitField0_ & 4) == 4) {
                    to_bitField0_ |= 4;
                }
                result2.level_ = this.level_;
                if ((from_bitField0_ & 8) == 8) {
                    to_bitField0_ |= 8;
                }
                result2.errorCode_ = this.errorCode_;
                if ((from_bitField0_ & 0x10) == 16) {
                    to_bitField0_ |= 0x10;
                }
                result2.message_ = this.message_;
                result2.bitField0_ = to_bitField0_;
                return result2;
            }

            @Override
            public Builder mergeFrom(SinceKotlinInfo other) {
                if (other == SinceKotlinInfo.getDefaultInstance()) {
                    return this;
                }
                if (other.hasVersion()) {
                    this.setVersion(other.getVersion());
                }
                if (other.hasVersionFull()) {
                    this.setVersionFull(other.getVersionFull());
                }
                if (other.hasLevel()) {
                    this.setLevel(other.getLevel());
                }
                if (other.hasErrorCode()) {
                    this.setErrorCode(other.getErrorCode());
                }
                if (other.hasMessage()) {
                    this.setMessage(other.getMessage());
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
                SinceKotlinInfo parsedMessage = null;
                try {
                    parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
                }
                catch (InvalidProtocolBufferException e) {
                    parsedMessage = (SinceKotlinInfo)e.getUnfinishedMessage();
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
            public boolean hasVersion() {
                return (this.bitField0_ & 1) == 1;
            }

            @Override
            public int getVersion() {
                return this.version_;
            }

            public Builder setVersion(int value) {
                this.bitField0_ |= 1;
                this.version_ = value;
                return this;
            }

            public Builder clearVersion() {
                this.bitField0_ &= 0xFFFFFFFE;
                this.version_ = 0;
                return this;
            }

            @Override
            public boolean hasVersionFull() {
                return (this.bitField0_ & 2) == 2;
            }

            @Override
            public int getVersionFull() {
                return this.versionFull_;
            }

            public Builder setVersionFull(int value) {
                this.bitField0_ |= 2;
                this.versionFull_ = value;
                return this;
            }

            public Builder clearVersionFull() {
                this.bitField0_ &= 0xFFFFFFFD;
                this.versionFull_ = 0;
                return this;
            }

            @Override
            public boolean hasLevel() {
                return (this.bitField0_ & 4) == 4;
            }

            @Override
            public Level getLevel() {
                return this.level_;
            }

            public Builder setLevel(Level value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.bitField0_ |= 4;
                this.level_ = value;
                return this;
            }

            public Builder clearLevel() {
                this.bitField0_ &= 0xFFFFFFFB;
                this.level_ = Level.ERROR;
                return this;
            }

            @Override
            public boolean hasErrorCode() {
                return (this.bitField0_ & 8) == 8;
            }

            @Override
            public int getErrorCode() {
                return this.errorCode_;
            }

            public Builder setErrorCode(int value) {
                this.bitField0_ |= 8;
                this.errorCode_ = value;
                return this;
            }

            public Builder clearErrorCode() {
                this.bitField0_ &= 0xFFFFFFF7;
                this.errorCode_ = 0;
                return this;
            }

            @Override
            public boolean hasMessage() {
                return (this.bitField0_ & 0x10) == 16;
            }

            @Override
            public int getMessage() {
                return this.message_;
            }

            public Builder setMessage(int value) {
                this.bitField0_ |= 0x10;
                this.message_ = value;
                return this;
            }

            public Builder clearMessage() {
                this.bitField0_ &= 0xFFFFFFEF;
                this.message_ = 0;
                return this;
            }
        }

        public static enum Level implements Internal.EnumLite
        {
            WARNING(0, 0),
            ERROR(1, 1),
            HIDDEN(2, 2);

            public static final int WARNING_VALUE = 0;
            public static final int ERROR_VALUE = 1;
            public static final int HIDDEN_VALUE = 2;
            private static Internal.EnumLiteMap<Level> internalValueMap;
            private final int value;

            @Override
            public final int getNumber() {
                return this.value;
            }

            public static Level valueOf(int value) {
                switch (value) {
                    case 0: {
                        return WARNING;
                    }
                    case 1: {
                        return ERROR;
                    }
                    case 2: {
                        return HIDDEN;
                    }
                }
                return null;
            }

            public static Internal.EnumLiteMap<Level> internalGetValueMap() {
                return internalValueMap;
            }

            private Level(int index, int value) {
                this.value = value;
            }

            static {
                internalValueMap = new Internal.EnumLiteMap<Level>(){

                    @Override
                    public Level findValueByNumber(int number) {
                        return Level.valueOf(number);
                    }
                };
            }
        }
    }

    public static interface SinceKotlinInfoOrBuilder
    extends MessageLiteOrBuilder {
        public boolean hasVersion();

        public int getVersion();

        public boolean hasVersionFull();

        public int getVersionFull();

        public boolean hasLevel();

        public SinceKotlinInfo.Level getLevel();

        public boolean hasErrorCode();

        public int getErrorCode();

        public boolean hasMessage();

        public int getMessage();
    }

    public static final class EnumEntry
    extends GeneratedMessageLite.ExtendableMessage<EnumEntry>
    implements EnumEntryOrBuilder {
        private static final EnumEntry defaultInstance;
        private final ByteString unknownFields;
        public static Parser<EnumEntry> PARSER;
        private int bitField0_;
        public static final int NAME_FIELD_NUMBER = 1;
        private int name_;
        private byte memoizedIsInitialized = (byte)-1;
        private int memoizedSerializedSize = -1;
        private static final long serialVersionUID = 0L;

        private EnumEntry(GeneratedMessageLite.ExtendableBuilder<EnumEntry, ?> builder) {
            super(builder);
            this.unknownFields = builder.getUnknownFields();
        }

        private EnumEntry(boolean noInit) {
            this.unknownFields = ByteString.EMPTY;
        }

        public static EnumEntry getDefaultInstance() {
            return defaultInstance;
        }

        @Override
        public EnumEntry getDefaultInstanceForType() {
            return defaultInstance;
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        private EnumEntry(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            this.initFields();
            boolean mutable_bitField0_ = false;
            ByteString.Output unknownFieldsOutput = ByteString.newOutput();
            CodedOutputStream unknownFieldsCodedOutput = CodedOutputStream.newInstance(unknownFieldsOutput);
            try {
                boolean done = false;
                block19: while (!done) {
                    int tag = input.readTag();
                    switch (tag) {
                        case 0: {
                            done = true;
                            continue block19;
                        }
                        default: {
                            if (this.parseUnknownField(input, unknownFieldsCodedOutput, extensionRegistry, tag)) continue block19;
                            done = true;
                            continue block19;
                        }
                        case 8: 
                    }
                    this.bitField0_ |= 1;
                    this.name_ = input.readInt32();
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

        public Parser<EnumEntry> getParserForType() {
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

        private void initFields() {
            this.name_ = 0;
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
            if (!this.extensionsAreInitialized()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            this.memoizedIsInitialized = 1;
            return true;
        }

        @Override
        public void writeTo(CodedOutputStream output) throws IOException {
            this.getSerializedSize();
            GeneratedMessageLite.ExtendableMessage.ExtensionWriter extensionWriter = this.newExtensionWriter();
            if ((this.bitField0_ & 1) == 1) {
                output.writeInt32(1, this.name_);
            }
            extensionWriter.writeUntil(200, output);
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
            size += this.extensionsSerializedSize();
            this.memoizedSerializedSize = size += this.unknownFields.size();
            return size;
        }

        @Override
        protected Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }

        public static EnumEntry parseFrom(ByteString data2) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data2);
        }

        public static EnumEntry parseFrom(ByteString data2, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data2, extensionRegistry);
        }

        public static EnumEntry parseFrom(byte[] data2) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data2);
        }

        public static EnumEntry parseFrom(byte[] data2, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data2, extensionRegistry);
        }

        public static EnumEntry parseFrom(InputStream input) throws IOException {
            return PARSER.parseFrom(input);
        }

        public static EnumEntry parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return PARSER.parseFrom(input, extensionRegistry);
        }

        public static EnumEntry parseDelimitedFrom(InputStream input) throws IOException {
            return PARSER.parseDelimitedFrom(input);
        }

        public static EnumEntry parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return PARSER.parseDelimitedFrom(input, extensionRegistry);
        }

        public static EnumEntry parseFrom(CodedInputStream input) throws IOException {
            return PARSER.parseFrom(input);
        }

        public static EnumEntry parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return PARSER.parseFrom(input, extensionRegistry);
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        @Override
        public Builder newBuilderForType() {
            return EnumEntry.newBuilder();
        }

        public static Builder newBuilder(EnumEntry prototype) {
            return EnumEntry.newBuilder().mergeFrom(prototype);
        }

        @Override
        public Builder toBuilder() {
            return EnumEntry.newBuilder(this);
        }

        static {
            PARSER = new AbstractParser<EnumEntry>(){

                @Override
                public EnumEntry parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                    return new EnumEntry(input, extensionRegistry);
                }
            };
            defaultInstance = new EnumEntry(true);
            defaultInstance.initFields();
        }

        public static final class Builder
        extends GeneratedMessageLite.ExtendableBuilder<EnumEntry, Builder>
        implements EnumEntryOrBuilder {
            private int bitField0_;
            private int name_;

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
                return this;
            }

            @Override
            public Builder clone() {
                return Builder.create().mergeFrom(this.buildPartial());
            }

            @Override
            public EnumEntry getDefaultInstanceForType() {
                return EnumEntry.getDefaultInstance();
            }

            @Override
            public EnumEntry build() {
                EnumEntry result2 = this.buildPartial();
                if (!result2.isInitialized()) {
                    throw Builder.newUninitializedMessageException(result2);
                }
                return result2;
            }

            @Override
            public EnumEntry buildPartial() {
                EnumEntry result2 = new EnumEntry(this);
                int from_bitField0_ = this.bitField0_;
                int to_bitField0_ = 0;
                if ((from_bitField0_ & 1) == 1) {
                    to_bitField0_ |= 1;
                }
                result2.name_ = this.name_;
                result2.bitField0_ = to_bitField0_;
                return result2;
            }

            @Override
            public Builder mergeFrom(EnumEntry other) {
                if (other == EnumEntry.getDefaultInstance()) {
                    return this;
                }
                if (other.hasName()) {
                    this.setName(other.getName());
                }
                this.mergeExtensionFields(other);
                this.setUnknownFields(this.getUnknownFields().concat(other.unknownFields));
                return this;
            }

            @Override
            public final boolean isInitialized() {
                return this.extensionsAreInitialized();
            }

            @Override
            public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                EnumEntry parsedMessage = null;
                try {
                    parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
                }
                catch (InvalidProtocolBufferException e) {
                    parsedMessage = (EnumEntry)e.getUnfinishedMessage();
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
        }
    }

    public static interface EnumEntryOrBuilder
    extends GeneratedMessageLite.ExtendableMessageOrBuilder<EnumEntry> {
        public boolean hasName();

        public int getName();
    }

    public static final class TypeAlias
    extends GeneratedMessageLite.ExtendableMessage<TypeAlias>
    implements TypeAliasOrBuilder {
        private static final TypeAlias defaultInstance;
        private final ByteString unknownFields;
        public static Parser<TypeAlias> PARSER;
        private int bitField0_;
        public static final int FLAGS_FIELD_NUMBER = 1;
        private int flags_;
        public static final int NAME_FIELD_NUMBER = 2;
        private int name_;
        public static final int TYPE_PARAMETER_FIELD_NUMBER = 3;
        private List<TypeParameter> typeParameter_;
        public static final int UNDERLYING_TYPE_FIELD_NUMBER = 4;
        private Type underlyingType_;
        public static final int UNDERLYING_TYPE_ID_FIELD_NUMBER = 5;
        private int underlyingTypeId_;
        public static final int EXPANDED_TYPE_FIELD_NUMBER = 6;
        private Type expandedType_;
        public static final int EXPANDED_TYPE_ID_FIELD_NUMBER = 7;
        private int expandedTypeId_;
        public static final int ANNOTATION_FIELD_NUMBER = 8;
        private List<Annotation> annotation_;
        public static final int SINCEKOTLININFO_FIELD_NUMBER = 31;
        private int sinceKotlinInfo_;
        private byte memoizedIsInitialized = (byte)-1;
        private int memoizedSerializedSize = -1;
        private static final long serialVersionUID = 0L;

        private TypeAlias(GeneratedMessageLite.ExtendableBuilder<TypeAlias, ?> builder) {
            super(builder);
            this.unknownFields = builder.getUnknownFields();
        }

        private TypeAlias(boolean noInit) {
            this.unknownFields = ByteString.EMPTY;
        }

        public static TypeAlias getDefaultInstance() {
            return defaultInstance;
        }

        @Override
        public TypeAlias getDefaultInstanceForType() {
            return defaultInstance;
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        private TypeAlias(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            this.initFields();
            int mutable_bitField0_ = 0;
            ByteString.Output unknownFieldsOutput = ByteString.newOutput();
            CodedOutputStream unknownFieldsCodedOutput = CodedOutputStream.newInstance(unknownFieldsOutput);
            try {
                boolean done = false;
                block27: while (!done) {
                    int tag = input.readTag();
                    switch (tag) {
                        case 0: {
                            done = true;
                            continue block27;
                        }
                        default: {
                            if (this.parseUnknownField(input, unknownFieldsCodedOutput, extensionRegistry, tag)) continue block27;
                            done = true;
                            continue block27;
                        }
                        case 8: {
                            this.bitField0_ |= 1;
                            this.flags_ = input.readInt32();
                            continue block27;
                        }
                        case 16: {
                            this.bitField0_ |= 2;
                            this.name_ = input.readInt32();
                            continue block27;
                        }
                        case 26: {
                            if ((mutable_bitField0_ & 4) != 4) {
                                this.typeParameter_ = new ArrayList<TypeParameter>();
                                mutable_bitField0_ |= 4;
                            }
                            this.typeParameter_.add(input.readMessage(TypeParameter.PARSER, extensionRegistry));
                            continue block27;
                        }
                        case 34: {
                            Type.Builder subBuilder = null;
                            if ((this.bitField0_ & 4) == 4) {
                                subBuilder = this.underlyingType_.toBuilder();
                            }
                            this.underlyingType_ = input.readMessage(Type.PARSER, extensionRegistry);
                            if (subBuilder != null) {
                                subBuilder.mergeFrom(this.underlyingType_);
                                this.underlyingType_ = subBuilder.buildPartial();
                            }
                            this.bitField0_ |= 4;
                            continue block27;
                        }
                        case 40: {
                            this.bitField0_ |= 8;
                            this.underlyingTypeId_ = input.readInt32();
                            continue block27;
                        }
                        case 50: {
                            Type.Builder subBuilder = null;
                            if ((this.bitField0_ & 0x10) == 16) {
                                subBuilder = this.expandedType_.toBuilder();
                            }
                            this.expandedType_ = input.readMessage(Type.PARSER, extensionRegistry);
                            if (subBuilder != null) {
                                subBuilder.mergeFrom(this.expandedType_);
                                this.expandedType_ = subBuilder.buildPartial();
                            }
                            this.bitField0_ |= 0x10;
                            continue block27;
                        }
                        case 56: {
                            this.bitField0_ |= 0x20;
                            this.expandedTypeId_ = input.readInt32();
                            continue block27;
                        }
                        case 66: {
                            if ((mutable_bitField0_ & 0x80) != 128) {
                                this.annotation_ = new ArrayList<Annotation>();
                                mutable_bitField0_ |= 0x80;
                            }
                            this.annotation_.add(input.readMessage(Annotation.PARSER, extensionRegistry));
                            continue block27;
                        }
                        case 248: 
                    }
                    this.bitField0_ |= 0x40;
                    this.sinceKotlinInfo_ = input.readInt32();
                }
            }
            catch (InvalidProtocolBufferException e) {
                throw e.setUnfinishedMessage(this);
            }
            catch (IOException e) {
                throw new InvalidProtocolBufferException(e.getMessage()).setUnfinishedMessage(this);
            }
            finally {
                if ((mutable_bitField0_ & 4) == 4) {
                    this.typeParameter_ = Collections.unmodifiableList(this.typeParameter_);
                }
                if ((mutable_bitField0_ & 0x80) == 128) {
                    this.annotation_ = Collections.unmodifiableList(this.annotation_);
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

        public Parser<TypeAlias> getParserForType() {
            return PARSER;
        }

        @Override
        public boolean hasFlags() {
            return (this.bitField0_ & 1) == 1;
        }

        @Override
        public int getFlags() {
            return this.flags_;
        }

        @Override
        public boolean hasName() {
            return (this.bitField0_ & 2) == 2;
        }

        @Override
        public int getName() {
            return this.name_;
        }

        @Override
        public List<TypeParameter> getTypeParameterList() {
            return this.typeParameter_;
        }

        public List<? extends TypeParameterOrBuilder> getTypeParameterOrBuilderList() {
            return this.typeParameter_;
        }

        @Override
        public int getTypeParameterCount() {
            return this.typeParameter_.size();
        }

        @Override
        public TypeParameter getTypeParameter(int index) {
            return this.typeParameter_.get(index);
        }

        public TypeParameterOrBuilder getTypeParameterOrBuilder(int index) {
            return this.typeParameter_.get(index);
        }

        @Override
        public boolean hasUnderlyingType() {
            return (this.bitField0_ & 4) == 4;
        }

        @Override
        public Type getUnderlyingType() {
            return this.underlyingType_;
        }

        @Override
        public boolean hasUnderlyingTypeId() {
            return (this.bitField0_ & 8) == 8;
        }

        @Override
        public int getUnderlyingTypeId() {
            return this.underlyingTypeId_;
        }

        @Override
        public boolean hasExpandedType() {
            return (this.bitField0_ & 0x10) == 16;
        }

        @Override
        public Type getExpandedType() {
            return this.expandedType_;
        }

        @Override
        public boolean hasExpandedTypeId() {
            return (this.bitField0_ & 0x20) == 32;
        }

        @Override
        public int getExpandedTypeId() {
            return this.expandedTypeId_;
        }

        @Override
        public List<Annotation> getAnnotationList() {
            return this.annotation_;
        }

        public List<? extends AnnotationOrBuilder> getAnnotationOrBuilderList() {
            return this.annotation_;
        }

        @Override
        public int getAnnotationCount() {
            return this.annotation_.size();
        }

        @Override
        public Annotation getAnnotation(int index) {
            return this.annotation_.get(index);
        }

        public AnnotationOrBuilder getAnnotationOrBuilder(int index) {
            return this.annotation_.get(index);
        }

        @Override
        public boolean hasSinceKotlinInfo() {
            return (this.bitField0_ & 0x40) == 64;
        }

        @Override
        public int getSinceKotlinInfo() {
            return this.sinceKotlinInfo_;
        }

        private void initFields() {
            this.flags_ = 6;
            this.name_ = 0;
            this.typeParameter_ = Collections.emptyList();
            this.underlyingType_ = Type.getDefaultInstance();
            this.underlyingTypeId_ = 0;
            this.expandedType_ = Type.getDefaultInstance();
            this.expandedTypeId_ = 0;
            this.annotation_ = Collections.emptyList();
            this.sinceKotlinInfo_ = 0;
        }

        @Override
        public final boolean isInitialized() {
            int i;
            byte isInitialized = this.memoizedIsInitialized;
            if (isInitialized == 1) {
                return true;
            }
            if (isInitialized == 0) {
                return false;
            }
            if (!this.hasName()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            for (i = 0; i < this.getTypeParameterCount(); ++i) {
                if (this.getTypeParameter(i).isInitialized()) continue;
                this.memoizedIsInitialized = 0;
                return false;
            }
            if (this.hasUnderlyingType() && !this.getUnderlyingType().isInitialized()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            if (this.hasExpandedType() && !this.getExpandedType().isInitialized()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            for (i = 0; i < this.getAnnotationCount(); ++i) {
                if (this.getAnnotation(i).isInitialized()) continue;
                this.memoizedIsInitialized = 0;
                return false;
            }
            if (!this.extensionsAreInitialized()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            this.memoizedIsInitialized = 1;
            return true;
        }

        @Override
        public void writeTo(CodedOutputStream output) throws IOException {
            int i;
            this.getSerializedSize();
            GeneratedMessageLite.ExtendableMessage.ExtensionWriter extensionWriter = this.newExtensionWriter();
            if ((this.bitField0_ & 1) == 1) {
                output.writeInt32(1, this.flags_);
            }
            if ((this.bitField0_ & 2) == 2) {
                output.writeInt32(2, this.name_);
            }
            for (i = 0; i < this.typeParameter_.size(); ++i) {
                output.writeMessage(3, this.typeParameter_.get(i));
            }
            if ((this.bitField0_ & 4) == 4) {
                output.writeMessage(4, this.underlyingType_);
            }
            if ((this.bitField0_ & 8) == 8) {
                output.writeInt32(5, this.underlyingTypeId_);
            }
            if ((this.bitField0_ & 0x10) == 16) {
                output.writeMessage(6, this.expandedType_);
            }
            if ((this.bitField0_ & 0x20) == 32) {
                output.writeInt32(7, this.expandedTypeId_);
            }
            for (i = 0; i < this.annotation_.size(); ++i) {
                output.writeMessage(8, this.annotation_.get(i));
            }
            if ((this.bitField0_ & 0x40) == 64) {
                output.writeInt32(31, this.sinceKotlinInfo_);
            }
            extensionWriter.writeUntil(200, output);
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
                size += CodedOutputStream.computeInt32Size(1, this.flags_);
            }
            if ((this.bitField0_ & 2) == 2) {
                size += CodedOutputStream.computeInt32Size(2, this.name_);
            }
            for (i = 0; i < this.typeParameter_.size(); ++i) {
                size += CodedOutputStream.computeMessageSize(3, this.typeParameter_.get(i));
            }
            if ((this.bitField0_ & 4) == 4) {
                size += CodedOutputStream.computeMessageSize(4, this.underlyingType_);
            }
            if ((this.bitField0_ & 8) == 8) {
                size += CodedOutputStream.computeInt32Size(5, this.underlyingTypeId_);
            }
            if ((this.bitField0_ & 0x10) == 16) {
                size += CodedOutputStream.computeMessageSize(6, this.expandedType_);
            }
            if ((this.bitField0_ & 0x20) == 32) {
                size += CodedOutputStream.computeInt32Size(7, this.expandedTypeId_);
            }
            for (i = 0; i < this.annotation_.size(); ++i) {
                size += CodedOutputStream.computeMessageSize(8, this.annotation_.get(i));
            }
            if ((this.bitField0_ & 0x40) == 64) {
                size += CodedOutputStream.computeInt32Size(31, this.sinceKotlinInfo_);
            }
            size += this.extensionsSerializedSize();
            this.memoizedSerializedSize = size += this.unknownFields.size();
            return size;
        }

        @Override
        protected Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }

        public static TypeAlias parseFrom(ByteString data2) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data2);
        }

        public static TypeAlias parseFrom(ByteString data2, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data2, extensionRegistry);
        }

        public static TypeAlias parseFrom(byte[] data2) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data2);
        }

        public static TypeAlias parseFrom(byte[] data2, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data2, extensionRegistry);
        }

        public static TypeAlias parseFrom(InputStream input) throws IOException {
            return PARSER.parseFrom(input);
        }

        public static TypeAlias parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return PARSER.parseFrom(input, extensionRegistry);
        }

        public static TypeAlias parseDelimitedFrom(InputStream input) throws IOException {
            return PARSER.parseDelimitedFrom(input);
        }

        public static TypeAlias parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return PARSER.parseDelimitedFrom(input, extensionRegistry);
        }

        public static TypeAlias parseFrom(CodedInputStream input) throws IOException {
            return PARSER.parseFrom(input);
        }

        public static TypeAlias parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return PARSER.parseFrom(input, extensionRegistry);
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        @Override
        public Builder newBuilderForType() {
            return TypeAlias.newBuilder();
        }

        public static Builder newBuilder(TypeAlias prototype) {
            return TypeAlias.newBuilder().mergeFrom(prototype);
        }

        @Override
        public Builder toBuilder() {
            return TypeAlias.newBuilder(this);
        }

        static {
            PARSER = new AbstractParser<TypeAlias>(){

                @Override
                public TypeAlias parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                    return new TypeAlias(input, extensionRegistry);
                }
            };
            defaultInstance = new TypeAlias(true);
            defaultInstance.initFields();
        }

        public static final class Builder
        extends GeneratedMessageLite.ExtendableBuilder<TypeAlias, Builder>
        implements TypeAliasOrBuilder {
            private int bitField0_;
            private int flags_ = 6;
            private int name_;
            private List<TypeParameter> typeParameter_ = Collections.emptyList();
            private Type underlyingType_ = Type.getDefaultInstance();
            private int underlyingTypeId_;
            private Type expandedType_ = Type.getDefaultInstance();
            private int expandedTypeId_;
            private List<Annotation> annotation_ = Collections.emptyList();
            private int sinceKotlinInfo_;

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
                this.flags_ = 6;
                this.bitField0_ &= 0xFFFFFFFE;
                this.name_ = 0;
                this.bitField0_ &= 0xFFFFFFFD;
                this.typeParameter_ = Collections.emptyList();
                this.bitField0_ &= 0xFFFFFFFB;
                this.underlyingType_ = Type.getDefaultInstance();
                this.bitField0_ &= 0xFFFFFFF7;
                this.underlyingTypeId_ = 0;
                this.bitField0_ &= 0xFFFFFFEF;
                this.expandedType_ = Type.getDefaultInstance();
                this.bitField0_ &= 0xFFFFFFDF;
                this.expandedTypeId_ = 0;
                this.bitField0_ &= 0xFFFFFFBF;
                this.annotation_ = Collections.emptyList();
                this.bitField0_ &= 0xFFFFFF7F;
                this.sinceKotlinInfo_ = 0;
                this.bitField0_ &= 0xFFFFFEFF;
                return this;
            }

            @Override
            public Builder clone() {
                return Builder.create().mergeFrom(this.buildPartial());
            }

            @Override
            public TypeAlias getDefaultInstanceForType() {
                return TypeAlias.getDefaultInstance();
            }

            @Override
            public TypeAlias build() {
                TypeAlias result2 = this.buildPartial();
                if (!result2.isInitialized()) {
                    throw Builder.newUninitializedMessageException(result2);
                }
                return result2;
            }

            @Override
            public TypeAlias buildPartial() {
                TypeAlias result2 = new TypeAlias(this);
                int from_bitField0_ = this.bitField0_;
                int to_bitField0_ = 0;
                if ((from_bitField0_ & 1) == 1) {
                    to_bitField0_ |= 1;
                }
                result2.flags_ = this.flags_;
                if ((from_bitField0_ & 2) == 2) {
                    to_bitField0_ |= 2;
                }
                result2.name_ = this.name_;
                if ((this.bitField0_ & 4) == 4) {
                    this.typeParameter_ = Collections.unmodifiableList(this.typeParameter_);
                    this.bitField0_ &= 0xFFFFFFFB;
                }
                result2.typeParameter_ = this.typeParameter_;
                if ((from_bitField0_ & 8) == 8) {
                    to_bitField0_ |= 4;
                }
                result2.underlyingType_ = this.underlyingType_;
                if ((from_bitField0_ & 0x10) == 16) {
                    to_bitField0_ |= 8;
                }
                result2.underlyingTypeId_ = this.underlyingTypeId_;
                if ((from_bitField0_ & 0x20) == 32) {
                    to_bitField0_ |= 0x10;
                }
                result2.expandedType_ = this.expandedType_;
                if ((from_bitField0_ & 0x40) == 64) {
                    to_bitField0_ |= 0x20;
                }
                result2.expandedTypeId_ = this.expandedTypeId_;
                if ((this.bitField0_ & 0x80) == 128) {
                    this.annotation_ = Collections.unmodifiableList(this.annotation_);
                    this.bitField0_ &= 0xFFFFFF7F;
                }
                result2.annotation_ = this.annotation_;
                if ((from_bitField0_ & 0x100) == 256) {
                    to_bitField0_ |= 0x40;
                }
                result2.sinceKotlinInfo_ = this.sinceKotlinInfo_;
                result2.bitField0_ = to_bitField0_;
                return result2;
            }

            @Override
            public Builder mergeFrom(TypeAlias other) {
                if (other == TypeAlias.getDefaultInstance()) {
                    return this;
                }
                if (other.hasFlags()) {
                    this.setFlags(other.getFlags());
                }
                if (other.hasName()) {
                    this.setName(other.getName());
                }
                if (!other.typeParameter_.isEmpty()) {
                    if (this.typeParameter_.isEmpty()) {
                        this.typeParameter_ = other.typeParameter_;
                        this.bitField0_ &= 0xFFFFFFFB;
                    } else {
                        this.ensureTypeParameterIsMutable();
                        this.typeParameter_.addAll(other.typeParameter_);
                    }
                }
                if (other.hasUnderlyingType()) {
                    this.mergeUnderlyingType(other.getUnderlyingType());
                }
                if (other.hasUnderlyingTypeId()) {
                    this.setUnderlyingTypeId(other.getUnderlyingTypeId());
                }
                if (other.hasExpandedType()) {
                    this.mergeExpandedType(other.getExpandedType());
                }
                if (other.hasExpandedTypeId()) {
                    this.setExpandedTypeId(other.getExpandedTypeId());
                }
                if (!other.annotation_.isEmpty()) {
                    if (this.annotation_.isEmpty()) {
                        this.annotation_ = other.annotation_;
                        this.bitField0_ &= 0xFFFFFF7F;
                    } else {
                        this.ensureAnnotationIsMutable();
                        this.annotation_.addAll(other.annotation_);
                    }
                }
                if (other.hasSinceKotlinInfo()) {
                    this.setSinceKotlinInfo(other.getSinceKotlinInfo());
                }
                this.mergeExtensionFields(other);
                this.setUnknownFields(this.getUnknownFields().concat(other.unknownFields));
                return this;
            }

            @Override
            public final boolean isInitialized() {
                int i;
                if (!this.hasName()) {
                    return false;
                }
                for (i = 0; i < this.getTypeParameterCount(); ++i) {
                    if (this.getTypeParameter(i).isInitialized()) continue;
                    return false;
                }
                if (this.hasUnderlyingType() && !this.getUnderlyingType().isInitialized()) {
                    return false;
                }
                if (this.hasExpandedType() && !this.getExpandedType().isInitialized()) {
                    return false;
                }
                for (i = 0; i < this.getAnnotationCount(); ++i) {
                    if (this.getAnnotation(i).isInitialized()) continue;
                    return false;
                }
                return this.extensionsAreInitialized();
            }

            @Override
            public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                TypeAlias parsedMessage = null;
                try {
                    parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
                }
                catch (InvalidProtocolBufferException e) {
                    parsedMessage = (TypeAlias)e.getUnfinishedMessage();
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
            public boolean hasFlags() {
                return (this.bitField0_ & 1) == 1;
            }

            @Override
            public int getFlags() {
                return this.flags_;
            }

            public Builder setFlags(int value) {
                this.bitField0_ |= 1;
                this.flags_ = value;
                return this;
            }

            public Builder clearFlags() {
                this.bitField0_ &= 0xFFFFFFFE;
                this.flags_ = 6;
                return this;
            }

            @Override
            public boolean hasName() {
                return (this.bitField0_ & 2) == 2;
            }

            @Override
            public int getName() {
                return this.name_;
            }

            public Builder setName(int value) {
                this.bitField0_ |= 2;
                this.name_ = value;
                return this;
            }

            public Builder clearName() {
                this.bitField0_ &= 0xFFFFFFFD;
                this.name_ = 0;
                return this;
            }

            private void ensureTypeParameterIsMutable() {
                if ((this.bitField0_ & 4) != 4) {
                    this.typeParameter_ = new ArrayList<TypeParameter>(this.typeParameter_);
                    this.bitField0_ |= 4;
                }
            }

            @Override
            public List<TypeParameter> getTypeParameterList() {
                return Collections.unmodifiableList(this.typeParameter_);
            }

            @Override
            public int getTypeParameterCount() {
                return this.typeParameter_.size();
            }

            @Override
            public TypeParameter getTypeParameter(int index) {
                return this.typeParameter_.get(index);
            }

            public Builder setTypeParameter(int index, TypeParameter value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.ensureTypeParameterIsMutable();
                this.typeParameter_.set(index, value);
                return this;
            }

            public Builder setTypeParameter(int index, TypeParameter.Builder builderForValue) {
                this.ensureTypeParameterIsMutable();
                this.typeParameter_.set(index, builderForValue.build());
                return this;
            }

            public Builder addTypeParameter(TypeParameter value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.ensureTypeParameterIsMutable();
                this.typeParameter_.add(value);
                return this;
            }

            public Builder addTypeParameter(int index, TypeParameter value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.ensureTypeParameterIsMutable();
                this.typeParameter_.add(index, value);
                return this;
            }

            public Builder addTypeParameter(TypeParameter.Builder builderForValue) {
                this.ensureTypeParameterIsMutable();
                this.typeParameter_.add(builderForValue.build());
                return this;
            }

            public Builder addTypeParameter(int index, TypeParameter.Builder builderForValue) {
                this.ensureTypeParameterIsMutable();
                this.typeParameter_.add(index, builderForValue.build());
                return this;
            }

            public Builder addAllTypeParameter(Iterable<? extends TypeParameter> values2) {
                this.ensureTypeParameterIsMutable();
                AbstractMessageLite.Builder.addAll(values2, this.typeParameter_);
                return this;
            }

            public Builder clearTypeParameter() {
                this.typeParameter_ = Collections.emptyList();
                this.bitField0_ &= 0xFFFFFFFB;
                return this;
            }

            public Builder removeTypeParameter(int index) {
                this.ensureTypeParameterIsMutable();
                this.typeParameter_.remove(index);
                return this;
            }

            @Override
            public boolean hasUnderlyingType() {
                return (this.bitField0_ & 8) == 8;
            }

            @Override
            public Type getUnderlyingType() {
                return this.underlyingType_;
            }

            public Builder setUnderlyingType(Type value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.underlyingType_ = value;
                this.bitField0_ |= 8;
                return this;
            }

            public Builder setUnderlyingType(Type.Builder builderForValue) {
                this.underlyingType_ = builderForValue.build();
                this.bitField0_ |= 8;
                return this;
            }

            public Builder mergeUnderlyingType(Type value) {
                this.underlyingType_ = (this.bitField0_ & 8) == 8 && this.underlyingType_ != Type.getDefaultInstance() ? Type.newBuilder(this.underlyingType_).mergeFrom(value).buildPartial() : value;
                this.bitField0_ |= 8;
                return this;
            }

            public Builder clearUnderlyingType() {
                this.underlyingType_ = Type.getDefaultInstance();
                this.bitField0_ &= 0xFFFFFFF7;
                return this;
            }

            @Override
            public boolean hasUnderlyingTypeId() {
                return (this.bitField0_ & 0x10) == 16;
            }

            @Override
            public int getUnderlyingTypeId() {
                return this.underlyingTypeId_;
            }

            public Builder setUnderlyingTypeId(int value) {
                this.bitField0_ |= 0x10;
                this.underlyingTypeId_ = value;
                return this;
            }

            public Builder clearUnderlyingTypeId() {
                this.bitField0_ &= 0xFFFFFFEF;
                this.underlyingTypeId_ = 0;
                return this;
            }

            @Override
            public boolean hasExpandedType() {
                return (this.bitField0_ & 0x20) == 32;
            }

            @Override
            public Type getExpandedType() {
                return this.expandedType_;
            }

            public Builder setExpandedType(Type value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.expandedType_ = value;
                this.bitField0_ |= 0x20;
                return this;
            }

            public Builder setExpandedType(Type.Builder builderForValue) {
                this.expandedType_ = builderForValue.build();
                this.bitField0_ |= 0x20;
                return this;
            }

            public Builder mergeExpandedType(Type value) {
                this.expandedType_ = (this.bitField0_ & 0x20) == 32 && this.expandedType_ != Type.getDefaultInstance() ? Type.newBuilder(this.expandedType_).mergeFrom(value).buildPartial() : value;
                this.bitField0_ |= 0x20;
                return this;
            }

            public Builder clearExpandedType() {
                this.expandedType_ = Type.getDefaultInstance();
                this.bitField0_ &= 0xFFFFFFDF;
                return this;
            }

            @Override
            public boolean hasExpandedTypeId() {
                return (this.bitField0_ & 0x40) == 64;
            }

            @Override
            public int getExpandedTypeId() {
                return this.expandedTypeId_;
            }

            public Builder setExpandedTypeId(int value) {
                this.bitField0_ |= 0x40;
                this.expandedTypeId_ = value;
                return this;
            }

            public Builder clearExpandedTypeId() {
                this.bitField0_ &= 0xFFFFFFBF;
                this.expandedTypeId_ = 0;
                return this;
            }

            private void ensureAnnotationIsMutable() {
                if ((this.bitField0_ & 0x80) != 128) {
                    this.annotation_ = new ArrayList<Annotation>(this.annotation_);
                    this.bitField0_ |= 0x80;
                }
            }

            @Override
            public List<Annotation> getAnnotationList() {
                return Collections.unmodifiableList(this.annotation_);
            }

            @Override
            public int getAnnotationCount() {
                return this.annotation_.size();
            }

            @Override
            public Annotation getAnnotation(int index) {
                return this.annotation_.get(index);
            }

            public Builder setAnnotation(int index, Annotation value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.ensureAnnotationIsMutable();
                this.annotation_.set(index, value);
                return this;
            }

            public Builder setAnnotation(int index, Annotation.Builder builderForValue) {
                this.ensureAnnotationIsMutable();
                this.annotation_.set(index, builderForValue.build());
                return this;
            }

            public Builder addAnnotation(Annotation value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.ensureAnnotationIsMutable();
                this.annotation_.add(value);
                return this;
            }

            public Builder addAnnotation(int index, Annotation value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.ensureAnnotationIsMutable();
                this.annotation_.add(index, value);
                return this;
            }

            public Builder addAnnotation(Annotation.Builder builderForValue) {
                this.ensureAnnotationIsMutable();
                this.annotation_.add(builderForValue.build());
                return this;
            }

            public Builder addAnnotation(int index, Annotation.Builder builderForValue) {
                this.ensureAnnotationIsMutable();
                this.annotation_.add(index, builderForValue.build());
                return this;
            }

            public Builder addAllAnnotation(Iterable<? extends Annotation> values2) {
                this.ensureAnnotationIsMutable();
                AbstractMessageLite.Builder.addAll(values2, this.annotation_);
                return this;
            }

            public Builder clearAnnotation() {
                this.annotation_ = Collections.emptyList();
                this.bitField0_ &= 0xFFFFFF7F;
                return this;
            }

            public Builder removeAnnotation(int index) {
                this.ensureAnnotationIsMutable();
                this.annotation_.remove(index);
                return this;
            }

            @Override
            public boolean hasSinceKotlinInfo() {
                return (this.bitField0_ & 0x100) == 256;
            }

            @Override
            public int getSinceKotlinInfo() {
                return this.sinceKotlinInfo_;
            }

            public Builder setSinceKotlinInfo(int value) {
                this.bitField0_ |= 0x100;
                this.sinceKotlinInfo_ = value;
                return this;
            }

            public Builder clearSinceKotlinInfo() {
                this.bitField0_ &= 0xFFFFFEFF;
                this.sinceKotlinInfo_ = 0;
                return this;
            }
        }
    }

    public static interface TypeAliasOrBuilder
    extends GeneratedMessageLite.ExtendableMessageOrBuilder<TypeAlias> {
        public boolean hasFlags();

        public int getFlags();

        public boolean hasName();

        public int getName();

        public List<TypeParameter> getTypeParameterList();

        public TypeParameter getTypeParameter(int var1);

        public int getTypeParameterCount();

        public boolean hasUnderlyingType();

        public Type getUnderlyingType();

        public boolean hasUnderlyingTypeId();

        public int getUnderlyingTypeId();

        public boolean hasExpandedType();

        public Type getExpandedType();

        public boolean hasExpandedTypeId();

        public int getExpandedTypeId();

        public List<Annotation> getAnnotationList();

        public Annotation getAnnotation(int var1);

        public int getAnnotationCount();

        public boolean hasSinceKotlinInfo();

        public int getSinceKotlinInfo();
    }

    public static final class ValueParameter
    extends GeneratedMessageLite.ExtendableMessage<ValueParameter>
    implements ValueParameterOrBuilder {
        private static final ValueParameter defaultInstance;
        private final ByteString unknownFields;
        public static Parser<ValueParameter> PARSER;
        private int bitField0_;
        public static final int FLAGS_FIELD_NUMBER = 1;
        private int flags_;
        public static final int NAME_FIELD_NUMBER = 2;
        private int name_;
        public static final int TYPE_FIELD_NUMBER = 3;
        private Type type_;
        public static final int TYPE_ID_FIELD_NUMBER = 5;
        private int typeId_;
        public static final int VARARG_ELEMENT_TYPE_FIELD_NUMBER = 4;
        private Type varargElementType_;
        public static final int VARARG_ELEMENT_TYPE_ID_FIELD_NUMBER = 6;
        private int varargElementTypeId_;
        private byte memoizedIsInitialized = (byte)-1;
        private int memoizedSerializedSize = -1;
        private static final long serialVersionUID = 0L;

        private ValueParameter(GeneratedMessageLite.ExtendableBuilder<ValueParameter, ?> builder) {
            super(builder);
            this.unknownFields = builder.getUnknownFields();
        }

        private ValueParameter(boolean noInit) {
            this.unknownFields = ByteString.EMPTY;
        }

        public static ValueParameter getDefaultInstance() {
            return defaultInstance;
        }

        @Override
        public ValueParameter getDefaultInstanceForType() {
            return defaultInstance;
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        private ValueParameter(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            this.initFields();
            boolean mutable_bitField0_ = false;
            ByteString.Output unknownFieldsOutput = ByteString.newOutput();
            CodedOutputStream unknownFieldsCodedOutput = CodedOutputStream.newInstance(unknownFieldsOutput);
            try {
                boolean done = false;
                block24: while (!done) {
                    int tag = input.readTag();
                    switch (tag) {
                        case 0: {
                            done = true;
                            continue block24;
                        }
                        default: {
                            if (this.parseUnknownField(input, unknownFieldsCodedOutput, extensionRegistry, tag)) continue block24;
                            done = true;
                            continue block24;
                        }
                        case 8: {
                            this.bitField0_ |= 1;
                            this.flags_ = input.readInt32();
                            continue block24;
                        }
                        case 16: {
                            this.bitField0_ |= 2;
                            this.name_ = input.readInt32();
                            continue block24;
                        }
                        case 26: {
                            Type.Builder subBuilder = null;
                            if ((this.bitField0_ & 4) == 4) {
                                subBuilder = this.type_.toBuilder();
                            }
                            this.type_ = input.readMessage(Type.PARSER, extensionRegistry);
                            if (subBuilder != null) {
                                subBuilder.mergeFrom(this.type_);
                                this.type_ = subBuilder.buildPartial();
                            }
                            this.bitField0_ |= 4;
                            continue block24;
                        }
                        case 34: {
                            Type.Builder subBuilder = null;
                            if ((this.bitField0_ & 0x10) == 16) {
                                subBuilder = this.varargElementType_.toBuilder();
                            }
                            this.varargElementType_ = input.readMessage(Type.PARSER, extensionRegistry);
                            if (subBuilder != null) {
                                subBuilder.mergeFrom(this.varargElementType_);
                                this.varargElementType_ = subBuilder.buildPartial();
                            }
                            this.bitField0_ |= 0x10;
                            continue block24;
                        }
                        case 40: {
                            this.bitField0_ |= 8;
                            this.typeId_ = input.readInt32();
                            continue block24;
                        }
                        case 48: 
                    }
                    this.bitField0_ |= 0x20;
                    this.varargElementTypeId_ = input.readInt32();
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

        public Parser<ValueParameter> getParserForType() {
            return PARSER;
        }

        @Override
        public boolean hasFlags() {
            return (this.bitField0_ & 1) == 1;
        }

        @Override
        public int getFlags() {
            return this.flags_;
        }

        @Override
        public boolean hasName() {
            return (this.bitField0_ & 2) == 2;
        }

        @Override
        public int getName() {
            return this.name_;
        }

        @Override
        public boolean hasType() {
            return (this.bitField0_ & 4) == 4;
        }

        @Override
        public Type getType() {
            return this.type_;
        }

        @Override
        public boolean hasTypeId() {
            return (this.bitField0_ & 8) == 8;
        }

        @Override
        public int getTypeId() {
            return this.typeId_;
        }

        @Override
        public boolean hasVarargElementType() {
            return (this.bitField0_ & 0x10) == 16;
        }

        @Override
        public Type getVarargElementType() {
            return this.varargElementType_;
        }

        @Override
        public boolean hasVarargElementTypeId() {
            return (this.bitField0_ & 0x20) == 32;
        }

        @Override
        public int getVarargElementTypeId() {
            return this.varargElementTypeId_;
        }

        private void initFields() {
            this.flags_ = 0;
            this.name_ = 0;
            this.type_ = Type.getDefaultInstance();
            this.typeId_ = 0;
            this.varargElementType_ = Type.getDefaultInstance();
            this.varargElementTypeId_ = 0;
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
            if (!this.hasName()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            if (this.hasType() && !this.getType().isInitialized()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            if (this.hasVarargElementType() && !this.getVarargElementType().isInitialized()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            if (!this.extensionsAreInitialized()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            this.memoizedIsInitialized = 1;
            return true;
        }

        @Override
        public void writeTo(CodedOutputStream output) throws IOException {
            this.getSerializedSize();
            GeneratedMessageLite.ExtendableMessage.ExtensionWriter extensionWriter = this.newExtensionWriter();
            if ((this.bitField0_ & 1) == 1) {
                output.writeInt32(1, this.flags_);
            }
            if ((this.bitField0_ & 2) == 2) {
                output.writeInt32(2, this.name_);
            }
            if ((this.bitField0_ & 4) == 4) {
                output.writeMessage(3, this.type_);
            }
            if ((this.bitField0_ & 0x10) == 16) {
                output.writeMessage(4, this.varargElementType_);
            }
            if ((this.bitField0_ & 8) == 8) {
                output.writeInt32(5, this.typeId_);
            }
            if ((this.bitField0_ & 0x20) == 32) {
                output.writeInt32(6, this.varargElementTypeId_);
            }
            extensionWriter.writeUntil(200, output);
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
                size += CodedOutputStream.computeInt32Size(1, this.flags_);
            }
            if ((this.bitField0_ & 2) == 2) {
                size += CodedOutputStream.computeInt32Size(2, this.name_);
            }
            if ((this.bitField0_ & 4) == 4) {
                size += CodedOutputStream.computeMessageSize(3, this.type_);
            }
            if ((this.bitField0_ & 0x10) == 16) {
                size += CodedOutputStream.computeMessageSize(4, this.varargElementType_);
            }
            if ((this.bitField0_ & 8) == 8) {
                size += CodedOutputStream.computeInt32Size(5, this.typeId_);
            }
            if ((this.bitField0_ & 0x20) == 32) {
                size += CodedOutputStream.computeInt32Size(6, this.varargElementTypeId_);
            }
            size += this.extensionsSerializedSize();
            this.memoizedSerializedSize = size += this.unknownFields.size();
            return size;
        }

        @Override
        protected Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }

        public static ValueParameter parseFrom(ByteString data2) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data2);
        }

        public static ValueParameter parseFrom(ByteString data2, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data2, extensionRegistry);
        }

        public static ValueParameter parseFrom(byte[] data2) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data2);
        }

        public static ValueParameter parseFrom(byte[] data2, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data2, extensionRegistry);
        }

        public static ValueParameter parseFrom(InputStream input) throws IOException {
            return PARSER.parseFrom(input);
        }

        public static ValueParameter parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return PARSER.parseFrom(input, extensionRegistry);
        }

        public static ValueParameter parseDelimitedFrom(InputStream input) throws IOException {
            return PARSER.parseDelimitedFrom(input);
        }

        public static ValueParameter parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return PARSER.parseDelimitedFrom(input, extensionRegistry);
        }

        public static ValueParameter parseFrom(CodedInputStream input) throws IOException {
            return PARSER.parseFrom(input);
        }

        public static ValueParameter parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return PARSER.parseFrom(input, extensionRegistry);
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        @Override
        public Builder newBuilderForType() {
            return ValueParameter.newBuilder();
        }

        public static Builder newBuilder(ValueParameter prototype) {
            return ValueParameter.newBuilder().mergeFrom(prototype);
        }

        @Override
        public Builder toBuilder() {
            return ValueParameter.newBuilder(this);
        }

        static {
            PARSER = new AbstractParser<ValueParameter>(){

                @Override
                public ValueParameter parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                    return new ValueParameter(input, extensionRegistry);
                }
            };
            defaultInstance = new ValueParameter(true);
            defaultInstance.initFields();
        }

        public static final class Builder
        extends GeneratedMessageLite.ExtendableBuilder<ValueParameter, Builder>
        implements ValueParameterOrBuilder {
            private int bitField0_;
            private int flags_;
            private int name_;
            private Type type_ = Type.getDefaultInstance();
            private int typeId_;
            private Type varargElementType_ = Type.getDefaultInstance();
            private int varargElementTypeId_;

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
                this.flags_ = 0;
                this.bitField0_ &= 0xFFFFFFFE;
                this.name_ = 0;
                this.bitField0_ &= 0xFFFFFFFD;
                this.type_ = Type.getDefaultInstance();
                this.bitField0_ &= 0xFFFFFFFB;
                this.typeId_ = 0;
                this.bitField0_ &= 0xFFFFFFF7;
                this.varargElementType_ = Type.getDefaultInstance();
                this.bitField0_ &= 0xFFFFFFEF;
                this.varargElementTypeId_ = 0;
                this.bitField0_ &= 0xFFFFFFDF;
                return this;
            }

            @Override
            public Builder clone() {
                return Builder.create().mergeFrom(this.buildPartial());
            }

            @Override
            public ValueParameter getDefaultInstanceForType() {
                return ValueParameter.getDefaultInstance();
            }

            @Override
            public ValueParameter build() {
                ValueParameter result2 = this.buildPartial();
                if (!result2.isInitialized()) {
                    throw Builder.newUninitializedMessageException(result2);
                }
                return result2;
            }

            @Override
            public ValueParameter buildPartial() {
                ValueParameter result2 = new ValueParameter(this);
                int from_bitField0_ = this.bitField0_;
                int to_bitField0_ = 0;
                if ((from_bitField0_ & 1) == 1) {
                    to_bitField0_ |= 1;
                }
                result2.flags_ = this.flags_;
                if ((from_bitField0_ & 2) == 2) {
                    to_bitField0_ |= 2;
                }
                result2.name_ = this.name_;
                if ((from_bitField0_ & 4) == 4) {
                    to_bitField0_ |= 4;
                }
                result2.type_ = this.type_;
                if ((from_bitField0_ & 8) == 8) {
                    to_bitField0_ |= 8;
                }
                result2.typeId_ = this.typeId_;
                if ((from_bitField0_ & 0x10) == 16) {
                    to_bitField0_ |= 0x10;
                }
                result2.varargElementType_ = this.varargElementType_;
                if ((from_bitField0_ & 0x20) == 32) {
                    to_bitField0_ |= 0x20;
                }
                result2.varargElementTypeId_ = this.varargElementTypeId_;
                result2.bitField0_ = to_bitField0_;
                return result2;
            }

            @Override
            public Builder mergeFrom(ValueParameter other) {
                if (other == ValueParameter.getDefaultInstance()) {
                    return this;
                }
                if (other.hasFlags()) {
                    this.setFlags(other.getFlags());
                }
                if (other.hasName()) {
                    this.setName(other.getName());
                }
                if (other.hasType()) {
                    this.mergeType(other.getType());
                }
                if (other.hasTypeId()) {
                    this.setTypeId(other.getTypeId());
                }
                if (other.hasVarargElementType()) {
                    this.mergeVarargElementType(other.getVarargElementType());
                }
                if (other.hasVarargElementTypeId()) {
                    this.setVarargElementTypeId(other.getVarargElementTypeId());
                }
                this.mergeExtensionFields(other);
                this.setUnknownFields(this.getUnknownFields().concat(other.unknownFields));
                return this;
            }

            @Override
            public final boolean isInitialized() {
                if (!this.hasName()) {
                    return false;
                }
                if (this.hasType() && !this.getType().isInitialized()) {
                    return false;
                }
                if (this.hasVarargElementType() && !this.getVarargElementType().isInitialized()) {
                    return false;
                }
                return this.extensionsAreInitialized();
            }

            @Override
            public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                ValueParameter parsedMessage = null;
                try {
                    parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
                }
                catch (InvalidProtocolBufferException e) {
                    parsedMessage = (ValueParameter)e.getUnfinishedMessage();
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
            public boolean hasFlags() {
                return (this.bitField0_ & 1) == 1;
            }

            @Override
            public int getFlags() {
                return this.flags_;
            }

            public Builder setFlags(int value) {
                this.bitField0_ |= 1;
                this.flags_ = value;
                return this;
            }

            public Builder clearFlags() {
                this.bitField0_ &= 0xFFFFFFFE;
                this.flags_ = 0;
                return this;
            }

            @Override
            public boolean hasName() {
                return (this.bitField0_ & 2) == 2;
            }

            @Override
            public int getName() {
                return this.name_;
            }

            public Builder setName(int value) {
                this.bitField0_ |= 2;
                this.name_ = value;
                return this;
            }

            public Builder clearName() {
                this.bitField0_ &= 0xFFFFFFFD;
                this.name_ = 0;
                return this;
            }

            @Override
            public boolean hasType() {
                return (this.bitField0_ & 4) == 4;
            }

            @Override
            public Type getType() {
                return this.type_;
            }

            public Builder setType(Type value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.type_ = value;
                this.bitField0_ |= 4;
                return this;
            }

            public Builder setType(Type.Builder builderForValue) {
                this.type_ = builderForValue.build();
                this.bitField0_ |= 4;
                return this;
            }

            public Builder mergeType(Type value) {
                this.type_ = (this.bitField0_ & 4) == 4 && this.type_ != Type.getDefaultInstance() ? Type.newBuilder(this.type_).mergeFrom(value).buildPartial() : value;
                this.bitField0_ |= 4;
                return this;
            }

            public Builder clearType() {
                this.type_ = Type.getDefaultInstance();
                this.bitField0_ &= 0xFFFFFFFB;
                return this;
            }

            @Override
            public boolean hasTypeId() {
                return (this.bitField0_ & 8) == 8;
            }

            @Override
            public int getTypeId() {
                return this.typeId_;
            }

            public Builder setTypeId(int value) {
                this.bitField0_ |= 8;
                this.typeId_ = value;
                return this;
            }

            public Builder clearTypeId() {
                this.bitField0_ &= 0xFFFFFFF7;
                this.typeId_ = 0;
                return this;
            }

            @Override
            public boolean hasVarargElementType() {
                return (this.bitField0_ & 0x10) == 16;
            }

            @Override
            public Type getVarargElementType() {
                return this.varargElementType_;
            }

            public Builder setVarargElementType(Type value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.varargElementType_ = value;
                this.bitField0_ |= 0x10;
                return this;
            }

            public Builder setVarargElementType(Type.Builder builderForValue) {
                this.varargElementType_ = builderForValue.build();
                this.bitField0_ |= 0x10;
                return this;
            }

            public Builder mergeVarargElementType(Type value) {
                this.varargElementType_ = (this.bitField0_ & 0x10) == 16 && this.varargElementType_ != Type.getDefaultInstance() ? Type.newBuilder(this.varargElementType_).mergeFrom(value).buildPartial() : value;
                this.bitField0_ |= 0x10;
                return this;
            }

            public Builder clearVarargElementType() {
                this.varargElementType_ = Type.getDefaultInstance();
                this.bitField0_ &= 0xFFFFFFEF;
                return this;
            }

            @Override
            public boolean hasVarargElementTypeId() {
                return (this.bitField0_ & 0x20) == 32;
            }

            @Override
            public int getVarargElementTypeId() {
                return this.varargElementTypeId_;
            }

            public Builder setVarargElementTypeId(int value) {
                this.bitField0_ |= 0x20;
                this.varargElementTypeId_ = value;
                return this;
            }

            public Builder clearVarargElementTypeId() {
                this.bitField0_ &= 0xFFFFFFDF;
                this.varargElementTypeId_ = 0;
                return this;
            }
        }
    }

    public static interface ValueParameterOrBuilder
    extends GeneratedMessageLite.ExtendableMessageOrBuilder<ValueParameter> {
        public boolean hasFlags();

        public int getFlags();

        public boolean hasName();

        public int getName();

        public boolean hasType();

        public Type getType();

        public boolean hasTypeId();

        public int getTypeId();

        public boolean hasVarargElementType();

        public Type getVarargElementType();

        public boolean hasVarargElementTypeId();

        public int getVarargElementTypeId();
    }

    public static final class Property
    extends GeneratedMessageLite.ExtendableMessage<Property>
    implements PropertyOrBuilder {
        private static final Property defaultInstance;
        private final ByteString unknownFields;
        public static Parser<Property> PARSER;
        private int bitField0_;
        public static final int FLAGS_FIELD_NUMBER = 11;
        private int flags_;
        public static final int OLD_FLAGS_FIELD_NUMBER = 1;
        private int oldFlags_;
        public static final int NAME_FIELD_NUMBER = 2;
        private int name_;
        public static final int RETURN_TYPE_FIELD_NUMBER = 3;
        private Type returnType_;
        public static final int RETURN_TYPE_ID_FIELD_NUMBER = 9;
        private int returnTypeId_;
        public static final int TYPE_PARAMETER_FIELD_NUMBER = 4;
        private List<TypeParameter> typeParameter_;
        public static final int RECEIVER_TYPE_FIELD_NUMBER = 5;
        private Type receiverType_;
        public static final int RECEIVER_TYPE_ID_FIELD_NUMBER = 10;
        private int receiverTypeId_;
        public static final int SETTER_VALUE_PARAMETER_FIELD_NUMBER = 6;
        private ValueParameter setterValueParameter_;
        public static final int GETTER_FLAGS_FIELD_NUMBER = 7;
        private int getterFlags_;
        public static final int SETTER_FLAGS_FIELD_NUMBER = 8;
        private int setterFlags_;
        public static final int SINCEKOTLININFO_FIELD_NUMBER = 31;
        private int sinceKotlinInfo_;
        private byte memoizedIsInitialized = (byte)-1;
        private int memoizedSerializedSize = -1;
        private static final long serialVersionUID = 0L;

        private Property(GeneratedMessageLite.ExtendableBuilder<Property, ?> builder) {
            super(builder);
            this.unknownFields = builder.getUnknownFields();
        }

        private Property(boolean noInit) {
            this.unknownFields = ByteString.EMPTY;
        }

        public static Property getDefaultInstance() {
            return defaultInstance;
        }

        @Override
        public Property getDefaultInstanceForType() {
            return defaultInstance;
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        private Property(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            this.initFields();
            int mutable_bitField0_ = 0;
            ByteString.Output unknownFieldsOutput = ByteString.newOutput();
            CodedOutputStream unknownFieldsCodedOutput = CodedOutputStream.newInstance(unknownFieldsOutput);
            try {
                boolean done = false;
                block30: while (!done) {
                    int tag = input.readTag();
                    switch (tag) {
                        case 0: {
                            done = true;
                            continue block30;
                        }
                        default: {
                            if (this.parseUnknownField(input, unknownFieldsCodedOutput, extensionRegistry, tag)) continue block30;
                            done = true;
                            continue block30;
                        }
                        case 8: {
                            this.bitField0_ |= 2;
                            this.oldFlags_ = input.readInt32();
                            continue block30;
                        }
                        case 16: {
                            this.bitField0_ |= 4;
                            this.name_ = input.readInt32();
                            continue block30;
                        }
                        case 26: {
                            GeneratedMessageLite.ExtendableBuilder subBuilder = null;
                            if ((this.bitField0_ & 8) == 8) {
                                subBuilder = this.returnType_.toBuilder();
                            }
                            this.returnType_ = input.readMessage(Type.PARSER, extensionRegistry);
                            if (subBuilder != null) {
                                ((Type.Builder)subBuilder).mergeFrom(this.returnType_);
                                this.returnType_ = ((Type.Builder)subBuilder).buildPartial();
                            }
                            this.bitField0_ |= 8;
                            continue block30;
                        }
                        case 34: {
                            if ((mutable_bitField0_ & 0x20) != 32) {
                                this.typeParameter_ = new ArrayList<TypeParameter>();
                                mutable_bitField0_ |= 0x20;
                            }
                            this.typeParameter_.add(input.readMessage(TypeParameter.PARSER, extensionRegistry));
                            continue block30;
                        }
                        case 42: {
                            GeneratedMessageLite.ExtendableBuilder subBuilder = null;
                            if ((this.bitField0_ & 0x20) == 32) {
                                subBuilder = this.receiverType_.toBuilder();
                            }
                            this.receiverType_ = input.readMessage(Type.PARSER, extensionRegistry);
                            if (subBuilder != null) {
                                ((Type.Builder)subBuilder).mergeFrom(this.receiverType_);
                                this.receiverType_ = ((Type.Builder)subBuilder).buildPartial();
                            }
                            this.bitField0_ |= 0x20;
                            continue block30;
                        }
                        case 50: {
                            GeneratedMessageLite.ExtendableBuilder subBuilder = null;
                            if ((this.bitField0_ & 0x80) == 128) {
                                subBuilder = this.setterValueParameter_.toBuilder();
                            }
                            this.setterValueParameter_ = input.readMessage(ValueParameter.PARSER, extensionRegistry);
                            if (subBuilder != null) {
                                ((ValueParameter.Builder)subBuilder).mergeFrom(this.setterValueParameter_);
                                this.setterValueParameter_ = ((ValueParameter.Builder)subBuilder).buildPartial();
                            }
                            this.bitField0_ |= 0x80;
                            continue block30;
                        }
                        case 56: {
                            this.bitField0_ |= 0x100;
                            this.getterFlags_ = input.readInt32();
                            continue block30;
                        }
                        case 64: {
                            this.bitField0_ |= 0x200;
                            this.setterFlags_ = input.readInt32();
                            continue block30;
                        }
                        case 72: {
                            this.bitField0_ |= 0x10;
                            this.returnTypeId_ = input.readInt32();
                            continue block30;
                        }
                        case 80: {
                            this.bitField0_ |= 0x40;
                            this.receiverTypeId_ = input.readInt32();
                            continue block30;
                        }
                        case 88: {
                            this.bitField0_ |= 1;
                            this.flags_ = input.readInt32();
                            continue block30;
                        }
                        case 248: 
                    }
                    this.bitField0_ |= 0x400;
                    this.sinceKotlinInfo_ = input.readInt32();
                }
            }
            catch (InvalidProtocolBufferException e) {
                throw e.setUnfinishedMessage(this);
            }
            catch (IOException e) {
                throw new InvalidProtocolBufferException(e.getMessage()).setUnfinishedMessage(this);
            }
            finally {
                if ((mutable_bitField0_ & 0x20) == 32) {
                    this.typeParameter_ = Collections.unmodifiableList(this.typeParameter_);
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

        public Parser<Property> getParserForType() {
            return PARSER;
        }

        @Override
        public boolean hasFlags() {
            return (this.bitField0_ & 1) == 1;
        }

        @Override
        public int getFlags() {
            return this.flags_;
        }

        @Override
        public boolean hasOldFlags() {
            return (this.bitField0_ & 2) == 2;
        }

        @Override
        public int getOldFlags() {
            return this.oldFlags_;
        }

        @Override
        public boolean hasName() {
            return (this.bitField0_ & 4) == 4;
        }

        @Override
        public int getName() {
            return this.name_;
        }

        @Override
        public boolean hasReturnType() {
            return (this.bitField0_ & 8) == 8;
        }

        @Override
        public Type getReturnType() {
            return this.returnType_;
        }

        @Override
        public boolean hasReturnTypeId() {
            return (this.bitField0_ & 0x10) == 16;
        }

        @Override
        public int getReturnTypeId() {
            return this.returnTypeId_;
        }

        @Override
        public List<TypeParameter> getTypeParameterList() {
            return this.typeParameter_;
        }

        public List<? extends TypeParameterOrBuilder> getTypeParameterOrBuilderList() {
            return this.typeParameter_;
        }

        @Override
        public int getTypeParameterCount() {
            return this.typeParameter_.size();
        }

        @Override
        public TypeParameter getTypeParameter(int index) {
            return this.typeParameter_.get(index);
        }

        public TypeParameterOrBuilder getTypeParameterOrBuilder(int index) {
            return this.typeParameter_.get(index);
        }

        @Override
        public boolean hasReceiverType() {
            return (this.bitField0_ & 0x20) == 32;
        }

        @Override
        public Type getReceiverType() {
            return this.receiverType_;
        }

        @Override
        public boolean hasReceiverTypeId() {
            return (this.bitField0_ & 0x40) == 64;
        }

        @Override
        public int getReceiverTypeId() {
            return this.receiverTypeId_;
        }

        @Override
        public boolean hasSetterValueParameter() {
            return (this.bitField0_ & 0x80) == 128;
        }

        @Override
        public ValueParameter getSetterValueParameter() {
            return this.setterValueParameter_;
        }

        @Override
        public boolean hasGetterFlags() {
            return (this.bitField0_ & 0x100) == 256;
        }

        @Override
        public int getGetterFlags() {
            return this.getterFlags_;
        }

        @Override
        public boolean hasSetterFlags() {
            return (this.bitField0_ & 0x200) == 512;
        }

        @Override
        public int getSetterFlags() {
            return this.setterFlags_;
        }

        @Override
        public boolean hasSinceKotlinInfo() {
            return (this.bitField0_ & 0x400) == 1024;
        }

        @Override
        public int getSinceKotlinInfo() {
            return this.sinceKotlinInfo_;
        }

        private void initFields() {
            this.flags_ = 518;
            this.oldFlags_ = 2054;
            this.name_ = 0;
            this.returnType_ = Type.getDefaultInstance();
            this.returnTypeId_ = 0;
            this.typeParameter_ = Collections.emptyList();
            this.receiverType_ = Type.getDefaultInstance();
            this.receiverTypeId_ = 0;
            this.setterValueParameter_ = ValueParameter.getDefaultInstance();
            this.getterFlags_ = 0;
            this.setterFlags_ = 0;
            this.sinceKotlinInfo_ = 0;
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
            if (!this.hasName()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            if (this.hasReturnType() && !this.getReturnType().isInitialized()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            for (int i = 0; i < this.getTypeParameterCount(); ++i) {
                if (this.getTypeParameter(i).isInitialized()) continue;
                this.memoizedIsInitialized = 0;
                return false;
            }
            if (this.hasReceiverType() && !this.getReceiverType().isInitialized()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            if (this.hasSetterValueParameter() && !this.getSetterValueParameter().isInitialized()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            if (!this.extensionsAreInitialized()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            this.memoizedIsInitialized = 1;
            return true;
        }

        @Override
        public void writeTo(CodedOutputStream output) throws IOException {
            this.getSerializedSize();
            GeneratedMessageLite.ExtendableMessage.ExtensionWriter extensionWriter = this.newExtensionWriter();
            if ((this.bitField0_ & 2) == 2) {
                output.writeInt32(1, this.oldFlags_);
            }
            if ((this.bitField0_ & 4) == 4) {
                output.writeInt32(2, this.name_);
            }
            if ((this.bitField0_ & 8) == 8) {
                output.writeMessage(3, this.returnType_);
            }
            for (int i = 0; i < this.typeParameter_.size(); ++i) {
                output.writeMessage(4, this.typeParameter_.get(i));
            }
            if ((this.bitField0_ & 0x20) == 32) {
                output.writeMessage(5, this.receiverType_);
            }
            if ((this.bitField0_ & 0x80) == 128) {
                output.writeMessage(6, this.setterValueParameter_);
            }
            if ((this.bitField0_ & 0x100) == 256) {
                output.writeInt32(7, this.getterFlags_);
            }
            if ((this.bitField0_ & 0x200) == 512) {
                output.writeInt32(8, this.setterFlags_);
            }
            if ((this.bitField0_ & 0x10) == 16) {
                output.writeInt32(9, this.returnTypeId_);
            }
            if ((this.bitField0_ & 0x40) == 64) {
                output.writeInt32(10, this.receiverTypeId_);
            }
            if ((this.bitField0_ & 1) == 1) {
                output.writeInt32(11, this.flags_);
            }
            if ((this.bitField0_ & 0x400) == 1024) {
                output.writeInt32(31, this.sinceKotlinInfo_);
            }
            extensionWriter.writeUntil(200, output);
            output.writeRawBytes(this.unknownFields);
        }

        @Override
        public int getSerializedSize() {
            int size = this.memoizedSerializedSize;
            if (size != -1) {
                return size;
            }
            size = 0;
            if ((this.bitField0_ & 2) == 2) {
                size += CodedOutputStream.computeInt32Size(1, this.oldFlags_);
            }
            if ((this.bitField0_ & 4) == 4) {
                size += CodedOutputStream.computeInt32Size(2, this.name_);
            }
            if ((this.bitField0_ & 8) == 8) {
                size += CodedOutputStream.computeMessageSize(3, this.returnType_);
            }
            for (int i = 0; i < this.typeParameter_.size(); ++i) {
                size += CodedOutputStream.computeMessageSize(4, this.typeParameter_.get(i));
            }
            if ((this.bitField0_ & 0x20) == 32) {
                size += CodedOutputStream.computeMessageSize(5, this.receiverType_);
            }
            if ((this.bitField0_ & 0x80) == 128) {
                size += CodedOutputStream.computeMessageSize(6, this.setterValueParameter_);
            }
            if ((this.bitField0_ & 0x100) == 256) {
                size += CodedOutputStream.computeInt32Size(7, this.getterFlags_);
            }
            if ((this.bitField0_ & 0x200) == 512) {
                size += CodedOutputStream.computeInt32Size(8, this.setterFlags_);
            }
            if ((this.bitField0_ & 0x10) == 16) {
                size += CodedOutputStream.computeInt32Size(9, this.returnTypeId_);
            }
            if ((this.bitField0_ & 0x40) == 64) {
                size += CodedOutputStream.computeInt32Size(10, this.receiverTypeId_);
            }
            if ((this.bitField0_ & 1) == 1) {
                size += CodedOutputStream.computeInt32Size(11, this.flags_);
            }
            if ((this.bitField0_ & 0x400) == 1024) {
                size += CodedOutputStream.computeInt32Size(31, this.sinceKotlinInfo_);
            }
            size += this.extensionsSerializedSize();
            this.memoizedSerializedSize = size += this.unknownFields.size();
            return size;
        }

        @Override
        protected Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }

        public static Property parseFrom(ByteString data2) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data2);
        }

        public static Property parseFrom(ByteString data2, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data2, extensionRegistry);
        }

        public static Property parseFrom(byte[] data2) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data2);
        }

        public static Property parseFrom(byte[] data2, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data2, extensionRegistry);
        }

        public static Property parseFrom(InputStream input) throws IOException {
            return PARSER.parseFrom(input);
        }

        public static Property parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return PARSER.parseFrom(input, extensionRegistry);
        }

        public static Property parseDelimitedFrom(InputStream input) throws IOException {
            return PARSER.parseDelimitedFrom(input);
        }

        public static Property parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return PARSER.parseDelimitedFrom(input, extensionRegistry);
        }

        public static Property parseFrom(CodedInputStream input) throws IOException {
            return PARSER.parseFrom(input);
        }

        public static Property parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return PARSER.parseFrom(input, extensionRegistry);
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        @Override
        public Builder newBuilderForType() {
            return Property.newBuilder();
        }

        public static Builder newBuilder(Property prototype) {
            return Property.newBuilder().mergeFrom(prototype);
        }

        @Override
        public Builder toBuilder() {
            return Property.newBuilder(this);
        }

        static {
            PARSER = new AbstractParser<Property>(){

                @Override
                public Property parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                    return new Property(input, extensionRegistry);
                }
            };
            defaultInstance = new Property(true);
            defaultInstance.initFields();
        }

        public static final class Builder
        extends GeneratedMessageLite.ExtendableBuilder<Property, Builder>
        implements PropertyOrBuilder {
            private int bitField0_;
            private int flags_ = 518;
            private int oldFlags_ = 2054;
            private int name_;
            private Type returnType_ = Type.getDefaultInstance();
            private int returnTypeId_;
            private List<TypeParameter> typeParameter_ = Collections.emptyList();
            private Type receiverType_ = Type.getDefaultInstance();
            private int receiverTypeId_;
            private ValueParameter setterValueParameter_ = ValueParameter.getDefaultInstance();
            private int getterFlags_;
            private int setterFlags_;
            private int sinceKotlinInfo_;

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
                this.flags_ = 518;
                this.bitField0_ &= 0xFFFFFFFE;
                this.oldFlags_ = 2054;
                this.bitField0_ &= 0xFFFFFFFD;
                this.name_ = 0;
                this.bitField0_ &= 0xFFFFFFFB;
                this.returnType_ = Type.getDefaultInstance();
                this.bitField0_ &= 0xFFFFFFF7;
                this.returnTypeId_ = 0;
                this.bitField0_ &= 0xFFFFFFEF;
                this.typeParameter_ = Collections.emptyList();
                this.bitField0_ &= 0xFFFFFFDF;
                this.receiverType_ = Type.getDefaultInstance();
                this.bitField0_ &= 0xFFFFFFBF;
                this.receiverTypeId_ = 0;
                this.bitField0_ &= 0xFFFFFF7F;
                this.setterValueParameter_ = ValueParameter.getDefaultInstance();
                this.bitField0_ &= 0xFFFFFEFF;
                this.getterFlags_ = 0;
                this.bitField0_ &= 0xFFFFFDFF;
                this.setterFlags_ = 0;
                this.bitField0_ &= 0xFFFFFBFF;
                this.sinceKotlinInfo_ = 0;
                this.bitField0_ &= 0xFFFFF7FF;
                return this;
            }

            @Override
            public Builder clone() {
                return Builder.create().mergeFrom(this.buildPartial());
            }

            @Override
            public Property getDefaultInstanceForType() {
                return Property.getDefaultInstance();
            }

            @Override
            public Property build() {
                Property result2 = this.buildPartial();
                if (!result2.isInitialized()) {
                    throw Builder.newUninitializedMessageException(result2);
                }
                return result2;
            }

            @Override
            public Property buildPartial() {
                Property result2 = new Property(this);
                int from_bitField0_ = this.bitField0_;
                int to_bitField0_ = 0;
                if ((from_bitField0_ & 1) == 1) {
                    to_bitField0_ |= 1;
                }
                result2.flags_ = this.flags_;
                if ((from_bitField0_ & 2) == 2) {
                    to_bitField0_ |= 2;
                }
                result2.oldFlags_ = this.oldFlags_;
                if ((from_bitField0_ & 4) == 4) {
                    to_bitField0_ |= 4;
                }
                result2.name_ = this.name_;
                if ((from_bitField0_ & 8) == 8) {
                    to_bitField0_ |= 8;
                }
                result2.returnType_ = this.returnType_;
                if ((from_bitField0_ & 0x10) == 16) {
                    to_bitField0_ |= 0x10;
                }
                result2.returnTypeId_ = this.returnTypeId_;
                if ((this.bitField0_ & 0x20) == 32) {
                    this.typeParameter_ = Collections.unmodifiableList(this.typeParameter_);
                    this.bitField0_ &= 0xFFFFFFDF;
                }
                result2.typeParameter_ = this.typeParameter_;
                if ((from_bitField0_ & 0x40) == 64) {
                    to_bitField0_ |= 0x20;
                }
                result2.receiverType_ = this.receiverType_;
                if ((from_bitField0_ & 0x80) == 128) {
                    to_bitField0_ |= 0x40;
                }
                result2.receiverTypeId_ = this.receiverTypeId_;
                if ((from_bitField0_ & 0x100) == 256) {
                    to_bitField0_ |= 0x80;
                }
                result2.setterValueParameter_ = this.setterValueParameter_;
                if ((from_bitField0_ & 0x200) == 512) {
                    to_bitField0_ |= 0x100;
                }
                result2.getterFlags_ = this.getterFlags_;
                if ((from_bitField0_ & 0x400) == 1024) {
                    to_bitField0_ |= 0x200;
                }
                result2.setterFlags_ = this.setterFlags_;
                if ((from_bitField0_ & 0x800) == 2048) {
                    to_bitField0_ |= 0x400;
                }
                result2.sinceKotlinInfo_ = this.sinceKotlinInfo_;
                result2.bitField0_ = to_bitField0_;
                return result2;
            }

            @Override
            public Builder mergeFrom(Property other) {
                if (other == Property.getDefaultInstance()) {
                    return this;
                }
                if (other.hasFlags()) {
                    this.setFlags(other.getFlags());
                }
                if (other.hasOldFlags()) {
                    this.setOldFlags(other.getOldFlags());
                }
                if (other.hasName()) {
                    this.setName(other.getName());
                }
                if (other.hasReturnType()) {
                    this.mergeReturnType(other.getReturnType());
                }
                if (other.hasReturnTypeId()) {
                    this.setReturnTypeId(other.getReturnTypeId());
                }
                if (!other.typeParameter_.isEmpty()) {
                    if (this.typeParameter_.isEmpty()) {
                        this.typeParameter_ = other.typeParameter_;
                        this.bitField0_ &= 0xFFFFFFDF;
                    } else {
                        this.ensureTypeParameterIsMutable();
                        this.typeParameter_.addAll(other.typeParameter_);
                    }
                }
                if (other.hasReceiverType()) {
                    this.mergeReceiverType(other.getReceiverType());
                }
                if (other.hasReceiverTypeId()) {
                    this.setReceiverTypeId(other.getReceiverTypeId());
                }
                if (other.hasSetterValueParameter()) {
                    this.mergeSetterValueParameter(other.getSetterValueParameter());
                }
                if (other.hasGetterFlags()) {
                    this.setGetterFlags(other.getGetterFlags());
                }
                if (other.hasSetterFlags()) {
                    this.setSetterFlags(other.getSetterFlags());
                }
                if (other.hasSinceKotlinInfo()) {
                    this.setSinceKotlinInfo(other.getSinceKotlinInfo());
                }
                this.mergeExtensionFields(other);
                this.setUnknownFields(this.getUnknownFields().concat(other.unknownFields));
                return this;
            }

            @Override
            public final boolean isInitialized() {
                if (!this.hasName()) {
                    return false;
                }
                if (this.hasReturnType() && !this.getReturnType().isInitialized()) {
                    return false;
                }
                for (int i = 0; i < this.getTypeParameterCount(); ++i) {
                    if (this.getTypeParameter(i).isInitialized()) continue;
                    return false;
                }
                if (this.hasReceiverType() && !this.getReceiverType().isInitialized()) {
                    return false;
                }
                if (this.hasSetterValueParameter() && !this.getSetterValueParameter().isInitialized()) {
                    return false;
                }
                return this.extensionsAreInitialized();
            }

            @Override
            public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                Property parsedMessage = null;
                try {
                    parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
                }
                catch (InvalidProtocolBufferException e) {
                    parsedMessage = (Property)e.getUnfinishedMessage();
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
            public boolean hasFlags() {
                return (this.bitField0_ & 1) == 1;
            }

            @Override
            public int getFlags() {
                return this.flags_;
            }

            public Builder setFlags(int value) {
                this.bitField0_ |= 1;
                this.flags_ = value;
                return this;
            }

            public Builder clearFlags() {
                this.bitField0_ &= 0xFFFFFFFE;
                this.flags_ = 518;
                return this;
            }

            @Override
            public boolean hasOldFlags() {
                return (this.bitField0_ & 2) == 2;
            }

            @Override
            public int getOldFlags() {
                return this.oldFlags_;
            }

            public Builder setOldFlags(int value) {
                this.bitField0_ |= 2;
                this.oldFlags_ = value;
                return this;
            }

            public Builder clearOldFlags() {
                this.bitField0_ &= 0xFFFFFFFD;
                this.oldFlags_ = 2054;
                return this;
            }

            @Override
            public boolean hasName() {
                return (this.bitField0_ & 4) == 4;
            }

            @Override
            public int getName() {
                return this.name_;
            }

            public Builder setName(int value) {
                this.bitField0_ |= 4;
                this.name_ = value;
                return this;
            }

            public Builder clearName() {
                this.bitField0_ &= 0xFFFFFFFB;
                this.name_ = 0;
                return this;
            }

            @Override
            public boolean hasReturnType() {
                return (this.bitField0_ & 8) == 8;
            }

            @Override
            public Type getReturnType() {
                return this.returnType_;
            }

            public Builder setReturnType(Type value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.returnType_ = value;
                this.bitField0_ |= 8;
                return this;
            }

            public Builder setReturnType(Type.Builder builderForValue) {
                this.returnType_ = builderForValue.build();
                this.bitField0_ |= 8;
                return this;
            }

            public Builder mergeReturnType(Type value) {
                this.returnType_ = (this.bitField0_ & 8) == 8 && this.returnType_ != Type.getDefaultInstance() ? Type.newBuilder(this.returnType_).mergeFrom(value).buildPartial() : value;
                this.bitField0_ |= 8;
                return this;
            }

            public Builder clearReturnType() {
                this.returnType_ = Type.getDefaultInstance();
                this.bitField0_ &= 0xFFFFFFF7;
                return this;
            }

            @Override
            public boolean hasReturnTypeId() {
                return (this.bitField0_ & 0x10) == 16;
            }

            @Override
            public int getReturnTypeId() {
                return this.returnTypeId_;
            }

            public Builder setReturnTypeId(int value) {
                this.bitField0_ |= 0x10;
                this.returnTypeId_ = value;
                return this;
            }

            public Builder clearReturnTypeId() {
                this.bitField0_ &= 0xFFFFFFEF;
                this.returnTypeId_ = 0;
                return this;
            }

            private void ensureTypeParameterIsMutable() {
                if ((this.bitField0_ & 0x20) != 32) {
                    this.typeParameter_ = new ArrayList<TypeParameter>(this.typeParameter_);
                    this.bitField0_ |= 0x20;
                }
            }

            @Override
            public List<TypeParameter> getTypeParameterList() {
                return Collections.unmodifiableList(this.typeParameter_);
            }

            @Override
            public int getTypeParameterCount() {
                return this.typeParameter_.size();
            }

            @Override
            public TypeParameter getTypeParameter(int index) {
                return this.typeParameter_.get(index);
            }

            public Builder setTypeParameter(int index, TypeParameter value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.ensureTypeParameterIsMutable();
                this.typeParameter_.set(index, value);
                return this;
            }

            public Builder setTypeParameter(int index, TypeParameter.Builder builderForValue) {
                this.ensureTypeParameterIsMutable();
                this.typeParameter_.set(index, builderForValue.build());
                return this;
            }

            public Builder addTypeParameter(TypeParameter value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.ensureTypeParameterIsMutable();
                this.typeParameter_.add(value);
                return this;
            }

            public Builder addTypeParameter(int index, TypeParameter value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.ensureTypeParameterIsMutable();
                this.typeParameter_.add(index, value);
                return this;
            }

            public Builder addTypeParameter(TypeParameter.Builder builderForValue) {
                this.ensureTypeParameterIsMutable();
                this.typeParameter_.add(builderForValue.build());
                return this;
            }

            public Builder addTypeParameter(int index, TypeParameter.Builder builderForValue) {
                this.ensureTypeParameterIsMutable();
                this.typeParameter_.add(index, builderForValue.build());
                return this;
            }

            public Builder addAllTypeParameter(Iterable<? extends TypeParameter> values2) {
                this.ensureTypeParameterIsMutable();
                AbstractMessageLite.Builder.addAll(values2, this.typeParameter_);
                return this;
            }

            public Builder clearTypeParameter() {
                this.typeParameter_ = Collections.emptyList();
                this.bitField0_ &= 0xFFFFFFDF;
                return this;
            }

            public Builder removeTypeParameter(int index) {
                this.ensureTypeParameterIsMutable();
                this.typeParameter_.remove(index);
                return this;
            }

            @Override
            public boolean hasReceiverType() {
                return (this.bitField0_ & 0x40) == 64;
            }

            @Override
            public Type getReceiverType() {
                return this.receiverType_;
            }

            public Builder setReceiverType(Type value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.receiverType_ = value;
                this.bitField0_ |= 0x40;
                return this;
            }

            public Builder setReceiverType(Type.Builder builderForValue) {
                this.receiverType_ = builderForValue.build();
                this.bitField0_ |= 0x40;
                return this;
            }

            public Builder mergeReceiverType(Type value) {
                this.receiverType_ = (this.bitField0_ & 0x40) == 64 && this.receiverType_ != Type.getDefaultInstance() ? Type.newBuilder(this.receiverType_).mergeFrom(value).buildPartial() : value;
                this.bitField0_ |= 0x40;
                return this;
            }

            public Builder clearReceiverType() {
                this.receiverType_ = Type.getDefaultInstance();
                this.bitField0_ &= 0xFFFFFFBF;
                return this;
            }

            @Override
            public boolean hasReceiverTypeId() {
                return (this.bitField0_ & 0x80) == 128;
            }

            @Override
            public int getReceiverTypeId() {
                return this.receiverTypeId_;
            }

            public Builder setReceiverTypeId(int value) {
                this.bitField0_ |= 0x80;
                this.receiverTypeId_ = value;
                return this;
            }

            public Builder clearReceiverTypeId() {
                this.bitField0_ &= 0xFFFFFF7F;
                this.receiverTypeId_ = 0;
                return this;
            }

            @Override
            public boolean hasSetterValueParameter() {
                return (this.bitField0_ & 0x100) == 256;
            }

            @Override
            public ValueParameter getSetterValueParameter() {
                return this.setterValueParameter_;
            }

            public Builder setSetterValueParameter(ValueParameter value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.setterValueParameter_ = value;
                this.bitField0_ |= 0x100;
                return this;
            }

            public Builder setSetterValueParameter(ValueParameter.Builder builderForValue) {
                this.setterValueParameter_ = builderForValue.build();
                this.bitField0_ |= 0x100;
                return this;
            }

            public Builder mergeSetterValueParameter(ValueParameter value) {
                this.setterValueParameter_ = (this.bitField0_ & 0x100) == 256 && this.setterValueParameter_ != ValueParameter.getDefaultInstance() ? ValueParameter.newBuilder(this.setterValueParameter_).mergeFrom(value).buildPartial() : value;
                this.bitField0_ |= 0x100;
                return this;
            }

            public Builder clearSetterValueParameter() {
                this.setterValueParameter_ = ValueParameter.getDefaultInstance();
                this.bitField0_ &= 0xFFFFFEFF;
                return this;
            }

            @Override
            public boolean hasGetterFlags() {
                return (this.bitField0_ & 0x200) == 512;
            }

            @Override
            public int getGetterFlags() {
                return this.getterFlags_;
            }

            public Builder setGetterFlags(int value) {
                this.bitField0_ |= 0x200;
                this.getterFlags_ = value;
                return this;
            }

            public Builder clearGetterFlags() {
                this.bitField0_ &= 0xFFFFFDFF;
                this.getterFlags_ = 0;
                return this;
            }

            @Override
            public boolean hasSetterFlags() {
                return (this.bitField0_ & 0x400) == 1024;
            }

            @Override
            public int getSetterFlags() {
                return this.setterFlags_;
            }

            public Builder setSetterFlags(int value) {
                this.bitField0_ |= 0x400;
                this.setterFlags_ = value;
                return this;
            }

            public Builder clearSetterFlags() {
                this.bitField0_ &= 0xFFFFFBFF;
                this.setterFlags_ = 0;
                return this;
            }

            @Override
            public boolean hasSinceKotlinInfo() {
                return (this.bitField0_ & 0x800) == 2048;
            }

            @Override
            public int getSinceKotlinInfo() {
                return this.sinceKotlinInfo_;
            }

            public Builder setSinceKotlinInfo(int value) {
                this.bitField0_ |= 0x800;
                this.sinceKotlinInfo_ = value;
                return this;
            }

            public Builder clearSinceKotlinInfo() {
                this.bitField0_ &= 0xFFFFF7FF;
                this.sinceKotlinInfo_ = 0;
                return this;
            }
        }
    }

    public static interface PropertyOrBuilder
    extends GeneratedMessageLite.ExtendableMessageOrBuilder<Property> {
        public boolean hasFlags();

        public int getFlags();

        public boolean hasOldFlags();

        public int getOldFlags();

        public boolean hasName();

        public int getName();

        public boolean hasReturnType();

        public Type getReturnType();

        public boolean hasReturnTypeId();

        public int getReturnTypeId();

        public List<TypeParameter> getTypeParameterList();

        public TypeParameter getTypeParameter(int var1);

        public int getTypeParameterCount();

        public boolean hasReceiverType();

        public Type getReceiverType();

        public boolean hasReceiverTypeId();

        public int getReceiverTypeId();

        public boolean hasSetterValueParameter();

        public ValueParameter getSetterValueParameter();

        public boolean hasGetterFlags();

        public int getGetterFlags();

        public boolean hasSetterFlags();

        public int getSetterFlags();

        public boolean hasSinceKotlinInfo();

        public int getSinceKotlinInfo();
    }

    public static final class Function
    extends GeneratedMessageLite.ExtendableMessage<Function>
    implements FunctionOrBuilder {
        private static final Function defaultInstance;
        private final ByteString unknownFields;
        public static Parser<Function> PARSER;
        private int bitField0_;
        public static final int FLAGS_FIELD_NUMBER = 9;
        private int flags_;
        public static final int OLD_FLAGS_FIELD_NUMBER = 1;
        private int oldFlags_;
        public static final int NAME_FIELD_NUMBER = 2;
        private int name_;
        public static final int RETURN_TYPE_FIELD_NUMBER = 3;
        private Type returnType_;
        public static final int RETURN_TYPE_ID_FIELD_NUMBER = 7;
        private int returnTypeId_;
        public static final int TYPE_PARAMETER_FIELD_NUMBER = 4;
        private List<TypeParameter> typeParameter_;
        public static final int RECEIVER_TYPE_FIELD_NUMBER = 5;
        private Type receiverType_;
        public static final int RECEIVER_TYPE_ID_FIELD_NUMBER = 8;
        private int receiverTypeId_;
        public static final int VALUE_PARAMETER_FIELD_NUMBER = 6;
        private List<ValueParameter> valueParameter_;
        public static final int TYPE_TABLE_FIELD_NUMBER = 30;
        private TypeTable typeTable_;
        public static final int SINCEKOTLININFO_FIELD_NUMBER = 31;
        private int sinceKotlinInfo_;
        private byte memoizedIsInitialized = (byte)-1;
        private int memoizedSerializedSize = -1;
        private static final long serialVersionUID = 0L;

        private Function(GeneratedMessageLite.ExtendableBuilder<Function, ?> builder) {
            super(builder);
            this.unknownFields = builder.getUnknownFields();
        }

        private Function(boolean noInit) {
            this.unknownFields = ByteString.EMPTY;
        }

        public static Function getDefaultInstance() {
            return defaultInstance;
        }

        @Override
        public Function getDefaultInstanceForType() {
            return defaultInstance;
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        private Function(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            this.initFields();
            int mutable_bitField0_ = 0;
            ByteString.Output unknownFieldsOutput = ByteString.newOutput();
            CodedOutputStream unknownFieldsCodedOutput = CodedOutputStream.newInstance(unknownFieldsOutput);
            try {
                boolean done = false;
                block29: while (!done) {
                    int tag = input.readTag();
                    switch (tag) {
                        case 0: {
                            done = true;
                            continue block29;
                        }
                        default: {
                            if (this.parseUnknownField(input, unknownFieldsCodedOutput, extensionRegistry, tag)) continue block29;
                            done = true;
                            continue block29;
                        }
                        case 8: {
                            this.bitField0_ |= 2;
                            this.oldFlags_ = input.readInt32();
                            continue block29;
                        }
                        case 16: {
                            this.bitField0_ |= 4;
                            this.name_ = input.readInt32();
                            continue block29;
                        }
                        case 26: {
                            GeneratedMessageLite.Builder subBuilder = null;
                            if ((this.bitField0_ & 8) == 8) {
                                subBuilder = this.returnType_.toBuilder();
                            }
                            this.returnType_ = input.readMessage(Type.PARSER, extensionRegistry);
                            if (subBuilder != null) {
                                ((Type.Builder)subBuilder).mergeFrom(this.returnType_);
                                this.returnType_ = ((Type.Builder)subBuilder).buildPartial();
                            }
                            this.bitField0_ |= 8;
                            continue block29;
                        }
                        case 34: {
                            if ((mutable_bitField0_ & 0x20) != 32) {
                                this.typeParameter_ = new ArrayList<TypeParameter>();
                                mutable_bitField0_ |= 0x20;
                            }
                            this.typeParameter_.add(input.readMessage(TypeParameter.PARSER, extensionRegistry));
                            continue block29;
                        }
                        case 42: {
                            GeneratedMessageLite.Builder subBuilder = null;
                            if ((this.bitField0_ & 0x20) == 32) {
                                subBuilder = this.receiverType_.toBuilder();
                            }
                            this.receiverType_ = input.readMessage(Type.PARSER, extensionRegistry);
                            if (subBuilder != null) {
                                ((Type.Builder)subBuilder).mergeFrom(this.receiverType_);
                                this.receiverType_ = ((Type.Builder)subBuilder).buildPartial();
                            }
                            this.bitField0_ |= 0x20;
                            continue block29;
                        }
                        case 50: {
                            if ((mutable_bitField0_ & 0x100) != 256) {
                                this.valueParameter_ = new ArrayList<ValueParameter>();
                                mutable_bitField0_ |= 0x100;
                            }
                            this.valueParameter_.add(input.readMessage(ValueParameter.PARSER, extensionRegistry));
                            continue block29;
                        }
                        case 56: {
                            this.bitField0_ |= 0x10;
                            this.returnTypeId_ = input.readInt32();
                            continue block29;
                        }
                        case 64: {
                            this.bitField0_ |= 0x40;
                            this.receiverTypeId_ = input.readInt32();
                            continue block29;
                        }
                        case 72: {
                            this.bitField0_ |= 1;
                            this.flags_ = input.readInt32();
                            continue block29;
                        }
                        case 242: {
                            GeneratedMessageLite.Builder subBuilder = null;
                            if ((this.bitField0_ & 0x80) == 128) {
                                subBuilder = this.typeTable_.toBuilder();
                            }
                            this.typeTable_ = input.readMessage(TypeTable.PARSER, extensionRegistry);
                            if (subBuilder != null) {
                                ((TypeTable.Builder)subBuilder).mergeFrom(this.typeTable_);
                                this.typeTable_ = ((TypeTable.Builder)subBuilder).buildPartial();
                            }
                            this.bitField0_ |= 0x80;
                            continue block29;
                        }
                        case 248: 
                    }
                    this.bitField0_ |= 0x100;
                    this.sinceKotlinInfo_ = input.readInt32();
                }
            }
            catch (InvalidProtocolBufferException e) {
                throw e.setUnfinishedMessage(this);
            }
            catch (IOException e) {
                throw new InvalidProtocolBufferException(e.getMessage()).setUnfinishedMessage(this);
            }
            finally {
                if ((mutable_bitField0_ & 0x20) == 32) {
                    this.typeParameter_ = Collections.unmodifiableList(this.typeParameter_);
                }
                if ((mutable_bitField0_ & 0x100) == 256) {
                    this.valueParameter_ = Collections.unmodifiableList(this.valueParameter_);
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

        public Parser<Function> getParserForType() {
            return PARSER;
        }

        @Override
        public boolean hasFlags() {
            return (this.bitField0_ & 1) == 1;
        }

        @Override
        public int getFlags() {
            return this.flags_;
        }

        @Override
        public boolean hasOldFlags() {
            return (this.bitField0_ & 2) == 2;
        }

        @Override
        public int getOldFlags() {
            return this.oldFlags_;
        }

        @Override
        public boolean hasName() {
            return (this.bitField0_ & 4) == 4;
        }

        @Override
        public int getName() {
            return this.name_;
        }

        @Override
        public boolean hasReturnType() {
            return (this.bitField0_ & 8) == 8;
        }

        @Override
        public Type getReturnType() {
            return this.returnType_;
        }

        @Override
        public boolean hasReturnTypeId() {
            return (this.bitField0_ & 0x10) == 16;
        }

        @Override
        public int getReturnTypeId() {
            return this.returnTypeId_;
        }

        @Override
        public List<TypeParameter> getTypeParameterList() {
            return this.typeParameter_;
        }

        public List<? extends TypeParameterOrBuilder> getTypeParameterOrBuilderList() {
            return this.typeParameter_;
        }

        @Override
        public int getTypeParameterCount() {
            return this.typeParameter_.size();
        }

        @Override
        public TypeParameter getTypeParameter(int index) {
            return this.typeParameter_.get(index);
        }

        public TypeParameterOrBuilder getTypeParameterOrBuilder(int index) {
            return this.typeParameter_.get(index);
        }

        @Override
        public boolean hasReceiverType() {
            return (this.bitField0_ & 0x20) == 32;
        }

        @Override
        public Type getReceiverType() {
            return this.receiverType_;
        }

        @Override
        public boolean hasReceiverTypeId() {
            return (this.bitField0_ & 0x40) == 64;
        }

        @Override
        public int getReceiverTypeId() {
            return this.receiverTypeId_;
        }

        @Override
        public List<ValueParameter> getValueParameterList() {
            return this.valueParameter_;
        }

        public List<? extends ValueParameterOrBuilder> getValueParameterOrBuilderList() {
            return this.valueParameter_;
        }

        @Override
        public int getValueParameterCount() {
            return this.valueParameter_.size();
        }

        @Override
        public ValueParameter getValueParameter(int index) {
            return this.valueParameter_.get(index);
        }

        public ValueParameterOrBuilder getValueParameterOrBuilder(int index) {
            return this.valueParameter_.get(index);
        }

        @Override
        public boolean hasTypeTable() {
            return (this.bitField0_ & 0x80) == 128;
        }

        @Override
        public TypeTable getTypeTable() {
            return this.typeTable_;
        }

        @Override
        public boolean hasSinceKotlinInfo() {
            return (this.bitField0_ & 0x100) == 256;
        }

        @Override
        public int getSinceKotlinInfo() {
            return this.sinceKotlinInfo_;
        }

        private void initFields() {
            this.flags_ = 6;
            this.oldFlags_ = 6;
            this.name_ = 0;
            this.returnType_ = Type.getDefaultInstance();
            this.returnTypeId_ = 0;
            this.typeParameter_ = Collections.emptyList();
            this.receiverType_ = Type.getDefaultInstance();
            this.receiverTypeId_ = 0;
            this.valueParameter_ = Collections.emptyList();
            this.typeTable_ = TypeTable.getDefaultInstance();
            this.sinceKotlinInfo_ = 0;
        }

        @Override
        public final boolean isInitialized() {
            int i;
            byte isInitialized = this.memoizedIsInitialized;
            if (isInitialized == 1) {
                return true;
            }
            if (isInitialized == 0) {
                return false;
            }
            if (!this.hasName()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            if (this.hasReturnType() && !this.getReturnType().isInitialized()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            for (i = 0; i < this.getTypeParameterCount(); ++i) {
                if (this.getTypeParameter(i).isInitialized()) continue;
                this.memoizedIsInitialized = 0;
                return false;
            }
            if (this.hasReceiverType() && !this.getReceiverType().isInitialized()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            for (i = 0; i < this.getValueParameterCount(); ++i) {
                if (this.getValueParameter(i).isInitialized()) continue;
                this.memoizedIsInitialized = 0;
                return false;
            }
            if (this.hasTypeTable() && !this.getTypeTable().isInitialized()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            if (!this.extensionsAreInitialized()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            this.memoizedIsInitialized = 1;
            return true;
        }

        @Override
        public void writeTo(CodedOutputStream output) throws IOException {
            int i;
            this.getSerializedSize();
            GeneratedMessageLite.ExtendableMessage.ExtensionWriter extensionWriter = this.newExtensionWriter();
            if ((this.bitField0_ & 2) == 2) {
                output.writeInt32(1, this.oldFlags_);
            }
            if ((this.bitField0_ & 4) == 4) {
                output.writeInt32(2, this.name_);
            }
            if ((this.bitField0_ & 8) == 8) {
                output.writeMessage(3, this.returnType_);
            }
            for (i = 0; i < this.typeParameter_.size(); ++i) {
                output.writeMessage(4, this.typeParameter_.get(i));
            }
            if ((this.bitField0_ & 0x20) == 32) {
                output.writeMessage(5, this.receiverType_);
            }
            for (i = 0; i < this.valueParameter_.size(); ++i) {
                output.writeMessage(6, this.valueParameter_.get(i));
            }
            if ((this.bitField0_ & 0x10) == 16) {
                output.writeInt32(7, this.returnTypeId_);
            }
            if ((this.bitField0_ & 0x40) == 64) {
                output.writeInt32(8, this.receiverTypeId_);
            }
            if ((this.bitField0_ & 1) == 1) {
                output.writeInt32(9, this.flags_);
            }
            if ((this.bitField0_ & 0x80) == 128) {
                output.writeMessage(30, this.typeTable_);
            }
            if ((this.bitField0_ & 0x100) == 256) {
                output.writeInt32(31, this.sinceKotlinInfo_);
            }
            extensionWriter.writeUntil(200, output);
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
            if ((this.bitField0_ & 2) == 2) {
                size += CodedOutputStream.computeInt32Size(1, this.oldFlags_);
            }
            if ((this.bitField0_ & 4) == 4) {
                size += CodedOutputStream.computeInt32Size(2, this.name_);
            }
            if ((this.bitField0_ & 8) == 8) {
                size += CodedOutputStream.computeMessageSize(3, this.returnType_);
            }
            for (i = 0; i < this.typeParameter_.size(); ++i) {
                size += CodedOutputStream.computeMessageSize(4, this.typeParameter_.get(i));
            }
            if ((this.bitField0_ & 0x20) == 32) {
                size += CodedOutputStream.computeMessageSize(5, this.receiverType_);
            }
            for (i = 0; i < this.valueParameter_.size(); ++i) {
                size += CodedOutputStream.computeMessageSize(6, this.valueParameter_.get(i));
            }
            if ((this.bitField0_ & 0x10) == 16) {
                size += CodedOutputStream.computeInt32Size(7, this.returnTypeId_);
            }
            if ((this.bitField0_ & 0x40) == 64) {
                size += CodedOutputStream.computeInt32Size(8, this.receiverTypeId_);
            }
            if ((this.bitField0_ & 1) == 1) {
                size += CodedOutputStream.computeInt32Size(9, this.flags_);
            }
            if ((this.bitField0_ & 0x80) == 128) {
                size += CodedOutputStream.computeMessageSize(30, this.typeTable_);
            }
            if ((this.bitField0_ & 0x100) == 256) {
                size += CodedOutputStream.computeInt32Size(31, this.sinceKotlinInfo_);
            }
            size += this.extensionsSerializedSize();
            this.memoizedSerializedSize = size += this.unknownFields.size();
            return size;
        }

        @Override
        protected Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }

        public static Function parseFrom(ByteString data2) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data2);
        }

        public static Function parseFrom(ByteString data2, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data2, extensionRegistry);
        }

        public static Function parseFrom(byte[] data2) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data2);
        }

        public static Function parseFrom(byte[] data2, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data2, extensionRegistry);
        }

        public static Function parseFrom(InputStream input) throws IOException {
            return PARSER.parseFrom(input);
        }

        public static Function parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return PARSER.parseFrom(input, extensionRegistry);
        }

        public static Function parseDelimitedFrom(InputStream input) throws IOException {
            return PARSER.parseDelimitedFrom(input);
        }

        public static Function parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return PARSER.parseDelimitedFrom(input, extensionRegistry);
        }

        public static Function parseFrom(CodedInputStream input) throws IOException {
            return PARSER.parseFrom(input);
        }

        public static Function parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return PARSER.parseFrom(input, extensionRegistry);
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        @Override
        public Builder newBuilderForType() {
            return Function.newBuilder();
        }

        public static Builder newBuilder(Function prototype) {
            return Function.newBuilder().mergeFrom(prototype);
        }

        @Override
        public Builder toBuilder() {
            return Function.newBuilder(this);
        }

        static {
            PARSER = new AbstractParser<Function>(){

                @Override
                public Function parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                    return new Function(input, extensionRegistry);
                }
            };
            defaultInstance = new Function(true);
            defaultInstance.initFields();
        }

        public static final class Builder
        extends GeneratedMessageLite.ExtendableBuilder<Function, Builder>
        implements FunctionOrBuilder {
            private int bitField0_;
            private int flags_ = 6;
            private int oldFlags_ = 6;
            private int name_;
            private Type returnType_ = Type.getDefaultInstance();
            private int returnTypeId_;
            private List<TypeParameter> typeParameter_ = Collections.emptyList();
            private Type receiverType_ = Type.getDefaultInstance();
            private int receiverTypeId_;
            private List<ValueParameter> valueParameter_ = Collections.emptyList();
            private TypeTable typeTable_ = TypeTable.getDefaultInstance();
            private int sinceKotlinInfo_;

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
                this.flags_ = 6;
                this.bitField0_ &= 0xFFFFFFFE;
                this.oldFlags_ = 6;
                this.bitField0_ &= 0xFFFFFFFD;
                this.name_ = 0;
                this.bitField0_ &= 0xFFFFFFFB;
                this.returnType_ = Type.getDefaultInstance();
                this.bitField0_ &= 0xFFFFFFF7;
                this.returnTypeId_ = 0;
                this.bitField0_ &= 0xFFFFFFEF;
                this.typeParameter_ = Collections.emptyList();
                this.bitField0_ &= 0xFFFFFFDF;
                this.receiverType_ = Type.getDefaultInstance();
                this.bitField0_ &= 0xFFFFFFBF;
                this.receiverTypeId_ = 0;
                this.bitField0_ &= 0xFFFFFF7F;
                this.valueParameter_ = Collections.emptyList();
                this.bitField0_ &= 0xFFFFFEFF;
                this.typeTable_ = TypeTable.getDefaultInstance();
                this.bitField0_ &= 0xFFFFFDFF;
                this.sinceKotlinInfo_ = 0;
                this.bitField0_ &= 0xFFFFFBFF;
                return this;
            }

            @Override
            public Builder clone() {
                return Builder.create().mergeFrom(this.buildPartial());
            }

            @Override
            public Function getDefaultInstanceForType() {
                return Function.getDefaultInstance();
            }

            @Override
            public Function build() {
                Function result2 = this.buildPartial();
                if (!result2.isInitialized()) {
                    throw Builder.newUninitializedMessageException(result2);
                }
                return result2;
            }

            @Override
            public Function buildPartial() {
                Function result2 = new Function(this);
                int from_bitField0_ = this.bitField0_;
                int to_bitField0_ = 0;
                if ((from_bitField0_ & 1) == 1) {
                    to_bitField0_ |= 1;
                }
                result2.flags_ = this.flags_;
                if ((from_bitField0_ & 2) == 2) {
                    to_bitField0_ |= 2;
                }
                result2.oldFlags_ = this.oldFlags_;
                if ((from_bitField0_ & 4) == 4) {
                    to_bitField0_ |= 4;
                }
                result2.name_ = this.name_;
                if ((from_bitField0_ & 8) == 8) {
                    to_bitField0_ |= 8;
                }
                result2.returnType_ = this.returnType_;
                if ((from_bitField0_ & 0x10) == 16) {
                    to_bitField0_ |= 0x10;
                }
                result2.returnTypeId_ = this.returnTypeId_;
                if ((this.bitField0_ & 0x20) == 32) {
                    this.typeParameter_ = Collections.unmodifiableList(this.typeParameter_);
                    this.bitField0_ &= 0xFFFFFFDF;
                }
                result2.typeParameter_ = this.typeParameter_;
                if ((from_bitField0_ & 0x40) == 64) {
                    to_bitField0_ |= 0x20;
                }
                result2.receiverType_ = this.receiverType_;
                if ((from_bitField0_ & 0x80) == 128) {
                    to_bitField0_ |= 0x40;
                }
                result2.receiverTypeId_ = this.receiverTypeId_;
                if ((this.bitField0_ & 0x100) == 256) {
                    this.valueParameter_ = Collections.unmodifiableList(this.valueParameter_);
                    this.bitField0_ &= 0xFFFFFEFF;
                }
                result2.valueParameter_ = this.valueParameter_;
                if ((from_bitField0_ & 0x200) == 512) {
                    to_bitField0_ |= 0x80;
                }
                result2.typeTable_ = this.typeTable_;
                if ((from_bitField0_ & 0x400) == 1024) {
                    to_bitField0_ |= 0x100;
                }
                result2.sinceKotlinInfo_ = this.sinceKotlinInfo_;
                result2.bitField0_ = to_bitField0_;
                return result2;
            }

            @Override
            public Builder mergeFrom(Function other) {
                if (other == Function.getDefaultInstance()) {
                    return this;
                }
                if (other.hasFlags()) {
                    this.setFlags(other.getFlags());
                }
                if (other.hasOldFlags()) {
                    this.setOldFlags(other.getOldFlags());
                }
                if (other.hasName()) {
                    this.setName(other.getName());
                }
                if (other.hasReturnType()) {
                    this.mergeReturnType(other.getReturnType());
                }
                if (other.hasReturnTypeId()) {
                    this.setReturnTypeId(other.getReturnTypeId());
                }
                if (!other.typeParameter_.isEmpty()) {
                    if (this.typeParameter_.isEmpty()) {
                        this.typeParameter_ = other.typeParameter_;
                        this.bitField0_ &= 0xFFFFFFDF;
                    } else {
                        this.ensureTypeParameterIsMutable();
                        this.typeParameter_.addAll(other.typeParameter_);
                    }
                }
                if (other.hasReceiverType()) {
                    this.mergeReceiverType(other.getReceiverType());
                }
                if (other.hasReceiverTypeId()) {
                    this.setReceiverTypeId(other.getReceiverTypeId());
                }
                if (!other.valueParameter_.isEmpty()) {
                    if (this.valueParameter_.isEmpty()) {
                        this.valueParameter_ = other.valueParameter_;
                        this.bitField0_ &= 0xFFFFFEFF;
                    } else {
                        this.ensureValueParameterIsMutable();
                        this.valueParameter_.addAll(other.valueParameter_);
                    }
                }
                if (other.hasTypeTable()) {
                    this.mergeTypeTable(other.getTypeTable());
                }
                if (other.hasSinceKotlinInfo()) {
                    this.setSinceKotlinInfo(other.getSinceKotlinInfo());
                }
                this.mergeExtensionFields(other);
                this.setUnknownFields(this.getUnknownFields().concat(other.unknownFields));
                return this;
            }

            @Override
            public final boolean isInitialized() {
                int i;
                if (!this.hasName()) {
                    return false;
                }
                if (this.hasReturnType() && !this.getReturnType().isInitialized()) {
                    return false;
                }
                for (i = 0; i < this.getTypeParameterCount(); ++i) {
                    if (this.getTypeParameter(i).isInitialized()) continue;
                    return false;
                }
                if (this.hasReceiverType() && !this.getReceiverType().isInitialized()) {
                    return false;
                }
                for (i = 0; i < this.getValueParameterCount(); ++i) {
                    if (this.getValueParameter(i).isInitialized()) continue;
                    return false;
                }
                if (this.hasTypeTable() && !this.getTypeTable().isInitialized()) {
                    return false;
                }
                return this.extensionsAreInitialized();
            }

            @Override
            public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                Function parsedMessage = null;
                try {
                    parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
                }
                catch (InvalidProtocolBufferException e) {
                    parsedMessage = (Function)e.getUnfinishedMessage();
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
            public boolean hasFlags() {
                return (this.bitField0_ & 1) == 1;
            }

            @Override
            public int getFlags() {
                return this.flags_;
            }

            public Builder setFlags(int value) {
                this.bitField0_ |= 1;
                this.flags_ = value;
                return this;
            }

            public Builder clearFlags() {
                this.bitField0_ &= 0xFFFFFFFE;
                this.flags_ = 6;
                return this;
            }

            @Override
            public boolean hasOldFlags() {
                return (this.bitField0_ & 2) == 2;
            }

            @Override
            public int getOldFlags() {
                return this.oldFlags_;
            }

            public Builder setOldFlags(int value) {
                this.bitField0_ |= 2;
                this.oldFlags_ = value;
                return this;
            }

            public Builder clearOldFlags() {
                this.bitField0_ &= 0xFFFFFFFD;
                this.oldFlags_ = 6;
                return this;
            }

            @Override
            public boolean hasName() {
                return (this.bitField0_ & 4) == 4;
            }

            @Override
            public int getName() {
                return this.name_;
            }

            public Builder setName(int value) {
                this.bitField0_ |= 4;
                this.name_ = value;
                return this;
            }

            public Builder clearName() {
                this.bitField0_ &= 0xFFFFFFFB;
                this.name_ = 0;
                return this;
            }

            @Override
            public boolean hasReturnType() {
                return (this.bitField0_ & 8) == 8;
            }

            @Override
            public Type getReturnType() {
                return this.returnType_;
            }

            public Builder setReturnType(Type value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.returnType_ = value;
                this.bitField0_ |= 8;
                return this;
            }

            public Builder setReturnType(Type.Builder builderForValue) {
                this.returnType_ = builderForValue.build();
                this.bitField0_ |= 8;
                return this;
            }

            public Builder mergeReturnType(Type value) {
                this.returnType_ = (this.bitField0_ & 8) == 8 && this.returnType_ != Type.getDefaultInstance() ? Type.newBuilder(this.returnType_).mergeFrom(value).buildPartial() : value;
                this.bitField0_ |= 8;
                return this;
            }

            public Builder clearReturnType() {
                this.returnType_ = Type.getDefaultInstance();
                this.bitField0_ &= 0xFFFFFFF7;
                return this;
            }

            @Override
            public boolean hasReturnTypeId() {
                return (this.bitField0_ & 0x10) == 16;
            }

            @Override
            public int getReturnTypeId() {
                return this.returnTypeId_;
            }

            public Builder setReturnTypeId(int value) {
                this.bitField0_ |= 0x10;
                this.returnTypeId_ = value;
                return this;
            }

            public Builder clearReturnTypeId() {
                this.bitField0_ &= 0xFFFFFFEF;
                this.returnTypeId_ = 0;
                return this;
            }

            private void ensureTypeParameterIsMutable() {
                if ((this.bitField0_ & 0x20) != 32) {
                    this.typeParameter_ = new ArrayList<TypeParameter>(this.typeParameter_);
                    this.bitField0_ |= 0x20;
                }
            }

            @Override
            public List<TypeParameter> getTypeParameterList() {
                return Collections.unmodifiableList(this.typeParameter_);
            }

            @Override
            public int getTypeParameterCount() {
                return this.typeParameter_.size();
            }

            @Override
            public TypeParameter getTypeParameter(int index) {
                return this.typeParameter_.get(index);
            }

            public Builder setTypeParameter(int index, TypeParameter value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.ensureTypeParameterIsMutable();
                this.typeParameter_.set(index, value);
                return this;
            }

            public Builder setTypeParameter(int index, TypeParameter.Builder builderForValue) {
                this.ensureTypeParameterIsMutable();
                this.typeParameter_.set(index, builderForValue.build());
                return this;
            }

            public Builder addTypeParameter(TypeParameter value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.ensureTypeParameterIsMutable();
                this.typeParameter_.add(value);
                return this;
            }

            public Builder addTypeParameter(int index, TypeParameter value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.ensureTypeParameterIsMutable();
                this.typeParameter_.add(index, value);
                return this;
            }

            public Builder addTypeParameter(TypeParameter.Builder builderForValue) {
                this.ensureTypeParameterIsMutable();
                this.typeParameter_.add(builderForValue.build());
                return this;
            }

            public Builder addTypeParameter(int index, TypeParameter.Builder builderForValue) {
                this.ensureTypeParameterIsMutable();
                this.typeParameter_.add(index, builderForValue.build());
                return this;
            }

            public Builder addAllTypeParameter(Iterable<? extends TypeParameter> values2) {
                this.ensureTypeParameterIsMutable();
                AbstractMessageLite.Builder.addAll(values2, this.typeParameter_);
                return this;
            }

            public Builder clearTypeParameter() {
                this.typeParameter_ = Collections.emptyList();
                this.bitField0_ &= 0xFFFFFFDF;
                return this;
            }

            public Builder removeTypeParameter(int index) {
                this.ensureTypeParameterIsMutable();
                this.typeParameter_.remove(index);
                return this;
            }

            @Override
            public boolean hasReceiverType() {
                return (this.bitField0_ & 0x40) == 64;
            }

            @Override
            public Type getReceiverType() {
                return this.receiverType_;
            }

            public Builder setReceiverType(Type value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.receiverType_ = value;
                this.bitField0_ |= 0x40;
                return this;
            }

            public Builder setReceiverType(Type.Builder builderForValue) {
                this.receiverType_ = builderForValue.build();
                this.bitField0_ |= 0x40;
                return this;
            }

            public Builder mergeReceiverType(Type value) {
                this.receiverType_ = (this.bitField0_ & 0x40) == 64 && this.receiverType_ != Type.getDefaultInstance() ? Type.newBuilder(this.receiverType_).mergeFrom(value).buildPartial() : value;
                this.bitField0_ |= 0x40;
                return this;
            }

            public Builder clearReceiverType() {
                this.receiverType_ = Type.getDefaultInstance();
                this.bitField0_ &= 0xFFFFFFBF;
                return this;
            }

            @Override
            public boolean hasReceiverTypeId() {
                return (this.bitField0_ & 0x80) == 128;
            }

            @Override
            public int getReceiverTypeId() {
                return this.receiverTypeId_;
            }

            public Builder setReceiverTypeId(int value) {
                this.bitField0_ |= 0x80;
                this.receiverTypeId_ = value;
                return this;
            }

            public Builder clearReceiverTypeId() {
                this.bitField0_ &= 0xFFFFFF7F;
                this.receiverTypeId_ = 0;
                return this;
            }

            private void ensureValueParameterIsMutable() {
                if ((this.bitField0_ & 0x100) != 256) {
                    this.valueParameter_ = new ArrayList<ValueParameter>(this.valueParameter_);
                    this.bitField0_ |= 0x100;
                }
            }

            @Override
            public List<ValueParameter> getValueParameterList() {
                return Collections.unmodifiableList(this.valueParameter_);
            }

            @Override
            public int getValueParameterCount() {
                return this.valueParameter_.size();
            }

            @Override
            public ValueParameter getValueParameter(int index) {
                return this.valueParameter_.get(index);
            }

            public Builder setValueParameter(int index, ValueParameter value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.ensureValueParameterIsMutable();
                this.valueParameter_.set(index, value);
                return this;
            }

            public Builder setValueParameter(int index, ValueParameter.Builder builderForValue) {
                this.ensureValueParameterIsMutable();
                this.valueParameter_.set(index, builderForValue.build());
                return this;
            }

            public Builder addValueParameter(ValueParameter value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.ensureValueParameterIsMutable();
                this.valueParameter_.add(value);
                return this;
            }

            public Builder addValueParameter(int index, ValueParameter value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.ensureValueParameterIsMutable();
                this.valueParameter_.add(index, value);
                return this;
            }

            public Builder addValueParameter(ValueParameter.Builder builderForValue) {
                this.ensureValueParameterIsMutable();
                this.valueParameter_.add(builderForValue.build());
                return this;
            }

            public Builder addValueParameter(int index, ValueParameter.Builder builderForValue) {
                this.ensureValueParameterIsMutable();
                this.valueParameter_.add(index, builderForValue.build());
                return this;
            }

            public Builder addAllValueParameter(Iterable<? extends ValueParameter> values2) {
                this.ensureValueParameterIsMutable();
                AbstractMessageLite.Builder.addAll(values2, this.valueParameter_);
                return this;
            }

            public Builder clearValueParameter() {
                this.valueParameter_ = Collections.emptyList();
                this.bitField0_ &= 0xFFFFFEFF;
                return this;
            }

            public Builder removeValueParameter(int index) {
                this.ensureValueParameterIsMutable();
                this.valueParameter_.remove(index);
                return this;
            }

            @Override
            public boolean hasTypeTable() {
                return (this.bitField0_ & 0x200) == 512;
            }

            @Override
            public TypeTable getTypeTable() {
                return this.typeTable_;
            }

            public Builder setTypeTable(TypeTable value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.typeTable_ = value;
                this.bitField0_ |= 0x200;
                return this;
            }

            public Builder setTypeTable(TypeTable.Builder builderForValue) {
                this.typeTable_ = builderForValue.build();
                this.bitField0_ |= 0x200;
                return this;
            }

            public Builder mergeTypeTable(TypeTable value) {
                this.typeTable_ = (this.bitField0_ & 0x200) == 512 && this.typeTable_ != TypeTable.getDefaultInstance() ? TypeTable.newBuilder(this.typeTable_).mergeFrom(value).buildPartial() : value;
                this.bitField0_ |= 0x200;
                return this;
            }

            public Builder clearTypeTable() {
                this.typeTable_ = TypeTable.getDefaultInstance();
                this.bitField0_ &= 0xFFFFFDFF;
                return this;
            }

            @Override
            public boolean hasSinceKotlinInfo() {
                return (this.bitField0_ & 0x400) == 1024;
            }

            @Override
            public int getSinceKotlinInfo() {
                return this.sinceKotlinInfo_;
            }

            public Builder setSinceKotlinInfo(int value) {
                this.bitField0_ |= 0x400;
                this.sinceKotlinInfo_ = value;
                return this;
            }

            public Builder clearSinceKotlinInfo() {
                this.bitField0_ &= 0xFFFFFBFF;
                this.sinceKotlinInfo_ = 0;
                return this;
            }
        }
    }

    public static interface FunctionOrBuilder
    extends GeneratedMessageLite.ExtendableMessageOrBuilder<Function> {
        public boolean hasFlags();

        public int getFlags();

        public boolean hasOldFlags();

        public int getOldFlags();

        public boolean hasName();

        public int getName();

        public boolean hasReturnType();

        public Type getReturnType();

        public boolean hasReturnTypeId();

        public int getReturnTypeId();

        public List<TypeParameter> getTypeParameterList();

        public TypeParameter getTypeParameter(int var1);

        public int getTypeParameterCount();

        public boolean hasReceiverType();

        public Type getReceiverType();

        public boolean hasReceiverTypeId();

        public int getReceiverTypeId();

        public List<ValueParameter> getValueParameterList();

        public ValueParameter getValueParameter(int var1);

        public int getValueParameterCount();

        public boolean hasTypeTable();

        public TypeTable getTypeTable();

        public boolean hasSinceKotlinInfo();

        public int getSinceKotlinInfo();
    }

    public static final class Constructor
    extends GeneratedMessageLite.ExtendableMessage<Constructor>
    implements ConstructorOrBuilder {
        private static final Constructor defaultInstance;
        private final ByteString unknownFields;
        public static Parser<Constructor> PARSER;
        private int bitField0_;
        public static final int FLAGS_FIELD_NUMBER = 1;
        private int flags_;
        public static final int VALUE_PARAMETER_FIELD_NUMBER = 2;
        private List<ValueParameter> valueParameter_;
        public static final int SINCEKOTLININFO_FIELD_NUMBER = 31;
        private int sinceKotlinInfo_;
        private byte memoizedIsInitialized = (byte)-1;
        private int memoizedSerializedSize = -1;
        private static final long serialVersionUID = 0L;

        private Constructor(GeneratedMessageLite.ExtendableBuilder<Constructor, ?> builder) {
            super(builder);
            this.unknownFields = builder.getUnknownFields();
        }

        private Constructor(boolean noInit) {
            this.unknownFields = ByteString.EMPTY;
        }

        public static Constructor getDefaultInstance() {
            return defaultInstance;
        }

        @Override
        public Constructor getDefaultInstanceForType() {
            return defaultInstance;
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        private Constructor(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                        case 8: {
                            this.bitField0_ |= 1;
                            this.flags_ = input.readInt32();
                            continue block21;
                        }
                        case 18: {
                            if ((mutable_bitField0_ & 2) != 2) {
                                this.valueParameter_ = new ArrayList<ValueParameter>();
                                mutable_bitField0_ |= 2;
                            }
                            this.valueParameter_.add(input.readMessage(ValueParameter.PARSER, extensionRegistry));
                            continue block21;
                        }
                        case 248: 
                    }
                    this.bitField0_ |= 2;
                    this.sinceKotlinInfo_ = input.readInt32();
                }
            }
            catch (InvalidProtocolBufferException e) {
                throw e.setUnfinishedMessage(this);
            }
            catch (IOException e) {
                throw new InvalidProtocolBufferException(e.getMessage()).setUnfinishedMessage(this);
            }
            finally {
                if ((mutable_bitField0_ & 2) == 2) {
                    this.valueParameter_ = Collections.unmodifiableList(this.valueParameter_);
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

        public Parser<Constructor> getParserForType() {
            return PARSER;
        }

        @Override
        public boolean hasFlags() {
            return (this.bitField0_ & 1) == 1;
        }

        @Override
        public int getFlags() {
            return this.flags_;
        }

        @Override
        public List<ValueParameter> getValueParameterList() {
            return this.valueParameter_;
        }

        public List<? extends ValueParameterOrBuilder> getValueParameterOrBuilderList() {
            return this.valueParameter_;
        }

        @Override
        public int getValueParameterCount() {
            return this.valueParameter_.size();
        }

        @Override
        public ValueParameter getValueParameter(int index) {
            return this.valueParameter_.get(index);
        }

        public ValueParameterOrBuilder getValueParameterOrBuilder(int index) {
            return this.valueParameter_.get(index);
        }

        @Override
        public boolean hasSinceKotlinInfo() {
            return (this.bitField0_ & 2) == 2;
        }

        @Override
        public int getSinceKotlinInfo() {
            return this.sinceKotlinInfo_;
        }

        private void initFields() {
            this.flags_ = 6;
            this.valueParameter_ = Collections.emptyList();
            this.sinceKotlinInfo_ = 0;
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
            for (int i = 0; i < this.getValueParameterCount(); ++i) {
                if (this.getValueParameter(i).isInitialized()) continue;
                this.memoizedIsInitialized = 0;
                return false;
            }
            if (!this.extensionsAreInitialized()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            this.memoizedIsInitialized = 1;
            return true;
        }

        @Override
        public void writeTo(CodedOutputStream output) throws IOException {
            this.getSerializedSize();
            GeneratedMessageLite.ExtendableMessage.ExtensionWriter extensionWriter = this.newExtensionWriter();
            if ((this.bitField0_ & 1) == 1) {
                output.writeInt32(1, this.flags_);
            }
            for (int i = 0; i < this.valueParameter_.size(); ++i) {
                output.writeMessage(2, this.valueParameter_.get(i));
            }
            if ((this.bitField0_ & 2) == 2) {
                output.writeInt32(31, this.sinceKotlinInfo_);
            }
            extensionWriter.writeUntil(200, output);
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
                size += CodedOutputStream.computeInt32Size(1, this.flags_);
            }
            for (int i = 0; i < this.valueParameter_.size(); ++i) {
                size += CodedOutputStream.computeMessageSize(2, this.valueParameter_.get(i));
            }
            if ((this.bitField0_ & 2) == 2) {
                size += CodedOutputStream.computeInt32Size(31, this.sinceKotlinInfo_);
            }
            size += this.extensionsSerializedSize();
            this.memoizedSerializedSize = size += this.unknownFields.size();
            return size;
        }

        @Override
        protected Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }

        public static Constructor parseFrom(ByteString data2) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data2);
        }

        public static Constructor parseFrom(ByteString data2, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data2, extensionRegistry);
        }

        public static Constructor parseFrom(byte[] data2) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data2);
        }

        public static Constructor parseFrom(byte[] data2, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data2, extensionRegistry);
        }

        public static Constructor parseFrom(InputStream input) throws IOException {
            return PARSER.parseFrom(input);
        }

        public static Constructor parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return PARSER.parseFrom(input, extensionRegistry);
        }

        public static Constructor parseDelimitedFrom(InputStream input) throws IOException {
            return PARSER.parseDelimitedFrom(input);
        }

        public static Constructor parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return PARSER.parseDelimitedFrom(input, extensionRegistry);
        }

        public static Constructor parseFrom(CodedInputStream input) throws IOException {
            return PARSER.parseFrom(input);
        }

        public static Constructor parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return PARSER.parseFrom(input, extensionRegistry);
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        @Override
        public Builder newBuilderForType() {
            return Constructor.newBuilder();
        }

        public static Builder newBuilder(Constructor prototype) {
            return Constructor.newBuilder().mergeFrom(prototype);
        }

        @Override
        public Builder toBuilder() {
            return Constructor.newBuilder(this);
        }

        static {
            PARSER = new AbstractParser<Constructor>(){

                @Override
                public Constructor parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                    return new Constructor(input, extensionRegistry);
                }
            };
            defaultInstance = new Constructor(true);
            defaultInstance.initFields();
        }

        public static final class Builder
        extends GeneratedMessageLite.ExtendableBuilder<Constructor, Builder>
        implements ConstructorOrBuilder {
            private int bitField0_;
            private int flags_ = 6;
            private List<ValueParameter> valueParameter_ = Collections.emptyList();
            private int sinceKotlinInfo_;

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
                this.flags_ = 6;
                this.bitField0_ &= 0xFFFFFFFE;
                this.valueParameter_ = Collections.emptyList();
                this.bitField0_ &= 0xFFFFFFFD;
                this.sinceKotlinInfo_ = 0;
                this.bitField0_ &= 0xFFFFFFFB;
                return this;
            }

            @Override
            public Builder clone() {
                return Builder.create().mergeFrom(this.buildPartial());
            }

            @Override
            public Constructor getDefaultInstanceForType() {
                return Constructor.getDefaultInstance();
            }

            @Override
            public Constructor build() {
                Constructor result2 = this.buildPartial();
                if (!result2.isInitialized()) {
                    throw Builder.newUninitializedMessageException(result2);
                }
                return result2;
            }

            @Override
            public Constructor buildPartial() {
                Constructor result2 = new Constructor(this);
                int from_bitField0_ = this.bitField0_;
                int to_bitField0_ = 0;
                if ((from_bitField0_ & 1) == 1) {
                    to_bitField0_ |= 1;
                }
                result2.flags_ = this.flags_;
                if ((this.bitField0_ & 2) == 2) {
                    this.valueParameter_ = Collections.unmodifiableList(this.valueParameter_);
                    this.bitField0_ &= 0xFFFFFFFD;
                }
                result2.valueParameter_ = this.valueParameter_;
                if ((from_bitField0_ & 4) == 4) {
                    to_bitField0_ |= 2;
                }
                result2.sinceKotlinInfo_ = this.sinceKotlinInfo_;
                result2.bitField0_ = to_bitField0_;
                return result2;
            }

            @Override
            public Builder mergeFrom(Constructor other) {
                if (other == Constructor.getDefaultInstance()) {
                    return this;
                }
                if (other.hasFlags()) {
                    this.setFlags(other.getFlags());
                }
                if (!other.valueParameter_.isEmpty()) {
                    if (this.valueParameter_.isEmpty()) {
                        this.valueParameter_ = other.valueParameter_;
                        this.bitField0_ &= 0xFFFFFFFD;
                    } else {
                        this.ensureValueParameterIsMutable();
                        this.valueParameter_.addAll(other.valueParameter_);
                    }
                }
                if (other.hasSinceKotlinInfo()) {
                    this.setSinceKotlinInfo(other.getSinceKotlinInfo());
                }
                this.mergeExtensionFields(other);
                this.setUnknownFields(this.getUnknownFields().concat(other.unknownFields));
                return this;
            }

            @Override
            public final boolean isInitialized() {
                for (int i = 0; i < this.getValueParameterCount(); ++i) {
                    if (this.getValueParameter(i).isInitialized()) continue;
                    return false;
                }
                return this.extensionsAreInitialized();
            }

            @Override
            public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                Constructor parsedMessage = null;
                try {
                    parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
                }
                catch (InvalidProtocolBufferException e) {
                    parsedMessage = (Constructor)e.getUnfinishedMessage();
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
            public boolean hasFlags() {
                return (this.bitField0_ & 1) == 1;
            }

            @Override
            public int getFlags() {
                return this.flags_;
            }

            public Builder setFlags(int value) {
                this.bitField0_ |= 1;
                this.flags_ = value;
                return this;
            }

            public Builder clearFlags() {
                this.bitField0_ &= 0xFFFFFFFE;
                this.flags_ = 6;
                return this;
            }

            private void ensureValueParameterIsMutable() {
                if ((this.bitField0_ & 2) != 2) {
                    this.valueParameter_ = new ArrayList<ValueParameter>(this.valueParameter_);
                    this.bitField0_ |= 2;
                }
            }

            @Override
            public List<ValueParameter> getValueParameterList() {
                return Collections.unmodifiableList(this.valueParameter_);
            }

            @Override
            public int getValueParameterCount() {
                return this.valueParameter_.size();
            }

            @Override
            public ValueParameter getValueParameter(int index) {
                return this.valueParameter_.get(index);
            }

            public Builder setValueParameter(int index, ValueParameter value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.ensureValueParameterIsMutable();
                this.valueParameter_.set(index, value);
                return this;
            }

            public Builder setValueParameter(int index, ValueParameter.Builder builderForValue) {
                this.ensureValueParameterIsMutable();
                this.valueParameter_.set(index, builderForValue.build());
                return this;
            }

            public Builder addValueParameter(ValueParameter value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.ensureValueParameterIsMutable();
                this.valueParameter_.add(value);
                return this;
            }

            public Builder addValueParameter(int index, ValueParameter value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.ensureValueParameterIsMutable();
                this.valueParameter_.add(index, value);
                return this;
            }

            public Builder addValueParameter(ValueParameter.Builder builderForValue) {
                this.ensureValueParameterIsMutable();
                this.valueParameter_.add(builderForValue.build());
                return this;
            }

            public Builder addValueParameter(int index, ValueParameter.Builder builderForValue) {
                this.ensureValueParameterIsMutable();
                this.valueParameter_.add(index, builderForValue.build());
                return this;
            }

            public Builder addAllValueParameter(Iterable<? extends ValueParameter> values2) {
                this.ensureValueParameterIsMutable();
                AbstractMessageLite.Builder.addAll(values2, this.valueParameter_);
                return this;
            }

            public Builder clearValueParameter() {
                this.valueParameter_ = Collections.emptyList();
                this.bitField0_ &= 0xFFFFFFFD;
                return this;
            }

            public Builder removeValueParameter(int index) {
                this.ensureValueParameterIsMutable();
                this.valueParameter_.remove(index);
                return this;
            }

            @Override
            public boolean hasSinceKotlinInfo() {
                return (this.bitField0_ & 4) == 4;
            }

            @Override
            public int getSinceKotlinInfo() {
                return this.sinceKotlinInfo_;
            }

            public Builder setSinceKotlinInfo(int value) {
                this.bitField0_ |= 4;
                this.sinceKotlinInfo_ = value;
                return this;
            }

            public Builder clearSinceKotlinInfo() {
                this.bitField0_ &= 0xFFFFFFFB;
                this.sinceKotlinInfo_ = 0;
                return this;
            }
        }
    }

    public static interface ConstructorOrBuilder
    extends GeneratedMessageLite.ExtendableMessageOrBuilder<Constructor> {
        public boolean hasFlags();

        public int getFlags();

        public List<ValueParameter> getValueParameterList();

        public ValueParameter getValueParameter(int var1);

        public int getValueParameterCount();

        public boolean hasSinceKotlinInfo();

        public int getSinceKotlinInfo();
    }

    public static final class TypeTable
    extends GeneratedMessageLite
    implements TypeTableOrBuilder {
        private static final TypeTable defaultInstance;
        private final ByteString unknownFields;
        public static Parser<TypeTable> PARSER;
        private int bitField0_;
        public static final int TYPE_FIELD_NUMBER = 1;
        private List<Type> type_;
        public static final int FIRST_NULLABLE_FIELD_NUMBER = 2;
        private int firstNullable_;
        private byte memoizedIsInitialized = (byte)-1;
        private int memoizedSerializedSize = -1;
        private static final long serialVersionUID = 0L;

        private TypeTable(GeneratedMessageLite.Builder builder) {
            super(builder);
            this.unknownFields = builder.getUnknownFields();
        }

        private TypeTable(boolean noInit) {
            this.unknownFields = ByteString.EMPTY;
        }

        public static TypeTable getDefaultInstance() {
            return defaultInstance;
        }

        @Override
        public TypeTable getDefaultInstanceForType() {
            return defaultInstance;
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        private TypeTable(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                        case 10: {
                            if (!(mutable_bitField0_ & true)) {
                                this.type_ = new ArrayList<Type>();
                                mutable_bitField0_ |= true;
                            }
                            this.type_.add(input.readMessage(Type.PARSER, extensionRegistry));
                            continue block20;
                        }
                        case 16: 
                    }
                    this.bitField0_ |= 1;
                    this.firstNullable_ = input.readInt32();
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
                    this.type_ = Collections.unmodifiableList(this.type_);
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

        public Parser<TypeTable> getParserForType() {
            return PARSER;
        }

        @Override
        public List<Type> getTypeList() {
            return this.type_;
        }

        public List<? extends TypeOrBuilder> getTypeOrBuilderList() {
            return this.type_;
        }

        @Override
        public int getTypeCount() {
            return this.type_.size();
        }

        @Override
        public Type getType(int index) {
            return this.type_.get(index);
        }

        public TypeOrBuilder getTypeOrBuilder(int index) {
            return this.type_.get(index);
        }

        @Override
        public boolean hasFirstNullable() {
            return (this.bitField0_ & 1) == 1;
        }

        @Override
        public int getFirstNullable() {
            return this.firstNullable_;
        }

        private void initFields() {
            this.type_ = Collections.emptyList();
            this.firstNullable_ = -1;
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
            for (int i = 0; i < this.getTypeCount(); ++i) {
                if (this.getType(i).isInitialized()) continue;
                this.memoizedIsInitialized = 0;
                return false;
            }
            this.memoizedIsInitialized = 1;
            return true;
        }

        @Override
        public void writeTo(CodedOutputStream output) throws IOException {
            this.getSerializedSize();
            for (int i = 0; i < this.type_.size(); ++i) {
                output.writeMessage(1, this.type_.get(i));
            }
            if ((this.bitField0_ & 1) == 1) {
                output.writeInt32(2, this.firstNullable_);
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
            for (int i = 0; i < this.type_.size(); ++i) {
                size += CodedOutputStream.computeMessageSize(1, this.type_.get(i));
            }
            if ((this.bitField0_ & 1) == 1) {
                size += CodedOutputStream.computeInt32Size(2, this.firstNullable_);
            }
            this.memoizedSerializedSize = size += this.unknownFields.size();
            return size;
        }

        @Override
        protected Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }

        public static TypeTable parseFrom(ByteString data2) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data2);
        }

        public static TypeTable parseFrom(ByteString data2, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data2, extensionRegistry);
        }

        public static TypeTable parseFrom(byte[] data2) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data2);
        }

        public static TypeTable parseFrom(byte[] data2, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data2, extensionRegistry);
        }

        public static TypeTable parseFrom(InputStream input) throws IOException {
            return PARSER.parseFrom(input);
        }

        public static TypeTable parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return PARSER.parseFrom(input, extensionRegistry);
        }

        public static TypeTable parseDelimitedFrom(InputStream input) throws IOException {
            return PARSER.parseDelimitedFrom(input);
        }

        public static TypeTable parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return PARSER.parseDelimitedFrom(input, extensionRegistry);
        }

        public static TypeTable parseFrom(CodedInputStream input) throws IOException {
            return PARSER.parseFrom(input);
        }

        public static TypeTable parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return PARSER.parseFrom(input, extensionRegistry);
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        @Override
        public Builder newBuilderForType() {
            return TypeTable.newBuilder();
        }

        public static Builder newBuilder(TypeTable prototype) {
            return TypeTable.newBuilder().mergeFrom(prototype);
        }

        @Override
        public Builder toBuilder() {
            return TypeTable.newBuilder(this);
        }

        static {
            PARSER = new AbstractParser<TypeTable>(){

                @Override
                public TypeTable parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                    return new TypeTable(input, extensionRegistry);
                }
            };
            defaultInstance = new TypeTable(true);
            defaultInstance.initFields();
        }

        public static final class Builder
        extends GeneratedMessageLite.Builder<TypeTable, Builder>
        implements TypeTableOrBuilder {
            private int bitField0_;
            private List<Type> type_ = Collections.emptyList();
            private int firstNullable_ = -1;

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
                this.type_ = Collections.emptyList();
                this.bitField0_ &= 0xFFFFFFFE;
                this.firstNullable_ = -1;
                this.bitField0_ &= 0xFFFFFFFD;
                return this;
            }

            @Override
            public Builder clone() {
                return Builder.create().mergeFrom(this.buildPartial());
            }

            @Override
            public TypeTable getDefaultInstanceForType() {
                return TypeTable.getDefaultInstance();
            }

            @Override
            public TypeTable build() {
                TypeTable result2 = this.buildPartial();
                if (!result2.isInitialized()) {
                    throw Builder.newUninitializedMessageException(result2);
                }
                return result2;
            }

            @Override
            public TypeTable buildPartial() {
                TypeTable result2 = new TypeTable(this);
                int from_bitField0_ = this.bitField0_;
                int to_bitField0_ = 0;
                if ((this.bitField0_ & 1) == 1) {
                    this.type_ = Collections.unmodifiableList(this.type_);
                    this.bitField0_ &= 0xFFFFFFFE;
                }
                result2.type_ = this.type_;
                if ((from_bitField0_ & 2) == 2) {
                    to_bitField0_ |= 1;
                }
                result2.firstNullable_ = this.firstNullable_;
                result2.bitField0_ = to_bitField0_;
                return result2;
            }

            @Override
            public Builder mergeFrom(TypeTable other) {
                if (other == TypeTable.getDefaultInstance()) {
                    return this;
                }
                if (!other.type_.isEmpty()) {
                    if (this.type_.isEmpty()) {
                        this.type_ = other.type_;
                        this.bitField0_ &= 0xFFFFFFFE;
                    } else {
                        this.ensureTypeIsMutable();
                        this.type_.addAll(other.type_);
                    }
                }
                if (other.hasFirstNullable()) {
                    this.setFirstNullable(other.getFirstNullable());
                }
                this.setUnknownFields(this.getUnknownFields().concat(other.unknownFields));
                return this;
            }

            @Override
            public final boolean isInitialized() {
                for (int i = 0; i < this.getTypeCount(); ++i) {
                    if (this.getType(i).isInitialized()) continue;
                    return false;
                }
                return true;
            }

            @Override
            public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                TypeTable parsedMessage = null;
                try {
                    parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
                }
                catch (InvalidProtocolBufferException e) {
                    parsedMessage = (TypeTable)e.getUnfinishedMessage();
                    throw e;
                }
                finally {
                    if (parsedMessage != null) {
                        this.mergeFrom(parsedMessage);
                    }
                }
                return this;
            }

            private void ensureTypeIsMutable() {
                if ((this.bitField0_ & 1) != 1) {
                    this.type_ = new ArrayList<Type>(this.type_);
                    this.bitField0_ |= 1;
                }
            }

            @Override
            public List<Type> getTypeList() {
                return Collections.unmodifiableList(this.type_);
            }

            @Override
            public int getTypeCount() {
                return this.type_.size();
            }

            @Override
            public Type getType(int index) {
                return this.type_.get(index);
            }

            public Builder setType(int index, Type value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.ensureTypeIsMutable();
                this.type_.set(index, value);
                return this;
            }

            public Builder setType(int index, Type.Builder builderForValue) {
                this.ensureTypeIsMutable();
                this.type_.set(index, builderForValue.build());
                return this;
            }

            public Builder addType(Type value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.ensureTypeIsMutable();
                this.type_.add(value);
                return this;
            }

            public Builder addType(int index, Type value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.ensureTypeIsMutable();
                this.type_.add(index, value);
                return this;
            }

            public Builder addType(Type.Builder builderForValue) {
                this.ensureTypeIsMutable();
                this.type_.add(builderForValue.build());
                return this;
            }

            public Builder addType(int index, Type.Builder builderForValue) {
                this.ensureTypeIsMutable();
                this.type_.add(index, builderForValue.build());
                return this;
            }

            public Builder addAllType(Iterable<? extends Type> values2) {
                this.ensureTypeIsMutable();
                AbstractMessageLite.Builder.addAll(values2, this.type_);
                return this;
            }

            public Builder clearType() {
                this.type_ = Collections.emptyList();
                this.bitField0_ &= 0xFFFFFFFE;
                return this;
            }

            public Builder removeType(int index) {
                this.ensureTypeIsMutable();
                this.type_.remove(index);
                return this;
            }

            @Override
            public boolean hasFirstNullable() {
                return (this.bitField0_ & 2) == 2;
            }

            @Override
            public int getFirstNullable() {
                return this.firstNullable_;
            }

            public Builder setFirstNullable(int value) {
                this.bitField0_ |= 2;
                this.firstNullable_ = value;
                return this;
            }

            public Builder clearFirstNullable() {
                this.bitField0_ &= 0xFFFFFFFD;
                this.firstNullable_ = -1;
                return this;
            }
        }
    }

    public static interface TypeTableOrBuilder
    extends MessageLiteOrBuilder {
        public List<Type> getTypeList();

        public Type getType(int var1);

        public int getTypeCount();

        public boolean hasFirstNullable();

        public int getFirstNullable();
    }

    public static final class Package
    extends GeneratedMessageLite.ExtendableMessage<Package>
    implements PackageOrBuilder {
        private static final Package defaultInstance;
        private final ByteString unknownFields;
        public static Parser<Package> PARSER;
        private int bitField0_;
        public static final int FUNCTION_FIELD_NUMBER = 3;
        private List<Function> function_;
        public static final int PROPERTY_FIELD_NUMBER = 4;
        private List<Property> property_;
        public static final int TYPE_ALIAS_FIELD_NUMBER = 5;
        private List<TypeAlias> typeAlias_;
        public static final int TYPE_TABLE_FIELD_NUMBER = 30;
        private TypeTable typeTable_;
        public static final int SINCE_KOTLIN_INFO_TABLE_FIELD_NUMBER = 32;
        private SinceKotlinInfoTable sinceKotlinInfoTable_;
        private byte memoizedIsInitialized = (byte)-1;
        private int memoizedSerializedSize = -1;
        private static final long serialVersionUID = 0L;

        private Package(GeneratedMessageLite.ExtendableBuilder<Package, ?> builder) {
            super(builder);
            this.unknownFields = builder.getUnknownFields();
        }

        private Package(boolean noInit) {
            this.unknownFields = ByteString.EMPTY;
        }

        public static Package getDefaultInstance() {
            return defaultInstance;
        }

        @Override
        public Package getDefaultInstanceForType() {
            return defaultInstance;
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        private Package(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            this.initFields();
            int mutable_bitField0_ = 0;
            ByteString.Output unknownFieldsOutput = ByteString.newOutput();
            CodedOutputStream unknownFieldsCodedOutput = CodedOutputStream.newInstance(unknownFieldsOutput);
            try {
                boolean done = false;
                block23: while (!done) {
                    GeneratedMessageLite.Builder subBuilder;
                    int tag = input.readTag();
                    switch (tag) {
                        case 0: {
                            done = true;
                            continue block23;
                        }
                        default: {
                            if (this.parseUnknownField(input, unknownFieldsCodedOutput, extensionRegistry, tag)) continue block23;
                            done = true;
                            continue block23;
                        }
                        case 26: {
                            if ((mutable_bitField0_ & 1) != 1) {
                                this.function_ = new ArrayList<Function>();
                                mutable_bitField0_ |= 1;
                            }
                            this.function_.add(input.readMessage(Function.PARSER, extensionRegistry));
                            continue block23;
                        }
                        case 34: {
                            if ((mutable_bitField0_ & 2) != 2) {
                                this.property_ = new ArrayList<Property>();
                                mutable_bitField0_ |= 2;
                            }
                            this.property_.add(input.readMessage(Property.PARSER, extensionRegistry));
                            continue block23;
                        }
                        case 42: {
                            if ((mutable_bitField0_ & 4) != 4) {
                                this.typeAlias_ = new ArrayList<TypeAlias>();
                                mutable_bitField0_ |= 4;
                            }
                            this.typeAlias_.add(input.readMessage(TypeAlias.PARSER, extensionRegistry));
                            continue block23;
                        }
                        case 242: {
                            subBuilder = null;
                            if ((this.bitField0_ & 1) == 1) {
                                subBuilder = this.typeTable_.toBuilder();
                            }
                            this.typeTable_ = input.readMessage(TypeTable.PARSER, extensionRegistry);
                            if (subBuilder != null) {
                                ((TypeTable.Builder)subBuilder).mergeFrom(this.typeTable_);
                                this.typeTable_ = ((TypeTable.Builder)subBuilder).buildPartial();
                            }
                            this.bitField0_ |= 1;
                            continue block23;
                        }
                        case 258: 
                    }
                    subBuilder = null;
                    if ((this.bitField0_ & 2) == 2) {
                        subBuilder = this.sinceKotlinInfoTable_.toBuilder();
                    }
                    this.sinceKotlinInfoTable_ = input.readMessage(SinceKotlinInfoTable.PARSER, extensionRegistry);
                    if (subBuilder != null) {
                        ((SinceKotlinInfoTable.Builder)subBuilder).mergeFrom(this.sinceKotlinInfoTable_);
                        this.sinceKotlinInfoTable_ = ((SinceKotlinInfoTable.Builder)subBuilder).buildPartial();
                    }
                    this.bitField0_ |= 2;
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
                    this.function_ = Collections.unmodifiableList(this.function_);
                }
                if ((mutable_bitField0_ & 2) == 2) {
                    this.property_ = Collections.unmodifiableList(this.property_);
                }
                if ((mutable_bitField0_ & 4) == 4) {
                    this.typeAlias_ = Collections.unmodifiableList(this.typeAlias_);
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

        public Parser<Package> getParserForType() {
            return PARSER;
        }

        @Override
        public List<Function> getFunctionList() {
            return this.function_;
        }

        public List<? extends FunctionOrBuilder> getFunctionOrBuilderList() {
            return this.function_;
        }

        @Override
        public int getFunctionCount() {
            return this.function_.size();
        }

        @Override
        public Function getFunction(int index) {
            return this.function_.get(index);
        }

        public FunctionOrBuilder getFunctionOrBuilder(int index) {
            return this.function_.get(index);
        }

        @Override
        public List<Property> getPropertyList() {
            return this.property_;
        }

        public List<? extends PropertyOrBuilder> getPropertyOrBuilderList() {
            return this.property_;
        }

        @Override
        public int getPropertyCount() {
            return this.property_.size();
        }

        @Override
        public Property getProperty(int index) {
            return this.property_.get(index);
        }

        public PropertyOrBuilder getPropertyOrBuilder(int index) {
            return this.property_.get(index);
        }

        @Override
        public List<TypeAlias> getTypeAliasList() {
            return this.typeAlias_;
        }

        public List<? extends TypeAliasOrBuilder> getTypeAliasOrBuilderList() {
            return this.typeAlias_;
        }

        @Override
        public int getTypeAliasCount() {
            return this.typeAlias_.size();
        }

        @Override
        public TypeAlias getTypeAlias(int index) {
            return this.typeAlias_.get(index);
        }

        public TypeAliasOrBuilder getTypeAliasOrBuilder(int index) {
            return this.typeAlias_.get(index);
        }

        @Override
        public boolean hasTypeTable() {
            return (this.bitField0_ & 1) == 1;
        }

        @Override
        public TypeTable getTypeTable() {
            return this.typeTable_;
        }

        @Override
        public boolean hasSinceKotlinInfoTable() {
            return (this.bitField0_ & 2) == 2;
        }

        @Override
        public SinceKotlinInfoTable getSinceKotlinInfoTable() {
            return this.sinceKotlinInfoTable_;
        }

        private void initFields() {
            this.function_ = Collections.emptyList();
            this.property_ = Collections.emptyList();
            this.typeAlias_ = Collections.emptyList();
            this.typeTable_ = TypeTable.getDefaultInstance();
            this.sinceKotlinInfoTable_ = SinceKotlinInfoTable.getDefaultInstance();
        }

        @Override
        public final boolean isInitialized() {
            int i;
            byte isInitialized = this.memoizedIsInitialized;
            if (isInitialized == 1) {
                return true;
            }
            if (isInitialized == 0) {
                return false;
            }
            for (i = 0; i < this.getFunctionCount(); ++i) {
                if (this.getFunction(i).isInitialized()) continue;
                this.memoizedIsInitialized = 0;
                return false;
            }
            for (i = 0; i < this.getPropertyCount(); ++i) {
                if (this.getProperty(i).isInitialized()) continue;
                this.memoizedIsInitialized = 0;
                return false;
            }
            for (i = 0; i < this.getTypeAliasCount(); ++i) {
                if (this.getTypeAlias(i).isInitialized()) continue;
                this.memoizedIsInitialized = 0;
                return false;
            }
            if (this.hasTypeTable() && !this.getTypeTable().isInitialized()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            if (!this.extensionsAreInitialized()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            this.memoizedIsInitialized = 1;
            return true;
        }

        @Override
        public void writeTo(CodedOutputStream output) throws IOException {
            int i;
            this.getSerializedSize();
            GeneratedMessageLite.ExtendableMessage.ExtensionWriter extensionWriter = this.newExtensionWriter();
            for (i = 0; i < this.function_.size(); ++i) {
                output.writeMessage(3, this.function_.get(i));
            }
            for (i = 0; i < this.property_.size(); ++i) {
                output.writeMessage(4, this.property_.get(i));
            }
            for (i = 0; i < this.typeAlias_.size(); ++i) {
                output.writeMessage(5, this.typeAlias_.get(i));
            }
            if ((this.bitField0_ & 1) == 1) {
                output.writeMessage(30, this.typeTable_);
            }
            if ((this.bitField0_ & 2) == 2) {
                output.writeMessage(32, this.sinceKotlinInfoTable_);
            }
            extensionWriter.writeUntil(200, output);
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
            for (i = 0; i < this.function_.size(); ++i) {
                size += CodedOutputStream.computeMessageSize(3, this.function_.get(i));
            }
            for (i = 0; i < this.property_.size(); ++i) {
                size += CodedOutputStream.computeMessageSize(4, this.property_.get(i));
            }
            for (i = 0; i < this.typeAlias_.size(); ++i) {
                size += CodedOutputStream.computeMessageSize(5, this.typeAlias_.get(i));
            }
            if ((this.bitField0_ & 1) == 1) {
                size += CodedOutputStream.computeMessageSize(30, this.typeTable_);
            }
            if ((this.bitField0_ & 2) == 2) {
                size += CodedOutputStream.computeMessageSize(32, this.sinceKotlinInfoTable_);
            }
            size += this.extensionsSerializedSize();
            this.memoizedSerializedSize = size += this.unknownFields.size();
            return size;
        }

        @Override
        protected Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }

        public static Package parseFrom(ByteString data2) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data2);
        }

        public static Package parseFrom(ByteString data2, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data2, extensionRegistry);
        }

        public static Package parseFrom(byte[] data2) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data2);
        }

        public static Package parseFrom(byte[] data2, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data2, extensionRegistry);
        }

        public static Package parseFrom(InputStream input) throws IOException {
            return PARSER.parseFrom(input);
        }

        public static Package parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return PARSER.parseFrom(input, extensionRegistry);
        }

        public static Package parseDelimitedFrom(InputStream input) throws IOException {
            return PARSER.parseDelimitedFrom(input);
        }

        public static Package parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return PARSER.parseDelimitedFrom(input, extensionRegistry);
        }

        public static Package parseFrom(CodedInputStream input) throws IOException {
            return PARSER.parseFrom(input);
        }

        public static Package parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return PARSER.parseFrom(input, extensionRegistry);
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        @Override
        public Builder newBuilderForType() {
            return Package.newBuilder();
        }

        public static Builder newBuilder(Package prototype) {
            return Package.newBuilder().mergeFrom(prototype);
        }

        @Override
        public Builder toBuilder() {
            return Package.newBuilder(this);
        }

        static {
            PARSER = new AbstractParser<Package>(){

                @Override
                public Package parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                    return new Package(input, extensionRegistry);
                }
            };
            defaultInstance = new Package(true);
            defaultInstance.initFields();
        }

        public static final class Builder
        extends GeneratedMessageLite.ExtendableBuilder<Package, Builder>
        implements PackageOrBuilder {
            private int bitField0_;
            private List<Function> function_ = Collections.emptyList();
            private List<Property> property_ = Collections.emptyList();
            private List<TypeAlias> typeAlias_ = Collections.emptyList();
            private TypeTable typeTable_ = TypeTable.getDefaultInstance();
            private SinceKotlinInfoTable sinceKotlinInfoTable_ = SinceKotlinInfoTable.getDefaultInstance();

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
                this.function_ = Collections.emptyList();
                this.bitField0_ &= 0xFFFFFFFE;
                this.property_ = Collections.emptyList();
                this.bitField0_ &= 0xFFFFFFFD;
                this.typeAlias_ = Collections.emptyList();
                this.bitField0_ &= 0xFFFFFFFB;
                this.typeTable_ = TypeTable.getDefaultInstance();
                this.bitField0_ &= 0xFFFFFFF7;
                this.sinceKotlinInfoTable_ = SinceKotlinInfoTable.getDefaultInstance();
                this.bitField0_ &= 0xFFFFFFEF;
                return this;
            }

            @Override
            public Builder clone() {
                return Builder.create().mergeFrom(this.buildPartial());
            }

            @Override
            public Package getDefaultInstanceForType() {
                return Package.getDefaultInstance();
            }

            @Override
            public Package build() {
                Package result2 = this.buildPartial();
                if (!result2.isInitialized()) {
                    throw Builder.newUninitializedMessageException(result2);
                }
                return result2;
            }

            @Override
            public Package buildPartial() {
                Package result2 = new Package(this);
                int from_bitField0_ = this.bitField0_;
                int to_bitField0_ = 0;
                if ((this.bitField0_ & 1) == 1) {
                    this.function_ = Collections.unmodifiableList(this.function_);
                    this.bitField0_ &= 0xFFFFFFFE;
                }
                result2.function_ = this.function_;
                if ((this.bitField0_ & 2) == 2) {
                    this.property_ = Collections.unmodifiableList(this.property_);
                    this.bitField0_ &= 0xFFFFFFFD;
                }
                result2.property_ = this.property_;
                if ((this.bitField0_ & 4) == 4) {
                    this.typeAlias_ = Collections.unmodifiableList(this.typeAlias_);
                    this.bitField0_ &= 0xFFFFFFFB;
                }
                result2.typeAlias_ = this.typeAlias_;
                if ((from_bitField0_ & 8) == 8) {
                    to_bitField0_ |= 1;
                }
                result2.typeTable_ = this.typeTable_;
                if ((from_bitField0_ & 0x10) == 16) {
                    to_bitField0_ |= 2;
                }
                result2.sinceKotlinInfoTable_ = this.sinceKotlinInfoTable_;
                result2.bitField0_ = to_bitField0_;
                return result2;
            }

            @Override
            public Builder mergeFrom(Package other) {
                if (other == Package.getDefaultInstance()) {
                    return this;
                }
                if (!other.function_.isEmpty()) {
                    if (this.function_.isEmpty()) {
                        this.function_ = other.function_;
                        this.bitField0_ &= 0xFFFFFFFE;
                    } else {
                        this.ensureFunctionIsMutable();
                        this.function_.addAll(other.function_);
                    }
                }
                if (!other.property_.isEmpty()) {
                    if (this.property_.isEmpty()) {
                        this.property_ = other.property_;
                        this.bitField0_ &= 0xFFFFFFFD;
                    } else {
                        this.ensurePropertyIsMutable();
                        this.property_.addAll(other.property_);
                    }
                }
                if (!other.typeAlias_.isEmpty()) {
                    if (this.typeAlias_.isEmpty()) {
                        this.typeAlias_ = other.typeAlias_;
                        this.bitField0_ &= 0xFFFFFFFB;
                    } else {
                        this.ensureTypeAliasIsMutable();
                        this.typeAlias_.addAll(other.typeAlias_);
                    }
                }
                if (other.hasTypeTable()) {
                    this.mergeTypeTable(other.getTypeTable());
                }
                if (other.hasSinceKotlinInfoTable()) {
                    this.mergeSinceKotlinInfoTable(other.getSinceKotlinInfoTable());
                }
                this.mergeExtensionFields(other);
                this.setUnknownFields(this.getUnknownFields().concat(other.unknownFields));
                return this;
            }

            @Override
            public final boolean isInitialized() {
                int i;
                for (i = 0; i < this.getFunctionCount(); ++i) {
                    if (this.getFunction(i).isInitialized()) continue;
                    return false;
                }
                for (i = 0; i < this.getPropertyCount(); ++i) {
                    if (this.getProperty(i).isInitialized()) continue;
                    return false;
                }
                for (i = 0; i < this.getTypeAliasCount(); ++i) {
                    if (this.getTypeAlias(i).isInitialized()) continue;
                    return false;
                }
                if (this.hasTypeTable() && !this.getTypeTable().isInitialized()) {
                    return false;
                }
                return this.extensionsAreInitialized();
            }

            @Override
            public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                Package parsedMessage = null;
                try {
                    parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
                }
                catch (InvalidProtocolBufferException e) {
                    parsedMessage = (Package)e.getUnfinishedMessage();
                    throw e;
                }
                finally {
                    if (parsedMessage != null) {
                        this.mergeFrom(parsedMessage);
                    }
                }
                return this;
            }

            private void ensureFunctionIsMutable() {
                if ((this.bitField0_ & 1) != 1) {
                    this.function_ = new ArrayList<Function>(this.function_);
                    this.bitField0_ |= 1;
                }
            }

            @Override
            public List<Function> getFunctionList() {
                return Collections.unmodifiableList(this.function_);
            }

            @Override
            public int getFunctionCount() {
                return this.function_.size();
            }

            @Override
            public Function getFunction(int index) {
                return this.function_.get(index);
            }

            public Builder setFunction(int index, Function value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.ensureFunctionIsMutable();
                this.function_.set(index, value);
                return this;
            }

            public Builder setFunction(int index, Function.Builder builderForValue) {
                this.ensureFunctionIsMutable();
                this.function_.set(index, builderForValue.build());
                return this;
            }

            public Builder addFunction(Function value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.ensureFunctionIsMutable();
                this.function_.add(value);
                return this;
            }

            public Builder addFunction(int index, Function value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.ensureFunctionIsMutable();
                this.function_.add(index, value);
                return this;
            }

            public Builder addFunction(Function.Builder builderForValue) {
                this.ensureFunctionIsMutable();
                this.function_.add(builderForValue.build());
                return this;
            }

            public Builder addFunction(int index, Function.Builder builderForValue) {
                this.ensureFunctionIsMutable();
                this.function_.add(index, builderForValue.build());
                return this;
            }

            public Builder addAllFunction(Iterable<? extends Function> values2) {
                this.ensureFunctionIsMutable();
                AbstractMessageLite.Builder.addAll(values2, this.function_);
                return this;
            }

            public Builder clearFunction() {
                this.function_ = Collections.emptyList();
                this.bitField0_ &= 0xFFFFFFFE;
                return this;
            }

            public Builder removeFunction(int index) {
                this.ensureFunctionIsMutable();
                this.function_.remove(index);
                return this;
            }

            private void ensurePropertyIsMutable() {
                if ((this.bitField0_ & 2) != 2) {
                    this.property_ = new ArrayList<Property>(this.property_);
                    this.bitField0_ |= 2;
                }
            }

            @Override
            public List<Property> getPropertyList() {
                return Collections.unmodifiableList(this.property_);
            }

            @Override
            public int getPropertyCount() {
                return this.property_.size();
            }

            @Override
            public Property getProperty(int index) {
                return this.property_.get(index);
            }

            public Builder setProperty(int index, Property value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.ensurePropertyIsMutable();
                this.property_.set(index, value);
                return this;
            }

            public Builder setProperty(int index, Property.Builder builderForValue) {
                this.ensurePropertyIsMutable();
                this.property_.set(index, builderForValue.build());
                return this;
            }

            public Builder addProperty(Property value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.ensurePropertyIsMutable();
                this.property_.add(value);
                return this;
            }

            public Builder addProperty(int index, Property value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.ensurePropertyIsMutable();
                this.property_.add(index, value);
                return this;
            }

            public Builder addProperty(Property.Builder builderForValue) {
                this.ensurePropertyIsMutable();
                this.property_.add(builderForValue.build());
                return this;
            }

            public Builder addProperty(int index, Property.Builder builderForValue) {
                this.ensurePropertyIsMutable();
                this.property_.add(index, builderForValue.build());
                return this;
            }

            public Builder addAllProperty(Iterable<? extends Property> values2) {
                this.ensurePropertyIsMutable();
                AbstractMessageLite.Builder.addAll(values2, this.property_);
                return this;
            }

            public Builder clearProperty() {
                this.property_ = Collections.emptyList();
                this.bitField0_ &= 0xFFFFFFFD;
                return this;
            }

            public Builder removeProperty(int index) {
                this.ensurePropertyIsMutable();
                this.property_.remove(index);
                return this;
            }

            private void ensureTypeAliasIsMutable() {
                if ((this.bitField0_ & 4) != 4) {
                    this.typeAlias_ = new ArrayList<TypeAlias>(this.typeAlias_);
                    this.bitField0_ |= 4;
                }
            }

            @Override
            public List<TypeAlias> getTypeAliasList() {
                return Collections.unmodifiableList(this.typeAlias_);
            }

            @Override
            public int getTypeAliasCount() {
                return this.typeAlias_.size();
            }

            @Override
            public TypeAlias getTypeAlias(int index) {
                return this.typeAlias_.get(index);
            }

            public Builder setTypeAlias(int index, TypeAlias value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.ensureTypeAliasIsMutable();
                this.typeAlias_.set(index, value);
                return this;
            }

            public Builder setTypeAlias(int index, TypeAlias.Builder builderForValue) {
                this.ensureTypeAliasIsMutable();
                this.typeAlias_.set(index, builderForValue.build());
                return this;
            }

            public Builder addTypeAlias(TypeAlias value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.ensureTypeAliasIsMutable();
                this.typeAlias_.add(value);
                return this;
            }

            public Builder addTypeAlias(int index, TypeAlias value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.ensureTypeAliasIsMutable();
                this.typeAlias_.add(index, value);
                return this;
            }

            public Builder addTypeAlias(TypeAlias.Builder builderForValue) {
                this.ensureTypeAliasIsMutable();
                this.typeAlias_.add(builderForValue.build());
                return this;
            }

            public Builder addTypeAlias(int index, TypeAlias.Builder builderForValue) {
                this.ensureTypeAliasIsMutable();
                this.typeAlias_.add(index, builderForValue.build());
                return this;
            }

            public Builder addAllTypeAlias(Iterable<? extends TypeAlias> values2) {
                this.ensureTypeAliasIsMutable();
                AbstractMessageLite.Builder.addAll(values2, this.typeAlias_);
                return this;
            }

            public Builder clearTypeAlias() {
                this.typeAlias_ = Collections.emptyList();
                this.bitField0_ &= 0xFFFFFFFB;
                return this;
            }

            public Builder removeTypeAlias(int index) {
                this.ensureTypeAliasIsMutable();
                this.typeAlias_.remove(index);
                return this;
            }

            @Override
            public boolean hasTypeTable() {
                return (this.bitField0_ & 8) == 8;
            }

            @Override
            public TypeTable getTypeTable() {
                return this.typeTable_;
            }

            public Builder setTypeTable(TypeTable value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.typeTable_ = value;
                this.bitField0_ |= 8;
                return this;
            }

            public Builder setTypeTable(TypeTable.Builder builderForValue) {
                this.typeTable_ = builderForValue.build();
                this.bitField0_ |= 8;
                return this;
            }

            public Builder mergeTypeTable(TypeTable value) {
                this.typeTable_ = (this.bitField0_ & 8) == 8 && this.typeTable_ != TypeTable.getDefaultInstance() ? TypeTable.newBuilder(this.typeTable_).mergeFrom(value).buildPartial() : value;
                this.bitField0_ |= 8;
                return this;
            }

            public Builder clearTypeTable() {
                this.typeTable_ = TypeTable.getDefaultInstance();
                this.bitField0_ &= 0xFFFFFFF7;
                return this;
            }

            @Override
            public boolean hasSinceKotlinInfoTable() {
                return (this.bitField0_ & 0x10) == 16;
            }

            @Override
            public SinceKotlinInfoTable getSinceKotlinInfoTable() {
                return this.sinceKotlinInfoTable_;
            }

            public Builder setSinceKotlinInfoTable(SinceKotlinInfoTable value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.sinceKotlinInfoTable_ = value;
                this.bitField0_ |= 0x10;
                return this;
            }

            public Builder setSinceKotlinInfoTable(SinceKotlinInfoTable.Builder builderForValue) {
                this.sinceKotlinInfoTable_ = builderForValue.build();
                this.bitField0_ |= 0x10;
                return this;
            }

            public Builder mergeSinceKotlinInfoTable(SinceKotlinInfoTable value) {
                this.sinceKotlinInfoTable_ = (this.bitField0_ & 0x10) == 16 && this.sinceKotlinInfoTable_ != SinceKotlinInfoTable.getDefaultInstance() ? SinceKotlinInfoTable.newBuilder(this.sinceKotlinInfoTable_).mergeFrom(value).buildPartial() : value;
                this.bitField0_ |= 0x10;
                return this;
            }

            public Builder clearSinceKotlinInfoTable() {
                this.sinceKotlinInfoTable_ = SinceKotlinInfoTable.getDefaultInstance();
                this.bitField0_ &= 0xFFFFFFEF;
                return this;
            }
        }
    }

    public static interface PackageOrBuilder
    extends GeneratedMessageLite.ExtendableMessageOrBuilder<Package> {
        public List<Function> getFunctionList();

        public Function getFunction(int var1);

        public int getFunctionCount();

        public List<Property> getPropertyList();

        public Property getProperty(int var1);

        public int getPropertyCount();

        public List<TypeAlias> getTypeAliasList();

        public TypeAlias getTypeAlias(int var1);

        public int getTypeAliasCount();

        public boolean hasTypeTable();

        public TypeTable getTypeTable();

        public boolean hasSinceKotlinInfoTable();

        public SinceKotlinInfoTable getSinceKotlinInfoTable();
    }

    public static final class Class
    extends GeneratedMessageLite.ExtendableMessage<Class>
    implements ClassOrBuilder {
        private static final Class defaultInstance;
        private final ByteString unknownFields;
        public static Parser<Class> PARSER;
        private int bitField0_;
        public static final int FLAGS_FIELD_NUMBER = 1;
        private int flags_;
        public static final int FQ_NAME_FIELD_NUMBER = 3;
        private int fqName_;
        public static final int COMPANION_OBJECT_NAME_FIELD_NUMBER = 4;
        private int companionObjectName_;
        public static final int TYPE_PARAMETER_FIELD_NUMBER = 5;
        private List<TypeParameter> typeParameter_;
        public static final int SUPERTYPE_FIELD_NUMBER = 6;
        private List<Type> supertype_;
        public static final int SUPERTYPE_ID_FIELD_NUMBER = 2;
        private List<Integer> supertypeId_;
        private int supertypeIdMemoizedSerializedSize = -1;
        public static final int NESTED_CLASS_NAME_FIELD_NUMBER = 7;
        private List<Integer> nestedClassName_;
        private int nestedClassNameMemoizedSerializedSize = -1;
        public static final int CONSTRUCTOR_FIELD_NUMBER = 8;
        private List<Constructor> constructor_;
        public static final int FUNCTION_FIELD_NUMBER = 9;
        private List<Function> function_;
        public static final int PROPERTY_FIELD_NUMBER = 10;
        private List<Property> property_;
        public static final int TYPE_ALIAS_FIELD_NUMBER = 11;
        private List<TypeAlias> typeAlias_;
        public static final int ENUM_ENTRY_FIELD_NUMBER = 13;
        private List<EnumEntry> enumEntry_;
        public static final int SEALED_SUBCLASS_FQ_NAME_FIELD_NUMBER = 16;
        private List<Integer> sealedSubclassFqName_;
        private int sealedSubclassFqNameMemoizedSerializedSize = -1;
        public static final int TYPE_TABLE_FIELD_NUMBER = 30;
        private TypeTable typeTable_;
        public static final int SINCEKOTLININFO_FIELD_NUMBER = 31;
        private int sinceKotlinInfo_;
        public static final int SINCE_KOTLIN_INFO_TABLE_FIELD_NUMBER = 32;
        private SinceKotlinInfoTable sinceKotlinInfoTable_;
        private byte memoizedIsInitialized = (byte)-1;
        private int memoizedSerializedSize = -1;
        private static final long serialVersionUID = 0L;

        private Class(GeneratedMessageLite.ExtendableBuilder<Class, ?> builder) {
            super(builder);
            this.unknownFields = builder.getUnknownFields();
        }

        private Class(boolean noInit) {
            this.unknownFields = ByteString.EMPTY;
        }

        public static Class getDefaultInstance() {
            return defaultInstance;
        }

        @Override
        public Class getDefaultInstanceForType() {
            return defaultInstance;
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        private Class(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            this.initFields();
            int mutable_bitField0_ = 0;
            ByteString.Output unknownFieldsOutput = ByteString.newOutput();
            CodedOutputStream unknownFieldsCodedOutput = CodedOutputStream.newInstance(unknownFieldsOutput);
            try {
                boolean done = false;
                block37: while (!done) {
                    int tag = input.readTag();
                    switch (tag) {
                        case 0: {
                            done = true;
                            continue block37;
                        }
                        default: {
                            if (this.parseUnknownField(input, unknownFieldsCodedOutput, extensionRegistry, tag)) continue block37;
                            done = true;
                            continue block37;
                        }
                        case 8: {
                            this.bitField0_ |= 1;
                            this.flags_ = input.readInt32();
                            continue block37;
                        }
                        case 16: {
                            if ((mutable_bitField0_ & 0x20) != 32) {
                                this.supertypeId_ = new ArrayList<Integer>();
                                mutable_bitField0_ |= 0x20;
                            }
                            this.supertypeId_.add(input.readInt32());
                            continue block37;
                        }
                        case 18: {
                            int length = input.readRawVarint32();
                            int limit = input.pushLimit(length);
                            if ((mutable_bitField0_ & 0x20) != 32 && input.getBytesUntilLimit() > 0) {
                                this.supertypeId_ = new ArrayList<Integer>();
                                mutable_bitField0_ |= 0x20;
                            }
                            while (input.getBytesUntilLimit() > 0) {
                                this.supertypeId_.add(input.readInt32());
                            }
                            input.popLimit(limit);
                            continue block37;
                        }
                        case 24: {
                            this.bitField0_ |= 2;
                            this.fqName_ = input.readInt32();
                            continue block37;
                        }
                        case 32: {
                            this.bitField0_ |= 4;
                            this.companionObjectName_ = input.readInt32();
                            continue block37;
                        }
                        case 42: {
                            if ((mutable_bitField0_ & 8) != 8) {
                                this.typeParameter_ = new ArrayList<TypeParameter>();
                                mutable_bitField0_ |= 8;
                            }
                            this.typeParameter_.add(input.readMessage(TypeParameter.PARSER, extensionRegistry));
                            continue block37;
                        }
                        case 50: {
                            if ((mutable_bitField0_ & 0x10) != 16) {
                                this.supertype_ = new ArrayList<Type>();
                                mutable_bitField0_ |= 0x10;
                            }
                            this.supertype_.add(input.readMessage(Type.PARSER, extensionRegistry));
                            continue block37;
                        }
                        case 56: {
                            if ((mutable_bitField0_ & 0x40) != 64) {
                                this.nestedClassName_ = new ArrayList<Integer>();
                                mutable_bitField0_ |= 0x40;
                            }
                            this.nestedClassName_.add(input.readInt32());
                            continue block37;
                        }
                        case 58: {
                            int length = input.readRawVarint32();
                            int limit = input.pushLimit(length);
                            if ((mutable_bitField0_ & 0x40) != 64 && input.getBytesUntilLimit() > 0) {
                                this.nestedClassName_ = new ArrayList<Integer>();
                                mutable_bitField0_ |= 0x40;
                            }
                            while (input.getBytesUntilLimit() > 0) {
                                this.nestedClassName_.add(input.readInt32());
                            }
                            input.popLimit(limit);
                            continue block37;
                        }
                        case 66: {
                            if ((mutable_bitField0_ & 0x80) != 128) {
                                this.constructor_ = new ArrayList<Constructor>();
                                mutable_bitField0_ |= 0x80;
                            }
                            this.constructor_.add(input.readMessage(Constructor.PARSER, extensionRegistry));
                            continue block37;
                        }
                        case 74: {
                            if ((mutable_bitField0_ & 0x100) != 256) {
                                this.function_ = new ArrayList<Function>();
                                mutable_bitField0_ |= 0x100;
                            }
                            this.function_.add(input.readMessage(Function.PARSER, extensionRegistry));
                            continue block37;
                        }
                        case 82: {
                            if ((mutable_bitField0_ & 0x200) != 512) {
                                this.property_ = new ArrayList<Property>();
                                mutable_bitField0_ |= 0x200;
                            }
                            this.property_.add(input.readMessage(Property.PARSER, extensionRegistry));
                            continue block37;
                        }
                        case 90: {
                            if ((mutable_bitField0_ & 0x400) != 1024) {
                                this.typeAlias_ = new ArrayList<TypeAlias>();
                                mutable_bitField0_ |= 0x400;
                            }
                            this.typeAlias_.add(input.readMessage(TypeAlias.PARSER, extensionRegistry));
                            continue block37;
                        }
                        case 106: {
                            if ((mutable_bitField0_ & 0x800) != 2048) {
                                this.enumEntry_ = new ArrayList<EnumEntry>();
                                mutable_bitField0_ |= 0x800;
                            }
                            this.enumEntry_.add(input.readMessage(EnumEntry.PARSER, extensionRegistry));
                            continue block37;
                        }
                        case 128: {
                            if ((mutable_bitField0_ & 0x1000) != 4096) {
                                this.sealedSubclassFqName_ = new ArrayList<Integer>();
                                mutable_bitField0_ |= 0x1000;
                            }
                            this.sealedSubclassFqName_.add(input.readInt32());
                            continue block37;
                        }
                        case 130: {
                            int length = input.readRawVarint32();
                            int limit = input.pushLimit(length);
                            if ((mutable_bitField0_ & 0x1000) != 4096 && input.getBytesUntilLimit() > 0) {
                                this.sealedSubclassFqName_ = new ArrayList<Integer>();
                                mutable_bitField0_ |= 0x1000;
                            }
                            while (input.getBytesUntilLimit() > 0) {
                                this.sealedSubclassFqName_.add(input.readInt32());
                            }
                            input.popLimit(limit);
                            continue block37;
                        }
                        case 242: {
                            TypeTable.Builder subBuilder = null;
                            if ((this.bitField0_ & 8) == 8) {
                                subBuilder = this.typeTable_.toBuilder();
                            }
                            this.typeTable_ = input.readMessage(TypeTable.PARSER, extensionRegistry);
                            if (subBuilder != null) {
                                subBuilder.mergeFrom(this.typeTable_);
                                this.typeTable_ = subBuilder.buildPartial();
                            }
                            this.bitField0_ |= 8;
                            continue block37;
                        }
                        case 248: {
                            this.bitField0_ |= 0x10;
                            this.sinceKotlinInfo_ = input.readInt32();
                            continue block37;
                        }
                        case 258: 
                    }
                    SinceKotlinInfoTable.Builder subBuilder = null;
                    if ((this.bitField0_ & 0x20) == 32) {
                        subBuilder = this.sinceKotlinInfoTable_.toBuilder();
                    }
                    this.sinceKotlinInfoTable_ = input.readMessage(SinceKotlinInfoTable.PARSER, extensionRegistry);
                    if (subBuilder != null) {
                        subBuilder.mergeFrom(this.sinceKotlinInfoTable_);
                        this.sinceKotlinInfoTable_ = subBuilder.buildPartial();
                    }
                    this.bitField0_ |= 0x20;
                }
            }
            catch (InvalidProtocolBufferException e) {
                throw e.setUnfinishedMessage(this);
            }
            catch (IOException e) {
                throw new InvalidProtocolBufferException(e.getMessage()).setUnfinishedMessage(this);
            }
            finally {
                if ((mutable_bitField0_ & 0x20) == 32) {
                    this.supertypeId_ = Collections.unmodifiableList(this.supertypeId_);
                }
                if ((mutable_bitField0_ & 8) == 8) {
                    this.typeParameter_ = Collections.unmodifiableList(this.typeParameter_);
                }
                if ((mutable_bitField0_ & 0x10) == 16) {
                    this.supertype_ = Collections.unmodifiableList(this.supertype_);
                }
                if ((mutable_bitField0_ & 0x40) == 64) {
                    this.nestedClassName_ = Collections.unmodifiableList(this.nestedClassName_);
                }
                if ((mutable_bitField0_ & 0x80) == 128) {
                    this.constructor_ = Collections.unmodifiableList(this.constructor_);
                }
                if ((mutable_bitField0_ & 0x100) == 256) {
                    this.function_ = Collections.unmodifiableList(this.function_);
                }
                if ((mutable_bitField0_ & 0x200) == 512) {
                    this.property_ = Collections.unmodifiableList(this.property_);
                }
                if ((mutable_bitField0_ & 0x400) == 1024) {
                    this.typeAlias_ = Collections.unmodifiableList(this.typeAlias_);
                }
                if ((mutable_bitField0_ & 0x800) == 2048) {
                    this.enumEntry_ = Collections.unmodifiableList(this.enumEntry_);
                }
                if ((mutable_bitField0_ & 0x1000) == 4096) {
                    this.sealedSubclassFqName_ = Collections.unmodifiableList(this.sealedSubclassFqName_);
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

        public Parser<Class> getParserForType() {
            return PARSER;
        }

        @Override
        public boolean hasFlags() {
            return (this.bitField0_ & 1) == 1;
        }

        @Override
        public int getFlags() {
            return this.flags_;
        }

        @Override
        public boolean hasFqName() {
            return (this.bitField0_ & 2) == 2;
        }

        @Override
        public int getFqName() {
            return this.fqName_;
        }

        @Override
        public boolean hasCompanionObjectName() {
            return (this.bitField0_ & 4) == 4;
        }

        @Override
        public int getCompanionObjectName() {
            return this.companionObjectName_;
        }

        @Override
        public List<TypeParameter> getTypeParameterList() {
            return this.typeParameter_;
        }

        public List<? extends TypeParameterOrBuilder> getTypeParameterOrBuilderList() {
            return this.typeParameter_;
        }

        @Override
        public int getTypeParameterCount() {
            return this.typeParameter_.size();
        }

        @Override
        public TypeParameter getTypeParameter(int index) {
            return this.typeParameter_.get(index);
        }

        public TypeParameterOrBuilder getTypeParameterOrBuilder(int index) {
            return this.typeParameter_.get(index);
        }

        @Override
        public List<Type> getSupertypeList() {
            return this.supertype_;
        }

        public List<? extends TypeOrBuilder> getSupertypeOrBuilderList() {
            return this.supertype_;
        }

        @Override
        public int getSupertypeCount() {
            return this.supertype_.size();
        }

        @Override
        public Type getSupertype(int index) {
            return this.supertype_.get(index);
        }

        public TypeOrBuilder getSupertypeOrBuilder(int index) {
            return this.supertype_.get(index);
        }

        @Override
        public List<Integer> getSupertypeIdList() {
            return this.supertypeId_;
        }

        @Override
        public int getSupertypeIdCount() {
            return this.supertypeId_.size();
        }

        @Override
        public int getSupertypeId(int index) {
            return this.supertypeId_.get(index);
        }

        @Override
        public List<Integer> getNestedClassNameList() {
            return this.nestedClassName_;
        }

        @Override
        public int getNestedClassNameCount() {
            return this.nestedClassName_.size();
        }

        @Override
        public int getNestedClassName(int index) {
            return this.nestedClassName_.get(index);
        }

        @Override
        public List<Constructor> getConstructorList() {
            return this.constructor_;
        }

        public List<? extends ConstructorOrBuilder> getConstructorOrBuilderList() {
            return this.constructor_;
        }

        @Override
        public int getConstructorCount() {
            return this.constructor_.size();
        }

        @Override
        public Constructor getConstructor(int index) {
            return this.constructor_.get(index);
        }

        public ConstructorOrBuilder getConstructorOrBuilder(int index) {
            return this.constructor_.get(index);
        }

        @Override
        public List<Function> getFunctionList() {
            return this.function_;
        }

        public List<? extends FunctionOrBuilder> getFunctionOrBuilderList() {
            return this.function_;
        }

        @Override
        public int getFunctionCount() {
            return this.function_.size();
        }

        @Override
        public Function getFunction(int index) {
            return this.function_.get(index);
        }

        public FunctionOrBuilder getFunctionOrBuilder(int index) {
            return this.function_.get(index);
        }

        @Override
        public List<Property> getPropertyList() {
            return this.property_;
        }

        public List<? extends PropertyOrBuilder> getPropertyOrBuilderList() {
            return this.property_;
        }

        @Override
        public int getPropertyCount() {
            return this.property_.size();
        }

        @Override
        public Property getProperty(int index) {
            return this.property_.get(index);
        }

        public PropertyOrBuilder getPropertyOrBuilder(int index) {
            return this.property_.get(index);
        }

        @Override
        public List<TypeAlias> getTypeAliasList() {
            return this.typeAlias_;
        }

        public List<? extends TypeAliasOrBuilder> getTypeAliasOrBuilderList() {
            return this.typeAlias_;
        }

        @Override
        public int getTypeAliasCount() {
            return this.typeAlias_.size();
        }

        @Override
        public TypeAlias getTypeAlias(int index) {
            return this.typeAlias_.get(index);
        }

        public TypeAliasOrBuilder getTypeAliasOrBuilder(int index) {
            return this.typeAlias_.get(index);
        }

        @Override
        public List<EnumEntry> getEnumEntryList() {
            return this.enumEntry_;
        }

        public List<? extends EnumEntryOrBuilder> getEnumEntryOrBuilderList() {
            return this.enumEntry_;
        }

        @Override
        public int getEnumEntryCount() {
            return this.enumEntry_.size();
        }

        @Override
        public EnumEntry getEnumEntry(int index) {
            return this.enumEntry_.get(index);
        }

        public EnumEntryOrBuilder getEnumEntryOrBuilder(int index) {
            return this.enumEntry_.get(index);
        }

        @Override
        public List<Integer> getSealedSubclassFqNameList() {
            return this.sealedSubclassFqName_;
        }

        @Override
        public int getSealedSubclassFqNameCount() {
            return this.sealedSubclassFqName_.size();
        }

        @Override
        public int getSealedSubclassFqName(int index) {
            return this.sealedSubclassFqName_.get(index);
        }

        @Override
        public boolean hasTypeTable() {
            return (this.bitField0_ & 8) == 8;
        }

        @Override
        public TypeTable getTypeTable() {
            return this.typeTable_;
        }

        @Override
        public boolean hasSinceKotlinInfo() {
            return (this.bitField0_ & 0x10) == 16;
        }

        @Override
        public int getSinceKotlinInfo() {
            return this.sinceKotlinInfo_;
        }

        @Override
        public boolean hasSinceKotlinInfoTable() {
            return (this.bitField0_ & 0x20) == 32;
        }

        @Override
        public SinceKotlinInfoTable getSinceKotlinInfoTable() {
            return this.sinceKotlinInfoTable_;
        }

        private void initFields() {
            this.flags_ = 6;
            this.fqName_ = 0;
            this.companionObjectName_ = 0;
            this.typeParameter_ = Collections.emptyList();
            this.supertype_ = Collections.emptyList();
            this.supertypeId_ = Collections.emptyList();
            this.nestedClassName_ = Collections.emptyList();
            this.constructor_ = Collections.emptyList();
            this.function_ = Collections.emptyList();
            this.property_ = Collections.emptyList();
            this.typeAlias_ = Collections.emptyList();
            this.enumEntry_ = Collections.emptyList();
            this.sealedSubclassFqName_ = Collections.emptyList();
            this.typeTable_ = TypeTable.getDefaultInstance();
            this.sinceKotlinInfo_ = 0;
            this.sinceKotlinInfoTable_ = SinceKotlinInfoTable.getDefaultInstance();
        }

        @Override
        public final boolean isInitialized() {
            int i;
            byte isInitialized = this.memoizedIsInitialized;
            if (isInitialized == 1) {
                return true;
            }
            if (isInitialized == 0) {
                return false;
            }
            if (!this.hasFqName()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            for (i = 0; i < this.getTypeParameterCount(); ++i) {
                if (this.getTypeParameter(i).isInitialized()) continue;
                this.memoizedIsInitialized = 0;
                return false;
            }
            for (i = 0; i < this.getSupertypeCount(); ++i) {
                if (this.getSupertype(i).isInitialized()) continue;
                this.memoizedIsInitialized = 0;
                return false;
            }
            for (i = 0; i < this.getConstructorCount(); ++i) {
                if (this.getConstructor(i).isInitialized()) continue;
                this.memoizedIsInitialized = 0;
                return false;
            }
            for (i = 0; i < this.getFunctionCount(); ++i) {
                if (this.getFunction(i).isInitialized()) continue;
                this.memoizedIsInitialized = 0;
                return false;
            }
            for (i = 0; i < this.getPropertyCount(); ++i) {
                if (this.getProperty(i).isInitialized()) continue;
                this.memoizedIsInitialized = 0;
                return false;
            }
            for (i = 0; i < this.getTypeAliasCount(); ++i) {
                if (this.getTypeAlias(i).isInitialized()) continue;
                this.memoizedIsInitialized = 0;
                return false;
            }
            for (i = 0; i < this.getEnumEntryCount(); ++i) {
                if (this.getEnumEntry(i).isInitialized()) continue;
                this.memoizedIsInitialized = 0;
                return false;
            }
            if (this.hasTypeTable() && !this.getTypeTable().isInitialized()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            if (!this.extensionsAreInitialized()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            this.memoizedIsInitialized = 1;
            return true;
        }

        @Override
        public void writeTo(CodedOutputStream output) throws IOException {
            int i;
            this.getSerializedSize();
            GeneratedMessageLite.ExtendableMessage.ExtensionWriter extensionWriter = this.newExtensionWriter();
            if ((this.bitField0_ & 1) == 1) {
                output.writeInt32(1, this.flags_);
            }
            if (this.getSupertypeIdList().size() > 0) {
                output.writeRawVarint32(18);
                output.writeRawVarint32(this.supertypeIdMemoizedSerializedSize);
            }
            for (i = 0; i < this.supertypeId_.size(); ++i) {
                output.writeInt32NoTag(this.supertypeId_.get(i));
            }
            if ((this.bitField0_ & 2) == 2) {
                output.writeInt32(3, this.fqName_);
            }
            if ((this.bitField0_ & 4) == 4) {
                output.writeInt32(4, this.companionObjectName_);
            }
            for (i = 0; i < this.typeParameter_.size(); ++i) {
                output.writeMessage(5, this.typeParameter_.get(i));
            }
            for (i = 0; i < this.supertype_.size(); ++i) {
                output.writeMessage(6, this.supertype_.get(i));
            }
            if (this.getNestedClassNameList().size() > 0) {
                output.writeRawVarint32(58);
                output.writeRawVarint32(this.nestedClassNameMemoizedSerializedSize);
            }
            for (i = 0; i < this.nestedClassName_.size(); ++i) {
                output.writeInt32NoTag(this.nestedClassName_.get(i));
            }
            for (i = 0; i < this.constructor_.size(); ++i) {
                output.writeMessage(8, this.constructor_.get(i));
            }
            for (i = 0; i < this.function_.size(); ++i) {
                output.writeMessage(9, this.function_.get(i));
            }
            for (i = 0; i < this.property_.size(); ++i) {
                output.writeMessage(10, this.property_.get(i));
            }
            for (i = 0; i < this.typeAlias_.size(); ++i) {
                output.writeMessage(11, this.typeAlias_.get(i));
            }
            for (i = 0; i < this.enumEntry_.size(); ++i) {
                output.writeMessage(13, this.enumEntry_.get(i));
            }
            if (this.getSealedSubclassFqNameList().size() > 0) {
                output.writeRawVarint32(130);
                output.writeRawVarint32(this.sealedSubclassFqNameMemoizedSerializedSize);
            }
            for (i = 0; i < this.sealedSubclassFqName_.size(); ++i) {
                output.writeInt32NoTag(this.sealedSubclassFqName_.get(i));
            }
            if ((this.bitField0_ & 8) == 8) {
                output.writeMessage(30, this.typeTable_);
            }
            if ((this.bitField0_ & 0x10) == 16) {
                output.writeInt32(31, this.sinceKotlinInfo_);
            }
            if ((this.bitField0_ & 0x20) == 32) {
                output.writeMessage(32, this.sinceKotlinInfoTable_);
            }
            extensionWriter.writeUntil(200, output);
            output.writeRawBytes(this.unknownFields);
        }

        @Override
        public int getSerializedSize() {
            int i;
            int i2;
            int size = this.memoizedSerializedSize;
            if (size != -1) {
                return size;
            }
            size = 0;
            if ((this.bitField0_ & 1) == 1) {
                size += CodedOutputStream.computeInt32Size(1, this.flags_);
            }
            int dataSize = 0;
            for (i2 = 0; i2 < this.supertypeId_.size(); ++i2) {
                dataSize += CodedOutputStream.computeInt32SizeNoTag(this.supertypeId_.get(i2));
            }
            size += dataSize;
            if (!this.getSupertypeIdList().isEmpty()) {
                ++size;
                size += CodedOutputStream.computeInt32SizeNoTag(dataSize);
            }
            this.supertypeIdMemoizedSerializedSize = dataSize;
            if ((this.bitField0_ & 2) == 2) {
                size += CodedOutputStream.computeInt32Size(3, this.fqName_);
            }
            if ((this.bitField0_ & 4) == 4) {
                size += CodedOutputStream.computeInt32Size(4, this.companionObjectName_);
            }
            for (i = 0; i < this.typeParameter_.size(); ++i) {
                size += CodedOutputStream.computeMessageSize(5, this.typeParameter_.get(i));
            }
            for (i = 0; i < this.supertype_.size(); ++i) {
                size += CodedOutputStream.computeMessageSize(6, this.supertype_.get(i));
            }
            dataSize = 0;
            for (i2 = 0; i2 < this.nestedClassName_.size(); ++i2) {
                dataSize += CodedOutputStream.computeInt32SizeNoTag(this.nestedClassName_.get(i2));
            }
            size += dataSize;
            if (!this.getNestedClassNameList().isEmpty()) {
                ++size;
                size += CodedOutputStream.computeInt32SizeNoTag(dataSize);
            }
            this.nestedClassNameMemoizedSerializedSize = dataSize;
            for (i = 0; i < this.constructor_.size(); ++i) {
                size += CodedOutputStream.computeMessageSize(8, this.constructor_.get(i));
            }
            for (i = 0; i < this.function_.size(); ++i) {
                size += CodedOutputStream.computeMessageSize(9, this.function_.get(i));
            }
            for (i = 0; i < this.property_.size(); ++i) {
                size += CodedOutputStream.computeMessageSize(10, this.property_.get(i));
            }
            for (i = 0; i < this.typeAlias_.size(); ++i) {
                size += CodedOutputStream.computeMessageSize(11, this.typeAlias_.get(i));
            }
            for (i = 0; i < this.enumEntry_.size(); ++i) {
                size += CodedOutputStream.computeMessageSize(13, this.enumEntry_.get(i));
            }
            dataSize = 0;
            for (i2 = 0; i2 < this.sealedSubclassFqName_.size(); ++i2) {
                dataSize += CodedOutputStream.computeInt32SizeNoTag(this.sealedSubclassFqName_.get(i2));
            }
            size += dataSize;
            if (!this.getSealedSubclassFqNameList().isEmpty()) {
                size += 2;
                size += CodedOutputStream.computeInt32SizeNoTag(dataSize);
            }
            this.sealedSubclassFqNameMemoizedSerializedSize = dataSize;
            if ((this.bitField0_ & 8) == 8) {
                size += CodedOutputStream.computeMessageSize(30, this.typeTable_);
            }
            if ((this.bitField0_ & 0x10) == 16) {
                size += CodedOutputStream.computeInt32Size(31, this.sinceKotlinInfo_);
            }
            if ((this.bitField0_ & 0x20) == 32) {
                size += CodedOutputStream.computeMessageSize(32, this.sinceKotlinInfoTable_);
            }
            size += this.extensionsSerializedSize();
            this.memoizedSerializedSize = size += this.unknownFields.size();
            return size;
        }

        @Override
        protected Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }

        public static Class parseFrom(ByteString data2) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data2);
        }

        public static Class parseFrom(ByteString data2, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data2, extensionRegistry);
        }

        public static Class parseFrom(byte[] data2) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data2);
        }

        public static Class parseFrom(byte[] data2, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data2, extensionRegistry);
        }

        public static Class parseFrom(InputStream input) throws IOException {
            return PARSER.parseFrom(input);
        }

        public static Class parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return PARSER.parseFrom(input, extensionRegistry);
        }

        public static Class parseDelimitedFrom(InputStream input) throws IOException {
            return PARSER.parseDelimitedFrom(input);
        }

        public static Class parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return PARSER.parseDelimitedFrom(input, extensionRegistry);
        }

        public static Class parseFrom(CodedInputStream input) throws IOException {
            return PARSER.parseFrom(input);
        }

        public static Class parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return PARSER.parseFrom(input, extensionRegistry);
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        @Override
        public Builder newBuilderForType() {
            return Class.newBuilder();
        }

        public static Builder newBuilder(Class prototype) {
            return Class.newBuilder().mergeFrom(prototype);
        }

        @Override
        public Builder toBuilder() {
            return Class.newBuilder(this);
        }

        static {
            PARSER = new AbstractParser<Class>(){

                @Override
                public Class parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                    return new Class(input, extensionRegistry);
                }
            };
            defaultInstance = new Class(true);
            defaultInstance.initFields();
        }

        public static final class Builder
        extends GeneratedMessageLite.ExtendableBuilder<Class, Builder>
        implements ClassOrBuilder {
            private int bitField0_;
            private int flags_ = 6;
            private int fqName_;
            private int companionObjectName_;
            private List<TypeParameter> typeParameter_ = Collections.emptyList();
            private List<Type> supertype_ = Collections.emptyList();
            private List<Integer> supertypeId_ = Collections.emptyList();
            private List<Integer> nestedClassName_ = Collections.emptyList();
            private List<Constructor> constructor_ = Collections.emptyList();
            private List<Function> function_ = Collections.emptyList();
            private List<Property> property_ = Collections.emptyList();
            private List<TypeAlias> typeAlias_ = Collections.emptyList();
            private List<EnumEntry> enumEntry_ = Collections.emptyList();
            private List<Integer> sealedSubclassFqName_ = Collections.emptyList();
            private TypeTable typeTable_ = TypeTable.getDefaultInstance();
            private int sinceKotlinInfo_;
            private SinceKotlinInfoTable sinceKotlinInfoTable_ = SinceKotlinInfoTable.getDefaultInstance();

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
                this.flags_ = 6;
                this.bitField0_ &= 0xFFFFFFFE;
                this.fqName_ = 0;
                this.bitField0_ &= 0xFFFFFFFD;
                this.companionObjectName_ = 0;
                this.bitField0_ &= 0xFFFFFFFB;
                this.typeParameter_ = Collections.emptyList();
                this.bitField0_ &= 0xFFFFFFF7;
                this.supertype_ = Collections.emptyList();
                this.bitField0_ &= 0xFFFFFFEF;
                this.supertypeId_ = Collections.emptyList();
                this.bitField0_ &= 0xFFFFFFDF;
                this.nestedClassName_ = Collections.emptyList();
                this.bitField0_ &= 0xFFFFFFBF;
                this.constructor_ = Collections.emptyList();
                this.bitField0_ &= 0xFFFFFF7F;
                this.function_ = Collections.emptyList();
                this.bitField0_ &= 0xFFFFFEFF;
                this.property_ = Collections.emptyList();
                this.bitField0_ &= 0xFFFFFDFF;
                this.typeAlias_ = Collections.emptyList();
                this.bitField0_ &= 0xFFFFFBFF;
                this.enumEntry_ = Collections.emptyList();
                this.bitField0_ &= 0xFFFFF7FF;
                this.sealedSubclassFqName_ = Collections.emptyList();
                this.bitField0_ &= 0xFFFFEFFF;
                this.typeTable_ = TypeTable.getDefaultInstance();
                this.bitField0_ &= 0xFFFFDFFF;
                this.sinceKotlinInfo_ = 0;
                this.bitField0_ &= 0xFFFFBFFF;
                this.sinceKotlinInfoTable_ = SinceKotlinInfoTable.getDefaultInstance();
                this.bitField0_ &= 0xFFFF7FFF;
                return this;
            }

            @Override
            public Builder clone() {
                return Builder.create().mergeFrom(this.buildPartial());
            }

            @Override
            public Class getDefaultInstanceForType() {
                return Class.getDefaultInstance();
            }

            @Override
            public Class build() {
                Class result2 = this.buildPartial();
                if (!result2.isInitialized()) {
                    throw Builder.newUninitializedMessageException(result2);
                }
                return result2;
            }

            @Override
            public Class buildPartial() {
                Class result2 = new Class(this);
                int from_bitField0_ = this.bitField0_;
                int to_bitField0_ = 0;
                if ((from_bitField0_ & 1) == 1) {
                    to_bitField0_ |= 1;
                }
                result2.flags_ = this.flags_;
                if ((from_bitField0_ & 2) == 2) {
                    to_bitField0_ |= 2;
                }
                result2.fqName_ = this.fqName_;
                if ((from_bitField0_ & 4) == 4) {
                    to_bitField0_ |= 4;
                }
                result2.companionObjectName_ = this.companionObjectName_;
                if ((this.bitField0_ & 8) == 8) {
                    this.typeParameter_ = Collections.unmodifiableList(this.typeParameter_);
                    this.bitField0_ &= 0xFFFFFFF7;
                }
                result2.typeParameter_ = this.typeParameter_;
                if ((this.bitField0_ & 0x10) == 16) {
                    this.supertype_ = Collections.unmodifiableList(this.supertype_);
                    this.bitField0_ &= 0xFFFFFFEF;
                }
                result2.supertype_ = this.supertype_;
                if ((this.bitField0_ & 0x20) == 32) {
                    this.supertypeId_ = Collections.unmodifiableList(this.supertypeId_);
                    this.bitField0_ &= 0xFFFFFFDF;
                }
                result2.supertypeId_ = this.supertypeId_;
                if ((this.bitField0_ & 0x40) == 64) {
                    this.nestedClassName_ = Collections.unmodifiableList(this.nestedClassName_);
                    this.bitField0_ &= 0xFFFFFFBF;
                }
                result2.nestedClassName_ = this.nestedClassName_;
                if ((this.bitField0_ & 0x80) == 128) {
                    this.constructor_ = Collections.unmodifiableList(this.constructor_);
                    this.bitField0_ &= 0xFFFFFF7F;
                }
                result2.constructor_ = this.constructor_;
                if ((this.bitField0_ & 0x100) == 256) {
                    this.function_ = Collections.unmodifiableList(this.function_);
                    this.bitField0_ &= 0xFFFFFEFF;
                }
                result2.function_ = this.function_;
                if ((this.bitField0_ & 0x200) == 512) {
                    this.property_ = Collections.unmodifiableList(this.property_);
                    this.bitField0_ &= 0xFFFFFDFF;
                }
                result2.property_ = this.property_;
                if ((this.bitField0_ & 0x400) == 1024) {
                    this.typeAlias_ = Collections.unmodifiableList(this.typeAlias_);
                    this.bitField0_ &= 0xFFFFFBFF;
                }
                result2.typeAlias_ = this.typeAlias_;
                if ((this.bitField0_ & 0x800) == 2048) {
                    this.enumEntry_ = Collections.unmodifiableList(this.enumEntry_);
                    this.bitField0_ &= 0xFFFFF7FF;
                }
                result2.enumEntry_ = this.enumEntry_;
                if ((this.bitField0_ & 0x1000) == 4096) {
                    this.sealedSubclassFqName_ = Collections.unmodifiableList(this.sealedSubclassFqName_);
                    this.bitField0_ &= 0xFFFFEFFF;
                }
                result2.sealedSubclassFqName_ = this.sealedSubclassFqName_;
                if ((from_bitField0_ & 0x2000) == 8192) {
                    to_bitField0_ |= 8;
                }
                result2.typeTable_ = this.typeTable_;
                if ((from_bitField0_ & 0x4000) == 16384) {
                    to_bitField0_ |= 0x10;
                }
                result2.sinceKotlinInfo_ = this.sinceKotlinInfo_;
                if ((from_bitField0_ & 0x8000) == 32768) {
                    to_bitField0_ |= 0x20;
                }
                result2.sinceKotlinInfoTable_ = this.sinceKotlinInfoTable_;
                result2.bitField0_ = to_bitField0_;
                return result2;
            }

            @Override
            public Builder mergeFrom(Class other) {
                if (other == Class.getDefaultInstance()) {
                    return this;
                }
                if (other.hasFlags()) {
                    this.setFlags(other.getFlags());
                }
                if (other.hasFqName()) {
                    this.setFqName(other.getFqName());
                }
                if (other.hasCompanionObjectName()) {
                    this.setCompanionObjectName(other.getCompanionObjectName());
                }
                if (!other.typeParameter_.isEmpty()) {
                    if (this.typeParameter_.isEmpty()) {
                        this.typeParameter_ = other.typeParameter_;
                        this.bitField0_ &= 0xFFFFFFF7;
                    } else {
                        this.ensureTypeParameterIsMutable();
                        this.typeParameter_.addAll(other.typeParameter_);
                    }
                }
                if (!other.supertype_.isEmpty()) {
                    if (this.supertype_.isEmpty()) {
                        this.supertype_ = other.supertype_;
                        this.bitField0_ &= 0xFFFFFFEF;
                    } else {
                        this.ensureSupertypeIsMutable();
                        this.supertype_.addAll(other.supertype_);
                    }
                }
                if (!other.supertypeId_.isEmpty()) {
                    if (this.supertypeId_.isEmpty()) {
                        this.supertypeId_ = other.supertypeId_;
                        this.bitField0_ &= 0xFFFFFFDF;
                    } else {
                        this.ensureSupertypeIdIsMutable();
                        this.supertypeId_.addAll(other.supertypeId_);
                    }
                }
                if (!other.nestedClassName_.isEmpty()) {
                    if (this.nestedClassName_.isEmpty()) {
                        this.nestedClassName_ = other.nestedClassName_;
                        this.bitField0_ &= 0xFFFFFFBF;
                    } else {
                        this.ensureNestedClassNameIsMutable();
                        this.nestedClassName_.addAll(other.nestedClassName_);
                    }
                }
                if (!other.constructor_.isEmpty()) {
                    if (this.constructor_.isEmpty()) {
                        this.constructor_ = other.constructor_;
                        this.bitField0_ &= 0xFFFFFF7F;
                    } else {
                        this.ensureConstructorIsMutable();
                        this.constructor_.addAll(other.constructor_);
                    }
                }
                if (!other.function_.isEmpty()) {
                    if (this.function_.isEmpty()) {
                        this.function_ = other.function_;
                        this.bitField0_ &= 0xFFFFFEFF;
                    } else {
                        this.ensureFunctionIsMutable();
                        this.function_.addAll(other.function_);
                    }
                }
                if (!other.property_.isEmpty()) {
                    if (this.property_.isEmpty()) {
                        this.property_ = other.property_;
                        this.bitField0_ &= 0xFFFFFDFF;
                    } else {
                        this.ensurePropertyIsMutable();
                        this.property_.addAll(other.property_);
                    }
                }
                if (!other.typeAlias_.isEmpty()) {
                    if (this.typeAlias_.isEmpty()) {
                        this.typeAlias_ = other.typeAlias_;
                        this.bitField0_ &= 0xFFFFFBFF;
                    } else {
                        this.ensureTypeAliasIsMutable();
                        this.typeAlias_.addAll(other.typeAlias_);
                    }
                }
                if (!other.enumEntry_.isEmpty()) {
                    if (this.enumEntry_.isEmpty()) {
                        this.enumEntry_ = other.enumEntry_;
                        this.bitField0_ &= 0xFFFFF7FF;
                    } else {
                        this.ensureEnumEntryIsMutable();
                        this.enumEntry_.addAll(other.enumEntry_);
                    }
                }
                if (!other.sealedSubclassFqName_.isEmpty()) {
                    if (this.sealedSubclassFqName_.isEmpty()) {
                        this.sealedSubclassFqName_ = other.sealedSubclassFqName_;
                        this.bitField0_ &= 0xFFFFEFFF;
                    } else {
                        this.ensureSealedSubclassFqNameIsMutable();
                        this.sealedSubclassFqName_.addAll(other.sealedSubclassFqName_);
                    }
                }
                if (other.hasTypeTable()) {
                    this.mergeTypeTable(other.getTypeTable());
                }
                if (other.hasSinceKotlinInfo()) {
                    this.setSinceKotlinInfo(other.getSinceKotlinInfo());
                }
                if (other.hasSinceKotlinInfoTable()) {
                    this.mergeSinceKotlinInfoTable(other.getSinceKotlinInfoTable());
                }
                this.mergeExtensionFields(other);
                this.setUnknownFields(this.getUnknownFields().concat(other.unknownFields));
                return this;
            }

            @Override
            public final boolean isInitialized() {
                int i;
                if (!this.hasFqName()) {
                    return false;
                }
                for (i = 0; i < this.getTypeParameterCount(); ++i) {
                    if (this.getTypeParameter(i).isInitialized()) continue;
                    return false;
                }
                for (i = 0; i < this.getSupertypeCount(); ++i) {
                    if (this.getSupertype(i).isInitialized()) continue;
                    return false;
                }
                for (i = 0; i < this.getConstructorCount(); ++i) {
                    if (this.getConstructor(i).isInitialized()) continue;
                    return false;
                }
                for (i = 0; i < this.getFunctionCount(); ++i) {
                    if (this.getFunction(i).isInitialized()) continue;
                    return false;
                }
                for (i = 0; i < this.getPropertyCount(); ++i) {
                    if (this.getProperty(i).isInitialized()) continue;
                    return false;
                }
                for (i = 0; i < this.getTypeAliasCount(); ++i) {
                    if (this.getTypeAlias(i).isInitialized()) continue;
                    return false;
                }
                for (i = 0; i < this.getEnumEntryCount(); ++i) {
                    if (this.getEnumEntry(i).isInitialized()) continue;
                    return false;
                }
                if (this.hasTypeTable() && !this.getTypeTable().isInitialized()) {
                    return false;
                }
                return this.extensionsAreInitialized();
            }

            @Override
            public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                Class parsedMessage = null;
                try {
                    parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
                }
                catch (InvalidProtocolBufferException e) {
                    parsedMessage = (Class)e.getUnfinishedMessage();
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
            public boolean hasFlags() {
                return (this.bitField0_ & 1) == 1;
            }

            @Override
            public int getFlags() {
                return this.flags_;
            }

            public Builder setFlags(int value) {
                this.bitField0_ |= 1;
                this.flags_ = value;
                return this;
            }

            public Builder clearFlags() {
                this.bitField0_ &= 0xFFFFFFFE;
                this.flags_ = 6;
                return this;
            }

            @Override
            public boolean hasFqName() {
                return (this.bitField0_ & 2) == 2;
            }

            @Override
            public int getFqName() {
                return this.fqName_;
            }

            public Builder setFqName(int value) {
                this.bitField0_ |= 2;
                this.fqName_ = value;
                return this;
            }

            public Builder clearFqName() {
                this.bitField0_ &= 0xFFFFFFFD;
                this.fqName_ = 0;
                return this;
            }

            @Override
            public boolean hasCompanionObjectName() {
                return (this.bitField0_ & 4) == 4;
            }

            @Override
            public int getCompanionObjectName() {
                return this.companionObjectName_;
            }

            public Builder setCompanionObjectName(int value) {
                this.bitField0_ |= 4;
                this.companionObjectName_ = value;
                return this;
            }

            public Builder clearCompanionObjectName() {
                this.bitField0_ &= 0xFFFFFFFB;
                this.companionObjectName_ = 0;
                return this;
            }

            private void ensureTypeParameterIsMutable() {
                if ((this.bitField0_ & 8) != 8) {
                    this.typeParameter_ = new ArrayList<TypeParameter>(this.typeParameter_);
                    this.bitField0_ |= 8;
                }
            }

            @Override
            public List<TypeParameter> getTypeParameterList() {
                return Collections.unmodifiableList(this.typeParameter_);
            }

            @Override
            public int getTypeParameterCount() {
                return this.typeParameter_.size();
            }

            @Override
            public TypeParameter getTypeParameter(int index) {
                return this.typeParameter_.get(index);
            }

            public Builder setTypeParameter(int index, TypeParameter value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.ensureTypeParameterIsMutable();
                this.typeParameter_.set(index, value);
                return this;
            }

            public Builder setTypeParameter(int index, TypeParameter.Builder builderForValue) {
                this.ensureTypeParameterIsMutable();
                this.typeParameter_.set(index, builderForValue.build());
                return this;
            }

            public Builder addTypeParameter(TypeParameter value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.ensureTypeParameterIsMutable();
                this.typeParameter_.add(value);
                return this;
            }

            public Builder addTypeParameter(int index, TypeParameter value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.ensureTypeParameterIsMutable();
                this.typeParameter_.add(index, value);
                return this;
            }

            public Builder addTypeParameter(TypeParameter.Builder builderForValue) {
                this.ensureTypeParameterIsMutable();
                this.typeParameter_.add(builderForValue.build());
                return this;
            }

            public Builder addTypeParameter(int index, TypeParameter.Builder builderForValue) {
                this.ensureTypeParameterIsMutable();
                this.typeParameter_.add(index, builderForValue.build());
                return this;
            }

            public Builder addAllTypeParameter(Iterable<? extends TypeParameter> values2) {
                this.ensureTypeParameterIsMutable();
                AbstractMessageLite.Builder.addAll(values2, this.typeParameter_);
                return this;
            }

            public Builder clearTypeParameter() {
                this.typeParameter_ = Collections.emptyList();
                this.bitField0_ &= 0xFFFFFFF7;
                return this;
            }

            public Builder removeTypeParameter(int index) {
                this.ensureTypeParameterIsMutable();
                this.typeParameter_.remove(index);
                return this;
            }

            private void ensureSupertypeIsMutable() {
                if ((this.bitField0_ & 0x10) != 16) {
                    this.supertype_ = new ArrayList<Type>(this.supertype_);
                    this.bitField0_ |= 0x10;
                }
            }

            @Override
            public List<Type> getSupertypeList() {
                return Collections.unmodifiableList(this.supertype_);
            }

            @Override
            public int getSupertypeCount() {
                return this.supertype_.size();
            }

            @Override
            public Type getSupertype(int index) {
                return this.supertype_.get(index);
            }

            public Builder setSupertype(int index, Type value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.ensureSupertypeIsMutable();
                this.supertype_.set(index, value);
                return this;
            }

            public Builder setSupertype(int index, Type.Builder builderForValue) {
                this.ensureSupertypeIsMutable();
                this.supertype_.set(index, builderForValue.build());
                return this;
            }

            public Builder addSupertype(Type value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.ensureSupertypeIsMutable();
                this.supertype_.add(value);
                return this;
            }

            public Builder addSupertype(int index, Type value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.ensureSupertypeIsMutable();
                this.supertype_.add(index, value);
                return this;
            }

            public Builder addSupertype(Type.Builder builderForValue) {
                this.ensureSupertypeIsMutable();
                this.supertype_.add(builderForValue.build());
                return this;
            }

            public Builder addSupertype(int index, Type.Builder builderForValue) {
                this.ensureSupertypeIsMutable();
                this.supertype_.add(index, builderForValue.build());
                return this;
            }

            public Builder addAllSupertype(Iterable<? extends Type> values2) {
                this.ensureSupertypeIsMutable();
                AbstractMessageLite.Builder.addAll(values2, this.supertype_);
                return this;
            }

            public Builder clearSupertype() {
                this.supertype_ = Collections.emptyList();
                this.bitField0_ &= 0xFFFFFFEF;
                return this;
            }

            public Builder removeSupertype(int index) {
                this.ensureSupertypeIsMutable();
                this.supertype_.remove(index);
                return this;
            }

            private void ensureSupertypeIdIsMutable() {
                if ((this.bitField0_ & 0x20) != 32) {
                    this.supertypeId_ = new ArrayList<Integer>(this.supertypeId_);
                    this.bitField0_ |= 0x20;
                }
            }

            @Override
            public List<Integer> getSupertypeIdList() {
                return Collections.unmodifiableList(this.supertypeId_);
            }

            @Override
            public int getSupertypeIdCount() {
                return this.supertypeId_.size();
            }

            @Override
            public int getSupertypeId(int index) {
                return this.supertypeId_.get(index);
            }

            public Builder setSupertypeId(int index, int value) {
                this.ensureSupertypeIdIsMutable();
                this.supertypeId_.set(index, value);
                return this;
            }

            public Builder addSupertypeId(int value) {
                this.ensureSupertypeIdIsMutable();
                this.supertypeId_.add(value);
                return this;
            }

            public Builder addAllSupertypeId(Iterable<? extends Integer> values2) {
                this.ensureSupertypeIdIsMutable();
                AbstractMessageLite.Builder.addAll(values2, this.supertypeId_);
                return this;
            }

            public Builder clearSupertypeId() {
                this.supertypeId_ = Collections.emptyList();
                this.bitField0_ &= 0xFFFFFFDF;
                return this;
            }

            private void ensureNestedClassNameIsMutable() {
                if ((this.bitField0_ & 0x40) != 64) {
                    this.nestedClassName_ = new ArrayList<Integer>(this.nestedClassName_);
                    this.bitField0_ |= 0x40;
                }
            }

            @Override
            public List<Integer> getNestedClassNameList() {
                return Collections.unmodifiableList(this.nestedClassName_);
            }

            @Override
            public int getNestedClassNameCount() {
                return this.nestedClassName_.size();
            }

            @Override
            public int getNestedClassName(int index) {
                return this.nestedClassName_.get(index);
            }

            public Builder setNestedClassName(int index, int value) {
                this.ensureNestedClassNameIsMutable();
                this.nestedClassName_.set(index, value);
                return this;
            }

            public Builder addNestedClassName(int value) {
                this.ensureNestedClassNameIsMutable();
                this.nestedClassName_.add(value);
                return this;
            }

            public Builder addAllNestedClassName(Iterable<? extends Integer> values2) {
                this.ensureNestedClassNameIsMutable();
                AbstractMessageLite.Builder.addAll(values2, this.nestedClassName_);
                return this;
            }

            public Builder clearNestedClassName() {
                this.nestedClassName_ = Collections.emptyList();
                this.bitField0_ &= 0xFFFFFFBF;
                return this;
            }

            private void ensureConstructorIsMutable() {
                if ((this.bitField0_ & 0x80) != 128) {
                    this.constructor_ = new ArrayList<Constructor>(this.constructor_);
                    this.bitField0_ |= 0x80;
                }
            }

            @Override
            public List<Constructor> getConstructorList() {
                return Collections.unmodifiableList(this.constructor_);
            }

            @Override
            public int getConstructorCount() {
                return this.constructor_.size();
            }

            @Override
            public Constructor getConstructor(int index) {
                return this.constructor_.get(index);
            }

            public Builder setConstructor(int index, Constructor value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.ensureConstructorIsMutable();
                this.constructor_.set(index, value);
                return this;
            }

            public Builder setConstructor(int index, Constructor.Builder builderForValue) {
                this.ensureConstructorIsMutable();
                this.constructor_.set(index, builderForValue.build());
                return this;
            }

            public Builder addConstructor(Constructor value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.ensureConstructorIsMutable();
                this.constructor_.add(value);
                return this;
            }

            public Builder addConstructor(int index, Constructor value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.ensureConstructorIsMutable();
                this.constructor_.add(index, value);
                return this;
            }

            public Builder addConstructor(Constructor.Builder builderForValue) {
                this.ensureConstructorIsMutable();
                this.constructor_.add(builderForValue.build());
                return this;
            }

            public Builder addConstructor(int index, Constructor.Builder builderForValue) {
                this.ensureConstructorIsMutable();
                this.constructor_.add(index, builderForValue.build());
                return this;
            }

            public Builder addAllConstructor(Iterable<? extends Constructor> values2) {
                this.ensureConstructorIsMutable();
                AbstractMessageLite.Builder.addAll(values2, this.constructor_);
                return this;
            }

            public Builder clearConstructor() {
                this.constructor_ = Collections.emptyList();
                this.bitField0_ &= 0xFFFFFF7F;
                return this;
            }

            public Builder removeConstructor(int index) {
                this.ensureConstructorIsMutable();
                this.constructor_.remove(index);
                return this;
            }

            private void ensureFunctionIsMutable() {
                if ((this.bitField0_ & 0x100) != 256) {
                    this.function_ = new ArrayList<Function>(this.function_);
                    this.bitField0_ |= 0x100;
                }
            }

            @Override
            public List<Function> getFunctionList() {
                return Collections.unmodifiableList(this.function_);
            }

            @Override
            public int getFunctionCount() {
                return this.function_.size();
            }

            @Override
            public Function getFunction(int index) {
                return this.function_.get(index);
            }

            public Builder setFunction(int index, Function value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.ensureFunctionIsMutable();
                this.function_.set(index, value);
                return this;
            }

            public Builder setFunction(int index, Function.Builder builderForValue) {
                this.ensureFunctionIsMutable();
                this.function_.set(index, builderForValue.build());
                return this;
            }

            public Builder addFunction(Function value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.ensureFunctionIsMutable();
                this.function_.add(value);
                return this;
            }

            public Builder addFunction(int index, Function value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.ensureFunctionIsMutable();
                this.function_.add(index, value);
                return this;
            }

            public Builder addFunction(Function.Builder builderForValue) {
                this.ensureFunctionIsMutable();
                this.function_.add(builderForValue.build());
                return this;
            }

            public Builder addFunction(int index, Function.Builder builderForValue) {
                this.ensureFunctionIsMutable();
                this.function_.add(index, builderForValue.build());
                return this;
            }

            public Builder addAllFunction(Iterable<? extends Function> values2) {
                this.ensureFunctionIsMutable();
                AbstractMessageLite.Builder.addAll(values2, this.function_);
                return this;
            }

            public Builder clearFunction() {
                this.function_ = Collections.emptyList();
                this.bitField0_ &= 0xFFFFFEFF;
                return this;
            }

            public Builder removeFunction(int index) {
                this.ensureFunctionIsMutable();
                this.function_.remove(index);
                return this;
            }

            private void ensurePropertyIsMutable() {
                if ((this.bitField0_ & 0x200) != 512) {
                    this.property_ = new ArrayList<Property>(this.property_);
                    this.bitField0_ |= 0x200;
                }
            }

            @Override
            public List<Property> getPropertyList() {
                return Collections.unmodifiableList(this.property_);
            }

            @Override
            public int getPropertyCount() {
                return this.property_.size();
            }

            @Override
            public Property getProperty(int index) {
                return this.property_.get(index);
            }

            public Builder setProperty(int index, Property value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.ensurePropertyIsMutable();
                this.property_.set(index, value);
                return this;
            }

            public Builder setProperty(int index, Property.Builder builderForValue) {
                this.ensurePropertyIsMutable();
                this.property_.set(index, builderForValue.build());
                return this;
            }

            public Builder addProperty(Property value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.ensurePropertyIsMutable();
                this.property_.add(value);
                return this;
            }

            public Builder addProperty(int index, Property value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.ensurePropertyIsMutable();
                this.property_.add(index, value);
                return this;
            }

            public Builder addProperty(Property.Builder builderForValue) {
                this.ensurePropertyIsMutable();
                this.property_.add(builderForValue.build());
                return this;
            }

            public Builder addProperty(int index, Property.Builder builderForValue) {
                this.ensurePropertyIsMutable();
                this.property_.add(index, builderForValue.build());
                return this;
            }

            public Builder addAllProperty(Iterable<? extends Property> values2) {
                this.ensurePropertyIsMutable();
                AbstractMessageLite.Builder.addAll(values2, this.property_);
                return this;
            }

            public Builder clearProperty() {
                this.property_ = Collections.emptyList();
                this.bitField0_ &= 0xFFFFFDFF;
                return this;
            }

            public Builder removeProperty(int index) {
                this.ensurePropertyIsMutable();
                this.property_.remove(index);
                return this;
            }

            private void ensureTypeAliasIsMutable() {
                if ((this.bitField0_ & 0x400) != 1024) {
                    this.typeAlias_ = new ArrayList<TypeAlias>(this.typeAlias_);
                    this.bitField0_ |= 0x400;
                }
            }

            @Override
            public List<TypeAlias> getTypeAliasList() {
                return Collections.unmodifiableList(this.typeAlias_);
            }

            @Override
            public int getTypeAliasCount() {
                return this.typeAlias_.size();
            }

            @Override
            public TypeAlias getTypeAlias(int index) {
                return this.typeAlias_.get(index);
            }

            public Builder setTypeAlias(int index, TypeAlias value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.ensureTypeAliasIsMutable();
                this.typeAlias_.set(index, value);
                return this;
            }

            public Builder setTypeAlias(int index, TypeAlias.Builder builderForValue) {
                this.ensureTypeAliasIsMutable();
                this.typeAlias_.set(index, builderForValue.build());
                return this;
            }

            public Builder addTypeAlias(TypeAlias value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.ensureTypeAliasIsMutable();
                this.typeAlias_.add(value);
                return this;
            }

            public Builder addTypeAlias(int index, TypeAlias value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.ensureTypeAliasIsMutable();
                this.typeAlias_.add(index, value);
                return this;
            }

            public Builder addTypeAlias(TypeAlias.Builder builderForValue) {
                this.ensureTypeAliasIsMutable();
                this.typeAlias_.add(builderForValue.build());
                return this;
            }

            public Builder addTypeAlias(int index, TypeAlias.Builder builderForValue) {
                this.ensureTypeAliasIsMutable();
                this.typeAlias_.add(index, builderForValue.build());
                return this;
            }

            public Builder addAllTypeAlias(Iterable<? extends TypeAlias> values2) {
                this.ensureTypeAliasIsMutable();
                AbstractMessageLite.Builder.addAll(values2, this.typeAlias_);
                return this;
            }

            public Builder clearTypeAlias() {
                this.typeAlias_ = Collections.emptyList();
                this.bitField0_ &= 0xFFFFFBFF;
                return this;
            }

            public Builder removeTypeAlias(int index) {
                this.ensureTypeAliasIsMutable();
                this.typeAlias_.remove(index);
                return this;
            }

            private void ensureEnumEntryIsMutable() {
                if ((this.bitField0_ & 0x800) != 2048) {
                    this.enumEntry_ = new ArrayList<EnumEntry>(this.enumEntry_);
                    this.bitField0_ |= 0x800;
                }
            }

            @Override
            public List<EnumEntry> getEnumEntryList() {
                return Collections.unmodifiableList(this.enumEntry_);
            }

            @Override
            public int getEnumEntryCount() {
                return this.enumEntry_.size();
            }

            @Override
            public EnumEntry getEnumEntry(int index) {
                return this.enumEntry_.get(index);
            }

            public Builder setEnumEntry(int index, EnumEntry value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.ensureEnumEntryIsMutable();
                this.enumEntry_.set(index, value);
                return this;
            }

            public Builder setEnumEntry(int index, EnumEntry.Builder builderForValue) {
                this.ensureEnumEntryIsMutable();
                this.enumEntry_.set(index, builderForValue.build());
                return this;
            }

            public Builder addEnumEntry(EnumEntry value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.ensureEnumEntryIsMutable();
                this.enumEntry_.add(value);
                return this;
            }

            public Builder addEnumEntry(int index, EnumEntry value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.ensureEnumEntryIsMutable();
                this.enumEntry_.add(index, value);
                return this;
            }

            public Builder addEnumEntry(EnumEntry.Builder builderForValue) {
                this.ensureEnumEntryIsMutable();
                this.enumEntry_.add(builderForValue.build());
                return this;
            }

            public Builder addEnumEntry(int index, EnumEntry.Builder builderForValue) {
                this.ensureEnumEntryIsMutable();
                this.enumEntry_.add(index, builderForValue.build());
                return this;
            }

            public Builder addAllEnumEntry(Iterable<? extends EnumEntry> values2) {
                this.ensureEnumEntryIsMutable();
                AbstractMessageLite.Builder.addAll(values2, this.enumEntry_);
                return this;
            }

            public Builder clearEnumEntry() {
                this.enumEntry_ = Collections.emptyList();
                this.bitField0_ &= 0xFFFFF7FF;
                return this;
            }

            public Builder removeEnumEntry(int index) {
                this.ensureEnumEntryIsMutable();
                this.enumEntry_.remove(index);
                return this;
            }

            private void ensureSealedSubclassFqNameIsMutable() {
                if ((this.bitField0_ & 0x1000) != 4096) {
                    this.sealedSubclassFqName_ = new ArrayList<Integer>(this.sealedSubclassFqName_);
                    this.bitField0_ |= 0x1000;
                }
            }

            @Override
            public List<Integer> getSealedSubclassFqNameList() {
                return Collections.unmodifiableList(this.sealedSubclassFqName_);
            }

            @Override
            public int getSealedSubclassFqNameCount() {
                return this.sealedSubclassFqName_.size();
            }

            @Override
            public int getSealedSubclassFqName(int index) {
                return this.sealedSubclassFqName_.get(index);
            }

            public Builder setSealedSubclassFqName(int index, int value) {
                this.ensureSealedSubclassFqNameIsMutable();
                this.sealedSubclassFqName_.set(index, value);
                return this;
            }

            public Builder addSealedSubclassFqName(int value) {
                this.ensureSealedSubclassFqNameIsMutable();
                this.sealedSubclassFqName_.add(value);
                return this;
            }

            public Builder addAllSealedSubclassFqName(Iterable<? extends Integer> values2) {
                this.ensureSealedSubclassFqNameIsMutable();
                AbstractMessageLite.Builder.addAll(values2, this.sealedSubclassFqName_);
                return this;
            }

            public Builder clearSealedSubclassFqName() {
                this.sealedSubclassFqName_ = Collections.emptyList();
                this.bitField0_ &= 0xFFFFEFFF;
                return this;
            }

            @Override
            public boolean hasTypeTable() {
                return (this.bitField0_ & 0x2000) == 8192;
            }

            @Override
            public TypeTable getTypeTable() {
                return this.typeTable_;
            }

            public Builder setTypeTable(TypeTable value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.typeTable_ = value;
                this.bitField0_ |= 0x2000;
                return this;
            }

            public Builder setTypeTable(TypeTable.Builder builderForValue) {
                this.typeTable_ = builderForValue.build();
                this.bitField0_ |= 0x2000;
                return this;
            }

            public Builder mergeTypeTable(TypeTable value) {
                this.typeTable_ = (this.bitField0_ & 0x2000) == 8192 && this.typeTable_ != TypeTable.getDefaultInstance() ? TypeTable.newBuilder(this.typeTable_).mergeFrom(value).buildPartial() : value;
                this.bitField0_ |= 0x2000;
                return this;
            }

            public Builder clearTypeTable() {
                this.typeTable_ = TypeTable.getDefaultInstance();
                this.bitField0_ &= 0xFFFFDFFF;
                return this;
            }

            @Override
            public boolean hasSinceKotlinInfo() {
                return (this.bitField0_ & 0x4000) == 16384;
            }

            @Override
            public int getSinceKotlinInfo() {
                return this.sinceKotlinInfo_;
            }

            public Builder setSinceKotlinInfo(int value) {
                this.bitField0_ |= 0x4000;
                this.sinceKotlinInfo_ = value;
                return this;
            }

            public Builder clearSinceKotlinInfo() {
                this.bitField0_ &= 0xFFFFBFFF;
                this.sinceKotlinInfo_ = 0;
                return this;
            }

            @Override
            public boolean hasSinceKotlinInfoTable() {
                return (this.bitField0_ & 0x8000) == 32768;
            }

            @Override
            public SinceKotlinInfoTable getSinceKotlinInfoTable() {
                return this.sinceKotlinInfoTable_;
            }

            public Builder setSinceKotlinInfoTable(SinceKotlinInfoTable value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.sinceKotlinInfoTable_ = value;
                this.bitField0_ |= 0x8000;
                return this;
            }

            public Builder setSinceKotlinInfoTable(SinceKotlinInfoTable.Builder builderForValue) {
                this.sinceKotlinInfoTable_ = builderForValue.build();
                this.bitField0_ |= 0x8000;
                return this;
            }

            public Builder mergeSinceKotlinInfoTable(SinceKotlinInfoTable value) {
                this.sinceKotlinInfoTable_ = (this.bitField0_ & 0x8000) == 32768 && this.sinceKotlinInfoTable_ != SinceKotlinInfoTable.getDefaultInstance() ? SinceKotlinInfoTable.newBuilder(this.sinceKotlinInfoTable_).mergeFrom(value).buildPartial() : value;
                this.bitField0_ |= 0x8000;
                return this;
            }

            public Builder clearSinceKotlinInfoTable() {
                this.sinceKotlinInfoTable_ = SinceKotlinInfoTable.getDefaultInstance();
                this.bitField0_ &= 0xFFFF7FFF;
                return this;
            }
        }

        public static enum Kind implements Internal.EnumLite
        {
            CLASS(0, 0),
            INTERFACE(1, 1),
            ENUM_CLASS(2, 2),
            ENUM_ENTRY(3, 3),
            ANNOTATION_CLASS(4, 4),
            OBJECT(5, 5),
            COMPANION_OBJECT(6, 6);

            public static final int CLASS_VALUE = 0;
            public static final int INTERFACE_VALUE = 1;
            public static final int ENUM_CLASS_VALUE = 2;
            public static final int ENUM_ENTRY_VALUE = 3;
            public static final int ANNOTATION_CLASS_VALUE = 4;
            public static final int OBJECT_VALUE = 5;
            public static final int COMPANION_OBJECT_VALUE = 6;
            private static Internal.EnumLiteMap<Kind> internalValueMap;
            private final int value;

            @Override
            public final int getNumber() {
                return this.value;
            }

            public static Kind valueOf(int value) {
                switch (value) {
                    case 0: {
                        return CLASS;
                    }
                    case 1: {
                        return INTERFACE;
                    }
                    case 2: {
                        return ENUM_CLASS;
                    }
                    case 3: {
                        return ENUM_ENTRY;
                    }
                    case 4: {
                        return ANNOTATION_CLASS;
                    }
                    case 5: {
                        return OBJECT;
                    }
                    case 6: {
                        return COMPANION_OBJECT;
                    }
                }
                return null;
            }

            public static Internal.EnumLiteMap<Kind> internalGetValueMap() {
                return internalValueMap;
            }

            private Kind(int index, int value) {
                this.value = value;
            }

            static {
                internalValueMap = new Internal.EnumLiteMap<Kind>(){

                    @Override
                    public Kind findValueByNumber(int number) {
                        return Kind.valueOf(number);
                    }
                };
            }
        }
    }

    public static interface ClassOrBuilder
    extends GeneratedMessageLite.ExtendableMessageOrBuilder<Class> {
        public boolean hasFlags();

        public int getFlags();

        public boolean hasFqName();

        public int getFqName();

        public boolean hasCompanionObjectName();

        public int getCompanionObjectName();

        public List<TypeParameter> getTypeParameterList();

        public TypeParameter getTypeParameter(int var1);

        public int getTypeParameterCount();

        public List<Type> getSupertypeList();

        public Type getSupertype(int var1);

        public int getSupertypeCount();

        public List<Integer> getSupertypeIdList();

        public int getSupertypeIdCount();

        public int getSupertypeId(int var1);

        public List<Integer> getNestedClassNameList();

        public int getNestedClassNameCount();

        public int getNestedClassName(int var1);

        public List<Constructor> getConstructorList();

        public Constructor getConstructor(int var1);

        public int getConstructorCount();

        public List<Function> getFunctionList();

        public Function getFunction(int var1);

        public int getFunctionCount();

        public List<Property> getPropertyList();

        public Property getProperty(int var1);

        public int getPropertyCount();

        public List<TypeAlias> getTypeAliasList();

        public TypeAlias getTypeAlias(int var1);

        public int getTypeAliasCount();

        public List<EnumEntry> getEnumEntryList();

        public EnumEntry getEnumEntry(int var1);

        public int getEnumEntryCount();

        public List<Integer> getSealedSubclassFqNameList();

        public int getSealedSubclassFqNameCount();

        public int getSealedSubclassFqName(int var1);

        public boolean hasTypeTable();

        public TypeTable getTypeTable();

        public boolean hasSinceKotlinInfo();

        public int getSinceKotlinInfo();

        public boolean hasSinceKotlinInfoTable();

        public SinceKotlinInfoTable getSinceKotlinInfoTable();
    }

    public static final class TypeParameter
    extends GeneratedMessageLite.ExtendableMessage<TypeParameter>
    implements TypeParameterOrBuilder {
        private static final TypeParameter defaultInstance;
        private final ByteString unknownFields;
        public static Parser<TypeParameter> PARSER;
        private int bitField0_;
        public static final int ID_FIELD_NUMBER = 1;
        private int id_;
        public static final int NAME_FIELD_NUMBER = 2;
        private int name_;
        public static final int REIFIED_FIELD_NUMBER = 3;
        private boolean reified_;
        public static final int VARIANCE_FIELD_NUMBER = 4;
        private Variance variance_;
        public static final int UPPER_BOUND_FIELD_NUMBER = 5;
        private List<Type> upperBound_;
        public static final int UPPER_BOUND_ID_FIELD_NUMBER = 6;
        private List<Integer> upperBoundId_;
        private byte memoizedIsInitialized = (byte)-1;
        private int memoizedSerializedSize = -1;
        private static final long serialVersionUID = 0L;

        private TypeParameter(GeneratedMessageLite.ExtendableBuilder<TypeParameter, ?> builder) {
            super(builder);
            this.unknownFields = builder.getUnknownFields();
        }

        private TypeParameter(boolean noInit) {
            this.unknownFields = ByteString.EMPTY;
        }

        public static TypeParameter getDefaultInstance() {
            return defaultInstance;
        }

        @Override
        public TypeParameter getDefaultInstanceForType() {
            return defaultInstance;
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        private TypeParameter(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            this.initFields();
            int mutable_bitField0_ = 0;
            ByteString.Output unknownFieldsOutput = ByteString.newOutput();
            CodedOutputStream unknownFieldsCodedOutput = CodedOutputStream.newInstance(unknownFieldsOutput);
            try {
                boolean done = false;
                block25: while (!done) {
                    int tag = input.readTag();
                    switch (tag) {
                        case 0: {
                            done = true;
                            continue block25;
                        }
                        default: {
                            if (this.parseUnknownField(input, unknownFieldsCodedOutput, extensionRegistry, tag)) continue block25;
                            done = true;
                            continue block25;
                        }
                        case 8: {
                            this.bitField0_ |= 1;
                            this.id_ = input.readInt32();
                            continue block25;
                        }
                        case 16: {
                            this.bitField0_ |= 2;
                            this.name_ = input.readInt32();
                            continue block25;
                        }
                        case 24: {
                            this.bitField0_ |= 4;
                            this.reified_ = input.readBool();
                            continue block25;
                        }
                        case 32: {
                            int rawValue = input.readEnum();
                            Variance value = Variance.valueOf(rawValue);
                            if (value == null) {
                                unknownFieldsCodedOutput.writeRawVarint32(tag);
                                unknownFieldsCodedOutput.writeRawVarint32(rawValue);
                                continue block25;
                            }
                            this.bitField0_ |= 8;
                            this.variance_ = value;
                            continue block25;
                        }
                        case 42: {
                            if ((mutable_bitField0_ & 0x10) != 16) {
                                this.upperBound_ = new ArrayList<Type>();
                                mutable_bitField0_ |= 0x10;
                            }
                            this.upperBound_.add(input.readMessage(Type.PARSER, extensionRegistry));
                            continue block25;
                        }
                        case 48: {
                            if ((mutable_bitField0_ & 0x20) != 32) {
                                this.upperBoundId_ = new ArrayList<Integer>();
                                mutable_bitField0_ |= 0x20;
                            }
                            this.upperBoundId_.add(input.readInt32());
                            continue block25;
                        }
                        case 50: 
                    }
                    int length = input.readRawVarint32();
                    int limit = input.pushLimit(length);
                    if ((mutable_bitField0_ & 0x20) != 32 && input.getBytesUntilLimit() > 0) {
                        this.upperBoundId_ = new ArrayList<Integer>();
                        mutable_bitField0_ |= 0x20;
                    }
                    while (input.getBytesUntilLimit() > 0) {
                        this.upperBoundId_.add(input.readInt32());
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
                if ((mutable_bitField0_ & 0x10) == 16) {
                    this.upperBound_ = Collections.unmodifiableList(this.upperBound_);
                }
                if ((mutable_bitField0_ & 0x20) == 32) {
                    this.upperBoundId_ = Collections.unmodifiableList(this.upperBoundId_);
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

        public Parser<TypeParameter> getParserForType() {
            return PARSER;
        }

        @Override
        public boolean hasId() {
            return (this.bitField0_ & 1) == 1;
        }

        @Override
        public int getId() {
            return this.id_;
        }

        @Override
        public boolean hasName() {
            return (this.bitField0_ & 2) == 2;
        }

        @Override
        public int getName() {
            return this.name_;
        }

        @Override
        public boolean hasReified() {
            return (this.bitField0_ & 4) == 4;
        }

        @Override
        public boolean getReified() {
            return this.reified_;
        }

        @Override
        public boolean hasVariance() {
            return (this.bitField0_ & 8) == 8;
        }

        @Override
        public Variance getVariance() {
            return this.variance_;
        }

        @Override
        public List<Type> getUpperBoundList() {
            return this.upperBound_;
        }

        public List<? extends TypeOrBuilder> getUpperBoundOrBuilderList() {
            return this.upperBound_;
        }

        @Override
        public int getUpperBoundCount() {
            return this.upperBound_.size();
        }

        @Override
        public Type getUpperBound(int index) {
            return this.upperBound_.get(index);
        }

        public TypeOrBuilder getUpperBoundOrBuilder(int index) {
            return this.upperBound_.get(index);
        }

        @Override
        public List<Integer> getUpperBoundIdList() {
            return this.upperBoundId_;
        }

        @Override
        public int getUpperBoundIdCount() {
            return this.upperBoundId_.size();
        }

        @Override
        public int getUpperBoundId(int index) {
            return this.upperBoundId_.get(index);
        }

        private void initFields() {
            this.id_ = 0;
            this.name_ = 0;
            this.reified_ = false;
            this.variance_ = Variance.INV;
            this.upperBound_ = Collections.emptyList();
            this.upperBoundId_ = Collections.emptyList();
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
            if (!this.hasId()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            if (!this.hasName()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            for (int i = 0; i < this.getUpperBoundCount(); ++i) {
                if (this.getUpperBound(i).isInitialized()) continue;
                this.memoizedIsInitialized = 0;
                return false;
            }
            if (!this.extensionsAreInitialized()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            this.memoizedIsInitialized = 1;
            return true;
        }

        @Override
        public void writeTo(CodedOutputStream output) throws IOException {
            int i;
            this.getSerializedSize();
            GeneratedMessageLite.ExtendableMessage.ExtensionWriter extensionWriter = this.newExtensionWriter();
            if ((this.bitField0_ & 1) == 1) {
                output.writeInt32(1, this.id_);
            }
            if ((this.bitField0_ & 2) == 2) {
                output.writeInt32(2, this.name_);
            }
            if ((this.bitField0_ & 4) == 4) {
                output.writeBool(3, this.reified_);
            }
            if ((this.bitField0_ & 8) == 8) {
                output.writeEnum(4, this.variance_.getNumber());
            }
            for (i = 0; i < this.upperBound_.size(); ++i) {
                output.writeMessage(5, this.upperBound_.get(i));
            }
            for (i = 0; i < this.upperBoundId_.size(); ++i) {
                output.writeInt32(6, this.upperBoundId_.get(i));
            }
            extensionWriter.writeUntil(1000, output);
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
                size += CodedOutputStream.computeInt32Size(1, this.id_);
            }
            if ((this.bitField0_ & 2) == 2) {
                size += CodedOutputStream.computeInt32Size(2, this.name_);
            }
            if ((this.bitField0_ & 4) == 4) {
                size += CodedOutputStream.computeBoolSize(3, this.reified_);
            }
            if ((this.bitField0_ & 8) == 8) {
                size += CodedOutputStream.computeEnumSize(4, this.variance_.getNumber());
            }
            for (int i = 0; i < this.upperBound_.size(); ++i) {
                size += CodedOutputStream.computeMessageSize(5, this.upperBound_.get(i));
            }
            int dataSize = 0;
            for (int i = 0; i < this.upperBoundId_.size(); ++i) {
                dataSize += CodedOutputStream.computeInt32SizeNoTag(this.upperBoundId_.get(i));
            }
            size += dataSize;
            size += 1 * this.getUpperBoundIdList().size();
            size += this.extensionsSerializedSize();
            this.memoizedSerializedSize = size += this.unknownFields.size();
            return size;
        }

        @Override
        protected Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }

        public static TypeParameter parseFrom(ByteString data2) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data2);
        }

        public static TypeParameter parseFrom(ByteString data2, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data2, extensionRegistry);
        }

        public static TypeParameter parseFrom(byte[] data2) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data2);
        }

        public static TypeParameter parseFrom(byte[] data2, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data2, extensionRegistry);
        }

        public static TypeParameter parseFrom(InputStream input) throws IOException {
            return PARSER.parseFrom(input);
        }

        public static TypeParameter parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return PARSER.parseFrom(input, extensionRegistry);
        }

        public static TypeParameter parseDelimitedFrom(InputStream input) throws IOException {
            return PARSER.parseDelimitedFrom(input);
        }

        public static TypeParameter parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return PARSER.parseDelimitedFrom(input, extensionRegistry);
        }

        public static TypeParameter parseFrom(CodedInputStream input) throws IOException {
            return PARSER.parseFrom(input);
        }

        public static TypeParameter parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return PARSER.parseFrom(input, extensionRegistry);
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        @Override
        public Builder newBuilderForType() {
            return TypeParameter.newBuilder();
        }

        public static Builder newBuilder(TypeParameter prototype) {
            return TypeParameter.newBuilder().mergeFrom(prototype);
        }

        @Override
        public Builder toBuilder() {
            return TypeParameter.newBuilder(this);
        }

        static {
            PARSER = new AbstractParser<TypeParameter>(){

                @Override
                public TypeParameter parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                    return new TypeParameter(input, extensionRegistry);
                }
            };
            defaultInstance = new TypeParameter(true);
            defaultInstance.initFields();
        }

        public static final class Builder
        extends GeneratedMessageLite.ExtendableBuilder<TypeParameter, Builder>
        implements TypeParameterOrBuilder {
            private int bitField0_;
            private int id_;
            private int name_;
            private boolean reified_;
            private Variance variance_ = Variance.INV;
            private List<Type> upperBound_ = Collections.emptyList();
            private List<Integer> upperBoundId_ = Collections.emptyList();

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
                this.id_ = 0;
                this.bitField0_ &= 0xFFFFFFFE;
                this.name_ = 0;
                this.bitField0_ &= 0xFFFFFFFD;
                this.reified_ = false;
                this.bitField0_ &= 0xFFFFFFFB;
                this.variance_ = Variance.INV;
                this.bitField0_ &= 0xFFFFFFF7;
                this.upperBound_ = Collections.emptyList();
                this.bitField0_ &= 0xFFFFFFEF;
                this.upperBoundId_ = Collections.emptyList();
                this.bitField0_ &= 0xFFFFFFDF;
                return this;
            }

            @Override
            public Builder clone() {
                return Builder.create().mergeFrom(this.buildPartial());
            }

            @Override
            public TypeParameter getDefaultInstanceForType() {
                return TypeParameter.getDefaultInstance();
            }

            @Override
            public TypeParameter build() {
                TypeParameter result2 = this.buildPartial();
                if (!result2.isInitialized()) {
                    throw Builder.newUninitializedMessageException(result2);
                }
                return result2;
            }

            @Override
            public TypeParameter buildPartial() {
                TypeParameter result2 = new TypeParameter(this);
                int from_bitField0_ = this.bitField0_;
                int to_bitField0_ = 0;
                if ((from_bitField0_ & 1) == 1) {
                    to_bitField0_ |= 1;
                }
                result2.id_ = this.id_;
                if ((from_bitField0_ & 2) == 2) {
                    to_bitField0_ |= 2;
                }
                result2.name_ = this.name_;
                if ((from_bitField0_ & 4) == 4) {
                    to_bitField0_ |= 4;
                }
                result2.reified_ = this.reified_;
                if ((from_bitField0_ & 8) == 8) {
                    to_bitField0_ |= 8;
                }
                result2.variance_ = this.variance_;
                if ((this.bitField0_ & 0x10) == 16) {
                    this.upperBound_ = Collections.unmodifiableList(this.upperBound_);
                    this.bitField0_ &= 0xFFFFFFEF;
                }
                result2.upperBound_ = this.upperBound_;
                if ((this.bitField0_ & 0x20) == 32) {
                    this.upperBoundId_ = Collections.unmodifiableList(this.upperBoundId_);
                    this.bitField0_ &= 0xFFFFFFDF;
                }
                result2.upperBoundId_ = this.upperBoundId_;
                result2.bitField0_ = to_bitField0_;
                return result2;
            }

            @Override
            public Builder mergeFrom(TypeParameter other) {
                if (other == TypeParameter.getDefaultInstance()) {
                    return this;
                }
                if (other.hasId()) {
                    this.setId(other.getId());
                }
                if (other.hasName()) {
                    this.setName(other.getName());
                }
                if (other.hasReified()) {
                    this.setReified(other.getReified());
                }
                if (other.hasVariance()) {
                    this.setVariance(other.getVariance());
                }
                if (!other.upperBound_.isEmpty()) {
                    if (this.upperBound_.isEmpty()) {
                        this.upperBound_ = other.upperBound_;
                        this.bitField0_ &= 0xFFFFFFEF;
                    } else {
                        this.ensureUpperBoundIsMutable();
                        this.upperBound_.addAll(other.upperBound_);
                    }
                }
                if (!other.upperBoundId_.isEmpty()) {
                    if (this.upperBoundId_.isEmpty()) {
                        this.upperBoundId_ = other.upperBoundId_;
                        this.bitField0_ &= 0xFFFFFFDF;
                    } else {
                        this.ensureUpperBoundIdIsMutable();
                        this.upperBoundId_.addAll(other.upperBoundId_);
                    }
                }
                this.mergeExtensionFields(other);
                this.setUnknownFields(this.getUnknownFields().concat(other.unknownFields));
                return this;
            }

            @Override
            public final boolean isInitialized() {
                if (!this.hasId()) {
                    return false;
                }
                if (!this.hasName()) {
                    return false;
                }
                for (int i = 0; i < this.getUpperBoundCount(); ++i) {
                    if (this.getUpperBound(i).isInitialized()) continue;
                    return false;
                }
                return this.extensionsAreInitialized();
            }

            @Override
            public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                TypeParameter parsedMessage = null;
                try {
                    parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
                }
                catch (InvalidProtocolBufferException e) {
                    parsedMessage = (TypeParameter)e.getUnfinishedMessage();
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
            public boolean hasId() {
                return (this.bitField0_ & 1) == 1;
            }

            @Override
            public int getId() {
                return this.id_;
            }

            public Builder setId(int value) {
                this.bitField0_ |= 1;
                this.id_ = value;
                return this;
            }

            public Builder clearId() {
                this.bitField0_ &= 0xFFFFFFFE;
                this.id_ = 0;
                return this;
            }

            @Override
            public boolean hasName() {
                return (this.bitField0_ & 2) == 2;
            }

            @Override
            public int getName() {
                return this.name_;
            }

            public Builder setName(int value) {
                this.bitField0_ |= 2;
                this.name_ = value;
                return this;
            }

            public Builder clearName() {
                this.bitField0_ &= 0xFFFFFFFD;
                this.name_ = 0;
                return this;
            }

            @Override
            public boolean hasReified() {
                return (this.bitField0_ & 4) == 4;
            }

            @Override
            public boolean getReified() {
                return this.reified_;
            }

            public Builder setReified(boolean value) {
                this.bitField0_ |= 4;
                this.reified_ = value;
                return this;
            }

            public Builder clearReified() {
                this.bitField0_ &= 0xFFFFFFFB;
                this.reified_ = false;
                return this;
            }

            @Override
            public boolean hasVariance() {
                return (this.bitField0_ & 8) == 8;
            }

            @Override
            public Variance getVariance() {
                return this.variance_;
            }

            public Builder setVariance(Variance value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.bitField0_ |= 8;
                this.variance_ = value;
                return this;
            }

            public Builder clearVariance() {
                this.bitField0_ &= 0xFFFFFFF7;
                this.variance_ = Variance.INV;
                return this;
            }

            private void ensureUpperBoundIsMutable() {
                if ((this.bitField0_ & 0x10) != 16) {
                    this.upperBound_ = new ArrayList<Type>(this.upperBound_);
                    this.bitField0_ |= 0x10;
                }
            }

            @Override
            public List<Type> getUpperBoundList() {
                return Collections.unmodifiableList(this.upperBound_);
            }

            @Override
            public int getUpperBoundCount() {
                return this.upperBound_.size();
            }

            @Override
            public Type getUpperBound(int index) {
                return this.upperBound_.get(index);
            }

            public Builder setUpperBound(int index, Type value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.ensureUpperBoundIsMutable();
                this.upperBound_.set(index, value);
                return this;
            }

            public Builder setUpperBound(int index, Type.Builder builderForValue) {
                this.ensureUpperBoundIsMutable();
                this.upperBound_.set(index, builderForValue.build());
                return this;
            }

            public Builder addUpperBound(Type value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.ensureUpperBoundIsMutable();
                this.upperBound_.add(value);
                return this;
            }

            public Builder addUpperBound(int index, Type value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.ensureUpperBoundIsMutable();
                this.upperBound_.add(index, value);
                return this;
            }

            public Builder addUpperBound(Type.Builder builderForValue) {
                this.ensureUpperBoundIsMutable();
                this.upperBound_.add(builderForValue.build());
                return this;
            }

            public Builder addUpperBound(int index, Type.Builder builderForValue) {
                this.ensureUpperBoundIsMutable();
                this.upperBound_.add(index, builderForValue.build());
                return this;
            }

            public Builder addAllUpperBound(Iterable<? extends Type> values2) {
                this.ensureUpperBoundIsMutable();
                AbstractMessageLite.Builder.addAll(values2, this.upperBound_);
                return this;
            }

            public Builder clearUpperBound() {
                this.upperBound_ = Collections.emptyList();
                this.bitField0_ &= 0xFFFFFFEF;
                return this;
            }

            public Builder removeUpperBound(int index) {
                this.ensureUpperBoundIsMutable();
                this.upperBound_.remove(index);
                return this;
            }

            private void ensureUpperBoundIdIsMutable() {
                if ((this.bitField0_ & 0x20) != 32) {
                    this.upperBoundId_ = new ArrayList<Integer>(this.upperBoundId_);
                    this.bitField0_ |= 0x20;
                }
            }

            @Override
            public List<Integer> getUpperBoundIdList() {
                return Collections.unmodifiableList(this.upperBoundId_);
            }

            @Override
            public int getUpperBoundIdCount() {
                return this.upperBoundId_.size();
            }

            @Override
            public int getUpperBoundId(int index) {
                return this.upperBoundId_.get(index);
            }

            public Builder setUpperBoundId(int index, int value) {
                this.ensureUpperBoundIdIsMutable();
                this.upperBoundId_.set(index, value);
                return this;
            }

            public Builder addUpperBoundId(int value) {
                this.ensureUpperBoundIdIsMutable();
                this.upperBoundId_.add(value);
                return this;
            }

            public Builder addAllUpperBoundId(Iterable<? extends Integer> values2) {
                this.ensureUpperBoundIdIsMutable();
                AbstractMessageLite.Builder.addAll(values2, this.upperBoundId_);
                return this;
            }

            public Builder clearUpperBoundId() {
                this.upperBoundId_ = Collections.emptyList();
                this.bitField0_ &= 0xFFFFFFDF;
                return this;
            }
        }

        public static enum Variance implements Internal.EnumLite
        {
            IN(0, 0),
            OUT(1, 1),
            INV(2, 2);

            public static final int IN_VALUE = 0;
            public static final int OUT_VALUE = 1;
            public static final int INV_VALUE = 2;
            private static Internal.EnumLiteMap<Variance> internalValueMap;
            private final int value;

            @Override
            public final int getNumber() {
                return this.value;
            }

            public static Variance valueOf(int value) {
                switch (value) {
                    case 0: {
                        return IN;
                    }
                    case 1: {
                        return OUT;
                    }
                    case 2: {
                        return INV;
                    }
                }
                return null;
            }

            public static Internal.EnumLiteMap<Variance> internalGetValueMap() {
                return internalValueMap;
            }

            private Variance(int index, int value) {
                this.value = value;
            }

            static {
                internalValueMap = new Internal.EnumLiteMap<Variance>(){

                    @Override
                    public Variance findValueByNumber(int number) {
                        return Variance.valueOf(number);
                    }
                };
            }
        }
    }

    public static interface TypeParameterOrBuilder
    extends GeneratedMessageLite.ExtendableMessageOrBuilder<TypeParameter> {
        public boolean hasId();

        public int getId();

        public boolean hasName();

        public int getName();

        public boolean hasReified();

        public boolean getReified();

        public boolean hasVariance();

        public TypeParameter.Variance getVariance();

        public List<Type> getUpperBoundList();

        public Type getUpperBound(int var1);

        public int getUpperBoundCount();

        public List<Integer> getUpperBoundIdList();

        public int getUpperBoundIdCount();

        public int getUpperBoundId(int var1);
    }

    public static final class Type
    extends GeneratedMessageLite.ExtendableMessage<Type>
    implements TypeOrBuilder {
        private static final Type defaultInstance;
        private final ByteString unknownFields;
        public static Parser<Type> PARSER;
        private int bitField0_;
        public static final int ARGUMENT_FIELD_NUMBER = 2;
        private List<Argument> argument_;
        public static final int NULLABLE_FIELD_NUMBER = 3;
        private boolean nullable_;
        public static final int FLEXIBLE_TYPE_CAPABILITIES_ID_FIELD_NUMBER = 4;
        private int flexibleTypeCapabilitiesId_;
        public static final int FLEXIBLE_UPPER_BOUND_FIELD_NUMBER = 5;
        private Type flexibleUpperBound_;
        public static final int FLEXIBLE_UPPER_BOUND_ID_FIELD_NUMBER = 8;
        private int flexibleUpperBoundId_;
        public static final int CLASS_NAME_FIELD_NUMBER = 6;
        private int className_;
        public static final int TYPE_PARAMETER_FIELD_NUMBER = 7;
        private int typeParameter_;
        public static final int TYPE_PARAMETER_NAME_FIELD_NUMBER = 9;
        private int typeParameterName_;
        public static final int TYPE_ALIAS_NAME_FIELD_NUMBER = 12;
        private int typeAliasName_;
        public static final int OUTER_TYPE_FIELD_NUMBER = 10;
        private Type outerType_;
        public static final int OUTER_TYPE_ID_FIELD_NUMBER = 11;
        private int outerTypeId_;
        public static final int ABBREVIATED_TYPE_FIELD_NUMBER = 13;
        private Type abbreviatedType_;
        public static final int ABBREVIATED_TYPE_ID_FIELD_NUMBER = 14;
        private int abbreviatedTypeId_;
        public static final int FLAGS_FIELD_NUMBER = 1;
        private int flags_;
        private byte memoizedIsInitialized = (byte)-1;
        private int memoizedSerializedSize = -1;
        private static final long serialVersionUID = 0L;

        private Type(GeneratedMessageLite.ExtendableBuilder<Type, ?> builder) {
            super(builder);
            this.unknownFields = builder.getUnknownFields();
        }

        private Type(boolean noInit) {
            this.unknownFields = ByteString.EMPTY;
        }

        public static Type getDefaultInstance() {
            return defaultInstance;
        }

        @Override
        public Type getDefaultInstanceForType() {
            return defaultInstance;
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        private Type(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            this.initFields();
            boolean mutable_bitField0_ = false;
            ByteString.Output unknownFieldsOutput = ByteString.newOutput();
            CodedOutputStream unknownFieldsCodedOutput = CodedOutputStream.newInstance(unknownFieldsOutput);
            try {
                boolean done = false;
                block32: while (!done) {
                    int tag = input.readTag();
                    switch (tag) {
                        case 0: {
                            done = true;
                            continue block32;
                        }
                        default: {
                            if (this.parseUnknownField(input, unknownFieldsCodedOutput, extensionRegistry, tag)) continue block32;
                            done = true;
                            continue block32;
                        }
                        case 8: {
                            this.bitField0_ |= 0x1000;
                            this.flags_ = input.readInt32();
                            continue block32;
                        }
                        case 18: {
                            if (!(mutable_bitField0_ & true)) {
                                this.argument_ = new ArrayList<Argument>();
                                mutable_bitField0_ |= true;
                            }
                            this.argument_.add(input.readMessage(Argument.PARSER, extensionRegistry));
                            continue block32;
                        }
                        case 24: {
                            this.bitField0_ |= 1;
                            this.nullable_ = input.readBool();
                            continue block32;
                        }
                        case 32: {
                            this.bitField0_ |= 2;
                            this.flexibleTypeCapabilitiesId_ = input.readInt32();
                            continue block32;
                        }
                        case 42: {
                            Builder subBuilder = null;
                            if ((this.bitField0_ & 4) == 4) {
                                subBuilder = this.flexibleUpperBound_.toBuilder();
                            }
                            this.flexibleUpperBound_ = input.readMessage(PARSER, extensionRegistry);
                            if (subBuilder != null) {
                                subBuilder.mergeFrom(this.flexibleUpperBound_);
                                this.flexibleUpperBound_ = subBuilder.buildPartial();
                            }
                            this.bitField0_ |= 4;
                            continue block32;
                        }
                        case 48: {
                            this.bitField0_ |= 0x10;
                            this.className_ = input.readInt32();
                            continue block32;
                        }
                        case 56: {
                            this.bitField0_ |= 0x20;
                            this.typeParameter_ = input.readInt32();
                            continue block32;
                        }
                        case 64: {
                            this.bitField0_ |= 8;
                            this.flexibleUpperBoundId_ = input.readInt32();
                            continue block32;
                        }
                        case 72: {
                            this.bitField0_ |= 0x40;
                            this.typeParameterName_ = input.readInt32();
                            continue block32;
                        }
                        case 82: {
                            Builder subBuilder = null;
                            if ((this.bitField0_ & 0x100) == 256) {
                                subBuilder = this.outerType_.toBuilder();
                            }
                            this.outerType_ = input.readMessage(PARSER, extensionRegistry);
                            if (subBuilder != null) {
                                subBuilder.mergeFrom(this.outerType_);
                                this.outerType_ = subBuilder.buildPartial();
                            }
                            this.bitField0_ |= 0x100;
                            continue block32;
                        }
                        case 88: {
                            this.bitField0_ |= 0x200;
                            this.outerTypeId_ = input.readInt32();
                            continue block32;
                        }
                        case 96: {
                            this.bitField0_ |= 0x80;
                            this.typeAliasName_ = input.readInt32();
                            continue block32;
                        }
                        case 106: {
                            Builder subBuilder = null;
                            if ((this.bitField0_ & 0x400) == 1024) {
                                subBuilder = this.abbreviatedType_.toBuilder();
                            }
                            this.abbreviatedType_ = input.readMessage(PARSER, extensionRegistry);
                            if (subBuilder != null) {
                                subBuilder.mergeFrom(this.abbreviatedType_);
                                this.abbreviatedType_ = subBuilder.buildPartial();
                            }
                            this.bitField0_ |= 0x400;
                            continue block32;
                        }
                        case 112: 
                    }
                    this.bitField0_ |= 0x800;
                    this.abbreviatedTypeId_ = input.readInt32();
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
                    this.argument_ = Collections.unmodifiableList(this.argument_);
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

        public Parser<Type> getParserForType() {
            return PARSER;
        }

        @Override
        public List<Argument> getArgumentList() {
            return this.argument_;
        }

        public List<? extends ArgumentOrBuilder> getArgumentOrBuilderList() {
            return this.argument_;
        }

        @Override
        public int getArgumentCount() {
            return this.argument_.size();
        }

        @Override
        public Argument getArgument(int index) {
            return this.argument_.get(index);
        }

        public ArgumentOrBuilder getArgumentOrBuilder(int index) {
            return this.argument_.get(index);
        }

        @Override
        public boolean hasNullable() {
            return (this.bitField0_ & 1) == 1;
        }

        @Override
        public boolean getNullable() {
            return this.nullable_;
        }

        @Override
        public boolean hasFlexibleTypeCapabilitiesId() {
            return (this.bitField0_ & 2) == 2;
        }

        @Override
        public int getFlexibleTypeCapabilitiesId() {
            return this.flexibleTypeCapabilitiesId_;
        }

        @Override
        public boolean hasFlexibleUpperBound() {
            return (this.bitField0_ & 4) == 4;
        }

        @Override
        public Type getFlexibleUpperBound() {
            return this.flexibleUpperBound_;
        }

        @Override
        public boolean hasFlexibleUpperBoundId() {
            return (this.bitField0_ & 8) == 8;
        }

        @Override
        public int getFlexibleUpperBoundId() {
            return this.flexibleUpperBoundId_;
        }

        @Override
        public boolean hasClassName() {
            return (this.bitField0_ & 0x10) == 16;
        }

        @Override
        public int getClassName() {
            return this.className_;
        }

        @Override
        public boolean hasTypeParameter() {
            return (this.bitField0_ & 0x20) == 32;
        }

        @Override
        public int getTypeParameter() {
            return this.typeParameter_;
        }

        @Override
        public boolean hasTypeParameterName() {
            return (this.bitField0_ & 0x40) == 64;
        }

        @Override
        public int getTypeParameterName() {
            return this.typeParameterName_;
        }

        @Override
        public boolean hasTypeAliasName() {
            return (this.bitField0_ & 0x80) == 128;
        }

        @Override
        public int getTypeAliasName() {
            return this.typeAliasName_;
        }

        @Override
        public boolean hasOuterType() {
            return (this.bitField0_ & 0x100) == 256;
        }

        @Override
        public Type getOuterType() {
            return this.outerType_;
        }

        @Override
        public boolean hasOuterTypeId() {
            return (this.bitField0_ & 0x200) == 512;
        }

        @Override
        public int getOuterTypeId() {
            return this.outerTypeId_;
        }

        @Override
        public boolean hasAbbreviatedType() {
            return (this.bitField0_ & 0x400) == 1024;
        }

        @Override
        public Type getAbbreviatedType() {
            return this.abbreviatedType_;
        }

        @Override
        public boolean hasAbbreviatedTypeId() {
            return (this.bitField0_ & 0x800) == 2048;
        }

        @Override
        public int getAbbreviatedTypeId() {
            return this.abbreviatedTypeId_;
        }

        @Override
        public boolean hasFlags() {
            return (this.bitField0_ & 0x1000) == 4096;
        }

        @Override
        public int getFlags() {
            return this.flags_;
        }

        private void initFields() {
            this.argument_ = Collections.emptyList();
            this.nullable_ = false;
            this.flexibleTypeCapabilitiesId_ = 0;
            this.flexibleUpperBound_ = Type.getDefaultInstance();
            this.flexibleUpperBoundId_ = 0;
            this.className_ = 0;
            this.typeParameter_ = 0;
            this.typeParameterName_ = 0;
            this.typeAliasName_ = 0;
            this.outerType_ = Type.getDefaultInstance();
            this.outerTypeId_ = 0;
            this.abbreviatedType_ = Type.getDefaultInstance();
            this.abbreviatedTypeId_ = 0;
            this.flags_ = 0;
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
            for (int i = 0; i < this.getArgumentCount(); ++i) {
                if (this.getArgument(i).isInitialized()) continue;
                this.memoizedIsInitialized = 0;
                return false;
            }
            if (this.hasFlexibleUpperBound() && !this.getFlexibleUpperBound().isInitialized()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            if (this.hasOuterType() && !this.getOuterType().isInitialized()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            if (this.hasAbbreviatedType() && !this.getAbbreviatedType().isInitialized()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            if (!this.extensionsAreInitialized()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            this.memoizedIsInitialized = 1;
            return true;
        }

        @Override
        public void writeTo(CodedOutputStream output) throws IOException {
            this.getSerializedSize();
            GeneratedMessageLite.ExtendableMessage.ExtensionWriter extensionWriter = this.newExtensionWriter();
            if ((this.bitField0_ & 0x1000) == 4096) {
                output.writeInt32(1, this.flags_);
            }
            for (int i = 0; i < this.argument_.size(); ++i) {
                output.writeMessage(2, this.argument_.get(i));
            }
            if ((this.bitField0_ & 1) == 1) {
                output.writeBool(3, this.nullable_);
            }
            if ((this.bitField0_ & 2) == 2) {
                output.writeInt32(4, this.flexibleTypeCapabilitiesId_);
            }
            if ((this.bitField0_ & 4) == 4) {
                output.writeMessage(5, this.flexibleUpperBound_);
            }
            if ((this.bitField0_ & 0x10) == 16) {
                output.writeInt32(6, this.className_);
            }
            if ((this.bitField0_ & 0x20) == 32) {
                output.writeInt32(7, this.typeParameter_);
            }
            if ((this.bitField0_ & 8) == 8) {
                output.writeInt32(8, this.flexibleUpperBoundId_);
            }
            if ((this.bitField0_ & 0x40) == 64) {
                output.writeInt32(9, this.typeParameterName_);
            }
            if ((this.bitField0_ & 0x100) == 256) {
                output.writeMessage(10, this.outerType_);
            }
            if ((this.bitField0_ & 0x200) == 512) {
                output.writeInt32(11, this.outerTypeId_);
            }
            if ((this.bitField0_ & 0x80) == 128) {
                output.writeInt32(12, this.typeAliasName_);
            }
            if ((this.bitField0_ & 0x400) == 1024) {
                output.writeMessage(13, this.abbreviatedType_);
            }
            if ((this.bitField0_ & 0x800) == 2048) {
                output.writeInt32(14, this.abbreviatedTypeId_);
            }
            extensionWriter.writeUntil(200, output);
            output.writeRawBytes(this.unknownFields);
        }

        @Override
        public int getSerializedSize() {
            int size = this.memoizedSerializedSize;
            if (size != -1) {
                return size;
            }
            size = 0;
            if ((this.bitField0_ & 0x1000) == 4096) {
                size += CodedOutputStream.computeInt32Size(1, this.flags_);
            }
            for (int i = 0; i < this.argument_.size(); ++i) {
                size += CodedOutputStream.computeMessageSize(2, this.argument_.get(i));
            }
            if ((this.bitField0_ & 1) == 1) {
                size += CodedOutputStream.computeBoolSize(3, this.nullable_);
            }
            if ((this.bitField0_ & 2) == 2) {
                size += CodedOutputStream.computeInt32Size(4, this.flexibleTypeCapabilitiesId_);
            }
            if ((this.bitField0_ & 4) == 4) {
                size += CodedOutputStream.computeMessageSize(5, this.flexibleUpperBound_);
            }
            if ((this.bitField0_ & 0x10) == 16) {
                size += CodedOutputStream.computeInt32Size(6, this.className_);
            }
            if ((this.bitField0_ & 0x20) == 32) {
                size += CodedOutputStream.computeInt32Size(7, this.typeParameter_);
            }
            if ((this.bitField0_ & 8) == 8) {
                size += CodedOutputStream.computeInt32Size(8, this.flexibleUpperBoundId_);
            }
            if ((this.bitField0_ & 0x40) == 64) {
                size += CodedOutputStream.computeInt32Size(9, this.typeParameterName_);
            }
            if ((this.bitField0_ & 0x100) == 256) {
                size += CodedOutputStream.computeMessageSize(10, this.outerType_);
            }
            if ((this.bitField0_ & 0x200) == 512) {
                size += CodedOutputStream.computeInt32Size(11, this.outerTypeId_);
            }
            if ((this.bitField0_ & 0x80) == 128) {
                size += CodedOutputStream.computeInt32Size(12, this.typeAliasName_);
            }
            if ((this.bitField0_ & 0x400) == 1024) {
                size += CodedOutputStream.computeMessageSize(13, this.abbreviatedType_);
            }
            if ((this.bitField0_ & 0x800) == 2048) {
                size += CodedOutputStream.computeInt32Size(14, this.abbreviatedTypeId_);
            }
            size += this.extensionsSerializedSize();
            this.memoizedSerializedSize = size += this.unknownFields.size();
            return size;
        }

        @Override
        protected Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }

        public static Type parseFrom(ByteString data2) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data2);
        }

        public static Type parseFrom(ByteString data2, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data2, extensionRegistry);
        }

        public static Type parseFrom(byte[] data2) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data2);
        }

        public static Type parseFrom(byte[] data2, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data2, extensionRegistry);
        }

        public static Type parseFrom(InputStream input) throws IOException {
            return PARSER.parseFrom(input);
        }

        public static Type parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return PARSER.parseFrom(input, extensionRegistry);
        }

        public static Type parseDelimitedFrom(InputStream input) throws IOException {
            return PARSER.parseDelimitedFrom(input);
        }

        public static Type parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return PARSER.parseDelimitedFrom(input, extensionRegistry);
        }

        public static Type parseFrom(CodedInputStream input) throws IOException {
            return PARSER.parseFrom(input);
        }

        public static Type parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return PARSER.parseFrom(input, extensionRegistry);
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        @Override
        public Builder newBuilderForType() {
            return Type.newBuilder();
        }

        public static Builder newBuilder(Type prototype) {
            return Type.newBuilder().mergeFrom(prototype);
        }

        @Override
        public Builder toBuilder() {
            return Type.newBuilder(this);
        }

        static {
            PARSER = new AbstractParser<Type>(){

                @Override
                public Type parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                    return new Type(input, extensionRegistry);
                }
            };
            defaultInstance = new Type(true);
            defaultInstance.initFields();
        }

        public static final class Builder
        extends GeneratedMessageLite.ExtendableBuilder<Type, Builder>
        implements TypeOrBuilder {
            private int bitField0_;
            private List<Argument> argument_ = Collections.emptyList();
            private boolean nullable_;
            private int flexibleTypeCapabilitiesId_;
            private Type flexibleUpperBound_ = Type.getDefaultInstance();
            private int flexibleUpperBoundId_;
            private int className_;
            private int typeParameter_;
            private int typeParameterName_;
            private int typeAliasName_;
            private Type outerType_ = Type.getDefaultInstance();
            private int outerTypeId_;
            private Type abbreviatedType_ = Type.getDefaultInstance();
            private int abbreviatedTypeId_;
            private int flags_;

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
                this.argument_ = Collections.emptyList();
                this.bitField0_ &= 0xFFFFFFFE;
                this.nullable_ = false;
                this.bitField0_ &= 0xFFFFFFFD;
                this.flexibleTypeCapabilitiesId_ = 0;
                this.bitField0_ &= 0xFFFFFFFB;
                this.flexibleUpperBound_ = Type.getDefaultInstance();
                this.bitField0_ &= 0xFFFFFFF7;
                this.flexibleUpperBoundId_ = 0;
                this.bitField0_ &= 0xFFFFFFEF;
                this.className_ = 0;
                this.bitField0_ &= 0xFFFFFFDF;
                this.typeParameter_ = 0;
                this.bitField0_ &= 0xFFFFFFBF;
                this.typeParameterName_ = 0;
                this.bitField0_ &= 0xFFFFFF7F;
                this.typeAliasName_ = 0;
                this.bitField0_ &= 0xFFFFFEFF;
                this.outerType_ = Type.getDefaultInstance();
                this.bitField0_ &= 0xFFFFFDFF;
                this.outerTypeId_ = 0;
                this.bitField0_ &= 0xFFFFFBFF;
                this.abbreviatedType_ = Type.getDefaultInstance();
                this.bitField0_ &= 0xFFFFF7FF;
                this.abbreviatedTypeId_ = 0;
                this.bitField0_ &= 0xFFFFEFFF;
                this.flags_ = 0;
                this.bitField0_ &= 0xFFFFDFFF;
                return this;
            }

            @Override
            public Builder clone() {
                return Builder.create().mergeFrom(this.buildPartial());
            }

            @Override
            public Type getDefaultInstanceForType() {
                return Type.getDefaultInstance();
            }

            @Override
            public Type build() {
                Type result2 = this.buildPartial();
                if (!result2.isInitialized()) {
                    throw Builder.newUninitializedMessageException(result2);
                }
                return result2;
            }

            @Override
            public Type buildPartial() {
                Type result2 = new Type(this);
                int from_bitField0_ = this.bitField0_;
                int to_bitField0_ = 0;
                if ((this.bitField0_ & 1) == 1) {
                    this.argument_ = Collections.unmodifiableList(this.argument_);
                    this.bitField0_ &= 0xFFFFFFFE;
                }
                result2.argument_ = this.argument_;
                if ((from_bitField0_ & 2) == 2) {
                    to_bitField0_ |= 1;
                }
                result2.nullable_ = this.nullable_;
                if ((from_bitField0_ & 4) == 4) {
                    to_bitField0_ |= 2;
                }
                result2.flexibleTypeCapabilitiesId_ = this.flexibleTypeCapabilitiesId_;
                if ((from_bitField0_ & 8) == 8) {
                    to_bitField0_ |= 4;
                }
                result2.flexibleUpperBound_ = this.flexibleUpperBound_;
                if ((from_bitField0_ & 0x10) == 16) {
                    to_bitField0_ |= 8;
                }
                result2.flexibleUpperBoundId_ = this.flexibleUpperBoundId_;
                if ((from_bitField0_ & 0x20) == 32) {
                    to_bitField0_ |= 0x10;
                }
                result2.className_ = this.className_;
                if ((from_bitField0_ & 0x40) == 64) {
                    to_bitField0_ |= 0x20;
                }
                result2.typeParameter_ = this.typeParameter_;
                if ((from_bitField0_ & 0x80) == 128) {
                    to_bitField0_ |= 0x40;
                }
                result2.typeParameterName_ = this.typeParameterName_;
                if ((from_bitField0_ & 0x100) == 256) {
                    to_bitField0_ |= 0x80;
                }
                result2.typeAliasName_ = this.typeAliasName_;
                if ((from_bitField0_ & 0x200) == 512) {
                    to_bitField0_ |= 0x100;
                }
                result2.outerType_ = this.outerType_;
                if ((from_bitField0_ & 0x400) == 1024) {
                    to_bitField0_ |= 0x200;
                }
                result2.outerTypeId_ = this.outerTypeId_;
                if ((from_bitField0_ & 0x800) == 2048) {
                    to_bitField0_ |= 0x400;
                }
                result2.abbreviatedType_ = this.abbreviatedType_;
                if ((from_bitField0_ & 0x1000) == 4096) {
                    to_bitField0_ |= 0x800;
                }
                result2.abbreviatedTypeId_ = this.abbreviatedTypeId_;
                if ((from_bitField0_ & 0x2000) == 8192) {
                    to_bitField0_ |= 0x1000;
                }
                result2.flags_ = this.flags_;
                result2.bitField0_ = to_bitField0_;
                return result2;
            }

            @Override
            public Builder mergeFrom(Type other) {
                if (other == Type.getDefaultInstance()) {
                    return this;
                }
                if (!other.argument_.isEmpty()) {
                    if (this.argument_.isEmpty()) {
                        this.argument_ = other.argument_;
                        this.bitField0_ &= 0xFFFFFFFE;
                    } else {
                        this.ensureArgumentIsMutable();
                        this.argument_.addAll(other.argument_);
                    }
                }
                if (other.hasNullable()) {
                    this.setNullable(other.getNullable());
                }
                if (other.hasFlexibleTypeCapabilitiesId()) {
                    this.setFlexibleTypeCapabilitiesId(other.getFlexibleTypeCapabilitiesId());
                }
                if (other.hasFlexibleUpperBound()) {
                    this.mergeFlexibleUpperBound(other.getFlexibleUpperBound());
                }
                if (other.hasFlexibleUpperBoundId()) {
                    this.setFlexibleUpperBoundId(other.getFlexibleUpperBoundId());
                }
                if (other.hasClassName()) {
                    this.setClassName(other.getClassName());
                }
                if (other.hasTypeParameter()) {
                    this.setTypeParameter(other.getTypeParameter());
                }
                if (other.hasTypeParameterName()) {
                    this.setTypeParameterName(other.getTypeParameterName());
                }
                if (other.hasTypeAliasName()) {
                    this.setTypeAliasName(other.getTypeAliasName());
                }
                if (other.hasOuterType()) {
                    this.mergeOuterType(other.getOuterType());
                }
                if (other.hasOuterTypeId()) {
                    this.setOuterTypeId(other.getOuterTypeId());
                }
                if (other.hasAbbreviatedType()) {
                    this.mergeAbbreviatedType(other.getAbbreviatedType());
                }
                if (other.hasAbbreviatedTypeId()) {
                    this.setAbbreviatedTypeId(other.getAbbreviatedTypeId());
                }
                if (other.hasFlags()) {
                    this.setFlags(other.getFlags());
                }
                this.mergeExtensionFields(other);
                this.setUnknownFields(this.getUnknownFields().concat(other.unknownFields));
                return this;
            }

            @Override
            public final boolean isInitialized() {
                for (int i = 0; i < this.getArgumentCount(); ++i) {
                    if (this.getArgument(i).isInitialized()) continue;
                    return false;
                }
                if (this.hasFlexibleUpperBound() && !this.getFlexibleUpperBound().isInitialized()) {
                    return false;
                }
                if (this.hasOuterType() && !this.getOuterType().isInitialized()) {
                    return false;
                }
                if (this.hasAbbreviatedType() && !this.getAbbreviatedType().isInitialized()) {
                    return false;
                }
                return this.extensionsAreInitialized();
            }

            @Override
            public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                Type parsedMessage = null;
                try {
                    parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
                }
                catch (InvalidProtocolBufferException e) {
                    parsedMessage = (Type)e.getUnfinishedMessage();
                    throw e;
                }
                finally {
                    if (parsedMessage != null) {
                        this.mergeFrom(parsedMessage);
                    }
                }
                return this;
            }

            private void ensureArgumentIsMutable() {
                if ((this.bitField0_ & 1) != 1) {
                    this.argument_ = new ArrayList<Argument>(this.argument_);
                    this.bitField0_ |= 1;
                }
            }

            @Override
            public List<Argument> getArgumentList() {
                return Collections.unmodifiableList(this.argument_);
            }

            @Override
            public int getArgumentCount() {
                return this.argument_.size();
            }

            @Override
            public Argument getArgument(int index) {
                return this.argument_.get(index);
            }

            public Builder setArgument(int index, Argument value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.ensureArgumentIsMutable();
                this.argument_.set(index, value);
                return this;
            }

            public Builder setArgument(int index, Argument.Builder builderForValue) {
                this.ensureArgumentIsMutable();
                this.argument_.set(index, builderForValue.build());
                return this;
            }

            public Builder addArgument(Argument value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.ensureArgumentIsMutable();
                this.argument_.add(value);
                return this;
            }

            public Builder addArgument(int index, Argument value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.ensureArgumentIsMutable();
                this.argument_.add(index, value);
                return this;
            }

            public Builder addArgument(Argument.Builder builderForValue) {
                this.ensureArgumentIsMutable();
                this.argument_.add(builderForValue.build());
                return this;
            }

            public Builder addArgument(int index, Argument.Builder builderForValue) {
                this.ensureArgumentIsMutable();
                this.argument_.add(index, builderForValue.build());
                return this;
            }

            public Builder addAllArgument(Iterable<? extends Argument> values2) {
                this.ensureArgumentIsMutable();
                AbstractMessageLite.Builder.addAll(values2, this.argument_);
                return this;
            }

            public Builder clearArgument() {
                this.argument_ = Collections.emptyList();
                this.bitField0_ &= 0xFFFFFFFE;
                return this;
            }

            public Builder removeArgument(int index) {
                this.ensureArgumentIsMutable();
                this.argument_.remove(index);
                return this;
            }

            @Override
            public boolean hasNullable() {
                return (this.bitField0_ & 2) == 2;
            }

            @Override
            public boolean getNullable() {
                return this.nullable_;
            }

            public Builder setNullable(boolean value) {
                this.bitField0_ |= 2;
                this.nullable_ = value;
                return this;
            }

            public Builder clearNullable() {
                this.bitField0_ &= 0xFFFFFFFD;
                this.nullable_ = false;
                return this;
            }

            @Override
            public boolean hasFlexibleTypeCapabilitiesId() {
                return (this.bitField0_ & 4) == 4;
            }

            @Override
            public int getFlexibleTypeCapabilitiesId() {
                return this.flexibleTypeCapabilitiesId_;
            }

            public Builder setFlexibleTypeCapabilitiesId(int value) {
                this.bitField0_ |= 4;
                this.flexibleTypeCapabilitiesId_ = value;
                return this;
            }

            public Builder clearFlexibleTypeCapabilitiesId() {
                this.bitField0_ &= 0xFFFFFFFB;
                this.flexibleTypeCapabilitiesId_ = 0;
                return this;
            }

            @Override
            public boolean hasFlexibleUpperBound() {
                return (this.bitField0_ & 8) == 8;
            }

            @Override
            public Type getFlexibleUpperBound() {
                return this.flexibleUpperBound_;
            }

            public Builder setFlexibleUpperBound(Type value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.flexibleUpperBound_ = value;
                this.bitField0_ |= 8;
                return this;
            }

            public Builder setFlexibleUpperBound(Builder builderForValue) {
                this.flexibleUpperBound_ = builderForValue.build();
                this.bitField0_ |= 8;
                return this;
            }

            public Builder mergeFlexibleUpperBound(Type value) {
                this.flexibleUpperBound_ = (this.bitField0_ & 8) == 8 && this.flexibleUpperBound_ != Type.getDefaultInstance() ? Type.newBuilder(this.flexibleUpperBound_).mergeFrom(value).buildPartial() : value;
                this.bitField0_ |= 8;
                return this;
            }

            public Builder clearFlexibleUpperBound() {
                this.flexibleUpperBound_ = Type.getDefaultInstance();
                this.bitField0_ &= 0xFFFFFFF7;
                return this;
            }

            @Override
            public boolean hasFlexibleUpperBoundId() {
                return (this.bitField0_ & 0x10) == 16;
            }

            @Override
            public int getFlexibleUpperBoundId() {
                return this.flexibleUpperBoundId_;
            }

            public Builder setFlexibleUpperBoundId(int value) {
                this.bitField0_ |= 0x10;
                this.flexibleUpperBoundId_ = value;
                return this;
            }

            public Builder clearFlexibleUpperBoundId() {
                this.bitField0_ &= 0xFFFFFFEF;
                this.flexibleUpperBoundId_ = 0;
                return this;
            }

            @Override
            public boolean hasClassName() {
                return (this.bitField0_ & 0x20) == 32;
            }

            @Override
            public int getClassName() {
                return this.className_;
            }

            public Builder setClassName(int value) {
                this.bitField0_ |= 0x20;
                this.className_ = value;
                return this;
            }

            public Builder clearClassName() {
                this.bitField0_ &= 0xFFFFFFDF;
                this.className_ = 0;
                return this;
            }

            @Override
            public boolean hasTypeParameter() {
                return (this.bitField0_ & 0x40) == 64;
            }

            @Override
            public int getTypeParameter() {
                return this.typeParameter_;
            }

            public Builder setTypeParameter(int value) {
                this.bitField0_ |= 0x40;
                this.typeParameter_ = value;
                return this;
            }

            public Builder clearTypeParameter() {
                this.bitField0_ &= 0xFFFFFFBF;
                this.typeParameter_ = 0;
                return this;
            }

            @Override
            public boolean hasTypeParameterName() {
                return (this.bitField0_ & 0x80) == 128;
            }

            @Override
            public int getTypeParameterName() {
                return this.typeParameterName_;
            }

            public Builder setTypeParameterName(int value) {
                this.bitField0_ |= 0x80;
                this.typeParameterName_ = value;
                return this;
            }

            public Builder clearTypeParameterName() {
                this.bitField0_ &= 0xFFFFFF7F;
                this.typeParameterName_ = 0;
                return this;
            }

            @Override
            public boolean hasTypeAliasName() {
                return (this.bitField0_ & 0x100) == 256;
            }

            @Override
            public int getTypeAliasName() {
                return this.typeAliasName_;
            }

            public Builder setTypeAliasName(int value) {
                this.bitField0_ |= 0x100;
                this.typeAliasName_ = value;
                return this;
            }

            public Builder clearTypeAliasName() {
                this.bitField0_ &= 0xFFFFFEFF;
                this.typeAliasName_ = 0;
                return this;
            }

            @Override
            public boolean hasOuterType() {
                return (this.bitField0_ & 0x200) == 512;
            }

            @Override
            public Type getOuterType() {
                return this.outerType_;
            }

            public Builder setOuterType(Type value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.outerType_ = value;
                this.bitField0_ |= 0x200;
                return this;
            }

            public Builder setOuterType(Builder builderForValue) {
                this.outerType_ = builderForValue.build();
                this.bitField0_ |= 0x200;
                return this;
            }

            public Builder mergeOuterType(Type value) {
                this.outerType_ = (this.bitField0_ & 0x200) == 512 && this.outerType_ != Type.getDefaultInstance() ? Type.newBuilder(this.outerType_).mergeFrom(value).buildPartial() : value;
                this.bitField0_ |= 0x200;
                return this;
            }

            public Builder clearOuterType() {
                this.outerType_ = Type.getDefaultInstance();
                this.bitField0_ &= 0xFFFFFDFF;
                return this;
            }

            @Override
            public boolean hasOuterTypeId() {
                return (this.bitField0_ & 0x400) == 1024;
            }

            @Override
            public int getOuterTypeId() {
                return this.outerTypeId_;
            }

            public Builder setOuterTypeId(int value) {
                this.bitField0_ |= 0x400;
                this.outerTypeId_ = value;
                return this;
            }

            public Builder clearOuterTypeId() {
                this.bitField0_ &= 0xFFFFFBFF;
                this.outerTypeId_ = 0;
                return this;
            }

            @Override
            public boolean hasAbbreviatedType() {
                return (this.bitField0_ & 0x800) == 2048;
            }

            @Override
            public Type getAbbreviatedType() {
                return this.abbreviatedType_;
            }

            public Builder setAbbreviatedType(Type value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.abbreviatedType_ = value;
                this.bitField0_ |= 0x800;
                return this;
            }

            public Builder setAbbreviatedType(Builder builderForValue) {
                this.abbreviatedType_ = builderForValue.build();
                this.bitField0_ |= 0x800;
                return this;
            }

            public Builder mergeAbbreviatedType(Type value) {
                this.abbreviatedType_ = (this.bitField0_ & 0x800) == 2048 && this.abbreviatedType_ != Type.getDefaultInstance() ? Type.newBuilder(this.abbreviatedType_).mergeFrom(value).buildPartial() : value;
                this.bitField0_ |= 0x800;
                return this;
            }

            public Builder clearAbbreviatedType() {
                this.abbreviatedType_ = Type.getDefaultInstance();
                this.bitField0_ &= 0xFFFFF7FF;
                return this;
            }

            @Override
            public boolean hasAbbreviatedTypeId() {
                return (this.bitField0_ & 0x1000) == 4096;
            }

            @Override
            public int getAbbreviatedTypeId() {
                return this.abbreviatedTypeId_;
            }

            public Builder setAbbreviatedTypeId(int value) {
                this.bitField0_ |= 0x1000;
                this.abbreviatedTypeId_ = value;
                return this;
            }

            public Builder clearAbbreviatedTypeId() {
                this.bitField0_ &= 0xFFFFEFFF;
                this.abbreviatedTypeId_ = 0;
                return this;
            }

            @Override
            public boolean hasFlags() {
                return (this.bitField0_ & 0x2000) == 8192;
            }

            @Override
            public int getFlags() {
                return this.flags_;
            }

            public Builder setFlags(int value) {
                this.bitField0_ |= 0x2000;
                this.flags_ = value;
                return this;
            }

            public Builder clearFlags() {
                this.bitField0_ &= 0xFFFFDFFF;
                this.flags_ = 0;
                return this;
            }
        }

        public static final class Argument
        extends GeneratedMessageLite
        implements ArgumentOrBuilder {
            private static final Argument defaultInstance;
            private final ByteString unknownFields;
            public static Parser<Argument> PARSER;
            private int bitField0_;
            public static final int PROJECTION_FIELD_NUMBER = 1;
            private Projection projection_;
            public static final int TYPE_FIELD_NUMBER = 2;
            private Type type_;
            public static final int TYPE_ID_FIELD_NUMBER = 3;
            private int typeId_;
            private byte memoizedIsInitialized = (byte)-1;
            private int memoizedSerializedSize = -1;
            private static final long serialVersionUID = 0L;

            private Argument(GeneratedMessageLite.Builder builder) {
                super(builder);
                this.unknownFields = builder.getUnknownFields();
            }

            private Argument(boolean noInit) {
                this.unknownFields = ByteString.EMPTY;
            }

            public static Argument getDefaultInstance() {
                return defaultInstance;
            }

            @Override
            public Argument getDefaultInstanceForType() {
                return defaultInstance;
            }

            /*
             * WARNING - Removed try catching itself - possible behaviour change.
             */
            private Argument(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                this.initFields();
                boolean mutable_bitField0_ = false;
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
                            case 8: {
                                int rawValue = input.readEnum();
                                Projection value = Projection.valueOf(rawValue);
                                if (value == null) {
                                    unknownFieldsCodedOutput.writeRawVarint32(tag);
                                    unknownFieldsCodedOutput.writeRawVarint32(rawValue);
                                    continue block21;
                                }
                                this.bitField0_ |= 1;
                                this.projection_ = value;
                                continue block21;
                            }
                            case 18: {
                                kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf$Type$Builder subBuilder = null;
                                if ((this.bitField0_ & 2) == 2) {
                                    subBuilder = this.type_.toBuilder();
                                }
                                this.type_ = input.readMessage(PARSER, extensionRegistry);
                                if (subBuilder != null) {
                                    subBuilder.mergeFrom(this.type_);
                                    this.type_ = subBuilder.buildPartial();
                                }
                                this.bitField0_ |= 2;
                                continue block21;
                            }
                            case 24: 
                        }
                        this.bitField0_ |= 4;
                        this.typeId_ = input.readInt32();
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

            public Parser<Argument> getParserForType() {
                return PARSER;
            }

            @Override
            public boolean hasProjection() {
                return (this.bitField0_ & 1) == 1;
            }

            @Override
            public Projection getProjection() {
                return this.projection_;
            }

            @Override
            public boolean hasType() {
                return (this.bitField0_ & 2) == 2;
            }

            @Override
            public Type getType() {
                return this.type_;
            }

            @Override
            public boolean hasTypeId() {
                return (this.bitField0_ & 4) == 4;
            }

            @Override
            public int getTypeId() {
                return this.typeId_;
            }

            private void initFields() {
                this.projection_ = Projection.INV;
                this.type_ = Type.getDefaultInstance();
                this.typeId_ = 0;
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
                if (this.hasType() && !this.getType().isInitialized()) {
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
                    output.writeEnum(1, this.projection_.getNumber());
                }
                if ((this.bitField0_ & 2) == 2) {
                    output.writeMessage(2, this.type_);
                }
                if ((this.bitField0_ & 4) == 4) {
                    output.writeInt32(3, this.typeId_);
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
                    size += CodedOutputStream.computeEnumSize(1, this.projection_.getNumber());
                }
                if ((this.bitField0_ & 2) == 2) {
                    size += CodedOutputStream.computeMessageSize(2, this.type_);
                }
                if ((this.bitField0_ & 4) == 4) {
                    size += CodedOutputStream.computeInt32Size(3, this.typeId_);
                }
                this.memoizedSerializedSize = size += this.unknownFields.size();
                return size;
            }

            @Override
            protected Object writeReplace() throws ObjectStreamException {
                return super.writeReplace();
            }

            public static Argument parseFrom(ByteString data2) throws InvalidProtocolBufferException {
                return PARSER.parseFrom(data2);
            }

            public static Argument parseFrom(ByteString data2, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return PARSER.parseFrom(data2, extensionRegistry);
            }

            public static Argument parseFrom(byte[] data2) throws InvalidProtocolBufferException {
                return PARSER.parseFrom(data2);
            }

            public static Argument parseFrom(byte[] data2, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return PARSER.parseFrom(data2, extensionRegistry);
            }

            public static Argument parseFrom(InputStream input) throws IOException {
                return PARSER.parseFrom(input);
            }

            public static Argument parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                return PARSER.parseFrom(input, extensionRegistry);
            }

            public static Argument parseDelimitedFrom(InputStream input) throws IOException {
                return PARSER.parseDelimitedFrom(input);
            }

            public static Argument parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                return PARSER.parseDelimitedFrom(input, extensionRegistry);
            }

            public static Argument parseFrom(CodedInputStream input) throws IOException {
                return PARSER.parseFrom(input);
            }

            public static Argument parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                return PARSER.parseFrom(input, extensionRegistry);
            }

            public static Builder newBuilder() {
                return Builder.create();
            }

            @Override
            public Builder newBuilderForType() {
                return Argument.newBuilder();
            }

            public static Builder newBuilder(Argument prototype) {
                return Argument.newBuilder().mergeFrom(prototype);
            }

            @Override
            public Builder toBuilder() {
                return Argument.newBuilder(this);
            }

            static {
                PARSER = new AbstractParser<Argument>(){

                    @Override
                    public Argument parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                        return new Argument(input, extensionRegistry);
                    }
                };
                defaultInstance = new Argument(true);
                defaultInstance.initFields();
            }

            public static final class Builder
            extends GeneratedMessageLite.Builder<Argument, Builder>
            implements ArgumentOrBuilder {
                private int bitField0_;
                private Projection projection_ = Projection.INV;
                private Type type_ = Type.getDefaultInstance();
                private int typeId_;

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
                    this.projection_ = Projection.INV;
                    this.bitField0_ &= 0xFFFFFFFE;
                    this.type_ = Type.getDefaultInstance();
                    this.bitField0_ &= 0xFFFFFFFD;
                    this.typeId_ = 0;
                    this.bitField0_ &= 0xFFFFFFFB;
                    return this;
                }

                @Override
                public Builder clone() {
                    return Builder.create().mergeFrom(this.buildPartial());
                }

                @Override
                public Argument getDefaultInstanceForType() {
                    return Argument.getDefaultInstance();
                }

                @Override
                public Argument build() {
                    Argument result2 = this.buildPartial();
                    if (!result2.isInitialized()) {
                        throw Builder.newUninitializedMessageException(result2);
                    }
                    return result2;
                }

                @Override
                public Argument buildPartial() {
                    Argument result2 = new Argument(this);
                    int from_bitField0_ = this.bitField0_;
                    int to_bitField0_ = 0;
                    if ((from_bitField0_ & 1) == 1) {
                        to_bitField0_ |= 1;
                    }
                    result2.projection_ = this.projection_;
                    if ((from_bitField0_ & 2) == 2) {
                        to_bitField0_ |= 2;
                    }
                    result2.type_ = this.type_;
                    if ((from_bitField0_ & 4) == 4) {
                        to_bitField0_ |= 4;
                    }
                    result2.typeId_ = this.typeId_;
                    result2.bitField0_ = to_bitField0_;
                    return result2;
                }

                @Override
                public Builder mergeFrom(Argument other) {
                    if (other == Argument.getDefaultInstance()) {
                        return this;
                    }
                    if (other.hasProjection()) {
                        this.setProjection(other.getProjection());
                    }
                    if (other.hasType()) {
                        this.mergeType(other.getType());
                    }
                    if (other.hasTypeId()) {
                        this.setTypeId(other.getTypeId());
                    }
                    this.setUnknownFields(this.getUnknownFields().concat(other.unknownFields));
                    return this;
                }

                @Override
                public final boolean isInitialized() {
                    return !this.hasType() || this.getType().isInitialized();
                }

                @Override
                public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                    Argument parsedMessage = null;
                    try {
                        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
                    }
                    catch (InvalidProtocolBufferException e) {
                        parsedMessage = (Argument)e.getUnfinishedMessage();
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
                public boolean hasProjection() {
                    return (this.bitField0_ & 1) == 1;
                }

                @Override
                public Projection getProjection() {
                    return this.projection_;
                }

                public Builder setProjection(Projection value) {
                    if (value == null) {
                        throw new NullPointerException();
                    }
                    this.bitField0_ |= 1;
                    this.projection_ = value;
                    return this;
                }

                public Builder clearProjection() {
                    this.bitField0_ &= 0xFFFFFFFE;
                    this.projection_ = Projection.INV;
                    return this;
                }

                @Override
                public boolean hasType() {
                    return (this.bitField0_ & 2) == 2;
                }

                @Override
                public Type getType() {
                    return this.type_;
                }

                public Builder setType(Type value) {
                    if (value == null) {
                        throw new NullPointerException();
                    }
                    this.type_ = value;
                    this.bitField0_ |= 2;
                    return this;
                }

                public Builder setType(kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf$Type$Builder builderForValue) {
                    this.type_ = builderForValue.build();
                    this.bitField0_ |= 2;
                    return this;
                }

                public Builder mergeType(Type value) {
                    this.type_ = (this.bitField0_ & 2) == 2 && this.type_ != Type.getDefaultInstance() ? Type.newBuilder(this.type_).mergeFrom(value).buildPartial() : value;
                    this.bitField0_ |= 2;
                    return this;
                }

                public Builder clearType() {
                    this.type_ = Type.getDefaultInstance();
                    this.bitField0_ &= 0xFFFFFFFD;
                    return this;
                }

                @Override
                public boolean hasTypeId() {
                    return (this.bitField0_ & 4) == 4;
                }

                @Override
                public int getTypeId() {
                    return this.typeId_;
                }

                public Builder setTypeId(int value) {
                    this.bitField0_ |= 4;
                    this.typeId_ = value;
                    return this;
                }

                public Builder clearTypeId() {
                    this.bitField0_ &= 0xFFFFFFFB;
                    this.typeId_ = 0;
                    return this;
                }
            }

            public static enum Projection implements Internal.EnumLite
            {
                IN(0, 0),
                OUT(1, 1),
                INV(2, 2),
                STAR(3, 3);

                public static final int IN_VALUE = 0;
                public static final int OUT_VALUE = 1;
                public static final int INV_VALUE = 2;
                public static final int STAR_VALUE = 3;
                private static Internal.EnumLiteMap<Projection> internalValueMap;
                private final int value;

                @Override
                public final int getNumber() {
                    return this.value;
                }

                public static Projection valueOf(int value) {
                    switch (value) {
                        case 0: {
                            return IN;
                        }
                        case 1: {
                            return OUT;
                        }
                        case 2: {
                            return INV;
                        }
                        case 3: {
                            return STAR;
                        }
                    }
                    return null;
                }

                public static Internal.EnumLiteMap<Projection> internalGetValueMap() {
                    return internalValueMap;
                }

                private Projection(int index, int value) {
                    this.value = value;
                }

                static {
                    internalValueMap = new Internal.EnumLiteMap<Projection>(){

                        @Override
                        public Projection findValueByNumber(int number) {
                            return Projection.valueOf(number);
                        }
                    };
                }
            }
        }

        public static interface ArgumentOrBuilder
        extends MessageLiteOrBuilder {
            public boolean hasProjection();

            public Argument.Projection getProjection();

            public boolean hasType();

            public Type getType();

            public boolean hasTypeId();

            public int getTypeId();
        }
    }

    public static interface TypeOrBuilder
    extends GeneratedMessageLite.ExtendableMessageOrBuilder<Type> {
        public List<Type.Argument> getArgumentList();

        public Type.Argument getArgument(int var1);

        public int getArgumentCount();

        public boolean hasNullable();

        public boolean getNullable();

        public boolean hasFlexibleTypeCapabilitiesId();

        public int getFlexibleTypeCapabilitiesId();

        public boolean hasFlexibleUpperBound();

        public Type getFlexibleUpperBound();

        public boolean hasFlexibleUpperBoundId();

        public int getFlexibleUpperBoundId();

        public boolean hasClassName();

        public int getClassName();

        public boolean hasTypeParameter();

        public int getTypeParameter();

        public boolean hasTypeParameterName();

        public int getTypeParameterName();

        public boolean hasTypeAliasName();

        public int getTypeAliasName();

        public boolean hasOuterType();

        public Type getOuterType();

        public boolean hasOuterTypeId();

        public int getOuterTypeId();

        public boolean hasAbbreviatedType();

        public Type getAbbreviatedType();

        public boolean hasAbbreviatedTypeId();

        public int getAbbreviatedTypeId();

        public boolean hasFlags();

        public int getFlags();
    }

    public static final class Annotation
    extends GeneratedMessageLite
    implements AnnotationOrBuilder {
        private static final Annotation defaultInstance;
        private final ByteString unknownFields;
        public static Parser<Annotation> PARSER;
        private int bitField0_;
        public static final int ID_FIELD_NUMBER = 1;
        private int id_;
        public static final int ARGUMENT_FIELD_NUMBER = 2;
        private List<Argument> argument_;
        private byte memoizedIsInitialized = (byte)-1;
        private int memoizedSerializedSize = -1;
        private static final long serialVersionUID = 0L;

        private Annotation(GeneratedMessageLite.Builder builder) {
            super(builder);
            this.unknownFields = builder.getUnknownFields();
        }

        private Annotation(boolean noInit) {
            this.unknownFields = ByteString.EMPTY;
        }

        public static Annotation getDefaultInstance() {
            return defaultInstance;
        }

        @Override
        public Annotation getDefaultInstanceForType() {
            return defaultInstance;
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        private Annotation(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            this.initFields();
            int mutable_bitField0_ = 0;
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
                            this.id_ = input.readInt32();
                            continue block20;
                        }
                        case 18: 
                    }
                    if ((mutable_bitField0_ & 2) != 2) {
                        this.argument_ = new ArrayList<Argument>();
                        mutable_bitField0_ |= 2;
                    }
                    this.argument_.add(input.readMessage(Argument.PARSER, extensionRegistry));
                }
            }
            catch (InvalidProtocolBufferException e) {
                throw e.setUnfinishedMessage(this);
            }
            catch (IOException e) {
                throw new InvalidProtocolBufferException(e.getMessage()).setUnfinishedMessage(this);
            }
            finally {
                if ((mutable_bitField0_ & 2) == 2) {
                    this.argument_ = Collections.unmodifiableList(this.argument_);
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

        public Parser<Annotation> getParserForType() {
            return PARSER;
        }

        @Override
        public boolean hasId() {
            return (this.bitField0_ & 1) == 1;
        }

        @Override
        public int getId() {
            return this.id_;
        }

        @Override
        public List<Argument> getArgumentList() {
            return this.argument_;
        }

        public List<? extends ArgumentOrBuilder> getArgumentOrBuilderList() {
            return this.argument_;
        }

        @Override
        public int getArgumentCount() {
            return this.argument_.size();
        }

        @Override
        public Argument getArgument(int index) {
            return this.argument_.get(index);
        }

        public ArgumentOrBuilder getArgumentOrBuilder(int index) {
            return this.argument_.get(index);
        }

        private void initFields() {
            this.id_ = 0;
            this.argument_ = Collections.emptyList();
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
            if (!this.hasId()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            for (int i = 0; i < this.getArgumentCount(); ++i) {
                if (this.getArgument(i).isInitialized()) continue;
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
                output.writeInt32(1, this.id_);
            }
            for (int i = 0; i < this.argument_.size(); ++i) {
                output.writeMessage(2, this.argument_.get(i));
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
                size += CodedOutputStream.computeInt32Size(1, this.id_);
            }
            for (int i = 0; i < this.argument_.size(); ++i) {
                size += CodedOutputStream.computeMessageSize(2, this.argument_.get(i));
            }
            this.memoizedSerializedSize = size += this.unknownFields.size();
            return size;
        }

        @Override
        protected Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }

        public static Annotation parseFrom(ByteString data2) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data2);
        }

        public static Annotation parseFrom(ByteString data2, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data2, extensionRegistry);
        }

        public static Annotation parseFrom(byte[] data2) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data2);
        }

        public static Annotation parseFrom(byte[] data2, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data2, extensionRegistry);
        }

        public static Annotation parseFrom(InputStream input) throws IOException {
            return PARSER.parseFrom(input);
        }

        public static Annotation parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return PARSER.parseFrom(input, extensionRegistry);
        }

        public static Annotation parseDelimitedFrom(InputStream input) throws IOException {
            return PARSER.parseDelimitedFrom(input);
        }

        public static Annotation parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return PARSER.parseDelimitedFrom(input, extensionRegistry);
        }

        public static Annotation parseFrom(CodedInputStream input) throws IOException {
            return PARSER.parseFrom(input);
        }

        public static Annotation parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return PARSER.parseFrom(input, extensionRegistry);
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        @Override
        public Builder newBuilderForType() {
            return Annotation.newBuilder();
        }

        public static Builder newBuilder(Annotation prototype) {
            return Annotation.newBuilder().mergeFrom(prototype);
        }

        @Override
        public Builder toBuilder() {
            return Annotation.newBuilder(this);
        }

        static {
            PARSER = new AbstractParser<Annotation>(){

                @Override
                public Annotation parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                    return new Annotation(input, extensionRegistry);
                }
            };
            defaultInstance = new Annotation(true);
            defaultInstance.initFields();
        }

        public static final class Builder
        extends GeneratedMessageLite.Builder<Annotation, Builder>
        implements AnnotationOrBuilder {
            private int bitField0_;
            private int id_;
            private List<Argument> argument_ = Collections.emptyList();

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
                this.id_ = 0;
                this.bitField0_ &= 0xFFFFFFFE;
                this.argument_ = Collections.emptyList();
                this.bitField0_ &= 0xFFFFFFFD;
                return this;
            }

            @Override
            public Builder clone() {
                return Builder.create().mergeFrom(this.buildPartial());
            }

            @Override
            public Annotation getDefaultInstanceForType() {
                return Annotation.getDefaultInstance();
            }

            @Override
            public Annotation build() {
                Annotation result2 = this.buildPartial();
                if (!result2.isInitialized()) {
                    throw Builder.newUninitializedMessageException(result2);
                }
                return result2;
            }

            @Override
            public Annotation buildPartial() {
                Annotation result2 = new Annotation(this);
                int from_bitField0_ = this.bitField0_;
                int to_bitField0_ = 0;
                if ((from_bitField0_ & 1) == 1) {
                    to_bitField0_ |= 1;
                }
                result2.id_ = this.id_;
                if ((this.bitField0_ & 2) == 2) {
                    this.argument_ = Collections.unmodifiableList(this.argument_);
                    this.bitField0_ &= 0xFFFFFFFD;
                }
                result2.argument_ = this.argument_;
                result2.bitField0_ = to_bitField0_;
                return result2;
            }

            @Override
            public Builder mergeFrom(Annotation other) {
                if (other == Annotation.getDefaultInstance()) {
                    return this;
                }
                if (other.hasId()) {
                    this.setId(other.getId());
                }
                if (!other.argument_.isEmpty()) {
                    if (this.argument_.isEmpty()) {
                        this.argument_ = other.argument_;
                        this.bitField0_ &= 0xFFFFFFFD;
                    } else {
                        this.ensureArgumentIsMutable();
                        this.argument_.addAll(other.argument_);
                    }
                }
                this.setUnknownFields(this.getUnknownFields().concat(other.unknownFields));
                return this;
            }

            @Override
            public final boolean isInitialized() {
                if (!this.hasId()) {
                    return false;
                }
                for (int i = 0; i < this.getArgumentCount(); ++i) {
                    if (this.getArgument(i).isInitialized()) continue;
                    return false;
                }
                return true;
            }

            @Override
            public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                Annotation parsedMessage = null;
                try {
                    parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
                }
                catch (InvalidProtocolBufferException e) {
                    parsedMessage = (Annotation)e.getUnfinishedMessage();
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
            public boolean hasId() {
                return (this.bitField0_ & 1) == 1;
            }

            @Override
            public int getId() {
                return this.id_;
            }

            public Builder setId(int value) {
                this.bitField0_ |= 1;
                this.id_ = value;
                return this;
            }

            public Builder clearId() {
                this.bitField0_ &= 0xFFFFFFFE;
                this.id_ = 0;
                return this;
            }

            private void ensureArgumentIsMutable() {
                if ((this.bitField0_ & 2) != 2) {
                    this.argument_ = new ArrayList<Argument>(this.argument_);
                    this.bitField0_ |= 2;
                }
            }

            @Override
            public List<Argument> getArgumentList() {
                return Collections.unmodifiableList(this.argument_);
            }

            @Override
            public int getArgumentCount() {
                return this.argument_.size();
            }

            @Override
            public Argument getArgument(int index) {
                return this.argument_.get(index);
            }

            public Builder setArgument(int index, Argument value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.ensureArgumentIsMutable();
                this.argument_.set(index, value);
                return this;
            }

            public Builder setArgument(int index, Argument.Builder builderForValue) {
                this.ensureArgumentIsMutable();
                this.argument_.set(index, builderForValue.build());
                return this;
            }

            public Builder addArgument(Argument value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.ensureArgumentIsMutable();
                this.argument_.add(value);
                return this;
            }

            public Builder addArgument(int index, Argument value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.ensureArgumentIsMutable();
                this.argument_.add(index, value);
                return this;
            }

            public Builder addArgument(Argument.Builder builderForValue) {
                this.ensureArgumentIsMutable();
                this.argument_.add(builderForValue.build());
                return this;
            }

            public Builder addArgument(int index, Argument.Builder builderForValue) {
                this.ensureArgumentIsMutable();
                this.argument_.add(index, builderForValue.build());
                return this;
            }

            public Builder addAllArgument(Iterable<? extends Argument> values2) {
                this.ensureArgumentIsMutable();
                AbstractMessageLite.Builder.addAll(values2, this.argument_);
                return this;
            }

            public Builder clearArgument() {
                this.argument_ = Collections.emptyList();
                this.bitField0_ &= 0xFFFFFFFD;
                return this;
            }

            public Builder removeArgument(int index) {
                this.ensureArgumentIsMutable();
                this.argument_.remove(index);
                return this;
            }
        }

        public static final class Argument
        extends GeneratedMessageLite
        implements ArgumentOrBuilder {
            private static final Argument defaultInstance;
            private final ByteString unknownFields;
            public static Parser<Argument> PARSER;
            private int bitField0_;
            public static final int NAME_ID_FIELD_NUMBER = 1;
            private int nameId_;
            public static final int VALUE_FIELD_NUMBER = 2;
            private Value value_;
            private byte memoizedIsInitialized = (byte)-1;
            private int memoizedSerializedSize = -1;
            private static final long serialVersionUID = 0L;

            private Argument(GeneratedMessageLite.Builder builder) {
                super(builder);
                this.unknownFields = builder.getUnknownFields();
            }

            private Argument(boolean noInit) {
                this.unknownFields = ByteString.EMPTY;
            }

            public static Argument getDefaultInstance() {
                return defaultInstance;
            }

            @Override
            public Argument getDefaultInstanceForType() {
                return defaultInstance;
            }

            /*
             * WARNING - Removed try catching itself - possible behaviour change.
             */
            private Argument(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                                this.nameId_ = input.readInt32();
                                continue block20;
                            }
                            case 18: 
                        }
                        Value.Builder subBuilder = null;
                        if ((this.bitField0_ & 2) == 2) {
                            subBuilder = this.value_.toBuilder();
                        }
                        this.value_ = input.readMessage(Value.PARSER, extensionRegistry);
                        if (subBuilder != null) {
                            subBuilder.mergeFrom(this.value_);
                            this.value_ = subBuilder.buildPartial();
                        }
                        this.bitField0_ |= 2;
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

            public Parser<Argument> getParserForType() {
                return PARSER;
            }

            @Override
            public boolean hasNameId() {
                return (this.bitField0_ & 1) == 1;
            }

            @Override
            public int getNameId() {
                return this.nameId_;
            }

            @Override
            public boolean hasValue() {
                return (this.bitField0_ & 2) == 2;
            }

            @Override
            public Value getValue() {
                return this.value_;
            }

            private void initFields() {
                this.nameId_ = 0;
                this.value_ = Value.getDefaultInstance();
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
                if (!this.hasNameId()) {
                    this.memoizedIsInitialized = 0;
                    return false;
                }
                if (!this.hasValue()) {
                    this.memoizedIsInitialized = 0;
                    return false;
                }
                if (!this.getValue().isInitialized()) {
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
                    output.writeInt32(1, this.nameId_);
                }
                if ((this.bitField0_ & 2) == 2) {
                    output.writeMessage(2, this.value_);
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
                    size += CodedOutputStream.computeInt32Size(1, this.nameId_);
                }
                if ((this.bitField0_ & 2) == 2) {
                    size += CodedOutputStream.computeMessageSize(2, this.value_);
                }
                this.memoizedSerializedSize = size += this.unknownFields.size();
                return size;
            }

            @Override
            protected Object writeReplace() throws ObjectStreamException {
                return super.writeReplace();
            }

            public static Argument parseFrom(ByteString data2) throws InvalidProtocolBufferException {
                return PARSER.parseFrom(data2);
            }

            public static Argument parseFrom(ByteString data2, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return PARSER.parseFrom(data2, extensionRegistry);
            }

            public static Argument parseFrom(byte[] data2) throws InvalidProtocolBufferException {
                return PARSER.parseFrom(data2);
            }

            public static Argument parseFrom(byte[] data2, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return PARSER.parseFrom(data2, extensionRegistry);
            }

            public static Argument parseFrom(InputStream input) throws IOException {
                return PARSER.parseFrom(input);
            }

            public static Argument parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                return PARSER.parseFrom(input, extensionRegistry);
            }

            public static Argument parseDelimitedFrom(InputStream input) throws IOException {
                return PARSER.parseDelimitedFrom(input);
            }

            public static Argument parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                return PARSER.parseDelimitedFrom(input, extensionRegistry);
            }

            public static Argument parseFrom(CodedInputStream input) throws IOException {
                return PARSER.parseFrom(input);
            }

            public static Argument parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                return PARSER.parseFrom(input, extensionRegistry);
            }

            public static Builder newBuilder() {
                return Builder.create();
            }

            @Override
            public Builder newBuilderForType() {
                return Argument.newBuilder();
            }

            public static Builder newBuilder(Argument prototype) {
                return Argument.newBuilder().mergeFrom(prototype);
            }

            @Override
            public Builder toBuilder() {
                return Argument.newBuilder(this);
            }

            static {
                PARSER = new AbstractParser<Argument>(){

                    @Override
                    public Argument parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                        return new Argument(input, extensionRegistry);
                    }
                };
                defaultInstance = new Argument(true);
                defaultInstance.initFields();
            }

            public static final class Builder
            extends GeneratedMessageLite.Builder<Argument, Builder>
            implements ArgumentOrBuilder {
                private int bitField0_;
                private int nameId_;
                private Value value_ = Value.getDefaultInstance();

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
                    this.nameId_ = 0;
                    this.bitField0_ &= 0xFFFFFFFE;
                    this.value_ = Value.getDefaultInstance();
                    this.bitField0_ &= 0xFFFFFFFD;
                    return this;
                }

                @Override
                public Builder clone() {
                    return Builder.create().mergeFrom(this.buildPartial());
                }

                @Override
                public Argument getDefaultInstanceForType() {
                    return Argument.getDefaultInstance();
                }

                @Override
                public Argument build() {
                    Argument result2 = this.buildPartial();
                    if (!result2.isInitialized()) {
                        throw Builder.newUninitializedMessageException(result2);
                    }
                    return result2;
                }

                @Override
                public Argument buildPartial() {
                    Argument result2 = new Argument(this);
                    int from_bitField0_ = this.bitField0_;
                    int to_bitField0_ = 0;
                    if ((from_bitField0_ & 1) == 1) {
                        to_bitField0_ |= 1;
                    }
                    result2.nameId_ = this.nameId_;
                    if ((from_bitField0_ & 2) == 2) {
                        to_bitField0_ |= 2;
                    }
                    result2.value_ = this.value_;
                    result2.bitField0_ = to_bitField0_;
                    return result2;
                }

                @Override
                public Builder mergeFrom(Argument other) {
                    if (other == Argument.getDefaultInstance()) {
                        return this;
                    }
                    if (other.hasNameId()) {
                        this.setNameId(other.getNameId());
                    }
                    if (other.hasValue()) {
                        this.mergeValue(other.getValue());
                    }
                    this.setUnknownFields(this.getUnknownFields().concat(other.unknownFields));
                    return this;
                }

                @Override
                public final boolean isInitialized() {
                    if (!this.hasNameId()) {
                        return false;
                    }
                    if (!this.hasValue()) {
                        return false;
                    }
                    return this.getValue().isInitialized();
                }

                @Override
                public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                    Argument parsedMessage = null;
                    try {
                        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
                    }
                    catch (InvalidProtocolBufferException e) {
                        parsedMessage = (Argument)e.getUnfinishedMessage();
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
                public boolean hasNameId() {
                    return (this.bitField0_ & 1) == 1;
                }

                @Override
                public int getNameId() {
                    return this.nameId_;
                }

                public Builder setNameId(int value) {
                    this.bitField0_ |= 1;
                    this.nameId_ = value;
                    return this;
                }

                public Builder clearNameId() {
                    this.bitField0_ &= 0xFFFFFFFE;
                    this.nameId_ = 0;
                    return this;
                }

                @Override
                public boolean hasValue() {
                    return (this.bitField0_ & 2) == 2;
                }

                @Override
                public Value getValue() {
                    return this.value_;
                }

                public Builder setValue(Value value) {
                    if (value == null) {
                        throw new NullPointerException();
                    }
                    this.value_ = value;
                    this.bitField0_ |= 2;
                    return this;
                }

                public Builder setValue(Value.Builder builderForValue) {
                    this.value_ = builderForValue.build();
                    this.bitField0_ |= 2;
                    return this;
                }

                public Builder mergeValue(Value value) {
                    this.value_ = (this.bitField0_ & 2) == 2 && this.value_ != Value.getDefaultInstance() ? Value.newBuilder(this.value_).mergeFrom(value).buildPartial() : value;
                    this.bitField0_ |= 2;
                    return this;
                }

                public Builder clearValue() {
                    this.value_ = Value.getDefaultInstance();
                    this.bitField0_ &= 0xFFFFFFFD;
                    return this;
                }
            }

            public static final class Value
            extends GeneratedMessageLite
            implements ValueOrBuilder {
                private static final Value defaultInstance;
                private final ByteString unknownFields;
                public static Parser<Value> PARSER;
                private int bitField0_;
                public static final int TYPE_FIELD_NUMBER = 1;
                private Type type_;
                public static final int INT_VALUE_FIELD_NUMBER = 2;
                private long intValue_;
                public static final int FLOAT_VALUE_FIELD_NUMBER = 3;
                private float floatValue_;
                public static final int DOUBLE_VALUE_FIELD_NUMBER = 4;
                private double doubleValue_;
                public static final int STRING_VALUE_FIELD_NUMBER = 5;
                private int stringValue_;
                public static final int CLASS_ID_FIELD_NUMBER = 6;
                private int classId_;
                public static final int ENUM_VALUE_ID_FIELD_NUMBER = 7;
                private int enumValueId_;
                public static final int ANNOTATION_FIELD_NUMBER = 8;
                private Annotation annotation_;
                public static final int ARRAY_ELEMENT_FIELD_NUMBER = 9;
                private List<Value> arrayElement_;
                private byte memoizedIsInitialized = (byte)-1;
                private int memoizedSerializedSize = -1;
                private static final long serialVersionUID = 0L;

                private Value(GeneratedMessageLite.Builder builder) {
                    super(builder);
                    this.unknownFields = builder.getUnknownFields();
                }

                private Value(boolean noInit) {
                    this.unknownFields = ByteString.EMPTY;
                }

                public static Value getDefaultInstance() {
                    return defaultInstance;
                }

                @Override
                public Value getDefaultInstanceForType() {
                    return defaultInstance;
                }

                /*
                 * WARNING - Removed try catching itself - possible behaviour change.
                 */
                private Value(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                    this.initFields();
                    int mutable_bitField0_ = 0;
                    ByteString.Output unknownFieldsOutput = ByteString.newOutput();
                    CodedOutputStream unknownFieldsCodedOutput = CodedOutputStream.newInstance(unknownFieldsOutput);
                    try {
                        boolean done = false;
                        block27: while (!done) {
                            int tag = input.readTag();
                            switch (tag) {
                                case 0: {
                                    done = true;
                                    continue block27;
                                }
                                default: {
                                    if (this.parseUnknownField(input, unknownFieldsCodedOutput, extensionRegistry, tag)) continue block27;
                                    done = true;
                                    continue block27;
                                }
                                case 8: {
                                    int rawValue = input.readEnum();
                                    Type value = Type.valueOf(rawValue);
                                    if (value == null) {
                                        unknownFieldsCodedOutput.writeRawVarint32(tag);
                                        unknownFieldsCodedOutput.writeRawVarint32(rawValue);
                                        continue block27;
                                    }
                                    this.bitField0_ |= 1;
                                    this.type_ = value;
                                    continue block27;
                                }
                                case 16: {
                                    this.bitField0_ |= 2;
                                    this.intValue_ = input.readSInt64();
                                    continue block27;
                                }
                                case 29: {
                                    this.bitField0_ |= 4;
                                    this.floatValue_ = input.readFloat();
                                    continue block27;
                                }
                                case 33: {
                                    this.bitField0_ |= 8;
                                    this.doubleValue_ = input.readDouble();
                                    continue block27;
                                }
                                case 40: {
                                    this.bitField0_ |= 0x10;
                                    this.stringValue_ = input.readInt32();
                                    continue block27;
                                }
                                case 48: {
                                    this.bitField0_ |= 0x20;
                                    this.classId_ = input.readInt32();
                                    continue block27;
                                }
                                case 56: {
                                    this.bitField0_ |= 0x40;
                                    this.enumValueId_ = input.readInt32();
                                    continue block27;
                                }
                                case 66: {
                                    kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf$Annotation$Builder subBuilder = null;
                                    if ((this.bitField0_ & 0x80) == 128) {
                                        subBuilder = this.annotation_.toBuilder();
                                    }
                                    this.annotation_ = input.readMessage(Annotation.PARSER, extensionRegistry);
                                    if (subBuilder != null) {
                                        subBuilder.mergeFrom(this.annotation_);
                                        this.annotation_ = subBuilder.buildPartial();
                                    }
                                    this.bitField0_ |= 0x80;
                                    continue block27;
                                }
                                case 74: 
                            }
                            if ((mutable_bitField0_ & 0x100) != 256) {
                                this.arrayElement_ = new ArrayList<Value>();
                                mutable_bitField0_ |= 0x100;
                            }
                            this.arrayElement_.add(input.readMessage(PARSER, extensionRegistry));
                        }
                    }
                    catch (InvalidProtocolBufferException e) {
                        throw e.setUnfinishedMessage(this);
                    }
                    catch (IOException e) {
                        throw new InvalidProtocolBufferException(e.getMessage()).setUnfinishedMessage(this);
                    }
                    finally {
                        if ((mutable_bitField0_ & 0x100) == 256) {
                            this.arrayElement_ = Collections.unmodifiableList(this.arrayElement_);
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

                public Parser<Value> getParserForType() {
                    return PARSER;
                }

                @Override
                public boolean hasType() {
                    return (this.bitField0_ & 1) == 1;
                }

                @Override
                public Type getType() {
                    return this.type_;
                }

                @Override
                public boolean hasIntValue() {
                    return (this.bitField0_ & 2) == 2;
                }

                @Override
                public long getIntValue() {
                    return this.intValue_;
                }

                @Override
                public boolean hasFloatValue() {
                    return (this.bitField0_ & 4) == 4;
                }

                @Override
                public float getFloatValue() {
                    return this.floatValue_;
                }

                @Override
                public boolean hasDoubleValue() {
                    return (this.bitField0_ & 8) == 8;
                }

                @Override
                public double getDoubleValue() {
                    return this.doubleValue_;
                }

                @Override
                public boolean hasStringValue() {
                    return (this.bitField0_ & 0x10) == 16;
                }

                @Override
                public int getStringValue() {
                    return this.stringValue_;
                }

                @Override
                public boolean hasClassId() {
                    return (this.bitField0_ & 0x20) == 32;
                }

                @Override
                public int getClassId() {
                    return this.classId_;
                }

                @Override
                public boolean hasEnumValueId() {
                    return (this.bitField0_ & 0x40) == 64;
                }

                @Override
                public int getEnumValueId() {
                    return this.enumValueId_;
                }

                @Override
                public boolean hasAnnotation() {
                    return (this.bitField0_ & 0x80) == 128;
                }

                @Override
                public Annotation getAnnotation() {
                    return this.annotation_;
                }

                @Override
                public List<Value> getArrayElementList() {
                    return this.arrayElement_;
                }

                public List<? extends ValueOrBuilder> getArrayElementOrBuilderList() {
                    return this.arrayElement_;
                }

                @Override
                public int getArrayElementCount() {
                    return this.arrayElement_.size();
                }

                @Override
                public Value getArrayElement(int index) {
                    return this.arrayElement_.get(index);
                }

                public ValueOrBuilder getArrayElementOrBuilder(int index) {
                    return this.arrayElement_.get(index);
                }

                private void initFields() {
                    this.type_ = Type.BYTE;
                    this.intValue_ = 0L;
                    this.floatValue_ = 0.0f;
                    this.doubleValue_ = 0.0;
                    this.stringValue_ = 0;
                    this.classId_ = 0;
                    this.enumValueId_ = 0;
                    this.annotation_ = Annotation.getDefaultInstance();
                    this.arrayElement_ = Collections.emptyList();
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
                    if (this.hasAnnotation() && !this.getAnnotation().isInitialized()) {
                        this.memoizedIsInitialized = 0;
                        return false;
                    }
                    for (int i = 0; i < this.getArrayElementCount(); ++i) {
                        if (this.getArrayElement(i).isInitialized()) continue;
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
                        output.writeEnum(1, this.type_.getNumber());
                    }
                    if ((this.bitField0_ & 2) == 2) {
                        output.writeSInt64(2, this.intValue_);
                    }
                    if ((this.bitField0_ & 4) == 4) {
                        output.writeFloat(3, this.floatValue_);
                    }
                    if ((this.bitField0_ & 8) == 8) {
                        output.writeDouble(4, this.doubleValue_);
                    }
                    if ((this.bitField0_ & 0x10) == 16) {
                        output.writeInt32(5, this.stringValue_);
                    }
                    if ((this.bitField0_ & 0x20) == 32) {
                        output.writeInt32(6, this.classId_);
                    }
                    if ((this.bitField0_ & 0x40) == 64) {
                        output.writeInt32(7, this.enumValueId_);
                    }
                    if ((this.bitField0_ & 0x80) == 128) {
                        output.writeMessage(8, this.annotation_);
                    }
                    for (int i = 0; i < this.arrayElement_.size(); ++i) {
                        output.writeMessage(9, this.arrayElement_.get(i));
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
                        size += CodedOutputStream.computeEnumSize(1, this.type_.getNumber());
                    }
                    if ((this.bitField0_ & 2) == 2) {
                        size += CodedOutputStream.computeSInt64Size(2, this.intValue_);
                    }
                    if ((this.bitField0_ & 4) == 4) {
                        size += CodedOutputStream.computeFloatSize(3, this.floatValue_);
                    }
                    if ((this.bitField0_ & 8) == 8) {
                        size += CodedOutputStream.computeDoubleSize(4, this.doubleValue_);
                    }
                    if ((this.bitField0_ & 0x10) == 16) {
                        size += CodedOutputStream.computeInt32Size(5, this.stringValue_);
                    }
                    if ((this.bitField0_ & 0x20) == 32) {
                        size += CodedOutputStream.computeInt32Size(6, this.classId_);
                    }
                    if ((this.bitField0_ & 0x40) == 64) {
                        size += CodedOutputStream.computeInt32Size(7, this.enumValueId_);
                    }
                    if ((this.bitField0_ & 0x80) == 128) {
                        size += CodedOutputStream.computeMessageSize(8, this.annotation_);
                    }
                    for (int i = 0; i < this.arrayElement_.size(); ++i) {
                        size += CodedOutputStream.computeMessageSize(9, this.arrayElement_.get(i));
                    }
                    this.memoizedSerializedSize = size += this.unknownFields.size();
                    return size;
                }

                @Override
                protected Object writeReplace() throws ObjectStreamException {
                    return super.writeReplace();
                }

                public static Value parseFrom(ByteString data2) throws InvalidProtocolBufferException {
                    return PARSER.parseFrom(data2);
                }

                public static Value parseFrom(ByteString data2, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                    return PARSER.parseFrom(data2, extensionRegistry);
                }

                public static Value parseFrom(byte[] data2) throws InvalidProtocolBufferException {
                    return PARSER.parseFrom(data2);
                }

                public static Value parseFrom(byte[] data2, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                    return PARSER.parseFrom(data2, extensionRegistry);
                }

                public static Value parseFrom(InputStream input) throws IOException {
                    return PARSER.parseFrom(input);
                }

                public static Value parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                    return PARSER.parseFrom(input, extensionRegistry);
                }

                public static Value parseDelimitedFrom(InputStream input) throws IOException {
                    return PARSER.parseDelimitedFrom(input);
                }

                public static Value parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                    return PARSER.parseDelimitedFrom(input, extensionRegistry);
                }

                public static Value parseFrom(CodedInputStream input) throws IOException {
                    return PARSER.parseFrom(input);
                }

                public static Value parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                    return PARSER.parseFrom(input, extensionRegistry);
                }

                public static Builder newBuilder() {
                    return Builder.create();
                }

                @Override
                public Builder newBuilderForType() {
                    return Value.newBuilder();
                }

                public static Builder newBuilder(Value prototype) {
                    return Value.newBuilder().mergeFrom(prototype);
                }

                @Override
                public Builder toBuilder() {
                    return Value.newBuilder(this);
                }

                static {
                    PARSER = new AbstractParser<Value>(){

                        @Override
                        public Value parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                            return new Value(input, extensionRegistry);
                        }
                    };
                    defaultInstance = new Value(true);
                    defaultInstance.initFields();
                }

                public static final class Builder
                extends GeneratedMessageLite.Builder<Value, Builder>
                implements ValueOrBuilder {
                    private int bitField0_;
                    private Type type_ = Type.BYTE;
                    private long intValue_;
                    private float floatValue_;
                    private double doubleValue_;
                    private int stringValue_;
                    private int classId_;
                    private int enumValueId_;
                    private Annotation annotation_ = Annotation.getDefaultInstance();
                    private List<Value> arrayElement_ = Collections.emptyList();

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
                        this.type_ = Type.BYTE;
                        this.bitField0_ &= 0xFFFFFFFE;
                        this.intValue_ = 0L;
                        this.bitField0_ &= 0xFFFFFFFD;
                        this.floatValue_ = 0.0f;
                        this.bitField0_ &= 0xFFFFFFFB;
                        this.doubleValue_ = 0.0;
                        this.bitField0_ &= 0xFFFFFFF7;
                        this.stringValue_ = 0;
                        this.bitField0_ &= 0xFFFFFFEF;
                        this.classId_ = 0;
                        this.bitField0_ &= 0xFFFFFFDF;
                        this.enumValueId_ = 0;
                        this.bitField0_ &= 0xFFFFFFBF;
                        this.annotation_ = Annotation.getDefaultInstance();
                        this.bitField0_ &= 0xFFFFFF7F;
                        this.arrayElement_ = Collections.emptyList();
                        this.bitField0_ &= 0xFFFFFEFF;
                        return this;
                    }

                    @Override
                    public Builder clone() {
                        return Builder.create().mergeFrom(this.buildPartial());
                    }

                    @Override
                    public Value getDefaultInstanceForType() {
                        return Value.getDefaultInstance();
                    }

                    @Override
                    public Value build() {
                        Value result2 = this.buildPartial();
                        if (!result2.isInitialized()) {
                            throw Builder.newUninitializedMessageException(result2);
                        }
                        return result2;
                    }

                    @Override
                    public Value buildPartial() {
                        Value result2 = new Value(this);
                        int from_bitField0_ = this.bitField0_;
                        int to_bitField0_ = 0;
                        if ((from_bitField0_ & 1) == 1) {
                            to_bitField0_ |= 1;
                        }
                        result2.type_ = this.type_;
                        if ((from_bitField0_ & 2) == 2) {
                            to_bitField0_ |= 2;
                        }
                        result2.intValue_ = this.intValue_;
                        if ((from_bitField0_ & 4) == 4) {
                            to_bitField0_ |= 4;
                        }
                        result2.floatValue_ = this.floatValue_;
                        if ((from_bitField0_ & 8) == 8) {
                            to_bitField0_ |= 8;
                        }
                        result2.doubleValue_ = this.doubleValue_;
                        if ((from_bitField0_ & 0x10) == 16) {
                            to_bitField0_ |= 0x10;
                        }
                        result2.stringValue_ = this.stringValue_;
                        if ((from_bitField0_ & 0x20) == 32) {
                            to_bitField0_ |= 0x20;
                        }
                        result2.classId_ = this.classId_;
                        if ((from_bitField0_ & 0x40) == 64) {
                            to_bitField0_ |= 0x40;
                        }
                        result2.enumValueId_ = this.enumValueId_;
                        if ((from_bitField0_ & 0x80) == 128) {
                            to_bitField0_ |= 0x80;
                        }
                        result2.annotation_ = this.annotation_;
                        if ((this.bitField0_ & 0x100) == 256) {
                            this.arrayElement_ = Collections.unmodifiableList(this.arrayElement_);
                            this.bitField0_ &= 0xFFFFFEFF;
                        }
                        result2.arrayElement_ = this.arrayElement_;
                        result2.bitField0_ = to_bitField0_;
                        return result2;
                    }

                    @Override
                    public Builder mergeFrom(Value other) {
                        if (other == Value.getDefaultInstance()) {
                            return this;
                        }
                        if (other.hasType()) {
                            this.setType(other.getType());
                        }
                        if (other.hasIntValue()) {
                            this.setIntValue(other.getIntValue());
                        }
                        if (other.hasFloatValue()) {
                            this.setFloatValue(other.getFloatValue());
                        }
                        if (other.hasDoubleValue()) {
                            this.setDoubleValue(other.getDoubleValue());
                        }
                        if (other.hasStringValue()) {
                            this.setStringValue(other.getStringValue());
                        }
                        if (other.hasClassId()) {
                            this.setClassId(other.getClassId());
                        }
                        if (other.hasEnumValueId()) {
                            this.setEnumValueId(other.getEnumValueId());
                        }
                        if (other.hasAnnotation()) {
                            this.mergeAnnotation(other.getAnnotation());
                        }
                        if (!other.arrayElement_.isEmpty()) {
                            if (this.arrayElement_.isEmpty()) {
                                this.arrayElement_ = other.arrayElement_;
                                this.bitField0_ &= 0xFFFFFEFF;
                            } else {
                                this.ensureArrayElementIsMutable();
                                this.arrayElement_.addAll(other.arrayElement_);
                            }
                        }
                        this.setUnknownFields(this.getUnknownFields().concat(other.unknownFields));
                        return this;
                    }

                    @Override
                    public final boolean isInitialized() {
                        if (this.hasAnnotation() && !this.getAnnotation().isInitialized()) {
                            return false;
                        }
                        for (int i = 0; i < this.getArrayElementCount(); ++i) {
                            if (this.getArrayElement(i).isInitialized()) continue;
                            return false;
                        }
                        return true;
                    }

                    @Override
                    public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                        Value parsedMessage = null;
                        try {
                            parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
                        }
                        catch (InvalidProtocolBufferException e) {
                            parsedMessage = (Value)e.getUnfinishedMessage();
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
                    public boolean hasType() {
                        return (this.bitField0_ & 1) == 1;
                    }

                    @Override
                    public Type getType() {
                        return this.type_;
                    }

                    public Builder setType(Type value) {
                        if (value == null) {
                            throw new NullPointerException();
                        }
                        this.bitField0_ |= 1;
                        this.type_ = value;
                        return this;
                    }

                    public Builder clearType() {
                        this.bitField0_ &= 0xFFFFFFFE;
                        this.type_ = Type.BYTE;
                        return this;
                    }

                    @Override
                    public boolean hasIntValue() {
                        return (this.bitField0_ & 2) == 2;
                    }

                    @Override
                    public long getIntValue() {
                        return this.intValue_;
                    }

                    public Builder setIntValue(long value) {
                        this.bitField0_ |= 2;
                        this.intValue_ = value;
                        return this;
                    }

                    public Builder clearIntValue() {
                        this.bitField0_ &= 0xFFFFFFFD;
                        this.intValue_ = 0L;
                        return this;
                    }

                    @Override
                    public boolean hasFloatValue() {
                        return (this.bitField0_ & 4) == 4;
                    }

                    @Override
                    public float getFloatValue() {
                        return this.floatValue_;
                    }

                    public Builder setFloatValue(float value) {
                        this.bitField0_ |= 4;
                        this.floatValue_ = value;
                        return this;
                    }

                    public Builder clearFloatValue() {
                        this.bitField0_ &= 0xFFFFFFFB;
                        this.floatValue_ = 0.0f;
                        return this;
                    }

                    @Override
                    public boolean hasDoubleValue() {
                        return (this.bitField0_ & 8) == 8;
                    }

                    @Override
                    public double getDoubleValue() {
                        return this.doubleValue_;
                    }

                    public Builder setDoubleValue(double value) {
                        this.bitField0_ |= 8;
                        this.doubleValue_ = value;
                        return this;
                    }

                    public Builder clearDoubleValue() {
                        this.bitField0_ &= 0xFFFFFFF7;
                        this.doubleValue_ = 0.0;
                        return this;
                    }

                    @Override
                    public boolean hasStringValue() {
                        return (this.bitField0_ & 0x10) == 16;
                    }

                    @Override
                    public int getStringValue() {
                        return this.stringValue_;
                    }

                    public Builder setStringValue(int value) {
                        this.bitField0_ |= 0x10;
                        this.stringValue_ = value;
                        return this;
                    }

                    public Builder clearStringValue() {
                        this.bitField0_ &= 0xFFFFFFEF;
                        this.stringValue_ = 0;
                        return this;
                    }

                    @Override
                    public boolean hasClassId() {
                        return (this.bitField0_ & 0x20) == 32;
                    }

                    @Override
                    public int getClassId() {
                        return this.classId_;
                    }

                    public Builder setClassId(int value) {
                        this.bitField0_ |= 0x20;
                        this.classId_ = value;
                        return this;
                    }

                    public Builder clearClassId() {
                        this.bitField0_ &= 0xFFFFFFDF;
                        this.classId_ = 0;
                        return this;
                    }

                    @Override
                    public boolean hasEnumValueId() {
                        return (this.bitField0_ & 0x40) == 64;
                    }

                    @Override
                    public int getEnumValueId() {
                        return this.enumValueId_;
                    }

                    public Builder setEnumValueId(int value) {
                        this.bitField0_ |= 0x40;
                        this.enumValueId_ = value;
                        return this;
                    }

                    public Builder clearEnumValueId() {
                        this.bitField0_ &= 0xFFFFFFBF;
                        this.enumValueId_ = 0;
                        return this;
                    }

                    @Override
                    public boolean hasAnnotation() {
                        return (this.bitField0_ & 0x80) == 128;
                    }

                    @Override
                    public Annotation getAnnotation() {
                        return this.annotation_;
                    }

                    public Builder setAnnotation(Annotation value) {
                        if (value == null) {
                            throw new NullPointerException();
                        }
                        this.annotation_ = value;
                        this.bitField0_ |= 0x80;
                        return this;
                    }

                    public Builder setAnnotation(kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf$Annotation$Builder builderForValue) {
                        this.annotation_ = builderForValue.build();
                        this.bitField0_ |= 0x80;
                        return this;
                    }

                    public Builder mergeAnnotation(Annotation value) {
                        this.annotation_ = (this.bitField0_ & 0x80) == 128 && this.annotation_ != Annotation.getDefaultInstance() ? Annotation.newBuilder(this.annotation_).mergeFrom(value).buildPartial() : value;
                        this.bitField0_ |= 0x80;
                        return this;
                    }

                    public Builder clearAnnotation() {
                        this.annotation_ = Annotation.getDefaultInstance();
                        this.bitField0_ &= 0xFFFFFF7F;
                        return this;
                    }

                    private void ensureArrayElementIsMutable() {
                        if ((this.bitField0_ & 0x100) != 256) {
                            this.arrayElement_ = new ArrayList<Value>(this.arrayElement_);
                            this.bitField0_ |= 0x100;
                        }
                    }

                    @Override
                    public List<Value> getArrayElementList() {
                        return Collections.unmodifiableList(this.arrayElement_);
                    }

                    @Override
                    public int getArrayElementCount() {
                        return this.arrayElement_.size();
                    }

                    @Override
                    public Value getArrayElement(int index) {
                        return this.arrayElement_.get(index);
                    }

                    public Builder setArrayElement(int index, Value value) {
                        if (value == null) {
                            throw new NullPointerException();
                        }
                        this.ensureArrayElementIsMutable();
                        this.arrayElement_.set(index, value);
                        return this;
                    }

                    public Builder setArrayElement(int index, Builder builderForValue) {
                        this.ensureArrayElementIsMutable();
                        this.arrayElement_.set(index, builderForValue.build());
                        return this;
                    }

                    public Builder addArrayElement(Value value) {
                        if (value == null) {
                            throw new NullPointerException();
                        }
                        this.ensureArrayElementIsMutable();
                        this.arrayElement_.add(value);
                        return this;
                    }

                    public Builder addArrayElement(int index, Value value) {
                        if (value == null) {
                            throw new NullPointerException();
                        }
                        this.ensureArrayElementIsMutable();
                        this.arrayElement_.add(index, value);
                        return this;
                    }

                    public Builder addArrayElement(Builder builderForValue) {
                        this.ensureArrayElementIsMutable();
                        this.arrayElement_.add(builderForValue.build());
                        return this;
                    }

                    public Builder addArrayElement(int index, Builder builderForValue) {
                        this.ensureArrayElementIsMutable();
                        this.arrayElement_.add(index, builderForValue.build());
                        return this;
                    }

                    public Builder addAllArrayElement(Iterable<? extends Value> values2) {
                        this.ensureArrayElementIsMutable();
                        AbstractMessageLite.Builder.addAll(values2, this.arrayElement_);
                        return this;
                    }

                    public Builder clearArrayElement() {
                        this.arrayElement_ = Collections.emptyList();
                        this.bitField0_ &= 0xFFFFFEFF;
                        return this;
                    }

                    public Builder removeArrayElement(int index) {
                        this.ensureArrayElementIsMutable();
                        this.arrayElement_.remove(index);
                        return this;
                    }
                }

                public static enum Type implements Internal.EnumLite
                {
                    BYTE(0, 0),
                    CHAR(1, 1),
                    SHORT(2, 2),
                    INT(3, 3),
                    LONG(4, 4),
                    FLOAT(5, 5),
                    DOUBLE(6, 6),
                    BOOLEAN(7, 7),
                    STRING(8, 8),
                    CLASS(9, 9),
                    ENUM(10, 10),
                    ANNOTATION(11, 11),
                    ARRAY(12, 12);

                    public static final int BYTE_VALUE = 0;
                    public static final int CHAR_VALUE = 1;
                    public static final int SHORT_VALUE = 2;
                    public static final int INT_VALUE = 3;
                    public static final int LONG_VALUE = 4;
                    public static final int FLOAT_VALUE = 5;
                    public static final int DOUBLE_VALUE = 6;
                    public static final int BOOLEAN_VALUE = 7;
                    public static final int STRING_VALUE = 8;
                    public static final int CLASS_VALUE = 9;
                    public static final int ENUM_VALUE = 10;
                    public static final int ANNOTATION_VALUE = 11;
                    public static final int ARRAY_VALUE = 12;
                    private static Internal.EnumLiteMap<Type> internalValueMap;
                    private final int value;

                    @Override
                    public final int getNumber() {
                        return this.value;
                    }

                    public static Type valueOf(int value) {
                        switch (value) {
                            case 0: {
                                return BYTE;
                            }
                            case 1: {
                                return CHAR;
                            }
                            case 2: {
                                return SHORT;
                            }
                            case 3: {
                                return INT;
                            }
                            case 4: {
                                return LONG;
                            }
                            case 5: {
                                return FLOAT;
                            }
                            case 6: {
                                return DOUBLE;
                            }
                            case 7: {
                                return BOOLEAN;
                            }
                            case 8: {
                                return STRING;
                            }
                            case 9: {
                                return CLASS;
                            }
                            case 10: {
                                return ENUM;
                            }
                            case 11: {
                                return ANNOTATION;
                            }
                            case 12: {
                                return ARRAY;
                            }
                        }
                        return null;
                    }

                    public static Internal.EnumLiteMap<Type> internalGetValueMap() {
                        return internalValueMap;
                    }

                    private Type(int index, int value) {
                        this.value = value;
                    }

                    static {
                        internalValueMap = new Internal.EnumLiteMap<Type>(){

                            @Override
                            public Type findValueByNumber(int number) {
                                return Type.valueOf(number);
                            }
                        };
                    }
                }
            }

            public static interface ValueOrBuilder
            extends MessageLiteOrBuilder {
                public boolean hasType();

                public Value.Type getType();

                public boolean hasIntValue();

                public long getIntValue();

                public boolean hasFloatValue();

                public float getFloatValue();

                public boolean hasDoubleValue();

                public double getDoubleValue();

                public boolean hasStringValue();

                public int getStringValue();

                public boolean hasClassId();

                public int getClassId();

                public boolean hasEnumValueId();

                public int getEnumValueId();

                public boolean hasAnnotation();

                public Annotation getAnnotation();

                public List<Value> getArrayElementList();

                public Value getArrayElement(int var1);

                public int getArrayElementCount();
            }
        }

        public static interface ArgumentOrBuilder
        extends MessageLiteOrBuilder {
            public boolean hasNameId();

            public int getNameId();

            public boolean hasValue();

            public Argument.Value getValue();
        }
    }

    public static interface AnnotationOrBuilder
    extends MessageLiteOrBuilder {
        public boolean hasId();

        public int getId();

        public List<Annotation.Argument> getArgumentList();

        public Annotation.Argument getArgument(int var1);

        public int getArgumentCount();
    }

    public static final class QualifiedNameTable
    extends GeneratedMessageLite
    implements QualifiedNameTableOrBuilder {
        private static final QualifiedNameTable defaultInstance;
        private final ByteString unknownFields;
        public static Parser<QualifiedNameTable> PARSER;
        public static final int QUALIFIED_NAME_FIELD_NUMBER = 1;
        private List<QualifiedName> qualifiedName_;
        private byte memoizedIsInitialized = (byte)-1;
        private int memoizedSerializedSize = -1;
        private static final long serialVersionUID = 0L;

        private QualifiedNameTable(GeneratedMessageLite.Builder builder) {
            super(builder);
            this.unknownFields = builder.getUnknownFields();
        }

        private QualifiedNameTable(boolean noInit) {
            this.unknownFields = ByteString.EMPTY;
        }

        public static QualifiedNameTable getDefaultInstance() {
            return defaultInstance;
        }

        @Override
        public QualifiedNameTable getDefaultInstanceForType() {
            return defaultInstance;
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        private QualifiedNameTable(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            this.initFields();
            boolean mutable_bitField0_ = false;
            ByteString.Output unknownFieldsOutput = ByteString.newOutput();
            CodedOutputStream unknownFieldsCodedOutput = CodedOutputStream.newInstance(unknownFieldsOutput);
            try {
                boolean done = false;
                block19: while (!done) {
                    int tag = input.readTag();
                    switch (tag) {
                        case 0: {
                            done = true;
                            continue block19;
                        }
                        default: {
                            if (this.parseUnknownField(input, unknownFieldsCodedOutput, extensionRegistry, tag)) continue block19;
                            done = true;
                            continue block19;
                        }
                        case 10: 
                    }
                    if (!(mutable_bitField0_ & true)) {
                        this.qualifiedName_ = new ArrayList<QualifiedName>();
                        mutable_bitField0_ |= true;
                    }
                    this.qualifiedName_.add(input.readMessage(QualifiedName.PARSER, extensionRegistry));
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
                    this.qualifiedName_ = Collections.unmodifiableList(this.qualifiedName_);
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

        public Parser<QualifiedNameTable> getParserForType() {
            return PARSER;
        }

        @Override
        public List<QualifiedName> getQualifiedNameList() {
            return this.qualifiedName_;
        }

        public List<? extends QualifiedNameOrBuilder> getQualifiedNameOrBuilderList() {
            return this.qualifiedName_;
        }

        @Override
        public int getQualifiedNameCount() {
            return this.qualifiedName_.size();
        }

        @Override
        public QualifiedName getQualifiedName(int index) {
            return this.qualifiedName_.get(index);
        }

        public QualifiedNameOrBuilder getQualifiedNameOrBuilder(int index) {
            return this.qualifiedName_.get(index);
        }

        private void initFields() {
            this.qualifiedName_ = Collections.emptyList();
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
            for (int i = 0; i < this.getQualifiedNameCount(); ++i) {
                if (this.getQualifiedName(i).isInitialized()) continue;
                this.memoizedIsInitialized = 0;
                return false;
            }
            this.memoizedIsInitialized = 1;
            return true;
        }

        @Override
        public void writeTo(CodedOutputStream output) throws IOException {
            this.getSerializedSize();
            for (int i = 0; i < this.qualifiedName_.size(); ++i) {
                output.writeMessage(1, this.qualifiedName_.get(i));
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
            for (int i = 0; i < this.qualifiedName_.size(); ++i) {
                size += CodedOutputStream.computeMessageSize(1, this.qualifiedName_.get(i));
            }
            this.memoizedSerializedSize = size += this.unknownFields.size();
            return size;
        }

        @Override
        protected Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }

        public static QualifiedNameTable parseFrom(ByteString data2) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data2);
        }

        public static QualifiedNameTable parseFrom(ByteString data2, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data2, extensionRegistry);
        }

        public static QualifiedNameTable parseFrom(byte[] data2) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data2);
        }

        public static QualifiedNameTable parseFrom(byte[] data2, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data2, extensionRegistry);
        }

        public static QualifiedNameTable parseFrom(InputStream input) throws IOException {
            return PARSER.parseFrom(input);
        }

        public static QualifiedNameTable parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return PARSER.parseFrom(input, extensionRegistry);
        }

        public static QualifiedNameTable parseDelimitedFrom(InputStream input) throws IOException {
            return PARSER.parseDelimitedFrom(input);
        }

        public static QualifiedNameTable parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return PARSER.parseDelimitedFrom(input, extensionRegistry);
        }

        public static QualifiedNameTable parseFrom(CodedInputStream input) throws IOException {
            return PARSER.parseFrom(input);
        }

        public static QualifiedNameTable parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return PARSER.parseFrom(input, extensionRegistry);
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        @Override
        public Builder newBuilderForType() {
            return QualifiedNameTable.newBuilder();
        }

        public static Builder newBuilder(QualifiedNameTable prototype) {
            return QualifiedNameTable.newBuilder().mergeFrom(prototype);
        }

        @Override
        public Builder toBuilder() {
            return QualifiedNameTable.newBuilder(this);
        }

        static {
            PARSER = new AbstractParser<QualifiedNameTable>(){

                @Override
                public QualifiedNameTable parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                    return new QualifiedNameTable(input, extensionRegistry);
                }
            };
            defaultInstance = new QualifiedNameTable(true);
            defaultInstance.initFields();
        }

        public static final class Builder
        extends GeneratedMessageLite.Builder<QualifiedNameTable, Builder>
        implements QualifiedNameTableOrBuilder {
            private int bitField0_;
            private List<QualifiedName> qualifiedName_ = Collections.emptyList();

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
                this.qualifiedName_ = Collections.emptyList();
                this.bitField0_ &= 0xFFFFFFFE;
                return this;
            }

            @Override
            public Builder clone() {
                return Builder.create().mergeFrom(this.buildPartial());
            }

            @Override
            public QualifiedNameTable getDefaultInstanceForType() {
                return QualifiedNameTable.getDefaultInstance();
            }

            @Override
            public QualifiedNameTable build() {
                QualifiedNameTable result2 = this.buildPartial();
                if (!result2.isInitialized()) {
                    throw Builder.newUninitializedMessageException(result2);
                }
                return result2;
            }

            @Override
            public QualifiedNameTable buildPartial() {
                QualifiedNameTable result2 = new QualifiedNameTable(this);
                int from_bitField0_ = this.bitField0_;
                if ((this.bitField0_ & 1) == 1) {
                    this.qualifiedName_ = Collections.unmodifiableList(this.qualifiedName_);
                    this.bitField0_ &= 0xFFFFFFFE;
                }
                result2.qualifiedName_ = this.qualifiedName_;
                return result2;
            }

            @Override
            public Builder mergeFrom(QualifiedNameTable other) {
                if (other == QualifiedNameTable.getDefaultInstance()) {
                    return this;
                }
                if (!other.qualifiedName_.isEmpty()) {
                    if (this.qualifiedName_.isEmpty()) {
                        this.qualifiedName_ = other.qualifiedName_;
                        this.bitField0_ &= 0xFFFFFFFE;
                    } else {
                        this.ensureQualifiedNameIsMutable();
                        this.qualifiedName_.addAll(other.qualifiedName_);
                    }
                }
                this.setUnknownFields(this.getUnknownFields().concat(other.unknownFields));
                return this;
            }

            @Override
            public final boolean isInitialized() {
                for (int i = 0; i < this.getQualifiedNameCount(); ++i) {
                    if (this.getQualifiedName(i).isInitialized()) continue;
                    return false;
                }
                return true;
            }

            @Override
            public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                QualifiedNameTable parsedMessage = null;
                try {
                    parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
                }
                catch (InvalidProtocolBufferException e) {
                    parsedMessage = (QualifiedNameTable)e.getUnfinishedMessage();
                    throw e;
                }
                finally {
                    if (parsedMessage != null) {
                        this.mergeFrom(parsedMessage);
                    }
                }
                return this;
            }

            private void ensureQualifiedNameIsMutable() {
                if ((this.bitField0_ & 1) != 1) {
                    this.qualifiedName_ = new ArrayList<QualifiedName>(this.qualifiedName_);
                    this.bitField0_ |= 1;
                }
            }

            @Override
            public List<QualifiedName> getQualifiedNameList() {
                return Collections.unmodifiableList(this.qualifiedName_);
            }

            @Override
            public int getQualifiedNameCount() {
                return this.qualifiedName_.size();
            }

            @Override
            public QualifiedName getQualifiedName(int index) {
                return this.qualifiedName_.get(index);
            }

            public Builder setQualifiedName(int index, QualifiedName value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.ensureQualifiedNameIsMutable();
                this.qualifiedName_.set(index, value);
                return this;
            }

            public Builder setQualifiedName(int index, QualifiedName.Builder builderForValue) {
                this.ensureQualifiedNameIsMutable();
                this.qualifiedName_.set(index, builderForValue.build());
                return this;
            }

            public Builder addQualifiedName(QualifiedName value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.ensureQualifiedNameIsMutable();
                this.qualifiedName_.add(value);
                return this;
            }

            public Builder addQualifiedName(int index, QualifiedName value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.ensureQualifiedNameIsMutable();
                this.qualifiedName_.add(index, value);
                return this;
            }

            public Builder addQualifiedName(QualifiedName.Builder builderForValue) {
                this.ensureQualifiedNameIsMutable();
                this.qualifiedName_.add(builderForValue.build());
                return this;
            }

            public Builder addQualifiedName(int index, QualifiedName.Builder builderForValue) {
                this.ensureQualifiedNameIsMutable();
                this.qualifiedName_.add(index, builderForValue.build());
                return this;
            }

            public Builder addAllQualifiedName(Iterable<? extends QualifiedName> values2) {
                this.ensureQualifiedNameIsMutable();
                AbstractMessageLite.Builder.addAll(values2, this.qualifiedName_);
                return this;
            }

            public Builder clearQualifiedName() {
                this.qualifiedName_ = Collections.emptyList();
                this.bitField0_ &= 0xFFFFFFFE;
                return this;
            }

            public Builder removeQualifiedName(int index) {
                this.ensureQualifiedNameIsMutable();
                this.qualifiedName_.remove(index);
                return this;
            }
        }

        public static final class QualifiedName
        extends GeneratedMessageLite
        implements QualifiedNameOrBuilder {
            private static final QualifiedName defaultInstance;
            private final ByteString unknownFields;
            public static Parser<QualifiedName> PARSER;
            private int bitField0_;
            public static final int PARENT_QUALIFIED_NAME_FIELD_NUMBER = 1;
            private int parentQualifiedName_;
            public static final int SHORT_NAME_FIELD_NUMBER = 2;
            private int shortName_;
            public static final int KIND_FIELD_NUMBER = 3;
            private Kind kind_;
            private byte memoizedIsInitialized = (byte)-1;
            private int memoizedSerializedSize = -1;
            private static final long serialVersionUID = 0L;

            private QualifiedName(GeneratedMessageLite.Builder builder) {
                super(builder);
                this.unknownFields = builder.getUnknownFields();
            }

            private QualifiedName(boolean noInit) {
                this.unknownFields = ByteString.EMPTY;
            }

            public static QualifiedName getDefaultInstance() {
                return defaultInstance;
            }

            @Override
            public QualifiedName getDefaultInstanceForType() {
                return defaultInstance;
            }

            /*
             * WARNING - Removed try catching itself - possible behaviour change.
             */
            private QualifiedName(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                this.initFields();
                boolean mutable_bitField0_ = false;
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
                            case 8: {
                                this.bitField0_ |= 1;
                                this.parentQualifiedName_ = input.readInt32();
                                continue block21;
                            }
                            case 16: {
                                this.bitField0_ |= 2;
                                this.shortName_ = input.readInt32();
                                continue block21;
                            }
                            case 24: 
                        }
                        int rawValue = input.readEnum();
                        Kind value = Kind.valueOf(rawValue);
                        if (value == null) {
                            unknownFieldsCodedOutput.writeRawVarint32(tag);
                            unknownFieldsCodedOutput.writeRawVarint32(rawValue);
                            continue;
                        }
                        this.bitField0_ |= 4;
                        this.kind_ = value;
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

            public Parser<QualifiedName> getParserForType() {
                return PARSER;
            }

            @Override
            public boolean hasParentQualifiedName() {
                return (this.bitField0_ & 1) == 1;
            }

            @Override
            public int getParentQualifiedName() {
                return this.parentQualifiedName_;
            }

            @Override
            public boolean hasShortName() {
                return (this.bitField0_ & 2) == 2;
            }

            @Override
            public int getShortName() {
                return this.shortName_;
            }

            @Override
            public boolean hasKind() {
                return (this.bitField0_ & 4) == 4;
            }

            @Override
            public Kind getKind() {
                return this.kind_;
            }

            private void initFields() {
                this.parentQualifiedName_ = -1;
                this.shortName_ = 0;
                this.kind_ = Kind.PACKAGE;
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
                if (!this.hasShortName()) {
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
                    output.writeInt32(1, this.parentQualifiedName_);
                }
                if ((this.bitField0_ & 2) == 2) {
                    output.writeInt32(2, this.shortName_);
                }
                if ((this.bitField0_ & 4) == 4) {
                    output.writeEnum(3, this.kind_.getNumber());
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
                    size += CodedOutputStream.computeInt32Size(1, this.parentQualifiedName_);
                }
                if ((this.bitField0_ & 2) == 2) {
                    size += CodedOutputStream.computeInt32Size(2, this.shortName_);
                }
                if ((this.bitField0_ & 4) == 4) {
                    size += CodedOutputStream.computeEnumSize(3, this.kind_.getNumber());
                }
                this.memoizedSerializedSize = size += this.unknownFields.size();
                return size;
            }

            @Override
            protected Object writeReplace() throws ObjectStreamException {
                return super.writeReplace();
            }

            public static QualifiedName parseFrom(ByteString data2) throws InvalidProtocolBufferException {
                return PARSER.parseFrom(data2);
            }

            public static QualifiedName parseFrom(ByteString data2, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return PARSER.parseFrom(data2, extensionRegistry);
            }

            public static QualifiedName parseFrom(byte[] data2) throws InvalidProtocolBufferException {
                return PARSER.parseFrom(data2);
            }

            public static QualifiedName parseFrom(byte[] data2, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return PARSER.parseFrom(data2, extensionRegistry);
            }

            public static QualifiedName parseFrom(InputStream input) throws IOException {
                return PARSER.parseFrom(input);
            }

            public static QualifiedName parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                return PARSER.parseFrom(input, extensionRegistry);
            }

            public static QualifiedName parseDelimitedFrom(InputStream input) throws IOException {
                return PARSER.parseDelimitedFrom(input);
            }

            public static QualifiedName parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                return PARSER.parseDelimitedFrom(input, extensionRegistry);
            }

            public static QualifiedName parseFrom(CodedInputStream input) throws IOException {
                return PARSER.parseFrom(input);
            }

            public static QualifiedName parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                return PARSER.parseFrom(input, extensionRegistry);
            }

            public static Builder newBuilder() {
                return Builder.create();
            }

            @Override
            public Builder newBuilderForType() {
                return QualifiedName.newBuilder();
            }

            public static Builder newBuilder(QualifiedName prototype) {
                return QualifiedName.newBuilder().mergeFrom(prototype);
            }

            @Override
            public Builder toBuilder() {
                return QualifiedName.newBuilder(this);
            }

            static {
                PARSER = new AbstractParser<QualifiedName>(){

                    @Override
                    public QualifiedName parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                        return new QualifiedName(input, extensionRegistry);
                    }
                };
                defaultInstance = new QualifiedName(true);
                defaultInstance.initFields();
            }

            public static final class Builder
            extends GeneratedMessageLite.Builder<QualifiedName, Builder>
            implements QualifiedNameOrBuilder {
                private int bitField0_;
                private int parentQualifiedName_ = -1;
                private int shortName_;
                private Kind kind_ = Kind.PACKAGE;

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
                    this.parentQualifiedName_ = -1;
                    this.bitField0_ &= 0xFFFFFFFE;
                    this.shortName_ = 0;
                    this.bitField0_ &= 0xFFFFFFFD;
                    this.kind_ = Kind.PACKAGE;
                    this.bitField0_ &= 0xFFFFFFFB;
                    return this;
                }

                @Override
                public Builder clone() {
                    return Builder.create().mergeFrom(this.buildPartial());
                }

                @Override
                public QualifiedName getDefaultInstanceForType() {
                    return QualifiedName.getDefaultInstance();
                }

                @Override
                public QualifiedName build() {
                    QualifiedName result2 = this.buildPartial();
                    if (!result2.isInitialized()) {
                        throw Builder.newUninitializedMessageException(result2);
                    }
                    return result2;
                }

                @Override
                public QualifiedName buildPartial() {
                    QualifiedName result2 = new QualifiedName(this);
                    int from_bitField0_ = this.bitField0_;
                    int to_bitField0_ = 0;
                    if ((from_bitField0_ & 1) == 1) {
                        to_bitField0_ |= 1;
                    }
                    result2.parentQualifiedName_ = this.parentQualifiedName_;
                    if ((from_bitField0_ & 2) == 2) {
                        to_bitField0_ |= 2;
                    }
                    result2.shortName_ = this.shortName_;
                    if ((from_bitField0_ & 4) == 4) {
                        to_bitField0_ |= 4;
                    }
                    result2.kind_ = this.kind_;
                    result2.bitField0_ = to_bitField0_;
                    return result2;
                }

                @Override
                public Builder mergeFrom(QualifiedName other) {
                    if (other == QualifiedName.getDefaultInstance()) {
                        return this;
                    }
                    if (other.hasParentQualifiedName()) {
                        this.setParentQualifiedName(other.getParentQualifiedName());
                    }
                    if (other.hasShortName()) {
                        this.setShortName(other.getShortName());
                    }
                    if (other.hasKind()) {
                        this.setKind(other.getKind());
                    }
                    this.setUnknownFields(this.getUnknownFields().concat(other.unknownFields));
                    return this;
                }

                @Override
                public final boolean isInitialized() {
                    return this.hasShortName();
                }

                @Override
                public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                    QualifiedName parsedMessage = null;
                    try {
                        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
                    }
                    catch (InvalidProtocolBufferException e) {
                        parsedMessage = (QualifiedName)e.getUnfinishedMessage();
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
                public boolean hasParentQualifiedName() {
                    return (this.bitField0_ & 1) == 1;
                }

                @Override
                public int getParentQualifiedName() {
                    return this.parentQualifiedName_;
                }

                public Builder setParentQualifiedName(int value) {
                    this.bitField0_ |= 1;
                    this.parentQualifiedName_ = value;
                    return this;
                }

                public Builder clearParentQualifiedName() {
                    this.bitField0_ &= 0xFFFFFFFE;
                    this.parentQualifiedName_ = -1;
                    return this;
                }

                @Override
                public boolean hasShortName() {
                    return (this.bitField0_ & 2) == 2;
                }

                @Override
                public int getShortName() {
                    return this.shortName_;
                }

                public Builder setShortName(int value) {
                    this.bitField0_ |= 2;
                    this.shortName_ = value;
                    return this;
                }

                public Builder clearShortName() {
                    this.bitField0_ &= 0xFFFFFFFD;
                    this.shortName_ = 0;
                    return this;
                }

                @Override
                public boolean hasKind() {
                    return (this.bitField0_ & 4) == 4;
                }

                @Override
                public Kind getKind() {
                    return this.kind_;
                }

                public Builder setKind(Kind value) {
                    if (value == null) {
                        throw new NullPointerException();
                    }
                    this.bitField0_ |= 4;
                    this.kind_ = value;
                    return this;
                }

                public Builder clearKind() {
                    this.bitField0_ &= 0xFFFFFFFB;
                    this.kind_ = Kind.PACKAGE;
                    return this;
                }
            }

            public static enum Kind implements Internal.EnumLite
            {
                CLASS(0, 0),
                PACKAGE(1, 1),
                LOCAL(2, 2);

                public static final int CLASS_VALUE = 0;
                public static final int PACKAGE_VALUE = 1;
                public static final int LOCAL_VALUE = 2;
                private static Internal.EnumLiteMap<Kind> internalValueMap;
                private final int value;

                @Override
                public final int getNumber() {
                    return this.value;
                }

                public static Kind valueOf(int value) {
                    switch (value) {
                        case 0: {
                            return CLASS;
                        }
                        case 1: {
                            return PACKAGE;
                        }
                        case 2: {
                            return LOCAL;
                        }
                    }
                    return null;
                }

                public static Internal.EnumLiteMap<Kind> internalGetValueMap() {
                    return internalValueMap;
                }

                private Kind(int index, int value) {
                    this.value = value;
                }

                static {
                    internalValueMap = new Internal.EnumLiteMap<Kind>(){

                        @Override
                        public Kind findValueByNumber(int number) {
                            return Kind.valueOf(number);
                        }
                    };
                }
            }
        }

        public static interface QualifiedNameOrBuilder
        extends MessageLiteOrBuilder {
            public boolean hasParentQualifiedName();

            public int getParentQualifiedName();

            public boolean hasShortName();

            public int getShortName();

            public boolean hasKind();

            public QualifiedName.Kind getKind();
        }
    }

    public static interface QualifiedNameTableOrBuilder
    extends MessageLiteOrBuilder {
        public List<QualifiedNameTable.QualifiedName> getQualifiedNameList();

        public QualifiedNameTable.QualifiedName getQualifiedName(int var1);

        public int getQualifiedNameCount();
    }

    public static final class StringTable
    extends GeneratedMessageLite
    implements StringTableOrBuilder {
        private static final StringTable defaultInstance;
        private final ByteString unknownFields;
        public static Parser<StringTable> PARSER;
        public static final int STRING_FIELD_NUMBER = 1;
        private LazyStringList string_;
        private byte memoizedIsInitialized = (byte)-1;
        private int memoizedSerializedSize = -1;
        private static final long serialVersionUID = 0L;

        private StringTable(GeneratedMessageLite.Builder builder) {
            super(builder);
            this.unknownFields = builder.getUnknownFields();
        }

        private StringTable(boolean noInit) {
            this.unknownFields = ByteString.EMPTY;
        }

        public static StringTable getDefaultInstance() {
            return defaultInstance;
        }

        @Override
        public StringTable getDefaultInstanceForType() {
            return defaultInstance;
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        private StringTable(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            this.initFields();
            boolean mutable_bitField0_ = false;
            ByteString.Output unknownFieldsOutput = ByteString.newOutput();
            CodedOutputStream unknownFieldsCodedOutput = CodedOutputStream.newInstance(unknownFieldsOutput);
            try {
                boolean done = false;
                block19: while (!done) {
                    int tag = input.readTag();
                    switch (tag) {
                        case 0: {
                            done = true;
                            continue block19;
                        }
                        default: {
                            if (this.parseUnknownField(input, unknownFieldsCodedOutput, extensionRegistry, tag)) continue block19;
                            done = true;
                            continue block19;
                        }
                        case 10: 
                    }
                    ByteString bs = input.readBytes();
                    if (!(mutable_bitField0_ & true)) {
                        this.string_ = new LazyStringArrayList();
                        mutable_bitField0_ |= true;
                    }
                    this.string_.add(bs);
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
                    this.string_ = this.string_.getUnmodifiableView();
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

        public Parser<StringTable> getParserForType() {
            return PARSER;
        }

        @Override
        public ProtocolStringList getStringList() {
            return this.string_;
        }

        @Override
        public int getStringCount() {
            return this.string_.size();
        }

        @Override
        public String getString(int index) {
            return (String)this.string_.get(index);
        }

        @Override
        public ByteString getStringBytes(int index) {
            return this.string_.getByteString(index);
        }

        private void initFields() {
            this.string_ = LazyStringArrayList.EMPTY;
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
            for (int i = 0; i < this.string_.size(); ++i) {
                output.writeBytes(1, this.string_.getByteString(i));
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
            int dataSize = 0;
            for (int i = 0; i < this.string_.size(); ++i) {
                dataSize += CodedOutputStream.computeBytesSizeNoTag(this.string_.getByteString(i));
            }
            size += dataSize;
            size += 1 * this.getStringList().size();
            this.memoizedSerializedSize = size += this.unknownFields.size();
            return size;
        }

        @Override
        protected Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }

        public static StringTable parseFrom(ByteString data2) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data2);
        }

        public static StringTable parseFrom(ByteString data2, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data2, extensionRegistry);
        }

        public static StringTable parseFrom(byte[] data2) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data2);
        }

        public static StringTable parseFrom(byte[] data2, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data2, extensionRegistry);
        }

        public static StringTable parseFrom(InputStream input) throws IOException {
            return PARSER.parseFrom(input);
        }

        public static StringTable parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return PARSER.parseFrom(input, extensionRegistry);
        }

        public static StringTable parseDelimitedFrom(InputStream input) throws IOException {
            return PARSER.parseDelimitedFrom(input);
        }

        public static StringTable parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return PARSER.parseDelimitedFrom(input, extensionRegistry);
        }

        public static StringTable parseFrom(CodedInputStream input) throws IOException {
            return PARSER.parseFrom(input);
        }

        public static StringTable parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return PARSER.parseFrom(input, extensionRegistry);
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        @Override
        public Builder newBuilderForType() {
            return StringTable.newBuilder();
        }

        public static Builder newBuilder(StringTable prototype) {
            return StringTable.newBuilder().mergeFrom(prototype);
        }

        @Override
        public Builder toBuilder() {
            return StringTable.newBuilder(this);
        }

        static {
            PARSER = new AbstractParser<StringTable>(){

                @Override
                public StringTable parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                    return new StringTable(input, extensionRegistry);
                }
            };
            defaultInstance = new StringTable(true);
            defaultInstance.initFields();
        }

        public static final class Builder
        extends GeneratedMessageLite.Builder<StringTable, Builder>
        implements StringTableOrBuilder {
            private int bitField0_;
            private LazyStringList string_ = LazyStringArrayList.EMPTY;

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
                this.string_ = LazyStringArrayList.EMPTY;
                this.bitField0_ &= 0xFFFFFFFE;
                return this;
            }

            @Override
            public Builder clone() {
                return Builder.create().mergeFrom(this.buildPartial());
            }

            @Override
            public StringTable getDefaultInstanceForType() {
                return StringTable.getDefaultInstance();
            }

            @Override
            public StringTable build() {
                StringTable result2 = this.buildPartial();
                if (!result2.isInitialized()) {
                    throw Builder.newUninitializedMessageException(result2);
                }
                return result2;
            }

            @Override
            public StringTable buildPartial() {
                StringTable result2 = new StringTable(this);
                int from_bitField0_ = this.bitField0_;
                if ((this.bitField0_ & 1) == 1) {
                    this.string_ = this.string_.getUnmodifiableView();
                    this.bitField0_ &= 0xFFFFFFFE;
                }
                result2.string_ = this.string_;
                return result2;
            }

            @Override
            public Builder mergeFrom(StringTable other) {
                if (other == StringTable.getDefaultInstance()) {
                    return this;
                }
                if (!other.string_.isEmpty()) {
                    if (this.string_.isEmpty()) {
                        this.string_ = other.string_;
                        this.bitField0_ &= 0xFFFFFFFE;
                    } else {
                        this.ensureStringIsMutable();
                        this.string_.addAll(other.string_);
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
                StringTable parsedMessage = null;
                try {
                    parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
                }
                catch (InvalidProtocolBufferException e) {
                    parsedMessage = (StringTable)e.getUnfinishedMessage();
                    throw e;
                }
                finally {
                    if (parsedMessage != null) {
                        this.mergeFrom(parsedMessage);
                    }
                }
                return this;
            }

            private void ensureStringIsMutable() {
                if ((this.bitField0_ & 1) != 1) {
                    this.string_ = new LazyStringArrayList(this.string_);
                    this.bitField0_ |= 1;
                }
            }

            @Override
            public ProtocolStringList getStringList() {
                return this.string_.getUnmodifiableView();
            }

            @Override
            public int getStringCount() {
                return this.string_.size();
            }

            @Override
            public String getString(int index) {
                return (String)this.string_.get(index);
            }

            @Override
            public ByteString getStringBytes(int index) {
                return this.string_.getByteString(index);
            }

            public Builder setString(int index, String value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.ensureStringIsMutable();
                this.string_.set(index, value);
                return this;
            }

            public Builder addString(String value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.ensureStringIsMutable();
                this.string_.add(value);
                return this;
            }

            public Builder addAllString(Iterable<String> values2) {
                this.ensureStringIsMutable();
                AbstractMessageLite.Builder.addAll(values2, this.string_);
                return this;
            }

            public Builder clearString() {
                this.string_ = LazyStringArrayList.EMPTY;
                this.bitField0_ &= 0xFFFFFFFE;
                return this;
            }

            public Builder addStringBytes(ByteString value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.ensureStringIsMutable();
                this.string_.add(value);
                return this;
            }
        }
    }

    public static interface StringTableOrBuilder
    extends MessageLiteOrBuilder {
        public ProtocolStringList getStringList();

        public int getStringCount();

        public String getString(int var1);

        public ByteString getStringBytes(int var1);
    }

    public static enum MemberKind implements Internal.EnumLite
    {
        DECLARATION(0, 0),
        FAKE_OVERRIDE(1, 1),
        DELEGATION(2, 2),
        SYNTHESIZED(3, 3);

        public static final int DECLARATION_VALUE = 0;
        public static final int FAKE_OVERRIDE_VALUE = 1;
        public static final int DELEGATION_VALUE = 2;
        public static final int SYNTHESIZED_VALUE = 3;
        private static Internal.EnumLiteMap<MemberKind> internalValueMap;
        private final int value;

        @Override
        public final int getNumber() {
            return this.value;
        }

        public static MemberKind valueOf(int value) {
            switch (value) {
                case 0: {
                    return DECLARATION;
                }
                case 1: {
                    return FAKE_OVERRIDE;
                }
                case 2: {
                    return DELEGATION;
                }
                case 3: {
                    return SYNTHESIZED;
                }
            }
            return null;
        }

        public static Internal.EnumLiteMap<MemberKind> internalGetValueMap() {
            return internalValueMap;
        }

        private MemberKind(int index, int value) {
            this.value = value;
        }

        static {
            internalValueMap = new Internal.EnumLiteMap<MemberKind>(){

                @Override
                public MemberKind findValueByNumber(int number) {
                    return MemberKind.valueOf(number);
                }
            };
        }
    }

    public static enum Visibility implements Internal.EnumLite
    {
        INTERNAL(0, 0),
        PRIVATE(1, 1),
        PROTECTED(2, 2),
        PUBLIC(3, 3),
        PRIVATE_TO_THIS(4, 4),
        LOCAL(5, 5);

        public static final int INTERNAL_VALUE = 0;
        public static final int PRIVATE_VALUE = 1;
        public static final int PROTECTED_VALUE = 2;
        public static final int PUBLIC_VALUE = 3;
        public static final int PRIVATE_TO_THIS_VALUE = 4;
        public static final int LOCAL_VALUE = 5;
        private static Internal.EnumLiteMap<Visibility> internalValueMap;
        private final int value;

        @Override
        public final int getNumber() {
            return this.value;
        }

        public static Visibility valueOf(int value) {
            switch (value) {
                case 0: {
                    return INTERNAL;
                }
                case 1: {
                    return PRIVATE;
                }
                case 2: {
                    return PROTECTED;
                }
                case 3: {
                    return PUBLIC;
                }
                case 4: {
                    return PRIVATE_TO_THIS;
                }
                case 5: {
                    return LOCAL;
                }
            }
            return null;
        }

        public static Internal.EnumLiteMap<Visibility> internalGetValueMap() {
            return internalValueMap;
        }

        private Visibility(int index, int value) {
            this.value = value;
        }

        static {
            internalValueMap = new Internal.EnumLiteMap<Visibility>(){

                @Override
                public Visibility findValueByNumber(int number) {
                    return Visibility.valueOf(number);
                }
            };
        }
    }

    public static enum Modality implements Internal.EnumLite
    {
        FINAL(0, 0),
        OPEN(1, 1),
        ABSTRACT(2, 2),
        SEALED(3, 3);

        public static final int FINAL_VALUE = 0;
        public static final int OPEN_VALUE = 1;
        public static final int ABSTRACT_VALUE = 2;
        public static final int SEALED_VALUE = 3;
        private static Internal.EnumLiteMap<Modality> internalValueMap;
        private final int value;

        @Override
        public final int getNumber() {
            return this.value;
        }

        public static Modality valueOf(int value) {
            switch (value) {
                case 0: {
                    return FINAL;
                }
                case 1: {
                    return OPEN;
                }
                case 2: {
                    return ABSTRACT;
                }
                case 3: {
                    return SEALED;
                }
            }
            return null;
        }

        public static Internal.EnumLiteMap<Modality> internalGetValueMap() {
            return internalValueMap;
        }

        private Modality(int index, int value) {
            this.value = value;
        }

        static {
            internalValueMap = new Internal.EnumLiteMap<Modality>(){

                @Override
                public Modality findValueByNumber(int number) {
                    return Modality.valueOf(number);
                }
            };
        }
    }
}

