// 
// Decompiled by Procyon v0.6.0
// 

package paulscode.sound.codecs;

import java.util.Arrays;
import java.io.OutputStream;
import paulscode.sound.SoundBuffer;
import java.net.UnknownServiceException;
import java.io.IOException;
import paulscode.sound.SoundSystemConfig;
import paulscode.sound.SoundSystemLogger;
import com.jcraft.jorbis.Info;
import com.jcraft.jorbis.Comment;
import com.jcraft.jorbis.Block;
import com.jcraft.jorbis.DspState;
import com.jcraft.jogg.SyncState;
import com.jcraft.jogg.StreamState;
import com.jcraft.jogg.Page;
import com.jcraft.jogg.Packet;
import javax.sound.sampled.AudioFormat;
import java.io.InputStream;
import java.net.URLConnection;
import java.net.URL;
import paulscode.sound.ICodec;

public class CodecJOrbis implements ICodec
{
    private static final boolean GET = false;
    private static final boolean SET = true;
    private static final boolean XXX = false;
    private URL url;
    private URLConnection urlConnection;
    private InputStream inputStream;
    private AudioFormat audioFormat;
    private boolean endOfStream;
    private boolean initialized;
    private byte[] buffer;
    private int bufferSize;
    private int count;
    private int index;
    private int convertedBufferSize;
    private byte[] convertedBuffer;
    private float[][][] pcmInfo;
    private int[] pcmIndex;
    private Packet joggPacket;
    private Page joggPage;
    private StreamState joggStreamState;
    private SyncState joggSyncState;
    private DspState jorbisDspState;
    private Block jorbisBlock;
    private Comment jorbisComment;
    private Info jorbisInfo;
    private SoundSystemLogger logger;
    private ByteArrayOStream bos;
    
    public CodecJOrbis() {
        this.urlConnection = null;
        this.endOfStream = false;
        this.initialized = false;
        this.buffer = null;
        this.count = 0;
        this.index = 0;
        this.convertedBuffer = null;
        this.joggPacket = new Packet();
        this.joggPage = new Page();
        this.joggStreamState = new StreamState();
        this.joggSyncState = new SyncState();
        this.jorbisDspState = new DspState();
        this.jorbisBlock = new Block(this.jorbisDspState);
        this.jorbisComment = new Comment();
        this.jorbisInfo = new Info();
        this.bos = new ByteArrayOStream(32);
        this.logger = SoundSystemConfig.getLogger();
    }
    
    public void reverseByteOrder(final boolean b) {
    }
    
    public boolean initialize(final URL url) {
        this.initialized(true, false);
        if (this.joggStreamState != null) {
            this.joggStreamState.clear();
        }
        if (this.jorbisBlock != null) {
            this.jorbisBlock.clear();
        }
        if (this.jorbisDspState != null) {
            this.jorbisDspState.clear();
        }
        if (this.jorbisInfo != null) {
            this.jorbisInfo.clear();
        }
        if (this.joggSyncState != null) {
            this.joggSyncState.clear();
        }
        if (this.inputStream != null) {
            try {
                this.inputStream.close();
            }
            catch (final IOException ex) {}
        }
        this.url = url;
        this.bufferSize = 8192;
        this.buffer = null;
        this.count = 0;
        this.index = 0;
        this.joggStreamState = new StreamState();
        this.jorbisBlock = new Block(this.jorbisDspState);
        this.jorbisDspState = new DspState();
        this.jorbisInfo = new Info();
        this.joggSyncState = new SyncState();
        try {
            this.urlConnection = url.openConnection();
        }
        catch (final UnknownServiceException use) {
            this.errorMessage("Unable to create a UrlConnection in method 'initialize'.");
            this.printStackTrace(use);
            this.cleanup();
            return false;
        }
        catch (final IOException ioe) {
            this.errorMessage("Unable to create a UrlConnection in method 'initialize'.");
            this.printStackTrace(ioe);
            this.cleanup();
            return false;
        }
        if (this.urlConnection != null) {
            try {
                this.inputStream = this.urlConnection.getInputStream();
            }
            catch (final IOException ioe) {
                this.errorMessage("Unable to acquire inputstream in method 'initialize'.");
                this.printStackTrace(ioe);
                this.cleanup();
                return false;
            }
        }
        this.endOfStream(true, false);
        this.joggSyncState.init();
        this.joggSyncState.buffer(this.bufferSize);
        this.buffer = this.joggSyncState.data;
        try {
            if (!this.readHeader()) {
                this.errorMessage("Error reading the header");
                return false;
            }
        }
        catch (final IOException ioe) {
            this.errorMessage("Error reading the header");
            return false;
        }
        this.convertedBufferSize = this.bufferSize * 2;
        this.jorbisDspState.synthesis_init(this.jorbisInfo);
        this.jorbisBlock.init(this.jorbisDspState);
        final int channels = this.jorbisInfo.channels;
        final int rate = this.jorbisInfo.rate;
        this.audioFormat = new AudioFormat((float)rate, 16, channels, true, false);
        this.pcmInfo = new float[1][][];
        this.pcmIndex = new int[this.jorbisInfo.channels];
        this.initialized(true, true);
        return true;
    }
    
