<?php

    include('connection.php');
    
    $id = $_POST["id"];
  
    
    $sql_query="delete from register where id ='$id'";
    
    if(mysqli_query($con,$sql_query))
    {
        echo 'Deleted  Successfully';
    }
    else
    {
        echo 'Something went wrong';
    }
    
    mysqli_close($con);

?>