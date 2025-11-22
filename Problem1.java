// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes 
// Any problem you faced while coding this :No


// Your code here along with comments explaining your approach
//we maintain two hash sets to store the resultant sequence and the substring of length 10
// If we encounter a substring again we add it in the result hashset and return
class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        HashSet<String> allSubs = new HashSet<>();
        HashSet<String> result = new HashSet<>();
        int n = s.length();
        if (n < 10)
            return new ArrayList<>();
        for (int i = 0; i <= n - 10; i++) {
            String curSub = s.substring(i, i + 10); //get the cur substring
            //check if curSub is already present, if yes it is a repeat
            if (allSubs.contains(curSub)) {
                result.add(curSub);
            } else {
                allSubs.add(curSub);
            }
        }
        return new ArrayList<>(result);

    }
}
