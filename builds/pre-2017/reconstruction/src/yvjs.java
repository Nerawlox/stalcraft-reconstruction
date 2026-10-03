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
import net.minecraft.client.resources.AbstractResourcePack;
import org.apache.commons.io.filefilter.DirectoryFileFilter;

public class yvjs
extends AbstractResourcePack {
    public yvjs(File file) {
        super(file);
    }

    @Override
    public InputStream getInputStreamByName(String string) {
        return new BufferedInputStream(new FileInputStream(new File(this.resourcePackFile, string)));
    }

    @Override
    public boolean hasResourceName(String string) {
        return new File(this.resourcePackFile, string).isFile();
    }

    @Override
    public Set getResourceDomains() {
        HashSet<String> hashSet = Sets.newHashSet();
        File file = new File(this.resourcePackFile, "assets/");
        if (file.isDirectory()) {
            for (File file2 : file.listFiles(DirectoryFileFilter.DIRECTORY)) {
                String string = yvjs.getRelativeName(file, file2);
                if (!string.equals(string.toLowerCase())) {
                    this.logNameNotLowercase(string);
                    continue;
                }
                hashSet.add(string.substring(0, string.length() - 1));
            }
        }
        return hashSet;
    }
}

