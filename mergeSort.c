#include <stdio.h>
#include <stdlib.h>
#include <time.h>

#define ARRAY_MAX 100000

void merge(int *a, int *w, int mid, int n) {
    int i;
    int left = 0;
    int right = mid;
    int counter = 0;

    while(left < mid && right < n) {
        if(a[left] < a[right]) {
            w[counter] = a[left];
            left++;
        } else {
            w[counter] = a[right];
            right++;
        }
        counter++;
    } /* end while method */


    while(left < mid){
        w[counter] = a[left];
        left++;
        counter++;
    } /* end while for left */

    while(right < n){
        w[counter] = a[right];
        right++;
        counter++;
    } /* end while for the right */

    for (i = 0; i < n; i++) {
        a[i] = w[i];

    } /* end while loop */
    
} /* end merge method */

void mergeSort(int *a, int *w, int n){
    int mid = n/2;
    
    if(n < 2){
        return;
    }

    mergeSort(a, w, mid);
    mergeSort(a + mid, w, n - mid);

    merge(a, w, mid, n);

    return;
}  /* end method mergesort */
    
int main(void) {
    int holdStuffArray[ARRAY_MAX];
    int my_array[ARRAY_MAX];
    clock_t start, end;
    int i, count = 0;

    while (count < ARRAY_MAX && 1 == scanf("%d", &my_array[count])) {
        count++;
    }
    start = clock();
    mergeSort(my_array, holdStuffArray, count);
    end = clock();

    for (i = 0; i < count; i++) {
        printf("%d\n", my_array[i]);
    }
    fprintf(stderr, "%d %f\n", count, (end - start) / (double)CLOCKS_PER_SEC);

    return EXIT_SUCCESS;
}
