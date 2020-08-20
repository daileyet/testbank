/**
 * 
 */
package com.openthinks.demo.sort;

import java.util.List;
import com.openthinks.libs.utilities.CommonUtilities;
import com.openthinks.libs.utilities.Converter;
import com.openthinks.libs.utilities.demo.AbstractDemo;
import com.openthinks.libs.utilities.logger.ProcessLogger2;
import com.openthinks.libs.utilities.logger.ProcessLogger2Factory;

/**
 * @author dailey.dai@openthinks.com
 *
 */
public abstract class AbstractSortDemo extends AbstractDemo {
  protected static final ProcessLogger2 LOGGER = ProcessLogger2Factory.getRootLogger();
  /* (non-Javadoc)
   * @see com.openthinks.libs.utilities.demo.AbstractDemo#run(java.util.List)
   */
  @Override
  protected void run(List<String> params) throws Exception {
    PartParams pp =  getPartParamsBy(params, "--INPUT");
    LOGGER.info("Input array:[{0}]",pp.getAllJoined(","));
    final List<String> list= pp.getParams();
    Integer[] inputArray = Converter.source(list).convert2Array(Integer.class);
    doSort(inputArray);
    LOGGER.info("Sorted array{0};[{1}]", keyParam(),CommonUtilities.toString4Array(inputArray));
  }
  
  protected abstract void doSort(Integer[] inputArray);


}
