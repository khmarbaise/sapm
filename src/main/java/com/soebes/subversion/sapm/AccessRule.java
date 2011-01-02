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

import java.util.ArrayList;

/**
 * <pre>
 * [repository:/trunk]
 * @group = rw
 * user = r
 * </pre>
 *
 * @author Karl Heinz Marbaise
 *
 */
public class AccessRule {

    private ArrayList<Access> accessList;

    /**
     * The name of the repository which this AccessRule represents.
     */
    private String repositoryName;
    /**
     * The path inside the repository which is represented by this AccessRule.
     */
    private String repositoryPath;

    /**
     * This is used if you have no paritcular repository defined for exmample
     *
     * <pre>
     * [/test/trunk]
     * ...
     * </pre>
     *
     * @param path
     */
    public AccessRule(String path) {
        super();
        init(null, path);
    }

    public AccessRule(String repositoryName, String path) {
        super();
        init(repositoryName, path);
    }

    private void init(String repositoryName, String path) {
        if (!path.endsWith("/")) {
            path += "/";
        }
        setRepositoryName(repositoryName);
        setRepositoryPath(path);
        setAccessList(new ArrayList<Access>());
    }

    public String getRepositoryName() {
        return repositoryName;
    }

    public void setRepositoryName(String repositoryName) {
        this.repositoryName = repositoryName;
    }

    public String getRepositoryPath() {
        return repositoryPath;
    }

    public void setRepositoryPath(String path) {
        this.repositoryPath = path;
    }

    public void setAccessList(ArrayList<Access> accessList) {
        this.accessList = accessList;
    }

    public ArrayList<Access> getAccessList() {
        return accessList;
    }

    /**
     * Add the user to the user list with it's appropriate {@link AccessLevel}.
     *
     * @param user
     * @param readWrite
     */
    public void add(User user, AccessLevel readWrite) {
        getAccessList().add(new Access(user, readWrite));
    }

    public void add(Group group, AccessLevel readWrite) {
        getAccessList().add(new Access(group, readWrite));
    }

    /**
     * Convenience method for usage in grammar.
     * @param access
     */
    public void add(Access access) {
        getAccessList().add(access);
    }

    public AccessLevel getAccess(User user, String repository, String path) {
        return getAccess(user.getName(), repository, path);
    }

    /**
     *
     * @param user
     * @param repository
     * @param path
     * @return
     */
    public AccessLevel getAccess(String user, String repository, String path) {
        AccessLevel result = AccessLevel.NOTHING;
        if (getRepositoryName() == null) {
            Path repositoryPath = new Path(getRepositoryPath());
            if (repositoryPath.contains(path)) {
                result = getAccessForPrincipal(user);
            }
        } else {
            if (getRepositoryName().equals(repository)) {
                Path repositoryPath = new Path(getRepositoryPath());
                if (repositoryPath.contains(path)) {
                    result = getAccessForPrincipal(user);
                }
            }
        }

        return result;
    }

    public AccessLevel getAccessForPrincipal(User user) {
        return getAccessForPrincipal(user.getName());
    }

    /**
     * Will get the {@link AccessLevel} for the given user.
     *
     * @param user
     *            The user which will be searched for.
     * @return The AccessLevel of the given user @{link AccessLevel.NOTHING} if
     *         the user will not be found.
     */
    public AccessLevel getAccessForPrincipal(String user) {
        AccessLevel result = AccessLevel.NOTHING;
        for (Access item : getAccessList()) {
            if (item.getPrincipal().contains(user)) {
                result = item.getLevel();
            }
        }
        return result;
    }

}
