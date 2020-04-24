# Milk's Best Friend

There's nothing I love more than oreos, lions, and winning. `https://mega.nz/#!DC5F2KgR!P8UotyST_6n2iW5BS1yYnum8KnU0-2Amw2nq3UoMq0Y` Have Fun :)

```bash
$ strings oreo.jpg | grep flag
This is not the flag you are looking for.Q"t

$ binwalk oreo.jpg 

DECIMAL       HEXADECIMAL     DESCRIPTION
--------------------------------------------------------------------------------
0             0x0             JPEG image data, JFIF standard 1.01
9515          0x252B          RAR archive data, version 4.x, first volume type: MAIN_HEAD

$ binwalk -e oreo.jpg 

DECIMAL       HEXADECIMAL     DESCRIPTION
--------------------------------------------------------------------------------
0             0x0             JPEG image data, JFIF standard 1.01
9515          0x252B          RAR archive data, version 4.x, first volume type: MAIN_HEAD

$ cd _oreo.jpg.extracted/
$ ls
252B.rar    a       b.jpg

$ cat a


This is not the flag you are looking for.
$ strings b.jpg | grep flag
Finally, flag{eat_more_oreos}

```

Hence, the flag is `flag{eat_more_oreos}`
