/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 *  javax.annotation.concurrent.Immutable
 */
package com.google.common.net;

import com.google.common.annotations.Beta;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.base.Strings;
import java.io.Serializable;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.annotation.Nullable;
import javax.annotation.concurrent.Immutable;

@Beta
@Immutable
public final class HostAndPort
implements Serializable {
    private static final int NO_PORT = -1;
    private final String host;
    private final int port;
    private final boolean hasBracketlessColons;
    private static final Pattern BRACKET_PATTERN = Pattern.compile("^\\[(.*:.*)\\](?::(\\d*))?$");
    private static final long serialVersionUID = 0L;

    private HostAndPort(String host, int port, boolean hasBracketlessColons) {
        this.host = host;
        this.port = port;
        this.hasBracketlessColons = hasBracketlessColons;
    }

    public String getHostText() {
        return this.host;
    }

    public boolean hasPort() {
        return this.port >= 0;
    }

    public int getPort() {
        Preconditions.checkState(this.hasPort());
        return this.port;
    }

    public int getPortOrDefault(int defaultPort) {
        return this.hasPort() ? this.port : defaultPort;
    }

    public static HostAndPort fromParts(String host, int port) {
        Preconditions.checkArgument(HostAndPort.isValidPort(port));
        HostAndPort parsedHost = HostAndPort.fromString(host);
        Preconditions.checkArgument(!parsedHost.hasPort());
        return new HostAndPort(parsedHost.host, port, parsedHost.hasBracketlessColons);
    }

    public static HostAndPort fromString(String hostPortString) {
        String host;
        Preconditions.checkNotNull(hostPortString);
        String portString = null;
        boolean hasBracketlessColons = false;
        if (hostPortString.startsWith("[")) {
            Matcher matcher = BRACKET_PATTERN.matcher(hostPortString);
            Preconditions.checkArgument(matcher.matches(), "Invalid bracketed host/port: %s", hostPortString);
            host = matcher.group(1);
            portString = matcher.group(2);
        } else {
            int colonPos = hostPortString.indexOf(58);
            if (colonPos >= 0 && hostPortString.indexOf(58, colonPos + 1) == -1) {
                host = hostPortString.substring(0, colonPos);
                portString = hostPortString.substring(colonPos + 1);
            } else {
                host = hostPortString;
                hasBracketlessColons = colonPos >= 0;
            }
        }
        int port = -1;
        if (!Strings.isNullOrEmpty(portString)) {
            Preconditions.checkArgument(!portString.startsWith("+"), "Unparseable port number: %s", hostPortString);
            try {
                port = Integer.parseInt(portString);
            }
            catch (NumberFormatException e) {
                throw new IllegalArgumentException("Unparseable port number: " + hostPortString);
            }
            Preconditions.checkArgument(HostAndPort.isValidPort(port), "Port number out of range: %s", hostPortString);
        }
        return new HostAndPort(host, port, hasBracketlessColons);
    }

    public HostAndPort withDefaultPort(int defaultPort) {
        Preconditions.checkArgument(HostAndPort.isValidPort(defaultPort));
        if (this.hasPort() || this.port == defaultPort) {
            return this;
        }
        return new HostAndPort(this.host, defaultPort, this.hasBracketlessColons);
    }

    public HostAndPort requireBracketsForIPv6() {
        Preconditions.checkArgument(!this.hasBracketlessColons, "Possible bracketless IPv6 literal: %s", this.host);
        return this;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof HostAndPort) {
            HostAndPort that = (HostAndPort)other;
            return Objects.equal(this.host, that.host) && this.port == that.port && this.hasBracketlessColons == that.hasBracketlessColons;
        }
        return false;
    }

    public int hashCode() {
        return Objects.hashCode(this.host, this.port, this.hasBracketlessColons);
    }

    public String toString() {
        StringBuilder builder = new StringBuilder(this.host.length() + 7);
        if (this.host.indexOf(58) >= 0) {
            builder.append('[').append(this.host).append(']');
        } else {
            builder.append(this.host);
        }
        if (this.hasPort()) {
            builder.append(':').append(this.port);
        }
        return builder.toString();
    }

    private static boolean isValidPort(int port) {
        return port >= 0 && port <= 65535;
    }
}

