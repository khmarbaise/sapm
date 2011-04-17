// $ANTLR 3.3 Nov 30, 2010 12:46:29 com/soebes/subversion/sapm/parser/SAFP.g 2011-04-17 20:02:24

    package com.soebes.subversion.sapm.parser;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class SAFPLexer extends Lexer {
    public static final int EOF=-1;
    public static final int T__13=13;
    public static final int T__14=14;
    public static final int T__15=15;
    public static final int T__16=16;
    public static final int T__17=17;
    public static final int T__18=18;
    public static final int T__19=19;
    public static final int T__20=20;
    public static final int T__21=21;
    public static final int T__22=22;
    public static final int T__23=23;
    public static final int T__24=24;
    public static final int T__25=25;
    public static final int T__26=26;
    public static final int T__27=27;
    public static final int T__28=28;
    public static final int NL=4;
    public static final int EQUAL=5;
    public static final int ID=6;
    public static final int GROUPS=7;
    public static final int ALIASES=8;
    public static final int PATH=9;
    public static final int WS=10;
    public static final int CHARACTERS=11;
    public static final int INTEGER_DIGITS=12;

    // delegates
    // delegators

    public SAFPLexer() {;} 
    public SAFPLexer(CharStream input) {
        this(input, new RecognizerSharedState());
    }
    public SAFPLexer(CharStream input, RecognizerSharedState state) {
        super(input,state);

    }
    public String getGrammarFileName() { return "com/soebes/subversion/sapm/parser/SAFP.g"; }

    // $ANTLR start "T__13"
    public final void mT__13() throws RecognitionException {
        try {
            int _type = T__13;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // com/soebes/subversion/sapm/parser/SAFP.g:7:7: ( '[' )
            // com/soebes/subversion/sapm/parser/SAFP.g:7:9: '['
            {
            match('['); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__13"

    // $ANTLR start "T__14"
    public final void mT__14() throws RecognitionException {
        try {
            int _type = T__14;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // com/soebes/subversion/sapm/parser/SAFP.g:8:7: ( ']' )
            // com/soebes/subversion/sapm/parser/SAFP.g:8:9: ']'
            {
            match(']'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__14"

    // $ANTLR start "T__15"
    public final void mT__15() throws RecognitionException {
        try {
            int _type = T__15;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // com/soebes/subversion/sapm/parser/SAFP.g:9:7: ( ':' )
            // com/soebes/subversion/sapm/parser/SAFP.g:9:9: ':'
            {
            match(':'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__15"

    // $ANTLR start "T__16"
    public final void mT__16() throws RecognitionException {
        try {
            int _type = T__16;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // com/soebes/subversion/sapm/parser/SAFP.g:10:7: ( '~' )
            // com/soebes/subversion/sapm/parser/SAFP.g:10:9: '~'
            {
            match('~'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__16"

    // $ANTLR start "T__17"
    public final void mT__17() throws RecognitionException {
        try {
            int _type = T__17;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // com/soebes/subversion/sapm/parser/SAFP.g:11:7: ( '*' )
            // com/soebes/subversion/sapm/parser/SAFP.g:11:9: '*'
            {
            match('*'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__17"

    // $ANTLR start "T__18"
    public final void mT__18() throws RecognitionException {
        try {
            int _type = T__18;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // com/soebes/subversion/sapm/parser/SAFP.g:12:7: ( '$authenticated' )
            // com/soebes/subversion/sapm/parser/SAFP.g:12:9: '$authenticated'
            {
            match("$authenticated"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__18"

    // $ANTLR start "T__19"
    public final void mT__19() throws RecognitionException {
        try {
            int _type = T__19;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // com/soebes/subversion/sapm/parser/SAFP.g:13:7: ( '$anonymous' )
            // com/soebes/subversion/sapm/parser/SAFP.g:13:9: '$anonymous'
            {
            match("$anonymous"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__19"

    // $ANTLR start "T__20"
    public final void mT__20() throws RecognitionException {
        try {
            int _type = T__20;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // com/soebes/subversion/sapm/parser/SAFP.g:14:7: ( 'r' )
            // com/soebes/subversion/sapm/parser/SAFP.g:14:9: 'r'
            {
            match('r'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__20"

    // $ANTLR start "T__21"
    public final void mT__21() throws RecognitionException {
        try {
            int _type = T__21;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // com/soebes/subversion/sapm/parser/SAFP.g:15:7: ( 'R' )
            // com/soebes/subversion/sapm/parser/SAFP.g:15:9: 'R'
            {
            match('R'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__21"

    // $ANTLR start "T__22"
    public final void mT__22() throws RecognitionException {
        try {
            int _type = T__22;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // com/soebes/subversion/sapm/parser/SAFP.g:16:7: ( 'w' )
            // com/soebes/subversion/sapm/parser/SAFP.g:16:9: 'w'
            {
            match('w'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__22"

    // $ANTLR start "T__23"
    public final void mT__23() throws RecognitionException {
        try {
            int _type = T__23;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // com/soebes/subversion/sapm/parser/SAFP.g:17:7: ( 'W' )
            // com/soebes/subversion/sapm/parser/SAFP.g:17:9: 'W'
            {
            match('W'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__23"

    // $ANTLR start "T__24"
    public final void mT__24() throws RecognitionException {
        try {
            int _type = T__24;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // com/soebes/subversion/sapm/parser/SAFP.g:18:7: ( 'rw' )
            // com/soebes/subversion/sapm/parser/SAFP.g:18:9: 'rw'
            {
            match("rw"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__24"

    // $ANTLR start "T__25"
    public final void mT__25() throws RecognitionException {
        try {
            int _type = T__25;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // com/soebes/subversion/sapm/parser/SAFP.g:19:7: ( 'RW' )
            // com/soebes/subversion/sapm/parser/SAFP.g:19:9: 'RW'
            {
            match("RW"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__25"

    // $ANTLR start "T__26"
    public final void mT__26() throws RecognitionException {
        try {
            int _type = T__26;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // com/soebes/subversion/sapm/parser/SAFP.g:20:7: ( ',' )
            // com/soebes/subversion/sapm/parser/SAFP.g:20:9: ','
            {
            match(','); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__26"

    // $ANTLR start "T__27"
    public final void mT__27() throws RecognitionException {
        try {
            int _type = T__27;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // com/soebes/subversion/sapm/parser/SAFP.g:21:7: ( '&' )
            // com/soebes/subversion/sapm/parser/SAFP.g:21:9: '&'
            {
            match('&'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__27"

    // $ANTLR start "T__28"
    public final void mT__28() throws RecognitionException {
        try {
            int _type = T__28;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // com/soebes/subversion/sapm/parser/SAFP.g:22:7: ( '@' )
            // com/soebes/subversion/sapm/parser/SAFP.g:22:9: '@'
            {
            match('@'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__28"

    // $ANTLR start "EQUAL"
    public final void mEQUAL() throws RecognitionException {
        try {
            int _type = EQUAL;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // com/soebes/subversion/sapm/parser/SAFP.g:255:7: ( '=' )
            // com/soebes/subversion/sapm/parser/SAFP.g:255:9: '='
            {
            match('='); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "EQUAL"

    // $ANTLR start "GROUPS"
    public final void mGROUPS() throws RecognitionException {
        try {
            int _type = GROUPS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // com/soebes/subversion/sapm/parser/SAFP.g:257:8: ( 'groups' )
            // com/soebes/subversion/sapm/parser/SAFP.g:257:10: 'groups'
            {
            match("groups"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "GROUPS"

    // $ANTLR start "ALIASES"
    public final void mALIASES() throws RecognitionException {
        try {
            int _type = ALIASES;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // com/soebes/subversion/sapm/parser/SAFP.g:259:9: ( 'aliases' )
            // com/soebes/subversion/sapm/parser/SAFP.g:259:11: 'aliases'
            {
            match("aliases"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "ALIASES"

    // $ANTLR start "WS"
    public final void mWS() throws RecognitionException {
        try {
            int _type = WS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // com/soebes/subversion/sapm/parser/SAFP.g:261:5: ( ( '\\t' | ' ' )+ )
            // com/soebes/subversion/sapm/parser/SAFP.g:261:7: ( '\\t' | ' ' )+
            {
            // com/soebes/subversion/sapm/parser/SAFP.g:261:7: ( '\\t' | ' ' )+
            int cnt1=0;
            loop1:
            do {
                int alt1=2;
                switch ( input.LA(1) ) {
                case '\t':
                case ' ':
                    {
                    alt1=1;
                    }
                    break;

                }

                switch (alt1) {
            	case 1 :
            	    // com/soebes/subversion/sapm/parser/SAFP.g:
            	    {
            	    if ( input.LA(1)=='\t'||input.LA(1)==' ' ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;

            	default :
            	    if ( cnt1 >= 1 ) break loop1;
                        EarlyExitException eee =
                            new EarlyExitException(1, input);
                        throw eee;
                }
                cnt1++;
            } while (true);

             _channel = HIDDEN; 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "WS"

    // $ANTLR start "CHARACTERS"
    public final void mCHARACTERS() throws RecognitionException {
        try {
            int _type = CHARACTERS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // com/soebes/subversion/sapm/parser/SAFP.g:263:11: ( '_' | 'a' .. 'z' | 'A' .. 'Z' | '.' | '-' )
            // com/soebes/subversion/sapm/parser/SAFP.g:
            {
            if ( (input.LA(1)>='-' && input.LA(1)<='.')||(input.LA(1)>='A' && input.LA(1)<='Z')||input.LA(1)=='_'||(input.LA(1)>='a' && input.LA(1)<='z') ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "CHARACTERS"

    // $ANTLR start "INTEGER_DIGITS"
    public final void mINTEGER_DIGITS() throws RecognitionException {
        try {
            int _type = INTEGER_DIGITS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // com/soebes/subversion/sapm/parser/SAFP.g:267:9: ( ( '0' .. '9' )+ )
            // com/soebes/subversion/sapm/parser/SAFP.g:267:11: ( '0' .. '9' )+
            {
            // com/soebes/subversion/sapm/parser/SAFP.g:267:11: ( '0' .. '9' )+
            int cnt2=0;
            loop2:
            do {
                int alt2=2;
                switch ( input.LA(1) ) {
                case '0':
                case '1':
                case '2':
                case '3':
                case '4':
                case '5':
                case '6':
                case '7':
                case '8':
                case '9':
                    {
                    alt2=1;
                    }
                    break;

                }

                switch (alt2) {
            	case 1 :
            	    // com/soebes/subversion/sapm/parser/SAFP.g:267:11: '0' .. '9'
            	    {
            	    matchRange('0','9'); 

            	    }
            	    break;

            	default :
            	    if ( cnt2 >= 1 ) break loop2;
                        EarlyExitException eee =
                            new EarlyExitException(2, input);
                        throw eee;
                }
                cnt2++;
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "INTEGER_DIGITS"

    // $ANTLR start "ID"
    public final void mID() throws RecognitionException {
        try {
            int _type = ID;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // com/soebes/subversion/sapm/parser/SAFP.g:270:5: ( CHARACTERS ( CHARACTERS | INTEGER_DIGITS )* )
            // com/soebes/subversion/sapm/parser/SAFP.g:270:7: CHARACTERS ( CHARACTERS | INTEGER_DIGITS )*
            {
            mCHARACTERS(); 
            // com/soebes/subversion/sapm/parser/SAFP.g:270:18: ( CHARACTERS | INTEGER_DIGITS )*
            loop3:
            do {
                int alt3=3;
                switch ( input.LA(1) ) {
                case '-':
                case '.':
                case 'A':
                case 'B':
                case 'C':
                case 'D':
                case 'E':
                case 'F':
                case 'G':
                case 'H':
                case 'I':
                case 'J':
                case 'K':
                case 'L':
                case 'M':
                case 'N':
                case 'O':
                case 'P':
                case 'Q':
                case 'R':
                case 'S':
                case 'T':
                case 'U':
                case 'V':
                case 'W':
                case 'X':
                case 'Y':
                case 'Z':
                case '_':
                case 'a':
                case 'b':
                case 'c':
                case 'd':
                case 'e':
                case 'f':
                case 'g':
                case 'h':
                case 'i':
                case 'j':
                case 'k':
                case 'l':
                case 'm':
                case 'n':
                case 'o':
                case 'p':
                case 'q':
                case 'r':
                case 's':
                case 't':
                case 'u':
                case 'v':
                case 'w':
                case 'x':
                case 'y':
                case 'z':
                    {
                    alt3=1;
                    }
                    break;
                case '0':
                case '1':
                case '2':
                case '3':
                case '4':
                case '5':
                case '6':
                case '7':
                case '8':
                case '9':
                    {
                    alt3=2;
                    }
                    break;

                }

                switch (alt3) {
            	case 1 :
            	    // com/soebes/subversion/sapm/parser/SAFP.g:270:19: CHARACTERS
            	    {
            	    mCHARACTERS(); 

            	    }
            	    break;
            	case 2 :
            	    // com/soebes/subversion/sapm/parser/SAFP.g:270:32: INTEGER_DIGITS
            	    {
            	    mINTEGER_DIGITS(); 

            	    }
            	    break;

            	default :
            	    break loop3;
                }
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "ID"

    // $ANTLR start "PATH"
    public final void mPATH() throws RecognitionException {
        try {
            int _type = PATH;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // com/soebes/subversion/sapm/parser/SAFP.g:273:6: ( '/' ( CHARACTERS | INTEGER_DIGITS | '/' )* )
            // com/soebes/subversion/sapm/parser/SAFP.g:273:8: '/' ( CHARACTERS | INTEGER_DIGITS | '/' )*
            {
            match('/'); 
            // com/soebes/subversion/sapm/parser/SAFP.g:273:12: ( CHARACTERS | INTEGER_DIGITS | '/' )*
            loop4:
            do {
                int alt4=4;
                switch ( input.LA(1) ) {
                case '-':
                case '.':
                case 'A':
                case 'B':
                case 'C':
                case 'D':
                case 'E':
                case 'F':
                case 'G':
                case 'H':
                case 'I':
                case 'J':
                case 'K':
                case 'L':
                case 'M':
                case 'N':
                case 'O':
                case 'P':
                case 'Q':
                case 'R':
                case 'S':
                case 'T':
                case 'U':
                case 'V':
                case 'W':
                case 'X':
                case 'Y':
                case 'Z':
                case '_':
                case 'a':
                case 'b':
                case 'c':
                case 'd':
                case 'e':
                case 'f':
                case 'g':
                case 'h':
                case 'i':
                case 'j':
                case 'k':
                case 'l':
                case 'm':
                case 'n':
                case 'o':
                case 'p':
                case 'q':
                case 'r':
                case 's':
                case 't':
                case 'u':
                case 'v':
                case 'w':
                case 'x':
                case 'y':
                case 'z':
                    {
                    alt4=1;
                    }
                    break;
                case '0':
                case '1':
                case '2':
                case '3':
                case '4':
                case '5':
                case '6':
                case '7':
                case '8':
                case '9':
                    {
                    alt4=2;
                    }
                    break;
                case '/':
                    {
                    alt4=3;
                    }
                    break;

                }

                switch (alt4) {
            	case 1 :
            	    // com/soebes/subversion/sapm/parser/SAFP.g:273:13: CHARACTERS
            	    {
            	    mCHARACTERS(); 

            	    }
            	    break;
            	case 2 :
            	    // com/soebes/subversion/sapm/parser/SAFP.g:273:26: INTEGER_DIGITS
            	    {
            	    mINTEGER_DIGITS(); 

            	    }
            	    break;
            	case 3 :
            	    // com/soebes/subversion/sapm/parser/SAFP.g:273:43: '/'
            	    {
            	    match('/'); 

            	    }
            	    break;

            	default :
            	    break loop4;
                }
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "PATH"

    // $ANTLR start "NL"
    public final void mNL() throws RecognitionException {
        try {
            int _type = NL;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // com/soebes/subversion/sapm/parser/SAFP.g:276:5: ( ( '\\r' | '\\n' )+ )
            // com/soebes/subversion/sapm/parser/SAFP.g:276:7: ( '\\r' | '\\n' )+
            {
            // com/soebes/subversion/sapm/parser/SAFP.g:276:7: ( '\\r' | '\\n' )+
            int cnt5=0;
            loop5:
            do {
                int alt5=2;
                switch ( input.LA(1) ) {
                case '\n':
                case '\r':
                    {
                    alt5=1;
                    }
                    break;

                }

                switch (alt5) {
            	case 1 :
            	    // com/soebes/subversion/sapm/parser/SAFP.g:
            	    {
            	    if ( input.LA(1)=='\n'||input.LA(1)=='\r' ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;

            	default :
            	    if ( cnt5 >= 1 ) break loop5;
                        EarlyExitException eee =
                            new EarlyExitException(5, input);
                        throw eee;
                }
                cnt5++;
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "NL"

    public void mTokens() throws RecognitionException {
        // com/soebes/subversion/sapm/parser/SAFP.g:1:8: ( T__13 | T__14 | T__15 | T__16 | T__17 | T__18 | T__19 | T__20 | T__21 | T__22 | T__23 | T__24 | T__25 | T__26 | T__27 | T__28 | EQUAL | GROUPS | ALIASES | WS | CHARACTERS | INTEGER_DIGITS | ID | PATH | NL )
        int alt6=25;
        alt6 = dfa6.predict(input);
        switch (alt6) {
            case 1 :
                // com/soebes/subversion/sapm/parser/SAFP.g:1:10: T__13
                {
                mT__13(); 

                }
                break;
            case 2 :
                // com/soebes/subversion/sapm/parser/SAFP.g:1:16: T__14
                {
                mT__14(); 

                }
                break;
            case 3 :
                // com/soebes/subversion/sapm/parser/SAFP.g:1:22: T__15
                {
                mT__15(); 

                }
                break;
            case 4 :
                // com/soebes/subversion/sapm/parser/SAFP.g:1:28: T__16
                {
                mT__16(); 

                }
                break;
            case 5 :
                // com/soebes/subversion/sapm/parser/SAFP.g:1:34: T__17
                {
                mT__17(); 

                }
                break;
            case 6 :
                // com/soebes/subversion/sapm/parser/SAFP.g:1:40: T__18
                {
                mT__18(); 

                }
                break;
            case 7 :
                // com/soebes/subversion/sapm/parser/SAFP.g:1:46: T__19
                {
                mT__19(); 

                }
                break;
            case 8 :
                // com/soebes/subversion/sapm/parser/SAFP.g:1:52: T__20
                {
                mT__20(); 

                }
                break;
            case 9 :
                // com/soebes/subversion/sapm/parser/SAFP.g:1:58: T__21
                {
                mT__21(); 

                }
                break;
            case 10 :
                // com/soebes/subversion/sapm/parser/SAFP.g:1:64: T__22
                {
                mT__22(); 

                }
                break;
            case 11 :
                // com/soebes/subversion/sapm/parser/SAFP.g:1:70: T__23
                {
                mT__23(); 

                }
                break;
            case 12 :
                // com/soebes/subversion/sapm/parser/SAFP.g:1:76: T__24
                {
                mT__24(); 

                }
                break;
            case 13 :
                // com/soebes/subversion/sapm/parser/SAFP.g:1:82: T__25
                {
                mT__25(); 

                }
                break;
            case 14 :
                // com/soebes/subversion/sapm/parser/SAFP.g:1:88: T__26
                {
                mT__26(); 

                }
                break;
            case 15 :
                // com/soebes/subversion/sapm/parser/SAFP.g:1:94: T__27
                {
                mT__27(); 

                }
                break;
            case 16 :
                // com/soebes/subversion/sapm/parser/SAFP.g:1:100: T__28
                {
                mT__28(); 

                }
                break;
            case 17 :
                // com/soebes/subversion/sapm/parser/SAFP.g:1:106: EQUAL
                {
                mEQUAL(); 

                }
                break;
            case 18 :
                // com/soebes/subversion/sapm/parser/SAFP.g:1:112: GROUPS
                {
                mGROUPS(); 

                }
                break;
            case 19 :
                // com/soebes/subversion/sapm/parser/SAFP.g:1:119: ALIASES
                {
                mALIASES(); 

                }
                break;
            case 20 :
                // com/soebes/subversion/sapm/parser/SAFP.g:1:127: WS
                {
                mWS(); 

                }
                break;
            case 21 :
                // com/soebes/subversion/sapm/parser/SAFP.g:1:130: CHARACTERS
                {
                mCHARACTERS(); 

                }
                break;
            case 22 :
                // com/soebes/subversion/sapm/parser/SAFP.g:1:141: INTEGER_DIGITS
                {
                mINTEGER_DIGITS(); 

                }
                break;
            case 23 :
                // com/soebes/subversion/sapm/parser/SAFP.g:1:156: ID
                {
                mID(); 

                }
                break;
            case 24 :
                // com/soebes/subversion/sapm/parser/SAFP.g:1:159: PATH
                {
                mPATH(); 

                }
                break;
            case 25 :
                // com/soebes/subversion/sapm/parser/SAFP.g:1:164: NL
                {
                mNL(); 

                }
                break;

        }

    }


    protected DFA6 dfa6 = new DFA6(this);
    static final String DFA6_eotS =
        "\7\uffff\1\30\1\33\1\34\1\35\4\uffff\2\37\1\uffff\1\37\4\uffff\1"+
        "\43\2\uffff\1\44\3\uffff\1\31\1\uffff\1\31\4\uffff\6\31\1\55\1\31"+
        "\1\uffff\1\57\1\uffff";
    static final String DFA6_eofS =
        "\60\uffff";
    static final String DFA6_minS =
        "\1\11\5\uffff\1\141\4\55\4\uffff\2\55\1\uffff\1\55\3\uffff\1\156"+
        "\1\55\2\uffff\1\55\3\uffff\1\157\1\uffff\1\151\4\uffff\1\165\1\141"+
        "\1\160\2\163\1\145\1\55\1\163\1\uffff\1\55\1\uffff";
    static final String DFA6_maxS =
        "\1\176\5\uffff\1\141\4\172\4\uffff\2\172\1\uffff\1\172\3\uffff\1"+
        "\165\1\172\2\uffff\1\172\3\uffff\1\157\1\uffff\1\151\4\uffff\1\165"+
        "\1\141\1\160\2\163\1\145\1\172\1\163\1\uffff\1\172\1\uffff";
    static final String DFA6_acceptS =
        "\1\uffff\1\1\1\2\1\3\1\4\1\5\5\uffff\1\16\1\17\1\20\1\21\2\uffff"+
        "\1\24\1\uffff\1\26\1\30\1\31\2\uffff\1\10\1\27\1\uffff\1\11\1\12"+
        "\1\13\1\uffff\1\25\1\uffff\1\6\1\7\1\14\1\15\10\uffff\1\22\1\uffff"+
        "\1\23";
    static final String DFA6_specialS =
        "\60\uffff}>";
    static final String[] DFA6_transitionS = {
            "\1\21\1\25\2\uffff\1\25\22\uffff\1\21\3\uffff\1\6\1\uffff\1"+
            "\14\3\uffff\1\5\1\uffff\1\13\2\22\1\24\12\23\1\3\2\uffff\1\16"+
            "\2\uffff\1\15\21\22\1\10\4\22\1\12\3\22\1\1\1\uffff\1\2\1\uffff"+
            "\1\22\1\uffff\1\20\5\22\1\17\12\22\1\7\4\22\1\11\3\22\3\uffff"+
            "\1\4",
            "",
            "",
            "",
            "",
            "",
            "\1\26",
            "\2\31\1\uffff\12\31\7\uffff\32\31\4\uffff\1\31\1\uffff\26\31"+
            "\1\27\3\31",
            "\2\31\1\uffff\12\31\7\uffff\26\31\1\32\3\31\4\uffff\1\31\1"+
            "\uffff\32\31",
            "\2\31\1\uffff\12\31\7\uffff\32\31\4\uffff\1\31\1\uffff\32\31",
            "\2\31\1\uffff\12\31\7\uffff\32\31\4\uffff\1\31\1\uffff\32\31",
            "",
            "",
            "",
            "",
            "\2\31\1\uffff\12\31\7\uffff\32\31\4\uffff\1\31\1\uffff\21\31"+
            "\1\36\10\31",
            "\2\31\1\uffff\12\31\7\uffff\32\31\4\uffff\1\31\1\uffff\13\31"+
            "\1\40\16\31",
            "",
            "\2\31\1\uffff\12\31\7\uffff\32\31\4\uffff\1\31\1\uffff\32\31",
            "",
            "",
            "",
            "\1\42\6\uffff\1\41",
            "\2\31\1\uffff\12\31\7\uffff\32\31\4\uffff\1\31\1\uffff\32\31",
            "",
            "",
            "\2\31\1\uffff\12\31\7\uffff\32\31\4\uffff\1\31\1\uffff\32\31",
            "",
            "",
            "",
            "\1\45",
            "",
            "\1\46",
            "",
            "",
            "",
            "",
            "\1\47",
            "\1\50",
            "\1\51",
            "\1\52",
            "\1\53",
            "\1\54",
            "\2\31\1\uffff\12\31\7\uffff\32\31\4\uffff\1\31\1\uffff\32\31",
            "\1\56",
            "",
            "\2\31\1\uffff\12\31\7\uffff\32\31\4\uffff\1\31\1\uffff\32\31",
            ""
    };

    static final short[] DFA6_eot = DFA.unpackEncodedString(DFA6_eotS);
    static final short[] DFA6_eof = DFA.unpackEncodedString(DFA6_eofS);
    static final char[] DFA6_min = DFA.unpackEncodedStringToUnsignedChars(DFA6_minS);
    static final char[] DFA6_max = DFA.unpackEncodedStringToUnsignedChars(DFA6_maxS);
    static final short[] DFA6_accept = DFA.unpackEncodedString(DFA6_acceptS);
    static final short[] DFA6_special = DFA.unpackEncodedString(DFA6_specialS);
    static final short[][] DFA6_transition;

    static {
        int numStates = DFA6_transitionS.length;
        DFA6_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA6_transition[i] = DFA.unpackEncodedString(DFA6_transitionS[i]);
        }
    }

    class DFA6 extends DFA {

        public DFA6(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 6;
            this.eot = DFA6_eot;
            this.eof = DFA6_eof;
            this.min = DFA6_min;
            this.max = DFA6_max;
            this.accept = DFA6_accept;
            this.special = DFA6_special;
            this.transition = DFA6_transition;
        }
        public String getDescription() {
            return "1:1: Tokens : ( T__13 | T__14 | T__15 | T__16 | T__17 | T__18 | T__19 | T__20 | T__21 | T__22 | T__23 | T__24 | T__25 | T__26 | T__27 | T__28 | EQUAL | GROUPS | ALIASES | WS | CHARACTERS | INTEGER_DIGITS | ID | PATH | NL );";
        }
    }
 

}