import 'regenerator-runtime/runtime';
import axios from 'axios';

const BASE_URL='http://localhost:8080/api/v1/data';
var hello;
const getgreeting = async() => {
    try{
        const response = await axios.get(`${BASE_URL}/basicData`);
        const greetingItems=response.data;
        console.log(`GET: Here's the greeting`,greetingItems);
        hello=response.data;
        document.getElementById("greeting").innerHTML = hello;
        return greetingItems;
    }catch (errors){
        console.log(errors);
    }
};

window.onload = (event) => {
    getgreeting();
};

$(document).ready(function() {
	
	redrawDotNav();

    /* Scroll event handler */
    $(window).bind('scroll',function(e){
        rainbowScroll();
        redrawDotNav();
    });

    /* Scroll the background layers */
    function rainbowScroll(){
        var scrolled = $(window).scrollTop();
        $('#rainbow-bg1').css('top',(0-(scrolled*.25))+'px');
        $('#rainbow-bg2').css('top',(0-(scrolled*.5))+'px');
        $('#rainbow-bg3').css('top',(0-(scrolled*.75))+'px');
    };

    /* Set navigation dots to an active state as the user scrolls */
    function redrawDotNav(){
        var section1Top =  0;
        // The top of each section is offset by half the distance to the previous section.
        var section2Top =  $('#vaccin').offset().top - (($('#useful-link').offset().top - $('#vaccin').offset().top) / 2);
        var section3Top =  $('#useful-link').offset().top - (($('#self-report').offset().top - $('#useful-link').offset().top) / 2);
        var section4Top =  $('#self-report').offset().top - (($(document).height() - $('#self-report').offset().top) / 2);;
        $('nav#primary a').removeClass('active');
        if($(document).scrollTop() >= section1Top && $(document).scrollTop() < section2Top){
            $('nav#primary a.situation').addClass('active');
        } else if ($(document).scrollTop() >= section2Top && $(document).scrollTop() < section3Top){
            $('nav#primary a.vaccin').addClass('active');
        } else if ($(document).scrollTop() >= section3Top && $(document).scrollTop() < section4Top){
            $('nav#primary a.useful-link').addClass('active');
        } else if ($(document).scrollTop() >= section4Top){
            $('nav#primary a.self-report').addClass('active');
        };

        /* Show/hide dot lav labels on hover */
        $('nav#primary a').hover(
            function () {
                $(this).prev('h1').show();
            },
            function () {
                $(this).prev('h1').hide();
            }
        );	
    };

    /* Next/prev and primary nav btn click handlers */
	$('a.situation').click(function(){
    	$('html, body').animate({
    		scrollTop:0
    	}, 1000, function() {
	    	rainbowScroll(); // Callback is required for iOS
		});
    	return false;
	});
    $('a.vaccin').click(function(){
    	$('html, body').animate({
    		scrollTop:$('#vaccin').offset().top
    	}, 1000, function() {
	    	rainbowScroll(); // Callback is required for iOS
		});
    	return false;
    });
    $('a.useful-link').click(function(){
    	$('html, body').animate({
    		scrollTop:$('#useful-link').offset().top
    	}, 1000, function() {
	    	rainbowScroll(); // Callback is required for iOS
		});
    	return false;
    });
	$('a.self-report').click(function(){
    	$('html, body').animate({
    		scrollTop:$('#self-report').offset().top
    	}, 1000, function() {
	    	rainbowScroll(); // Callback is required for iOS
		});
    	return false;
    });

});



