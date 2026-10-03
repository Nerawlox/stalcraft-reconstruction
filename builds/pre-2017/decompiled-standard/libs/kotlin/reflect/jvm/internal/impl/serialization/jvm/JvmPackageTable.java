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
import kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException;
import kotlin.reflect.jvm.internal.impl.protobuf.LazyStringArrayList;
import kotlin.reflect.jvm.internal.impl.protobuf.LazyStringList;
import kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder;
import kotlin.reflect.jvm.internal.impl.protobuf.Parser;
import kotlin.reflect.jvm.internal.impl.protobuf.ProtocolStringList;

public final class JvmPackageTable {
    private JvmPackageTable() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static final class PackageParts
    extends GeneratedMessageLite
    implements PackagePartsOrBuilder {
        private static final PackageParts defaultInstance;
        private final ByteString unknownFields;
        public static Parser<PackageParts> PARSER;
        private int bitField0_;
        public static final int PACKAGE_FQ_NAME_FIELD_NUMBER = 1;
        private Object packageFqName_;
        public static final int CLASS_NAME_FIELD_NUMBER = 2;
        private LazyStringList className_;
        public static final int MULTIFILE_FACADE_ID_FIELD_NUMBER = 3;
        private List<Integer> multifileFacadeId_;
        private int multifileFacadeIdMemoizedSerializedSize = -1;
        public static final int MULTIFILE_FACADE_NAME_FIELD_NUMBER = 4;
        private LazyStringList multifileFacadeName_;
        private byte memoizedIsInitialized = (byte)-1;
        private int memoizedSerializedSize = -1;
        private static final long serialVersionUID = 0L;

        private PackageParts(GeneratedMessageLite.Builder builder) {
            super(builder);
            this.unknownFields = builder.getUnknownFields();
        }

        private PackageParts(boolean noInit) {
            this.unknownFields = ByteString.EMPTY;
        }

        public static PackageParts getDefaultInstance() {
            return defaultInstance;
        }

        @Override
        public PackageParts getDefaultInstanceForType() {
            return defaultInstance;
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        private PackageParts(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            this.initFields();
            int mutable_bitField0_ = 0;
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
                        case 10: {
                            ByteString bs = input.readBytes();
                            this.bitField0_ |= 1;
                            this.packageFqName_ = bs;
                            continue block23;
                        }
                        case 18: {
                            ByteString bs = input.readBytes();
                            if ((mutable_bitField0_ & 2) != 2) {
                                this.className_ = new LazyStringArrayList();
                                mutable_bitField0_ |= 2;
                            }
                            this.className_.add(bs);
                            continue block23;
                        }
                        case 24: {
                            if ((mutable_bitField0_ & 4) != 4) {
                                this.multifileFacadeId_ = new ArrayList<Integer>();
                                mutable_bitField0_ |= 4;
                            }
                            this.multifileFacadeId_.add(input.readInt32());
                            continue block23;
                        }
                        case 26: {
                            int length = input.readRawVarint32();
                            int limit = input.pushLimit(length);
                            if ((mutable_bitField0_ & 4) != 4 && input.getBytesUntilLimit() > 0) {
                                this.multifileFacadeId_ = new ArrayList<Integer>();
                                mutable_bitField0_ |= 4;
                            }
                            while (input.getBytesUntilLimit() > 0) {
                                this.multifileFacadeId_.add(input.readInt32());
                            }
                            input.popLimit(limit);
                            continue block23;
                        }
                        case 34: 
                    }
                    ByteString bs = input.readBytes();
                    if ((mutable_bitField0_ & 8) != 8) {
                        this.multifileFacadeName_ = new LazyStringArrayList();
                        mutable_bitField0_ |= 8;
                    }
                    this.multifileFacadeName_.add(bs);
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
                    this.className_ = this.className_.getUnmodifiableView();
                }
                if ((mutable_bitField0_ & 4) == 4) {
                    this.multifileFacadeId_ = Collections.unmodifiableList(this.multifileFacadeId_);
                }
                if ((mutable_bitField0_ & 8) == 8) {
                    this.multifileFacadeName_ = this.multifileFacadeName_.getUnmodifiableView();
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

        public Parser<PackageParts> getParserForType() {
            return PARSER;
        }

        @Override
        public boolean hasPackageFqName() {
            return (this.bitField0_ & 1) == 1;
        }

        @Override
        public String getPackageFqName() {
            Object ref = this.packageFqName_;
            if (ref instanceof String) {
                return (String)ref;
            }
            ByteString bs = (ByteString)ref;
            String s = bs.toStringUtf8();
            if (bs.isValidUtf8()) {
                this.packageFqName_ = s;
            }
            return s;
        }

        @Override
        public ByteString getPackageFqNameBytes() {
            Object ref = this.packageFqName_;
            if (ref instanceof String) {
                ByteString b = ByteString.copyFromUtf8((String)ref);
                this.packageFqName_ = b;
                return b;
            }
            return (ByteString)ref;
        }

        @Override
        public ProtocolStringList getClassNameList() {
            return this.className_;
        }

        @Override
        public int getClassNameCount() {
            return this.className_.size();
        }

        @Override
        public String getClassName(int index) {
            return (String)this.className_.get(index);
        }

        @Override
        public ByteString getClassNameBytes(int index) {
            return this.className_.getByteString(index);
        }

        @Override
        public List<Integer> getMultifileFacadeIdList() {
            return this.multifileFacadeId_;
        }

        @Override
        public int getMultifileFacadeIdCount() {
            return this.multifileFacadeId_.size();
        }

        @Override
        public int getMultifileFacadeId(int index) {
            return this.multifileFacadeId_.get(index);
        }

        @Override
        public ProtocolStringList getMultifileFacadeNameList() {
            return this.multifileFacadeName_;
        }

        @Override
        public int getMultifileFacadeNameCount() {
            return this.multifileFacadeName_.size();
        }

        @Override
        public String getMultifileFacadeName(int index) {
            return (String)this.multifileFacadeName_.get(index);
        }

        @Override
        public ByteString getMultifileFacadeNameBytes(int index) {
            return this.multifileFacadeName_.getByteString(index);
        }

        private void initFields() {
            this.packageFqName_ = "";
            this.className_ = LazyStringArrayList.EMPTY;
            this.multifileFacadeId_ = Collections.emptyList();
            this.multifileFacadeName_ = LazyStringArrayList.EMPTY;
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
            if (!this.hasPackageFqName()) {
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
            if ((this.bitField0_ & 1) == 1) {
                output.writeBytes(1, this.getPackageFqNameBytes());
            }
            for (i = 0; i < this.className_.size(); ++i) {
                output.writeBytes(2, this.className_.getByteString(i));
            }
            if (this.getMultifileFacadeIdList().size() > 0) {
                output.writeRawVarint32(26);
                output.writeRawVarint32(this.multifileFacadeIdMemoizedSerializedSize);
            }
            for (i = 0; i < this.multifileFacadeId_.size(); ++i) {
                output.writeInt32NoTag(this.multifileFacadeId_.get(i));
            }
            for (i = 0; i < this.multifileFacadeName_.size(); ++i) {
                output.writeBytes(4, this.multifileFacadeName_.getByteString(i));
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
                size += CodedOutputStream.computeBytesSize(1, this.getPackageFqNameBytes());
            }
            int dataSize = 0;
            for (i = 0; i < this.className_.size(); ++i) {
                dataSize += CodedOutputStream.computeBytesSizeNoTag(this.className_.getByteString(i));
            }
            size += dataSize;
            size += 1 * this.getClassNameList().size();
            dataSize = 0;
            for (i = 0; i < this.multifileFacadeId_.size(); ++i) {
                dataSize += CodedOutputStream.computeInt32SizeNoTag(this.multifileFacadeId_.get(i));
            }
            size += dataSize;
            if (!this.getMultifileFacadeIdList().isEmpty()) {
                ++size;
                size += CodedOutputStream.computeInt32SizeNoTag(dataSize);
            }
            this.multifileFacadeIdMemoizedSerializedSize = dataSize;
            dataSize = 0;
            for (i = 0; i < this.multifileFacadeName_.size(); ++i) {
                dataSize += CodedOutputStream.computeBytesSizeNoTag(this.multifileFacadeName_.getByteString(i));
            }
            size += dataSize;
            size += 1 * this.getMultifileFacadeNameList().size();
            this.memoizedSerializedSize = size += this.unknownFields.size();
            return size;
        }

        @Override
        protected Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }

        public static PackageParts parseFrom(ByteString data2) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data2);
        }

