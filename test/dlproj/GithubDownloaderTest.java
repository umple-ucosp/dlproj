/*

 Copyright: All contributers to the Umple Project

 This file is made available subject to the open source license found at:
 http://umple.org/license

*/

package dlproj;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.junit.*;
import org.eclipse.jgit.api.*;
import org.eclipse.jgit.api.errors.*;

import com.jcraft.jsch.*;

import static dlproj.Helper.LOCAL_DOWNLOAD_DIRECTORY;

public class GithubDownloaderTest
{
  private GithubDownloader proj;
  private GithubDownloader sample;
  
  @Before
  public void init()
  {
    Helper.cleanup();
    sample = new GithubDownloader("umple-ucosp/dlproj.test", "master", LOCAL_DOWNLOAD_DIRECTORY);
  }
  
  @After
  public void teardown()
  {
    Helper.cleanup();
  }

  @Test
  public void constructor()
  {
    Assert.assertEquals("umple-ucosp/dlproj.test", sample.getProjectName());
  }

  @Test
  public void properties()
  {
    Assert.assertEquals("https://github.com/umple-ucosp/dlproj.test.git", sample.getGithubUrl());
    Assert.assertEquals("umple-ucosp/dlproj.test", sample.getProjectName());
    Assert.assertEquals("master", sample.getProjectBranch());
    Assert.assertEquals(LOCAL_DOWNLOAD_DIRECTORY, sample.getLocalPath());
    Assert.assertEquals(LOCAL_DOWNLOAD_DIRECTORY + "/umple-ucosp/dlproj.test/master", sample.getDownloadDir());
  }

  @Test
  public void gitDownload() throws IOException,GitAPIException
  {
	  sample.download();
	  Assert.assertEquals(true, (new File(LOCAL_DOWNLOAD_DIRECTORY + "/umple-ucosp/dlproj.test/master/README.md").exists()));
  }

}


