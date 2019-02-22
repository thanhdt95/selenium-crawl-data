/*
 * Copyright (c) 2018 Azeus Systems Holdings Limited. All rights reserved.
 *
 * This software is the confidential and proprietary information of Azeus
 * Systems Holdings, Ltd. ("Confidential Information"). You shall not disclose
 * such Confidential Information and shall use it only in accordance with the
 * terms of the license agreement you entered into with Azeus.
 */

import java.util.Random;

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
 * <b>File Created</b>: Feb 20, 2019
 *
 * <br>
 * <br>
 *
 * <b>Author</b>: quytm
 */
public class Product {

  private int id;

  private int amount;

  private int category_id;

  private String status;

  private String nameProduct;

  private String price;

  private String percent;

  private ProductDetail productDetail;

  public Product(String nameProduct, String price, String percent,
      ProductDetail productDetail) {
    this.nameProduct = nameProduct;
    this.price = price;
    this.percent = percent;
    this.productDetail = productDetail;
  }

  public Product() {
  }

  public int getCategoryId() {
    return category_id;
  }

  public void setCategoryId(int category_id) {
    this.category_id = category_id;
  }

  public void setProductDetail(ProductDetail productDetail) {
    this.productDetail = productDetail;
  }

  public void setNameProduct(String nameProduct) {
    this.nameProduct = nameProduct;
  }

  public void setPrice(String price) {
    this.price = price;
  }

  public void setPercent(String percent) {
    this.percent = percent;
  }

  public String getNameProduct() {
    return this.nameProduct;
  }

  public String getPrice() {
    return this.price.replace(" ₫", "").replace(".", "");
  }

  public String getPercent() {
    return this.percent.replace("%", "").replace("-", "");
  }

  public ProductDetail getProductDetail() {
    return productDetail;
  }

  public void setId(int id) {
    this.id = id;
  }

  public int getId() {
    return this.id;
  }

  public int getAmount() {
    Random r = new Random();
    return r.nextInt((100 - 1) + 1) + 1;
  }

  public String getStatus() {
    return status;
  }

  public double getWeight() {
    Random r = new Random();
    return (0.5 + (10.0 - 0.5) * r.nextDouble());
  }

  public String generateSQL() {
    String sql =
        "INSERT INTO product (id, name, full_desc, category_id, brand_name, status, weight, available_item, unit_price, discount_percent, avg_rating, img_url) VALUES"
            + "("
            + this.getId() + ", "
            + "'" + this.getNameProduct() + "'" + ", "
            + "'" + this.getProductDetail().getProductDescription() + "'" + ", "
            + this.getCategoryId() + ", "
            + "'" + this.getProductDetail().getBrandName() + "'" + ", "
            + "'" + this.getStatus() + "'" + ", "
            + this.getWeight() + ", "
            + this.getAmount() + ", "
            + this.getPrice() + ", "
            + this.getPercent() + ", "
            + this.getProductDetail().getRatingPoint() + ", "
            + "'" + this.getProductDetail().getListThumbnail() + "'"
            + ");" + "\r\n";
    return sql;
  }

}
