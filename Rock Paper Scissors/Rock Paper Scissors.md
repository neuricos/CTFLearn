# Rock Paper Scissors

Do you think you're lucky enough to win 10 games of Rock Paper Scissors in a row? Connect to the server and find out. `nc 138.197.193.132 5001`

Notice that the value for each round doesn't change. Hence, we can just try out the correct answers.

```bash
$ nc 138.197.193.132 5001
----------- Let's play rock, paper, scissors!
----------- Beat me 10 times in a row to win the flag!

Please choose: R / P / S
>>>P
You won! Consecutive wins: 1
I chose R based on 2454155475
Please choose: R / P / S
>>>R
You won! Consecutive wins: 2
I chose S based on 139951793
Please choose: R / P / S
>>>P
You won! Consecutive wins: 3
I chose R based on 1842064464
Please choose: R / P / S
>>>S
You won! Consecutive wins: 4
I chose P based on 2072586604
Please choose: R / P / S
>>>P
You won! Consecutive wins: 5
I chose R based on 2482883256
Please choose: R / P / S
>>>P
You won! Consecutive wins: 6
I chose R based on 63704871
Please choose: R / P / S
>>>S
You won! Consecutive wins: 7
I chose P based on 885185152
Please choose: R / P / S
>>>P
You won! Consecutive wins: 8
I chose R based on 1986768135
Please choose: R / P / S
>>>R
You won! Consecutive wins: 9
I chose S based on 3493188185
Please choose: R / P / S
>>>P
You won! Consecutive wins: 10
I chose R based on 2110102074
Wow, you're good, here's your flag!
CTFlearn{r0ck_p4per_skiss0rs}

```
