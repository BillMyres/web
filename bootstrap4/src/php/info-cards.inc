<?php
	$info = array(
		array(
			/* Title, Grid, Link */
			"Basic Grid",
			"Simplified grid system, based of the webpage being split into twelve equal sections",
			"https://www.w3schools.com/bootstrap4/bootstrap_grid_basic.asp"
		), array(
			"Text",
			"Classes used for text formatting. Makes all text look a little nicer",
			"https://www.w3schools.com/bootstrap4/bootstrap_typography.asp"
		), array(
			"Colors",
			"Useful, meaningful text colors to help represent things like errors, warnings, danger, etc...",
			"https://www.w3schools.com/bootstrap4/bootstrap_colors.asp"
		), array(
			"Tables",
			"A straight forward way to create table, allowing for “active rows”, “striped rows”, and many more features",
			"https://www.w3schools.com/bootstrap4/bootstrap_tables.asp"
		), array(
			"Cards",
			"Bordered div with many formatting options",
			"https://www.w3schools.com/bootstrap4/bootstrap_cards.asp"
		), array(
			"Nav Bar",
			"Another container with many features used in a navigation bar, like logos, title, links, menu, etc...",
			"https://www.w3schools.com/bootstrap4/bootstrap_navbar.asp"
		), array(
			"Flex",
			"Div container that doesn’t require the use of float or positioning",
			"https://www.w3schools.com/bootstrap4/bootstrap_flex.asp"
		), array(
			"Templates",
			"A free web template, you are allowed to use in any project",
			"https://www.w3schools.com/bootstrap4/bootstrap_templates.asp"
		), array(
			"Jumbotron",
			"Container that can extend the entire viewport",
			"https://www.w3schools.com/bootstrap4/bootstrap_jumbotron.asp"
		), array(
			"Alert",
			"Easy way to make good looking alert / notifications, with the ability to close the div element",
			"https://www.w3schools.com/bootstrap4/bootstrap_alerts.asp"
		), array(
			"Pagination",
			"MUCH easier way to do pagination, looks good to",
			"https://www.w3schools.com/bootstrap4/bootstrap_pagination.asp"
		), array(
			"Progress bar",
			"Nice looking progress bar to add to your design . ability to have different colors and even percentage complete",
			"https://www.w3schools.com/bootstrap4/bootstrap_progressbars.asp"
		)
	);

	for($i = 0; $i < 12; $i++){
		$title = 		$info[$i][0];
		$description = 	$info[$i][1];
		$link = 		$info[$i][2];

		echo "

		<!-- Cards -->
		<div class='card container my-2'>
			<h5 class='card-header'>$title</h5>
			<div class='card-body'>
				<p class='card-text'>$description</p>
				<a href='$link' class='btn btn-primary'>w3c</a>
			</div>
		</div>";
	}
?>