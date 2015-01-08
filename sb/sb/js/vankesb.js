/*
*this js file is written for sb team
*@author MAC CHEN
*@date: 2014-12-12 21:00
**/

$(document).ready(function(){
	
	var $isShown = false;
	// $('.home-a').on('click', function(event){
// 		event.preventDefault();
// 		$('#sub-menu-1').toggleClass('show').fadeIn('slow');		
// 	});
// 	
	$('.home-a').on('click', function(event){
		event.preventDefault();
		//$('#sub-menu-2').toggleClass('show');
		if($isShown == false){
			$('#sub-menu-1').animate(
    		{
				opacity: '0.99',
				top: 0
			}, 200);
			
			$isShown = true;
		}
		else{
			$('#sub-menu-1').animate(
    		{
				opacity: 0,
				top: '-500px'
			}, 200);
			
			$isShown = false;
		}
	});
	$('.profile-a').on('click', function(event){
		event.preventDefault();
		//$('#sub-menu-2').toggleClass('show');
		if($isShown == false){
			$('#sub-menu-2').animate(
    		{
				opacity: '0.99',
				top: 0
			}, 200);
			
			$isShown = true;
		}
		else{
			$('#sub-menu-2').animate(
    		{
				opacity: 0,
				top: '-500px'
			}, 200);
			
			$isShown = false;
		}
	});
// 	
// 	$('ul.global-action').on('click', function(event){
// 		event.preventDefault();
// 		if($(event.target).is('home-a')){
// 			$('#sub-menu-1').removeClass('show');			
// 		}
// 		
// 	});
// 	


/* image slider*/
		$('.sb-image-slider').slick({
  slidesToShow: 1,
  slidesToScroll: 1,
  autoplay: true,
  autoplaySpeed: 2000,
  arrows: false,
  
});


});