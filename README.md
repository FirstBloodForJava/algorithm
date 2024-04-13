# algorithm
算法学习
## a.相向双指针
### Solution_1
1.两数之和：https://leetcode.cn/problems/two-sum/description/
暴力解法

hash加速搜索，如暴力搜索的0->n-2，反过来从n-2的顺序查找，当比对的结果较多时，通过hash加快搜索
![image-20240401161124766](http://47.101.155.205/image-20240401161124766.png)

### Solution_2
167.两数之和II-输入有序数组：https://leetcode.cn/problems/two-sum-ii-input-array-is-sorted/description
![image-20240401161410801](http://47.101.155.205/image-20240401161410801.png)

### Solution_3
15.三数之和：https://leetcode.cn/problems/3sum/description
![image-20240401161956826](http://47.101.155.205/image-20240401161956826.png)

![image-20240402194959079](http://47.101.155.205/image-20240402194959079.png)
将给定的数组排好序之后，从i=0开始，则需要从另外一个数组中找到其和为-nums[i]的值，变成了找一个有序数组的两数之和

## b.相向双指针+前缀和
### Solution_1
11.盛最多水的容器：https://leetcode.cn/problems/container-with-most-water/description

![image-20240402200051612](http://47.101.155.205/image-20240402200051612.png)



暴力枚举：固定左边，从右边开始枚举。

![image-20240402213059676](http://47.101.155.205/image-20240402213059676.png)
数组的长度为n
从i=0开始，height[n-1]>=height[0]，则小于n-1再高，和i=0结果都小于(n-1)height[0];

从i=1开始，height[n-1]<height[0]，计算这里的大小和之前的结果比较，取最大值，n-1向左移动，如果其启动后的高度小于上一个高度，则不用比较，比他大才比较(虽然这里少了计算比较次数，但是还是进入了循环); 

直到i<=n-2，循环结束。



![image-20240403090611621](http://47.101.155.205/image-20240403090611621.png)

双指针+贪心

对于一个长度为n的数组，从数组的左右边界开始，这里的容量会是Min(nums[0],nums[n-1]) x(n-1);

假如nums[0]<=nums[n-1]：

这个时候如果n-1向左移动，不管nums[n-2]是变大还是变小Min(nums[0],nums[n-2])x(n-2)都是小于Min(nums[0],nums[n-1])x(n-1)的，这样的比较是没有意义的；

这个时候如果0向右移动，Min(nums[1],nums[n-1])可能大于或小于等于nums[0]，当小于等于nums[1]时，结果都是小于原来的值；当大于nums[0]，则需要计算结果和之前的比较，取最大。左右之间相互靠近，直到边界重合。

### Solution_2
42.接雨水：https://leetcode.cn/problems/trapping-rain-water/description/

![image-20240403121855342](http://47.101.155.205/image-20240403121855342.png)

#### 动态规划

![image-20240403191106379](http://47.101.155.205/image-20240403191106379.png)

用两个数组记录当前i的左边的最大值及右边的最大值，依次计算每个i能容纳的雨水的容量。



#### 双指针

![image-20240403194841306](http://47.101.155.205/image-20240403194841306.png)



#### 单调栈

![image-20240403200749762](http://47.101.155.205/image-20240403200749762.png)

前面这个单调栈不行，是因为下一个最大值不是右边的最大值，和动态规划的不一样。

![image-20240403204840626](http://47.101.155.205/image-20240403204840626.png)



## c.滑动窗口

### Solution_1

209.长度最小的子数组：https://leetcode.cn/problems/minimum-size-subarray-sum/description/

![image-20240403210230162](http://47.101.155.205/image-20240403210230162.png)

### Solution_2

713.乘积小于K的子数组：https://leetcode.cn/problems/subarray-product-less-than-k/description/

![image-20240403210405436](http://47.101.155.205/image-20240403210405436.png)

这个问题的关键在于从left到right刚好大于等于k的指针移动情况处理。

当nums[left] x nums[left+1] x nums[right-1] xnums[right] = s >= k
当left<right时[left,right-1]的乘积和s肯定时小于k的
当left=right时[left,left]本身s肯定是大于等于k的
while s >= k进行循环时，如果端点右移,s/nums[left] < k，循环退出，记录当前不需要遍历端点长度；否则继续右移，记录left+1到right-1连续数组长度，直到left==right或s/nums[left] < k，退出循环；
如果这个时候left==right，s = 1，如果继续拿这个s去和k比较肯定会出问题，应该是需要退出循环，并且left右移
即

~~~java
while (s >= k) {
	s = s / nums[left];
	left++;
	if(left == right){
		left++;
		break;
	}
	if(s < k) {
		//加上left+1端点到right的连续数组长度，退出循环
		right - left + 1;
	}else{
		记录left+1端点到right的连续数组长度，继续移动，直到left==right或left==right
		right - left;
	}
	
}

~~~





### Solution_3

3.无重复字符的最长字串：https://leetcode.cn/problems/longest-substring-without-repeating-characters/description/

![image-20240403210531655](http://47.101.155.205/image-20240403210531655.png)



## d.二分查找

34.在排序数组中查找元素的第一个和最后一个位置：https://leetcode.cn/problems/find-first-and-last-position-of-element-in-sorted-array/description/

![image-20240412195702339](http://47.101.155.205/image-20240412195702339.png)

### 思路一

left即第一个大于等于(等于)target的index

right即最后一个小于等于(等于)target的index



### 思路二

left即第一个大于等于(等于)target的index

right即第一个大于target的index-1



### 思路三

二分查找target的left即可能大于等于target的index(如果target>nums[length-1]，则left为length)

数组升序，则第一个大于等于target+1的index-1即最后一个target

~~~java
public int searchBound(int[] nums, int target) {
    int left = 0;
    int right = nums.length - 1;
    while(left <= right) {
        int mid = (right - left) / 2 + left;
        if(nums[mid] >= target) {
            right = mid - 1;
        }else {
            left = mid + 1;
        }
    }
    return left;
}

~~~





## e.二分查找进阶

### 162

162.寻找峰值：https://leetcode.cn/problems/find-peak-element/description/

![image-20240413165622186](http://47.101.155.205/image-20240413165622186.png)

对于其中任意的元素下标i，其左右两边情况只有以下4种情况

1. nums[i-1]<nums[i]<nums[i+1]
2. nums[i-1]<nums[i]>nums[i+1]就是峰值
3. nums[i-1]>nums[i]>nums[i+1]
4. nums[i-1]>nums[i]<nums[i+1]

因为nums[-1]=nums[n]=最小，且满足nums[i]!=nums[i+1]情况，所以当nums[i-1]<nums[i]时，往左边查找，可能出现一直递减的情况，没有意义；同理，当nums[i]>nums[i+1]时往右查找也是如此；第4种情况往左往右查找都可以。



### 153

153.寻找旋转排序数组中的最小值：https://leetcode.cn/problems/find-minimum-in-rotated-sorted-array/description/

![image-20240413165912877](http://47.101.155.205/image-20240413165912877.png)

对于这个旋转数组，当旋转不为n次时，nums[0]>nums[n-1]，所以当nums[0]<nums[n-1]时，意味着旋转了n次，0即是最小，n=1时，nums[0]<=nums[n-1]，0即时最小。

对于中间的mid，nums[mid] > nums[0]，[left,mid]肯定升序的所以left=mid+1

对于nums[mid]<nums[0]，[mid,right]也是升序的，right=mid



### 33

33.搜索旋转排序数组：https://leetcode.cn/problems/search-in-rotated-sorted-array/description/

![image-20240413170130140](http://47.101.155.205/image-20240413170130140.png)

假设这个旋转数组对于的最小值所以为x，则[0,x-1]，[x,length-1]是递增的。

当nums[mid]!=target时，我们可以通过nums[mid]和nums[length-1]比较确定部分的有序数组情况。例如

如果nums[mid] > nums[length-1]，则[left,mid]，是升序的，如果target<nums[mid]且target>=nums[0]，则可以在[left,mid]区间进行二分查找，即right=mid-1，否则left=mid+1，两种情况，target>nums[mid]需要往右遍历寻找更大值；target<nums[0]在较小的旋转数组处。

当nums[mid]<=nums[length-1]，则[mid,length-1]是升序的，如果target>nums[mid]且target<=nums[length-1]，则可以在[mid,length-1]进行二分查找，即left=mid+1，否则right=mid-1,两种情况，target>nums[length-1]，需要往左找更大的值，target<num[mid]，需要玩左找更小的值。





## f.反转链表

### 206

206.反转链表：https://leetcode.cn/problems/reverse-linked-list/description/

![image-20240413171029806](http://47.101.155.205/image-20240413171029806.png)

### 92

92.反转链表 II：https://leetcode.cn/problems/reverse-linked-list-ii/description/

![image-20240413171254226](http://47.101.155.205/image-20240413171254226.png)

### 25

25.K 个一组翻转链表：https://leetcode.cn/problems/reverse-nodes-in-k-group/description/

![image-20240413171425645](http://47.101.155.205/image-20240413171425645.png)