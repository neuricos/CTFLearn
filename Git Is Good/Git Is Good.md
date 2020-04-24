# Git Is Good

The flag used to be there. But then I redacted it. Good Luck.
`https://mega.nz/#!3CwDFZpJ!Jjr55hfJQJ5-jspnyrnVtqBkMHGJrd6Nn_QqM7iXEuc`

```bash
$ unzip gitIsGood.zip
...
$ ls
gitIsGood/      gitIsGood.zip

$ cd gitIsGood
$ ls
flag.txt

$ cat flag.txt
flag{REDACTED}

$ git log
commit d10f77c4e766705ab36c7f31dc47b0c5056666bb (HEAD -> master)
Author: LaScalaLuke <lascala.luke@gmail.com>
Date:   Sun Oct 30 14:33:18 2016 -0400

    Edited files

commit 195dd65b9f5130d5f8a435c5995159d4d760741b
Author: LaScalaLuke <lascala.luke@gmail.com>
Date:   Sun Oct 30 14:32:44 2016 -0400

    Edited files

commit 6e824db5ef3b0fa2eb2350f63a9f0fdd9cc7b0bf
Author: LaScalaLuke <lascala.luke@gmail.com>
Date:   Sun Oct 30 14:32:11 2016 -0400

    edited files

$ git checkout 195dd65b9f5130d5f8a435c5995159d4d760741b
Note: checking out '195dd65b9f5130d5f8a435c5995159d4d760741b'.

You are in 'detached HEAD' state. You can look around, make experimental
changes and commit them, and you can discard any commits you make in this
state without impacting any branches by performing another checkout.

If you want to create a new branch to retain commits you create, you may
do so (now or later) by using -b with the checkout command again. Example:

  git checkout -b <new-branch-name>

HEAD is now at 195dd65 Edited files

$ cat flag.txt
flag{protect_your_git}
```
