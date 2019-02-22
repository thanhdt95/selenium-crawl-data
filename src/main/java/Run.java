/*
 * Copyright (c) 2018 Azeus Systems Holdings Limited. All rights reserved.
 *
 * This software is the confidential and proprietary information of Azeus
 * Systems Holdings, Ltd. ("Confidential Information"). You shall not disclose
 * such Confidential Information and shall use it only in accordance with the
 * terms of the license agreement you entered into with Azeus.
 */

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

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

  public static void main(String args[]) throws Exception {

    ArrayList<Product> productArrayList = new ArrayList<Product>();

    System.setProperty("webdriver.chrome.driver",
        "C:\\Users\\thanhdt\\project\\crawl-data\\chromedriver.exe");
    ChromeOptions options = new ChromeOptions();
    options.addArguments("start-maximized");
    options.addArguments("headless");
    options.addArguments("--disable-extensions");
    WebDriver driver = new ChromeDriver(options);

    driver.get(
        "https://www.lazada.vn/playstation-console/?spm=a2o4n.home.cate_1_6.1.1905e182z6ePRa");

    WebElement rootDiv = driver.findElement(By.id("root"));

    List<WebElement> listItem = rootDiv.findElements(By.className("c5TXIP"));

    List<WebElement> listLink = rootDiv.findElements(By.xpath(
        "//*[@class='c5TXIP']//*[@class='c2iYAv']//*[@class='cRjKsc']//a"));

    for (int i = 0; i < listItem.size(); i++) {
      Product product = new Product();
      product.setCategoryId(257);
      product.setId(Integer.valueOf(product.getCategoryId() + "" + i));
      List<WebElement> listText = listItem.get(i)
          .findElements(By.className("c3KeDq"));
      for (WebElement x : listText) {
        WebElement nameElm = x.findElement(By.className("c16H9d"));
        WebElement priceElm = x.findElement(By.className("c3gUW0"));
        WebElement percent = x.findElement(By.className("c3lr34"))
            .findElement(By.xpath("//span[@class='c1hkC1']"));
        product.setNameProduct(nameElm.getText());
        product.setPercent(percent.getText());
        product.setPrice(priceElm.getText());
      }
      String link = listLink.get(i).getAttribute("href");
      try{
        ProductDetail detail = new ProductDetail(link);
        product.setProductDetail(detail);
        productArrayList.add(product);
      }catch(Exception e){

      }
    }

    /*write file*/
    BufferedWriter bw = null;
    FileWriter fw = null;

    try {
      String content = "This is the content to write into file\n";
      fw = new FileWriter("C:\\Users\\thanhdt\\Desktop\\fullData.txt");
      bw = new BufferedWriter(fw);
      for (Product product : productArrayList) {
        bw.write(product.generateSQL());
      }
      System.out.println("Done");
    } catch (IOException e) {
      e.printStackTrace();
    } finally {
      try {
        if (bw != null)
          bw.close();
        if (fw != null)
          fw.close();
      } catch (IOException ex) {
        ex.printStackTrace();
      }
    }
    System.out.println("Done");
  }
}
