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

  private String branch = "branch";
  private String localPath = "./temp/";
  private String projectName = "myp";

  @Before
  public void init()
  {
    proj = new GithubDownloader(projectName, branch, localPath);
  }

  @Test
  public void constructor()
  {
    Assert.assertEquals(projectName, proj.getProjectName());
  }

  @Test
  public void gitDownload() throws IOException,GitAPIException
  {
    //TODO: Fix assertion
    Assert.assertEquals(1, 1);
  }

}


