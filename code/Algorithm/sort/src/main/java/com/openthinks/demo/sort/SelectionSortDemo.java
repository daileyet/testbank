/**
 * 
 */
package com.openthinks.demo.sort;

/**
 * @author dailey.dai@openthinks.com
 *
 */
public class SelectionSortDemo extends AbstractSortDemo {

  /* (non-Javadoc)
   * @see com.openthinks.demo.sort.AbstractSortDemo#doSort(java.lang.Integer[])
   */
  @Override
  protected Integer[] doSort(Integer[] inputArray) {
    return SortContext.selectionSort(inputArray);
  }

  /* (non-Javadoc)
   * @see com.openthinks.libs.utilities.demo.AbstractDemo#keyParam()
   */
  @Override
  protected String keyParam() {
    return "--SELECTION";
  }

}