        public static PackageParts parseFrom(ByteString data2, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data2, extensionRegistry);
        }

        public static PackageParts parseFrom(byte[] data2) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data2);
        }

        public static PackageParts parseFrom(byte[] data2, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data2, extensionRegistry);
        }

        public static PackageParts parseFrom(InputStream input) throws IOException {
            return PARSER.parseFrom(input);
        }

        public static PackageParts parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return PARSER.parseFrom(input, extensionRegistry);
        }

        public static PackageParts parseDelimitedFrom(InputStream input) throws IOException {
            return PARSER.parseDelimitedFrom(input);
        }

        public static PackageParts parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return PARSER.parseDelimitedFrom(input, extensionRegistry);
        }

        public static PackageParts parseFrom(CodedInputStream input) throws IOException {
            return PARSER.parseFrom(input);
        }

        public static PackageParts parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return PARSER.parseFrom(input, extensionRegistry);
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        @Override
        public Builder newBuilderForType() {
            return PackageParts.newBuilder();
        }

        public static Builder newBuilder(PackageParts prototype) {
            return PackageParts.newBuilder().mergeFrom(prototype);
        }

        @Override
        public Builder toBuilder() {
            return PackageParts.newBuilder(this);
        }

        static {
            PARSER = new AbstractParser<PackageParts>(){

                @Override
                public PackageParts parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                    return new PackageParts(input, extensionRegistry);
                }
            };
            defaultInstance = new PackageParts(true);
            defaultInstance.initFields();
        }

        public static final class Builder
        extends GeneratedMessageLite.Builder<PackageParts, Builder>
        implements PackagePartsOrBuilder {
            private int bitField0_;
            private Object packageFqName_ = "";
            private LazyStringList className_ = LazyStringArrayList.EMPTY;
            private List<Integer> multifileFacadeId_ = Collections.emptyList();
            private LazyStringList multifileFacadeName_ = LazyStringArrayList.EMPTY;

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
                this.packageFqName_ = "";
                this.bitField0_ &= 0xFFFFFFFE;
                this.className_ = LazyStringArrayList.EMPTY;
                this.bitField0_ &= 0xFFFFFFFD;
                this.multifileFacadeId_ = Collections.emptyList();
                this.bitField0_ &= 0xFFFFFFFB;
                this.multifileFacadeName_ = LazyStringArrayList.EMPTY;
                this.bitField0_ &= 0xFFFFFFF7;
                return this;
            }

            @Override
            public Builder clone() {
                return Builder.create().mergeFrom(this.buildPartial());
            }

            @Override
            public PackageParts getDefaultInstanceForType() {
                return PackageParts.getDefaultInstance();
            }

            @Override
            public PackageParts build() {
                PackageParts result2 = this.buildPartial();
                if (!result2.isInitialized()) {
                    throw Builder.newUninitializedMessageException(result2);
                }
                return result2;
            }

            @Override
            public PackageParts buildPartial() {
                PackageParts result2 = new PackageParts(this);
                int from_bitField0_ = this.bitField0_;
                int to_bitField0_ = 0;
                if ((from_bitField0_ & 1) == 1) {
                    to_bitField0_ |= 1;
                }
                result2.packageFqName_ = this.packageFqName_;
                if ((this.bitField0_ & 2) == 2) {
                    this.className_ = this.className_.getUnmodifiableView();
                    this.bitField0_ &= 0xFFFFFFFD;
                }
                result2.className_ = this.className_;
                if ((this.bitField0_ & 4) == 4) {
                    this.multifileFacadeId_ = Collections.unmodifiableList(this.multifileFacadeId_);
                    this.bitField0_ &= 0xFFFFFFFB;
                }
                result2.multifileFacadeId_ = this.multifileFacadeId_;
                if ((this.bitField0_ & 8) == 8) {
                    this.multifileFacadeName_ = this.multifileFacadeName_.getUnmodifiableView();
                    this.bitField0_ &= 0xFFFFFFF7;
                }
                result2.multifileFacadeName_ = this.multifileFacadeName_;
                result2.bitField0_ = to_bitField0_;
                return result2;
            }

            @Override
            public Builder mergeFrom(PackageParts other) {
                if (other == PackageParts.getDefaultInstance()) {
                    return this;
                }
                if (other.hasPackageFqName()) {
                    this.bitField0_ |= 1;
                    this.packageFqName_ = other.packageFqName_;
                }
                if (!other.className_.isEmpty()) {
                    if (this.className_.isEmpty()) {
                        this.className_ = other.className_;
                        this.bitField0_ &= 0xFFFFFFFD;
                    } else {
                        this.ensureClassNameIsMutable();
                        this.className_.addAll(other.className_);
                    }
                }
                if (!other.multifileFacadeId_.isEmpty()) {
                    if (this.multifileFacadeId_.isEmpty()) {
                        this.multifileFacadeId_ = other.multifileFacadeId_;
                        this.bitField0_ &= 0xFFFFFFFB;
                    } else {
                        this.ensureMultifileFacadeIdIsMutable();
                        this.multifileFacadeId_.addAll(other.multifileFacadeId_);
                    }
                }
                if (!other.multifileFacadeName_.isEmpty()) {
                    if (this.multifileFacadeName_.isEmpty()) {
                        this.multifileFacadeName_ = other.multifileFacadeName_;
                        this.bitField0_ &= 0xFFFFFFF7;
                    } else {
                        this.ensureMultifileFacadeNameIsMutable();
                        this.multifileFacadeName_.addAll(other.multifileFacadeName_);
                    }
                }
                this.setUnknownFields(this.getUnknownFields().concat(other.unknownFields));
                return this;
            }

            @Override
            public final boolean isInitialized() {
                return this.hasPackageFqName();
            }

            @Override
            public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                PackageParts parsedMessage = null;
                try {
                    parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
                }
                catch (InvalidProtocolBufferException e) {
                    parsedMessage = (PackageParts)e.getUnfinishedMessage();
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
            public boolean hasPackageFqName() {
                return (this.bitField0_ & 1) == 1;
            }

            @Override
            public String getPackageFqName() {
                Object ref = this.packageFqName_;
                if (!(ref instanceof String)) {
                    ByteString bs = (ByteString)ref;
                    String s = bs.toStringUtf8();
                    if (bs.isValidUtf8()) {
                        this.packageFqName_ = s;
                    }
                    return s;
                }
                return (String)ref;
            }

            @Override
            public ByteString getPackageFqNameBytes() {
                Object ref = this.packageFqName_;
                if (ref instanceof String) {
                    ByteString b = ByteString.copyFromUtf8((String)ref);
                    this.packageFqName_ = b;
                    return b;
                }
                return (ByteString)ref;
            }

            public Builder setPackageFqName(String value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.bitField0_ |= 1;
                this.packageFqName_ = value;
                return this;
            }

            public Builder clearPackageFqName() {
                this.bitField0_ &= 0xFFFFFFFE;
                this.packageFqName_ = PackageParts.getDefaultInstance().getPackageFqName();
                return this;
            }

            public Builder setPackageFqNameBytes(ByteString value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.bitField0_ |= 1;
                this.packageFqName_ = value;
                return this;
            }

            private void ensureClassNameIsMutable() {
                if ((this.bitField0_ & 2) != 2) {
                    this.className_ = new LazyStringArrayList(this.className_);
                    this.bitField0_ |= 2;
                }
            }

            @Override
            public ProtocolStringList getClassNameList() {
                return this.className_.getUnmodifiableView();
            }

            @Override
            public int getClassNameCount() {
                return this.className_.size();
            }

            @Override
            public String getClassName(int index) {
                return (String)this.className_.get(index);
            }

            @Override
            public ByteString getClassNameBytes(int index) {
                return this.className_.getByteString(index);
            }

            public Builder setClassName(int index, String value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.ensureClassNameIsMutable();
                this.className_.set(index, value);
                return this;
            }

            public Builder addClassName(String value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.ensureClassNameIsMutable();
                this.className_.add(value);
                return this;
            }

            public Builder addAllClassName(Iterable<String> values2) {
                this.ensureClassNameIsMutable();
                AbstractMessageLite.Builder.addAll(values2, this.className_);
                return this;
            }

            public Builder clearClassName() {
                this.className_ = LazyStringArrayList.EMPTY;
                this.bitField0_ &= 0xFFFFFFFD;
                return this;
            }

            public Builder addClassNameBytes(ByteString value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.ensureClassNameIsMutable();
                this.className_.add(value);
                return this;
            }

            private void ensureMultifileFacadeIdIsMutable() {
                if ((this.bitField0_ & 4) != 4) {
                    this.multifileFacadeId_ = new ArrayList<Integer>(this.multifileFacadeId_);
                    this.bitField0_ |= 4;
                }
            }

            @Override
            public List<Integer> getMultifileFacadeIdList() {
                return Collections.unmodifiableList(this.multifileFacadeId_);
            }

            @Override
            public int getMultifileFacadeIdCount() {
                return this.multifileFacadeId_.size();
            }

            @Override
            public int getMultifileFacadeId(int index) {
                return this.multifileFacadeId_.get(index);
            }

            public Builder setMultifileFacadeId(int index, int value) {
                this.ensureMultifileFacadeIdIsMutable();
                this.multifileFacadeId_.set(index, value);
                return this;
            }

            public Builder addMultifileFacadeId(int value) {
                this.ensureMultifileFacadeIdIsMutable();
                this.multifileFacadeId_.add(value);
                return this;
            }

            public Builder addAllMultifileFacadeId(Iterable<? extends Integer> values2) {
                this.ensureMultifileFacadeIdIsMutable();
                AbstractMessageLite.Builder.addAll(values2, this.multifileFacadeId_);
                return this;
            }

            public Builder clearMultifileFacadeId() {
                this.multifileFacadeId_ = Collections.emptyList();
                this.bitField0_ &= 0xFFFFFFFB;
                return this;
            }

            private void ensureMultifileFacadeNameIsMutable() {
                if ((this.bitField0_ & 8) != 8) {
                    this.multifileFacadeName_ = new LazyStringArrayList(this.multifileFacadeName_);
                    this.bitField0_ |= 8;
                }
            }

            @Override
            public ProtocolStringList getMultifileFacadeNameList() {
                return this.multifileFacadeName_.getUnmodifiableView();
            }

            @Override
            public int getMultifileFacadeNameCount() {
                return this.multifileFacadeName_.size();
            }

            @Override
            public String getMultifileFacadeName(int index) {
                return (String)this.multifileFacadeName_.get(index);
            }

            @Override
            public ByteString getMultifileFacadeNameBytes(int index) {
                return this.multifileFacadeName_.getByteString(index);
            }

            public Builder setMultifileFacadeName(int index, String value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.ensureMultifileFacadeNameIsMutable();
                this.multifileFacadeName_.set(index, value);
                return this;
            }

            public Builder addMultifileFacadeName(String value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.ensureMultifileFacadeNameIsMutable();
                this.multifileFacadeName_.add(value);
                return this;
            }

            public Builder addAllMultifileFacadeName(Iterable<String> values2) {
                this.ensureMultifileFacadeNameIsMutable();
                AbstractMessageLite.Builder.addAll(values2, this.multifileFacadeName_);
                return this;
            }

            public Builder clearMultifileFacadeName() {
                this.multifileFacadeName_ = LazyStringArrayList.EMPTY;
                this.bitField0_ &= 0xFFFFFFF7;
                return this;
            }

            public Builder addMultifileFacadeNameBytes(ByteString value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.ensureMultifileFacadeNameIsMutable();
                this.multifileFacadeName_.add(value);
                return this;
            }
        }
    }

    public static interface PackagePartsOrBuilder
    extends MessageLiteOrBuilder {
        public boolean hasPackageFqName();

        public String getPackageFqName();

        public ByteString getPackageFqNameBytes();

        public ProtocolStringList getClassNameList();

        public int getClassNameCount();

        public String getClassName(int var1);

        public ByteString getClassNameBytes(int var1);

        public List<Integer> getMultifileFacadeIdList();

        public int getMultifileFacadeIdCount();

        public int getMultifileFacadeId(int var1);

        public ProtocolStringList getMultifileFacadeNameList();

        public int getMultifileFacadeNameCount();

        public String getMultifileFacadeName(int var1);

        public ByteString getMultifileFacadeNameBytes(int var1);
    }

    public static final class PackageTable
    extends GeneratedMessageLite
    implements PackageTableOrBuilder {
        private static final PackageTable defaultInstance;
        private final ByteString unknownFields;
        public static Parser<PackageTable> PARSER;
        public static final int PACKAGE_PARTS_FIELD_NUMBER = 1;
        private List<PackageParts> packageParts_;
        public static final int METADATA_PARTS_FIELD_NUMBER = 2;
        private List<PackageParts> metadataParts_;
        private byte memoizedIsInitialized = (byte)-1;
        private int memoizedSerializedSize = -1;
        private static final long serialVersionUID = 0L;

        private PackageTable(GeneratedMessageLite.Builder builder) {
            super(builder);
            this.unknownFields = builder.getUnknownFields();
        }

        private PackageTable(boolean noInit) {
            this.unknownFields = ByteString.EMPTY;
        }

        public static PackageTable getDefaultInstance() {
            return defaultInstance;
        }

        @Override
        public PackageTable getDefaultInstanceForType() {
            return defaultInstance;
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        private PackageTable(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                        case 10: {
                            if ((mutable_bitField0_ & 1) != 1) {
                                this.packageParts_ = new ArrayList<PackageParts>();
                                mutable_bitField0_ |= 1;
                            }
                            this.packageParts_.add(input.readMessage(PackageParts.PARSER, extensionRegistry));
                            continue block20;
                        }
                        case 18: 
                    }
                    if ((mutable_bitField0_ & 2) != 2) {
                        this.metadataParts_ = new ArrayList<PackageParts>();
                        mutable_bitField0_ |= 2;
                    }
                    this.metadataParts_.add(input.readMessage(PackageParts.PARSER, extensionRegistry));
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
                    this.packageParts_ = Collections.unmodifiableList(this.packageParts_);
                }
                if ((mutable_bitField0_ & 2) == 2) {
                    this.metadataParts_ = Collections.unmodifiableList(this.metadataParts_);
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

        public Parser<PackageTable> getParserForType() {
            return PARSER;
        }

        @Override
        public List<PackageParts> getPackagePartsList() {
            return this.packageParts_;
        }

        public List<? extends PackagePartsOrBuilder> getPackagePartsOrBuilderList() {
            return this.packageParts_;
        }

        @Override
        public int getPackagePartsCount() {
            return this.packageParts_.size();
        }

        @Override
        public PackageParts getPackageParts(int index) {
            return this.packageParts_.get(index);
        }

        public PackagePartsOrBuilder getPackagePartsOrBuilder(int index) {
            return this.packageParts_.get(index);
        }

        @Override
        public List<PackageParts> getMetadataPartsList() {
            return this.metadataParts_;
        }

        public List<? extends PackagePartsOrBuilder> getMetadataPartsOrBuilderList() {
            return this.metadataParts_;
        }

        @Override
        public int getMetadataPartsCount() {
            return this.metadataParts_.size();
        }

        @Override
        public PackageParts getMetadataParts(int index) {
            return this.metadataParts_.get(index);
        }

        public PackagePartsOrBuilder getMetadataPartsOrBuilder(int index) {
            return this.metadataParts_.get(index);
        }

        private void initFields() {
            this.packageParts_ = Collections.emptyList();
            this.metadataParts_ = Collections.emptyList();
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
            for (i = 0; i < this.getPackagePartsCount(); ++i) {
                if (this.getPackageParts(i).isInitialized()) continue;
                this.memoizedIsInitialized = 0;
                return false;
            }
            for (i = 0; i < this.getMetadataPartsCount(); ++i) {
                if (this.getMetadataParts(i).isInitialized()) continue;
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
            for (i = 0; i < this.packageParts_.size(); ++i) {
                output.writeMessage(1, this.packageParts_.get(i));
            }
            for (i = 0; i < this.metadataParts_.size(); ++i) {
                output.writeMessage(2, this.metadataParts_.get(i));
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
            for (i = 0; i < this.packageParts_.size(); ++i) {
                size += CodedOutputStream.computeMessageSize(1, this.packageParts_.get(i));
            }
            for (i = 0; i < this.metadataParts_.size(); ++i) {
                size += CodedOutputStream.computeMessageSize(2, this.metadataParts_.get(i));
            }
            this.memoizedSerializedSize = size += this.unknownFields.size();
            return size;
        }

        @Override
        protected Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }

        public static PackageTable parseFrom(ByteString data2) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data2);
        }

        public static PackageTable parseFrom(ByteString data2, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data2, extensionRegistry);
        }

        public static PackageTable parseFrom(byte[] data2) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data2);
        }

        public static PackageTable parseFrom(byte[] data2, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data2, extensionRegistry);
        }

        public static PackageTable parseFrom(InputStream input) throws IOException {
            return PARSER.parseFrom(input);
        }

        public static PackageTable parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return PARSER.parseFrom(input, extensionRegistry);
        }

        public static PackageTable parseDelimitedFrom(InputStream input) throws IOException {
            return PARSER.parseDelimitedFrom(input);
        }

        public static PackageTable parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return PARSER.parseDelimitedFrom(input, extensionRegistry);
        }

        public static PackageTable parseFrom(CodedInputStream input) throws IOException {
            return PARSER.parseFrom(input);
        }

        public static PackageTable parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return PARSER.parseFrom(input, extensionRegistry);
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        @Override
        public Builder newBuilderForType() {
            return PackageTable.newBuilder();
        }

        public static Builder newBuilder(PackageTable prototype) {
            return PackageTable.newBuilder().mergeFrom(prototype);
        }

        @Override
        public Builder toBuilder() {
            return PackageTable.newBuilder(this);
        }

        static {
            PARSER = new AbstractParser<PackageTable>(){

                @Override
                public PackageTable parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                    return new PackageTable(input, extensionRegistry);
                }
            };
            defaultInstance = new PackageTable(true);
            defaultInstance.initFields();
        }

        public static final class Builder
        extends GeneratedMessageLite.Builder<PackageTable, Builder>
        implements PackageTableOrBuilder {
            private int bitField0_;
            private List<PackageParts> packageParts_ = Collections.emptyList();
            private List<PackageParts> metadataParts_ = Collections.emptyList();

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
                this.packageParts_ = Collections.emptyList();
                this.bitField0_ &= 0xFFFFFFFE;
                this.metadataParts_ = Collections.emptyList();
                this.bitField0_ &= 0xFFFFFFFD;
                return this;
            }

            @Override
            public Builder clone() {
                return Builder.create().mergeFrom(this.buildPartial());
            }

            @Override
            public PackageTable getDefaultInstanceForType() {
                return PackageTable.getDefaultInstance();
            }

            @Override
            public PackageTable build() {
                PackageTable result2 = this.buildPartial();
                if (!result2.isInitialized()) {
                    throw Builder.newUninitializedMessageException(result2);
                }
                return result2;
            }

            @Override
            public PackageTable buildPartial() {
                PackageTable result2 = new PackageTable(this);
                int from_bitField0_ = this.bitField0_;
                if ((this.bitField0_ & 1) == 1) {
                    this.packageParts_ = Collections.unmodifiableList(this.packageParts_);
                    this.bitField0_ &= 0xFFFFFFFE;
                }
                result2.packageParts_ = this.packageParts_;
                if ((this.bitField0_ & 2) == 2) {
                    this.metadataParts_ = Collections.unmodifiableList(this.metadataParts_);
                    this.bitField0_ &= 0xFFFFFFFD;
                }
                result2.metadataParts_ = this.metadataParts_;
                return result2;
            }

            @Override
            public Builder mergeFrom(PackageTable other) {
                if (other == PackageTable.getDefaultInstance()) {
                    return this;
                }
                if (!other.packageParts_.isEmpty()) {
                    if (this.packageParts_.isEmpty()) {
                        this.packageParts_ = other.packageParts_;
                        this.bitField0_ &= 0xFFFFFFFE;
                    } else {
                        this.ensurePackagePartsIsMutable();
                        this.packageParts_.addAll(other.packageParts_);
                    }
                }
                if (!other.metadataParts_.isEmpty()) {
                    if (this.metadataParts_.isEmpty()) {
                        this.metadataParts_ = other.metadataParts_;
                        this.bitField0_ &= 0xFFFFFFFD;
                    } else {
                        this.ensureMetadataPartsIsMutable();
                        this.metadataParts_.addAll(other.metadataParts_);
                    }
                }
                this.setUnknownFields(this.getUnknownFields().concat(other.unknownFields));
                return this;
            }

            @Override
            public final boolean isInitialized() {
                int i;
                for (i = 0; i < this.getPackagePartsCount(); ++i) {
                    if (this.getPackageParts(i).isInitialized()) continue;
                    return false;
                }
                for (i = 0; i < this.getMetadataPartsCount(); ++i) {
                    if (this.getMetadataParts(i).isInitialized()) continue;
                    return false;
                }
                return true;
            }

            @Override
            public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                PackageTable parsedMessage = null;
                try {
                    parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
                }
                catch (InvalidProtocolBufferException e) {
                    parsedMessage = (PackageTable)e.getUnfinishedMessage();
                    throw e;
                }
                finally {
                    if (parsedMessage != null) {
                        this.mergeFrom(parsedMessage);
                    }
                }
                return this;
            }

            private void ensurePackagePartsIsMutable() {
                if ((this.bitField0_ & 1) != 1) {
                    this.packageParts_ = new ArrayList<PackageParts>(this.packageParts_);
                    this.bitField0_ |= 1;
                }
            }

            @Override
            public List<PackageParts> getPackagePartsList() {
                return Collections.unmodifiableList(this.packageParts_);
            }

            @Override
            public int getPackagePartsCount() {
                return this.packageParts_.size();
            }

            @Override
            public PackageParts getPackageParts(int index) {
                return this.packageParts_.get(index);
            }

            public Builder setPackageParts(int index, PackageParts value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.ensurePackagePartsIsMutable();
                this.packageParts_.set(index, value);
                return this;
            }

            public Builder setPackageParts(int index, PackageParts.Builder builderForValue) {
                this.ensurePackagePartsIsMutable();
                this.packageParts_.set(index, builderForValue.build());
                return this;
            }

            public Builder addPackageParts(PackageParts value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.ensurePackagePartsIsMutable();
                this.packageParts_.add(value);
                return this;
            }

            public Builder addPackageParts(int index, PackageParts value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.ensurePackagePartsIsMutable();
                this.packageParts_.add(index, value);
                return this;
            }

            public Builder addPackageParts(PackageParts.Builder builderForValue) {
                this.ensurePackagePartsIsMutable();
                this.packageParts_.add(builderForValue.build());
                return this;
            }

            public Builder addPackageParts(int index, PackageParts.Builder builderForValue) {
                this.ensurePackagePartsIsMutable();
                this.packageParts_.add(index, builderForValue.build());
                return this;
            }

            public Builder addAllPackageParts(Iterable<? extends PackageParts> values2) {
                this.ensurePackagePartsIsMutable();
                AbstractMessageLite.Builder.addAll(values2, this.packageParts_);
                return this;
            }

            public Builder clearPackageParts() {
                this.packageParts_ = Collections.emptyList();
                this.bitField0_ &= 0xFFFFFFFE;
                return this;
            }

            public Builder removePackageParts(int index) {
                this.ensurePackagePartsIsMutable();
                this.packageParts_.remove(index);
                return this;
            }

            private void ensureMetadataPartsIsMutable() {
                if ((this.bitField0_ & 2) != 2) {
                    this.metadataParts_ = new ArrayList<PackageParts>(this.metadataParts_);
                    this.bitField0_ |= 2;
                }
            }

            @Override
            public List<PackageParts> getMetadataPartsList() {
                return Collections.unmodifiableList(this.metadataParts_);
            }

            @Override
            public int getMetadataPartsCount() {
                return this.metadataParts_.size();
            }

            @Override
            public PackageParts getMetadataParts(int index) {
                return this.metadataParts_.get(index);
            }

            public Builder setMetadataParts(int index, PackageParts value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.ensureMetadataPartsIsMutable();
                this.metadataParts_.set(index, value);
                return this;
            }

            public Builder setMetadataParts(int index, PackageParts.Builder builderForValue) {
                this.ensureMetadataPartsIsMutable();
                this.metadataParts_.set(index, builderForValue.build());
                return this;
            }

            public Builder addMetadataParts(PackageParts value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.ensureMetadataPartsIsMutable();
                this.metadataParts_.add(value);
                return this;
            }

            public Builder addMetadataParts(int index, PackageParts value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.ensureMetadataPartsIsMutable();
                this.metadataParts_.add(index, value);
                return this;
            }

            public Builder addMetadataParts(PackageParts.Builder builderForValue) {
                this.ensureMetadataPartsIsMutable();
                this.metadataParts_.add(builderForValue.build());
                return this;
            }

            public Builder addMetadataParts(int index, PackageParts.Builder builderForValue) {
                this.ensureMetadataPartsIsMutable();
                this.metadataParts_.add(index, builderForValue.build());
                return this;
            }

            public Builder addAllMetadataParts(Iterable<? extends PackageParts> values2) {
                this.ensureMetadataPartsIsMutable();
                AbstractMessageLite.Builder.addAll(values2, this.metadataParts_);
                return this;
            }

            public Builder clearMetadataParts() {
                this.metadataParts_ = Collections.emptyList();
                this.bitField0_ &= 0xFFFFFFFD;
                return this;
            }

            public Builder removeMetadataParts(int index) {
                this.ensureMetadataPartsIsMutable();
                this.metadataParts_.remove(index);
                return this;
            }
        }
    }

    public static interface PackageTableOrBuilder
    extends MessageLiteOrBuilder {
        public List<PackageParts> getPackagePartsList();

        public PackageParts getPackageParts(int var1);

        public int getPackagePartsCount();

        public List<PackageParts> getMetadataPartsList();

        public PackageParts getMetadataParts(int var1);

        public int getMetadataPartsCount();
    }
}