    public boolean initialized() {
        return this.initialized(false, false);
    }
    
    public SoundBuffer read() {
        this.bos.reset();
        boolean success;
        for (success = false; !this.endOfStream(false, false) && (!success || this.bos.size() < SoundSystemConfig.getStreamingBufferSize()); success |= this.readBytes(this.bos)) {}
        if (!success) {
            return null;
        }
        return new SoundBuffer(this.bos.toByteArray(), this.audioFormat);
    }
    
    public SoundBuffer readAll() {
        this.bos.reset();
        boolean success = false;
        while (!this.endOfStream(false, false)) {
            success |= this.readBytes(this.bos);
        }
        if (!success) {
            return null;
        }
        return new SoundBuffer(this.bos.toByteArray(), this.audioFormat);
    }
    
    public boolean endOfStream() {
        return this.endOfStream(false, false);
    }
    
    public void cleanup() {
        this.joggStreamState.clear();
        this.jorbisBlock.clear();
        this.jorbisDspState.clear();
        this.jorbisInfo.clear();
        this.joggSyncState.clear();
        if (this.inputStream != null) {
            try {
                this.inputStream.close();
            }
            catch (final IOException ex) {}
        }
        this.joggStreamState = null;
        this.jorbisBlock = null;
        this.jorbisDspState = null;
        this.jorbisInfo = null;
        this.joggSyncState = null;
        this.inputStream = null;
    }
    
    public AudioFormat getAudioFormat() {
        return this.audioFormat;
    }
    
    private boolean readHeader() throws IOException {
        this.index = this.joggSyncState.buffer(this.bufferSize);
        int bytes = this.inputStream.read(this.joggSyncState.data, this.index, this.bufferSize);
        if (bytes < 0) {
            bytes = 0;
        }
        this.joggSyncState.wrote(bytes);
        if (this.joggSyncState.pageout(this.joggPage) != 1) {
            if (bytes < this.bufferSize) {
                return true;
            }
            this.errorMessage("Ogg header not recognized in method 'readHeader'.");
            return false;
        }
        else {
            this.joggStreamState.init(this.joggPage.serialno());
            this.jorbisInfo.init();
            this.jorbisComment.init();
            if (this.joggStreamState.pagein(this.joggPage) < 0) {
                this.errorMessage("Problem with first Ogg header page in method 'readHeader'.");
                return false;
            }
            if (this.joggStreamState.packetout(this.joggPacket) != 1) {
                this.errorMessage("Problem with first Ogg header packet in method 'readHeader'.");
                return false;
            }
            if (this.jorbisInfo.synthesis_headerin(this.jorbisComment, this.joggPacket) < 0) {
                this.errorMessage("File does not contain Vorbis header in method 'readHeader'.");
                return false;
            }
            int i = 0;
            while (i < 2) {
                while (i < 2) {
                    int result = this.joggSyncState.pageout(this.joggPage);
                    if (result == 0) {
                        break;
                    }
                    if (result != 1) {
                        continue;
                    }
                    this.joggStreamState.pagein(this.joggPage);
                    while (i < 2) {
                        result = this.joggStreamState.packetout(this.joggPacket);
                        if (result == 0) {
                            break;
                        }
                        if (result == -1) {
                            this.errorMessage("Secondary Ogg header corrupt in method 'readHeader'.");
                            return false;
                        }
                        this.jorbisInfo.synthesis_headerin(this.jorbisComment, this.joggPacket);
                        ++i;
                    }
                }
                this.index = this.joggSyncState.buffer(this.bufferSize);
                bytes = this.inputStream.read(this.joggSyncState.data, this.index, this.bufferSize);
                if (bytes < 0) {
                    bytes = 0;
                }
                if (bytes == 0 && i < 2) {
                    this.errorMessage("End of file reached before finished readingOgg header in method 'readHeader'");
                    return false;
                }
                this.joggSyncState.wrote(bytes);
            }
            this.index = this.joggSyncState.buffer(this.bufferSize);
            this.buffer = this.joggSyncState.data;
            return true;
        }
    }
    
