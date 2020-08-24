/**
 * 
 */
package com.openthinks.demo.db;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author dailey.dai@openthinks.com
 *
 */
public class JDBCHelper {
  private DBInfo dbInfo;

  public JDBCHelper(DBInfo dbInfo) {
    super();
    this.dbInfo = dbInfo;
  }

  public final Connection getConnection() throws ClassNotFoundException, SQLException {
    Class.forName(dbInfo.driverClass);
    Connection conn = DriverManager.getConnection(dbInfo.dbURL, dbInfo.dbUName, dbInfo.dbUPass);
    return conn;
  }

  public final <T> List<T> list(Class<T> entityClazz) throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException {
    final String querySql = "select * from %1$s where 1=1";
    String finalSQL = String.format(querySql, toTableName(entityClazz));
    Connection conn = getConnection();
    PreparedStatement ps = conn.prepareStatement(finalSQL);
    ResultSet rs = ps.executeQuery();
    final List<T> list = new ArrayList<T>();
    final Field[] fields = entityClazz.getDeclaredFields();
    while(rs.next()) {
      T entity = entityClazz.newInstance();
      for(Field field:fields) {
        field.setAccessible(true);
        field.set(entity, rs.getObject(toColumnName(field)));
      }
      list.add(entity);
    }
    release(conn,ps,rs);
    return list;
  }

  public final <T> int create(T entity) throws ClassNotFoundException, SQLException, IllegalArgumentException, IllegalAccessException {
    @SuppressWarnings("unchecked")
    final Class<T> entityClass = (Class<T>) entity.getClass();
    final Field[] entityFields = entityClass.getDeclaredFields();
    final String sql = "insert into %1$s(%2$s) values(%3$s)";
    final String tableName = toTableName(entityClass);
    final StringBuffer columnNames = new StringBuffer();
    final StringBuffer columnPlaceHoder = new StringBuffer();
    for(int i=0,j=entityFields.length;i<j;i++) {
      Field field = entityFields[i];
      columnNames.append(toColumnName(field));
      columnPlaceHoder.append("?");
      if(i!=j-1) {
        columnNames.append(",");
        columnPlaceHoder.append(",");
      }
    }
    String SQL = String.format(sql, tableName,columnNames.toString(),columnPlaceHoder.toString());
    Connection conn = getConnection();
    PreparedStatement ps = conn.prepareStatement(SQL);
    for(int i=0,j=entityFields.length;i<j;i++) {
      Field field = entityFields[i];
      field.setAccessible(true);
      ps.setObject(i+1, field.get(entity));
    }
    final int result =  ps.executeUpdate();
    release(conn,ps,null);
    return result;
  }

  protected void release(Connection conn, PreparedStatement ps, ResultSet rs) throws SQLException {
    if(rs!=null && !rs.isClosed()) {
      rs.close();
    }
    if(ps!=null && !ps.isClosed()) {
      ps.close();
    }
    if(conn!=null && !conn.isClosed()) {
      conn.close();
    }
  }

  protected String toColumnName(Field field) {
    return field.getName();
  }

  protected <T> String toTableName(Class<T> entityClass) {
    return entityClass.getSimpleName();
  }

  public final static class DBInfo {
    public String driverClass;
    public String dbURL;
    public String dbUName;
    public String dbUPass;
  }
}
