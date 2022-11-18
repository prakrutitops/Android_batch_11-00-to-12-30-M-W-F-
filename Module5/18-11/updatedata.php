<?php

    include('connection.php');
    
    $id = $_POST["id"];
    $username = $_POST["username"];
    $password = $_POST["password"];
    $email = $_POST["email"];
    
    $sql_query="update register set username='$username' , password='$password' ,email ='$email' where id ='$id'";
    
    if(mysqli_query($con,$sql_query))
    {
        echo 'Updated Successfully';
    }
    else
    {
        echo 'Something went wrong';
    }
    
    mysqli_close($con);

?>