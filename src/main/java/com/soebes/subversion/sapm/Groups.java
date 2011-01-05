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
 * Convenience class for the grammar to handle a list of {@link Group}s.
 * @author Karl Heinz Marbaise
 *
 */
public class Groups {
    private ArrayList<Group> groupsList;

    public Groups() {
        setGroupsList(new ArrayList<Group>());
    }

    public void setGroupsList(ArrayList<Group> groupsList) {
        this.groupsList = groupsList;
    }

    /**
     * Get the list of all groups
     * @return The list of Groups.
     */
    public ArrayList<Group> getGroupsList() {
        return groupsList;
    }

    /**
     * Add a single {@link Group group} to the list of groups.
     * @param group The {@link Group group} which will added to the list.
     */
    public void add(Group group) {
        getGroupsList().add(group);
    }

    /**
     * Check if a group with the given groupName exists in the
     * list or not.
     * The check will be done case-sensitive.
     * @param groupName The name we are searching for.
     * @return true if the group has been found false otherwise.
     */
    public boolean hasGroup(String groupName) {
        boolean result = false;
        for (Group item : getGroupsList()) {
            if (item.getName().equals(groupName)) {
                result = true;
            }
        }
        return result;
    }

    public Group getGroup(Group group) {
        return getGroup(group.getName());
    }

    /**
     * Get the Group instance from the list by
     * name.
     * @param groupName The group for which will be searched.
     * @return The Group instance for the given group name.
     */
    public Group getGroup(String groupName) {
        Group result = null;
        for (Group item : getGroupsList()) {
            if (item.getName().equals(groupName)) {
                result = item;
            }
        }
        return result;
    }

}
