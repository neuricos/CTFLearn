# Reverse Polarity

I got a new hard drive just to hold my flag, but I'm afraid that it rotted. What do I do? The only thing I could get off of it was this:

```text
01000011010101000100011001111011010000100110100101110100010111110100011001101100011010010111000001110000011010010110111001111101
```

Looking at this form, I guess we have to make this string back to its hex representation. Each byte is then a character.

Use the following script to decrypt the message:

```python3
#!/usr/bin/python3

s = "01000011010101000100011001111011010000100110100101110100010111110100011001101100011010010111000001110000011010010110111001111101"
hex_msg = format(int(s, 2), 'x')
msg = ""
for i in range(len(hex_msg) // 2):
    c = hex_msg[2 * i: 2 * i + 2]
    msg += chr(int(c, 16))
print(msg)
```

If we run it:

```bash
$ ./exploit.py
CTF{Bit_Flippin}

```
