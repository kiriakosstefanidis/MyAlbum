<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <style>
        * {
            box-sizing: border-box;
        }

        body {
            font-family: Arial;
            padding: 20px;
            background: #f1f1f1;
        }


        .header {
            padding: 30px;
            text-align: center;
            background: white;
        }

        .header h1 {
            font-size: 50px;
        }


        .menubar {
            overflow: hidden;
            background-color: #333;
        }


        .menubar a {
            float: left;
            display: block;
            color: #f2f2f2;
            text-align: center;
            padding: 14px 16px;
            text-decoration: none;
        }
        input[type=text], select {
            width: 100%;
            padding: 12px 20px;
            margin: 8px 0;
            display: inline-block;
            border: 1px solid #ccc;
            border-radius: 4px;
            box-sizing: border-box;
        }

        input[type=submit] {
            width: 100%;
            background-color: #333;
            color: white;
            padding: 14px 20px;
            margin: 8px 0;
            border: none;
            border-radius: 4px;
            cursor: pointer;
        }

        input[type=submit]:hover {
            background-color: #333;
        }
        div {
            border-radius: 5px;
            background-color: #f2f2f2;
            padding: 20px;
        }

        /* Footer */
        .footer {
            padding: 20px;
            text-align: center;
            background: #ddd;
            margin-top: 20px;
        }

        /* Responsive layout - when the screen is less than 800px wide, make the two columns stack on top of each other instead of next to each other */
        @media screen and (max-width: 800px) {
            .leftcolumn, .rightcolumn {
                width: 100%;
                padding: 0;
            }
        }

        /* Responsive layout - when the screen is less than 400px wide, make the navigation links stack on top of each other instead of next to each other */
        @media screen and (max-width: 400px) {
            .menubar  a {
                float: none;
                width: 100%;
            }

        }

    </style>
</head>
<body>

<div class="header">
    <h1>My Photo Album 2021</h1>
    <p>The ultimate web site for your photos.</p>
</div>

<div class="menubar">
    <a href="#"></a>
    <a href="#"></a>

</div>

<div class="form">
    <form action="/NewAlbum" method="post">

        <label>Album ID</label>
        <input type="text" name="AlbumID" placeholder="AlbumID">



        <label>Album Name</label>
        <input type="text" name="AlbumTitle" placeholder="Album Title">

        <button type = "submit" > Create album </button>


    </form>

</div>

    <div class="footer">
        <p>We are three undergraduate students in International Hellenic University and this is the semester project for the programming methodology</p>
    </div>

</body>
</html>

