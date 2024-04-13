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