    private boolean readBytes(final ByteArrayOStream bos) {
        if (!this.initialized(false, false)) {
            return false;
        }
        if (this.endOfStream(false, false)) {
            return false;
        }
        if (this.convertedBuffer == null) {
            this.convertedBuffer = new byte[this.convertedBufferSize];
        }
        switch (this.joggSyncState.pageout(this.joggPage)) {
            case -1:
            case 0: {
                break;
            }
            default: {
                this.joggStreamState.pagein(this.joggPage);
                if (this.joggPage.granulepos() == 0L) {
                    this.endOfStream(true, true);
                    return false;
                }
            Label_0148:
                while (true) {
                    switch (this.joggStreamState.packetout(this.joggPacket)) {
                        case 0: {
                            break Label_0148;
                        }
                        case -1: {
                            continue;
                        }
                        default: {
                            if (this.jorbisBlock.synthesis(this.joggPacket) == 0) {
                                this.jorbisDspState.synthesis_blockin(this.jorbisBlock);
                            }
                            int samples;
                            while ((samples = this.jorbisDspState.synthesis_pcmout(this.pcmInfo, this.pcmIndex)) > 0) {
                                final float[][] pcmf = this.pcmInfo[0];
                                final int bout = (samples < this.convertedBufferSize) ? samples : this.convertedBufferSize;
                                for (int i = 0; i < this.jorbisInfo.channels; ++i) {
                                    int ptr = i * 2;
                                    final int mono = this.pcmIndex[i];
                                    for (int j = 0; j < bout; ++j) {
                                        int val = (int)(pcmf[i][mono + j] * 32767.0);
                                        if (val > 32767) {
                                            val = 32767;
                                        }
                                        if (val < -32768) {
                                            val = -32768;
                                        }
                                        if (val < 0) {
                                            val |= 0x8000;
                                        }
                                        this.convertedBuffer[ptr] = (byte)val;
                                        this.convertedBuffer[ptr + 1] = (byte)(val >>> 8);
                                        ptr += 2 * this.jorbisInfo.channels;
                                    }
                                }
                                this.jorbisDspState.synthesis_read(bout);
                                bos.write(this.convertedBuffer, 0, Math.min(this.convertedBuffer.length, 2 * this.jorbisInfo.channels * bout));
                            }
                            continue;
                        }
                    }
                }
                if (this.joggPage.eos() != 0) {
                    this.endOfStream(true, true);
                    break;
                }
                break;
            }
        }
        if (!this.endOfStream(false, false)) {
            this.index = this.joggSyncState.buffer(this.bufferSize);
            this.buffer = this.joggSyncState.data;
            try {
                this.count = this.inputStream.read(this.buffer, this.index, this.bufferSize);
            }
            catch (final Exception e) {
                this.printStackTrace(e);
                return false;
            }
            if (this.count == -1) {
                return true;
            }
            this.joggSyncState.wrote(this.count);
            if (this.count == 0) {
                this.endOfStream(true, true);
            }
        }
        return true;
    }
    
    private synchronized boolean initialized(final boolean action, final boolean value) {
        if (action) {
            this.initialized = value;
        }
        return this.initialized;
    }
    
