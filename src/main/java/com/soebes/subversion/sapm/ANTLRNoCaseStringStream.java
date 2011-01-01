package com.soebes.subversion.sapm;

import java.io.IOException;

import org.antlr.runtime.ANTLRStringStream;
import org.antlr.runtime.CharStream;

public class ANTLRNoCaseStringStream extends ANTLRStringStream {

    public ANTLRNoCaseStringStream(String string) throws IOException {
        super(string);
    }

    public ANTLRNoCaseStringStream(char[] args, int argc) throws IOException {
        super(args, argc);
    }

    public int LA(int i) {
        if (i == 0) {
            return 0; // undefined
        }
        if (i < 0) {
            i++; // e.g., translate LA(-1) to use offset 0
        }

        if ((p + i - 1) >= n) {

            return CharStream.EOF;
        }
        return Character.toUpperCase(data[p + i - 1]);
    }
}
