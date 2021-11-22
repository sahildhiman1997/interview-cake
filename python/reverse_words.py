# the reaL PROBLEM IS TO SOLVE IT IN-PLACE


def reverse_words(msg):
    msg.reverse()
    msg.append(' ')
    start=0
    i=0
    while ( i < len(msg)):
        if ( (msg[i]==' ')):
            counter=0
            end=i-1
            while(counter<=(end-start)/2):
                msg[start+counter],msg[end-counter]= msg[end-counter],msg[start+counter]
                counter+=1
            start=end+2
        i+=1
    msg.pop(-1)
    return msg

print(reverse_words([ 'c', 'a', 'k', 'e', ' ',
            'p', 'o', 'u', 'n', 'd', ' ',
            's', 't', 'e', 'a', 'l' ]))
