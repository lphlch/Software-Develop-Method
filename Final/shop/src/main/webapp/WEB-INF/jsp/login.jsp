<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="com.web.utils.*" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Login Page</title>
    <link rel="stylesheet" href="./css/web.css">

</head>

<body>
<div class="main">
    <div class="header">
        <h1>
            <a href="./login" class="curr">Login</a> <a href="./register">Register</a>
        </h1>
    </div>

    <form action="" method="post">
        <table>
            <tr>
                <td class="td1">Username</td>
                <td><input type="text" class="input1" id="username" name="username" placeholder="username"></td>
            </tr>
            <tr>
                <td class="td1">Password</td>
                <td><input type="password" class="input1" id="password" name="password" placeholder="password"></td>
            </tr>
            <tr>
                <td class="td1" colspan="2">
                    <input type="checkbox" name="rememberUsername" value="true" checked="checked">Remember me
                </td>
            </tr>
            <tr>
                <td colspan="2">
                    <div class="btn-red">
                        <input type="button" value="Login" id="main-btn" onclick="doLogin()">
                    </div>
                </td>
            </tr>
        </table>
    </form>
</div>

<script src="jquery/jquery-2.1.1.min.js"></script>
<script src="layer/layer.js"></script>


<script>
    // login
    function doLogin() {
        var username = $("#username").val();
        var password = $("#password").val();

        // check username and password
        if (username == "" || password == "") {
            layer.msg("Please input username or password!", {time: 2000, icon: 0, shift: 6}, function () {
            });
            return;
        }

        var isRememberUser = document.getElementsByName("rememberUsername")[0].checked;

        // submit login form
        var loadingIndex = null;
        $.ajax({
            type: "POST",
            url: "doAjaxLogin",
            data: {"username": username, "password": password, "flag": isRememberUser},
            beforeSend: function () {
                loadingIndex = layer.msg('Please wait', {icon: 16});
            },
            success: function (result) {
                layer.close(loadingIndex);
                if (result.success) {
                    layer.msg("Welcome " + username + " !", {time: 5000, icon: 1, shift: 6}, function () {
                    })
                } else {
                    layer.msg("Wrong Username or Passwords!", {time: 2000, icon: 2, shift: 6}, function () {
                    });
                }
            }
        });

    }

</script>

</body>
</html>

