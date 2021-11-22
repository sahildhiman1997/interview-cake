def solution(word):
    amounts={}
    for char in word:
        amounts[char]=0
    for char in word:
        amounts[char]+=1
    odd_counter = 0
    counter=0
    for amount in amounts.values():
        if (amount%2)==1:
            counter+=1
            if ( counter>1):
                return False
    return True

# test
print(solution(('aabcbcd')))