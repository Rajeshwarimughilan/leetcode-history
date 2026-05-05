/**
 * @param {number[]} temperatures
 * @return {number[]}
 */
var dailyTemperatures = function(temperatures) {
    let stack = [];
    let res = new Array(temperatures.length).fill(0);

    for(let i = 0; i < temperatures.length; i++){
        while(stack.length && temperatures[stack[stack.length - 1]] < temperatures[i]){
            let idx = stack.pop();
            res[idx] = i - idx;
        }
        stack.push(i);
    }
    return res;
};