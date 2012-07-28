import org.junit.Assert;
import org.junit.Test;

import static junit.framework.Assert.assertTrue;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertThat;

public class QuickSortTest {
    @Test
    public void should_return_013456910() {
        int[] numbers = new int[]{5, 3, 6, 9, 1, 0, 10, 4};
        QuickSort.sort(numbers, 0, 7);
       assertArrayEquals(numbers,new int[]{0,1,3,4,5,6,9,10});
    }

    @Test
    public void should_return_1(){
        int[] numbers = new int[]{1};
        QuickSort.sort(numbers,0,0);
        assertArrayEquals(numbers,new int[]{1});

        assertTrue(true);

    }
}
