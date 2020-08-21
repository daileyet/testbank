/**
 * 
 */
package com.openthinks.demo.sort;

import java.util.ArrayList;
import java.util.List;
import com.openthinks.libs.utilities.CommonUtilities;
import com.openthinks.libs.utilities.Converter;
import com.openthinks.libs.utilities.DateUtils;
import com.openthinks.libs.utilities.demo.AbstractDemo;
import com.openthinks.libs.utilities.logger.ProcessLogger2;
import com.openthinks.libs.utilities.logger.ProcessLogger2Factory;

/**
 * @author dailey.dai@openthinks.com
 *
 */
public abstract class AbstractSortDemo extends AbstractDemo {
  protected static final ProcessLogger2 LOGGER = ProcessLogger2Factory.getRootLogger();
  protected static final List<String> DEFAULT_LIST = new ArrayList<String>();

  /*
   * (non-Javadoc)
   * 
   * @see com.openthinks.libs.utilities.demo.AbstractDemo#run(java.util.List)
   */
  @Override
  protected void run(List<String> params) throws Exception {
    PartParams pp = getPartParamsBy(params, "--INPUT");
    List<String> list = pp.getParams();
    if (pp.isEmpty()) {
      list = preparedDefaultUnSortedList();
    }
    LOGGER.info("Input  array{0}:[{1}]", keyParam(), String.join(",", list));
    Integer[] inputArray = Converter.source(list).convert2Array(Integer.class);
    long start = DateUtils.currentTimeMillis();
    inputArray = doSort(inputArray);
    long end = DateUtils.currentTimeMillis();
    LOGGER.info("Sorted array{0}:[{1}]", keyParam(), CommonUtilities.toString4Array(inputArray));
    LOGGER.info("Sorted array{0} cost time={1}\n", keyParam(), (end - start));
  }

  private static List<String> preparedDefaultUnSortedList() {
    if(DEFAULT_LIST.isEmpty()) {
      final int LEN = 10000;
      for(int i=0;i<LEN;i++) {
        DEFAULT_LIST.add(String.valueOf((int)(Math.random()*LEN)));
      }
    }
    return DEFAULT_LIST;
  }

  protected abstract Integer[] doSort(Integer[] inputArray);


}
