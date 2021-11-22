def solution(ml):
    ml.sort(key=lambda x: x[0])
    merged_meetings=[]
    merged_meetings.append(ml[0])
    i=1
    while(i <len(ml)):
        if (ml[i][0]<=merged_meetings[-1][1]):
            start = min(ml[i][0], merged_meetings[-1][0])
            end=max(ml[i][1],merged_meetings[-1][1])
            merged_meetings.pop()
            merged_meetings.append((start,end))
        else:
            merged_meetings.append(ml[i])
        i+=1

    return merged_meetings

print(solution([(1, 10), (2, 5), (6, 8), (9, 10), (10, 12)]))