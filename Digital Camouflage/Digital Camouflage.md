# Digital Camouflage

We need to gain access to some routers. Let's try and see if we can find the password in the captured network data: `https://mega.nz/#!XDBDRAQD!4jRcJvAhMkaVaZCOT3z3zkyHre2KHfmkbCN5lYpiEoY`

Hint 1: It looks like someone logged in with their password earlier. Where would log in data be located in a network capture?

Hint 2: If you think you found the flag, but it doesn't work, consider that the data may be encrypted.

Credit: picoCTF 2017

Following TCP stream, on stream 3, we can see the following:

```text
POST /pages/main.html HTTP/1.1
Referer: 10.0.0.1:8080/index.html
User-Agent: User-Agent: Mozilla/5.0 (Windows NT 10.0; WOW64; rv:44.0) Gecko/20100101 Firefox/44.0
Accept: text/html,application/xhtml+xml,application/xml;q=0.9*/*;q=0.8
Host: 10.0.0.1:8080
Connection: Keep-Alive
Content-Type: application/x-www-form-urlencoded
Content-Length: 43
Accept-Language: en-US,en;q=0.5

userid=hardawayn&pswrd=UEFwZHNqUlRhZQ%3D%3DHTTP/1.0 200 OK
Server: BaseHTTP/0.3 Python/2.7.9
Date: Sat, 19 Mar 2016 02:50:30 GMT
Content-type: text/html
```

One thing to notice is that we can see the following text on stream 1:

```text
GET /index.html HTTP/1.1
User-Agent: Wget/1.16 (linux-gnu)
Accept: */*
Host: 10.0.0.1:8080
Connection: Keep-Alive

HTTP/1.0 200 OK
Server: BaseHTTP/0.3 Python/2.7.9
Date: Sat, 19 Mar 2016 02:49:27 GMT
Content-type: text/html

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>NET-LINK Router - Log In</title>
<link href="styles.css" rel="stylesheet" type="text/css" />
</head>

<body>

<div class="container">
  <div class="header"><a href="index.html"><img src="images/netlink_logo.png" alt="Netlink Logo" width="180" height="90" style="display:block;" /></a> 
  </div>
  <div class="sidebar1">
    <ul class="nav">
      <li><a href="index.html">Log In</a></li>
      <li><a href="pages/pictures.html">Pictures</a></li>
      <li><a href="pages/about.html">About</a></li>
      <li><a href="pages/help.html">Help</a></li>
    </ul>
    <div id = "sidebarbox">
    	<p>Please log in.</p>
    </div>
</div>
  <div class="content">
    <h1>Log In </h1>
    <form name="login" class="contentstuff" method="post" action="pages/main.html" onsubmit="modifyPass()">
    <table>
    	<tr>
        	<td>Username</td>
            <td><input type="text" name="userid"/></td>
        </tr>
        <tr>
        	<td>Password</td>
            <td><input type="password" name="pswrd"/></td>
        </tr>
    </table>

    <button type="submit">Submit</button>
    <input type="reset" value="Cancel"/>
    </form>

    <script>
        function modifyPass(){
            document.login.pswrd.value = btoa(document.login.pswrd.value);
        }
    </script>
  </div>
  <div class="footer">
    <p>NET-LINK Router Administration &copy; 2016 by PPP</p>
  </div>
  </div>
</body>
</html>
```

According to

```javascript
function modifyPass(){
    document.login.pswrd.value = btoa(document.login.pswrd.value);
}
```

We know that the password is base64-encoded. Hence, in order to get the original password, we need to decode it. We can do so with NodeJs.

```javascript
> Buffer.from(decodeURIComponent("UEFwZHNqUlRhZQ%3D%3D"), "base64").toString()
'PApdsjRTae'
```

Hence, the flag is `PApdsjRTae`
