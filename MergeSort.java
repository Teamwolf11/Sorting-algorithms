package week10;

/**
 *  A merge sort implementation which is able to be observed through its
 *  Sorter superclass.
 *
 * @author Mike Cui
 */
public class MergeSort extends Sorter {

    /**
     *  Create a new Merge  sorter with the given integers to sort.
     *
     * @param nums the integers to sort.
     */
    public MergeSort(Integer[] nums) {
        super(nums); // pass nums[] to the superclass Sort
    }

    /**
     * Sort the integers (which are stored in the parent Sorter class).
     */
    public void sortNums() {
        // int i, j, comparisons, and nums[] are all protected datafields in
        // the superclass Sort so we can use them without declaring them
        comparisons=0;
        mergeSort(nums);
                  
    }//end method
    /**This is default method to call the real method.
       @param nums the array to be sorted.

       This is only when the programmer is lazy or stupid
    */
    public void mergeSort(Integer [] nums){
        mergeSort(nums,0,nums.length-1);
    }//end method
    /** This is the recursive part of the algorithm.
        @param nums is the array to be sorted
        @param left is the first position of array
        @param right is the last position of array
    */
    public void mergeSort(Integer [] nums,int left,int right){

        if (left<right){
            int  mid= (left +right)/2;
            mergeSort(nums,left,mid);
            mergeSort(nums,mid+1,right);
            merge(nums,left,mid+1,right);
        }//end if

    }//end method
    /** This does the actual merge sorting part.

        @param nums is the array to be sorted
        @param left is the index of the first position of the
        first half of array
        you want to be sorted
        @param mid is the index of the first position of the
        second half of array
        you want to be sorted
        @param right is the index of the last position of the
        second half of array
    */

    public void merge(Integer[] nums,int left,int mid,int right){
        Integer [] temp = new Integer [nums.length];
        for (int index=left;index<=right;index++){
            temp[index]=nums[index];
        }//end for
        int index=left;//I want to make this 0 but I can't
        //as it could be the middle of the array
        int secondArrayStart=mid;
        int firstArrayStart=left;

        while(++comparisons>0 && firstArrayStart<mid &&
              secondArrayStart<=right){
            
            if (++comparisons>0 &&
                temp[firstArrayStart]<temp[secondArrayStart]){

                nums[index++]=temp[firstArrayStart++];
            }else{
                nums[index++]=temp[secondArrayStart++];
            }//end else
            i=firstArrayStart;//just for the gui to work
            j=index;//just for the gui to work
            int  k=secondArrayStart;//just for the gui to work
            update();//just for the gui to work
        }//end while
        while (firstArrayStart<mid){
            nums[index++]=temp[firstArrayStart++];

            i=firstArrayStart;//just for the gui to work
            j=index;//just for the gui to work
            int  k=secondArrayStart;//just for the gui to work
            update();//just for the gui to work
        }//end while

        while (secondArrayStart<=right){
            nums[index++]=temp[secondArrayStart++];

            i=firstArrayStart;//just for the gui to work
            j=index;//just for the gui to work
            int  k=secondArrayStart;//just for the gui to work
            update();//just for the gui to work
        }//end while
        

        i=firstArrayStart;//just for the gui to work
        j=index;//just for the gui to work
        int  k=secondArrayStart;//just for the gui to work
        update();//just for the gui to work
    }//end method
}//end class
