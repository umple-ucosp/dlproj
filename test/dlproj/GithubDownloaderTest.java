/*

 Copyright: All contributers to the Umple Project

 This file is made available subject to the open source license found at:
 http://umple.org/license

*/

package dlproj;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.junit.*;
import org.eclipse.jgit.api.*;
import org.eclipse.jgit.lib.*;
import org.eclipse.jgit.revwalk.RevTag;
import org.eclipse.jgit.api.errors.*;

import com.jcraft.jsch.*;

import static dlproj.Helper.LOCAL_DOWNLOAD_DIRECTORY;

public class GithubDownloaderTest
{
  private static GithubDownloader proj;
  
  @BeforeClass
  public static void init() throws IOException,GitAPIException
  {
    Helper.cleanup();

    proj = new GithubDownloader("umple-ucosp/dlproj.test", "master", LOCAL_DOWNLOAD_DIRECTORY);
    proj.download(3);
  }
  
  @AfterClass
  public static void teardown()
  {
    Helper.cleanup();
  }

  @Test
  public void constructor()
  {
    Assert.assertEquals("umple-ucosp/dlproj.test", proj.getProjectName());
  }

  @Test
  public void properties()
  {
    Assert.assertEquals("https://github.com/umple-ucosp/dlproj.test.git", proj.getGithubUrl());
    Assert.assertEquals("umple-ucosp/dlproj.test", proj.getProjectName());
    Assert.assertEquals("master", proj.getProjectBranch());
    Assert.assertEquals(LOCAL_DOWNLOAD_DIRECTORY, proj.getLocalPath());
    Assert.assertEquals(LOCAL_DOWNLOAD_DIRECTORY + "/umple-ucosp/dlproj.test/master/src", proj.getDownloadDir());
  }

  @Test
  public void gitDownloadTip()
  {
	  Assert.assertEquals(true, (new File(LOCAL_DOWNLOAD_DIRECTORY + "/umple-ucosp/dlproj.test/master/tip/src/README.md").exists()));
  }

  @Test
  public void gitDownloadVersionTag()
  {
    Assert.assertEquals(true, (new File(LOCAL_DOWNLOAD_DIRECTORY + "/umple-ucosp/dlproj.test/master/v4.0/src/README.md").exists()));
  }

  @Test
  public void gitDownloadVersionTagOutsideOfMaximum()
  {
    Assert.assertEquals(false, (new File(LOCAL_DOWNLOAD_DIRECTORY + "/umple-ucosp/dlproj.test/master/v1.0/src/README.md").exists()));
  }

  @Test
  public void gitCheckoutVersionTag()
  {
    Assert.assertEquals(false, (new File(LOCAL_DOWNLOAD_DIRECTORY + "/umple-ucosp/dlproj.test/master/v3.0/src/v4").exists()));
    Assert.assertEquals(true, (new File(LOCAL_DOWNLOAD_DIRECTORY + "/umple-ucosp/dlproj.test/master/v3.0/src/v2").exists())); 
  }
}


