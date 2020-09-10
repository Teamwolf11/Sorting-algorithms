#include <stdio.h>
#include <stdlib.h>
#include <time.h>

#define ARRAY_MAX 30000

/** This is selection sorting at work**/
void selection_sort(int *a, int n) {
    int i,j;
    int smallest,temp;

    
    
    for(i=0;i<n-1;i++){/** go through every number except last*/
        smallest=i;/** set the first number to smallest**/
        for(j=i+1;j<n;j++){ /** find the smallest number
                                out of the remaining list**/
            if(a[j]<a[smallest]){/** if found smaller number
                                     swap with smallest**/
                smallest=j;
            } /*end if loop*/
        }  /* end inner for loop omegalul lmfao */
        temp=a[smallest];/** this is just a swap of the smallest
                             number and the first number of the
                             unsorted array**/
        a[smallest]=a[i];
        a[i]=temp;
        
    }  /* end outer for loopy lol */
}

int main(void) {
    int my_array[ARRAY_MAX];
    clock_t start, end;
    int i, count = 0;

    while (count < ARRAY_MAX && 1 == scanf("%d", &my_array[count])) {
        count++;
    }
    start = clock();
    selection_sort(my_array, count);
    end = clock();

    for (i = 0; i < count; i++) {
        printf("%d\n", my_array[i]);
    }
    fprintf(stderr, "%d %f\n", count, (end - start) / (double)CLOCKS_PER_SEC);

    return EXIT_SUCCESS;
}
