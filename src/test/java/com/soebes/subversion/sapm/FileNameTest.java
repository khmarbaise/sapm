/**
 * The (Su)bversion Re(po)sitory (S)earch (E)ngine (SupoSE for short).
 *
 * Copyright (c) 2007, 2008, 2009, 2010 by SoftwareEntwicklung Beratung Schulung (SoEBeS)
 * Copyright (c) 2007, 2008, 2009, 2010 by Karl Heinz Marbaise
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

import static org.testng.Assert.assertEquals;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * @author Karl Heinz Marbaise
 *
 */
@Test()
public class FileNameTest {

    @DataProvider(name = "createTestList")
    public Object[][] createTestList() {
        return new Object[][] {
                { "/usr/local/test.zip", "zip", "test.zip", "test",
                "/usr/local/" },
                { "/usr/local/test.tar.gz", "tar.gz", "test.tar.gz", "test",
                "/usr/local/" },
                { "C:/Programme/x-y-z.zip", "zip", "x-y-z.zip", "x-y-z",
                "C:/Programme/" },
                { "/x.zip", "zip", "x.zip", "x", "/" },
                { "/branches/", "", "", "", "/branches/" },
                { "/branches", "", "branches", "branches", "/" },
                { "/", "", "", "", "/" }, };
    }

    @Test(dataProvider = "createTestList")
    public void check(String fileName, String ext, String baseName,
            String nameWithoutExtension, String path) {
        FileName fn = new FileName(fileName);
        assertEquals(fn.getExt(), ext);
        assertEquals(fn.getBaseName(), baseName);
        assertEquals(fn.getNameWithoutExtension(), nameWithoutExtension);
        assertEquals(fn.getPath(), path);
    }

    // This is not in the dataProvider list!!!
    public void testF61() {
        String fileName = "/branches";
        FileName fn = new FileName(fileName, true);
        assertEquals(fn.getExt(), "", "The extension is not as expected.");
        assertEquals(fn.getBaseName(), "", "The basename is not as expected.");
        assertEquals(fn.getNameWithoutExtension(), "",
        "The name without extension is not as expected.");
        assertEquals(fn.getPath(), "/branches/", "The path is not as expected.");
    }

    // This is not in the dataProvider list!!!
    public void testF80() {
        String fileName = "/tags/1.5.o-beta1";
        FileName fn = new FileName(fileName, true);
        assertEquals(fn.getExt(), "", "The extension is not as expected.");
        assertEquals(fn.getBaseName(), "", "The basename is not as expected.");
        assertEquals(fn.getNameWithoutExtension(), "",
        "The name without extension is not as expected.");
        assertEquals(fn.getPath(), "/tags/1.5.o-beta1/",
        "The path is not as expected.");
    }

    // This is not in the dataProvider list!!!
    public void testF90() {
        String fileName = "/branches/B_0.4.0/.project";
        FileName fn = new FileName(fileName, false);
        assertEquals(fn.getExt(), "project",
        "The extension is not as expected.");
        assertEquals(fn.getBaseName(), ".project",
        "The basename is not as expected.");
        assertEquals(fn.getNameWithoutExtension(), "",
        "The name without extension is not as expected.");
        assertEquals(fn.getPath(), "/branches/B_0.4.0/",
        "The path is not as expected.");
    }

    // This is not in the dataProvider list!!!
    /**
     * This test is based on issue #215 as well as the test in
     * SearchRepositoryTest#testQueryForREADMEFileIssue215
     */
    public void testF100() {
        String fileName = "/branches/B_0.4.0/README";
        FileName fn = new FileName(fileName, false);
        assertEquals(fn.getExt(), "", "The extension is not as expected.");
        assertEquals(fn.getBaseName(), "README",
        "The basename is not as expected.");
        assertEquals(fn.getNameWithoutExtension(), "README",
        "The name without extension is not as expected.");
        assertEquals(fn.getPath(), "/branches/B_0.4.0/",
        "The path is not as expected.");
    }

}
