/*
 * Copyright (c) 2018 Azeus Systems Holdings Limited. All rights reserved.
 *
 * This software is the confidential and proprietary information of Azeus
 * Systems Holdings, Ltd. ("Confidential Information"). You shall not disclose
 * such Confidential Information and shall use it only in accordance with the
 * terms of the license agreement you entered into with Azeus.
 */

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import java.util.ArrayList;
import java.util.List;

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
 * <b>File Created</b>: Feb 19, 2019
 *
 * <br>
 * <br>
 *
 * <b>Author</b>: quytm
 */
public class ProductDetail {

  private WebDriver driver;

  private String link;

  private WebElement rootDiv;

  private ArrayList<String> listThumbnail;

  private String brandName;

  private String productDescription;

  private ArrayList<String> reviewComments = new ArrayList<String>();

  private Double ratingPoint;

  public ProductDetail(String link) {

    ChromeOptions options = new ChromeOptions();
    String proxy = "118.172.211.37:41780";
    options.addArguments("--proxy-server=http://" + proxy);
    options.addArguments("start-maximized");
    options.addArguments("headless");
    options.addArguments("--disable-extensions");

    this.driver = new ChromeDriver(options);
    try {
      this.driver.get(link);
      this.rootDiv = this.driver.findElement(
          By.xpath("//div[@class='pdp-block pdp-block__main-information']"));
    } catch (Exception e) {
      System.out.println(e);
    }
    this.setListThumbnail(this.rootDiv);
    this.setBrandName(this.rootDiv);
    this.setReviewComments(this.rootDiv);
    this.setProductDescription(this.rootDiv);
    this.setRatingPoint(this.rootDiv);

    this.driver.close();
    this.driver.quit();
  }

  public String getListThumbnail() {
    String result = "";
    for (String elm : this.listThumbnail) {
      result += elm + ";";
    }
    return result;
  }

  public void setListThumbnail(WebElement rootDiv) {
    this.listThumbnail = new ArrayList<String>();
    WebElement imageFrame = rootDiv
        .findElement(By.xpath("//div[@class='pdp-block module']"));
    List<WebElement> listImages = imageFrame.findElements(By.xpath(
        "//div[@class='item-gallery__image-wrapper']/img[@class='pdp-mod-common-image item-gallery__thumbnail-image']"));
    for (WebElement image : listImages) {
      this.listThumbnail.add(image.getAttribute("src").replace("_.webp", "")
          .replace("_80x80q80.jpg", ""));
    }
  }

  public String getBrandName() {
    return brandName;
  }

  public void setBrandName(WebElement rootDiv) {
    WebElement brandName = rootDiv.findElement(By.xpath(
        "//div[@class='pdp-product-brand']//*[@class='pdp-link pdp-link_size_s pdp-link_theme_blue pdp-product-brand__brand-link']"));
    this.brandName = brandName.getText();
  }

  public String getProductDescription() {
    return "<pre>" + productDescription + "</pre>";
  }

  public void setProductDescription(WebElement rootDiv) {
    WebElement detail = rootDiv.findElement(By.xpath(
        "//div[@class='html-content pdp-product-highlights']"));
    this.productDescription = detail.getText();
  }

  public ArrayList<String> getReviewComments() {
    return reviewComments;
  }

  public void setReviewComments(WebElement rootDiv) {
    this.reviewComments = new ArrayList<String>();
    List<WebElement> reviewCommnent = rootDiv.findElements(
        By.xpath("//div[@class='mod-reviews']//*[@class='item']"));
    for (WebElement x : reviewCommnent) {
      this.reviewComments.add(x.getText());
    }
  }

  public Double getRatingPoint() {
    return ratingPoint;
  }

  public void setRatingPoint(WebElement rootDiv) {
    WebElement rating = rootDiv.findElement(By.xpath(
        "//div[@id='module_product_review']//div[@class='score']//span[@class='score-average']"));
    this.ratingPoint = Double.valueOf(rating.getText());
  }

  //  public static void main(String args[]) throws Exception {
  //
  //    System.setProperty("webdriver.chrome.driver",
  //        "C:\\Users\\thanhdt\\project\\crawl-data\\chromedriver.exe");
  //
  //    ChromeOptions options = new ChromeOptions();
  //    String proxy = "78.108.108.192:61847";
  //    options.addArguments("start-maximized");
  //    options.addArguments("headless");
  //    //    options.addArguments("window-size=1920x10000");
  //    options.addArguments("--disable-extensions");
  //    options.addArguments("--proxy-server=http://" + proxy);
  //    WebDriver driver = new ChromeDriver(options);

  //    ProductDetail detail = new ProductDetail(driver,
  //        "https://www.lazada.vn/products/xiaomi-redmi-5-32gb-ram-3gb-den-hang-phan-phoi-chinh-thuc-i161183555-s174988855.html?spm=a2o4n.searchlistcategory.list.1.138c2590AnudrG&search=1");
  //    System.out.println(detail.getProductDescription());

  //  }
}
