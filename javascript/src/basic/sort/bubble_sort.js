/**
 * 比较交换相邻的两个值，每次循环将当前未排序数组中最大的数冒泡到数组后面
 * 
 * 原地排序，稳定的
 * O(n) ~ O(n^2)
 * @param {} array 
 */
function bubbleSort (array) {
    if (array == null || !array.length) {
        return
    }

    for (var i = 0; i < array.length; i++) {
        var flag = false;
        for (var j = 0; j < array.length - i - 1; j++) {
            if (array[j] > array[j + 1]) {
                swap(array, j, j + 1)
                flag = true
            }
        }
        if (!flag) {
            break
        }
    }

    return array
}

function swap (array, i, j) {
    var temp = array[i]
    array[i] = array[j]
    array[j] = temp
}

function testBubbleSort () {
    var array = [0, 4, 1, 5, 6, 9, 3, 11, 7]
    var result = bubbleSort(array)
    console.log("result:" + result)
}

{
    testBubbleSort()
}