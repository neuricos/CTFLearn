# PIN

Can you crack my pin?

`https://mega.nz/#!PXYjCKCY!F2gcs83XD6RxjOR-FNWGQZpyvUFvDbuT-PTnqRhBPGQ`

Use Ghidra to dissemble file `rev1` and we can find the following `main` function.

```c
undefined8 main(void)

{
  int iVar1;
  uint local_c;
  
  printf("Masukan PIN = ");
  __isoc99_scanf(&DAT_004006d3,&local_c);
  iVar1 = cek((ulong)local_c);
  if (iVar1 == 0) {
    puts("PIN salah ! \n");
  }
  else {
    puts("PIN benar ! \n");
  }
  return 0;
}
```

That means, we just need to make sure `cek` returns true. In order to do that, the passed-in parameter, or in this case, the pin, should be `valid`.

```c
ulong cek(int param_1)

{
  return (ulong)(param_1 == valid);
}
```

If we check out what's the value of `valid`, we know that it is `00051615`, stored in hex form.

```text
                            valid                           XREF[2]:     Entry Point(*), cek:004005bd(R)  
        00601040 15 16 05 00     undefined4 00051615h

```

Convert `valid` from hex to decimal, we know that pin is `333333`
