/*
 * Decompiled with CFR 0.152.
 */
package mods.pda.client.news;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonParseException;
import cpw.mods.fml.common.FMLLog;
import gloomyfolken.bundle.common.core.eidj;
import gloomyfolken.bundle.common.core.ezey;
import gloomyfolken.mods.core.main.ClientProxy;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Type;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TimeZone;
import mods.pda.PdaMod;
import mods.pda.client.PdaClient;
import mods.pda.client.news.NewsEntry;
import net.minecraft.client.Minecraft;
import org.apache.commons.io.IOUtils;

public class NewsFetcher {
    public static final String SOURCE_URL = "http://files.stalcraft.ru/news";
    public static final String dataFile = "news.0";
    public static final Gson gson = new GsonBuilder().registerTypeAdapter((Type)((Object)LocalDateTime.class), (jsonElement, type, jsonDeserializationContext) -> {
        try {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm dd/MM/yyyy");
            simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
            return simpleDateFormat.parse(jsonElement.getAsString()).toInstant().atZone(ZoneId.of("UTC")).withZoneSameInstant(ZoneId.systemDefault()).toLocalDateTime();
        }
        catch (ParseException parseException) {
            parseException.printStackTrace();
            return null;
        }
    }).create();
    public int lastReadNews = -1;
    public boolean hasUnread = false;
    public String notificationTitle = null;
    public Map<Integer, NewsEntry> fetchedNews = new HashMap<Integer, NewsEntry>();

    public NewsFetcher() {
        this.readLocalData();
    }

    private void readLocalData() {
        try (FileInputStream fileInputStream = new FileInputStream(new File(PdaMod.configurationDir, dataFile));){
            DataInputStream dataInputStream = new DataInputStream(fileInputStream);
            this.lastReadNews = dataInputStream.readInt();
        }
        catch (IOException iOException) {
            iOException.printStackTrace();
        }
    }

    private void writeLocalData() {
        try (FileOutputStream fileOutputStream = new FileOutputStream(new File(PdaMod.configurationDir, dataFile));){
            DataOutputStream dataOutputStream = new DataOutputStream(fileOutputStream);
            dataOutputStream.writeInt(this.lastReadNews);
        }
        catch (IOException iOException) {
            iOException.printStackTrace();
        }
    }

    @ezey(_a={eidj.CLIENT})
    public void fetchNewsList() {
        NewsEntry[] newsEntryArray;
        this.fetchedNews.clear();
        String string = this.readUrl("http://files.stalcraft.ru/news/news.json");
        if (string == null) {
            return;
        }
        try {
            newsEntryArray = gson.fromJson(string, NewsEntry[].class);
        }
        catch (JsonParseException jsonParseException) {
            FMLLog.warning("Error while parsing news", new Object[0]);
            jsonParseException.printStackTrace();
            return;
        }
        this.notificationTitle = null;
        Arrays.sort(newsEntryArray, Comparator.comparing(NewsEntry::getId));
        for (NewsEntry newsEntry : newsEntryArray) {
            this.requestTextFor(newsEntry);
            this.fetchedNews.put(newsEntry.getId(), newsEntry);
            if (newsEntry.getId() <= this.lastReadNews) continue;
            if (newsEntry.canBeForcedNow()) {
                this.notificationTitle = newsEntry.getTitle();
            }
            this.lastReadNews = newsEntry.getId();
            this.hasUnread = true;
        }
        if (Minecraft._E()._r != null) {
            this.publishNotification();
        }
        this.writeLocalData();
    }

    @ezey(_a={eidj.CLIENT})
    public void publishNotification() {
        if (this.notificationTitle != null) {
            ClientProxy.publishNotification(PdaClient.newsChannel.createNotification(new dwly()._a("Title", this.notificationTitle)._a()));
            this.notificationTitle = null;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private String readUrl(String string) {
        try (InputStream inputStream = new URL(string).openStream();){
            List<String> list = IOUtils.readLines(inputStream, "UTF-8");
            String string2 = String.join((CharSequence)"\n", list);
            return string2;
        }
        catch (IOException iOException) {
            iOException.printStackTrace();
            return null;
        }
    }

    private void requestTextFor(NewsEntry newsEntry) {
        if (newsEntry.fetched) {
            return;
        }
        String string = newsEntry.getTextFile();
        newsEntry.text = this.readUrl("http://files.stalcraft.ru/news/" + string);
        newsEntry.fetched = true;
    }
}

