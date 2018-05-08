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

      let key = `AIzaSyB2F9Rh3cFiuDuRxfTCaiS0AyS2sTO_ZFw`;
      let url = `https://cors-anywhere.herokuapp.com/https://maps.googleapis.com/maps/api/place/autocomplete/json?input=${cityName}&types=(cities)&key=${key}`

      fetch(url, {
          method: "GET",
        })
        .then(response => response.json())
        .then(function(response) {
          cityName = response.predictions[0].structured_formatting.main_text;
          localStorage.setItem("cityName", cityName);
          postCityName(cityName);
          window.location = "result.html";
        })
    }
  });

  $(".logoDiv").click(function() {
    window.location = "index.html";
  });

  $(".details button").click(function() {
    window.location = "recommend.html";
  })

  $(".navButton").click(function(){
    window.location = "login.html";
  })
});
