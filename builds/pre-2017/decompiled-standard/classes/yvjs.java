/*
 * Decompiled with CFR 0.152.
 */
import com.google.common.collect.Sets;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.HashSet;
import java.util.Set;
import org.apache.commons.io.filefilter.DirectoryFileFilter;

public class yvjs
extends nvkn {
    public yvjs(File file) {
        super(file);
    }

    @Override
    public InputStream func_110591_a(String string) {
        return new BufferedInputStream(new FileInputStream(new File(this.field_110597_b, string)));
    }

    @Override
    public boolean func_110593_b(String string) {
        return new File(this.field_110597_b, string).isFile();
    }

    @Override
    public Set func_110587_b() {
        HashSet<String> hashSet = Sets.newHashSet();
        File file = new File(this.field_110597_b, "assets/");
        if (file.isDirectory()) {
            for (File file2 : file.listFiles(DirectoryFileFilter.DIRECTORY)) {
                String string = yvjs.func_110595_a(file, file2);
                if (!string.equals(string.toLowerCase())) {
                    this.func_110594_c(string);
                    continue;
                }
                hashSet.add(string.substring(0, string.length() - 1));
            }
        }
        return hashSet;
    }
}

