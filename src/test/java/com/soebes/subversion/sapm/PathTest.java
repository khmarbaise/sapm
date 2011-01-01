package com.soebes.subversion.sapm;

import junit.framework.Assert;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.soebes.subversion.sapm.Path;

public class PathTest extends TestBase {

    @DataProvider(name = "createRepositoryPaths")
    public Object[][] createRepositoryPaths() {
        return new Object[][] {
                { "/test/trunk/", "/test/trunk/xyz.pas", true },
                { "/test/trunk/", "/test/trunk/src/main/java/", true },
                { "/test/trunk/", "/test/trunk/", true },
                { "/test/trunk/", "/test/", false }, };
    }

    @Test(dataProvider = "createRepositoryPaths")
    public void folderTestWithX(String repository, String checkPath,
            boolean result) {
        Path f = new Path(repository);
        Assert.assertEquals(result, f.contains(checkPath));
    }

}
