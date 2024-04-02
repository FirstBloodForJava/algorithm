# algorithm
算法学习
## 1.相向双指针
### Solution_1
1.两数之和：https://leetcode.cn/problems/two-sum/description/
暴力解法

hash加速搜索,如暴力搜索的0->n-2,反过来从n-2的顺序查找，当比对的结果较多时,通过hash加快搜索
![image-20240401161124766](http://47.101.155.205/image-20240401161124766.png)

### Solution_2
167.两数之和II-输入有序数组：https://leetcode.cn/problems/two-sum-ii-input-array-is-sorted/description
![image-20240401161410801](http://47.101.155.205/image-20240401161410801.png)

### Solution_3
15.三数之和：https://leetcode.cn/problems/3sum/description
![image-20240401161956826](http://47.101.155.205/image-20240401161956826.png)

![image-20240402194959079](http://47.101.155.205/image-20240402194959079.png)
将给定的数组排好序之后,从i=0开始,则需要从另外一个数组中找到其和为-nums[i]的值,变成了找一个有序数组的两数之和