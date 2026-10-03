/*
 * Decompiled with CFR 0.152.
 */
package net.sf.kdgcommons.io;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;
import java.nio.charset.CoderResult;
import java.nio.charset.CodingErrorAction;

public class TranslatingInputStream
extends InputStream {
    private InputStreamReader _delegate;
    private CharsetEncoder _encoder;
    private CharBuffer _charBuf;
    private ByteBuffer _byteBuf;

    public TranslatingInputStream(InputStream inputStream, Charset charset, Charset charset2) {
        this._delegate = new InputStreamReader(inputStream, charset);
        this._encoder = charset2.newEncoder();
        this._charBuf = CharBuffer.allocate(2);
        this._byteBuf = ByteBuffer.allocate(4);
        this._byteBuf.limit(0);
    }

    public TranslatingInputStream(InputStream inputStream, Charset charset, Charset charset2, char c) {
        this(inputStream, charset, charset2);
        this._encoder.replaceWith(TranslatingInputStream.encodeReplacement(charset2, c));
        this._encoder.onUnmappableCharacter(CodingErrorAction.REPLACE);
    }

    public int read() throws IOException {
        if (this._byteBuf.remaining() == 0) {
            this.fillBuffer();
        }
        if (this._byteBuf.remaining() == 0) {
            return -1;
        }
        return this._byteBuf.get() & 0xFF;
    }

    private static byte[] encodeReplacement(Charset charset, char c) {
        try {
            CharsetEncoder charsetEncoder = charset.newEncoder();
            CharBuffer charBuffer = CharBuffer.wrap(new char[]{c});
            ByteBuffer byteBuffer = charsetEncoder.encode(charBuffer);
            byteBuffer.position(0);
            byte[] byArray = new byte[byteBuffer.remaining()];
            byteBuffer.get(byArray);
            return byArray;
        }
        catch (CharacterCodingException characterCodingException) {
            throw new IllegalArgumentException("illegal replacement character: " + c);
        }
    }

    private void fillBuffer() throws IOException {
        this._byteBuf.clear();
        this._charBuf.clear();
        while (this._byteBuf.position() == 0) {
            this.fillCharBuf();
            if (this._charBuf.limit() == 0) {
                this._byteBuf.limit(0);
                return;
            }
            this._encoder.reset();
            CoderResult coderResult = this._encoder.encode(this._charBuf, this._byteBuf, true);
            this._encoder.flush(this._byteBuf);
        }
        this._byteBuf.limit(this._byteBuf.position());
        this._byteBuf.position(0);
    }

    private void fillCharBuf() throws IOException {
        int n = 0;
        int n2 = 0;
        do {
            if ((n2 = this._delegate.read()) < 0) continue;
            this._charBuf.put((char)n2);
            ++n;
        } while (n2 >= 55296 && n2 <= 56319);
        this._charBuf.position(0);
        this._charBuf.limit(n);
    }
}

