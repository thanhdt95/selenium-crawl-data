/*
 * Copyright (c) 2018 Azeus Systems Holdings Limited. All rights reserved.
 *
 * This software is the confidential and proprietary information of Azeus
 * Systems Holdings, Ltd. ("Confidential Information"). You shall not disclose
 * such Confidential Information and shall use it only in accordance with the
 * terms of the license agreement you entered into with Azeus.
 */

import java.io.IOException;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * <b>Program ID</b>: NA <br>
 * <br>
 *
 * <b>Mode</b>: <!-- Online/Batch/Library (Library by default) --> Library <br>
 * <br>
 *
 * <b>Program Name</b>: NA <br>
 * <br>
 *
 * <b>Description</b>: Class/Interface/Enum description here
 * <br>
 * <br>
 *
 * <b>Programming Environment</b>:
 *
 * <table cellspacing="0" cellpadding="0" class="PCMS2">
 * <tr class="header">
 * <td>Related Source</td>
 * <td>Compiler</td>
 * </tr>
 * <p>
 * <!-- Programming Environment Entries -->
 *
 * <tr>
 * <td>NA</td>
 * <td>NA</td>
 * </tr>
 * </table>
 *
 * <br>
 *
 * <b>File Usage</b>: <br>
 * <p>
 * File usage here
 *
 * <pre>
 *   Enclose sample code usage in &lt;pre&gt; tags
 * </pre>
 *
 * <b>Input Parameters</b>:
 *
 * <table cellspacing="0" cellpadding="0" class="PCMS2">
 * <tr class="header">
 * <td>Parameter</td>
 * <td>Type</td>
 * <td>Format</td>
 * <td>Mandatory</td>
 * <td>Description</td>
 * </tr>
 * <p>
 * <!-- Input Parameter Entries -->
 *
 * <tr>
 * <td>NA</td>
 * <td>NA</td>
 * <td>NA</td>
 * <td>NA</td>
 * <td>NA</td>
 * </tr>
 * </table>
 *
 * <br>
 *
 * <b>Screens Used</b>: NA <br>
 * <br>
 *
 * <b>Processing Logic</b>: <br>
 * <p>
 * Place processing logic here.
 *
 * <br>
 * <br>
 *
 * <b>External References</b>:
 *
 * <table cellspacing="0" cellpadding="0" class="PCMS2">
 * <tr class="header">
 * <td>Reference</td>
 * <td>Description</td>
 * </tr>
 * <p>
 * <!-- External References Entries -->
 * <tr>
 * <td>NA</td>
 * <td>NA</td>
 * </tr>
 * </table>
 *
 * <br>
 *
 * <b>Program Limits</b>: NA <br>
 *
 * <ul>
 * <!-- List Program Limits here using
 * <li></li>
 * tags -->
 * </ul>
 *
 * <br>
 *
 * <b>Unit Test Record</b>: NA <br>
 * <br>
 *
 * <b>Amendment History</b>:
 *
 * <table cellspacing="0" cellpadding="0" class="PCMS2">
 * <tr class="header">
 * <td>Reference No.</td>
 * <td>Date (MMM-DD-YYYY)</td>
 * <td>Author</td>
 * <td>Description</td>
 * </tr>
 * <p>
 * <!-- Amendment History Entries -->
 *
 * <tr>
 * <td>&nbsp;</td>
 * <td></td>
 * <td></td>
 * <td></td>
 * </tr>
 * </table>
 *
 * <br>
 *
 * <b>File Created</b>: Feb 15, 2019
 *
 * <br>
 * <br>
 *
 * <b>Author</b>: thanhdt
 */
public class Run {

  public static void main(String args[]) throws IOException {
    System.setProperty("webdriver.gecko.driver",
        "C:\\Users\\thanhdt\\project\\crawl-data\\geckodriver.exe");
    WebDriver driver = new FirefoxDriver();
    driver.get(
        "https://www.lazada.vn/dien-thoai-di-dong/?spm=a2o4n.home.cate_1.1.1905e182EfIqk1");
    WebElement rootDiv = driver.findElement(By.id("root"));
    List<WebElement> listItems = rootDiv.findElements(By.className("c2prKC"));
    for (WebElement item : listItems) {
      List<WebElement> listImages = item.findElements(By.className("c1ZEkM"));
    }
  }
}
