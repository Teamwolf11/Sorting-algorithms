package week09;

/**
 *  A Insertion sorta implementation which is able to be observed through its
 *  Sorter superclass.
 *
 * @author Mikee Cui
 */
public class InsertionSort extends Sorter {
    //fhjkeshkfhkse
    /**
     *  Create a new insertion  sorter with the given integers to sort.
     *
     * @param nums the integers to sort.
     */
    public InsertionSort(Integer[] nums) {
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
        for (int counter = 0; counter < nums.length; counter++) {
            for (j=counter+1;j<nums.length;j++){
                if (++comparisons>0 && nums[counter]>nums[j]){
                    //it will run this and when the 5 is bigger then
                    //the 7 and it will store the 5 in temp (array below)
                    //
                    //7,8,5
                    //
                    //- this is the array i use to understand what i am doing
                    temp=nums[j];
                    int changer=j-1;//this is what is changing the numbers kinda
                    while( changer>=counter && nums[changer]>temp){ 
                        nums[changer+1]=nums[changer];
                        changer--;
                        //the point of this is to move all the numbers up
                        //so that there is a gap for the number 5
                        
                    }//end while
                    
                    nums[++changer]=temp;//this puts the 5 in the right place,
                    //this is at position 0
                    
                    update();
                }//end if
               
            }//end inner for
        }//end outer for
    }//end method sort nums
}//end class
