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