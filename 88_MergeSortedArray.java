class Solution {
    
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        
        // Sorting O((m+n)lg(m+n)) - Runtime: 1 ms, Memory: 39.8 MB
        /* for (int i=0; i<n; i++) {
            nums1[i+m] = nums2[i];
        }
        Arrays.sort(nums1);
        return; */
        
        // Two pointers approach O(m+n) - Runtime: 0 ms, Memory: 39.6 MB
        int i=m-1, j=n-1, idx=m+n-1;
        while (i>=0 && j>=0) {
            if (nums1[i] > nums2[j]) {
                nums1[idx--] = nums1[i--];
            } else {
                nums1[idx--] = nums2[j--];
            }
        }
        while (i >= 0) {
            nums1[idx--] = nums1[i--];
        }
        while (j >= 0) {
            nums1[idx--] =  nums2[j--];
        }
        return;
    }
}

// My solution
class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] ans = new int[m + n];
        if (n == 0) return;
        if (m == 0) {
            for (int i=0; i<n; i++) {
                nums1[i] = nums2[i];
            }
            return;
        }
        int i = 0, j = 0, idx = 0;
        while (idx < ans.length && i < m && j < n) {
            if (nums1[i] <= nums2[j]) {
                ans[idx] = nums1[i];
                i++;
            } else {
                ans[idx] = nums2[j];
                j++;
            }
            idx++;
        }
        while (i < m) {
            ans[idx] = nums1[i];
            i++;
            idx++;
        }
        while (j < n) {
            ans[idx++] = nums2[j++];
        }
        for (idx = 0; idx < ans.length; idx++) {
            nums1[idx] = ans[idx];
        }
    }
}
