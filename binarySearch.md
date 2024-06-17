# 二分查找

## 什么是二分查找

描述了在有序集合中搜索特定值的过程。二分查找使用到的元素：

- 目标Target：你要查找的值。
- 索引Index：你要查找的当前位置
- 左、右指示符Left、Right：用来维持查找空间的指标
- 中间指示符Mid：用来确定应该向左查找还是向右查找的索引

二分查找维护查找空间的左右和中间指示符，并比较查找目标或将查找条件应用于集合的中间值；如果条件不满足或者值不相等，则清除目标不可能存在的那一半，并在剩下的一半上继续查找，直到成功为止。如果查找一空的一半结束(Left>Right)，则无法满足条件，无法找到目标。



## 识别二分查找

二分查找在每次比较之后将查找空间一分为二的算法。需要查找集合汇总的索引或元素时，都应该考虑二分查找。如果集合是无序的，我们可以总是在应用二分查找之前先对其进行排序。

二分查找步骤：

1. 预处理：如果集合未排序，则进行排序；
2. 二分查找：使用循环或递归在每次比较后将查找空间划分为两半；
3. 后处理：在剩余空间中确认可行的候选者。



### 模板一

区间为[left,right]，左闭右闭，left=mid+1，right=mid-1

~~~java
int binarySearch(int[] nums, int target){
  if(nums == null || nums.length == 0)
    return -1;

  int left = 0, right = nums.length - 1;
  while(left <= right){
    // 划分空间(可以避免下标越界)
    int mid = left + (right - left) / 2;
    if(nums[mid] == target){ return mid; }
    else if(nums[mid] < target) { left = mid + 1; }
    else { right = mid - 1; }
  }

  // 结束条件: left > right
  return -1;
}

~~~

关键属性：

- 二分查找最基本和最基础的形式
- 查找条件可以在不与元素的两侧进行比较的情况下确定
- 不需要后处理，因为每一步中，都在检查是否找到了元素。如果达到末尾，则知道未找到改元素。



初始条件：left=0，right=length-1；

结束条件：left>right；

向左查找：right=mid-1；

向右查找：left=mid+1。



#### x的平方根

![image-20240406173559780](http://47.101.155.205/image-20240406173559780.png)

![image-20240406180803861](http://47.101.155.205/image-20240406180803861.png)



#### 猜数字大小

![image-20240406181746864](http://47.101.155.205/image-20240406181746864.png)





#### 搜索旋转排序数组

![image-20240406182555884](http://47.101.155.205/image-20240406182555884.png)

![image-20240406202340077](http://47.101.155.205/image-20240406202340077.png)

数组被旋转后，有相对的顺序性，可以通过二分查找，找到其中有序的部分。

例如：

当left<=right时，mid = (left+right)/2

如果nums[mid] >= nums[0]，[0,mid]是升序的，则[left,mid]也是有序的。如果target<nums[mid]且target>=nums[0]，则可以在[l,mid-1]中进行有序的二分查找。

同理：如果nums[mid] < nums[0]，[mid,n-1]是升序的，则[mid,r]也是有序的。如果target>nums[mid]且

target<=nums[n-1]\(<nums[0]也可以)，则可以在[mid+1,r]中进行有序的二分查找。



### 模板二

区间为[left,right)左闭右开，左闭left=mid+1

区间为(left,right]左开右闭，右闭left=mid+1

不论区间是左闭右开还是左开右闭，其中边界只能是left=mid+1移动，不能是right=mid-1

例如

~~~txt
[left,right)->[1,5),
第一次mid=3,进入right移动条件right=mid-1=2,left=1
第二次mid=1,left=1,right=2,进入left条件,left=1,right=2程序死循环

同理(left,right]->(1,5]第二次还会访问到边界外的元素

left=mid+1情况分析,right=mid
在left<right的情况下,mid<right恒成立,这个时候+1能正常保证循环退出。

right=mid-1情况分析,left=mid
当left<right的情况下,mid<right恒成立,当left也等于mid-2(left=right-4)时,
left=1,right=5,mid=2,这个时候mid=1,边界2并没有进行计算,而且这种情况才特点条件下会导致死循环;而如果时left=mid+1,right=mid,无论哪种情况都能正常的退出循环


~~~



~~~java
int binarySearch(int[] nums, int target){
  if(nums == null || nums.length == 0)
    return -1;

  int left = 0, right = nums.length;
  while(left < right){
    // 防止下标索引越界
    int mid = left + (right - left) / 2;
    if(nums[mid] == target) { 
        return mid; 
    } else if (nums[mid] < target) { 
        left = mid + 1; 
    }else { 
        right = mid; 
    }
  }

  // 后处理:
  // 结束: left == right
  if(left != nums.length && nums[left] == target) return left;
  return -1;
}

~~~

查找需要访问数组中当前索引及其直接右邻居索引的元素或条件。

关键属性：

- 查找条件需要访问元素的直接右邻居
- 使用元素的右邻居来确定是否满足条件，并决定是向左还是向右
- 保证查找的空间在每一步中至少有2个元素
- 需要进行后处理。当剩下1个元素时，循环/递归结束。需要评估剩余元素是否符合条件



区分语法：

- 初始条件：left=0,right=length；
- 终止：left == right
- 向左查找：right = mid；
- 向右查找：left = mid+1；



#### 第一个错误的版本

![image-20240407215441128](http://47.101.155.205/image-20240407215441128.png)

#### 寻找峰值

![image-20240407215510374](http://47.101.155.205/image-20240407215510374.png)



#### 寻找旋转排序数组中的最小值

![image-20240407215549339](http://47.101.155.205/image-20240407215549339.png)



### 模板三

区间留元素或左开右开(left,right)，则left=mid，right=mid

~~~java
int binarySearch(int[] nums, int target) {
    if (nums == null || nums.length == 0)
        return -1;

    int left = 0, right = nums.length - 1;
    while (left + 1 < right){
        // 避免下标越界
        int mid = left + (right - left) / 2;
        if (nums[mid] == target) {
            return mid;
        } else if (nums[mid] < target) {
            left = mid;
        } else {
            right = mid;
        }
    }

    // 后处理:
    // 结束条件: left + 1 == right
    if(nums[left] == target) return left;
    if(nums[right] == target) return right;
    return -1;
}

~~~

关键属性：

- 搜索条件需要访问元素的直接左右邻居
- 使用元素的邻居来确定它是向右还是向左
- 保证查找空间在每个步骤中至少有 3 个元素
- 需要进行后处理，当剩余2个元素时，递归/循环结束。需要处理剩余元素是否符合要求



区分语法：

- 初始条件：left=0，right=length-1；
- 终止：left+1=right；
- 向左查找：right=mid；
- 向右查找：left=mid；



#### 在排序数组中查找元素的第一个和最后一个位置

![image-20240407220343892](http://47.101.155.205/image-20240407220343892.png)



#### 找到 K 个最接近的元素

![image-20240407220410404](http://47.101.155.205/image-20240407220410404.png)



#### 寻找峰值

![image-20240407220426993](http://47.101.155.205/image-20240407220426993.png)