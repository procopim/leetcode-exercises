class Solution(object):
    def longestConsecutive(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        if len(nums) == 0:
            return 0
        hashset = set()
        for n in nums:
            hashset.add(n)
        orderedlist = sorted(hashset)
        longest = 0
        tracker = 0
        for i, k in enumerate(orderedlist):
            if not (i == len(orderedlist)-1):
                longest +=1
                if orderedlist[i+1] == k + 1:
                    continue
                else:
                    if longest > tracker:
                        tracker = longest
                        longest = 0
                    else:
                        longest = 0
            else:
                longest+=1
                if longest > tracker:
                    tracker = longest
        return tracker
#https://leetcode.com/problems/longest-consecutive-sequence/