def solution(sentence):
    words = sentence.replace(',','').replace('.','').lower().split(' ')
    wordcount={}
    for word in words:
        wordcount[word]=0
    for word in words:
        wordcount[word]+=1
    return wordcount


print(solution('hi, ,there how HOw are you'))