/**
 * 如果要排序数组中下标从 p 到 r 之间的一组数据，我们选择 p 到 r 之间的任意一个数据作为 pivot（分区点）。
 * 我们遍历 p 到 r 之间的数据，将小于 pivot 的放到左边，将大于 pivot 的放到右边，将 pivot 放到中间。
 * 经过这一步骤之后，数组 p 到 r 之间的数据就被分成了三个部分，前面 p 到 q-1 之间都是小于 pivot 的，
 * 中间是 pivot，后面的 q+1 到 r 之间是大于 pivot 的。根据分治、递归的处理思想，我们可以用递归排序下标
 * 从 p 到 q-1 之间的数据和下标从 q+1 到 r 之间的数据，直到区间缩小为 1，就说明所有的数据都有序了。
 * 
 * pivot是随机选择的，一般情况下，可以选择 p 到 r 区间的最后一个元素
 * 
 * 递推公式：quick_sort(p…r) = quick_sort(p…q-1) + quick_sort(q+1… r)
 * 终止条件：p >= r
 * 
 * 原地，非稳定排序算法
 * 
 * https://www.cnblogs.com/Bonnie3449/p/9221039.html
 * @param {number} array 
 */
function quickSort (array) {
    if (array == null || array.length < 1) {
        return
    }

    sort(array, 0, array.length - 1)
}

function sort (array, p, r) {
    if (p >= r) {
        return;
    }

    // 活动分区点
    q = partition(array, p, r)
    sort(array, p, q - 1)
    sort(array, q + 1, r)
}

// 两个指针从头尾向中间逼近
function partition (array, low, hight) {
    let p = array[low]
    while (low < hight) {
        while (low < hight && array[hight] >= p) {
            --hight
        }
        swap(array, low, hight)
        while (low < hight && array[low] < p) {
            ++low
        }
        swap(array, low, hight)
    }

    return low
}

function swap (array, i, j) {
    var temp = array[i]
    array[i] = array[j]
    array[j] = temp
}

function testQuickSort () {
    var array = [0, 4, 1, 5, 6, 9, 3, 11, 7]
    quickSort(array)
    console.log("result:" + array)
}

{
    testQuickSort()
}