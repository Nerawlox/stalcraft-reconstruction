/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.client.resources;

import com.google.common.base.Splitter;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.Set;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import net.minecraft.client.resources.AbstractResourcePack;

public class FileResourcePack
extends AbstractResourcePack
implements Closeable {
    public static final Splitter entryNameSplitter = Splitter.on('/').omitEmptyStrings().limit(3);
    public ZipFile resourcePackZipFile;

    public FileResourcePack(File file) {
        super(file);
    }

    public ZipFile getResourcePackZipFile() {
        if (this.resourcePackZipFile == null) {
            this.resourcePackZipFile = new ZipFile(this.resourcePackFile);
        }
        return this.resourcePackZipFile;
    }

    @Override
    public InputStream getInputStreamByName(String string) {
        ZipFile zipFile = this.getResourcePackZipFile();
        ZipEntry zipEntry = zipFile.getEntry(string);
        if (zipEntry == null) {
            throw new mbep(this.resourcePackFile, string);
        }
        return zipFile.getInputStream(zipEntry);
    }

    @Override
    public boolean hasResourceName(String string) {
        try {
            return this.getResourcePackZipFile().getEntry(string) != null;
        }
        catch (IOException iOException) {
            return false;
        }
    }

    @Override
    public Set getResourceDomains() {
        ZipFile zipFile;
        try {
            zipFile = this.getResourcePackZipFile();
        }
        catch (IOException iOException) {
            return Collections.emptySet();
        }
        Enumeration<? extends ZipEntry> enumeration = zipFile.entries();
        HashSet<String> hashSet = Sets.newHashSet();
        while (enumeration.hasMoreElements()) {
            ArrayList<String> arrayList;
            ZipEntry zipEntry = enumeration.nextElement();
            String string = zipEntry.getName();
            if (!string.startsWith("assets/") || (arrayList = Lists.newArrayList(entryNameSplitter.split(string))).size() <= 1) continue;
            String string2 = (String)arrayList.get(1);
            if (!string2.equals(string2.toLowerCase())) {
                this.logNameNotLowercase(string2);
                continue;
            }
            hashSet.add(string2);
        }
        return hashSet;
    }

    public void finalize() {
        this.close();
        super.finalize();
    }

    @Override
    public void close() {
        if (this.resourcePackZipFile != null) {
            this.resourcePackZipFile.close();
            this.resourcePackZipFile = null;
        }
    }
}

