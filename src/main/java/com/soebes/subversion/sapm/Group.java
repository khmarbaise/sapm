/**
 * The Subversion Authentication Parse Module (SAPM for short).
 *
 * Copyright (c) 2010, 2011 by SoftwareEntwicklung Beratung Schulung (SoEBeS)
 * Copyright (c) 2010, 2011 by Karl Heinz Marbaise
 *
 * This program is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation; either version 2 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA  02110-1301 USA
 *
 * The License can viewed online under http://www.gnu.org/licenses/gpl.html
 * If you have any questions about the Software or about the license
 * just write an email to license@soebes.de
 */
package com.soebes.subversion.sapm;

import java.util.ArrayList;

public class Group implements IPrincipal {

    private ArrayList<IPrincipal> principalList;

    private String name;

    private void init() {
        setPrincipalList(new ArrayList<IPrincipal>());
    }

    public Group() {
        init();
    }

    public Group(String name) {
        setName(name);
        init();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void add(IPrincipal principal) {
        if (!getPrincipalList().contains(principal)) {
            getPrincipalList().add(principal);
        }
    }

    public boolean contains(User user) {
        return contains(user.getName());
    }

    public boolean contains(String user) {
        boolean result = false;
        for (IPrincipal item : getPrincipalList()) {
            if (item.contains(user)) {
                result = true;
            }
        }
        return result;
    }

    public ArrayList<IPrincipal> getPrincipalList() {
        return principalList;
    }

    public void setPrincipalList(ArrayList<IPrincipal> principalList) {
        this.principalList = principalList;
    }

}
