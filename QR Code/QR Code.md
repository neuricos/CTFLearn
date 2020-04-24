# QR Code

Do you remember something known as QR Code? Simple. Here for you : `https://mega.nz/#!eGYlFa5Z!8mbiqg3kosk93qJCP-DBxIilHH2rf7iIVY-kpwyrx-0`

If we scan the QR code, we will get the following string:

```text
c3ludCB2ZiA6IGEwX29icWxfczBldHJnX2RlX3BicXI=
```

If we decode it, we get

```bash
$ echo "c3ludCB2ZiA6IGEwX29icWxfczBldHJnX2RlX3BicXI=" | base64 -D
synt vf : a0_obql_s0etrg_de_pbqr
```

We can make a guess here. Suppose this message is encrypted using Caesar Cipher and the first token `synt` is actually `flag`, then the shift should be 13.

Hence, if we decrypt this message, we get:

```text
flag is : n0_body_f0rget_qr_code
```

That means, `n0_body_f0rget_qr_code` is the flag.
