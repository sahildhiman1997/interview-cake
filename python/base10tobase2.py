i=int(input('enter no . in base 10: '))

base2=[]
while (i>=1):
    m=int(i%2)
    i=i/2
    base2.append(m)

base2.reverse()

base2 = ''.join(map(str, base2))
print('Base2 for {} is {}'.format(i, base2))




