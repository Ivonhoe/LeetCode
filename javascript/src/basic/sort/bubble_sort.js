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