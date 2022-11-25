<?php

include ('connection.php');

$uname=$_REQUEST["u1"];
$pass=$_REQUEST["p1"];


$sel="select * from register where  username='$uname' and password = '$pass'";

$ex=mysqli_query($con,$sel);


$no=mysqli_num_rows($ex);
//echo $no;


if($no>0)
{
$fet=mysqli_fetch_object($ex);
echo json_encode(['code'=>200]);
}
else
{
echo "0";
}


?>