# Help Bity

Bity had the flag for his problem. Unfortunately, his negative friend Noty corrupted it.

Help Bity retrieve his flag. He only remembers the first 4 characters of the flag: CTFL.

Flag:

```text
BUGMd`sozc0o`sx^0r^`vdr1ld|
```

```python3
corrupted = 'BUGMd`sozc0o`sx^0r^`vdr1ld|'
shift = [1, -1, -1, -1, 1, 1, -1, -1, 1, -1, 1, -1, 1, -1, 1, 1, 1, 1, 1, 1, 1, 1, 1, -1, 1, 1, 1]
msg = "".join([chr(ord(corrupted[i]) + shift[i]) for i in range(len(shift))])
print(msg)
```

```bash
$ python3 exploit.py
# => CTFLearn{b1nary_1s_awes0me}
```
