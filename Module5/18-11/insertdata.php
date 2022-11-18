<?php

    include('connection.php');
    
    $username = $_POST["username"];
    $password = $_POST["password"];
    $email = $_POST["email"];
    
    
    if($username=="" && $password=="" && $email=="")
    {
        echo '0';
    }
    else
    {
          $sql = "Insert into register (username,password,email) values('$username','$password','$email')";
          mysqli_query($con,$sql);
    }
    
    mysqli_close($con);
    
 


?>