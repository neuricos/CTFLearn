# POST Practice

These website requires authentication, via POST. However, it seems as if someone has defaced our site. Maybe these is still some way to authenticate? `http://165.227.106.113/post.php`

If we look at the source code of this site, we will see as follows:

```html
<h1>This site takes POST data that you have not submitted!</h1><!-- username: admin | password: 71urlkufpsdnlkadsf -->
```

Hence, if we use cURL to POST request it:

```bash
$ curl http://165.227.106.113/post.php -X POST -d 'username=admin&password=71urlkufpsdnlkadsf'
<h1>flag{p0st_d4t4_4ll_d4y}</h1>
```

That means the flag is `flag{p0st_d4t4_4ll_d4y}`
