# Time to Eat

My friend sent me some Python code, but something tells me he was hungry when he wrote it. Do you think you can put your reverse engineering skills to use and get it to output the flag?

```python
# I wrote and debugged this code with all the convoluted "EAT" variable names.
# Was it confusing? Yes. Was debugging hard? Yes.
# Did I spend more time than I should have on this problem? Yes

EAT = int
eAT = len
EaT = print
ATE = str
EATEATEATEATEATEAT = ATE.isdigit

def Eating(eat):
    return ATE(EAT(eat)*EATEATEAT)

def EAt(eat, eats):
    print(eat, eats)
    eat1 = 0
    eat2 = 0
    eateat = 0
    eAt = ""
    while eat1 < eAT(eat) and eat2 < eAT(eats):
        if eateat%EATEATEAT == EATEATEATEATEAT//EATEATEATEAT:
            eAt += eats[eat2]
            eat2 += 1
        else:
            eAt += eat[eat1]
            eat1 += 1
        eateat += 1
    return eAt

def aten(eat):
    return eat[::EATEATEAT-EATEATEATEAT]

def eaT(eat):
    return Eating(eat[:EATEATEAT]) + aten(eat)

def aTE(eat):
    return eat#*eAT(eat)

def Ate(eat):
    return "Eat" + ATE(eAT(eat)) + eat[:EATEATEAT]

def Eat(eat):
    if eAT(eat) == 9:
        if EATEATEATEATEATEAT(eat[:EATEATEAT]) and\
            EATEATEATEATEATEAT(eat[eAT(eat)-EATEATEAT+1:]):
                eateat = EAt(eaT(eat), Ate(aTE(aten(eat))))
                if eateat == "E10a23t9090t9ae0140":
                    flag = "eaten_" + eat
                    EaT("absolutely EATEN!!! CTFlearn{",flag,"}")
                else:
                    EaT("thats not the answer. you formatted it fine tho, here's what you got\n>>", eateat)
        else:
            EaT("thats not the answer. bad format :(\
            \n(hint: 123abc456 is an example of good format)")
    else:
        EaT("thats not the answer. bad length :(")

EaT("what's the answer")
eat = input()
EATEATEAT = eAT(eat)//3
EATEATEATEAT = EATEATEAT+1
EATEATEATEATEAT = EATEATEAT-1
Eat(eat)
```

If we obfuscate the python program, we should have something like the following:

```python
def foo(s):
    return str(int(s) * 3)

def bar(s1, s2):
    print(s1, s2)
    k1 = 0
    k2 = 0
    i = 0
    s = ""
    while k1 < len(s1) and k2 < len(s2):
        if i % 3 == 0:
            s += s2[k2]
            k2 += 1
        else:
            s += s1[k1]
            k1 += 1
        i += 1
    return s

def baz(s):
    return foo(s[:3]) + s[::-1]

def boo(s):
    return "Eat" + str(len(s)) + s[:3]

def check(s):
    if len(s) == 9:
        if str.isdigit(s[:3]) and str.isdigit(s[7:]):
            v = bar(baz(s), boo(s[::-1]))
            if v == "E10a23t9090t9ae0140":
                flag = "eaten_" + s
                print("absolutely EATEN!!! CTFlearn{", flag ,"}")
            else:
                print("thats not the answer. you formatted it fine tho, here's what you got\n>>", v)
        else:
            print("thats not the answer. bad format :(\n(hint: 123abc456 is an example of good format)")
    else:
        print("thats not the answer. bad length :(")

input_str = input("what's the answer")
check(input_str)
```

Hence, we can write the following python script to solve it:

```python
# input_str = input("what's the answer")
# check(input_str)

# We know the input length is 9
# baz returns a string of length 3+9=12 or 4+9=13, depending on the value of the first 3 digit of the input string
# boo returns a string of length 3+1+3=7
# Since the value ss we would eventually compare against is of length 19 ("E10a23t9090t9ae0140")
# baz should return a string of length 13
# That means, characters of ss that have index divisible by 3 are from boo, the rest are from baz

fusc = "E10a23t9090t9ae0140"
from_boo = "".join([fusc[i] for i in range(len(fusc)) if i % 3 == 0])
from_baz = "".join([fusc[i] for i in range(len(fusc)) if i % 3 != 0])

# If we print the result out, we will have the following
# from_boo = Eat9900
# from_baz = 1023900tae14

# From the result of from_baz, we know that foo(s[:3]) is 1023 and the whole input string is X41eat009
# From the result of from_boo, we know that the last 3 characters are 0, 0, 9
# That means, X41 * 3 = 1023 => X41 = 341 => X = 3
# Hence, the entire input string must be 341eat009
# The flag, therefore, is CTFlearn{eaten_341eat009}
```

(Although the script is more like deduction than really "script")
