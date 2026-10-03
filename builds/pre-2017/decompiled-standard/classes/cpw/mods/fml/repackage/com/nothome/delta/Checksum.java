/*
 * Decompiled with CFR 0.152.
 */
package cpw.mods.fml.repackage.com.nothome.delta;

import com.google.common.collect.Maps;
import cpw.mods.fml.repackage.com.nothome.delta.SeekableSource;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.Map;

public class Checksum {
    static final boolean debug = false;
    private Map<Long, Integer> checksums = Maps.newHashMap();
    private static final char[] single_hash = new char[]{'\ubcd1', '\ubb65', '\u42c2', '\udffe', '\u9666', '\u431b', '\u8504', '\ueb46', '\u6379', '\ud460', '\ucf14', '\u53cf', '\udb51', '\udb08', '\u12c8', '\uf602', '\ue766', '\u2394', '\u250d', '\udcbb', '\ua678', '\u02af', '\ua5c6', '\u7ea6', '\ub645', '\ucb4d', '\uc44b', '\ue5dc', '\u9fe6', '\u5b5c', '\u35f5', '\u701a', '\u220f', '\u6c38', '\u1a56', '\u4ca3', '\uffc6', '\ub152', '\u8d61', '\u7a58', '\u9025', '\u8b3d', '\ubf0f', '\u95a3', '\ue5f4', '\uc127', '\u3bed', '\u320b', '\ub7f3', '\u6054', '\u333c', '\ud383', '\u8154', '\u5242', '\u4e0d', '\u0a94', '\u7028', '\u8689', '\u3a22', '\u0980', '\u1847', '\ub0f1', '\u9b5c', '\u4176', '\ub858', '\ud542', '\u1f6c', '\u2497', '\u6a5a', '\u9fa9', '\u8c5a', '\u7743', '\ua8a9', '\u9a02', '\u4918', '\u438c', '\uc388', '\u9e2b', '\u4cad', '\u01b6', '\uab19', '\uf777', '\u365f', '\u1eb2', '\u091e', '\u7bf8', '\u7a8e', '\u5227', '\ueab1', '\u2074', '\u4523', '\ue781', '\u01a3', '\u163d', '\u3b2e', '\u287d', '\u5e7f', '\ua063', '\ub134', '\u8fae', '\u5e8e', '\ub7b7', '\u4548', '\u1f5a', '\ufa56', '\u7a24', '\u900f', '\u42dc', '\ucc69', '\u02a0', '\u0b22', '\udb31', '\u71fe', '\u0c7d', '\u1732', '\u1159', '\ucb09', '\ue1d2', '\u1351', '\u52e9', '\uf536', '\u5a4f', '\uc316', '\u6bf9', '\u8994', '\ub774', '\u5f3e', '\uf6d6', '\u3a61', '\uf82c', '\ucc22', '\u9d06', '\u299c', '\u09e5', '\u1eec', '\u514f', '\u8d53', '\ua650', '\u5c6e', '\uc577', '\u7958', '\u71ac', '\u8916', '\u9b4f', '\u2c09', '\u5211', '\uf6d8', '\ucaaa', '\uf7ef', '\u287f', '\u7a94', '\uab49', '\ufa2c', '\u7222', '\ue457', '\ud71a', '\u00c3', '\u1a76', '\ue98c', '\uc037', '\u8208', '\u5c2d', '\udfda', '\ue5f5', '\u0b45', '\u15ce', '\u8a7e', '\ufcad', '\uaa2d', '\u4b5c', '\ud42e', '\ub251', '\u907e', '\u9a47', '\uc9a6', '\ud93f', '\u085e', '\u35ce', '\ua153', '\u7e7b', '\u9f0b', '\u25aa', '\u5d9f', '\uc04d', '\u8a0e', '\u2875', '\u4a1c', '\u295f', '\u1393', '\uf760', '\u9178', '\u0f5b', '\ufa7d', '\u83b4', '\u2082', '\u721d', '\u6462', '\u0368', '\u67e2', '\u8624', '\u194d', '\u22f6', '\u78fb', '\u6791', '\ub238', '\ub332', '\u7276', '\uf272', '\u47ec', '\u4504', '\ua961', '\u9fc8', '\u3fdc', '\ub413', 'z', '\u0806', '\u7458', '\u95c6', '\uccaa', '\u18d6', '\ue2ae', '\u1b06', '\uf3f6', '\u5050', '\uc8e8', '\uf4ac', '\uc04c', '\uf41c', '\u992f', '\uae44', '\u5f1b', '\u1113', '\u1738', '\ud9a8', '\u19ea', '\u2d33', '\u9698', '\u2fe9', '\u323f', '\ucde2', '\u6d71', '\ue37d', '\ub697', '\u2c4f', '\u4373', '\u9102', '\u075d', '\u8e25', '\u1672', '\uec28', '\u6acb', '\u86cc', '\u186e', '\u9414', '\ud674', '\ud1a5'};

    public Checksum(SeekableSource seekableSource, int n) throws IOException {
        ByteBuffer byteBuffer = ByteBuffer.allocate(n * 2);
        int n2 = 0;
        while (true) {
            seekableSource.read(byteBuffer);
            byteBuffer.flip();
            if (byteBuffer.remaining() < n) break;
            while (byteBuffer.remaining() >= n) {
                long l = Checksum.queryChecksum0(byteBuffer, n);
                this.checksums.put(l, n2++);
            }
            byteBuffer.compact();
        }
    }

    public static long queryChecksum(ByteBuffer byteBuffer, int n) {
        byteBuffer.mark();
        long l = Checksum.queryChecksum0(byteBuffer, n);
        byteBuffer.reset();
        return l;
    }

    private static long queryChecksum0(ByteBuffer byteBuffer, int n) {
        int n2 = 0;
        int n3 = 0;
        for (int i = 0; i < n; ++i) {
            n2 += (n3 += single_hash[byteBuffer.get() + 128]);
        }
        return (n2 & 0xFFFF) << 16 | n3 & 0xFFFF;
    }

    public static long incrementChecksum(long l, byte by, byte by2, int n) {
        char c = single_hash[by + 128];
        char c2 = single_hash[by2 + 128];
        int n2 = (int)(l & 0xFFFFL) - c + c2 & 0xFFFF;
        int n3 = (int)(l >> 16) - c * n + n2 & 0xFFFF;
        return n3 << 16 | n2 & 0xFFFF;
    }

    public static char[] getSingleHash() {
        return single_hash;
    }

    public int findChecksumIndex(long l) {
        if (!this.checksums.containsKey(l)) {
            return -1;
        }
        return this.checksums.get(l);
    }

    public String toString() {
        return super.toString() + " checksums=" + this.checksums;
    }
}

