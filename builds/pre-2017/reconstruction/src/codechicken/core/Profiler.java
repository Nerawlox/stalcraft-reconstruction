/*
 * Decompiled with CFR 0.152.
 */
package codechicken.core;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Profiler {
    public HashMap<String, Long> times = new HashMap();
    public String currentSection;
    private long startTime;
    private long totalTime;

    public void start(String string) {
        if (this.currentSection != null) {
            this.end();
        }
        this.currentSection = string;
        this.startTime = System.nanoTime();
    }

    public void end() {
        long l = System.nanoTime() - this.startTime;
        this.totalTime += l;
        Long l2 = this.times.get(this.currentSection);
        if (l2 == null) {
            l2 = 0L;
        }
        this.times.put(this.currentSection, l2 + l);
        this.currentSection = null;
    }

    public List<ProfilerResult> getResults() {
        ArrayList<ProfilerResult> arrayList = new ArrayList<ProfilerResult>(this.times.size());
        for (Map.Entry<String, Long> entry : this.times.entrySet()) {
            arrayList.add(new ProfilerResult(entry.getKey(), entry.getValue(), this.totalTime));
        }
        return arrayList;
    }

    public void clear() {
        if (this.currentSection != null) {
            this.end();
        }
        this.times.clear();
        this.totalTime = 0L;
    }

    public static class ProfilerResult {
        public final String name;
        public final long time;
        public final double fraction;

        public ProfilerResult(String string, long l, long l2) {
            this.name = string;
            this.time = l;
            this.fraction = (double)l / (double)l2;
        }
    }
}

