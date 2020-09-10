package week10;

/**
 *  A Heap sort implementation which is able to be observed through its
 *  Sorter superclass.
 *
 * @author Mike Cui
 */
public class HeapSort extends Sorter {

    /**
     *  Create a new HeapSort sorter with the given integers to sort.
     *
     * @param nums the integers to sort.
     */
    public HeapSort(Integer[] nums) {
        super(nums); // pass nums[] to the superclass Sort
    }

    /**
     * Sort the integers (which are stored in the parent Sorter class).
     */
    public void sortNums() {
        // int i, j, comparisons, and nums[] are all protected datafields in
        // the superclass Sort so we can use them without declaring them
        comparisons = 0;
        heapify(nums);

        for(int lastNumber=nums.length-1;lastNumber>0;lastNumber--){
            swap(nums,0,lastNumber);
            siftDown(nums,0,lastNumber);
        }
        
    }//sort nums

    
    public void siftDown(Integer[] nums,int index, int length){
        i=index;
        int largestIndex=i;
        
        int l = 2*i+1;
        int r = 2*i+2;
        if(r>=length || nums[r]<nums[l]){
            if(l<length && nums[i]<nums[l] && ++comparisons>0){
                largestIndex=l;
                j=largestIndex;
            }//end if
        }else{//right child exists and is larger than left
            if(nums[i]<nums[r] && ++comparisons>0){
                largestIndex=r;
                j=largestIndex;
            }//end if
        }//end else
        if (largestIndex!=i){
            swap(nums,i,j);
            update();
            largestIndex=j;
        
            siftDown(nums, j,length);
            largestIndex=j;
        }//end if
    }//sift down

    
    public void heapify (Integer[] nums){
        for (int parent=(nums.length-1)/2;parent>=0;parent--){
            siftDown(nums,parent,nums.length);
        }//end for
    
    }//end method heapify

    
    public void swap(Integer []nums,int left,int right){
        int temp=nums[left];
        nums[left]=nums[right];
        nums[right]=temp;
    }//end method swap
    
}
