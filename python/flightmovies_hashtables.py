# def solution(movies, flight_time):
#     i=0
#     while (i<len(movies)-1):
#         for m2 in range(i+1, len(movies)):
#             if ( movies[i]+movies[m2] == flight_time):
#                 return True
#         i+=1
#     return False
# print(solution([2, 4], 1))



# using hash tables
def solution(movies, flight_time):
    lengths={}
    for movie_time in movies:
        complement = flight_time-movie_time
        if complement in lengths:
            return True
        lengths[movie_time]=True
    return False


print(solution([2, 4], 1))