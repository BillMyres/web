<?php
	$ignore = array(
		".",
		"..",
		"index.php"
	);
	$files = scandir("./");
	
	foreach($files as $file){
		if(!in_array($file, $ignore)){
			echo "
				<a href='$file'>$file</a><br />
			";
		}
	}
?>