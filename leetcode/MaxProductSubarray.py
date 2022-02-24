class com.solutions.Solution(object):

    def maxProduct(self, nums):
        res = max(nums)
        currMin, currMax = 1, 1
        
        for n in nums: 
            tmp = n * currMax
            currMax = max(n* currMax, n * currMin, n)
            currMin = min(tmp, n * currMin, n)
            res = max(res, currMax, currMin)
        return res

# 0
# 24
# 6
# print(com.solutions.Solution().maxProduct([-2, 0, -1]))
# print(com.solutions.Solution().maxProduct([-2,3,-4]))
print(com.solutions.Solution().maxProduct([-2,3,0, -4, -6]))
# print(com.solutions.Solution().maxProduct([2,3,-2,4]))