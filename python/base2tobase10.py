i = input("Enter binary number")
k=i
p=0
base10=0
while ( i >=1):
    currentdigit  = i%10
    i=i/10
    base10 +=currentdigit*(2**p)
    p+=1
print('{} in base10 is: {}'.format(k, base10))