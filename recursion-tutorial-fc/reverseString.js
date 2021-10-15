const reverseString = (string) => {

    if(string == null || !string) return "";

    const result = reverseString(string.substring(1)) + string.charAt(0);
    return result;
}


const reverseString2 = (string) => {

    let result = "";

    for(let i = string.length - 1; i >= 0; i--){

        result += string[i];
    }

    return result;
}

console.log(reverseString("Hello"));
console.log(reverseString2("Hello"));