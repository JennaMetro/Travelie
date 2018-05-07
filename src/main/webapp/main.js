$(document).ready(function() {

  $(".cityName").click(function() {
    let cityName = $(this).text();
    console.log(cityName);
    localStorage.setItem("cityName", cityName);
    window.location = "result.html";
  });

  $(".readMore").click(function() {
    let cityName = $(this).parent().find(".cityName").text();
      
    let  url = "/cityRumble?name="+cityName;  
    fetch(url, {
      method: "POST",
      cache: 'no-cache'
    }
    ).then(response => response.text())
	.then (response => console.log(response))
	.then(function(result){console.log(result)});
  
    //console.log(cityName);
    //window.location = "result.html";
    //localStorage.setItem("cityName", cityName);
  });

  $(".logoDiv").click(function() {
    window.location = "main.html";
  });

  $('.citySearch > input').keypress(function(e) {
      if (e.which == 13) {
        let cityName = $(this).val();
        console.log(cityName)
        localStorage.setItem("cityName", cityName);
        window.location = "result.html";
      }
  });
});
