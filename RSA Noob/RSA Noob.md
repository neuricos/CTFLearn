# RSA Noob

These numbers were scratched out on a prison wall. Can you help me decode them? `https://mega.nz/#!al8iDSYB!s5olEDK5zZmYdx1LZU8s4CmYqnynvU_aOUvdQojJPJQ`

```bash
$ cat rsanoob\ \(1\).txt
e: 1
c:9327565722767258308650643213344542404592011161659991421
n: 245841236512478852752909734912575581815967630033049838269083
```

Use [this website](https://www.alpertron.com.ar/ECM.HTM) to factorize `n`.

We will know that if we factorize `n`, `n = 416064 700201 658306 196320 137931 × 590872 612825 179551 336102 196593`.

Then, we can use the following Python script to decrypt the message:

```python3
from Crypto.Util.number import inverse

def int2msg(v):
    s = format(v, 'x')
    msg = ""
    for i in range(0, len(s), 2):
        msg += chr(int(s[i:i+2], 16))
    return msg

n = 245841236512478852752909734912575581815967630033049838269083
p = 416064700201658306196320137931
q = 590872612825179551336102196593
e = 1
ct = 9327565722767258308650643213344542404592011161659991421

phi = (p - 1) * (q - 1)
d = inverse(e, phi)
pt = pow(ct, d, n)
print(int2msg(pt))
```

```bash
$ python3 exploit.py
abctf{b3tter_up_y0ur_e}

```

Notice that for this question, we don't actually need to figure out `p` or `q`. Since `ct = pt^e mod n`, and `e=1`, we know that `ct = pt mod n`.

Based on the solution, we know that `ct = pt`. Hence, we can directly call `int2msg` on `ct` to get the flag.
