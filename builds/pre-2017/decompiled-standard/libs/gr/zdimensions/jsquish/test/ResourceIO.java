/*
 * Decompiled with CFR 0.152.
 */
package gr.zdimensions.jsquish.test;

import java.awt.image.BufferedImage;
import java.awt.image.DataBufferByte;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.ByteBuffer;
import javax.imageio.ImageIO;
import org.lwjgl.BufferUtils;

final class ResourceIO {
    private ResourceIO() {
    }

    static URL resourceGetURL(String resource) {
        File file;
        URL url = Thread.currentThread().getContextClassLoader().getResource(resource);
        if (url == null && (file = new File(resource)).exists()) {
            try {
                url = file.toURI().toURL();
            }
            catch (MalformedURLException malformedURLException) {
                // empty catch block
            }
        }
        if (url == null) {
            throw new RuntimeException("Invalid resource specified: " + resource);
        }
        return url;
    }

    public static BufferedImage resourceReadImage(String resource) throws IOException {
        return ImageIO.read(ResourceIO.resourceGetURL(resource));
    }

    static ByteBuffer resourceReadImageBuffer(String resource) throws IOException {
        BufferedImage image = ImageIO.read(ResourceIO.resourceGetURL(resource));
        byte[] data2 = ((DataBufferByte)image.getRaster().getDataBuffer()).getData();
        ByteBuffer buffer = BufferUtils.createByteBuffer(data2.length);
        buffer.put(data2);
        buffer.flip();
        return buffer;
    }
}

