# Binwalk

Here is a file with another file hidden inside it. Can you extract it? `https://mega.nz/#!qbpUTYiK!-deNdQJxsQS8bTSMxeUOtpEclCI-zpK7tbJiKV0tXYY`

```bash
$ binwalk PurpleThing.jpeg 

DECIMAL       HEXADECIMAL     DESCRIPTION
--------------------------------------------------------------------------------
0             0x0             PNG image, 780 x 720, 8-bit/color RGBA, non-interlaced
41            0x29            Zlib compressed data, best compression
153493        0x25795         PNG image, 802 x 118, 8-bit/color RGBA, non-interlaced

$ binwalk -D 'image:png' PurpleThing.jpeg 
$ ls
PurpleThing.jpeg        _PurpleThing.jpeg.extracted/

$ cd _PurpleThing.jpeg.extracted/
$ ls
0.png       25795.png   29      29.zlib

$ open 25795.png
```

Then, we can see there is a flag in the image. The flag is `ABCTF{b1nw4lk_is_us3ful}`
