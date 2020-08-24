package com.openthinks.demo.db;

import java.util.Date;
import com.openthinks.libs.utilities.DateFormatUtil;

public class Car {
  private int id;
  private String name;
  private String produce_date;

  public void setId(int id) {
    this.id = id;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setProduce_date(Date produce_date) {
    this.produce_date = DateFormatUtil.format("yyyyMMddHHmmss", produce_date);
  }

  @Override
  public String toString() {
    return "Car [id=" + id + ", name=" + name + ", produce_date=" + produce_date + "]";
  }
}