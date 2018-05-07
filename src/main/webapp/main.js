$(document).ready(function() {

  let url = "https://travelie.herokuapp.com/city";

  function postCityName(name) {
    fetch(url, {
      method: "POST",
      body: name
    })
    window.location = "result.html";
    localStorage.setItem("cityName", name);
  }
  $(".cityName").click(function() {
    let cityName = $(this).text();
    postCityName(cityName);
  });

  $(".readMore").click(function() {
    let cityName = $(this).parent().find(".cityName").text();
    postCityName(cityName);
  });

  $('.citySearch > input').keypress(function(e) {
    if (e.which == 13) {
      let cityName = $(this).val();
      postCityName(cityName);
    }
  });

  $(".logoDiv").click(function() {
    window.location = "index.html";
  });

  $(".details button").click(function() {
    window.location = "recommend.html";
  })
});
