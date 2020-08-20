/**
 * 
 */
package com.openthinks.demo.sort;

/**
 * @author dailey.dai@openthinks.com
 *
 */
public class QuickSortDemo extends AbstractSortDemo {

  @Override
  protected void doSort(Integer[] inputArray) {
    SortContext.quickSort(inputArray, null, null);
  }

  /*
   * (non-Javadoc)
   * 
   * @see com.openthinks.libs.utilities.demo.AbstractDemo#keyParam()
   */
  @Override
  protected String keyParam() {
    return "--QUICK";
  }

}
