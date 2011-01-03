/**
 * The Subversion Authentication Parse Module (SAPM for short).
 *
 * Copyright (c) 2010, 2011 by SoftwareEntwicklung Beratung Schulung (SoEBeS)
 * Copyright (c) 2010, 2011 by Karl Heinz Marbaise
 *
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.soebes.subversion.sapm;

import java.io.FileInputStream;
import java.io.IOException;

import org.antlr.runtime.ANTLRInputStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.tree.Tree;
import org.testng.annotations.Test;

import com.soebes.subversion.sapm.parser.SAFPLexer;
import com.soebes.subversion.sapm.parser.SAFPParser;

/**
 *
 *
 *<pre>
 * [/] = r
 *
 * [aliases]
 * harry = CN=Harold Hacker,OU=Engineers,DC=red-bean,DC=com
 * sally = CN=Sally Swatterbug,OU=Engineers,DC=red-bean,DC=com
 * joe = CN=Gerald I. Joseph,OU=Engineers,DC=red-bean,DC=com
 *
 * [groups]
 * calc-developers = &harry, &sally, &joe
 * paint-developers = &frank,&sally, &jane
 * everyone = @calc-developers, @paint-developers
 *
 * [groups]
 * calc-developers = harry, sally, joe
 * paint-developers = frank, sally, jane
 * everyone = @calc-developers, @paint-developers
 *
 * [calc:/projects/calc]
 * @calc-developers = rw
 *
 * [paint:/projects/paint] jane = r
 * @paint-developers = rw
 * </pre>
 */
public class AppTest extends TestBase {

    @Test
    public void testReadOne() throws IOException, RecognitionException {
        FileInputStream fis = new FileInputStream(
                getFileResource("/svnaccess-1.conf"));
        ANTLRInputStream stream = new ANTLRInputStream(fis);
        SAFPLexer lexer = new SAFPLexer(stream);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        SAFPParser parser = new SAFPParser(tokens);
        parser.prog();
    }

    @Test
    public void testReadTwo() throws IOException, RecognitionException {
        FileInputStream fis = new FileInputStream(
                getFileResource("/svnaccess-2.conf"));
        ANTLRInputStream stream = new ANTLRInputStream(fis);
        SAFPLexer lexer = new SAFPLexer(stream);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        SAFPParser parser = new SAFPParser(tokens);
        parser.prog();

    }

    @Test
    public void testReadThree() throws IOException, RecognitionException {
        FileInputStream fis = new FileInputStream(
                getFileResource("/svnaccess-3.conf"));
        ANTLRInputStream stream = new ANTLRInputStream(fis);
        SAFPLexer lexer = new SAFPLexer(stream);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        SAFPParser parser = new SAFPParser(tokens);
        parser.prog();
    }

    @Test
    public void testReadAST() throws IOException, RecognitionException {
        FileInputStream fis = new FileInputStream(
                getFileResource("/svnaccess-3.conf"));
        ANTLRInputStream stream = new ANTLRInputStream(fis);
        SAFPLexer lexer = new SAFPLexer(stream);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        SAFPParser parser = new SAFPParser(tokens);
        SAFPParser.prog_return result = parser.prog();
        Tree t = (Tree) result.getTree();
        //System.out.println("AST:" + t.toStringTree());
    }

    @Test
    public void firstConfigurationTest() throws IOException, RecognitionException {
        FileInputStream fis = new FileInputStream(
                getFileResource("/svnaccess-first.conf"));
        ANTLRInputStream stream = new ANTLRInputStream(fis);
        SAFPLexer lexer = new SAFPLexer(stream);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        SAFPParser parser = new SAFPParser(tokens);
        parser.prog();
        AccessRules accessRules = parser.getAccessRules();
//        System.out.println("============= S T A R T ================================================");
//        System.out.println("Size:" + accessRules.getAccessRules().size());
//        for (AccessRule item : accessRules.getAccessRules()) {
//            System.out.print("[");
//            if (item.getRepositoryName() != null) {
//                System.out.print(item.getRepositoryName() + ":" );
//            }
//            System.out.println(item.getRepositoryPath() + "]");
//            for (Access accessItem : item.getAccessList()) {
//                System.out.println("-> " + accessItem.getPrincipal().getName() + " " + accessItem.getLevel());
//            }
//        }
//        Groups groups = parser.getGroups();
//        for(Group item : groups.getGroupsList()) {
//            System.out.println("Group:" + item.getName());
//            for (IPrincipal pItem : item.getPrincipalList()) {
//                System.out.println(" -> " + pItem.getName());
//            }
//        }
//        System.out.println("=============================================================");
    }

    @Test
    public void groupsInGroupsConfigurationTest() throws IOException, RecognitionException {
        FileInputStream fis = new FileInputStream(
                getFileResource("/svnaccess-groups-in-groups.conf"));
        ANTLRInputStream stream = new ANTLRInputStream(fis);
        SAFPLexer lexer = new SAFPLexer(stream);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        SAFPParser parser = new SAFPParser(tokens);
        parser.prog();
        AccessRules accessRules = parser.getAccessRules();
//        System.out.println("============= S T A R T ================================================");
//        System.out.println("Size:" + accessRules.getAccessRules().size());
//        for (AccessRule item : accessRules.getAccessRules()) {
//            System.out.print("[");
//            if (item.getRepositoryName() != null) {
//                System.out.print(item.getRepositoryName() + ":" );
//            }
//            System.out.println(item.getRepositoryPath() + "]");
//            for (Access accessItem : item.getAccessList()) {
//                System.out.println("-> " + accessItem.getPrincipal().getName() + " " + accessItem.getLevel());
//            }
//        }
//        Groups groups = parser.getGroups();
//        for(Group item : groups.getGroupsList()) {
//            System.out.println("Group:" + item.getName());
//            for (IPrincipal pItem : item.getPrincipalList()) {
//                System.out.println(" -> " + pItem.getName());
//            }
//        }
//        System.out.println("=============================================================");
    }

}
