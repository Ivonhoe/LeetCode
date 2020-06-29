/**
 * 直接插入排序
 * 
 * 原地排序，稳定的
 * O(n^2)
 * @param {} array 
 */
function straightInsertSort (array) {
    if (array.length <= 1) {
        return
    }

    for (var i = 1; i < array.length; i++) {
        var j = i - 1;
        var value = array[i]
        for (; j >= 0; j--) {
            if (array[j] > value) {
                array[j + 1] = array[j]
            } else {
                break
            }
        }
        array[j + 1] = value
    }

    return array
}

function testInsertSort () {
    var array = [0, 4, 1, 5, 6, 9, 3, 11, 7]
    var result = straightInsertSort(array)
    console.log("result:" + result)
}

{
    testInsertSort()
}