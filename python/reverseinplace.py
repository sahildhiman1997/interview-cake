def reverse(list_of_chars):

    # Reverse the input list of chars in place
    if ( len(list_of_chars)<=1):
        return list_of_chars
    i=0
    while ( i <=len(list_of_chars)/2):
        list_of_chars[i],list_of_chars[len(list_of_chars)-1-i]= list_of_chars[len(list_of_chars)-1-i],list_of_chars[i]
        i+=1
    return list_of_chars


print(reverse([1,2,3,4,5,6,7,8,9,10]))

