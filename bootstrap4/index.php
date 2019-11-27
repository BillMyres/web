 <!DOCTYPE html>

 <!-- Author: Thomas vanBommel -->
<?php 
	$exclude = array(
		".",
		"..",
		"src",
		"res",
		".git",
		"site_images",
		"index.php"
	);
 ?>
<html class="bg-dark">
	<head>
		<title>Thomas vanBommel</title>
		<meta name="viewport" content="width=device-width, initial-scale=1.0">

		<!-- Bootstrap -->
		<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
		<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
		<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
		<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
		
		<!-- Custom -->
		<link rel="stylesheet" href="src/css/style.css" />
		<script src="src/js/main.js"></script>
	</head>
	<body class="bg-lightgray pb-2">

		<!-- Tabbed Content -->
		<div class="content container-fluid px-0">

			<!-- Navigation bar -->
			<div class="navigation container-fluid px-0 bg-dark">

				<!-- Brand -->
				<h5 class="pl-2 pt-2 left text-light">Thomas vanBommel</h5>

				<!-- Tabs -->
				<ul class="nav nav-tabs right bg-dark text-light" id="tabs" role="tablist">

					<!-- Home tab -->
					<li class="nav-item">
						<a class="nav-link active" id="home-tab" data-toggle="tab" role="tab" href="#home" aria-controls="home" aria-selected="true">Home</a>
					</li>

					<!-- Bootstrap tab -->
					<li class="nav-item">
						<a class="nav-link" id="bootstrap-tab" data-toggle="tab" role="tab" href="#bootstrap" aria-controls="bootstrap" aria-selected="bootstrap">Bootstrap</a>
					</li>
				</ul>
				<div class="clearfix"></div>
			</div>
			<div class="tab-content">

				<!-- Home content -->
				<div class="tab-pane fade show active" id="home" role="tabpanel" aria-labelledby="home-tab">
					
					<!-- Carousel -->
					<div class="container-fluid m1100 py-2 bg-lightgray">
						<div id="slideshow" class="carousel slide" data-ride="carousel">

							<!-- Indicators -->
							<ul class="carousel-indicators">
								<?php
									$count = 0;

									foreach(scandir(".") as $file){
										if(!in_array($file, $exclude)){
											$active = $count == 0 ? " class='active'" : "";

											echo "<li data-target='#slideshow' data-slide-to='$count'$active></li>";
											$count++;
										}
									}
								?>
							</ul>

							<!-- Controls -->
							<a class="carousel-control-prev" href="#slideshow" data-slide="prev">
								<span class="carousel-control-prev-icon"></span>
							</a>
							<a class="carousel-control-next" href="#slideshow" data-slide="next">
								<span class="carousel-control-next-icon"></span>
							</a>

							<!-- Slides -->
							<div class="carousel-inner">

								<!-- Carousel items -->
								<?php include("src/php/carousel-items.inc"); ?>
							</div>
						</div>
					</div>

					<!-- Canvas -->
					<div class="container mt-2 text-center text-light bg-secondary">
						<h4>Comming soon...</h4>
						<img src="res/images/logo-white.png" class="py-2" style="width:100%; max-width:320px;" />
						
						<!-- <canvas id="canvas" class="w-100 h-100 bg-dark">Your browser does not support the canvas tag.</canvas> -->
					</div>
				</div>

				<!-- Bootstrap content -->
				<div class="tab-pane fade bg-lightgray py-1" id="bootstrap" role="tabpanel" aria-labelledby="bootstrap-tab">

					<!-- Info-cards -->
					<?php include("src/php/info-cards.inc"); ?>
				</div>
			</div>
		</div>
	</body>
</html>