<?php
    
    include('connection.php');
    
    $sql="select * from greeting_diwali";
    
    $r=mysqli_query($con,$sql);
    $response=array();
    
    while($row=mysqli_fetch_array($r))
    {
        
        $value["id"]=$row["id"];
      
       $value["image"]=$row["image"];

          array_push($response, $value);
    }
    echo json_encode($response);
    mysqli_close($con);

?>