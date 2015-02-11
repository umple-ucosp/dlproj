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
import static dlproj.Helper.SAMPLE_PROJECT_NAME;
import static dlproj.Helper.SAMPLE_PROJECT_BRANCH;
import static dlproj.Helper.SAMPLE_PROJECT_LOCAL_README;
import static dlproj.Helper.SAMPLE_PROJECT_LOCAL_DIRECTORY;
import static dlproj.Helper.SAMPLE_PROJECT_GITHUB_URL;

public class GithubDownloaderTest
{
  private GithubDownloader proj;
  private GithubDownloader sample;
  
  @Before
  public void init()
  {
    Helper.cleanup();
    sample = new GithubDownloader(SAMPLE_PROJECT_NAME, SAMPLE_PROJECT_BRANCH, LOCAL_DOWNLOAD_DIRECTORY);
  }
  
  @After
  public void teardown()
  {
    Helper.cleanup();
  }

  @Test
  public void constructor()
  {
    Assert.assertEquals(SAMPLE_PROJECT_NAME, sample.getProjectName());
  }

  @Test
  public void properties()
  {
    Assert.assertEquals(SAMPLE_PROJECT_GITHUB_URL, sample.getGithubUrl());
    Assert.assertEquals(SAMPLE_PROJECT_NAME, sample.getProjectName());
    Assert.assertEquals(SAMPLE_PROJECT_BRANCH, sample.getProjectBranch());
    Assert.assertEquals(LOCAL_DOWNLOAD_DIRECTORY, sample.getLocalPath());
    Assert.assertEquals(SAMPLE_PROJECT_LOCAL_DIRECTORY, sample.getDownloadDir());
  }

  @Test
  public void gitDownload() throws IOException,GitAPIException
  {
	  sample.download();
	  Assert.assertEquals(true, (new File(SAMPLE_PROJECT_LOCAL_README).exists()));
  }

}


