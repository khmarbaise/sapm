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

/**
 * @author Karl Heinz Marbaise
 * 
 *         This class will support you to extract the <code>extension</code> of
 *         a file, the <code>path</code> and the
 *         <code>filename incl. the extension</code>.
 * 
 *         We define a extension as one of the following: <li></li>
 */
public class FileName {

    private String name;
    private String ext;
    private String baseName;
    private String path;
    private String nameWithoutExtension;

    public FileName(String fileName, boolean isDir) {
        init(fileName, isDir);
    }

    public FileName(String fileName) {
        init(fileName, false);
    }

    private void init(String fileName, boolean isDir) {
        setExt("");
        setName("");
        setBaseName("");
        setNameWithoutExtension("");
        setPath("");
        if (!isDir) {
            if (fileName.endsWith("/")) {
                isDir = true;
            }
        }

        if (isDir) {
            if (!fileName.endsWith("/")) {
                fileName += "/";
            }
            setPath(fileName);
        } else {
            int pos = fileName.lastIndexOf("/");
            if (pos >= 0) {
                setBaseName(fileName.substring(pos + 1));
                setPath(fileName.substring(0, pos + 1));
            } else {
                setBaseName(fileName);
            }
            pos = getBaseName().indexOf('.');
            if (pos >= 0) {
                setNameWithoutExtension(getBaseName().substring(0, pos));
                setName(getNameWithoutExtension());
                setExt(getBaseName().substring(pos + 1));
            } else {
                setNameWithoutExtension(getBaseName());
                setName(getBaseName());
            }
        }
    }

    /**
     * @return The extension of a filename.
     */
    public String getExt() {
        return ext;
    }

    public void setExt(String ext) {
        this.ext = ext;
    }

    /**
     * @return The name of a file.
     */
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBaseName() {
        return baseName;
    }

    public void setBaseName(String baseName) {
        this.baseName = baseName;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getNameWithoutExtension() {
        return nameWithoutExtension;
    }

    public void setNameWithoutExtension(String nameWithoutExtension) {
        this.nameWithoutExtension = nameWithoutExtension;
    }

}
