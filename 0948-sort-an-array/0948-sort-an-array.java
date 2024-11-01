import java.util.Random;

class Solution {
    public int[] sortArray(int[] nums) {
        quickSort(nums, 0, nums.length - 1);
        return nums;
    }

    private void quickSort(int[] nums, int low, int high) {
        if (low < high) {
            int partition = partitionFunc(nums, low, high);
            quickSort(nums, low, partition - 1);
            quickSort(nums, partition + 1, high);
        }
    }

    private int partitionFunc(int[] nums, int low, int high) {
        // Median-of-three pivot selection
        int pivotIndex = medianOfThree(nums, low, high);
        int pivot = nums[pivotIndex];
        swap(nums, pivotIndex, low); // Move pivot to the start

        int l = low + 1;
        int r = high;

        while (l <= r) {
            while (l <= high && nums[l] <= pivot) {
                l++;
            }
            while (r > low && nums[r] > pivot) {
                r--;
            }
            if (l < r) {
                swap(nums, l, r);
            }
        }

        swap(nums, low, r); // Move pivot to its final place
        return r;
    }

    private int medianOfThree(int[] nums, int low, int high) {
        int mid = low + (high - low) / 2;
        if (nums[low] > nums[mid]) swap(nums, low, mid);
        if (nums[low] > nums[high]) swap(nums, low, high);
        if (nums[mid] > nums[high]) swap(nums, mid, high);
        return mid;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
