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
  protected Integer[] doSort(Integer[] inputArray) {
    return SortContext.quickSort(inputArray, null, null);
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
