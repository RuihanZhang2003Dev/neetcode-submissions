class Solution {
    /**
     * @param {string} s
     * @param {string} t
     * @return {boolean}
     */
    isAnagram(s: string, t: string): boolean {
        let occurances = new Array(26).fill(0);
        for (let i = 0; i< s.length; i++){
            occurances[s.charAt(i).charCodeAt(0) - 'a'.charCodeAt(0)]++;        
        }
        for (let i = 0; i< t.length; i++){
            occurances[t.charAt(i).charCodeAt(0) - 'a'.charCodeAt(0)]--;
            if (occurances[t.charAt(i).charCodeAt(0) - 'a'.charCodeAt(0)] < 0){
                return false;
            }        
        }
        for (let i = 0; i< occurances.length; i++){
            if (occurances[i] > 0){
                return false;
            }
        }
        return true;
    }
}
