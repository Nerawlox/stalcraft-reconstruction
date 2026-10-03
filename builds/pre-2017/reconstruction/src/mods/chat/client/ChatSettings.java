/*
 * Decompiled with CFR 0.152.
 */
package mods.chat.client;

import com.google.common.collect.Sets;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.stream.Stream;
import org.jetbrains.annotations.NotNull;

public class ChatSettings {
    public static final ChatSettings SETTINGS = new ChatSettings();
    private ChatGroup group;
    private Map<String, ChatGroup> groups = new LinkedHashMap<String, ChatGroup>();

    public Map<String, ChatGroup> getGroups() {
        return Collections.unmodifiableMap(this.groups);
    }

    public ChatGroup getGroup() {
        return this.group;
    }

    public ChatSettings setGroup(ChatGroup chatGroup) {
        this.group = chatGroup;
        return this;
    }

    public void switchToNextGroup() {
        ArrayList<ChatGroup> arrayList = new ArrayList<ChatGroup>(this.getGroups().values());
        int n = arrayList.indexOf(this.getGroup());
        n = (n + 1) % arrayList.size();
        this.setGroup(arrayList.get(n));
    }

    public void add(ChatGroup chatGroup) {
        this.put(chatGroup.getTitle(), chatGroup);
    }

    public ChatGroup get(Object object) {
        return this.groups.get(object);
    }

    public ChatGroup put(String string, ChatGroup chatGroup) {
        return this.groups.put(string, chatGroup);
    }

    public ChatGroup remove(Object object) {
        return this.groups.remove(object);
    }

    public void clear() {
        this.groups.clear();
    }

    public void forEach(BiConsumer<? super String, ? super ChatGroup> biConsumer) {
        this.groups.forEach(biConsumer);
    }

    public static class ChatGroup {
        private String title;
        private ugqi sendType;
        private Set<ugqi> types;
        private final Set<ugqi> initialTypes;
        private boolean unreadCount;

        public ChatGroup(String string, ugqi ugqi2, Set<ugqi> set, boolean bl) {
            this.title = string;
            this.sendType = ugqi2;
            this.types = set;
            this.initialTypes = Sets.immutableEnumSet(set);
            this.unreadCount = bl;
        }

        public ugqi getSendType() {
            return this.sendType;
        }

        public String getTitle() {
            return this.title;
        }

        public Set<ugqi> getTypes() {
            return this.types;
        }

        public Set<ugqi> getInitialTypes() {
            return this.initialTypes;
        }

        public boolean isCountingUnread() {
            return this.unreadCount;
        }

        public boolean equals(Object object) {
            if (this == object) {
                return true;
            }
            if (!(object instanceof ChatGroup)) {
                return false;
            }
            ChatGroup chatGroup = (ChatGroup)object;
            return Objects.equals(this.types, chatGroup.types);
        }

        public int hashCode() {
            return Objects.hash(this.types);
        }

        public void clear() {
            this.types.clear();
        }

        public int size() {
            return this.types.size();
        }

        public boolean add(ugqi ugqi2) {
            return this.types.add(ugqi2);
        }

        public boolean addAll(@NotNull Collection<? extends ugqi> collection) {
            if (collection == null) {
                ChatGroup.$$$reportNull$$$0(0);
            }
            return this.types.addAll(collection);
        }

        public boolean remove(Object object) {
            return this.types.remove(object);
        }

        public Stream<ugqi> stream() {
            return this.types.stream();
        }

        public void forEach(Consumer<? super ugqi> consumer) {
            this.types.forEach(consumer);
        }

        private static /* synthetic */ void $$$reportNull$$$0(int n) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "c", "mods/chat/client/ChatSettings$ChatGroup", "addAll"));
        }
    }
}

