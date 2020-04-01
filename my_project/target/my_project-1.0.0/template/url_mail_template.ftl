<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <title>Images</title>

    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>

    <link href='http://fonts.googleapis.com/css?family=Roboto' rel='stylesheet' type='text/css'>

    <!-- use the font -->
    <style>
        body {
            font-family: 'Montserrat', sans-serif;
            font-size: 48px;
        }
        .button {
            text-decoration: none;
            outline: none;
            display: inline-block;
            width: 200px;
            height: 45px;
            line-height: 45px;
            border-radius: 45px;
            font-family: 'Montserrat', sans-serif;
            font-size: 14px;
            text-transform: capitalize;
            text-align: center;
            letter-spacing: 1px;
            font-weight: 600;
            color: #ffffff;
            background: #00b4ef;
            transition: .3s;
        }
        .center {
            text-align: center;
        }
    </style>
</head>
<body style="margin: 0; padding: 0;">

<table align="center" border="0" cellpadding="0" cellspacing="0" width="600" style="border-collapse: collapse;">
    <tr>
        <td align="center" bgcolor="#00b4ef" style="padding: 10px 0 5px 0;">
            <p style="font-size: 30px"><b>Your image uploaded seccessfully!</b></p>
        </td>
    </tr>
    <tr>
        <td bgcolor="#f7f7f7" style="padding: 40px 30px 40px 30px;">
            <p>Dear user</p>
            <p>Here is <a href="http://localhost:8080/files/${url}">link</a> to your image</p>
        </td>
    </tr>
</table>

</body>
</html>