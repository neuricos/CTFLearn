# A CAPture of a Flag

This isn't what I had in mind, when I asked someone to capture a flag... can you help? You should check out WireShark.

`https://mega.nz/#!3WhAWKwR!1T9cw2srN2CeOQWeuCm0ZVXgwk-E2v-TrPsZ4HUQ_f4`

Open the file with Wireshark and filter on http messages. Then, we can find the following request:

```text
Request URI Query Parameter: msg=ZmxhZ3tBRmxhZ0luUENBUH0=
```

After decoding it, we get:

```bash
$ echo "ZmxhZ3tBRmxhZ0luUENBUH0=" | base64 -D
flag{AFlagInPCAP}
```
