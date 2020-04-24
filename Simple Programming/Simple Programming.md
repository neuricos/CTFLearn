# Simple Programming

Can you help me? I need to know how many lines there are where the number of 0's is a multiple of 3 or the numbers of 1s is a multiple of 2.
Please! Here is the file: `https://mega.nz/#!7aoVEKhK!BAohJ0tfnP7bISIkbADK3qe1yNEkzjHXLKoJoKmqLys`

```python3
with open('data.dat', 'r') as f:
    lines = f.readlines()
    count = 0
    for line in lines:
    ¦   zero_times = 0
    ¦   one_times = 0
    ¦   for c in line:
    ¦   ¦   if c == '0':
    ¦   ¦   ¦   zero_times += 1
    ¦   ¦   if c == '1':
    ¦   ¦   ¦   one_times += 1
    ¦   ¦   if zero_times % 3 == 0 or one_times % 2 == 0:
    ¦   ¦   ¦   count += 1
    print(count)
```

```bash
$ python3 exploit.py
# => 6662
```

Hence, flag is `6662`
