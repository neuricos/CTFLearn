# Taking LS

Just take the Ls. Check out this zip file and I be the flag will remain hidden.
`https://mega.nz/#!mCgBjZgB!_FtmAm8s_mpsHr7KWv8GYUzhbThNn0I8cHMBi4fJQp8`

```bash
$ unzip "The Flag.zip"
$ ls
The Flag/   The Flag.zip    __MACOSX/

$ cd The\ Flag/
$ ls -a
./      ../    .DS_Store    .ThePassword/     The Flag.pdf

$ cd .ThePassword/
$ ls
ThePassword.txt

$ cat ThePassword.txt
Nice Job!  The Password is "Im The Flag".

```

Try to open "The Flag.pdf". The document requires password. Enter "I'm The Flag" and we see the flag is `ABCTF{T3Rm1n4l_is_C00l}`