    private synchronized boolean endOfStream(final boolean action, final boolean value) {
        if (action) {
            this.endOfStream = value;
        }
        return this.endOfStream;
    }
    
    private static byte[] trimArray(final byte[] array, final int maxLength) {
        byte[] trimmedArray = null;
        if (array != null && array.length > maxLength) {
            trimmedArray = new byte[maxLength];
            System.arraycopy(array, 0, trimmedArray, 0, maxLength);
        }
        return trimmedArray;
    }
    
    private static byte[] appendByteArrays(byte[] arrayOne, byte[] arrayTwo, final int arrayTwoBytes) {
        int bytes = arrayTwoBytes;
        if (arrayTwo == null || arrayTwo.length == 0) {
            bytes = 0;
        }
        else if (arrayTwo.length < arrayTwoBytes) {
            bytes = arrayTwo.length;
        }
        if (arrayOne == null && (arrayTwo == null || bytes <= 0)) {
            return null;
        }
        byte[] newArray;
        if (arrayOne == null) {
            newArray = new byte[bytes];
            System.arraycopy(arrayTwo, 0, newArray, 0, bytes);
            arrayTwo = null;
        }
        else if (arrayTwo == null || bytes <= 0) {
            newArray = new byte[arrayOne.length];
            System.arraycopy(arrayOne, 0, newArray, 0, arrayOne.length);
            arrayOne = null;
        }
        else {
            newArray = new byte[arrayOne.length + bytes];
            System.arraycopy(arrayOne, 0, newArray, 0, arrayOne.length);
            System.arraycopy(arrayTwo, 0, newArray, arrayOne.length, bytes);
            arrayOne = null;
            arrayTwo = null;
        }
        return newArray;
    }
    
    private static byte[] appendByteArrays(byte[] arrayOne, byte[] arrayTwo) {
        if (arrayOne == null && arrayTwo == null) {
            return null;
        }
        byte[] newArray;
        if (arrayOne == null) {
            newArray = new byte[arrayTwo.length];
            System.arraycopy(arrayTwo, 0, newArray, 0, arrayTwo.length);
            arrayTwo = null;
        }
        else if (arrayTwo == null) {
            newArray = new byte[arrayOne.length];
            System.arraycopy(arrayOne, 0, newArray, 0, arrayOne.length);
            arrayOne = null;
        }
        else {
            newArray = new byte[arrayOne.length + arrayTwo.length];
            System.arraycopy(arrayOne, 0, newArray, 0, arrayOne.length);
            System.arraycopy(arrayTwo, 0, newArray, arrayOne.length, arrayTwo.length);
            arrayOne = null;
            arrayTwo = null;
        }
        return newArray;
    }
    
    private void errorMessage(final String message) {
        this.logger.errorMessage("CodecJOrbis", message, 0);
    }
    
    private void printStackTrace(final Exception e) {
        this.logger.printStackTrace(e, 1);
    }
    
    public static final class ByteArrayOStream extends OutputStream
    {
        private byte[] m_buf;
        private int m_pos;
        private static final int NATIVE_COPY_THRESHOLD = 9;
        
        public ByteArrayOStream(final int initialCapacity) {
            this.m_buf = new byte[initialCapacity];
        }
        
        public final void write2(final int b1, final int b2) {
            final int pos = this.m_pos;
            final int capacity = pos + 2;
            byte[] mbuf = this.m_buf;
            final int mbuflen = mbuf.length;
            if (mbuflen < capacity) {
                final byte[] newbuf = new byte[Math.max(mbuflen << 1, capacity)];
                if (pos < 9) {
                    for (int i = 0; i < pos; ++i) {
                        newbuf[i] = mbuf[i];
                    }
                }
                else {
                    System.arraycopy(mbuf, 0, newbuf, 0, pos);
                }
                mbuf = (this.m_buf = newbuf);
            }
            mbuf[pos] = (byte)b1;
            mbuf[pos + 1] = (byte)b2;
            this.m_pos = capacity;
        }
        
