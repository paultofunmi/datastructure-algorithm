const ransomNote = (note, mag) => {

    const dict = [];

    console.log(9 % 10);
    console.log(10 / 10);
    console.log(10 % 10);

    for(let currentString of mag) {

        if(!dict[currentString]) {
            dict[currentString] = 1;
        }else {
            dict[currentString] += 1;
        }
    }

    for(let currentString of note) {

        // console.log(currentString);
        if(!dict[currentString]) {
            
            return false;
        }else {
            dict[currentString] -= 1;
        }
    }

    return true;
}


console.log(ransomNote('aa', 'ab'));