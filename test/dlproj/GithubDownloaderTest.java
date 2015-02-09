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

public class GithubDownloaderTest
{
  private GithubDownloader proj;
  private GithubDownloader sample;

  private String branch = "branch";
  private String localPath = "./tmp/";
  private String projectName = "myp";
  
  private void cleanup()
  {
    try
    {
      Runtime.getRuntime().exec("rm -rf ./tmp/umple-ucsop");
    }
    catch (IOException e)
    {
      Assert.fail("Unable to cleanup ./tmp/umple-ucsop");
    }
  }
  
  @Before
  public void init()
  {
    cleanup();
    proj = new GithubDownloader(projectName, branch, localPath);
    sample = new GithubDownloader("umple-ucsop/umple.sample.downloader", "master", "./tmp");
  }
  
  @After
  public void teardown()
  {
    cleanup();
  }

  @Test
  public void constructor()
  {
    Assert.assertEquals(projectName, proj.getProjectName());
  }

  @Test
  public void properties()
  {
    Assert.assertEquals("https://github.com/umple-ucsop/umple.sample.downloader.git", sample.getGithubUrl());
    Assert.assertEquals("umple-ucsop/umple.sample.downloader", sample.getProjectName());
    Assert.assertEquals("master", sample.getProjectBranch());
    Assert.assertEquals("./tmp", sample.getLocalPath());
    Assert.assertEquals("./tmp/umple-ucsop/umple.sample.downloader/master", sample.getDownloadDir());
  }

  @Test
  public void gitDownload() throws IOException,GitAPIException
  {
	  sample.download();
	  Assert.assertEquals(true, (new File("./tmp/umple-ucsop/umple.sample.downloader/master/README.md").exists()));
  }

}


