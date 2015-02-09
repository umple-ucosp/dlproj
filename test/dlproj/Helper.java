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

public class Helper
{
  
  // Clean up everything, everywhere  
  public static void cleanup()
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

}


