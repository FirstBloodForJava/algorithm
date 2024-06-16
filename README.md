# algorithm
算法学习
## a.相向双指针

两个变量，固定一个变量，把它当成常量看待，从而转化成了一个变量的问题。

### 1
1.两数之和：https://leetcode.cn/problems/two-sum/description/
暴力解法

hash加速搜索，如暴力搜索的0->n-2，反过来从n-2的顺序查找，当比对的结果较多时，通过hash加快搜索
![image-20240401161124766](http://47.101.155.205/image-20240401161124766.png)

### 167
167.两数之和II-输入有序数组：https://leetcode.cn/problems/two-sum-ii-input-array-is-sorted/description
![image-20240401161410801](http://47.101.155.205/image-20240401161410801.png)

### 15
15.三数之和：https://leetcode.cn/problems/3sum/description
![image-20240401161956826](http://47.101.155.205/image-20240401161956826.png)

![image-20240402194959079](http://47.101.155.205/image-20240402194959079.png)
将给定的数组排好序之后，从i=0开始，则需要从另外一个数组中找到其和为-nums[i]的值，变成了找一个有序数组的两数之和。



### 16

16.最接近的三数之和：https://leetcode.cn/problems/3sum-closest/description/

![image-20240521215112325](http://47.101.155.205/image-20240521215112325.png)





### 18

18.四数之和：https://leetcode.cn/problems/4sum/description/

![image-20240521215328962](http://47.101.155.205/image-20240521215328962.png)

### 219

219.存在重复元素 II：https://leetcode.cn/problems/contains-duplicate-ii/description/

![image-20240521215516178](http://47.101.155.205/image-20240521215516178.png)



### 611

611.有效三角形的个数：https://leetcode.cn/problems/valid-triangle-number/description/

![image-20240521215633925](http://47.101.155.205/image-20240521215633925.png)



### 1010

1010.总持续时间可被60整除的歌曲：https://leetcode.cn/problems/pairs-of-songs-with-total-durations-divisible-by-60/description/

![image-20240521215751579](http://47.101.155.205/image-20240521215751579.png)



### 1512

1512.好数对的数目：https://leetcode.cn/problems/number-of-good-pairs/description/

![image-20240521215918669](http://47.101.155.205/image-20240521215918669.png)



### 2748

2748.美丽下标对的数目：https://leetcode.cn/problems/number-of-beautiful-pairs/description/

![image-20240521220006447](http://47.101.155.205/image-20240521220006447.png)

### 2824

2824.统计和小于目标的下标对数目：https://leetcode.cn/problems/count-pairs-whose-sum-is-less-than-target/description/

![image-20240521220155466](http://47.101.155.205/image-20240521220155466.png)



## b.相向双指针+前缀和
### 11
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

### 42
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

### 209

209.长度最小的子数组：https://leetcode.cn/problems/minimum-size-subarray-sum/description/

![image-20240403210230162](http://47.101.155.205/image-20240403210230162.png)

### 713

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





### 3

3.无重复字符的最长字串：https://leetcode.cn/problems/longest-substring-without-repeating-characters/description/

![image-20240403210531655.png](http://47.101.155.205/image-20240403210531655.png)



## ca.定长滑动窗口

### 1456-1263

1456.定长子串中元音的最大数目: https://leetcode.cn/problems/maximum-number-of-vowels-in-a-substring-of-given-length/description/

![image-20240529210843747](http://47.101.155.205/image-20240529210843747.png)



### 2269-1280

2269.找到一个数字的K美丽值: https://leetcode.cn/problems/find-the-k-beauty-of-a-number/description/

![image-20240529211028079](http://47.101.155.205/image-20240529211028079.png)



### 1984-1306

1984.学生分数的最小差值: https://leetcode.cn/problems/minimum-difference-between-highest-and-lowest-of-k-scores/description/

![image-20240529211222956](http://47.101.155.205/image-20240529211222956.png)



### 643

643.子数组最大平均数I: https://leetcode.cn/problems/maximum-average-subarray-i/description/

![image-20240529211356317](http://47.101.155.205/image-20240529211356317.png)



### 1343-1317

1343.大小为K且平均值大于等于阈值的子数组数目: https://leetcode.cn/problems/number-of-sub-arrays-of-size-k-and-average-greater-than-or-equal-to-threshold/description/

![image-20240529211514872](http://47.101.155.205/image-20240529211514872.png)



### 2090-1358

2090.半径为k的子数组平均值: https://leetcode.cn/problems/k-radius-subarray-averages/description/





### 2379-1360



### 1052-1418



### 2841-1546



### 2461-1553



### 1423-1574



### 2134-1748



### 2653-1786



### 567



### 438



### 2156-2063



### 2963-2449







## cb.不定长滑动窗口(求最长/最大)

### 3

3.无重复字符的最长字串：https://leetcode.cn/problems/longest-substring-without-repeating-characters/description/

![image-20240403210531655.png](http://47.101.155.205/image-20240403210531655.png)



### 1493-1423

1493.删掉一个元素以后全为 1 的最长子数组：https://leetcode.cn/problems/longest-subarray-of-1s-after-deleting-one-element/description/

![image-20240603212201074](http://47.101.155.205/image-20240603212201074.png)



### 2730-1502

2730.找到最长的半重复子字符串：https://leetcode.cn/problems/find-the-longest-semi-repetitive-substring/

![image-20240604103903707](http://47.101.155.205/image-20240604103903707.png)

### 904-1516



### 1695-1529



### 2958-1535



### 2024-1643



### 1004-1656



### 1438-1672



### 2401-1750



### 1658-1817



### 1838-1876



### 2516-1948



### 2831-1976



### 2106-2062



### 1610-2147



### 2781-2204



### 2968-2444



### 395



### 1763






## cc.不定长滑动窗口(求最短/最小)

### 209

209.长度最小的子数组：https://leetcode.cn/problems/minimum-size-subarray-sum/description/

![image-20240403210230162](http://47.101.155.205/image-20240403210230162.png)



### 1234-1878

1234.替换子串得到平衡字符串：https://leetcode.cn/problems/replace-the-substring-for-balanced-string/

![image-20240604135935102](http://47.101.155.205/image-20240604135935102.png)



### 1574-1932

1574.删除最短的子数组使剩余数组有序：https://leetcode.cn/problems/shortest-subarray-to-be-removed-to-make-array-sorted/

![image-20240604212929879](http://47.101.155.205/image-20240604212929879.png)



### 76

76.最小覆盖子串：https://leetcode.cn/problems/minimum-window-substring/

![image-20240604213500193](http://47.101.155.205/image-20240604213500193.png)

### 面试题 17.18. 最短超串

面试题 17.18. 最短超串：https://leetcode.cn/problems/shortest-supersequence-lcci/

![image-20240604214119174](http://47.101.155.205/image-20240604214119174.png)







## cd.不定长滑动窗口(求子数组个数)

### 2799-1398

2799.统计完全子数组的数目：https://leetcode.cn/problems/count-complete-subarrays-in-an-array/

![image-20240612212908257](http://47.101.155.205/image-20240612212908257.png)



### 713

713.乘积小于K的子数组：https://leetcode.cn/problems/subarray-product-less-than-k/description/

![image-20240403210405436](http://47.101.155.205/image-20240403210405436.png)



### 1358-1646

1358.包含所有三种字符的子字符串数目: https://leetcode.cn/problems/number-of-substrings-containing-all-three-characters/description/

![image-20240613213831312](http://47.101.155.205/image-20240613213831312.png)

### 2962-1701

2962.统计最大元素出现至少K次的子数组: https://leetcode.cn/problems/count-subarrays-where-max-element-appears-at-least-k-times/description/

![image-20240613214222372](http://47.101.155.205/image-20240613214222372.png)



### 2302-1808

2302.统计得分小于K的子数组数目: https://leetcode.cn/problems/count-subarrays-with-score-less-than-k/description/

![image-20240613214510985](http://47.101.155.205/image-20240613214510985.png)



### 2537-1892



### 2762-1940



### 2972-2153





## ce.多指针滑动窗口

### 930-1592

930.和相同的二元子数组: https://leetcode.cn/problems/binary-subarrays-with-sum/description/

![image-20240613215230011](http://47.101.155.205/image-20240613215230011.png)



### 1248-1624

1248.统计[优美子数组]https://leetcode.cn/problems/count-number-of-nice-subarrays/

![image-20240613215230011](http://47.101.155.205/image-20240613215624749.png)



### 2563-1721

2563.统计公平数对的数目: https://leetcode.cn/problems/count-the-number-of-fair-pairs/

![image-20240613215230011](http://47.101.155.205/image-20240613215824638.png)





### 1712-2079



### 2444-2093



### 992-2210







## d.二分查找

### 34

34.在排序数组中查找元素的第一个和最后一个位置：https://leetcode.cn/problems/find-first-and-last-position-of-element-in-sorted-array/description/

![image-20240412195702339](http://47.101.155.205/image-20240412195702339.png)

#### 思路一

left即第一个大于等于(等于)target的index

right即最后一个小于等于(等于)target的index



#### 思路二

left即第一个大于等于(等于)target的index

right即第一个大于target的index-1



####  思路三

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



### 35

35.搜索插入位置: https://leetcode.cn/problems/search-insert-position/description/

![image-20240616214656444](http://47.101.155.205/image-20240616214656444.png)



### 704

704.二分查找: https://leetcode.cn/problems/binary-search/description/

![image-20240616215521989](http://47.101.155.205/image-20240616215521989.png)



### 744

744.寻找比目标字母大的最小字母: https://leetcode.cn/problems/find-smallest-letter-greater-than-target/description/

![image-20240616215901825](http://47.101.155.205/image-20240616215901825.png)



### 2529

2529.正整数和负整数的最大计数: https://leetcode.cn/problems/maximum-count-of-positive-integer-and-negative-integer/description/

![image-20240616220541278](http://47.101.155.205/image-20240616220541278.png)



### 2300-1400

2300.咒语和药水的成功对数: https://leetcode.cn/problems/successful-pairs-of-spells-and-potions/description/

![image-20240616220919399](http://47.101.155.205/image-20240616220919399.png)



### 2389

2389.和有限的最长子序列: https://leetcode.cn/problems/longest-subsequence-with-limited-sum/description/

![image-20240616221521830](http://47.101.155.205/image-20240616221521830.png)



### 1170



### 2080-1702



### 2563-1721



### 2856-1721



### 981



### 1146-1771



### 1818-1934



### 911-2001



### LCP08



## da.二分查找-求最小

### 1283-1542






### 2187-1641



### 2871-1676



### 1011-1725



### 875-1766



### 475



### 1385



### 2594-1915



### 1946



### 3048-2263



### 3049-3111





## db.二分查找-求最大

### 275



### 2226-1646



### 1898-1913



### 1802-1929



### 1642-1962



### 2861-1981





### 3007-2258



### 2141-2265



### 2258-2347



### 2071-2648



## dc.计算间接结果

### 3143-1600



## dd.最小化最大值

### 410



### 2064-1886



### 1760-1940



### 1631-1948



### 2439-1965



### 2560-2081



### 778



### 2616-2155



### 2516-2302


### de.最大化最小值

### 2517-2021



### 1552-2021



### 2812-2154



### 2528-2236



### LCP12



## de.第k小/大

### 378



### 668



### 373



### 719



### 878-1897



### 1201-2039



### 793-2100



### 1439-2134



### 786-2169



### 3116-2387



### 3134-2400



### 2040-2518



### 2386-2648



### 1508



## df.其他

### 2476



### 74



### 240



### 278



### 374



### 162



### 1901



### 852



### 1095-1827



### 153



### 33



### 1539



### 540



### 4









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



## g.快慢指针

### 876

876.链表的中间结点：https://leetcode.cn/problems/middle-of-the-linked-list/description/

![image-20240414180258138](http://47.101.155.205/image-20240414180258138.png)

### 141

141.环形链表：https://leetcode.cn/problems/linked-list-cycle/description/

![image-20240414180425696](http://47.101.155.205/image-20240414180425696.png)

### 142

142.环形链表 II：https://leetcode.cn/problems/linked-list-cycle-ii/description/

![image-20240414180547708](http://47.101.155.205/image-20240414180547708.png)



### 143

143.重排链表：https://leetcode.cn/problems/reorder-list/description/

![image-20240414180712223](http://47.101.155.205/image-20240414180712223.png)



## h.前后指针

### 237

237.删除链表中的节点：https://leetcode.cn/problems/delete-node-in-a-linked-list/description/

![image-20240415210735285](http://47.101.155.205/image-20240415210735285.png)

![image-20240415210802812](http://47.101.155.205/image-20240415210802812.png)



### 19 

19.删除链表的倒数第 N 个结点：https://leetcode.cn/problems/remove-nth-node-from-end-of-list/description/

![image-20240415210902897](http://47.101.155.205/image-20240415210902897.png)



### 83

83.删除排序链表中的重复元素：https://leetcode.cn/problems/remove-duplicates-from-sorted-list/description/

![image-20240415211147556](http://47.101.155.205/image-20240415211147556.png)

### 82

82.删除排序链表中的重复元素 II：https://leetcode.cn/problems/remove-duplicates-from-sorted-list-ii/description/

![image-20240415211320608](http://47.101.155.205/image-20240415211320608.png)



## i.二叉树入门

### 104

104.二叉树的最大深度：https://leetcode.cn/problems/maximum-depth-of-binary-tree/description/

![image-20240416205712618](http://47.101.155.205/image-20240416205712618.png)

## j.二叉树相同/对称/平衡

### 100

100.相同的树：https://leetcode.cn/problems/same-tree/description/

![image-20240416210209641](http://47.101.155.205/image-20240416210209641.png)

### 101

101.对称二叉树：https://leetcode.cn/problems/symmetric-tree/description/

![image-20240416210314097](http://47.101.155.205/image-20240416210314097.png)

![image-20240416210331516](http://47.101.155.205/image-20240416210331516.png)

### 110

110.平衡二叉树：https://leetcode.cn/problems/balanced-binary-tree/description/

![image-20240416210508801](http://47.101.155.205/image-20240416210508801.png)

![image-20240416210526935](http://47.101.155.205/image-20240416210526935.png)



### 199

199.二叉树的右视图：https://leetcode.cn/problems/binary-tree-right-side-view/description/

![image-20240416210643370](http://47.101.155.205/image-20240416210643370.png)



## k.二叉树搜索

### 98

98.验证二叉搜索树：https://leetcode.cn/problems/validate-binary-search-tree/

![image-20240424205913657](http://47.101.155.205/image-20240424205913657.png)

## l.二叉树

### 236

236.二叉树的最近公共祖先：https://leetcode.cn/problems/lowest-common-ancestor-of-a-binary-tree/description/

![image-20240425200321937](http://47.101.155.205/image-20240425200321937.png)



### 235

235.二叉搜索树的最近公共祖先：https://leetcode.cn/problems/lowest-common-ancestor-of-a-binary-search-tree/

![image-20240425200427349](http://47.101.155.205/image-20240425200427349.png)



## m.二叉树-层序遍历

### 102

102.二叉树的层序遍历：https://leetcode.cn/problems/binary-tree-level-order-traversal/description/

![image-20240427181342845](http://47.101.155.205/image-20240427181342845.png)



### 103

103.二叉树的锯齿形层序遍历：https://leetcode.cn/problems/binary-tree-zigzag-level-order-traversal/

![image-20240427181559146](http://47.101.155.205/image-20240427181559146.png)

### 513

513.找树左下角的值：https://leetcode.cn/problems/find-bottom-left-tree-value/

![image-20240427181819009](http://47.101.155.205/image-20240427181819009.png)



## n.回溯-子集型

回溯三问：

1. 当前操作？每一步的操作是什么？
2. 子问题？
3. 下一个子问题？

### 17

17.电话号码的字母组合：https://leetcode.cn/problems/letter-combinations-of-a-phone-number/

![image-20240428223923028](http://47.101.155.205/image-20240428223923028.png)

![image-20240501160650151](http://47.101.155.205/image-20240501160650151.png)

1. 当前操作？枚举当前i需要填入的字母，path[i]=[a,b,c]
2. 子问题？构造字符串>=i的部分
3. 下一个子问题？构造字符串>=i+1的部分

~~~java
// 核心代码
int n;// length
int s;
List<String> ans = new ArrayList<>();
char[] path = new char[n];
private void dfs(int i) {
    if(i == n) {
        ans.add(new String(path));
        return;
    }
    // get方法根据数组获得对于的字母
    for(char c : get(s.chatAt(i))) {
        path[i] = c;
        dfs(i+1);
    }
}

~~~



### 78

78.子集：https://leetcode.cn/problems/subsets/

![image-20240428224017653](http://47.101.155.205/image-20240428224017653.png)

#### 方式一：选/不选

![image-20240501162716709](http://47.101.155.205/image-20240501162716709.png)

1. 当前操作？枚举nums[i]，选/不选
2. 子问题？从下标>=i中构造子集
3. 下一个子问题？从下标>=i+1中构造子集

~~~java
// 核心代码
private void dfs(int i, int n, int[] nums, List<Integer> path, List<List<Integer>> ans) {
    if(i == n) {
        ans.add(new ArrayList<>(path));
        return;
    }
    // 不选
    dfs(i+1, n, nums, path, ans);
    // 选
    path.add(nums[i]);
    dfs(i+1, n, nums, path, ans);
    
    // 恢复，递归往回走的时候要将添加的元素移除
    path.remove(path.size()-1);
}

~~~



#### 方式二：答案

![image-20240501163855856](http://47.101.155.205/image-20240501163855856.png)

[1,2,3]

第一层[]

第二层[1]；[2]；[3]

第三层[1,2]，[1,3]；[2,3]；

第四层[1,2,3]



1. 当前操作？枚举一个下标j>=i的加入path
2. 子问题？从下标>=j的数字中构造子集
3. 下一个子问题？从下标>=j+1的数字中构造子集

~~~java
// 核心代码
private void dfs(int i, int n, int[] nums, List<Integer> path, List<List<Integer>> ans) {
    // 先记录答案，每个节点都是结果
    ans.add(new ArrayList<>(path));
    if(i == n) {
        return;
    }
    for(int j = i; j < n, j++) {
        // 选
        path.add(nums[j]);
    	dfs(j+1, n, nums, path, ans);
        // 恢复，递归往回走的时候要将添加的元素移除
        path.remove(path.size()-1);
    }
}

~~~





### 131

131.分割回文串：https://leetcode.cn/problems/palindrome-partitioning/

![image-20240428224132171](http://47.101.155.205/image-20240428224132171.png)

#### 方式一：答案

![image-20240502123400590](http://47.101.155.205/image-20240502123400590.png)

1. 当前操作？选择回文字串s[i,j]，加入path
2. 子问题？从下标>=i(j)的后缀中构造回文分割字串
3. 下一个子问题？从下标>=j+1的后缀中构造回文分割

~~~java
// 核心代码
private void dfs(int i, String s, List<String> path, List<List<String>> ans) {
    if (i == s.length()) {
        ans.add(new ArrayList<>(path));
        return;
    }
    for(int j = i; j < s.length(); j++) {
        // 判断字串是否回文
        if(isPalindrome(i, j)) {
            path.add(s.substring(i, j+1));
            dfs(j+1, s, path, ans);
            path.remove(path.size()-1);
        }
    }
}

~~~



#### 方式二：选/不选

![image-20240502190140372](http://47.101.155.205/image-20240502190140372.png)

1. 当前操作？对s[start,i]不选/选(为回文串选或i=n-1回文串时选)
2. 子问题？从start到i中构造回文串
3. 下一个子问题？从>=i+1再构造回文串

~~~java
// 核心代码
private void dfs(int i, int start) {
    if(i == n) {
        // 记录答案,退出循环
        ans.add(new ArrayList<>(path));
        return;
    }
    if(i < n-1) {
        // 不选
        dfs(i+1, start);
    }
    // 是回文串选
    if(check(start, i)) {
        // 记录答案
        path.add(s.substring(i, j+1));
        dfs(i+1, i+1);
        // 恢复现场
        path.remove(path.size()-1);
    }
    
}

~~~





## o.回溯-组合型

### 77

77.组合：https://leetcode.cn/problems/combinations/

![image-20240428224432510](http://47.101.155.205/image-20240428224432510.png)

### 216

216.组合总和 III：https://leetcode.cn/problems/combination-sum-iii/

![image-20240428224522034](http://47.101.155.205/image-20240428224522034.png)

### 22

22.括号生成：https://leetcode.cn/problems/generate-parentheses/

![image-20240428224614260](http://47.101.155.205/image-20240428224614260.png)

![image-20240502212018400](http://47.101.155.205/image-20240502212018400.png)



## p.回溯-排列型

###46

46.全排列：https://leetcode.cn/problems/permutations/

![image-20240428224921886](http://47.101.155.205/image-20240428224921886.png)

chose中记录未选的数字

1. 当前操作？从chose枚举path中要填的数字x
2. 子问题？构造排列>=i的部分，剩余未选的数字集合中chose
3. 下一个子问题？构造排列>=i+1的部分，剩余未选的数字集合chose-x

![image-20240502220623014](http://47.101.155.205/image-20240502220623014.png)



### 51

51.N皇后：https://leetcode.cn/problems/n-queens/

![image-20240428225020151](http://47.101.155.205/image-20240428225020151.png)

![image-20240503090622772](http://47.101.155.205/image-20240503090622772.png)



## q.动态规划

### 198

198.打家劫舍：https://leetcode.cn/problems/house-robber/description/

![image-20240504160221885](http://47.101.155.205/image-20240504160221885.png)

![image-20240506140852398](http://47.101.155.205/image-20240506140852398.png)



### 0-1背包动态规划方程推导

**递归的初始值就是递归的边界条件**

~~~java
return dfs(weight, value, weight.length-1, c);
// 回溯
private int dfs(int[] weight, int[] value, int i, int c) {
    if (i < 0 || c == 0) {
        return 0;
    }
    if (c < weight[i]) {
        // 容量不够
        return dfs(weight, value, i-1, c);
    }
    return Math.max(dfs(weight, value, i-1, c), dfs(weight, value, i-1, c-weight[i])+value[i]);

}

// 回溯+记忆集搜索
int[][] dp = new int[weight.length][c+1];
// dp[i][j]可以解释为从[0-i]选任意个物品，在对应背包容量为j的情况下的最大价值
for (int[] ints : dp) {
	Arrays.fill(ints, -1);
}
private int dfs(int[] weight, int[] value, int i, int c, int[][] dp) {
    if (i < 0 || c == 0) return 0;
    if(dp[i][c] != -1) {
        return dp[i][c];
    }
    if(c < weight[i]) {
        dp[i][c] = dfs(weight, value, i-1, c, dp);
    }else {
        dp[i][c] = Math.max(dfs(weight, value, i-1, c, dp), dfs(weight, value, i-1, c-weight[i], dp)+value[i]);
    }
    return dp[i][c];
}

dp[i][j]当i=weight.length-1,j=c时,即从0-n中选出任意个物品，在背包容量为c的时最大价值;
对于dp[0][j],可以有:
for(int j = weight[0]; j <= c; j++){ dp[0][j] = value[0]}当weight[0] > c时这一排的最大价值都是0,当weight[0]<c时,[weight[0],c]的最大价值就是value[0];
当i=1时，对应dp[1][j]可以用这个表达式计算:
dp[1][j] = max(dp[0][j], dp[0][j-weight[1]]+value[1]);其实这个表达式也就是动态规划方程
dp[i][j] = max(dp[i-1][j], dp[i-1][j-weight[i]]+value[i]);
// 代码实现
private int method_3(int[] weight, int[] value, int c){
    int[][] dp = new int[weight.lenght][c+1];
    for(int j = weight[0]; j <= c; j++) {
        dp[0][j] = value[0];
    }
    for(int i = 1; i < weight.length; i++) {
        for(int j = 0; j <= c; j++) {
            if(weight[i] > c) {
                dp[i][j] = dp[i-1][j];
            }else {
                dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-weight[i]]+value[i]);
            }
        }
    }
    return dp[weight.length-1][c];
}

// 滚动数组优化时间复杂度，由于上一层的结果会复制到下一层来，可以使用滚动数组来实现
private int method_4(int[] weight, int[] value, int c) {
    int[] dp = new int[c+1];
    for(int j = weight[0]; j <= c; j++) {
        dp[j] = value[0];
    }
    for(int i = 1; i < weight.length; i++) {
        // 这里需要从大到小遍历，因为dp[i-1]在前面被修改之后，可能会被dp[i]使用到
        // 
        for(int j = c; j > 0; j--) {
            if(weight[i] <= c) {
                dp[j] = Math.max(dp[j], dp[j-weight[i]]+value[i]);
            }
        }
    }
    return dp[c];
}

~~~



### 完全背包动态规划方程推导

**递归的初始值就是递归的边界条件**

~~~java
public int method_1(int[] weight, int[] value, int target) {
	return dfs_1(weight, value, target, weight.length-1);
}

private int dfs_1(int[] weight, int[] value, int target, int i) {
	if (i < 0 || target <= 0) return 0;
    if (weight[i] > target) {
        return dfs_1(weight, value, target, i-1);
    }else {
        return Math.max(dfs_1(weight, value, target, i-1), dfs_1(weight, value, target-weight[i], i)+value[i]);
    }

}

// 递推实现
private int method_2(int[] weight, int[] value, int target) {
    int n = weight.length;
    int[][] dp = new int[n][target+1];
    for(int j = weight[0]; j <= target; j++) {
        dp[0][j] = dp[0][j-weight[0]] + value[i];
    }
    for(int i = 1; i < n; i++) {
        for(int j = 0; j <= target; j++) {
            if (weight[i] > j) {
                dp[i][j] = dp[i-1][j];
            }else {
                dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-weight[i]] + value[i])
            }
        }
    }
    return dp[n-1][target];
}

public int method_4(int[] weight, int[] value, int target) {

	int n = weight.length;
	int[] dp = new int[target+1];
	for (int j = weight[0]; j <= target; j++) {
    	dp[j] = dp[j-weight[0]] + value[0];
    }
    for (int i = 1; i < n; i++) {
        // 注意这里与0-1背包不同，这里是从头开始遍历
        for (int j = weight[i]; j <= target; j++) {
            // 解决多选的问题
            dp[j] = Math.max(dp[j], dp[j-weight[i]] + value[i]);
        }
    }
	return dp[target];
}

~~~





## r.0-1背包

### 494

494.目标和：https://leetcode.cn/problems/target-sum/

![image-20240504160655803](http://47.101.155.205/image-20240504160655803.png)



### 322

322.零钱兑换：https://leetcode.cn/problems/coin-change/

![image-20240504160715040](http://47.101.155.205/image-20240504160715040.png)



### 背包变形题目

1. 至多装target，求方案数/最大价值和
2. 恰好装target，求方案数(0-1背包494)/最大价值和/最小价值和(完全背包322)
3. 至少装target，求方案数/最小价值和



## s.线性DP-1

### 1143

1143.最长公共子序列：https://leetcode.cn/problems/longest-common-subsequence/

![image-20240504161203281](http://47.101.155.205/image-20240504161203281.png)

#### 回溯思考

子序列的问题就是选或不选，从最后一对字母开始，假设为x，y，有以下四种情况：

1. 选x，不选y
2. 不选x，选y
3. 不选x，不选y
4. 选x，选y

text1字符串用s[]数组表示；text2字符串用t[]数组表示

回溯三问：

1. 当前操作？对于t[i]和s[j]选或不选；
2. 子问题？t的前i个字母和s的前j个字母的最长公共子序列长度
3. 从选或不选的方向来思考？下一个子问题就是：
   1. t的前i-1个字母和s的前j个字母的最长公共子序列长度；
   2. t的前i个字母和s个前j-1个字母的最长公共子序列长度；
   3. t的前i-1个字母和s的前j-1个字母的最长公共子序列长度(都选/都不选)；

则有下面的dfs表达式

~~~java
// 当t[i]=s[j]
dfs(i, j) = max(dfs(i-1, j), dfs(i, j-1), dfs(i-1, j-1)+1);
// 当t[i]!=s[j]
dfs(i, j) = max(dfs(i-1, j), dfs(i, j-1), dfs(i-1, j-1));

// 当t[i]=s[j]时，还需要考虑dfs(i-1, j), dfs(i, j-1)的情况吗？

// 当t[i]!=s[j]时，还需要考虑dfs(i-1, j-1)的情况吗？

~~~





### 72

72.编辑距离：https://leetcode.cn/problems/edit-distance/

![image-20240504161351555](http://47.101.155.205/image-20240504161351555.png)



#### 回溯思考

回溯三问？对于text1和text2的一对字符x和y，对于x可以有插入字符、删除字符、替换字符、不做操作这四种操作

text1表示为t[]数组

text2表示为s[]数组

1. 当前操作？对于t[i]和s[j]，是进行插入字符(j-1的子问题)、删除字符(i-1的子问题)、替换字符(i-1,j-1的子问题)
2. 子问题？对于t的前i个和s的前j个字母，使字母t[i]变成t[j]的最小操作
3. 下一个子问题？
   1. 插入t[i]和s[j-1]+1的子问题
   2. 删除t[i-1]和s[j]+1的子问题
   3. 替换t[i-1]和s[j-1]+1的子问题
   4. 不做操作

可以复用上面的dfs

~~~java
// 当t[i]=s[j]
dfs(i, j) = dfs(i-1, j-1);
// 当t[i]!=s[j]
dfs(i, j) = min(dfs(i-1, j), dfs(i, j-1), dfs(i-1, j-1)) + 1;
dfs(i-1, j) 理解为插入;
dfs(i, j-1) 理解为删除;
dfs(i-1, j-1) 理解为替换;

~~~





## t.线性DP-2

### 300

300.最长递增子序列：https://leetcode.cn/problems/longest-increasing-subsequence/

![image-20240504160918674](http://47.101.155.205/image-20240504160918674.png)

#### 回溯思考

选/不选

回溯三问？

1. 当前操作？枚举nums[i]，选或不选
2. 子问题？从下标<=i中构造LIS，要知道上一个选的下标情况
3. 下一个子问题？nums[i-1]选或不选，LIS情况
   1. 大于选+1和不选的最大值？
   2. 小于，不选的情况

在这个递归过程中需要知道上一个选择的数字下标，递归的入口要满足选/不选

~~~java
public int dfs(int i, int pre, int[] nums) {
    if(i < 0) return 0;
    if(i == nums.length || num[i] < num[pre]) {
        // 选i(+1)或不选i
        return Math.max(dfs(i-1, i, nums)+1, dfs(i-1, pre, nums));
    }else{
        // i不能选
        return dfs(i-1, pre, nums);
    }
}

~~~

答案的角度

回溯三问？

1. 当前操作？枚举nums[j]
2. 子问题？以nums[i]结尾的LIS长度
3. 下一个子问题？以nums[j]结尾的LIS长度

~~~java
public int dfs(int[] nums, int i) {
    int res = 0;
    // i = 0循环不会执行，自动退出边界条件
    for(int j = 0; j < i; j++) {
        if (nums[j] < nums[i]) {
            res = Math.max(res, dfs(nums, j));
        }
    }
    return res+1;
}
int ans = 0;
for(int i = 0; i < nums.length; i++) {
    ans = Math.max(ans, dfs(nums, i));
}

~~~



#### 思路转换-1

nums的LIS(最长递增子序列)等价于对nums数组排序去重之后的nums的LCS问题。

例如：[10,9,2,5,3,7,101,18]

去重排序：[2,3,5,7,9,10,18,101]

LCS：[2,3,7,101]



#### 思路转换-2

交换状态与状态值

dp[i]表示末尾元素为nums[i]的LIS的长度。

f[i]表示长度为i+1的LIS的末尾元素的最小值

[10, 9, 2, 5, 3, 7, 101, 18]

g = [10]

g = [9]

g = [2]

g = [2,5]

g = [2,3]

g = [2,3,7]

g = [2,3,7,101]

g = [2,3,18,101]





## u.状态机DP

### 122

122.买卖股票的最佳时机 II：https://leetcode.cn/problems/best-time-to-buy-and-sell-stock-ii/

![image-20240504162121302](http://47.101.155.205/image-20240504162121302.png)

#### 回溯思考

[7, 1, 5, 3, 6, 4]这里总共是有6天，用下标i表示第i天结束时的最大收益

第5天结束的最大收益是第4天结束的收益+第5天收益(卖出(前面要持有股票)/买入(前面不持有股票)/不操作(持有或不持有))；

回溯三问？

1. 当前操作？nums[i]当前状态(持有/不持有)的最大收益，持有(1)=max(dfs(i-1,1),dfs(i-1,0)+nums[i]);不持有(0)=max(dfs(i-1,0),dfs(i-1,1)-nums[i]);
2. 子问题？第i天结束的收益
3. 下一个子问题？第i-1天结束的收益

递归的边界条件i<0时，或者i==0时的收益

dfs(-1,0)，不持有股票的收益为0，因为没有股票可以卖出

dfs(-1,1)，持有股票的收益为最小，因为不可能持有股票

~~~java
// dfs(prices, i, 0) 表示第i天结束，不持有股票的最大收益
// dfs(prices, i, 1) 表示第i天结束，持有股票的最大收益
public int dfs(int[] prices, int i, int flag) {
    if (i < 0) {
        return flag == 0 ? 0 : Integer.MIN_VALUE;
    }
    if (flag == 0) {
        return Math.max(dfs(prices, i-1, 0), dfs(prices, i-1, 1) - prices[i]);
    }else {
        return Math.max(dfs(prices, i-1, 1), dfs(prices, i-1, 0) + prices[i]);
    }
	
}

~~~

![image-20240514130944628](http://47.101.155.205/image-20240514130944628.png)



### 309

309.买卖股票的最佳时机含冷冻期：https://leetcode.cn/problems/best-time-to-buy-and-sell-stock-with-cooldown/

![image-20240504162220523](http://47.101.155.205/image-20240504162220523.png)

![image-20240514205620249](http://47.101.155.205/image-20240514205620249.png)

~~~java
// 边界条件
dfs(-2, 0) = 0;
dfs(-2, 1) = 负无穷;
dfs(-1, 0) = 0;
dfs(-1, 1) = 负无穷;

~~~





### 188

188.买卖股票的最佳时机 IV：https://leetcode.cn/problems/best-time-to-buy-and-sell-stock-iv/

![image-20240514131308283](http://47.101.155.205/image-20240514131308283.png)

![image-20240514215724935](http://47.101.155.205/image-20240514215724935.png)

~~~java
// 边界条件
dfs(*, -1, *) = 负无穷;
dfs(-1, *, 0) = 0;
dfs(-1, *, 1) = 负无穷;

~~~



### 恰好k次交易的最大金额

当交易次数k>length/2 + 1不可能完成

~~~java
public int dfs(int k, int i, int flag, int[] prices){
	// k < 0 不合法
	if (k < 0 ) {
		return min;
	}
	if (i < 0) {
		if (k > 0 || flag == 1) {
			return min;
		}else {
			return 0;
		}
	}
	if (flag == 1) {
	return Math.max(dfs(k, i-1, 1, prices), dfs(k-1, i-1, 0, prices) - prices[i]);
	}
    return Math.max(dfs(k, i-1, 0, prices), dfs(k, i-1, 1, prices) + prices[i]);
}

~~~





### 至少k次交易的最大金额

当交易次数k=0，转换成了不限制交易次数，同122

~~~java
public int dfs(int k, int i, int flag, int[] prices){
	if (i < 0) {
        // 到最后一天，还剩交易次数，不合法
		if (k > 0 || flag == 1) {
			return min;
		}else {
			return 0;
		}
	}
	if (flag == 1) {
	return Math.max(dfs(k, i-1, 1, prices), dfs(k-1, i-1, 0, prices) - prices[i]);
	}
    return Math.max(dfs(k, i-1, 0, prices), dfs(k, i-1, 1, prices) + prices[i]);
}

~~~







## v.区间DP

### 516

516.最长回文子序列：https://leetcode.cn/problems/longest-palindromic-subsequence/

![image-20240504162423444](http://47.101.155.205/image-20240504162423444.png)

#### 思路一

反转s得到revertS，求s与revertS的最长公共子序列

~~~java
// 最长公共子序列 s[i] t[j] 
// s[i]=t[j] 选+1
// s[i]!=t[j] 不选s[i]选t[j]/选s[i]不选t[j]
dfs(i,j);
// 边界条件
dfs(-1,*)=0;
dfs(*,-1)=0;
~~~





### 1039

1039.多边形三角剖分的最低得分：https://leetcode.cn/problems/minimum-score-triangulation-of-polygon/

![image-20240504162602807](http://47.101.155.205/image-20240504162602807.png)

![image-20240504162614881](http://47.101.155.205/image-20240504162614881.png)

## w.树形DP-1

### 543

543.二叉树的直径：https://leetcode.cn/problems/diameter-of-binary-tree/

![image-20240504163008553](http://47.101.155.205/image-20240504163008553.png)


### 124

124.二叉树中的最大路径和：https://leetcode.cn/problems/binary-tree-maximum-path-sum/

![image-20240504163158672](http://47.101.155.205/image-20240504163158672.png)

![image-20240504163224064](http://47.101.155.205/image-20240504163224064.png)

### 2246

2246.相邻字符不同的最长路径：https://leetcode.cn/problems/longest-path-with-different-adjacent-characters/

![image-20240504163340805](http://47.101.155.205/image-20240504163340805.png)

![image-20240504163401451](http://47.101.155.205/image-20240504163401451.png)



## x.树形DP-2

### 337

337.打家劫舍 III：https://leetcode.cn/problems/house-robber-iii/

![image-20240504163613786](http://47.101.155.205/image-20240504163613786.png)

![image-20240504163631005](http://47.101.155.205/image-20240504163631005.png)

选/不选：

1. 选当前节点，左右儿子节点都不可以选
2. 不选当前节点，左右儿子可选/不选

提炼状态：

1. 选当前节点，以当前节点为根的子树最大点权和
2. 不选当前系节点，以当前节点为根的子树最大点权和

转移方程：

1. 选 = 左不选 + 右不选 + 当前节点
2. 不选 = max(左选，左不选) + max(右选，右不选)

最终答案 = max(选，不选)



## y.树形DP-3

### 968

968.监控二叉树：https://leetcode.cn/problems/binary-tree-cameras/

![image-20240504163805856](http://47.101.155.205/image-20240504163805856.png)

![image-20240504163834503](http://47.101.155.205/image-20240504163834503.png)



![image-20240518150847325](http://47.101.155.205/image-20240518150847325.png)

![image-20240518154043938](http://47.101.155.205/image-20240518154043938.png)

~~~java
红色 = 黄色 + max(0, min(左蓝-左红, 右蓝-右红));

~~~



## z.单调栈

### 739

739.每日温度：https://leetcode.cn/problems/daily-temperatures/

![image-20240504164016398](http://47.101.155.205/image-20240504164016398.png)



### 42

42.接雨水：https://leetcode.cn/problems/trapping-rain-water/

![image-20240504164139885](http://47.101.155.205/image-20240504164139885.png)



## za.单调队列

### 239

239.滑动窗口最大值：https://leetcode.cn/problems/sliding-window-maximum/description/

![image-20240504164547773](http://47.101.155.205/image-20240504164547773.png)