const decimalToBinary = (number) => {

    if(number == 0) return "";

    // console.log(Math.floor(number / 2));
    return decimalToBinary(Math.floor(number / 2)) + ""  + number % 2;
}

console.log(decimalToBinary(5));