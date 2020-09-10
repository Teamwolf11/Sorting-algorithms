package week10;

/**
 *  A Quicksort implementation which is able to be observed through its
 *  Sorter superclass.
 *
 * @author Mike Cui
 */
public class QuickSort extends Sorter {

    /**
     *  Create a new QuickSort sorter with the given integers to sort.
     *
     * @param nums the integers to sort.
     */
    public QuickSort(Integer[] nums) {
        super(nums); // pass nums[] to the superclass Sort
    }

    /**
     * Sort the integers (which are stored in the parent Sorter class).
     */
    public void sortNums() {
        // int i, j, comparisons, and nums[] are all protected datafields in
        // the superclass Sort so we can use them without declaring them
        comparisons = 0;
        int temp;
        sort (nums);
    }//end sortNums method
    /** This is the default sort method and calls the real sort method.
        @param nums the integers to sort
    */
    public void sort(Integer []nums){
        quicksort(nums,0,nums.length-1);
    }//end sort
    
    /** This does the recursive to split the array into many pieces.
     So it can call quick sort to sort one number each time.
    @param nums the nums to sort
    @param low the lowest index in array
    @param high is the highest index in array*/
    public void quicksort(Integer [] nums, int low, int high){
        if (low<high){
            //if (high-low <=1) return; we don't need this as low must be <high
            //to even be called
            int  p = partition (nums,low,high);
            quicksort (nums, low, p);
            quicksort(nums,p+1,high);
        }//end if



    }//end quicksort
    /** This is the sorting function for quick sort.
        This actually sorts the number in position low to the right place.
        and puts the rest of the number relative to it. lower numbers below it
        and higher number above it in array.

        @param nums the array to be used
        @param low the bottom number of section of array to be sorted
        @param high the top number of section of array to be sortd
        @return hole is the index of the number that is in the right position
    */
    public int partition (Integer [] nums, int low, int high){
        int pivot= nums[low];
        int hole = low;
        int left = low+1;
           
        int right= high;
        
        while (true){
            while (++comparisons>0 && right>hole && nums[right] >= pivot ){
                right--;
                j=right;//just for the gui to work
            }//end while for right is bigger than pivot
            
            if (right == hole){
                break;
            }//end if break thingyx
                
            nums[hole]=nums[right];
            hole =right;

            j=right;//just for the gui to work
            update();//just for the gui to work
            while (++comparisons>0 && left<hole && nums[left] < pivot){
                left++;
                i=left;//just for the gui to work
            }//end while for left is smaller than pivot
            
            if (left == hole) {
                break;
            }//end if
            nums[hole]=nums[left];
            hole = left;

            i=left;//just for the gui to work
            update();//just for the gui to work
        }//end while infinte loop
        nums[hole]=pivot;

        i=left;//just for the gui to work
        j=right;//just for the gui to work
        update();//just for the gui to work
        return hole;

        
    }//end partition method
}// end class
