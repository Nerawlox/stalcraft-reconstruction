/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.protobuf;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import kotlin.reflect.jvm.internal.impl.protobuf.BoundedByteString;
import kotlin.reflect.jvm.internal.impl.protobuf.ByteString;
import kotlin.reflect.jvm.internal.impl.protobuf.CodedInputStream;
import kotlin.reflect.jvm.internal.impl.protobuf.RopeByteString;
import kotlin.reflect.jvm.internal.impl.protobuf.Utf8;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 */
class LiteralByteString
extends ByteString {
    protected final byte[] bytes;
    private int hash = 0;

    LiteralByteString(byte[] bytes) {
        this.bytes = bytes;
    }

    @Override
    public byte byteAt(int index) {
        return this.bytes[index];
    }

    @Override
    public int size() {
        return this.bytes.length;
    }

    @Override
    public ByteString substring(int beginIndex, int endIndex) {
        if (beginIndex < 0) {
            int n = beginIndex;
            throw new IndexOutOfBoundsException(new StringBuilder(32).append("Beginning index: ").append(n).append(" < 0").toString());
        }
        if (endIndex > this.size()) {
            int n = endIndex;
            int n2 = this.size();
            throw new IndexOutOfBoundsException(new StringBuilder(36).append("End index: ").append(n).append(" > ").append(n2).toString());
        }
        int substringLength = endIndex - beginIndex;
        if (substringLength < 0) {
            int n = beginIndex;
            int n3 = endIndex;
            throw new IndexOutOfBoundsException(new StringBuilder(66).append("Beginning index larger than ending index: ").append(n).append(", ").append(n3).toString());
        }
        ByteString result2 = substringLength == 0 ? ByteString.EMPTY : new BoundedByteString(this.bytes, this.getOffsetIntoBytes() + beginIndex, substringLength);
        return result2;
    }

    @Override
    protected void copyToInternal(byte[] target, int sourceOffset, int targetOffset, int numberToCopy) {
        System.arraycopy(this.bytes, sourceOffset, target, targetOffset, numberToCopy);
    }

    @Override
    public void copyTo(ByteBuffer target) {
        target.put(this.bytes, this.getOffsetIntoBytes(), this.size());
    }

    @Override
    public ByteBuffer asReadOnlyByteBuffer() {
        ByteBuffer byteBuffer = ByteBuffer.wrap(this.bytes, this.getOffsetIntoBytes(), this.size());
        return byteBuffer.asReadOnlyBuffer();
    }

    @Override
    public List<ByteBuffer> asReadOnlyByteBufferList() {
        ArrayList<ByteBuffer> result2 = new ArrayList<ByteBuffer>(1);
        result2.add(this.asReadOnlyByteBuffer());
        return result2;
    }

    @Override
    public void writeTo(OutputStream outputStream) throws IOException {
        outputStream.write(this.toByteArray());
    }

    @Override
    void writeToInternal(OutputStream outputStream, int sourceOffset, int numberToWrite) throws IOException {
        outputStream.write(this.bytes, this.getOffsetIntoBytes() + sourceOffset, numberToWrite);
    }

    @Override
    public String toString(String charsetName) throws UnsupportedEncodingException {
        return new String(this.bytes, this.getOffsetIntoBytes(), this.size(), charsetName);
    }

    @Override
    public boolean isValidUtf8() {
        int offset = this.getOffsetIntoBytes();
        return Utf8.isValidUtf8(this.bytes, offset, offset + this.size());
    }

    @Override
    protected int partialIsValidUtf8(int state, int offset, int length) {
        int index = this.getOffsetIntoBytes() + offset;
        return Utf8.partialIsValidUtf8(state, this.bytes, index, index + length);
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if (!(other instanceof ByteString)) {
            return false;
        }
        if (this.size() != ((ByteString)other).size()) {
            return false;
        }
        if (this.size() == 0) {
            return true;
        }
        if (other instanceof LiteralByteString) {
            return this.equalsRange((LiteralByteString)other, 0, this.size());
        }
        if (other instanceof RopeByteString) {
            return other.equals(this);
        }
        String string = String.valueOf(String.valueOf(other.getClass()));
        throw new IllegalArgumentException(new StringBuilder(49 + string.length()).append("Has a new type of ByteString been created? Found ").append(string).toString());
    }

    boolean equalsRange(LiteralByteString other, int offset, int length) {
        if (length > other.size()) {
            int n = length;
            int n2 = this.size();
            throw new IllegalArgumentException(new StringBuilder(40).append("Length too large: ").append(n).append(n2).toString());
        }
        if (offset + length > other.size()) {
            int n = offset;
            int n3 = length;
            int n4 = other.size();
            throw new IllegalArgumentException(new StringBuilder(59).append("Ran off end of other: ").append(n).append(", ").append(n3).append(", ").append(n4).toString());
        }
        byte[] thisBytes = this.bytes;
        byte[] otherBytes = other.bytes;
        int thisLimit = this.getOffsetIntoBytes() + length;
        int thisIndex = this.getOffsetIntoBytes();
        int otherIndex = other.getOffsetIntoBytes() + offset;
        while (thisIndex < thisLimit) {
            if (thisBytes[thisIndex] != otherBytes[otherIndex]) {
                return false;
            }
            ++thisIndex;
            ++otherIndex;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int h = this.hash;
        if (h == 0) {
            int size = this.size();
            h = this.partialHash(size, 0, size);
            if (h == 0) {
                h = 1;
            }
            this.hash = h;
        }
        return h;
    }

    @Override
    protected int peekCachedHashCode() {
        return this.hash;
    }

    @Override
    protected int partialHash(int h, int offset, int length) {
        return LiteralByteString.hashCode(h, this.bytes, this.getOffsetIntoBytes() + offset, length);
    }

    static int hashCode(int h, byte[] bytes, int offset, int length) {
        for (int i = offset; i < offset + length; ++i) {
            h = h * 31 + bytes[i];
        }
        return h;
    }

    static int hashCode(byte[] bytes) {
        int h = LiteralByteString.hashCode(bytes.length, bytes, 0, bytes.length);
        return h == 0 ? 1 : h;
    }

    @Override
    public InputStream newInput() {
        return new ByteArrayInputStream(this.bytes, this.getOffsetIntoBytes(), this.size());
    }

    @Override
    public CodedInputStream newCodedInput() {
        return CodedInputStream.newInstance(this);
    }

    @Override
    public ByteString.ByteIterator iterator() {
        return new LiteralByteIterator();
    }

    @Override
    protected int getTreeDepth() {
        return 0;
    }

    @Override
    protected boolean isBalanced() {
        return true;
    }

    protected int getOffsetIntoBytes() {
        return 0;
    }

    private class LiteralByteIterator
    implements ByteString.ByteIterator {
        private int position = 0;
        private final int limit;

        private LiteralByteIterator() {
            this.limit = LiteralByteString.this.size();
        }

        public boolean hasNext() {
            return this.position < this.limit;
        }

        public Byte next() {
            return this.nextByte();
        }

        public byte nextByte() {
            try {
                return LiteralByteString.this.bytes[this.position++];
            }
            catch (ArrayIndexOutOfBoundsException e) {
                throw new NoSuchElementException(e.getMessage());
            }
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }
    }
}

