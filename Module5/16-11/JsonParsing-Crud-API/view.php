<?php

    include('connect.php');
    
    $sql ="select * from mobile_products";
    
    $r= mysqli_query($con,$sql);
    $response= array();
    
    while($row=mysqli_fetch_array($r))
    {
            $value["id"] = $row["id"];
            $value["m_name"] = $row["m_name"];
            $value["m_price"] = $row["m_price"];
            $value["m_image"] = $row["m_image"];
        
        
            array_push($response, $value);
    }
    
    echo json_encode($response);
    mysqli_close($con);
    
    

?>