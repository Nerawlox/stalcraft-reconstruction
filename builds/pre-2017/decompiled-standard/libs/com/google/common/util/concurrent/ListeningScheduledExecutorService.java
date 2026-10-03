/*
 * Decompiled with CFR 0.152.
 */
package com.google.common.util.concurrent;

import com.google.common.annotations.Beta;
import com.google.common.util.concurrent.ListeningExecutorService;
import java.util.concurrent.ScheduledExecutorService;

@Beta
public interface ListeningScheduledExecutorService
extends ScheduledExecutorService,
ListeningExecutorService {
}