        public final void write3(final int b1, final int b2, final int b3) {
            final int pos = this.m_pos;
            final int capacity = pos + 3;
            byte[] mbuf = this.m_buf;
            final int mbuflen = mbuf.length;
            if (mbuflen < capacity) {
                final byte[] newbuf = new byte[Math.max(mbuflen << 1, capacity)];
                if (pos < 9) {
                    for (int i = 0; i < pos; ++i) {
                        newbuf[i] = mbuf[i];
                    }
                }
                else {
                    System.arraycopy(mbuf, 0, newbuf, 0, pos);
                }
                mbuf = (this.m_buf = newbuf);
            }
            mbuf[pos] = (byte)b1;
            mbuf[pos + 1] = (byte)b2;
            mbuf[pos + 2] = (byte)b3;
            this.m_pos = capacity;
        }
        
        public final void write4(final int b1, final int b2, final int b3, final int b4) {
            final int pos = this.m_pos;
            final int capacity = pos + 4;
            byte[] mbuf = this.m_buf;
            final int mbuflen = mbuf.length;
            if (mbuflen < capacity) {
                final byte[] newbuf = new byte[Math.max(mbuflen << 1, capacity)];
                if (pos < 9) {
                    for (int i = 0; i < pos; ++i) {
                        newbuf[i] = mbuf[i];
                    }
                }
                else {
                    System.arraycopy(mbuf, 0, newbuf, 0, pos);
                }
                mbuf = (this.m_buf = newbuf);
            }
            mbuf[pos] = (byte)b1;
            mbuf[pos + 1] = (byte)b2;
            mbuf[pos + 2] = (byte)b3;
            mbuf[pos + 3] = (byte)b4;
            this.m_pos = capacity;
        }
        
        public final void writeTo(final OutputStream out) throws IOException {
            out.write(this.m_buf, 0, this.m_pos);
        }
        
        public final byte[] getByteArray() {
            return this.m_buf;
        }
        
        public final byte[] copyByteArray() {
            final int pos = this.m_pos;
            final byte[] result = new byte[pos];
            final byte[] mbuf = this.m_buf;
            if (pos < 9) {
                for (int i = 0; i < pos; ++i) {
                    result[i] = mbuf[i];
                }
            }
            else {
                System.arraycopy(mbuf, 0, result, 0, pos);
            }
            return result;
        }
        
        public final int size() {
            return this.m_pos;
        }
        
        public final int capacity() {
            return this.m_buf.length;
        }
        
        public final void reset() {
            this.m_pos = 0;
        }
        
        @Override
        public final void write(final int b) {
            final int pos = this.m_pos;
            final int capacity = pos + 1;
            byte[] mbuf = this.m_buf;
            final int mbuflen = mbuf.length;
            if (mbuflen < capacity) {
                final byte[] newbuf = new byte[Math.max(mbuflen << 1, capacity)];
                if (pos < 9) {
                    for (int i = 0; i < pos; ++i) {
                        newbuf[i] = mbuf[i];
                    }
                }
                else {
                    System.arraycopy(mbuf, 0, newbuf, 0, pos);
                }
                mbuf = (this.m_buf = newbuf);
            }
            mbuf[pos] = (byte)b;
            this.m_pos = capacity;
        }
        
        @Override
        public final void write(final byte[] buf, final int offset, final int length) {
            final int pos = this.m_pos;
            final int capacity = pos + length;
            byte[] mbuf = this.m_buf;
            final int mbuflen = mbuf.length;
            if (mbuflen < capacity) {
                final byte[] newbuf = new byte[Math.max(mbuflen << 1, capacity)];
                if (pos < 9) {
                    for (int i = 0; i < pos; ++i) {
                        newbuf[i] = mbuf[i];
                    }
                }
                else {
                    System.arraycopy(mbuf, 0, newbuf, 0, pos);
                }
                mbuf = (this.m_buf = newbuf);
            }
            if (length < 9) {
                for (int j = 0; j < length; ++j) {
                    mbuf[pos + j] = buf[offset + j];
                }
            }
            else {
                System.arraycopy(buf, offset, mbuf, pos, length);
            }
            this.m_pos = capacity;
        }
        
        @Override
        public final void close() {
            this.reset();
        }
        
        public byte[] toByteArray() {
            return Arrays.copyOf(this.m_buf, this.m_pos);
        }
    }
}
