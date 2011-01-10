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

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.antlr.runtime.ANTLRInputStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.RecognitionException;

import com.soebes.subversion.sapm.parser.SAFPLexer;
import com.soebes.subversion.sapm.parser.SAFPParser;

/**
 * This class is intended for the user to use it for reading
 * of the authentication file.
 *
 * @author Karl Heinz Marbaise
 *
 */
public class AuthorizationFile {

    private AccessRules accessRules;
    private Groups groups;
    private Aliases aliases;

    public AuthorizationFile() {
        setAccessRules(new AccessRules());
    }

    /**
     * Load the authorization file.
     *
     * @param authorizationFile The file you would like to load.
     * @throws AuthorizationFileException in case of a problem like file not found,
     *  IOException or parser problem (syntax error in the authorization file).
     */
    public void load(File authorizationFile) throws AuthorizationFileException {
        FileInputStream fis = null;
        try {
            fis = new FileInputStream(authorizationFile);
            ANTLRInputStream stream = new ANTLRInputStream(fis);
            SAFPLexer lexer = new SAFPLexer(stream);
            CommonTokenStream tokens = new CommonTokenStream(lexer);
            SAFPParser parser = new SAFPParser(tokens);
            parser.prog();
            setAccessRules(parser.getAccessRules());
            setGroups(parser.getGroups());
            setAliases(parser.getAliases());
        } catch (FileNotFoundException e) {
            throw new AuthorizationFileException("FileNotFoundException: ", e);
        } catch (IOException e) {
            throw new AuthorizationFileException("IOException: ", e);
        } catch (RecognitionException e) {
            throw new AuthorizationFileException("Parser problem: ", e);
        } finally {
            try {
                fis.close();
            } catch (IOException e) {
                throw new AuthorizationFileException("IOExcetion during close: ", e);
            }
        }
    }

    public void setAccessRules(AccessRules accessRules) {
        this.accessRules = accessRules;
    }

    public AccessRules getAccessRules() {
        return accessRules;
    }

    public void setGroups(Groups groups) {
        this.groups = groups;
    }

    public Groups getGroups() {
        return groups;
    }

    public void setAliases(Aliases aliases) {
        this.aliases = aliases;
    }

    public Aliases getAliases() {
        return aliases;
    }


}
