class Solution {
    /**
     * @param {number[]} nums
     * @param {number} target
     * @return {number[]}
     */
    twoSum(nums: number[], target: number): number[] {
        const set = new Set<[number, number]>();
        for (let i = 0; i< nums.length; i++){
            for (let j = i+1; j< nums.length; j++){
                if (set.has([nums[i], nums[j]])){
                    continue;
                }
                if (nums[i] + nums[j] == target){
                    return [i, j];
                }
                set.add([i, j]);
            }
        }
    }
}
