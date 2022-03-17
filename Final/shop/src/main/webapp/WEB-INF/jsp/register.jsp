<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Register Page</title>
    <link rel="stylesheet" href="./css/web.css">

</head>
<body>
<div class="main">
    <div class="header">
        <h1>
            <a href="./login">Login</a> <a href="./register" class="curr">Register</a>
        </h1>
    </div>
    <form action="" method="post" id="userForm">
        <table>
            <tr>
                <td class="td1">Username</td>
                <td><input type="text" class="input1" name="username" id="username" placeholder="username"></td>
            </tr>
            <tr>
                <td class="td1">Password</td>
                <td><input type="password" class="input1" name="password" id="password" placeholder="password"></td>
            </tr>
            <tr>
                <td class="td1">Repeat Password</td>
                <td><input type="password" class="input1" name="password" id="rePassword" placeholder="repeat password">
                </td>
            </tr>
            <tr>
                <td colspan="2">
                    <div class="btn-red">
                        <input type="button" value="Register" id="main-btn" onclick="doRegister()">
                    </div>
                </td>
            </tr>
        </table>
    </form>
</div>

<script src="jquery/jquery-2.1.1.min.js"></script>
<script src="layer/layer.js"></script>

<script>
    // register
    function doRegister() {
        var username = $("#username").val();
        var password = $("#password").val();
        var rePassword = $("#rePassword").val();
        var pwdReg = /^(?![0-9]+$)(?![a-zA-Z]+$)[0-9A-Za-z]{8,20}$/;

        // check username and password
        if (username == "" || password == "") {
            layer.msg("Please input username or password!", {time: 2000, icon: 0, shift: 6}, function () {
            });
            return;
        }

        // check password validity
        if (!pwdReg.test(password)) {
            layer.msg("Password must be consisted by number and letter with length between 8-20!", {
                time: 2000,
                icon: 5,
                shift: 6
            }, function () {
            });
            return;
        }

        // check if passwords match
        if (password != rePassword) {
            layer.msg("Passwords must match!", {time: 2000, icon: 5, shift: 6}, function () {
            });
            return;
        }

        // submit register and check status
        var loadingIndex = null;
        $.ajax({
            type: "POST",
            url: "doAjaxRegister",
            data: {"username": username, "password": password},
            beforeSend: function () {
                loadingIndex = layer.msg('Please wait', {icon: 16});
            },
            success: function (result) {
                layer.close(loadingIndex);
                if (result.success) {
                    layer.msg("Register Successfully!", {time: 2000, icon: 1, shift: 6}, function () {
                    });
                    // wait and jump to login page
                    Thread.Sleep(2000);
                    window.location.href = "login";
                } else {
                    layer.msg("Username had been registered! Please use another username!", {
                        time: 2000,
                        icon: 2,
                        shift: 6
                    }, function () {
                    });
                }
            }
        });
    }

</script>

</body>
</html>