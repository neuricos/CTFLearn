# Up For A Little Challenge?

`https://mega.nz/#!LoABFK5K!0sEKbsU3sBUG8zWxpBfD1bQx_JY_MuYEWQvLrFIqWZ0`

You Know What To Do ...

```bash
$ strings "Begin Hack.jpg"
JFIF
Exif
8Photoshop 3.0
8BIM
8BIM
S@%c
&T6d
'E7e
()*89:HIJWXYZghijwxyz
0"2Q
3#aB
c6p&ET
()*789:FGHIJUVWXYZdefghijstuvwxyz

mQ15
TLMm
[m[mQ15
*tMD
"k4J
Rs]n
<zbpM
;ELN
*gEN
=a?6m
bj'j
:5LN
[m[m[mZ4
_|RW
zgm19
-{{?_
:UWXV
A_~{
[mRQ.
MtMm
_b|g
)bum
Q;TLMm
j&5i
\_s5sH
mQ:j6
mQ15
[mFw\j
y0X,
Yyrx
DC(jC)dwC
?HxC
Cl|G
/sPj
MJ,h`
550]
4KvwUp
QYj,
n7~$N[$
-g0L
Gmu5
i*iSJ
]ZIsk
g<W1M
LE4l^\
wdc.)
:}^Xs
1bdM;V
Lub 
%)p_
d(3D
gqm6
[y|7
Qoq-
)kAO
j.YJ
t)9m
U>iy
}p.<E1
.Xm5
Yu>6p
_f;>Yd$W
&MBo
&aF
X?$6
bjCL
k)p$
W&YL
19b$
^8/_
l',r
%pRG
H4\p
R/C,^
7l#Y
Oi?h
|^7V*
QXmG5_?
/E'C
.$%er
o%))
:?ab
y+q\
5O9e?%j?
_&j"
1,G$+
CS@?
*zHr
Z#8CLQ_$#
1exh
1yjyw(
'Trj
`- https://mega.nz/#!z8hACJbb!vQB569ptyQjNEoxIwHrUhwWu5WCj1JWmU-OFjf90Prg -N17hGnFBfJliykJxXu8 -
=u}B
{Y4B
R_:/
/bTK
T8(w
}SPF*
.YRi,
m%<p
7<S:
CdRR
5Ol=
7Ge'
!1AQaq
 0@P`p
rK2*
=611y
*E%9
M`H0X_
_W]y
!{u~
r%LL
;3;;
vj54
=}pW
5p^-
?s$X0?]
4@a4
=reg#
9*fL'
Mp real_unlock_key: Nothing Is As It SeemsU
~t>?
pb}X8a
;>)I$
A16hM
O9]F
K_Es
OQcc
{8OI
<T|pF
t<?EK*
)#0=n
'u%
b_74
^x<sN
1u{k
Nitr
b9R6
(Q{T
 F>_
bK(1
<AI<a
JxAD
AQa q
0@P`p
]!ql>
-L_Q
c<gg
c='I
_l2A5
5~Fh
89]M}+
^Jx(
)_4b
LQ")
zy=>
n66k
NuHPO
;(hO
+vU8*
+CL@
NiiJo
"Y#).3
kw]}
1|yq
UB!1/OV1
nt }
0+<$<
:Rgh
Qo"P
?a>^
)gN0e&W
Xzbg
bZ<R
N: r@
%r",r
 #=#
U@!e
H/ga
8HK/
iPi5
|XPr
yJ6P
KeMLx
bQvs
MSU}
"*OL
Y@dmf
J\yE
%PEuW
yDYUE
 password: Really? Again
3oC=
S MWX
lwPBj
XR0W'
@t-%
flag{Not_So_Simple...}
?@};
7b,,*
W*)^
#zZ&
 Oqq
uS%f
yB1+!
tt'8
1F?jn
;'"K
|q=_
=U$a
8nzo
P8t
Trqe@
(~CK9&
Jq$?
@a:O>
ea!%!
e$Ef
yQ(u$65
4"< 
s^)V

```

Although there is "flag" inside the output, we know that one is not the flag.

We also see URL `https://mega.nz/#!z8hACJbb!vQB569ptyQjNEoxIwHrUhwWu5WCj1JWmU-OFjf90Prg` inside the output. If we go there, we can donwlaod a zip file.

```bash
$ unzip "Up For A Little Challenge.zip"
$ cd "Did I Forget Again?"
$ ls -a
./              ../             .Processing.cerb4           Loo Nothing Becomes Useless ack.jpg
```

I tried to use `strings` and `binwalk` to look into both files, but I didn't find anything interesting. However, if we check the file types:

```bash
$ file .Processing.cerb4
.Processing.cerb4: Zip archive data, at least v2.0 to extract
```

We will notice that `.Processing.cerb4` is actually a zip file. Hence, we can unzip it:

```bash
$ unzip .Processing.cerb4
Archive:  .Processing.cerb4
[.Processing.cerb4] skycoder.jpg password:
```

However, here we would encounter a password prompt. Remeber that previously when we looked into image `Begin Hack.jpg`, we see a bunch of suspicious tokens:

```text
Mp real_unlock_key: Nothing Is As It SeemsU
password: Really? Again
flag{Not_So_Simple...}
```

After trying several times, we know that the password is actually `Nothing Is As It Seems`.

After we unzip the file, we will get image `skycoder.jpg`. At the bottom right of of the image, we will see the flag `flag{hack_complete}`.
