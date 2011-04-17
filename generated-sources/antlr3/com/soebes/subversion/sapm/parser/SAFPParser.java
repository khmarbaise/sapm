// $ANTLR 3.3 Nov 30, 2010 12:46:29 com/soebes/subversion/sapm/parser/SAFP.g 2011-04-17 20:02:23

    package com.soebes.subversion.sapm.parser;

    import com.soebes.subversion.sapm.User;
    import com.soebes.subversion.sapm.Users;
    import com.soebes.subversion.sapm.UserFactory;
    import com.soebes.subversion.sapm.Group;
    import com.soebes.subversion.sapm.Groups;
    import com.soebes.subversion.sapm.Alias;
    import com.soebes.subversion.sapm.Aliases;
    import com.soebes.subversion.sapm.AccessRule;
    import com.soebes.subversion.sapm.AccessRules;
    import com.soebes.subversion.sapm.Access;
    import com.soebes.subversion.sapm.AccessLevel;
    import com.soebes.subversion.sapm.IPrincipal;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;


import org.antlr.runtime.tree.*;

public class SAFPParser extends Parser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "NL", "EQUAL", "ID", "GROUPS", "ALIASES", "PATH", "WS", "CHARACTERS", "INTEGER_DIGITS", "'['", "']'", "':'", "'~'", "'*'", "'$authenticated'", "'$anonymous'", "'r'", "'R'", "'w'", "'W'", "'rw'", "'RW'", "','", "'&'", "'@'"
    };
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


        public SAFPParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public SAFPParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        
    protected TreeAdaptor adaptor = new CommonTreeAdaptor();

    public void setTreeAdaptor(TreeAdaptor adaptor) {
        this.adaptor = adaptor;
    }
    public TreeAdaptor getTreeAdaptor() {
        return adaptor;
    }

    public String[] getTokenNames() { return SAFPParser.tokenNames; }
    public String getGrammarFileName() { return "com/soebes/subversion/sapm/parser/SAFP.g"; }


        private AccessRules accessRules = new AccessRules();
        public AccessRules getAccessRules() { return this.accessRules; }
        private Groups groups = new Groups();
        public Groups getGroups() { return this.groups; }
        private Users users = new Users();
        public Users getUsers() { return this.users; }
        private Aliases aliases = new Aliases();
        public Aliases getAliases() { return this.aliases; }


    public static class prog_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "prog"
    // com/soebes/subversion/sapm/parser/SAFP.g:64:1: prog : ( statement )* ;
    public final SAFPParser.prog_return prog() throws RecognitionException {
        SAFPParser.prog_return retval = new SAFPParser.prog_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        SAFPParser.statement_return statement1 = null;



        try {
            // com/soebes/subversion/sapm/parser/SAFP.g:65:5: ( ( statement )* )
            // com/soebes/subversion/sapm/parser/SAFP.g:65:7: ( statement )*
            {
            root_0 = (Object)adaptor.nil();

            // com/soebes/subversion/sapm/parser/SAFP.g:65:7: ( statement )*
            loop1:
            do {
                int alt1=2;
                switch ( input.LA(1) ) {
                case 13:
                    {
                    alt1=1;
                    }
                    break;

                }

                switch (alt1) {
            	case 1 :
            	    // com/soebes/subversion/sapm/parser/SAFP.g:65:8: statement
            	    {
            	    pushFollow(FOLLOW_statement_in_prog75);
            	    statement1=statement();

            	    state._fsp--;

            	    adaptor.addChild(root_0, statement1.getTree());

            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);


            }

            retval.stop = input.LT(-1);

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "prog"

    public static class statement_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "statement"
    // com/soebes/subversion/sapm/parser/SAFP.g:67:1: statement : ( groups | repos | aliases );
    public final SAFPParser.statement_return statement() throws RecognitionException {
        SAFPParser.statement_return retval = new SAFPParser.statement_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        SAFPParser.groups_return groups2 = null;

        SAFPParser.repos_return repos3 = null;

        SAFPParser.aliases_return aliases4 = null;



        try {
            // com/soebes/subversion/sapm/parser/SAFP.g:68:5: ( groups | repos | aliases )
            int alt2=3;
            switch ( input.LA(1) ) {
            case 13:
                {
                switch ( input.LA(2) ) {
                case GROUPS:
                    {
                    alt2=1;
                    }
                    break;
                case ALIASES:
                    {
                    alt2=3;
                    }
                    break;
                case ID:
                case PATH:
                    {
                    alt2=2;
                    }
                    break;
                default:
                    NoViableAltException nvae =
                        new NoViableAltException("", 2, 1, input);

                    throw nvae;
                }

                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 2, 0, input);

                throw nvae;
            }

            switch (alt2) {
                case 1 :
                    // com/soebes/subversion/sapm/parser/SAFP.g:68:7: groups
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_groups_in_statement89);
                    groups2=groups();

                    state._fsp--;

                    adaptor.addChild(root_0, groups2.getTree());

                    }
                    break;
                case 2 :
                    // com/soebes/subversion/sapm/parser/SAFP.g:69:7: repos
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_repos_in_statement97);
                    repos3=repos();

                    state._fsp--;

                    adaptor.addChild(root_0, repos3.getTree());
                     getAccessRules().add((repos3!=null?repos3.accessrule:null)); 

                    }
                    break;
                case 3 :
                    // com/soebes/subversion/sapm/parser/SAFP.g:70:7: aliases
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_aliases_in_statement107);
                    aliases4=aliases();

                    state._fsp--;

                    adaptor.addChild(root_0, aliases4.getTree());

                    }
                    break;

            }
            retval.stop = input.LT(-1);

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "statement"

    public static class groups_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "groups"
    // com/soebes/subversion/sapm/parser/SAFP.g:73:1: groups : sectiongroup NL ( group EQUAL groupuserdefinition NL )* ;
    public final SAFPParser.groups_return groups() throws RecognitionException {
        SAFPParser.groups_return retval = new SAFPParser.groups_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token NL6=null;
        Token EQUAL8=null;
        Token NL10=null;
        SAFPParser.sectiongroup_return sectiongroup5 = null;

        SAFPParser.group_return group7 = null;

        SAFPParser.groupuserdefinition_return groupuserdefinition9 = null;


        Object NL6_tree=null;
        Object EQUAL8_tree=null;
        Object NL10_tree=null;

        try {
            // com/soebes/subversion/sapm/parser/SAFP.g:74:5: ( sectiongroup NL ( group EQUAL groupuserdefinition NL )* )
            // com/soebes/subversion/sapm/parser/SAFP.g:74:7: sectiongroup NL ( group EQUAL groupuserdefinition NL )*
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_sectiongroup_in_groups124);
            sectiongroup5=sectiongroup();

            state._fsp--;

            adaptor.addChild(root_0, sectiongroup5.getTree());
            NL6=(Token)match(input,NL,FOLLOW_NL_in_groups126); 
            NL6_tree = (Object)adaptor.create(NL6);
            adaptor.addChild(root_0, NL6_tree);

            // com/soebes/subversion/sapm/parser/SAFP.g:74:23: ( group EQUAL groupuserdefinition NL )*
            loop3:
            do {
                int alt3=2;
                switch ( input.LA(1) ) {
                case ID:
                    {
                    alt3=1;
                    }
                    break;

                }

                switch (alt3) {
            	case 1 :
            	    // com/soebes/subversion/sapm/parser/SAFP.g:74:24: group EQUAL groupuserdefinition NL
            	    {
            	    pushFollow(FOLLOW_group_in_groups129);
            	    group7=group();

            	    state._fsp--;

            	    adaptor.addChild(root_0, group7.getTree());
            	    EQUAL8=(Token)match(input,EQUAL,FOLLOW_EQUAL_in_groups131); 
            	    EQUAL8_tree = (Object)adaptor.create(EQUAL8);
            	    adaptor.addChild(root_0, EQUAL8_tree);

            	    pushFollow(FOLLOW_groupuserdefinition_in_groups133);
            	    groupuserdefinition9=groupuserdefinition();

            	    state._fsp--;

            	    adaptor.addChild(root_0, groupuserdefinition9.getTree());

            	              Group group = new Group((group7!=null?input.toString(group7.start,group7.stop):null));
            	              for (IPrincipal item:(groupuserdefinition9!=null?groupuserdefinition9.gud:null)) {
            	                group.add(item);
            	              }
            	              getGroups().add(group);
            	            
            	    NL10=(Token)match(input,NL,FOLLOW_NL_in_groups153); 
            	    NL10_tree = (Object)adaptor.create(NL10);
            	    adaptor.addChild(root_0, NL10_tree);


            	    }
            	    break;

            	default :
            	    break loop3;
                }
            } while (true);


            }

            retval.stop = input.LT(-1);

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "groups"

    public static class repos_return extends ParserRuleReturnScope {
        public AccessRule accessrule;;
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "repos"
    // com/soebes/subversion/sapm/parser/SAFP.g:85:1: repos returns [ AccessRule accessrule; ] : sectionrule= sectionrepository NL perm= permissionrule ( NL )? (perm1= permissionrule ( NL )? )* ;
    public final SAFPParser.repos_return repos() throws RecognitionException {
        SAFPParser.repos_return retval = new SAFPParser.repos_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token NL11=null;
        Token NL12=null;
        Token NL13=null;
        SAFPParser.sectionrepository_return sectionrule = null;

        SAFPParser.permissionrule_return perm = null;

        SAFPParser.permissionrule_return perm1 = null;


        Object NL11_tree=null;
        Object NL12_tree=null;
        Object NL13_tree=null;

        try {
            // com/soebes/subversion/sapm/parser/SAFP.g:86:5: (sectionrule= sectionrepository NL perm= permissionrule ( NL )? (perm1= permissionrule ( NL )? )* )
            // com/soebes/subversion/sapm/parser/SAFP.g:86:7: sectionrule= sectionrepository NL perm= permissionrule ( NL )? (perm1= permissionrule ( NL )? )*
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_sectionrepository_in_repos178);
            sectionrule=sectionrepository();

            state._fsp--;

            adaptor.addChild(root_0, sectionrule.getTree());
            NL11=(Token)match(input,NL,FOLLOW_NL_in_repos180); 
            NL11_tree = (Object)adaptor.create(NL11);
            adaptor.addChild(root_0, NL11_tree);

            pushFollow(FOLLOW_permissionrule_in_repos192);
            perm=permissionrule();

            state._fsp--;

            adaptor.addChild(root_0, perm.getTree());

                        (sectionrule!=null?sectionrule.accessRule:null).add((perm!=null?perm.access:null));
                    
            // com/soebes/subversion/sapm/parser/SAFP.g:89:11: ( NL )?
            int alt4=2;
            switch ( input.LA(1) ) {
                case NL:
                    {
                    alt4=1;
                    }
                    break;
            }

            switch (alt4) {
                case 1 :
                    // com/soebes/subversion/sapm/parser/SAFP.g:89:11: NL
                    {
                    NL12=(Token)match(input,NL,FOLLOW_NL_in_repos196); 
                    NL12_tree = (Object)adaptor.create(NL12);
                    adaptor.addChild(root_0, NL12_tree);


                    }
                    break;

            }

            // com/soebes/subversion/sapm/parser/SAFP.g:90:9: (perm1= permissionrule ( NL )? )*
            loop6:
            do {
                int alt6=2;
                switch ( input.LA(1) ) {
                case ID:
                case 16:
                case 17:
                case 18:
                case 19:
                case 27:
                case 28:
                    {
                    alt6=1;
                    }
                    break;

                }

                switch (alt6) {
            	case 1 :
            	    // com/soebes/subversion/sapm/parser/SAFP.g:91:13: perm1= permissionrule ( NL )?
            	    {
            	    pushFollow(FOLLOW_permissionrule_in_repos223);
            	    perm1=permissionrule();

            	    state._fsp--;

            	    adaptor.addChild(root_0, perm1.getTree());

            	                    (sectionrule!=null?sectionrule.accessRule:null).add((perm1!=null?perm1.access:null));
            	                
            	    // com/soebes/subversion/sapm/parser/SAFP.g:94:13: ( NL )?
            	    int alt5=2;
            	    switch ( input.LA(1) ) {
            	        case NL:
            	            {
            	            alt5=1;
            	            }
            	            break;
            	    }

            	    switch (alt5) {
            	        case 1 :
            	            // com/soebes/subversion/sapm/parser/SAFP.g:94:13: NL
            	            {
            	            NL13=(Token)match(input,NL,FOLLOW_NL_in_repos239); 
            	            NL13_tree = (Object)adaptor.create(NL13);
            	            adaptor.addChild(root_0, NL13_tree);


            	            }
            	            break;

            	    }


            	    }
            	    break;

            	default :
            	    break loop6;
                }
            } while (true);

             retval.accessrule = (sectionrule!=null?sectionrule.accessRule:null); 

            }

            retval.stop = input.LT(-1);

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "repos"

    public static class aliases_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "aliases"
    // com/soebes/subversion/sapm/parser/SAFP.g:98:1: aliases : sectionaliases NL ( alias EQUAL useraliasdefinition NL )* ;
    public final SAFPParser.aliases_return aliases() throws RecognitionException {
        SAFPParser.aliases_return retval = new SAFPParser.aliases_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token NL15=null;
        Token EQUAL17=null;
        Token NL19=null;
        SAFPParser.sectionaliases_return sectionaliases14 = null;

        SAFPParser.alias_return alias16 = null;

        SAFPParser.useraliasdefinition_return useraliasdefinition18 = null;


        Object NL15_tree=null;
        Object EQUAL17_tree=null;
        Object NL19_tree=null;

        try {
            // com/soebes/subversion/sapm/parser/SAFP.g:99:5: ( sectionaliases NL ( alias EQUAL useraliasdefinition NL )* )
            // com/soebes/subversion/sapm/parser/SAFP.g:99:7: sectionaliases NL ( alias EQUAL useraliasdefinition NL )*
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_sectionaliases_in_aliases270);
            sectionaliases14=sectionaliases();

            state._fsp--;

            adaptor.addChild(root_0, sectionaliases14.getTree());
            NL15=(Token)match(input,NL,FOLLOW_NL_in_aliases272); 
            NL15_tree = (Object)adaptor.create(NL15);
            adaptor.addChild(root_0, NL15_tree);

            // com/soebes/subversion/sapm/parser/SAFP.g:100:9: ( alias EQUAL useraliasdefinition NL )*
            loop7:
            do {
                int alt7=2;
                switch ( input.LA(1) ) {
                case ID:
                    {
                    alt7=1;
                    }
                    break;

                }

                switch (alt7) {
            	case 1 :
            	    // com/soebes/subversion/sapm/parser/SAFP.g:101:13: alias EQUAL useraliasdefinition NL
            	    {
            	    pushFollow(FOLLOW_alias_in_aliases296);
            	    alias16=alias();

            	    state._fsp--;

            	    adaptor.addChild(root_0, alias16.getTree());
            	    EQUAL17=(Token)match(input,EQUAL,FOLLOW_EQUAL_in_aliases298); 
            	    EQUAL17_tree = (Object)adaptor.create(EQUAL17);
            	    adaptor.addChild(root_0, EQUAL17_tree);

            	    pushFollow(FOLLOW_useraliasdefinition_in_aliases300);
            	    useraliasdefinition18=useraliasdefinition();

            	    state._fsp--;

            	    adaptor.addChild(root_0, useraliasdefinition18.getTree());
            	    NL19=(Token)match(input,NL,FOLLOW_NL_in_aliases302); 
            	    NL19_tree = (Object)adaptor.create(NL19);
            	    adaptor.addChild(root_0, NL19_tree);


            	                  Alias alias = new Alias((alias16!=null?input.toString(alias16.start,alias16.stop):null), (useraliasdefinition18!=null?input.toString(useraliasdefinition18.start,useraliasdefinition18.stop):null));
            	                  getAliases().add(alias);
            	                

            	    }
            	    break;

            	default :
            	    break loop7;
                }
            } while (true);


            }

            retval.stop = input.LT(-1);

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "aliases"

    public static class group_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "group"
    // com/soebes/subversion/sapm/parser/SAFP.g:109:1: group : ID ;
    public final SAFPParser.group_return group() throws RecognitionException {
        SAFPParser.group_return retval = new SAFPParser.group_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token ID20=null;

        Object ID20_tree=null;

        try {
            // com/soebes/subversion/sapm/parser/SAFP.g:110:5: ( ID )
            // com/soebes/subversion/sapm/parser/SAFP.g:110:7: ID
            {
            root_0 = (Object)adaptor.nil();

            ID20=(Token)match(input,ID,FOLLOW_ID_in_group344); 
            ID20_tree = (Object)adaptor.create(ID20);
            adaptor.addChild(root_0, ID20_tree);


            }

            retval.stop = input.LT(-1);

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "group"

    public static class alias_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "alias"
    // com/soebes/subversion/sapm/parser/SAFP.g:113:1: alias : ID ;
    public final SAFPParser.alias_return alias() throws RecognitionException {
        SAFPParser.alias_return retval = new SAFPParser.alias_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token ID21=null;

        Object ID21_tree=null;

        try {
            // com/soebes/subversion/sapm/parser/SAFP.g:114:5: ( ID )
            // com/soebes/subversion/sapm/parser/SAFP.g:114:7: ID
            {
            root_0 = (Object)adaptor.nil();

            ID21=(Token)match(input,ID,FOLLOW_ID_in_alias361); 
            ID21_tree = (Object)adaptor.create(ID21);
            adaptor.addChild(root_0, ID21_tree);


            }

            retval.stop = input.LT(-1);

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "alias"

    public static class sectiongroup_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "sectiongroup"
    // com/soebes/subversion/sapm/parser/SAFP.g:117:1: sectiongroup : '[' GROUPS ']' ;
    public final SAFPParser.sectiongroup_return sectiongroup() throws RecognitionException {
        SAFPParser.sectiongroup_return retval = new SAFPParser.sectiongroup_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token char_literal22=null;
        Token GROUPS23=null;
        Token char_literal24=null;

        Object char_literal22_tree=null;
        Object GROUPS23_tree=null;
        Object char_literal24_tree=null;

        try {
            // com/soebes/subversion/sapm/parser/SAFP.g:118:5: ( '[' GROUPS ']' )
            // com/soebes/subversion/sapm/parser/SAFP.g:118:7: '[' GROUPS ']'
            {
            root_0 = (Object)adaptor.nil();

            char_literal22=(Token)match(input,13,FOLLOW_13_in_sectiongroup378); 
            char_literal22_tree = (Object)adaptor.create(char_literal22);
            adaptor.addChild(root_0, char_literal22_tree);

            GROUPS23=(Token)match(input,GROUPS,FOLLOW_GROUPS_in_sectiongroup380); 
            GROUPS23_tree = (Object)adaptor.create(GROUPS23);
            adaptor.addChild(root_0, GROUPS23_tree);

            char_literal24=(Token)match(input,14,FOLLOW_14_in_sectiongroup382); 
            char_literal24_tree = (Object)adaptor.create(char_literal24);
            adaptor.addChild(root_0, char_literal24_tree);


            }

            retval.stop = input.LT(-1);

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "sectiongroup"

    public static class sectionaliases_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "sectionaliases"
    // com/soebes/subversion/sapm/parser/SAFP.g:121:1: sectionaliases : '[' ALIASES ']' ;
    public final SAFPParser.sectionaliases_return sectionaliases() throws RecognitionException {
        SAFPParser.sectionaliases_return retval = new SAFPParser.sectionaliases_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token char_literal25=null;
        Token ALIASES26=null;
        Token char_literal27=null;

        Object char_literal25_tree=null;
        Object ALIASES26_tree=null;
        Object char_literal27_tree=null;

        try {
            // com/soebes/subversion/sapm/parser/SAFP.g:122:5: ( '[' ALIASES ']' )
            // com/soebes/subversion/sapm/parser/SAFP.g:122:7: '[' ALIASES ']'
            {
            root_0 = (Object)adaptor.nil();

            char_literal25=(Token)match(input,13,FOLLOW_13_in_sectionaliases399); 
            char_literal25_tree = (Object)adaptor.create(char_literal25);
            adaptor.addChild(root_0, char_literal25_tree);

            ALIASES26=(Token)match(input,ALIASES,FOLLOW_ALIASES_in_sectionaliases401); 
            ALIASES26_tree = (Object)adaptor.create(ALIASES26);
            adaptor.addChild(root_0, ALIASES26_tree);

            char_literal27=(Token)match(input,14,FOLLOW_14_in_sectionaliases403); 
            char_literal27_tree = (Object)adaptor.create(char_literal27);
            adaptor.addChild(root_0, char_literal27_tree);


            }

            retval.stop = input.LT(-1);

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "sectionaliases"

    public static class sectionrepository_return extends ParserRuleReturnScope {
        public AccessRule accessRule;;
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "sectionrepository"
    // com/soebes/subversion/sapm/parser/SAFP.g:125:1: sectionrepository returns [ AccessRule accessRule; ] : '[' repository repositorypath ']' ;
    public final SAFPParser.sectionrepository_return sectionrepository() throws RecognitionException {
        SAFPParser.sectionrepository_return retval = new SAFPParser.sectionrepository_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token char_literal28=null;
        Token char_literal31=null;
        SAFPParser.repository_return repository29 = null;

        SAFPParser.repositorypath_return repositorypath30 = null;


        Object char_literal28_tree=null;
        Object char_literal31_tree=null;

        try {
            // com/soebes/subversion/sapm/parser/SAFP.g:126:5: ( '[' repository repositorypath ']' )
            // com/soebes/subversion/sapm/parser/SAFP.g:126:7: '[' repository repositorypath ']'
            {
            root_0 = (Object)adaptor.nil();

            char_literal28=(Token)match(input,13,FOLLOW_13_in_sectionrepository424); 
            char_literal28_tree = (Object)adaptor.create(char_literal28);
            adaptor.addChild(root_0, char_literal28_tree);

            pushFollow(FOLLOW_repository_in_sectionrepository426);
            repository29=repository();

            state._fsp--;

            adaptor.addChild(root_0, repository29.getTree());
            pushFollow(FOLLOW_repositorypath_in_sectionrepository428);
            repositorypath30=repositorypath();

            state._fsp--;

            adaptor.addChild(root_0, repositorypath30.getTree());
            char_literal31=(Token)match(input,14,FOLLOW_14_in_sectionrepository430); 
            char_literal31_tree = (Object)adaptor.create(char_literal31);
            adaptor.addChild(root_0, char_literal31_tree);


                        if ((repository29!=null?input.toString(repository29.start,repository29.stop):null) == null) {
                          retval.accessRule = new AccessRule((repositorypath30!=null?input.toString(repositorypath30.start,repositorypath30.stop):null));
                        } else {
                          retval.accessRule = new AccessRule((repository29!=null?repository29.repositoryId:null), (repositorypath30!=null?input.toString(repositorypath30.start,repositorypath30.stop):null));
                        }
                    

            }

            retval.stop = input.LT(-1);

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "sectionrepository"

    public static class repository_return extends ParserRuleReturnScope {
        public String repositoryId;;
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "repository"
    // com/soebes/subversion/sapm/parser/SAFP.g:136:1: repository returns [ String repositoryId; ] : ( ID ':' )? ;
    public final SAFPParser.repository_return repository() throws RecognitionException {
        SAFPParser.repository_return retval = new SAFPParser.repository_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token ID32=null;
        Token char_literal33=null;

        Object ID32_tree=null;
        Object char_literal33_tree=null;

        try {
            // com/soebes/subversion/sapm/parser/SAFP.g:137:5: ( ( ID ':' )? )
            // com/soebes/subversion/sapm/parser/SAFP.g:137:7: ( ID ':' )?
            {
            root_0 = (Object)adaptor.nil();

            // com/soebes/subversion/sapm/parser/SAFP.g:137:7: ( ID ':' )?
            int alt8=2;
            switch ( input.LA(1) ) {
                case ID:
                    {
                    alt8=1;
                    }
                    break;
            }

            switch (alt8) {
                case 1 :
                    // com/soebes/subversion/sapm/parser/SAFP.g:137:8: ID ':'
                    {
                    ID32=(Token)match(input,ID,FOLLOW_ID_in_repository462); 
                    ID32_tree = (Object)adaptor.create(ID32);
                    adaptor.addChild(root_0, ID32_tree);

                    char_literal33=(Token)match(input,15,FOLLOW_15_in_repository464); 
                    char_literal33_tree = (Object)adaptor.create(char_literal33);
                    adaptor.addChild(root_0, char_literal33_tree);


                    }
                    break;

            }

             retval.repositoryId = (ID32!=null?ID32.getText():null); 

            }

            retval.stop = input.LT(-1);

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "repository"

    public static class repositorypath_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "repositorypath"
    // com/soebes/subversion/sapm/parser/SAFP.g:140:1: repositorypath : PATH ;
    public final SAFPParser.repositorypath_return repositorypath() throws RecognitionException {
        SAFPParser.repositorypath_return retval = new SAFPParser.repositorypath_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token PATH34=null;

        Object PATH34_tree=null;

        try {
            // com/soebes/subversion/sapm/parser/SAFP.g:141:5: ( PATH )
            // com/soebes/subversion/sapm/parser/SAFP.g:141:7: PATH
            {
            root_0 = (Object)adaptor.nil();

            PATH34=(Token)match(input,PATH,FOLLOW_PATH_in_repositorypath485); 
            PATH34_tree = (Object)adaptor.create(PATH34);
            adaptor.addChild(root_0, PATH34_tree);


            }

            retval.stop = input.LT(-1);

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "repositorypath"

    public static class permissionrule_return extends ParserRuleReturnScope {
        public Access access;;
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "permissionrule"
    // com/soebes/subversion/sapm/parser/SAFP.g:144:1: permissionrule returns [ Access access; ] : ( userpermission | grouppermission | aliaspermission );
    public final SAFPParser.permissionrule_return permissionrule() throws RecognitionException {
        SAFPParser.permissionrule_return retval = new SAFPParser.permissionrule_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        SAFPParser.userpermission_return userpermission35 = null;

        SAFPParser.grouppermission_return grouppermission36 = null;

        SAFPParser.aliaspermission_return aliaspermission37 = null;



        try {
            // com/soebes/subversion/sapm/parser/SAFP.g:145:5: ( userpermission | grouppermission | aliaspermission )
            int alt9=3;
            switch ( input.LA(1) ) {
            case ID:
            case 17:
            case 18:
            case 19:
                {
                alt9=1;
                }
                break;
            case 16:
                {
                switch ( input.LA(2) ) {
                case ID:
                case 17:
                case 18:
                case 19:
                    {
                    alt9=1;
                    }
                    break;
                case 28:
                    {
                    alt9=2;
                    }
                    break;
                case 27:
                    {
                    alt9=3;
                    }
                    break;
                default:
                    NoViableAltException nvae =
                        new NoViableAltException("", 9, 2, input);

                    throw nvae;
                }

                }
                break;
            case 28:
                {
                alt9=2;
                }
                break;
            case 27:
                {
                alt9=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 9, 0, input);

                throw nvae;
            }

            switch (alt9) {
                case 1 :
                    // com/soebes/subversion/sapm/parser/SAFP.g:145:7: userpermission
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_userpermission_in_permissionrule506);
                    userpermission35=userpermission();

                    state._fsp--;

                    adaptor.addChild(root_0, userpermission35.getTree());
                     retval.access = (userpermission35!=null?userpermission35.access:null); 

                    }
                    break;
                case 2 :
                    // com/soebes/subversion/sapm/parser/SAFP.g:146:7: grouppermission
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_grouppermission_in_permissionrule516);
                    grouppermission36=grouppermission();

                    state._fsp--;

                    adaptor.addChild(root_0, grouppermission36.getTree());
                     retval.access = (grouppermission36!=null?grouppermission36.access:null); 

                    }
                    break;
                case 3 :
                    // com/soebes/subversion/sapm/parser/SAFP.g:147:7: aliaspermission
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_aliaspermission_in_permissionrule526);
                    aliaspermission37=aliaspermission();

                    state._fsp--;

                    adaptor.addChild(root_0, aliaspermission37.getTree());
                     retval.access = (aliaspermission37!=null?aliaspermission37.access:null); 

                    }
                    break;

            }
            retval.stop = input.LT(-1);

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "permissionrule"

    public static class userpermission_return extends ParserRuleReturnScope {
        public Access access;;
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "userpermission"
    // com/soebes/subversion/sapm/parser/SAFP.g:150:1: userpermission returns [ Access access; ] : ( user EQUAL permission | '~' user EQUAL permission );
    public final SAFPParser.userpermission_return userpermission() throws RecognitionException {
        SAFPParser.userpermission_return retval = new SAFPParser.userpermission_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token EQUAL39=null;
        Token char_literal41=null;
        Token EQUAL43=null;
        SAFPParser.user_return user38 = null;

        SAFPParser.permission_return permission40 = null;

        SAFPParser.user_return user42 = null;

        SAFPParser.permission_return permission44 = null;


        Object EQUAL39_tree=null;
        Object char_literal41_tree=null;
        Object EQUAL43_tree=null;

        try {
            // com/soebes/subversion/sapm/parser/SAFP.g:151:5: ( user EQUAL permission | '~' user EQUAL permission )
            int alt10=2;
            switch ( input.LA(1) ) {
            case ID:
            case 17:
            case 18:
            case 19:
                {
                alt10=1;
                }
                break;
            case 16:
                {
                alt10=2;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 10, 0, input);

                throw nvae;
            }

            switch (alt10) {
                case 1 :
                    // com/soebes/subversion/sapm/parser/SAFP.g:151:7: user EQUAL permission
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_user_in_userpermission549);
                    user38=user();

                    state._fsp--;

                    adaptor.addChild(root_0, user38.getTree());
                    EQUAL39=(Token)match(input,EQUAL,FOLLOW_EQUAL_in_userpermission551); 
                    EQUAL39_tree = (Object)adaptor.create(EQUAL39);
                    adaptor.addChild(root_0, EQUAL39_tree);

                    pushFollow(FOLLOW_permission_in_userpermission553);
                    permission40=permission();

                    state._fsp--;

                    adaptor.addChild(root_0, permission40.getTree());

                                User userInstance = UserFactory.createInstance((user38!=null?input.toString(user38.start,user38.stop):null));
                                retval.access = new Access(userInstance, (permission40!=null?permission40.perm:null));
                            

                    }
                    break;
                case 2 :
                    // com/soebes/subversion/sapm/parser/SAFP.g:156:7: '~' user EQUAL permission
                    {
                    root_0 = (Object)adaptor.nil();

                    char_literal41=(Token)match(input,16,FOLLOW_16_in_userpermission571); 
                    char_literal41_tree = (Object)adaptor.create(char_literal41);
                    adaptor.addChild(root_0, char_literal41_tree);

                    pushFollow(FOLLOW_user_in_userpermission573);
                    user42=user();

                    state._fsp--;

                    adaptor.addChild(root_0, user42.getTree());
                    EQUAL43=(Token)match(input,EQUAL,FOLLOW_EQUAL_in_userpermission575); 
                    EQUAL43_tree = (Object)adaptor.create(EQUAL43);
                    adaptor.addChild(root_0, EQUAL43_tree);

                    pushFollow(FOLLOW_permission_in_userpermission577);
                    permission44=permission();

                    state._fsp--;

                    adaptor.addChild(root_0, permission44.getTree());

                                User userInstance = UserFactory.createInstance((user42!=null?input.toString(user42.start,user42.stop):null));
                                retval.access = new Access(userInstance, (permission44!=null?permission44.perm:null), true);
                            

                    }
                    break;

            }
            retval.stop = input.LT(-1);

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "userpermission"

    public static class grouppermission_return extends ParserRuleReturnScope {
        public Access access;;
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "grouppermission"
    // com/soebes/subversion/sapm/parser/SAFP.g:163:1: grouppermission returns [ Access access; ] : ( groupreference EQUAL permission | '~' groupreference EQUAL permission );
    public final SAFPParser.grouppermission_return grouppermission() throws RecognitionException {
        SAFPParser.grouppermission_return retval = new SAFPParser.grouppermission_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token EQUAL46=null;
        Token char_literal48=null;
        Token EQUAL50=null;
        SAFPParser.groupreference_return groupreference45 = null;

        SAFPParser.permission_return permission47 = null;

        SAFPParser.groupreference_return groupreference49 = null;

        SAFPParser.permission_return permission51 = null;


        Object EQUAL46_tree=null;
        Object char_literal48_tree=null;
        Object EQUAL50_tree=null;

        try {
            // com/soebes/subversion/sapm/parser/SAFP.g:164:5: ( groupreference EQUAL permission | '~' groupreference EQUAL permission )
            int alt11=2;
            switch ( input.LA(1) ) {
            case 28:
                {
                alt11=1;
                }
                break;
            case 16:
                {
                alt11=2;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 11, 0, input);

                throw nvae;
            }

            switch (alt11) {
                case 1 :
                    // com/soebes/subversion/sapm/parser/SAFP.g:164:7: groupreference EQUAL permission
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_groupreference_in_grouppermission608);
                    groupreference45=groupreference();

                    state._fsp--;

                    adaptor.addChild(root_0, groupreference45.getTree());
                    EQUAL46=(Token)match(input,EQUAL,FOLLOW_EQUAL_in_grouppermission610); 
                    EQUAL46_tree = (Object)adaptor.create(EQUAL46);
                    adaptor.addChild(root_0, EQUAL46_tree);

                    pushFollow(FOLLOW_permission_in_grouppermission612);
                    permission47=permission();

                    state._fsp--;

                    adaptor.addChild(root_0, permission47.getTree());

                                IPrincipal groupInstance = getGroups().getGroup((groupreference45!=null?groupreference45.refId:null));
                                retval.access = new Access(groupInstance, (permission47!=null?permission47.perm:null));
                            

                    }
                    break;
                case 2 :
                    // com/soebes/subversion/sapm/parser/SAFP.g:169:7: '~' groupreference EQUAL permission
                    {
                    root_0 = (Object)adaptor.nil();

                    char_literal48=(Token)match(input,16,FOLLOW_16_in_grouppermission630); 
                    char_literal48_tree = (Object)adaptor.create(char_literal48);
                    adaptor.addChild(root_0, char_literal48_tree);

                    pushFollow(FOLLOW_groupreference_in_grouppermission632);
                    groupreference49=groupreference();

                    state._fsp--;

                    adaptor.addChild(root_0, groupreference49.getTree());
                    EQUAL50=(Token)match(input,EQUAL,FOLLOW_EQUAL_in_grouppermission634); 
                    EQUAL50_tree = (Object)adaptor.create(EQUAL50);
                    adaptor.addChild(root_0, EQUAL50_tree);

                    pushFollow(FOLLOW_permission_in_grouppermission636);
                    permission51=permission();

                    state._fsp--;

                    adaptor.addChild(root_0, permission51.getTree());

                                IPrincipal groupInstance = getGroups().getGroup((groupreference49!=null?groupreference49.refId:null));
                                retval.access = new Access(groupInstance, (permission51!=null?permission51.perm:null), true);
                            

                    }
                    break;

            }
            retval.stop = input.LT(-1);

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "grouppermission"

    public static class aliaspermission_return extends ParserRuleReturnScope {
        public Access access;;
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "aliaspermission"
    // com/soebes/subversion/sapm/parser/SAFP.g:176:1: aliaspermission returns [ Access access; ] : ( aliasreference EQUAL permission | '~' aliasreference EQUAL permission );
    public final SAFPParser.aliaspermission_return aliaspermission() throws RecognitionException {
        SAFPParser.aliaspermission_return retval = new SAFPParser.aliaspermission_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token EQUAL53=null;
        Token char_literal55=null;
        Token EQUAL57=null;
        SAFPParser.aliasreference_return aliasreference52 = null;

        SAFPParser.permission_return permission54 = null;

        SAFPParser.aliasreference_return aliasreference56 = null;

        SAFPParser.permission_return permission58 = null;


        Object EQUAL53_tree=null;
        Object char_literal55_tree=null;
        Object EQUAL57_tree=null;

        try {
            // com/soebes/subversion/sapm/parser/SAFP.g:177:5: ( aliasreference EQUAL permission | '~' aliasreference EQUAL permission )
            int alt12=2;
            switch ( input.LA(1) ) {
            case 27:
                {
                alt12=1;
                }
                break;
            case 16:
                {
                alt12=2;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 12, 0, input);

                throw nvae;
            }

            switch (alt12) {
                case 1 :
                    // com/soebes/subversion/sapm/parser/SAFP.g:177:7: aliasreference EQUAL permission
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_aliasreference_in_aliaspermission667);
                    aliasreference52=aliasreference();

                    state._fsp--;

                    adaptor.addChild(root_0, aliasreference52.getTree());
                    EQUAL53=(Token)match(input,EQUAL,FOLLOW_EQUAL_in_aliaspermission669); 
                    EQUAL53_tree = (Object)adaptor.create(EQUAL53);
                    adaptor.addChild(root_0, EQUAL53_tree);

                    pushFollow(FOLLOW_permission_in_aliaspermission671);
                    permission54=permission();

                    state._fsp--;

                    adaptor.addChild(root_0, permission54.getTree());

                                IPrincipal aliasInstance = getAliases().getAlias((aliasreference52!=null?aliasreference52.refId:null));
                                retval.access = new Access(aliasInstance, (permission54!=null?permission54.perm:null));
                            

                    }
                    break;
                case 2 :
                    // com/soebes/subversion/sapm/parser/SAFP.g:182:7: '~' aliasreference EQUAL permission
                    {
                    root_0 = (Object)adaptor.nil();

                    char_literal55=(Token)match(input,16,FOLLOW_16_in_aliaspermission689); 
                    char_literal55_tree = (Object)adaptor.create(char_literal55);
                    adaptor.addChild(root_0, char_literal55_tree);

                    pushFollow(FOLLOW_aliasreference_in_aliaspermission691);
                    aliasreference56=aliasreference();

                    state._fsp--;

                    adaptor.addChild(root_0, aliasreference56.getTree());
                    EQUAL57=(Token)match(input,EQUAL,FOLLOW_EQUAL_in_aliaspermission693); 
                    EQUAL57_tree = (Object)adaptor.create(EQUAL57);
                    adaptor.addChild(root_0, EQUAL57_tree);

                    pushFollow(FOLLOW_permission_in_aliaspermission695);
                    permission58=permission();

                    state._fsp--;

                    adaptor.addChild(root_0, permission58.getTree());

                                IPrincipal aliasInstance = getAliases().getAlias((aliasreference56!=null?aliasreference56.refId:null));
                                retval.access = new Access(aliasInstance, (permission58!=null?permission58.perm:null), true);
                            

                    }
                    break;

            }
            retval.stop = input.LT(-1);

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "aliaspermission"

    public static class user_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "user"
    // com/soebes/subversion/sapm/parser/SAFP.g:189:1: user : ( ID | '*' | '$authenticated' | '$anonymous' ) ;
    public final SAFPParser.user_return user() throws RecognitionException {
        SAFPParser.user_return retval = new SAFPParser.user_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token set59=null;

        Object set59_tree=null;

        try {
            // com/soebes/subversion/sapm/parser/SAFP.g:190:5: ( ( ID | '*' | '$authenticated' | '$anonymous' ) )
            // com/soebes/subversion/sapm/parser/SAFP.g:190:7: ( ID | '*' | '$authenticated' | '$anonymous' )
            {
            root_0 = (Object)adaptor.nil();

            set59=(Token)input.LT(1);
            if ( input.LA(1)==ID||(input.LA(1)>=17 && input.LA(1)<=19) ) {
                input.consume();
                adaptor.addChild(root_0, (Object)adaptor.create(set59));
                state.errorRecovery=false;
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
            }


            }

            retval.stop = input.LT(-1);

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "user"

    public static class permission_return extends ParserRuleReturnScope {
        public AccessLevel perm;;
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "permission"
    // com/soebes/subversion/sapm/parser/SAFP.g:193:1: permission returns [ AccessLevel perm; ] : ( permission_read | permission_read_write | permission_nothing );
    public final SAFPParser.permission_return permission() throws RecognitionException {
        SAFPParser.permission_return retval = new SAFPParser.permission_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        SAFPParser.permission_read_return permission_read60 = null;

        SAFPParser.permission_read_write_return permission_read_write61 = null;

        SAFPParser.permission_nothing_return permission_nothing62 = null;



         retval.perm = AccessLevel.NOTHING; 
        try {
            // com/soebes/subversion/sapm/parser/SAFP.g:194:5: ( permission_read | permission_read_write | permission_nothing )
            int alt13=3;
            switch ( input.LA(1) ) {
            case 20:
            case 21:
                {
                alt13=1;
                }
                break;
            case 24:
            case 25:
                {
                alt13=2;
                }
                break;
            case NL:
                {
                alt13=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 13, 0, input);

                throw nvae;
            }

            switch (alt13) {
                case 1 :
                    // com/soebes/subversion/sapm/parser/SAFP.g:194:7: permission_read
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_permission_read_in_permission756);
                    permission_read60=permission_read();

                    state._fsp--;

                    adaptor.addChild(root_0, permission_read60.getTree());
                     retval.perm = AccessLevel.READ; 

                    }
                    break;
                case 2 :
                    // com/soebes/subversion/sapm/parser/SAFP.g:195:7: permission_read_write
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_permission_read_write_in_permission766);
                    permission_read_write61=permission_read_write();

                    state._fsp--;

                    adaptor.addChild(root_0, permission_read_write61.getTree());
                     retval.perm = AccessLevel.READ_WRITE; 

                    }
                    break;
                case 3 :
                    // com/soebes/subversion/sapm/parser/SAFP.g:196:7: permission_nothing
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_permission_nothing_in_permission776);
                    permission_nothing62=permission_nothing();

                    state._fsp--;

                    adaptor.addChild(root_0, permission_nothing62.getTree());

                    }
                    break;

            }
            retval.stop = input.LT(-1);

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "permission"

    public static class permission_read_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "permission_read"
    // com/soebes/subversion/sapm/parser/SAFP.g:199:1: permission_read : ( 'r' | 'R' );
    public final SAFPParser.permission_read_return permission_read() throws RecognitionException {
        SAFPParser.permission_read_return retval = new SAFPParser.permission_read_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token set63=null;

        Object set63_tree=null;

        try {
            // com/soebes/subversion/sapm/parser/SAFP.g:200:5: ( 'r' | 'R' )
            // com/soebes/subversion/sapm/parser/SAFP.g:
            {
            root_0 = (Object)adaptor.nil();

            set63=(Token)input.LT(1);
            if ( (input.LA(1)>=20 && input.LA(1)<=21) ) {
                input.consume();
                adaptor.addChild(root_0, (Object)adaptor.create(set63));
                state.errorRecovery=false;
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
            }


            }

            retval.stop = input.LT(-1);

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "permission_read"

    public static class permission_write_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "permission_write"
    // com/soebes/subversion/sapm/parser/SAFP.g:204:1: permission_write : ( 'w' | 'W' );
    public final SAFPParser.permission_write_return permission_write() throws RecognitionException {
        SAFPParser.permission_write_return retval = new SAFPParser.permission_write_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token set64=null;

        Object set64_tree=null;

        try {
            // com/soebes/subversion/sapm/parser/SAFP.g:205:5: ( 'w' | 'W' )
            // com/soebes/subversion/sapm/parser/SAFP.g:
            {
            root_0 = (Object)adaptor.nil();

            set64=(Token)input.LT(1);
            if ( (input.LA(1)>=22 && input.LA(1)<=23) ) {
                input.consume();
                adaptor.addChild(root_0, (Object)adaptor.create(set64));
                state.errorRecovery=false;
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
            }


            }

            retval.stop = input.LT(-1);

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "permission_write"

    public static class permission_read_write_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "permission_read_write"
    // com/soebes/subversion/sapm/parser/SAFP.g:209:1: permission_read_write : ( 'rw' | 'RW' );
    public final SAFPParser.permission_read_write_return permission_read_write() throws RecognitionException {
        SAFPParser.permission_read_write_return retval = new SAFPParser.permission_read_write_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token set65=null;

        Object set65_tree=null;

        try {
            // com/soebes/subversion/sapm/parser/SAFP.g:210:5: ( 'rw' | 'RW' )
            // com/soebes/subversion/sapm/parser/SAFP.g:
            {
            root_0 = (Object)adaptor.nil();

            set65=(Token)input.LT(1);
            if ( (input.LA(1)>=24 && input.LA(1)<=25) ) {
                input.consume();
                adaptor.addChild(root_0, (Object)adaptor.create(set65));
                state.errorRecovery=false;
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
            }


            }

            retval.stop = input.LT(-1);

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "permission_read_write"

    public static class permission_nothing_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "permission_nothing"
    // com/soebes/subversion/sapm/parser/SAFP.g:214:1: permission_nothing : NL ;
    public final SAFPParser.permission_nothing_return permission_nothing() throws RecognitionException {
        SAFPParser.permission_nothing_return retval = new SAFPParser.permission_nothing_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token NL66=null;

        Object NL66_tree=null;

        try {
            // com/soebes/subversion/sapm/parser/SAFP.g:215:5: ( NL )
            // com/soebes/subversion/sapm/parser/SAFP.g:215:7: NL
            {
            root_0 = (Object)adaptor.nil();

            NL66=(Token)match(input,NL,FOLLOW_NL_in_permission_nothing868); 
            NL66_tree = (Object)adaptor.create(NL66);
            adaptor.addChild(root_0, NL66_tree);


            }

            retval.stop = input.LT(-1);

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "permission_nothing"

    public static class useraliasdefinition_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "useraliasdefinition"
    // com/soebes/subversion/sapm/parser/SAFP.g:218:1: useraliasdefinition : useralias ( ',' useralias )* ;
    public final SAFPParser.useraliasdefinition_return useraliasdefinition() throws RecognitionException {
        SAFPParser.useraliasdefinition_return retval = new SAFPParser.useraliasdefinition_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token char_literal68=null;
        SAFPParser.useralias_return useralias67 = null;

        SAFPParser.useralias_return useralias69 = null;


        Object char_literal68_tree=null;

        try {
            // com/soebes/subversion/sapm/parser/SAFP.g:219:5: ( useralias ( ',' useralias )* )
            // com/soebes/subversion/sapm/parser/SAFP.g:219:7: useralias ( ',' useralias )*
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_useralias_in_useraliasdefinition885);
            useralias67=useralias();

            state._fsp--;

            adaptor.addChild(root_0, useralias67.getTree());
            // com/soebes/subversion/sapm/parser/SAFP.g:219:17: ( ',' useralias )*
            loop14:
            do {
                int alt14=2;
                switch ( input.LA(1) ) {
                case 26:
                    {
                    alt14=1;
                    }
                    break;

                }

                switch (alt14) {
            	case 1 :
            	    // com/soebes/subversion/sapm/parser/SAFP.g:219:18: ',' useralias
            	    {
            	    char_literal68=(Token)match(input,26,FOLLOW_26_in_useraliasdefinition888); 
            	    char_literal68_tree = (Object)adaptor.create(char_literal68);
            	    adaptor.addChild(root_0, char_literal68_tree);

            	    pushFollow(FOLLOW_useralias_in_useraliasdefinition890);
            	    useralias69=useralias();

            	    state._fsp--;

            	    adaptor.addChild(root_0, useralias69.getTree());

            	    }
            	    break;

            	default :
            	    break loop14;
                }
            } while (true);


            }

            retval.stop = input.LT(-1);

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "useraliasdefinition"

    public static class useralias_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "useralias"
    // com/soebes/subversion/sapm/parser/SAFP.g:222:1: useralias : ID EQUAL ( ID )+ ;
    public final SAFPParser.useralias_return useralias() throws RecognitionException {
        SAFPParser.useralias_return retval = new SAFPParser.useralias_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token ID70=null;
        Token EQUAL71=null;
        Token ID72=null;

        Object ID70_tree=null;
        Object EQUAL71_tree=null;
        Object ID72_tree=null;

        try {
            // com/soebes/subversion/sapm/parser/SAFP.g:223:5: ( ID EQUAL ( ID )+ )
            // com/soebes/subversion/sapm/parser/SAFP.g:223:7: ID EQUAL ( ID )+
            {
            root_0 = (Object)adaptor.nil();

            ID70=(Token)match(input,ID,FOLLOW_ID_in_useralias909); 
            ID70_tree = (Object)adaptor.create(ID70);
            adaptor.addChild(root_0, ID70_tree);

            EQUAL71=(Token)match(input,EQUAL,FOLLOW_EQUAL_in_useralias911); 
            EQUAL71_tree = (Object)adaptor.create(EQUAL71);
            adaptor.addChild(root_0, EQUAL71_tree);

            // com/soebes/subversion/sapm/parser/SAFP.g:223:16: ( ID )+
            int cnt15=0;
            loop15:
            do {
                int alt15=2;
                switch ( input.LA(1) ) {
                case ID:
                    {
                    alt15=1;
                    }
                    break;

                }

                switch (alt15) {
            	case 1 :
            	    // com/soebes/subversion/sapm/parser/SAFP.g:223:17: ID
            	    {
            	    ID72=(Token)match(input,ID,FOLLOW_ID_in_useralias914); 
            	    ID72_tree = (Object)adaptor.create(ID72);
            	    adaptor.addChild(root_0, ID72_tree);


            	    }
            	    break;

            	default :
            	    if ( cnt15 >= 1 ) break loop15;
                        EarlyExitException eee =
                            new EarlyExitException(15, input);
                        throw eee;
                }
                cnt15++;
            } while (true);


            }

            retval.stop = input.LT(-1);

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "useralias"

    public static class groupuserdefinition_return extends ParserRuleReturnScope {
        public ArrayList<IPrincipal> gud;;
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "groupuserdefinition"
    // com/soebes/subversion/sapm/parser/SAFP.g:226:1: groupuserdefinition returns [ArrayList<IPrincipal> gud; ] : groupref1= groupuserreference ( ',' groupreffollow= groupuserreference )* ;
    public final SAFPParser.groupuserdefinition_return groupuserdefinition() throws RecognitionException {
        SAFPParser.groupuserdefinition_return retval = new SAFPParser.groupuserdefinition_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token char_literal73=null;
        SAFPParser.groupuserreference_return groupref1 = null;

        SAFPParser.groupuserreference_return groupreffollow = null;


        Object char_literal73_tree=null;

         retval.gud = new ArrayList<IPrincipal>(); 
        try {
            // com/soebes/subversion/sapm/parser/SAFP.g:227:5: (groupref1= groupuserreference ( ',' groupreffollow= groupuserreference )* )
            // com/soebes/subversion/sapm/parser/SAFP.g:227:7: groupref1= groupuserreference ( ',' groupreffollow= groupuserreference )*
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_groupuserreference_in_groupuserdefinition944);
            groupref1=groupuserreference();

            state._fsp--;

            adaptor.addChild(root_0, groupref1.getTree());
             retval.gud.add((groupref1!=null?groupref1.principal:null)); 
            // com/soebes/subversion/sapm/parser/SAFP.g:228:9: ( ',' groupreffollow= groupuserreference )*
            loop16:
            do {
                int alt16=2;
                switch ( input.LA(1) ) {
                case 26:
                    {
                    alt16=1;
                    }
                    break;

                }

                switch (alt16) {
            	case 1 :
            	    // com/soebes/subversion/sapm/parser/SAFP.g:228:11: ',' groupreffollow= groupuserreference
            	    {
            	    char_literal73=(Token)match(input,26,FOLLOW_26_in_groupuserdefinition958); 
            	    char_literal73_tree = (Object)adaptor.create(char_literal73);
            	    adaptor.addChild(root_0, char_literal73_tree);

            	    pushFollow(FOLLOW_groupuserreference_in_groupuserdefinition962);
            	    groupreffollow=groupuserreference();

            	    state._fsp--;

            	    adaptor.addChild(root_0, groupreffollow.getTree());
            	     retval.gud.add((groupreffollow!=null?groupreffollow.principal:null)); 

            	    }
            	    break;

            	default :
            	    break loop16;
                }
            } while (true);


            }

            retval.stop = input.LT(-1);

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "groupuserdefinition"

    public static class groupuserreference_return extends ParserRuleReturnScope {
        public IPrincipal principal;;
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "groupuserreference"
    // com/soebes/subversion/sapm/parser/SAFP.g:231:1: groupuserreference returns [ IPrincipal principal; ] : ( aliasreference | groupreference | userreference );
    public final SAFPParser.groupuserreference_return groupuserreference() throws RecognitionException {
        SAFPParser.groupuserreference_return retval = new SAFPParser.groupuserreference_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        SAFPParser.aliasreference_return aliasreference74 = null;

        SAFPParser.groupreference_return groupreference75 = null;

        SAFPParser.userreference_return userreference76 = null;



        try {
            // com/soebes/subversion/sapm/parser/SAFP.g:232:5: ( aliasreference | groupreference | userreference )
            int alt17=3;
            switch ( input.LA(1) ) {
            case 27:
                {
                alt17=1;
                }
                break;
            case 28:
                {
                alt17=2;
                }
                break;
            case ID:
                {
                alt17=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 17, 0, input);

                throw nvae;
            }

            switch (alt17) {
                case 1 :
                    // com/soebes/subversion/sapm/parser/SAFP.g:232:7: aliasreference
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_aliasreference_in_groupuserreference988);
                    aliasreference74=aliasreference();

                    state._fsp--;

                    adaptor.addChild(root_0, aliasreference74.getTree());
                     retval.principal = getAliases().getAlias((aliasreference74!=null?aliasreference74.refId:null)); 

                    }
                    break;
                case 2 :
                    // com/soebes/subversion/sapm/parser/SAFP.g:233:7: groupreference
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_groupreference_in_groupuserreference998);
                    groupreference75=groupreference();

                    state._fsp--;

                    adaptor.addChild(root_0, groupreference75.getTree());
                     retval.principal = getGroups().getGroup((groupreference75!=null?groupreference75.refId:null)); 

                    }
                    break;
                case 3 :
                    // com/soebes/subversion/sapm/parser/SAFP.g:234:7: userreference
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_userreference_in_groupuserreference1008);
                    userreference76=userreference();

                    state._fsp--;

                    adaptor.addChild(root_0, userreference76.getTree());
                     retval.principal = new User((userreference76!=null?userreference76.refId:null)); 

                    }
                    break;

            }
            retval.stop = input.LT(-1);

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "groupuserreference"

    public static class aliasreference_return extends ParserRuleReturnScope {
        public String refId;;
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "aliasreference"
    // com/soebes/subversion/sapm/parser/SAFP.g:237:1: aliasreference returns [ String refId; ] : '&' ID ;
    public final SAFPParser.aliasreference_return aliasreference() throws RecognitionException {
        SAFPParser.aliasreference_return retval = new SAFPParser.aliasreference_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token char_literal77=null;
        Token ID78=null;

        Object char_literal77_tree=null;
        Object ID78_tree=null;

        try {
            // com/soebes/subversion/sapm/parser/SAFP.g:238:5: ( '&' ID )
            // com/soebes/subversion/sapm/parser/SAFP.g:238:7: '&' ID
            {
            root_0 = (Object)adaptor.nil();

            char_literal77=(Token)match(input,27,FOLLOW_27_in_aliasreference1031); 
            char_literal77_tree = (Object)adaptor.create(char_literal77);
            adaptor.addChild(root_0, char_literal77_tree);

            ID78=(Token)match(input,ID,FOLLOW_ID_in_aliasreference1033); 
            ID78_tree = (Object)adaptor.create(ID78);
            adaptor.addChild(root_0, ID78_tree);

             retval.refId = (ID78!=null?ID78.getText():null); 

            }

            retval.stop = input.LT(-1);

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "aliasreference"

    public static class groupreference_return extends ParserRuleReturnScope {
        public String refId;;
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "groupreference"
    // com/soebes/subversion/sapm/parser/SAFP.g:241:1: groupreference returns [ String refId; ] : '@' ID ;
    public final SAFPParser.groupreference_return groupreference() throws RecognitionException {
        SAFPParser.groupreference_return retval = new SAFPParser.groupreference_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token char_literal79=null;
        Token ID80=null;

        Object char_literal79_tree=null;
        Object ID80_tree=null;

        try {
            // com/soebes/subversion/sapm/parser/SAFP.g:242:5: ( '@' ID )
            // com/soebes/subversion/sapm/parser/SAFP.g:242:7: '@' ID
            {
            root_0 = (Object)adaptor.nil();

            char_literal79=(Token)match(input,28,FOLLOW_28_in_groupreference1056); 
            char_literal79_tree = (Object)adaptor.create(char_literal79);
            adaptor.addChild(root_0, char_literal79_tree);

            ID80=(Token)match(input,ID,FOLLOW_ID_in_groupreference1058); 
            ID80_tree = (Object)adaptor.create(ID80);
            adaptor.addChild(root_0, ID80_tree);

             retval.refId = (ID80!=null?ID80.getText():null); 

            }

            retval.stop = input.LT(-1);

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "groupreference"

    public static class userreference_return extends ParserRuleReturnScope {
        public String refId;;
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "userreference"
    // com/soebes/subversion/sapm/parser/SAFP.g:245:1: userreference returns [ String refId;] : ID ;
    public final SAFPParser.userreference_return userreference() throws RecognitionException {
        SAFPParser.userreference_return retval = new SAFPParser.userreference_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token ID81=null;

        Object ID81_tree=null;

        try {
            // com/soebes/subversion/sapm/parser/SAFP.g:246:5: ( ID )
            // com/soebes/subversion/sapm/parser/SAFP.g:246:7: ID
            {
            root_0 = (Object)adaptor.nil();

            ID81=(Token)match(input,ID,FOLLOW_ID_in_userreference1081); 
            ID81_tree = (Object)adaptor.create(ID81);
            adaptor.addChild(root_0, ID81_tree);

             retval.refId = (ID81!=null?ID81.getText():null); 

            }

            retval.stop = input.LT(-1);

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "userreference"

    // Delegated rules


 

    public static final BitSet FOLLOW_statement_in_prog75 = new BitSet(new long[]{0x0000000000002002L});
    public static final BitSet FOLLOW_groups_in_statement89 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_repos_in_statement97 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_aliases_in_statement107 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_sectiongroup_in_groups124 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_NL_in_groups126 = new BitSet(new long[]{0x0000000000000042L});
    public static final BitSet FOLLOW_group_in_groups129 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_EQUAL_in_groups131 = new BitSet(new long[]{0x0000000018000040L});
    public static final BitSet FOLLOW_groupuserdefinition_in_groups133 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_NL_in_groups153 = new BitSet(new long[]{0x0000000000000042L});
    public static final BitSet FOLLOW_sectionrepository_in_repos178 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_NL_in_repos180 = new BitSet(new long[]{0x00000000180F0040L});
    public static final BitSet FOLLOW_permissionrule_in_repos192 = new BitSet(new long[]{0x00000000180F0052L});
    public static final BitSet FOLLOW_NL_in_repos196 = new BitSet(new long[]{0x00000000180F0042L});
    public static final BitSet FOLLOW_permissionrule_in_repos223 = new BitSet(new long[]{0x00000000180F0052L});
    public static final BitSet FOLLOW_NL_in_repos239 = new BitSet(new long[]{0x00000000180F0042L});
    public static final BitSet FOLLOW_sectionaliases_in_aliases270 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_NL_in_aliases272 = new BitSet(new long[]{0x0000000000000042L});
    public static final BitSet FOLLOW_alias_in_aliases296 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_EQUAL_in_aliases298 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_useraliasdefinition_in_aliases300 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_NL_in_aliases302 = new BitSet(new long[]{0x0000000000000042L});
    public static final BitSet FOLLOW_ID_in_group344 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_alias361 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_13_in_sectiongroup378 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_GROUPS_in_sectiongroup380 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_sectiongroup382 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_13_in_sectionaliases399 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_ALIASES_in_sectionaliases401 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_sectionaliases403 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_13_in_sectionrepository424 = new BitSet(new long[]{0x0000000000000240L});
    public static final BitSet FOLLOW_repository_in_sectionrepository426 = new BitSet(new long[]{0x0000000000000240L});
    public static final BitSet FOLLOW_repositorypath_in_sectionrepository428 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_sectionrepository430 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_repository462 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_repository464 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PATH_in_repositorypath485 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_userpermission_in_permissionrule506 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_grouppermission_in_permissionrule516 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_aliaspermission_in_permissionrule526 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_user_in_userpermission549 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_EQUAL_in_userpermission551 = new BitSet(new long[]{0x0000000003300010L});
    public static final BitSet FOLLOW_permission_in_userpermission553 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_16_in_userpermission571 = new BitSet(new long[]{0x00000000000E0040L});
    public static final BitSet FOLLOW_user_in_userpermission573 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_EQUAL_in_userpermission575 = new BitSet(new long[]{0x0000000003300010L});
    public static final BitSet FOLLOW_permission_in_userpermission577 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_groupreference_in_grouppermission608 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_EQUAL_in_grouppermission610 = new BitSet(new long[]{0x0000000003300010L});
    public static final BitSet FOLLOW_permission_in_grouppermission612 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_16_in_grouppermission630 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_groupreference_in_grouppermission632 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_EQUAL_in_grouppermission634 = new BitSet(new long[]{0x0000000003300010L});
    public static final BitSet FOLLOW_permission_in_grouppermission636 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_aliasreference_in_aliaspermission667 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_EQUAL_in_aliaspermission669 = new BitSet(new long[]{0x0000000003300010L});
    public static final BitSet FOLLOW_permission_in_aliaspermission671 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_16_in_aliaspermission689 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_aliasreference_in_aliaspermission691 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_EQUAL_in_aliaspermission693 = new BitSet(new long[]{0x0000000003300010L});
    public static final BitSet FOLLOW_permission_in_aliaspermission695 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_user722 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_permission_read_in_permission756 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_permission_read_write_in_permission766 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_permission_nothing_in_permission776 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_permission_read0 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_permission_write0 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_permission_read_write0 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NL_in_permission_nothing868 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_useralias_in_useraliasdefinition885 = new BitSet(new long[]{0x0000000004000002L});
    public static final BitSet FOLLOW_26_in_useraliasdefinition888 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_useralias_in_useraliasdefinition890 = new BitSet(new long[]{0x0000000004000002L});
    public static final BitSet FOLLOW_ID_in_useralias909 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_EQUAL_in_useralias911 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_ID_in_useralias914 = new BitSet(new long[]{0x0000000000000042L});
    public static final BitSet FOLLOW_groupuserreference_in_groupuserdefinition944 = new BitSet(new long[]{0x0000000004000002L});
    public static final BitSet FOLLOW_26_in_groupuserdefinition958 = new BitSet(new long[]{0x0000000018000040L});
    public static final BitSet FOLLOW_groupuserreference_in_groupuserdefinition962 = new BitSet(new long[]{0x0000000004000002L});
    public static final BitSet FOLLOW_aliasreference_in_groupuserreference988 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_groupreference_in_groupuserreference998 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_userreference_in_groupuserreference1008 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_27_in_aliasreference1031 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_ID_in_aliasreference1033 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_28_in_groupreference1056 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_ID_in_groupreference1058 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_userreference1081 = new BitSet(new long[]{0x0000000000000002L});

}