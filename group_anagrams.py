class Solution(object):
    def groupAnagrams(self, strs):
        """
        :type strs: List[str]
        :rtype: List[List[str]]
        """
        strmap = {}
        for string in strs:
            target = ''.join(sorted(string))
            if target not in strmap:
                strmap[target] =[]
            strmap[target].append(string)
        return strmap.values()

#https://leetcode.com/problems/group-anagrams