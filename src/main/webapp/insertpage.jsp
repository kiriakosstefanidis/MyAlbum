<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<style>
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
        background-color: #4CAF50;
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
</style>
<body>

<h3>Πρόσθεσε την φωτογραφία σου!</h3>

<div>
    <form action="insertpage.jsp" method="POST">

        <label>Θεματική ενότητα</label>
        <input type="text" name="title">

        <label>Συμμετέχοντες</label>
        <input type="text"  name="tags">

        <label>Ημερομηνία</label>
        <input type="datetime"  name="date">
        <br>
        </br>
        <label>Γεωγραφικό μίκος</label>
        <input type="float" name="longtitude">
        <br>
        </br>
        <label>Γεωγραφικό πλάτος</label>
        <input type="float" name="latitude">
        <br>
        </br>

        <label>Επιλογή Αρχείου:</label>
        <input type="file" id="myfile" name="imagepath">
        <br>
        </br>

        <input type="submit" value="Submit">

    </form>
</div>

</body>
</html>
