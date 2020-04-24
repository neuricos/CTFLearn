# Lazy Game Challenge

I found an interesting game made by some guy named "John_123". It is some betting game. I made some small fixes to the game; see if you can still pwn this and steal $1000000 from me!

To get flag, pwn the server at: `nc thekidofarcrania.com 10001`

```text
Welcome to the Game of Luck !.

Rules of the Game :
(1) You will be Given 500$
(2) Place a Bet
(3) Guess the number what computer thinks of !
(4) computer's number changes every new time !.
(5) You have to guess a number between 1-10
(6) You have only 10 tries !.
(7) If you guess a number > 10, it still counts as a Try !
(8) Put your mind, Win the game !..
(9) If you guess within the number of tries, you win money !
(10) Good Luck !..

theKidOfArcrania:
  I bet you cannot get past $1000000!


Are you ready? Y/N :

Y
```

Then, we would see:

```text
Money you have : 500$
Place a Bet : -1000000000000000000000000000000000
```

We make our bet negative, so it doesn't matter if we can guess the correct number. We will lose our bet and get that amount of money!

At the end, we will see:

```text
Sorry you didn't made it !
Play Again !...
Better Luck next Time !.
1Sorry you lost some money !..
Your balance has been updated !.
Current balance :  :
10000000000000000500$
What the... how did you get that money (even when I tried to stop you)!? I guess you beat me!

The flag is CTFlearn{d9029a08c55b936cbc9a30_i_wish_real_betting_games_were_like_this!}

Thank you for playing !
Made by John_123
Small mods by theKidOfArcrania
Give it a (+1) if you like !..
```

Hence, the flag is `CTFlearn{d9029a08c55b936cbc9a30_i_wish_real_betting_games_were_like_this!}`
