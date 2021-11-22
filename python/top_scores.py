# clarification
# 1. take scores as array input to the function
# 2. sort them

# edge cases
# array might be empty ( no users played till now)
# multiple players might have same score

# assumptions
# score not be negative ( assumption)
# score can be 0


# solution
# 1. storing scores in dictionary ( hashmap) for each possible score
#    and their respective count
# 2. printing out keys the no. of times their values


# implementation

def solution(scores, max_score):
    scoresmap={}
    for x in scores:
        score = scoresmap.get(x,0)
        scoresmap[x]=score + 1
    
    sorted_scores=[]
    for x in range(max_score,0,-1):
        if x in scoresmap:
            for number_of_players in range(scoresmap[x]):
                sorted_scores.append(x)
    
    return sorted_scores        
print(solution([30, 60], 100))


# improvements made
# used o (n) space complexity using dictionary, would have taken o(max_score) if we used array