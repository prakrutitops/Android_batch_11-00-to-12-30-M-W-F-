<?php
    
    include('connection.php');
    
    $sql="select * from greeting_dashboard";
    
    $r=mysqli_query($con,$sql);
    $response=array();
    
    while($row=mysqli_fetch_array($r))
    {
        
        $value["c_id"]=$row["c_id"];
        $value["c_name"]=$row["c_name"];
        $value["c_image"]=$row["c_image"];

          array_push($response, $value);
    }
    echo json_encode($response);
    mysqli_close($con);

?>