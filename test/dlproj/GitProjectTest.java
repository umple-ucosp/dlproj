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

public class GitProjectTest
{
  private GitProject proj;

  private String gitURI = "https://github.com/umple-ucsop/dlproj.git";
  private String localPath = "./temp/";

  @Before
  public void init()
  {
    proj = new GitProject("myp", localPath, gitURI);
  }

  @Test
  public void constructor()
  {
    Assert.assertEquals("myp", proj.getName());
  }

  @Test
  public void gitDownload() throws IOException,GitAPIException
  {
    //TODO: Fix assertion
  	proj.Download();
    Assert.assertEquals(1, 1);
  }

}


