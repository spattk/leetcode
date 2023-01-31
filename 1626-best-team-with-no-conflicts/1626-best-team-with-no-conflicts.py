# class Solution:
#     def bestTeamScore(self, scores: List[int], ages: List[int]) -> int:
        
        
# import heapq

class Solution:
    def bestTeamScore(self, scores, ages):
        players = [(age, score) for age, score in zip(ages, scores)]
        players.sort()
        dp = [0] * len(players)
        dp[0] = players[0][1]
        for i in range(1, len(players)):
            dp[i] = players[i][1]
            for j in range(i):
                if players[j][1] <= players[i][1]:
                    dp[i] = max(dp[i], dp[j] + players[i][1])
        return max(dp)

        