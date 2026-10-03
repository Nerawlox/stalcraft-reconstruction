/*
 * Decompiled with CFR 0.152.
 */
package mods.pda.client;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import mods.pda.client.waypoint.QuestWaypoint;
import noppes.npcs.QuestLogUnit;

public class ClientWaypointsData {
    public Set<Integer> primaryQuests = new HashSet<Integer>();
    public Multimap<Integer, QuestWaypoint> questWaypoints = HashMultimap.create();
    public Map<Integer, QuestLogUnit> questState = new HashMap<Integer, QuestLogUnit>();
}

