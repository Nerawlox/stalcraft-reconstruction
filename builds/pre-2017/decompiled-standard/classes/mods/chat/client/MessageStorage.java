/*
 * Decompiled with CFR 0.152.
 */
package mods.chat.client;

import com.google.common.collect.LinkedHashMultimap;
import com.google.common.collect.Multimap;
import com.google.common.collect.Sets;
import gloomyfolken.bundle.common.core.eidj;
import gloomyfolken.bundle.common.core.ezey;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@ezey(_a={eidj.CLIENT})
public class MessageStorage {
    public static final MessageStorage RECEIVED = new MessageStorage();
    public static final MessageStorage SENT = new MessageStorage();
    private final Multimap<ugqi, jxsn> messages = LinkedHashMultimap.create();

    public void add(jxsn jxsn2) {
        this.messages.put(jxsn2._a, jxsn2);
    }

    public List<jxsn> all() {
        return new ArrayList<jxsn>(this.messages.values());
    }

    public List<jxsn> get(Set<ugqi> set) {
        return set.stream().map(this.messages::get).flatMap(Collection::stream).collect(Collectors.toList());
    }

    public List<jxsn> get(ugqi ... ugqiArray) {
        return this.get(Sets.newHashSet(ugqiArray));
    }
}

