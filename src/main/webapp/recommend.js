$(document).ready(function() {

  let url = "https://travelie.herokuapp.com/city";


  fetch(url, {
      method: "GET",
    }).then(response => response.json())
    .then(function(response) {
      for (value of response.results) {
        let name = value.name;
        let url2 = `https://cors-anywhere.herokuapp.com/https://maps.googleapis.com/maps/api/place/textsearch/json?query=things+to+do+in${name}&key=AIzaSyA51GtAToTOjiu4pEYW8miXs6lwexTMZvk`;

        fetch(url, {
            method: "GET",
          })
          .then(response => response.json())
          .then(function(response) {
            let element = response.results[0];
            if (element.photos === undefined) {
              photo_ref = `CnRtAAAATLZNl354RwP_9UKbQ_5Psy40texXePv4oAlgP4qNEkdIrkyse7rPXYGd9D_Uj1rVsQdWT4oRz4QrYAJNpFX7rzqqMlZw2h2E2y5IKMUZ7ouD_SlcHxYq1yL4KbKUv3qtWgTK0A6QbGh87GB3sscrHRIQiG2RrmU_jF4tENr9wGS_YxoUSSDrYjWmrNfeEHSGSc3FyhNLlBU`;
            } else photo_ref = element.photos[0].photo_reference;
            let imgRequestUrl = `https://cors-anywhere.herokuapp.com/https://maps.googleapis.com/maps/api/place/photo?maxwidth=200&photoreference=${photo_ref}&key=AIzaSyA51GtAToTOjiu4pEYW8miXs6lwexTMZvk`;
            fetch(imgRequestUrl, {
                method: "GET",
              })
              .then(response => response.blob())
              .then(function(response) {
                let urlCreator = window.URL || window.webkitURL;
                let imageUrl = urlCreator.createObjectURL(response);
                $(`#recommendSection >  .resultList`).append(
                  `<div class="result">
                      <div class="resultImg">
                        <img src="${imageUrl}" alt="">
                      </div>
                      <div class="resultDetails">
                        <div class="name">${name}</div>
                        </div>
                      </div>
                    </div>
                    `
                )
              })
          })
      }
    })
});
