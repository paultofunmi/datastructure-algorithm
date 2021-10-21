//Return 2D array of the words used to make the target word.
const allconstruct = (targetword, wordbank) => {

}




allconstruct("purple", ["purp", "p", "ur", "le", "purpl"]); // [ [purp, le], [p, ur, p, le] ]
allconstruct("purple", ["abcdef", "ab", "abc", "cd", "def", "abcd", "ef", "c"]); // [ [ab, cd, ef], [ab, c, def], [abc, def], [abcd, ef] ];
allconstruct("hello", ["cat", "dog", "mouse"]); //[]
allconstruct("", ["cat", "dog", "mouse"]); // [[]]