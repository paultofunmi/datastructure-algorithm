const sumNaturalNumber = (number) => {

    if(number < 1) return 0;
    if(number == 1) return 1;

    return number + sumNaturalNumber(number - 1);
}


console.log(sumNaturalNumber(0));
console.log(sumNaturalNumber(2));
console.log(sumNaturalNumber(10));