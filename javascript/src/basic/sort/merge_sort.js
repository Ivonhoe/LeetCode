/**
 * 利用分治思想，将数组分成左右两个数组，分别排序，然后将两个子数组合并
 * 将一个数组分成两个数组，直到数组中只有一个元素。
 * 递归利用合并来排序。
 * 
 * 非原地，稳定排序算法
 * @param {number} array 
 */
function mergeSort (array) {
    if (array == null || array.length < 1) {
        return []
    }

    if (array.length == 1) {
        return array
    }

    const length = array.length
    const mid = Math.floor(length / 2)

    const left = array.slice(0, mid)
    const right = array.slice(mid, length)

    return merge(mergeSort(left), mergeSort(right))
}

function merge (left, right) {
    const result = []

    let il = 0
    let ir = 0
    while (il < left.length && ir < right.length) {
        if (left[il] < right[ir]) {
            result.push(left[il])
            il++
        } else {
            result.push(right[ir])
            ir++
        }
    }

    while (il < left.length) {
        result.push(left[il])
        il++
    }

    while (ir < right.length) {
        result.push(right[ir])
        ir++
    }

    return result
}

function testMergeSort () {
    var array = [0, 4, 1, 5, 6, 9, 3, 11, 7]
    var result = mergeSort(array)
    console.log("result:" + result)
}

{
    testMergeSort()
}