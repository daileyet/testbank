/**
 * 
 */
package com.openthinks.demo.db;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import com.openthinks.demo.db.JDBCHelper.DBInfo;
import com.openthinks.libs.utilities.DateFormatUtil;
import com.openthinks.libs.utilities.demo.AbstractDemo;
import com.openthinks.libs.utilities.logger.ProcessLogger2;
import com.openthinks.libs.utilities.logger.ProcessLogger2Factory;

/**
 * @author dailey.dai@openthinks.com
 *
 */
public class MySQLJDBCDemo extends AbstractDemo {
  private JDBCHelper helper;
  private static final ProcessLogger2 LOGGER = ProcessLogger2Factory.getRootLogger();
  {
    DBInfo dbInfo = new DBInfo();
    dbInfo.driverClass = "com.mysql.jdbc.Driver";
    dbInfo.dbURL = "jdbc:mysql://172.17.0.6:3306/testdb?characterEncoding=utf8";
    dbInfo.dbUName = "tester";
    dbInfo.dbUPass = "test123";
    helper = new JDBCHelper(dbInfo);
    prepareTable();
  }
  
  private void prepareTable() {
    String table = "create table if not exists Car("
        + "id INT PRIMARY KEY NOT NULL,"
        + "name VARCHAR(45),"
        + "produce_date VARCHAR(45))"
        ;
    try {
      helper.getConnection().createStatement().executeUpdate(table);
    } catch (ClassNotFoundException | SQLException e) {
      LOGGER.fatal(e);
    }
  }

  /*
   * (non-Javadoc)
   * 
   * @see com.openthinks.libs.utilities.demo.AbstractDemo#run(java.util.List)
   */
  @Override
  protected void run(List<String> params) throws Exception {
    // test list all
    LOGGER.info("listAll():");
    testListAll();
    // test insert one
    LOGGER.info("\ncreate():");
    testInsert();
    // test list again
    LOGGER.info("\nlistAll():");
    testListAll();
  }

  private void testInsert() {
    Car car = new Car();
    car.setId(Integer.valueOf(DateFormatUtil.format("hhmmssSSS", new Date())));
    car.setName("test");
    car.setProduce_date(new Date());
    try {
      int ret = helper.create(car);
      if(ret>0) {
        LOGGER.info("Success to insert {0}", car);
      }
    } catch (ClassNotFoundException | IllegalArgumentException | IllegalAccessException
        | SQLException e) {
      LOGGER.error(e);
    }
  }

  private void testListAll() {
    try {
      helper.list(Car.class).forEach(e->{
        LOGGER.info(e.toString());
      });
    } catch (ClassNotFoundException | InstantiationException | IllegalAccessException
        | SQLException e) {
      LOGGER.error(e);
    }

  }

  /*
   * (non-Javadoc)
   * 
   * @see com.openthinks.libs.utilities.demo.AbstractDemo#keyParam()
   */
  @Override
  protected String keyParam() {
    return "--MYSQL";
  }
}
