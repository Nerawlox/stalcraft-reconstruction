/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.protobuf;

import java.io.IOException;
import java.io.InputStream;
import kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite;
import kotlin.reflect.jvm.internal.impl.protobuf.ByteString;
import kotlin.reflect.jvm.internal.impl.protobuf.CodedInputStream;
import kotlin.reflect.jvm.internal.impl.protobuf.ExtensionRegistryLite;
import kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException;
import kotlin.reflect.jvm.internal.impl.protobuf.MessageLite;
import kotlin.reflect.jvm.internal.impl.protobuf.Parser;
import kotlin.reflect.jvm.internal.impl.protobuf.UninitializedMessageException;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 */
public abstract class AbstractParser<MessageType extends MessageLite>
implements Parser<MessageType> {
    private static final ExtensionRegistryLite EMPTY_REGISTRY = ExtensionRegistryLite.getEmptyRegistry();

    private UninitializedMessageException newUninitializedMessageException(MessageType message) {
        if (message instanceof AbstractMessageLite) {
            return ((AbstractMessageLite)message).newUninitializedMessageException();
        }
        return new UninitializedMessageException((MessageLite)message);
    }

    private MessageType checkMessageInitialized(MessageType message) throws InvalidProtocolBufferException {
        if (message != null && !message.isInitialized()) {
            throw this.newUninitializedMessageException(message).asInvalidProtocolBufferException().setUnfinishedMessage((MessageLite)message);
        }
        return message;
    }

    @Override
    public MessageType parsePartialFrom(CodedInputStream input) throws InvalidProtocolBufferException {
        return (MessageType)((MessageLite)this.parsePartialFrom(input, EMPTY_REGISTRY));
    }

    @Override
    public MessageType parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return (MessageType)this.checkMessageInitialized((MessageLite)this.parsePartialFrom(input, extensionRegistry));
    }

    @Override
    public MessageType parseFrom(CodedInputStream input) throws InvalidProtocolBufferException {
        return (MessageType)this.parseFrom(input, EMPTY_REGISTRY);
    }

    @Override
    public MessageType parsePartialFrom(ByteString data2, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        CodedInputStream input = data2.newCodedInput();
        MessageLite message = (MessageLite)this.parsePartialFrom(input, extensionRegistry);
        try {
            input.checkLastTagWas(0);
        }
        catch (InvalidProtocolBufferException e) {
            throw e.setUnfinishedMessage(message);
        }
        return (MessageType)message;
    }

    @Override
    public MessageType parsePartialFrom(ByteString data2) throws InvalidProtocolBufferException {
        return (MessageType)this.parsePartialFrom(data2, EMPTY_REGISTRY);
    }

    @Override
    public MessageType parseFrom(ByteString data2, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return (MessageType)this.checkMessageInitialized(this.parsePartialFrom(data2, extensionRegistry));
    }

    @Override
    public MessageType parseFrom(ByteString data2) throws InvalidProtocolBufferException {
        return (MessageType)this.parseFrom(data2, EMPTY_REGISTRY);
    }

    @Override
    public MessageType parsePartialFrom(byte[] data2, int off, int len, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        CodedInputStream input = CodedInputStream.newInstance(data2, off, len);
        MessageLite message = (MessageLite)this.parsePartialFrom(input, extensionRegistry);
        try {
            input.checkLastTagWas(0);
        }
        catch (InvalidProtocolBufferException e) {
            throw e.setUnfinishedMessage(message);
        }
        return (MessageType)message;
    }

    @Override
    public MessageType parsePartialFrom(byte[] data2, int off, int len) throws InvalidProtocolBufferException {
        return (MessageType)this.parsePartialFrom(data2, off, len, EMPTY_REGISTRY);
    }

    @Override
    public MessageType parsePartialFrom(byte[] data2, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return (MessageType)this.parsePartialFrom(data2, 0, data2.length, extensionRegistry);
    }

    @Override
    public MessageType parsePartialFrom(byte[] data2) throws InvalidProtocolBufferException {
        return (MessageType)this.parsePartialFrom(data2, 0, data2.length, EMPTY_REGISTRY);
    }

    @Override
    public MessageType parseFrom(byte[] data2, int off, int len, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return (MessageType)this.checkMessageInitialized(this.parsePartialFrom(data2, off, len, extensionRegistry));
    }

    @Override
    public MessageType parseFrom(byte[] data2, int off, int len) throws InvalidProtocolBufferException {
        return (MessageType)this.parseFrom(data2, off, len, EMPTY_REGISTRY);
    }

    @Override
    public MessageType parseFrom(byte[] data2, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return (MessageType)this.parseFrom(data2, 0, data2.length, extensionRegistry);
    }

    @Override
    public MessageType parseFrom(byte[] data2) throws InvalidProtocolBufferException {
        return (MessageType)this.parseFrom(data2, EMPTY_REGISTRY);
    }

    @Override
    public MessageType parsePartialFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        CodedInputStream codedInput = CodedInputStream.newInstance(input);
        MessageLite message = (MessageLite)this.parsePartialFrom(codedInput, extensionRegistry);
        try {
            codedInput.checkLastTagWas(0);
        }
        catch (InvalidProtocolBufferException e) {
            throw e.setUnfinishedMessage(message);
        }
        return (MessageType)message;
    }

    @Override
    public MessageType parsePartialFrom(InputStream input) throws InvalidProtocolBufferException {
        return (MessageType)this.parsePartialFrom(input, EMPTY_REGISTRY);
    }

    @Override
    public MessageType parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return (MessageType)this.checkMessageInitialized(this.parsePartialFrom(input, extensionRegistry));
    }

    @Override
    public MessageType parseFrom(InputStream input) throws InvalidProtocolBufferException {
        return (MessageType)this.parseFrom(input, EMPTY_REGISTRY);
    }

    @Override
    public MessageType parsePartialDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        int size;
        try {
            int firstByte = input.read();
            if (firstByte == -1) {
                return null;
            }
            size = CodedInputStream.readRawVarint32(firstByte, input);
        }
        catch (IOException e) {
            throw new InvalidProtocolBufferException(e.getMessage());
        }
        AbstractMessageLite.Builder.LimitedInputStream limitedInput = new AbstractMessageLite.Builder.LimitedInputStream(input, size);
        return (MessageType)this.parsePartialFrom(limitedInput, extensionRegistry);
    }

    @Override
    public MessageType parsePartialDelimitedFrom(InputStream input) throws InvalidProtocolBufferException {
        return (MessageType)this.parsePartialDelimitedFrom(input, EMPTY_REGISTRY);
    }

    @Override
    public MessageType parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return (MessageType)this.checkMessageInitialized(this.parsePartialDelimitedFrom(input, extensionRegistry));
    }

    @Override
    public MessageType parseDelimitedFrom(InputStream input) throws InvalidProtocolBufferException {
        return (MessageType)this.parseDelimitedFrom(input, EMPTY_REGISTRY);
    }
}

