package week09;

/**
 *  A SEleciton sort  implementation which is able to be observed through its
 *  Sorter superclass.
 *
 * @author Mike Cui
 */
public class SelectionSort extends Sorter {

    /**
     *  Create a new SElection  sorter with the given integers to sort.
     *
     * @param nums the integers to sort.
     */
    public SelectionSort(Integer[] nums) {
        super(nums); // pass nums[] to the superclass Sort
    }

    /**
     * Sort the integers (which are stored in the parent Sorter class).
     */
    public void sortNums() {
        // int i, j, comparisons, and nums[] are all protected datafields in
        // the superclass Sort so we can use them without declaring them
        int compare;
        int temp;
        comparisons=0;
        for (i=0;i<nums.length;i++){
            for (j=i+1;j<nums.length;j++){
        
                if (++comparisons>0 && nums[i]>nums[j]){
                    temp=nums[j]   ;
                    nums[j]=nums[i];
                    nums[i]=temp;
                }//end if
                update();

                
            }//end inner for
        }//end for
                  
    }//end method
}//end class
