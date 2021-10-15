const isPalindrome = (string) => {
    
    if(string.length == 0 || string.length == 1) return true;

    if(string.charAt(0) == string.charAt(string.length - 1)) {

        return isPalindrome(string.substring(1, string.length - 1));
    }

    return false;
}

const isPalindrome2 = (string) => {
    
    if(string.length == 0 || !string) return false;
    if(string.length == 1) return true;

    let i = 0, j = string.length -1;
    while( i < j) {

        if(string.charAt(i) == string.charAt(j)) {
            i++;
            j--;
        }else {
            return false;
        }
    }

    return true;
}

// isPalindrome('abcd');
console.log(isPalindrome('abcd'));
console.log(isPalindrome2('kaak'));