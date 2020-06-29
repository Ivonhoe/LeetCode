/**
 * 每次会从未排序区间中找到最小的元素，将其放到已排序区间的末尾
 * 
 * @param {*} array 
 */
function straightSelectionSort (array) {
    if (!array.length) {
        return null
    }

    for (var i = 0; i < array.length; i++) {
        var index = i;
        var value = array[i]
        for (var j = i; j < array.length; j++) {
            if(array[j]<value){
                value = array[j]
                index = j
            }
        }

        var temp = array[i]
        array[i] = array[index]
        array[index]= temp
    }
    return array
}


function testInsertSort () {
    var array = [0, 4, 1, 5, 6, 9, 3, 11, 7]
    var result = straightSelectionSort(array)
    console.log("result:" + result)
}

{
    testInsertSort()
}