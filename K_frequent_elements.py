class Solution(object):
    def topKFrequent(self, nums, k):
        """
        :type nums: List[int]
        :type k: int
        :rtype: List[int]
        """
        if len(nums) == k:
            return nums
        counter = {}
        for num in nums:
            if num in counter:
                counter[num] += 1
            else:
                counter[num] = 1
        sorted_dict = sorted(counter.items(), key=lambda x: x[1], reverse=True)
        res = []
        for i in sorted_dict[:k]:
            res.append(i[0])
        return res

#https://leetcode.com/problems/top-k-frequent-elements/