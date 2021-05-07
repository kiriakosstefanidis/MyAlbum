<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" language="java" %>
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



        /* Create two unequal columns that floats next to each other */
        /* Left column */
        .leftcolumn {
            float: left;
            width: 75%;
        }


        /* Album */
        .album {
            background-color: #aaa;
            width: 20%;
            padding: 20px;
        }


        .card {
            background-color: white;
            padding: 20px;
            margin-top: 20px;
        }

        /* Clear floats after the columns */
        .row:after {
            content: "";
            display: table;
            clear: both;
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
    <a href="index.jsp">ΑΡΧΙΚΗ</a>

</div>


<h2> Επιτυχής Προσθήκη! </h2>

</div>
</div>

<div class="footer">
    <p>We are three undergraduate students in International Hellenic University and this is the semester project for the programming methodology</p>
</div>

</body>
</html>
