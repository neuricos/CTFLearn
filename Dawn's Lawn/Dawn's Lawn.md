# Dawn's Lawn

Dawn has a magical lawnmower that she uses to mow her square lawn. As soon as she trims the grass, it starts growing quickly. Once the grass grows tall enough, it turns into a flower. Dawn has a lawn that has flowers, grass, and dirt. More details can be found here: `https://mega.nz/#!bTwAgS5K!_7Ct7i5rPzsTwxB-QXuM0C751gYppdItpfGl3Cr-RaY` - You can find Dawn's actual lawn (your input) here: `https://mega.nz/#!OGxQDQgA!pQdDXyto9sqdoprz53541HTyPMr9aLFBKP29Rutqom8` How many flowers are in Dawn's lawn after she mows it completely?

*Example*:

```text
/-*  >>  /-*  >>  /-*  >>  |-*  >>  |-*  >>  |_*  >> *_/  >>  *_/  >>  *\/
_|.  >>  .|.  >>  .|.  >>  .|.  >>  .-.  >>  .-.  >> .-.  >>  ./.  >>  ./.
/\/  >>  /\/  >>  \\/  >>  \./  >>  \./  >>  -./  >> -./  >>  -./  >>  /.\
```

The lawn we are trying to solve is as follows:

```text
\|*/|_|.-_\\|.|_.-//
/-\_.--.|-_._\.-|/*-
\\-|..-*-/__*--/.\*-
_/\|.*.---___***_/\.
_-|.\\././_/|.-|_\//
_-*.\..**/|/**.\_./-
|-*|*.-_-////.|**-|-
*\|*_-|_\-|__\_.*.-|
.*///*.*/*\_-\..*-**
*/_\-\.//--/||\\/_|_
*.**/--/**///./\\/-|
/|.\-..*-./\..-|\.||
|\/\__|./*_-\|-/_*_\
.|///*-/\-/|*/*||*-*
.\.|\/.*/--*.|\--\/\
/_/|_|_---\_\_.***.-
|-.._.-*\|*_\/_|_\/*
.\.|\|//_-|.*-*|\*|*
_\/-|-_*\-\|-/-/-*.-
-_..\_\_*\\-*__..*/-
```

We can write the following script to find the number of flowers:

```python
#!/usr/bin/env python3

f = open("dawn2.txt", "r")

levels = ('.', '_', '\\', '-', '/', '|', '*')
lawn = [list(l.strip()) for l in f.readlines()]

lawn_len = len(lawn)
growth_speed = lawn_len
growing_tiles = []

loc = (0, 0)
# 1 -> going downward
# -1 -> going upward
direction = 1

end_loc = (0 if lawn_len % 2 == 0 else lawn_len - 1, lawn_len)

while loc != end_loc:
    # trim
    row, col = loc
    state = lawn[row][col]
    idx = levels.index(state)
    idx -= 2
    idx = max(idx, 0)
    lawn[row][col] = levels[idx]
    # update location
    if idx != 0:
        growing_tiles.append([loc, growth_speed])

    if row + direction < 0 or row + direction >= lawn_len:
        loc = (row, col + 1)
        direction *= -1
    else:
        loc = (row + direction, col)
    # grow
    for gt in growing_tiles:
        gt[1] -= 1
        if gt[1] == 0:
            r, c = gt[0]
            s = lawn[r][c]
            i = levels.index(s)
            i += 1
            i = min(i, len(levels) - 1)
            lawn[r][c] = levels[i]
            gt[1] = growth_speed

flowers = sum([sum([1 if c == levels[-1] else 0 for c in row]) for row in lawn])
print(f"Total number of flowers = {flowers}")

f.close()
```

```bash
$ python3 exploit.py
Total number of flowers = 194
```

Hence, the flag is `194`
