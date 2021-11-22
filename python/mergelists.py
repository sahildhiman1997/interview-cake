def merge_lists(list1, list2):
    if ( len(list1)==0):
        return list2
    if ( len(list2)==0):
        return list1
    i=0
    while (i < len(list1)):
        if ( list1[i]>list2[0]):
            list1.insert(i,list2[0])
            list2.pop(0)
        if ( len(list2)==0):
            break
        i+=1
    for o in list2:
        list1.append(o)
    return list1

my_list     = [3, 4, 6, 10, 11, 15]
alices_list = [1, 5, 8, 12, 14, 19]
print merge_lists(my_list, alices_list)