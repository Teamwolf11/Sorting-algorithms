#include <stdio.h>
#include <stdlib.h>
#include <time.h>

#define ARRAY_MAX 30000

void insertion_sort(int *a, int n) {
    int i,j;
    int key;
    
    for(i=1;i<n;i++){/** go through every number except the
                         first as it will make less sorts**/
        key=a[i];/** set the key as the first number in unsorted
                     array**/
        j=i-1;/** set the j as the last number in the sorted array**/
        while(j>=0 && a[j]>key){
            a[j+1]=a[j];/** move each item that is bigger
                than the key to the right one place
                to make space for the key**/
            j--;  /** DECREMENT J so that while loop will end**/               
        }  /* end inner for loop omegalul lmfao */
        a[j+1]=key;/** put key in the leftmost vacated position**/
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
    insertion_sort(my_array, count);
    end = clock();

    for (i = 0; i < count; i++) {
        printf("%d\n", my_array[i]);
    }
    fprintf(stderr, "%d %f\n", count, (end - start) / (double)CLOCKS_PER_SEC);

    return EXIT_SUCCESS;
}
