/**
 * 
 */
package com.openthinks.demo.sort;

/**
 * @author dailey.dai@openthinks.com
 *
 */
public class InsertionSortDemo extends AbstractSortDemo {

  /* (non-Javadoc)
   * @see com.openthinks.demo.sort.AbstractSortDemo#doSort(java.lang.Integer[])
   */
  @Override
  protected Integer[] doSort(Integer[] inputArray) {
    return SortContext.insertionSort(inputArray);
  }

  /* (non-Javadoc)
   * @see com.openthinks.libs.utilities.demo.AbstractDemo#keyParam()
   */
  @Override
  protected String keyParam() {
    return "--INSERTION";
  }

}
