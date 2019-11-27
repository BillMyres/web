<?php
	$directory = ".";
	$files = scandir($directory);
	$count = 0;

	foreach($files as $file){
		if(!in_array($file, $exclude)){
			$dir = $directory . "/" . $file;
			$img_loc = "res/images/no-image.png";
			
			$index_img_loc = "res/images/site_images/" . $file . ".png";

			if(file_exists($index_img_loc)){
				$img_loc = $index_img_loc;
			}

			$active = $count == 0 ? " active" : "";

			echo "
				<!-- Item -->
				<div class='carousel-item" . $active . "'>
					
					<div class='w-100' style='height:200px; background:url(" . $img_loc . "); background-size:cover;'></div>
					
					<!-- Visit, Like and Dislike button group -->
					<div class='container-fluid caption py-2 text-center'>
						<div class='btn-group bg-secondary' role='group' aria-label='Visit/Like/Dislike'>
							<button type='button' class='btn btn-primary'><a href='" . $dir . "' class='no-decoration text-light'>" . $file . "</a></button>
							<button type='button' class='btn btn-secondary' onclick='like(this)'>&#x1f44d;</button>
							<button type='button' class='btn btn-secondary' style='border-left:1px solid rgba(0, 0, 0, 0.2);' onclick='dislike(this)'>&#128078;</button>
						</div>
					</div>
				</div>
			";

			$count++;
		}
	}
?>