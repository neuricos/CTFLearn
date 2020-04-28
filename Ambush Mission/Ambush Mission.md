# Ambush Mission

Hi, i can't tell you my name since now i'm in a mission. In case to arrest our fugitive target, our team had been intercepted communication between the target with his fellow and found this image (`https://mega.nz/#!TKZ3DabY!BEUHD7VJvq_b-M22eD4VfHv_PPBnW2m7CZUfMbveZYw`). It looks like they are going to meet in specific place, but we still don't know the time yet. Can you help me?

The image is as follows:

![clue](./clue.png)

After trying `string`, `binwalk`, `zsteg`, `exiftool`, I finally reached the right tool for this, which is `stegsolve`.

Open the image with `stegsolve` and switch to `Red Pane 0`. We will be able to see the following text:

```text
==QTh9lMx8Fd08VZt9FdFNTb
```

It is obviously a reversed base64 encoded string. Decode it and we would get:

```bash
$ echo "==QTh9lMx8Fd08VZt9FdFNTb" | perl -ne 'chomp; print scalar reverse;' | base64 -D
m3Et_me_4t_12_aM
```
