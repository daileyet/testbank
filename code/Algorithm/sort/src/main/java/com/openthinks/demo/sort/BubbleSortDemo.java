/**
 * 
 */
package com.openthinks.demo.sort;

/**
 * @author dailey.dai@openthinks.com
 *
 */
public class BubbleSortDemo extends AbstractSortDemo {

  /* (non-Javadoc)
   * @see com.openthinks.libs.utilities.demo.AbstractDemo#keyParam()
   */
  @Override
  protected String keyParam() {
    return "--BUBBLE";
  }

  @Override
  protected Integer[] doSort(Integer[] inputArray) {
    return SortContext.bubbleSort(inputArray);
  }

}
