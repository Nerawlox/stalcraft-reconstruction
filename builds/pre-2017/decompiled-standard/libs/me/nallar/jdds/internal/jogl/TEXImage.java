/*
 * Decompiled with CFR 0.152.
 */
package me.nallar.jdds.internal.jogl;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.util.Vector;
import me.nallar.jdds.internal.jogl.DDSImage;

public class TEXImage {
    private Header header;
    private final Vector<DDSImage> embeddedMap = new Vector();
    private static final int MAGIC = 1413830656;

    public static TEXImage read(File file) throws IOException {
        TEXImage image = new TEXImage();
        image.readFromFile(file);
        return image;
    }

    public int getWidth() {
        return this.header.width;
    }

    public int getHeight() {
        return this.header.height;
    }

    private TEXImage() {
    }

    private void readFromFile(File file) throws IOException {
        FileInputStream fis = new FileInputStream(file);
        FileChannel chan = fis.getChannel();
        MappedByteBuffer buf = chan.map(FileChannel.MapMode.READ_ONLY, 0L, (int)file.length());
        this.readFromBuffer(buf);
    }

    private void readFromBuffer(ByteBuffer buf) throws IOException {
        ByteBuffer buf1 = buf;
        buf.order(ByteOrder.LITTLE_ENDIAN);
        this.header = new Header();
        this.header.read(buf);
        for (Header.EmbeddedBuffer embBuffer : this.header.embeddedMap) {
            embBuffer.buffer.rewind();
            this.embeddedMap.add(DDSImage.read(embBuffer.buffer));
        }
    }

    public DDSImage getEmbeddedMaps(int index) {
        return this.embeddedMap.get(index);
    }

    static class Header {
        int height;
        int width;
        int mipMapCountOrAux;
        int alphaBitDepth;
        Vector<EmbeddedBuffer> embeddedMap;

        Header() {
        }

        void read(ByteBuffer buf) throws IOException {
            int magic = buf.getInt();
            if (magic != 1413830656) {
                throw new IOException("Incorrect magic number 0x" + Integer.toHexString(magic) + " (expected " + 1413830656 + ")");
            }
            this.width = buf.getInt();
            this.height = buf.getInt();
            this.alphaBitDepth = buf.getInt();
            this.mipMapCountOrAux = buf.getInt();
            this.embeddedMap = this.readHeaderTable(buf);
        }

        private Vector<EmbeddedBuffer> readHeaderTable(ByteBuffer buf) {
            Vector<EmbeddedBuffer> embeddedBuffer = new Vector<EmbeddedBuffer>();
            for (int t = 0; t < 5; ++t) {
                for (int i = 0; i < 8; ++i) {
                    int offset = buf.getInt();
                    int size = buf.getInt();
                    EmbeddedBuffer embBuffer = new EmbeddedBuffer();
                    if (offset == -1 || size == -1) continue;
                    int currentPos = buf.position();
                    byte[] ddsbuffer = new byte[size];
                    buf.position(offset);
                    buf.get(ddsbuffer);
                    embBuffer.buffer = ByteBuffer.wrap(ddsbuffer);
                    embeddedBuffer.add(embBuffer);
                    buf.position(currentPos);
                }
            }
            for (EmbeddedBuffer embeddedBuffer2 : embeddedBuffer) {
                embeddedBuffer2.buffer.rewind();
                embeddedBuffer2.buffer.order(ByteOrder.LITTLE_ENDIAN);
            }
            return embeddedBuffer;
        }

        void write(ByteBuffer buf) {
            buf.putInt(1413830656);
            buf.putInt(this.width);
            buf.putInt(this.height);
            buf.putInt(this.alphaBitDepth);
            buf.putInt(this.mipMapCountOrAux);
        }

        private static int writtenSize() {
            return 340;
        }

        class EmbeddedBuffer {
            ByteBuffer buffer;

            EmbeddedBuffer() {
            }
        }
    }
}

