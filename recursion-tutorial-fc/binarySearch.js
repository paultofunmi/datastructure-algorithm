const binarySearch = (arr, left, right, key) => {

    if(left > right) return -1;

    let mid = Math.floor((left + right ) / 2);

    if(arr[mid] == key) return mid;

    if(arr[mid] > key) {

        return binarySearch(arr, left, mid - 1, key);
    }

    return binarySearch(arr, mid + 1, right, key);
}

const arr = [2, 3];
console.log(binarySearch(arr, 0, arr.length -1, 3));