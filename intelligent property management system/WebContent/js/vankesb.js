/*
*this js file is written for sb team
*@author MAC CHEN
*@date: 2014-12-12 21:00
**/

$(document).ready(function(){

	var $isShown1 = false;
	var $isShown2 = false;
	var $isShown3 = false;
	var $isShown4 = false;
	// $('.home-a').on('click', function(event){
// 		event.preventDefault();
// 		$('#sub-menu-1').toggleClass('show').fadeIn('slow');		
// 	});
// 	
/*owner的js文件*/
	$('.owner-fee-a').on('click', function(event){
		event.preventDefault();
		//$('#sub-menu-2').toggleClass('show');
		if($isShown1 == false){
			$('#sub-menu-1').animate(
    		{
				opacity: '0.99',
				top: 0
			}, 200);
			
			$isShown1 = true;
		}
		else{
			$('#sub-menu-1').animate(
    		{
				opacity: 0,
				top: '-500px'
			}, 200);
			
			$isShown1 = false;
		}
	});

	$('.owner-pp-a').on('click', function(event){
		event.preventDefault();
		//$('#sub-menu-2').toggleClass('show');
		if($isShown2 == false){
			$('#sub-menu-2').animate(
    		{
				opacity: '0.99',
				top: 0
			}, 200);
			
			$isShown2 = true;
		}
		else{
			$('#sub-menu-2').animate(
    		{
				opacity: 0,
				top: '-500px'
			}, 200);
			
			$isShown2 = false;
		}
	});

	$('.owner-he-a').on('click', function(event){
		event.preventDefault();
		//$('#sub-menu-2').toggleClass('show');
		if($isShown3 == false){
			$('#sub-menu-3').animate(
    		{
				opacity: '0.99',
				top: 0
			}, 200);
			
			$isShown3 = true;
		}
		else{
			$('#sub-menu-3').animate(
    		{
				opacity: 0,
				top: '-500px'
			}, 200);
			
			$isShown3 = false;
		}
	});

	$('.owner-profile-a').on('click', function(event){
		event.preventDefault();
		//$('#sub-menu-2').toggleClass('show');
		if($isShown4 == false){
			$('#sub-menu-4').animate(
    		{
				opacity: '0.99',
				top: 0
			}, 200);
			
			$isShown4 = true;
		}
		else{
			$('#sub-menu-4').animate(
    		{
				opacity: 0,
				top: '-500px'
			}, 200);
			
			$isShown4 = false;
		}
	});
	
	/*owner的js文件*/
	///////////////////////////////////////////////////////
	
	/*guard的js文件*/
	$('.guard-user-a').on('click', function(event){
		event.preventDefault();
		//$('#sub-menu-2').toggleClass('show');
		if($isShown1 == false){
			$('#sub-menu-1').animate(
    		{
				opacity: '0.99',
				top: 0
			}, 200);
			
			$isShown1 = true;
		}
		else{
			$('#sub-menu-1').animate(
    		{
				opacity: 0,
				top: '-500px'
			}, 200);
			
			$isShown1 = false;
		}
	});

	$('.guard-pp-a').on('click', function(event){
		event.preventDefault();
		//$('#sub-menu-2').toggleClass('show');
		if($isShown2 == false){
			$('#sub-menu-2').animate(
    		{
				opacity: '0.99',
				top: 0
			}, 200);
			
			$isShown2 = true;
		}
		else{
			$('#sub-menu-2').animate(
    		{
				opacity: 0,
				top: '-500px'
			}, 200);
			
			$isShown2 = false;
		}
	});

	$('.guard-profile-a').on('click', function(event){
		event.preventDefault();
		//$('#sub-menu-2').toggleClass('show');
		if($isShown4 == false){
			$('#sub-menu-3').animate(
    		{
				opacity: '0.99',
				top: 0
			}, 200);
			
			$isShown4 = true;
		}
		else{
			$('#sub-menu-3').animate(
    		{
				opacity: 0,
				top: '-500px'
			}, 200);
			
			$isShown4 = false;
		}
	});
	/*guard的js文件*/
	
	////////////////////////////////////////////////////////
	/*manager的js文件*/
	$('.manager-usermanagement-a').on('click', function(event){
		event.preventDefault();
		//$('#sub-menu-2').toggleClass('show');
		if($isShown1 == false){
			$('#sub-menu-1').animate(
    		{
				opacity: '0.99',
				top: 0
			}, 200);
			
			$isShown1 = true;
		}
		else{
			$('#sub-menu-1').animate(
    		{
				opacity: 0,
				top: '-500px'
			}, 200);
			
			$isShown1 = false;
		}
	});

	$('.manager-fee-a').on('click', function(event){
		event.preventDefault();
		//$('#sub-menu-2').toggleClass('show');
		if($isShown2 == false){
			$('#sub-menu-2').animate(
    		{
				opacity: '0.99',
				top: 0
			}, 200);
			
			$isShown2 = true;
		}
		else{
			$('#sub-menu-2').animate(
    		{
				opacity: 0,
				top: '-500px'
			}, 200);
			
			$isShown2 = false;
		}
	});

	$('.manager-pp-a').on('click', function(event){
		event.preventDefault();
		//$('#sub-menu-2').toggleClass('show');
		if($isShown3 == false){
			$('#sub-menu-3').animate(
    		{
				opacity: '0.99',
				top: 0
			}, 200);
			
			$isShown3 = true;
		}
		else{
			$('#sub-menu-3').animate(
    		{
				opacity: 0,
				top: '-500px'
			}, 200);
			
			$isShown3 = false;
		}
	});
	$('.manager-profile-a').on('click', function(event){
		event.preventDefault();
		//$('#sub-menu-2').toggleClass('show');
		if($isShown4 == false){
			$('#sub-menu-4').animate(
    		{
				opacity: '0.99',
				top: 0
			}, 200);
			
			$isShown4 = true;
		}
		else{
			$('#sub-menu-4').animate(
    		{
				opacity: 0,
				top: '-500px'
			}, 200);
			
			$isShown4 = false;
		}
	});
	
	
	
	/*manager的js文件*/
	
	/*super的js文件*/
	$('.super-usermanagement-a').on('click', function(event){
		event.preventDefault();
		//$('#sub-menu-2').toggleClass('show');
		if($isShown1 == false){
			$('#sub-menu-1').animate(
    		{
				opacity: '0.99',
				top: 0
			}, 200);
			
			$isShown1 = true;
		}
		else{
			$('#sub-menu-1').animate(
    		{
				opacity: 0,
				top: '-500px'
			}, 200);
			
			$isShown1 = false;
		}
	});
	
	$('.super-profile-a').on('click', function(event){
		event.preventDefault();
		//$('#sub-menu-2').toggleClass('show');
		if($isShown2 == false){
			$('#sub-menu-2').animate(
    		{
				opacity: '0.99',
				top: 0
			}, 200);
			
			$isShown2 = true;
		}
		else{
			$('#sub-menu-2').animate(
    		{
				opacity: 0,
				top: '-500px'
			}, 200);
			
			$isShown2 = false;
		}
	});
	
	/*super的js文件*/
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