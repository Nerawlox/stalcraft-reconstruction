/*
 * Decompiled with CFR 0.152.
 */
package net.sf.kdgcommons.html;

import net.sf.kdgcommons.html.HtmlUtil;
import net.sf.kdgcommons.lang.StringBuilderUtil;
import net.sf.kdgcommons.lang.StringUtil;

public final class URLBuilder {
    private StringBuilder _path = new StringBuilder(256);
    private StringBuilder _query = new StringBuilder(128);

    public URLBuilder() {
        this._path.append("/");
    }

    public URLBuilder(String string) {
        if (StringUtil.isBlank(string)) {
            string = "/";
        }
        this._path.append(string);
    }

    public URLBuilder(String string, String string2, String string3) {
        if (StringUtil.isBlank(string3)) {
            string3 = "/";
        }
        if (string2 != null) {
            this._path.append(string == null ? "http" : string.toLowerCase()).append("://").append(string2);
        }
        this._path.append(string3.startsWith("/") ? "" : "/").append(string3);
    }

    public URLBuilder appendPath(String string) {
        if (StringBuilderUtil.lastChar(this._path) != '/') {
            this._path.append("/");
        }
        this._path.append(HtmlUtil.urlEncode(string));
        return this;
    }

    public URLBuilder appendParameter(String string, String string2) {
        if (this._query.length() > 0) {
            this._query.append("&");
        }
        this._query.append(HtmlUtil.urlEncode(string)).append("=").append(HtmlUtil.urlEncode(string2));
        return this;
    }

    public URLBuilder appendOptionalParameter(String string, String string2) {
        return string2 != null ? this.appendParameter(string, string2) : this;
    }

    public String toString() {
        return this._query.length() > 0 ? this._path.toString() + "?" + this._query.toString() : this._path.toString();
    }
}

