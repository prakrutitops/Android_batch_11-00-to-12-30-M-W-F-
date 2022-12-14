<?php 
	
//importing dbDetails file 
include 'Your_Connect.php';	

//this is our upload folder 
$upload_path = 'YourFolderName/';

//Getting the server ip 
$server_ip = gethostbyname(gethostname());

//creating the upload url 
//$upload_url = 'http://'.$server_ip.'/animal/'.$upload_path; 

$upload_url = 'https://'.$_SERVER['SERVER_NAME'] . "/Main_Folder/Sub_Folder/" . $upload_path;
	
	
//getting name from the request 
$fname = $_POST['firstname'];
 $lname = $_POST['lastname'];
 $email = $_POST['email'];
 $pass=$_POST['password'];
 
 
//getting file info from the request 
$fileinfo = pathinfo($_FILES["img"]["name"]);

//getting the file extension 
$extension = $fileinfo["extension"];

//file url to store in the database 
$file_url = $upload_url . $name . '.' . $extension;

//file path to upload in the server 
$file_path = $upload_path . $name . '.'. $extension; 
			
//saving the file 
move_uploaded_file($_FILES["img"]["tmp_name"],$file_path);

if($fname=="" && $lname=="" && $email==""&& $pass=="" && $file_url=="")
{
       echo '0';
}
else
{
        $sql = "INSERT INTO Your_Table_Name (firstname,lastname,email,password,img) VALUES ('$fname','$lname','$email',$pass','$file_url')";
        $ex=mysqli_query($con,$sql);
}
echo $sql;
//exit;

			
//closing the connection 
mysqli_close($con);

?>
